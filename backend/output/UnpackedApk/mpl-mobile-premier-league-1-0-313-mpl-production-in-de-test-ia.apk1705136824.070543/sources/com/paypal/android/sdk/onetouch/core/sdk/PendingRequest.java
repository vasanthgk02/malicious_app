package com.paypal.android.sdk.onetouch.core.sdk;

import android.content.Intent;
import com.paypal.android.sdk.onetouch.core.enums.RequestTarget;

public class PendingRequest {
    public final Intent mIntent;
    public final RequestTarget mRequestTarget;
    public final boolean mSuccess;

    public PendingRequest(boolean z, RequestTarget requestTarget, String str, Intent intent) {
        this.mSuccess = z;
        this.mRequestTarget = requestTarget;
        this.mIntent = intent;
    }
}
