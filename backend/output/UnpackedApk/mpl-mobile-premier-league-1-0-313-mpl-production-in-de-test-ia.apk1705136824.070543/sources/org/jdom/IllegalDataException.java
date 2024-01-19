package org.jdom;

public class IllegalDataException extends IllegalArgumentException {
    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public IllegalDataException(String str, String str2, String str3) {
        // StringBuffer stringBuffer = new StringBuffer();
        // stringBuffer.append("The data \"");
        // stringBuffer.append(str);
        // stringBuffer.append("\" is not legal for a JDOM ");
        // stringBuffer.append(str2);
        // stringBuffer.append(": ");
        // stringBuffer.append(str3);
        // stringBuffer.append(".");
        super(stringBuffer.toString());
    }

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public IllegalDataException(String str, String str2) {
        // StringBuffer stringBuffer = new StringBuffer();
        // stringBuffer.append("The data \"");
        // stringBuffer.append(str);
        // stringBuffer.append("\" is not legal for a JDOM ");
        // stringBuffer.append(str2);
        // stringBuffer.append(".");
        super(stringBuffer.toString());
    }
}
