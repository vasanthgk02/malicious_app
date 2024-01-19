package com.userexperior.a.a.b.a;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.userexperior.a.a.b.i;
import com.userexperior.a.a.d.a;
import com.userexperior.a.a.d.b;
import com.userexperior.a.a.d.c;
import com.userexperior.a.a.f;
import com.userexperior.a.a.j;
import com.userexperior.a.a.l;
import com.userexperior.a.a.m;
import com.userexperior.a.a.n;
import com.userexperior.a.a.o;
import com.userexperior.a.a.q;
import com.userexperior.a.a.s;
import com.userexperior.a.a.u;
import com.userexperior.a.a.v;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.InetAddress;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Calendar;
import java.util.Currency;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map.Entry;
import java.util.StringTokenizer;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;
import org.apache.fontbox.cmap.CMapParser;
import org.eclipse.paho.client.mqttv3.MqttTopic;

public final class t {
    public static final u<String> A = new u<String>() {
        public final /* synthetic */ Object a(a aVar) throws IOException {
            b f2 = aVar.f();
            if (f2 != b.NULL) {
                return f2 == b.BOOLEAN ? Boolean.toString(aVar.j()) : aVar.i();
            }
            aVar.k();
            return null;
        }

        public final /* synthetic */ void a(c cVar, Object obj) throws IOException {
            cVar.b((String) obj);
        }
    };
    public static final u<BigDecimal> B = new u<BigDecimal>() {
        public static BigDecimal b(a aVar) throws IOException {
            if (aVar.f() == b.NULL) {
                aVar.k();
                return null;
            }
            try {
                return new BigDecimal(aVar.i());
            } catch (NumberFormatException e2) {
                throw new s((Throwable) e2);
            }
        }

        public final /* synthetic */ Object a(a aVar) throws IOException {
            return b(aVar);
        }

        public final /* bridge */ /* synthetic */ void a(c cVar, Object obj) throws IOException {
            cVar.a((Number) (BigDecimal) obj);
        }
    };
    public static final u<BigInteger> C = new u<BigInteger>() {
        public static BigInteger b(a aVar) throws IOException {
            if (aVar.f() == b.NULL) {
                aVar.k();
                return null;
            }
            try {
                return new BigInteger(aVar.i());
            } catch (NumberFormatException e2) {
                throw new s((Throwable) e2);
            }
        }

        public final /* synthetic */ Object a(a aVar) throws IOException {
            return b(aVar);
        }

        public final /* bridge */ /* synthetic */ void a(c cVar, Object obj) throws IOException {
            cVar.a((Number) (BigInteger) obj);
        }
    };
    public static final v D = a(String.class, A);
    public static final u<StringBuilder> E;
    public static final v F;
    public static final u<StringBuffer> G;
    public static final v H;
    public static final u<URL> I;
    public static final v J;
    public static final u<URI> K;
    public static final v L;
    public static final u<InetAddress> M;
    public static final v N;
    public static final u<UUID> O;
    public static final v P;
    public static final u<Currency> Q;
    public static final v R;
    public static final v S = new v() {
        public final <T> u<T> a(f fVar, com.userexperior.a.a.c.a<T> aVar) {
            if (aVar.f3725a != Timestamp.class) {
                return null;
            }
            final u<Date> a2 = fVar.a(Date.class);
            return new u<Timestamp>() {
                public final /* synthetic */ Object a(a aVar) throws IOException {
                    Date date = (Date) a2.a(aVar);
                    if (date != null) {
                        return new Timestamp(date.getTime());
                    }
                    return null;
                }

                public final /* bridge */ /* synthetic */ void a(c cVar, Object obj) throws IOException {
                    a2.a(cVar, (Timestamp) obj);
                }
            };
        }
    };
    public static final u<Calendar> T;
    public static final v U;
    public static final u<Locale> V;
    public static final v W;
    public static final u<l> X;
    public static final v Y;
    public static final v Z = new v() {
        public final <T> u<T> a(f fVar, com.userexperior.a.a.c.a<T> aVar) {
            Class<? super T> cls = aVar.f3725a;
            if (!Enum.class.isAssignableFrom(cls) || cls == Enum.class) {
                return null;
            }
            if (!cls.isEnum()) {
                cls = cls.getSuperclass();
            }
            return new u(cls);
        }
    };

    /* renamed from: a  reason: collision with root package name */
    public static final u<Class> f3626a;

    /* renamed from: b  reason: collision with root package name */
    public static final v f3627b;

    /* renamed from: c  reason: collision with root package name */
    public static final u<BitSet> f3628c;

    /* renamed from: d  reason: collision with root package name */
    public static final v f3629d;

    /* renamed from: e  reason: collision with root package name */
    public static final u<Boolean> f3630e = new u<Boolean>() {
        public final /* synthetic */ Object a(a aVar) throws IOException {
            if (aVar.f() != b.NULL) {
                return aVar.f() == b.STRING ? Boolean.valueOf(Boolean.parseBoolean(aVar.i())) : Boolean.valueOf(aVar.j());
            }
            aVar.k();
            return null;
        }

        public final /* bridge */ /* synthetic */ void a(c cVar, Object obj) throws IOException {
            cVar.a((Boolean) obj);
        }
    };

    /* renamed from: f  reason: collision with root package name */
    public static final u<Boolean> f3631f = new u<Boolean>() {
        public final /* synthetic */ Object a(a aVar) throws IOException {
            if (aVar.f() != b.NULL) {
                return Boolean.valueOf(aVar.i());
            }
            aVar.k();
            return null;
        }

        public final /* synthetic */ void a(c cVar, Object obj) throws IOException {
            Boolean bool = (Boolean) obj;
            cVar.b(bool == null ? "null" : bool.toString());
        }
    };
    public static final v g = a(Boolean.TYPE, Boolean.class, f3630e);
    public static final u<Number> h = new u<Number>() {
        public static Number b(a aVar) throws IOException {
            if (aVar.f() == b.NULL) {
                aVar.k();
                return null;
            }
            try {
                return Byte.valueOf((byte) aVar.n());
            } catch (NumberFormatException e2) {
                throw new s((Throwable) e2);
            }
        }

        public final /* synthetic */ Object a(a aVar) throws IOException {
            return b(aVar);
        }

        public final /* bridge */ /* synthetic */ void a(c cVar, Object obj) throws IOException {
            cVar.a((Number) obj);
        }
    };
    public static final v i = a(Byte.TYPE, Byte.class, h);
    public static final u<Number> j = new u<Number>() {
        public static Number b(a aVar) throws IOException {
            if (aVar.f() == b.NULL) {
                aVar.k();
                return null;
            }
            try {
                return Short.valueOf((short) aVar.n());
            } catch (NumberFormatException e2) {
                throw new s((Throwable) e2);
            }
        }

        public final /* synthetic */ Object a(a aVar) throws IOException {
            return b(aVar);
        }

        public final /* bridge */ /* synthetic */ void a(c cVar, Object obj) throws IOException {
            cVar.a((Number) obj);
        }
    };
    public static final v k = a(Short.TYPE, Short.class, j);
    public static final u<Number> l = new u<Number>() {
        public static Number b(a aVar) throws IOException {
            if (aVar.f() == b.NULL) {
                aVar.k();
                return null;
            }
            try {
                return Integer.valueOf(aVar.n());
            } catch (NumberFormatException e2) {
                throw new s((Throwable) e2);
            }
        }

        public final /* synthetic */ Object a(a aVar) throws IOException {
            return b(aVar);
        }

        public final /* bridge */ /* synthetic */ void a(c cVar, Object obj) throws IOException {
            cVar.a((Number) obj);
        }
    };
    public static final v m = a(Integer.TYPE, Integer.class, l);
    public static final u<AtomicInteger> n;
    public static final v o;
    public static final u<AtomicBoolean> p;
    public static final v q;
    public static final u<AtomicIntegerArray> r;
    public static final v s;
    public static final u<Number> t = new u<Number>() {
        public static Number b(a aVar) throws IOException {
            if (aVar.f() == b.NULL) {
                aVar.k();
                return null;
            }
            try {
                return Long.valueOf(aVar.m());
            } catch (NumberFormatException e2) {
                throw new s((Throwable) e2);
            }
        }

        public final /* synthetic */ Object a(a aVar) throws IOException {
            return b(aVar);
        }

        public final /* bridge */ /* synthetic */ void a(c cVar, Object obj) throws IOException {
            cVar.a((Number) obj);
        }
    };
    public static final u<Number> u = new u<Number>() {
        public final /* synthetic */ Object a(a aVar) throws IOException {
            if (aVar.f() != b.NULL) {
                return Float.valueOf((float) aVar.l());
            }
            aVar.k();
            return null;
        }

        public final /* bridge */ /* synthetic */ void a(c cVar, Object obj) throws IOException {
            cVar.a((Number) obj);
        }
    };
    public static final u<Number> v = new u<Number>() {
        public final /* synthetic */ Object a(a aVar) throws IOException {
            if (aVar.f() != b.NULL) {
                return Double.valueOf(aVar.l());
            }
            aVar.k();
            return null;
        }

        public final /* bridge */ /* synthetic */ void a(c cVar, Object obj) throws IOException {
            cVar.a((Number) obj);
        }
    };
    public static final u<Number> w;
    public static final v x;
    public static final u<Character> y = new u<Character>() {
        public final /* synthetic */ Object a(a aVar) throws IOException {
            if (aVar.f() == b.NULL) {
                aVar.k();
                return null;
            }
            String i = aVar.i();
            if (i.length() == 1) {
                return Character.valueOf(i.charAt(0));
            }
            throw new s("Expecting character, got: ".concat(i));
        }

        public final /* synthetic */ void a(c cVar, Object obj) throws IOException {
            Character ch = (Character) obj;
            cVar.b(ch == null ? null : String.valueOf(ch));
        }
    };
    public static final v z = a(Character.TYPE, Character.class, y);

    /* renamed from: com.userexperior.a.a.b.a.t$29  reason: invalid class name */
    public final /* synthetic */ class AnonymousClass29 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f3646a;

        /* JADX WARNING: Can't wrap try/catch for region: R(23:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|13|14|15|16|17|18|19|21|22|23|24|25|26|27|28|30) */
        /* JADX WARNING: Can't wrap try/catch for region: R(24:0|1|2|3|(2:5|6)|7|(2:9|10)|11|13|14|15|16|17|18|19|21|22|23|24|25|26|27|28|30) */
        /* JADX WARNING: Can't wrap try/catch for region: R(25:0|1|2|3|(2:5|6)|7|9|10|11|13|14|15|16|17|18|19|21|22|23|24|25|26|27|28|30) */
        /* JADX WARNING: Code restructure failed: missing block: B:31:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x002f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x003d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0043 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x0049 */
        static {
            /*
                com.userexperior.a.a.d.b[] r0 = com.userexperior.a.a.d.b.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f3646a = r0
                r1 = 1
                r2 = 6
                com.userexperior.a.a.d.b r3 = com.userexperior.a.a.d.b.NUMBER     // Catch:{ NoSuchFieldError -> 0x000f }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x000f }
            L_0x000f:
                r0 = 2
                r3 = 7
                int[] r4 = f3646a     // Catch:{ NoSuchFieldError -> 0x0017 }
                com.userexperior.a.a.d.b r5 = com.userexperior.a.a.d.b.BOOLEAN     // Catch:{ NoSuchFieldError -> 0x0017 }
                r4[r3] = r0     // Catch:{ NoSuchFieldError -> 0x0017 }
            L_0x0017:
                r4 = 3
                r5 = 5
                int[] r6 = f3646a     // Catch:{ NoSuchFieldError -> 0x001f }
                com.userexperior.a.a.d.b r7 = com.userexperior.a.a.d.b.STRING     // Catch:{ NoSuchFieldError -> 0x001f }
                r6[r5] = r4     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                r6 = 4
                r7 = 8
                int[] r8 = f3646a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.userexperior.a.a.d.b r9 = com.userexperior.a.a.d.b.NULL     // Catch:{ NoSuchFieldError -> 0x0028 }
                r8[r7] = r6     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r8 = f3646a     // Catch:{ NoSuchFieldError -> 0x002f }
                com.userexperior.a.a.d.b r9 = com.userexperior.a.a.d.b.BEGIN_ARRAY     // Catch:{ NoSuchFieldError -> 0x002f }
                r9 = 0
                r8[r9] = r5     // Catch:{ NoSuchFieldError -> 0x002f }
            L_0x002f:
                int[] r5 = f3646a     // Catch:{ NoSuchFieldError -> 0x0035 }
                com.userexperior.a.a.d.b r8 = com.userexperior.a.a.d.b.BEGIN_OBJECT     // Catch:{ NoSuchFieldError -> 0x0035 }
                r5[r0] = r2     // Catch:{ NoSuchFieldError -> 0x0035 }
            L_0x0035:
                r0 = 9
                int[] r2 = f3646a     // Catch:{ NoSuchFieldError -> 0x003d }
                com.userexperior.a.a.d.b r5 = com.userexperior.a.a.d.b.END_DOCUMENT     // Catch:{ NoSuchFieldError -> 0x003d }
                r2[r0] = r3     // Catch:{ NoSuchFieldError -> 0x003d }
            L_0x003d:
                int[] r2 = f3646a     // Catch:{ NoSuchFieldError -> 0x0043 }
                com.userexperior.a.a.d.b r3 = com.userexperior.a.a.d.b.NAME     // Catch:{ NoSuchFieldError -> 0x0043 }
                r2[r6] = r7     // Catch:{ NoSuchFieldError -> 0x0043 }
            L_0x0043:
                int[] r2 = f3646a     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.userexperior.a.a.d.b r3 = com.userexperior.a.a.d.b.END_OBJECT     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2[r4] = r0     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = f3646a     // Catch:{ NoSuchFieldError -> 0x0051 }
                com.userexperior.a.a.d.b r2 = com.userexperior.a.a.d.b.END_ARRAY     // Catch:{ NoSuchFieldError -> 0x0051 }
                r2 = 10
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0051 }
            L_0x0051:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.userexperior.a.a.b.a.t.AnonymousClass29.<clinit>():void");
        }
    }

    static {
        AnonymousClass1 r0 = new u<Class>() {
            public final /* synthetic */ Object a(a aVar) throws IOException {
                if (aVar.f() == b.NULL) {
                    aVar.k();
                    return null;
                }
                throw new UnsupportedOperationException("Attempted to deserialize a java.lang.Class. Forgot to register a type adapter?");
            }

            public final /* synthetic */ void a(c cVar, Object obj) throws IOException {
                Class cls = (Class) obj;
                if (cls == null) {
                    cVar.e();
                    return;
                }
                throw new UnsupportedOperationException(GeneratedOutlineSupport.outline36(cls, new StringBuilder("Attempted to serialize java.lang.Class: "), ". Forgot to register a type adapter?"));
            }
        };
        f3626a = r0;
        f3627b = a(Class.class, r0);
        AnonymousClass12 r02 = new u<BitSet>() {
            /* JADX WARNING: Code restructure failed: missing block: B:16:0x0038, code lost:
                if (java.lang.Integer.parseInt(r1) != 0) goto L_0x0068;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:25:0x0066, code lost:
                if (r7.n() != 0) goto L_0x0068;
             */
            /* JADX WARNING: Removed duplicated region for block: B:27:0x006a  */
            /* JADX WARNING: Removed duplicated region for block: B:34:0x006d A[SYNTHETIC] */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public static java.util.BitSet b(com.userexperior.a.a.d.a r7) throws java.io.IOException {
                /*
                    com.userexperior.a.a.d.b r0 = r7.f()
                    com.userexperior.a.a.d.b r1 = com.userexperior.a.a.d.b.NULL
                    if (r0 != r1) goto L_0x000d
                    r7.k()
                    r7 = 0
                    return r7
                L_0x000d:
                    java.util.BitSet r0 = new java.util.BitSet
                    r0.<init>()
                    r7.a()
                    com.userexperior.a.a.d.b r1 = r7.f()
                    r2 = 0
                    r3 = 0
                L_0x001b:
                    com.userexperior.a.a.d.b r4 = com.userexperior.a.a.d.b.END_ARRAY
                    if (r1 == r4) goto L_0x0074
                    int[] r4 = com.userexperior.a.a.b.a.t.AnonymousClass29.f3646a
                    int r5 = r1.ordinal()
                    r4 = r4[r5]
                    r5 = 1
                    if (r4 == r5) goto L_0x0062
                    r6 = 2
                    if (r4 == r6) goto L_0x005d
                    r6 = 3
                    if (r4 != r6) goto L_0x004d
                    java.lang.String r1 = r7.i()
                    int r1 = java.lang.Integer.parseInt(r1)     // Catch:{ NumberFormatException -> 0x003d }
                    if (r1 == 0) goto L_0x003b
                    goto L_0x0068
                L_0x003b:
                    r5 = 0
                    goto L_0x0068
                L_0x003d:
                    com.userexperior.a.a.s r7 = new com.userexperior.a.a.s
                    java.lang.String r0 = java.lang.String.valueOf(r1)
                    java.lang.String r1 = "Error: Expecting: bitset number value (1, 0), Found: "
                    java.lang.String r0 = r1.concat(r0)
                    r7.<init>(r0)
                    throw r7
                L_0x004d:
                    com.userexperior.a.a.s r7 = new com.userexperior.a.a.s
                    java.lang.String r0 = java.lang.String.valueOf(r1)
                    java.lang.String r1 = "Invalid bitset value type: "
                    java.lang.String r0 = r1.concat(r0)
                    r7.<init>(r0)
                    throw r7
                L_0x005d:
                    boolean r5 = r7.j()
                    goto L_0x0068
                L_0x0062:
                    int r1 = r7.n()
                    if (r1 == 0) goto L_0x003b
                L_0x0068:
                    if (r5 == 0) goto L_0x006d
                    r0.set(r3)
                L_0x006d:
                    int r3 = r3 + 1
                    com.userexperior.a.a.d.b r1 = r7.f()
                    goto L_0x001b
                L_0x0074:
                    r7.b()
                    return r0
                */
                throw new UnsupportedOperationException("Method not decompiled: com.userexperior.a.a.b.a.t.AnonymousClass12.b(com.userexperior.a.a.d.a):java.util.BitSet");
            }

            public final /* synthetic */ Object a(a aVar) throws IOException {
                return b(aVar);
            }

            public final /* synthetic */ void a(c cVar, Object obj) throws IOException {
                BitSet bitSet = (BitSet) obj;
                if (bitSet == null) {
                    cVar.e();
                    return;
                }
                cVar.a();
                for (int i = 0; i < bitSet.length(); i++) {
                    cVar.a(bitSet.get(i) ? 1 : 0);
                }
                cVar.b();
            }
        };
        f3628c = r02;
        f3629d = a(BitSet.class, r02);
        u<AtomicInteger> a2 = new u<AtomicInteger>() {
            public static AtomicInteger b(a aVar) throws IOException {
                try {
                    return new AtomicInteger(aVar.n());
                } catch (NumberFormatException e2) {
                    throw new s((Throwable) e2);
                }
            }

            public final /* synthetic */ Object a(a aVar) throws IOException {
                return b(aVar);
            }

            public final /* synthetic */ void a(c cVar, Object obj) throws IOException {
                cVar.a((long) ((AtomicInteger) obj).get());
            }
        }.a();
        n = a2;
        o = a(AtomicInteger.class, a2);
        u<AtomicBoolean> a3 = new u<AtomicBoolean>() {
            public final /* synthetic */ Object a(a aVar) throws IOException {
                return new AtomicBoolean(aVar.j());
            }

            public final /* synthetic */ void a(c cVar, Object obj) throws IOException {
                cVar.a(((AtomicBoolean) obj).get());
            }
        }.a();
        p = a3;
        q = a(AtomicBoolean.class, a3);
        u<AtomicIntegerArray> a4 = new u<AtomicIntegerArray>() {
            public static AtomicIntegerArray b(a aVar) throws IOException {
                ArrayList arrayList = new ArrayList();
                aVar.a();
                while (aVar.e()) {
                    try {
                        arrayList.add(Integer.valueOf(aVar.n()));
                    } catch (NumberFormatException e2) {
                        throw new s((Throwable) e2);
                    }
                }
                aVar.b();
                int size = arrayList.size();
                AtomicIntegerArray atomicIntegerArray = new AtomicIntegerArray(size);
                for (int i = 0; i < size; i++) {
                    atomicIntegerArray.set(i, ((Integer) arrayList.get(i)).intValue());
                }
                return atomicIntegerArray;
            }

            public final /* synthetic */ Object a(a aVar) throws IOException {
                return b(aVar);
            }

            public final /* synthetic */ void a(c cVar, Object obj) throws IOException {
                AtomicIntegerArray atomicIntegerArray = (AtomicIntegerArray) obj;
                cVar.a();
                int length = atomicIntegerArray.length();
                for (int i = 0; i < length; i++) {
                    cVar.a((long) atomicIntegerArray.get(i));
                }
                cVar.b();
            }
        }.a();
        r = a4;
        s = a(AtomicIntegerArray.class, a4);
        AnonymousClass6 r03 = new u<Number>() {
            public final /* synthetic */ Object a(a aVar) throws IOException {
                b f2 = aVar.f();
                int i = AnonymousClass29.f3646a[f2.ordinal()];
                if (i == 1) {
                    return new i(aVar.i());
                }
                if (i == 4) {
                    aVar.k();
                    return null;
                }
                throw new s("Expecting number, got: ".concat(String.valueOf(f2)));
            }

            public final /* bridge */ /* synthetic */ void a(c cVar, Object obj) throws IOException {
                cVar.a((Number) obj);
            }
        };
        w = r03;
        x = a(Number.class, r03);
        AnonymousClass11 r04 = new u<StringBuilder>() {
            public final /* synthetic */ Object a(a aVar) throws IOException {
                if (aVar.f() != b.NULL) {
                    return new StringBuilder(aVar.i());
                }
                aVar.k();
                return null;
            }

            public final /* synthetic */ void a(c cVar, Object obj) throws IOException {
                StringBuilder sb = (StringBuilder) obj;
                cVar.b(sb == null ? null : sb.toString());
            }
        };
        E = r04;
        F = a(StringBuilder.class, r04);
        AnonymousClass13 r05 = new u<StringBuffer>() {
            public final /* synthetic */ Object a(a aVar) throws IOException {
                if (aVar.f() != b.NULL) {
                    return new StringBuffer(aVar.i());
                }
                aVar.k();
                return null;
            }

            public final /* synthetic */ void a(c cVar, Object obj) throws IOException {
                StringBuffer stringBuffer = (StringBuffer) obj;
                cVar.b(stringBuffer == null ? null : stringBuffer.toString());
            }
        };
        G = r05;
        H = a(StringBuffer.class, r05);
        AnonymousClass14 r06 = new u<URL>() {
            public final /* synthetic */ Object a(a aVar) throws IOException {
                if (aVar.f() == b.NULL) {
                    aVar.k();
                    return null;
                }
                String i = aVar.i();
                if ("null".equals(i)) {
                    return null;
                }
                return new URL(i);
            }

            public final /* synthetic */ void a(c cVar, Object obj) throws IOException {
                URL url = (URL) obj;
                cVar.b(url == null ? null : url.toExternalForm());
            }
        };
        I = r06;
        J = a(URL.class, r06);
        AnonymousClass15 r07 = new u<URI>() {
            public static URI b(a aVar) throws IOException {
                if (aVar.f() == b.NULL) {
                    aVar.k();
                    return null;
                }
                try {
                    String i = aVar.i();
                    if ("null".equals(i)) {
                        return null;
                    }
                    return new URI(i);
                } catch (URISyntaxException e2) {
                    throw new m((Throwable) e2);
                }
            }

            public final /* synthetic */ Object a(a aVar) throws IOException {
                return b(aVar);
            }

            public final /* synthetic */ void a(c cVar, Object obj) throws IOException {
                URI uri = (URI) obj;
                cVar.b(uri == null ? null : uri.toASCIIString());
            }
        };
        K = r07;
        L = a(URI.class, r07);
        AnonymousClass16 r08 = new u<InetAddress>() {
            public final /* synthetic */ Object a(a aVar) throws IOException {
                if (aVar.f() != b.NULL) {
                    return InetAddress.getByName(aVar.i());
                }
                aVar.k();
                return null;
            }

            public final /* synthetic */ void a(c cVar, Object obj) throws IOException {
                InetAddress inetAddress = (InetAddress) obj;
                cVar.b(inetAddress == null ? null : inetAddress.getHostAddress());
            }
        };
        M = r08;
        N = b(InetAddress.class, r08);
        AnonymousClass17 r09 = new u<UUID>() {
            public final /* synthetic */ Object a(a aVar) throws IOException {
                if (aVar.f() != b.NULL) {
                    return UUID.fromString(aVar.i());
                }
                aVar.k();
                return null;
            }

            public final /* synthetic */ void a(c cVar, Object obj) throws IOException {
                UUID uuid = (UUID) obj;
                cVar.b(uuid == null ? null : uuid.toString());
            }
        };
        O = r09;
        P = a(UUID.class, r09);
        u<Currency> a5 = new u<Currency>() {
            public final /* synthetic */ Object a(a aVar) throws IOException {
                return Currency.getInstance(aVar.i());
            }

            public final /* synthetic */ void a(c cVar, Object obj) throws IOException {
                cVar.b(((Currency) obj).getCurrencyCode());
            }
        }.a();
        Q = a5;
        R = a(Currency.class, a5);
        final AnonymousClass20 r010 = new u<Calendar>() {
            public final /* synthetic */ Object a(a aVar) throws IOException {
                if (aVar.f() == b.NULL) {
                    aVar.k();
                    return null;
                }
                aVar.c();
                int i = 0;
                int i2 = 0;
                int i3 = 0;
                int i4 = 0;
                int i5 = 0;
                int i6 = 0;
                while (aVar.f() != b.END_OBJECT) {
                    String h = aVar.h();
                    int n = aVar.n();
                    if (com.google.gson.internal.bind.TypeAdapters.AnonymousClass27.YEAR.equals(h)) {
                        i = n;
                    } else if (com.google.gson.internal.bind.TypeAdapters.AnonymousClass27.MONTH.equals(h)) {
                        i2 = n;
                    } else if (com.google.gson.internal.bind.TypeAdapters.AnonymousClass27.DAY_OF_MONTH.equals(h)) {
                        i3 = n;
                    } else if (com.google.gson.internal.bind.TypeAdapters.AnonymousClass27.HOUR_OF_DAY.equals(h)) {
                        i4 = n;
                    } else if ("minute".equals(h)) {
                        i5 = n;
                    } else if (com.google.gson.internal.bind.TypeAdapters.AnonymousClass27.SECOND.equals(h)) {
                        i6 = n;
                    }
                }
                aVar.d();
                GregorianCalendar gregorianCalendar = new GregorianCalendar(i, i2, i3, i4, i5, i6);
                return gregorianCalendar;
            }

            public final /* synthetic */ void a(c cVar, Object obj) throws IOException {
                Calendar calendar = (Calendar) obj;
                if (calendar == null) {
                    cVar.e();
                    return;
                }
                cVar.c();
                cVar.a((String) com.google.gson.internal.bind.TypeAdapters.AnonymousClass27.YEAR);
                cVar.a((long) calendar.get(1));
                cVar.a((String) com.google.gson.internal.bind.TypeAdapters.AnonymousClass27.MONTH);
                cVar.a((long) calendar.get(2));
                cVar.a((String) com.google.gson.internal.bind.TypeAdapters.AnonymousClass27.DAY_OF_MONTH);
                cVar.a((long) calendar.get(5));
                cVar.a((String) com.google.gson.internal.bind.TypeAdapters.AnonymousClass27.HOUR_OF_DAY);
                cVar.a((long) calendar.get(11));
                cVar.a((String) "minute");
                cVar.a((long) calendar.get(12));
                cVar.a((String) com.google.gson.internal.bind.TypeAdapters.AnonymousClass27.SECOND);
                cVar.a((long) calendar.get(13));
                cVar.d();
            }
        };
        T = r010;
        final Class<Calendar> cls = Calendar.class;
        final Class<GregorianCalendar> cls2 = GregorianCalendar.class;
        U = new v() {
            public final <T> u<T> a(f fVar, com.userexperior.a.a.c.a<T> aVar) {
                Class<? super T> cls = aVar.f3725a;
                if (cls == cls || cls == cls2) {
                    return r010;
                }
                return null;
            }

            public final String toString() {
                StringBuilder sb = new StringBuilder("Factory[type=");
                GeneratedOutlineSupport.outline94(cls, sb, MqttTopic.SINGLE_LEVEL_WILDCARD);
                GeneratedOutlineSupport.outline94(cls2, sb, ",adapter=");
                sb.append(r010);
                sb.append(CMapParser.MARK_END_OF_ARRAY);
                return sb.toString();
            }
        };
        AnonymousClass21 r011 = new u<Locale>() {
            public final /* synthetic */ Object a(a aVar) throws IOException {
                Locale locale;
                String str = null;
                if (aVar.f() == b.NULL) {
                    aVar.k();
                    return null;
                }
                StringTokenizer stringTokenizer = new StringTokenizer(aVar.i(), "_");
                String nextToken = stringTokenizer.hasMoreElements() ? stringTokenizer.nextToken() : null;
                String nextToken2 = stringTokenizer.hasMoreElements() ? stringTokenizer.nextToken() : null;
                if (stringTokenizer.hasMoreElements()) {
                    str = stringTokenizer.nextToken();
                }
                if (nextToken2 == null && str == null) {
                    return new Locale(nextToken);
                }
                if (str == null) {
                    locale = new Locale(nextToken, nextToken2);
                    return locale;
                }
                locale = new Locale(nextToken, nextToken2, str);
                return locale;
            }

            public final /* synthetic */ void a(c cVar, Object obj) throws IOException {
                Locale locale = (Locale) obj;
                cVar.b(locale == null ? null : locale.toString());
            }
        };
        V = r011;
        W = a(Locale.class, r011);
        AnonymousClass22 r012 = new u<l>() {
            /* access modifiers changed from: private */
            public void a(c cVar, l lVar) throws IOException {
                if (lVar == null || (lVar instanceof n)) {
                    cVar.e();
                } else if (lVar instanceof q) {
                    q g = lVar.g();
                    Object obj = g.f3761a;
                    if (obj instanceof Number) {
                        cVar.a(g.a());
                    } else if (obj instanceof Boolean) {
                        cVar.a(g.f());
                    } else {
                        cVar.b(g.b());
                    }
                } else {
                    boolean z = lVar instanceof j;
                    if (z) {
                        cVar.a();
                        if (z) {
                            Iterator<l> it = ((j) lVar).iterator();
                            while (it.hasNext()) {
                                a(cVar, it.next());
                            }
                            cVar.b();
                            return;
                        }
                        throw new IllegalStateException("This is not a JSON Array.");
                    }
                    boolean z2 = lVar instanceof o;
                    if (z2) {
                        cVar.c();
                        if (z2) {
                            for (Entry entry : ((o) lVar).f3759a.entrySet()) {
                                cVar.a((String) entry.getKey());
                                a(cVar, (l) entry.getValue());
                            }
                            cVar.d();
                            return;
                        }
                        throw new IllegalStateException("Not a JSON Object: ".concat(String.valueOf(lVar)));
                    }
                    throw new IllegalArgumentException("Couldn't write " + lVar.getClass());
                }
            }

            /* access modifiers changed from: private */
            /* renamed from: b */
            public l a(a aVar) throws IOException {
                switch (AnonymousClass29.f3646a[aVar.f().ordinal()]) {
                    case 1:
                        return new q((Number) new i(aVar.i()));
                    case 2:
                        return new q(Boolean.valueOf(aVar.j()));
                    case 3:
                        return new q(aVar.i());
                    case 4:
                        aVar.k();
                        return n.f3758a;
                    case 5:
                        j jVar = new j();
                        aVar.a();
                        while (aVar.e()) {
                            jVar.a(a(aVar));
                        }
                        aVar.b();
                        return jVar;
                    case 6:
                        o oVar = new o();
                        aVar.c();
                        while (aVar.e()) {
                            oVar.a(aVar.h(), a(aVar));
                        }
                        aVar.d();
                        return oVar;
                    default:
                        throw new IllegalArgumentException();
                }
            }
        };
        X = r012;
        Y = b(l.class, r012);
    }

    public static <TT> v a(final Class<TT> cls, final u<TT> uVar) {
        return new v() {
            public final <T> u<T> a(f fVar, com.userexperior.a.a.c.a<T> aVar) {
                if (aVar.f3725a == cls) {
                    return uVar;
                }
                return null;
            }

            public final String toString() {
                StringBuilder sb = new StringBuilder("Factory[type=");
                GeneratedOutlineSupport.outline94(cls, sb, ",adapter=");
                sb.append(uVar);
                sb.append(CMapParser.MARK_END_OF_ARRAY);
                return sb.toString();
            }
        };
    }

    public static <TT> v a(final Class<TT> cls, final Class<TT> cls2, final u<? super TT> uVar) {
        return new v() {
            public final <T> u<T> a(f fVar, com.userexperior.a.a.c.a<T> aVar) {
                Class<? super T> cls = aVar.f3725a;
                if (cls == cls || cls == cls2) {
                    return uVar;
                }
                return null;
            }

            public final String toString() {
                StringBuilder sb = new StringBuilder("Factory[type=");
                GeneratedOutlineSupport.outline94(cls2, sb, MqttTopic.SINGLE_LEVEL_WILDCARD);
                GeneratedOutlineSupport.outline94(cls, sb, ",adapter=");
                sb.append(uVar);
                sb.append(CMapParser.MARK_END_OF_ARRAY);
                return sb.toString();
            }
        };
    }

    public static <T1> v b(final Class<T1> cls, final u<T1> uVar) {
        return new v() {
            public final <T2> u<T2> a(f fVar, com.userexperior.a.a.c.a<T2> aVar) {
                final Class<? super T> cls = aVar.f3725a;
                if (!cls.isAssignableFrom(cls)) {
                    return null;
                }
                return new u<T1>() {
                    public final T1 a(a aVar) throws IOException {
                        T1 a2 = uVar.a(aVar);
                        if (a2 == null || cls.isInstance(a2)) {
                            return a2;
                        }
                        throw new s("Expected a " + cls.getName() + " but was " + a2.getClass().getName());
                    }

                    public final void a(c cVar, T1 t1) throws IOException {
                        uVar.a(cVar, t1);
                    }
                };
            }

            public final String toString() {
                StringBuilder sb = new StringBuilder("Factory[typeHierarchy=");
                GeneratedOutlineSupport.outline94(cls, sb, ",adapter=");
                sb.append(uVar);
                sb.append(CMapParser.MARK_END_OF_ARRAY);
                return sb.toString();
            }
        };
    }
}
