package org.apache.pdfbox.pdmodel.documentinterchange.logicalstructure;

import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.pdmodel.common.COSObjectable;

public class PDMarkInfo implements COSObjectable {
    public COSDictionary dictionary;

    public PDMarkInfo() {
        this.dictionary = new COSDictionary();
    }

    public COSBase getCOSObject() {
        return this.dictionary;
    }

    public COSDictionary getDictionary() {
        return this.dictionary;
    }

    public boolean isMarked() {
        return this.dictionary.getBoolean((String) "Marked", false);
    }

    public boolean isSuspect() {
        return this.dictionary.getBoolean((String) "Suspects", false);
    }

    public void setMarked(boolean z) {
        this.dictionary.setBoolean((String) "Marked", z);
    }

    public void setSuspect(boolean z) {
        this.dictionary.setBoolean((String) "Suspects", false);
    }

    public void setUserProperties(boolean z) {
        this.dictionary.setBoolean((String) PDUserAttributeObject.OWNER_USER_PROPERTIES, z);
    }

    public boolean usesUserProperties() {
        return this.dictionary.getBoolean((String) PDUserAttributeObject.OWNER_USER_PROPERTIES, false);
    }

    public PDMarkInfo(COSDictionary cOSDictionary) {
        this.dictionary = cOSDictionary;
    }
}
