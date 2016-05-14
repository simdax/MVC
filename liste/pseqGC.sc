PseqGC : ObjectGui{

	var spec, view;
	
	guiBody{ arg lay, b;
		spec=[-10,10].asSpec.step_(1);
		view=MultiSliderView(lay).elasticMode_(true)
		.value_(spec.unmap(model.list))
		.action_
		{ arg self;
			model.changed(this, self.value)
		}
	}
	update{ arg mod, msg, val;
		mod.list=spec.map(val);
		if(msg!=this, {
			view.value=spec.unmap(val)
		});
	}
}

/*

Pseq([0,2,1,3]).gui

*/
