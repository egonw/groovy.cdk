 import org.openscience.cdk.templates.*;
 import org.openscience.cdk.isomorphism.*;
butane = MoleculeFactory.makeAlkane(4)
ccc = MoleculeFactory.makeAlkane(3)
hits = UniversalIsomorphismTester
  .getOverlaps(
     butane, ccc
  )
println "Number of hits: " + hits.size
hits.each { substructure ->
  println "Substructure in Molecule:"
  println "  #atoms: " + substructure.atomCount
}
