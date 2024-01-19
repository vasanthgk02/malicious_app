package com.cfg.mendikot.api.d.a.a.a.b.r.c;

import co.hyperverge.hypersnapsdk.c.k;
import com.cfg.mendikot.api.d.a.a.a.b.f;
import com.cfg.mendikot.api.d.a.a.a.b.s.d;
import com.cfg.mendikot.api.d.a.a.a.b.t.i;
import java.util.ArrayList;
import java.util.List;

public abstract class a<T extends f> {

    /* renamed from: a  reason: collision with root package name */
    public final d f2284a;

    /* renamed from: b  reason: collision with root package name */
    public final com.cfg.mendikot.api.d.a.a.a.b.q.a f2285b;

    /* renamed from: c  reason: collision with root package name */
    public final List<com.cfg.mendikot.api.d.a.a.a.b.w.d> f2286c;

    /* renamed from: d  reason: collision with root package name */
    public final i f2287d;

    /* renamed from: e  reason: collision with root package name */
    public int f2288e;

    /* renamed from: f  reason: collision with root package name */
    public T f2289f;

    public a(d dVar, i iVar, com.cfg.mendikot.api.d.a.a.a.b.q.a aVar) {
        k.a(dVar, (String) "Session input buffer");
        this.f2284a = dVar;
        this.f2287d = iVar == null ? com.cfg.mendikot.api.d.a.a.a.b.t.d.f2302b : iVar;
        this.f2285b = aVar == null ? com.cfg.mendikot.api.d.a.a.a.b.q.a.f2277c : aVar;
        this.f2286c = new ArrayList();
        this.f2288e = 0;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:58:0x00f1, code lost:
        if (r1 >= r5.size()) goto L_0x010e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:?, code lost:
        r0[r1] = new com.cfg.mendikot.api.d.a.a.a.b.t.f(r5.get(r1));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x0100, code lost:
        r1 = r1 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x0103, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x010d, code lost:
        throw new com.cfg.mendikot.api.d.a.a.a.b.m(r0.getMessage());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x010e, code lost:
        r14.f2289f.a(r0);
        r0 = r14.f2289f;
        r14.f2289f = null;
        r14.f2286c.clear();
        r14.f2288e = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x011e, code lost:
        return r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public T a() {
        /*
            r14 = this;
            int r0 = r14.f2288e
            r1 = 1
            if (r0 == 0) goto L_0x0010
            if (r0 != r1) goto L_0x0008
            goto L_0x001a
        L_0x0008:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "Inconsistent parser state"
            r0.<init>(r1)
            throw r0
        L_0x0010:
            com.cfg.mendikot.api.d.a.a.a.b.s.d r0 = r14.f2284a     // Catch:{ l -> 0x011f }
            com.cfg.mendikot.api.d.a.a.a.b.f r0 = r14.a(r0)     // Catch:{ l -> 0x011f }
            r14.f2289f = r0     // Catch:{ l -> 0x011f }
            r14.f2288e = r1
        L_0x001a:
            com.cfg.mendikot.api.d.a.a.a.b.s.d r0 = r14.f2284a
            com.cfg.mendikot.api.d.a.a.a.b.q.a r2 = r14.f2285b
            int r3 = r2.f2279b
            int r2 = r2.f2278a
            com.cfg.mendikot.api.d.a.a.a.b.t.i r4 = r14.f2287d
            java.util.List<com.cfg.mendikot.api.d.a.a.a.b.w.d> r5 = r14.f2286c
            java.lang.String r6 = "Session input buffer"
            co.hyperverge.hypersnapsdk.c.k.a(r0, r6)
            java.lang.String r6 = "Line parser"
            co.hyperverge.hypersnapsdk.c.k.a(r4, r6)
            java.lang.String r4 = "Header line list"
            co.hyperverge.hypersnapsdk.c.k.a(r5, r4)
            r4 = 0
            r6 = r4
            r7 = r6
        L_0x0038:
            r8 = 0
            if (r6 != 0) goto L_0x0043
            com.cfg.mendikot.api.d.a.a.a.b.w.d r6 = new com.cfg.mendikot.api.d.a.a.a.b.w.d
            r9 = 64
            r6.<init>(r9)
            goto L_0x0045
        L_0x0043:
            r6.f2318b = r8
        L_0x0045:
            int r9 = r0.a(r6)
            r10 = -1
            if (r9 == r10) goto L_0x00e6
            int r9 = r6.f2318b
            if (r9 >= r1) goto L_0x0052
            goto L_0x00e6
        L_0x0052:
            char[] r9 = r6.f2317a
            char r10 = r9[r8]
            r11 = 9
            r12 = 32
            if (r10 == r12) goto L_0x0060
            char r9 = r9[r8]
            if (r9 != r11) goto L_0x00cf
        L_0x0060:
            if (r7 == 0) goto L_0x00cf
        L_0x0062:
            int r9 = r6.f2318b
            if (r8 >= r9) goto L_0x0072
            char[] r9 = r6.f2317a
            char r9 = r9[r8]
            if (r9 == r12) goto L_0x006f
            if (r9 == r11) goto L_0x006f
            goto L_0x0072
        L_0x006f:
            int r8 = r8 + 1
            goto L_0x0062
        L_0x0072:
            if (r2 <= 0) goto L_0x0086
            int r9 = r7.f2318b
            int r9 = r9 + r1
            int r10 = r6.f2318b
            int r9 = r9 + r10
            int r9 = r9 - r8
            if (r9 > r2) goto L_0x007e
            goto L_0x0086
        L_0x007e:
            com.cfg.mendikot.api.d.a.a.a.b.j r0 = new com.cfg.mendikot.api.d.a.a.a.b.j
            java.lang.String r1 = "Maximum line length limit exceeded"
            r0.<init>(r1)
            throw r0
        L_0x0086:
            r7.a(r12)
            int r9 = r6.f2318b
            int r9 = r9 - r8
            char[] r10 = r6.f2317a
            if (r10 != 0) goto L_0x0091
            goto L_0x00d4
        L_0x0091:
            if (r8 < 0) goto L_0x00b7
            int r11 = r10.length
            if (r8 > r11) goto L_0x00b7
            if (r9 < 0) goto L_0x00b7
            int r11 = r8 + r9
            if (r11 < 0) goto L_0x00b7
            int r12 = r10.length
            if (r11 > r12) goto L_0x00b7
            if (r9 != 0) goto L_0x00a2
            goto L_0x00d4
        L_0x00a2:
            int r11 = r7.f2318b
            int r11 = r11 + r9
            char[] r12 = r7.f2317a
            int r12 = r12.length
            if (r11 <= r12) goto L_0x00ad
            r7.c(r11)
        L_0x00ad:
            char[] r12 = r7.f2317a
            int r13 = r7.f2318b
            java.lang.System.arraycopy(r10, r8, r12, r13, r9)
            r7.f2318b = r11
            goto L_0x00d4
        L_0x00b7:
            java.lang.IndexOutOfBoundsException r0 = new java.lang.IndexOutOfBoundsException
            java.lang.String r1 = "off: "
            java.lang.String r2 = " len: "
            java.lang.String r3 = " b.length: "
            java.lang.StringBuilder r1 = com.android.tools.r8.GeneratedOutlineSupport.outline75(r1, r8, r2, r9, r3)
            int r2 = r10.length
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x00cf:
            r5.add(r6)
            r7 = r6
            r6 = r4
        L_0x00d4:
            if (r3 <= 0) goto L_0x0038
            int r8 = r5.size()
            if (r8 >= r3) goto L_0x00de
            goto L_0x0038
        L_0x00de:
            com.cfg.mendikot.api.d.a.a.a.b.j r0 = new com.cfg.mendikot.api.d.a.a.a.b.j
            java.lang.String r1 = "Maximum header count exceeded"
            r0.<init>(r1)
            throw r0
        L_0x00e6:
            int r0 = r5.size()
            com.cfg.mendikot.api.d.a.a.a.b.c[] r0 = new com.cfg.mendikot.api.d.a.a.a.b.c[r0]
            r1 = 0
        L_0x00ed:
            int r2 = r5.size()
            if (r1 >= r2) goto L_0x010e
            java.lang.Object r2 = r5.get(r1)
            com.cfg.mendikot.api.d.a.a.a.b.w.d r2 = (com.cfg.mendikot.api.d.a.a.a.b.w.d) r2
            com.cfg.mendikot.api.d.a.a.a.b.t.f r3 = new com.cfg.mendikot.api.d.a.a.a.b.t.f     // Catch:{ l -> 0x0103 }
            r3.<init>(r2)     // Catch:{ l -> 0x0103 }
            r0[r1] = r3     // Catch:{ l -> 0x0103 }
            int r1 = r1 + 1
            goto L_0x00ed
        L_0x0103:
            r0 = move-exception
            com.cfg.mendikot.api.d.a.a.a.b.m r1 = new com.cfg.mendikot.api.d.a.a.a.b.m
            java.lang.String r0 = r0.getMessage()
            r1.<init>(r0)
            throw r1
        L_0x010e:
            T r1 = r14.f2289f
            r1.a(r0)
            T r0 = r14.f2289f
            r14.f2289f = r4
            java.util.List<com.cfg.mendikot.api.d.a.a.a.b.w.d> r1 = r14.f2286c
            r1.clear()
            r14.f2288e = r8
            return r0
        L_0x011f:
            r0 = move-exception
            com.cfg.mendikot.api.d.a.a.a.b.m r1 = new com.cfg.mendikot.api.d.a.a.a.b.m
            java.lang.String r2 = r0.getMessage()
            r1.<init>(r2, r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cfg.mendikot.api.d.a.a.a.b.r.c.a.a():com.cfg.mendikot.api.d.a.a.a.b.f");
    }

    public abstract T a(d dVar);
}
