package com.midtrans.sdk.gopaycheckout.di;

import android.content.Context;
import com.midtrans.sdk.gopaycheckout.BuildConfig;
import com.midtrans.sdk.gopaycheckout.analytics.AnalyticsTracker;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\bH\u0007¨\u0006\t"}, d2 = {"Lcom/midtrans/sdk/gopaycheckout/di/AnalyticsModule;", "", "()V", "provideAnalyticsTracker", "Lcom/midtrans/sdk/gopaycheckout/analytics/AnalyticsTracker;", "context", "Landroid/content/Context;", "loggingEnabled", "", "gopay-checkout_release"}, k = 1, mv = {1, 1, 16})
public final class AnalyticsModule {
    public final AnalyticsTracker provideAnalyticsTracker(Context context, boolean z) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        return new AnalyticsTracker(context, BuildConfig.CLEVERTAP_APP_ID, BuildConfig.CLEVERTAP_APP_TOKEN, z);
    }
}
