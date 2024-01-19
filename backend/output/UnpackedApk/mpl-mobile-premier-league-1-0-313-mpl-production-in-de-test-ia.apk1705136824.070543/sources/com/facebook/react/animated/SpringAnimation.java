package com.facebook.react.animated;

import com.facebook.react.bridge.ReadableMap;

public class SpringAnimation extends AnimationDriver {
    public int mCurrentLoop;
    public final PhysicsState mCurrentState;
    public double mDisplacementFromRestThreshold;
    public double mEndValue;
    public double mInitialVelocity;
    public int mIterations;
    public long mLastTime;
    public double mOriginalValue;
    public boolean mOvershootClampingEnabled;
    public double mRestSpeedThreshold;
    public double mSpringDamping;
    public double mSpringMass;
    public boolean mSpringStarted;
    public double mSpringStiffness;
    public double mStartValue;
    public double mTimeAccumulator;

    public static class PhysicsState {
        public double position;
        public double velocity;

        public PhysicsState(AnonymousClass1 r1) {
        }
    }

    public SpringAnimation(ReadableMap readableMap) {
        PhysicsState physicsState = new PhysicsState(null);
        this.mCurrentState = physicsState;
        physicsState.velocity = readableMap.getDouble("initialVelocity");
        resetConfig(readableMap);
    }

    public final boolean isAtRest() {
        if (Math.abs(this.mCurrentState.velocity) <= this.mRestSpeedThreshold) {
            if (Math.abs(this.mEndValue - this.mCurrentState.position) <= this.mDisplacementFromRestThreshold || this.mSpringStiffness == 0.0d) {
                return true;
            }
        }
        return false;
    }

    public void resetConfig(ReadableMap readableMap) {
        this.mSpringStiffness = readableMap.getDouble("stiffness");
        this.mSpringDamping = readableMap.getDouble("damping");
        this.mSpringMass = readableMap.getDouble("mass");
        this.mInitialVelocity = this.mCurrentState.velocity;
        this.mEndValue = readableMap.getDouble("toValue");
        this.mRestSpeedThreshold = readableMap.getDouble("restSpeedThreshold");
        this.mDisplacementFromRestThreshold = readableMap.getDouble("restDisplacementThreshold");
        this.mOvershootClampingEnabled = readableMap.getBoolean("overshootClamping");
        boolean z = true;
        int i = readableMap.hasKey("iterations") ? readableMap.getInt("iterations") : 1;
        this.mIterations = i;
        if (i != 0) {
            z = false;
        }
        this.mHasFinished = z;
        this.mCurrentLoop = 0;
        this.mTimeAccumulator = 0.0d;
        this.mSpringStarted = false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0132, code lost:
        if (r0.mCurrentState.position < r7) goto L_0x0134;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0137, code lost:
        if (r3 == false) goto L_0x0158;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void runAnimationStep(long r25) {
        /*
            r24 = this;
            r0 = r24
            r1 = 1000000(0xf4240, double:4.940656E-318)
            long r1 = r25 / r1
            boolean r3 = r0.mSpringStarted
            r4 = 0
            r6 = 1
            if (r3 != 0) goto L_0x002a
            int r3 = r0.mCurrentLoop
            if (r3 != 0) goto L_0x001a
            com.facebook.react.animated.ValueAnimatedNode r3 = r0.mAnimatedValue
            double r7 = r3.mValue
            r0.mOriginalValue = r7
            r0.mCurrentLoop = r6
        L_0x001a:
            com.facebook.react.animated.SpringAnimation$PhysicsState r3 = r0.mCurrentState
            com.facebook.react.animated.ValueAnimatedNode r7 = r0.mAnimatedValue
            double r7 = r7.mValue
            r3.position = r7
            r0.mStartValue = r7
            r0.mLastTime = r1
            r0.mTimeAccumulator = r4
            r0.mSpringStarted = r6
        L_0x002a:
            long r7 = r0.mLastTime
            long r7 = r1 - r7
            double r7 = (double) r7
            r9 = 4652007308841189376(0x408f400000000000, double:1000.0)
            double r7 = r7 / r9
            boolean r3 = r24.isAtRest()
            if (r3 == 0) goto L_0x003d
            goto L_0x0158
        L_0x003d:
            r10 = 4589276106681592316(0x3fb0624dd2f1a9fc, double:0.064)
            int r3 = (r7 > r10 ? 1 : (r7 == r10 ? 0 : -1))
            if (r3 <= 0) goto L_0x0047
            r7 = r10
        L_0x0047:
            double r10 = r0.mTimeAccumulator
            double r10 = r10 + r7
            r0.mTimeAccumulator = r10
            double r7 = r0.mSpringDamping
            double r10 = r0.mSpringMass
            double r12 = r0.mSpringStiffness
            double r14 = r0.mInitialVelocity
            double r14 = -r14
            r16 = 4611686018427387904(0x4000000000000000, double:2.0)
            double r18 = r12 * r10
            double r18 = java.lang.Math.sqrt(r18)
            double r18 = r18 * r16
            double r7 = r7 / r18
            double r12 = r12 / r10
            double r10 = java.lang.Math.sqrt(r12)
            double r12 = r7 * r7
            r16 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            double r12 = r16 - r12
            double r12 = java.lang.Math.sqrt(r12)
            double r12 = r12 * r10
            double r4 = r0.mEndValue
            r18 = r10
            double r9 = r0.mStartValue
            double r4 = r4 - r9
            double r9 = r0.mTimeAccumulator
            int r11 = (r7 > r16 ? 1 : (r7 == r16 ? 0 : -1))
            if (r11 >= 0) goto L_0x00d1
            r20 = r4
            double r3 = -r7
            double r3 = r3 * r18
            double r3 = r3 * r9
            double r3 = java.lang.Math.exp(r3)
            r22 = r12
            double r11 = r0.mEndValue
            double r7 = r7 * r18
            double r16 = r7 * r20
            double r16 = r16 + r14
            double r13 = r16 / r22
            double r9 = r9 * r22
            double r18 = java.lang.Math.sin(r9)
            double r18 = r18 * r13
            double r13 = java.lang.Math.cos(r9)
            double r13 = r13 * r20
            double r13 = r13 + r18
            double r13 = r13 * r3
            double r11 = r11 - r13
            double r7 = r7 * r3
            double r13 = java.lang.Math.sin(r9)
            double r13 = r13 * r16
            double r13 = r13 / r22
            double r18 = java.lang.Math.cos(r9)
            double r18 = r18 * r20
            double r18 = r18 + r13
            double r18 = r18 * r7
            double r7 = java.lang.Math.cos(r9)
            double r7 = r7 * r16
            double r13 = r22 * r20
            double r9 = java.lang.Math.sin(r9)
            double r9 = r9 * r13
            double r7 = r7 - r9
            double r7 = r7 * r3
            double r18 = r18 - r7
            goto L_0x00fa
        L_0x00d1:
            r20 = r4
            r3 = r18
            double r7 = -r3
            double r7 = r7 * r9
            double r7 = java.lang.Math.exp(r7)
            double r11 = r0.mEndValue
            double r18 = r3 * r20
            double r18 = r18 + r14
            double r18 = r18 * r9
            double r18 = r18 + r20
            double r18 = r18 * r7
            double r11 = r11 - r18
            double r18 = r9 * r3
            double r18 = r18 - r16
            double r18 = r18 * r14
            double r9 = r9 * r20
            double r3 = r3 * r3
            double r3 = r3 * r9
            double r3 = r3 + r18
            double r18 = r3 * r7
        L_0x00fa:
            r3 = r18
            com.facebook.react.animated.SpringAnimation$PhysicsState r7 = r0.mCurrentState
            r7.position = r11
            r7.velocity = r3
            boolean r3 = r24.isAtRest()
            if (r3 != 0) goto L_0x0139
            boolean r3 = r0.mOvershootClampingEnabled
            if (r3 == 0) goto L_0x0158
            double r3 = r0.mSpringStiffness
            r7 = 0
            int r9 = (r3 > r7 ? 1 : (r3 == r7 ? 0 : -1))
            if (r9 <= 0) goto L_0x0136
            double r3 = r0.mStartValue
            double r7 = r0.mEndValue
            int r9 = (r3 > r7 ? 1 : (r3 == r7 ? 0 : -1))
            if (r9 >= 0) goto L_0x0124
            com.facebook.react.animated.SpringAnimation$PhysicsState r3 = r0.mCurrentState
            double r3 = r3.position
            int r9 = (r3 > r7 ? 1 : (r3 == r7 ? 0 : -1))
            if (r9 > 0) goto L_0x0134
        L_0x0124:
            double r3 = r0.mStartValue
            double r7 = r0.mEndValue
            int r9 = (r3 > r7 ? 1 : (r3 == r7 ? 0 : -1))
            if (r9 <= 0) goto L_0x0136
            com.facebook.react.animated.SpringAnimation$PhysicsState r3 = r0.mCurrentState
            double r3 = r3.position
            int r9 = (r3 > r7 ? 1 : (r3 == r7 ? 0 : -1))
            if (r9 >= 0) goto L_0x0136
        L_0x0134:
            r3 = 1
            goto L_0x0137
        L_0x0136:
            r3 = 0
        L_0x0137:
            if (r3 == 0) goto L_0x0158
        L_0x0139:
            double r3 = r0.mSpringStiffness
            r7 = 0
            int r9 = (r3 > r7 ? 1 : (r3 == r7 ? 0 : -1))
            if (r9 <= 0) goto L_0x014a
            double r3 = r0.mEndValue
            r0.mStartValue = r3
            com.facebook.react.animated.SpringAnimation$PhysicsState r7 = r0.mCurrentState
            r7.position = r3
            goto L_0x0152
        L_0x014a:
            com.facebook.react.animated.SpringAnimation$PhysicsState r3 = r0.mCurrentState
            double r3 = r3.position
            r0.mEndValue = r3
            r0.mStartValue = r3
        L_0x0152:
            com.facebook.react.animated.SpringAnimation$PhysicsState r3 = r0.mCurrentState
            r7 = 0
            r3.velocity = r7
        L_0x0158:
            r0.mLastTime = r1
            com.facebook.react.animated.ValueAnimatedNode r1 = r0.mAnimatedValue
            com.facebook.react.animated.SpringAnimation$PhysicsState r2 = r0.mCurrentState
            double r2 = r2.position
            r1.mValue = r2
            boolean r1 = r24.isAtRest()
            if (r1 == 0) goto L_0x0183
            int r1 = r0.mIterations
            r2 = -1
            if (r1 == r2) goto L_0x0175
            int r2 = r0.mCurrentLoop
            if (r2 >= r1) goto L_0x0172
            goto L_0x0175
        L_0x0172:
            r0.mHasFinished = r6
            goto L_0x0183
        L_0x0175:
            r1 = 0
            r0.mSpringStarted = r1
            com.facebook.react.animated.ValueAnimatedNode r1 = r0.mAnimatedValue
            double r2 = r0.mOriginalValue
            r1.mValue = r2
            int r1 = r0.mCurrentLoop
            int r1 = r1 + r6
            r0.mCurrentLoop = r1
        L_0x0183:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.animated.SpringAnimation.runAnimationStep(long):void");
    }
}
