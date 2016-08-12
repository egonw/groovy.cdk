import org.openscience.cdk.interfaces.*;
import org.openscience.cdk.*;

mol = new AtomContainer();
mol.addAtom(new Atom("C"));
mol.addAtom(new Atom("C"));
mol.addAtom(new Atom("C"));
mol.addBond(0,1,IBond.Order.DOUBLE);
mol.addBond(0,2,IBond.Order.SINGLE);

int doubleBondCount = 0
for (IBond bond : mol.bonds()) {
  if (IBond.Order.DOUBLE == bond.getOrder())
    doubleBondCount++
}
println "Number of double bonds: $doubleBondCount"
