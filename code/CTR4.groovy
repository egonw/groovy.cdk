import org.openscience.cdk.io.*;
import org.openscience.cdk.io.iterator.*;
import org.openscience.cdk.silent.*;
import java.util.zip.GZIPInputStream;

iterator = new IteratingSDFReader(
  new GZIPInputStream(
    new File("ctr/benzodiazepine.sdf.gz")
      .newInputStream()
  ),
  SilentChemObjectBuilder.getInstance()
)
writer = new SDFWriter(
  new FileWriter("ctr/ctr4.sdf")
)
while (iterator.hasNext()) {
  mol = iterator.next()
  if (mol.getProperty("PUBCHEM_XLOGP3") == null) {
    mol.setProperty("RULE5", "no logP")
  } else {
    ruleCount = 0;
    if (Integer.valueOf(
          mol.getProperty(
            "PUBCHEM_CACTVS_HBOND_ACCEPTOR"
          )
        ) <= 10) ruleCount++
    if (Integer.valueOf(
          mol.getProperty(
            "PUBCHEM_CACTVS_HBOND_DONOR"
          )
       ) <= 5) ruleCount++
    if (Double.valueOf(
          mol.getProperty(
            "PUBCHEM_MOLECULAR_WEIGHT"
          )
       ) <= 500.0) ruleCount++
    if (Double.valueOf(
          mol.getProperty(
            "PUBCHEM_XLOGP3"
          )
        ) <= 5.0) ruleCount++
    mol.setProperty("RULE5", ruleCount >= 3  ? "1" : "0")
    writer.write(mol)
  }
}
writer.close()
