import org.openscience.cdk.interfaces.*;
import org.openscience.cdk.*;

IChemObjectBuilder builder =
  DefaultChemObjectBuilder.getInstance();
IAtomContainer molecule = builder.newInstance(
  IAtomContainer.class
);
molecule.addAtom(
  builder.newInstance(IAtom.class, "C")
);
