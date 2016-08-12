import org.openscience.cdk.interfaces.*;
import org.openscience.cdk.*;
import javax.vecmath.*;

salt = new Crystal();
salt.setA(new Vector3d(5.6402, 0, 0));
salt.setB(new Vector3d(0, 5.6402, 0));
salt.setC(new Vector3d(0, 0, 5.6402));
salt.setZ(4);
sodium = new Atom("Na");
sodium.setFormalCharge(+1);
sodium.setFractionalPoint3d(
  new Point3d(0, 0, 0)
);
chloride = new Atom("Cl");
chloride.setFormalCharge(-1);
chloride.setFractionalPoint3d(
  new Point3d(0.5, 0.5, 0.5)
);
salt.addAtom(sodium);
salt.addAtom(chloride);
