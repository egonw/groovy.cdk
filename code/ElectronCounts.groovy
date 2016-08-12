import org.openscience.cdk.interfaces.*;
import org.openscience.cdk.*;

IBond.Order.each { order ->
  bond = new Bond(
    new Atom("C"), new Atom("C"),
    order
  )
  println "Bond order $order has " +
    bond.electronCount + " electrons"
}
