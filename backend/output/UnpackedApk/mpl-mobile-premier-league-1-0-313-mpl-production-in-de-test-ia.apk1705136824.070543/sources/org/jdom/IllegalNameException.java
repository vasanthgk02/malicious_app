package org.jdom;

public class IllegalNameException extends IllegalArgumentException {
    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public IllegalNameException(String str, String str2, String str3) {
        // StringBuffer stringBuffer = new StringBuffer();
        // stringBuffer.append("The name \"");
        // stringBuffer.append(str);
        // stringBuffer.append("\" is not legal for JDOM/XML ");
        // stringBuffer.append(str2);
        // stringBuffer.append("s: ");
        // stringBuffer.append(str3);
        // stringBuffer.append(".");
        super(stringBuffer.toString());
    }
}
