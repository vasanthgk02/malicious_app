package org.apache.pdfbox.pdmodel.interactive.annotation;

import java.util.HashMap;
import java.util.Map;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.pdmodel.common.COSDictionaryMap;
import org.apache.pdfbox.pdmodel.common.COSObjectable;

public class PDAppearanceEntry implements COSObjectable {
    public COSBase entry;

    public PDAppearanceEntry() {
    }

    public PDAppearanceStream getAppearanceStream() {
        if (isStream()) {
            return new PDAppearanceStream((COSStream) this.entry);
        }
        throw new IllegalStateException();
    }

    public COSBase getCOSObject() {
        return this.entry;
    }

    public Map<COSName, PDAppearanceStream> getSubDictionary() {
        if (isSubDictionary()) {
            COSDictionary cOSDictionary = (COSDictionary) this.entry;
            HashMap hashMap = new HashMap();
            for (COSName next : cOSDictionary.keySet()) {
                COSBase dictionaryObject = cOSDictionary.getDictionaryObject(next);
                if (dictionaryObject instanceof COSStream) {
                    hashMap.put(next, new PDAppearanceStream((COSStream) dictionaryObject));
                }
            }
            return new COSDictionaryMap(hashMap, cOSDictionary);
        }
        throw new IllegalStateException();
    }

    public boolean isStream() {
        return this.entry instanceof COSStream;
    }

    public boolean isSubDictionary() {
        return !(this.entry instanceof COSStream);
    }

    public PDAppearanceEntry(COSBase cOSBase) {
        this.entry = cOSBase;
    }
}
