(
w=Window("test", Rect(0, 0, 400, 400)).front;
Pbind(
	\degree, a=Pseq([0,1,2,4,1,2], inf),
	\bob, b=Pseq([1,1,2,1], inf),
	\dur, Pkey(\bob)/16
).play;
[a, b].do(_.gui(w));


)