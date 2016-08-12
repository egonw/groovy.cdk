import org.openscience.cdk.interfaces.*;
import org.openscience.cdk.silent.*;
import org.openscience.cdk.inchi.*;
import org.openscience.cdk.io.*;
import org.openscience.cdk.io.IChemObjectReader.Mode;
import java.io.File;

reader = new MDLV2000Reader(
  new File("data/CID_57518771.mol").newReader(),
  Mode.STRICT
);
try {
isomer1 = reader.read(new AtomContainer());
} catch (Exception exception) {
  println exception.message
}

reader = new MDLV2000Reader(
  new File("data/CID_57518772.mol").newReader(),
  Mode.STRICT 
);
try {
 isomer2 = reader.read(new AtomContainer());
} catch (Exception exception) {
  println exception.message 
}
factory = InChIGeneratorFactory.getInstance();

generator = factory.getInChIGenerator(isomer1)
println generator.inchi
generator = factory.getInChIGenerator(isomer2)
println generator.inchi
