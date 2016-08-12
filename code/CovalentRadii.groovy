import org.openscience.cdk.interfaces.*;
import org.openscience.cdk.*;
import org.openscience.cdk.config.*;
import javax.vecmath.Point3d;

methane = new Molecule();
methane.addAtom(new Atom("C", new Point3d(0.0, 0.0, 0.0)));
methane.addAtom(new Atom("H", new Point3d(0.6, 0.6, 0.6)));
methane.addAtom(new Atom("H", new Point3d(-0.6,-0.6,0.6)));
methane.addAtom(new Atom("H", new Point3d(0.6,-0.6,-0.6)));
methane.addAtom(new Atom("H", new Point3d(-0.6,0.6,-0.6)));
factory = AtomTypeFactory.getInstance(
  "org/openscience/cdk/config/data/jmol_atomtypes.txt", 
  methane.getBuilder()
);
for (IAtom atom : methane.atoms()) {
  factory.configure(atom);
  println "$atom.symbol -> $atom.covalentRadius"
}
