MSV : MultiSliderView{

	var <spec;
	spec_{
		arg a; spec=a.asSpec.step_(1)
	}
	value_{ arg val;
		this.superPerform(\value_, spec.unmap(val) )
	}
	*new{ arg lay, b, spec=[0, 10];
		^super.new(lay, b).elasticMode_(true)
		.spec_(spec)
	}

}

MSVPlus : View{

	var msv;
	*new{ arg p, b;
		^super.new(p, b).init
	}
	init{
		this.layout_(
			VLayout(
				msv=MSV(),
				[
					["+", \add, msv.range/2],
					["-", \drop, (-1)]
				].collect({|x|
					Button().states_([x[0]])
					.action_{
						msv.value_(
							msv.value.perform(x[1], x[2])
						)
					}
				})
			)
		)
	}
}
