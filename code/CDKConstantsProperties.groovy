 import org.openscience.cdk.*;

aspirin = new AtomContainer()
aspirin.setProperty(CDKConstants.TITLE, "aspirin")
aspirin.setProperty(CDKConstants.INCHI, "InChI=1/C9H8O4/c1-6(10)13-8-5-3-2-4-7(8)9(11)12/h2-5H,1H3,(H,11,12)")
aspirin.setProperty(CDKConstants.SMILES, "CC(=O)Oc1ccccc1C(=O)O")
aspirin.setProperty(CDKConstants.CASRN, "50-78-2")
aspirin.setProperty(CDKConstants.COMMENT, "Against headaches.")
aspirin.setProperty(CDKConstants.NAMES, "2-(acetyloxy)benzoic acid")

println "Title: " + 
  aspirin.getProperty(CDKConstants.TITLE)
println "InChI: " +
  aspirin.getProperty(CDKConstants.INCHI)
println "SMILES: " +
  aspirin.getProperty(CDKConstants.SMILES)
println "CAS registry number: " +
  aspirin.getProperty(CDKConstants.CASRN)
println "COMMENT: " +
  aspirin.getProperty(CDKConstants.COMMENT)
println "NAMES: " +
  aspirin.getProperty(CDKConstants.NAMES)
