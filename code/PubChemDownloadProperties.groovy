import java.net.UnknownHostException;
import org.openscience.cdk.*
import org.openscience.cdk.io.*
import org.openscience.cdk.nonotify.*


cid = 5282253
try {
reader = new PCCompoundXMLReader(
  new URL(
    "http://pubchem.ncbi.nlm.nih.gov/summary/summary.cgi?cid=$cid&disopt=SaveXML"
  ).newInputStream()
)
mol = reader.read(new NNMolecule())
mol.properties.each {
  line = "" + it
 line = line.replaceAll("\\\\", "\\\\textbackslash")
  println line
}
} catch (UnknownHostException exception) {
  println "FIXME: compile without internet connection"
}
