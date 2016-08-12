import org.openscience.cdk.smiles.SmilesGenerator;
import org.openscience.cdk.interfaces.*;
import org.openscience.cdk.*;
import org.openscience.cdk.templates.*;
import org.openscience.cdk.tools.*;
import org.openscience.cdk.tools.manipulator.*;
import org.openscience.cdk.aromaticity.*;

mol = MoleculeFactory.makePhenylAmine()
AtomContainerManipulator.percieveAtomTypesAndConfigureAtoms(mol);
CDKHueckelAromaticityDetector.detectAromaticity(mol);
hAdder = CDKHydrogenAdder.getInstance(mol.getBuilder())
hAdder.addImplicitHydrogens(mol)

generator = SmilesGenerator.unique()
smiles = generator.createSMILES(mol)
println "$smiles"
