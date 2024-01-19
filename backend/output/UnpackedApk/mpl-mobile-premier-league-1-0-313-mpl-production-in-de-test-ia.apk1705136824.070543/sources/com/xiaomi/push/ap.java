package com.xiaomi.push;

import java.util.Iterator;
import java.util.LinkedList;
import okhttp3.internal.http2.Http2ExchangeCodec;
import org.json.JSONArray;
import org.json.JSONObject;

public class ap implements Comparable<ap> {

    /* renamed from: a  reason: collision with root package name */
    public int f4412a;

    /* renamed from: a  reason: collision with other field name */
    public long f259a;

    /* renamed from: a  reason: collision with other field name */
    public String f260a;

    /* renamed from: a  reason: collision with other field name */
    public final LinkedList<af> f261a;

    public ap() {
        this(null, 0);
    }

    public ap(String str) {
        this(str, 0);
    }

    public ap(String str, int i) {
        this.f261a = new LinkedList<>();
        this.f259a = 0;
        this.f260a = str;
        this.f4412a = i;
    }

    /* renamed from: a */
    public int compareTo(ap apVar) {
        if (apVar == null) {
            return 1;
        }
        return apVar.f4412a - this.f4412a;
    }

    public synchronized ap a(JSONObject jSONObject) {
        try {
            this.f259a = jSONObject.getLong("tt");
            this.f4412a = jSONObject.getInt("wt");
            this.f260a = jSONObject.getString(Http2ExchangeCodec.HOST);
            JSONArray jSONArray = jSONObject.getJSONArray("ah");
            for (int i = 0; i < jSONArray.length(); i++) {
                this.f261a.add(new af().a(jSONArray.getJSONObject(i)));
            }
        }
        return this;
    }

    public synchronized JSONObject a() {
        JSONObject jSONObject;
        try {
            jSONObject = new JSONObject();
            jSONObject.put("tt", this.f259a);
            jSONObject.put("wt", this.f4412a);
            jSONObject.put(Http2ExchangeCodec.HOST, this.f260a);
            JSONArray jSONArray = new JSONArray();
            Iterator it = this.f261a.iterator();
            while (it.hasNext()) {
                jSONArray.put(((af) it.next()).a());
            }
            jSONObject.put("ah", jSONArray);
        }
        return jSONObject;
    }

    public synchronized void a(af afVar) {
        if (afVar != null) {
            this.f261a.add(afVar);
            int a2 = afVar.a();
            if (a2 > 0) {
                this.f4412a += afVar.a();
            } else {
                int i = 0;
                int size = this.f261a.size() - 1;
                while (size >= 0 && this.f261a.get(size).a() < 0) {
                    i++;
                    size--;
                }
                this.f4412a = (a2 * i) + this.f4412a;
            }
            if (this.f261a.size() > 30) {
                this.f4412a -= this.f261a.remove().a();
            }
        }
    }

    public String toString() {
        return this.f260a + ":" + this.f4412a;
    }
}
