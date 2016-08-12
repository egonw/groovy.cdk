 import org.openscience.cdk.silent.*;
 import org.openscience.cdk.isomorphism.*;
 import org.openscience.cdk.interfaces.*;

cyclopropane = new AtomContainer()
for (i in 1..3) cyclopropane.addAtom(new Atom("C"))
cyclopropane.addBond(0,1,IBond.Order.SINGLE);
cyclopropane.addBond(1,2,IBond.Order.SINGLE);
cyclopropane.addBond(0,2,IBond.Order.SINGLE);
isobutane = new AtomContainer()
for (i in 1..4) isobutane.addAtom(new Atom("C"))
isobutane.addBond(0,1,IBond.Order.SINGLE);
isobutane.addBond(0,2,IBond.Order.SINGLE);
isobutane.addBond(0,3,IBond.Order.SINGLE);

isomorphismTester = new UniversalIsomorphismTester()
println "Cyclopropane part of isobutane: " +
  isomorphismTester.isSubgraph(
    isobutane, cyclopropane
  )
println "Isobutane part of cyclopropane: " +
  isomorphismTester.isSubgraph(
    cyclopropane, isobutane
  )
