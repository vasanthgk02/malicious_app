package com.mpl.androidapp.share.usecases;

import android.content.Context;
import dagger.internal.Factory;
import javax.inject.Provider;
import kotlinx.coroutines.CoroutineDispatcher;

public final class PrepareShareIntent_Factory implements Factory<PrepareShareIntent> {
    public final Provider<Context> contextProvider;
    public final Provider<CoroutineDispatcher> dispatcherProvider;

    public PrepareShareIntent_Factory(Provider<Context> provider, Provider<CoroutineDispatcher> provider2) {
        this.contextProvider = provider;
        this.dispatcherProvider = provider2;
    }

    public static PrepareShareIntent_Factory create(Provider<Context> provider, Provider<CoroutineDispatcher> provider2) {
        return new PrepareShareIntent_Factory(provider, provider2);
    }

    public static PrepareShareIntent newInstance(Context context, CoroutineDispatcher coroutineDispatcher) {
        return new PrepareShareIntent(context, coroutineDispatcher);
    }

    public PrepareShareIntent get() {
        return newInstance((Context) this.contextProvider.get(), (CoroutineDispatcher) this.dispatcherProvider.get());
    }
}
