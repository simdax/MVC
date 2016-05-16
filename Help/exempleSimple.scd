// =====================================================================
// SuperCollider Workspace
// =====================================================================

(
~bob=(val:5, crierCommeUnGoret:{arg self; self.changed(\crier)});
~listener=SimpleController(~bob).put(\crier, {"oh la la ! ".postln});
~listener2=SimpleController(~bob).put(\crier, {arg obj, msg;
	"Ça pue ! ".postln;
	obj.val="tiens dans ta face ! "
});
)

~bob.crierCommeUnGoret
~bob.val