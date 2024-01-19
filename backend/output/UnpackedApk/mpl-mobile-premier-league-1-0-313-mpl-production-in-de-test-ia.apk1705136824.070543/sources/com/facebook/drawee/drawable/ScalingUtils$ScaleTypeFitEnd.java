package com.facebook.drawee.drawable;

import android.graphics.Matrix;
import android.graphics.Rect;

public class ScalingUtils$ScaleTypeFitEnd extends ScalingUtils$AbstractScaleType {
    public static final ScalingUtils$ScaleType INSTANCE = new ScalingUtils$ScaleTypeFitEnd();

    public void getTransformImpl(Matrix matrix, Rect rect, int i, int i2, float f2, float f3, float f4, float f5) {
        float min = Math.min(f4, f5);
        float width = ((float) rect.width()) - (((float) i) * min);
        float height = ((float) rect.height()) - (((float) i2) * min);
        matrix.setScale(min, min);
        matrix.postTranslate((float) ((int) (width + ((float) rect.left) + 0.5f)), (float) ((int) (height + ((float) rect.top) + 0.5f)));
    }

    public String toString() {
        return "fit_end";
    }
}
