// a multisliderV with a spec

MSV : MultiSliderView{

	var <spec;
	*new{ arg lay, b, spec=[0, 10];
		^super.new(lay, b).elasticMode_(true)
		.spec_(spec)
		.action_{ arg self;
			self.changed(\value, self.value.postln)
		};
	}
	spec_{
		arg a; spec=a.asSpec.step_(1);
		spec.addDependant(this)
	}
	value_{ arg val;
		this.superPerform(\value_, val=spec.unmap(val) );
		this.changed(\value, val)
	}
	value{ 
		^spec.map(this.superPerform(\value))
	}
	update{ arg qui, que ... quoi;
		var clipF={arg lo, hi; this.value_(this.value.clip(lo, hi))};
		switch(qui,
			spec, {
				switch(que,
					\minval, clipF.(spec.minval, spec.maxval),
					\maxval, clipF.(spec.minval, spec.maxval)
				)
			}
		)
	}

}

