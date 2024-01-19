package com.facebook.appevents.suggestedevents;

import android.app.Activity;
import com.facebook.FacebookSdk;
import com.facebook.appevents.internal.ActivityLifecycleTracker;
import com.facebook.appevents.ml.ModelManager;
import com.facebook.appevents.ml.ModelManager.Task;
import com.facebook.internal.FetchedAppSettings;
import com.facebook.internal.FetchedAppSettingsManager;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010#\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u000b\u001a\u00020\fH\u0007J\b\u0010\r\u001a\u00020\fH\u0002J\u0015\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0004H\u0001¢\u0006\u0002\b\u0011J\b\u0010\u0012\u001a\u00020\u000fH\u0007J\u0015\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0004H\u0001¢\u0006\u0002\b\u0014J\u0017\u0010\u0015\u001a\u00020\f2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0004H\u0001¢\u0006\u0002\b\u0017J\u0010\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\u001aH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/facebook/appevents/suggestedevents/SuggestedEventsManager;", "", "()V", "ELIGIBLE_EVENTS_KEY", "", "PRODUCTION_EVENTS_KEY", "eligibleEvents", "", "enabled", "Ljava/util/concurrent/atomic/AtomicBoolean;", "productionEvents", "enable", "", "initialize", "isEligibleEvents", "", "event", "isEligibleEvents$facebook_core_release", "isEnabled", "isProductionEvents", "isProductionEvents$facebook_core_release", "populateEventsFromRawJsonString", "rawSuggestedEventSetting", "populateEventsFromRawJsonString$facebook_core_release", "trackActivity", "activity", "Landroid/app/Activity;", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: SuggestedEventsManager.kt */
public final class SuggestedEventsManager {
    public static final SuggestedEventsManager INSTANCE = new SuggestedEventsManager();
    public static final Set<String> eligibleEvents = new LinkedHashSet();
    public static final AtomicBoolean enabled = new AtomicBoolean(false);
    public static final Set<String> productionEvents = new LinkedHashSet();

    /* renamed from: enable$lambda-0  reason: not valid java name */
    public static final void m184enable$lambda0() {
        Class<SuggestedEventsManager> cls = SuggestedEventsManager.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                if (!enabled.get()) {
                    enabled.set(true);
                    INSTANCE.initialize();
                }
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, cls);
            }
        }
    }

    public static final void trackActivity(Activity activity) {
        Class<SuggestedEventsManager> cls = SuggestedEventsManager.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                Intrinsics.checkNotNullParameter(activity, "activity");
                try {
                    if (enabled.get()) {
                        Class<FeatureExtractor> cls2 = FeatureExtractor.class;
                        boolean z = false;
                        if (!CrashShieldHandler.isObjectCrashing(cls2)) {
                            try {
                                z = FeatureExtractor.initialized;
                            } catch (Throwable th) {
                                CrashShieldHandler.handleThrowable(th, cls2);
                            }
                        }
                        if (z && (!productionEvents.isEmpty() || !eligibleEvents.isEmpty())) {
                            ViewObserver viewObserver = ViewObserver.Companion;
                            ViewObserver.startTrackingActivity(activity);
                        }
                    }
                    ViewObserver viewObserver2 = ViewObserver.Companion;
                    ViewObserver.stopTrackingActivity(activity);
                } catch (Exception unused) {
                }
            } catch (Throwable th2) {
                CrashShieldHandler.handleThrowable(th2, cls);
            }
        }
    }

    public final void initialize() {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                FetchedAppSettingsManager fetchedAppSettingsManager = FetchedAppSettingsManager.INSTANCE;
                FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
                FetchedAppSettings queryAppSettings = FetchedAppSettingsManager.queryAppSettings(FacebookSdk.getApplicationId(), false);
                if (queryAppSettings != null) {
                    String str = queryAppSettings.suggestedEventsSetting;
                    if (str != null) {
                        populateEventsFromRawJsonString$facebook_core_release(str);
                        if ((!productionEvents.isEmpty()) || (!eligibleEvents.isEmpty())) {
                            ModelManager modelManager = ModelManager.INSTANCE;
                            File ruleFile = ModelManager.getRuleFile(Task.MTML_APP_EVENT_PREDICTION);
                            if (ruleFile != null) {
                                FeatureExtractor.initialize(ruleFile);
                                ActivityLifecycleTracker activityLifecycleTracker = ActivityLifecycleTracker.INSTANCE;
                                WeakReference<Activity> weakReference = ActivityLifecycleTracker.currActivity;
                                Activity activity = null;
                                if (weakReference != null) {
                                    if (weakReference != null) {
                                        activity = (Activity) weakReference.get();
                                    }
                                }
                                if (activity != null) {
                                    trackActivity(activity);
                                }
                            }
                        }
                    }
                }
            } catch (Exception unused) {
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }

    public final void populateEventsFromRawJsonString$facebook_core_release(String str) {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                int i = 0;
                if (jSONObject.has("production_events")) {
                    JSONArray jSONArray = jSONObject.getJSONArray("production_events");
                    int length = jSONArray.length();
                    if (length > 0) {
                        int i2 = 0;
                        while (true) {
                            int i3 = i2 + 1;
                            Set<String> set = productionEvents;
                            String string = jSONArray.getString(i2);
                            Intrinsics.checkNotNullExpressionValue(string, "jsonArray.getString(i)");
                            set.add(string);
                            if (i3 >= length) {
                                break;
                            }
                            i2 = i3;
                        }
                    }
                }
                if (jSONObject.has("eligible_for_prediction_events")) {
                    JSONArray jSONArray2 = jSONObject.getJSONArray("eligible_for_prediction_events");
                    int length2 = jSONArray2.length();
                    if (length2 > 0) {
                        while (true) {
                            int i4 = i + 1;
                            Set<String> set2 = eligibleEvents;
                            String string2 = jSONArray2.getString(i);
                            Intrinsics.checkNotNullExpressionValue(string2, "jsonArray.getString(i)");
                            set2.add(string2);
                            if (i4 >= length2) {
                                break;
                            }
                            i = i4;
                        }
                    }
                }
            } catch (Exception unused) {
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }
}
