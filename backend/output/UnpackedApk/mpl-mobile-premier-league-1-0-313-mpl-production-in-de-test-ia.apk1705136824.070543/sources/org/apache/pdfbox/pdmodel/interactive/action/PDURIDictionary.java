package org.apache.pdfbox.pdmodel.interactive.action;

import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.pdmodel.common.COSObjectable;

public class PDURIDictionary implements COSObjectable {
    public COSDictionary uriDictionary;

    public PDURIDictionary() {
        this.uriDictionary = new COSDictionary();
    }

    public String getBase() {
        return getDictionary().getString((String) "Base");
    }

    public COSBase getCOSObject() {
        return this.uriDictionary;
    }

    public COSDictionary getDictionary() {
        return this.uriDictionary;
    }

    public void setBase(String str) {
        getDictionary().setString((String) "Base", str);
    }

    public PDURIDictionary(COSDictionary cOSDictionary) {
        this.uriDictionary = cOSDictionary;
    }
}
