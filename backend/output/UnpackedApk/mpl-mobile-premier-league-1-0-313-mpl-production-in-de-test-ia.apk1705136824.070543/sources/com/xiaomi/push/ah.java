package com.xiaomi.push;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import okhttp3.internal.http2.Http2ExchangeCodec;
import org.json.JSONArray;
import org.json.JSONObject;

public class ah {

    /* renamed from: a  reason: collision with root package name */
    public String f4402a;

    /* renamed from: a  reason: collision with other field name */
    public final ArrayList<ag> f245a = new ArrayList<>();

    public ah() {
    }

    public ah(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f4402a = str;
            return;
        }
        throw new IllegalArgumentException("the host is empty");
    }

    public synchronized ag a() {
        for (int size = this.f245a.size() - 1; size >= 0; size--) {
            ag agVar = this.f245a.get(size);
            if (agVar.a()) {
                ak.a().a(agVar.a());
                return agVar;
            }
        }
        return null;
    }

    public synchronized ah a(JSONObject jSONObject) {
        this.f4402a = jSONObject.getString(Http2ExchangeCodec.HOST);
        JSONArray jSONArray = jSONObject.getJSONArray("fbs");
        for (int i = 0; i < jSONArray.length(); i++) {
            this.f245a.add(new ag(this.f4402a).a(jSONArray.getJSONObject(i)));
        }
        return this;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m396a() {
        return this.f4402a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public ArrayList<ag> m397a() {
        return this.f245a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized JSONObject m398a() {
        JSONObject jSONObject;
        jSONObject = new JSONObject();
        jSONObject.put(Http2ExchangeCodec.HOST, this.f4402a);
        JSONArray jSONArray = new JSONArray();
        Iterator<ag> it = this.f245a.iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next().a());
        }
        jSONObject.put("fbs", jSONArray);
        return jSONObject;
    }

    public synchronized void a(ag agVar) {
        int i = 0;
        while (true) {
            if (i >= this.f245a.size()) {
                break;
            } else if (this.f245a.get(i).a(agVar)) {
                this.f245a.set(i, agVar);
                break;
            } else {
                i++;
            }
        }
        if (i >= this.f245a.size()) {
            this.f245a.add(agVar);
        }
    }

    public synchronized void a(boolean z) {
        ArrayList<ag> arrayList;
        for (int size = this.f245a.size() - 1; size >= 0; size--) {
            ag agVar = this.f245a.get(size);
            if (z) {
                if (agVar.c()) {
                    arrayList = this.f245a;
                }
            } else if (!agVar.b()) {
                arrayList = this.f245a;
            }
            arrayList.remove(size);
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f4402a);
        sb.append("\n");
        Iterator<ag> it = this.f245a.iterator();
        while (it.hasNext()) {
            sb.append(it.next());
        }
        return sb.toString();
    }
}
