import org.openscience.cdk.interfaces.*;
import org.openscience.cdk.config.*;
import org.openscience.cdk.silent.*;
import org.openscience.cdk.*;
import java.util.Arrays;

isofac = Isotopes.getInstance();
output = new File("../isotopelist.tex")
output.text = ""

maxAtomicNumber = 150;
for (atomicNumber in 1..maxAtomicNumber) {
  element = isofac.getElement(atomicNumber)
 if (element != null) {
  isotopes = isofac.getIsotopes(element.symbol)
 firstIsotope = true
  for (isotope in isotopes) {
    if (isotope.naturalAbundance > 0.1) {
     if (firstIsotope) {
      output.append(
        atomicNumber + " & " +
        element.symbol + " & "
      )
     } else {
       output.append(" & & ")
     }
      output.append(
        isotope.massNumber + " & " +
        isotope.naturalAbundance + " & " +
        isotope.exactMass + "\\\\\n"
      )
   firstIsotope = false
    }
  }
 }
}
