+ Pattern{
	// override object gui
	// to benefit specific options (lay)
	// and easier invocation
	gui{ arg p, b, lay;
		^this.superPerform(\gui, p, b, lay)
	}

}