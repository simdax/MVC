ListPatternGui : PatternGui{
	var view;
	var gate=true;
	var <>action;
	guiWidget{/* should override*/}
	guiBody{ arg v, b;
		view=this.guiWidget.new(v, b).value_(model.list)
		.action_{ arg self;
			action !? {action.value(self)}
			?? {
				model.list_(self.value);
				gate=false;
				model.changed(\list, self.value)}
			.value;
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

MSVGui : ListPatternGui{
	guiWidget{^MSVPlus}	
}