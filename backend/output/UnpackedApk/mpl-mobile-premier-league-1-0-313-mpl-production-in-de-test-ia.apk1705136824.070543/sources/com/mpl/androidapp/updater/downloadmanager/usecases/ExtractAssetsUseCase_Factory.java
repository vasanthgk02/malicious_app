package com.mpl.androidapp.updater.downloadmanager.usecases;

import android.content.Context;
import dagger.internal.Factory;
import javax.inject.Provider;
import kotlinx.coroutines.CoroutineDispatcher;

public final class ExtractAssetsUseCase_Factory implements Factory<ExtractAssetsUseCase> {
    public final Provider<Context> contextProvider;
    public final Provider<CoroutineDispatcher> dispatcherProvider;

    public ExtractAssetsUseCase_Factory(Provider<Context> provider, Provider<CoroutineDispatcher> provider2) {
        this.contextProvider = provider;
        this.dispatcherProvider = provider2;
    }

    public static ExtractAssetsUseCase_Factory create(Provider<Context> provider, Provider<CoroutineDispatcher> provider2) {
        return new ExtractAssetsUseCase_Factory(provider, provider2);
    }

    public static ExtractAssetsUseCase newInstance(Context context, CoroutineDispatcher coroutineDispatcher) {
        return new ExtractAssetsUseCase(context, coroutineDispatcher);
    }

    public ExtractAssetsUseCase get() {
        return newInstance((Context) this.contextProvider.get(), (CoroutineDispatcher) this.dispatcherProvider.get());
    }
}
