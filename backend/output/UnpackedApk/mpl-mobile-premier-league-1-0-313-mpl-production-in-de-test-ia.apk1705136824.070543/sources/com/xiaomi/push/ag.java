package com.xiaomi.push;

import android.text.TextUtils;
import com.android.tools.r8.GeneratedOutlineSupport;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import okhttp3.internal.http2.Http2ExchangeCodec;
import org.json.JSONArray;
import org.json.JSONObject;
import sfs2x.client.requests.game.CreateSFSGameRequest;

public class ag {

    /* renamed from: a  reason: collision with root package name */
    public double f4396a = 0.1d;

    /* renamed from: a  reason: collision with other field name */
    public long f241a;

    /* renamed from: a  reason: collision with other field name */
    public String f242a = "";

    /* renamed from: a  reason: collision with other field name */
    public ArrayList<ap> f243a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    public long f4397b = 86400000;

    /* renamed from: b  reason: collision with other field name */
    public String f244b;

    /* renamed from: c  reason: collision with root package name */
    public String f4398c;

    /* renamed from: d  reason: collision with root package name */
    public String f4399d;

    /* renamed from: e  reason: collision with root package name */
    public String f4400e;

    /* renamed from: f  reason: collision with root package name */
    public String f4401f;
    public String g;
    public String h;
    public String i;
    public String j = "s.mi1.cc";

    public ag(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f241a = System.currentTimeMillis();
            this.f243a.add(new ap(str, -1));
            this.f242a = ak.a();
            this.f244b = str;
            return;
        }
        throw new IllegalArgumentException("the host is empty");
    }

    private synchronized void c(String str) {
        Iterator<ap> it = this.f243a.iterator();
        while (it.hasNext()) {
            if (TextUtils.equals(it.next().f260a, str)) {
                it.remove();
            }
        }
    }

    public synchronized ag a(JSONObject jSONObject) {
        this.f242a = jSONObject.optString("net");
        this.f4397b = jSONObject.getLong("ttl");
        this.f4396a = jSONObject.getDouble("pct");
        this.f241a = jSONObject.getLong("ts");
        this.f4399d = jSONObject.optString("city");
        this.f4398c = jSONObject.optString("prv");
        this.g = jSONObject.optString("cty");
        this.f4400e = jSONObject.optString("isp");
        this.f4401f = jSONObject.optString(CreateSFSGameRequest.KEY_INVITATION_PARAMS);
        this.f244b = jSONObject.optString(Http2ExchangeCodec.HOST);
        this.h = jSONObject.optString("xf");
        JSONArray jSONArray = jSONObject.getJSONArray("fbs");
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            a(new ap().a(jSONArray.getJSONObject(i2)));
        }
        return this;
    }

    public synchronized String a() {
        if (!TextUtils.isEmpty(this.i)) {
            return this.i;
        } else if (TextUtils.isEmpty(this.f4400e)) {
            return "hardcode_isp";
        } else {
            String a2 = ad.a((Object[]) new String[]{this.f4400e, this.f4398c, this.f4399d, this.g, this.f4401f}, (String) "_");
            this.i = a2;
            return a2;
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized ArrayList<String> m392a() {
        return a(false);
    }

    public ArrayList<String> a(String str) {
        if (!TextUtils.isEmpty(str)) {
            URL url = new URL(str);
            if (TextUtils.equals(url.getHost(), this.f244b)) {
                ArrayList<String> arrayList = new ArrayList<>();
                Iterator<String> it = a(true).iterator();
                while (it.hasNext()) {
                    ai a2 = ai.a(it.next(), url.getPort());
                    arrayList.add(new URL(url.getProtocol(), a2.a(), a2.a(), url.getFile()).toString());
                }
                return arrayList;
            }
            throw new IllegalArgumentException("the url is not supported by the fallback");
        }
        throw new IllegalArgumentException("the url is empty.");
    }

    public synchronized ArrayList<String> a(boolean z) {
        ArrayList<String> arrayList;
        String substring;
        int size = this.f243a.size();
        ap[] apVarArr = new ap[size];
        this.f243a.toArray(apVarArr);
        Arrays.sort(apVarArr);
        arrayList = new ArrayList<>();
        for (int i2 = 0; i2 < size; i2++) {
            ap apVar = apVarArr[i2];
            if (z) {
                substring = apVar.f260a;
            } else {
                int indexOf = apVar.f260a.indexOf(":");
                substring = indexOf != -1 ? apVar.f260a.substring(0, indexOf) : apVar.f260a;
            }
            arrayList.add(substring);
        }
        return arrayList;
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized JSONObject m393a() {
        JSONObject jSONObject;
        jSONObject = new JSONObject();
        jSONObject.put("net", this.f242a);
        jSONObject.put("ttl", this.f4397b);
        jSONObject.put("pct", this.f4396a);
        jSONObject.put("ts", this.f241a);
        jSONObject.put("city", this.f4399d);
        jSONObject.put("prv", this.f4398c);
        jSONObject.put("cty", this.g);
        jSONObject.put("isp", this.f4400e);
        jSONObject.put(CreateSFSGameRequest.KEY_INVITATION_PARAMS, this.f4401f);
        jSONObject.put(Http2ExchangeCodec.HOST, this.f244b);
        jSONObject.put("xf", this.h);
        JSONArray jSONArray = new JSONArray();
        Iterator<ap> it = this.f243a.iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next().a());
        }
        jSONObject.put("fbs", jSONArray);
        return jSONObject;
    }

    public void a(double d2) {
        this.f4396a = d2;
    }

    public void a(long j2) {
        if (j2 > 0) {
            this.f4397b = j2;
            return;
        }
        throw new IllegalArgumentException(GeneratedOutlineSupport.outline45("the duration is invalid ", j2));
    }

    public synchronized void a(ap apVar) {
        c(apVar.f260a);
        this.f243a.add(apVar);
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized void m394a(String str) {
        a(new ap(str));
    }

    public void a(String str, int i2, long j2, long j3, Exception exc) {
        af afVar = new af(i2, j2, j3, exc);
        a(str, afVar);
    }

    public void a(String str, long j2, long j3) {
        try {
            b(new URL(str).getHost(), j2, j3);
        } catch (MalformedURLException unused) {
        }
    }

    public void a(String str, long j2, long j3, Exception exc) {
        try {
            b(new URL(str).getHost(), j2, j3, exc);
        } catch (MalformedURLException unused) {
        }
    }

    public synchronized void a(String str, af afVar) {
        Iterator<ap> it = this.f243a.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            ap next = it.next();
            if (TextUtils.equals(str, next.f260a)) {
                next.a(afVar);
                break;
            }
        }
    }

    public synchronized void a(String[] strArr) {
        int i2;
        int size = this.f243a.size() - 1;
        while (true) {
            i2 = 0;
            if (size < 0) {
                break;
            }
            int length = strArr.length;
            while (true) {
                if (i2 >= length) {
                    break;
                }
                if (TextUtils.equals(this.f243a.get(size).f260a, strArr[i2])) {
                    this.f243a.remove(size);
                    break;
                }
                i2++;
            }
            size--;
        }
        Iterator<ap> it = this.f243a.iterator();
        int i3 = 0;
        while (it.hasNext()) {
            ap next = it.next();
            if (next.f4412a > i3) {
                i3 = next.f4412a;
            }
        }
        while (i2 < strArr.length) {
            a(new ap(strArr[i2], (strArr.length + i3) - i2));
            i2++;
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m395a() {
        return TextUtils.equals(this.f242a, ak.a());
    }

    public boolean a(ag agVar) {
        return TextUtils.equals(this.f242a, agVar.f242a);
    }

    public void b(String str) {
        this.j = str;
    }

    public void b(String str, long j2, long j3) {
        a(str, 0, j2, j3, null);
    }

    public void b(String str, long j2, long j3, Exception exc) {
        a(str, -1, j2, j3, exc);
    }

    public boolean b() {
        return System.currentTimeMillis() - this.f241a < this.f4397b;
    }

    public boolean c() {
        long j2 = this.f4397b;
        if (864000000 >= j2) {
            j2 = 864000000;
        }
        long currentTimeMillis = System.currentTimeMillis();
        long j3 = this.f241a;
        return currentTimeMillis - j3 > j2 || (currentTimeMillis - j3 > this.f4397b && this.f242a.startsWith("WIFI-"));
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f242a);
        sb.append("\n");
        sb.append(a());
        Iterator<ap> it = this.f243a.iterator();
        while (it.hasNext()) {
            sb.append("\n");
            sb.append(it.next().toString());
        }
        sb.append("\n");
        return sb.toString();
    }
}
