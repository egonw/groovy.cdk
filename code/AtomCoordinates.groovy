import org.openscience.cdk.interfaces.*;
import org.openscience.cdk.*;
import javax.vecmath.*;

IAtom atom = new Atom("C");
atom.setPoint2d(
  new Point2d(1.0, 2.3)
)
atom.setPoint3d(
  new Point3d(-2.0, -3.5, 4.7)
)
atom.setFractionalPoint3d(
  new Point3d(0.1, 0.5, 0.25)
)
