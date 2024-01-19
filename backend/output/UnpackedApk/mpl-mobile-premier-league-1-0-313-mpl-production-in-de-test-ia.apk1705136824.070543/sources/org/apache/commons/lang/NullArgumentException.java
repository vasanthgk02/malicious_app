package org.apache.commons.lang;

public class NullArgumentException extends IllegalArgumentException {
    public static final long serialVersionUID = 1174360235354917591L;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public NullArgumentException(String str) {
        // StringBuffer stringBuffer = new StringBuffer();
        // stringBuffer.append(str == null ? "Argument" : str);
        // stringBuffer.append(" must not be null.");
        super(stringBuffer.toString());
    }
}
