PtparGui : PatternGui {

	var offset=0;
	var pbindGuis;
	var <esp;
	var z, y; // moveV et line
	
	gui{
		var v=View(nil, 400@400).front,  b=400@400;
		this.guiBody(v, b)
	}
	guiBody{ arg w, b;
		z=MoveView.new(w,b)
		.onClose_{try{esp.stop}}; 
		y=MovingLine(w, b);
		/*
		movingLine does not accept focus
		so we have to transmit him kboard actions
		*/
		z.keyDownAction_{arg ... args;
			y.keyDownAction.value(*args); 
		};
		pbindGuis=model.list.clump(2).collect({|x, i|
			x[1].gui(z,
				Rect(
					y.wpp(x[0]), 10+(50*i),
					y.wpp(x[1].getDur.sum),50
				)
			)
		});
		this.vControllers;
	}

	vControllers{ 
		
		SimpleController(z)
		.put(\clickVide,
			{ arg ... args;	//args;
				y.mouseDownAction.value(*[y]++args.drop(2)); }
		)
		.put(\taille, {arg self, msg, obj;
			var pbind=pbindGuis.detect({|x| x.view==obj}).model;
			var index=model.list.detectIndex(_==pbind);
			model.list[index-1]=y.dpw(obj.bounds.left);
			this.togglePlay;
		})
		;
		// movingLine
		SimpleController(y)
		.put(\go, {arg ... args;
			offset=y.dpw(args[2]);
			("offset = "++offset).postln;
			"++ les decalages :".postln;
			this.pdef.play
		})
		.put(\stop, { esp.postln.stop})
		;
	}
	//// SOUND
	pdef{
		^esp=PFF(offset,model)
	}
	togglePlay{
		if(esp.isPlaying){esp.stop};
		this.pdef; esp.play
	}

}