MSVPlus : View{

	var msv, indicateur;
	*new{ arg p, b;
		^super.new(p, b).init
	}
	doesNotUnderstand{ arg op ... args;
		^msv.perform(op, *args)
	}
	init{
		msv=MSV()
		.addAction({
			arg self; indicateur.string_(self.value)
		})
		;
		this.layout_(
			VLayout(
				View().layout_(
					VLayout(
						VLayout(
							RangeSlider().lo_(msv.spec.minval).hi_(msv.spec.maxval).orientation_(\horizontal),
							StaticText().string_([msv.spec.minval, msv.spec.maxval])
						).margins_(0).spacing_(0),
						indicateur=StaticText()
						.background_(Color.rand)
					).margins_(0).spacing_(0),
				).fixedHeight_(60)
				, msv,
				HLayout(
					*[
					["+", \add, msv.spec.range/2, Color.green],
					["-", \drop, (-1), Color.red]
				].collect({|x|
					Button().states_([
						[x[0], Color.black,  x[3]]
					])
					.action_{
						msv.value_(	msv.value.perform(x[1], x[2]));
						msv.doAction
					}
				})
				)
			).margins_(0)
		)
	}
}
