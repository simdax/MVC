(



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