import org.openscience.cdk.interfaces.*;
import org.openscience.cdk.*;
import org.openscience.cdk.inchi.*;
import org.openscience.cdk.smiles.*;
import net.sf.jniinchi.INCHI_RET;

InChIToStructure parser = new InChIToStructure(
  "InChI=1/CH2O2/c2-1-3/h1H,(H,2,3)/f/h2H",
  DefaultChemObjectBuilder.getInstance()
);
IAtomContainer container = parser.getAtomContainer();
SmilesGenerator smilesGen = new SmilesGenerator();
println smilesGen.createSMILES(container);
