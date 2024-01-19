package com.paypal.android.sdk.onetouch.core;

import android.content.Context;
import com.paypal.android.sdk.onetouch.core.base.ContextInspector;
import com.paypal.android.sdk.onetouch.core.config.ConfigManager;
import com.paypal.android.sdk.onetouch.core.config.OAuth2Recipe;
import com.paypal.android.sdk.onetouch.core.enums.RequestTarget;
import com.paypal.android.sdk.onetouch.core.fpti.FptiManager;
import com.paypal.android.sdk.onetouch.core.network.PayPalHttpClient;
import java.util.ArrayList;
import java.util.Iterator;

public class PayPalOneTouchCore {
    public static ConfigManager sConfigManager;
    public static ContextInspector sContextInspector;
    public static FptiManager sFptiManager;

    public static void initService(Context context) {
        if (sConfigManager == null || sFptiManager == null) {
            PayPalHttpClient payPalHttpClient = new PayPalHttpClient();
            payPalHttpClient.mBaseUrl = "https://api-m.paypal.com/v1/";
            if (sContextInspector == null) {
                sContextInspector = new ContextInspector(context);
            }
            sConfigManager = new ConfigManager(sContextInspector, payPalHttpClient);
            if (sContextInspector == null) {
                sContextInspector = new ContextInspector(context);
            }
            sFptiManager = new FptiManager(sContextInspector, payPalHttpClient);
        }
        sConfigManager.refreshConfiguration();
    }

    public static boolean isWalletAppInstalled(Context context) {
        initService(context);
        Iterator it = new ArrayList(sConfigManager.getConfig().mOauth2RecipesInDecreasingPriorityOrder).iterator();
        while (it.hasNext()) {
            OAuth2Recipe oAuth2Recipe = (OAuth2Recipe) it.next();
            if (oAuth2Recipe.mTarget == RequestTarget.wallet && oAuth2Recipe.isValidAppTarget(context)) {
                return true;
            }
        }
        return false;
    }
}
