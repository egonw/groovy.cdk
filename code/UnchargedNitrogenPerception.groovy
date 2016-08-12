import org.openscience.cdk.interfaces.*;
import org.openscience.cdk.interfaces.IBond.Order;
import org.openscience.cdk.*;
import org.openscience.cdk.atomtype.*;
import org.openscience.cdk.config.*;
import org.openscience.cdk.tools.manipulator.*;
import javax.vecmath.Point3d;

molecule = new AtomContainer();
atom = new Atom(Elements.NITROGEN);
molecule.addAtom(atom);
hydrogen = new Atom(Elements.HYDROGEN);
molecule.addAtom(hydrogen);
molecule.addBond(0,1,Order.SINGLE);
hydrogen = new Atom(Elements.HYDROGEN);
molecule.addAtom(hydrogen);
molecule.addBond(0,2,Order.SINGLE);
hydrogen = new Atom(Elements.HYDROGEN);
molecule.addAtom(hydrogen);
molecule.addBond(0,3,Order.SINGLE);
hydrogen = new Atom(Elements.HYDROGEN);
molecule.addAtom(hydrogen);
molecule.addBond(0,4,Order.SINGLE);
matcher = CDKAtomTypeMatcher.getInstance(
  DefaultChemObjectBuilder.getInstance()
);
type = matcher.findMatchingAtomType(molecule, atom);
println "Atom type: $type.atomTypeName"
assert type.atomTypeName == "X"
