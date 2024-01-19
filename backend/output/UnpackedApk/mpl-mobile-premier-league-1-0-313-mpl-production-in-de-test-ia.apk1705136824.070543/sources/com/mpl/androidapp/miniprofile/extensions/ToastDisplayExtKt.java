package com.mpl.androidapp.miniprofile.extensions;

import android.widget.Toast;
import androidx.fragment.app.Fragment;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u001a\u001c\u0010\u0005\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u0007\u001a\u001c\u0010\u0005\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u0007¨\u0006\t"}, d2 = {"NOT_IMPL", "", "Landroidx/fragment/app/Fragment;", "message", "", "TOAST", "messageResId", "", "duration", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: ToastDisplayExt.kt */
public final class ToastDisplayExtKt {
    public static final void NOT_IMPL(Fragment fragment, String str) {
        Intrinsics.checkNotNullParameter(fragment, "<this>");
        Intrinsics.checkNotNullParameter(str, "message");
        TOAST$default(fragment, str, 0, 2, (Object) null);
    }

    public static /* synthetic */ void NOT_IMPL$default(Fragment fragment, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "This action is not implemented yet!";
        }
        NOT_IMPL(fragment, str);
    }

    public static final void TOAST(Fragment fragment, String str, int i) {
        Intrinsics.checkNotNullParameter(fragment, "<this>");
        Intrinsics.checkNotNullParameter(str, "message");
        Toast.makeText(fragment.getContext(), str, i).show();
    }

    public static /* synthetic */ void TOAST$default(Fragment fragment, String str, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        TOAST(fragment, str, i);
    }

    public static final void TOAST(Fragment fragment, int i, int i2) {
        Intrinsics.checkNotNullParameter(fragment, "<this>");
        Toast.makeText(fragment.getContext(), i, i2).show();
    }

    public static /* synthetic */ void TOAST$default(Fragment fragment, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = 0;
        }
        TOAST(fragment, i, i2);
    }
}
