package com.braintreepayments.api;

import android.content.Context;
import android.util.Base64;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.braintreepayments.api.models.Configuration;
import java.util.concurrent.TimeUnit;

public class ConfigurationManager {
    public static final long TTL = TimeUnit.MINUTES.toMillis(5);
    public static boolean sFetchingConfiguration = false;

    public static void access$000(Context context, String str, Configuration configuration) {
        String encodeToString = Base64.encodeToString(str.getBytes(), 0);
        context.getApplicationContext().getSharedPreferences("BraintreeApi", 0).edit().putString(encodeToString, configuration.mConfigurationString).putLong(GeneratedOutlineSupport.outline50(encodeToString, "_timestamp"), System.currentTimeMillis()).apply();
    }
}
