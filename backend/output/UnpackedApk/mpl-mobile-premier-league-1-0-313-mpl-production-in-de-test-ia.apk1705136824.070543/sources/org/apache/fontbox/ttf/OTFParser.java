package org.apache.fontbox.ttf;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class OTFParser extends TTFParser {
    public OTFParser() {
    }

    public TTFTable readTable(String str) {
        if (str.equals("BASE") || str.equals("GDEF") || str.equals("GPOS") || str.equals("GSUB") || str.equals("JSTF")) {
            return new OTLTable();
        }
        if (str.equals(CFFTable.TAG)) {
            return new CFFTable();
        }
        return super.readTable(str);
    }

    public OTFParser(boolean z) {
        this(z, false);
    }

    public OpenTypeFont newFont(TTFDataStream tTFDataStream) {
        return new OpenTypeFont(tTFDataStream);
    }

    public OTFParser(boolean z, boolean z2) {
        super(z, z2);
    }

    public OpenTypeFont parse(String str) throws IOException {
        return (OpenTypeFont) super.parse(str);
    }

    public OpenTypeFont parse(File file) throws IOException {
        return (OpenTypeFont) super.parse(file);
    }

    public OpenTypeFont parse(InputStream inputStream) throws IOException {
        return (OpenTypeFont) super.parse(inputStream);
    }

    public OpenTypeFont parse(TTFDataStream tTFDataStream) throws IOException {
        return (OpenTypeFont) super.parse(tTFDataStream);
    }
}
