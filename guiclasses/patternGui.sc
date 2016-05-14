PatternGui : ObjectGui{
	// much more standard gui
	gui { arg parent, bounds ... args;
		var layout=parent ? ColoredView();
		bounds ?? {bounds=layout.bounds};
		this.guiBody(layout,bounds);
		if(parent.isNil,{
			layout.front;
		});
	}
	guiBody{ arg v, b;
		var list=model.guiList.asArray;
		if(list.isEmpty)
		{
			var str=" sourry, no GUI available :( ";
			StaticText(v, str.bounds+20).string_(str)
		}
		{
			var holder;
			v.layout_(
				VLayout(
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
							- (0@(PopUpMenu().sizeHint.height+20))).postln
						)
					.view_(
						list[0], model
					)
				).spacing_(5).margins_(0)
			);
		}
	}
}
