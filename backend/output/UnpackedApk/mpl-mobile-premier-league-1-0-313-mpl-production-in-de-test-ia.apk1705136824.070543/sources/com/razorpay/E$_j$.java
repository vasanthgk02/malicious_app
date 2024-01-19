package com.razorpay;

import org.json.JSONObject;

public final class E$_j$ {
    public static JSONObject Q_$2$(boolean z) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("otp_read", z ? 1 : 0);
            return jSONObject;
        } catch (Exception e2) {
            AnalyticsUtil.reportError(e2, "error", e2.getMessage());
            return null;
        }
    }
}
