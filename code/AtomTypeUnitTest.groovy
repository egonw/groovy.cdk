import java.net.UnknownHostException;
import org.openscience.cdk.silent.*;
import org.openscience.cdk.io.*;
import org.openscience.cdk.io.listener.*;


cid = 3396560

if (args.length == 1) cid = args[0]

try {
reader = new PCCompoundXMLReader(
  new URL(
    "http://pubchem.ncbi.nlm.nih.gov/summary/" +
    "summary.cgi?cid=$cid&disopt=SaveXML"
  ).newInputStream()
)
mol = reader.read(new AtomContainer())
stringWriter = new StringWriter();
CDKSourceCodeWriter writer =
  new CDKSourceCodeWriter(stringWriter);
customSettings = new Properties();
customSettings.setProperty("write2DCoordinates", "false");
customSettings.setProperty("write3DCoordinates", "false");
writer.addChemObjectIOListener(
  new PropertiesListener(
    customSettings
  )
)
writer.write(mol);
writer.close();
println stringWriter.toString();
} catch (UnknownHostException exception) {
  println "FIXME: compiled without internet connection"
}
