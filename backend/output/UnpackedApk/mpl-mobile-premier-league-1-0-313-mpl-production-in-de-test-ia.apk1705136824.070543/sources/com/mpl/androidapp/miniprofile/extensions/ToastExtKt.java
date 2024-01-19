package com.mpl.androidapp.miniprofile.extensions;

import android.annotation.SuppressLint;
import android.content.Context;
import android.widget.Toast;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a$\u0010\u0000\u001a\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u000e¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"toast", "Landroid/widget/Toast;", "", "msg", "", "isShort", "", "context", "Landroid/content/Context;", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: ToastExt.kt */
public final class ToastExtKt {
    public static Toast toast;

    @SuppressLint({"ShowToast"})
    public static final void toast(Object obj, boolean z, Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (obj != null) {
            Toast toast2 = toast;
            if (toast2 == null) {
                toast = Toast.makeText(context, obj.toString(), 0);
            } else if (toast2 != null) {
                toast2.setText(obj.toString());
            }
            Toast toast3 = toast;
            if (toast3 != null) {
                toast3.setDuration(z ^ true ? 1 : 0);
            }
            Toast toast4 = toast;
            if (toast4 != null) {
                toast4.show();
            }
        }
    }

    public static /* synthetic */ void toast$default(Object obj, boolean z, Context context, int i, Object obj2) {
        if ((i & 2) != 0) {
            z = true;
        }
        toast(obj, z, context);
    }
}
