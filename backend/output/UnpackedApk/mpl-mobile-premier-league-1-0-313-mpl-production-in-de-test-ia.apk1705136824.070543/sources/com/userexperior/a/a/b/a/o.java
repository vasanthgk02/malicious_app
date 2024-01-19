package com.userexperior.a.a.b.a;

import com.userexperior.a.a.c.a;
import com.userexperior.a.a.d.b;
import com.userexperior.a.a.d.c;
import com.userexperior.a.a.f;
import com.userexperior.a.a.s;
import com.userexperior.a.a.u;
import com.userexperior.a.a.v;
import java.io.IOException;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public final class o extends u<Time> {

    /* renamed from: a  reason: collision with root package name */
    public static final v f3609a = new v() {
        public final <T> u<T> a(f fVar, a<T> aVar) {
            if (aVar.f3725a == Time.class) {
                return new o();
            }
            return null;
        }
    };

    /* renamed from: b  reason: collision with root package name */
    public final DateFormat f3610b = new SimpleDateFormat("hh:mm:ss a");

    /* access modifiers changed from: private */
    public synchronized void a(c cVar, Time time) throws IOException {
        cVar.b(time == null ? null : this.f3610b.format(time));
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public synchronized Time a(com.userexperior.a.a.d.a aVar) throws IOException {
        if (aVar.f() == b.NULL) {
            aVar.k();
            return null;
        }
        try {
            return new Time(this.f3610b.parse(aVar.i()).getTime());
        } catch (ParseException e2) {
            throw new s((Throwable) e2);
        }
    }
}
