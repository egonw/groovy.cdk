import org.openscience.cdk.interfaces.*;
import org.openscience.cdk.*;
import org.openscience.cdk.atomtype.*;
import org.openscience.cdk.config.*;
import org.openscience.cdk.tools.*;
import org.openscience.cdk.tools.manipulator.*;
import javax.vecmath.Point3d;

molecule = new Molecule();
newAtom = new Atom(Elements.CARBON);
molecule.addAtom(newAtom);
matcher = CDKAtomTypeMatcher.getInstance(
  DefaultChemObjectBuilder.getInstance()
);
type = matcher.findMatchingAtomType(molecule, newAtom);
AtomTypeManipulator.configure(newAtom, type);

adder = CDKHydrogenAdder.getInstance(
  DefaultChemObjectBuilder.getInstance()
);
adder.addImplicitHydrogens(molecule);
println "Atom count: $molecule.atomCount"
println " .. adding explicit hydrogens .."
AtomContainerManipulator.convertImplicitToExplicitHydrogens(
  molecule
);
println "Atom count: $molecule.atomCount"
