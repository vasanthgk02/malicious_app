package com.google.zxing;

import java.util.Map;

public final class Result {
    public Map<ResultMetadataType, Object> resultMetadata = null;
    public final String text;

    public Result(String str, byte[] bArr, ResultPoint[] resultPointArr, BarcodeFormat barcodeFormat) {
        System.currentTimeMillis();
        this.text = str;
    }

    public String toString() {
        return this.text;
    }
}
