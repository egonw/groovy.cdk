 import org.openscience.cdk.tools.*;
crambin = ProteinBuilderTool.createProtein(
  "TTCCPSIVARSNFNVCRLPGTPEA" +
  "ICATYTGCIIIPGATCPGDYAN"
);
println "Crambin has " + crambin.atomCount +
  " atoms."
