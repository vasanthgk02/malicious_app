package org.apache.pdfbox.pdmodel.graphics.color;

import com.android.tools.r8.GeneratedOutlineSupport;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSFloat;
import org.apache.pdfbox.cos.COSNumber;
import org.apache.pdfbox.pdmodel.common.COSObjectable;

public final class PDTristimulus implements COSObjectable {
    public COSArray values;

    public PDTristimulus() {
        this.values = null;
        COSArray cOSArray = new COSArray();
        this.values = cOSArray;
        GeneratedOutlineSupport.outline91(0.0f, cOSArray);
        GeneratedOutlineSupport.outline91(0.0f, this.values);
        GeneratedOutlineSupport.outline91(0.0f, this.values);
    }

    public COSBase getCOSObject() {
        return this.values;
    }

    public float getX() {
        return ((COSNumber) this.values.get(0)).floatValue();
    }

    public float getY() {
        return ((COSNumber) this.values.get(1)).floatValue();
    }

    public float getZ() {
        return ((COSNumber) this.values.get(2)).floatValue();
    }

    public void setX(float f2) {
        this.values.set(0, (COSBase) new COSFloat(f2));
    }

    public void setY(float f2) {
        this.values.set(1, (COSBase) new COSFloat(f2));
    }

    public void setZ(float f2) {
        this.values.set(2, (COSBase) new COSFloat(f2));
    }

    public PDTristimulus(COSArray cOSArray) {
        this.values = null;
        this.values = cOSArray;
    }

    public PDTristimulus(float[] fArr) {
        this.values = null;
        this.values = new COSArray();
        int i = 0;
        while (i < fArr.length && i < 3) {
            this.values.add((COSBase) new COSFloat(fArr[i]));
            i++;
        }
    }
}
