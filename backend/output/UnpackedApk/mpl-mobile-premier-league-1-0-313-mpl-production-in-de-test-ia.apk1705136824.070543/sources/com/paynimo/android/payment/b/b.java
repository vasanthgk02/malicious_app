package com.paynimo.android.payment.b;

import java.util.Objects;
import java.util.concurrent.TimeUnit;
import okhttp3.Interceptor;
import okhttp3.Interceptor.Chain;
import okhttp3.OkHttpClient.Builder;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import okhttp3.logging.HttpLoggingInterceptor.Level;
import retrofit2.Converter.Factory;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public abstract class b {

    public class a implements Interceptor {
        public a(b bVar) {
        }

        public Response intercept(Chain chain) {
            return chain.proceed(chain.request().newBuilder().addHeader("Accept-Encoding", "gzip").build());
        }
    }

    public c getAPIServiceInterface() {
        Builder builder = new Builder();
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(Level.NONE);
        builder.addInterceptor(httpLoggingInterceptor);
        builder.addNetworkInterceptor(new a(this));
        builder.readTimeout(30, TimeUnit.SECONDS);
        Retrofit.Builder builder2 = new Retrofit.Builder();
        builder2.baseUrl("https://www.paynimo.com");
        builder2.converterFactories.add((Factory) Objects.requireNonNull(GsonConverterFactory.create(), "factory == null"));
        builder2.client(builder.build());
        return (c) builder2.build().create(c.class);
    }
}
