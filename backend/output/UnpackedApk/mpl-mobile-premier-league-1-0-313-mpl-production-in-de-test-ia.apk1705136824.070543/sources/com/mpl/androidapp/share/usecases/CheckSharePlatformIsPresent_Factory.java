package com.mpl.androidapp.share.usecases;

import android.content.Context;
import dagger.internal.Factory;
import javax.inject.Provider;
import kotlinx.coroutines.CoroutineDispatcher;

public final class CheckSharePlatformIsPresent_Factory implements Factory<CheckSharePlatformIsPresent> {
    public final Provider<Context> contextProvider;
    public final Provider<CoroutineDispatcher> dispatcherProvider;

    public CheckSharePlatformIsPresent_Factory(Provider<Context> provider, Provider<CoroutineDispatcher> provider2) {
        this.contextProvider = provider;
        this.dispatcherProvider = provider2;
    }

    public static CheckSharePlatformIsPresent_Factory create(Provider<Context> provider, Provider<CoroutineDispatcher> provider2) {
        return new CheckSharePlatformIsPresent_Factory(provider, provider2);
    }

    public static CheckSharePlatformIsPresent newInstance(Context context, CoroutineDispatcher coroutineDispatcher) {
        return new CheckSharePlatformIsPresent(context, coroutineDispatcher);
    }

    public CheckSharePlatformIsPresent get() {
        return newInstance((Context) this.contextProvider.get(), (CoroutineDispatcher) this.dispatcherProvider.get());
    }
}
