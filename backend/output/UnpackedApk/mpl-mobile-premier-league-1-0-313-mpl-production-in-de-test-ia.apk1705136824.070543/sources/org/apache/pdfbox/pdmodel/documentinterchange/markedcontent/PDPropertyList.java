package org.apache.pdfbox.pdmodel.documentinterchange.markedcontent;

import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.pdmodel.common.COSObjectable;
import org.apache.pdfbox.pdmodel.graphics.optionalcontent.PDOptionalContentGroup;

public class PDPropertyList implements COSObjectable {
    public final COSDictionary dict;

    public PDPropertyList() {
        this.dict = new COSDictionary();
    }

    public static PDPropertyList create(COSDictionary cOSDictionary) {
        if (COSName.OCG.equals(cOSDictionary.getItem(COSName.TYPE))) {
            return new PDOptionalContentGroup(cOSDictionary);
        }
        return new PDPropertyList(cOSDictionary);
    }

    public COSDictionary getCOSObject() {
        return this.dict;
    }

    public PDPropertyList(COSDictionary cOSDictionary) {
        this.dict = cOSDictionary;
    }
}
