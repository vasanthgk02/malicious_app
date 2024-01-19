package com.mpl.androidapp.notification.usecases;

import android.content.Context;
import dagger.internal.Factory;
import javax.inject.Provider;
import kotlinx.coroutines.CoroutineDispatcher;

public final class IsAppIsInBackgroundUseCase_Factory implements Factory<IsAppIsInBackgroundUseCase> {
    public final Provider<Context> contextProvider;
    public final Provider<CoroutineDispatcher> dispatcherProvider;

    public IsAppIsInBackgroundUseCase_Factory(Provider<Context> provider, Provider<CoroutineDispatcher> provider2) {
        this.contextProvider = provider;
        this.dispatcherProvider = provider2;
    }

    public static IsAppIsInBackgroundUseCase_Factory create(Provider<Context> provider, Provider<CoroutineDispatcher> provider2) {
        return new IsAppIsInBackgroundUseCase_Factory(provider, provider2);
    }

    public static IsAppIsInBackgroundUseCase newInstance(Context context, CoroutineDispatcher coroutineDispatcher) {
        return new IsAppIsInBackgroundUseCase(context, coroutineDispatcher);
    }

    public IsAppIsInBackgroundUseCase get() {
        return newInstance((Context) this.contextProvider.get(), (CoroutineDispatcher) this.dispatcherProvider.get());
    }
}
