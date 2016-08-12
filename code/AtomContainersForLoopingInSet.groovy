import org.openscience.cdk.silent.*;
import org.openscience.cdk.*;
set = new AtomContainerSet()
anAtomContainer = new AtomContainer()
anotherAtomContainer = new AtomContainer()
set.addAtomContainer(anAtomContainer)
set.addAtomContainer(anotherAtomContainer)
println "Number of containers: " +
  set.getAtomContainerCount()
for (i=0; i<set.getAtomContainerCount(); i++) {
  println "container $i has hashcode " +
    set.getAtomContainer(i).hashCode()
}
