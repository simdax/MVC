MSVPlus : MultiSliderView{

	var <spec;
	spec_{arg a; spec=a.asSpec.step_(1)}
	value_{ arg val; this.superPerform(\value_, spec.unmap(val) )}
	*new{ arg lay, b, spec;
		^super.new(lay, b).elasticMode_(true)
		.spec_(spec)
	}

}
