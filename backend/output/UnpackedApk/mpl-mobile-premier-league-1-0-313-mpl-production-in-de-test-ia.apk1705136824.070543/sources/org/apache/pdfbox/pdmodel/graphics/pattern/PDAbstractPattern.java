package org.apache.pdfbox.pdmodel.graphics.pattern;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.io.IOException;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSFloat;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.pdmodel.common.COSObjectable;
import org.apache.pdfbox.util.Matrix;
import org.apache.pdfbox.util.awt.AffineTransform;

public abstract class PDAbstractPattern implements COSObjectable {
    public static final int TYPE_SHADING_PATTERN = 2;
    public static final int TYPE_TILING_PATTERN = 1;
    public final COSDictionary patternDictionary;

    public PDAbstractPattern() {
        COSDictionary cOSDictionary = new COSDictionary();
        this.patternDictionary = cOSDictionary;
        cOSDictionary.setName(COSName.TYPE, COSName.PATTERN.getName());
    }

    public static PDAbstractPattern create(COSDictionary cOSDictionary) throws IOException {
        int i = cOSDictionary.getInt(COSName.PATTERN_TYPE, 0);
        if (i == 1) {
            return new PDTilingPattern(cOSDictionary);
        }
        if (i == 2) {
            return new PDShadingPattern(cOSDictionary);
        }
        throw new IOException(GeneratedOutlineSupport.outline41("Error: Unknown pattern type ", i));
    }

    public COSDictionary getCOSDictionary() {
        return this.patternDictionary;
    }

    public COSBase getCOSObject() {
        return this.patternDictionary;
    }

    public String getFilter() {
        return this.patternDictionary.getNameAsString(COSName.FILTER);
    }

    public int getLength() {
        return this.patternDictionary.getInt(COSName.LENGTH, 0);
    }

    public Matrix getMatrix() {
        COSArray cOSArray = (COSArray) getCOSDictionary().getDictionaryObject(COSName.MATRIX);
        if (cOSArray != null) {
            return new Matrix(cOSArray);
        }
        return new Matrix();
    }

    public abstract int getPatternType();

    public String getType() {
        return COSName.PATTERN.getName();
    }

    public void setFilter(String str) {
        this.patternDictionary.setItem(COSName.FILTER, (COSBase) COSName.getPDFName(str));
    }

    public void setLength(int i) {
        this.patternDictionary.setInt(COSName.LENGTH, i);
    }

    public void setMatrix(AffineTransform affineTransform) {
        COSArray cOSArray = new COSArray();
        double[] dArr = new double[6];
        affineTransform.getMatrix(dArr);
        for (int i = 0; i < 6; i++) {
            cOSArray.add((COSBase) new COSFloat((float) dArr[i]));
        }
        getCOSDictionary().setItem(COSName.MATRIX, (COSBase) cOSArray);
    }

    public void setPaintType(int i) {
        this.patternDictionary.setInt(COSName.PAINT_TYPE, i);
    }

    public void setPatternType(int i) {
        this.patternDictionary.setInt(COSName.PATTERN_TYPE, i);
    }

    public PDAbstractPattern(COSDictionary cOSDictionary) {
        this.patternDictionary = cOSDictionary;
    }
}
