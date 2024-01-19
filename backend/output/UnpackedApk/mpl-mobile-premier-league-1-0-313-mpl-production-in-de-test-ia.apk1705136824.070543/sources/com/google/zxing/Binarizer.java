package com.google.zxing;

import com.google.zxing.common.BitMatrix;

public abstract class Binarizer {
    public final RGBLuminanceSource source;

    public Binarizer(RGBLuminanceSource rGBLuminanceSource) {
        this.source = rGBLuminanceSource;
    }

    public abstract BitMatrix getBlackMatrix() throws NotFoundException;
}
