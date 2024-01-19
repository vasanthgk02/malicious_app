package com.xiaomi.push;

import android.os.Bundle;
import android.text.TextUtils;
import com.android.tools.r8.GeneratedOutlineSupport;

public class ci extends cj {

    /* renamed from: a  reason: collision with root package name */
    public boolean f4547a = false;

    /* renamed from: b  reason: collision with root package name */
    public String f4548b = null;

    /* renamed from: b  reason: collision with other field name */
    public boolean f417b = false;

    /* renamed from: c  reason: collision with root package name */
    public String f4549c = null;

    /* renamed from: d  reason: collision with root package name */
    public String f4550d;

    /* renamed from: e  reason: collision with root package name */
    public String f4551e;

    /* renamed from: f  reason: collision with root package name */
    public String f4552f;
    public String g;
    public String h;
    public String i = "";
    public String j = "";
    public String k = "";
    public String l = "";

    public ci() {
    }

    public ci(Bundle bundle) {
        super(bundle);
        this.f4548b = bundle.getString("ext_msg_type");
        this.f4550d = bundle.getString("ext_msg_lang");
        this.f4549c = bundle.getString("ext_msg_thread");
        this.f4551e = bundle.getString("ext_msg_sub");
        this.f4552f = bundle.getString("ext_msg_body");
        this.g = bundle.getString("ext_body_encode");
        this.h = bundle.getString("ext_msg_appid");
        this.f4547a = bundle.getBoolean("ext_msg_trans", false);
        this.f417b = bundle.getBoolean("ext_msg_encrypt", false);
        this.i = bundle.getString("ext_msg_seq");
        this.j = bundle.getString("ext_msg_mseq");
        this.k = bundle.getString("ext_msg_fseq");
        this.l = bundle.getString("ext_msg_status");
    }

    public Bundle a() {
        Bundle a2 = super.a();
        if (!TextUtils.isEmpty(this.f4548b)) {
            a2.putString("ext_msg_type", this.f4548b);
        }
        String str = this.f4550d;
        if (str != null) {
            a2.putString("ext_msg_lang", str);
        }
        String str2 = this.f4551e;
        if (str2 != null) {
            a2.putString("ext_msg_sub", str2);
        }
        String str3 = this.f4552f;
        if (str3 != null) {
            a2.putString("ext_msg_body", str3);
        }
        if (!TextUtils.isEmpty(this.g)) {
            a2.putString("ext_body_encode", this.g);
        }
        String str4 = this.f4549c;
        if (str4 != null) {
            a2.putString("ext_msg_thread", str4);
        }
        String str5 = this.h;
        if (str5 != null) {
            a2.putString("ext_msg_appid", str5);
        }
        if (this.f4547a) {
            a2.putBoolean("ext_msg_trans", true);
        }
        if (!TextUtils.isEmpty(this.i)) {
            a2.putString("ext_msg_seq", this.i);
        }
        if (!TextUtils.isEmpty(this.j)) {
            a2.putString("ext_msg_mseq", this.j);
        }
        if (!TextUtils.isEmpty(this.k)) {
            a2.putString("ext_msg_fseq", this.k);
        }
        if (this.f417b) {
            a2.putBoolean("ext_msg_encrypt", true);
        }
        if (!TextUtils.isEmpty(this.l)) {
            a2.putString("ext_msg_status", this.l);
        }
        return a2;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m573a() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("<message");
        if (p() != null) {
            outline73.append(" xmlns=\"");
            outline73.append(p());
            outline73.append("\"");
        }
        if (this.f4550d != null) {
            outline73.append(" xml:lang=\"");
            outline73.append(h());
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
        if (!TextUtils.isEmpty(d())) {
            outline73.append(" seq=\"");
            outline73.append(d());
            outline73.append("\"");
        }
        if (!TextUtils.isEmpty(e())) {
            outline73.append(" mseq=\"");
            outline73.append(e());
            outline73.append("\"");
        }
        if (!TextUtils.isEmpty(f())) {
            outline73.append(" fseq=\"");
            outline73.append(f());
            outline73.append("\"");
        }
        if (!TextUtils.isEmpty(g())) {
            outline73.append(" status=\"");
            outline73.append(g());
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
        if (this.f4547a) {
            outline73.append(" transient=\"true\"");
        }
        if (!TextUtils.isEmpty(this.h)) {
            outline73.append(" appid=\"");
            outline73.append(c());
            outline73.append("\"");
        }
        if (!TextUtils.isEmpty(this.f4548b)) {
            outline73.append(" type=\"");
            outline73.append(this.f4548b);
            outline73.append("\"");
        }
        if (this.f417b) {
            outline73.append(" s=\"1\"");
        }
        outline73.append(">");
        if (this.f4551e != null) {
            outline73.append("<subject>");
            outline73.append(cu.a(this.f4551e));
            outline73.append("</subject>");
        }
        if (this.f4552f != null) {
            outline73.append("<body");
            if (!TextUtils.isEmpty(this.g)) {
                outline73.append(" encode=\"");
                outline73.append(this.g);
                outline73.append("\"");
            }
            outline73.append(">");
            outline73.append(cu.a(this.f4552f));
            outline73.append("</body>");
        }
        if (this.f4549c != null) {
            outline73.append("<thread>");
            outline73.append(this.f4549c);
            outline73.append("</thread>");
        }
        if ("error".equalsIgnoreCase(this.f4548b)) {
            cn a2 = a();
            if (a2 != null) {
                outline73.append(a2.a());
            }
        }
        outline73.append(o());
        outline73.append("</message>");
        return outline73.toString();
    }

    public void a(String str) {
        this.h = str;
    }

    public void a(String str, String str2) {
        this.f4552f = str;
        this.g = str2;
    }

    public void a(boolean z) {
        this.f4547a = z;
    }

    public String b() {
        return this.f4548b;
    }

    public void b(String str) {
        this.i = str;
    }

    public void b(boolean z) {
        this.f417b = z;
    }

    public String c() {
        return this.h;
    }

    public void c(String str) {
        this.j = str;
    }

    public String d() {
        return this.i;
    }

    public void d(String str) {
        this.k = str;
    }

    public String e() {
        return this.j;
    }

    public void e(String str) {
        this.l = str;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (obj == null || ci.class != obj.getClass()) {
            return false;
        }
        ci ciVar = (ci) obj;
        if (!super.equals(ciVar)) {
            return false;
        }
        String str = this.f4552f;
        if (str == null ? ciVar.f4552f != null : !str.equals(ciVar.f4552f)) {
            return false;
        }
        String str2 = this.f4550d;
        if (str2 == null ? ciVar.f4550d != null : !str2.equals(ciVar.f4550d)) {
            return false;
        }
        String str3 = this.f4551e;
        if (str3 == null ? ciVar.f4551e != null : !str3.equals(ciVar.f4551e)) {
            return false;
        }
        String str4 = this.f4549c;
        if (str4 == null ? ciVar.f4549c != null : !str4.equals(ciVar.f4549c)) {
            return false;
        }
        if (this.f4548b != ciVar.f4548b) {
            z = false;
        }
        return z;
    }

    public String f() {
        return this.k;
    }

    public void f(String str) {
        this.f4548b = str;
    }

    public String g() {
        return this.l;
    }

    public void g(String str) {
        this.f4551e = str;
    }

    public String h() {
        return this.f4550d;
    }

    public void h(String str) {
        this.f4552f = str;
    }

    public int hashCode() {
        String str = this.f4548b;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.f4552f;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.f4549c;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.f4550d;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.f4551e;
        if (str5 != null) {
            i2 = str5.hashCode();
        }
        return hashCode4 + i2;
    }

    public void i(String str) {
        this.f4549c = str;
    }

    public void j(String str) {
        this.f4550d = str;
    }
}
