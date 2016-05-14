+ Pattern {
	guiList{^[]}
	guiBody{ arg v, b;
		v.decorator.nextLine;
		if(this.guiList.isEmpty)
		{
			var str=" sourry, no GUI available :( ";
			StaticText(v, str.bounds+20).string_(str)
		}
		{
			var holder;
			PopUpMenu(v, 100@50).items_(this.guiList.collect(_.asSymbol))
			.action_{arg self; holder.view_(
				//that's ugly, I know...
				*this.guiList.select({|x| x.name==self.item})
				)
			}
			;
			holder=Vholder(v, 100@100).view_(this.guiList[0])
		}
	}
	showGui{ arg res;
		res.parent ?? {res.front};
	}
}
+ Prand{
	guiList{
		^[Button, MultiSliderView]
	}
}


+ Pbind {

	guiClass{^PbindEnvirGui}
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
	gui{ arg p, bounds;
		var res=PbindGUI(p, bounds).value_(this);
		this.addMissing; 
		this.showGui(res);
		^res
	}
}

/*

a=Pbind(\bob, Pseq([9], inf) ); a.patternpairs.postln;
a.gui
Pbind(\bob, 9).gui

*/

