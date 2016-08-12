import org.openscience.cdk.interfaces.*;
import org.openscience.cdk.*;
import org.openscience.cdk.inchi.*;
import net.sf.jniinchi.INCHI_RET;

mierezuur = new Molecule();
atom1 = new Atom("O")
atom2 = new Atom("C")
atom3 = new Atom("O")
bond1 = new Bond(atom1, atom2, IBond.Order.SINGLE)
bond2 = new Bond(atom2, atom3, IBond.Order.DOUBLE)
mierezuur.addAtom(atom1)
mierezuur.addAtom(atom2)
mierezuur.addAtom(atom3)
mierezuur.addBond(bond1)
mierezuur.addBond(bond2)

factory = InChIGeneratorFactory.getInstance();
generator = factory.getInChIGenerator(mierezuur, "FixedH");
if (generator.getReturnStatus() == INCHI_RET.OKAY)
print generator.getInchi()
