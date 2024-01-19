package androidx.transition;

import android.annotation.SuppressLint;
import android.view.View;

public class ViewUtilsApi22 extends ViewUtilsApi21 {
    public static boolean sTryHiddenSetLeftTopRightBottom = true;

    @SuppressLint({"NewApi"})
    public void setLeftTopRightBottom(View view, int i, int i2, int i3, int i4) {
        if (sTryHiddenSetLeftTopRightBottom) {
            try {
                view.setLeftTopRightBottom(i, i2, i3, i4);
            } catch (NoSuchMethodError unused) {
                sTryHiddenSetLeftTopRightBottom = false;
            }
        }
    }
}
