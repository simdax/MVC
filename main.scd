(
a=Pseq([5], inf);
b=a.gui(nil, 350@350);
Pbind(\degree, a, \dur, 0.5).trace.play
)

(
a=Pseq([5]);
b=a.gui(nil, 400@400, lay: VLayout);
Pbind(\degree, Pn(a), \dur, 0.3).trace.play
)
(
a=Pseq([5]);
a.gui(nil, Rect(20,20,100,100), VLayout)
)

// in way for pbindEnvir
(
w=Window('test', 400@800).front; 
a=Pbind(
	\degree, b=Pseq([0,1,2,5,10], inf),
	\dur, c=Pseq([1,2], inf)
);
a.trace.play;
b.gui(w, Rect(0,0,400,200), lay:VLayout);
c.gui(w, Rect(0,200,400,200), lay:VLayout)
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