import org.openscience.cdk.interfaces.*;
import org.openscience.cdk.graph.*;
import org.openscience.cdk.io.*;
import org.openscience.cdk.io.IChemObjectReader.Mode;
import org.openscience.cdk.io.iterator.*;
import org.openscience.cdk.ringsearch.*;
import org.openscience.cdk.silent.*;
import org.openscience.cdk.tools.manipulator.*;
import java.io.File;
import java.util.zip.GZIPInputStream;

iterator = new IteratingSMILESReader(
  new GZIPInputStream(
    new File("ctr/benzodiazepine.smi.gz")
      .newInputStream()
  ),
  SilentChemObjectBuilder.getInstance()
)
iterator.setReaderMode(
  IChemObjectReader.Mode.STRICT
)
while (iterator.hasNext()) {
  mol = iterator.next()
  components =
    ConnectivityChecker.partitionIntoMolecules(
      mol
    )
  totalRingCount = 0
  for (component in components.atomContainers()) {
    ringset = new SSSRFinder(component).findSSSR()
    totalRingCount += ringset.atomContainerCount
  }
  println totalRingCount
}
