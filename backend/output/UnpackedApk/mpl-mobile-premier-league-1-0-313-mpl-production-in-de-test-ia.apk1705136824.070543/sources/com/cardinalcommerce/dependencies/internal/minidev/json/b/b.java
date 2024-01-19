package com.cardinalcommerce.dependencies.internal.minidev.json.b;

import com.badlogic.gdx.graphics.GL20;
import java.math.BigDecimal;

public abstract class b {

    /* renamed from: c  reason: collision with root package name */
    public static boolean[] f1920c;

    /* renamed from: d  reason: collision with root package name */
    public static boolean[] f1921d;

    /* renamed from: e  reason: collision with root package name */
    public static boolean[] f1922e;

    /* renamed from: f  reason: collision with root package name */
    public static boolean[] f1923f;
    public static boolean[] g;

    /* renamed from: a  reason: collision with root package name */
    public char f1924a;
    public final a h = new a(15);
    public Object i;
    public String j;
    public int k;
    public final boolean l;
    public final boolean m;
    public final boolean n;
    public final boolean o;
    public final boolean p;
    public final boolean q;
    public final boolean r;
    public final boolean s;
    public final boolean t;
    public final boolean u;
    public final boolean v;
    public String w;

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public char[] f1925a;

        /* renamed from: b  reason: collision with root package name */
        public int f1926b = -1;

        public a(int i) {
            this.f1925a = new char[i];
        }

        public void a(char c2) {
            int i = this.f1926b + 1;
            this.f1926b = i;
            char[] cArr = this.f1925a;
            if (cArr.length <= i) {
                char[] cArr2 = new char[((cArr.length * 2) + 1)];
                System.arraycopy(cArr, 0, cArr2, 0, cArr.length);
                this.f1925a = cArr2;
            }
            this.f1925a[this.f1926b] = c2;
        }

        public String toString() {
            return new String(this.f1925a, 0, this.f1926b + 1);
        }
    }

    static {
        boolean[] zArr = new boolean[126];
        f1920c = zArr;
        boolean[] zArr2 = new boolean[126];
        f1921d = zArr2;
        boolean[] zArr3 = new boolean[126];
        f1922e = zArr3;
        boolean[] zArr4 = new boolean[126];
        f1923f = zArr4;
        boolean[] zArr5 = new boolean[126];
        g = zArr5;
        zArr3[26] = true;
        zArr3[58] = true;
        zArr4[26] = true;
        zArr4[125] = true;
        zArr4[44] = true;
        zArr2[26] = true;
        zArr2[93] = true;
        zArr2[44] = true;
        zArr5[26] = true;
        zArr[58] = true;
        zArr[44] = true;
        zArr[26] = true;
        zArr[125] = true;
        zArr[93] = true;
    }

    public b(int i2) {
        boolean z = false;
        this.m = (i2 & 4) > 0;
        this.n = (i2 & 2) > 0;
        this.o = (i2 & 1) > 0;
        this.s = (i2 & 8) > 0;
        this.u = (i2 & 16) > 0;
        this.l = (i2 & 32) > 0;
        this.p = (i2 & 64) > 0;
        this.t = (i2 & 128) > 0;
        this.q = (i2 & GL20.GL_SRC_COLOR) != 768;
        this.r = (i2 & 512) == 0;
        this.v = (i2 & 1024) > 0 ? true : z;
    }

    public char a(int i2) {
        int i3;
        int i4;
        int i5 = 0;
        for (int i6 = 0; i6 < i2; i6++) {
            int i7 = i5 * 16;
            d();
            char c2 = this.f1924a;
            if (c2 > '9' || c2 < '0') {
                char c3 = this.f1924a;
                if (c3 > 'F' || c3 < 'A') {
                    char c4 = this.f1924a;
                    if (c4 >= 'a' && c4 <= 'f') {
                        i3 = c4 - 'a';
                    } else if (this.f1924a == 26) {
                        throw new i(this.k, 3, "EOF");
                    } else {
                        throw new i(this.k, 4, Character.valueOf(this.f1924a));
                    }
                } else {
                    i3 = c3 - 'A';
                }
                i4 = i3 + 10;
            } else {
                i4 = c2 - '0';
            }
            i5 = i4 + i7;
        }
        return (char) i5;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:62:0x010c, code lost:
        throw new com.cardinalcommerce.dependencies.internal.minidev.json.b.i(r2.k, 0, java.lang.Character.valueOf(r2.f1924a));
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object a(com.cardinalcommerce.dependencies.internal.minidev.json.d.j<?> r3, boolean[] r4) {
        /*
            r2 = this;
        L_0x0000:
            char r0 = r2.f1924a
            r1 = 9
            if (r0 == r1) goto L_0x011c
            r1 = 10
            if (r0 == r1) goto L_0x011c
            r1 = 1
            switch(r0) {
                case 13: goto L_0x011c;
                case 32: goto L_0x011c;
                case 34: goto L_0x00f8;
                case 39: goto L_0x00f8;
                case 45: goto L_0x010d;
                case 78: goto L_0x00bb;
                case 91: goto L_0x00b0;
                case 93: goto L_0x00fe;
                case 102: goto L_0x0085;
                case 110: goto L_0x005b;
                case 116: goto L_0x0030;
                case 123: goto L_0x0025;
                case 125: goto L_0x00fe;
                default: goto L_0x000e;
            }
        L_0x000e:
            switch(r0) {
                case 48: goto L_0x010d;
                case 49: goto L_0x010d;
                case 50: goto L_0x010d;
                case 51: goto L_0x010d;
                case 52: goto L_0x010d;
                case 53: goto L_0x010d;
                case 54: goto L_0x010d;
                case 55: goto L_0x010d;
                case 56: goto L_0x010d;
                case 57: goto L_0x010d;
                case 58: goto L_0x00fe;
                default: goto L_0x0011;
            }
        L_0x0011:
            r3 = r2
            com.cardinalcommerce.dependencies.internal.minidev.json.b.e r3 = (com.cardinalcommerce.dependencies.internal.minidev.json.b.e) r3
            int r0 = r3.k
            r3.c(r4)
            int r4 = r3.k
            r3.b(r0, r4)
            boolean r3 = r2.n
            if (r3 == 0) goto L_0x0112
            java.lang.String r3 = r2.j
            return r3
        L_0x0025:
            java.lang.String r4 = r2.w
            com.cardinalcommerce.dependencies.internal.minidev.json.d.j r3 = r3.b(r4)
            java.lang.Object r3 = r2.d(r3)
            return r3
        L_0x0030:
            r3 = r2
            com.cardinalcommerce.dependencies.internal.minidev.json.b.e r3 = (com.cardinalcommerce.dependencies.internal.minidev.json.b.e) r3
            int r0 = r3.k
            r3.c(r4)
            int r4 = r3.k
            r3.b(r0, r4)
            java.lang.String r3 = r2.j
            java.lang.String r4 = "true"
            boolean r3 = r4.equals(r3)
            if (r3 == 0) goto L_0x004a
            java.lang.Boolean r3 = java.lang.Boolean.TRUE
            return r3
        L_0x004a:
            boolean r3 = r2.n
            if (r3 == 0) goto L_0x0051
            java.lang.String r3 = r2.j
            return r3
        L_0x0051:
            com.cardinalcommerce.dependencies.internal.minidev.json.b.i r3 = new com.cardinalcommerce.dependencies.internal.minidev.json.b.i
            int r4 = r2.k
            java.lang.String r0 = r2.j
            r3.<init>(r4, r1, r0)
            throw r3
        L_0x005b:
            r3 = r2
            com.cardinalcommerce.dependencies.internal.minidev.json.b.e r3 = (com.cardinalcommerce.dependencies.internal.minidev.json.b.e) r3
            int r0 = r3.k
            r3.c(r4)
            int r4 = r3.k
            r3.b(r0, r4)
            java.lang.String r3 = r2.j
            java.lang.String r4 = "null"
            boolean r3 = r4.equals(r3)
            if (r3 == 0) goto L_0x0074
            r3 = 0
            return r3
        L_0x0074:
            boolean r3 = r2.n
            if (r3 == 0) goto L_0x007b
            java.lang.String r3 = r2.j
            return r3
        L_0x007b:
            com.cardinalcommerce.dependencies.internal.minidev.json.b.i r3 = new com.cardinalcommerce.dependencies.internal.minidev.json.b.i
            int r4 = r2.k
            java.lang.String r0 = r2.j
            r3.<init>(r4, r1, r0)
            throw r3
        L_0x0085:
            r3 = r2
            com.cardinalcommerce.dependencies.internal.minidev.json.b.e r3 = (com.cardinalcommerce.dependencies.internal.minidev.json.b.e) r3
            int r0 = r3.k
            r3.c(r4)
            int r4 = r3.k
            r3.b(r0, r4)
            java.lang.String r3 = r2.j
            java.lang.String r4 = "false"
            boolean r3 = r4.equals(r3)
            if (r3 == 0) goto L_0x009f
            java.lang.Boolean r3 = java.lang.Boolean.FALSE
            return r3
        L_0x009f:
            boolean r3 = r2.n
            if (r3 == 0) goto L_0x00a6
            java.lang.String r3 = r2.j
            return r3
        L_0x00a6:
            com.cardinalcommerce.dependencies.internal.minidev.json.b.i r3 = new com.cardinalcommerce.dependencies.internal.minidev.json.b.i
            int r4 = r2.k
            java.lang.String r0 = r2.j
            r3.<init>(r4, r1, r0)
            throw r3
        L_0x00b0:
            java.lang.String r4 = r2.w
            com.cardinalcommerce.dependencies.internal.minidev.json.d.j r3 = r3.a(r4)
            java.lang.Object r3 = r2.b(r3)
            return r3
        L_0x00bb:
            r3 = r2
            com.cardinalcommerce.dependencies.internal.minidev.json.b.e r3 = (com.cardinalcommerce.dependencies.internal.minidev.json.b.e) r3
            int r0 = r3.k
            r3.c(r4)
            int r4 = r3.k
            r3.b(r0, r4)
            boolean r3 = r2.m
            if (r3 == 0) goto L_0x00ee
            java.lang.String r3 = r2.j
            java.lang.String r4 = "NaN"
            boolean r3 = r4.equals(r3)
            if (r3 == 0) goto L_0x00dd
            r3 = 2143289344(0x7fc00000, float:NaN)
            java.lang.Float r3 = java.lang.Float.valueOf(r3)
            return r3
        L_0x00dd:
            boolean r3 = r2.n
            if (r3 == 0) goto L_0x00e4
            java.lang.String r3 = r2.j
            return r3
        L_0x00e4:
            com.cardinalcommerce.dependencies.internal.minidev.json.b.i r3 = new com.cardinalcommerce.dependencies.internal.minidev.json.b.i
            int r4 = r2.k
            java.lang.String r0 = r2.j
            r3.<init>(r4, r1, r0)
            throw r3
        L_0x00ee:
            com.cardinalcommerce.dependencies.internal.minidev.json.b.i r3 = new com.cardinalcommerce.dependencies.internal.minidev.json.b.i
            int r4 = r2.k
            java.lang.String r0 = r2.j
            r3.<init>(r4, r1, r0)
            throw r3
        L_0x00f8:
            r2.g()
            java.lang.String r3 = r2.j
            return r3
        L_0x00fe:
            com.cardinalcommerce.dependencies.internal.minidev.json.b.i r3 = new com.cardinalcommerce.dependencies.internal.minidev.json.b.i
            int r4 = r2.k
            r0 = 0
            char r1 = r2.f1924a
            java.lang.Character r1 = java.lang.Character.valueOf(r1)
            r3.<init>(r4, r0, r1)
            throw r3
        L_0x010d:
            java.lang.Object r3 = r2.b(r4)
            return r3
        L_0x0112:
            com.cardinalcommerce.dependencies.internal.minidev.json.b.i r3 = new com.cardinalcommerce.dependencies.internal.minidev.json.b.i
            int r4 = r2.k
            java.lang.String r0 = r2.j
            r3.<init>(r4, r1, r0)
            throw r3
        L_0x011c:
            r2.d()
            goto L_0x0000
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cardinalcommerce.dependencies.internal.minidev.json.b.b.a(com.cardinalcommerce.dependencies.internal.minidev.json.d.j, boolean[]):java.lang.Object");
    }

    public abstract void a(boolean[] zArr);

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0043, code lost:
        if (r5 == ':') goto L_0x0074;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0047, code lost:
        if (r5 == ']') goto L_0x0057;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x004b, code lost:
        if (r5 == '}') goto L_0x0074;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0057, code lost:
        if (r4 == false) goto L_0x006c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x005b, code lost:
        if (r7.p == false) goto L_0x005e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x006b, code lost:
        throw new com.cardinalcommerce.dependencies.internal.minidev.json.b.i(r7.k, 0, java.lang.Character.valueOf(r7.f1924a));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x006c, code lost:
        d();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0073, code lost:
        return r8.a(r0);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public <T> T b(com.cardinalcommerce.dependencies.internal.minidev.json.d.j<T> r8) {
        /*
            r7 = this;
            java.lang.Object r0 = r8.a()
            char r1 = r7.f1924a
            r2 = 91
            if (r1 != r2) goto L_0x00ad
            r7.d()
            char r1 = r7.f1924a
            r2 = 44
            r3 = 0
            if (r1 != r2) goto L_0x0027
            boolean r1 = r7.p
            if (r1 == 0) goto L_0x0019
            goto L_0x0027
        L_0x0019:
            com.cardinalcommerce.dependencies.internal.minidev.json.b.i r8 = new com.cardinalcommerce.dependencies.internal.minidev.json.b.i
            int r0 = r7.k
            char r1 = r7.f1924a
            java.lang.Character r1 = java.lang.Character.valueOf(r1)
            r8.<init>(r0, r3, r1)
            throw r8
        L_0x0027:
            r1 = 1
        L_0x0028:
            r4 = 0
        L_0x0029:
            char r5 = r7.f1924a
            r6 = 9
            if (r5 == r6) goto L_0x00a8
            r6 = 10
            if (r5 == r6) goto L_0x00a8
            r6 = 13
            if (r5 == r6) goto L_0x00a8
            r6 = 26
            if (r5 == r6) goto L_0x009c
            r6 = 32
            if (r5 == r6) goto L_0x00a8
            if (r5 == r2) goto L_0x0082
            r6 = 58
            if (r5 == r6) goto L_0x0074
            r6 = 93
            if (r5 == r6) goto L_0x0057
            r4 = 125(0x7d, float:1.75E-43)
            if (r5 == r4) goto L_0x0074
            boolean[] r4 = f1921d
            java.lang.Object r4 = r7.a(r8, r4)
            r8.a(r0, r4)
            goto L_0x0028
        L_0x0057:
            if (r4 == 0) goto L_0x006c
            boolean r1 = r7.p
            if (r1 == 0) goto L_0x005e
            goto L_0x006c
        L_0x005e:
            com.cardinalcommerce.dependencies.internal.minidev.json.b.i r8 = new com.cardinalcommerce.dependencies.internal.minidev.json.b.i
            int r0 = r7.k
            char r1 = r7.f1924a
            java.lang.Character r1 = java.lang.Character.valueOf(r1)
            r8.<init>(r0, r3, r1)
            throw r8
        L_0x006c:
            r7.d()
            java.lang.Object r8 = r8.a(r0)
            return r8
        L_0x0074:
            com.cardinalcommerce.dependencies.internal.minidev.json.b.i r8 = new com.cardinalcommerce.dependencies.internal.minidev.json.b.i
            int r0 = r7.k
            char r1 = r7.f1924a
            java.lang.Character r1 = java.lang.Character.valueOf(r1)
            r8.<init>(r0, r3, r1)
            throw r8
        L_0x0082:
            if (r4 == 0) goto L_0x0097
            boolean r4 = r7.p
            if (r4 == 0) goto L_0x0089
            goto L_0x0097
        L_0x0089:
            com.cardinalcommerce.dependencies.internal.minidev.json.b.i r8 = new com.cardinalcommerce.dependencies.internal.minidev.json.b.i
            int r0 = r7.k
            char r1 = r7.f1924a
            java.lang.Character r1 = java.lang.Character.valueOf(r1)
            r8.<init>(r0, r3, r1)
            throw r8
        L_0x0097:
            r7.d()
            r4 = 1
            goto L_0x0029
        L_0x009c:
            com.cardinalcommerce.dependencies.internal.minidev.json.b.i r8 = new com.cardinalcommerce.dependencies.internal.minidev.json.b.i
            int r0 = r7.k
            int r0 = r0 - r1
            r1 = 3
            java.lang.String r2 = "EOF"
            r8.<init>(r0, r1, r2)
            throw r8
        L_0x00a8:
            r7.d()
            goto L_0x0029
        L_0x00ad:
            java.lang.RuntimeException r8 = new java.lang.RuntimeException
            java.lang.String r0 = "Internal Error"
            r8.<init>(r0)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cardinalcommerce.dependencies.internal.minidev.json.b.b.b(com.cardinalcommerce.dependencies.internal.minidev.json.d.j):java.lang.Object");
    }

    public abstract Object b(boolean[] zArr);

    public void b() {
        int length = this.j.length();
        if (length != 1) {
            if (length != 2) {
                char charAt = this.j.charAt(0);
                char charAt2 = this.j.charAt(1);
                if (charAt == '-') {
                    char charAt3 = this.j.charAt(2);
                    if (charAt2 == '0' && charAt3 >= '0' && charAt3 <= '9') {
                        throw new i(this.k, 6, this.j);
                    }
                } else if (charAt == '0' && charAt2 >= '0' && charAt2 <= '9') {
                    throw new i(this.k, 6, this.j);
                }
            } else if (this.j.equals("00")) {
                throw new i(this.k, 6, this.j);
            }
        }
    }

    public Number c() {
        if (!this.l) {
            b();
        }
        return !this.t ? Float.valueOf(Float.parseFloat(this.j)) : this.j.length() > 18 ? new BigDecimal(this.j) : Double.valueOf(Double.parseDouble(this.j));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00a0, code lost:
        throw new com.cardinalcommerce.dependencies.internal.minidev.json.b.i(r3.k, 0, java.lang.Character.valueOf(r3.f1924a));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x00db, code lost:
        r0 = b(g);
        r3.i = r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public <T> T c(com.cardinalcommerce.dependencies.internal.minidev.json.d.j<T> r4) {
        /*
            r3 = this;
        L_0x0000:
            char r0 = r3.f1924a
            r1 = 9
            if (r0 == r1) goto L_0x00ea
            r1 = 10
            if (r0 == r1) goto L_0x00ea
            r1 = 1
            switch(r0) {
                case 13: goto L_0x00ea;
                case 32: goto L_0x00ea;
                case 34: goto L_0x00e5;
                case 39: goto L_0x00e5;
                case 45: goto L_0x00db;
                case 78: goto L_0x00a6;
                case 91: goto L_0x00a1;
                case 93: goto L_0x0092;
                case 102: goto L_0x0071;
                case 110: goto L_0x0051;
                case 116: goto L_0x0030;
                case 123: goto L_0x002b;
                case 125: goto L_0x0092;
                default: goto L_0x000e;
            }
        L_0x000e:
            switch(r0) {
                case 48: goto L_0x00db;
                case 49: goto L_0x00db;
                case 50: goto L_0x00db;
                case 51: goto L_0x00db;
                case 52: goto L_0x00db;
                case 53: goto L_0x00db;
                case 54: goto L_0x00db;
                case 55: goto L_0x00db;
                case 56: goto L_0x00db;
                case 57: goto L_0x00db;
                case 58: goto L_0x0092;
                default: goto L_0x0011;
            }
        L_0x0011:
            boolean[] r0 = g
            r3.a(r0)
            boolean r0 = r3.n
            if (r0 == 0) goto L_0x0021
        L_0x001a:
            java.lang.String r0 = r3.j
        L_0x001c:
            java.lang.Object r4 = r4.a(r0)
            return r4
        L_0x0021:
            com.cardinalcommerce.dependencies.internal.minidev.json.b.i r4 = new com.cardinalcommerce.dependencies.internal.minidev.json.b.i
            int r0 = r3.k
            java.lang.String r2 = r3.j
            r4.<init>(r0, r1, r2)
            throw r4
        L_0x002b:
            java.lang.Object r4 = r3.d(r4)
            return r4
        L_0x0030:
            boolean[] r0 = g
            r3.a(r0)
            java.lang.String r0 = r3.j
            java.lang.String r2 = "true"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x0042
            java.lang.Boolean r0 = java.lang.Boolean.TRUE
            goto L_0x001c
        L_0x0042:
            boolean r0 = r3.n
            if (r0 == 0) goto L_0x0047
            goto L_0x001a
        L_0x0047:
            com.cardinalcommerce.dependencies.internal.minidev.json.b.i r4 = new com.cardinalcommerce.dependencies.internal.minidev.json.b.i
            int r0 = r3.k
            java.lang.String r2 = r3.j
            r4.<init>(r0, r1, r2)
            throw r4
        L_0x0051:
            boolean[] r0 = g
            r3.a(r0)
            java.lang.String r0 = r3.j
            java.lang.String r2 = "null"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x0062
            r4 = 0
            return r4
        L_0x0062:
            boolean r0 = r3.n
            if (r0 == 0) goto L_0x0067
            goto L_0x001a
        L_0x0067:
            com.cardinalcommerce.dependencies.internal.minidev.json.b.i r4 = new com.cardinalcommerce.dependencies.internal.minidev.json.b.i
            int r0 = r3.k
            java.lang.String r2 = r3.j
            r4.<init>(r0, r1, r2)
            throw r4
        L_0x0071:
            boolean[] r0 = g
            r3.a(r0)
            java.lang.String r0 = r3.j
            java.lang.String r2 = "false"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x0083
            java.lang.Boolean r0 = java.lang.Boolean.FALSE
            goto L_0x001c
        L_0x0083:
            boolean r0 = r3.n
            if (r0 == 0) goto L_0x0088
            goto L_0x001a
        L_0x0088:
            com.cardinalcommerce.dependencies.internal.minidev.json.b.i r4 = new com.cardinalcommerce.dependencies.internal.minidev.json.b.i
            int r0 = r3.k
            java.lang.String r2 = r3.j
            r4.<init>(r0, r1, r2)
            throw r4
        L_0x0092:
            com.cardinalcommerce.dependencies.internal.minidev.json.b.i r4 = new com.cardinalcommerce.dependencies.internal.minidev.json.b.i
            int r0 = r3.k
            r1 = 0
            char r2 = r3.f1924a
            java.lang.Character r2 = java.lang.Character.valueOf(r2)
            r4.<init>(r0, r1, r2)
            throw r4
        L_0x00a1:
            java.lang.Object r4 = r3.b(r4)
            return r4
        L_0x00a6:
            boolean[] r0 = g
            r3.a(r0)
            boolean r0 = r3.m
            if (r0 == 0) goto L_0x00d1
            java.lang.String r0 = r3.j
            java.lang.String r2 = "NaN"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x00c1
            r0 = 2143289344(0x7fc00000, float:NaN)
            java.lang.Float r0 = java.lang.Float.valueOf(r0)
            goto L_0x001c
        L_0x00c1:
            boolean r0 = r3.n
            if (r0 == 0) goto L_0x00c7
            goto L_0x001a
        L_0x00c7:
            com.cardinalcommerce.dependencies.internal.minidev.json.b.i r4 = new com.cardinalcommerce.dependencies.internal.minidev.json.b.i
            int r0 = r3.k
            java.lang.String r2 = r3.j
            r4.<init>(r0, r1, r2)
            throw r4
        L_0x00d1:
            com.cardinalcommerce.dependencies.internal.minidev.json.b.i r4 = new com.cardinalcommerce.dependencies.internal.minidev.json.b.i
            int r0 = r3.k
            java.lang.String r2 = r3.j
            r4.<init>(r0, r1, r2)
            throw r4
        L_0x00db:
            boolean[] r0 = g
            java.lang.Object r0 = r3.b(r0)
            r3.i = r0
            goto L_0x001c
        L_0x00e5:
            r3.g()
            goto L_0x001a
        L_0x00ea:
            r3.d()
            goto L_0x0000
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cardinalcommerce.dependencies.internal.minidev.json.b.b.c(com.cardinalcommerce.dependencies.internal.minidev.json.d.j):java.lang.Object");
    }

    public void c(boolean[] zArr) {
        while (true) {
            char c2 = this.f1924a;
            if (c2 == 26) {
                return;
            }
            if (c2 < 0 || c2 >= '~' || !zArr[c2]) {
                f();
            } else {
                return;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:59:0x00f7, code lost:
        throw new com.cardinalcommerce.dependencies.internal.minidev.json.b.i(r13.k, 0, java.lang.Character.valueOf(r13.f1924a));
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public <T> T d(com.cardinalcommerce.dependencies.internal.minidev.json.d.j<T> r14) {
        /*
            r13 = this;
            char r0 = r13.f1924a
            r1 = 123(0x7b, float:1.72E-43)
            if (r0 != r1) goto L_0x0110
            java.lang.Object r0 = r14.b()
            r2 = 0
            r3 = 1
            r4 = 0
        L_0x000d:
            r13.d()
            char r5 = r13.f1924a
            r6 = 9
            if (r5 == r6) goto L_0x000d
            r6 = 10
            if (r5 == r6) goto L_0x000d
            r6 = 13
            if (r5 == r6) goto L_0x000d
            r6 = 32
            if (r5 == r6) goto L_0x000d
            r6 = 44
            if (r5 == r6) goto L_0x00f8
            r7 = 58
            if (r5 == r7) goto L_0x00ea
            r8 = 91
            if (r5 == r8) goto L_0x00ea
            r8 = 93
            if (r5 == r8) goto L_0x00ea
            if (r5 == r1) goto L_0x00ea
            r8 = 125(0x7d, float:1.75E-43)
            if (r5 == r8) goto L_0x00d5
            r4 = 34
            if (r5 == r4) goto L_0x0055
            r4 = 39
            if (r5 != r4) goto L_0x0041
            goto L_0x0055
        L_0x0041:
            boolean[] r4 = f1922e
            r13.a(r4)
            boolean r4 = r13.n
            if (r4 == 0) goto L_0x004b
            goto L_0x0058
        L_0x004b:
            com.cardinalcommerce.dependencies.internal.minidev.json.b.i r14 = new com.cardinalcommerce.dependencies.internal.minidev.json.b.i
            int r0 = r13.k
            java.lang.String r1 = r13.j
            r14.<init>(r0, r3, r1)
            throw r14
        L_0x0055:
            r13.g()
        L_0x0058:
            java.lang.String r4 = r13.j
            r13.j()
            char r5 = r13.f1924a
            r9 = 0
            r10 = 3
            r11 = 26
            if (r5 == r7) goto L_0x007a
            com.cardinalcommerce.dependencies.internal.minidev.json.b.i r14 = new com.cardinalcommerce.dependencies.internal.minidev.json.b.i
            int r0 = r13.k
            int r0 = r0 - r3
            if (r5 != r11) goto L_0x0070
            r14.<init>(r0, r10, r9)
            throw r14
        L_0x0070:
            char r1 = r13.f1924a
            java.lang.Character r1 = java.lang.Character.valueOf(r1)
            r14.<init>(r0, r2, r1)
            throw r14
        L_0x007a:
            r5 = r13
            com.cardinalcommerce.dependencies.internal.minidev.json.b.h r5 = (com.cardinalcommerce.dependencies.internal.minidev.json.b.h) r5
            int r7 = r5.k
            int r7 = r7 + r3
            r5.k = r7
            int r12 = r5.w
            if (r7 >= r12) goto L_0x00c7
            java.lang.String r12 = r5.x
            char r7 = r12.charAt(r7)
            r5.f1924a = r7
            r13.w = r4
            boolean[] r5 = f1923f
            java.lang.Object r5 = r13.a(r14, r5)
            r14.a(r0, r4, r5)
            r13.w = r9
            r13.j()
            char r4 = r13.f1924a
            if (r4 != r8) goto L_0x00aa
        L_0x00a2:
            r13.d()
            java.lang.Object r14 = r14.a(r0)
            return r14
        L_0x00aa:
            if (r4 == r11) goto L_0x00be
            if (r4 != r6) goto L_0x00af
            goto L_0x010d
        L_0x00af:
            com.cardinalcommerce.dependencies.internal.minidev.json.b.i r14 = new com.cardinalcommerce.dependencies.internal.minidev.json.b.i
            int r0 = r13.k
            int r0 = r0 - r3
            char r1 = r13.f1924a
            java.lang.Character r1 = java.lang.Character.valueOf(r1)
            r14.<init>(r0, r3, r1)
            throw r14
        L_0x00be:
            com.cardinalcommerce.dependencies.internal.minidev.json.b.i r14 = new com.cardinalcommerce.dependencies.internal.minidev.json.b.i
            int r0 = r13.k
            int r0 = r0 - r3
            r14.<init>(r0, r10, r9)
            throw r14
        L_0x00c7:
            r5.f1924a = r11
            com.cardinalcommerce.dependencies.internal.minidev.json.b.i r14 = new com.cardinalcommerce.dependencies.internal.minidev.json.b.i
            int r0 = r5.k
            int r0 = r0 + -1
            java.lang.String r1 = "EOF"
            r14.<init>(r0, r10, r1)
            throw r14
        L_0x00d5:
            if (r4 == 0) goto L_0x00a2
            boolean r1 = r13.p
            if (r1 == 0) goto L_0x00dc
            goto L_0x00a2
        L_0x00dc:
            com.cardinalcommerce.dependencies.internal.minidev.json.b.i r14 = new com.cardinalcommerce.dependencies.internal.minidev.json.b.i
            int r0 = r13.k
            char r1 = r13.f1924a
            java.lang.Character r1 = java.lang.Character.valueOf(r1)
            r14.<init>(r0, r2, r1)
            throw r14
        L_0x00ea:
            com.cardinalcommerce.dependencies.internal.minidev.json.b.i r14 = new com.cardinalcommerce.dependencies.internal.minidev.json.b.i
            int r0 = r13.k
            char r1 = r13.f1924a
            java.lang.Character r1 = java.lang.Character.valueOf(r1)
            r14.<init>(r0, r2, r1)
            throw r14
        L_0x00f8:
            if (r4 == 0) goto L_0x010d
            boolean r4 = r13.p
            if (r4 == 0) goto L_0x00ff
            goto L_0x010d
        L_0x00ff:
            com.cardinalcommerce.dependencies.internal.minidev.json.b.i r14 = new com.cardinalcommerce.dependencies.internal.minidev.json.b.i
            int r0 = r13.k
            char r1 = r13.f1924a
            java.lang.Character r1 = java.lang.Character.valueOf(r1)
            r14.<init>(r0, r2, r1)
            throw r14
        L_0x010d:
            r4 = 1
            goto L_0x000d
        L_0x0110:
            java.lang.RuntimeException r14 = new java.lang.RuntimeException
            java.lang.String r0 = "Internal Error"
            r14.<init>(r0)
            throw r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cardinalcommerce.dependencies.internal.minidev.json.b.b.d(com.cardinalcommerce.dependencies.internal.minidev.json.d.j):java.lang.Object");
    }

    public abstract void d();

    public abstract void f();

    public abstract void g();

    public void i() {
        while (true) {
            char c2 = this.f1924a;
            if (c2 >= '0' && c2 <= '9') {
                f();
            } else {
                return;
            }
        }
    }

    public void j() {
        while (true) {
            char c2 = this.f1924a;
            if (c2 <= ' ' && c2 != 26) {
                f();
            } else {
                return;
            }
        }
    }
}
