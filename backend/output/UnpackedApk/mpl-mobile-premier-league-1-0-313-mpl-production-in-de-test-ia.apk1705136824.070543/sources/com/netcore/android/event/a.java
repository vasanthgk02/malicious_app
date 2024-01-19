package com.netcore.android.event;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import androidx.work.impl.WorkManagerImpl;
import com.google.firebase.perf.config.RemoteConfigManager;
import com.netcore.android.SMTActivityLifecycleCallback;
import com.netcore.android.logger.SMTLogger;
import com.netcore.android.network.SMTNetworkUtil;
import com.netcore.android.preference.SMTPreferenceConstants;
import com.netcore.android.preference.SMTPreferenceHelper;
import com.netcore.android.utility.SMTCommonUtility;
import com.netcore.android.workmgr.SMTWorkerScheduler;
import com.userexperior.models.recording.enums.UeCustomType;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SMTEventBatchProcessor.kt */
public final class a {

    /* renamed from: c  reason: collision with root package name */
    public static volatile a f1065c;

    /* renamed from: d  reason: collision with root package name */
    public static SMTPreferenceHelper f1066d;

    /* renamed from: e  reason: collision with root package name */
    public static Handler f1067e;

    /* renamed from: f  reason: collision with root package name */
    public static HandlerThread f1068f;
    public static final C0003a g = new C0003a(null);

    /* renamed from: a  reason: collision with root package name */
    public final String f1069a;

    /* renamed from: b  reason: collision with root package name */
    public final WeakReference<Context> f1070b;

    /* renamed from: com.netcore.android.event.a$a  reason: collision with other inner class name */
    /* compiled from: SMTEventBatchProcessor.kt */
    public static final class C0003a {
        public C0003a() {
        }

        private final a a(Context context) {
            a.f1066d = SMTPreferenceHelper.Companion.getAppPreferenceInstance(context, null);
            a.f1068f = new HandlerThread("EventBatchProcessor_Thread");
            HandlerThread b2 = a.f1068f;
            if (b2 != null) {
                b2.start();
                HandlerThread b3 = a.f1068f;
                if (b3 != null) {
                    a.f1067e = new Handler(b3.getLooper());
                    return new a(new WeakReference(context), null);
                }
                Intrinsics.throwUninitializedPropertyAccessException("mHandlerThread");
                throw null;
            }
            Intrinsics.throwUninitializedPropertyAccessException("mHandlerThread");
            throw null;
        }

        public final a b(Context context) {
            a aVar;
            Intrinsics.checkNotNullParameter(context, "context");
            a a2 = a.f1065c;
            if (a2 != null) {
                return a2;
            }
            synchronized (a.class) {
                try {
                    a a3 = a.f1065c;
                    if (a3 != null) {
                        aVar = a3;
                    } else {
                        aVar = a.g.a(context);
                        a.f1065c = aVar;
                    }
                }
            }
            return aVar;
        }

        public /* synthetic */ C0003a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: SMTEventBatchProcessor.kt */
    public static final class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f1071a;

        public b(a aVar) {
            this.f1071a = aVar;
        }

        public final void run() {
            this.f1071a.d();
        }
    }

    public a(WeakReference<Context> weakReference) {
        this.f1070b = weakReference;
        this.f1069a = a.class.getSimpleName();
    }

    private final Runnable c() {
        return new b(this);
    }

    public final void d() {
        Context context = (Context) this.f1070b.get();
        if (context != null) {
            Intrinsics.checkNotNullExpressionValue(WorkManagerImpl.getInstance(context), "WorkManager.getInstance(it)");
            SMTPreferenceHelper sMTPreferenceHelper = f1066d;
            if (sMTPreferenceHelper != null) {
                boolean a2 = com.netcore.android.e.b.f1030c.b(this.f1070b).a(sMTPreferenceHelper.getInt(SMTPreferenceConstants.BATCH_SIZE));
                SMTCommonUtility sMTCommonUtility = SMTCommonUtility.INSTANCE;
                Intrinsics.checkNotNullExpressionValue(context, "it");
                boolean checkIfTrackingAllowed$smartech_release = sMTCommonUtility.checkIfTrackingAllowed$smartech_release(context);
                SMTLogger sMTLogger = SMTLogger.INSTANCE;
                String str = this.f1069a;
                Intrinsics.checkNotNullExpressionValue(str, UeCustomType.TAG);
                sMTLogger.internal(str, "Events in DB: " + a2 + " tracking status: " + checkIfTrackingAllowed$smartech_release);
                if (SMTActivityLifecycleCallback.Companion.getInstance().isAppInForeground()) {
                    boolean hasInternetConnection = SMTNetworkUtil.INSTANCE.hasInternetConnection(context);
                    if (a2 && checkIfTrackingAllowed$smartech_release && hasInternetConnection) {
                        SMTWorkerScheduler.Companion.getInstance().scheduleEventWorker(context);
                    }
                } else if (a2 && checkIfTrackingAllowed$smartech_release) {
                    SMTWorkerScheduler.Companion.getInstance().scheduleEventWorker(context);
                }
            } else {
                Intrinsics.throwUninitializedPropertyAccessException("sharedPreferences");
                throw null;
            }
        }
        a(0);
    }

    public /* synthetic */ a(WeakReference weakReference, DefaultConstructorMarker defaultConstructorMarker) {
        this(weakReference);
    }

    private final void a(long j) {
        Runnable c2 = c();
        if (j == 0) {
            SMTPreferenceHelper sMTPreferenceHelper = f1066d;
            if (sMTPreferenceHelper != null) {
                j = ((long) sMTPreferenceHelper.getInt(SMTPreferenceConstants.BATCH_INTERVAL, 5)) * 1000;
            } else {
                Intrinsics.throwUninitializedPropertyAccessException("sharedPreferences");
                throw null;
            }
        }
        if (j <= 0) {
            j = RemoteConfigManager.MIN_APP_START_CONFIG_FETCH_DELAY_MS;
        }
        SMTLogger sMTLogger = SMTLogger.INSTANCE;
        String str = this.f1069a;
        Intrinsics.checkNotNullExpressionValue(str, UeCustomType.TAG);
        StringBuilder sb = new StringBuilder();
        sb.append("scheduling next batch process in ");
        sb.append(j);
        sb.append(" milli seconds and thread name is ");
        Thread currentThread = Thread.currentThread();
        Intrinsics.checkNotNullExpressionValue(currentThread, "Thread.currentThread()");
        sb.append(currentThread.getName());
        sMTLogger.internal(str, sb.toString());
        Handler handler = f1067e;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            Handler handler2 = f1067e;
            if (handler2 != null) {
                handler2.postDelayed(c2, j);
            } else {
                Intrinsics.throwUninitializedPropertyAccessException("mHandler");
                throw null;
            }
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("mHandler");
            throw null;
        }
    }

    public final void a(boolean z) {
        if (z) {
            SMTPreferenceHelper sMTPreferenceHelper = f1066d;
            if (sMTPreferenceHelper != null) {
                long j = sMTPreferenceHelper.getLong(SMTPreferenceConstants.LAST_APP_ACTIVE_TIME_STAMP);
                SMTPreferenceHelper sMTPreferenceHelper2 = f1066d;
                if (sMTPreferenceHelper2 != null) {
                    long j2 = ((long) sMTPreferenceHelper2.getInt(SMTPreferenceConstants.BATCH_INTERVAL)) * 1000;
                    long j3 = j + j2;
                    if (j3 < System.currentTimeMillis()) {
                        d();
                        return;
                    }
                    long currentTimeMillis = j3 - System.currentTimeMillis();
                    if (currentTimeMillis >= 0) {
                        j2 = currentTimeMillis;
                    }
                    a(j2);
                    return;
                }
                Intrinsics.throwUninitializedPropertyAccessException("sharedPreferences");
                throw null;
            }
            Intrinsics.throwUninitializedPropertyAccessException("sharedPreferences");
            throw null;
        }
        Handler handler = f1067e;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("mHandler");
            throw null;
        }
    }
}
