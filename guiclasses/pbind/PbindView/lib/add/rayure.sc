Rayure : StaticText {

	var <>object;

	*new { arg p, b;
        ^super.new(p, b).init
	}
	init{
		this
		.background_(Color.rand)
		.align_(\center)
	}

	mouseDownEvent { arg x, y, modifiers, buttonNumber, clickCount;
		if(buttonNumber==1) {^false};
		if( 
			this.beginDrag( x, y ).postln
		) { ^true };

		modifiers = QKeyModifiers.toCocoa(modifiers);
		^this.mouseDown( x, y, modifiers, buttonNumber, clickCount );
	}

	defaultGetDrag{
		^this.object ? "ton objet est Nil !"
	}


}

