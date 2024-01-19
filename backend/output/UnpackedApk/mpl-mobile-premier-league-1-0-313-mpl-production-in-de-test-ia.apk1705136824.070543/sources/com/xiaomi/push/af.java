package com.xiaomi.push;

import com.mpl.androidapp.updater.util.UpdaterConstant.Response;
import org.json.JSONObject;

public class af {

    /* renamed from: a  reason: collision with root package name */
    public int f4393a;

    /* renamed from: a  reason: collision with other field name */
    public long f239a;

    /* renamed from: a  reason: collision with other field name */
    public String f240a;

    /* renamed from: b  reason: collision with root package name */
    public long f4394b;

    /* renamed from: c  reason: collision with root package name */
    public long f4395c;

    public af() {
        this(0, 0, 0, null);
    }

    public af(int i, long j, long j2, Exception exc) {
        this.f4393a = i;
        this.f239a = j;
        this.f4395c = j2;
        this.f4394b = System.currentTimeMillis();
        if (exc != null) {
            this.f240a = exc.getClass().getSimpleName();
        }
    }

    public int a() {
        return this.f4393a;
    }

    public af a(JSONObject jSONObject) {
        this.f239a = jSONObject.getLong("cost");
        this.f4395c = jSONObject.getLong(Response.SIZE);
        this.f4394b = jSONObject.getLong("ts");
        this.f4393a = jSONObject.getInt("wt");
        this.f240a = jSONObject.optString("expt");
        return this;
    }

    /* renamed from: a  reason: collision with other method in class */
    public JSONObject m391a() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("cost", this.f239a);
        jSONObject.put(Response.SIZE, this.f4395c);
        jSONObject.put("ts", this.f4394b);
        jSONObject.put("wt", this.f4393a);
        jSONObject.put("expt", this.f240a);
        return jSONObject;
    }
}
