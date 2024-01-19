package com.cardinalcommerce.shared.cs.e;

import java.io.Serializable;
import org.json.JSONObject;

public class f implements Serializable {

    /* renamed from: a  reason: collision with root package name */
    public boolean f2103a = false;

    /* renamed from: b  reason: collision with root package name */
    public String f2104b;

    /* renamed from: c  reason: collision with root package name */
    public String f2105c;

    /* renamed from: d  reason: collision with root package name */
    public String f2106d;

    public f(String str) {
        if (!str.equals("")) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.has("medium")) {
                    this.f2104b = jSONObject.getString("medium");
                    this.f2103a = true;
                }
                if (jSONObject.has("extraHigh")) {
                    this.f2106d = jSONObject.getString("extraHigh");
                    this.f2103a = true;
                }
                if (jSONObject.has("high")) {
                    this.f2105c = jSONObject.getString("high");
                    this.f2103a = true;
                }
            } catch (Exception unused) {
                this.f2103a = false;
            }
        } else {
            this.f2103a = true;
        }
    }
}
