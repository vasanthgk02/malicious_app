package com.xiaomi.push;

import android.os.Bundle;
import android.os.Parcelable;
import com.android.tools.r8.GeneratedOutlineSupport;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.apache.fontbox.cmap.CMap;

public class cn {

    /* renamed from: a  reason: collision with root package name */
    public int f4573a;

    /* renamed from: a  reason: collision with other field name */
    public String f427a;

    /* renamed from: a  reason: collision with other field name */
    public List<cg> f428a = null;

    /* renamed from: b  reason: collision with root package name */
    public String f4574b;

    /* renamed from: c  reason: collision with root package name */
    public String f4575c;

    /* renamed from: d  reason: collision with root package name */
    public String f4576d;

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public static final a f4577a = new a("internal-server-error");

        /* renamed from: b  reason: collision with root package name */
        public static final a f4578b = new a("forbidden");

        /* renamed from: c  reason: collision with root package name */
        public static final a f4579c = new a("bad-request");

        /* renamed from: d  reason: collision with root package name */
        public static final a f4580d = new a("conflict");

        /* renamed from: e  reason: collision with root package name */
        public static final a f4581e = new a("feature-not-implemented");

        /* renamed from: f  reason: collision with root package name */
        public static final a f4582f = new a("gone");
        public static final a g = new a("item-not-found");
        public static final a h = new a("jid-malformed");
        public static final a i = new a("not-acceptable");
        public static final a j = new a("not-allowed");
        public static final a k = new a("not-authorized");
        public static final a l = new a("payment-required");
        public static final a m = new a("recipient-unavailable");
        public static final a n = new a("redirect");
        public static final a o = new a("registration-required");
        public static final a p = new a("remote-server-error");
        public static final a q = new a("remote-server-not-found");
        public static final a r = new a("remote-server-timeout");
        public static final a s = new a("resource-constraint");
        public static final a t = new a("service-unavailable");
        public static final a u = new a("subscription-required");
        public static final a v = new a("undefined-condition");
        public static final a w = new a("unexpected-request");
        public static final a x = new a("request-timeout");

        /* renamed from: a  reason: collision with other field name */
        public String f429a;

        public a(String str) {
            this.f429a = str;
        }

        public String toString() {
            return this.f429a;
        }
    }

    public cn(int i, String str, String str2, String str3, String str4, List<cg> list) {
        this.f4573a = i;
        this.f427a = str;
        this.f4575c = str2;
        this.f4574b = str3;
        this.f4576d = str4;
        this.f428a = list;
    }

    public cn(Bundle bundle) {
        this.f4573a = bundle.getInt("ext_err_code");
        if (bundle.containsKey("ext_err_type")) {
            this.f427a = bundle.getString("ext_err_type");
        }
        this.f4574b = bundle.getString("ext_err_cond");
        this.f4575c = bundle.getString("ext_err_reason");
        this.f4576d = bundle.getString("ext_err_msg");
        Parcelable[] parcelableArray = bundle.getParcelableArray("ext_exts");
        if (parcelableArray != null) {
            this.f428a = new ArrayList(parcelableArray.length);
            for (Parcelable parcelable : parcelableArray) {
                cg a2 = cg.a((Bundle) parcelable);
                if (a2 != null) {
                    this.f428a.add(a2);
                }
            }
        }
    }

    public cn(a aVar) {
        a(aVar);
        this.f4576d = null;
    }

    private void a(a aVar) {
        this.f4574b = aVar.f429a;
    }

    public Bundle a() {
        Bundle bundle = new Bundle();
        String str = this.f427a;
        if (str != null) {
            bundle.putString("ext_err_type", str);
        }
        bundle.putInt("ext_err_code", this.f4573a);
        String str2 = this.f4575c;
        if (str2 != null) {
            bundle.putString("ext_err_reason", str2);
        }
        String str3 = this.f4574b;
        if (str3 != null) {
            bundle.putString("ext_err_cond", str3);
        }
        String str4 = this.f4576d;
        if (str4 != null) {
            bundle.putString("ext_err_msg", str4);
        }
        List<cg> list = this.f428a;
        if (list != null) {
            Bundle[] bundleArr = new Bundle[list.size()];
            int i = 0;
            for (cg a2 : this.f428a) {
                Bundle a3 = a2.a();
                if (a3 != null) {
                    bundleArr[i] = a3;
                    i++;
                }
            }
            bundle.putParcelableArray("ext_exts", bundleArr);
        }
        return bundle;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m579a() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("<error code=\"");
        outline73.append(this.f4573a);
        outline73.append("\"");
        if (this.f427a != null) {
            outline73.append(" type=\"");
            outline73.append(this.f427a);
            outline73.append("\"");
        }
        if (this.f4575c != null) {
            outline73.append(" reason=\"");
            outline73.append(this.f4575c);
            outline73.append("\"");
        }
        outline73.append(">");
        if (this.f4574b != null) {
            outline73.append("<");
            outline73.append(this.f4574b);
            outline73.append(" xmlns=\"urn:ietf:params:xml:ns:xmpp-stanzas\"/>");
        }
        if (this.f4576d != null) {
            outline73.append("<text xml:lang=\"en\" xmlns=\"urn:ietf:params:xml:ns:xmpp-stanzas\">");
            outline73.append(this.f4576d);
            outline73.append("</text>");
        }
        for (ck d2 : a()) {
            outline73.append(d2.d());
        }
        outline73.append("</error>");
        return outline73.toString();
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized List<cg> m580a() {
        if (this.f428a == null) {
            return Collections.emptyList();
        }
        return Collections.unmodifiableList(this.f428a);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        String str = this.f4574b;
        if (str != null) {
            sb.append(str);
        }
        sb.append("(");
        sb.append(this.f4573a);
        sb.append(")");
        if (this.f4576d != null) {
            sb.append(CMap.SPACE);
            sb.append(this.f4576d);
        }
        return sb.toString();
    }
}
