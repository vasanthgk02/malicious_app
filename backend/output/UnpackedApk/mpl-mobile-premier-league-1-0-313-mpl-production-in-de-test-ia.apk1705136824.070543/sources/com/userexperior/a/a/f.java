package com.userexperior.a.a;

import com.google.gson.Gson;
import com.userexperior.a.a.b.a.d;
import com.userexperior.a.a.b.a.e;
import com.userexperior.a.a.b.a.h;
import com.userexperior.a.a.b.a.j;
import com.userexperior.a.a.b.a.k;
import com.userexperior.a.a.b.a.n;
import com.userexperior.a.a.b.a.o;
import com.userexperior.a.a.b.a.t;
import com.userexperior.a.a.b.g;
import com.userexperior.a.a.b.p;
import com.userexperior.a.a.b.q;
import com.userexperior.a.a.c.a;
import com.userexperior.a.a.d.b;
import com.userexperior.a.a.d.c;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicLongArray;

public final class f {

    /* renamed from: a  reason: collision with root package name */
    public static final a<?> f3740a = new a<Object>() {
    };

    /* renamed from: b  reason: collision with root package name */
    public final ThreadLocal<Map<a<?>, g<?>>> f3741b;

    /* renamed from: c  reason: collision with root package name */
    public final Map<a<?>, u<?>> f3742c;

    /* renamed from: d  reason: collision with root package name */
    public final List<v> f3743d;

    /* renamed from: e  reason: collision with root package name */
    public final com.userexperior.a.a.b.f f3744e;

    /* renamed from: f  reason: collision with root package name */
    public final g f3745f;
    public final e g;
    public final boolean h;
    public final boolean i;
    public final boolean j;
    public final boolean k;
    public final boolean l;
    public final e m;

    public f() {
        this(g.f3680a, d.IDENTITY, Collections.emptyMap(), false, false, false, true, false, false, false, t.DEFAULT, Collections.emptyList());
    }

    public f(g gVar, e eVar, Map<Type, i<?>> map, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, t tVar, List<v> list) {
        this.f3741b = new ThreadLocal<>();
        this.f3742c = new ConcurrentHashMap();
        this.f3744e = new com.userexperior.a.a.b.f(map);
        this.f3745f = gVar;
        this.g = eVar;
        this.h = z;
        this.j = z3;
        this.i = z4;
        this.k = z5;
        this.l = z6;
        ArrayList arrayList = new ArrayList();
        arrayList.add(t.Y);
        arrayList.add(j.f3592a);
        arrayList.add(gVar);
        arrayList.addAll(list);
        arrayList.add(t.D);
        arrayList.add(t.m);
        arrayList.add(t.g);
        arrayList.add(t.i);
        arrayList.add(t.k);
        final u r5 = tVar == t.DEFAULT ? t.t : new u<Number>() {
            public final /* synthetic */ Object a(com.userexperior.a.a.d.a aVar) throws IOException {
                if (aVar.f() != b.NULL) {
                    return Long.valueOf(aVar.m());
                }
                aVar.k();
                return null;
            }

            public final /* synthetic */ void a(c cVar, Object obj) throws IOException {
                Number number = (Number) obj;
                if (number == null) {
                    cVar.e();
                } else {
                    cVar.b(number.toString());
                }
            }
        };
        arrayList.add(t.a(Long.TYPE, Long.class, r5));
        arrayList.add(t.a(Double.TYPE, Double.class, z7 ? t.v : new u<Number>() {
            public final /* synthetic */ Object a(com.userexperior.a.a.d.a aVar) throws IOException {
                if (aVar.f() != b.NULL) {
                    return Double.valueOf(aVar.l());
                }
                aVar.k();
                return null;
            }

            public final /* synthetic */ void a(c cVar, Object obj) throws IOException {
                Number number = (Number) obj;
                if (number == null) {
                    cVar.e();
                    return;
                }
                f.a(number.doubleValue());
                cVar.a(number);
            }
        }));
        arrayList.add(t.a(Float.TYPE, Float.class, z7 ? t.u : new u<Number>() {
            public final /* synthetic */ Object a(com.userexperior.a.a.d.a aVar) throws IOException {
                if (aVar.f() != b.NULL) {
                    return Float.valueOf((float) aVar.l());
                }
                aVar.k();
                return null;
            }

            public final /* synthetic */ void a(c cVar, Object obj) throws IOException {
                Number number = (Number) obj;
                if (number == null) {
                    cVar.e();
                    return;
                }
                f.a((double) number.floatValue());
                cVar.a(number);
            }
        }));
        arrayList.add(t.x);
        arrayList.add(t.o);
        arrayList.add(t.q);
        arrayList.add(t.a(AtomicLong.class, new u<AtomicLong>() {
            public final /* synthetic */ Object a(com.userexperior.a.a.d.a aVar) throws IOException {
                return new AtomicLong(((Number) u.this.a(aVar)).longValue());
            }

            public final /* synthetic */ void a(c cVar, Object obj) throws IOException {
                u.this.a(cVar, Long.valueOf(((AtomicLong) obj).get()));
            }
        }.a()));
        arrayList.add(t.a(AtomicLongArray.class, new u<AtomicLongArray>() {
            public final /* synthetic */ Object a(com.userexperior.a.a.d.a aVar) throws IOException {
                ArrayList arrayList = new ArrayList();
                aVar.a();
                while (aVar.e()) {
                    arrayList.add(Long.valueOf(((Number) u.this.a(aVar)).longValue()));
                }
                aVar.b();
                int size = arrayList.size();
                AtomicLongArray atomicLongArray = new AtomicLongArray(size);
                for (int i = 0; i < size; i++) {
                    atomicLongArray.set(i, ((Long) arrayList.get(i)).longValue());
                }
                return atomicLongArray;
            }

            public final /* synthetic */ void a(c cVar, Object obj) throws IOException {
                AtomicLongArray atomicLongArray = (AtomicLongArray) obj;
                cVar.a();
                int length = atomicLongArray.length();
                for (int i = 0; i < length; i++) {
                    u.this.a(cVar, Long.valueOf(atomicLongArray.get(i)));
                }
                cVar.b();
            }
        }.a()));
        arrayList.add(t.s);
        arrayList.add(t.z);
        arrayList.add(t.F);
        arrayList.add(t.H);
        arrayList.add(t.a(BigDecimal.class, t.B));
        arrayList.add(t.a(BigInteger.class, t.C));
        arrayList.add(t.J);
        arrayList.add(t.L);
        arrayList.add(t.P);
        arrayList.add(t.R);
        arrayList.add(t.W);
        arrayList.add(t.N);
        arrayList.add(t.f3629d);
        arrayList.add(d.f3575a);
        arrayList.add(t.U);
        arrayList.add(o.f3609a);
        arrayList.add(n.f3607a);
        arrayList.add(t.S);
        arrayList.add(com.userexperior.a.a.b.a.a.f3568a);
        arrayList.add(t.f3627b);
        arrayList.add(new com.userexperior.a.a.b.a.b(this.f3744e));
        arrayList.add(new h(this.f3744e, z2));
        e eVar2 = new e(this.f3744e);
        this.m = eVar2;
        arrayList.add(eVar2);
        arrayList.add(t.Z);
        arrayList.add(new k(this.f3744e, eVar, gVar, this.m));
        this.f3743d = Collections.unmodifiableList(arrayList);
    }

    private com.userexperior.a.a.d.a a(Reader reader) {
        com.userexperior.a.a.d.a aVar = new com.userexperior.a.a.d.a(reader);
        aVar.f3729a = this.l;
        return aVar;
    }

    private c a(Writer writer) throws IOException {
        if (this.j) {
            writer.write(Gson.JSON_NON_EXECUTABLE_PREFIX);
        }
        c cVar = new c(writer);
        if (this.k) {
            cVar.c("  ");
        }
        cVar.f3738e = this.h;
        return cVar;
    }

    private <T> T a(com.userexperior.a.a.d.a aVar, Type type) throws m, s {
        boolean z = aVar.f3729a;
        aVar.f3729a = true;
        try {
            aVar.f();
            T a2 = a(a.a(type)).a(aVar);
            aVar.f3729a = z;
            return a2;
        } catch (EOFException e2) {
            if (1 != 0) {
                aVar.f3729a = z;
                return null;
            }
            throw new s((Throwable) e2);
        } catch (IllegalStateException e3) {
            throw new s((Throwable) e3);
        } catch (IOException e4) {
            throw new s((Throwable) e4);
        } catch (Throwable th) {
            aVar.f3729a = z;
            throw th;
        }
    }

    private String a(l lVar) {
        StringWriter stringWriter = new StringWriter();
        a(lVar, (Appendable) stringWriter);
        return stringWriter.toString();
    }

    private String a(Object obj, Type type) {
        StringWriter stringWriter = new StringWriter();
        a(obj, type, (Appendable) stringWriter);
        return stringWriter.toString();
    }

    public static /* synthetic */ void a(double d2) {
        try {
            if (Double.isNaN(d2) || Double.isInfinite(d2)) {
                throw new IllegalArgumentException(d2 + " is not a valid double value as per JSON specification. To override this behavior, use GsonBuilder.serializeSpecialFloatingPointValues() method.");
            }
        } catch (Exception e2) {
            new StringBuilder("issue at cvfp: ").append(e2.getMessage());
        }
    }

    private void a(l lVar, c cVar) throws m {
        boolean z = cVar.f3736c;
        cVar.f3736c = true;
        boolean z2 = cVar.f3737d;
        cVar.f3737d = this.i;
        boolean z3 = cVar.f3738e;
        cVar.f3738e = this.h;
        try {
            q.a(lVar, cVar);
            cVar.f3736c = z;
            cVar.f3737d = z2;
            cVar.f3738e = z3;
        } catch (IOException e2) {
            throw new m((Throwable) e2);
        } catch (Throwable th) {
            cVar.f3736c = z;
            cVar.f3737d = z2;
            cVar.f3738e = z3;
            throw th;
        }
    }

    private void a(l lVar, Appendable appendable) throws m {
        try {
            a(lVar, a(q.a(appendable)));
        } catch (IOException e2) {
            throw new m((Throwable) e2);
        }
    }

    public static void a(Object obj, com.userexperior.a.a.d.a aVar) {
        if (obj != null) {
            try {
                if (aVar.f() != b.END_DOCUMENT) {
                    throw new m((String) "JSON document was not fully consumed.");
                }
            } catch (com.userexperior.a.a.d.d e2) {
                throw new s((Throwable) e2);
            } catch (IOException e3) {
                throw new m((Throwable) e3);
            }
        }
    }

    private void a(Object obj, Type type, c cVar) throws m {
        u a2 = a(a.a(type));
        boolean z = cVar.f3736c;
        cVar.f3736c = true;
        boolean z2 = cVar.f3737d;
        cVar.f3737d = this.i;
        boolean z3 = cVar.f3738e;
        cVar.f3738e = this.h;
        try {
            a2.a(cVar, obj);
            cVar.f3736c = z;
            cVar.f3737d = z2;
            cVar.f3738e = z3;
        } catch (IOException e2) {
            throw new m((Throwable) e2);
        } catch (Throwable th) {
            cVar.f3736c = z;
            cVar.f3737d = z2;
            cVar.f3738e = z3;
            throw th;
        }
    }

    private void a(Object obj, Type type, Appendable appendable) throws m {
        try {
            a(obj, type, a(q.a(appendable)));
        } catch (IOException e2) {
            throw new m((Throwable) e2);
        }
    }

    /* JADX WARNING: Incorrect type for immutable var: ssa=com.userexperior.a.a.c.a<T>, code=com.userexperior.a.a.c.a, for r6v0, types: [com.userexperior.a.a.c.a<T>, java.lang.Object, com.userexperior.a.a.c.a] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final <T> com.userexperior.a.a.u<T> a(com.userexperior.a.a.c.a r6) {
        /*
            r5 = this;
            java.util.Map<com.userexperior.a.a.c.a<?>, com.userexperior.a.a.u<?>> r0 = r5.f3742c
            if (r6 != 0) goto L_0x0007
            com.userexperior.a.a.c.a<?> r1 = f3740a
            goto L_0x0008
        L_0x0007:
            r1 = r6
        L_0x0008:
            java.lang.Object r0 = r0.get(r1)
            com.userexperior.a.a.u r0 = (com.userexperior.a.a.u) r0
            if (r0 == 0) goto L_0x0011
            return r0
        L_0x0011:
            java.lang.ThreadLocal<java.util.Map<com.userexperior.a.a.c.a<?>, com.userexperior.a.a.g<?>>> r0 = r5.f3741b
            java.lang.Object r0 = r0.get()
            java.util.Map r0 = (java.util.Map) r0
            r1 = 0
            if (r0 != 0) goto L_0x0027
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            java.lang.ThreadLocal<java.util.Map<com.userexperior.a.a.c.a<?>, com.userexperior.a.a.g<?>>> r1 = r5.f3741b
            r1.set(r0)
            r1 = 1
        L_0x0027:
            java.lang.Object r2 = r0.get(r6)
            com.userexperior.a.a.g r2 = (com.userexperior.a.a.g) r2
            if (r2 == 0) goto L_0x0030
            return r2
        L_0x0030:
            com.userexperior.a.a.g r2 = new com.userexperior.a.a.g     // Catch:{ all -> 0x007c }
            r2.<init>()     // Catch:{ all -> 0x007c }
            r0.put(r6, r2)     // Catch:{ all -> 0x007c }
            java.util.List<com.userexperior.a.a.v> r3 = r5.f3743d     // Catch:{ all -> 0x007c }
            java.util.Iterator r3 = r3.iterator()     // Catch:{ all -> 0x007c }
        L_0x003e:
            boolean r4 = r3.hasNext()     // Catch:{ all -> 0x007c }
            if (r4 == 0) goto L_0x006c
            java.lang.Object r4 = r3.next()     // Catch:{ all -> 0x007c }
            com.userexperior.a.a.v r4 = (com.userexperior.a.a.v) r4     // Catch:{ all -> 0x007c }
            com.userexperior.a.a.u r4 = r4.a(r5, r6)     // Catch:{ all -> 0x007c }
            if (r4 == 0) goto L_0x003e
            com.userexperior.a.a.u<T> r3 = r2.f3750a     // Catch:{ all -> 0x007c }
            if (r3 != 0) goto L_0x0066
            r2.f3750a = r4     // Catch:{ all -> 0x007c }
            java.util.Map<com.userexperior.a.a.c.a<?>, com.userexperior.a.a.u<?>> r2 = r5.f3742c     // Catch:{ all -> 0x007c }
            r2.put(r6, r4)     // Catch:{ all -> 0x007c }
            r0.remove(r6)
            if (r1 == 0) goto L_0x0065
            java.lang.ThreadLocal<java.util.Map<com.userexperior.a.a.c.a<?>, com.userexperior.a.a.g<?>>> r6 = r5.f3741b
            r6.remove()
        L_0x0065:
            return r4
        L_0x0066:
            java.lang.AssertionError r2 = new java.lang.AssertionError     // Catch:{ all -> 0x007c }
            r2.<init>()     // Catch:{ all -> 0x007c }
            throw r2     // Catch:{ all -> 0x007c }
        L_0x006c:
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException     // Catch:{ all -> 0x007c }
            java.lang.String r3 = "GSON cannot handle "
            java.lang.String r4 = java.lang.String.valueOf(r6)     // Catch:{ all -> 0x007c }
            java.lang.String r3 = r3.concat(r4)     // Catch:{ all -> 0x007c }
            r2.<init>(r3)     // Catch:{ all -> 0x007c }
            throw r2     // Catch:{ all -> 0x007c }
        L_0x007c:
            r2 = move-exception
            r0.remove(r6)
            if (r1 == 0) goto L_0x0087
            java.lang.ThreadLocal<java.util.Map<com.userexperior.a.a.c.a<?>, com.userexperior.a.a.g<?>>> r6 = r5.f3741b
            r6.remove()
        L_0x0087:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.userexperior.a.a.f.a(com.userexperior.a.a.c.a):com.userexperior.a.a.u");
    }

    public final <T> u<T> a(v vVar, a<T> aVar) {
        if (!this.f3743d.contains(vVar)) {
            vVar = this.m;
        }
        boolean z = false;
        for (v next : this.f3743d) {
            if (z) {
                u<T> a2 = next.a(this, aVar);
                if (a2 != null) {
                    return a2;
                }
            } else if (next == vVar) {
                z = true;
            }
        }
        throw new IllegalArgumentException("GSON cannot serialize ".concat(String.valueOf(aVar)));
    }

    public final <T> u<T> a(Class<T> cls) {
        return a(a.a(cls));
    }

    public final <T> T a(Reader reader, Type type) throws m, s {
        com.userexperior.a.a.d.a a2 = a(reader);
        T a3 = a(a2, type);
        a((Object) a3, a2);
        return a3;
    }

    public final <T> T a(String str, Class<T> cls) throws s {
        return p.a(cls).cast(a(str, (Type) cls));
    }

    public final <T> T a(String str, Type type) throws s {
        if (str == null) {
            return null;
        }
        return a((Reader) new StringReader(str), type);
    }

    public final String a(Object obj) {
        return obj == null ? a((l) n.f3758a) : a(obj, (Type) obj.getClass());
    }

    public final String toString() {
        return "{serializeNulls:" + this.h + "factories:" + this.f3743d + ",instanceCreators:" + this.f3744e + "}";
    }
}
