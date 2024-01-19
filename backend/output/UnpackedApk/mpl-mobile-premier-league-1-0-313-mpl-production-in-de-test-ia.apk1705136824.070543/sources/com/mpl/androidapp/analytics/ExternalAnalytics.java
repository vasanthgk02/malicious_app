package com.mpl.androidapp.analytics;

import android.text.TextUtils;
import com.mpl.androidapp.config.ConfigManager;
import com.mpl.androidapp.utils.CountryUtils;
import com.mpl.androidapp.utils.GameConstant;
import com.mpl.androidapp.utils.KafkaUtils;
import com.mpl.androidapp.utils.MLogger;
import com.mpl.androidapp.utils.Util;
import com.razorpay.AnalyticsConstants;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J2\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00042\"\u0010\b\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\tj\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0001`\nR\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/mpl/androidapp/analytics/ExternalAnalytics;", "", "()V", "tag", "", "sendKafkaEvent", "", "eventName", "properties", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ExternalAnalytics.kt */
public final class ExternalAnalytics {
    public static final ExternalAnalytics INSTANCE;
    public static final String tag;

    static {
        ExternalAnalytics externalAnalytics = new ExternalAnalytics();
        INSTANCE = externalAnalytics;
        String simpleName = externalAnalytics.getClass().getSimpleName();
        Intrinsics.checkNotNullExpressionValue(simpleName, "this.javaClass.simpleName");
        tag = simpleName;
    }

    public final void sendKafkaEvent(String str, HashMap<String, Object> hashMap) {
        Intrinsics.checkNotNullParameter(str, "eventName");
        Intrinsics.checkNotNullParameter(hashMap, AnalyticsConstants.PROPERTIES);
        try {
            if (KafkaUtils.getAnalyticsHelper() != null) {
                boolean z = (ConfigManager.getKafkaConfig() != null && ConfigManager.getKafkaConfig().optBoolean("enabledv1", false)) || (hashMap.containsKey(GameConstant.IS_KAFKA_ENABLED) && hashMap.get(GameConstant.IS_KAFKA_ENABLED) != null && Boolean.parseBoolean(String.valueOf(hashMap.get(GameConstant.IS_KAFKA_ENABLED))));
                MLogger.d(tag, "addKafkaEvent: ", str, Boolean.valueOf(z), new JSONObject(hashMap));
                if (z) {
                    if (!TextUtils.isEmpty(CountryUtils.getCountryCodeForUnity())) {
                        String countryCodeForUnity = CountryUtils.getCountryCodeForUnity();
                        Intrinsics.checkNotNullExpressionValue(countryCodeForUnity, "getCountryCodeForUnity()");
                        hashMap.put("Country Code", countryCodeForUnity);
                    }
                    KafkaUtils.getAnalyticsHelper().addEvent(str, hashMap, String.valueOf(TimeUnit.MILLISECONDS.toSeconds(Util.getCurrentTime().getTime())));
                }
            }
        } catch (Exception e2) {
            MLogger.e(tag, "addKafkaEvent: ", e2);
        }
    }
}
