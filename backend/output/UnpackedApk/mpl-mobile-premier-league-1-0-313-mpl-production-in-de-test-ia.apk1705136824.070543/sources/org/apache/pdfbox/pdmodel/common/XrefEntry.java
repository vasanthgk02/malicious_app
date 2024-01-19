package org.apache.pdfbox.pdmodel.common;

public class XrefEntry {
    public int byteOffset = 0;
    public int generation = 0;
    public boolean inUse = true;
    public int objectNumber = 0;

    public XrefEntry() {
    }

    public int getByteOffset() {
        return this.byteOffset;
    }

    public XrefEntry(int i, int i2, int i3, String str) {
        this.objectNumber = i;
        this.byteOffset = i2;
        this.generation = i3;
        this.inUse = "n".equals(str);
    }
}
