package org.apache.pdfbox.pdmodel.common;

import com.android.tools.r8.GeneratedOutlineSupport;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSFloat;
import org.apache.pdfbox.cos.COSNumber;

public class PDRange implements COSObjectable {
    public COSArray rangeArray;
    public int startingIndex;

    public PDRange() {
        COSArray cOSArray = new COSArray();
        this.rangeArray = cOSArray;
        GeneratedOutlineSupport.outline91(0.0f, cOSArray);
        GeneratedOutlineSupport.outline91(1.0f, this.rangeArray);
        this.startingIndex = 0;
    }

    public COSArray getCOSArray() {
        return this.rangeArray;
    }

    public COSBase getCOSObject() {
        return this.rangeArray;
    }

    public float getMax() {
        return ((COSNumber) this.rangeArray.getObject((this.startingIndex * 2) + 1)).floatValue();
    }

    public float getMin() {
        return ((COSNumber) this.rangeArray.getObject(this.startingIndex * 2)).floatValue();
    }

    public void setMax(float f2) {
        this.rangeArray.set((this.startingIndex * 2) + 1, (COSBase) new COSFloat(f2));
    }

    public void setMin(float f2) {
        this.rangeArray.set(this.startingIndex * 2, (COSBase) new COSFloat(f2));
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("PDRange{");
        outline73.append(getMin());
        outline73.append(", ");
        outline73.append(getMax());
        outline73.append('}');
        return outline73.toString();
    }

    public PDRange(COSArray cOSArray) {
        this.rangeArray = cOSArray;
    }

    public PDRange(COSArray cOSArray, int i) {
        this.rangeArray = cOSArray;
        this.startingIndex = i;
    }
}
