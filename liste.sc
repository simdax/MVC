+ Pattern {
	*guiClass{^ListPat}
	guiClass{^PatternGui}
	guiList{^[]}
}
//Pattern.gui.front
+ ListPattern{
	guiList{^ListPatternGui.subclasses}
}

+ Ptpar{
	guiClass{^PtparGui}
}
+ Pbind {

	guiClass{^PbindGuiMVC}
	*base{
		^Pbind(\degree, 0, \dur, 1, \amp, 0.4)
	}
	doesNotUnderstand{ arg msg;
		^this.patternpairs.asDict[msg.asSymbol]
	}
	addMissing{
		if(this.degree.isNil){this.add(\degree, 0)};
		if(this.dur.isNil){this.add(\dur, 1)};
		if(this.amp.isNil){this.add(\amp, 0.4)};		
	}
}
