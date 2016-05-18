
PatternGui : ObjectGui{

	gui { arg parent=ColoredView(nil, 300@300).front,
		bounds=parent.bounds, lay=HLayout ;
		this.guiBody(parent,bounds, lay);
	}

	guiBody{ arg v, b, layout;
		var list=model.guiList.asArray;
		var innerV; var holder;
		if(list.isEmpty)
		{
			var str=" sourry, no GUI available :( ";
			StaticText(v, str.bounds+20).string_(str)
		}
		{
			innerV=View(v, b);
			innerV.layout_(
				layout.new(
					PopUpMenu()
					.items_(list.collect(_.asSymbol))
					.action_{arg self;
						holder.view_(
							//that's ugly, I know... but popupmenu transforms className items in symbols
							list.detect({|x| x.name==self.item}),
							model
						)
					},
					holder=Vholder()
					.fixedSize_
						(
							innerV.bounds.extent.postln
							- (0@(PopUpMenu().sizeHint.height+20))
						)					
					.view_(
						list[0], model
					)
				).spacing_(5).margins_(0)
			);
		}
	}
}
