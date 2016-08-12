import org.openscience.cdk.io.*;
import org.openscience.cdk.io.formats.*;
import org.openscience.cdk.interfaces.*;
import org.openscience.cdk.isomorphism.matchers.RGroupQuery;
import org.openscience.cdk.*;
import org.openscience.cdk.*;
import java.util.*;
import java.lang.reflect.Method;

output = new File("../ioclasseslist.tex")
output.text = ""

classes = [ ChemFile.class, AtomContainer.class ]
optional = [ ChemSequence.class, Reaction.class, ReactionSet.class, RGroupQuery.class,
             Crystal.class]

formats = new ArrayList<IChemFormat>();
reader =
  this.getClass().getClassLoader().getResourceAsStream(
    "io-formats.set"
  )
reader.eachLine { formatName ->
  try {
    Class<? extends Object> formatClass =
      this.getClass().getClassLoader().loadClass(formatName);
    Method getinstanceMethod =
      formatClass.getMethod("getInstance", new Class[0]);
    format = getinstanceMethod.invoke(null, new Object[0]);
    formats.add(format);
  } catch (ClassNotFoundException exception) {
  } catch (Exception exception) {
  }
}
formats.sort{ it.formatName }

for (format in formats) {
  if (format instanceof IChemFormat &&
      (format.getReaderClassName() != null ||
       format.getWriterClassName() != null)) {
    output.append(
      "\\subsection{" + format.formatName + "}\n\n"
    )
   output.append("\\index{" + format.formatName + "}\n")
    // output some further format details
   output.append("\\begin{description}[noitemsep]\n")
   if (format.nameExtensions.length > 1)
     output.append(" \\item[Extensions] " + format.nameExtensions + "\n")
   if (format.preferredNameExtension != null)
     output.append(" \\item[Preferred Extension] " + format.preferredNameExtension + "\n")
   if (format.getMIMEType() != null)
     output.append(" \\item[MIME type] " + format.getMIMEType() + "\n")
   output.append(" \\item[XML Based?] " + (format.isXMLBased() ? "Yes" : "No") + "\n")
   output.append("\\end{description}\n")
    if (format.readerClassName != null) {
      reader = format.readerClassName.substring(
        format.readerClassName.lastIndexOf(".") + 1
      )
      output.append(
        "\\subsection*{" + reader + "}\n"
      )
     output.append("\\index{" + reader + "}\n")
     ioClass = Class.forName(format.readerClassName).newInstance()
     output.append("This reader supports these data objects:\n")
     output.append("\\begin{small}\n")
     output.append("\\begin{longtable}{p{3.0in}p{1.0in}}\n")
     output.append("\\textbf{Class} & \\textbf{Accepted} \\\\\n")
     output.append("\\endfirsthead\n")
     for (clazz in classes) {
       clazzName = clazz.name.substring(clazz.name.indexOf("cdk.")+4)
       output.append(
         clazzName + " & " +
         ioClass.accepts(clazz) +
         "\\\\\n"
       )
     }
     for (clazz in optional) {
       clazzName = clazz.name.substring(clazz.name.indexOf("cdk.")+4)
       if (ioClass.accepts(clazz))
         output.append(clazzName + " & true \\\\\n")
     }
     output.append("\\end{longtable}\n")
     output.append("\\end{small}\n")
     settings = ioClass.getIOSettings()
     if (settings != null && settings.length > 0) {
       output.append("This reader has these IO settings:\n")
       output.append("\\begin{small}\n")
       output.append("\\begin{longtable}{p{1.8in}p{2.2in}}\n")
       output.append("\\textbf{Name} & \\textbf{Description} \\\\\n")
       output.append("\\endfirsthead\n")
       for (setting in settings) {
         if (setting == null) {
           output.append(" & \\\\\n")
         } else {
           output.append((setting.name != null ? setting.name : "") + " & ")
           output.append((setting.question != null ? setting.question : ""))
           output.append((setting.defaultSetting != null ? " [Default: " + setting.defaultSetting + "]" : ""))
           output.append(" \\\\\n")
         }
       }
       output.append("\\end{longtable}\n")
       output.append("\\end{small}\n")
     }
    }
    if (format.writerClassName != null) {
      writer = format.writerClassName.substring(
        format.writerClassName.lastIndexOf(".") + 1
      )
      output.append(
        "\\subsection*{" + writer + "}\n"
      )
     output.append("\\index{" + writer + "}\n")
     ioClass = Class.forName(format.writerClassName).newInstance()
     output.append("This writer support these data objects:\n")
     output.append("\\begin{small}\n")
     output.append("\\begin{longtable}{p{3.0in}p{1.0in}}\n")
     output.append("\\textbf{Class} & \\textbf{Accepted} \\\\\n")
     output.append("\\endfirsthead\n")
     for (clazz in classes) {
       clazzName = clazz.name.substring(clazz.name.indexOf("cdk.")+4)
       output.append(
         clazzName + " & " +
         ioClass.accepts(clazz) +
         "\\\\\n"
       )
     }
     for (clazz in optional) {
       clazzName = clazz.name.substring(clazz.name.indexOf("cdk.")+4)
       if (ioClass.accepts(clazz))
         output.append(clazzName + " & true \\\\\n")
     }
     output.append("\\end{longtable}\n")
     output.append("\\end{small}\n")
     settings = ioClass.getIOSettings()
     if (settings != null && settings.length > 0) {
       output.append("This writer has these IO settings:\n")
       output.append("\\begin{small}\n")
       output.append("\\begin{longtable}{p{1.8in}p{2.2in}}\n")
       output.append("\\textbf{Name} & \\textbf{Description} \\\\\n")
       output.append("\\endfirsthead\n")
       for (setting in settings) {
         if (setting == null) {
           output.append(" & \\\\\n")
         } else {
           output.append((setting.name != null ? setting.name : "") + " & ")
           output.append((setting.question != null ? setting.question : ""))
           output.append((setting.defaultSetting != null ? " [Default: " + setting.defaultSetting + "]" : ""))
           output.append(" \\\\\n")
         }
       }
       output.append("\\end{longtable}\n")
       output.append("\\end{small}\n")
     }
    }
  }
}
