package com.userexperior.a.a.b;

import com.userexperior.a.a.b.a.t;
import com.userexperior.a.a.d.c;
import com.userexperior.a.a.l;
import java.io.IOException;
import java.io.Writer;

public final class q {
    /* JADX INFO: used method not loaded: com.userexperior.a.a.m.<init>(java.lang.Throwable):null, types can be incorrect */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0016, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001c, code lost:
        throw new com.userexperior.a.a.m((java.lang.Throwable) r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x001d, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0023, code lost:
        throw new com.userexperior.a.a.s((java.lang.Throwable) r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0024, code lost:
        r2 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0025, code lost:
        r0 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x002a, code lost:
        return com.userexperior.a.a.n.f3758a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0030, code lost:
        throw new com.userexperior.a.a.s((java.lang.Throwable) r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x000f, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0015, code lost:
        throw new com.userexperior.a.a.s((java.lang.Throwable) r2);
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x0016 A[ExcHandler: IOException (r2v5 'e' java.io.IOException A[CUSTOM_DECLARE]), Splitter:B:0:0x0000] */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x001d A[ExcHandler: d (r2v4 'e' com.userexperior.a.a.d.d A[CUSTOM_DECLARE]), Splitter:B:0:0x0000] */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0028  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x002b  */
    /* JADX WARNING: Removed duplicated region for block: B:7:0x000f A[ExcHandler: NumberFormatException (r2v6 'e' java.lang.NumberFormatException A[CUSTOM_DECLARE]), Splitter:B:0:0x0000] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.userexperior.a.a.l a(com.userexperior.a.a.d.a r2) throws com.userexperior.a.a.p {
        /*
            r2.f()     // Catch:{ EOFException -> 0x0024, d -> 0x001d, IOException -> 0x0016, NumberFormatException -> 0x000f }
            r0 = 0
            com.userexperior.a.a.u<com.userexperior.a.a.l> r1 = com.userexperior.a.a.b.a.t.X     // Catch:{ EOFException -> 0x000d, d -> 0x001d, IOException -> 0x0016, NumberFormatException -> 0x000f }
            java.lang.Object r2 = r1.a(r2)     // Catch:{ EOFException -> 0x000d, d -> 0x001d, IOException -> 0x0016, NumberFormatException -> 0x000f }
            com.userexperior.a.a.l r2 = (com.userexperior.a.a.l) r2     // Catch:{ EOFException -> 0x000d, d -> 0x001d, IOException -> 0x0016, NumberFormatException -> 0x000f }
            return r2
        L_0x000d:
            r2 = move-exception
            goto L_0x0026
        L_0x000f:
            r2 = move-exception
            com.userexperior.a.a.s r0 = new com.userexperior.a.a.s
            r0.<init>(r2)
            throw r0
        L_0x0016:
            r2 = move-exception
            com.userexperior.a.a.m r0 = new com.userexperior.a.a.m
            r0.<init>(r2)
            throw r0
        L_0x001d:
            r2 = move-exception
            com.userexperior.a.a.s r0 = new com.userexperior.a.a.s
            r0.<init>(r2)
            throw r0
        L_0x0024:
            r2 = move-exception
            r0 = 1
        L_0x0026:
            if (r0 == 0) goto L_0x002b
            com.userexperior.a.a.n r2 = com.userexperior.a.a.n.f3758a
            return r2
        L_0x002b:
            com.userexperior.a.a.s r0 = new com.userexperior.a.a.s
            r0.<init>(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.userexperior.a.a.b.q.a(com.userexperior.a.a.d.a):com.userexperior.a.a.l");
    }

    public static Writer a(Appendable appendable) {
        return appendable instanceof Writer ? (Writer) appendable : new r(appendable);
    }

    public static void a(l lVar, c cVar) throws IOException {
        t.X.a(cVar, lVar);
    }
}
