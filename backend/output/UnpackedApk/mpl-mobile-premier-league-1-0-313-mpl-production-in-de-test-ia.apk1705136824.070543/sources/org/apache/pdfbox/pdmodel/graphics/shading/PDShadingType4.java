package org.apache.pdfbox.pdmodel.graphics.shading;

import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.pdmodel.common.PDRange;

public class PDShadingType4 extends PDTriangleBasedShadingType {
    public PDShadingType4(COSDictionary cOSDictionary) {
        super(cOSDictionary);
    }

    public /* bridge */ /* synthetic */ int getBitsPerComponent() {
        return super.getBitsPerComponent();
    }

    public /* bridge */ /* synthetic */ int getBitsPerCoordinate() {
        return super.getBitsPerCoordinate();
    }

    public int getBitsPerFlag() {
        return getCOSDictionary().getInt(COSName.BITS_PER_FLAG, -1);
    }

    public /* bridge */ /* synthetic */ PDRange getDecodeForParameter(int i) {
        return super.getDecodeForParameter(i);
    }

    public int getShadingType() {
        return 4;
    }

    public /* bridge */ /* synthetic */ void setBitsPerComponent(int i) {
        super.setBitsPerComponent(i);
    }

    public /* bridge */ /* synthetic */ void setBitsPerCoordinate(int i) {
        super.setBitsPerCoordinate(i);
    }

    public void setBitsPerFlag(int i) {
        getCOSDictionary().setInt(COSName.BITS_PER_FLAG, i);
    }

    public /* bridge */ /* synthetic */ void setDecodeValues(COSArray cOSArray) {
        super.setDecodeValues(cOSArray);
    }
}
