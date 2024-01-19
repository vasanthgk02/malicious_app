package com.mpl.androidapp.notification.usecases;

import dagger.internal.Factory;
import javax.inject.Provider;
import kotlinx.coroutines.CoroutineDispatcher;

public final class NotificationChannelUseCase_Factory implements Factory<NotificationChannelUseCase> {
    public final Provider<CoroutineDispatcher> dispatcherProvider;

    public NotificationChannelUseCase_Factory(Provider<CoroutineDispatcher> provider) {
        this.dispatcherProvider = provider;
    }

    public static NotificationChannelUseCase_Factory create(Provider<CoroutineDispatcher> provider) {
        return new NotificationChannelUseCase_Factory(provider);
    }

    public static NotificationChannelUseCase newInstance(CoroutineDispatcher coroutineDispatcher) {
        return new NotificationChannelUseCase(coroutineDispatcher);
    }

    public NotificationChannelUseCase get() {
        return newInstance((CoroutineDispatcher) this.dispatcherProvider.get());
    }
}
