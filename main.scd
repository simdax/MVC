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
w=Window("test", Rect(0, 0, 400, 400)).front;
Pbind(
	\degree, a=Pseq([0,1,2,4,1,2], inf),
	\dur, b=Pseq([1,1,2,1], inf)
).play;
[a, b].do(_.gui(w));
)

