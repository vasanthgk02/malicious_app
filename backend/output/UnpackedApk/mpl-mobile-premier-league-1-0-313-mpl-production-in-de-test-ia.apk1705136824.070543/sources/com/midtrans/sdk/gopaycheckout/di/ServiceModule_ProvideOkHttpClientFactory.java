package com.midtrans.sdk.gopaycheckout.di;

import com.twitter.sdk.android.tweetui.TweetUtils;
import dagger.internal.Factory;
import javax.inject.Provider;
import okhttp3.OkHttpClient;

public final class ServiceModule_ProvideOkHttpClientFactory implements Factory<OkHttpClient> {
    public final Provider<Boolean> loggingEnabledProvider;
    public final ServiceModule module;

    public ServiceModule_ProvideOkHttpClientFactory(ServiceModule serviceModule, Provider<Boolean> provider) {
        this.module = serviceModule;
        this.loggingEnabledProvider = provider;
    }

    public static ServiceModule_ProvideOkHttpClientFactory create(ServiceModule serviceModule, Provider<Boolean> provider) {
        return new ServiceModule_ProvideOkHttpClientFactory(serviceModule, provider);
    }

    public static OkHttpClient provideInstance(ServiceModule serviceModule, Provider<Boolean> provider) {
        return proxyProvideOkHttpClient(serviceModule, ((Boolean) provider.get()).booleanValue());
    }

    public static OkHttpClient proxyProvideOkHttpClient(ServiceModule serviceModule, boolean z) {
        OkHttpClient provideOkHttpClient = serviceModule.provideOkHttpClient(z);
        TweetUtils.checkNotNull1(provideOkHttpClient, "Cannot return null from a non-@Nullable @Provides method");
        return provideOkHttpClient;
    }

    public OkHttpClient get() {
        return provideInstance(this.module, this.loggingEnabledProvider);
    }
}
