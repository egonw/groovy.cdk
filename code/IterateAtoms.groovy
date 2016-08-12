import org.openscience.cdk.interfaces.*;
import org.openscience.cdk.nonotify.NoNotificationChemObjectBuilder;

IChemObjectBuilder builder = NoNotificationChemObjectBuilder.getInstance();
IMolecule molecule = builder.newInstance(IMolecule.class);
molecule.addAtom(builder.newInstance(IAtom.class, "C"));
molecule.addAtom(builder.newInstance(IAtom.class, "O"));
molecule.addAtom(builder.newInstance(IAtom.class, "C"));

for (IAtom atom : molecule.atoms()) {
  System.out.println(atom.getSymbol());
}
