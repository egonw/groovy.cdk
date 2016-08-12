import org.openscience.cdk.interfaces.*;
import org.openscience.cdk.interfaces.IBond.Order;
import org.openscience.cdk.*;
import org.openscience.cdk.inchi.*;
import net.sf.jniinchi.INCHI_RET;

bad = new AtomContainer();
bad.addAtom(new Atom("C"))
bad.addAtom(new Atom("H"))
bad.addBond(0, 1, Order.TRIPLE)

factory = InChIGeneratorFactory.getInstance();
generator = factory.getInChIGenerator(bad);
print generator.getMessage()
