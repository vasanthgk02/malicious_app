package com.google.zxing.pdf417.decoder;

public final class Codeword {
    public final int bucket;
    public final int endX;
    public int rowNumber = -1;
    public final int startX;
    public final int value;

    public Codeword(int i, int i2, int i3, int i4) {
        this.startX = i;
        this.endX = i2;
        this.bucket = i3;
        this.value = i4;
    }

    public boolean hasValidRowNumber() {
        int i = this.rowNumber;
        return i != -1 && this.bucket == (i % 3) * 3;
    }

    public void setRowNumberAsRowIndicatorColumn() {
        this.rowNumber = (this.bucket / 3) + ((this.value / 30) * 3);
    }

    public String toString() {
        return this.rowNumber + "|" + this.value;
    }
}
