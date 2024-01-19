package com.cardinalcommerce.shared.cs.e;

import com.xiaomi.mipush.sdk.MiPushMessage;
import org.json.JSONObject;

public class e {

    /* renamed from: a  reason: collision with root package name */
    public String f2097a;

    /* renamed from: b  reason: collision with root package name */
    public String f2098b = "C";

    /* renamed from: c  reason: collision with root package name */
    public String f2099c;

    /* renamed from: d  reason: collision with root package name */
    public String f2100d;

    /* renamed from: e  reason: collision with root package name */
    public String f2101e = "CRes";

    /* renamed from: f  reason: collision with root package name */
    public String f2102f = "Erro";
    public String g = new String(null);
    public String h = "";
    public String i = "";
    public String j = "";

    public e(char[] cArr) {
    }

    public void a(b bVar) {
        this.j = bVar.f2089e;
        this.i = bVar.f2088d;
        this.h = bVar.z;
    }

    public JSONObject e() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.putOpt("errorCode", this.f2097a);
        jSONObject.putOpt("errorComponent", this.f2098b);
        jSONObject.putOpt("errorDescription", this.f2099c);
        jSONObject.putOpt("errorDetail", this.f2100d);
        jSONObject.putOpt("errorMessageType", this.f2101e);
        jSONObject.putOpt(MiPushMessage.KEY_MESSAGE_TYPE, this.f2102f);
        jSONObject.putOpt("messageVersion", this.g);
        jSONObject.putOpt("sdkTransID", this.h);
        jSONObject.putOpt("threeDSServerTransID", this.i);
        jSONObject.putOpt("acsTransID", this.j);
        return jSONObject;
    }
}
