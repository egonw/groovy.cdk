import org.openscience.cdk.interfaces.*;
import org.openscience.cdk.silent.SilentChemObjectBuilder;

IChemObjectBuilder builder = SilentChemObjectBuilder.getInstance();
IAtomContainer molecule = builder.newInstance(IAtomContainer.class);
molecule.addAtom(builder.newInstance(IAtom.class, "C"));
molecule.addAtom(builder.newInstance(IAtom.class, "O"));
molecule.addAtom(builder.newInstance(IAtom.class, "C"));

for (IAtom atom : molecule.atoms()) {
  System.out.println(atom.getSymbol());
}
