package org.apache.fontbox.ttf;

import java.io.IOException;

public class TTFTable {
    public long checkSum;
    public boolean initialized = false;
    public long length;
    public long offset;
    public String tag;

    public long getCheckSum() {
        return this.checkSum;
    }

    public boolean getInitialized() {
        return this.initialized;
    }

    public long getLength() {
        return this.length;
    }

    public long getOffset() {
        return this.offset;
    }

    public String getTag() {
        return this.tag;
    }

    public void read(TrueTypeFont trueTypeFont, TTFDataStream tTFDataStream) throws IOException {
    }

    public void setCheckSum(long j) {
        this.checkSum = j;
    }

    public void setLength(long j) {
        this.length = j;
    }

    public void setOffset(long j) {
        this.offset = j;
    }

    public void setTag(String str) {
        this.tag = str;
    }
}
