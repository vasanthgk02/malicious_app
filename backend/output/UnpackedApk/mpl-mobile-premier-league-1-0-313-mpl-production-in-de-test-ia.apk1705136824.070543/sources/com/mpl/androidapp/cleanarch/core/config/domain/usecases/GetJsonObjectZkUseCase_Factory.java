package com.mpl.androidapp.cleanarch.core.config.domain.usecases;

import com.mpl.androidapp.cleanarch.core.config.domain.ConfigManagerFeature;
import com.mpl.androidapp.cleanarch.core.logger.domain.LoggerFeature;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class GetJsonObjectZkUseCase_Factory implements Factory<GetJsonObjectZkUseCase> {
    public final Provider<ConfigManagerFeature> configManagerProvider;
    public final Provider<LoggerFeature> loggerProvider;

    public GetJsonObjectZkUseCase_Factory(Provider<ConfigManagerFeature> provider, Provider<LoggerFeature> provider2) {
        this.configManagerProvider = provider;
        this.loggerProvider = provider2;
    }

    public static GetJsonObjectZkUseCase_Factory create(Provider<ConfigManagerFeature> provider, Provider<LoggerFeature> provider2) {
        return new GetJsonObjectZkUseCase_Factory(provider, provider2);
    }

    public static GetJsonObjectZkUseCase newInstance(ConfigManagerFeature configManagerFeature, LoggerFeature loggerFeature) {
        return new GetJsonObjectZkUseCase(configManagerFeature, loggerFeature);
    }

    public GetJsonObjectZkUseCase get() {
        return newInstance((ConfigManagerFeature) this.configManagerProvider.get(), (LoggerFeature) this.loggerProvider.get());
    }
}
