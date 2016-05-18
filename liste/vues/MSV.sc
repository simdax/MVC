// a multisliderV with a spec

MSV : MultiSliderView{

	var <spec;
	spec_{
		arg a; spec=a.asSpec.step_(1)
	}
	value_{ arg val;
		this.superPerform(\value_, spec.unmap(val) )
	}
	value{ 
		^spec.map(this.superPerform(\value))
	}
	*new{ arg lay, b, spec=[0, 10];
		^super.new(lay, b).elasticMode_(true)
		.spec_(spec)
	}

}

