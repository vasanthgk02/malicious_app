package com.mpl.androidapp.webview.usecases;

import android.content.Context;
import dagger.internal.Factory;
import javax.inject.Provider;
import kotlinx.coroutines.CoroutineDispatcher;

public final class PrepUrlForWebViewLoadingUseCase_Factory implements Factory<PrepUrlForWebViewLoadingUseCase> {
    public final Provider<Context> contextProvider;
    public final Provider<CoroutineDispatcher> dispatcherProvider;

    public PrepUrlForWebViewLoadingUseCase_Factory(Provider<Context> provider, Provider<CoroutineDispatcher> provider2) {
        this.contextProvider = provider;
        this.dispatcherProvider = provider2;
    }

    public static PrepUrlForWebViewLoadingUseCase_Factory create(Provider<Context> provider, Provider<CoroutineDispatcher> provider2) {
        return new PrepUrlForWebViewLoadingUseCase_Factory(provider, provider2);
    }

    public static PrepUrlForWebViewLoadingUseCase newInstance(Context context, CoroutineDispatcher coroutineDispatcher) {
        return new PrepUrlForWebViewLoadingUseCase(context, coroutineDispatcher);
    }

    public PrepUrlForWebViewLoadingUseCase get() {
        return newInstance((Context) this.contextProvider.get(), (CoroutineDispatcher) this.dispatcherProvider.get());
    }
}
