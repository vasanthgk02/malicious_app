package com.mpl.androidapp.cleanarch.core.config.domain.usecases;

import com.mpl.androidapp.cleanarch.core.config.domain.ConfigManagerFeature;
import com.mpl.androidapp.cleanarch.core.logger.domain.LoggerFeature;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class GetStringZkUseCase_Factory implements Factory<GetStringZkUseCase> {
    public final Provider<ConfigManagerFeature> configManagerProvider;
    public final Provider<LoggerFeature> loggerProvider;

    public GetStringZkUseCase_Factory(Provider<ConfigManagerFeature> provider, Provider<LoggerFeature> provider2) {
        this.configManagerProvider = provider;
        this.loggerProvider = provider2;
    }

    public static GetStringZkUseCase_Factory create(Provider<ConfigManagerFeature> provider, Provider<LoggerFeature> provider2) {
        return new GetStringZkUseCase_Factory(provider, provider2);
    }

    public static GetStringZkUseCase newInstance(ConfigManagerFeature configManagerFeature, LoggerFeature loggerFeature) {
        return new GetStringZkUseCase(configManagerFeature, loggerFeature);
    }

    public GetStringZkUseCase get() {
        return newInstance((ConfigManagerFeature) this.configManagerProvider.get(), (LoggerFeature) this.loggerProvider.get());
    }
}
