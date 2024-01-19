package com.userexperior.a.a.b.a;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.userexperior.a.a.d.c;
import com.userexperior.a.a.j;
import com.userexperior.a.a.l;
import com.userexperior.a.a.n;
import com.userexperior.a.a.o;
import com.userexperior.a.a.q;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public final class g extends c {

    /* renamed from: f  reason: collision with root package name */
    public static final Writer f3583f = new Writer() {
        public final void close() throws IOException {
            throw new AssertionError();
        }

        public final void flush() throws IOException {
            throw new AssertionError();
        }

        public final void write(char[] cArr, int i, int i2) {
            throw new AssertionError();
        }
    };
    public static final q g = new q((String) "closed");

    /* renamed from: a  reason: collision with root package name */
    public final List<l> f3584a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    public l f3585b = n.f3758a;
    public String h;

    public g() {
        super(f3583f);
    }

    private void a(l lVar) {
        if (this.h != null) {
            if (!(lVar instanceof n) || this.f3738e) {
                ((o) f()).a(this.h, lVar);
            }
            this.h = null;
        } else if (this.f3584a.isEmpty()) {
            this.f3585b = lVar;
        } else {
            l f2 = f();
            if (f2 instanceof j) {
                ((j) f2).a(lVar);
                return;
            }
            throw new IllegalStateException();
        }
    }

    private l f() {
        return (l) GeneratedOutlineSupport.outline29(this.f3584a, -1);
    }

    public final c a() throws IOException {
        j jVar = new j();
        a((l) jVar);
        this.f3584a.add(jVar);
        return this;
    }

    public final c a(long j) throws IOException {
        a((l) new q((Number) Long.valueOf(j)));
        return this;
    }

    public final c a(Boolean bool) throws IOException {
        if (bool == null) {
            return e();
        }
        a((l) new q(bool));
        return this;
    }

    public final c a(Number number) throws IOException {
        if (number == null) {
            return e();
        }
        if (!this.f3736c) {
            double doubleValue = number.doubleValue();
            if (Double.isNaN(doubleValue) || Double.isInfinite(doubleValue)) {
                throw new IllegalArgumentException("JSON forbids NaN and infinities: ".concat(String.valueOf(number)));
            }
        }
        a((l) new q(number));
        return this;
    }

    public final c a(String str) throws IOException {
        if (this.f3584a.isEmpty() || this.h != null) {
            throw new IllegalStateException();
        } else if (f() instanceof o) {
            this.h = str;
            return this;
        } else {
            throw new IllegalStateException();
        }
    }

    public final c a(boolean z) throws IOException {
        a((l) new q(Boolean.valueOf(z)));
        return this;
    }

    public final c b() throws IOException {
        if (this.f3584a.isEmpty() || this.h != null) {
            throw new IllegalStateException();
        } else if (f() instanceof j) {
            List<l> list = this.f3584a;
            list.remove(list.size() - 1);
            return this;
        } else {
            throw new IllegalStateException();
        }
    }

    public final c b(String str) throws IOException {
        if (str == null) {
            return e();
        }
        a((l) new q(str));
        return this;
    }

    public final c c() throws IOException {
        o oVar = new o();
        a((l) oVar);
        this.f3584a.add(oVar);
        return this;
    }

    public final void close() throws IOException {
        if (this.f3584a.isEmpty()) {
            this.f3584a.add(g);
            return;
        }
        throw new IOException("Incomplete document");
    }

    public final c d() throws IOException {
        if (this.f3584a.isEmpty() || this.h != null) {
            throw new IllegalStateException();
        } else if (f() instanceof o) {
            List<l> list = this.f3584a;
            list.remove(list.size() - 1);
            return this;
        } else {
            throw new IllegalStateException();
        }
    }

    public final c e() throws IOException {
        a((l) n.f3758a);
        return this;
    }

    public final void flush() throws IOException {
    }
}
