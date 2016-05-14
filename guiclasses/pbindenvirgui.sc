
PbindEnvirGui : PatternGui{

	guiBody{ arg layout, bounds;
		var vues;
		var val=model.patternpairs.asDict;
		layout.layout_(			
			VLayout(
				*vues=3.collect({|x| ColoredView().minSize_(200@200) })
			)
		);
		"degree amp dur".split($ ).do({|x, i| 
			val.at(x.asSymbol).gui(vues[i])
		})
			
		
	}
	update{ arg what, msg, a;
		[what, msg, a].postln;
		
	}
}



