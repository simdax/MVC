
+ Pbind{
	getDurMel { arg dur=20;
		var res=this.nextNsec(dur).collect({|x|
			if(x.isNil){()}
			{
				x.degree.isNil.if {(x.degree=0)};
				x.dur.isNil.if {(x.dur=1)};
				x
			}
		}).flopDict;
		^(degree:res[\degree])++(dur:res[\dur])
	}
	getMel{
		^this.getDurMel.degree
	}
	getDur{
		^this.getDurMel.dur
	}
}
+ Pchain{
	getMel { arg dur=20;
		var res=this.nextNsec(dur).collect({|x|
			x.degree.isNil.if {(x.degree=0)};
			x.dur.isNil.if {(x.dur=1)};
			x
		}).flopDict;
		^(degree:res[\degree])++(dur:res[\dur])
	}
}

/*

Pbind(\degree, Pseq([0,5,1,4,2,1,2])  ).getMel
Pbind(  ).getMel

Pbind(
	\degree, Pwhite(0, 10),
	\dur, Pwhite(0.31, 1.5)
).getMel

(Pbind.base <> Pbind(\joe, 6)).getMel

*/


