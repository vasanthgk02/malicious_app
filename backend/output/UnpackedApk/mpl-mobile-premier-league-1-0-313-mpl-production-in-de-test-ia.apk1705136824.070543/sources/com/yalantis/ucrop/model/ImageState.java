package com.yalantis.ucrop.model;

import android.graphics.RectF;

public class ImageState {
    public RectF mCropRect;
    public float mCurrentAngle;
    public RectF mCurrentImageRect;
    public float mCurrentScale;

    public ImageState(RectF rectF, RectF rectF2, float f2, float f3) {
        this.mCropRect = rectF;
        this.mCurrentImageRect = rectF2;
        this.mCurrentScale = f2;
        this.mCurrentAngle = f3;
    }
}
