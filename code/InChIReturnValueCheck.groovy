import org.openscience.cdk.interfaces.*;
import org.openscience.cdk.*;
import org.openscience.cdk.inchi.*;
import net.sf.jniinchi.*;

methane = new AtomContainer();
atom1 = new Atom("C")
methane.addAtom(atom1)

factory = InChIGeneratorFactory.getInstance();
generator = factory.getInChIGenerator(methane);
if (generator.getReturnStatus() == INCHI_RET.OKAY) {
  print generator.getInchi()
} else {
  print generator.getLog()
}
