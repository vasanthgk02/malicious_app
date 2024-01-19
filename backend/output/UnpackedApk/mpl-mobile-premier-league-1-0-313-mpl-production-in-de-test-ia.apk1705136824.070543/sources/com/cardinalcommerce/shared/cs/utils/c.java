package com.cardinalcommerce.shared.cs.utils;

import org.json.JSONException;
import org.json.JSONObject;

public class c {

    /* renamed from: a  reason: collision with root package name */
    public String f2219a;

    /* renamed from: b  reason: collision with root package name */
    public String f2220b;

    /* renamed from: c  reason: collision with root package name */
    public String f2221c;

    /* renamed from: d  reason: collision with root package name */
    public String f2222d;

    /* renamed from: e  reason: collision with root package name */
    public String f2223e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f2224f;

    public JSONObject b() {
        String str;
        String str2;
        JSONObject jSONObject = new JSONObject();
        try {
            if (this.f2224f) {
                str = "error";
                str2 = this.f2223e;
            } else {
                str = "event";
                str2 = this.f2222d;
            }
            jSONObject.put(str, str2);
            jSONObject.put("detail", this.f2219a);
            jSONObject.put("timestamp", this.f2221c);
            return jSONObject;
        } catch (JSONException unused) {
            return null;
        }
    }
}
