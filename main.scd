(

a=Pbind(\bob, b=Pseq([0,1,2,5,10], inf));
a.trace.play;
b.gui()
)

(
Pbind(\degree, Pseq([5])).gui
)

Pchain().gui

b.gui(nil, 300@300)

ColoredView(nil,150@150 ).layout_(VLayout(
	StringGui(0),//	Vholder().view_(StringGui, 0),
	PopUpMenu()
)).front

