import java.util.List;
import java.awt.*;
import java.awt.image.*;
import javax.imageio.*;
import javax.vecmath.*;
import org.openscience.cdk.silent.*;
import org.openscience.cdk.geometry.*;
import org.openscience.cdk.interfaces.*;
import org.openscience.cdk.io.*;
import org.openscience.cdk.layout.*;
import org.openscience.cdk.renderer.*;
import org.openscience.cdk.renderer.font.*;
import org.openscience.cdk.renderer.generators.*;
import org.openscience.cdk.renderer.visitor.*;
import org.openscience.cdk.templates.*;




int WIDTH = 1200;
int HEIGHT = 400;

// the draw area and the image should be the same size
Rectangle drawArea = new Rectangle(WIDTH, HEIGHT);
Image image = new BufferedImage(
  WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB
);

MDLRXNReader reader = new MDLRXNReader(
  new File("data/anie.201203222.rxn").newReader()
);
IReaction reaction = new Reaction();
reaction = reader.read(reaction);
reader.close();
// generators make the image elements
List<IGenerator> generators =
  new ArrayList<IGenerator>();
generators.add(new BasicSceneGenerator());
generators.add(new BasicBondGenerator());
generators.add(new BasicAtomGenerator());
List<IGenerator<IReaction>> reactiongenerators =
  new ArrayList<IGenerator<IReaction>>();
reactiongenerators.add(new ReactionSceneGenerator());
reactiongenerators.add(new ReactionArrowGenerator());
reactiongenerators.add(new ReactionPlusGenerator());
ReactionRenderer renderer = new ReactionRenderer(
  generators, reactiongenerators, new AWTFontManager()
);
renderer.setup(reaction, drawArea);
Graphics2D g2 = (Graphics2D)image.getGraphics();
g2.setColor(Color.WHITE);
g2.fillRect(0, 0, WIDTH, HEIGHT);
renderer.paint(reaction, new ExtraAWTDrawVisitor(g2));
ImageIO.write(
  (RenderedImage)image, "PNG", new File("RenderReaction.png")
);
