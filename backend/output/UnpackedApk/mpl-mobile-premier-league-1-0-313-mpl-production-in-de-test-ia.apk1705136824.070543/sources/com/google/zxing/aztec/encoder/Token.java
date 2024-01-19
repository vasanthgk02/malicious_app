package com.google.zxing.aztec.encoder;

import com.google.zxing.common.BitArray;

public abstract class Token {
    public static final Token EMPTY = new SimpleToken(null, 0, 0);
    public final Token previous;

    public Token(Token token) {
        this.previous = token;
    }

    public abstract void appendTo(BitArray bitArray, byte[] bArr);
}
