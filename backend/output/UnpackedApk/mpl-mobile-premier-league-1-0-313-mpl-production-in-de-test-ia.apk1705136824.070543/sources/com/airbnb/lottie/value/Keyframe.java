package com.airbnb.lottie.value;

import android.graphics.PointF;
import android.view.animation.Interpolator;
import com.airbnb.lottie.LottieComposition;
import com.android.tools.r8.GeneratedOutlineSupport;

public class Keyframe<T> {
    public final LottieComposition composition;
    public Float endFrame;
    public float endProgress;
    public T endValue;
    public float endValueFloat;
    public int endValueInt;
    public final Interpolator interpolator;
    public PointF pathCp1;
    public PointF pathCp2;
    public final float startFrame;
    public float startProgress;
    public final T startValue;
    public float startValueFloat;
    public int startValueInt;
    public final Interpolator xInterpolator;
    public final Interpolator yInterpolator;

    public Keyframe(LottieComposition lottieComposition, T t, T t2, Interpolator interpolator2, float f2, Float f3) {
        this.startValueFloat = -3987645.8f;
        this.endValueFloat = -3987645.8f;
        this.startValueInt = 784923401;
        this.endValueInt = 784923401;
        this.startProgress = Float.MIN_VALUE;
        this.endProgress = Float.MIN_VALUE;
        this.pathCp1 = null;
        this.pathCp2 = null;
        this.composition = lottieComposition;
        this.startValue = t;
        this.endValue = t2;
        this.interpolator = interpolator2;
        this.xInterpolator = null;
        this.yInterpolator = null;
        this.startFrame = f2;
        this.endFrame = f3;
    }

    public boolean containsProgress(float f2) {
        return f2 >= getStartProgress() && f2 < getEndProgress();
    }

    public float getEndProgress() {
        if (this.composition == null) {
            return 1.0f;
        }
        if (this.endProgress == Float.MIN_VALUE) {
            if (this.endFrame == null) {
                this.endProgress = 1.0f;
            } else {
                this.endProgress = ((this.endFrame.floatValue() - this.startFrame) / this.composition.getDurationFrames()) + getStartProgress();
            }
        }
        return this.endProgress;
    }

    public float getStartProgress() {
        LottieComposition lottieComposition = this.composition;
        if (lottieComposition == null) {
            return 0.0f;
        }
        if (this.startProgress == Float.MIN_VALUE) {
            this.startProgress = (this.startFrame - lottieComposition.startFrame) / lottieComposition.getDurationFrames();
        }
        return this.startProgress;
    }

    public boolean isStatic() {
        return this.interpolator == null && this.xInterpolator == null && this.yInterpolator == null;
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("Keyframe{startValue=");
        outline73.append(this.startValue);
        outline73.append(", endValue=");
        outline73.append(this.endValue);
        outline73.append(", startFrame=");
        outline73.append(this.startFrame);
        outline73.append(", endFrame=");
        outline73.append(this.endFrame);
        outline73.append(", interpolator=");
        outline73.append(this.interpolator);
        outline73.append('}');
        return outline73.toString();
    }

    public Keyframe(LottieComposition lottieComposition, T t, T t2, Interpolator interpolator2, Interpolator interpolator3, float f2, Float f3) {
        this.startValueFloat = -3987645.8f;
        this.endValueFloat = -3987645.8f;
        this.startValueInt = 784923401;
        this.endValueInt = 784923401;
        this.startProgress = Float.MIN_VALUE;
        this.endProgress = Float.MIN_VALUE;
        this.pathCp1 = null;
        this.pathCp2 = null;
        this.composition = lottieComposition;
        this.startValue = t;
        this.endValue = t2;
        this.interpolator = null;
        this.xInterpolator = interpolator2;
        this.yInterpolator = interpolator3;
        this.startFrame = f2;
        this.endFrame = null;
    }

    public Keyframe(LottieComposition lottieComposition, T t, T t2, Interpolator interpolator2, Interpolator interpolator3, Interpolator interpolator4, float f2, Float f3) {
        this.startValueFloat = -3987645.8f;
        this.endValueFloat = -3987645.8f;
        this.startValueInt = 784923401;
        this.endValueInt = 784923401;
        this.startProgress = Float.MIN_VALUE;
        this.endProgress = Float.MIN_VALUE;
        this.pathCp1 = null;
        this.pathCp2 = null;
        this.composition = lottieComposition;
        this.startValue = t;
        this.endValue = t2;
        this.interpolator = interpolator2;
        this.xInterpolator = interpolator3;
        this.yInterpolator = interpolator4;
        this.startFrame = f2;
        this.endFrame = f3;
    }

    public Keyframe(T t) {
        this.startValueFloat = -3987645.8f;
        this.endValueFloat = -3987645.8f;
        this.startValueInt = 784923401;
        this.endValueInt = 784923401;
        this.startProgress = Float.MIN_VALUE;
        this.endProgress = Float.MIN_VALUE;
        this.pathCp1 = null;
        this.pathCp2 = null;
        this.composition = null;
        this.startValue = t;
        this.endValue = t;
        this.interpolator = null;
        this.xInterpolator = null;
        this.yInterpolator = null;
        this.startFrame = Float.MIN_VALUE;
        this.endFrame = Float.valueOf(Float.MAX_VALUE);
    }
}
