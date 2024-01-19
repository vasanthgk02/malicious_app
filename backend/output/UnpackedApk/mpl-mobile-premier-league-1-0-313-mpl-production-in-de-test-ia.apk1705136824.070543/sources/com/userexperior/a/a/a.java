package com.userexperior.a.a;

import java.lang.reflect.Type;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public final class a implements k<Date>, r<Date> {

    /* renamed from: a  reason: collision with root package name */
    public final DateFormat f3566a;

    /* renamed from: b  reason: collision with root package name */
    public final DateFormat f3567b;

    public a() {
        this(DateFormat.getDateTimeInstance(2, 2, Locale.US), DateFormat.getDateTimeInstance(2, 2));
    }

    public a(int i, int i2) {
        this(DateFormat.getDateTimeInstance(i, i2, Locale.US), DateFormat.getDateTimeInstance(i, i2));
    }

    public a(String str) {
        this((DateFormat) new SimpleDateFormat(str, Locale.US), (DateFormat) new SimpleDateFormat(str));
    }

    public a(DateFormat dateFormat, DateFormat dateFormat2) {
        this.f3566a = dateFormat;
        this.f3567b = dateFormat2;
    }

    /* access modifiers changed from: private */
    public l a(Date date) {
        q qVar;
        synchronized (this.f3567b) {
            qVar = new q(this.f3566a.format(date));
        }
        return qVar;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(5:13|14|15|16|17) */
    /* JADX WARNING: Can't wrap try/catch for region: R(5:8|9|10|11|12) */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001c, code lost:
        return r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:?, code lost:
        r5 = com.userexperior.a.a.b.a.a.a.a(r5.b(), new java.text.ParsePosition(0));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x002c, code lost:
        return r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x002d, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0037, code lost:
        throw new com.userexperior.a.a.s(r5.b(), r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:?, code lost:
        r5 = r4.f3566a.parse(r5.b());
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x001d */
    /* JADX WARNING: Missing exception handler attribute for start block: B:8:0x0011 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.util.Date a(com.userexperior.a.a.l r5) {
        /*
            r4 = this;
            java.text.DateFormat r0 = r4.f3567b
            monitor-enter(r0)
            java.text.DateFormat r1 = r4.f3567b     // Catch:{ ParseException -> 0x0011 }
            java.lang.String r2 = r5.b()     // Catch:{ ParseException -> 0x0011 }
            java.util.Date r5 = r1.parse(r2)     // Catch:{ ParseException -> 0x0011 }
            monitor-exit(r0)     // Catch:{ all -> 0x000f }
            return r5
        L_0x000f:
            r5 = move-exception
            goto L_0x0038
        L_0x0011:
            java.text.DateFormat r1 = r4.f3566a     // Catch:{ ParseException -> 0x001d }
            java.lang.String r2 = r5.b()     // Catch:{ ParseException -> 0x001d }
            java.util.Date r5 = r1.parse(r2)     // Catch:{ ParseException -> 0x001d }
            monitor-exit(r0)     // Catch:{ all -> 0x000f }
            return r5
        L_0x001d:
            java.lang.String r1 = r5.b()     // Catch:{ ParseException -> 0x002d }
            java.text.ParsePosition r2 = new java.text.ParsePosition     // Catch:{ ParseException -> 0x002d }
            r3 = 0
            r2.<init>(r3)     // Catch:{ ParseException -> 0x002d }
            java.util.Date r5 = com.userexperior.a.a.b.a.a.a.a(r1, r2)     // Catch:{ ParseException -> 0x002d }
            monitor-exit(r0)     // Catch:{ all -> 0x000f }
            return r5
        L_0x002d:
            r1 = move-exception
            com.userexperior.a.a.s r2 = new com.userexperior.a.a.s     // Catch:{ all -> 0x000f }
            java.lang.String r5 = r5.b()     // Catch:{ all -> 0x000f }
            r2.<init>(r5, r1)     // Catch:{ all -> 0x000f }
            throw r2     // Catch:{ all -> 0x000f }
        L_0x0038:
            monitor-exit(r0)     // Catch:{ all -> 0x000f }
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.userexperior.a.a.a.a(com.userexperior.a.a.l):java.util.Date");
    }

    public final /* synthetic */ Object a(l lVar, Type type) throws p {
        if (lVar instanceof q) {
            Date a2 = a(lVar);
            if (type == Date.class) {
                return a2;
            }
            if (type == Timestamp.class) {
                return new Timestamp(a2.getTime());
            }
            if (type == java.sql.Date.class) {
                return new java.sql.Date(a2.getTime());
            }
            throw new IllegalArgumentException(a.class + " cannot deserialize to " + type);
        }
        throw new p((String) "The date should be a string value");
    }

    public final String toString() {
        return a.class.getSimpleName() + '(' + this.f3567b.getClass().getSimpleName() + ')';
    }
}
