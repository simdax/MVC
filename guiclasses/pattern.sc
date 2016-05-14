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
			PopUpMenu(v, 100@50).items_(list.collect(_.asSymbol))
			.action_{arg self;
				holder.view_(
					//that's ugly, I know...
					*list.select({|x| x.name==self.item})
				)
			};
			holder=Vholder(v, 200@200).view_(
				list[0], model
			)
		}
	}
	update{ arg qui, que, quoi;
		[qui, que, quoi].postln;
		// if(que != this){
			
		// }
	}

}
