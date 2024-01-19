package com.mpl.androidapp.share.services;

import android.content.Context;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class GenerateDeepLinkService_Factory implements Factory<GenerateDeepLinkService> {
    public final Provider<Context> contextProvider;

    public GenerateDeepLinkService_Factory(Provider<Context> provider) {
        this.contextProvider = provider;
    }

    public static GenerateDeepLinkService_Factory create(Provider<Context> provider) {
        return new GenerateDeepLinkService_Factory(provider);
    }

    public static GenerateDeepLinkService newInstance(Context context) {
        return new GenerateDeepLinkService(context);
    }

    public GenerateDeepLinkService get() {
        return newInstance((Context) this.contextProvider.get());
    }
}
