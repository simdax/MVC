ControlSpecGui : ObjectGui{
	writeName{}
	guiBody{ arg p, b;
		EZRanger(p, b, nil, [model.minval, model.maxval].asSpec,
			{arg self;
				model.minval_(self.lo); 	model.maxval_(self.hi)
			},
			[model.minval+5, model.maxval-5]
		)
		
	}

}

/*
a=[0, 30].asSpec;
a.gui
a
*/