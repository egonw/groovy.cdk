import org.openscience.cdk.silent.*;
import org.openscience.cdk.interfaces.*;
import org.openscience.cdk.qsar.descriptors.molecular.*;

atom1 = new Atom("C")
atom2 = new Atom("C")
atom3 = new Atom("O")
bond1 = new Bond(atom1, atom2, IBond.Order.SINGLE);
bond2 = new Bond(atom2, atom3, IBond.Order.SINGLE);

ethanol = new AtomContainer();
ethanol.addAtom(atom1);
ethanol.addAtom(atom2);
ethanol.addAtom(atom3);
ethanol.addBond(bond1);
ethanol.addBond(bond2);
descriptor = new AtomCountDescriptor()
Object[] params = [ "N" ]
descriptor.setParameters(params)
calculated = descriptor.calculate(ethanol)
nitrogenCount = calculated.value
label = calculated.names[0]
println "Number of nitrogens ($label): $nitrogenCount"
params = [ "O" ]
descriptor.setParameters(params)
calculated = descriptor.calculate(ethanol)
oxygenCount = calculated.value
label = calculated.names[0]
println "Number of oxygens ($label): $oxygenCount"
