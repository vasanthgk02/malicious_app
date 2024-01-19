package org.apache.pdfbox.filter;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;

public abstract class Filter {
    public static COSDictionary getDecodeParams(COSDictionary cOSDictionary, int i) {
        COSBase dictionaryObject = cOSDictionary.getDictionaryObject(COSName.DECODE_PARMS, COSName.DP);
        if (dictionaryObject instanceof COSDictionary) {
            return (COSDictionary) dictionaryObject;
        }
        if (dictionaryObject instanceof COSArray) {
            COSArray cOSArray = (COSArray) dictionaryObject;
            if (i < cOSArray.size()) {
                return (COSDictionary) cOSArray.getObject(i);
            }
        } else if (dictionaryObject != null) {
            dictionaryObject.getClass().getName();
        }
        return new COSDictionary();
    }

    public abstract DecodeResult decode(InputStream inputStream, OutputStream outputStream, COSDictionary cOSDictionary, int i) throws IOException;

    public abstract void encode(InputStream inputStream, OutputStream outputStream, COSDictionary cOSDictionary) throws IOException;

    public final void encode(InputStream inputStream, OutputStream outputStream, COSDictionary cOSDictionary, int i) throws IOException {
        encode(inputStream, outputStream, cOSDictionary.asUnmodifiableDictionary());
    }
}
