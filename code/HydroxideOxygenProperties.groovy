import org.openscience.cdk.interfaces.*;
import org.openscience.cdk.config.*;
import org.openscience.cdk.nonotify.*;
import org.openscience.cdk.*;

factory = AtomTypeFactory.getInstance(
  "org/openscience/cdk/dict/data/cdk-atom-types.owl",
  NoNotificationChemObjectBuilder.getInstance()
);
IAtomType type = factory.getAtomType("O.minus");
println "element       : $type.symbol"
println "formal change : $type.formalCharge"
println "hybridization : $type.hybridization"
println "neighbors     : $type.formalNeighbourCount"
println "lone pairs    : " +
  type.getProperty(CDKConstants.LONE_PAIR_COUNT)
println "pi bonds      : " +
  type.getProperty(CDKConstants.PI_BOND_COUNT)
