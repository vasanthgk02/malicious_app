package com.mpl.androidapp.utils;

import android.content.Context;
import android.widget.Toast;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.google.firebase.crashlytics.CrashlyticsAnalyticsListener;
import in.juspay.hypersdk.mystique.AnimationHolder.InlineAnimation;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import kotlinx.coroutines.Dispatchers;
import timber.log.Timber;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J)\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00042\u0012\u0010\n\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u000b\"\u00020\u0001H\u0007¢\u0006\u0002\u0010\fJ)\u0010\r\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00042\u0012\u0010\n\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u000b\"\u00020\u0001H\u0007¢\u0006\u0002\u0010\fJ)\u0010\u000e\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00042\u0012\u0010\n\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u000b\"\u00020\u0001H\u0007¢\u0006\u0002\u0010\fJ\u0012\u0010\u000f\u001a\u00020\b2\b\u0010\r\u001a\u0004\u0018\u00010\u0010H\u0007J1\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0012\u0010\n\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u000b\"\u00020\u0001H\u0007¢\u0006\u0002\u0010\u0016J)\u0010\u0017\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00042\u0012\u0010\n\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u000b\"\u00020\u0001H\u0002¢\u0006\u0002\u0010\u0018J)\u0010\u0019\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00042\u0012\u0010\n\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u000b\"\u00020\u0001H\u0007¢\u0006\u0002\u0010\fJ)\u0010\u001a\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00042\u0012\u0010\n\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u000b\"\u00020\u0001H\u0007¢\u0006\u0002\u0010\fJ%\u0010\u001b\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00042\u000e\u0010\n\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u000bH\u0002¢\u0006\u0002\u0010\fR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/mpl/androidapp/utils/MTimber;", "", "()V", "TAG", "", "isLogEnabled", "", "d", "", "tag", "params", "", "(Ljava/lang/String;[Ljava/lang/Object;)V", "e", "i", "printStackTrace", "", "t", "context", "Landroid/content/Context;", "mDuration", "", "(Landroid/content/Context;I[Ljava/lang/Object;)V", "timberLog", "(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;", "v", "w", "writeToFile", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: MTimber.kt */
public final class MTimber {
    public static final MTimber INSTANCE = new MTimber();
    public static final String TAG = "MTimber";
    public static boolean isLogEnabled = MBuildConfigUtils.isLogEnabled();

    public static final void d(String str, Object... objArr) {
        Intrinsics.checkNotNullParameter(str, InlineAnimation.TAG);
        Intrinsics.checkNotNullParameter(objArr, CrashlyticsAnalyticsListener.EVENT_PARAMS_KEY);
        if (isLogEnabled) {
            Timber.TREE_OF_SOULS.d(INSTANCE.timberLog(GeneratedOutlineSupport.outline52(TAG, " --> ", str), Arrays.copyOf(objArr, objArr.length)), new Object[0]);
            INSTANCE.writeToFile(str, objArr);
        }
    }

    public static final void e(String str, Object... objArr) {
        Intrinsics.checkNotNullParameter(str, InlineAnimation.TAG);
        Intrinsics.checkNotNullParameter(objArr, CrashlyticsAnalyticsListener.EVENT_PARAMS_KEY);
        if (isLogEnabled) {
            Timber.TREE_OF_SOULS.e(INSTANCE.timberLog(GeneratedOutlineSupport.outline52(TAG, " --> ", str), Arrays.copyOf(objArr, objArr.length)), new Object[0]);
            INSTANCE.writeToFile(str, objArr);
        }
    }

    public static final void i(String str, Object... objArr) {
        Intrinsics.checkNotNullParameter(str, InlineAnimation.TAG);
        Intrinsics.checkNotNullParameter(objArr, CrashlyticsAnalyticsListener.EVENT_PARAMS_KEY);
        if (isLogEnabled) {
            Timber.TREE_OF_SOULS.i(INSTANCE.timberLog(GeneratedOutlineSupport.outline52(TAG, " --> ", str), Arrays.copyOf(objArr, objArr.length)), new Object[0]);
            INSTANCE.writeToFile(str, objArr);
        }
    }

    public static final void printStackTrace(Throwable th) {
        if (isLogEnabled && th != null) {
            th.printStackTrace();
        }
    }

    public static final void t(Context context, int i, Object... objArr) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(objArr, CrashlyticsAnalyticsListener.EVENT_PARAMS_KEY);
        synchronized (INSTANCE) {
            int i2 = 0;
            int i3 = 1;
            if (i <= 1) {
                i3 = 0;
            }
            try {
                StringBuilder sb = new StringBuilder();
                int length = objArr.length;
                while (i2 < length) {
                    Object obj = objArr[i2];
                    i2++;
                    sb.append(obj);
                    sb.append(' ');
                }
                if (isLogEnabled) {
                    Toast.makeText(context, sb.toString(), i3).show();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    /* access modifiers changed from: private */
    public final String timberLog(String str, Object... objArr) {
        String sb;
        try {
            StringBuilder sb2 = new StringBuilder();
            synchronized (this) {
                sb2.append(str);
                int i = 0;
                int length = objArr.length;
                while (i < length) {
                    Object obj = objArr[i];
                    i++;
                    sb2.append(Intrinsics.stringPlus(" --> ", obj));
                }
                sb = sb2.toString();
                Intrinsics.checkNotNullExpressionValue(sb, "sb.toString()");
            }
            return sb;
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public static final void v(String str, Object... objArr) {
        Intrinsics.checkNotNullParameter(str, InlineAnimation.TAG);
        Intrinsics.checkNotNullParameter(objArr, CrashlyticsAnalyticsListener.EVENT_PARAMS_KEY);
        if (isLogEnabled) {
            Timber.TREE_OF_SOULS.v(INSTANCE.timberLog(GeneratedOutlineSupport.outline52(TAG, " --> ", str), Arrays.copyOf(objArr, objArr.length)), new Object[0]);
            INSTANCE.writeToFile(str, objArr);
        }
    }

    public static final void w(String str, Object... objArr) {
        Intrinsics.checkNotNullParameter(str, InlineAnimation.TAG);
        Intrinsics.checkNotNullParameter(objArr, CrashlyticsAnalyticsListener.EVENT_PARAMS_KEY);
        if (isLogEnabled) {
            Timber.TREE_OF_SOULS.w(INSTANCE.timberLog(GeneratedOutlineSupport.outline52(TAG, " --> ", str), Arrays.copyOf(objArr, objArr.length)), new Object[0]);
            INSTANCE.writeToFile(str, objArr);
        }
    }

    private final void writeToFile(String str, Object[] objArr) {
        try {
            TypeUtilsKt.launch$default(TypeUtilsKt.CoroutineScope(Dispatchers.IO), null, null, new MTimber$writeToFile$1(str, objArr, null), 3, null);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
