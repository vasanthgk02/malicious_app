package org.apache.pdfbox.pdmodel.graphics.form;

import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.pdmodel.common.COSObjectable;
import org.apache.pdfbox.pdmodel.graphics.color.PDColorSpace;

public final class PDGroup implements COSObjectable {
    public PDColorSpace colorSpace;
    public COSDictionary dictionary;
    public COSName subType;

    public PDGroup(COSDictionary cOSDictionary) {
        this.dictionary = cOSDictionary;
    }

    public COSDictionary getCOSDictionary() {
        return this.dictionary;
    }

    public COSBase getCOSObject() {
        return this.dictionary;
    }

    public COSName getSubType() {
        if (this.subType == null) {
            this.subType = (COSName) getCOSDictionary().getDictionaryObject(COSName.S);
        }
        return this.subType;
    }

    public boolean isIsolated() {
        return getCOSDictionary().getBoolean(COSName.I, false);
    }

    public boolean isKnockout() {
        return getCOSDictionary().getBoolean(COSName.K, false);
    }
}
