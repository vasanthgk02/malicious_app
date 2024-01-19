package com.mpl.androidapp;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.clevertap.android.sdk.CleverTapAPI;
import com.mpl.analytics.MPLAnalytics;
import com.mpl.androidapp.game.MPLUnityPlayerActivity;
import com.mpl.androidapp.miniprofile.ct.C.PlaybackWatched;
import com.mpl.androidapp.responsiblegaming.RgSessionManager;
import com.mpl.androidapp.utils.CleverTapAnalyticsUtils;
import com.mpl.androidapp.utils.MLogger;
import java.util.HashMap;
import java.util.Random;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt__CharKt;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\f\u0018\u0000 !2\u00020\u0001:\u0001!B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0002J\b\u0010\n\u001a\u00020\u000bH\u0002J\u001a\u0010\f\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\u0010\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\u0011\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u001a\u0010\u0012\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\u0010\u0010\u0013\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\u0014\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\b\u0010\u0015\u001a\u00020\u0016H\u0002J\b\u0010\u0017\u001a\u00020\u0007H\u0002J\b\u0010\u0018\u001a\u00020\u0007H\u0002J\u0010\u0010\u0019\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0002J\b\u0010\u001a\u001a\u00020\u0007H\u0002J\u0010\u0010\u001b\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0002J\u0010\u0010\u001c\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0002J\u0010\u0010\u001d\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0002J\u0010\u0010\u001e\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0002J\u0010\u0010\u001f\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0002J\b\u0010 \u001a\u00020\u0007H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/mpl/androidapp/MPLApplicationLifeCycleCallback;", "Landroid/app/Application$ActivityLifecycleCallbacks;", "()V", "TAG", "", "tag", "addActivitySettings", "", "activity", "Landroid/app/Activity;", "getSessionTimeRunnable", "Ljava/lang/Runnable;", "onActivityCreated", "bundle", "Landroid/os/Bundle;", "onActivityDestroyed", "onActivityPaused", "onActivityResumed", "onActivitySaveInstanceState", "onActivityStarted", "onActivityStopped", "postRunnable", "", "removeSessionRunnable", "reset", "sendIntentData", "sendSessionData", "whenActivityDestroyed", "whenActivityStarted", "whenActivityStopped", "whenAppStopped", "whenConversationDetailActivity", "whenFirstActivityStarted", "Companion", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: MPLApplicationLifeCycleCallback.kt */
public final class MPLApplicationLifeCycleCallback implements ActivityLifecycleCallbacks {
    public static final Companion Companion = new Companion(null);
    public static final String WZRK_ACCT_ID_KEY = "wzrk_acct_id";
    public static int activityStarted;
    public static long appLastBackgroundTime;
    public static long appLastSeen;
    public static final Handler handlerUsingMainLooper = new Handler(Looper.getMainLooper());
    public static boolean isConfigurationChanging;
    public static int numStarted;
    public static Runnable sessionTimeoutRunnable;
    public static int startedTime;
    public static final int uuid = new Random().nextInt(1000);
    public final String TAG = "ResponsibleGamingTimer";
    public final String tag;

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0012\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0015\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/mpl/androidapp/MPLApplicationLifeCycleCallback$Companion;", "", "()V", "WZRK_ACCT_ID_KEY", "", "activityStarted", "", "appLastBackgroundTime", "", "appLastSeen", "handlerUsingMainLooper", "Landroid/os/Handler;", "isConfigurationChanging", "", "numStarted", "sessionTimeoutRunnable", "Ljava/lang/Runnable;", "startedTime", "timeElapsedUntilNow", "getTimeElapsedUntilNow", "()I", "uuid", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: MPLApplicationLifeCycleCallback.kt */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int getTimeElapsedUntilNow() {
            int access$getStartedTime$cp = MPLApplicationLifeCycleCallback.startedTime;
            if (access$getStartedTime$cp == 0) {
                return -1;
            }
            return ((int) (System.currentTimeMillis() / ((long) 1000))) - access$getStartedTime$cp;
        }
    }

    public MPLApplicationLifeCycleCallback() {
        startedTime = (int) (System.currentTimeMillis() / ((long) 1000));
        String simpleName = MPLApplicationLifeCycleCallback.class.getSimpleName();
        Intrinsics.checkNotNullExpressionValue(simpleName, "this.javaClass.simpleName");
        this.tag = simpleName;
    }

    private final void addActivitySettings(Activity activity) {
        whenConversationDetailActivity(activity);
    }

    private final Runnable getSessionTimeRunnable() {
        return new Runnable() {
            public final void run() {
                MPLApplicationLifeCycleCallback.m8getSessionTimeRunnable$lambda6(MPLApplicationLifeCycleCallback.this);
            }
        };
    }

    /* renamed from: getSessionTimeRunnable$lambda-6  reason: not valid java name */
    public static final void m8getSessionTimeRunnable$lambda6(MPLApplicationLifeCycleCallback mPLApplicationLifeCycleCallback) {
        Intrinsics.checkNotNullParameter(mPLApplicationLifeCycleCallback, "this$0");
        int timeElapsedUntilNow = Companion.getTimeElapsedUntilNow();
        HashMap hashMap = new HashMap();
        long currentTimeMillis = ((System.currentTimeMillis() - appLastSeen) - ((long) 60000)) / ((long) 1000);
        hashMap.put("Session Time", Long.valueOf(currentTimeMillis));
        hashMap.put("Time Elapsed", Integer.valueOf(timeElapsedUntilNow));
        String str = mPLApplicationLifeCycleCallback.tag;
        MLogger.d(str, "App Closed seconds " + currentTimeMillis + " timeElapsed " + timeElapsedUntilNow);
        mPLApplicationLifeCycleCallback.reset();
    }

    private final boolean postRunnable() {
        Runnable runnable = sessionTimeoutRunnable;
        if (runnable == null) {
            return false;
        }
        return handlerUsingMainLooper.postDelayed(runnable, 60000);
    }

    private final void removeSessionRunnable() {
        Runnable runnable = sessionTimeoutRunnable;
        if (runnable != null) {
            handlerUsingMainLooper.removeCallbacks(runnable);
        }
    }

    private final void reset() {
        appLastSeen = 0;
        appLastBackgroundTime = 0;
    }

    private final void sendIntentData(Activity activity) {
        Bundle extras = activity.getIntent().getExtras();
        if (extras != null) {
            Uri data = activity.getIntent().getData();
            MPLAnalytics mplAnalytics = MPLApplication.getMplAnalytics();
            mplAnalytics.pushNotificationClickedEventV2(extras);
            mplAnalytics.pushDeepLink(data);
            MLogger.d(this.tag, "Sending to MPL analytics");
        }
    }

    private final void sendSessionData() {
        int timeElapsedUntilNow = Companion.getTimeElapsedUntilNow();
        HashMap hashMap = new HashMap();
        long currentTimeMillis = (System.currentTimeMillis() - appLastSeen) / ((long) 1000);
        hashMap.put("Session Time", Long.valueOf(currentTimeMillis));
        hashMap.put("Time Elapsed", Integer.valueOf(timeElapsedUntilNow));
        CleverTapAnalyticsUtils.sendEvent((String) PlaybackWatched.TRIGGER_MODE_APP_CLOSED, hashMap);
        String str = this.tag;
        MLogger.d(str, "App Closed seconds " + currentTimeMillis + " timeElapsed " + timeElapsedUntilNow);
    }

    private final void whenActivityDestroyed(Activity activity) {
        removeSessionRunnable();
        sendSessionData();
        reset();
        whenConversationDetailActivity(activity);
    }

    private final void whenActivityStarted(Activity activity) {
        long j;
        String localClassName = activity.getLocalClassName();
        Intrinsics.checkNotNullExpressionValue(localClassName, "activity.localClassName");
        if (!CharsKt__CharKt.contains$default((CharSequence) localClassName, (CharSequence) MPLUnityPlayerActivity.TAG, false, 2) && numStarted == 0) {
            long j2 = appLastSeen;
            if (j2 != 0) {
                j = (System.currentTimeMillis() - appLastBackgroundTime) + j2;
            } else {
                j = System.currentTimeMillis();
            }
            appLastSeen = j;
            removeSessionRunnable();
            numStarted++;
        }
    }

    private final void whenActivityStopped(Activity activity) {
        String localClassName = activity.getLocalClassName();
        Intrinsics.checkNotNullExpressionValue(localClassName, "activity.localClassName");
        if (!CharsKt__CharKt.contains$default((CharSequence) localClassName, (CharSequence) MPLUnityPlayerActivity.TAG, false, 2)) {
            int i = numStarted - 1;
            numStarted = i;
            if (i == 0) {
                appLastBackgroundTime = System.currentTimeMillis();
                if (sessionTimeoutRunnable == null) {
                    sessionTimeoutRunnable = getSessionTimeRunnable();
                }
                int timeElapsedUntilNow = Companion.getTimeElapsedUntilNow();
                Bundle bundle = new Bundle();
                long j = (long) 1000;
                bundle.putLong("session_time", (System.currentTimeMillis() - appLastSeen) / j);
                bundle.putLong("time_elapsed", (long) timeElapsedUntilNow);
                MPLLibInitContentProvider libInitContentProvider = MPLLibInitContentProvider.getLibInitContentProvider();
                if (libInitContentProvider != null) {
                    if (libInitContentProvider.getFirebaseAnalytics() != null) {
                        libInitContentProvider.getFirebaseAnalytics().zzb.zzx("app_Closed", bundle);
                    }
                }
                if (activity.isFinishing()) {
                    int timeElapsedUntilNow2 = Companion.getTimeElapsedUntilNow();
                    HashMap hashMap = new HashMap();
                    long currentTimeMillis = (System.currentTimeMillis() - appLastSeen) / j;
                    hashMap.put("Session Time", Long.valueOf(currentTimeMillis));
                    hashMap.put("Time Elapsed", Integer.valueOf(timeElapsedUntilNow2));
                    CleverTapAnalyticsUtils.sendEvent((String) PlaybackWatched.TRIGGER_MODE_APP_CLOSED, hashMap);
                    MLogger.d(this.tag, "App Closed Event  called with sessionTimeSeconds", Long.valueOf(currentTimeMillis), "timeElapsed", Integer.valueOf(timeElapsedUntilNow2));
                    reset();
                    return;
                }
                MLogger.d(this.tag, Intrinsics.stringPlus("isSessionRunnablePosted? ", Boolean.valueOf(postRunnable())));
            }
        }
    }

    private final void whenAppStopped(Activity activity) {
        boolean isChangingConfigurations = activity.isChangingConfigurations();
        isConfigurationChanging = isChangingConfigurations;
        int i = activityStarted - 1;
        activityStarted = i;
        if (i == 0 && !isChangingConfigurations) {
            MLogger.d(this.TAG, Intrinsics.stringPlus("Going in background! id is ", Integer.valueOf(uuid)));
            RgSessionManager rgSessionManager = MPLApplication.getRgSessionManager();
            if (rgSessionManager != null) {
                rgSessionManager.onAppBackground();
            }
        }
    }

    private final void whenConversationDetailActivity(Activity activity) {
        String localClassName = activity.getLocalClassName();
        Intrinsics.checkNotNullExpressionValue(localClassName, "activity.localClassName");
        if (CharsKt__CharKt.contains$default((CharSequence) localClassName, (CharSequence) "ConversationDetailActivity", false, 2)) {
            activity.getWindow().setFlags(8192, 8192);
            if (VERSION.SDK_INT >= 29) {
                activity.getWindow().setSoftInputMode(32);
            }
        }
    }

    private final void whenFirstActivityStarted() {
        int i = activityStarted + 1;
        activityStarted = i;
        if (i == 1 && !isConfigurationChanging) {
            MLogger.d(this.TAG, Intrinsics.stringPlus("onApplicationForeground id is ", Integer.valueOf(uuid)));
            RgSessionManager rgSessionManager = MPLApplication.getRgSessionManager();
            if (rgSessionManager != null) {
                rgSessionManager.onAppForeground();
            }
        }
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        try {
            CleverTapAPI.setAppForeground(true);
            sendIntentData(activity);
        } catch (Throwable th) {
            MLogger.e(this.tag, th);
        }
        addActivitySettings(activity);
    }

    public void onActivityDestroyed(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        String str = this.tag;
        MLogger.d(str, "onActivityDestroyed() activity = [" + activity + ']');
        if (appLastSeen > 0) {
            whenActivityDestroyed(activity);
        }
    }

    public void onActivityPaused(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        MLogger.d(this.tag, Intrinsics.stringPlus("onActivityPaused() ", activity.getLocalClassName()));
        MPLApplication.getMplAnalytics().activityPaused(activity);
    }

    public void onActivityResumed(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        MLogger.d(this.tag, Intrinsics.stringPlus("onActivityResumed() ", activity.getLocalClassName()));
        MPLApplication.getMplAnalytics().activityResumed(activity);
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        Intrinsics.checkNotNullParameter(activity, "activity");
    }

    public void onActivityStarted(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        String str = this.tag;
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("onActivityStarted()  ");
        outline73.append(activity.getLocalClassName());
        outline73.append(' ');
        outline73.append(numStarted);
        MLogger.d(str, outline73.toString());
        whenActivityStarted(activity);
        whenFirstActivityStarted();
    }

    public void onActivityStopped(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        String str = this.tag;
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("onActivityStopped() numStarted ");
        outline73.append(numStarted);
        outline73.append(" isActivityFinishing? ");
        outline73.append(activity.isFinishing());
        MLogger.d(str, outline73.toString());
        whenActivityStopped(activity);
        whenAppStopped(activity);
    }
}
