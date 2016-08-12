import org.openscience.cdk.interfaces.*;
import org.openscience.cdk.io.*;
import org.openscience.cdk.tools.manipulator.*;
import org.openscience.cdk.io.IChemObjectReader.Mode;
import org.openscience.cdk.*;
import java.io.File;
import java.util.zip.GZIPInputStream;

try {
reader = new PDBReader(
  new GZIPInputStream(
    new URL(
      "http://www.pdb.org/pdb/files/1CRN.pdb.gz"
    ).openStream()
  )
);
crambin = reader.read(new ChemFile());
for (container in
     ChemFileManipulator.getAllAtomContainers(
       crambin
     )) {
  for (atom in container.atoms()) {
    println atom.point3d;
  }
}
} catch (UnknownHostException exception) {
  println "FIXME: compile without internet connection"
}
