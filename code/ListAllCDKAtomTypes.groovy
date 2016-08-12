import org.openscience.cdk.interfaces.*;
import org.openscience.cdk.config.*;
import org.openscience.cdk.nonotify.*;
import org.openscience.cdk.*;
import java.util.Arrays;

factory = AtomTypeFactory.getInstance(
  "org/openscience/cdk/dict/data/cdk-atom-types.owl",
  NoNotificationChemObjectBuilder.getInstance()
);
output = new File("../atomtypelist.tex")
output.text = ""

IAtomType[] types = factory.getAllAtomTypes();
Arrays.sort(types, new Comparator<IAtomType>() {
  public int compare(IAtomType type1, IAtomType type2) {
    return type1.getSymbol().compareTo(type2.getSymbol())
  }
});
for (IAtomType type : types) {
  lonepairs = type.getProperty(
    CDKConstants.LONE_PAIR_COUNT
  )
  output.append(
    type.atomTypeName + " & " +
    type.symbol + " & " +
    type.formalCharge + " & " +
    type.formalNeighbourCount + " & " +
    (type.hybridization == null
      ? ""
      : type.hybridization) + " & " +
    (lonepairs == null
      ? ""
      : lonepairs) + " & " +
    type.getProperty(
      CDKConstants.PI_BOND_COUNT
    ) + "\\\\\n")
}
