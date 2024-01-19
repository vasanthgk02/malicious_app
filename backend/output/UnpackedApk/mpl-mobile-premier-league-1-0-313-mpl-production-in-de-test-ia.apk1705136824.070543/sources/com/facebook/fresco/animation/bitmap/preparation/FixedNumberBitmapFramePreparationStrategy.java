package com.facebook.fresco.animation.bitmap.preparation;

public class FixedNumberBitmapFramePreparationStrategy implements BitmapFramePreparationStrategy {
    public static final Class<?> TAG = FixedNumberBitmapFramePreparationStrategy.class;
    public final int mFramesToPrepare;

    public FixedNumberBitmapFramePreparationStrategy() {
        this.mFramesToPrepare = 3;
    }

    public FixedNumberBitmapFramePreparationStrategy(int i) {
        this.mFramesToPrepare = i;
    }
}
