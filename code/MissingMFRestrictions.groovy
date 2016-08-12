import org.openscience.cdk.interfaces.*;
import org.openscience.cdk.*;
import org.openscience.cdk.formula.*;
import org.openscience.cdk.formula.rules.*;
import org.openscience.cdk.nonotify.*;
import org.openscience.cdk.tools.manipulator.*;
import org.openscience.cdk.config.IsotopeFactory;

ifac = ifac = IsotopeFactory.getInstance(
  NoNotificationChemObjectBuilder.getInstance()
)
tool = new MassToFormulaTool(
  NoNotificationChemObjectBuilder.getInstance()
)
rules = new ArrayList<IRule>();
restriction  = new ElementRule();
MolecularFormulaRange range = new MolecularFormulaRange();
range.addIsotope( ifac.getMajorIsotope("C"), 8, 20);
range.addIsotope( ifac.getMajorIsotope("H"), 0, 20);
range.addIsotope( ifac.getMajorIsotope("O"), 0, 1);
range.addIsotope( ifac.getMajorIsotope("N"), 0, 1);
params = new Object[1];
params[0] = range;
restriction.setParameters(params);
rules.add(restriction);
tool.setRestrictions(rules);
mfSet = tool.generate(133.0968);
for (mf in mfSet) {
  println MolecularFormulaManipulator.getString(mf)
}
