+ Pattern{
	// override object gui
	// to benefit specific options (lay)
	// and easier invocation
	gui{ arg p, lay;
		^this.superPerform(\gui, p, nil,  lay)
	}

}