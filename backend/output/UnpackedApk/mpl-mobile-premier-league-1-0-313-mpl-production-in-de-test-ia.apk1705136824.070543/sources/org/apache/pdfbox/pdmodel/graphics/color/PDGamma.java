package org.apache.pdfbox.pdmodel.graphics.color;

import com.android.tools.r8.GeneratedOutlineSupport;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSFloat;
import org.apache.pdfbox.cos.COSNumber;
import org.apache.pdfbox.pdmodel.common.COSObjectable;

public final class PDGamma implements COSObjectable {
    public COSArray values = null;

    public PDGamma() {
        COSArray cOSArray = new COSArray();
        this.values = cOSArray;
        GeneratedOutlineSupport.outline91(0.0f, cOSArray);
        GeneratedOutlineSupport.outline91(0.0f, this.values);
        GeneratedOutlineSupport.outline91(0.0f, this.values);
    }

    public float getB() {
        return ((COSNumber) this.values.get(2)).floatValue();
    }

    public COSArray getCOSArray() {
        return this.values;
    }

    public COSBase getCOSObject() {
        return this.values;
    }

    public float getG() {
        return ((COSNumber) this.values.get(1)).floatValue();
    }

    public float getR() {
        return ((COSNumber) this.values.get(0)).floatValue();
    }

    public void setB(float f2) {
        this.values.set(2, (COSBase) new COSFloat(f2));
    }

    public void setG(float f2) {
        this.values.set(1, (COSBase) new COSFloat(f2));
    }

    public void setR(float f2) {
        this.values.set(0, (COSBase) new COSFloat(f2));
    }

    public PDGamma(COSArray cOSArray) {
        this.values = cOSArray;
    }
}
