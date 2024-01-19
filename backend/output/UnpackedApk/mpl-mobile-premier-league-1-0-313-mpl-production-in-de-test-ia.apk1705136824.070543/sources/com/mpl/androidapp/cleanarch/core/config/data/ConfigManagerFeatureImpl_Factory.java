package com.mpl.androidapp.cleanarch.core.config.data;

import com.mpl.androidapp.cleanarch.core.logger.domain.LoggerFeature;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class ConfigManagerFeatureImpl_Factory implements Factory<ConfigManagerFeatureImpl> {
    public final Provider<LoggerFeature> loggerProvider;

    public ConfigManagerFeatureImpl_Factory(Provider<LoggerFeature> provider) {
        this.loggerProvider = provider;
    }

    public static ConfigManagerFeatureImpl_Factory create(Provider<LoggerFeature> provider) {
        return new ConfigManagerFeatureImpl_Factory(provider);
    }

    public static ConfigManagerFeatureImpl newInstance(LoggerFeature loggerFeature) {
        return new ConfigManagerFeatureImpl(loggerFeature);
    }

    public ConfigManagerFeatureImpl get() {
        return newInstance((LoggerFeature) this.loggerProvider.get());
    }
}
