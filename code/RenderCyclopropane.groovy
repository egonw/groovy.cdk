import java.util.List;
import java.awt.*;
import java.awt.image.*;
import javax.imageio.*;
import javax.vecmath.*;
import org.openscience.cdk.*;
import org.openscience.cdk.interfaces.*;
import org.openscience.cdk.layout.*;
import org.openscience.cdk.renderer.*;
import org.openscience.cdk.renderer.font.*;
import org.openscience.cdk.renderer.generators.*;
import org.openscience.cdk.renderer.visitor.*;
import org.openscience.cdk.templates.*;
import org.openscience.cdk.renderer.generators.BasicSceneGenerator.Margin;
import org.openscience.cdk.renderer.generators.BasicSceneGenerator.ZoomFactor;




int WIDTH = 600;
int HEIGHT = 600;
cyclopropane = new AtomContainer()
for (i in 1..3) cyclopropane.addAtom(new Atom("C"))
cyclopropane.addBond(0,1,IBond.Order.SINGLE);
cyclopropane.addBond(1,2,IBond.Order.SINGLE);
cyclopropane.addBond(0,2,IBond.Order.SINGLE);
// the draw area and the image should be the same size
Rectangle drawArea = new Rectangle(WIDTH, HEIGHT);
Image image = new BufferedImage(
  WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB
);
StructureDiagramGenerator sdg = new StructureDiagramGenerator();
sdg.setMolecule(cyclopropane);
sdg.generateCoordinates();
cyclopropane = sdg.getMolecule();
// generators make the image elements
List<IGenerator> generators = new ArrayList<IGenerator>();
generators.add(new BasicSceneGenerator());
generators.add(new BasicBondGenerator());
generators.add(new BasicAtomGenerator());
// the renderer needs to have a toolkit-specific font manager
AtomContainerRenderer renderer =
  new AtomContainerRenderer(generators, new AWTFontManager());
// the call to 'setup' only needs to be done on the first paint
renderer.setup(cyclopropane, drawArea);
model = renderer.getRenderer2DModel();
model.set(Margin.class, (double)0.1);
model.set(ZoomFactor.class, (double)3.0);

// paint the background
Graphics2D g2 = (Graphics2D)image.getGraphics();
g2.setColor(Color.WHITE);
g2.fillRect(0, 0, WIDTH, HEIGHT);
// the paint method also needs a toolkit-specific renderer
renderer.paint(cyclopropane, new AWTDrawVisitor(g2));
ImageIO.write(
  (RenderedImage)image, "PNG",
  new File("RenderCyclopropane.png")
);
