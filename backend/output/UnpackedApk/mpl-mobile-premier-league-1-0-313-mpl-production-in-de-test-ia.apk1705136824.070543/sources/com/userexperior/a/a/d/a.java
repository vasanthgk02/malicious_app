package com.userexperior.a.a.d;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.google.gson.Gson;
import com.userexperior.a.a.b.a.f;
import com.userexperior.a.a.b.h;
import com.userexperior.a.a.q;
import java.io.Closeable;
import java.io.IOException;
import java.io.Reader;
import java.util.Iterator;
import java.util.Map.Entry;
import org.apache.commons.lang.StringEscapeUtils;
import org.apache.commons.lang.text.ExtendedMessageFormat;
import org.apache.pdfbox.pdfparser.BaseParser;
import org.apache.pdfbox.pdmodel.common.function.type4.Parser.Tokenizer;
import sfs2x.client.entities.variables.SFSBuddyVariable;

public class a implements Closeable {

    /* renamed from: c  reason: collision with root package name */
    public static final char[] f3728c = Gson.JSON_NON_EXECUTABLE_PREFIX.toCharArray();

    /* renamed from: a  reason: collision with root package name */
    public boolean f3729a = false;

    /* renamed from: b  reason: collision with root package name */
    public int f3730b = 0;

    /* renamed from: d  reason: collision with root package name */
    public final Reader f3731d;

    /* renamed from: e  reason: collision with root package name */
    public final char[] f3732e = new char[1024];

    /* renamed from: f  reason: collision with root package name */
    public int f3733f = 0;
    public int g = 0;
    public int h = 0;
    public int i = 0;
    public long j;
    public int k;
    public String l;
    public int[] m;
    public int n;
    public String[] o;
    public int[] p;

    static {
        h.f3692a = new h() {
            public final void a(a aVar) throws IOException {
                if (aVar instanceof f) {
                    f fVar = (f) aVar;
                    fVar.a(b.NAME);
                    Entry entry = (Entry) ((Iterator) fVar.g()).next();
                    fVar.a(entry.getValue());
                    fVar.a((Object) new q((String) entry.getKey()));
                    return;
                }
                int i = aVar.f3730b;
                if (i == 0) {
                    i = aVar.q();
                }
                if (i == 13) {
                    aVar.f3730b = 9;
                } else if (i == 12) {
                    aVar.f3730b = 8;
                } else if (i == 14) {
                    aVar.f3730b = 10;
                } else {
                    throw new IllegalStateException("Expected a name but was " + aVar.f() + aVar.v());
                }
            }
        };
    }

    public a(Reader reader) {
        int[] iArr = new int[32];
        this.m = iArr;
        this.n = 0;
        this.n = 0 + 1;
        iArr[0] = 6;
        this.o = new String[32];
        this.p = new int[32];
        if (reader != null) {
            this.f3731d = reader;
            return;
        }
        throw new NullPointerException("in == null");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0050, code lost:
        if (r1 != '/') goto L_0x0092;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0052, code lost:
        r7.f3733f = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0055, code lost:
        if (r4 != r2) goto L_0x0067;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0057, code lost:
        r7.f3733f = r4 - 1;
        r2 = b(2);
        r7.f3733f++;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0064, code lost:
        if (r2 != false) goto L_0x0067;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0066, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0067, code lost:
        t();
        r2 = r7.f3733f;
        r3 = r0[r2];
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0070, code lost:
        if (r3 == '*') goto L_0x007a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0072, code lost:
        if (r3 == '/') goto L_0x0075;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0074, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0075, code lost:
        r7.f3733f = r2 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x007a, code lost:
        r7.f3733f = r2 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0084, code lost:
        if (a((java.lang.String) "*/") == false) goto L_0x008b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0091, code lost:
        throw b((java.lang.String) "Unterminated comment");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0092, code lost:
        r7.f3733f = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x0096, code lost:
        if (r1 != '#') goto L_0x00a0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x0098, code lost:
        t();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00a0, code lost:
        return r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int a(boolean r8) throws java.io.IOException {
        /*
            r7 = this;
            char[] r0 = r7.f3732e
        L_0x0002:
            int r1 = r7.f3733f
        L_0x0004:
            int r2 = r7.g
        L_0x0006:
            r3 = 1
            if (r1 != r2) goto L_0x0032
            r7.f3733f = r1
            boolean r1 = r7.b(r3)
            if (r1 == 0) goto L_0x0016
            int r1 = r7.f3733f
            int r2 = r7.g
            goto L_0x0032
        L_0x0016:
            if (r8 != 0) goto L_0x001a
            r8 = -1
            return r8
        L_0x001a:
            java.io.EOFException r8 = new java.io.EOFException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "End of input"
            r0.<init>(r1)
            java.lang.String r1 = r7.v()
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r8.<init>(r0)
            throw r8
        L_0x0032:
            int r4 = r1 + 1
            char r1 = r0[r1]
            r5 = 10
            if (r1 != r5) goto L_0x0042
            int r1 = r7.h
            int r1 = r1 + r3
            r7.h = r1
            r7.i = r4
            goto L_0x00a1
        L_0x0042:
            r5 = 32
            if (r1 == r5) goto L_0x00a1
            r5 = 13
            if (r1 == r5) goto L_0x00a1
            r5 = 9
            if (r1 == r5) goto L_0x00a1
            r5 = 47
            if (r1 != r5) goto L_0x0092
            r7.f3733f = r4
            r6 = 2
            if (r4 != r2) goto L_0x0067
            int r4 = r4 + -1
            r7.f3733f = r4
            boolean r2 = r7.b(r6)
            int r4 = r7.f3733f
            int r4 = r4 + r3
            r7.f3733f = r4
            if (r2 != 0) goto L_0x0067
            return r1
        L_0x0067:
            r7.t()
            int r2 = r7.f3733f
            char r3 = r0[r2]
            r4 = 42
            if (r3 == r4) goto L_0x007a
            if (r3 == r5) goto L_0x0075
            return r1
        L_0x0075:
            int r2 = r2 + 1
            r7.f3733f = r2
            goto L_0x009b
        L_0x007a:
            int r2 = r2 + 1
            r7.f3733f = r2
            java.lang.String r1 = "*/"
            boolean r1 = r7.a(r1)
            if (r1 == 0) goto L_0x008b
            int r1 = r7.f3733f
            int r1 = r1 + r6
            goto L_0x0004
        L_0x008b:
            java.lang.String r8 = "Unterminated comment"
            java.io.IOException r8 = r7.b(r8)
            throw r8
        L_0x0092:
            r2 = 35
            r7.f3733f = r4
            if (r1 != r2) goto L_0x00a0
            r7.t()
        L_0x009b:
            r7.u()
            goto L_0x0002
        L_0x00a0:
            return r1
        L_0x00a1:
            r1 = r4
            goto L_0x0006
        */
        throw new UnsupportedOperationException("Method not decompiled: com.userexperior.a.a.d.a.a(boolean):int");
    }

    private void a(int i2) {
        int i3 = this.n;
        int[] iArr = this.m;
        if (i3 == iArr.length) {
            int[] iArr2 = new int[(i3 * 2)];
            int[] iArr3 = new int[(i3 * 2)];
            String[] strArr = new String[(i3 * 2)];
            System.arraycopy(iArr, 0, iArr2, 0, i3);
            System.arraycopy(this.p, 0, iArr3, 0, this.n);
            System.arraycopy(this.o, 0, strArr, 0, this.n);
            this.m = iArr2;
            this.p = iArr3;
            this.o = strArr;
        }
        int[] iArr4 = this.m;
        int i4 = this.n;
        this.n = i4 + 1;
        iArr4[i4] = i2;
    }

    private boolean a(char c2) throws IOException {
        if (!(c2 == 9 || c2 == 10 || c2 == 12 || c2 == 13 || c2 == ' ')) {
            if (c2 != '#') {
                if (c2 != ',') {
                    if (!(c2 == '/' || c2 == '=')) {
                        if (!(c2 == '{' || c2 == '}' || c2 == ':')) {
                            if (c2 != ';') {
                                switch (c2) {
                                    case '[':
                                    case ']':
                                        break;
                                    case '\\':
                                        break;
                                    default:
                                        return true;
                                }
                            }
                        }
                    }
                }
            }
            t();
        }
        return false;
    }

    private boolean a(String str) throws IOException {
        while (true) {
            int i2 = 0;
            if (str.length() + this.f3733f > this.g && !b(str.length())) {
                return false;
            }
            char[] cArr = this.f3732e;
            int i3 = this.f3733f;
            if (cArr[i3] == 10) {
                this.h++;
                this.i = i3 + 1;
            } else {
                while (i2 < str.length()) {
                    if (this.f3732e[this.f3733f + i2] == str.charAt(i2)) {
                        i2++;
                    }
                }
                return true;
            }
            this.f3733f++;
        }
    }

    private IOException b(String str) throws IOException {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73(str);
        outline73.append(v());
        throw new d(outline73.toString());
    }

    private String b(char c2) throws IOException {
        char[] cArr = this.f3732e;
        StringBuilder sb = new StringBuilder();
        while (true) {
            int i2 = this.f3733f;
            int i3 = this.g;
            int i4 = i2;
            while (true) {
                if (i4 < i3) {
                    int i5 = i4 + 1;
                    char c3 = cArr[i4];
                    if (c3 == c2) {
                        this.f3733f = i5;
                        sb.append(cArr, i2, (i5 - i2) - 1);
                        return sb.toString();
                    } else if (c3 == '\\') {
                        this.f3733f = i5;
                        sb.append(cArr, i2, (i5 - i2) - 1);
                        sb.append(w());
                        break;
                    } else {
                        if (c3 == 10) {
                            this.h++;
                            this.i = i5;
                        }
                        i4 = i5;
                    }
                } else {
                    sb.append(cArr, i2, i4 - i2);
                    this.f3733f = i4;
                    if (!b(1)) {
                        throw b((String) "Unterminated string");
                    }
                }
            }
        }
    }

    private boolean b(int i2) throws IOException {
        char[] cArr = this.f3732e;
        int i3 = this.i;
        int i4 = this.f3733f;
        this.i = i3 - i4;
        int i5 = this.g;
        if (i5 != i4) {
            int i6 = i5 - i4;
            this.g = i6;
            System.arraycopy(cArr, i4, cArr, 0, i6);
        } else {
            this.g = 0;
        }
        this.f3733f = 0;
        do {
            Reader reader = this.f3731d;
            int i7 = this.g;
            int read = reader.read(cArr, i7, cArr.length - i7);
            if (read == -1) {
                return false;
            }
            int i8 = this.g + read;
            this.g = i8;
            if (this.h == 0) {
                int i9 = this.i;
                if (i9 == 0 && i8 > 0 && cArr[0] == 65279) {
                    this.f3733f++;
                    this.i = i9 + 1;
                    i2++;
                }
            }
        } while (this.g < i2);
        return true;
    }

    private void c(char c2) throws IOException {
        char[] cArr = this.f3732e;
        while (true) {
            int i2 = this.f3733f;
            int i3 = this.g;
            while (true) {
                if (i2 < i3) {
                    int i4 = i2 + 1;
                    char c3 = cArr[i2];
                    if (c3 == c2) {
                        this.f3733f = i4;
                        return;
                    } else if (c3 == '\\') {
                        this.f3733f = i4;
                        w();
                        break;
                    } else {
                        if (c3 == 10) {
                            this.h++;
                            this.i = i4;
                        }
                        i2 = i4;
                    }
                } else {
                    this.f3733f = i2;
                    if (!b(1)) {
                        throw b((String) "Unterminated string");
                    }
                }
            }
        }
    }

    private int g() throws IOException {
        String str;
        String str2;
        int i2;
        char c2 = this.f3732e[this.f3733f];
        if (c2 == 't' || c2 == 'T') {
            i2 = 5;
            str2 = BaseParser.TRUE;
            str = "TRUE";
        } else if (c2 == 'f' || c2 == 'F') {
            i2 = 6;
            str2 = BaseParser.FALSE;
            str = "FALSE";
        } else if (c2 != 'n' && c2 != 'N') {
            return 0;
        } else {
            i2 = 7;
            str2 = "null";
            str = "NULL";
        }
        int length = str2.length();
        for (int i3 = 1; i3 < length; i3++) {
            if (this.f3733f + i3 >= this.g && !b(i3 + 1)) {
                return 0;
            }
            char c3 = this.f3732e[this.f3733f + i3];
            if (c3 != str2.charAt(i3) && c3 != str.charAt(i3)) {
                return 0;
            }
        }
        if ((this.f3733f + length < this.g || b(length + 1)) && a(this.f3732e[this.f3733f + length])) {
            return 0;
        }
        this.f3733f += length;
        this.f3730b = i2;
        return i2;
    }

    private int r() throws IOException {
        int i2;
        char c2;
        char[] cArr = this.f3732e;
        int i3 = this.f3733f;
        int i4 = this.g;
        int i5 = 0;
        int i6 = 0;
        char c3 = 0;
        boolean z = true;
        long j2 = 0;
        boolean z2 = false;
        while (true) {
            if (i3 + i6 == i4) {
                if (i6 != cArr.length) {
                    if (!b(i6 + 1)) {
                        break;
                    }
                    i3 = this.f3733f;
                    i4 = this.g;
                } else {
                    return i5;
                }
            }
            c2 = cArr[i3 + i6];
            if (c2 == '+') {
                i5 = 0;
                if (c3 != 5) {
                    return 0;
                }
            } else if (c2 == 'E' || c2 == 'e') {
                i5 = 0;
                if (c3 != 2 && c3 != 4) {
                    return 0;
                }
                c3 = 5;
                i6++;
            } else {
                if (c2 == '-') {
                    i5 = 0;
                    if (c3 == 0) {
                        c3 = 1;
                        z2 = true;
                    } else if (c3 != 5) {
                        return 0;
                    }
                } else if (c2 == '.') {
                    i5 = 0;
                    if (c3 != 2) {
                        return 0;
                    }
                    c3 = 3;
                } else if (c2 >= '0' && c2 <= '9') {
                    if (c3 == 1 || c3 == 0) {
                        j2 = (long) (-(c2 - '0'));
                        i5 = 0;
                        c3 = 2;
                    } else {
                        if (c3 == 2) {
                            if (j2 == 0) {
                                return 0;
                            }
                            long j3 = (10 * j2) - ((long) (c2 - '0'));
                            int i7 = (j2 > -922337203685477580L ? 1 : (j2 == -922337203685477580L ? 0 : -1));
                            z &= i7 > 0 || (i7 == 0 && j3 < j2);
                            j2 = j3;
                        } else if (c3 == 3) {
                            i5 = 0;
                            c3 = 4;
                        } else if (c3 == 5 || c3 == 6) {
                            i5 = 0;
                            c3 = 7;
                        }
                        i5 = 0;
                    }
                }
                i6++;
            }
            c3 = 6;
            i6++;
        }
        if (a(c2)) {
            return 0;
        }
        if (c3 == 2 && z && (j2 != Long.MIN_VALUE || z2)) {
            if (!z2) {
                j2 = -j2;
            }
            this.j = j2;
            this.f3733f += i6;
            i2 = 15;
        } else if (c3 != 2 && c3 != 4 && c3 != 7) {
            return 0;
        } else {
            this.k = i6;
            i2 = 16;
        }
        this.f3730b = i2;
        return i2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:32:0x004a, code lost:
        t();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String s() throws java.io.IOException {
        /*
            r6 = this;
            r0 = 0
            r1 = 0
        L_0x0002:
            r2 = 0
        L_0x0003:
            int r3 = r6.f3733f
            int r4 = r3 + r2
            int r5 = r6.g
            if (r4 >= r5) goto L_0x004e
            char[] r4 = r6.f3732e
            int r3 = r3 + r2
            char r3 = r4[r3]
            r4 = 9
            if (r3 == r4) goto L_0x005c
            r4 = 10
            if (r3 == r4) goto L_0x005c
            r4 = 12
            if (r3 == r4) goto L_0x005c
            r4 = 13
            if (r3 == r4) goto L_0x005c
            r4 = 32
            if (r3 == r4) goto L_0x005c
            r4 = 35
            if (r3 == r4) goto L_0x004a
            r4 = 44
            if (r3 == r4) goto L_0x005c
            r4 = 47
            if (r3 == r4) goto L_0x004a
            r4 = 61
            if (r3 == r4) goto L_0x004a
            r4 = 123(0x7b, float:1.72E-43)
            if (r3 == r4) goto L_0x005c
            r4 = 125(0x7d, float:1.75E-43)
            if (r3 == r4) goto L_0x005c
            r4 = 58
            if (r3 == r4) goto L_0x005c
            r4 = 59
            if (r3 == r4) goto L_0x004a
            switch(r3) {
                case 91: goto L_0x005c;
                case 92: goto L_0x004a;
                case 93: goto L_0x005c;
                default: goto L_0x0047;
            }
        L_0x0047:
            int r2 = r2 + 1
            goto L_0x0003
        L_0x004a:
            r6.t()
            goto L_0x005c
        L_0x004e:
            char[] r3 = r6.f3732e
            int r3 = r3.length
            if (r2 >= r3) goto L_0x005e
            int r3 = r2 + 1
            boolean r3 = r6.b(r3)
            if (r3 == 0) goto L_0x005c
            goto L_0x0003
        L_0x005c:
            r0 = r2
            goto L_0x0078
        L_0x005e:
            if (r1 != 0) goto L_0x0065
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
        L_0x0065:
            char[] r3 = r6.f3732e
            int r4 = r6.f3733f
            r1.append(r3, r4, r2)
            int r3 = r6.f3733f
            int r3 = r3 + r2
            r6.f3733f = r3
            r2 = 1
            boolean r2 = r6.b(r2)
            if (r2 != 0) goto L_0x0002
        L_0x0078:
            if (r1 != 0) goto L_0x0084
            java.lang.String r1 = new java.lang.String
            char[] r2 = r6.f3732e
            int r3 = r6.f3733f
            r1.<init>(r2, r3, r0)
            goto L_0x008f
        L_0x0084:
            char[] r2 = r6.f3732e
            int r3 = r6.f3733f
            r1.append(r2, r3, r0)
            java.lang.String r1 = r1.toString()
        L_0x008f:
            int r2 = r6.f3733f
            int r2 = r2 + r0
            r6.f3733f = r2
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.userexperior.a.a.d.a.s():java.lang.String");
    }

    private void t() throws IOException {
        if (!this.f3729a) {
            throw b((String) "Use JsonReader.setLenient(true) to accept malformed JSON");
        }
    }

    private void u() throws IOException {
        char c2;
        do {
            if (this.f3733f >= this.g && !b(1)) {
                break;
            }
            char[] cArr = this.f3732e;
            int i2 = this.f3733f;
            int i3 = i2 + 1;
            this.f3733f = i3;
            c2 = cArr[i2];
            if (c2 == 10) {
                this.h++;
                this.i = i3;
                return;
            }
        } while (c2 != 13);
    }

    /* access modifiers changed from: private */
    public String v() {
        return " at line " + (this.h + 1) + " column " + ((this.f3733f - this.i) + 1) + " path " + p();
    }

    private char w() throws IOException {
        int i2;
        int i3;
        if (this.f3733f != this.g || b(1)) {
            char[] cArr = this.f3732e;
            int i4 = this.f3733f;
            int i5 = i4 + 1;
            this.f3733f = i5;
            char c2 = cArr[i4];
            if (c2 == 10) {
                this.h++;
                this.i = i5;
            } else if (!(c2 == '\"' || c2 == '\'' || c2 == '/' || c2 == '\\')) {
                if (c2 == 'b') {
                    return 8;
                }
                if (c2 == 'f') {
                    return Tokenizer.FF;
                }
                if (c2 == 'n') {
                    return 10;
                }
                if (c2 == 'r') {
                    return 13;
                }
                if (c2 == 't') {
                    return 9;
                }
                if (c2 != 'u') {
                    throw b((String) "Invalid escape sequence");
                } else if (i5 + 4 <= this.g || b(4)) {
                    char c3 = 0;
                    int i6 = this.f3733f;
                    int i7 = i6 + 4;
                    while (i6 < i7) {
                        char c4 = this.f3732e[i6];
                        char c5 = (char) (c3 << 4);
                        if (c4 < '0' || c4 > '9') {
                            if (c4 >= 'a' && c4 <= 'f') {
                                i2 = c4 - 'a';
                            } else if (c4 < 'A' || c4 > 'F') {
                                throw new NumberFormatException("\\u" + new String(this.f3732e, this.f3733f, 4));
                            } else {
                                i2 = c4 - 'A';
                            }
                            i3 = i2 + 10;
                        } else {
                            i3 = c4 - '0';
                        }
                        c3 = (char) (i3 + c5);
                        i6++;
                    }
                    this.f3733f += 4;
                    return c3;
                } else {
                    throw b((String) "Unterminated escape sequence");
                }
            }
            return c2;
        }
        throw b((String) "Unterminated escape sequence");
    }

    private void x() throws IOException {
        a(true);
        int i2 = this.f3733f - 1;
        this.f3733f = i2;
        char[] cArr = f3728c;
        if (i2 + cArr.length <= this.g || b(cArr.length)) {
            int i3 = 0;
            while (true) {
                char[] cArr2 = f3728c;
                if (i3 >= cArr2.length) {
                    this.f3733f += cArr2.length;
                    return;
                } else if (this.f3732e[this.f3733f + i3] == cArr2[i3]) {
                    i3++;
                } else {
                    return;
                }
            }
        }
    }

    public void a() throws IOException {
        int i2 = this.f3730b;
        if (i2 == 0) {
            i2 = q();
        }
        if (i2 == 3) {
            a(1);
            this.p[this.n - 1] = 0;
            this.f3730b = 0;
            return;
        }
        throw new IllegalStateException("Expected BEGIN_ARRAY but was " + f() + v());
    }

    public void b() throws IOException {
        int i2 = this.f3730b;
        if (i2 == 0) {
            i2 = q();
        }
        if (i2 == 4) {
            int i3 = this.n - 1;
            this.n = i3;
            int[] iArr = this.p;
            int i4 = i3 - 1;
            iArr[i4] = iArr[i4] + 1;
            this.f3730b = 0;
            return;
        }
        throw new IllegalStateException("Expected END_ARRAY but was " + f() + v());
    }

    public void c() throws IOException {
        int i2 = this.f3730b;
        if (i2 == 0) {
            i2 = q();
        }
        if (i2 == 1) {
            a(3);
            this.f3730b = 0;
            return;
        }
        throw new IllegalStateException("Expected BEGIN_OBJECT but was " + f() + v());
    }

    public void close() throws IOException {
        this.f3730b = 0;
        this.m[0] = 8;
        this.n = 1;
        this.f3731d.close();
    }

    public void d() throws IOException {
        int i2 = this.f3730b;
        if (i2 == 0) {
            i2 = q();
        }
        if (i2 == 2) {
            int i3 = this.n - 1;
            this.n = i3;
            this.o[i3] = null;
            int[] iArr = this.p;
            int i4 = i3 - 1;
            iArr[i4] = iArr[i4] + 1;
            this.f3730b = 0;
            return;
        }
        throw new IllegalStateException("Expected END_OBJECT but was " + f() + v());
    }

    public boolean e() throws IOException {
        int i2 = this.f3730b;
        if (i2 == 0) {
            i2 = q();
        }
        return (i2 == 2 || i2 == 4) ? false : true;
    }

    public b f() throws IOException {
        int i2 = this.f3730b;
        if (i2 == 0) {
            i2 = q();
        }
        switch (i2) {
            case 1:
                return b.BEGIN_OBJECT;
            case 2:
                return b.END_OBJECT;
            case 3:
                return b.BEGIN_ARRAY;
            case 4:
                return b.END_ARRAY;
            case 5:
            case 6:
                return b.BOOLEAN;
            case 7:
                return b.NULL;
            case 8:
            case 9:
            case 10:
            case 11:
                return b.STRING;
            case 12:
            case 13:
            case 14:
                return b.NAME;
            case 15:
            case 16:
                return b.NUMBER;
            case 17:
                return b.END_DOCUMENT;
            default:
                throw new AssertionError();
        }
    }

    public String h() throws IOException {
        String str;
        char c2;
        int i2 = this.f3730b;
        if (i2 == 0) {
            i2 = q();
        }
        if (i2 == 14) {
            str = s();
        } else {
            if (i2 == 12) {
                c2 = ExtendedMessageFormat.QUOTE;
            } else if (i2 == 13) {
                c2 = StringEscapeUtils.CSV_QUOTE;
            } else {
                throw new IllegalStateException("Expected a name but was " + f() + v());
            }
            str = b(c2);
        }
        this.f3730b = 0;
        this.o[this.n - 1] = str;
        return str;
    }

    public String i() throws IOException {
        String str;
        char c2;
        int i2 = this.f3730b;
        if (i2 == 0) {
            i2 = q();
        }
        if (i2 == 10) {
            str = s();
        } else {
            if (i2 == 8) {
                c2 = ExtendedMessageFormat.QUOTE;
            } else if (i2 == 9) {
                c2 = StringEscapeUtils.CSV_QUOTE;
            } else if (i2 == 11) {
                str = this.l;
                this.l = null;
            } else if (i2 == 15) {
                str = Long.toString(this.j);
            } else if (i2 == 16) {
                str = new String(this.f3732e, this.f3733f, this.k);
                this.f3733f += this.k;
            } else {
                throw new IllegalStateException("Expected a string but was " + f() + v());
            }
            str = b(c2);
        }
        this.f3730b = 0;
        int[] iArr = this.p;
        int i3 = this.n - 1;
        iArr[i3] = iArr[i3] + 1;
        return str;
    }

    public boolean j() throws IOException {
        int i2 = this.f3730b;
        if (i2 == 0) {
            i2 = q();
        }
        if (i2 == 5) {
            this.f3730b = 0;
            int[] iArr = this.p;
            int i3 = this.n - 1;
            iArr[i3] = iArr[i3] + 1;
            return true;
        } else if (i2 == 6) {
            this.f3730b = 0;
            int[] iArr2 = this.p;
            int i4 = this.n - 1;
            iArr2[i4] = iArr2[i4] + 1;
            return false;
        } else {
            throw new IllegalStateException("Expected a boolean but was " + f() + v());
        }
    }

    public void k() throws IOException {
        int i2 = this.f3730b;
        if (i2 == 0) {
            i2 = q();
        }
        if (i2 == 7) {
            this.f3730b = 0;
            int[] iArr = this.p;
            int i3 = this.n - 1;
            iArr[i3] = iArr[i3] + 1;
            return;
        }
        throw new IllegalStateException("Expected null but was " + f() + v());
    }

    public double l() throws IOException {
        String str;
        int i2 = this.f3730b;
        if (i2 == 0) {
            i2 = q();
        }
        if (i2 == 15) {
            this.f3730b = 0;
            int[] iArr = this.p;
            int i3 = this.n - 1;
            iArr[i3] = iArr[i3] + 1;
            return (double) this.j;
        }
        if (i2 == 16) {
            this.l = new String(this.f3732e, this.f3733f, this.k);
            this.f3733f += this.k;
        } else {
            if (i2 == 8 || i2 == 9) {
                str = b(i2 == 8 ? ExtendedMessageFormat.QUOTE : StringEscapeUtils.CSV_QUOTE);
            } else if (i2 == 10) {
                str = s();
            } else if (i2 != 11) {
                throw new IllegalStateException("Expected a double but was " + f() + v());
            }
            this.l = str;
        }
        this.f3730b = 11;
        double parseDouble = Double.parseDouble(this.l);
        if (this.f3729a || (!Double.isNaN(parseDouble) && !Double.isInfinite(parseDouble))) {
            this.l = null;
            this.f3730b = 0;
            int[] iArr2 = this.p;
            int i4 = this.n - 1;
            iArr2[i4] = iArr2[i4] + 1;
            return parseDouble;
        }
        throw new d("JSON forbids NaN and infinities: " + parseDouble + v());
    }

    public long m() throws IOException {
        String b2;
        int i2 = this.f3730b;
        if (i2 == 0) {
            i2 = q();
        }
        if (i2 == 15) {
            this.f3730b = 0;
            int[] iArr = this.p;
            int i3 = this.n - 1;
            iArr[i3] = iArr[i3] + 1;
            return this.j;
        }
        if (i2 == 16) {
            this.l = new String(this.f3732e, this.f3733f, this.k);
            this.f3733f += this.k;
        } else if (i2 == 8 || i2 == 9 || i2 == 10) {
            if (i2 == 10) {
                b2 = s();
            } else {
                b2 = b(i2 == 8 ? ExtendedMessageFormat.QUOTE : StringEscapeUtils.CSV_QUOTE);
            }
            this.l = b2;
            try {
                long parseLong = Long.parseLong(this.l);
                this.f3730b = 0;
                int[] iArr2 = this.p;
                int i4 = this.n - 1;
                iArr2[i4] = iArr2[i4] + 1;
                return parseLong;
            } catch (NumberFormatException unused) {
            }
        } else {
            throw new IllegalStateException("Expected a long but was " + f() + v());
        }
        this.f3730b = 11;
        double parseDouble = Double.parseDouble(this.l);
        long j2 = (long) parseDouble;
        if (((double) j2) == parseDouble) {
            this.l = null;
            this.f3730b = 0;
            int[] iArr3 = this.p;
            int i5 = this.n - 1;
            iArr3[i5] = iArr3[i5] + 1;
            return j2;
        }
        throw new NumberFormatException("Expected a long but was " + this.l + v());
    }

    public int n() throws IOException {
        String b2;
        int i2 = this.f3730b;
        if (i2 == 0) {
            i2 = q();
        }
        if (i2 == 15) {
            long j2 = this.j;
            int i3 = (int) j2;
            if (j2 == ((long) i3)) {
                this.f3730b = 0;
                int[] iArr = this.p;
                int i4 = this.n - 1;
                iArr[i4] = iArr[i4] + 1;
                return i3;
            }
            throw new NumberFormatException("Expected an int but was " + this.j + v());
        }
        if (i2 == 16) {
            this.l = new String(this.f3732e, this.f3733f, this.k);
            this.f3733f += this.k;
        } else if (i2 == 8 || i2 == 9 || i2 == 10) {
            if (i2 == 10) {
                b2 = s();
            } else {
                b2 = b(i2 == 8 ? ExtendedMessageFormat.QUOTE : StringEscapeUtils.CSV_QUOTE);
            }
            this.l = b2;
            try {
                int parseInt = Integer.parseInt(this.l);
                this.f3730b = 0;
                int[] iArr2 = this.p;
                int i5 = this.n - 1;
                iArr2[i5] = iArr2[i5] + 1;
                return parseInt;
            } catch (NumberFormatException unused) {
            }
        } else {
            throw new IllegalStateException("Expected an int but was " + f() + v());
        }
        this.f3730b = 11;
        double parseDouble = Double.parseDouble(this.l);
        int i6 = (int) parseDouble;
        if (((double) i6) == parseDouble) {
            this.l = null;
            this.f3730b = 0;
            int[] iArr3 = this.p;
            int i7 = this.n - 1;
            iArr3[i7] = iArr3[i7] + 1;
            return i6;
        }
        throw new NumberFormatException("Expected an int but was " + this.l + v());
    }

    public void o() throws IOException {
        int i2;
        char c2;
        int i3 = 0;
        do {
            int i4 = this.f3730b;
            if (i4 == 0) {
                i4 = q();
            }
            if (i4 == 3) {
                a(1);
            } else if (i4 == 1) {
                a(3);
            } else if (i4 == 4 || i4 == 2) {
                this.n--;
                i3--;
                this.f3730b = 0;
            } else if (i4 == 14 || i4 == 10) {
                while (true) {
                    i2 = 0;
                    while (true) {
                        int i5 = this.f3733f;
                        if (i5 + i2 < this.g) {
                            char c3 = this.f3732e[i5 + i2];
                            if (!(c3 == 9 || c3 == 10 || c3 == 12 || c3 == 13 || c3 == ' ')) {
                                if (c3 != '#') {
                                    if (c3 != ',') {
                                        if (!(c3 == '/' || c3 == '=')) {
                                            if (!(c3 == '{' || c3 == '}' || c3 == ':')) {
                                                if (c3 != ';') {
                                                    switch (c3) {
                                                        case '[':
                                                        case ']':
                                                            break;
                                                        case '\\':
                                                            break;
                                                        default:
                                                            i2++;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        } else {
                            this.f3733f = i5 + i2;
                            if (!b(1)) {
                            }
                        }
                    }
                }
                t();
                this.f3733f += i2;
                this.f3730b = 0;
            } else {
                if (i4 == 8 || i4 == 12) {
                    c2 = ExtendedMessageFormat.QUOTE;
                } else if (i4 == 9 || i4 == 13) {
                    c2 = StringEscapeUtils.CSV_QUOTE;
                } else {
                    if (i4 == 16) {
                        this.f3733f += this.k;
                    }
                    this.f3730b = 0;
                }
                c(c2);
                this.f3730b = 0;
            }
            i3++;
            this.f3730b = 0;
        } while (i3 != 0);
        int[] iArr = this.p;
        int i6 = this.n;
        int i7 = i6 - 1;
        iArr[i7] = iArr[i7] + 1;
        this.o[i6 - 1] = "null";
    }

    public String p() {
        StringBuilder sb = new StringBuilder(SFSBuddyVariable.OFFLINE_PREFIX);
        int i2 = this.n;
        for (int i3 = 0; i3 < i2; i3++) {
            int i4 = this.m[i3];
            if (i4 == 1 || i4 == 2) {
                sb.append('[');
                sb.append(this.p[i3]);
                sb.append(']');
            } else if (i4 == 3 || i4 == 4 || i4 == 5) {
                sb.append('.');
                String[] strArr = this.o;
                if (strArr[i3] != null) {
                    sb.append(strArr[i3]);
                }
            }
        }
        return sb.toString();
    }

    /* JADX WARNING: Removed duplicated region for block: B:46:0x00a8  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x010c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int q() throws java.io.IOException {
        /*
            r15 = this;
            int[] r0 = r15.m
            int r1 = r15.n
            int r2 = r1 + -1
            r2 = r0[r2]
            r3 = 8
            r4 = 39
            r5 = 34
            r6 = 93
            r7 = 3
            r8 = 7
            r9 = 59
            r10 = 44
            r11 = 4
            r12 = 2
            r13 = 1
            if (r2 != r13) goto L_0x0020
            int r1 = r1 - r13
            r0[r1] = r12
            goto L_0x00a2
        L_0x0020:
            if (r2 != r12) goto L_0x003a
            int r0 = r15.a(r13)
            if (r0 == r10) goto L_0x00a2
            if (r0 == r9) goto L_0x0036
            if (r0 != r6) goto L_0x002f
            r15.f3730b = r11
            return r11
        L_0x002f:
            java.lang.String r0 = "Unterminated array"
            java.io.IOException r0 = r15.b(r0)
            throw r0
        L_0x0036:
            r15.t()
            goto L_0x00a2
        L_0x003a:
            r14 = 5
            if (r2 == r7) goto L_0x0117
            if (r2 != r14) goto L_0x0041
            goto L_0x0117
        L_0x0041:
            if (r2 != r11) goto L_0x0076
            int r1 = r1 - r13
            r0[r1] = r14
            int r0 = r15.a(r13)
            r1 = 58
            if (r0 == r1) goto L_0x00a2
            r1 = 61
            if (r0 != r1) goto L_0x006f
            r15.t()
            int r0 = r15.f3733f
            int r1 = r15.g
            if (r0 < r1) goto L_0x0061
            boolean r0 = r15.b(r13)
            if (r0 == 0) goto L_0x00a2
        L_0x0061:
            char[] r0 = r15.f3732e
            int r1 = r15.f3733f
            char r0 = r0[r1]
            r14 = 62
            if (r0 != r14) goto L_0x00a2
            int r1 = r1 + r13
            r15.f3733f = r1
            goto L_0x00a2
        L_0x006f:
            java.lang.String r0 = "Expected ':'"
            java.io.IOException r0 = r15.b(r0)
            throw r0
        L_0x0076:
            r0 = 6
            if (r2 != r0) goto L_0x0088
            boolean r0 = r15.f3729a
            if (r0 == 0) goto L_0x0080
            r15.x()
        L_0x0080:
            int[] r0 = r15.m
            int r1 = r15.n
            int r1 = r1 - r13
            r0[r1] = r8
            goto L_0x00a2
        L_0x0088:
            if (r2 != r8) goto L_0x00a0
            r0 = 0
            int r0 = r15.a(r0)
            r1 = -1
            if (r0 != r1) goto L_0x0097
            r0 = 17
        L_0x0094:
            r15.f3730b = r0
            return r0
        L_0x0097:
            r15.t()
            int r0 = r15.f3733f
            int r0 = r0 - r13
            r15.f3733f = r0
            goto L_0x00a2
        L_0x00a0:
            if (r2 == r3) goto L_0x010f
        L_0x00a2:
            int r0 = r15.a(r13)
            if (r0 == r5) goto L_0x010c
            if (r0 == r4) goto L_0x0106
            if (r0 == r10) goto L_0x00ef
            if (r0 == r9) goto L_0x00ef
            r1 = 91
            if (r0 == r1) goto L_0x00ec
            if (r0 == r6) goto L_0x00e7
            r1 = 123(0x7b, float:1.72E-43)
            if (r0 == r1) goto L_0x00e4
            int r0 = r15.f3733f
            int r0 = r0 - r13
            r15.f3733f = r0
            int r0 = r15.g()
            if (r0 == 0) goto L_0x00c4
            return r0
        L_0x00c4:
            int r0 = r15.r()
            if (r0 == 0) goto L_0x00cb
            return r0
        L_0x00cb:
            char[] r0 = r15.f3732e
            int r1 = r15.f3733f
            char r0 = r0[r1]
            boolean r0 = r15.a(r0)
            if (r0 == 0) goto L_0x00dd
            r15.t()
            r0 = 10
            goto L_0x0094
        L_0x00dd:
            java.lang.String r0 = "Expected value"
            java.io.IOException r0 = r15.b(r0)
            throw r0
        L_0x00e4:
            r15.f3730b = r13
            return r13
        L_0x00e7:
            if (r2 != r13) goto L_0x00ef
            r15.f3730b = r11
            return r11
        L_0x00ec:
            r15.f3730b = r7
            return r7
        L_0x00ef:
            if (r2 == r13) goto L_0x00fb
            if (r2 != r12) goto L_0x00f4
            goto L_0x00fb
        L_0x00f4:
            java.lang.String r0 = "Unexpected value"
            java.io.IOException r0 = r15.b(r0)
            throw r0
        L_0x00fb:
            r15.t()
            int r0 = r15.f3733f
            int r0 = r0 - r13
            r15.f3733f = r0
            r15.f3730b = r8
            return r8
        L_0x0106:
            r15.t()
            r15.f3730b = r3
            return r3
        L_0x010c:
            r0 = 9
            goto L_0x0094
        L_0x010f:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "JsonReader is closed"
            r0.<init>(r1)
            throw r0
        L_0x0117:
            int[] r0 = r15.m
            int r1 = r15.n
            int r1 = r1 - r13
            r0[r1] = r11
            r0 = 125(0x7d, float:1.75E-43)
            if (r2 != r14) goto L_0x0139
            int r1 = r15.a(r13)
            if (r1 == r10) goto L_0x0139
            if (r1 == r9) goto L_0x0136
            if (r1 != r0) goto L_0x012f
            r15.f3730b = r12
            return r12
        L_0x012f:
            java.lang.String r0 = "Unterminated object"
            java.io.IOException r0 = r15.b(r0)
            throw r0
        L_0x0136:
            r15.t()
        L_0x0139:
            int r1 = r15.a(r13)
            if (r1 == r5) goto L_0x016e
            if (r1 == r4) goto L_0x0167
            java.lang.String r3 = "Expected name"
            if (r1 == r0) goto L_0x015d
            r15.t()
            int r0 = r15.f3733f
            int r0 = r0 - r13
            r15.f3733f = r0
            char r0 = (char) r1
            boolean r0 = r15.a(r0)
            if (r0 == 0) goto L_0x0158
            r0 = 14
            goto L_0x0094
        L_0x0158:
            java.io.IOException r0 = r15.b(r3)
            throw r0
        L_0x015d:
            if (r2 == r14) goto L_0x0162
            r15.f3730b = r12
            return r12
        L_0x0162:
            java.io.IOException r0 = r15.b(r3)
            throw r0
        L_0x0167:
            r15.t()
            r0 = 12
            goto L_0x0094
        L_0x016e:
            r0 = 13
            goto L_0x0094
        */
        throw new UnsupportedOperationException("Method not decompiled: com.userexperior.a.a.d.a.q():int");
    }

    public String toString() {
        return getClass().getSimpleName() + v();
    }
}
