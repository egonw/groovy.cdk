import org.openscience.cdk.interfaces.*;
import org.openscience.cdk.io.*;
import org.openscience.cdk.ringsearch.*;
import org.openscience.cdk.io.IChemObjectReader.Mode;
import org.openscience.cdk.silent.*;
import java.io.File;

reader = new MDLV2000Reader(
  new File("data/azulene.mol").newReader(),
  Mode.STRICT
);
azulene = reader.read(new AtomContainer());
ringset = new FiguerasSSSRFinder().findSSSR(azulene)
println "Number of rings: $ringset.atomContainerCount"
