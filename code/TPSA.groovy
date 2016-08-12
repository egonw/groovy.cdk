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
benzene = MoleculeFactory.makeBenzene();
// add explicit hydrogens ...
AtomContainerManipulator.percieveAtomTypesAndConfigureAtoms(oxazone)
adder.addImplicitHydrogens(oxazone)
AtomContainerManipulator.convertImplicitToExplicitHydrogens(oxazone)
AtomContainerManipulator.percieveAtomTypesAndConfigureAtoms(benzene)
adder.addImplicitHydrogens(benzene)
AtomContainerManipulator.convertImplicitToExplicitHydrogens(benzene)
descriptor = new TPSADescriptor()
println "TPSA of oxazone: " +
  ((DoubleResult)descriptor.calculate(oxazone).getValue())
  .doubleValue()
println "TPSA of benzene: " +
  ((DoubleResult) descriptor.calculate(benzene).getValue())
  .doubleValue()
