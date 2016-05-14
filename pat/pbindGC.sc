//PbindGC : ObjectGui {

// + Pbind  {
// 	guiBody{ arg layout;
// 		var dict=this.patternpairs.asDict;
// 		dict.select({|x|  x.isKindOf(Pattern) })
// 		.do(_.gui(layout));
// 		EnvirGui(dict.select({|x| x.isNumber }), parent: layout)
// 	}
// 	// update{
		
// 	// }
// }

/*

Pbind(\degree, 5, \dur, Pseq([0,2])).gui

*/