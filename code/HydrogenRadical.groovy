import org.openscience.cdk.interfaces.*
import org.openscience.cdk.*;

hydrogen = new Atom("H")
radicalElectron =
  new SingleElectron(hydrogen)
hydrogenRadical = new Molecule()
hydrogenRadical.addAtom(hydrogen)
hydrogenRadical.addSingleElectron(radicalElectron)
