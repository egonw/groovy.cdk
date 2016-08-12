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
println "Crambin has " +
  crambin.strandCount + " strand(s)"
for (name in crambin.strandNames) {
  print "  strand " + name
  strand = crambin.getStrand(name)
  println " has " + strand.atomCount +
    " atoms"
}
