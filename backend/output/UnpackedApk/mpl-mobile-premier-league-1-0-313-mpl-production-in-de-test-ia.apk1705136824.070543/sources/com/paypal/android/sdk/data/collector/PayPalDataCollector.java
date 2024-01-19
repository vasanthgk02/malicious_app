package com.paypal.android.sdk.data.collector;

import android.content.Context;
import com.google.android.material.resources.TextAppearanceConfig;
import lib.android.paypal.com.magnessdk.Environment;
import lib.android.paypal.com.magnessdk.InvalidInputException;
import lib.android.paypal.com.magnessdk.MagnesSDK;
import lib.android.paypal.com.magnessdk.MagnesSettings.Builder;
import lib.android.paypal.com.magnessdk.MagnesSource;
import lib.android.paypal.com.magnessdk.c$b$b;

public class PayPalDataCollector {
    public static String getClientMetadataId(Context context) {
        String installationGUID = TextAppearanceConfig.getInstallationGUID(context);
        if (context == null) {
            return "";
        }
        try {
            MagnesSDK instance = MagnesSDK.getInstance();
            Builder builder = new Builder(context);
            builder.sourceFlow = MagnesSource.BRAINTREE.getVersion();
            builder.disableBeacon = false;
            builder.environment = Environment.LIVE;
            if (installationGUID.length() <= 36) {
                builder.appGuid = installationGUID;
                instance.setUp(builder.build());
                return instance.collectAndSubmit(context, null, null).paypalclientmetadataid;
            }
            throw new InvalidInputException(c$b$b.APPGUID_EXCEPTION_MESSAGE.toString());
        } catch (InvalidInputException unused) {
            return "";
        }
    }
}
