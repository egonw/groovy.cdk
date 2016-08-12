 import org.openscience.cdk.templates.*;
 import org.openscience.cdk.isomorphism.*;

butane = MoleculeFactory.makeAlkane(4);
println "Is isomorphic: " +
  UniversalIsomorphismTester.isIsomorph(
    butane, butane
  )
