package com.userexperior.e;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import com.crimzoncode.tqcontests.util.TQConstants;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;
import java.util.Map.Entry;
import org.apache.fontbox.cmap.CMap;

public abstract class o<T> implements Comparable<o<T>> {
    public static long q;

    /* renamed from: a  reason: collision with root package name */
    public final aa f4012a;

    /* renamed from: b  reason: collision with root package name */
    public String f4013b;

    /* renamed from: c  reason: collision with root package name */
    public final s f4014c;

    /* renamed from: d  reason: collision with root package name */
    public long f4015d;

    /* renamed from: e  reason: collision with root package name */
    public Map<String, String> f4016e;

    /* renamed from: f  reason: collision with root package name */
    public final int f4017f;
    public final String g;
    public String h;
    public final int i;
    public Integer j;
    public q k;
    public boolean l;
    public boolean m;
    public boolean n;
    public v o;
    public c p;

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0072, code lost:
        r2 = r8.hashCode();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public o(java.lang.String r8, com.userexperior.e.s r9) {
        /*
            r7 = this;
            r7.<init>()
            boolean r0 = com.userexperior.e.aa.f3933a
            r1 = 0
            if (r0 == 0) goto L_0x000e
            com.userexperior.e.aa r0 = new com.userexperior.e.aa
            r0.<init>()
            goto L_0x000f
        L_0x000e:
            r0 = r1
        L_0x000f:
            r7.f4012a = r0
            r0 = 1
            r7.l = r0
            r2 = 0
            r7.m = r2
            r7.n = r2
            r3 = 0
            r7.f4015d = r3
            r7.p = r1
            java.util.HashMap r1 = new java.util.HashMap
            r1.<init>()
            r7.f4016e = r1
            r7.f4017f = r0
            r7.g = r8
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "Request:1:"
            r0.<init>(r1)
            r0.append(r8)
            java.lang.String r1 = ":"
            r0.append(r1)
            long r3 = java.lang.System.currentTimeMillis()
            r0.append(r3)
            r0.append(r1)
            long r3 = q
            r5 = 1
            long r5 = r5 + r3
            q = r5
            r0.append(r3)
            java.lang.String r0 = r0.toString()
            java.lang.String r0 = com.userexperior.e.h.a(r0)
            r7.f4013b = r0
            r7.f4014c = r9
            com.userexperior.e.e r9 = new com.userexperior.e.e
            r9.<init>()
            r7.o = r9
            boolean r9 = android.text.TextUtils.isEmpty(r8)
            if (r9 != 0) goto L_0x0076
            android.net.Uri r8 = android.net.Uri.parse(r8)
            if (r8 == 0) goto L_0x0076
            java.lang.String r8 = r8.getHost()
            if (r8 == 0) goto L_0x0076
            int r2 = r8.hashCode()
        L_0x0076:
            r7.i = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.userexperior.e.o.<init>(java.lang.String, com.userexperior.e.s):void");
    }

    public static y a(y yVar) {
        return yVar;
    }

    public static byte[] a(Map<String, String> map, String str) {
        StringBuilder sb = new StringBuilder();
        try {
            for (Entry next : map.entrySet()) {
                sb.append(URLEncoder.encode((String) next.getKey(), str));
                sb.append('=');
                sb.append(URLEncoder.encode((String) next.getValue(), str));
                sb.append('&');
            }
            return sb.toString().getBytes(str);
        } catch (UnsupportedEncodingException e2) {
            throw new RuntimeException("Encoding not supported: ".concat(String.valueOf(str)), e2);
        }
    }

    public abstract r<T> a(m mVar);

    public abstract void a(T t);

    public final void a(String str) {
        if (aa.f3933a) {
            this.f4012a.a(str, Thread.currentThread().getId());
            return;
        }
        if (this.f4015d == 0) {
            this.f4015d = SystemClock.elapsedRealtime();
        }
    }

    public Map<String, String> b() throws a {
        return null;
    }

    public void b(y yVar) {
        s sVar = this.f4014c;
        if (sVar != null) {
            sVar.a(yVar);
        }
    }

    public final void b(final String str) {
        q qVar = this.k;
        if (qVar != null) {
            qVar.b(this);
        }
        if (aa.f3933a) {
            final long id = Thread.currentThread().getId();
            if (Looper.myLooper() != Looper.getMainLooper()) {
                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    public final void run() {
                        o.this.f4012a.a(str, id);
                        o.this.f4012a.a(toString());
                    }
                });
                return;
            }
            this.f4012a.a(str, id);
            this.f4012a.a(toString());
            return;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime() - this.f4015d;
        if (elapsedRealtime >= TQConstants.COUNTDOWN_DURATION) {
            z.b("%d ms: %s", Long.valueOf(elapsedRealtime), toString());
        }
    }

    public final String c() {
        String str = this.h;
        return str != null ? str : this.g;
    }

    public /* synthetic */ int compareTo(Object obj) {
        o oVar = (o) obj;
        p pVar = p.NORMAL;
        if (pVar == pVar) {
            return this.j.intValue() - oVar.j.intValue();
        }
        return 0;
    }

    public Map<String, String> d() throws a {
        return this.f4016e;
    }

    @Deprecated
    public final byte[] e() throws a {
        Map<String, String> b2 = b();
        if (b2 == null || b2.size() <= 0) {
            return null;
        }
        return a(b2, "UTF-8");
    }

    public String f() {
        return "application/x-www-form-urlencoded; charset=UTF-8";
    }

    public byte[] g() throws a {
        Map<String, String> b2 = b();
        if (b2 == null || b2.size() <= 0) {
            return null;
        }
        return a(b2, "UTF-8");
    }

    public final int h() {
        return this.o.a();
    }

    public String toString() {
        String str = "0x" + Integer.toHexString(this.i);
        StringBuilder sb = new StringBuilder();
        sb.append(this.m ? "[X] " : "[ ] ");
        sb.append(c());
        sb.append(CMap.SPACE);
        sb.append(str);
        sb.append(CMap.SPACE);
        sb.append(p.NORMAL);
        sb.append(CMap.SPACE);
        sb.append(this.j);
        return sb.toString();
    }
}
