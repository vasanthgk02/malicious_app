package org.apache.pdfbox.pdmodel.font;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.apache.fontbox.util.BoundingBox;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSNumber;
import org.apache.pdfbox.pdmodel.common.COSObjectable;
import org.apache.pdfbox.util.Matrix;
import org.apache.pdfbox.util.Vector;

public abstract class PDCIDFont implements COSObjectable, PDFontLike {
    public float defaultWidth;
    public final COSDictionary dict;
    public float[] dw2;
    public PDFontDescriptor fontDescriptor;
    public final PDType0Font parent;
    public final Map<Integer, Vector> positionVectors = new HashMap();
    public final Map<Integer, Float> verticalDisplacementY = new HashMap();
    public Map<Integer, Float> widths;

    public PDCIDFont(COSDictionary cOSDictionary, PDType0Font pDType0Font) throws IOException {
        this.dict = cOSDictionary;
        this.parent = pDType0Font;
        readWidths();
        readVerticalDisplacements();
    }

    private Vector getDefaultPositionVector(int i) {
        float f2;
        if (this.widths.containsKey(Integer.valueOf(i))) {
            Float f3 = this.widths.get(Integer.valueOf(i));
            if (f3 != null) {
                f2 = f3.floatValue();
            } else {
                f2 = getDefaultWidth();
            }
        } else {
            f2 = getDefaultWidth();
        }
        return new Vector(f2 / 2.0f, this.dw2[0]);
    }

    private float getDefaultWidth() {
        if (this.defaultWidth == 0.0f) {
            COSNumber cOSNumber = (COSNumber) this.dict.getDictionaryObject(COSName.DW);
            if (cOSNumber != null) {
                this.defaultWidth = cOSNumber.floatValue();
            } else {
                this.defaultWidth = 1000.0f;
            }
        }
        return this.defaultWidth;
    }

    private void readVerticalDisplacements() {
        COSArray cOSArray = (COSArray) this.dict.getDictionaryObject(COSName.DW2);
        if (cOSArray != null) {
            float[] fArr = new float[2];
            this.dw2 = fArr;
            fArr[0] = ((COSNumber) cOSArray.get(0)).floatValue();
            this.dw2[1] = ((COSNumber) cOSArray.get(1)).floatValue();
        } else {
            this.dw2 = new float[]{880.0f, -1000.0f};
        }
        COSArray cOSArray2 = (COSArray) this.dict.getDictionaryObject(COSName.W2);
        if (cOSArray2 != null) {
            int i = 0;
            while (i < cOSArray2.size()) {
                COSNumber cOSNumber = (COSNumber) cOSArray2.get(i);
                int i2 = i + 1;
                COSBase cOSBase = cOSArray2.get(i2);
                if (cOSBase instanceof COSArray) {
                    COSArray cOSArray3 = (COSArray) cOSBase;
                    int i3 = 0;
                    while (i3 < cOSArray3.size()) {
                        int intValue = cOSNumber.intValue() + i3;
                        int i4 = i3 + 1;
                        int i5 = i4 + 1;
                        this.verticalDisplacementY.put(Integer.valueOf(intValue), Float.valueOf(((COSNumber) cOSArray3.get(i3)).floatValue()));
                        this.positionVectors.put(Integer.valueOf(intValue), new Vector(((COSNumber) cOSArray3.get(i4)).floatValue(), ((COSNumber) cOSArray3.get(i5)).floatValue()));
                        i3 = i5 + 1;
                    }
                } else {
                    int intValue2 = ((COSNumber) cOSBase).intValue();
                    int i6 = i2 + 1;
                    COSNumber cOSNumber2 = (COSNumber) cOSArray2.get(i6);
                    int i7 = i6 + 1;
                    COSNumber cOSNumber3 = (COSNumber) cOSArray2.get(i7);
                    i2 = i7 + 1;
                    COSNumber cOSNumber4 = (COSNumber) cOSArray2.get(i2);
                    for (int intValue3 = cOSNumber.intValue(); intValue3 <= intValue2; intValue3++) {
                        this.verticalDisplacementY.put(Integer.valueOf(intValue3), Float.valueOf(cOSNumber2.floatValue()));
                        this.positionVectors.put(Integer.valueOf(intValue3), new Vector(cOSNumber3.floatValue(), cOSNumber4.floatValue()));
                    }
                }
                i = i2 + 1;
            }
        }
    }

    private void readWidths() {
        this.widths = new HashMap();
        COSArray cOSArray = (COSArray) this.dict.getDictionaryObject(COSName.W);
        if (cOSArray != null) {
            int size = cOSArray.size();
            int i = 0;
            while (i < size) {
                int i2 = i + 1;
                COSNumber cOSNumber = (COSNumber) cOSArray.getObject(i);
                int i3 = i2 + 1;
                COSBase object = cOSArray.getObject(i2);
                if (object instanceof COSArray) {
                    COSArray cOSArray2 = (COSArray) object;
                    int intValue = cOSNumber.intValue();
                    int size2 = cOSArray2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        this.widths.put(Integer.valueOf(intValue + i4), Float.valueOf(((COSNumber) cOSArray2.get(i4)).floatValue()));
                    }
                    i = i3;
                } else {
                    int i5 = i3 + 1;
                    int intValue2 = ((COSNumber) object).intValue();
                    float floatValue = ((COSNumber) cOSArray.getObject(i3)).floatValue();
                    for (int intValue3 = cOSNumber.intValue(); intValue3 <= intValue2; intValue3++) {
                        this.widths.put(Integer.valueOf(intValue3), Float.valueOf(floatValue));
                    }
                    i = i5;
                }
            }
        }
    }

    public abstract int codeToCID(int i);

    public abstract int codeToGID(int i) throws IOException;

    public abstract byte[] encode(int i) throws IOException;

    public float getAverageFontWidth() {
        float f2;
        float f3;
        COSArray cOSArray = (COSArray) this.dict.getDictionaryObject(COSName.W);
        if (cOSArray != null) {
            int i = 0;
            f3 = 0.0f;
            f2 = 0.0f;
            while (i < cOSArray.size()) {
                int i2 = i + 1;
                COSNumber cOSNumber = (COSNumber) cOSArray.getObject(i);
                COSBase object = cOSArray.getObject(i2);
                if (object instanceof COSArray) {
                    COSArray cOSArray2 = (COSArray) object;
                    for (int i3 = 0; i3 < cOSArray2.size(); i3++) {
                        f3 += ((COSNumber) cOSArray2.get(i3)).floatValue();
                        f2 += 1.0f;
                    }
                } else {
                    i2++;
                    COSNumber cOSNumber2 = (COSNumber) cOSArray.getObject(i2);
                    if (cOSNumber2.floatValue() > 0.0f) {
                        f3 += cOSNumber2.floatValue();
                        f2 += 1.0f;
                    }
                }
                i = i2 + 1;
            }
        } else {
            f3 = 0.0f;
            f2 = 0.0f;
        }
        float f4 = f3 / f2;
        return f4 <= 0.0f ? getDefaultWidth() : f4;
    }

    public String getBaseFont() {
        return this.dict.getNameAsString(COSName.BASE_FONT);
    }

    public abstract BoundingBox getBoundingBox() throws IOException;

    public PDFontDescriptor getFontDescriptor() {
        if (this.fontDescriptor == null) {
            COSDictionary cOSDictionary = (COSDictionary) this.dict.getDictionaryObject(COSName.FONT_DESC);
            if (cOSDictionary != null) {
                this.fontDescriptor = new PDFontDescriptor(cOSDictionary);
            }
        }
        return this.fontDescriptor;
    }

    public abstract Matrix getFontMatrix();

    public String getName() {
        return getBaseFont();
    }

    public final PDType0Font getParent() {
        return this.parent;
    }

    public Vector getPositionVector(int i) {
        int codeToCID = codeToCID(i);
        Vector vector = this.positionVectors.get(Integer.valueOf(codeToCID));
        if (vector != null) {
            return vector;
        }
        return getDefaultPositionVector(codeToCID);
    }

    public float getVerticalDisplacementVectorY(int i) {
        Float f2 = this.verticalDisplacementY.get(Integer.valueOf(codeToCID(i)));
        if (f2 != null) {
            return f2.floatValue();
        }
        return this.dw2[1];
    }

    public float getWidth(int i) throws IOException {
        int codeToCID = codeToCID(i);
        if (!this.widths.containsKey(Integer.valueOf(codeToCID))) {
            return getWidthFromFont(i);
        }
        Float f2 = this.widths.get(Integer.valueOf(codeToCID));
        if (f2 != null) {
            return f2.floatValue();
        }
        return getDefaultWidth();
    }

    public abstract float getWidthFromFont(int i) throws IOException;

    public abstract boolean isEmbedded();

    public COSDictionary getCOSObject() {
        return this.dict;
    }
}
