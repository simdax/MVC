PbindGuiMVC : PatternGui{

	var view;
	guiBody{ arg p, b;
		view=PbindView(p, b)
		.mel_(model.getMel)
		.pairs_(model.patternpairs)
		.addAction({
			PbindEnvirGui(model)
		}, \mouseDownAction)
		// .onMove_{arg self, x, y;
		// 	self.changed(\pos, x@y)
		// }//, \mouseUpAction)
	}
	update{ arg qui, que ... quoi;
		// switch(que,
		// 	{}
		// )
	}
}

//Pbind().gui

