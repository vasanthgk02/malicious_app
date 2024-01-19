package com.mpl.androidapp.updater.downloadmanager.usecases;

import dagger.internal.Factory;
import javax.inject.Provider;
import kotlinx.coroutines.CoroutineDispatcher;

public final class OptionalDownloadNotificationFlowCheckUseCase_Factory implements Factory<OptionalDownloadNotificationFlowCheckUseCase> {
    public final Provider<CoroutineDispatcher> dispatcherProvider;

    public OptionalDownloadNotificationFlowCheckUseCase_Factory(Provider<CoroutineDispatcher> provider) {
        this.dispatcherProvider = provider;
    }

    public static OptionalDownloadNotificationFlowCheckUseCase_Factory create(Provider<CoroutineDispatcher> provider) {
        return new OptionalDownloadNotificationFlowCheckUseCase_Factory(provider);
    }

    public static OptionalDownloadNotificationFlowCheckUseCase newInstance(CoroutineDispatcher coroutineDispatcher) {
        return new OptionalDownloadNotificationFlowCheckUseCase(coroutineDispatcher);
    }

    public OptionalDownloadNotificationFlowCheckUseCase get() {
        return newInstance((CoroutineDispatcher) this.dispatcherProvider.get());
    }
}
