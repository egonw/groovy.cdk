import org.openscience.cdk.silent.*;
import org.openscience.cdk.tools.manipulator.*;

molFormula = MolecularFormulaManipulator
  .getMolecularFormula(
    "C2H6O",
    SilentChemObjectBuilder.getInstance()
  )
println "Monoisotopic mass: " +
  MolecularFormulaManipulator.getMajorIsotopeMass(
    molFormula
  )
