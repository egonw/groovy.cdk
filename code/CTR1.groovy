import org.openscience.cdk.interfaces.*;
import org.openscience.cdk.io.*;
import org.openscience.cdk.io.iterator.*;
import org.openscience.cdk.silent.*;
import org.openscience.cdk.tools.manipulator.*;
import java.util.zip.GZIPInputStream;

iterator = new IteratingSDFReader(
  new GZIPInputStream(
    new File("ctr/benzodiazepine.sdf.gz")
      .newInputStream()
  ),
  SilentChemObjectBuilder.getInstance()
)
iterator.setReaderMode(
  IChemObjectReader.Mode.STRICT
)
while (iterator.hasNext()) {
  mol = iterator.next()
  heavyAtomCount = 0
  for (atom in mol.atoms()) {
    if (1 == atom.atomicNumber ||
        "H" == atom.symbol) {
      // do not count hydrogens
    } else {
      heavyAtomCount++
    }
  }
  println heavyAtomCount
}
