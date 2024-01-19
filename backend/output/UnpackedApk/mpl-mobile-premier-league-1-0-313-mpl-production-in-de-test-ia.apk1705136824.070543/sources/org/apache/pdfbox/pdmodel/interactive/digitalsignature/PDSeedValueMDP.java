package org.apache.pdfbox.pdmodel.interactive.digitalsignature;

import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;

public class PDSeedValueMDP {
    public COSDictionary dictionary;

    public PDSeedValueMDP() {
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

    public int getP() {
        return this.dictionary.getInt(COSName.P);
    }

    public void setP(int i) {
        if (i < 0 || i > 3) {
            throw new IllegalArgumentException("Only values between 0 and 3 nare allowed.");
        }
        this.dictionary.setInt(COSName.P, i);
    }

    public PDSeedValueMDP(COSDictionary cOSDictionary) {
        this.dictionary = cOSDictionary;
        cOSDictionary.setDirect(true);
    }
}
