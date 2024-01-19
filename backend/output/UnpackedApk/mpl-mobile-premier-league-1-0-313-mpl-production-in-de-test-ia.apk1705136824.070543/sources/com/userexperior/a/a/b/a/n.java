package com.userexperior.a.a.b.a;

import com.userexperior.a.a.c.a;
import com.userexperior.a.a.d.b;
import com.userexperior.a.a.d.c;
import com.userexperior.a.a.f;
import com.userexperior.a.a.s;
import com.userexperior.a.a.u;
import com.userexperior.a.a.v;
import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public final class n extends u<Date> {

    /* renamed from: a  reason: collision with root package name */
    public static final v f3607a = new v() {
        public final <T> u<T> a(f fVar, a<T> aVar) {
            if (aVar.f3725a == Date.class) {
                return new n();
            }
            return null;
        }
    };

    /* renamed from: b  reason: collision with root package name */
    public final DateFormat f3608b = new SimpleDateFormat("MMM d, yyyy");

    /* access modifiers changed from: private */
    public synchronized void a(c cVar, Date date) throws IOException {
        cVar.b(date == null ? null : this.f3608b.format(date));
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public synchronized Date a(com.userexperior.a.a.d.a aVar) throws IOException {
        if (aVar.f() == b.NULL) {
            aVar.k();
            return null;
        }
        try {
            return new Date(this.f3608b.parse(aVar.i()).getTime());
        } catch (ParseException e2) {
            throw new s((Throwable) e2);
        }
    }
}
