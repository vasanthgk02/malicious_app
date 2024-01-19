package org.apache.pdfbox.pdmodel.interactive.annotation;

import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.pdmodel.common.COSObjectable;

public class PDAppearanceDictionary implements COSObjectable {
    public final COSDictionary dictionary;

    public PDAppearanceDictionary() {
        COSDictionary cOSDictionary = new COSDictionary();
        this.dictionary = cOSDictionary;
        cOSDictionary.setItem(COSName.N, (COSBase) new COSDictionary());
    }

    public PDAppearanceEntry getDownAppearance() {
        COSBase dictionaryObject = this.dictionary.getDictionaryObject(COSName.D);
        if (dictionaryObject == null) {
            return getNormalAppearance();
        }
        return new PDAppearanceEntry(dictionaryObject);
    }

    public PDAppearanceEntry getNormalAppearance() {
        COSBase dictionaryObject = this.dictionary.getDictionaryObject(COSName.N);
        if (dictionaryObject == null) {
            return null;
        }
        return new PDAppearanceEntry(dictionaryObject);
    }

    public PDAppearanceEntry getRolloverAppearance() {
        COSBase dictionaryObject = this.dictionary.getDictionaryObject(COSName.R);
        if (dictionaryObject == null) {
            return getNormalAppearance();
        }
        return new PDAppearanceEntry(dictionaryObject);
    }

    public void setDownAppearance(PDAppearanceEntry pDAppearanceEntry) {
        this.dictionary.setItem(COSName.D, (COSObjectable) pDAppearanceEntry);
    }

    public void setNormalAppearance(PDAppearanceEntry pDAppearanceEntry) {
        this.dictionary.setItem(COSName.N, (COSObjectable) pDAppearanceEntry);
    }

    public void setRolloverAppearance(PDAppearanceEntry pDAppearanceEntry) {
        this.dictionary.setItem(COSName.R, (COSObjectable) pDAppearanceEntry);
    }

    public COSDictionary getCOSObject() {
        return this.dictionary;
    }

    public void setDownAppearance(PDAppearanceStream pDAppearanceStream) {
        this.dictionary.setItem(COSName.D, (COSObjectable) pDAppearanceStream);
    }

    public void setNormalAppearance(PDAppearanceStream pDAppearanceStream) {
        this.dictionary.setItem(COSName.N, (COSObjectable) pDAppearanceStream);
    }

    public void setRolloverAppearance(PDAppearanceStream pDAppearanceStream) {
        this.dictionary.setItem(COSName.R, (COSObjectable) pDAppearanceStream);
    }

    public PDAppearanceDictionary(COSDictionary cOSDictionary) {
        this.dictionary = cOSDictionary;
    }
}
