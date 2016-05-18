
PatternGui : ObjectGui{
	var <parent;
	gui {
		arg parent=
		Window().front, bounds, 
		lay=VLayout
		;
		if(parent.layout.isNil){parent.layout_(HLayout())};
		//parent.bounds_(bounds.asRect);		
		this.guiBody(parent,lay);
	}

	guiBody{ arg v, layout;
		var list=model.guiList.asArray;
		var innerV; var holder;
		//		parent=v;
		if(list.isEmpty)
		{
			var str=" sourry, no GUI available :( ";
			StaticText(v, str.bounds+20).string_(str)
		}
		{
			// innerV=View(v, v.bounds.extent);
			// innerV
			v.layout.insert(
				View().layout_(
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
							v.bounds.extent.postln
							- (0@(PopUpMenu().sizeHint.height+20))
						)					
					.view_(
						list[0], model
					)
					).spacing_(5).margins_(0)
				)
			);
		}
	}
}
