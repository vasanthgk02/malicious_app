package androidx.constraintlayout.core.motion.utils;

public class SpringStopEngine implements StopEngine {
    public int mBoundaryMode = 0;
    public double mDamping = 0.5d;
    public float mLastTime;
    public float mMass;
    public float mPos;
    public double mStiffness;
    public float mStopThreshold;
    public double mTargetPos;
    public float mV;

    public float getInterpolation(float f2) {
        SpringStopEngine springStopEngine = this;
        double d2 = (double) (f2 - springStopEngine.mLastTime);
        double d3 = springStopEngine.mStiffness;
        double d4 = springStopEngine.mDamping;
        int sqrt = (int) ((9.0d / ((Math.sqrt(d3 / ((double) springStopEngine.mMass)) * d2) * 4.0d)) + 1.0d);
        double d5 = d2 / ((double) sqrt);
        int i = 0;
        while (i < sqrt) {
            double d6 = (double) springStopEngine.mPos;
            double d7 = springStopEngine.mTargetPos;
            int i2 = sqrt;
            int i3 = i;
            double d8 = (double) springStopEngine.mV;
            double d9 = (double) springStopEngine.mMass;
            double d10 = ((((((-d3) * (d6 - d7)) - (d8 * d4)) / d9) * d5) / 2.0d) + d8;
            double d11 = ((((-((((d5 * d10) / 2.0d) + d6) - d7)) * d3) - (d10 * d4)) / d9) * d5;
            float f3 = (float) (d8 + d11);
            this.mV = f3;
            float f4 = (float) ((((d11 / 2.0d) + d8) * d5) + d6);
            this.mPos = f4;
            int i4 = this.mBoundaryMode;
            if (i4 > 0) {
                if (f4 < 0.0f && (i4 & 1) == 1) {
                    this.mPos = -f4;
                    this.mV = -f3;
                }
                float f5 = this.mPos;
                if (f5 > 1.0f && (this.mBoundaryMode & 2) == 2) {
                    this.mPos = 2.0f - f5;
                    this.mV = -this.mV;
                }
            }
            float f6 = f2;
            sqrt = i2;
            i = i3 + 1;
            springStopEngine = this;
        }
        SpringStopEngine springStopEngine2 = springStopEngine;
        springStopEngine2.mLastTime = f2;
        return springStopEngine2.mPos;
    }

    public float getVelocity() {
        return 0.0f;
    }

    public boolean isStopped() {
        double d2 = ((double) this.mPos) - this.mTargetPos;
        double d3 = this.mStiffness;
        double d4 = (double) this.mV;
        return Math.sqrt((((d3 * d2) * d2) + ((d4 * d4) * ((double) this.mMass))) / d3) <= ((double) this.mStopThreshold);
    }
}
