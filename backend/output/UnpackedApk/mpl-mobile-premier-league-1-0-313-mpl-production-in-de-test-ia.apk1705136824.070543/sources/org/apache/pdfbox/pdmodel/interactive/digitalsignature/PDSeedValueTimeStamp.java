package org.apache.pdfbox.pdmodel.interactive.digitalsignature;

import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;

public class PDSeedValueTimeStamp {
    public COSDictionary dictionary;

    public PDSeedValueTimeStamp() {
        COSDictionary cOSDictionary = new COSDictionary();
        this.dictionary = cOSDictionary;
        cOSDictionary.setDirect(true);
    }

    public COSBase getCOSObject() {
        return getDictionary();
    }

    public COSDictionary getDictionary() {
        return this.dictionary;
    }

    public String getURL() {
        return this.dictionary.getString(COSName.URL);
    }

    public boolean isTimestampRequired() {
        return this.dictionary.getInt(COSName.FT, 0) != 0;
    }

    public void setTimestampRequired(boolean z) {
        this.dictionary.setInt(COSName.FT, z ? 1 : 0);
    }

    public void setURL(String str) {
        this.dictionary.setString(COSName.URL, str);
    }

    public PDSeedValueTimeStamp(COSDictionary cOSDictionary) {
        this.dictionary = cOSDictionary;
        cOSDictionary.setDirect(true);
    }
}
