package org.apache.pdfbox.pdmodel.common;

import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSDictionary;

public class PDDictionaryWrapper implements COSObjectable {
    public final COSDictionary dictionary;

    public PDDictionaryWrapper() {
        this.dictionary = new COSDictionary();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof PDDictionaryWrapper) {
            return this.dictionary.equals(((PDDictionaryWrapper) obj).dictionary);
        }
        return false;
    }

    public COSDictionary getCOSDictionary() {
        return this.dictionary;
    }

    public COSBase getCOSObject() {
        return this.dictionary;
    }

    public int hashCode() {
        return this.dictionary.hashCode();
    }

    public PDDictionaryWrapper(COSDictionary cOSDictionary) {
        this.dictionary = cOSDictionary;
    }
}
