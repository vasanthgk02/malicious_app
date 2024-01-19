package com.mpl.androidapp.notification.usecases;

import android.content.Context;
import dagger.internal.Factory;
import javax.inject.Provider;
import kotlinx.coroutines.CoroutineDispatcher;

public final class BuildMplNotificationUseCase_Factory implements Factory<BuildMplNotificationUseCase> {
    public final Provider<Context> contextProvider;
    public final Provider<CoroutineDispatcher> dispatcherProvider;

    public BuildMplNotificationUseCase_Factory(Provider<Context> provider, Provider<CoroutineDispatcher> provider2) {
        this.contextProvider = provider;
        this.dispatcherProvider = provider2;
    }

    public static BuildMplNotificationUseCase_Factory create(Provider<Context> provider, Provider<CoroutineDispatcher> provider2) {
        return new BuildMplNotificationUseCase_Factory(provider, provider2);
    }

    public static BuildMplNotificationUseCase newInstance(Context context, CoroutineDispatcher coroutineDispatcher) {
        return new BuildMplNotificationUseCase(context, coroutineDispatcher);
    }

    public BuildMplNotificationUseCase get() {
        return newInstance((Context) this.contextProvider.get(), (CoroutineDispatcher) this.dispatcherProvider.get());
    }
}
