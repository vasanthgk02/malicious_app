package com.facebook.appevents;

import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.HttpMethod;
import com.facebook.LoggingBehavior;
import com.facebook.appevents.aam.$$Lambda$HwZfI6_dusrQWeo0giyGr_AOY_o;
import com.facebook.appevents.aam.MetadataIndexer;
import com.facebook.appevents.cloudbridge.$$Lambda$m16G8HSqbE1bMmir1EfQXv1qNY;
import com.facebook.appevents.eventdeactivation.EventDeactivationManager;
import com.facebook.appevents.iap.InAppPurchaseManager;
import com.facebook.appevents.ml.$$Lambda$KNMvWVVOx1J2nhRNfxa7Dpikjp0;
import com.facebook.appevents.ml.ModelManager;
import com.facebook.appevents.restrictivedatafilter.RestrictiveDataManager;
import com.facebook.internal.FeatureManager;
import com.facebook.internal.FeatureManager.Feature;
import com.facebook.internal.FetchedAppSettings;
import com.facebook.internal.FetchedAppSettingsManager.FetchedAppSettingsCallback;
import com.facebook.internal.Logger;
import com.facebook.internal.Utility;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import com.twitter.sdk.android.tweetui.TweetUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0012\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016¨\u0006\u0007"}, d2 = {"com/facebook/appevents/AppEventsManager$start$1", "Lcom/facebook/internal/FetchedAppSettingsManager$FetchedAppSettingsCallback;", "onError", "", "onSuccess", "fetchedAppSettings", "Lcom/facebook/internal/FetchedAppSettings;", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: AppEventsManager.kt */
public final class AppEventsManager$start$1 implements FetchedAppSettingsCallback {
    /* renamed from: onSuccess$lambda-0  reason: not valid java name */
    public static final void m147onSuccess$lambda0(boolean z) {
        if (z) {
            Class<MetadataIndexer> cls = MetadataIndexer.class;
            if (!CrashShieldHandler.isObjectCrashing(cls)) {
                try {
                    FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
                    FacebookSdk.getExecutor().execute($$Lambda$HwZfI6_dusrQWeo0giyGr_AOY_o.INSTANCE);
                } catch (Exception e2) {
                    Utility.logd("com.facebook.appevents.aam.MetadataIndexer", e2);
                } catch (Throwable th) {
                    CrashShieldHandler.handleThrowable(th, cls);
                }
            }
        }
    }

    /* renamed from: onSuccess$lambda-1  reason: not valid java name */
    public static final void m148onSuccess$lambda1(boolean z) {
        if (z) {
            RestrictiveDataManager restrictiveDataManager = RestrictiveDataManager.INSTANCE;
            Class<RestrictiveDataManager> cls = RestrictiveDataManager.class;
            if (!CrashShieldHandler.isObjectCrashing(cls)) {
                try {
                    RestrictiveDataManager.enabled = true;
                    RestrictiveDataManager.INSTANCE.initialize();
                } catch (Throwable th) {
                    CrashShieldHandler.handleThrowable(th, cls);
                }
            }
        }
    }

    /* renamed from: onSuccess$lambda-2  reason: not valid java name */
    public static final void m149onSuccess$lambda2(boolean z) {
        if (z) {
            ModelManager modelManager = ModelManager.INSTANCE;
            Class<ModelManager> cls = ModelManager.class;
            if (!CrashShieldHandler.isObjectCrashing(cls)) {
                try {
                    Utility.runOnNonUiThread($$Lambda$KNMvWVVOx1J2nhRNfxa7Dpikjp0.INSTANCE);
                } catch (Throwable th) {
                    CrashShieldHandler.handleThrowable(th, cls);
                }
            }
        }
    }

    /* renamed from: onSuccess$lambda-3  reason: not valid java name */
    public static final void m150onSuccess$lambda3(boolean z) {
        if (z) {
            EventDeactivationManager eventDeactivationManager = EventDeactivationManager.INSTANCE;
            Class<EventDeactivationManager> cls = EventDeactivationManager.class;
            if (!CrashShieldHandler.isObjectCrashing(cls)) {
                try {
                    EventDeactivationManager.enabled = true;
                    EventDeactivationManager.INSTANCE.initialize();
                } catch (Throwable th) {
                    CrashShieldHandler.handleThrowable(th, cls);
                }
            }
        }
    }

    /* renamed from: onSuccess$lambda-4  reason: not valid java name */
    public static final void m151onSuccess$lambda4(boolean z) {
        if (z) {
            InAppPurchaseManager inAppPurchaseManager = InAppPurchaseManager.INSTANCE;
            Class<InAppPurchaseManager> cls = InAppPurchaseManager.class;
            if (!CrashShieldHandler.isObjectCrashing(cls)) {
                try {
                    InAppPurchaseManager.enabled.set(true);
                    InAppPurchaseManager.startTracking();
                } catch (Throwable th) {
                    CrashShieldHandler.handleThrowable(th, cls);
                }
            }
        }
    }

    /* renamed from: onSuccess$lambda-5  reason: not valid java name */
    public static final void m152onSuccess$lambda5(boolean z) {
        if (z) {
            try {
                $$Lambda$m16G8HSqbE1bMmir1EfQXv1qNY r7 = $$Lambda$m16G8HSqbE1bMmir1EfQXv1qNY.INSTANCE;
                FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
                GraphRequest graphRequest = new GraphRequest(null, Intrinsics.stringPlus(FacebookSdk.getApplicationId(), "/cloudbridge_settings"), null, HttpMethod.GET, r7, null, 32);
                Logger.Companion.log(LoggingBehavior.APP_EVENTS, (String) "com.facebook.appevents.cloudbridge.AppEventsCAPIManager", (String) " \n\nCreating Graph Request: \n=============\n%s\n\n ", graphRequest);
                graphRequest.executeAsync();
            } catch (JSONException e2) {
                Logger.Companion.log(LoggingBehavior.APP_EVENTS, (String) "com.facebook.appevents.cloudbridge.AppEventsCAPIManager", (String) " \n\nGraph Request Exception: \n=============\n%s\n\n ", TweetUtils.stackTraceToString(e2));
            }
        }
    }

    public void onError() {
    }

    public void onSuccess(FetchedAppSettings fetchedAppSettings) {
        FeatureManager featureManager = FeatureManager.INSTANCE;
        FeatureManager.checkFeature(Feature.AAM, $$Lambda$4nn3_uw4ywWJWXJ_cgelB6dzU3M.INSTANCE);
        FeatureManager featureManager2 = FeatureManager.INSTANCE;
        FeatureManager.checkFeature(Feature.RestrictiveDataFiltering, $$Lambda$BPR80qquJ5Ti2m1zBPILQqqnmws.INSTANCE);
        FeatureManager featureManager3 = FeatureManager.INSTANCE;
        FeatureManager.checkFeature(Feature.PrivacyProtection, $$Lambda$2TzN31hkw99zRJLMhQ9xbXcKt28.INSTANCE);
        FeatureManager featureManager4 = FeatureManager.INSTANCE;
        FeatureManager.checkFeature(Feature.EventDeactivation, $$Lambda$rqxljRI9tf8q5UZP6iCZY7dBIY.INSTANCE);
        FeatureManager featureManager5 = FeatureManager.INSTANCE;
        FeatureManager.checkFeature(Feature.IapLogging, $$Lambda$t3xA2PHvArcTfJcS085meRN4OWg.INSTANCE);
        FeatureManager featureManager6 = FeatureManager.INSTANCE;
        FeatureManager.checkFeature(Feature.CloudBridge, $$Lambda$WTzROiUaEiYR8NY0YJVVwfJWuqg.INSTANCE);
    }
}
