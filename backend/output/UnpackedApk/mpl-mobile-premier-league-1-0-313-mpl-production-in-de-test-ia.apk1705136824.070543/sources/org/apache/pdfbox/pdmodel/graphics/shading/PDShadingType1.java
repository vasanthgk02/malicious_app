package org.apache.pdfbox.pdmodel.graphics.shading;

import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSFloat;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.util.Matrix;

public class PDShadingType1 extends PDShading {
    public COSArray domain = null;

    public PDShadingType1(COSDictionary cOSDictionary) {
        super(cOSDictionary);
    }

    public COSArray getDomain() {
        if (this.domain == null) {
            this.domain = (COSArray) getCOSDictionary().getDictionaryObject(COSName.DOMAIN);
        }
        return this.domain;
    }

    public Matrix getMatrix() {
        COSArray cOSArray = (COSArray) getCOSDictionary().getDictionaryObject(COSName.MATRIX);
        if (cOSArray != null) {
            return new Matrix(cOSArray);
        }
        return new Matrix();
    }

    public int getShadingType() {
        return 1;
    }

    public void setDomain(COSArray cOSArray) {
        this.domain = cOSArray;
        getCOSDictionary().setItem(COSName.DOMAIN, (COSBase) cOSArray);
    }

    public void setMatrix(android.graphics.Matrix matrix) {
        COSArray cOSArray = new COSArray();
        float[] fArr = new float[9];
        matrix.getValues(fArr);
        for (int i = 0; i < 9; i++) {
            cOSArray.add((COSBase) new COSFloat(fArr[i]));
        }
        getCOSDictionary().setItem(COSName.MATRIX, (COSBase) cOSArray);
    }
}
