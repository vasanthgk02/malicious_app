package com.google.zxing.datamatrix.encoder;

import com.google.zxing.Dimension;
import java.nio.charset.Charset;

public final class EncoderContext {
    public final StringBuilder codewords;
    public Dimension maxSize;
    public Dimension minSize;
    public final String msg;
    public int newEncoding;
    public int pos;
    public SymbolShapeHint shape;
    public int skipAtEnd;
    public SymbolInfo symbolInfo;

    public EncoderContext(String str) {
        byte[] bytes = str.getBytes(Charset.forName("ISO-8859-1"));
        StringBuilder sb = new StringBuilder(bytes.length);
        int length = bytes.length;
        int i = 0;
        while (i < length) {
            char c2 = (char) (bytes[i] & 255);
            if (c2 != '?' || str.charAt(i) == '?') {
                sb.append(c2);
                i++;
            } else {
                throw new IllegalArgumentException("Message contains characters outside ISO-8859-1 encoding.");
            }
        }
        this.msg = sb.toString();
        this.shape = SymbolShapeHint.FORCE_NONE;
        this.codewords = new StringBuilder(str.length());
        this.newEncoding = -1;
    }

    public int getCodewordCount() {
        return this.codewords.length();
    }

    public char getCurrentChar() {
        return this.msg.charAt(this.pos);
    }

    public int getRemainingCharacters() {
        return (this.msg.length() - this.skipAtEnd) - this.pos;
    }

    public boolean hasMoreCharacters() {
        return this.pos < this.msg.length() - this.skipAtEnd;
    }

    public void updateSymbolInfo() {
        updateSymbolInfo(getCodewordCount());
    }

    public void updateSymbolInfo(int i) {
        SymbolInfo symbolInfo2 = this.symbolInfo;
        if (symbolInfo2 == null || i > symbolInfo2.dataCapacity) {
            this.symbolInfo = SymbolInfo.lookup(i, this.shape, this.minSize, this.maxSize, true);
        }
    }
}
