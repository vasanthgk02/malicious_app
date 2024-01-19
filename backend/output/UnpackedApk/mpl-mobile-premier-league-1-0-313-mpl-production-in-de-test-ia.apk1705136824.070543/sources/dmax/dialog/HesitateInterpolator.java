package dmax.dialog;

import android.view.animation.Interpolator;

public class HesitateInterpolator implements Interpolator {
    public float getInterpolation(float f2) {
        if (((double) f2) < 0.5d) {
            return ((float) Math.pow((double) (f2 * 2.0f), 0.5d)) * 0.5f;
        }
        return (((float) Math.pow((double) ((1.0f - f2) * 2.0f), 0.5d)) * -0.5f) + 1.0f;
    }
}
