package com.paypal.android.sdk.onetouch.core.fpti;

import com.paypal.android.sdk.onetouch.core.base.ContextInspector;
import com.paypal.android.sdk.onetouch.core.network.PayPalHttpClient;

public class FptiManager {
    public final ContextInspector mContextInspector;
    public final PayPalHttpClient mHttpClient;
    public FptiToken mToken;

    public FptiManager(ContextInspector contextInspector, PayPalHttpClient payPalHttpClient) {
        this.mContextInspector = contextInspector;
        this.mHttpClient = payPalHttpClient;
    }
}
