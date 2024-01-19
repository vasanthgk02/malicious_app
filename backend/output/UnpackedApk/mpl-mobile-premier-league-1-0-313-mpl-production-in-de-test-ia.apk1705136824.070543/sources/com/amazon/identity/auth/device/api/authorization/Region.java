package com.amazon.identity.auth.device.api.authorization;

import com.razorpay.AnalyticsConstants;

public enum Region {
    AUTO("AUTO"),
    NA(AnalyticsConstants.NOT_AVAILABLE),
    EU("EU"),
    FE("FE");
    

    /* renamed from: a  reason: collision with other field name */
    public String f108a;

    /* access modifiers changed from: public */
    Region(String str) {
        this.f108a = str;
    }

    public String getStringValue() {
        return this.f108a;
    }
}
