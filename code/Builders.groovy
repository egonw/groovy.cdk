import org.openscience.cdk.interfaces.*;
import org.openscience.cdk.*;

IChemObjectBuilder builder =
  DefaultChemObjectBuilder.getInstance();
IAtom atom1 = builder.newInstance(IAtom.class, "C");
IAtom atom2 = builder.newInstance(IAtom.class, "C");
molecule = builder.newInstance(IAtomContainer.class);
molecule.addAtom(atom1);
molecule.addAtom(atom2);
molecule.addBond(builder.newInstance(
  IBond.class, atom1, atom2, IBond.Order.SINGLE
));
