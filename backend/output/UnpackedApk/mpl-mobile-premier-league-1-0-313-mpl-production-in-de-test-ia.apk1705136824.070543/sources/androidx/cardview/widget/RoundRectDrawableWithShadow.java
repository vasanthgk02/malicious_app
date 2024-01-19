package androidx.cardview.widget;

import android.graphics.drawable.Drawable;

public class RoundRectDrawableWithShadow extends Drawable {
    public static final double COS_45 = Math.cos(Math.toRadians(45.0d));

    public static float calculateHorizontalPadding(float f2, float f3, boolean z) {
        if (!z) {
            return f2;
        }
        return (float) (((1.0d - COS_45) * ((double) f3)) + ((double) f2));
    }

    public static float calculateVerticalPadding(float f2, float f3, boolean z) {
        if (!z) {
            return f2 * 1.5f;
        }
        return (float) (((1.0d - COS_45) * ((double) f3)) + ((double) (f2 * 1.5f)));
    }
}
