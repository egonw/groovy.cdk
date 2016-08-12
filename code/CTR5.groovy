import org.openscience.cdk.smiles.SmilesGenerator;
import org.openscience.cdk.smiles.SmilesParser;
import org.openscience.cdk.silent.SilentChemObjectBuilder;
 
parser = new SmilesParser(
  SilentChemObjectBuilder.getInstance()
);
generator = SmilesGenerator.unique();
smi = [
  "CN2C(=O)N(C)C(=O)C1=C2N=CN1C",
  "CN1C=NC2=C1C(=O)N(C)C(=O)N2C"
]
can = [];
smi.each { smiles ->
  can.add(
    generator.createSMILES(
      parser.parseSmiles(smiles)
    )
  )
}
print "The canonical SMILES are identical: " + (can[0] == can[1])
