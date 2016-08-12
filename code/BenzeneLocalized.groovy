import org.openscience.cdk.*;
import org.openscience.cdk.depict.*;
import org.openscience.cdk.interfaces.*;
import org.openscience.cdk.templates.*;
IAtomContainer benzene = MoleculeFactory.makeBenzene();
benzene.atoms().each { atom ->
  atom.setFlag(CDKConstants.ISAROMATIC, true)
}
benzene.bonds().each { bond ->
  bond.setFlag(CDKConstants.ISAROMATIC, true)
}

new DepictionGenerator()
  .withSize(600, 600)
  .depict(benzene)
  .writeTo("BenzeneLocalized.png");
