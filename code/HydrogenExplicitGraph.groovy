import org.openscience.cdk.interfaces.*;
import org.openscience.cdk.*;
import org.openscience.cdk.config.Elements;

molecule = new AtomContainer();
carbon = new Atom(Elements.CARBON);
molecule.addAtom(carbon);
for (int i=1; i<=4; i++) {
  hydrogen = new Atom(Elements.HYDROGEN);
  molecule.addAtom(hydrogen);
  molecule.addBond(0, i, IBond.Order.SINGLE);
}
