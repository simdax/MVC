ListPatternGui : PatternGui{
	var view;
	var <>action;
	guiWidget{/* should override*/}
	guiBody{ arg v;
		view=this.guiWidget.new(v)
		.minHeight_(300)
		.value_(model.list)
		.addDependant(this)
	}
	update{ arg qui, que ... quoi;
		if(qui==view){
			switch(que,
				\value, {model.list_(qui.value)}
			)
		}
	}
}

MSVGui : ListPatternGui{
	guiWidget{^MSVPlus}	
}


