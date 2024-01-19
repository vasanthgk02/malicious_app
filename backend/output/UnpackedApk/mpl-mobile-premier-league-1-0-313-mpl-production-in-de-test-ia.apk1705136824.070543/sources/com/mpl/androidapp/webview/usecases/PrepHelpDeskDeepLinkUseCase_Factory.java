package com.mpl.androidapp.webview.usecases;

import android.content.Context;
import dagger.internal.Factory;
import javax.inject.Provider;
import kotlinx.coroutines.CoroutineDispatcher;

public final class PrepHelpDeskDeepLinkUseCase_Factory implements Factory<PrepHelpDeskDeepLinkUseCase> {
    public final Provider<Context> contextProvider;
    public final Provider<CoroutineDispatcher> dispatcherProvider;

    public PrepHelpDeskDeepLinkUseCase_Factory(Provider<Context> provider, Provider<CoroutineDispatcher> provider2) {
        this.contextProvider = provider;
        this.dispatcherProvider = provider2;
    }

    public static PrepHelpDeskDeepLinkUseCase_Factory create(Provider<Context> provider, Provider<CoroutineDispatcher> provider2) {
        return new PrepHelpDeskDeepLinkUseCase_Factory(provider, provider2);
    }

    public static PrepHelpDeskDeepLinkUseCase newInstance(Context context, CoroutineDispatcher coroutineDispatcher) {
        return new PrepHelpDeskDeepLinkUseCase(context, coroutineDispatcher);
    }

    public PrepHelpDeskDeepLinkUseCase get() {
        return newInstance((Context) this.contextProvider.get(), (CoroutineDispatcher) this.dispatcherProvider.get());
    }
}
