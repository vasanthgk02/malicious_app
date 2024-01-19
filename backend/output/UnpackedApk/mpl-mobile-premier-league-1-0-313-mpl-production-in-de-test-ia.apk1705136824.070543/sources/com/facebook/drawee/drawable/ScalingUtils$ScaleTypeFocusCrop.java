package com.facebook.drawee.drawable;

import android.graphics.Matrix;
import android.graphics.Rect;

public class ScalingUtils$ScaleTypeFocusCrop extends ScalingUtils$AbstractScaleType {
    public static final ScalingUtils$ScaleType INSTANCE = new ScalingUtils$ScaleTypeFocusCrop();

    public void getTransformImpl(Matrix matrix, Rect rect, int i, int i2, float f2, float f3, float f4, float f5) {
        float f6;
        float f7;
        if (f5 > f4) {
            float f8 = ((float) i) * f5;
            f6 = Math.max(Math.min((((float) rect.width()) * 0.5f) - (f2 * f8), 0.0f), ((float) rect.width()) - f8) + ((float) rect.left);
            f7 = (float) rect.top;
            f4 = f5;
        } else {
            f6 = (float) rect.left;
            float f9 = ((float) i2) * f4;
            f7 = Math.max(Math.min((((float) rect.height()) * 0.5f) - (f3 * f9), 0.0f), ((float) rect.height()) - f9) + ((float) rect.top);
        }
        matrix.setScale(f4, f4);
        matrix.postTranslate((float) ((int) (f6 + 0.5f)), (float) ((int) (f7 + 0.5f)));
    }

    public String toString() {
        return "focus_crop";
    }
}
