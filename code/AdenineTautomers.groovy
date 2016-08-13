import org.openscience.cdk.interfaces.*;
import org.openscience.cdk.smiles.*;
import org.openscience.cdk.tautomers.*;
import org.openscience.cdk.tools.manipulator.*;
import org.openscience.cdk.*;

IChemObjectBuilder builder = DefaultChemObjectBuilder.getInstance();
IAtomContainer adenine = builder.newInstance(IAtomContainer.class);
IAtom a1 = builder.newInstance(IAtom.class,"N");
adenine.addAtom(a1);
IAtom a2 = builder.newInstance(IAtom.class,"N");
adenine.addAtom(a2);
IAtom a3 = builder.newInstance(IAtom.class,"N");
adenine.addAtom(a3);
IAtom a4 = builder.newInstance(IAtom.class,"N");
adenine.addAtom(a4);
IAtom a5 = builder.newInstance(IAtom.class,"N");
adenine.addAtom(a5);
IAtom a6 = builder.newInstance(IAtom.class,"C");
adenine.addAtom(a6);
IAtom a7 = builder.newInstance(IAtom.class,"C");
adenine.addAtom(a7);
IAtom a8 = builder.newInstance(IAtom.class,"C");
adenine.addAtom(a8);
IAtom a9 = builder.newInstance(IAtom.class,"C");
adenine.addAtom(a9);
IAtom a10 = builder.newInstance(IAtom.class,"C");
adenine.addAtom(a10);
IAtom a11 = builder.newInstance(IAtom.class,"H");
adenine.addAtom(a11);
IAtom a12 = builder.newInstance(IAtom.class,"H");
adenine.addAtom(a12);
IAtom a13 = builder.newInstance(IAtom.class,"H");
adenine.addAtom(a13);
IAtom a14 = builder.newInstance(IAtom.class,"H");
adenine.addAtom(a14);
IAtom a15 = builder.newInstance(IAtom.class,"H");
adenine.addAtom(a15);
IBond b1 = builder.newInstance(IBond.class,a1, a6, IBond.Order.SINGLE);
adenine.addBond(b1);
IBond b2 = builder.newInstance(IBond.class,a1, a9, IBond.Order.SINGLE);
adenine.addBond(b2);
IBond b3 = builder.newInstance(IBond.class,a1, a11, IBond.Order.SINGLE);
adenine.addBond(b3);
IBond b4 = builder.newInstance(IBond.class,a2, a7, IBond.Order.SINGLE);
adenine.addBond(b4);
IBond b5 = builder.newInstance(IBond.class,a2, a9, IBond.Order.DOUBLE);
adenine.addBond(b5);
IBond b6 = builder.newInstance(IBond.class,a3, a7, IBond.Order.DOUBLE);
adenine.addBond(b6);
IBond b7 = builder.newInstance(IBond.class,a3, a10, IBond.Order.SINGLE);
adenine.addBond(b7);
IBond b8 = builder.newInstance(IBond.class,a4, a8, IBond.Order.SINGLE);
adenine.addBond(b8);
IBond b9 = builder.newInstance(IBond.class,a4, a10, IBond.Order.DOUBLE);
adenine.addBond(b9);
IBond b10 = builder.newInstance(IBond.class,a5, a8, IBond.Order.SINGLE);
adenine.addBond(b10);
IBond b11 = builder.newInstance(IBond.class,a5, a14, IBond.Order.SINGLE);
adenine.addBond(b11);
IBond b12 = builder.newInstance(IBond.class,a5, a15, IBond.Order.SINGLE);
adenine.addBond(b12);
IBond b13 = builder.newInstance(IBond.class,a6, a7, IBond.Order.SINGLE);
adenine.addBond(b13);
IBond b14 = builder.newInstance(IBond.class,a6, a8, IBond.Order.DOUBLE);
adenine.addBond(b14);
IBond b15 = builder.newInstance(IBond.class,a9, a12, IBond.Order.SINGLE);
adenine.addBond(b15);
IBond b16 = builder.newInstance(IBond.class,a10, a13, IBond.Order.SINGLE);
adenine.addBond(b16);

smilesGenerator = new SmilesGenerator();

AtomContainerManipulator
  .percieveAtomTypesAndConfigureAtoms(
    adenine
  );
tautomerGenerator = new InChITautomerGenerator();
tautomers = tautomerGenerator.getTautomers(adenine)
for (tautomer in tautomers) {
  println smilesGenerator.createSMILES(tautomer)
}
