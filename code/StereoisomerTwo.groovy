import java.util.List;
import java.awt.*;
import java.awt.image.*;
import javax.imageio.*;
import javax.vecmath.*;
import org.openscience.cdk.*;
import org.openscience.cdk.interfaces.*;
import org.openscience.cdk.interfaces.IBond.Order;
import org.openscience.cdk.interfaces.IBond.Stereo;
import org.openscience.cdk.renderer.*;
import org.openscience.cdk.renderer.font.*;
import org.openscience.cdk.renderer.generators.*;
import org.openscience.cdk.renderer.visitor.*;
import org.openscience.cdk.renderer.generators.BasicSceneGenerator.Margin;
import org.openscience.cdk.renderer.generators.BasicSceneGenerator.ZoomFactor;




int WIDTH = 600;
int HEIGHT = 600;

// the draw area and the image should be the same size
Rectangle drawArea = new Rectangle(WIDTH, HEIGHT);
Image image = new BufferedImage(
  WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB
);

isomer = new AtomContainer()
isomer.addAtom(new Atom("C"));
 isomer.getAtom(0).setPoint2d(new Point2d(0,0));
isomer.addAtom(new Atom("Cl"));
 isomer.getAtom(1).setPoint2d(new Point2d(0,1.5));
isomer.addAtom(new Atom("F"));
 isomer.getAtom(2).setPoint2d(new Point2d(1.5,0));
isomer.addAtom(new Atom("Br"));
 isomer.getAtom(3).setPoint2d(new Point2d(-1.5,0));
isomer.addAtom(new Atom("I"));
 isomer.getAtom(4).setPoint2d(new Point2d(0,-1.5));
isomer.addBond(0,1,Order.SINGLE)
isomer.addBond(0,2,Order.SINGLE)
isomer.getBond(1).setStereo(Stereo.UP)
isomer.addBond(0,3,Order.SINGLE)
isomer.getBond(2).setStereo(Stereo.UP)
isomer.addBond(0,4,Order.SINGLE)

// generators make the image elements
List<IGenerator> generators =
  new ArrayList<IGenerator>();
generators.add(new BasicSceneGenerator());
generators.add(new BasicBondGenerator());
generators.add(new BasicAtomGenerator());

// the renderer needs to have a toolkit-specific
// font manager
AtomContainerRenderer renderer =
  new AtomContainerRenderer(
    generators, new AWTFontManager()
  );

// the call to 'setup' only needs to be done on
// the first paint
renderer.setup(isomer, drawArea);

model = renderer.getRenderer2DModel();
model.set(Margin.class, (double)0.1);
model.set(ZoomFactor.class, (double)3.0);

// paint the background
Graphics2D g2 = (Graphics2D)image.getGraphics();
g2.setColor(Color.WHITE);
g2.fillRect(0, 0, WIDTH, HEIGHT);

// the paint method also needs a
// toolkit-specific renderer
renderer.paint(isomer, new AWTDrawVisitor(g2));

ImageIO.write(
  (RenderedImage)image, "PNG",
  new File("StereoisomerTwo.png")
);
