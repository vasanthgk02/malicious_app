package org.apache.pdfbox.pdmodel.interactive.pagenavigation;

import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSBoolean;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSFloat;
import org.apache.pdfbox.cos.COSInteger;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.pdmodel.common.PDDictionaryWrapper;

public final class PDTransition extends PDDictionaryWrapper {
    public PDTransition() {
        this(PDTransitionStyle.R);
    }

    public String getDimension() {
        return getCOSDictionary().getNameAsString(COSName.DM, PDTransitionDimension.H.name());
    }

    public COSBase getDirection() {
        COSBase item = getCOSDictionary().getItem(COSName.DI);
        return item == null ? COSInteger.ZERO : item;
    }

    public float getDuration() {
        return getCOSDictionary().getFloat(COSName.D, 1.0f);
    }

    public float getFlyScale() {
        return getCOSDictionary().getFloat(COSName.SS, 1.0f);
    }

    public String getMotion() {
        return getCOSDictionary().getNameAsString(COSName.M, PDTransitionMotion.I.name());
    }

    public String getStyle() {
        return getCOSDictionary().getNameAsString(COSName.S, PDTransitionStyle.R.name());
    }

    public boolean isFlyAreaOpaque() {
        return getCOSDictionary().getBoolean(COSName.B, false);
    }

    public void setDimension(PDTransitionDimension pDTransitionDimension) {
        getCOSDictionary().setName(COSName.DM, pDTransitionDimension.name());
    }

    public void setDirection(PDTransitionDirection pDTransitionDirection) {
        getCOSDictionary().setItem(COSName.DI, pDTransitionDirection.getCOSBase());
    }

    public void setDuration(float f2) {
        getCOSDictionary().setItem(COSName.D, (COSBase) new COSFloat(f2));
    }

    public void setFlyAreaOpaque(boolean z) {
        getCOSDictionary().setItem(COSName.B, (COSBase) COSBoolean.getBoolean(z));
    }

    public void setFlyScale(float f2) {
        getCOSDictionary().setItem(COSName.SS, (COSBase) new COSFloat(f2));
    }

    public void setMotion(PDTransitionMotion pDTransitionMotion) {
        getCOSDictionary().setName(COSName.M, pDTransitionMotion.name());
    }

    public PDTransition(PDTransitionStyle pDTransitionStyle) {
        getCOSDictionary().setName(COSName.TYPE, COSName.TRANS.getName());
        getCOSDictionary().setName(COSName.S, pDTransitionStyle.name());
    }

    public PDTransition(COSDictionary cOSDictionary) {
        super(cOSDictionary);
    }
}
