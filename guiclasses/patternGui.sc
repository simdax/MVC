PatternGui : ObjectGui{

	var <>layout;
	// much more standard gui func
	gui { arg parent=ColoredView(nil, 150@150).front,
		bounds=parent.bounds, lay=HLayout ;
		layout=lay;
		this.guiBody(parent,bounds);
	}
	guiBody{ arg v, optionLayout=layout;
		var list=model.guiList.asArray;
		if(list.isEmpty)
		{
			var str=" sourry, no GUI available :( ";
			StaticText(v, str.bounds+20).string_(str)
		}
		{
			var holder;
			v.layout_(
				layout.new(
					PopUpMenu()
					.items_(list.collect(_.asSymbol))
					.action_{arg self;
						holder.view_(
							//that's ugly, I know...
							*list.select({|x| x.name==self.item})
						)
					},
					holder=Vholder()
					.fixedSize_
						(
							(if(v.bounds.extent==(0@0))
							{150@150}
							{v.bounds.extent}
							- (0@(PopUpMenu().sizeHint.height+20)))
						)
					.view_(
						list[0], model
					)
				).spacing_(5).margins_(0)
			);
		}
	}
}
