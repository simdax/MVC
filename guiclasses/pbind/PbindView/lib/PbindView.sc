/*

a=PbindView().front;
a.mel=[0,5,12,7,4];
a.pairs=["salut", \patrick, "ça va", \lesEnfants];



w=FlowView(nil, 500@500);
a=PbindView(w, 200@200).pairs_([\io, 5]).front;
PopUpMenu(w, 50@50).items_(["io"]).focusColor_(Color.blue);
ColoredView(w, 50@50).focusColor_(Color.blue).focus;
b=SkipJack({a.hasFocus.postln}, 0.5, name:"io");
w.onClose_{SkipJack.stopAll}

*/

PbindView : View {

	var <mel;
	var pairs;
	
	var stream, action,
	s, // streamVal
	x // tmpView
	;
	*new{ arg p, b=(try{p.bounds.extent.postln}{(150@150)}), nbL=3, mel=[1,0,1,2];
		^super.new(p, b).init(nbL, mel)//.canFocus_(true)
	}
	init{ arg n, m;
		mel=m;
		stream=Pseq([0,1], inf).asStream;
		this.mouseDownAction_{ arg self, xx, yy, mod,  but;
			if(but==1)
			{
				s=stream.next;
				this.action
			}
		};
		this.action
	}
	// hasFocus{
	// 	^try{x.hasFocus}{false}
	// }
	//interface
	mel_{ arg v;
		mel=v; this.action;
	}
	pairs_{ arg v;
		pairs=v; this.action;
	}
	//private
	makeRayures { 
		var a=View(this, this.bounds.extent.asRect.postln)
		.focus.background_(Color.black)	;
		a.layout_(
			VLayout(
				*pairs.clump(2).collect{ arg x;
					Rayure()
					.object_(x[1])
					.string_(x[0]);
				}
			)
			.margins_(0)
			.spacing_(0)
		);
		^a
	}
	makePlot{ 
		var res=Plotter(parent: this, bounds:this.bounds.extent.asRect.postln).value_(mel);
		res.interactionView
		.focusColor_(Color.blue)
		.addAction(
			{arg self,x, y, mod, but, nbCl;
				if(but==1){this.mouseDownAction.value(but:1)}},
			\mouseDownAction
		);
		^res.interactionView
	}
	action{
		s ?? {s=stream.next};
		x=		this.perform(
			[\makePlot, \makeRayures][s]
		);
		this.focus
	}
}

