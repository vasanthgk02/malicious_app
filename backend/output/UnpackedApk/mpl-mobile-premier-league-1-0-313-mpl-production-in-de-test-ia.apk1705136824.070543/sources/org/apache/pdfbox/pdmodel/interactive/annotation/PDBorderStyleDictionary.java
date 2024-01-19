package org.apache.pdfbox.pdmodel.interactive.annotation;

import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSInteger;
import org.apache.pdfbox.pdmodel.common.COSObjectable;
import org.apache.pdfbox.pdmodel.graphics.PDLineDashPattern;

public class PDBorderStyleDictionary implements COSObjectable {
    public static final String STYLE_BEVELED = "B";
    public static final String STYLE_DASHED = "D";
    public static final String STYLE_INSET = "I";
    public static final String STYLE_SOLID = "S";
    public static final String STYLE_UNDERLINE = "U";
    public COSDictionary dictionary;

    public PDBorderStyleDictionary() {
        this.dictionary = new COSDictionary();
    }

    public COSBase getCOSObject() {
        return this.dictionary;
    }

    public PDLineDashPattern getDashStyle() {
        COSArray cOSArray = (COSArray) getDictionary().getDictionaryObject((String) "D");
        if (cOSArray == null) {
            cOSArray = new COSArray();
            cOSArray.add((COSBase) COSInteger.THREE);
            getDictionary().setItem((String) "D", (COSBase) cOSArray);
        }
        return new PDLineDashPattern(cOSArray, 0);
    }

    public COSDictionary getDictionary() {
        return this.dictionary;
    }

    public String getStyle() {
        return getDictionary().getNameAsString((String) "S", (String) "S");
    }

    public float getWidth() {
        return getDictionary().getFloat((String) "W", 1.0f);
    }

    public void setDashStyle(COSArray cOSArray) {
        if (cOSArray == null) {
            cOSArray = null;
        }
        getDictionary().setItem((String) "D", (COSBase) cOSArray);
    }

    public void setStyle(String str) {
        getDictionary().setName((String) "S", str);
    }

    public void setWidth(float f2) {
        getDictionary().setFloat((String) "W", f2);
    }

    public PDBorderStyleDictionary(COSDictionary cOSDictionary) {
        this.dictionary = cOSDictionary;
    }
}
