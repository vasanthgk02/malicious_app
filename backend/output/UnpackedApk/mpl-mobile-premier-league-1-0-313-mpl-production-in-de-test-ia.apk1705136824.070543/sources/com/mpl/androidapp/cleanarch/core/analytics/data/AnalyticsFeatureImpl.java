package com.mpl.androidapp.cleanarch.core.analytics.data;

import com.mpl.androidapp.analytics.ExternalAnalytics;
import com.mpl.androidapp.cleanarch.core.analytics.domain.AnalyticsFeature;
import com.mpl.androidapp.cleanarch.core.logger.domain.LoggerFeature;
import com.mpl.androidapp.utils.CleverTapAnalyticsUtils;
import com.razorpay.AnalyticsConstants;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J4\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\"\u0010\u000b\u001a\u001e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\r0\fj\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\r`\u000eH\u0016J4\u0010\u000f\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\"\u0010\u000b\u001a\u001e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\r0\fj\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\r`\u000eH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/mpl/androidapp/cleanarch/core/analytics/data/AnalyticsFeatureImpl;", "Lcom/mpl/androidapp/cleanarch/core/analytics/domain/AnalyticsFeature;", "logger", "Lcom/mpl/androidapp/cleanarch/core/logger/domain/LoggerFeature;", "(Lcom/mpl/androidapp/cleanarch/core/logger/domain/LoggerFeature;)V", "getLogger", "()Lcom/mpl/androidapp/cleanarch/core/logger/domain/LoggerFeature;", "send", "", "eventName", "", "properties", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "sendOnlyToKafka", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AnalyticsFeatureImpl.kt */
public final class AnalyticsFeatureImpl implements AnalyticsFeature {
    public final LoggerFeature logger;

    public AnalyticsFeatureImpl(LoggerFeature loggerFeature) {
        Intrinsics.checkNotNullParameter(loggerFeature, "logger");
        this.logger = loggerFeature;
    }

    public final LoggerFeature getLogger() {
        return this.logger;
    }

    public void send(String str, HashMap<String, Object> hashMap) {
        Intrinsics.checkNotNullParameter(str, "eventName");
        Intrinsics.checkNotNullParameter(hashMap, AnalyticsConstants.PROPERTIES);
        this.logger.i("EVENT-NAME-CT", str);
        this.logger.i("EVENT-PROPERTIES-CT", hashMap.toString());
        CleverTapAnalyticsUtils.sendEvent(str, hashMap);
    }

    public void sendOnlyToKafka(String str, HashMap<String, Object> hashMap) {
        Intrinsics.checkNotNullParameter(str, "eventName");
        Intrinsics.checkNotNullParameter(hashMap, AnalyticsConstants.PROPERTIES);
        this.logger.i("EVENT-NAME-KAFKA", str);
        this.logger.i("EVENT-PROPERTIES-KAFKA", hashMap.toString());
        ExternalAnalytics.INSTANCE.sendKafkaEvent(str, hashMap);
    }
}
