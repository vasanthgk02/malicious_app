package com.google.zxing.common;

import java.util.List;

public final class DecoderResult {
    public final String ecLevel;
    public Object other;
    public final byte[] rawBytes = null;
    public final String text;

    public DecoderResult(byte[] bArr, String str, List<byte[]> list, String str2) {
        this.text = str;
        this.ecLevel = str2;
    }
}
