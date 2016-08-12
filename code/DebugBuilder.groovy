import org.openscience.cdk.interfaces.*;
import org.openscience.cdk.debug.*;
import org.openscience.cdk.tools.*;

System.setProperty("cdk.debugging", "true");
System.getProperty("cdk.debug.stdout", "true");
LoggingToolFactory.setLoggingToolClass(
  SystemOutLoggingTool.class
);

IChemObjectBuilder builder =
  DebugChemObjectBuilder.getInstance();
IAtom atom1 = builder.newInstance(IAtom.class, "C");
IAtom atom2 = builder.newInstance(IAtom.class, "C");
molecule = builder.newInstance(IAtomContainer.class);
molecule.addAtom(atom1);
molecule.addAtom(atom2);
molecule.addBond(builder.newInstance(
  IBond.class, atom1, atom2, IBond.Order.SINGLE
));
