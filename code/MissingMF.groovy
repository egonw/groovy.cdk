import org.openscience.cdk.interfaces.*;
import org.openscience.cdk.*;
import org.openscience.cdk.formula.*;
import org.openscience.cdk.nonotify.*;
import org.openscience.cdk.tools.manipulator.*;

tool = new MassToFormulaTool(
  NoNotificationChemObjectBuilder.getInstance()
)
mfSet = tool.generate(133.0968);
for (mf in mfSet) {
  println MolecularFormulaManipulator.getString(mf)
}
