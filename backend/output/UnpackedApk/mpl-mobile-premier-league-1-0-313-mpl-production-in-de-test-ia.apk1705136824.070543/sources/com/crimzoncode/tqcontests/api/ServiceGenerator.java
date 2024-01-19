package com.crimzoncode.tqcontests.api;

import com.crimzoncode.tqcontests.util.TQConstants;
import com.google.gson.GsonBuilder;
import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import okhttp3.logging.HttpLoggingInterceptor.Level;
import retrofit2.Retrofit.Builder;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceGenerator {
    public static GsonConverterFactory buildGsonConverter() {
        return GsonConverterFactory.create(new GsonBuilder().setDateFormat((String) TQConstants.SERVER_DATE_FORMAT).create());
    }

    public static <S> S createService(Class<S> cls, String str, String str2, Level level) {
        Builder builder = new Builder();
        builder.baseUrl(str);
        builder.addConverterFactory(buildGsonConverter());
        builder.client(getOkHttpClient(level, str2));
        return builder.build().create(cls);
    }

    public static OkHttpClient getOkHttpClient(Level level, String str) {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.connectTimeout(45, TimeUnit.SECONDS);
        builder.readTimeout(45, TimeUnit.SECONDS);
        builder.writeTimeout(45, TimeUnit.SECONDS);
        builder.addInterceptor(new TestInterceptor(str));
        if (level != null) {
            builder.addInterceptor(new HttpLoggingInterceptor().setLevel(level));
        }
        return builder.build();
    }
}
