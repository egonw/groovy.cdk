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
println "Strand name: " + strand.strandName
println "       type: " + strand.strandType
monomer = strand.getMonomer("ALAA9")
println "Monomer name: " + monomer.monomerName
println "        type: " + monomer.monomerType
