package com.midtrans.sdk.gopaycheckout.analytics;

import android.content.Context;
import com.clevertap.android.sdk.CleverTapAPI;
import com.clevertap.android.sdk.CleverTapAPI.LogLevel;
import com.clevertap.android.sdk.CleverTapInstanceConfig;
import com.razorpay.AnalyticsConstants;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0005\b\u0000\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\"\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00052\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0012J$\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u00052\u0014\b\u0002\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u0012R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/midtrans/sdk/gopaycheckout/analytics/AnalyticsTracker;", "", "context", "Landroid/content/Context;", "accountId", "", "accountToken", "debuggable", "", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Z)V", "cleverTapApi", "Lcom/clevertap/android/sdk/CleverTapAPI;", "cleverTapInstanceConfig", "Lcom/clevertap/android/sdk/CleverTapInstanceConfig;", "setIdentity", "", "id", "extras", "", "trackEvent", "eventName", "properties", "Companion", "gopay-checkout_release"}, k = 1, mv = {1, 1, 16})
public final class AnalyticsTracker {
    public static final Companion Companion = new Companion(null);
    public static final String IDENTITY = "Identity";
    public final CleverTapAPI cleverTapApi;
    public final CleverTapInstanceConfig cleverTapInstanceConfig;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/midtrans/sdk/gopaycheckout/analytics/AnalyticsTracker$Companion;", "", "()V", "IDENTITY", "", "gopay-checkout_release"}, k = 1, mv = {1, 1, 16})
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public AnalyticsTracker(Context context, String str, String str2, boolean z) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(str, "accountId");
        Intrinsics.checkParameterIsNotNull(str2, "accountToken");
        CleverTapInstanceConfig cleverTapInstanceConfig2 = new CleverTapInstanceConfig(context, str, str2, null, false);
        LogLevel logLevel = z ? LogLevel.DEBUG : LogLevel.OFF;
        if (cleverTapInstanceConfig2 != null) {
            cleverTapInstanceConfig2.debugLevel = logLevel.intValue();
            cleverTapInstanceConfig2.analyticsOnly = true;
            Intrinsics.checkExpressionValueIsNotNull(cleverTapInstanceConfig2, "CleverTapInstanceConfig\n…ticsOnly = true\n        }");
            this.cleverTapInstanceConfig = cleverTapInstanceConfig2;
            CleverTapAPI instanceWithConfig = CleverTapAPI.instanceWithConfig(context, cleverTapInstanceConfig2);
            Intrinsics.checkExpressionValueIsNotNull(instanceWithConfig, "CleverTapAPI\n        .in…pInstanceConfig\n        )");
            this.cleverTapApi = instanceWithConfig;
            return;
        }
        throw null;
    }

    public /* synthetic */ AnalyticsTracker(Context context, String str, String str2, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, str, str2, (i & 8) != 0 ? false : z);
    }

    public static /* synthetic */ void trackEvent$default(AnalyticsTracker analyticsTracker, String str, Map map, int i, Object obj) {
        if ((i & 2) != 0) {
            map = ArraysKt___ArraysJvmKt.emptyMap();
        }
        analyticsTracker.trackEvent(str, map);
    }

    public final void setIdentity(String str, Map<String, String> map) {
        Intrinsics.checkParameterIsNotNull(str, "id");
        Intrinsics.checkParameterIsNotNull(map, "extras");
        CleverTapAPI cleverTapAPI = this.cleverTapApi;
        Map<String, String> mutableMap = ArraysKt___ArraysJvmKt.toMutableMap(map);
        ((HashMap) mutableMap).put("Identity", str);
        cleverTapAPI.coreState.analyticsManager.pushProfile(ArraysKt___ArraysJvmKt.toMap(mutableMap));
    }

    public final void trackEvent(String str, Map<String, ? extends Object> map) {
        Intrinsics.checkParameterIsNotNull(str, "eventName");
        Intrinsics.checkParameterIsNotNull(map, AnalyticsConstants.PROPERTIES);
        this.cleverTapApi.pushEvent(str, map);
    }
}
