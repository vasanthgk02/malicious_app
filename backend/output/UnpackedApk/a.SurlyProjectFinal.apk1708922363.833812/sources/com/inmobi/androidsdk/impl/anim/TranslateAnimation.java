package com.inmobi.androidsdk.impl.anim;

import android.view.animation.Animation;
import android.view.animation.Transformation;

public class TranslateAnimation extends Animation {
    private float mFromXDelta;
    private int mFromXType = 0;
    private float mFromXValue = 0.0f;
    private float mFromYDelta;
    private int mFromYType = 0;
    private float mFromYValue = 0.0f;
    private float mToXDelta;
    private int mToXType = 0;
    private float mToXValue = 0.0f;
    private float mToYDelta;
    private int mToYType = 0;
    private float mToYValue = 0.0f;

    public TranslateAnimation(float fromXDelta, float toXDelta, float fromYDelta, float toYDelta) {
        this.mFromXValue = fromXDelta;
        this.mToXValue = toXDelta;
        this.mFromYValue = fromYDelta;
        this.mToYValue = toYDelta;
        this.mFromXType = 0;
        this.mToXType = 0;
        this.mFromYType = 0;
        this.mToYType = 0;
    }

    public TranslateAnimation(int fromXType, float fromXValue, int toXType, float toXValue, int fromYType, float fromYValue, int toYType, float toYValue) {
        this.mFromXValue = fromXValue;
        this.mToXValue = toXValue;
        this.mFromYValue = fromYValue;
        this.mToYValue = toYValue;
        this.mFromXType = fromXType;
        this.mToXType = toXType;
        this.mFromYType = fromYType;
        this.mToYType = toYType;
    }

    public void initialize(int width, int height, int parentWidth, int parentHeight) {
        super.initialize(width, height, parentWidth, parentHeight);
        this.mFromXDelta = resolveSize(this.mFromXType, this.mFromXValue, width, parentWidth);
        this.mToXDelta = resolveSize(this.mToXType, this.mToXValue, width, parentWidth);
        this.mFromYDelta = resolveSize(this.mFromYType, this.mFromYValue, height, parentHeight);
        this.mToYDelta = resolveSize(this.mToYType, this.mToYValue, height, parentHeight);
    }

    /* access modifiers changed from: protected */
    public void applyTransformation(float interpolatedTime, Transformation t) {
        float dx = this.mFromXDelta;
        float dy = this.mFromYDelta;
        if (this.mFromXDelta != this.mToXDelta) {
            dx = this.mFromXDelta + ((this.mToXDelta - this.mFromXDelta) * interpolatedTime);
        }
        if (this.mFromYDelta != this.mToYDelta) {
            dy = this.mFromYDelta + ((this.mToYDelta - this.mFromYDelta) * interpolatedTime);
        }
        t.getMatrix().setTranslate(dx, dy);
    }
}
