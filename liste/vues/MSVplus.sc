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

MSVPlus : View{

	var msv;
	*new{ arg p, b;
		^super.new(p, b).init
	}
	doesNotUnderstand{ arg op ... args;
		^msv.perform(op, *args)
	}
	init{
		this.layout_(
			VLayout(
				msv=MSV(),
				HLayout(
				*[
					["+", \add, msv.spec.range/2, Color.green],
					["-", \drop, (-1), Color.red]
				].collect({|x|
					Button().states_([
						[x[0], Color.black,  x[3]]
					])
					.action_{
						msv.value_(
							msv.value.perform(x[1], x[2])
						)
					}
				})
				)
			)
		)
	}
}
