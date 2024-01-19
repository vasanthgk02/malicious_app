package com.midtrans.sdk.gopaycheckout.di;

import com.midtrans.sdk.gopaycheckout.core.utils.ErrorResponseUtils;
import com.squareup.moshi.Moshi;
import com.twitter.sdk.android.tweetui.TweetUtils;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class UtilsModule_ProvideErrorResponseUtilsFactory implements Factory<ErrorResponseUtils> {
    public final UtilsModule module;
    public final Provider<Moshi> moshiProvider;

    public UtilsModule_ProvideErrorResponseUtilsFactory(UtilsModule utilsModule, Provider<Moshi> provider) {
        this.module = utilsModule;
        this.moshiProvider = provider;
    }

    public static UtilsModule_ProvideErrorResponseUtilsFactory create(UtilsModule utilsModule, Provider<Moshi> provider) {
        return new UtilsModule_ProvideErrorResponseUtilsFactory(utilsModule, provider);
    }

    public static ErrorResponseUtils provideInstance(UtilsModule utilsModule, Provider<Moshi> provider) {
        return proxyProvideErrorResponseUtils(utilsModule, (Moshi) provider.get());
    }

    public static ErrorResponseUtils proxyProvideErrorResponseUtils(UtilsModule utilsModule, Moshi moshi) {
        ErrorResponseUtils provideErrorResponseUtils = utilsModule.provideErrorResponseUtils(moshi);
        TweetUtils.checkNotNull1(provideErrorResponseUtils, "Cannot return null from a non-@Nullable @Provides method");
        return provideErrorResponseUtils;
    }

    public ErrorResponseUtils get() {
        return provideInstance(this.module, this.moshiProvider);
    }
}
