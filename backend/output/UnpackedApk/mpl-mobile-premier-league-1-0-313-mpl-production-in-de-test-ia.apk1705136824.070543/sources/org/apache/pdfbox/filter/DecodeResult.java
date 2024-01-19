package org.apache.pdfbox.filter;

import org.apache.pdfbox.cos.COSDictionary;

public final class DecodeResult {
    public static final DecodeResult DEFAULT = new DecodeResult(new COSDictionary());
    public final COSDictionary parameters;

    public DecodeResult(COSDictionary cOSDictionary) {
        this.parameters = cOSDictionary;
    }

    public COSDictionary getParameters() {
        return this.parameters;
    }
}
