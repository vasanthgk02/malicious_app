package com.facebook.drawee.drawable;

import android.graphics.Matrix;
import android.graphics.Rect;

public class ScalingUtils$ScaleTypeFitCenter extends ScalingUtils$AbstractScaleType {
    public static final ScalingUtils$ScaleType INSTANCE = new ScalingUtils$ScaleTypeFitCenter();

    public void getTransformImpl(Matrix matrix, Rect rect, int i, int i2, float f2, float f3, float f4, float f5) {
        float min = Math.min(f4, f5);
        float width = ((((float) rect.width()) - (((float) i) * min)) * 0.5f) + ((float) rect.left);
        float height = (((float) rect.height()) - (((float) i2) * min)) * 0.5f;
        matrix.setScale(min, min);
        matrix.postTranslate((float) ((int) (width + 0.5f)), (float) ((int) (height + ((float) rect.top) + 0.5f)));
    }

    public String toString() {
        return "fit_center";
    }
}
