import org.openscience.cdk.qsar.*;
import org.openscience.cdk.*;
import java.util.Arrays;

output = new File("../moldescriptorlist.tex")
output.text = ""
qsarDescriptors = this.getClass().getClassLoader()
 .getResourceAsStream("qsar-descriptors.set").text
List<String> descriptorClasses = new ArrayList<String>()
qsarDescriptors.eachLine { line ->
  if (line.contains("descriptors.molecular"))
    descriptorClasses.add(line)
}
DescriptorEngine engine =
  new DescriptorEngine(
    descriptorClasses,
    DefaultChemObjectBuilder.getInstance()
  );
List<IDescriptor> instances =
  engine.getDescriptorInstances()
instances.sort{ it.specification.implementationTitle }
println "Descriptor count: " + instances.size()
for (IDescriptor descriptor : instances) {
  specification = descriptor.specification
  implementationTitle = specification.implementationTitle
 implementationTitle = implementationTitle.substring(
   implementationTitle.lastIndexOf('.') + 1
 )
  output.append(
    implementationTitle + " & "
  )
  descriptor.descriptorNames.each { name ->
    output.append(name + " ")
  }
  output.append("\\\\\n")
}
