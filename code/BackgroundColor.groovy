import java.util.List;
import java.awt.*;
import java.awt.image.*;
import javax.imageio.*;
import org.openscience.cdk.*;
import org.openscience.cdk.interfaces.*;
import org.openscience.cdk.layout.*;
import org.openscience.cdk.renderer.*;
import org.openscience.cdk.renderer.font.*;
import org.openscience.cdk.renderer.generators.*;
import org.openscience.cdk.renderer.visitor.*;
import org.openscience.cdk.templates.*;
import org.openscience.cdk.renderer.generators.BasicSceneGenerator.ZoomFactor;

int WIDTH = 600;
int HEIGHT = 600;
backgroundColor = Color.lightGray;

// the draw area and the image should be the same size
Rectangle drawArea = new Rectangle(WIDTH, HEIGHT);
Image image = new BufferedImage(
  WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB
);

IAtomContainer triazole = MoleculeFactory.make123Triazole();
StructureDiagramGenerator sdg = new StructureDiagramGenerator();
sdg.setMolecule(triazole);
sdg.generateCoordinates();
triazole = sdg.getMolecule();

// generators make the image elements
List<IGenerator> generators = new ArrayList<IGenerator>();
generators.add(new BasicSceneGenerator());
generators.add(new BasicBondGenerator());
generators.add(new BasicAtomGenerator());

// the renderer needs to have a toolkit-specific font manager
AtomContainerRenderer renderer =
  new AtomContainerRenderer(generators, new AWTFontManager());
model = renderer.getRenderer2DModel()
model.set(
  BasicSceneGenerator.BackgroundColor.class,
  backgroundColor
)
model.set(ZoomFactor.class, (double)3.0);

// the call to 'setup' only needs to be done on the first paint
renderer.setup(triazole, drawArea);

// paint the background
Graphics2D g2 = (Graphics2D)image.getGraphics();
g2.setColor(backgroundColor);
g2.fillRect(0, 0, WIDTH, HEIGHT);

// the paint method also needs a toolkit-specific renderer
visitor = new AWTDrawVisitor(g2)
visitor.setRendererModel(model)
renderer.paint(triazole, visitor);

ImageIO.write((RenderedImage)image, "PNG", new File("BackgroundColor.png"));
