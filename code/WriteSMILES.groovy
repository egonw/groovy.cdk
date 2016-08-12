import org.openscience.cdk.smiles.SmilesGenerator;
import org.openscience.cdk.interfaces.*;
import org.openscience.cdk.*;
import org.openscience.cdk.templates.*;
import org.openscience.cdk.tools.*;
import org.openscience.cdk.tools.manipulator.*;
import org.openscience.cdk.aromaticity.*;
generator = new SmilesGenerator()
mol = MoleculeFactory.makePhenylAmine()
AtomContainerManipulator.percieveAtomTypesAndConfigureAtoms(mol);
CDKHueckelAromaticityDetector.detectAromaticity(mol);
smiles = generator.createSMILES(mol)
println "Ph-NH2 -> $smiles"
generator.setUseAromaticityFlag(true);
smiles = generator.createSMILES(mol)
println "Ph-NH2 -> $smiles"
