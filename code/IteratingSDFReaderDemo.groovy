import org.openscience.cdk.interfaces.*;
import org.openscience.cdk.io.*;
import org.openscience.cdk.io.iterator.*;
import org.openscience.cdk.*;
import org.openscience.cdk.tools.manipulator.*;

iterator = new IteratingSDFReader(
  new File("data/test6.sdf").newReader(),
  DefaultChemObjectBuilder.getInstance()
)
while (iterator.hasNext()) {
  IAtomContainer mol = iterator.next()
  formula = MolecularFormulaManipulator
    .getMolecularFormula(mol)
  println MolecularFormulaManipulator
    .getString(formula)
}
