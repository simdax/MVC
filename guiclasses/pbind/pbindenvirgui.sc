
PbindEnvirGui : PatternGui{

	guiBody{ arg layout;

		var val=model.patternpairs.asDict;
		val.do { |x|
			x.gui(layout)
		};
		// "degree amp dur".split($ ).do({|x, i| 
		// 	val.at(x.asSymbol).gui(vues[i])
		// })
			
		
	}
	update{ arg what, msg, a;
		[what, msg, a].postln;
		
	}
}



