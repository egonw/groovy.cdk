import org.openscience.cdk.*;
import org.openscience.cdk.interfaces.*;
import org.openscience.cdk.nonotify.NoNotificationChemObjectBuilder;
import org.openscience.cdk.config.*;

IChemObjectBuilder builder = NoNotificationChemObjectBuilder.getInstance();
IMolecule molecule = builder.newInstance(IMolecule.class);
molecule.addAtom(builder.newInstance(IAtom.class, "C"));
molecule.addAtom(builder.newInstance(IAtom.class, "H"));
molecule.addAtom(builder.newInstance(IAtom.class, "H"));
molecule.addAtom(builder.newInstance(IAtom.class, "H"));
molecule.addAtom(builder.newInstance(IAtom.class, "H"));
IsotopeFactory isotopeInfo = IsotopeFactory.getInstance(builder);
molWeight = 0.0
hWeight = isotopeInfo.getNaturalMass(Elements.HYDROGEN)
for (atom in molecule.atoms()) {
  molWeight += isotopeInfo.getNaturalMass(atom)
  if (atom.getImplicitHydrogenCount() != CDKConstants.UNSET)
    molWeight += atom.getImplicitHydrogenCount() *
                 hWeight
}
println molWeight
assert(molWeight - 16 < 0.3)
