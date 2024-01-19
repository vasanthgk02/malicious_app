package com.midtrans.sdk.gopaycheckout.di;

import com.midtrans.sdk.gopaycheckout.core.server.GoPayCheckoutApi;
import com.twitter.sdk.android.tweetui.TweetUtils;
import dagger.internal.Factory;
import javax.inject.Provider;
import retrofit2.Retrofit;

public final class ServiceModule_ProvideGoPayCheckoutApiFactory implements Factory<GoPayCheckoutApi> {
    public final ServiceModule module;
    public final Provider<Retrofit> retrofitProvider;

    public ServiceModule_ProvideGoPayCheckoutApiFactory(ServiceModule serviceModule, Provider<Retrofit> provider) {
        this.module = serviceModule;
        this.retrofitProvider = provider;
    }

    public static ServiceModule_ProvideGoPayCheckoutApiFactory create(ServiceModule serviceModule, Provider<Retrofit> provider) {
        return new ServiceModule_ProvideGoPayCheckoutApiFactory(serviceModule, provider);
    }

    public static GoPayCheckoutApi provideInstance(ServiceModule serviceModule, Provider<Retrofit> provider) {
        return proxyProvideGoPayCheckoutApi(serviceModule, (Retrofit) provider.get());
    }

    public static GoPayCheckoutApi proxyProvideGoPayCheckoutApi(ServiceModule serviceModule, Retrofit retrofit) {
        GoPayCheckoutApi provideGoPayCheckoutApi = serviceModule.provideGoPayCheckoutApi(retrofit);
        TweetUtils.checkNotNull1(provideGoPayCheckoutApi, "Cannot return null from a non-@Nullable @Provides method");
        return provideGoPayCheckoutApi;
    }

    public GoPayCheckoutApi get() {
        return provideInstance(this.module, this.retrofitProvider);
    }
}
