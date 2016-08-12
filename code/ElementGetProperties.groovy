import org.openscience.cdk.interfaces.*;
import org.openscience.cdk.*;
import org.openscience.cdk.config.Elements;

IAtom atom = new Atom(Elements.CARBON);
println "Symbol: " + atom.getSymbol()
println "Atomic number: " + atom.getAtomicNumber()
