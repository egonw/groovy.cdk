import org.openscience.cdk.*;
file = new ChemFile()
for (i = 0; i < file.chemSequenceCount; i++) {
  println "sequence $i has hash: " +
    model.getChemSequence(i)
}
