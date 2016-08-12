import org.openscience.cdk.interfaces.*;
import org.openscience.cdk.*;
methanol = new AtomContainer();
dimethoxymethane = new AtomContainer();
water = new AtomContainer();
acid = new AtomContainer();
reaction = new Reaction()
reaction.addReactant(methanol, (double)2.0)
reaction.setDirection(IReaction.Direction.FORWARD)
reaction.addAgent(acid)
reaction.addProduct(dimethoxymethane)
reaction.addProduct(water)
