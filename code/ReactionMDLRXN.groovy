import org.openscience.cdk.silent.*;
import org.openscience.cdk.interfaces.*;
import org.openscience.cdk.io.*;

MDLRXNReader reader = new MDLRXNReader(
  new File("data/anie.201203222.rxn").newReader()
);
IReaction reaction = new Reaction();
reaction = reader.read(reaction);
reader.close();
println "Reactants: " + reaction.reactants.atomContainerCount
println "Products: " + reaction.products.atomContainerCount
