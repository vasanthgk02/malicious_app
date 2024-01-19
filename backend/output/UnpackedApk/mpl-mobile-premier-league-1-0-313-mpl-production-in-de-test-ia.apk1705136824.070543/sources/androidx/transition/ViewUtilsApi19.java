package androidx.transition;

import android.annotation.SuppressLint;
import android.view.View;

public class ViewUtilsApi19 extends ViewUtilsBase {
    public static boolean sTryHiddenTransitionAlpha = true;

    public void clearNonTransitionAlpha(View view) {
    }

    @SuppressLint({"NewApi"})
    public float getTransitionAlpha(View view) {
        if (sTryHiddenTransitionAlpha) {
            try {
                return view.getTransitionAlpha();
            } catch (NoSuchMethodError unused) {
                sTryHiddenTransitionAlpha = false;
            }
        }
        return view.getAlpha();
    }

    public void saveNonTransitionAlpha(View view) {
    }

    @SuppressLint({"NewApi"})
    public void setTransitionAlpha(View view, float f2) {
        if (sTryHiddenTransitionAlpha) {
            try {
                view.setTransitionAlpha(f2);
                return;
            } catch (NoSuchMethodError unused) {
                sTryHiddenTransitionAlpha = false;
            }
        }
        view.setAlpha(f2);
    }
}
