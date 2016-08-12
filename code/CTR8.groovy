import org.openscience.cdk.interfaces.*;
import org.openscience.cdk.smiles.*;
import org.openscience.cdk.smiles.smarts.*;
import org.openscience.cdk.silent.SilentChemObjectBuilder;
 
SmilesParser sp = new SmilesParser(SilentChemObjectBuilder.getInstance());
atomContainer = sp.parseSmiles("C1CC12C3(C24CC4)CC3");
querytool = new SMARTSQueryTool(
  "*1**1", atomContainer.getBuilder()
);
found = querytool.matches(atomContainer);
if (found) {
  mappings = querytool.getMatchingAtoms()
  hits = 0
  for (int i = 0; i < mappings.size(); i++) {
    atomIndices = mappings.get(i);
    if (atomIndices.size() == 3) {
      // work around the cyclopropane / isobutane equivalence
      hits++
    }
  }
  println "hits: $hits"
  mappings = querytool.getUniqueMatchingAtoms()
  uniqueHits = 0
  for (int i = 0; i < mappings.size(); i++) {
    atomIndices = mappings.get(i);
    if (atomIndices.size() == 3) {
      // work around the cyclopropane / isobutane equivalence
      uniqueHits++
    }
  }
  println "unique hits: $uniqueHits"
}
