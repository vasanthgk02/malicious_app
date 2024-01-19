package com.facebook.react.uimanager;

import com.facebook.drawee.backends.pipeline.info.ImageOriginUtils;

public class Spacing {
    public static final int[] sFlagsMap = {1, 2, 4, 8, 16, 32, 64, 128, 256};
    public final float mDefaultValue;
    public boolean mHasAliasesSet;
    public final float[] mSpacing;
    public int mValueFlags = 0;

    public Spacing(float f2) {
        this.mDefaultValue = f2;
        this.mSpacing = new float[]{Float.NaN, Float.NaN, Float.NaN, Float.NaN, Float.NaN, Float.NaN, Float.NaN, Float.NaN, Float.NaN};
    }

    public float get(int i) {
        float f2 = (i == 4 || i == 5) ? Float.NaN : this.mDefaultValue;
        int i2 = this.mValueFlags;
        if (i2 == 0) {
            return f2;
        }
        if ((i2 & sFlagsMap[i]) != 0) {
            return this.mSpacing[i];
        }
        if (this.mHasAliasesSet) {
            char c2 = (i == 1 || i == 3) ? (char) 7 : 6;
            int i3 = this.mValueFlags;
            int[] iArr = sFlagsMap;
            if ((iArr[c2] & i3) != 0) {
                return this.mSpacing[c2];
            }
            if ((i3 & iArr[8]) != 0) {
                return this.mSpacing[8];
            }
        }
        return f2;
    }

    public boolean set(int i, float f2) {
        boolean z = false;
        if (ImageOriginUtils.floatsEqual(this.mSpacing[i], f2)) {
            return false;
        }
        this.mSpacing[i] = f2;
        if (ImageOriginUtils.isUndefined(f2)) {
            this.mValueFlags = (~sFlagsMap[i]) & this.mValueFlags;
        } else {
            this.mValueFlags = sFlagsMap[i] | this.mValueFlags;
        }
        int i2 = this.mValueFlags;
        int[] iArr = sFlagsMap;
        if (!((iArr[8] & i2) == 0 && (iArr[7] & i2) == 0 && (i2 & iArr[6]) == 0)) {
            z = true;
        }
        this.mHasAliasesSet = z;
        return true;
    }
}
