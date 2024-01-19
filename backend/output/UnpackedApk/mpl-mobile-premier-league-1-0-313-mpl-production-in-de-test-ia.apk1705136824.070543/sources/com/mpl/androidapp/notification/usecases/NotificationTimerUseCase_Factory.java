package com.mpl.androidapp.notification.usecases;

import android.content.Context;
import dagger.internal.Factory;
import javax.inject.Provider;
import kotlinx.coroutines.CoroutineDispatcher;

public final class NotificationTimerUseCase_Factory implements Factory<NotificationTimerUseCase> {
    public final Provider<Context> contextProvider;
    public final Provider<CoroutineDispatcher> dispatcherProvider;

    public NotificationTimerUseCase_Factory(Provider<Context> provider, Provider<CoroutineDispatcher> provider2) {
        this.contextProvider = provider;
        this.dispatcherProvider = provider2;
    }

    public static NotificationTimerUseCase_Factory create(Provider<Context> provider, Provider<CoroutineDispatcher> provider2) {
        return new NotificationTimerUseCase_Factory(provider, provider2);
    }

    public static NotificationTimerUseCase newInstance(Context context, CoroutineDispatcher coroutineDispatcher) {
        return new NotificationTimerUseCase(context, coroutineDispatcher);
    }

    public NotificationTimerUseCase get() {
        return newInstance((Context) this.contextProvider.get(), (CoroutineDispatcher) this.dispatcherProvider.get());
    }
}
