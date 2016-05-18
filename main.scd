(
a=Pseq([5], inf);
b=a.gui();
Pbind(\degree, a, \dur, 0.5).trace.play
)

(
w=Window("test", Rect(0, 0, 400, 400)).front;
a=Pseq([5]);
2.do{a.gui(w)};
)
(
w=Window("test", Rect(0, 0, 400, 400)).front;
a=Pseq([5]);

)

// in way for pbindEnvir
(
w=Window('test', 400@800).front; 
a=Pbind(
	\degree, b=Pseq([0,1,2,5,10], inf),
	\dur, c=Pseq([1,2], inf)
);
a.trace.play;
 w.view.layout_(HLayout());
 [b, c].do(w.view.layout.insert(_.gui))
)

)
(

Pbind(
	\degree, a=Pseq([0,1,2,4,1,2].normalizeSum, inf),
	\dur, b=Pseq([1,1,2,1].normalizeSum, inf)
).play;
[a, b].do(_.gui);
)


(
a=Pbind.base;
a.gui;
)

(

c=Pbind(
	\degree, a=Pseq([0,1,2,4,1,2].normalizeSum, inf),
	\dur, b=Pseq([1,1,2,1].normalizeSum, inf)
);
c.play;
c.gui(nil, 150@150)

)