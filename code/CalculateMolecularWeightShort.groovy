import org.openscience.cdk.interfaces.*;
import org.openscience.cdk.silent.SilentChemObjectBuilder;
import org.openscience.cdk.config.Isotopes;
import org.openscience.cdk.tools.manipulator.*;

IChemObjectBuilder builder = SilentChemObjectBuilder.getInstance();
IAtomContainer molecule = builder.newInstance(IAtomContainer.class);
molecule.addAtom(builder.newInstance(IAtom.class, "C"));
molecule.addAtom(builder.newInstance(IAtom.class, "H"));
molecule.addAtom(builder.newInstance(IAtom.class, "H"));
molecule.addAtom(builder.newInstance(IAtom.class, "H"));
molecule.addAtom(builder.newInstance(IAtom.class, "H"));
molecule.getAtom(0).setImplicitHydrogenCount(0)
molecule.getAtom(1).setImplicitHydrogenCount(0)
molecule.getAtom(2).setImplicitHydrogenCount(0)
molecule.getAtom(3).setImplicitHydrogenCount(0)
molecule.getAtom(4).setImplicitHydrogenCount(0)
Isotopes isotopeInfo = Isotopes.getInstance();
molWeight = AtomContainerManipulator
  .getNaturalExactMass(molecule)
println molWeight
assert(molWeight - 16 < 0.3)
