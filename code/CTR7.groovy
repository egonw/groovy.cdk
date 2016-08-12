import java.util.List;
import java.awt.*;
import java.awt.image.*;
import java.util.zip.GZIPInputStream;
import javax.imageio.*;
import org.openscience.cdk.*;
import org.openscience.cdk.interfaces.*;
import org.openscience.cdk.io.*;
import org.openscience.cdk.io.iterator.*;
import org.openscience.cdk.layout.*;
import org.openscience.cdk.renderer.*;
import org.openscience.cdk.renderer.font.*;
import org.openscience.cdk.renderer.generators.*;
import org.openscience.cdk.renderer.visitor.*;
import org.openscience.cdk.renderer.generators.BasicSceneGenerator.Margin;
import org.openscience.cdk.renderer.generators.BasicSceneGenerator.ZoomFactor;
import org.openscience.cdk.silent.*;
import org.openscience.cdk.smiles.smarts.*;
import org.openscience.cdk.templates.*;
import org.openscience.cdk.tools.manipulator.*;




int WIDTH = 250;
int HEIGHT = 200;
// the draw area and the image should be the same size
Rectangle drawArea = new Rectangle(WIDTH, HEIGHT);
Image image = new BufferedImage(
  WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB
);
iterator = new IteratingSDFReader(
  new GZIPInputStream(
    new File("ctr/benzodiazepine.sdf.gz")
      .newInputStream()
  ),
  SilentChemObjectBuilder.getInstance()
)
iterator.setReaderMode(
  IChemObjectReader.Mode.STRICT
)
compound3016 = null
while (iterator.hasNext() && compound3016 == null) {
  mol = iterator.next()
  if ("3016".equals(mol.getProperty(CDKConstants.TITLE)))
    compound3016 = mol
}
compound3016 = AtomContainerManipulator.removeHydrogens(
  compound3016
)
sdg = new StructureDiagramGenerator();
sdg.setMolecule(compound3016);
sdg.generateCoordinates();
compound3016 = sdg.getMolecule();
// generators make the image elements
List<IGenerator> generators =
  new ArrayList<IGenerator>();
generators.add(new BasicSceneGenerator());
generators.add(new ExternalHighlightGenerator());
generators.add(new BasicBondGenerator());
generators.add(new BasicAtomGenerator());
selection = new AtomContainer();
querytool = new SMARTSQueryTool(
  "c1ccc2c(c1)C(=NCCN2)c3ccccc3",
  compound3016.getBuilder()
);
querytool.matches(compound3016);
if (querytool.countMatches() > 0) {
  mappings = querytool.getUniqueMatchingAtoms()
  mapping = mappings.get(0)
  for (int i=0; i<mapping.size(); i++) {
    selection.addAtom(
      compound3016.getAtom(mapping.get(i))
    )
  }
}
// the renderer needs to have a toolkit-specific font manager
AtomContainerRenderer renderer =
  new AtomContainerRenderer(generators, new AWTFontManager());
// the call to 'setup' only needs to be done on the first paint
renderer.setup(compound3016, drawArea);
model = renderer.getRenderer2DModel();
model.set(ZoomFactor.class, (double)0.5);
model.set(
  ExternalHighlightGenerator
    .ExternalHighlightDistance.class,
  (double)18
);
model.set(
  RendererModel.ExternalHighlightColor.class,
  Color.red
);
model.setExternalSelectedPart(selection);
// paint the background
Graphics2D g2 = (Graphics2D)image.getGraphics();
g2.setColor(Color.WHITE);
g2.fillRect(0, 0, WIDTH, HEIGHT);
// the paint method also needs a toolkit-specific renderer
renderer.paint(compound3016, new AWTDrawVisitor(g2));
ImageIO.write(
  (RenderedImage)image, "PNG",
  new File("CTR7.png")
);
