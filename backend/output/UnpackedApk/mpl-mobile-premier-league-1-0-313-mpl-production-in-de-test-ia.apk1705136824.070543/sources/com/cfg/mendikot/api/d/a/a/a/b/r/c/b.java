package com.cfg.mendikot.api.d.a.a.a.b.r.c;

import com.cfg.mendikot.api.d.a.a.a.b.g;
import com.cfg.mendikot.api.d.a.a.a.b.h;
import com.cfg.mendikot.api.d.a.a.a.b.r.a;
import com.cfg.mendikot.api.d.a.a.a.b.w.d;

public class b extends a<g> {
    public final h g = a.f2280b;
    public final d h = new d(128);

    public b(com.cfg.mendikot.api.d.a.a.a.b.s.d dVar) {
        super(dVar, null, com.cfg.mendikot.api.d.a.a.a.b.q.a.f2277c);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:32|33|34) */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00b2, code lost:
        throw new com.cfg.mendikot.api.d.a.a.a.b.l("Status line contains invalid status code: " + r2.a(r4, r5));
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:32:0x009a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.cfg.mendikot.api.d.a.a.a.b.f a(com.cfg.mendikot.api.d.a.a.a.b.s.d r10) {
        /*
            r9 = this;
            com.cfg.mendikot.api.d.a.a.a.b.w.d r0 = r9.h
            r1 = 0
            r0.f2318b = r1
            int r10 = r10.a(r0)
            r0 = -1
            if (r10 == r0) goto L_0x00cb
            com.cfg.mendikot.api.d.a.a.a.b.t.j r10 = new com.cfg.mendikot.api.d.a.a.a.b.t.j
            com.cfg.mendikot.api.d.a.a.a.b.w.d r0 = r9.h
            int r0 = r0.f2318b
            r10.<init>(r1, r0)
            com.cfg.mendikot.api.d.a.a.a.b.t.i r0 = r9.f2287d
            com.cfg.mendikot.api.d.a.a.a.b.w.d r2 = r9.h
            com.cfg.mendikot.api.d.a.a.a.b.t.d r0 = (com.cfg.mendikot.api.d.a.a.a.b.t.d) r0
            r3 = 0
            if (r0 == 0) goto L_0x00ca
            java.lang.String r4 = "Char array buffer"
            co.hyperverge.hypersnapsdk.c.k.a(r2, r4)
            java.lang.String r4 = "Parser cursor"
            co.hyperverge.hypersnapsdk.c.k.a(r10, r4)
            int r4 = r10.f2314c
            int r5 = r10.f2313b
            com.cfg.mendikot.api.d.a.a.a.b.n r6 = r0.b(r2, r10)     // Catch:{ IndexOutOfBoundsException -> 0x00b3 }
            r0.c(r2, r10)     // Catch:{ IndexOutOfBoundsException -> 0x00b3 }
            int r10 = r10.f2314c     // Catch:{ IndexOutOfBoundsException -> 0x00b3 }
            r0 = 32
            int r0 = r2.a(r0, r10, r5)     // Catch:{ IndexOutOfBoundsException -> 0x00b3 }
            if (r0 >= 0) goto L_0x003e
            r0 = r5
        L_0x003e:
            java.lang.String r10 = r2.b(r10, r0)     // Catch:{ IndexOutOfBoundsException -> 0x00b3 }
        L_0x0042:
            int r7 = r10.length()     // Catch:{ IndexOutOfBoundsException -> 0x00b3 }
            java.lang.String r8 = "Status line contains invalid status code: "
            if (r1 >= r7) goto L_0x0070
            char r7 = r10.charAt(r1)     // Catch:{ IndexOutOfBoundsException -> 0x00b3 }
            boolean r7 = java.lang.Character.isDigit(r7)     // Catch:{ IndexOutOfBoundsException -> 0x00b3 }
            if (r7 == 0) goto L_0x0057
            int r1 = r1 + 1
            goto L_0x0042
        L_0x0057:
            com.cfg.mendikot.api.d.a.a.a.b.l r10 = new com.cfg.mendikot.api.d.a.a.a.b.l     // Catch:{ IndexOutOfBoundsException -> 0x00b3 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ IndexOutOfBoundsException -> 0x00b3 }
            r0.<init>()     // Catch:{ IndexOutOfBoundsException -> 0x00b3 }
            r0.append(r8)     // Catch:{ IndexOutOfBoundsException -> 0x00b3 }
            java.lang.String r1 = r2.a(r4, r5)     // Catch:{ IndexOutOfBoundsException -> 0x00b3 }
            r0.append(r1)     // Catch:{ IndexOutOfBoundsException -> 0x00b3 }
            java.lang.String r0 = r0.toString()     // Catch:{ IndexOutOfBoundsException -> 0x00b3 }
            r10.<init>(r0)     // Catch:{ IndexOutOfBoundsException -> 0x00b3 }
            throw r10     // Catch:{ IndexOutOfBoundsException -> 0x00b3 }
        L_0x0070:
            int r10 = java.lang.Integer.parseInt(r10)     // Catch:{ NumberFormatException -> 0x009a }
            if (r0 >= r5) goto L_0x007b
            java.lang.String r0 = r2.b(r0, r5)     // Catch:{ IndexOutOfBoundsException -> 0x00b3 }
            goto L_0x007d
        L_0x007b:
            java.lang.String r0 = ""
        L_0x007d:
            com.cfg.mendikot.api.d.a.a.a.b.t.e r1 = new com.cfg.mendikot.api.d.a.a.a.b.t.e     // Catch:{ IndexOutOfBoundsException -> 0x00b3 }
            r1.<init>(r6, r10, r0)     // Catch:{ IndexOutOfBoundsException -> 0x00b3 }
            com.cfg.mendikot.api.d.a.a.a.b.h r10 = r9.g
            com.cfg.mendikot.api.d.a.a.a.b.r.a r10 = (com.cfg.mendikot.api.d.a.a.a.b.r.a) r10
            if (r10 == 0) goto L_0x0099
            java.lang.String r0 = "Status line"
            co.hyperverge.hypersnapsdk.c.k.a(r1, r0)
            com.cfg.mendikot.api.d.a.a.a.b.t.b r0 = new com.cfg.mendikot.api.d.a.a.a.b.t.b
            com.cfg.mendikot.api.d.a.a.a.b.o r10 = r10.f2281a
            java.util.Locale r2 = java.util.Locale.getDefault()
            r0.<init>(r1, r10, r2)
            return r0
        L_0x0099:
            throw r3
        L_0x009a:
            com.cfg.mendikot.api.d.a.a.a.b.l r10 = new com.cfg.mendikot.api.d.a.a.a.b.l     // Catch:{ IndexOutOfBoundsException -> 0x00b3 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ IndexOutOfBoundsException -> 0x00b3 }
            r0.<init>()     // Catch:{ IndexOutOfBoundsException -> 0x00b3 }
            r0.append(r8)     // Catch:{ IndexOutOfBoundsException -> 0x00b3 }
            java.lang.String r1 = r2.a(r4, r5)     // Catch:{ IndexOutOfBoundsException -> 0x00b3 }
            r0.append(r1)     // Catch:{ IndexOutOfBoundsException -> 0x00b3 }
            java.lang.String r0 = r0.toString()     // Catch:{ IndexOutOfBoundsException -> 0x00b3 }
            r10.<init>(r0)     // Catch:{ IndexOutOfBoundsException -> 0x00b3 }
            throw r10     // Catch:{ IndexOutOfBoundsException -> 0x00b3 }
        L_0x00b3:
            com.cfg.mendikot.api.d.a.a.a.b.l r10 = new com.cfg.mendikot.api.d.a.a.a.b.l
            java.lang.String r0 = "Invalid status line: "
            java.lang.StringBuilder r0 = com.android.tools.r8.GeneratedOutlineSupport.outline73(r0)
            java.lang.String r1 = r2.a(r4, r5)
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r10.<init>(r0)
            throw r10
        L_0x00ca:
            throw r3
        L_0x00cb:
            com.cfg.mendikot.api.d.a.a.a.b.k r10 = new com.cfg.mendikot.api.d.a.a.a.b.k
            java.lang.String r0 = "The target server failed to respond"
            r10.<init>(r0)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cfg.mendikot.api.d.a.a.a.b.r.c.b.a(com.cfg.mendikot.api.d.a.a.a.b.s.d):com.cfg.mendikot.api.d.a.a.a.b.f");
    }
}
