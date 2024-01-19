package org.apache.fontbox.ttf;

import java.io.IOException;
import org.apache.fontbox.cff.CFFFont;
import org.apache.fontbox.cff.CFFParser;

public class CFFTable extends TTFTable {
    public static final String TAG = "CFF ";
    public CFFFont cffFont;

    public CFFFont getFont() {
        return this.cffFont;
    }

    public void read(TrueTypeFont trueTypeFont, TTFDataStream tTFDataStream) throws IOException {
        this.cffFont = new CFFParser().parse(tTFDataStream.read((int) getLength())).get(0);
        this.initialized = true;
    }
}
