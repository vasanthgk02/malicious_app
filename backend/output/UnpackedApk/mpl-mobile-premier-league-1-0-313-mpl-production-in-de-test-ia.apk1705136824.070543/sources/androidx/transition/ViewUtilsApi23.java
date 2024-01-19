package androidx.transition;

import android.annotation.SuppressLint;
import android.os.Build.VERSION;
import android.view.View;

public class ViewUtilsApi23 extends ViewUtilsApi22 {
    public static boolean sTryHiddenSetTransitionVisibility = true;

    @SuppressLint({"NewApi"})
    public void setTransitionVisibility(View view, int i) {
        if (VERSION.SDK_INT == 28) {
            super.setTransitionVisibility(view, i);
        } else if (sTryHiddenSetTransitionVisibility) {
            try {
                view.setTransitionVisibility(i);
            } catch (NoSuchMethodError unused) {
                sTryHiddenSetTransitionVisibility = false;
            }
        }
    }
}
