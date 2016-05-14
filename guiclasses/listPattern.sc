ListPatternGui : PatternGui{
	var view;
	var gate=true;
	guiBody{ arg v, b;
		b.postln;
		view=MultiSliderView(v, b).value_(model.list)
		.action_{
			arg self;
			model.list_(self.value);
			gate=false;
			model.changed(\list, self.value);
		}
	}
	update{ arg qui, que ... quoi;
		if((qui==model) and: gate)
		{
			if(que==\list, {
			view.value_(quoi[0])
			})
		};
		gate=true;
	}
}