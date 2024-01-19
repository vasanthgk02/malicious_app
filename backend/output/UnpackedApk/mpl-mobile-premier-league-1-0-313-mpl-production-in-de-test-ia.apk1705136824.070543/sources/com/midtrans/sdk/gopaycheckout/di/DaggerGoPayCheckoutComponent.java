package com.midtrans.sdk.gopaycheckout.di;

import android.content.Context;
import com.midtrans.sdk.gopaycheckout.analytics.AnalyticsTracker;
import com.midtrans.sdk.gopaycheckout.core.GoPayCheckoutClient;
import com.midtrans.sdk.gopaycheckout.core.GoPayCheckoutClient_MembersInjector;
import com.midtrans.sdk.gopaycheckout.core.server.GoPayCheckoutApi;
import com.midtrans.sdk.gopaycheckout.core.server.GoPayCheckoutHttpApi;
import com.midtrans.sdk.gopaycheckout.core.utils.ErrorResponseUtils;
import com.squareup.moshi.Moshi;
import com.twitter.sdk.android.tweetui.TweetUtils;
import dagger.internal.DoubleCheck;
import dagger.internal.InstanceFactory;
import javax.inject.Provider;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

public final class DaggerGoPayCheckoutComponent implements GoPayCheckoutComponent {
    public AnalyticsModule analyticsModule;
    public Provider<Moshi> provideMoshiProvider;
    public Provider<OkHttpClient> provideOkHttpClientProvider;
    public Provider<Retrofit> provideRetrofitProvider;
    public ServiceModule serviceModule;
    public Context setApplicationContext;
    public Boolean setEnableLogging;
    public Provider<Boolean> setEnableLoggingProvider;
    public Provider<String> setMerchantUrlProvider;
    public UtilsModule utilsModule;

    public static final class Builder implements com.midtrans.sdk.gopaycheckout.di.GoPayCheckoutComponent.Builder {
        public AnalyticsModule analyticsModule;
        public ServiceModule serviceModule;
        public Context setApplicationContext;
        public Boolean setEnableLogging;
        public String setMerchantUrl;
        public UtilsModule utilsModule;

        public Builder() {
        }

        public GoPayCheckoutComponent build() {
            if (this.serviceModule == null) {
                this.serviceModule = new ServiceModule();
            }
            if (this.analyticsModule == null) {
                this.analyticsModule = new AnalyticsModule();
            }
            if (this.utilsModule == null) {
                this.utilsModule = new UtilsModule();
            }
            if (this.setApplicationContext == null) {
                throw new IllegalStateException(Context.class.getCanonicalName() + " must be set");
            } else if (this.setEnableLogging == null) {
                throw new IllegalStateException(Boolean.class.getCanonicalName() + " must be set");
            } else if (this.setMerchantUrl != null) {
                return new DaggerGoPayCheckoutComponent(this);
            } else {
                throw new IllegalStateException(String.class.getCanonicalName() + " must be set");
            }
        }

        public Builder setApplicationContext(Context context) {
            if (context != null) {
                this.setApplicationContext = context;
                return this;
            }
            throw null;
        }

        public Builder setEnableLogging(boolean z) {
            Boolean valueOf = Boolean.valueOf(z);
            TweetUtils.checkNotNull1(valueOf);
            this.setEnableLogging = valueOf;
            return this;
        }

        public Builder setMerchantUrl(String str) {
            if (str != null) {
                this.setMerchantUrl = str;
                return this;
            }
            throw null;
        }
    }

    public DaggerGoPayCheckoutComponent(Builder builder) {
        initialize(builder);
    }

    public static com.midtrans.sdk.gopaycheckout.di.GoPayCheckoutComponent.Builder builder() {
        return new Builder();
    }

    private AnalyticsTracker getAnalyticsTracker() {
        return AnalyticsModule_ProvideAnalyticsTrackerFactory.proxyProvideAnalyticsTracker(this.analyticsModule, this.setApplicationContext, this.setEnableLogging.booleanValue());
    }

    private ErrorResponseUtils getErrorResponseUtils() {
        return UtilsModule_ProvideErrorResponseUtilsFactory.proxyProvideErrorResponseUtils(this.utilsModule, (Moshi) this.provideMoshiProvider.get());
    }

    private GoPayCheckoutApi getGoPayCheckoutApi() {
        return ServiceModule_ProvideGoPayCheckoutApiFactory.proxyProvideGoPayCheckoutApi(this.serviceModule, (Retrofit) this.provideRetrofitProvider.get());
    }

    private GoPayCheckoutHttpApi getGoPayCheckoutHttpApi() {
        return ServiceModule_ProvideGoPayCheckoutHttpApiFactory.proxyProvideGoPayCheckoutHttpApi(this.serviceModule, getGoPayCheckoutApi());
    }

    private void initialize(Builder builder) {
        this.serviceModule = builder.serviceModule;
        this.setMerchantUrlProvider = InstanceFactory.create(builder.setMerchantUrl);
        this.setEnableLoggingProvider = InstanceFactory.create(builder.setEnableLogging);
        this.provideOkHttpClientProvider = DoubleCheck.provider(ServiceModule_ProvideOkHttpClientFactory.create(builder.serviceModule, this.setEnableLoggingProvider));
        this.provideMoshiProvider = DoubleCheck.provider(ServiceModule_ProvideMoshiFactory.create(builder.serviceModule));
        this.provideRetrofitProvider = DoubleCheck.provider(ServiceModule_ProvideRetrofitFactory.create(builder.serviceModule, this.setMerchantUrlProvider, this.provideOkHttpClientProvider, this.provideMoshiProvider));
        this.analyticsModule = builder.analyticsModule;
        this.setApplicationContext = builder.setApplicationContext;
        this.setEnableLogging = builder.setEnableLogging;
        this.utilsModule = builder.utilsModule;
    }

    private GoPayCheckoutClient injectGoPayCheckoutClient(GoPayCheckoutClient goPayCheckoutClient) {
        GoPayCheckoutClient_MembersInjector.injectGoPayCheckoutHttpApi(goPayCheckoutClient, getGoPayCheckoutHttpApi());
        GoPayCheckoutClient_MembersInjector.injectAnalyticsTracker(goPayCheckoutClient, getAnalyticsTracker());
        GoPayCheckoutClient_MembersInjector.injectErrorResponseUtils(goPayCheckoutClient, getErrorResponseUtils());
        return goPayCheckoutClient;
    }

    public void inject(GoPayCheckoutClient goPayCheckoutClient) {
        injectGoPayCheckoutClient(goPayCheckoutClient);
    }
}
