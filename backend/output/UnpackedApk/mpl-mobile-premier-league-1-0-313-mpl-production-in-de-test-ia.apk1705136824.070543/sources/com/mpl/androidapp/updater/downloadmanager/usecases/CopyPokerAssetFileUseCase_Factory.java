package com.mpl.androidapp.updater.downloadmanager.usecases;

import android.content.Context;
import dagger.internal.Factory;
import javax.inject.Provider;
import kotlinx.coroutines.CoroutineDispatcher;

public final class CopyPokerAssetFileUseCase_Factory implements Factory<CopyPokerAssetFileUseCase> {
    public final Provider<Context> contextProvider;
    public final Provider<CoroutineDispatcher> dispatcherProvider;

    public CopyPokerAssetFileUseCase_Factory(Provider<Context> provider, Provider<CoroutineDispatcher> provider2) {
        this.contextProvider = provider;
        this.dispatcherProvider = provider2;
    }

    public static CopyPokerAssetFileUseCase_Factory create(Provider<Context> provider, Provider<CoroutineDispatcher> provider2) {
        return new CopyPokerAssetFileUseCase_Factory(provider, provider2);
    }

    public static CopyPokerAssetFileUseCase newInstance(Context context, CoroutineDispatcher coroutineDispatcher) {
        return new CopyPokerAssetFileUseCase(context, coroutineDispatcher);
    }

    public CopyPokerAssetFileUseCase get() {
        return newInstance((Context) this.contextProvider.get(), (CoroutineDispatcher) this.dispatcherProvider.get());
    }
}
