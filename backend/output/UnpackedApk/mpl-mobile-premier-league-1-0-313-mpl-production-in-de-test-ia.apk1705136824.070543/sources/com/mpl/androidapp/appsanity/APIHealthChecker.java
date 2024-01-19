package com.mpl.androidapp.appsanity;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J \u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00032\u000e\u0010\t\u001a\n\u0018\u00010\nj\u0004\u0018\u0001`\u000bH&J\u001a\u0010\f\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00032\b\u0010\r\u001a\u0004\u0018\u00010\u0005H&J\u0010\u0010\u000e\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0003H&J\u0010\u0010\u000f\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0003H&¨\u0006\u0010"}, d2 = {"Lcom/mpl/androidapp/appsanity/APIHealthChecker;", "", "initAppSanity", "Lcom/mpl/androidapp/appsanity/APPSanityModel;", "url", "", "processAPIHealthStatusFromFailedResponse", "", "appSanityModel", "ex", "Ljava/lang/Exception;", "Lkotlin/Exception;", "processAPIHealthStatusFromSuccessFullResponse", "response", "setEndAppSanityParams", "setStartAppSanityParams", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: APIHealthChecker.kt */
public interface APIHealthChecker {
    APPSanityModel initAppSanity(String str);

    void processAPIHealthStatusFromFailedResponse(APPSanityModel aPPSanityModel, Exception exc);

    void processAPIHealthStatusFromSuccessFullResponse(APPSanityModel aPPSanityModel, String str);

    void setEndAppSanityParams(APPSanityModel aPPSanityModel);

    void setStartAppSanityParams(APPSanityModel aPPSanityModel);
}
