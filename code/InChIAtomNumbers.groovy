import java.util.List;
import java.awt.*;
import java.awt.image.*;
import javax.imageio.*;
import javax.vecmath.*;
import org.openscience.cdk.*;
import org.openscience.cdk.interfaces.*;
import org.openscience.cdk.layout.*;
import org.openscience.cdk.templates.*;
import org.openscience.cdk.graph.invariant.*;
import org.openscience.cdk.tools.manipulator.*;
import org.openscience.cdk.renderer.*;
import org.openscience.cdk.renderer.font.*;
import org.openscience.cdk.renderer.generators.*;
import org.openscience.cdk.renderer.visitor.*;
import org.openscience.cdk.renderer.generators.BasicSceneGenerator.Margin;
import org.openscience.cdk.qsar.descriptors.molecular.*;
import org.openscience.cdk.qsar.result.*;




oxazole = MoleculeFactory.makeOxazole();
long[] morganNumbers =
  InChINumbersTools.getNumbers(
    oxazole
  );
for (i in 0..(oxazole.atomCount-1)) {
  atom = oxazole.getAtom(i)
  println atom.symbol +
    " " + morganNumbers[i]
  atom.setProperty(
    "AtomNumber",
    "" + morganNumbers[i]
  )
}
int WIDTH = 220;
int HEIGHT = 220;

// the draw area and the image should be the same size
Rectangle drawArea = new Rectangle(WIDTH, HEIGHT);
Image image = new BufferedImage(
  WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB
);

StructureDiagramGenerator sdg = new StructureDiagramGenerator();
sdg.setMolecule(oxazole);
sdg.generateCoordinates();
oxazole = sdg.getMolecule();

// generators make the image elements
List<IGenerator> generators = new ArrayList<IGenerator>();
generators.add(new BasicSceneGenerator());
generators.add(new BasicBondGenerator());
generators.add(new BasicAtomGenerator());
generators.add(new AtomNumberGenerator());

// the renderer needs to have a toolkit-specific font manager
AtomContainerRenderer renderer =
  new AtomContainerRenderer(generators, new AWTFontManager());

// the call to 'setup' only needs to be done on the first paint
renderer.setup(oxazole, drawArea);

model = renderer.getRenderer2DModel();
model.set(Margin.class, (double)0.1);

// paint the background
Graphics2D g2 = (Graphics2D)image.getGraphics();
g2.setColor(Color.WHITE);
g2.fillRect(0, 0, WIDTH, HEIGHT);

// the paint method also needs a toolkit-specific renderer
renderer.paint(oxazole, new AWTDrawVisitor(g2));

ImageIO.write(
  (RenderedImage)image, "PNG",
  new File("InChIAtomNumbers.png")
);
