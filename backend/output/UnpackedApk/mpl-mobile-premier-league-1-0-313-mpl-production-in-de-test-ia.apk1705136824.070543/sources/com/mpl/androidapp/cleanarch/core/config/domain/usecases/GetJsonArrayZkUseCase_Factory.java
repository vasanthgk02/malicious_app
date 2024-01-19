package com.mpl.androidapp.cleanarch.core.config.domain.usecases;

import com.mpl.androidapp.cleanarch.core.config.domain.ConfigManagerFeature;
import com.mpl.androidapp.cleanarch.core.logger.domain.LoggerFeature;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class GetJsonArrayZkUseCase_Factory implements Factory<GetJsonArrayZkUseCase> {
    public final Provider<ConfigManagerFeature> configManagerProvider;
    public final Provider<LoggerFeature> loggerProvider;

    public GetJsonArrayZkUseCase_Factory(Provider<ConfigManagerFeature> provider, Provider<LoggerFeature> provider2) {
        this.configManagerProvider = provider;
        this.loggerProvider = provider2;
    }

    public static GetJsonArrayZkUseCase_Factory create(Provider<ConfigManagerFeature> provider, Provider<LoggerFeature> provider2) {
        return new GetJsonArrayZkUseCase_Factory(provider, provider2);
    }

    public static GetJsonArrayZkUseCase newInstance(ConfigManagerFeature configManagerFeature, LoggerFeature loggerFeature) {
        return new GetJsonArrayZkUseCase(configManagerFeature, loggerFeature);
    }

    public GetJsonArrayZkUseCase get() {
        return newInstance((ConfigManagerFeature) this.configManagerProvider.get(), (LoggerFeature) this.loggerProvider.get());
    }
}
