import org.openscience.cdk.qsar.descriptors.molecular.*;

descriptor = new TPSADescriptor()
specs = descriptor.specification
println "Title: " + specs.implementationTitle
println "Reference: " + specs.specificationReference
println "Vendor: " + specs.implementationVendor
println "Identifier: " + specs.implementationIdentifier
