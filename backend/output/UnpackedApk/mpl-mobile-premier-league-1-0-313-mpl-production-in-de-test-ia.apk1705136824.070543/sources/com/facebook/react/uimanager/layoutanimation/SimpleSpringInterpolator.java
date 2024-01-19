package com.facebook.react.uimanager.layoutanimation;

import android.view.animation.Interpolator;

public class SimpleSpringInterpolator implements Interpolator {
    public final float mSpringDamping;

    public SimpleSpringInterpolator(float f2) {
        this.mSpringDamping = f2;
    }

    public float getInterpolation(float f2) {
        double pow = Math.pow(2.0d, (double) (-10.0f * f2));
        float f3 = this.mSpringDamping;
        return (float) ((Math.sin(((((double) (f2 - (f3 / 4.0f))) * 3.141592653589793d) * 2.0d) / ((double) f3)) * pow) + 1.0d);
    }
}
