package org.apache.pdfbox.pdmodel.interactive.annotation;

import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.pdmodel.common.COSObjectable;

public class PDBorderEffectDictionary implements COSObjectable {
    public static final String STYLE_CLOUDY = "C";
    public static final String STYLE_SOLID = "S";
    public COSDictionary dictionary;

    public PDBorderEffectDictionary() {
        this.dictionary = new COSDictionary();
    }

    public COSBase getCOSObject() {
        return this.dictionary;
    }

    public COSDictionary getDictionary() {
        return this.dictionary;
    }

    public float getIntensity() {
        return getDictionary().getFloat((String) "I", 0.0f);
    }

    public String getStyle() {
        return getDictionary().getNameAsString((String) "S", (String) "S");
    }

    public void setIntensity(float f2) {
        getDictionary().setFloat((String) "I", f2);
    }

    public void setStyle(String str) {
        getDictionary().setName((String) "S", str);
    }

    public PDBorderEffectDictionary(COSDictionary cOSDictionary) {
        this.dictionary = cOSDictionary;
    }
}
