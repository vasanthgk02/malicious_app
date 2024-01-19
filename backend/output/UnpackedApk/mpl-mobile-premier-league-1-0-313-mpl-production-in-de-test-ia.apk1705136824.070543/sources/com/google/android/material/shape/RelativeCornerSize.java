package com.google.android.material.shape;

import android.graphics.RectF;
import java.util.Arrays;

public final class RelativeCornerSize implements CornerSize {
    public final float percent;

    public RelativeCornerSize(float f2) {
        this.percent = f2;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RelativeCornerSize)) {
            return false;
        }
        if (this.percent != ((RelativeCornerSize) obj).percent) {
            z = false;
        }
        return z;
    }

    public float getCornerSize(RectF rectF) {
        return rectF.height() * this.percent;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Float.valueOf(this.percent)});
    }
}
