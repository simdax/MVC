
(
Window.closeAll;
s.boot;

//// INIT  => WINDOWS
~offset=0;
w=Window("io", Rect(0, 0, 400, 400))
//.alwaysOnTop_(true)
.acceptsMouseOver_(true)
.front;
z=~a.new(w, w.view.bounds.extent); z.addFlowLayout;
y=MovingLine(w, w.view.bounds.extent);
// movingLine does not accept
z.keyDownAction_{arg ... args; 
	y.keyDownAction.value(*args);
};

/// GUI OBJECT
~msv=(new:{	arg s; s.msvInit},
	msvInit:{arg s; var msv=MultiSliderView(parent:z, bounds:
		((s.widthF.value)@50).asRect
	).value_(Array.rand(s.duree,0,10));
	msv.beginDragAction_{nil};
		s.msv=msv;
}, duree:3, widthF:{arg s; y.wpp(s.duree)},
	pbind:{arg s;
		//		var notes=[0,10].asSpec.map(s.msv.value).round;
		var notes=s.msv.value;
		[
			y.dpw(s.decalage),
			Pbind(
				*[\degree,notes.pseq,
				\dur, (s.duree/notes.size)]
			)
		]},
		decalage:{arg s; s.msv.bounds.left}
);
~reservoirMSV=2.collect{
	var a=~msv.copy; a.new; a
};


//////// CONTROLLERS //////
// mainFEN
SimpleController(z).put(\clickVide,
	{ arg ... args;	//args;
		y.mouseDownAction.value(*[y]++args.drop(2)); }
);
SimpleController(z).put(\taille, {arg obj, msg, taille;
	z.children.do { |x, i|
		if(Pdef(\bob).isPlaying)
		{Pdef(\bob).stop; ~pdef.value.play};
	}}  
);
// movingLine
SimpleController(y).put(\go, {arg ... args;
	~offset=y.dpw(args[2]);
	("offset = "++~offset);
	"++ les decalages :";
	~pdef.value.play
})
.put(\stop, { Pdef(\bob).stop})
;

//// SOUND
~pdef={	Pdef(\bob,
		PFF(~offset,
			Ptpar(
				z.children.size.collect({|x, i|
					~reservoirMSV[x].pbind
				}).flatten
			)//.trace
		)
	).quant_(0)};

z.children.do(_.changed(\taille))

)
