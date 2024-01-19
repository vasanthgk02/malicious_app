package com.braintreepayments.browserswitch;

import org.json.JSONObject;

public class BrowserSwitchResult {
    public final String errorMessage;
    public final int status;

    public BrowserSwitchResult(int i, String str) {
        this.status = i;
        this.errorMessage = str;
    }

    public BrowserSwitchResult(int i, String str, JSONObject jSONObject) {
        this.status = i;
        this.errorMessage = null;
    }
}
