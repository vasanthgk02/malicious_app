package org.apache.pdfbox.pdmodel.graphics.shading;

import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.pdmodel.common.PDRange;

public abstract class PDTriangleBasedShadingType extends PDShading {
    public COSArray decode = null;

    public PDTriangleBasedShadingType(COSDictionary cOSDictionary) {
        super(cOSDictionary);
    }

    private COSArray getDecodeValues() {
        if (this.decode == null) {
            this.decode = (COSArray) getCOSDictionary().getDictionaryObject(COSName.DECODE);
        }
        return this.decode;
    }

    public int getBitsPerComponent() {
        return getCOSDictionary().getInt(COSName.BITS_PER_COMPONENT, -1);
    }

    public int getBitsPerCoordinate() {
        return getCOSDictionary().getInt(COSName.BITS_PER_COORDINATE, -1);
    }

    public PDRange getDecodeForParameter(int i) {
        COSArray decodeValues = getDecodeValues();
        if (decodeValues == null || decodeValues.size() < (i * 2) + 1) {
            return null;
        }
        return new PDRange(decodeValues, i);
    }

    public void setBitsPerComponent(int i) {
        getCOSDictionary().setInt(COSName.BITS_PER_COMPONENT, i);
    }

    public void setBitsPerCoordinate(int i) {
        getCOSDictionary().setInt(COSName.BITS_PER_COORDINATE, i);
    }

    public void setDecodeValues(COSArray cOSArray) {
        this.decode = cOSArray;
        getCOSDictionary().setItem(COSName.DECODE, (COSBase) cOSArray);
    }
}
