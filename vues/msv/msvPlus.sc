/*
a=MSVPlus(nil, 200@200).front
*/

MSVPlus : View{

	var msv, indicateur;
	*new{ arg p, b;
		^super.new(p, b)
		.minWidth_(360) // ctrlSpec EZRanger un peu gourmand ?
		.minHeight_(150)	
		.init
	}
	doesNotUnderstand{ arg op ... args;
		^msv.perform(op, *args)
	}
	init{
		var specView=View()
		.minWidth_(this.bounds.width)
		.minHeight_(20)
		;
		msv=MSV(); msv.addDependant(this);
		msv.spec.gui(specView);

		this.layout_(
			VLayout(
				View().layout_(
					VLayout(
						specView,
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
					}
				})
				)
			).margins_(0)
		)
	}
	update{ arg qui, que ... quoi;
		//		qui.hash.postln; msv.hash.postln;
		// switch(qui,
		// 	msv, {
		switch(que,
			\value, {
				indicateur
				.string_(quoi[0].asString)
			}
		)
				//})
	}
}
