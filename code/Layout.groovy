import org.openscience.cdk.*;
import org.openscience.cdk.layout.*;
import org.openscience.cdk.smiles.*;
import javax.vecmath.*;

smilesParser = new SmilesParser(
  DefaultChemObjectBuilder.getInstance()
);
butanol = smilesParser.parseSmiles("CCC(O)C")
sdg = new StructureDiagramGenerator();
sdg.setMolecule(butanol);
sdg.generateCoordinates(new Vector2d(0, 1));
butanol = sdg.getMolecule();
for (atom in butanol.atoms()) {
  println atom.getSymbol() + ": " +
    atom.getPoint2d()
}
