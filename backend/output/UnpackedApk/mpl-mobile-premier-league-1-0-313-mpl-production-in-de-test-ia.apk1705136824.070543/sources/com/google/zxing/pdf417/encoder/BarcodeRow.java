package com.google.zxing.pdf417.encoder;

public final class BarcodeRow {
    public int currentLocation = 0;
    public final byte[] row;

    public BarcodeRow(int i) {
        this.row = new byte[i];
    }

    public void addBar(boolean z, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            int i3 = this.currentLocation;
            this.currentLocation = i3 + 1;
            this.row[i3] = z ? (byte) 1 : 0;
        }
    }
}
