package com.mpl.androidapp.updater.downloadmanager.usecases;

import android.content.Context;
import dagger.internal.Factory;
import javax.inject.Provider;
import kotlinx.coroutines.CoroutineDispatcher;

public final class PublishProgressUseCase_Factory implements Factory<PublishProgressUseCase> {
    public final Provider<Context> contextProvider;
    public final Provider<CoroutineDispatcher> dispatcherProvider;

    public PublishProgressUseCase_Factory(Provider<Context> provider, Provider<CoroutineDispatcher> provider2) {
        this.contextProvider = provider;
        this.dispatcherProvider = provider2;
    }

    public static PublishProgressUseCase_Factory create(Provider<Context> provider, Provider<CoroutineDispatcher> provider2) {
        return new PublishProgressUseCase_Factory(provider, provider2);
    }

    public static PublishProgressUseCase newInstance(Context context, CoroutineDispatcher coroutineDispatcher) {
        return new PublishProgressUseCase(context, coroutineDispatcher);
    }

    public PublishProgressUseCase get() {
        return newInstance((Context) this.contextProvider.get(), (CoroutineDispatcher) this.dispatcherProvider.get());
    }
}
