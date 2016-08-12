import org.openscience.cdk.*;
sequence = new ChemSequence()
for (model in sequence.chemModels()) {
  println "model's hash: " + model.hashCode()
}
