package androidx.constraintlayout.core.motion.utils;

public class VelocityMatrix {
    public float mDRotate;
    public float mDScaleX;
    public float mDScaleY;
    public float mDTranslateX;
    public float mDTranslateY;
    public float mRotate;

    public void applyTransform(float f2, float f3, int i, int i2, float[] fArr) {
        int i3 = i;
        float f4 = fArr[0];
        float f5 = fArr[1];
        float f6 = (f2 - 0.5f) * 2.0f;
        float f7 = (f3 - 0.5f) * 2.0f;
        float f8 = f4 + this.mDTranslateX;
        float f9 = f5 + this.mDTranslateY;
        float f10 = (this.mDScaleX * f6) + f8;
        float f11 = (this.mDScaleY * f7) + f9;
        float radians = (float) Math.toRadians((double) this.mRotate);
        float radians2 = (float) Math.toRadians((double) this.mDRotate);
        double d2 = (double) radians;
        double sin = Math.sin(d2);
        double d3 = (double) (((float) i2) * f7);
        double cos = Math.cos(d2);
        fArr[0] = (((float) ((sin * ((double) (((float) (-i3)) * f6))) - (Math.cos(d2) * d3))) * radians2) + f10;
        fArr[1] = (radians2 * ((float) ((cos * ((double) (((float) i3) * f6))) - (Math.sin(d2) * d3)))) + f11;
    }

    public void setRotationVelocity(SplineSet splineSet, float f2) {
        if (splineSet != null) {
            double d2 = (double) f2;
            this.mDRotate = (float) splineSet.mCurveFit.getSlope(d2, 0);
            this.mRotate = (float) splineSet.mCurveFit.getPos(d2, 0);
        }
    }

    public void setScaleVelocity(SplineSet splineSet, SplineSet splineSet2, float f2) {
        if (splineSet != null) {
            this.mDScaleX = (float) splineSet.mCurveFit.getSlope((double) f2, 0);
        }
        if (splineSet2 != null) {
            this.mDScaleY = (float) splineSet2.mCurveFit.getSlope((double) f2, 0);
        }
    }

    public void setTranslationVelocity(SplineSet splineSet, SplineSet splineSet2, float f2) {
        if (splineSet != null) {
            this.mDTranslateX = (float) splineSet.mCurveFit.getSlope((double) f2, 0);
        }
        if (splineSet2 != null) {
            this.mDTranslateY = (float) splineSet2.mCurveFit.getSlope((double) f2, 0);
        }
    }
}
