package androidx.dynamicanimation.animation;

import androidx.dynamicanimation.animation.DynamicAnimation.MassState;

public final class SpringForce {
    public double mDampedFreq;
    public double mDampingRatio = 0.5d;
    public double mFinalPosition = Double.MAX_VALUE;
    public double mGammaMinus;
    public double mGammaPlus;
    public boolean mInitialized = false;
    public final MassState mMassState = new MassState();
    public double mNaturalFreq = Math.sqrt(1500.0d);
    public double mValueThreshold;
    public double mVelocityThreshold;

    public SpringForce() {
    }

    public SpringForce setStiffness(float f2) {
        if (f2 > 0.0f) {
            this.mNaturalFreq = Math.sqrt((double) f2);
            this.mInitialized = false;
            return this;
        }
        throw new IllegalArgumentException("Spring stiffness constant must be positive.");
    }

    public MassState updateValues(double d2, double d3, long j) {
        double d4;
        double d5;
        if (!this.mInitialized) {
            if (this.mFinalPosition != Double.MAX_VALUE) {
                double d6 = this.mDampingRatio;
                if (d6 > 1.0d) {
                    double d7 = this.mNaturalFreq;
                    this.mGammaPlus = (Math.sqrt((d6 * d6) - 1.0d) * d7) + ((-d6) * d7);
                    double d8 = this.mDampingRatio;
                    double d9 = this.mNaturalFreq;
                    this.mGammaMinus = ((-d8) * d9) - (Math.sqrt((d8 * d8) - 1.0d) * d9);
                } else if (d6 >= 0.0d && d6 < 1.0d) {
                    this.mDampedFreq = Math.sqrt(1.0d - (d6 * d6)) * this.mNaturalFreq;
                }
                this.mInitialized = true;
            } else {
                throw new IllegalStateException("Error: Final position of the spring must be set before the animation starts");
            }
        }
        double d10 = ((double) j) / 1000.0d;
        double d11 = d2 - this.mFinalPosition;
        double d12 = this.mDampingRatio;
        if (d12 > 1.0d) {
            double d13 = this.mGammaMinus;
            double d14 = this.mGammaPlus;
            double d15 = d11 - (((d13 * d11) - d3) / (d13 - d14));
            double d16 = ((d11 * d13) - d3) / (d13 - d14);
            d4 = (Math.pow(2.718281828459045d, this.mGammaPlus * d10) * d16) + (Math.pow(2.718281828459045d, d13 * d10) * d15);
            double d17 = this.mGammaMinus;
            double pow = Math.pow(2.718281828459045d, d17 * d10) * d15 * d17;
            double d18 = this.mGammaPlus;
            d5 = (Math.pow(2.718281828459045d, d18 * d10) * d16 * d18) + pow;
        } else if (d12 == 1.0d) {
            double d19 = this.mNaturalFreq;
            double d20 = (d19 * d11) + d3;
            double d21 = (d20 * d10) + d11;
            double pow2 = Math.pow(2.718281828459045d, (-d19) * d10) * d21;
            double pow3 = Math.pow(2.718281828459045d, (-this.mNaturalFreq) * d10) * d21;
            double d22 = this.mNaturalFreq;
            d5 = (Math.pow(2.718281828459045d, (-d22) * d10) * d20) + (pow3 * (-d22));
            d4 = pow2;
        } else {
            double d23 = 1.0d / this.mDampedFreq;
            double d24 = this.mNaturalFreq;
            double d25 = ((d12 * d24 * d11) + d3) * d23;
            double sin = ((Math.sin(this.mDampedFreq * d10) * d25) + (Math.cos(this.mDampedFreq * d10) * d11)) * Math.pow(2.718281828459045d, (-d12) * d24 * d10);
            double d26 = this.mNaturalFreq;
            double d27 = this.mDampingRatio;
            double d28 = (-d26) * sin * d27;
            double pow4 = Math.pow(2.718281828459045d, (-d27) * d26 * d10);
            double d29 = this.mDampedFreq;
            double d30 = sin;
            double d31 = (-d29) * d11;
            double d32 = this.mDampedFreq;
            d5 = (((Math.cos(d32 * d10) * d25 * d32) + (Math.sin(d29 * d10) * d31)) * pow4) + d28;
            d4 = d30;
        }
        MassState massState = this.mMassState;
        massState.mValue = (float) (d4 + this.mFinalPosition);
        massState.mVelocity = (float) d5;
        return massState;
    }

    public SpringForce(float f2) {
        this.mFinalPosition = (double) f2;
    }
}
