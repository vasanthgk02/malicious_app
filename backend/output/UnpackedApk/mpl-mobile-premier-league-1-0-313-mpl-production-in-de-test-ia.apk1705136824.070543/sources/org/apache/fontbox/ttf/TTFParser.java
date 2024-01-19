package org.apache.fontbox.ttf;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class TTFParser {
    public boolean isEmbedded;
    public boolean parseOnDemandOnly;

    public TTFParser() {
        this(false);
    }

    private void parseTables(TrueTypeFont trueTypeFont, TTFDataStream tTFDataStream) throws IOException {
        for (TTFTable next : trueTypeFont.getTables()) {
            if (!next.getInitialized()) {
                trueTypeFont.readTable(next);
            }
        }
        if (trueTypeFont.getHeader() == null) {
            throw new IOException("head is mandatory");
        } else if (trueTypeFont.getHorizontalHeader() == null) {
            throw new IOException("hhead is mandatory");
        } else if (trueTypeFont.getMaximumProfile() == null) {
            throw new IOException("maxp is mandatory");
        } else if (trueTypeFont.getPostScript() == null && !this.isEmbedded) {
            throw new IOException("post is mandatory");
        } else if (trueTypeFont.getIndexToLocation() == null) {
            throw new IOException("loca is mandatory");
        } else if (trueTypeFont.getGlyph() == null) {
            throw new IOException("glyf is mandatory");
        } else if (trueTypeFont.getNaming() == null && !this.isEmbedded) {
            throw new IOException("name is mandatory");
        } else if (trueTypeFont.getHorizontalMetrics() == null) {
            throw new IOException("hmtx is mandatory");
        } else if (!this.isEmbedded && trueTypeFont.getCmap() == null) {
            throw new IOException("cmap is mandatory");
        }
    }

    private TTFTable readTableDirectory(TTFDataStream tTFDataStream) throws IOException {
        TTFTable tTFTable;
        String readString = tTFDataStream.readString(4);
        if (readString.equals(CmapTable.TAG)) {
            tTFTable = new CmapTable();
        } else if (readString.equals(GlyphTable.TAG)) {
            tTFTable = new GlyphTable();
        } else if (readString.equals(HeaderTable.TAG)) {
            tTFTable = new HeaderTable();
        } else if (readString.equals(HorizontalHeaderTable.TAG)) {
            tTFTable = new HorizontalHeaderTable();
        } else if (readString.equals(HorizontalMetricsTable.TAG)) {
            tTFTable = new HorizontalMetricsTable();
        } else if (readString.equals(IndexToLocationTable.TAG)) {
            tTFTable = new IndexToLocationTable();
        } else if (readString.equals(MaximumProfileTable.TAG)) {
            tTFTable = new MaximumProfileTable();
        } else if (readString.equals("name")) {
            tTFTable = new NamingTable();
        } else if (readString.equals("OS/2")) {
            tTFTable = new OS2WindowsMetricsTable();
        } else if (readString.equals("post")) {
            tTFTable = new PostScriptTable();
        } else if (readString.equals(DigitalSignatureTable.TAG)) {
            tTFTable = new DigitalSignatureTable();
        } else {
            tTFTable = readTable(readString);
        }
        tTFTable.setTag(readString);
        tTFTable.setCheckSum(tTFDataStream.readUnsignedInt());
        tTFTable.setOffset(tTFDataStream.readUnsignedInt());
        tTFTable.setLength(tTFDataStream.readUnsignedInt());
        return tTFTable;
    }

    public TrueTypeFont newFont(TTFDataStream tTFDataStream) {
        return new TrueTypeFont(tTFDataStream);
    }

    public TrueTypeFont parse(String str) throws IOException {
        return parse(new File(str));
    }

    public TrueTypeFont parseEmbedded(InputStream inputStream) throws IOException {
        this.isEmbedded = true;
        return parse((TTFDataStream) new MemoryTTFDataStream(inputStream));
    }

    public TTFTable readTable(String str) {
        return new TTFTable();
    }

    public TTFParser(boolean z) {
        this(z, false);
    }

    public TrueTypeFont parse(File file) throws IOException {
        return parse((TTFDataStream) new RAFDataStream(file, (String) "r"));
    }

    public TTFParser(boolean z, boolean z2) {
        this.isEmbedded = false;
        this.parseOnDemandOnly = false;
        this.isEmbedded = z;
        this.parseOnDemandOnly = z2;
    }

    public TrueTypeFont parse(InputStream inputStream) throws IOException {
        return parse((TTFDataStream) new MemoryTTFDataStream(inputStream));
    }

    public TrueTypeFont parse(TTFDataStream tTFDataStream) throws IOException {
        TrueTypeFont newFont = newFont(tTFDataStream);
        newFont.setVersion(tTFDataStream.read32Fixed());
        int readUnsignedShort = tTFDataStream.readUnsignedShort();
        tTFDataStream.readUnsignedShort();
        tTFDataStream.readUnsignedShort();
        tTFDataStream.readUnsignedShort();
        for (int i = 0; i < readUnsignedShort; i++) {
            newFont.addTable(readTableDirectory(tTFDataStream));
        }
        if (!this.parseOnDemandOnly) {
            parseTables(newFont, tTFDataStream);
        }
        return newFont;
    }
}
