package com.google.zxing;

import com.google.zxing.common.BitMatrix;

public final class BinaryBitmap {
    public final Binarizer binarizer;
    public BitMatrix matrix;

    public BinaryBitmap(Binarizer binarizer2) {
        this.binarizer = binarizer2;
    }

    public String toString() {
        try {
            if (this.matrix == null) {
                this.matrix = this.binarizer.getBlackMatrix();
            }
            return this.matrix.toString();
        } catch (NotFoundException unused) {
            return "";
        }
    }
}
