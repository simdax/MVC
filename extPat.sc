
+ Pbind {

	guiClass{^PbindGuiMVC}
	*base{
		^Pbind(\degree, 0, \dur, 1, \amp, 0.4)
	}
	doesNotUnderstand{ arg msg;
		^this.patternpairs.asDict[msg.asSymbol]
	}
	analyse{
		^patternpairs.asDict.values.collect(_.class)
		/*
			Pbind(\bob, Pseq([5])).analyse

		*/
	}
	addMissing{
		if(this.degree.isNil){this.add(\degree, 0)};
		if(this.dur.isNil){this.add(\dur, 1)};
		if(this.amp.isNil){this.add(\amp, 0.4)};		
	}
	// gui{ arg p, bounds;
	// 	var res=PbindGUI(p, bounds).value_(this);
	// 	this.addMissing; 
	// 	//		this.showGui(res);
	// 	^res
	// }
}

/*

a=Pbind(\bob, Pseq([9], inf) ); a.patternpairs.postln;
a.gui
Pbind(\bob, 9).gui

*/

