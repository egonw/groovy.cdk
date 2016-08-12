import org.openscience.cdk.*;
import org.openscience.cdk.stereo.*;
import org.openscience.cdk.interfaces.*;
import org.openscience.cdk.interfaces.IBond.Order;
import org.openscience.cdk.interfaces.ITetrahedralChirality.Stereo;

isomer = new AtomContainer()
isomer.addAtom(new Atom("C"))
isomer.addAtom(new Atom("Cl"))
isomer.addAtom(new Atom("Br"))
isomer.addAtom(new Atom("F"))
isomer.addAtom(new Atom("I"))
isomer.addBond(0,1,Order.SINGLE)
isomer.addBond(0,2,Order.SINGLE)
isomer.addBond(0,3,Order.SINGLE)
isomer.addBond(0,4,Order.SINGLE)

ligands = new IAtom[4]
ligands[0] = isomer.getAtom(1)
ligands[1] = isomer.getAtom(2)
ligands[2] = isomer.getAtom(3)
ligands[3] = isomer.getAtom(4)
chirality = new TetrahedralChirality(
  isomer.getAtom(0), ligands,
  Stereo.CLOCKWISE
)
