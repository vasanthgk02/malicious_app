package com.mpl.androidapp.filehandling.downloadservice.usecases;

import android.content.Context;
import dagger.internal.Factory;
import javax.inject.Provider;
import kotlinx.coroutines.CoroutineDispatcher;

public final class CheckConnectivityUseCase_Factory implements Factory<CheckConnectivityUseCase> {
    public final Provider<Context> contextProvider;
    public final Provider<CoroutineDispatcher> dispatcherProvider;

    public CheckConnectivityUseCase_Factory(Provider<Context> provider, Provider<CoroutineDispatcher> provider2) {
        this.contextProvider = provider;
        this.dispatcherProvider = provider2;
    }

    public static CheckConnectivityUseCase_Factory create(Provider<Context> provider, Provider<CoroutineDispatcher> provider2) {
        return new CheckConnectivityUseCase_Factory(provider, provider2);
    }

    public static CheckConnectivityUseCase newInstance(Context context, CoroutineDispatcher coroutineDispatcher) {
        return new CheckConnectivityUseCase(context, coroutineDispatcher);
    }

    public CheckConnectivityUseCase get() {
        return newInstance((Context) this.contextProvider.get(), (CoroutineDispatcher) this.dispatcherProvider.get());
    }
}
