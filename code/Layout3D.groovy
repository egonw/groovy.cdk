import org.openscience.cdk.modeling.builder3d.*;
import org.openscience.cdk.silent.*;
import org.openscience.cdk.smiles.*;

parser = new SmilesParser(SilentChemObjectBuilder.newInstance())
mol = parser.parseSmiles("[F]C([F])([F])[H]")
builder3d = ModelBuilder3D.getInstance(mol.getBuilder());
mol = builder3d.generate3DCoordinates(mol, false);
for (atom in mol.atoms()) {
  point = atom.getPoint3d()
  println "$atom.symbol $point.x $point.y $point.z"
}
