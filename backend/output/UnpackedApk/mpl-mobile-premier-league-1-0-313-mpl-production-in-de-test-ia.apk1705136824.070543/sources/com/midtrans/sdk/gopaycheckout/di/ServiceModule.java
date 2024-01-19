package com.midtrans.sdk.gopaycheckout.di;

import com.midtrans.sdk.gopaycheckout.core.server.GoPayCheckoutApi;
import com.midtrans.sdk.gopaycheckout.core.server.GoPayCheckoutHttpApi;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.Moshi.Builder;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt__CharKt;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import okhttp3.logging.HttpLoggingInterceptor.Level;
import retrofit2.Converter.Factory;
import retrofit2.Retrofit;
import retrofit2.converter.moshi.MoshiConverterFactory;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0001\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004H\u0007J\b\u0010\n\u001a\u00020\u000bH\u0007J\u0012\u0010\f\u001a\u00020\r2\b\b\u0001\u0010\u000e\u001a\u00020\u000fH\u0007J\"\u0010\u0010\u001a\u00020\u00062\b\b\u0001\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u000bH\u0007J\u0010\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u0012H\u0002¨\u0006\u0016"}, d2 = {"Lcom/midtrans/sdk/gopaycheckout/di/ServiceModule;", "", "()V", "provideGoPayCheckoutApi", "Lcom/midtrans/sdk/gopaycheckout/core/server/GoPayCheckoutApi;", "retrofit", "Lretrofit2/Retrofit;", "provideGoPayCheckoutHttpApi", "Lcom/midtrans/sdk/gopaycheckout/core/server/GoPayCheckoutHttpApi;", "goPayCheckoutApi", "provideMoshi", "Lcom/squareup/moshi/Moshi;", "provideOkHttpClient", "Lokhttp3/OkHttpClient;", "loggingEnabled", "", "provideRetrofit", "url", "", "okHttpClient", "moshi", "validateUrl", "gopay-checkout_release"}, k = 1, mv = {1, 1, 16})
public final class ServiceModule {
    private final String validateUrl(String str) {
        if (CharsKt__CharKt.endsWith$default(str, (String) "/", false, 2)) {
            return str;
        }
        return str + '/';
    }

    public final GoPayCheckoutApi provideGoPayCheckoutApi(Retrofit retrofit) {
        Intrinsics.checkParameterIsNotNull(retrofit, "retrofit");
        Object create = retrofit.create(GoPayCheckoutApi.class);
        Intrinsics.checkExpressionValueIsNotNull(create, "retrofit.create(GoPayCheckoutApi::class.java)");
        return (GoPayCheckoutApi) create;
    }

    public final GoPayCheckoutHttpApi provideGoPayCheckoutHttpApi(GoPayCheckoutApi goPayCheckoutApi) {
        Intrinsics.checkParameterIsNotNull(goPayCheckoutApi, "goPayCheckoutApi");
        return new GoPayCheckoutHttpApi(goPayCheckoutApi);
    }

    public final Moshi provideMoshi() {
        Moshi build = new Builder().build();
        Intrinsics.checkExpressionValueIsNotNull(build, "Moshi\n            .Builder()\n            .build()");
        return build;
    }

    public final OkHttpClient provideOkHttpClient(boolean z) {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor(null, 1, null);
        httpLoggingInterceptor.setLevel(z ? Level.BODY : Level.NONE);
        return builder.addInterceptor(httpLoggingInterceptor).build();
    }

    public final Retrofit provideRetrofit(String str, OkHttpClient okHttpClient, Moshi moshi) {
        Intrinsics.checkParameterIsNotNull(str, "url");
        Intrinsics.checkParameterIsNotNull(okHttpClient, "okHttpClient");
        Intrinsics.checkParameterIsNotNull(moshi, "moshi");
        Retrofit.Builder builder = new Retrofit.Builder();
        builder.baseUrl(validateUrl(str));
        builder.client(okHttpClient);
        builder.converterFactories.add((Factory) Objects.requireNonNull(new MoshiConverterFactory(moshi, true, false, false), "factory == null"));
        Retrofit build = builder.build();
        Intrinsics.checkExpressionValueIsNotNull(build, "Retrofit\n            .Bu…t())\n            .build()");
        return build;
    }
}
