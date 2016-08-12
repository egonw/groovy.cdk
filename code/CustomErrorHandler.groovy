import org.openscience.cdk.interfaces.*;
import org.openscience.cdk.io.*;
import org.openscience.cdk.*;

class ErrorHandler
implements IChemObjectReaderErrorHandler {
  public void handleError(String message) {
    println message;
  };
  public void handleError(String message,
    Exception exception)
  {
    println message + "\n  -> " +
            exception.getMessage();
  };
  public void handleError(String message,
    int row, int colStart, int colEnd)
  {
    print "location: " + row + ", " + 
          colStart + "-" + colEnd + ": ";
    println message;
  };
  public void handleError(String message,
    int row, int colStart, int colEnd,
    Exception exception)
  {
    print "location: " + row + ", " +
          colStart + "-" + colEnd + ": "
    println message + "\n  -> " +
            exception.getMessage()
  };
}
handler = new ErrorHandler()
