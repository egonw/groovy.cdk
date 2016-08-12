import org.openscience.cdk.smiles.SmilesParser;
import org.openscience.cdk.interfaces.*;
import org.openscience.cdk.*;
import org.openscience.cdk.tools.*;
import org.openscience.cdk.tools.manipulator.*;
import org.openscience.cdk.templates.*;
import org.openscience.cdk.aromaticity.*;
mol = MoleculeFactory.makeBenzene()
AtomContainerManipulator.
  percieveAtomTypesAndConfigureAtoms(mol);
aromatic = CDKHueckelAromaticityDetector.
  detectAromaticity(mol);
println "benzene is " +
  (aromatic ? "" : "not ") + "aromatic."
