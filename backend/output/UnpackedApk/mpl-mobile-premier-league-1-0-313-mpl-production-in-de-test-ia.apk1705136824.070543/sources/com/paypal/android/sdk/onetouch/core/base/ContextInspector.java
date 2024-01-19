package com.paypal.android.sdk.onetouch.core.base;

import android.content.Context;
import android.content.SharedPreferences;

public class ContextInspector {
    public final Context mContext;
    public final SharedPreferences mPreferences;

    public ContextInspector(Context context) {
        Context applicationContext = context.getApplicationContext();
        this.mContext = applicationContext;
        this.mPreferences = applicationContext.getSharedPreferences("PayPalOTC", 0);
    }
}
