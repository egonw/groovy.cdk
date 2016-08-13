 import org.openscience.cdk.templates.*;
 import org.openscience.cdk.isomorphism.*;

butane = MoleculeFactory.makeAlkane(4);
ccc = MoleculeFactory.makeAlkane(3);
isomorphismTester = new UniversalIsomorphismTester()
hits = isomorphismTester.getSubgraphAtomsMaps(
     butane, ccc
  )
println "Number of hits: " + hits.size
 assert hits.size == 4
hits.each { substructure ->
  println "Atoms in substructure: " +
    substructure.size
}
