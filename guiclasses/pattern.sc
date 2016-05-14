PatternGui : ObjectGui{	
	guiBody{ arg v, b;
		var list=model.guiList.asArray;
		v.decorator.nextLine;
		if(list.isEmpty)
		{
			var str=" sourry, no GUI available :( ";
			StaticText(v, str.bounds+20).string_(str)
		}
		{
			var holder;
			ColoredView(v, b).layout_(
				VLayout(
					PopUpMenu()
					.items_(list.collect(_.asSymbol))
					.action_{arg self;
						holder.view_(
							//that's ugly, I know...
							*list.select({|x| x.name==self.item})
						)
					},
					Vholder()
					.minSize_(100@100)
					.view_(
						list[0], model
					)
				)
			);
		}
	}
	update{ arg qui, que, quoi;
		[qui, que, quoi].postln;
		// if(que != this){
			
		// }
	}

}
