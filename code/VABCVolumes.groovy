import org.openscience.cdk.*;
import org.openscience.cdk.interfaces.*;
import org.openscience.cdk.smiles.*;
import org.openscience.cdk.geometry.volume.*;
import org.openscience.cdk.tools.manipulator.*;
import org.openscience.cdk.silent.*;

smilesParser = new SmilesParser(
  SilentChemObjectBuilder.getInstance()
);
methane = smilesParser.parseSmiles("C");
AtomContainerManipulator.percieveAtomTypesAndConfigureAtoms(methane)
println "Methane volume = " +
  VABCVolume.calculate(methane);
ethane = smilesParser.parseSmiles("CC");
AtomContainerManipulator.percieveAtomTypesAndConfigureAtoms(ethane)
println "Ethane volume = " +
  VABCVolume.calculate(ethane);
