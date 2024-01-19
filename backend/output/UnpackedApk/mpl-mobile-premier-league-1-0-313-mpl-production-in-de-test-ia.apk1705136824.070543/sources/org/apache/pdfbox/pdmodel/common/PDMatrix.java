package org.apache.pdfbox.pdmodel.common;

import com.android.tools.r8.GeneratedOutlineSupport;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSFloat;
import org.apache.pdfbox.cos.COSNumber;

public class PDMatrix implements COSObjectable {
    public COSArray matrix;
    public int numberOfRowElements = 3;

    public PDMatrix() {
        COSArray cOSArray = new COSArray();
        this.matrix = cOSArray;
        GeneratedOutlineSupport.outline91(1.0f, cOSArray);
        GeneratedOutlineSupport.outline91(0.0f, this.matrix);
        GeneratedOutlineSupport.outline91(0.0f, this.matrix);
        GeneratedOutlineSupport.outline91(0.0f, this.matrix);
        GeneratedOutlineSupport.outline91(1.0f, this.matrix);
        GeneratedOutlineSupport.outline91(0.0f, this.matrix);
        GeneratedOutlineSupport.outline91(0.0f, this.matrix);
        GeneratedOutlineSupport.outline91(0.0f, this.matrix);
        GeneratedOutlineSupport.outline91(1.0f, this.matrix);
    }

    public COSArray getCOSArray() {
        return this.matrix;
    }

    public COSBase getCOSObject() {
        return this.matrix;
    }

    public float getValue(int i, int i2) {
        return ((COSNumber) this.matrix.get((i * this.numberOfRowElements) + i2)).floatValue();
    }

    public void setValue(int i, int i2, float f2) {
        this.matrix.set((i * this.numberOfRowElements) + i2, (COSBase) new COSFloat(f2));
    }

    public PDMatrix(COSArray cOSArray) {
        if (cOSArray.size() == 6) {
            this.numberOfRowElements = 2;
        }
        this.matrix = cOSArray;
    }
}
