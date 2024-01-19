package org.apache.fontbox.ttf;

import java.io.IOException;

public class IndexToLocationTable extends TTFTable {
    public static final short LONG_OFFSETS = 1;
    public static final short SHORT_OFFSETS = 0;
    public static final String TAG = "loca";
    public long[] offsets;

    public long[] getOffsets() {
        return this.offsets;
    }

    public void read(TrueTypeFont trueTypeFont, TTFDataStream tTFDataStream) throws IOException {
        HeaderTable header = trueTypeFont.getHeader();
        int numberOfGlyphs = trueTypeFont.getNumberOfGlyphs() + 1;
        this.offsets = new long[numberOfGlyphs];
        for (int i = 0; i < numberOfGlyphs; i++) {
            if (header.getIndexToLocFormat() == 0) {
                this.offsets[i] = (long) (tTFDataStream.readUnsignedShort() * 2);
            } else if (header.getIndexToLocFormat() == 1) {
                this.offsets[i] = tTFDataStream.readUnsignedInt();
            } else {
                throw new IOException("Error:TTF.loca unknown offset format.");
            }
        }
        this.initialized = true;
    }

    public void setOffsets(long[] jArr) {
        this.offsets = jArr;
    }
}
