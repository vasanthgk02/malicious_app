package org.apache.pdfbox.pdmodel.interactive.annotation;

import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.pdmodel.common.COSObjectable;

public class PDExternalDataDictionary implements COSObjectable {
    public COSDictionary dataDictionary;

    public PDExternalDataDictionary() {
        COSDictionary cOSDictionary = new COSDictionary();
        this.dataDictionary = cOSDictionary;
        cOSDictionary.setName(COSName.TYPE, (String) "ExData");
    }

    public COSBase getCOSObject() {
        return this.dataDictionary;
    }

    public COSDictionary getDictionary() {
        return this.dataDictionary;
    }

    public String getSubtype() {
        return getDictionary().getNameAsString(COSName.SUBTYPE);
    }

    public String getType() {
        return getDictionary().getNameAsString(COSName.TYPE, (String) "ExData");
    }

    public void setSubtype(String str) {
        getDictionary().setName(COSName.SUBTYPE, str);
    }

    public PDExternalDataDictionary(COSDictionary cOSDictionary) {
        this.dataDictionary = cOSDictionary;
    }
}
