import org.openscience.cdk.interfaces.*;
import org.openscience.cdk.nonotify.NoNotificationChemObjectBuilder;
import org.openscience.cdk.config.IsotopeFactory;

IChemObjectBuilder builder = NoNotificationChemObjectBuilder.getInstance();
IMolecule molecule = builder.newInstance(IMolecule.class);
molecule.addAtom(builder.newInstance(IAtom.class, "C"));
molecule.getAtom(0).setCharge(0.1);
molecule.addAtom(builder.newInstance(IAtom.class, "O"));
molecule.getAtom(1).setCharge(-0.2);
molecule.addAtom(builder.newInstance(IAtom.class, "C"));
molecule.getAtom(2).setCharge(0.1);

totalCharge = 0.0
for (atom in molecule.atoms()) {
  totalCharge += atom.getCharge()
}
println totalCharge
