import org.openscience.cdk.*;
import org.openscience.cdk.templates.*;
import org.openscience.cdk.tools.*;
import org.openscience.cdk.tools.manipulator.*;
import org.openscience.cdk.qsar.descriptors.molecular.*;
import org.openscience.cdk.qsar.result.*;

adder = CDKHydrogenAdder.getInstance(
  DefaultChemObjectBuilder.getInstance()
);
oxazone = MoleculeFactory.makeOxazole();
// add explicit hydrogens ...
AtomContainerManipulator.percieveAtomTypesAndConfigureAtoms(oxazone)
adder.addImplicitHydrogens(oxazone)
AtomContainerManipulator.convertImplicitToExplicitHydrogens(oxazone)
descriptor = new MomentOfInertiaDescriptor()
result = descriptor.calculate(oxazone)
exception = result.exception
println "Exception:\n" + exception
