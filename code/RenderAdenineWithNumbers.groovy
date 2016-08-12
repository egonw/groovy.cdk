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




int WIDTH = 220;
int HEIGHT = 220;

  IChemObjectBuilder builder = DefaultChemObjectBuilder.getInstance();
  IMolecule mol = builder.newInstance(IMolecule.class);
  IAtom a1 = builder.newInstance(IAtom.class,"N");
  a1.setFormalCharge(0);
  a1.setPoint2d(new Point2d(4.6783, 0.1497));
  a1.setProperty("AtomNumber", "1");
  mol.addAtom(a1);
  IAtom a2 = builder.newInstance(IAtom.class,"N");
  a2.setFormalCharge(0);
  a2.setPoint2d(new Point2d(4.6783, -1.4597));
  a2.setProperty("AtomNumber", "2");
  mol.addAtom(a2);
  IAtom a3 = builder.newInstance(IAtom.class,"N");
  a3.setFormalCharge(0);
  a3.setPoint2d(new Point2d(2.866, -1.655));
  a3.setProperty("AtomNumber", "3");
  mol.addAtom(a3);
  IAtom a4 = builder.newInstance(IAtom.class,"N");
  a4.setFormalCharge(0);
  a4.setPoint2d(new Point2d(2.0, -0.155));
  a4.setProperty("AtomNumber", "4");
  mol.addAtom(a4);
  IAtom a5 = builder.newInstance(IAtom.class,"N");
  a5.setFormalCharge(0);
  a5.setPoint2d(new Point2d(2.866, 1.345));
  a5.setProperty("AtomNumber", "5");
  mol.addAtom(a5);
  IAtom a6 = builder.newInstance(IAtom.class,"C");
  a6.setFormalCharge(0);
  a6.setPoint2d(new Point2d(3.732, -0.155));
  a6.setProperty("AtomNumber", "6");
  mol.addAtom(a6);
  IAtom a7 = builder.newInstance(IAtom.class,"C");
  a7.setFormalCharge(0);
  a7.setPoint2d(new Point2d(3.732, -1.155));
  a7.setProperty("AtomNumber", "7");
  mol.addAtom(a7);
  IAtom a8 = builder.newInstance(IAtom.class,"C");
  a8.setFormalCharge(0);
  a8.setPoint2d(new Point2d(2.866, 0.345));
  a8.setProperty("AtomNumber", "8");
  mol.addAtom(a8);
  IAtom a9 = builder.newInstance(IAtom.class,"C");
  a9.setFormalCharge(0);
  a9.setPoint2d(new Point2d(5.2619, -0.655));
  a9.setProperty("AtomNumber", "9");
  mol.addAtom(a9);
  IAtom a10 = builder.newInstance(IAtom.class,"C");
  a10.setFormalCharge(0);
  a10.setPoint2d(new Point2d(2.0, -1.155));
  a10.setProperty("AtomNumber", "10");
  mol.addAtom(a10);
  IBond b1 = builder.newInstance(IBond.class,a1, a6, IBond.Order.SINGLE);
  mol.addBond(b1);
  IBond b2 = builder.newInstance(IBond.class,a1, a9, IBond.Order.SINGLE);
  mol.addBond(b2);
  IBond b4 = builder.newInstance(IBond.class,a2, a7, IBond.Order.SINGLE);
  mol.addBond(b4);
  IBond b5 = builder.newInstance(IBond.class,a2, a9, IBond.Order.DOUBLE);
  mol.addBond(b5);
  IBond b6 = builder.newInstance(IBond.class,a3, a7, IBond.Order.DOUBLE);
  mol.addBond(b6);
  IBond b7 = builder.newInstance(IBond.class,a3, a10, IBond.Order.SINGLE);
  mol.addBond(b7);
  IBond b8 = builder.newInstance(IBond.class,a4, a8, IBond.Order.SINGLE);
  mol.addBond(b8);
  IBond b9 = builder.newInstance(IBond.class,a4, a10, IBond.Order.DOUBLE);
  mol.addBond(b9);
  IBond b10 = builder.newInstance(IBond.class,a5, a8, IBond.Order.SINGLE);
  mol.addBond(b10);
  IBond b13 = builder.newInstance(IBond.class,a6, a7, IBond.Order.SINGLE);
  mol.addBond(b13);
  IBond b14 = builder.newInstance(IBond.class,a6, a8, IBond.Order.DOUBLE);
  mol.addBond(b14);
  adenine = mol

// the draw area and the image should be the same size
Rectangle drawArea = new Rectangle(WIDTH, HEIGHT);
Image image = new BufferedImage(
  WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB
);

StructureDiagramGenerator sdg = new StructureDiagramGenerator();
sdg.setMolecule(adenine);
sdg.generateCoordinates();
adenine = sdg.getMolecule();

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
renderer.setup(adenine, drawArea);

model = renderer.getRenderer2DModel();
model.set(Margin.class, (double)0.1);

// paint the background
Graphics2D g2 = (Graphics2D)image.getGraphics();
g2.setColor(Color.WHITE);
g2.fillRect(0, 0, WIDTH, HEIGHT);

// the paint method also needs a toolkit-specific renderer
renderer.paint(adenine, new AWTDrawVisitor(g2));

ImageIO.write(
  (RenderedImage)image, "PNG",
  new File("RenderAdenineWithNumbers.png")
);
