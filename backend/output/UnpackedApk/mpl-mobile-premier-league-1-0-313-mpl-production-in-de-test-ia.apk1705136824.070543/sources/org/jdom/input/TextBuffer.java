package org.jdom.input;

public class TextBuffer {
    public char[] array = new char[4096];
    public int arraySize = 0;
    public String prefixString;

    public String toString() {
        String str = this.prefixString;
        if (str == null) {
            return "";
        }
        if (this.arraySize != 0) {
            StringBuffer stringBuffer = new StringBuffer(str.length() + this.arraySize);
            stringBuffer.append(this.prefixString);
            stringBuffer.append(this.array, 0, this.arraySize);
            str = stringBuffer.toString();
        }
        return str;
    }
}
