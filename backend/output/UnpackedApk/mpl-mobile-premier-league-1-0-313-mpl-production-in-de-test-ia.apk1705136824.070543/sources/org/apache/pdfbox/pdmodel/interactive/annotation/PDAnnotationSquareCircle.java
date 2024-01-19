package org.apache.pdfbox.pdmodel.interactive.annotation;

import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.pdmodel.common.COSObjectable;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.graphics.color.PDColor;

public class PDAnnotationSquareCircle extends PDAnnotationMarkup {
    public static final String SUB_TYPE_CIRCLE = "Circle";
    public static final String SUB_TYPE_SQUARE = "Square";

    public PDAnnotationSquareCircle(String str) {
        setSubtype(str);
    }

    public PDBorderEffectDictionary getBorderEffect() {
        COSDictionary cOSDictionary = (COSDictionary) getDictionary().getDictionaryObject((String) "BE");
        if (cOSDictionary != null) {
            return new PDBorderEffectDictionary(cOSDictionary);
        }
        return null;
    }

    public PDBorderStyleDictionary getBorderStyle() {
        COSDictionary cOSDictionary = (COSDictionary) getDictionary().getItem(COSName.BS);
        if (cOSDictionary != null) {
            return new PDBorderStyleDictionary(cOSDictionary);
        }
        return null;
    }

    public PDColor getInteriorColor() {
        return getColor(COSName.IC);
    }

    public PDRectangle getRectDifference() {
        COSArray cOSArray = (COSArray) getDictionary().getDictionaryObject((String) "RD");
        if (cOSArray != null) {
            return new PDRectangle(cOSArray);
        }
        return null;
    }

    public String getSubtype() {
        return getDictionary().getNameAsString(COSName.SUBTYPE);
    }

    public void setBorderEffect(PDBorderEffectDictionary pDBorderEffectDictionary) {
        getDictionary().setItem((String) "BE", (COSObjectable) pDBorderEffectDictionary);
    }

    public void setBorderStyle(PDBorderStyleDictionary pDBorderStyleDictionary) {
        getDictionary().setItem((String) "BS", (COSObjectable) pDBorderStyleDictionary);
    }

    public void setInteriorColor(PDColor pDColor) {
        getDictionary().setItem(COSName.IC, (COSBase) pDColor.toCOSArray());
    }

    public void setRectDifference(PDRectangle pDRectangle) {
        getDictionary().setItem((String) "RD", (COSObjectable) pDRectangle);
    }

    public void setSubtype(String str) {
        getDictionary().setName(COSName.SUBTYPE, str);
    }

    public PDAnnotationSquareCircle(COSDictionary cOSDictionary) {
        super(cOSDictionary);
    }
}
