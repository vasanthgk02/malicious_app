package com.mpl.androidapp.unity.usecases;

import android.content.Context;
import dagger.internal.Factory;
import javax.inject.Provider;
import kotlinx.coroutines.CoroutineDispatcher;

public final class SendEventForGamesUseCase_Factory implements Factory<SendEventForGamesUseCase> {
    public final Provider<Context> contextProvider;
    public final Provider<CoroutineDispatcher> dispatcherProvider;

    public SendEventForGamesUseCase_Factory(Provider<Context> provider, Provider<CoroutineDispatcher> provider2) {
        this.contextProvider = provider;
        this.dispatcherProvider = provider2;
    }

    public static SendEventForGamesUseCase_Factory create(Provider<Context> provider, Provider<CoroutineDispatcher> provider2) {
        return new SendEventForGamesUseCase_Factory(provider, provider2);
    }

    public static SendEventForGamesUseCase newInstance(Context context, CoroutineDispatcher coroutineDispatcher) {
        return new SendEventForGamesUseCase(context, coroutineDispatcher);
    }

    public SendEventForGamesUseCase get() {
        return newInstance((Context) this.contextProvider.get(), (CoroutineDispatcher) this.dispatcherProvider.get());
    }
}
