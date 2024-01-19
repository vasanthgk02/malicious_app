package com.midtrans.sdk.gopaycheckout.core;

import com.midtrans.sdk.gopaycheckout.analytics.AnalyticsTracker;
import com.midtrans.sdk.gopaycheckout.core.server.GoPayCheckoutHttpApi;
import com.midtrans.sdk.gopaycheckout.core.utils.ErrorResponseUtils;
import dagger.MembersInjector;
import javax.inject.Provider;

public final class GoPayCheckoutClient_MembersInjector implements MembersInjector<GoPayCheckoutClient> {
    public final Provider<AnalyticsTracker> analyticsTrackerProvider;
    public final Provider<ErrorResponseUtils> errorResponseUtilsProvider;
    public final Provider<GoPayCheckoutHttpApi> goPayCheckoutHttpApiProvider;

    public GoPayCheckoutClient_MembersInjector(Provider<GoPayCheckoutHttpApi> provider, Provider<AnalyticsTracker> provider2, Provider<ErrorResponseUtils> provider3) {
        this.goPayCheckoutHttpApiProvider = provider;
        this.analyticsTrackerProvider = provider2;
        this.errorResponseUtilsProvider = provider3;
    }

    public static MembersInjector<GoPayCheckoutClient> create(Provider<GoPayCheckoutHttpApi> provider, Provider<AnalyticsTracker> provider2, Provider<ErrorResponseUtils> provider3) {
        return new GoPayCheckoutClient_MembersInjector(provider, provider2, provider3);
    }

    public static void injectAnalyticsTracker(GoPayCheckoutClient goPayCheckoutClient, AnalyticsTracker analyticsTracker) {
        goPayCheckoutClient.analyticsTracker = analyticsTracker;
    }

    public static void injectErrorResponseUtils(GoPayCheckoutClient goPayCheckoutClient, ErrorResponseUtils errorResponseUtils) {
        goPayCheckoutClient.errorResponseUtils = errorResponseUtils;
    }

    public static void injectGoPayCheckoutHttpApi(GoPayCheckoutClient goPayCheckoutClient, GoPayCheckoutHttpApi goPayCheckoutHttpApi) {
        goPayCheckoutClient.goPayCheckoutHttpApi = goPayCheckoutHttpApi;
    }

    public void injectMembers(GoPayCheckoutClient goPayCheckoutClient) {
        injectGoPayCheckoutHttpApi(goPayCheckoutClient, (GoPayCheckoutHttpApi) this.goPayCheckoutHttpApiProvider.get());
        injectAnalyticsTracker(goPayCheckoutClient, (AnalyticsTracker) this.analyticsTrackerProvider.get());
        injectErrorResponseUtils(goPayCheckoutClient, (ErrorResponseUtils) this.errorResponseUtilsProvider.get());
    }
}
