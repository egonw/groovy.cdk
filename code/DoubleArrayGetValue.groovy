import org.openscience.cdk.*;
import org.openscience.cdk.io.*;
import org.openscience.cdk.templates.*;
import org.openscience.cdk.tools.*;
import org.openscience.cdk.tools.manipulator.*;
import org.openscience.cdk.qsar.descriptors.molecular.*;
import org.openscience.cdk.qsar.result.*;

reader = new XYZReader(
  new FileReader(new File("data/methane.xyz"))
);

// convert the file
ChemFile content = (ChemFile)reader.read(new ChemFile());
containers = ChemFileManipulator.getAllAtomContainers(content)
methane = containers.get(0)

descriptor = new MomentOfInertiaDescriptor()
value = descriptor.calculate(methane).value
for (i in 0..(value.length()-1)) {
  println i + " " + value.get(i)
}
