import org.openscience.cdk.silent.*;
import org.openscience.cdk.*;
set = new AtomContainerSet()
println "This set has $set.atomContainerCount containers"
anAtomContainer = new AtomContainer()
anotherAtomContainer = new AtomContainer()
set.addAtomContainer(anAtomContainer)
set.addAtomContainer(anotherAtomContainer)
println "Now it has $set.atomContainerCount containers"
