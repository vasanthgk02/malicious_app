package org.apache.fontbox.ttf;

import java.io.IOException;

public abstract class GlyfDescript implements GlyphDescription {
    public static final byte ON_CURVE = 1;
    public static final byte REPEAT = 8;
    public static final byte X_DUAL = 16;
    public static final byte X_SHORT_VECTOR = 2;
    public static final byte Y_DUAL = 32;
    public static final byte Y_SHORT_VECTOR = 4;
    public final int contourCount;
    public int[] instructions;

    public GlyfDescript(short s, TTFDataStream tTFDataStream) throws IOException {
        this.contourCount = s;
    }

    public int getContourCount() {
        return this.contourCount;
    }

    public int[] getInstructions() {
        return this.instructions;
    }

    public void readInstructions(TTFDataStream tTFDataStream, int i) throws IOException {
        this.instructions = tTFDataStream.readUnsignedByteArray(i);
    }

    public void resolve() {
    }
}
