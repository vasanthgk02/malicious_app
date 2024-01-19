package com.twitter.sdk.android.core.internal.oauth;

import android.os.Build;
import android.os.Build.VERSION;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.google.android.material.resources.TextAppearanceConfig;
import com.smartfoxserver.v2.protocol.serialization.DefaultObjectDumpFormatter;
import com.twitter.sdk.android.core.TwitterCore;
import com.twitter.sdk.android.core.internal.TwitterApi;
import java.io.IOException;
import java.text.Normalizer;
import java.text.Normalizer.Form;
import java.util.Objects;
import okhttp3.Interceptor;
import okhttp3.Interceptor.Chain;
import okhttp3.OkHttpClient;
import okhttp3.OkHttpClient.Builder;
import okhttp3.Response;
import retrofit2.Converter.Factory;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public abstract class OAuthService {
    public final TwitterApi api;
    public final Retrofit retrofit;
    public final TwitterCore twitterCore;
    public final String userAgent;

    public OAuthService(TwitterCore twitterCore2, TwitterApi twitterApi) {
        this.twitterCore = twitterCore2;
        this.api = twitterApi;
        if (twitterCore2 != null) {
            StringBuilder sb = new StringBuilder("TwitterAndroidSDK");
            sb.append('/');
            sb.append("3.3.0.12");
            sb.append(' ');
            sb.append(Build.MODEL);
            sb.append('/');
            sb.append(VERSION.RELEASE);
            sb.append(" (");
            sb.append(Build.MANUFACTURER);
            sb.append(DefaultObjectDumpFormatter.TOKEN_DIVIDER);
            sb.append(Build.MODEL);
            sb.append(DefaultObjectDumpFormatter.TOKEN_DIVIDER);
            sb.append(Build.BRAND);
            sb.append(DefaultObjectDumpFormatter.TOKEN_DIVIDER);
            String normalize = Normalizer.normalize(GeneratedOutlineSupport.outline59(sb, Build.PRODUCT, ')'), Form.NFD);
            StringBuilder sb2 = new StringBuilder(normalize.length());
            for (int i = 0; i < normalize.length(); i++) {
                char charAt = normalize.charAt(i);
                if (charAt > 31 && charAt < 127) {
                    sb2.append(charAt);
                }
            }
            this.userAgent = sb2.toString();
            OkHttpClient build = new Builder().addInterceptor(new Interceptor() {
                public final Response intercept(Chain chain) {
                    return OAuthService.this.lambda$new$0$OAuthService(chain);
                }
            }).certificatePinner(TextAppearanceConfig.getCertificatePinner()).build();
            Retrofit.Builder builder = new Retrofit.Builder();
            builder.baseUrl(this.api.baseHostUrl);
            builder.client(build);
            builder.converterFactories.add((Factory) Objects.requireNonNull(GsonConverterFactory.create(), "factory == null"));
            this.retrofit = builder.build();
            return;
        }
        throw null;
    }

    public Response lambda$new$0$OAuthService(Chain chain) throws IOException {
        return chain.proceed(chain.request().newBuilder().header("User-Agent", this.userAgent).build());
    }
}
