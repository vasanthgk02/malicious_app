package com.mpl.androidapp.notification.usecases;

import android.content.Context;
import dagger.internal.Factory;
import javax.inject.Provider;
import kotlinx.coroutines.CoroutineDispatcher;

public final class BuildLaunchIntentUseCase_Factory implements Factory<BuildLaunchIntentUseCase> {
    public final Provider<Context> contextProvider;
    public final Provider<CoroutineDispatcher> dispatcherProvider;

    public BuildLaunchIntentUseCase_Factory(Provider<Context> provider, Provider<CoroutineDispatcher> provider2) {
        this.contextProvider = provider;
        this.dispatcherProvider = provider2;
    }

    public static BuildLaunchIntentUseCase_Factory create(Provider<Context> provider, Provider<CoroutineDispatcher> provider2) {
        return new BuildLaunchIntentUseCase_Factory(provider, provider2);
    }

    public static BuildLaunchIntentUseCase newInstance(Context context, CoroutineDispatcher coroutineDispatcher) {
        return new BuildLaunchIntentUseCase(context, coroutineDispatcher);
    }

    public BuildLaunchIntentUseCase get() {
        return newInstance((Context) this.contextProvider.get(), (CoroutineDispatcher) this.dispatcherProvider.get());
    }
}
