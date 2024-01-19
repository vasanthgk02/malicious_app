package com.facebook.drawee.generic;

import java.util.Arrays;

public class RoundingParams {
    public int mBorderColor = 0;
    public float mBorderWidth = 0.0f;
    public float[] mCornersRadii = null;
    public int mOverlayColor = 0;
    public float mPadding = 0.0f;
    public boolean mPaintFilterBitmap = false;
    public boolean mRoundAsCircle = false;
    public RoundingMethod mRoundingMethod = RoundingMethod.BITMAP_ONLY;
    public boolean mScaleDownInsideBorders = false;

    public enum RoundingMethod {
        OVERLAY_COLOR,
        BITMAP_ONLY
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || RoundingParams.class != obj.getClass()) {
            return false;
        }
        RoundingParams roundingParams = (RoundingParams) obj;
        if (this.mRoundAsCircle == roundingParams.mRoundAsCircle && this.mOverlayColor == roundingParams.mOverlayColor && Float.compare(roundingParams.mBorderWidth, this.mBorderWidth) == 0 && this.mBorderColor == roundingParams.mBorderColor && Float.compare(roundingParams.mPadding, this.mPadding) == 0 && this.mRoundingMethod == roundingParams.mRoundingMethod && this.mScaleDownInsideBorders == roundingParams.mScaleDownInsideBorders && this.mPaintFilterBitmap == roundingParams.mPaintFilterBitmap) {
            return Arrays.equals(this.mCornersRadii, roundingParams.mCornersRadii);
        }
        return false;
    }

    public int hashCode() {
        RoundingMethod roundingMethod = this.mRoundingMethod;
        int i = 0;
        int hashCode = (((roundingMethod != null ? roundingMethod.hashCode() : 0) * 31) + (this.mRoundAsCircle ? 1 : 0)) * 31;
        float[] fArr = this.mCornersRadii;
        int hashCode2 = (((hashCode + (fArr != null ? Arrays.hashCode(fArr) : 0)) * 31) + this.mOverlayColor) * 31;
        float f2 = this.mBorderWidth;
        int floatToIntBits = (((hashCode2 + (f2 != 0.0f ? Float.floatToIntBits(f2) : 0)) * 31) + this.mBorderColor) * 31;
        float f3 = this.mPadding;
        if (f3 != 0.0f) {
            i = Float.floatToIntBits(f3);
        }
        return ((((floatToIntBits + i) * 31) + (this.mScaleDownInsideBorders ? 1 : 0)) * 31) + (this.mPaintFilterBitmap ? 1 : 0);
    }

    public RoundingParams setCornersRadii(float f2, float f3, float f4, float f5) {
        if (this.mCornersRadii == null) {
            this.mCornersRadii = new float[8];
        }
        float[] fArr = this.mCornersRadii;
        fArr[1] = f2;
        fArr[0] = f2;
        fArr[3] = f3;
        fArr[2] = f3;
        fArr[5] = f4;
        fArr[4] = f4;
        fArr[7] = f5;
        fArr[6] = f5;
        return this;
    }
}
