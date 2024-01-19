package androidx.transition;

import android.os.Build.VERSION;
import android.view.ViewGroup;
import java.lang.reflect.Method;

public class ViewGroupUtils {
    public static Method sGetChildDrawingOrderMethod = null;
    public static boolean sGetChildDrawingOrderMethodFetched = false;
    public static boolean sTryHiddenSuppressLayout = true;

    public static void suppressLayout(ViewGroup viewGroup, boolean z) {
        if (VERSION.SDK_INT >= 29) {
            viewGroup.suppressLayout(z);
        } else if (sTryHiddenSuppressLayout) {
            try {
                viewGroup.suppressLayout(z);
            } catch (NoSuchMethodError unused) {
                sTryHiddenSuppressLayout = false;
            }
        }
    }
}
