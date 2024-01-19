package com.midtrans.sdk.gopaycheckout.di;

import com.squareup.moshi.Moshi;
import com.twitter.sdk.android.tweetui.TweetUtils;
import dagger.internal.Factory;

public final class ServiceModule_ProvideMoshiFactory implements Factory<Moshi> {
    public final ServiceModule module;

    public ServiceModule_ProvideMoshiFactory(ServiceModule serviceModule) {
        this.module = serviceModule;
    }

    public static ServiceModule_ProvideMoshiFactory create(ServiceModule serviceModule) {
        return new ServiceModule_ProvideMoshiFactory(serviceModule);
    }

    public static Moshi provideInstance(ServiceModule serviceModule) {
        return proxyProvideMoshi(serviceModule);
    }

    public static Moshi proxyProvideMoshi(ServiceModule serviceModule) {
        Moshi provideMoshi = serviceModule.provideMoshi();
        TweetUtils.checkNotNull1(provideMoshi, "Cannot return null from a non-@Nullable @Provides method");
        return provideMoshi;
    }

    public Moshi get() {
        return provideInstance(this.module);
    }
}
