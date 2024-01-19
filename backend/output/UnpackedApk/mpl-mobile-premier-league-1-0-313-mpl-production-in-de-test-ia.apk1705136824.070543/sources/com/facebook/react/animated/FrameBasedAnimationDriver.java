package com.facebook.react.animated;

import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableType;

public class FrameBasedAnimationDriver extends AnimationDriver {
    public int mCurrentLoop;
    public double[] mFrames;
    public double mFromValue;
    public int mIterations;
    public long mStartFrameTimeNanos;
    public double mToValue;

    public FrameBasedAnimationDriver(ReadableMap readableMap) {
        resetConfig(readableMap);
    }

    public void resetConfig(ReadableMap readableMap) {
        ReadableArray array = readableMap.getArray("frames");
        int size = array.size();
        double[] dArr = this.mFrames;
        if (dArr == null || dArr.length != size) {
            this.mFrames = new double[size];
        }
        boolean z = false;
        for (int i = 0; i < size; i++) {
            this.mFrames[i] = array.getDouble(i);
        }
        double d2 = 0.0d;
        if (readableMap.hasKey("toValue")) {
            if (readableMap.getType("toValue") == ReadableType.Number) {
                d2 = readableMap.getDouble("toValue");
            }
            this.mToValue = d2;
        } else {
            this.mToValue = 0.0d;
        }
        if (readableMap.hasKey("iterations")) {
            this.mIterations = readableMap.getType("iterations") == ReadableType.Number ? readableMap.getInt("iterations") : 1;
        } else {
            this.mIterations = 1;
        }
        this.mCurrentLoop = 1;
        if (this.mIterations == 0) {
            z = true;
        }
        this.mHasFinished = z;
        this.mStartFrameTimeNanos = -1;
    }

    public void runAnimationStep(long j) {
        double d2;
        if (this.mStartFrameTimeNanos < 0) {
            this.mStartFrameTimeNanos = j;
            if (this.mCurrentLoop == 1) {
                this.mFromValue = this.mAnimatedValue.mValue;
            }
        }
        int round = (int) Math.round(((double) ((j - this.mStartFrameTimeNanos) / 1000000)) / 16.666666666666668d);
        if (round < 0) {
            throw new IllegalStateException("Calculated frame index should never be lower than 0");
        } else if (!this.mHasFinished) {
            double[] dArr = this.mFrames;
            if (round >= dArr.length - 1) {
                d2 = this.mToValue;
                int i = this.mIterations;
                if (i == -1 || this.mCurrentLoop < i) {
                    this.mStartFrameTimeNanos = -1;
                    this.mCurrentLoop++;
                } else {
                    this.mHasFinished = true;
                }
            } else {
                double d3 = this.mFromValue;
                d2 = ((this.mToValue - d3) * dArr[round]) + d3;
            }
            this.mAnimatedValue.mValue = d2;
        }
    }
}
