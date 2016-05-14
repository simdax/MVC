
PbindEnvirGui : ObjectGui{

	writeName{}
	guiBody{ arg layout, bounds;
			
		ColoredView(layout, bounds).layout_(			
			VLayout());
				"degree amp dur".split($ ).do({|x| 
					model.at(x.asSymbol).gui(layout, bounds)
				})
			
		
	}
	update{ arg what, msg, a;
		[what, msg, a].postln;
		
	}
}



