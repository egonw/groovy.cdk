 import org.openscience.cdk.templates.*;
 import org.openscience.cdk.isomorphism.*;
butane = MoleculeFactory.makeAlkane(4);
butane.atoms().each { atom ->
  atom.setProperty("Label", "Molecule")
}
ccc = MoleculeFactory.makeAlkane(3);
ccc.atoms().each { atom ->
  atom.setProperty("Label", "Substructure")
}
