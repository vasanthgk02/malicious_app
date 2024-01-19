package org.apache.pdfbox.pdmodel.graphics.shading;

import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.pdmodel.common.PDRange;

public class PDShadingType5 extends PDTriangleBasedShadingType {
    public PDShadingType5(COSDictionary cOSDictionary) {
        super(cOSDictionary);
    }

    public /* bridge */ /* synthetic */ int getBitsPerComponent() {
        return super.getBitsPerComponent();
    }

    public /* bridge */ /* synthetic */ int getBitsPerCoordinate() {
        return super.getBitsPerCoordinate();
    }

    public /* bridge */ /* synthetic */ PDRange getDecodeForParameter(int i) {
        return super.getDecodeForParameter(i);
    }

    public int getShadingType() {
        return 5;
    }

    public int getVerticesPerRow() {
        return getCOSDictionary().getInt(COSName.VERTICES_PER_ROW, -1);
    }

    public /* bridge */ /* synthetic */ void setBitsPerComponent(int i) {
        super.setBitsPerComponent(i);
    }

    public /* bridge */ /* synthetic */ void setBitsPerCoordinate(int i) {
        super.setBitsPerCoordinate(i);
    }

    public /* bridge */ /* synthetic */ void setDecodeValues(COSArray cOSArray) {
        super.setDecodeValues(cOSArray);
    }

    public void setVerticesPerRow(int i) {
        getCOSDictionary().setInt(COSName.VERTICES_PER_ROW, i);
    }
}
