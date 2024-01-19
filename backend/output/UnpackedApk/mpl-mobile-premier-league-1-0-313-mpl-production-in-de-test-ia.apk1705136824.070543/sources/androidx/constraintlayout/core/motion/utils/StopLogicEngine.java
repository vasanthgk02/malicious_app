package androidx.constraintlayout.core.motion.utils;

public class StopLogicEngine implements StopEngine {
    public boolean mBackwards = false;
    public float mLastPosition;
    public int mNumberOfStages;
    public float mStage1Duration;
    public float mStage1EndPosition;
    public float mStage1Velocity;
    public float mStage2Duration;
    public float mStage2EndPosition;
    public float mStage2Velocity;
    public float mStage3Duration;
    public float mStage3EndPosition;
    public float mStage3Velocity;
    public float mStartPosition;

    public float getInterpolation(float f2) {
        float f3;
        float f4 = this.mStage1Duration;
        if (f2 <= f4) {
            float f5 = this.mStage1Velocity;
            f3 = ((((this.mStage2Velocity - f5) * f2) * f2) / (f4 * 2.0f)) + (f5 * f2);
        } else {
            int i = this.mNumberOfStages;
            if (i == 1) {
                f3 = this.mStage1EndPosition;
            } else {
                float f6 = f2 - f4;
                float f7 = this.mStage2Duration;
                if (f6 < f7) {
                    float f8 = this.mStage1EndPosition;
                    float f9 = this.mStage2Velocity;
                    f3 = ((((this.mStage3Velocity - f9) * f6) * f6) / (f7 * 2.0f)) + (f9 * f6) + f8;
                } else if (i == 2) {
                    f3 = this.mStage2EndPosition;
                } else {
                    float f10 = f6 - f7;
                    float f11 = this.mStage3Duration;
                    if (f10 <= f11) {
                        float f12 = this.mStage2EndPosition;
                        float f13 = this.mStage3Velocity * f10;
                        f3 = (f12 + f13) - ((f13 * f10) / (f11 * 2.0f));
                    } else {
                        f3 = this.mStage3EndPosition;
                    }
                }
            }
        }
        this.mLastPosition = f2;
        return this.mBackwards ? this.mStartPosition - f3 : this.mStartPosition + f3;
    }

    public float getVelocity(float f2) {
        float f3;
        float f4;
        float f5 = this.mStage1Duration;
        if (f2 <= f5) {
            f3 = this.mStage1Velocity;
            f4 = this.mStage2Velocity;
        } else {
            int i = this.mNumberOfStages;
            if (i == 1) {
                return 0.0f;
            }
            f2 -= f5;
            f5 = this.mStage2Duration;
            if (f2 < f5) {
                f3 = this.mStage2Velocity;
                f4 = this.mStage3Velocity;
            } else if (i == 2) {
                return this.mStage2EndPosition;
            } else {
                float f6 = f2 - f5;
                float f7 = this.mStage3Duration;
                if (f6 >= f7) {
                    return this.mStage3EndPosition;
                }
                float f8 = this.mStage3Velocity;
                return f8 - ((f6 * f8) / f7);
            }
        }
        return (((f4 - f3) * f2) / f5) + f3;
    }

    public boolean isStopped() {
        return getVelocity() < 1.0E-5f && Math.abs(this.mStage3EndPosition - this.mLastPosition) < 1.0E-5f;
    }

    public final void setup(float f2, float f3, float f4, float f5, float f6) {
        if (f2 == 0.0f) {
            f2 = 1.0E-4f;
        }
        this.mStage1Velocity = f2;
        float f7 = f2 / f4;
        float f8 = (f7 * f2) / 2.0f;
        if (f2 < 0.0f) {
            float sqrt = (float) Math.sqrt((double) ((f3 - ((((-f2) / f4) * f2) / 2.0f)) * f4));
            if (sqrt < f5) {
                this.mNumberOfStages = 2;
                this.mStage1Velocity = f2;
                this.mStage2Velocity = sqrt;
                this.mStage3Velocity = 0.0f;
                float f9 = (sqrt - f2) / f4;
                this.mStage1Duration = f9;
                this.mStage2Duration = sqrt / f4;
                this.mStage1EndPosition = ((f2 + sqrt) * f9) / 2.0f;
                this.mStage2EndPosition = f3;
                this.mStage3EndPosition = f3;
                return;
            }
            this.mNumberOfStages = 3;
            this.mStage1Velocity = f2;
            this.mStage2Velocity = f5;
            this.mStage3Velocity = f5;
            float f10 = (f5 - f2) / f4;
            this.mStage1Duration = f10;
            float f11 = f5 / f4;
            this.mStage3Duration = f11;
            float f12 = ((f2 + f5) * f10) / 2.0f;
            float f13 = (f11 * f5) / 2.0f;
            this.mStage2Duration = ((f3 - f12) - f13) / f5;
            this.mStage1EndPosition = f12;
            this.mStage2EndPosition = f3 - f13;
            this.mStage3EndPosition = f3;
        } else if (f8 >= f3) {
            this.mNumberOfStages = 1;
            this.mStage1Velocity = f2;
            this.mStage2Velocity = 0.0f;
            this.mStage1EndPosition = f3;
            this.mStage1Duration = (2.0f * f3) / f2;
        } else {
            float f14 = f3 - f8;
            float f15 = f14 / f2;
            if (f15 + f7 < f6) {
                this.mNumberOfStages = 2;
                this.mStage1Velocity = f2;
                this.mStage2Velocity = f2;
                this.mStage3Velocity = 0.0f;
                this.mStage1EndPosition = f14;
                this.mStage2EndPosition = f3;
                this.mStage1Duration = f15;
                this.mStage2Duration = f7;
                return;
            }
            float sqrt2 = (float) Math.sqrt((double) (((f2 * f2) / 2.0f) + (f4 * f3)));
            float f16 = (sqrt2 - f2) / f4;
            this.mStage1Duration = f16;
            float f17 = sqrt2 / f4;
            this.mStage2Duration = f17;
            if (sqrt2 < f5) {
                this.mNumberOfStages = 2;
                this.mStage1Velocity = f2;
                this.mStage2Velocity = sqrt2;
                this.mStage3Velocity = 0.0f;
                this.mStage1Duration = f16;
                this.mStage2Duration = f17;
                this.mStage1EndPosition = ((f2 + sqrt2) * f16) / 2.0f;
                this.mStage2EndPosition = f3;
                return;
            }
            this.mNumberOfStages = 3;
            this.mStage1Velocity = f2;
            this.mStage2Velocity = f5;
            this.mStage3Velocity = f5;
            float f18 = (f5 - f2) / f4;
            this.mStage1Duration = f18;
            float f19 = f5 / f4;
            this.mStage3Duration = f19;
            float f20 = ((f2 + f5) * f18) / 2.0f;
            float f21 = (f19 * f5) / 2.0f;
            this.mStage2Duration = ((f3 - f20) - f21) / f5;
            this.mStage1EndPosition = f20;
            this.mStage2EndPosition = f3 - f21;
            this.mStage3EndPosition = f3;
        }
    }

    public float getVelocity() {
        return this.mBackwards ? -getVelocity(this.mLastPosition) : getVelocity(this.mLastPosition);
    }
}
