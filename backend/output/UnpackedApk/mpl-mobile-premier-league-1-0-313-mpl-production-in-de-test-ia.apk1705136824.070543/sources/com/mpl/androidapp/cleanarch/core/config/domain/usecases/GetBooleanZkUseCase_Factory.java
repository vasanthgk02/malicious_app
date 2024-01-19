package com.mpl.androidapp.cleanarch.core.config.domain.usecases;

import com.mpl.androidapp.cleanarch.core.config.domain.ConfigManagerFeature;
import com.mpl.androidapp.cleanarch.core.logger.domain.LoggerFeature;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class GetBooleanZkUseCase_Factory implements Factory<GetBooleanZkUseCase> {
    public final Provider<ConfigManagerFeature> configManagerProvider;
    public final Provider<LoggerFeature> loggerProvider;

    public GetBooleanZkUseCase_Factory(Provider<ConfigManagerFeature> provider, Provider<LoggerFeature> provider2) {
        this.configManagerProvider = provider;
        this.loggerProvider = provider2;
    }

    public static GetBooleanZkUseCase_Factory create(Provider<ConfigManagerFeature> provider, Provider<LoggerFeature> provider2) {
        return new GetBooleanZkUseCase_Factory(provider, provider2);
    }

    public static GetBooleanZkUseCase newInstance(ConfigManagerFeature configManagerFeature, LoggerFeature loggerFeature) {
        return new GetBooleanZkUseCase(configManagerFeature, loggerFeature);
    }

    public GetBooleanZkUseCase get() {
        return newInstance((ConfigManagerFeature) this.configManagerProvider.get(), (LoggerFeature) this.loggerProvider.get());
    }
}
