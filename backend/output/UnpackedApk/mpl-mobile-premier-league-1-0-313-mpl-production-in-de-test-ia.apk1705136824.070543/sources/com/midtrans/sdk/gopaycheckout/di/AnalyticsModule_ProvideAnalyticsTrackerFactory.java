package com.midtrans.sdk.gopaycheckout.di;

import android.content.Context;
import com.midtrans.sdk.gopaycheckout.analytics.AnalyticsTracker;
import com.twitter.sdk.android.tweetui.TweetUtils;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class AnalyticsModule_ProvideAnalyticsTrackerFactory implements Factory<AnalyticsTracker> {
    public final Provider<Context> contextProvider;
    public final Provider<Boolean> loggingEnabledProvider;
    public final AnalyticsModule module;

    public AnalyticsModule_ProvideAnalyticsTrackerFactory(AnalyticsModule analyticsModule, Provider<Context> provider, Provider<Boolean> provider2) {
        this.module = analyticsModule;
        this.contextProvider = provider;
        this.loggingEnabledProvider = provider2;
    }

    public static AnalyticsModule_ProvideAnalyticsTrackerFactory create(AnalyticsModule analyticsModule, Provider<Context> provider, Provider<Boolean> provider2) {
        return new AnalyticsModule_ProvideAnalyticsTrackerFactory(analyticsModule, provider, provider2);
    }

    public static AnalyticsTracker provideInstance(AnalyticsModule analyticsModule, Provider<Context> provider, Provider<Boolean> provider2) {
        return proxyProvideAnalyticsTracker(analyticsModule, (Context) provider.get(), ((Boolean) provider2.get()).booleanValue());
    }

    public static AnalyticsTracker proxyProvideAnalyticsTracker(AnalyticsModule analyticsModule, Context context, boolean z) {
        AnalyticsTracker provideAnalyticsTracker = analyticsModule.provideAnalyticsTracker(context, z);
        TweetUtils.checkNotNull1(provideAnalyticsTracker, "Cannot return null from a non-@Nullable @Provides method");
        return provideAnalyticsTracker;
    }

    public AnalyticsTracker get() {
        return provideInstance(this.module, this.contextProvider, this.loggingEnabledProvider);
    }
}
