package com.userexperior.a.a.b.a;

import com.userexperior.a.a.c.a;
import com.userexperior.a.a.d.b;
import com.userexperior.a.a.d.c;
import com.userexperior.a.a.f;
import com.userexperior.a.a.u;
import com.userexperior.a.a.v;
import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

public final class d extends u<Date> {

    /* renamed from: a  reason: collision with root package name */
    public static final v f3575a = new v() {
        public final <T> u<T> a(f fVar, a<T> aVar) {
            if (aVar.f3725a == Date.class) {
                return new d();
            }
            return null;
        }
    };

    /* renamed from: b  reason: collision with root package name */
    public final DateFormat f3576b = DateFormat.getDateTimeInstance(2, 2, Locale.US);

    /* renamed from: c  reason: collision with root package name */
    public final DateFormat f3577c = DateFormat.getDateTimeInstance(2, 2);

    /* JADX WARNING: Can't wrap try/catch for region: R(4:6|7|8|9) */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x001e, code lost:
        return com.userexperior.a.a.b.a.a.a.a(r3, new java.text.ParsePosition(0));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x001f, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0025, code lost:
        throw new com.userexperior.a.a.s(r3, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0012, code lost:
        return r2.f3576b.parse(r3);
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:10:0x0013 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:6:0x000b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized java.util.Date a(java.lang.String r3) {
        /*
            r2 = this;
            monitor-enter(r2)
            java.text.DateFormat r0 = r2.f3577c     // Catch:{ ParseException -> 0x000b }
            java.util.Date r3 = r0.parse(r3)     // Catch:{ ParseException -> 0x000b }
            monitor-exit(r2)
            return r3
        L_0x0009:
            r3 = move-exception
            goto L_0x0026
        L_0x000b:
            java.text.DateFormat r0 = r2.f3576b     // Catch:{ ParseException -> 0x0013 }
            java.util.Date r3 = r0.parse(r3)     // Catch:{ ParseException -> 0x0013 }
            monitor-exit(r2)
            return r3
        L_0x0013:
            java.text.ParsePosition r0 = new java.text.ParsePosition     // Catch:{ ParseException -> 0x001f }
            r1 = 0
            r0.<init>(r1)     // Catch:{ ParseException -> 0x001f }
            java.util.Date r3 = com.userexperior.a.a.b.a.a.a.a(r3, r0)     // Catch:{ ParseException -> 0x001f }
            monitor-exit(r2)
            return r3
        L_0x001f:
            r0 = move-exception
            com.userexperior.a.a.s r1 = new com.userexperior.a.a.s     // Catch:{ all -> 0x0009 }
            r1.<init>(r3, r0)     // Catch:{ all -> 0x0009 }
            throw r1     // Catch:{ all -> 0x0009 }
        L_0x0026:
            monitor-exit(r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.userexperior.a.a.b.a.d.a(java.lang.String):java.util.Date");
    }

    /* access modifiers changed from: private */
    public synchronized void a(c cVar, Date date) throws IOException {
        if (date == null) {
            cVar.e();
        } else {
            cVar.b(this.f3576b.format(date));
        }
    }

    public final /* synthetic */ Object a(com.userexperior.a.a.d.a aVar) throws IOException {
        if (aVar.f() != b.NULL) {
            return a(aVar.i());
        }
        aVar.k();
        return null;
    }
}
