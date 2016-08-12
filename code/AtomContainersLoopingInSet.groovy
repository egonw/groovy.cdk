import org.openscience.cdk.silent.*;
import org.openscience.cdk.*;
set = new AtomContainerSet()
anAtomContainer = new AtomContainer()
anotherAtomContainer = new AtomContainer()
set.addAtomContainer(anAtomContainer)
set.addAtomContainer(anotherAtomContainer)
println "Number of containers: " + 
  set.getAtomContainerCount()
for (atomContainer in set.atomContainers()) {
  println "container's hashcode " +
    atomContainer.hashCode()
}
