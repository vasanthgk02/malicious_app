package org.apache.pdfbox.pdmodel.fdf;

import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.pdmodel.common.COSObjectable;
import org.apache.pdfbox.pdmodel.common.PDRange;

public class FDFIconFit implements COSObjectable {
    public static final String SCALE_OPTION_ALWAYS = "A";
    public static final String SCALE_OPTION_NEVER = "N";
    public static final String SCALE_OPTION_ONLY_WHEN_ICON_IS_BIGGER = "B";
    public static final String SCALE_OPTION_ONLY_WHEN_ICON_IS_SMALLER = "S";
    public static final String SCALE_TYPE_ANAMORPHIC = "A";
    public static final String SCALE_TYPE_PROPORTIONAL = "P";
    public COSDictionary fit;

    public FDFIconFit() {
        this.fit = new COSDictionary();
    }

    public COSDictionary getCOSDictionary() {
        return this.fit;
    }

    public COSBase getCOSObject() {
        return this.fit;
    }

    public PDRange getFractionalSpaceToAllocate() {
        COSArray cOSArray = (COSArray) this.fit.getDictionaryObject(COSName.A);
        if (cOSArray != null) {
            return new PDRange(cOSArray);
        }
        PDRange pDRange = new PDRange();
        pDRange.setMin(0.5f);
        pDRange.setMax(0.5f);
        setFractionalSpaceToAllocate(pDRange);
        return pDRange;
    }

    public String getScaleOption() {
        String nameAsString = this.fit.getNameAsString(COSName.SW);
        return nameAsString == null ? "A" : nameAsString;
    }

    public String getScaleType() {
        String nameAsString = this.fit.getNameAsString(COSName.S);
        return nameAsString == null ? "P" : nameAsString;
    }

    public void setFractionalSpaceToAllocate(PDRange pDRange) {
        this.fit.setItem(COSName.A, (COSObjectable) pDRange);
    }

    public void setScaleOption(String str) {
        this.fit.setName(COSName.SW, str);
    }

    public void setScaleToFitAnnotation(boolean z) {
        this.fit.setBoolean(COSName.FB, z);
    }

    public void setScaleType(String str) {
        this.fit.setName(COSName.S, str);
    }

    public boolean shouldScaleToFitAnnotation() {
        return this.fit.getBoolean(COSName.FB, false);
    }

    public FDFIconFit(COSDictionary cOSDictionary) {
        this.fit = cOSDictionary;
    }
}
