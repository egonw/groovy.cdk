import org.openscience.cdk.interfaces.*;
import org.openscience.cdk.*;
import org.openscience.cdk.inchi.*;
import org.openscience.cdk.smiles.*;
import net.sf.jniinchi.INCHI_RET;

InChIToStructure parser = new InChIToStructure(
  "InChI=1S/",
  DefaultChemObjectBuilder.getInstance()
);
IAtomContainer container = parser.getAtomContainer();
INCHI_RET returnStatus = parser.getReturnStatus();
print returnStatus
