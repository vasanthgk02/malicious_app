package com.mpl.androidapp.cleanarch.core.config.domain;

import com.mpl.androidapp.cleanarch.core.config.domain.usecases.GetBooleanZkUseCase;
import com.mpl.androidapp.cleanarch.core.config.domain.usecases.GetJsonObjectZkUseCase;
import com.mpl.androidapp.cleanarch.core.config.domain.usecases.GetStringZkUseCase;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class ConfigZkFeatures_Factory implements Factory<ConfigZkFeatures> {
    public final Provider<GetBooleanZkUseCase> getBooleanZkUseCaseProvider;
    public final Provider<GetJsonObjectZkUseCase> getJsonObjectZkUseCaseProvider;
    public final Provider<GetStringZkUseCase> getStringZkUseCaseProvider;

    public ConfigZkFeatures_Factory(Provider<GetBooleanZkUseCase> provider, Provider<GetStringZkUseCase> provider2, Provider<GetJsonObjectZkUseCase> provider3) {
        this.getBooleanZkUseCaseProvider = provider;
        this.getStringZkUseCaseProvider = provider2;
        this.getJsonObjectZkUseCaseProvider = provider3;
    }

    public static ConfigZkFeatures_Factory create(Provider<GetBooleanZkUseCase> provider, Provider<GetStringZkUseCase> provider2, Provider<GetJsonObjectZkUseCase> provider3) {
        return new ConfigZkFeatures_Factory(provider, provider2, provider3);
    }

    public static ConfigZkFeatures newInstance(GetBooleanZkUseCase getBooleanZkUseCase, GetStringZkUseCase getStringZkUseCase, GetJsonObjectZkUseCase getJsonObjectZkUseCase) {
        return new ConfigZkFeatures(getBooleanZkUseCase, getStringZkUseCase, getJsonObjectZkUseCase);
    }

    public ConfigZkFeatures get() {
        return newInstance((GetBooleanZkUseCase) this.getBooleanZkUseCaseProvider.get(), (GetStringZkUseCase) this.getStringZkUseCaseProvider.get(), (GetJsonObjectZkUseCase) this.getJsonObjectZkUseCaseProvider.get());
    }
}
