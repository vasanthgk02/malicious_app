package com.mpl.androidapp.updater.downloadmanager.usecases;

import dagger.internal.Factory;
import javax.inject.Provider;
import kotlinx.coroutines.CoroutineDispatcher;

public final class UpdateAssetsAnalyticsUseCase_Factory implements Factory<UpdateAssetsAnalyticsUseCase> {
    public final Provider<CoroutineDispatcher> dispatcherProvider;

    public UpdateAssetsAnalyticsUseCase_Factory(Provider<CoroutineDispatcher> provider) {
        this.dispatcherProvider = provider;
    }

    public static UpdateAssetsAnalyticsUseCase_Factory create(Provider<CoroutineDispatcher> provider) {
        return new UpdateAssetsAnalyticsUseCase_Factory(provider);
    }

    public static UpdateAssetsAnalyticsUseCase newInstance(CoroutineDispatcher coroutineDispatcher) {
        return new UpdateAssetsAnalyticsUseCase(coroutineDispatcher);
    }

    public UpdateAssetsAnalyticsUseCase get() {
        return newInstance((CoroutineDispatcher) this.dispatcherProvider.get());
    }
}
