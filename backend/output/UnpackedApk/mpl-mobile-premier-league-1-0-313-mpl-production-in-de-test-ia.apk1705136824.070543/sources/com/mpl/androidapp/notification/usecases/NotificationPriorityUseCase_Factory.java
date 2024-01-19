package com.mpl.androidapp.notification.usecases;

import dagger.internal.Factory;
import javax.inject.Provider;
import kotlinx.coroutines.CoroutineDispatcher;

public final class NotificationPriorityUseCase_Factory implements Factory<NotificationPriorityUseCase> {
    public final Provider<CoroutineDispatcher> dispatcherProvider;

    public NotificationPriorityUseCase_Factory(Provider<CoroutineDispatcher> provider) {
        this.dispatcherProvider = provider;
    }

    public static NotificationPriorityUseCase_Factory create(Provider<CoroutineDispatcher> provider) {
        return new NotificationPriorityUseCase_Factory(provider);
    }

    public static NotificationPriorityUseCase newInstance(CoroutineDispatcher coroutineDispatcher) {
        return new NotificationPriorityUseCase(coroutineDispatcher);
    }

    public NotificationPriorityUseCase get() {
        return newInstance((CoroutineDispatcher) this.dispatcherProvider.get());
    }
}
