(
a=FlowView();
20.do{PopUpMenu(a)};
a.flow{arg a;
	20.do{Button(a)};
	MultiSliderView(a).value_([0,5,1,2]).maxSize_(150@150)
}
)
