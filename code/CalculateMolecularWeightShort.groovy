import org.openscience.cdk.interfaces.*;
import org.openscience.cdk.nonotify.NoNotificationChemObjectBuilder;
import org.openscience.cdk.config.IsotopeFactory;
import org.openscience.cdk.tools.manipulator.*;

IChemObjectBuilder builder = NoNotificationChemObjectBuilder.getInstance();
IMolecule molecule = builder.newInstance(IMolecule.class);
molecule.addAtom(builder.newInstance(IAtom.class, "C"));
molecule.addAtom(builder.newInstance(IAtom.class, "H"));
molecule.addAtom(builder.newInstance(IAtom.class, "H"));
molecule.addAtom(builder.newInstance(IAtom.class, "H"));
molecule.addAtom(builder.newInstance(IAtom.class, "H"));
IsotopeFactory isotopeInfo = IsotopeFactory.getInstance(builder);
molWeight = AtomContainerManipulator
  .getNaturalExactMass(molecule)
println molWeight
assert(molWeight - 16 < 0.3)
