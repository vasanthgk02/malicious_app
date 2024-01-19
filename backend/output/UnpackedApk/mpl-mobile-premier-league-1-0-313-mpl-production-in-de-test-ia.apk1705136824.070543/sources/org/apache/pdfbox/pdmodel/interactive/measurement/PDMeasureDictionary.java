package org.apache.pdfbox.pdmodel.interactive.measurement;

import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.pdmodel.common.COSObjectable;

public class PDMeasureDictionary implements COSObjectable {
    public static final String TYPE = "Measure";
    public COSDictionary measureDictionary;

    public PDMeasureDictionary() {
        this.measureDictionary = new COSDictionary();
        getDictionary().setName(COSName.TYPE, (String) TYPE);
    }

    public COSBase getCOSObject() {
        return this.measureDictionary;
    }

    public COSDictionary getDictionary() {
        return this.measureDictionary;
    }

    public String getSubtype() {
        return getDictionary().getNameAsString(COSName.SUBTYPE, (String) PDRectlinearMeasureDictionary.SUBTYPE);
    }

    public String getType() {
        return TYPE;
    }

    public void setSubtype(String str) {
        getDictionary().setName(COSName.SUBTYPE, str);
    }

    public PDMeasureDictionary(COSDictionary cOSDictionary) {
        this.measureDictionary = cOSDictionary;
    }
}
