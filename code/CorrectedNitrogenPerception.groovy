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
hydrogen = new Atom(Elements.NITROGEN);
molecule.addAtom(hydrogen);
molecule.addBond(0,1,Order.SINGLE);
hydrogen = new Atom(Elements.NITROGEN);
molecule.addAtom(hydrogen);
molecule.addBond(0,2,Order.SINGLE);
hydrogen = new Atom(Elements.NITROGEN);
molecule.addAtom(hydrogen);
molecule.addBond(0,3,Order.SINGLE);
hydrogen = new Atom(Elements.NITROGEN);
molecule.addAtom(hydrogen);
molecule.addBond(0,4,Order.SINGLE);
matcher = CDKAtomTypeMatcher.getInstance(
  DefaultChemObjectBuilder.getInstance()
);
type = matcher.findMatchingAtomType(molecule, atom);
assert type.atomTypeName == "X"
if (type.atomTypeName == "X") {
  // try a positive charge
  charge = atom.getFormalCharge()
  if (charge == null | charge == 0) {
    atom.setFormalCharge(+1)
    type = matcher.findMatchingAtomType(molecule, atom);
  }
}
assert type.atomTypeName != "X"
println "Atom type: $type.atomTypeName"
