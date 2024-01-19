package com.clevertap.android.sdk.pushnotification.fcm;

import android.content.Context;
import com.clevertap.android.sdk.CleverTapInstanceConfig;
import com.clevertap.android.sdk.ManifestInfo;
import com.clevertap.android.sdk.pushnotification.CTPushProviderListener;

public class FcmSdkHandlerImpl implements IFcmSdkHandler {
    public final CleverTapInstanceConfig config;
    public final Context context;
    public final CTPushProviderListener listener;

    public FcmSdkHandlerImpl(CTPushProviderListener cTPushProviderListener, Context context2, CleverTapInstanceConfig cleverTapInstanceConfig) {
        this.context = context2;
        this.config = cleverTapInstanceConfig;
        this.listener = cTPushProviderListener;
        ManifestInfo.getInstance(context2);
    }
}
