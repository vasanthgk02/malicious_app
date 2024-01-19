package com.userexperior.a.a.b.a;

import com.userexperior.a.a.d.a;
import com.userexperior.a.a.d.b;
import com.userexperior.a.a.j;
import com.userexperior.a.a.n;
import com.userexperior.a.a.o;
import com.userexperior.a.a.q;
import java.io.IOException;
import java.io.Reader;
import java.util.Iterator;
import java.util.Map.Entry;
import sfs2x.client.entities.variables.SFSBuddyVariable;

public final class f extends a {

    /* renamed from: c  reason: collision with root package name */
    public static final Reader f3579c = new Reader() {
        public final void close() throws IOException {
            throw new AssertionError();
        }

        public final int read(char[] cArr, int i, int i2) throws IOException {
            throw new AssertionError();
        }
    };

    /* renamed from: d  reason: collision with root package name */
    public static final Object f3580d = new Object();

    /* renamed from: e  reason: collision with root package name */
    public Object[] f3581e;

    /* renamed from: f  reason: collision with root package name */
    public int f3582f;
    public String[] g;
    public int[] h;

    private Object r() {
        Object[] objArr = this.f3581e;
        int i = this.f3582f - 1;
        this.f3582f = i;
        Object obj = objArr[i];
        objArr[i] = null;
        return obj;
    }

    private String s() {
        return " at path " + p();
    }

    public final void a() throws IOException {
        a(b.BEGIN_ARRAY);
        a((Object) ((j) g()).iterator());
        this.h[this.f3582f - 1] = 0;
    }

    public final void a(b bVar) throws IOException {
        if (f() != bVar) {
            throw new IllegalStateException("Expected " + bVar + " but was " + f() + s());
        }
    }

    public final void a(Object obj) {
        int i = this.f3582f;
        Object[] objArr = this.f3581e;
        if (i == objArr.length) {
            Object[] objArr2 = new Object[(i * 2)];
            int[] iArr = new int[(i * 2)];
            String[] strArr = new String[(i * 2)];
            System.arraycopy(objArr, 0, objArr2, 0, i);
            System.arraycopy(this.h, 0, iArr, 0, this.f3582f);
            System.arraycopy(this.g, 0, strArr, 0, this.f3582f);
            this.f3581e = objArr2;
            this.h = iArr;
            this.g = strArr;
        }
        Object[] objArr3 = this.f3581e;
        int i2 = this.f3582f;
        this.f3582f = i2 + 1;
        objArr3[i2] = obj;
    }

    public final void b() throws IOException {
        a(b.END_ARRAY);
        r();
        r();
        int i = this.f3582f;
        if (i > 0) {
            int[] iArr = this.h;
            int i2 = i - 1;
            iArr[i2] = iArr[i2] + 1;
        }
    }

    public final void c() throws IOException {
        a(b.BEGIN_OBJECT);
        a((Object) ((o) g()).f3759a.entrySet().iterator());
    }

    public final void close() throws IOException {
        this.f3581e = new Object[]{f3580d};
        this.f3582f = 1;
    }

    public final void d() throws IOException {
        a(b.END_OBJECT);
        r();
        r();
        int i = this.f3582f;
        if (i > 0) {
            int[] iArr = this.h;
            int i2 = i - 1;
            iArr[i2] = iArr[i2] + 1;
        }
    }

    public final boolean e() throws IOException {
        b f2 = f();
        return (f2 == b.END_OBJECT || f2 == b.END_ARRAY) ? false : true;
    }

    public final b f() throws IOException {
        while (this.f3582f != 0) {
            Object g2 = g();
            if (g2 instanceof Iterator) {
                boolean z = this.f3581e[this.f3582f - 2] instanceof o;
                Iterator it = (Iterator) g2;
                if (!it.hasNext()) {
                    return z ? b.END_OBJECT : b.END_ARRAY;
                }
                if (z) {
                    return b.NAME;
                }
                a(it.next());
            } else if (g2 instanceof o) {
                return b.BEGIN_OBJECT;
            } else {
                if (g2 instanceof j) {
                    return b.BEGIN_ARRAY;
                }
                if (g2 instanceof q) {
                    Object obj = ((q) g2).f3761a;
                    if (obj instanceof String) {
                        return b.STRING;
                    }
                    if (obj instanceof Boolean) {
                        return b.BOOLEAN;
                    }
                    if (obj instanceof Number) {
                        return b.NUMBER;
                    }
                    throw new AssertionError();
                } else if (g2 instanceof n) {
                    return b.NULL;
                } else {
                    if (g2 == f3580d) {
                        throw new IllegalStateException("JsonReader is closed");
                    }
                    throw new AssertionError();
                }
            }
        }
        return b.END_DOCUMENT;
    }

    public final Object g() {
        return this.f3581e[this.f3582f - 1];
    }

    public final String h() throws IOException {
        a(b.NAME);
        Entry entry = (Entry) ((Iterator) g()).next();
        String str = (String) entry.getKey();
        this.g[this.f3582f - 1] = str;
        a(entry.getValue());
        return str;
    }

    public final String i() throws IOException {
        b f2 = f();
        if (f2 == b.STRING || f2 == b.NUMBER) {
            String b2 = ((q) r()).b();
            int i = this.f3582f;
            if (i > 0) {
                int[] iArr = this.h;
                int i2 = i - 1;
                iArr[i2] = iArr[i2] + 1;
            }
            return b2;
        }
        throw new IllegalStateException("Expected " + b.STRING + " but was " + f2 + s());
    }

    public final boolean j() throws IOException {
        a(b.BOOLEAN);
        boolean f2 = ((q) r()).f();
        int i = this.f3582f;
        if (i > 0) {
            int[] iArr = this.h;
            int i2 = i - 1;
            iArr[i2] = iArr[i2] + 1;
        }
        return f2;
    }

    public final void k() throws IOException {
        a(b.NULL);
        r();
        int i = this.f3582f;
        if (i > 0) {
            int[] iArr = this.h;
            int i2 = i - 1;
            iArr[i2] = iArr[i2] + 1;
        }
    }

    public final double l() throws IOException {
        b f2 = f();
        if (f2 == b.NUMBER || f2 == b.STRING) {
            double c2 = ((q) g()).c();
            if (this.f3729a || (!Double.isNaN(c2) && !Double.isInfinite(c2))) {
                r();
                int i = this.f3582f;
                if (i > 0) {
                    int[] iArr = this.h;
                    int i2 = i - 1;
                    iArr[i2] = iArr[i2] + 1;
                }
                return c2;
            }
            throw new NumberFormatException("JSON forbids NaN and infinities: ".concat(String.valueOf(c2)));
        }
        throw new IllegalStateException("Expected " + b.NUMBER + " but was " + f2 + s());
    }

    public final long m() throws IOException {
        b f2 = f();
        if (f2 == b.NUMBER || f2 == b.STRING) {
            long d2 = ((q) g()).d();
            r();
            int i = this.f3582f;
            if (i > 0) {
                int[] iArr = this.h;
                int i2 = i - 1;
                iArr[i2] = iArr[i2] + 1;
            }
            return d2;
        }
        throw new IllegalStateException("Expected " + b.NUMBER + " but was " + f2 + s());
    }

    public final int n() throws IOException {
        b f2 = f();
        if (f2 == b.NUMBER || f2 == b.STRING) {
            int e2 = ((q) g()).e();
            r();
            int i = this.f3582f;
            if (i > 0) {
                int[] iArr = this.h;
                int i2 = i - 1;
                iArr[i2] = iArr[i2] + 1;
            }
            return e2;
        }
        throw new IllegalStateException("Expected " + b.NUMBER + " but was " + f2 + s());
    }

    public final void o() throws IOException {
        if (f() == b.NAME) {
            h();
            this.g[this.f3582f - 2] = "null";
        } else {
            r();
            this.g[this.f3582f - 1] = "null";
        }
        int[] iArr = this.h;
        int i = this.f3582f - 1;
        iArr[i] = iArr[i] + 1;
    }

    public final String p() {
        StringBuilder sb = new StringBuilder(SFSBuddyVariable.OFFLINE_PREFIX);
        int i = 0;
        while (i < this.f3582f) {
            Object[] objArr = this.f3581e;
            if (objArr[i] instanceof j) {
                i++;
                if (objArr[i] instanceof Iterator) {
                    sb.append('[');
                    sb.append(this.h[i]);
                    sb.append(']');
                }
            } else if (objArr[i] instanceof o) {
                i++;
                if (objArr[i] instanceof Iterator) {
                    sb.append('.');
                    String[] strArr = this.g;
                    if (strArr[i] != null) {
                        sb.append(strArr[i]);
                    }
                }
            }
            i++;
        }
        return sb.toString();
    }

    public final String toString() {
        return f.class.getSimpleName();
    }
}
