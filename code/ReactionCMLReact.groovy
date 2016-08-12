import org.openscience.cdk.silent.*;
import org.openscience.cdk.interfaces.*;
import org.openscience.cdk.io.*;

CMLReader reader = new CMLReader(
  new File("data/anie.201203222.cml").newInputStream()
);
IChemFile file = new ChemFile();
reaction = reader.read(file);
reader.close();
sequence = file.getChemSequence(0)
model = sequence.getChemModel(0)
reactions = model.getReactionSet()
reaction = reactions.getReaction(0)
println "Reactants: " + reaction.reactants.atomContainerCount
println "Products: " + reaction.products.atomContainerCount
