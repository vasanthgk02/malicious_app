package com.mpl.androidapp.notification.usecases;

import android.content.Context;
import dagger.internal.Factory;
import javax.inject.Provider;
import kotlinx.coroutines.CoroutineDispatcher;

public final class NotificationSendEventUseCase_Factory implements Factory<NotificationSendEventUseCase> {
    public final Provider<Context> contextProvider;
    public final Provider<CoroutineDispatcher> dispatcherProvider;

    public NotificationSendEventUseCase_Factory(Provider<Context> provider, Provider<CoroutineDispatcher> provider2) {
        this.contextProvider = provider;
        this.dispatcherProvider = provider2;
    }

    public static NotificationSendEventUseCase_Factory create(Provider<Context> provider, Provider<CoroutineDispatcher> provider2) {
        return new NotificationSendEventUseCase_Factory(provider, provider2);
    }

    public static NotificationSendEventUseCase newInstance(Context context, CoroutineDispatcher coroutineDispatcher) {
        return new NotificationSendEventUseCase(context, coroutineDispatcher);
    }

    public NotificationSendEventUseCase get() {
        return newInstance((Context) this.contextProvider.get(), (CoroutineDispatcher) this.dispatcherProvider.get());
    }
}
