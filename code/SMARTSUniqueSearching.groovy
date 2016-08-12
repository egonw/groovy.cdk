import org.openscience.cdk.interfaces.*;
import org.openscience.cdk.smiles.*;
import org.openscience.cdk.smiles.smarts.*;
import org.openscience.cdk.silent.SilentChemObjectBuilder;
 
SmilesParser sp = new SmilesParser(SilentChemObjectBuilder.getInstance());
atomContainer = sp.parseSmiles("CC(=O)OC(=O)C");
querytool = new SMARTSQueryTool(
  "O~C~O", atomContainer.getBuilder()
);
found = querytool.matches(atomContainer);
if (found) {
   mappings = querytool.getMatchingAtoms();
   for (int i = 1; i <= mappings.size(); i++) {
      atomIndices = mappings.get(i-1);
      println "match $i: $atomIndices"
   }
   mappings = querytool.getUniqueMatchingAtoms();
   for (int i = 1; i <= mappings.size(); i++) {
      atomIndices = mappings.get(i-1);
      println "unique match $i: $atomIndices"
   }
}
