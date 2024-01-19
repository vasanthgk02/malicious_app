package com.mpl.androidapp.cleanarch.core.analytics.domain;

import java.util.HashMap;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J4\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\"\u0010\u0006\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u0007j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0001`\bH&J4\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\"\u0010\u0006\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u0007j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0001`\bH&¨\u0006\n"}, d2 = {"Lcom/mpl/androidapp/cleanarch/core/analytics/domain/AnalyticsFeature;", "", "send", "", "eventName", "", "properties", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "sendOnlyToKafka", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AnalyticsFeature.kt */
public interface AnalyticsFeature {
    void send(String str, HashMap<String, Object> hashMap);

    void sendOnlyToKafka(String str, HashMap<String, Object> hashMap);
}
