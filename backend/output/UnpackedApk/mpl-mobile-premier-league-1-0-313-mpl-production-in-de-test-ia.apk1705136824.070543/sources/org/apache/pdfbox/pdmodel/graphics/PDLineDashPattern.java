package org.apache.pdfbox.pdmodel.graphics;

import java.util.Arrays;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSInteger;
import org.apache.pdfbox.pdmodel.common.COSArrayList;
import org.apache.pdfbox.pdmodel.common.COSObjectable;

public final class PDLineDashPattern implements COSObjectable {
    public final float[] array;
    public final int phase;

    public PDLineDashPattern() {
        this.array = new float[0];
        this.phase = 0;
    }

    public COSBase getCOSObject() {
        COSArray cOSArray = new COSArray();
        cOSArray.add((COSBase) COSArrayList.converterToCOSArray(Arrays.asList(new float[][]{this.array})));
        cOSArray.add((COSBase) COSInteger.get((long) this.phase));
        return cOSArray;
    }

    public float[] getDashArray() {
        return (float[]) this.array.clone();
    }

    public int getPhase() {
        return this.phase;
    }

    public PDLineDashPattern(COSArray cOSArray, int i) {
        this.array = cOSArray.toFloatArray();
        this.phase = i;
    }
}
