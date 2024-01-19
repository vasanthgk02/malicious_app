package com.facebook.drawee.drawable;

import android.graphics.Matrix;
import android.graphics.Rect;

public class ScalingUtils$ScaleTypeCenterCrop extends ScalingUtils$AbstractScaleType {
    public static final ScalingUtils$ScaleType INSTANCE = new ScalingUtils$ScaleTypeCenterCrop();

    public void getTransformImpl(Matrix matrix, Rect rect, int i, int i2, float f2, float f3, float f4, float f5) {
        float f6;
        float f7;
        if (f5 > f4) {
            f6 = ((((float) rect.width()) - (((float) i) * f5)) * 0.5f) + ((float) rect.left);
            f7 = (float) rect.top;
            f4 = f5;
        } else {
            f6 = (float) rect.left;
            f7 = ((((float) rect.height()) - (((float) i2) * f4)) * 0.5f) + ((float) rect.top);
        }
        matrix.setScale(f4, f4);
        matrix.postTranslate((float) ((int) (f6 + 0.5f)), (float) ((int) (f7 + 0.5f)));
    }

    public String toString() {
        return "center_crop";
    }
}
