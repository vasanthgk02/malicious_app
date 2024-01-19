package com.userexperior.e.b;

import com.userexperior.e.m;
import com.userexperior.e.o;
import com.userexperior.e.r;
import com.userexperior.e.s;
import com.userexperior.e.t;
import java.io.UnsupportedEncodingException;

public class k extends o<String> {

    /* renamed from: a  reason: collision with root package name */
    public final t<String> f3963a;

    public k(String str, t<String> tVar, s sVar) {
        super(str, sVar);
        this.f3963a = tVar;
    }

    public final r<String> a(m mVar) {
        String str;
        try {
            str = new String(mVar.f4008b, f.a(mVar.f4009c));
        } catch (UnsupportedEncodingException unused) {
            str = new String(mVar.f4008b);
        }
        return r.a(str, f.a(mVar));
    }

    public final /* bridge */ /* synthetic */ void a(Object obj) {
        this.f3963a.a((String) obj);
    }
}
