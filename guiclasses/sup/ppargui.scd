
(
Window.closeAll;
s.boot;

~ppar=Ptpar([
	0, Pbind(\degree, Pseq([0,5,1,4,2,1,2])),
	//	0, Pbind.base
]);

//// INIT  => WINDOWS
~offset=0;
//w=Window("io",  400@400)
w=View(nil, 400@400)
.front;
z=MoveView.new(w, w.bounds.extent); z.addFlowLayout;
y=MovingLine(w, w.bounds.extent);
// movingLine does not accept focus so we have to transmit him kboard actions
z.keyDownAction_{arg ... args;
	y.keyDownAction.value(*args); 
};

/// GUI OBJECT
// ~msv=(new:{	arg s; s.msvInit},
// 	msvInit:{arg s; var msv=MultiSliderView(parent:z,
// 		bound:((s.widthF.value)@50).asRect
// 	).value_(Array.rand(s.duree,0,10));
// 	msv.beginDragAction_{nil};
// 		s.msv=msv;
// }, duree:3, widthF:{arg s; y.wpp(s.duree)},
// 	pbind:{arg s;
// 		//		var notes=[0,10].asSpec.map(s.msv.value).round;
// 		var notes=s.msv.value;
// 		[
// 			y.dpw(s.decalage),
// 			Pbind(
// 				*[\degree,notes.pseq,
// 				\dur, (s.duree/notes.size)]
// 			)
// 		]},
// 		decalage:{arg s; s.msv.bounds.left}
// );
// ~reservoirMSV=2.collect{
// 	var a=~msv.copy; a.new; a
// };

~reservoirMSV=~ppar.list.clump(2).collect({|x|
	x[1].gui(z,(y.wpp(x[1].getDur.sum)@50).asRect)
});



 //////// CONTROLLERS //////
// mainFEN
SimpleController(z).put(\clickVide,
	{ arg ... args;	//args;
		y.mouseDownAction.value(*[y]++args.drop(2)); }
);
//z.children.do { |x, i|
	SimpleController(z).put(\taille, {arg self, msg, obj;
		var pbind=~reservoirMSV.detect({|x| x.view==obj}).model;
		var index=~ppar.list.detectIndex(_==pbind);
		~ppar.list[index-1]=y.dpw(obj.bounds.left);

		if(Pdef(\bob).isPlaying)
		{Pdef(\bob).stop; ~pdef.value.play};
	})
;
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
	PFF(~offset,~ppar)
).quant_(0)
};

z.children.do(_.changed(\taille));



)

