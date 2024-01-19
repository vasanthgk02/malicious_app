package com.mpl.androidapp.cleanarch.core.analytics.data;

import com.mpl.androidapp.cleanarch.core.logger.domain.LoggerFeature;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class AnalyticsFeatureImpl_Factory implements Factory<AnalyticsFeatureImpl> {
    public final Provider<LoggerFeature> loggerProvider;

    public AnalyticsFeatureImpl_Factory(Provider<LoggerFeature> provider) {
        this.loggerProvider = provider;
    }

    public static AnalyticsFeatureImpl_Factory create(Provider<LoggerFeature> provider) {
        return new AnalyticsFeatureImpl_Factory(provider);
    }

    public static AnalyticsFeatureImpl newInstance(LoggerFeature loggerFeature) {
        return new AnalyticsFeatureImpl(loggerFeature);
    }

    public AnalyticsFeatureImpl get() {
        return newInstance((LoggerFeature) this.loggerProvider.get());
    }
}
