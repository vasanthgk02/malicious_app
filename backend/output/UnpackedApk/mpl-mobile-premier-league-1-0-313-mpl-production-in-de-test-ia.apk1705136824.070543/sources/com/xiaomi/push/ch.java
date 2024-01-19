package com.xiaomi.push;

import android.os.Bundle;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.mpl.androidapp.login.LoginReactModule;
import com.mpl.androidapp.utils.Constant;
import com.xiaomi.mipush.sdk.MiPushCommandMessage;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class ch extends cj {

    /* renamed from: a  reason: collision with root package name */
    public a f4541a = a.f4542a;

    /* renamed from: a  reason: collision with other field name */
    public final Map<String, String> f415a = new HashMap();

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public static final a f4542a = new a(Constant.GET);

        /* renamed from: b  reason: collision with root package name */
        public static final a f4543b = new a("set");

        /* renamed from: c  reason: collision with root package name */
        public static final a f4544c = new a(LoginReactModule.RESULT);

        /* renamed from: d  reason: collision with root package name */
        public static final a f4545d = new a("error");

        /* renamed from: e  reason: collision with root package name */
        public static final a f4546e = new a(MiPushCommandMessage.KEY_COMMAND);

        /* renamed from: a  reason: collision with other field name */
        public String f416a;

        public a(String str) {
            this.f416a = str;
        }

        public static a a(String str) {
            if (str == null) {
                return null;
            }
            String lowerCase = str.toLowerCase();
            if (f4542a.toString().equals(lowerCase)) {
                return f4542a;
            }
            if (f4543b.toString().equals(lowerCase)) {
                return f4543b;
            }
            if (f4545d.toString().equals(lowerCase)) {
                return f4545d;
            }
            if (f4544c.toString().equals(lowerCase)) {
                return f4544c;
            }
            if (f4546e.toString().equals(lowerCase)) {
                return f4546e;
            }
            return null;
        }

        public String toString() {
            return this.f416a;
        }
    }

    public ch() {
    }

    public ch(Bundle bundle) {
        super(bundle);
        if (bundle.containsKey("ext_iq_type")) {
            this.f4541a = a.a(bundle.getString("ext_iq_type"));
        }
    }

    public Bundle a() {
        Bundle a2 = super.a();
        a aVar = this.f4541a;
        if (aVar != null) {
            a2.putString("ext_iq_type", aVar.toString());
        }
        return a2;
    }

    /* renamed from: a  reason: collision with other method in class */
    public a m571a() {
        return this.f4541a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m572a() {
        String str;
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("<iq ");
        if (j() != null) {
            StringBuilder outline732 = GeneratedOutlineSupport.outline73("id=\"");
            outline732.append(j());
            outline732.append("\" ");
            outline73.append(outline732.toString());
        }
        if (l() != null) {
            outline73.append("to=\"");
            outline73.append(cu.a(l()));
            outline73.append("\" ");
        }
        if (m() != null) {
            outline73.append("from=\"");
            outline73.append(cu.a(m()));
            outline73.append("\" ");
        }
        if (k() != null) {
            outline73.append("chid=\"");
            outline73.append(cu.a(k()));
            outline73.append("\" ");
        }
        for (Entry next : this.f415a.entrySet()) {
            outline73.append(cu.a((String) next.getKey()));
            outline73.append("=\"");
            outline73.append(cu.a((String) next.getValue()));
            outline73.append("\" ");
        }
        if (this.f4541a == null) {
            str = "type=\"get\">";
        } else {
            outline73.append("type=\"");
            outline73.append(a());
            str = "\">";
        }
        outline73.append(str);
        String b2 = b();
        if (b2 != null) {
            outline73.append(b2);
        }
        outline73.append(o());
        cn a2 = a();
        if (a2 != null) {
            outline73.append(a2.a());
        }
        outline73.append("</iq>");
        return outline73.toString();
    }

    public void a(a aVar) {
        if (aVar == null) {
            aVar = a.f4542a;
        }
        this.f4541a = aVar;
    }

    public synchronized void a(Map<String, String> map) {
        this.f415a.putAll(map);
    }

    public String b() {
        return null;
    }
}
