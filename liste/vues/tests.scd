(

a=MSVPlus().front.value_(Array.rand(3, 0, 10).postln);

)


(
a=MSV();
a.value;
a.value_(a.value.clip(4,7));
a.spec.gui


)

[0,1,2,4,12,6,3].clip(0,5)
.collect({|x| x.clip(0, 5) })