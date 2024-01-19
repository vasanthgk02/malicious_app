package com.mpl.androidapp.miniprofile.extensions;

import android.view.View;
import com.google.android.material.snackbar.Snackbar;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\u001a\u001c\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u001a\u001c\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\u0005\u001a\u00020\u0004¨\u0006\b"}, d2 = {"displaySnakbar", "Lcom/google/android/material/snackbar/Snackbar;", "Landroid/view/View;", "messageResId", "", "duration", "message", "", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: SnackBarExt.kt */
public final class SnackBarExtKt {
    public static final Snackbar displaySnakbar(View view, String str, int i) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Intrinsics.checkNotNullParameter(str, "message");
        Snackbar make = Snackbar.make(view, (CharSequence) str, i);
        Intrinsics.checkNotNullExpressionValue(make, "make(this, message, duration)");
        make.show();
        return make;
    }

    public static /* synthetic */ Snackbar displaySnakbar$default(View view, String str, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = -1;
        }
        return displaySnakbar(view, str, i);
    }

    public static /* synthetic */ Snackbar displaySnakbar$default(View view, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = -1;
        }
        return displaySnakbar(view, i, i2);
    }

    public static final Snackbar displaySnakbar(View view, int i, int i2) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Snackbar make = Snackbar.make(view, i, i2);
        Intrinsics.checkNotNullExpressionValue(make, "make(this, messageResId, duration)");
        make.show();
        return make;
    }
}
