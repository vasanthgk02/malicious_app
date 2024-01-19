package com.userexperior.a.a.d;

import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.Writer;
import org.apache.fontbox.cmap.CMapParser;
import org.apache.pdfbox.pdfparser.BaseParser;

public class c implements Closeable, Flushable {

    /* renamed from: a  reason: collision with root package name */
    public static final String[] f3734a = new String[128];

    /* renamed from: b  reason: collision with root package name */
    public static final String[] f3735b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f3736c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f3737d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f3738e;

    /* renamed from: f  reason: collision with root package name */
    public final Writer f3739f;
    public int[] g = new int[32];
    public int h = 0;
    public String i;
    public String j;
    public String k;

    static {
        for (int i2 = 0; i2 <= 31; i2++) {
            f3734a[i2] = String.format("\\u%04x", new Object[]{Integer.valueOf(i2)});
        }
        String[] strArr = f3734a;
        strArr[34] = "\\\"";
        strArr[92] = "\\\\";
        strArr[9] = "\\t";
        strArr[8] = "\\b";
        strArr[10] = "\\n";
        strArr[13] = "\\r";
        strArr[12] = "\\f";
        String[] strArr2 = (String[]) strArr.clone();
        f3735b = strArr2;
        strArr2[60] = "\\u003c";
        strArr2[62] = "\\u003e";
        strArr2[38] = "\\u0026";
        strArr2[61] = "\\u003d";
        strArr2[39] = "\\u0027";
    }

    public c(Writer writer) {
        a(6);
        this.j = ":";
        this.f3738e = true;
        if (writer != null) {
            this.f3739f = writer;
            return;
        }
        throw new NullPointerException("out == null");
    }

    private c a(int i2, int i3, String str) throws IOException {
        int f2 = f();
        if (f2 != i3 && f2 != i2) {
            throw new IllegalStateException("Nesting problem.");
        } else if (this.k == null) {
            this.h--;
            if (f2 == i3) {
                h();
            }
            this.f3739f.write(str);
            return this;
        } else {
            throw new IllegalStateException("Dangling name: " + this.k);
        }
    }

    private c a(int i2, String str) throws IOException {
        j();
        a(i2);
        this.f3739f.write(str);
        return this;
    }

    private void a(int i2) {
        int i3 = this.h;
        int[] iArr = this.g;
        if (i3 == iArr.length) {
            int[] iArr2 = new int[(i3 * 2)];
            System.arraycopy(iArr, 0, iArr2, 0, i3);
            this.g = iArr2;
        }
        int[] iArr3 = this.g;
        int i4 = this.h;
        this.h = i4 + 1;
        iArr3[i4] = i2;
    }

    private void b(int i2) {
        this.g[this.h - 1] = i2;
    }

    private void d(String str) throws IOException {
        String str2;
        String[] strArr = this.f3737d ? f3735b : f3734a;
        this.f3739f.write("\"");
        int length = str.length();
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3++) {
            char charAt = str.charAt(i3);
            if (charAt < 128) {
                str2 = strArr[charAt];
                if (str2 == null) {
                }
            } else if (charAt == 8232) {
                str2 = "\\u2028";
            } else if (charAt == 8233) {
                str2 = "\\u2029";
            }
            if (i2 < i3) {
                this.f3739f.write(str, i2, i3 - i2);
            }
            this.f3739f.write(str2);
            i2 = i3 + 1;
        }
        if (i2 < length) {
            this.f3739f.write(str, i2, length - i2);
        }
        this.f3739f.write("\"");
    }

    private int f() {
        int i2 = this.h;
        if (i2 != 0) {
            return this.g[i2 - 1];
        }
        throw new IllegalStateException("JsonWriter is closed.");
    }

    private void g() throws IOException {
        if (this.k != null) {
            i();
            d(this.k);
            this.k = null;
        }
    }

    private void h() throws IOException {
        if (this.i != null) {
            this.f3739f.write("\n");
            int i2 = this.h;
            for (int i3 = 1; i3 < i2; i3++) {
                this.f3739f.write(this.i);
            }
        }
    }

    private void i() throws IOException {
        int f2 = f();
        if (f2 == 5) {
            this.f3739f.write(44);
        } else if (f2 != 3) {
            throw new IllegalStateException("Nesting problem.");
        }
        h();
        b(4);
    }

    private void j() throws IOException {
        int f2 = f();
        if (f2 == 1) {
            b(2);
            h();
        } else if (f2 == 2) {
            this.f3739f.append(',');
            h();
        } else if (f2 != 4) {
            if (f2 != 6) {
                if (f2 != 7) {
                    throw new IllegalStateException("Nesting problem.");
                } else if (!this.f3736c) {
                    throw new IllegalStateException("JSON must have only one top-level value.");
                }
            }
            b(7);
        } else {
            this.f3739f.append(this.j);
            b(5);
        }
    }

    public c a() throws IOException {
        g();
        return a(1, "[");
    }

    public c a(long j2) throws IOException {
        g();
        j();
        this.f3739f.write(Long.toString(j2));
        return this;
    }

    public c a(Boolean bool) throws IOException {
        if (bool == null) {
            return e();
        }
        g();
        j();
        this.f3739f.write(bool.booleanValue() ? BaseParser.TRUE : BaseParser.FALSE);
        return this;
    }

    public c a(Number number) throws IOException {
        if (number == null) {
            return e();
        }
        g();
        String obj = number.toString();
        if (this.f3736c || (!obj.equals("-Infinity") && !obj.equals("Infinity") && !obj.equals("NaN"))) {
            j();
            this.f3739f.append(obj);
            return this;
        }
        throw new IllegalArgumentException("Numeric values must be finite, but was ".concat(String.valueOf(number)));
    }

    public c a(String str) throws IOException {
        if (str == null) {
            throw new NullPointerException("name == null");
        } else if (this.k != null) {
            throw new IllegalStateException();
        } else if (this.h != 0) {
            this.k = str;
            return this;
        } else {
            throw new IllegalStateException("JsonWriter is closed.");
        }
    }

    public c a(boolean z) throws IOException {
        g();
        j();
        this.f3739f.write(z ? BaseParser.TRUE : BaseParser.FALSE);
        return this;
    }

    public c b() throws IOException {
        return a(1, 2, CMapParser.MARK_END_OF_ARRAY);
    }

    public c b(String str) throws IOException {
        if (str == null) {
            return e();
        }
        g();
        j();
        d(str);
        return this;
    }

    public c c() throws IOException {
        g();
        return a(3, "{");
    }

    public final void c(String str) {
        String str2;
        if (str.length() == 0) {
            this.i = null;
            str2 = ":";
        } else {
            this.i = str;
            str2 = ": ";
        }
        this.j = str2;
    }

    public void close() throws IOException {
        this.f3739f.close();
        int i2 = this.h;
        if (i2 > 1 || (i2 == 1 && this.g[i2 - 1] != 7)) {
            throw new IOException("Incomplete document");
        }
        this.h = 0;
    }

    public c d() throws IOException {
        return a(3, 5, "}");
    }

    public c e() throws IOException {
        if (this.k != null) {
            if (this.f3738e) {
                g();
            } else {
                this.k = null;
                return this;
            }
        }
        j();
        this.f3739f.write("null");
        return this;
    }

    public void flush() throws IOException {
        if (this.h != 0) {
            this.f3739f.flush();
            return;
        }
        throw new IllegalStateException("JsonWriter is closed.");
    }
}
