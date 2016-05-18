+ FilterPattern{
	repeats{
		"attention, c'est pas un list pattern !".warn;
		^pattern.repeats
	}
}
+ SimpleNumber{ repeats{^inf}}

+ Pbind{
	// getRep{
	// 	^this.addMissing.patternpairs.asDict.values
	// 	.collect({|x| x.repeats })
	// }
	// getDur{
	// 	^((this.dur) * (this.getRep)).maxItem
	// }
	lazyGetDur{ arg rep=100;
		^this.addMissing.asStream.nextN(rep, ())
		.reject(_.isNil)
		.flopDict.dur
		.asArray.sum
	}
}


/*


Pbind(\bob, 45).asStream.nextN(10, ())
Pbind.base.lazyGetDur
Pbind(\dur, 5).lazyGetDur
Pbind(\dur, Pseq([5])).lazyGetDur

*/