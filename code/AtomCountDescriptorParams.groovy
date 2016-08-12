import org.openscience.cdk.qsar.descriptors.molecular.*;

descriptor = new AtomCountDescriptor()
descriptor.parameterNames.each { name ->
  type = descriptor.getParameterType(name).class.name
  println "$name -> $type"
}
