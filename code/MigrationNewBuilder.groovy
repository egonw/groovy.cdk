import org.openscience.cdk.interfaces.*;
import org.openscience.cdk.*;

IChemObjectBuilder builder =
  DefaultChemObjectBuilder.getInstance();
IMolecule molecule = builder.newInstance(
  IMolecule.class
);
molecule.addAtom(
  builder.newInstance(IAtom.class, "C")
);
