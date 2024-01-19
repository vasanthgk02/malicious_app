package com.xiaomi.push;

import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.android.tools.r8.GeneratedOutlineSupport;

public class cl extends cj {

    /* renamed from: a  reason: collision with root package name */
    public int f4559a = LinearLayoutManager.INVALID_OFFSET;

    /* renamed from: a  reason: collision with other field name */
    public a f423a = null;

    /* renamed from: a  reason: collision with other field name */
    public b f424a = b.available;

    /* renamed from: b  reason: collision with root package name */
    public String f4560b = null;

    public enum a {
        chat,
        available,
        away,
        xa,
        dnd
    }

    public enum b {
        available,
        unavailable,
        subscribe,
        subscribed,
        unsubscribe,
        unsubscribed,
        error,
        probe
    }

    public cl(Bundle bundle) {
        super(bundle);
        if (bundle.containsKey("ext_pres_type")) {
            this.f424a = b.valueOf(bundle.getString("ext_pres_type"));
        }
        if (bundle.containsKey("ext_pres_status")) {
            this.f4560b = bundle.getString("ext_pres_status");
        }
        if (bundle.containsKey("ext_pres_prio")) {
            this.f4559a = bundle.getInt("ext_pres_prio");
        }
        if (bundle.containsKey("ext_pres_mode")) {
            this.f423a = a.valueOf(bundle.getString("ext_pres_mode"));
        }
    }

    public cl(b bVar) {
        a(bVar);
    }

    public Bundle a() {
        Bundle a2 = super.a();
        b bVar = this.f424a;
        if (bVar != null) {
            a2.putString("ext_pres_type", bVar.toString());
        }
        String str = this.f4560b;
        if (str != null) {
            a2.putString("ext_pres_status", str);
        }
        int i = this.f4559a;
        if (i != Integer.MIN_VALUE) {
            a2.putInt("ext_pres_prio", i);
        }
        a aVar = this.f423a;
        if (!(aVar == null || aVar == a.available)) {
            a2.putString("ext_pres_mode", aVar.toString());
        }
        return a2;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m578a() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("<presence");
        if (p() != null) {
            outline73.append(" xmlns=\"");
            outline73.append(p());
            outline73.append("\"");
        }
        if (j() != null) {
            outline73.append(" id=\"");
            outline73.append(j());
            outline73.append("\"");
        }
        if (l() != null) {
            outline73.append(" to=\"");
            outline73.append(cu.a(l()));
            outline73.append("\"");
        }
        if (m() != null) {
            outline73.append(" from=\"");
            outline73.append(cu.a(m()));
            outline73.append("\"");
        }
        if (k() != null) {
            outline73.append(" chid=\"");
            outline73.append(cu.a(k()));
            outline73.append("\"");
        }
        if (this.f424a != null) {
            outline73.append(" type=\"");
            outline73.append(this.f424a);
            outline73.append("\"");
        }
        outline73.append(">");
        if (this.f4560b != null) {
            outline73.append("<status>");
            outline73.append(cu.a(this.f4560b));
            outline73.append("</status>");
        }
        if (this.f4559a != Integer.MIN_VALUE) {
            outline73.append("<priority>");
            outline73.append(this.f4559a);
            outline73.append("</priority>");
        }
        a aVar = this.f423a;
        if (!(aVar == null || aVar == a.available)) {
            outline73.append("<show>");
            outline73.append(this.f423a);
            outline73.append("</show>");
        }
        outline73.append(o());
        cn a2 = a();
        if (a2 != null) {
            outline73.append(a2.a());
        }
        outline73.append("</presence>");
        return outline73.toString();
    }

    public void a(int i) {
        if (i < -128 || i > 128) {
            throw new IllegalArgumentException(GeneratedOutlineSupport.outline42("Priority value ", i, " is not valid. Valid range is -128 through 128."));
        }
        this.f4559a = i;
    }

    public void a(a aVar) {
        this.f423a = aVar;
    }

    public void a(b bVar) {
        if (bVar != null) {
            this.f424a = bVar;
            return;
        }
        throw new NullPointerException("Type cannot be null");
    }

    public void a(String str) {
        this.f4560b = str;
    }
}
