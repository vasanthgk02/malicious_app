package com.facebook.internal.instrument.anrreport;

import android.app.ActivityManager;
import android.app.ActivityManager.ProcessErrorStateInfo;
import android.os.Looper;
import android.os.Process;
import com.facebook.FacebookSdk;
import com.facebook.internal.instrument.InstrumentData;
import com.facebook.internal.instrument.InstrumentUtility;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0007J\b\u0010\u0011\u001a\u00020\u000eH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n \f*\u0004\u0018\u00010\u000b0\u000bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/facebook/internal/instrument/anrreport/ANRDetector;", "", "()V", "DETECTION_INTERVAL_IN_MS", "", "anrDetectorRunnable", "Ljava/lang/Runnable;", "myUid", "previousStackTrace", "", "scheduledExecutorService", "Ljava/util/concurrent/ScheduledExecutorService;", "kotlin.jvm.PlatformType", "checkProcessError", "", "am", "Landroid/app/ActivityManager;", "start", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: ANRDetector.kt */
public final class ANRDetector {
    public static final ANRDetector INSTANCE = null;
    public static final Runnable anrDetectorRunnable = $$Lambda$uE1dCF2iduQZmZLAjiovuK3Fhw.INSTANCE;
    public static final int myUid = Process.myUid();
    public static String previousStackTrace = "";
    public static final ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();

    /* renamed from: anrDetectorRunnable$lambda-0  reason: not valid java name */
    public static final void m219anrDetectorRunnable$lambda0() {
        Class<ANRDetector> cls = ANRDetector.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
                Object systemService = FacebookSdk.getApplicationContext().getSystemService("activity");
                if (systemService != null) {
                    checkProcessError((ActivityManager) systemService);
                    return;
                }
                throw new NullPointerException("null cannot be cast to non-null type android.app.ActivityManager");
            } catch (Exception unused) {
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, cls);
            }
        }
    }

    public static final void checkProcessError(ActivityManager activityManager) {
        Class<ANRDetector> cls = ANRDetector.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                List<ProcessErrorStateInfo> processesInErrorState = activityManager.getProcessesInErrorState();
                if (processesInErrorState != null) {
                    for (ProcessErrorStateInfo processErrorStateInfo : processesInErrorState) {
                        if (processErrorStateInfo.condition == 2 && processErrorStateInfo.uid == myUid) {
                            Thread thread = Looper.getMainLooper().getThread();
                            Intrinsics.checkNotNullExpressionValue(thread, "getMainLooper().thread");
                            Intrinsics.checkNotNullParameter(thread, "thread");
                            StackTraceElement[] stackTrace = thread.getStackTrace();
                            JSONArray jSONArray = new JSONArray();
                            Intrinsics.checkNotNullExpressionValue(stackTrace, "stackTrace");
                            int length = stackTrace.length;
                            int i = 0;
                            while (i < length) {
                                StackTraceElement stackTraceElement = stackTrace[i];
                                i++;
                                jSONArray.put(stackTraceElement.toString());
                            }
                            String jSONArray2 = jSONArray.toString();
                            if (!Intrinsics.areEqual(jSONArray2, previousStackTrace)) {
                                if (InstrumentUtility.isSDKRelatedThread(thread)) {
                                    previousStackTrace = jSONArray2;
                                    new InstrumentData(processErrorStateInfo.shortMsg, jSONArray2, (DefaultConstructorMarker) null).save();
                                }
                            }
                        }
                    }
                }
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, cls);
            }
        }
    }
}
