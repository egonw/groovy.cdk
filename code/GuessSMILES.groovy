import java.io.*;
import org.openscience.cdk.io.*;
import org.openscience.cdk.io.formats.*;

Reader stringReader = new StringReader(
  "O=CN formamide\n" +
  "OCC ethanol\n"
);
FormatFactory factory = new FormatFactory();
factory.registerFormat(SMILESFormatMatcher.getInstance());
IChemFormat format = factory.guessFormat(stringReader);
System.out.println("Format: " + format.getFormatName());
