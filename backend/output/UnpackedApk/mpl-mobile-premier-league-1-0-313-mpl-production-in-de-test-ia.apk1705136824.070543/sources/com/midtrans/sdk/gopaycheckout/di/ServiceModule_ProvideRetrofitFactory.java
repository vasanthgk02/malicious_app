package com.midtrans.sdk.gopaycheckout.di;

import com.squareup.moshi.Moshi;
import com.twitter.sdk.android.tweetui.TweetUtils;
import dagger.internal.Factory;
import javax.inject.Provider;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

public final class ServiceModule_ProvideRetrofitFactory implements Factory<Retrofit> {
    public final ServiceModule module;
    public final Provider<Moshi> moshiProvider;
    public final Provider<OkHttpClient> okHttpClientProvider;
    public final Provider<String> urlProvider;

    public ServiceModule_ProvideRetrofitFactory(ServiceModule serviceModule, Provider<String> provider, Provider<OkHttpClient> provider2, Provider<Moshi> provider3) {
        this.module = serviceModule;
        this.urlProvider = provider;
        this.okHttpClientProvider = provider2;
        this.moshiProvider = provider3;
    }

    public static ServiceModule_ProvideRetrofitFactory create(ServiceModule serviceModule, Provider<String> provider, Provider<OkHttpClient> provider2, Provider<Moshi> provider3) {
        return new ServiceModule_ProvideRetrofitFactory(serviceModule, provider, provider2, provider3);
    }

    public static Retrofit provideInstance(ServiceModule serviceModule, Provider<String> provider, Provider<OkHttpClient> provider2, Provider<Moshi> provider3) {
        return proxyProvideRetrofit(serviceModule, (String) provider.get(), (OkHttpClient) provider2.get(), (Moshi) provider3.get());
    }

    public static Retrofit proxyProvideRetrofit(ServiceModule serviceModule, String str, OkHttpClient okHttpClient, Moshi moshi) {
        Retrofit provideRetrofit = serviceModule.provideRetrofit(str, okHttpClient, moshi);
        TweetUtils.checkNotNull1(provideRetrofit, "Cannot return null from a non-@Nullable @Provides method");
        return provideRetrofit;
    }

    public Retrofit get() {
        return provideInstance(this.module, this.urlProvider, this.okHttpClientProvider, this.moshiProvider);
    }
}
