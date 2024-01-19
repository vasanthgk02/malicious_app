package org.apache.pdfbox.pdmodel.common.function;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.io.IOException;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSNumber;

public class PDFunctionType2 extends PDFunction {
    public final COSArray c0;
    public final COSArray c1;
    public final float exponent;

    public PDFunctionType2(COSBase cOSBase) {
        super(cOSBase);
        if (getDictionary().getDictionaryObject(COSName.C0) == null) {
            COSArray cOSArray = new COSArray();
            this.c0 = cOSArray;
            GeneratedOutlineSupport.outline91(0.0f, cOSArray);
        } else {
            this.c0 = (COSArray) getDictionary().getDictionaryObject(COSName.C0);
        }
        if (getDictionary().getDictionaryObject(COSName.C1) == null) {
            COSArray cOSArray2 = new COSArray();
            this.c1 = cOSArray2;
            GeneratedOutlineSupport.outline91(1.0f, cOSArray2);
        } else {
            this.c1 = (COSArray) getDictionary().getDictionaryObject(COSName.C1);
        }
        this.exponent = getDictionary().getFloat(COSName.N);
    }

    public float[] eval(float[] fArr) throws IOException {
        float pow = (float) Math.pow((double) fArr[0], (double) this.exponent);
        int size = this.c0.size();
        float[] fArr2 = new float[size];
        for (int i = 0; i < size; i++) {
            float floatValue = ((COSNumber) this.c0.get(i)).floatValue();
            fArr2[i] = ((((COSNumber) this.c1.get(i)).floatValue() - floatValue) * pow) + floatValue;
        }
        return clipToRange(fArr2);
    }

    public COSArray getC0() {
        return this.c0;
    }

    public COSArray getC1() {
        return this.c1;
    }

    public int getFunctionType() {
        return 2;
    }

    public float getN() {
        return this.exponent;
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("FunctionType2{C0: ");
        outline73.append(getC0());
        outline73.append(" C1: ");
        outline73.append(getC1());
        outline73.append(" N: ");
        outline73.append(getN());
        outline73.append("}");
        return outline73.toString();
    }
}
