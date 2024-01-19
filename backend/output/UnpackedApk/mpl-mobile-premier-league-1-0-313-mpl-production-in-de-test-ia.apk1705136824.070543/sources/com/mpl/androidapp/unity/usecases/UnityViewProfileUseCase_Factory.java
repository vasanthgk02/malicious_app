package com.mpl.androidapp.unity.usecases;

import com.google.gson.Gson;
import dagger.internal.Factory;
import javax.inject.Provider;
import kotlinx.coroutines.CoroutineDispatcher;

public final class UnityViewProfileUseCase_Factory implements Factory<UnityViewProfileUseCase> {
    public final Provider<CoroutineDispatcher> dispatcherProvider;
    public final Provider<Gson> gsonProvider;

    public UnityViewProfileUseCase_Factory(Provider<Gson> provider, Provider<CoroutineDispatcher> provider2) {
        this.gsonProvider = provider;
        this.dispatcherProvider = provider2;
    }

    public static UnityViewProfileUseCase_Factory create(Provider<Gson> provider, Provider<CoroutineDispatcher> provider2) {
        return new UnityViewProfileUseCase_Factory(provider, provider2);
    }

    public static UnityViewProfileUseCase newInstance(Gson gson, CoroutineDispatcher coroutineDispatcher) {
        return new UnityViewProfileUseCase(gson, coroutineDispatcher);
    }

    public UnityViewProfileUseCase get() {
        return newInstance((Gson) this.gsonProvider.get(), (CoroutineDispatcher) this.dispatcherProvider.get());
    }
}
