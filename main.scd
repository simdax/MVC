(
a=Pseq([5]);
a.gui(lay: VLayout)
)
(
a=Pseq([5]);
a.gui(nil, Rect(20,20,50,50))
)

// in way for pbindEnvir
(
w=Window('test', 400@400).front; 
a=Pbind(
	\degree, b=Pseq([0,1,2,5,10], inf),
	\degree, c=Pseq([0,1,2,5,10], inf)
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