import org.openscience.cdk.interfaces.*;
import org.openscience.cdk.io.*;
import org.openscience.cdk.exception.*;
import org.openscience.cdk.*;
import org.openscience.cdk.io.IChemObjectReader.Mode;
import java.io.File;

reader = new MDLV2000Reader(
  new File("data/t.mol").newReader(),
  Mode.STRICT
);
try {
water = reader.read(new Molecule());
println "atom count: $water.atomCount"
} catch (CDKException exception) {
 println exception.getMessage()
}
