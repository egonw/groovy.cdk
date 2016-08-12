import org.openscience.cdk.fingerprint.*;
import org.openscience.cdk.smiles.*;
import org.openscience.cdk.silent.*;
import org.openscience.cdk.similarity.*;

smilesParser = new SmilesParser(
  SilentChemObjectBuilder.getInstance()
);
smiles1 = "CC(C)C=CCCCCC(=O)NCc1ccc(c(c1)OC)O"
smiles2 = "COC1=C(C=CC(=C1)C=O)O"
mol1 = smilesParser.parseSmiles(smiles1)
mol2 = smilesParser.parseSmiles(smiles2)
fingerprinter = new HybridizationFingerprinter()
bitset1 = fingerprinter.getBitFingerprint(mol1)
bitset2 = fingerprinter.getBitFingerprint(mol2)
tanimoto = Tanimoto.calculate(bitset1, bitset2)
println "Tanimoto: $tanimoto"
