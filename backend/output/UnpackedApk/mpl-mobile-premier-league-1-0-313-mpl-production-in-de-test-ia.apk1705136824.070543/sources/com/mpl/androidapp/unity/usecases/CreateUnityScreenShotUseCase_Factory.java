package com.mpl.androidapp.unity.usecases;

import android.content.Context;
import dagger.internal.Factory;
import javax.inject.Provider;
import kotlinx.coroutines.CoroutineDispatcher;

public final class CreateUnityScreenShotUseCase_Factory implements Factory<CreateUnityScreenShotUseCase> {
    public final Provider<Context> contextProvider;
    public final Provider<CoroutineDispatcher> dispatcherProvider;

    public CreateUnityScreenShotUseCase_Factory(Provider<Context> provider, Provider<CoroutineDispatcher> provider2) {
        this.contextProvider = provider;
        this.dispatcherProvider = provider2;
    }

    public static CreateUnityScreenShotUseCase_Factory create(Provider<Context> provider, Provider<CoroutineDispatcher> provider2) {
        return new CreateUnityScreenShotUseCase_Factory(provider, provider2);
    }

    public static CreateUnityScreenShotUseCase newInstance(Context context, CoroutineDispatcher coroutineDispatcher) {
        return new CreateUnityScreenShotUseCase(context, coroutineDispatcher);
    }

    public CreateUnityScreenShotUseCase get() {
        return newInstance((Context) this.contextProvider.get(), (CoroutineDispatcher) this.dispatcherProvider.get());
    }
}
