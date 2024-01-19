package com.midtrans.sdk.gopaycheckout.di;

import com.midtrans.sdk.gopaycheckout.core.server.GoPayCheckoutApi;
import com.midtrans.sdk.gopaycheckout.core.server.GoPayCheckoutHttpApi;
import com.twitter.sdk.android.tweetui.TweetUtils;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class ServiceModule_ProvideGoPayCheckoutHttpApiFactory implements Factory<GoPayCheckoutHttpApi> {
    public final Provider<GoPayCheckoutApi> goPayCheckoutApiProvider;
    public final ServiceModule module;

    public ServiceModule_ProvideGoPayCheckoutHttpApiFactory(ServiceModule serviceModule, Provider<GoPayCheckoutApi> provider) {
        this.module = serviceModule;
        this.goPayCheckoutApiProvider = provider;
    }

    public static ServiceModule_ProvideGoPayCheckoutHttpApiFactory create(ServiceModule serviceModule, Provider<GoPayCheckoutApi> provider) {
        return new ServiceModule_ProvideGoPayCheckoutHttpApiFactory(serviceModule, provider);
    }

    public static GoPayCheckoutHttpApi provideInstance(ServiceModule serviceModule, Provider<GoPayCheckoutApi> provider) {
        return proxyProvideGoPayCheckoutHttpApi(serviceModule, (GoPayCheckoutApi) provider.get());
    }

    public static GoPayCheckoutHttpApi proxyProvideGoPayCheckoutHttpApi(ServiceModule serviceModule, GoPayCheckoutApi goPayCheckoutApi) {
        GoPayCheckoutHttpApi provideGoPayCheckoutHttpApi = serviceModule.provideGoPayCheckoutHttpApi(goPayCheckoutApi);
        TweetUtils.checkNotNull1(provideGoPayCheckoutHttpApi, "Cannot return null from a non-@Nullable @Provides method");
        return provideGoPayCheckoutHttpApi;
    }

    public GoPayCheckoutHttpApi get() {
        return provideInstance(this.module, this.goPayCheckoutApiProvider);
    }
}
