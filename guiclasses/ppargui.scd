(
a=
(new{arg s, p, b;
View(p, b).mouseEnterAction_{ arg self, x, y, mod, but;
			self.children.do { |x|
				x.acceptsMouse_(false)
				.addAction({ arg s, xx, yy, m, b;
					if(m!=0){self.mouseDownAction.value(s, xx, yy, m, b)};
				}, \mouseDownAction)
			};
		}
		.mouseDownAction_({ arg self, x, y, mod, but, nbCl;
			var v=self.children.detect{|vue| vue.bounds.contains(x@y)};
			v.postln;
			if(v.notNil)
			{
				v.focus; v.bounds.postln;
				mod.isCtrl.if {self.moveAction(self, x, y, v)};
				mod.isShift.if {self.resizeAction(self, x, y, v)}
				{
					f.switch(
						nil, {v.acceptsMouse_(true); f=v},
						v, {},
						{f.acceptsMouse_(false); f=v.acceptsMouse_(true)}
					);
				}
			};
		})
.mouseUpAction_{ arg self;	self.mouseMoveAction_{} })

(
Window.closeAll;

// a=Ppar([nil]);
// b=Pbind();

w=Window("io", Rect(0, 0, 400, 400)).alwaysOnTop_(true).front;
z=MoveView.new(w, 150@150);
y=MovingLine(w);
z.keyDownAction_{arg ... args; 'io'.postln;
	y.keyDownAction.value(*args)};
 Button(z);

)


z.keyDownAction.value(0,$ ,32, 32, 32)


PFF(offset,
	Ptpar(
		pos, pat, ...
	)
)

		if(pat.isPlaying)
		{pat.stop}
		{pat=
		PFF(timeline.x,
			Ptpar(
				(timeline.durees+++timeline.patterns).collect({|x|
					x.postln;
					[x[0], Pfindur(x[1], x[2]).midi]
				}).flat
			)
		).play}

)