package androidx.core.view;

import android.content.Context;
import android.os.Build.VERSION;
import android.view.PointerIcon;

public final class PointerIconCompat {
    public Object mPointerIcon;

    public PointerIconCompat(Object obj) {
        this.mPointerIcon = obj;
    }

    public static PointerIconCompat getSystemIcon(Context context, int i) {
        if (VERSION.SDK_INT >= 24) {
            return new PointerIconCompat(PointerIcon.getSystemIcon(context, i));
        }
        return new PointerIconCompat(null);
    }
}
