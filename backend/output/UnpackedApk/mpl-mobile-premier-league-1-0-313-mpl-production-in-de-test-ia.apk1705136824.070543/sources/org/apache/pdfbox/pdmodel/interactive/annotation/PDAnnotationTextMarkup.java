package org.apache.pdfbox.pdmodel.interactive.annotation;

import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;

public class PDAnnotationTextMarkup extends PDAnnotationMarkup {
    public static final String SUB_TYPE_HIGHLIGHT = "Highlight";
    public static final String SUB_TYPE_SQUIGGLY = "Squiggly";
    public static final String SUB_TYPE_STRIKEOUT = "StrikeOut";
    public static final String SUB_TYPE_UNDERLINE = "Underline";

    public PDAnnotationTextMarkup() {
    }

    public float[] getQuadPoints() {
        COSArray cOSArray = (COSArray) getDictionary().getDictionaryObject((String) "QuadPoints");
        if (cOSArray != null) {
            return cOSArray.toFloatArray();
        }
        return null;
    }

    public String getSubtype() {
        return getDictionary().getNameAsString(COSName.SUBTYPE);
    }

    public void setQuadPoints(float[] fArr) {
        COSArray cOSArray = new COSArray();
        cOSArray.setFloatArray(fArr);
        getDictionary().setItem((String) "QuadPoints", (COSBase) cOSArray);
    }

    public void setSubtype(String str) {
        getDictionary().setName(COSName.SUBTYPE, str);
    }

    public PDAnnotationTextMarkup(String str) {
        setSubtype(str);
        setQuadPoints(new float[0]);
    }

    public PDAnnotationTextMarkup(COSDictionary cOSDictionary) {
        super(cOSDictionary);
    }
}
