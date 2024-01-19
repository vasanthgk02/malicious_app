package com.facebook.appevents.internal;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import com.facebook.FacebookSdk;
import com.facebook.LoggingBehavior;
import com.facebook.appevents.$$Lambda$62J7sj8JMyiA3W4h7e07NMp8t6E;
import com.facebook.appevents.AppEventQueue;
import com.facebook.appevents.AppEventsLoggerImpl;
import com.facebook.appevents.AppEventsLoggerImpl.Companion;
import com.facebook.appevents.aam.MetadataIndexer;
import com.facebook.appevents.aam.MetadataRule;
import com.facebook.appevents.aam.MetadataViewObserver;
import com.facebook.appevents.codeless.$$Lambda$vzd3Vq5Ies9LLUeAp7KTjGDCc58;
import com.facebook.appevents.codeless.CodelessManager;
import com.facebook.appevents.codeless.CodelessMatcher;
import com.facebook.appevents.codeless.ViewIndexer;
import com.facebook.appevents.codeless.ViewIndexingTrigger;
import com.facebook.appevents.codeless.ViewIndexingTrigger.OnShakeListener;
import com.facebook.appevents.iap.InAppPurchaseManager;
import com.facebook.appevents.suggestedevents.SuggestedEventsManager;
import com.facebook.internal.FetchedAppSettings;
import com.facebook.internal.FetchedAppSettingsManager;
import com.facebook.internal.Logger;
import com.facebook.internal.Utility;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Timer;
import java.util.concurrent.ScheduledFuture;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0018\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u0007H\u0016J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u000f"}, d2 = {"com/facebook/appevents/internal/ActivityLifecycleTracker$startTracking$2", "Landroid/app/Application$ActivityLifecycleCallbacks;", "onActivityCreated", "", "activity", "Landroid/app/Activity;", "savedInstanceState", "Landroid/os/Bundle;", "onActivityDestroyed", "onActivityPaused", "onActivityResumed", "onActivitySaveInstanceState", "outState", "onActivityStarted", "onActivityStopped", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: ActivityLifecycleTracker.kt */
public final class ActivityLifecycleTracker$startTracking$2 implements ActivityLifecycleCallbacks {
    public void onActivityCreated(Activity activity, Bundle bundle) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Logger.Companion.log(LoggingBehavior.APP_EVENTS, ActivityLifecycleTracker.TAG, "onActivityCreated");
        ActivityLifecycleTracker activityLifecycleTracker = ActivityLifecycleTracker.INSTANCE;
        ActivityLifecycleTracker.singleThreadExecutor.execute($$Lambda$XOX9ESVnlXeW178B9Ol43TaNwnA.INSTANCE);
    }

    public void onActivityDestroyed(Activity activity) {
        CodelessMatcher instance;
        Intrinsics.checkNotNullParameter(activity, "activity");
        Logger.Companion.log(LoggingBehavior.APP_EVENTS, ActivityLifecycleTracker.TAG, "onActivityDestroyed");
        ActivityLifecycleTracker activityLifecycleTracker = ActivityLifecycleTracker.INSTANCE;
        CodelessManager codelessManager = CodelessManager.INSTANCE;
        Class<CodelessManager> cls = CodelessManager.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                Intrinsics.checkNotNullParameter(activity, "activity");
                instance = CodelessMatcher.Companion.getInstance();
                if (!CrashShieldHandler.isObjectCrashing(instance)) {
                    Intrinsics.checkNotNullParameter(activity, "activity");
                    instance.activityToListenerMap.remove(Integer.valueOf(activity.hashCode()));
                }
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, cls);
            }
        }
    }

    public void onActivityPaused(Activity activity) {
        ViewIndexer viewIndexer;
        Intrinsics.checkNotNullParameter(activity, "activity");
        Logger.Companion.log(LoggingBehavior.APP_EVENTS, ActivityLifecycleTracker.TAG, "onActivityPaused");
        ActivityLifecycleTracker activityLifecycleTracker = ActivityLifecycleTracker.INSTANCE;
        if (ActivityLifecycleTracker.foregroundActivityCount.decrementAndGet() < 0) {
            ActivityLifecycleTracker.foregroundActivityCount.set(0);
        }
        activityLifecycleTracker.cancelCurrentTask();
        long currentTimeMillis = System.currentTimeMillis();
        String activityName = Utility.getActivityName(activity);
        CodelessManager codelessManager = CodelessManager.INSTANCE;
        Class<CodelessManager> cls = CodelessManager.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                Intrinsics.checkNotNullParameter(activity, "activity");
                if (CodelessManager.isCodelessEnabled.get()) {
                    CodelessMatcher.Companion.getInstance().remove(activity);
                    viewIndexer = CodelessManager.viewIndexer;
                    if (viewIndexer != null) {
                        if (!CrashShieldHandler.isObjectCrashing(viewIndexer)) {
                            if (((Activity) viewIndexer.activityReference.get()) != null) {
                                try {
                                    Timer timer = viewIndexer.indexingTimer;
                                    if (timer != null) {
                                        timer.cancel();
                                    }
                                    viewIndexer.indexingTimer = null;
                                } catch (Exception unused) {
                                }
                            }
                        }
                    }
                    SensorManager sensorManager = CodelessManager.sensorManager;
                    if (sensorManager != null) {
                        sensorManager.unregisterListener(CodelessManager.viewIndexingTrigger);
                    }
                }
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, cls);
            }
        }
        ActivityLifecycleTracker.singleThreadExecutor.execute(new Runnable(currentTimeMillis, activityName) {
            public final /* synthetic */ long f$0;
            public final /* synthetic */ String f$1;

            {
                this.f$0 = r1;
                this.f$1 = r3;
            }

            public final void run() {
                ActivityLifecycleTracker.m173onActivityPaused$lambda6(this.f$0, this.f$1);
            }
        });
    }

    public void onActivityResumed(Activity activity) {
        Boolean bool;
        ViewIndexingTrigger viewIndexingTrigger;
        Intrinsics.checkNotNullParameter(activity, "activity");
        Logger.Companion.log(LoggingBehavior.APP_EVENTS, ActivityLifecycleTracker.TAG, "onActivityResumed");
        ActivityLifecycleTracker activityLifecycleTracker = ActivityLifecycleTracker.INSTANCE;
        Intrinsics.checkNotNullParameter(activity, "activity");
        ActivityLifecycleTracker.currActivity = new WeakReference<>(activity);
        ActivityLifecycleTracker.foregroundActivityCount.incrementAndGet();
        synchronized (ActivityLifecycleTracker.currentFutureLock) {
            if (ActivityLifecycleTracker.currentFuture != null) {
                ScheduledFuture<?> scheduledFuture = ActivityLifecycleTracker.currentFuture;
                if (scheduledFuture != null) {
                    scheduledFuture.cancel(false);
                }
            }
            bool = null;
            ActivityLifecycleTracker.currentFuture = null;
        }
        long currentTimeMillis = System.currentTimeMillis();
        ActivityLifecycleTracker.currentActivityAppearTime = currentTimeMillis;
        String activityName = Utility.getActivityName(activity);
        CodelessManager codelessManager = CodelessManager.INSTANCE;
        Class<CodelessManager> cls = CodelessManager.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                Intrinsics.checkNotNullParameter(activity, "activity");
                if (CodelessManager.isCodelessEnabled.get()) {
                    CodelessMatcher.Companion.getInstance().add(activity);
                    Context applicationContext = activity.getApplicationContext();
                    FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
                    String applicationId = FacebookSdk.getApplicationId();
                    FetchedAppSettingsManager fetchedAppSettingsManager = FetchedAppSettingsManager.INSTANCE;
                    FetchedAppSettings appSettingsWithoutQuery = FetchedAppSettingsManager.getAppSettingsWithoutQuery(applicationId);
                    if (appSettingsWithoutQuery != null) {
                        bool = Boolean.valueOf(appSettingsWithoutQuery.codelessEventsEnabled);
                    }
                    if (!Intrinsics.areEqual(bool, Boolean.TRUE)) {
                        CrashShieldHandler.isObjectCrashing(CodelessManager.INSTANCE);
                    } else {
                        SensorManager sensorManager = (SensorManager) applicationContext.getSystemService("sensor");
                        if (sensorManager != null) {
                            CodelessManager.sensorManager = sensorManager;
                            Sensor defaultSensor = sensorManager.getDefaultSensor(1);
                            ViewIndexer viewIndexer = new ViewIndexer(activity);
                            CodelessManager.viewIndexer = viewIndexer;
                            viewIndexingTrigger = CodelessManager.viewIndexingTrigger;
                            $$Lambda$vzd3Vq5Ies9LLUeAp7KTjGDCc58 r10 = new OnShakeListener(applicationId) {
                                public final /* synthetic */ String f$1;

                                {
                                    this.f$1 = r2;
                                }

                                public final void onShake() {
                                    CodelessManager.m162onActivityResumed$lambda0(FetchedAppSettings.this, this.f$1);
                                }
                            };
                            if (!CrashShieldHandler.isObjectCrashing(viewIndexingTrigger)) {
                                viewIndexingTrigger.onShakeListener = r10;
                            }
                            sensorManager.registerListener(CodelessManager.viewIndexingTrigger, defaultSensor, 2);
                            if (appSettingsWithoutQuery != null && appSettingsWithoutQuery.codelessEventsEnabled) {
                                viewIndexer.schedule();
                            }
                        }
                    }
                    CrashShieldHandler.isObjectCrashing(CodelessManager.INSTANCE);
                }
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, cls);
            }
        }
        Class<MetadataIndexer> cls2 = MetadataIndexer.class;
        if (!CrashShieldHandler.isObjectCrashing(cls2)) {
            try {
                Intrinsics.checkNotNullParameter(activity, "activity");
                try {
                    if (MetadataIndexer.enabled) {
                        MetadataRule metadataRule = MetadataRule.Companion;
                        if (!new HashSet(MetadataRule.access$getRules$cp()).isEmpty()) {
                            MetadataViewObserver.Companion.startTrackingActivity(activity);
                        }
                    }
                } catch (Exception unused) {
                }
            } catch (Throwable th2) {
                CrashShieldHandler.handleThrowable(th2, cls2);
            }
        }
        SuggestedEventsManager suggestedEventsManager = SuggestedEventsManager.INSTANCE;
        SuggestedEventsManager.trackActivity(activity);
        InAppPurchaseManager inAppPurchaseManager = InAppPurchaseManager.INSTANCE;
        InAppPurchaseManager.startTracking();
        ActivityLifecycleTracker.singleThreadExecutor.execute(new Runnable(currentTimeMillis, activityName, activity.getApplicationContext()) {
            public final /* synthetic */ long f$0;
            public final /* synthetic */ String f$1;
            public final /* synthetic */ Context f$2;

            {
                this.f$0 = r1;
                this.f$1 = r3;
                this.f$2 = r4;
            }

            public final void run() {
                ActivityLifecycleTracker.m175onActivityResumed$lambda2(this.f$0, this.f$1, this.f$2);
            }
        });
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(bundle, "outState");
        Logger.Companion.log(LoggingBehavior.APP_EVENTS, ActivityLifecycleTracker.TAG, "onActivitySaveInstanceState");
    }

    public void onActivityStarted(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        ActivityLifecycleTracker activityLifecycleTracker = ActivityLifecycleTracker.INSTANCE;
        ActivityLifecycleTracker.activityReferences++;
        Logger.Companion.log(LoggingBehavior.APP_EVENTS, ActivityLifecycleTracker.TAG, "onActivityStarted");
    }

    public void onActivityStopped(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Logger.Companion.log(LoggingBehavior.APP_EVENTS, ActivityLifecycleTracker.TAG, "onActivityStopped");
        Companion companion = AppEventsLoggerImpl.Companion;
        AppEventQueue appEventQueue = AppEventQueue.INSTANCE;
        Class<AppEventQueue> cls = AppEventQueue.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                AppEventQueue.singleThreadExecutor.execute($$Lambda$62J7sj8JMyiA3W4h7e07NMp8t6E.INSTANCE);
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, cls);
            }
        }
        ActivityLifecycleTracker activityLifecycleTracker = ActivityLifecycleTracker.INSTANCE;
        ActivityLifecycleTracker.activityReferences--;
    }
}
