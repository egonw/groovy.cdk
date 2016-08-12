 import org.openscience.cdk.templates.*;
 import org.openscience.cdk.isomorphism.*;

butane = MoleculeFactory.makeAlkane(4);
propane = MoleculeFactory.makeAlkane(3);
println "Propane part of Butane: " +
  UniversalIsomorphismTester.isSubgraph(
    butane, propane
  )
println "Butane part of Propane: " +
  UniversalIsomorphismTester.isSubgraph(
    propane, butane
  )
