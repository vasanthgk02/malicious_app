package com.facebook.appevents.internal;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.preference.PreferenceManager;
import com.facebook.AccessToken;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLoggerImpl;
import com.facebook.appevents.codeless.CodelessManager;
import com.facebook.internal.FeatureManager;
import com.facebook.internal.FeatureManager.Feature;
import com.facebook.internal.FetchedAppSettings;
import com.facebook.internal.FetchedAppSettingsManager;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.lang.ref.WeakReference;
import java.util.UUID;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u001e\u001a\u00020\u001fH\u0002J\n\u0010 \u001a\u0004\u0018\u00010\rH\u0007J\n\u0010!\u001a\u0004\u0018\u00010\"H\u0007J\b\u0010#\u001a\u00020$H\u0007J\b\u0010%\u001a\u00020$H\u0007J\u0012\u0010&\u001a\u00020\u001f2\b\u0010'\u001a\u0004\u0018\u00010\rH\u0007J\u0010\u0010(\u001a\u00020\u001f2\u0006\u0010'\u001a\u00020\rH\u0002J\u0010\u0010)\u001a\u00020\u001f2\u0006\u0010'\u001a\u00020\rH\u0002J\u0010\u0010*\u001a\u00020\u001f2\u0006\u0010'\u001a\u00020\rH\u0007J\u001a\u0010+\u001a\u00020\u001f2\u0006\u0010,\u001a\u00020-2\b\u0010\n\u001a\u0004\u0018\u00010\u0004H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\u00020\t8BX\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0016\u0010\u0019\u001a\n \u001b*\u0004\u0018\u00010\u001a0\u001aX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0004¢\u0006\u0002\n\u0000¨\u0006."}, d2 = {"Lcom/facebook/appevents/internal/ActivityLifecycleTracker;", "", "()V", "INCORRECT_IMPL_WARNING", "", "INTERRUPTION_THRESHOLD_MILLISECONDS", "", "TAG", "activityReferences", "", "appId", "currActivity", "Ljava/lang/ref/WeakReference;", "Landroid/app/Activity;", "currentActivityAppearTime", "currentFuture", "Ljava/util/concurrent/ScheduledFuture;", "currentFutureLock", "currentSession", "Lcom/facebook/appevents/internal/SessionInfo;", "foregroundActivityCount", "Ljava/util/concurrent/atomic/AtomicInteger;", "sessionTimeoutInSeconds", "getSessionTimeoutInSeconds", "()I", "singleThreadExecutor", "Ljava/util/concurrent/ScheduledExecutorService;", "kotlin.jvm.PlatformType", "tracking", "Ljava/util/concurrent/atomic/AtomicBoolean;", "cancelCurrentTask", "", "getCurrentActivity", "getCurrentSessionGuid", "Ljava/util/UUID;", "isInBackground", "", "isTracking", "onActivityCreated", "activity", "onActivityDestroyed", "onActivityPaused", "onActivityResumed", "startTracking", "application", "Landroid/app/Application;", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: ActivityLifecycleTracker.kt */
public final class ActivityLifecycleTracker {
    public static final ActivityLifecycleTracker INSTANCE = new ActivityLifecycleTracker();
    public static final String TAG;
    public static int activityReferences;
    public static String appId;
    public static WeakReference<Activity> currActivity;
    public static long currentActivityAppearTime;
    public static volatile ScheduledFuture<?> currentFuture;
    public static final Object currentFutureLock = new Object();
    public static volatile SessionInfo currentSession;
    public static final AtomicInteger foregroundActivityCount = new AtomicInteger(0);
    public static final ScheduledExecutorService singleThreadExecutor = Executors.newSingleThreadScheduledExecutor();
    public static final AtomicBoolean tracking = new AtomicBoolean(false);

    static {
        String canonicalName = ActivityLifecycleTracker.class.getCanonicalName();
        if (canonicalName == null) {
            canonicalName = "com.facebook.appevents.internal.ActivityLifecycleTracker";
        }
        TAG = canonicalName;
    }

    public static final UUID getCurrentSessionGuid() {
        if (currentSession == null) {
            return null;
        }
        SessionInfo sessionInfo = currentSession;
        if (sessionInfo == null) {
            return null;
        }
        return sessionInfo.sessionId;
    }

    /* JADX WARNING: type inference failed for: r7v0 */
    /* JADX WARNING: type inference failed for: r7v1, types: [com.facebook.appevents.internal.SessionInfo] */
    /* JADX WARNING: type inference failed for: r1v1, types: [com.facebook.appevents.internal.SessionInfo] */
    /* JADX WARNING: type inference failed for: r7v2, types: [com.facebook.appevents.internal.SourceApplicationInfo] */
    /* JADX WARNING: type inference failed for: r7v3 */
    /* JADX WARNING: type inference failed for: r2v5, types: [com.facebook.appevents.internal.SourceApplicationInfo] */
    /* JADX WARNING: type inference failed for: r7v4 */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r7v0
      assigns: [?[int, float, boolean, short, byte, char, OBJECT, ARRAY], ?[OBJECT, ARRAY]]
      uses: [com.facebook.appevents.internal.SessionInfo, com.facebook.appevents.internal.SourceApplicationInfo]
      mth insns count: 40
    	at jadx.core.dex.visitors.typeinference.TypeSearch.fillTypeCandidates(TypeSearch.java:237)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
    	at jadx.core.dex.visitors.typeinference.TypeSearch.run(TypeSearch.java:53)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runMultiVariableSearch(TypeInferenceVisitor.java:104)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:97)
     */
    /* JADX WARNING: Unknown variable types count: 2 */
    /* renamed from: onActivityCreated$lambda-1  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m172onActivityCreated$lambda1() {
        /*
            com.facebook.appevents.internal.SessionInfo r0 = currentSession
            if (r0 != 0) goto L_0x0087
            com.facebook.FacebookSdk r0 = com.facebook.FacebookSdk.INSTANCE
            android.content.Context r0 = com.facebook.FacebookSdk.getApplicationContext()
            android.content.SharedPreferences r0 = android.preference.PreferenceManager.getDefaultSharedPreferences(r0)
            r1 = 0
            java.lang.String r3 = "com.facebook.appevents.SessionInfo.sessionStartTime"
            long r3 = r0.getLong(r3, r1)
            java.lang.String r5 = "com.facebook.appevents.SessionInfo.sessionEndTime"
            long r5 = r0.getLong(r5, r1)
            r7 = 0
            java.lang.String r8 = "com.facebook.appevents.SessionInfo.sessionId"
            java.lang.String r8 = r0.getString(r8, r7)
            int r9 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r9 == 0) goto L_0x0085
            int r9 = (r5 > r1 ? 1 : (r5 == r1 ? 0 : -1))
            if (r9 == 0) goto L_0x0085
            if (r8 != 0) goto L_0x002e
            goto L_0x0085
        L_0x002e:
            com.facebook.appevents.internal.SessionInfo r1 = new com.facebook.appevents.internal.SessionInfo
            java.lang.Long r2 = java.lang.Long.valueOf(r3)
            java.lang.Long r3 = java.lang.Long.valueOf(r5)
            r4 = 4
            r1.<init>(r2, r3, r7, r4)
            r2 = 0
            java.lang.String r3 = "com.facebook.appevents.SessionInfo.interruptionCount"
            int r0 = r0.getInt(r3, r2)
            r1.interruptionCount = r0
            com.facebook.FacebookSdk r0 = com.facebook.FacebookSdk.INSTANCE
            android.content.Context r0 = com.facebook.FacebookSdk.getApplicationContext()
            android.content.SharedPreferences r0 = android.preference.PreferenceManager.getDefaultSharedPreferences(r0)
            java.lang.String r3 = "com.facebook.appevents.SourceApplicationInfo.callingApplicationPackage"
            boolean r4 = r0.contains(r3)
            if (r4 != 0) goto L_0x0058
            goto L_0x0068
        L_0x0058:
            java.lang.String r3 = r0.getString(r3, r7)
            java.lang.String r4 = "com.facebook.appevents.SourceApplicationInfo.openedByApplink"
            boolean r0 = r0.getBoolean(r4, r2)
            com.facebook.appevents.internal.SourceApplicationInfo r2 = new com.facebook.appevents.internal.SourceApplicationInfo
            r2.<init>(r3, r0, r7)
            r7 = r2
        L_0x0068:
            r1.sourceApplicationInfo = r7
            long r2 = java.lang.System.currentTimeMillis()
            java.lang.Long r0 = java.lang.Long.valueOf(r2)
            r1.diskRestoreTime = r0
            java.util.UUID r0 = java.util.UUID.fromString(r8)
            java.lang.String r2 = "fromString(sessionIDStr)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r2)
            java.lang.String r2 = "<set-?>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r2)
            r1.sessionId = r0
            r7 = r1
        L_0x0085:
            currentSession = r7
        L_0x0087:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.appevents.internal.ActivityLifecycleTracker.m172onActivityCreated$lambda1():void");
    }

    /* renamed from: onActivityPaused$lambda-6  reason: not valid java name */
    public static final void m173onActivityPaused$lambda6(long j, String str) {
        int i;
        Intrinsics.checkNotNullParameter(str, "$activityName");
        if (currentSession == null) {
            currentSession = new SessionInfo(Long.valueOf(j), null, null, 4);
        }
        SessionInfo sessionInfo = currentSession;
        if (sessionInfo != null) {
            sessionInfo.sessionLastEventTime = Long.valueOf(j);
        }
        if (foregroundActivityCount.get() <= 0) {
            $$Lambda$3_sU20C6cin3z58vx2KmrQAdBZ8 r0 = new Runnable(j, str) {
                public final /* synthetic */ long f$0;
                public final /* synthetic */ String f$1;

                {
                    this.f$0 = r1;
                    this.f$1 = r3;
                }

                public final void run() {
                    ActivityLifecycleTracker.m174onActivityPaused$lambda6$lambda4(this.f$0, this.f$1);
                }
            };
            synchronized (currentFutureLock) {
                ScheduledExecutorService scheduledExecutorService = singleThreadExecutor;
                FetchedAppSettingsManager fetchedAppSettingsManager = FetchedAppSettingsManager.INSTANCE;
                FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
                FetchedAppSettings appSettingsWithoutQuery = FetchedAppSettingsManager.getAppSettingsWithoutQuery(FacebookSdk.getApplicationId());
                if (appSettingsWithoutQuery == null) {
                    i = 60;
                } else {
                    i = appSettingsWithoutQuery.sessionTimeoutInSeconds;
                }
                currentFuture = scheduledExecutorService.schedule(r0, (long) i, TimeUnit.SECONDS);
            }
        }
        long j2 = currentActivityAppearTime;
        long j3 = j2 > 0 ? (j - j2) / ((long) 1000) : 0;
        AutomaticAnalyticsLogger automaticAnalyticsLogger = AutomaticAnalyticsLogger.INSTANCE;
        FacebookSdk facebookSdk2 = FacebookSdk.INSTANCE;
        Context applicationContext = FacebookSdk.getApplicationContext();
        FacebookSdk facebookSdk3 = FacebookSdk.INSTANCE;
        String applicationId = FacebookSdk.getApplicationId();
        FetchedAppSettingsManager fetchedAppSettingsManager2 = FetchedAppSettingsManager.INSTANCE;
        FetchedAppSettings queryAppSettings = FetchedAppSettingsManager.queryAppSettings(applicationId, false);
        if (queryAppSettings != null && queryAppSettings.automaticLoggingEnabled && j3 > 0) {
            AppEventsLoggerImpl appEventsLoggerImpl = new AppEventsLoggerImpl(applicationContext, (String) null, (AccessToken) null);
            Intrinsics.checkNotNullParameter(appEventsLoggerImpl, "loggerImpl");
            Bundle bundle = new Bundle(1);
            bundle.putCharSequence("fb_aa_time_spent_view_name", str);
            double d2 = (double) j3;
            FacebookSdk facebookSdk4 = FacebookSdk.INSTANCE;
            if (FacebookSdk.getAutoLogAppEventsEnabled()) {
                appEventsLoggerImpl.logEvent("fb_aa_time_spent_on_view", d2, bundle);
            }
        }
        SessionInfo sessionInfo2 = currentSession;
        if (sessionInfo2 != null) {
            sessionInfo2.writeSessionToDisk();
        }
    }

    /* renamed from: onActivityPaused$lambda-6$lambda-4  reason: not valid java name */
    public static final void m174onActivityPaused$lambda6$lambda4(long j, String str) {
        Intrinsics.checkNotNullParameter(str, "$activityName");
        if (currentSession == null) {
            currentSession = new SessionInfo(Long.valueOf(j), null, null, 4);
        }
        if (foregroundActivityCount.get() <= 0) {
            SessionLogger.logDeactivateApp(str, currentSession, appId);
            FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
            Editor edit = PreferenceManager.getDefaultSharedPreferences(FacebookSdk.getApplicationContext()).edit();
            edit.remove("com.facebook.appevents.SessionInfo.sessionStartTime");
            edit.remove("com.facebook.appevents.SessionInfo.sessionEndTime");
            edit.remove("com.facebook.appevents.SessionInfo.interruptionCount");
            edit.remove("com.facebook.appevents.SessionInfo.sessionId");
            edit.apply();
            FacebookSdk facebookSdk2 = FacebookSdk.INSTANCE;
            Editor edit2 = PreferenceManager.getDefaultSharedPreferences(FacebookSdk.getApplicationContext()).edit();
            edit2.remove("com.facebook.appevents.SourceApplicationInfo.callingApplicationPackage");
            edit2.remove("com.facebook.appevents.SourceApplicationInfo.openedByApplink");
            edit2.apply();
            currentSession = null;
        }
        synchronized (currentFutureLock) {
            currentFuture = null;
        }
    }

    /* renamed from: onActivityResumed$lambda-2  reason: not valid java name */
    public static final void m175onActivityResumed$lambda2(long j, String str, Context context) {
        Long l;
        int i;
        Intrinsics.checkNotNullParameter(str, "$activityName");
        SessionInfo sessionInfo = currentSession;
        if (sessionInfo == null) {
            l = null;
        } else {
            l = sessionInfo.sessionLastEventTime;
        }
        if (currentSession == null) {
            currentSession = new SessionInfo(Long.valueOf(j), null, null, 4);
            String str2 = appId;
            Intrinsics.checkNotNullExpressionValue(context, "appContext");
            SessionLogger.logActivateApp(str, null, str2, context);
        } else if (l != null) {
            long longValue = j - l.longValue();
            FetchedAppSettingsManager fetchedAppSettingsManager = FetchedAppSettingsManager.INSTANCE;
            FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
            FetchedAppSettings appSettingsWithoutQuery = FetchedAppSettingsManager.getAppSettingsWithoutQuery(FacebookSdk.getApplicationId());
            if (appSettingsWithoutQuery == null) {
                i = 60;
            } else {
                i = appSettingsWithoutQuery.sessionTimeoutInSeconds;
            }
            if (longValue > ((long) (i * 1000))) {
                SessionLogger.logDeactivateApp(str, currentSession, appId);
                String str3 = appId;
                Intrinsics.checkNotNullExpressionValue(context, "appContext");
                SessionLogger.logActivateApp(str, null, str3, context);
                currentSession = new SessionInfo(Long.valueOf(j), null, null, 4);
            } else if (longValue > 1000) {
                SessionInfo sessionInfo2 = currentSession;
                if (sessionInfo2 != null) {
                    sessionInfo2.interruptionCount++;
                }
            }
        }
        SessionInfo sessionInfo3 = currentSession;
        if (sessionInfo3 != null) {
            sessionInfo3.sessionLastEventTime = Long.valueOf(j);
        }
        SessionInfo sessionInfo4 = currentSession;
        if (sessionInfo4 != null) {
            sessionInfo4.writeSessionToDisk();
        }
    }

    public static final void startTracking(Application application, String str) {
        Intrinsics.checkNotNullParameter(application, "application");
        if (tracking.compareAndSet(false, true)) {
            FeatureManager featureManager = FeatureManager.INSTANCE;
            FeatureManager.checkFeature(Feature.CodelessEvents, $$Lambda$8hcyK5i_zMiQ9qMOxD4eNscIJqM.INSTANCE);
            appId = str;
            application.registerActivityLifecycleCallbacks(new ActivityLifecycleTracker$startTracking$2());
        }
    }

    /* renamed from: startTracking$lambda-0  reason: not valid java name */
    public static final void m176startTracking$lambda0(boolean z) {
        Class<CodelessManager> cls = CodelessManager.class;
        if (z) {
            CodelessManager codelessManager = CodelessManager.INSTANCE;
            if (!CrashShieldHandler.isObjectCrashing(cls)) {
                try {
                    CodelessManager.isCodelessEnabled.set(true);
                } catch (Throwable th) {
                    CrashShieldHandler.handleThrowable(th, cls);
                }
            }
        } else {
            CodelessManager codelessManager2 = CodelessManager.INSTANCE;
            if (!CrashShieldHandler.isObjectCrashing(cls)) {
                try {
                    CodelessManager.isCodelessEnabled.set(false);
                } catch (Throwable th2) {
                    CrashShieldHandler.handleThrowable(th2, cls);
                }
            }
        }
    }

    public final void cancelCurrentTask() {
        synchronized (currentFutureLock) {
            if (currentFuture != null) {
                ScheduledFuture<?> scheduledFuture = currentFuture;
                if (scheduledFuture != null) {
                    scheduledFuture.cancel(false);
                }
            }
            currentFuture = null;
        }
    }
}
