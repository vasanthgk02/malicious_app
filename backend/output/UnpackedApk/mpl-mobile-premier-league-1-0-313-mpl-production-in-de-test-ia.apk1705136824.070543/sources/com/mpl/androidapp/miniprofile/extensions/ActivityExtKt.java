package com.mpl.androidapp.miniprofile.extensions;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.util.DisplayMetrics;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0003\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0004\u001a\u00020\u0005*\u00020\u0002¨\u0006\u0006"}, d2 = {"getAvailableRamMb", "", "Landroid/app/Activity;", "getAvailableRamPercent", "isInPortrait", "", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: ActivityExt.kt */
public final class ActivityExtKt {
    public static final double getAvailableRamMb(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "<this>");
        MemoryInfo memoryInfo = new MemoryInfo();
        Object systemService = activity.getSystemService("activity");
        if (systemService != null) {
            ((ActivityManager) systemService).getMemoryInfo(memoryInfo);
            return (double) (memoryInfo.availMem / 1048576);
        }
        throw new NullPointerException("null cannot be cast to non-null type android.app.ActivityManager");
    }

    public static final double getAvailableRamPercent(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "<this>");
        MemoryInfo memoryInfo = new MemoryInfo();
        Object systemService = activity.getSystemService("activity");
        if (systemService != null) {
            ((ActivityManager) systemService).getMemoryInfo(memoryInfo);
            return (((double) memoryInfo.availMem) / ((double) memoryInfo.totalMem)) * 100.0d;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.app.ActivityManager");
    }

    public static final boolean isInPortrait(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "<this>");
        DisplayMetrics displayMetrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.heightPixels > displayMetrics.widthPixels;
    }
}
