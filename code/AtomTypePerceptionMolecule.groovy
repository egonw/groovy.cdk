import org.openscience.cdk.interfaces.*;
import org.openscience.cdk.*;
import org.openscience.cdk.atomtype.*;
import org.openscience.cdk.config.*;
import org.openscience.cdk.tools.manipulator.*;
import javax.vecmath.Point3d;

molecule = new Molecule();
atom = new Atom(Elements.CARBON);
molecule.addAtom(atom);
matcher = CDKAtomTypeMatcher.getInstance(
  DefaultChemObjectBuilder.getInstance()
);
type = matcher.findMatchingAtomType(molecule);
