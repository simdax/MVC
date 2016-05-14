
PbindEnvirGui : ObjectGui{

	writeName{}
	guiBody{ arg layout, bounds;
		// we need space for
		// degree, amp, dur (dur+leg+lag), ////TODO appo?
		"degree amp dur".split($ ).do({|x| 
			FenPatternPairs(layout, 100@100,  label:x).minSize_(50@50)
			.autreVue_(Button)
		})
		// if(model.degree.notNil){
			
		// }
	}
	update{ arg what, msg, a;
		[what, msg, a].postln;
		
	}
}



