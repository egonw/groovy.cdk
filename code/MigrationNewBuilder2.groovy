import org.openscience.cdk.interfaces.*;
import org.openscience.cdk.*;
import javax.vecmath.*;

IChemObjectBuilder builder = new DefaultChemObjectBuilder();
IAtom atom = builder.newInstance(
  IAtom.class, "C", new Point2d(0,0)
);
