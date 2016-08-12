import java.io.*;
import org.openscience.cdk.io.*;
import org.openscience.cdk.io.formats.*;

FormatFactory factory = new FormatFactory();
Reader stringReader = new StringReader(
  "<molecule xmlns='http://www.xml-cml.org/schema'/>"
);
IChemFormat format = factory.guessFormat(stringReader);
String readerClass = format.getReaderClassName();
String writerClass = format.getWriterClassName();
System.out.println("Reader: " + readerClass);
System.out.println("Writer: " + writerClass);
