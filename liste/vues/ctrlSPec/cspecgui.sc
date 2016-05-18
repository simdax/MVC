// pour regler des ambitus

ControlSpecGui : ObjectGui{
	writeName{}
	guiBody{ arg p, b, val=model.range/8;
		EZRanger(p, b, nil, [model.minval, model.maxval].asSpec.step_(1),
			{arg self;
				model.minval_(self.lo);
				model.maxval_(self.hi)
			},
			[model.minval+val, model.maxval-val]
		)		
	}

}

/*
a=[0, 30].asSpec;
a.gui
a
*/