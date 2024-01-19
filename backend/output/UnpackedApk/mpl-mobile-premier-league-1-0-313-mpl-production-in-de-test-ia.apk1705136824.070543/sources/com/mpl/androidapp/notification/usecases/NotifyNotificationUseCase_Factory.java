package com.mpl.androidapp.notification.usecases;

import android.content.Context;
import dagger.internal.Factory;
import javax.inject.Provider;
import kotlinx.coroutines.CoroutineDispatcher;

public final class NotifyNotificationUseCase_Factory implements Factory<NotifyNotificationUseCase> {
    public final Provider<Context> contextProvider;
    public final Provider<CoroutineDispatcher> dispatcherProvider;

    public NotifyNotificationUseCase_Factory(Provider<Context> provider, Provider<CoroutineDispatcher> provider2) {
        this.contextProvider = provider;
        this.dispatcherProvider = provider2;
    }

    public static NotifyNotificationUseCase_Factory create(Provider<Context> provider, Provider<CoroutineDispatcher> provider2) {
        return new NotifyNotificationUseCase_Factory(provider, provider2);
    }

    public static NotifyNotificationUseCase newInstance(Context context, CoroutineDispatcher coroutineDispatcher) {
        return new NotifyNotificationUseCase(context, coroutineDispatcher);
    }

    public NotifyNotificationUseCase get() {
        return newInstance((Context) this.contextProvider.get(), (CoroutineDispatcher) this.dispatcherProvider.get());
    }
}
