import org.openscience.cdk.qsar.descriptors.molecular.*;

descriptor = new AromaticAtomsCountDescriptor()
println "Descriptor names:"
descriptor.parameterNames.each { name ->
  type = descriptor.getParameterType(name).class.name
  println "$name -> $type"
}
println ""
println "Values:"
descriptor.parameters.each { param ->
  type = param.class.name
  println "$type -> $param"
}
println ""
println "Updating the value..."
Object[] newValues = [ Boolean.TRUE ]
descriptor.setParameters(newValues)
println ""
println "New values:"
descriptor.parameters.each { param ->
  type = param.class.name
  println "$type -> $param"
}
