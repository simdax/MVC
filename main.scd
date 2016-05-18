(
a=Pseq([5]);
a.gui(lay:VLayout)
)

(
w=Window('test').front;
a=Pbind(\bob, b=Pseq([0,1,2,5,10], inf));
a.trace.play;
/// todo : marche pas
b.gui(w, Rect( 20, 20, 40, 40));
a.gui(w, Rect( 20, 20, 40, 40));
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