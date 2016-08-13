 import org.openscience.cdk.templates.*;
 import org.openscience.cdk.isomorphism.*;

butane = MoleculeFactory.makeAlkane(4);
propane = MoleculeFactory.makeAlkane(3);
isomorphismTester = new UniversalIsomorphismTester()
println "Propane part of Butane: " +
  isomorphismTester.isSubgraph(
    butane, propane
  )
println "Butane part of Propane: " +
  isomorphismTester.isSubgraph(
    propane, butane
  )
