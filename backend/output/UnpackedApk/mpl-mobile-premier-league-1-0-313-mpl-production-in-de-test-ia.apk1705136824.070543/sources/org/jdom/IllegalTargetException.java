package org.jdom;

public class IllegalTargetException extends IllegalArgumentException {
    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public IllegalTargetException(String str, String str2) {
        // StringBuffer stringBuffer = new StringBuffer();
        // stringBuffer.append("The target \"");
        // stringBuffer.append(str);
        // stringBuffer.append("\" is not legal for JDOM/XML Processing Instructions: ");
        // stringBuffer.append(str2);
        // stringBuffer.append(".");
        super(stringBuffer.toString());
    }
}
