package com.facebook.internal.instrument;

import android.content.SharedPreferences.Editor;
import com.facebook.FacebookSdk;
import com.facebook.GraphResponse;
import com.facebook.internal.FeatureManager;
import com.facebook.internal.FeatureManager.Feature;
import com.google.firebase.crashlytics.internal.settings.SettingsJsonConstants;
import com.paynimo.android.payment.util.Constant;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map.Entry;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt__CharKt;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u00020\u0006H\u0007J\u0012\u0010\u0007\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0007J\r\u0010\n\u001a\u00020\u0004H\u0001¢\u0006\u0002\b\u000bJ\r\u0010\f\u001a\u00020\u0006H\u0001¢\u0006\u0002\b\rR\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/facebook/internal/instrument/ExceptionAnalyzer;", "", "()V", "enabled", "", "enable", "", "execute", "e", "", "isDebug", "isDebug$facebook_core_release", "sendExceptionAnalysisReports", "sendExceptionAnalysisReports$facebook_core_release", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: ExceptionAnalyzer.kt */
public final class ExceptionAnalyzer {
    public static boolean enabled;

    public static final void execute(Throwable th) {
        Feature feature;
        if (enabled && th != null) {
            HashSet hashSet = new HashSet();
            StackTraceElement[] stackTrace = th.getStackTrace();
            Intrinsics.checkNotNullExpressionValue(stackTrace, "e.stackTrace");
            for (StackTraceElement className : stackTrace) {
                FeatureManager featureManager = FeatureManager.INSTANCE;
                String className2 = className.getClassName();
                Intrinsics.checkNotNullExpressionValue(className2, "it.className");
                Intrinsics.checkNotNullParameter(className2, "className");
                synchronized (FeatureManager.INSTANCE) {
                    if (FeatureManager.featureMapping.isEmpty()) {
                        FeatureManager.featureMapping.put(Feature.AAM, new String[]{"com.facebook.appevents.aam."});
                        FeatureManager.featureMapping.put(Feature.CodelessEvents, new String[]{"com.facebook.appevents.codeless."});
                        FeatureManager.featureMapping.put(Feature.CloudBridge, new String[]{"com.facebook.appevents.cloudbridge."});
                        FeatureManager.featureMapping.put(Feature.ErrorReport, new String[]{"com.facebook.internal.instrument.errorreport."});
                        FeatureManager.featureMapping.put(Feature.AnrReport, new String[]{"com.facebook.internal.instrument.anrreport."});
                        FeatureManager.featureMapping.put(Feature.PrivacyProtection, new String[]{"com.facebook.appevents.ml."});
                        FeatureManager.featureMapping.put(Feature.SuggestedEvents, new String[]{"com.facebook.appevents.suggestedevents."});
                        FeatureManager.featureMapping.put(Feature.RestrictiveDataFiltering, new String[]{"com.facebook.appevents.restrictivedatafilter.RestrictiveDataManager"});
                        FeatureManager.featureMapping.put(Feature.IntelligentIntegrity, new String[]{"com.facebook.appevents.integrity.IntegrityManager"});
                        FeatureManager.featureMapping.put(Feature.EventDeactivation, new String[]{"com.facebook.appevents.eventdeactivation."});
                        FeatureManager.featureMapping.put(Feature.OnDeviceEventProcessing, new String[]{"com.facebook.appevents.ondeviceprocessing."});
                        FeatureManager.featureMapping.put(Feature.IapLogging, new String[]{"com.facebook.appevents.iap."});
                        FeatureManager.featureMapping.put(Feature.Monitoring, new String[]{"com.facebook.internal.logging.monitor"});
                    }
                }
                Iterator<Entry<Feature, String[]>> it = FeatureManager.featureMapping.entrySet().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        feature = Feature.Unknown;
                        break;
                    }
                    Entry next = it.next();
                    feature = (Feature) next.getKey();
                    String[] strArr = (String[]) next.getValue();
                    int length = strArr.length;
                    int i = 0;
                    while (true) {
                        if (i < length) {
                            String str = strArr[i];
                            i++;
                            if (CharsKt__CharKt.startsWith$default(className2, str, false, 2)) {
                                break;
                            }
                        }
                    }
                }
                if (feature != Feature.Unknown) {
                    FeatureManager featureManager2 = FeatureManager.INSTANCE;
                    Intrinsics.checkNotNullParameter(feature, "feature");
                    FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
                    Editor edit = FacebookSdk.getApplicationContext().getSharedPreferences("com.facebook.internal.FEATURE_MANAGER", 0).edit();
                    String key = feature.toKey();
                    FacebookSdk facebookSdk2 = FacebookSdk.INSTANCE;
                    edit.putString(key, "16.0.1").apply();
                    hashSet.add(feature.toString());
                }
            }
            FacebookSdk facebookSdk3 = FacebookSdk.INSTANCE;
            if (FacebookSdk.getAutoLogAppEventsEnabled() && (!hashSet.isEmpty())) {
                JSONArray jSONArray = new JSONArray(hashSet);
                Intrinsics.checkNotNullParameter(jSONArray, SettingsJsonConstants.FEATURES_KEY);
                new InstrumentData(jSONArray, (DefaultConstructorMarker) null).save();
            }
        }
    }

    /* renamed from: sendExceptionAnalysisReports$lambda-1  reason: not valid java name */
    public static final void m212sendExceptionAnalysisReports$lambda1(InstrumentData instrumentData, GraphResponse graphResponse) {
        Boolean bool;
        Intrinsics.checkNotNullParameter(instrumentData, "$instrumentData");
        Intrinsics.checkNotNullParameter(graphResponse, Constant.TAG_RESPONSE);
        try {
            if (graphResponse.error == null) {
                JSONObject jSONObject = graphResponse.jsonObject;
                if (jSONObject == null) {
                    bool = null;
                } else {
                    bool = Boolean.valueOf(jSONObject.getBoolean("success"));
                }
                if (Intrinsics.areEqual(bool, Boolean.TRUE)) {
                    InstrumentUtility.deleteFile(instrumentData.filename);
                }
            }
        } catch (JSONException unused) {
        }
    }
}
