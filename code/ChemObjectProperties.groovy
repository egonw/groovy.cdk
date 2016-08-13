 import org.openscience.cdk.*;

butane = new AtomContainer();
butane.setProperty(
  "InChI", "InChI=1/C4H10/c1-3-4-2/h3-4H2,1-2H3"
)
print "InChI: " + butane.getProperty("InChI")
