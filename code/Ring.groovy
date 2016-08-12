import org.openscience.cdk.interfaces.IRing;
import org.openscience.cdk.*;

IRing ring = DefaultChemObjectBuilder.getInstance().newInstance(IRing.class, 5, "C")
println "Ring size: " + ring.getRingSize()
println "Ring atoms: " + ring.getAtomCount()
println "Ring bonds: " + ring.getBondCount()
