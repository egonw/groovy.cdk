import org.openscience.cdk.interfaces.*;
import org.openscience.cdk.*;
import org.openscience.cdk.inchi.*;
import net.sf.jniinchi.INCHI_RET;

ethanol = new AtomContainer()
ethanol.addAtom(new Atom("C"))
ethanol.addAtom(new Atom("C"))
ethanol.addAtom(new Atom("O"))

factory = InChIGeneratorFactory.getInstance();
generator = factory.getInChIGenerator(ethanol, "")
print generator.getAuxInfo()
