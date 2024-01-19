package com.mpl.androidapp.webview.usecases;

import android.content.Context;
import dagger.internal.Factory;
import javax.inject.Provider;
import kotlinx.coroutines.CoroutineDispatcher;

public final class PrepPaymentPageDeepLinkUseCase_Factory implements Factory<PrepPaymentPageDeepLinkUseCase> {
    public final Provider<Context> contextProvider;
    public final Provider<CoroutineDispatcher> dispatcherProvider;

    public PrepPaymentPageDeepLinkUseCase_Factory(Provider<Context> provider, Provider<CoroutineDispatcher> provider2) {
        this.contextProvider = provider;
        this.dispatcherProvider = provider2;
    }

    public static PrepPaymentPageDeepLinkUseCase_Factory create(Provider<Context> provider, Provider<CoroutineDispatcher> provider2) {
        return new PrepPaymentPageDeepLinkUseCase_Factory(provider, provider2);
    }

    public static PrepPaymentPageDeepLinkUseCase newInstance(Context context, CoroutineDispatcher coroutineDispatcher) {
        return new PrepPaymentPageDeepLinkUseCase(context, coroutineDispatcher);
    }

    public PrepPaymentPageDeepLinkUseCase get() {
        return newInstance((Context) this.contextProvider.get(), (CoroutineDispatcher) this.dispatcherProvider.get());
    }
}
