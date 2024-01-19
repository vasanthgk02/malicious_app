package bolts;

import java.io.PrintStream;
import java.io.PrintWriter;

public class AggregateException extends Exception {
    public static final long serialVersionUID = 1;

    public void printStackTrace(PrintStream printStream) {
        super.printStackTrace(printStream);
        throw null;
    }

    public void printStackTrace(PrintWriter printWriter) {
        super.printStackTrace(printWriter);
        throw null;
    }
}
