import org.openscience.cdk.config.*;

isofac = Isotopes.getInstance();
isotopes = isofac.getIsotopes("H");
majorIsotope = isofac.getMajorIsotope("H")
for (isotope in isotopes) {
  print "${isotope.massNumber}${isotope.symbol}: " +
    "${isotope.exactMass} ${isotope.naturalAbundance}%"
  if (majorIsotope.massNumber == isotope.massNumber)
    print " (major isotope)"
  println ""
}
