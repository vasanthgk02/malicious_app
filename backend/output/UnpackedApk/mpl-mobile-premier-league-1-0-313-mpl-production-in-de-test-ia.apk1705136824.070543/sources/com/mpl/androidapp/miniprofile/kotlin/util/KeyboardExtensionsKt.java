package com.mpl.androidapp.miniprofile.kotlin.util;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.util.TypedValue;
import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0001\u001a\u0012\u0010\u0004\u001a\u00020\u0005*\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"convertDpToPx", "", "Landroid/content/Context;", "dp", "isKeyboardOpen", "", "view", "Landroid/view/View;", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: KeyboardExtensions.kt */
public final class KeyboardExtensionsKt {
    public static final float convertDpToPx(Context context, float f2) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        Resources resources = context.getResources();
        return TypedValue.applyDimension(1, f2, resources == null ? null : resources.getDisplayMetrics());
    }

    public static final boolean isKeyboardOpen(Context context, View view) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        Intrinsics.checkNotNullParameter(view, "view");
        Rect rect = new Rect();
        view.getWindowVisibleDisplayFrame(rect);
        return ((float) (view.getRootView().getHeight() - (rect.bottom - rect.top))) > convertDpToPx(context, 100.0f);
    }
}
