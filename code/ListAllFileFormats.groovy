import org.openscience.cdk.io.*;
import org.openscience.cdk.io.formats.*;
import org.openscience.cdk.*;
import java.util.*;
import java.lang.reflect.Method;

output = new File("../fileformatlist.tex")
output.text = ""
formats = new ArrayList<IChemFormat>();
reader =
  this.getClass().getClassLoader().getResourceAsStream(
    "io-formats.set"
  )
reader.eachLine { formatName ->
  try {
    Class<? extends Object> formatClass =
      this.getClass().getClassLoader().
        loadClass(formatName);
    Method getinstanceMethod =
      formatClass.getMethod(
        "getInstance", new Class[0]
      );
    format = getinstanceMethod.invoke(
      null, new Object[0]
    );
    formats.add(format);
  } catch (ClassNotFoundException exception) {
  } catch (Exception exception) {
  }
}
formats.sort{ it.formatName }
for (format in formats) {
  if (format instanceof IChemFormat &&
      format.getReaderClassName() != null) {
    output.append("R");
  } else {
    output.append(" ");
  }
  if (format instanceof IChemFormat &&
      format.getWriterClassName() != null) {
    output.append("W");
  } else {
    output.append(" "); 
  }
  output.append(" & ");
  if (format instanceof IChemFormatMatcher) {
    output.append("M");
  }
  output.append(" & ");
  output.append(format.getFormatName())
  output.append("\\\\\n")
}
