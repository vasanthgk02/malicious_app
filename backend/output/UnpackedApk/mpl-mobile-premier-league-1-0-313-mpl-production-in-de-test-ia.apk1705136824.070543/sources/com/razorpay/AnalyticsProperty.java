package com.razorpay;

import org.json.JSONObject;
import proguard.annotation.Keep;
import proguard.annotation.KeepClassMembers;

@Keep
@KeepClassMembers
public class AnalyticsProperty {
    public AnalyticsProperty$R$$r_ scope;
    public Object value;

    public AnalyticsProperty(int i, AnalyticsProperty$R$$r_ analyticsProperty$R$$r_) {
        this.value = Integer.valueOf(i);
        this.scope = analyticsProperty$R$$r_;
    }

    public AnalyticsProperty(long j, AnalyticsProperty$R$$r_ analyticsProperty$R$$r_) {
        this.value = Long.valueOf(j);
        this.scope = analyticsProperty$R$$r_;
    }

    public AnalyticsProperty(String str, AnalyticsProperty$R$$r_ analyticsProperty$R$$r_) {
        this.value = str;
        this.scope = analyticsProperty$R$$r_;
    }

    public AnalyticsProperty(boolean z, AnalyticsProperty$R$$r_ analyticsProperty$R$$r_) {
        this.value = Boolean.valueOf(z);
        this.scope = analyticsProperty$R$$r_;
    }

    public AnalyticsProperty(JSONObject jSONObject, AnalyticsProperty$R$$r_ analyticsProperty$R$$r_) {
        this.value = jSONObject;
        this.scope = analyticsProperty$R$$r_;
    }
}
