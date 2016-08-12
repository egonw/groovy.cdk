import org.openscience.cdk.interfaces.*;
import org.openscience.cdk.io.*;
import org.openscience.cdk.tools.manipulator.*;
import org.openscience.cdk.*;
import java.io.*;

reader = new PDBReader(
  new FileReader("data/1CRN.pdb")
);
file = reader.read(new ChemFile());
crambin = ChemFileManipulator
  .getAllAtomContainers(file)
  .get(0)
assert crambin instanceof IBioPolymer
strand = crambin.getStrand("A")
i=0
for (name in crambin.monomerNames) {
  println "monomer " + name
  i += 1
  if (i>7) { println "..."; break }
}
