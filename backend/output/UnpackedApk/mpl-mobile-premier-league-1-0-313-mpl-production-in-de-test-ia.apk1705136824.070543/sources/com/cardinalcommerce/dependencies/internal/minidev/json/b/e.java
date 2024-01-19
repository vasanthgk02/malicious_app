package com.cardinalcommerce.dependencies.internal.minidev.json.b;

import com.cardinalcommerce.dependencies.internal.minidev.json.b.b.a;
import org.apache.commons.lang.StringEscapeUtils;
import org.apache.commons.lang.text.ExtendedMessageFormat;
import org.apache.pdfbox.pdmodel.common.function.type4.Parser.Tokenizer;

public abstract class e extends b {
    public int w;

    public e(int i) {
        super(i);
    }

    public void a(boolean[] zArr) {
        int i = this.k;
        c(zArr);
        b(i, this.k);
    }

    /* JADX WARNING: Removed duplicated region for block: B:57:0x00cd  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00d3  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object b(boolean[] r19) {
        /*
            r18 = this;
            r0 = r18
            int r1 = r0.k
            r18.d()
            r18.i()
            char r2 = r0.f1924a
            r3 = 45
            r4 = 101(0x65, float:1.42E-43)
            r5 = 46
            r6 = 26
            r7 = 126(0x7e, float:1.77E-43)
            r8 = 48
            r9 = 69
            r10 = 1
            if (r2 == r5) goto L_0x0115
            if (r2 == r9) goto L_0x0115
            if (r2 == r4) goto L_0x0115
            r18.j()
            char r2 = r0.f1924a
            if (r2 < 0) goto L_0x0049
            if (r2 >= r7) goto L_0x0049
            boolean r4 = r19[r2]
            if (r4 != 0) goto L_0x0049
            if (r2 == r6) goto L_0x0049
            r18.c(r19)
            int r2 = r0.k
            r0.b(r1, r2)
            boolean r1 = r0.n
            if (r1 == 0) goto L_0x003f
            java.lang.String r1 = r0.j
            return r1
        L_0x003f:
            com.cardinalcommerce.dependencies.internal.minidev.json.b.i r1 = new com.cardinalcommerce.dependencies.internal.minidev.json.b.i
            int r2 = r0.k
            java.lang.String r3 = r0.j
            r1.<init>(r2, r10, r3)
            throw r1
        L_0x0049:
            int r2 = r0.k
            r0.b(r1, r2)
            java.lang.String r2 = r0.j
            int r1 = r2.length()
            r11 = 0
            char r4 = r2.charAt(r11)
            r5 = 6
            if (r4 != r3) goto L_0x0077
            r3 = 20
            boolean r4 = r0.l
            if (r4 != 0) goto L_0x0074
            r4 = 3
            if (r1 < r4) goto L_0x0074
            char r4 = r2.charAt(r10)
            if (r4 == r8) goto L_0x006c
            goto L_0x0074
        L_0x006c:
            com.cardinalcommerce.dependencies.internal.minidev.json.b.i r1 = new com.cardinalcommerce.dependencies.internal.minidev.json.b.i
            int r3 = r0.k
            r1.<init>(r3, r5, r2)
            throw r1
        L_0x0074:
            r4 = 1
            r12 = 1
            goto L_0x0091
        L_0x0077:
            boolean r3 = r0.l
            if (r3 != 0) goto L_0x008d
            r3 = 2
            if (r1 < r3) goto L_0x008d
            char r3 = r2.charAt(r11)
            if (r3 == r8) goto L_0x0085
            goto L_0x008d
        L_0x0085:
            com.cardinalcommerce.dependencies.internal.minidev.json.b.i r1 = new com.cardinalcommerce.dependencies.internal.minidev.json.b.i
            int r3 = r0.k
            r1.<init>(r3, r5, r2)
            throw r1
        L_0x008d:
            r3 = 19
            r4 = 0
            r12 = 0
        L_0x0091:
            r13 = 10
            if (r1 >= r3) goto L_0x0098
            r14 = r1
            r15 = 0
            goto L_0x00a5
        L_0x0098:
            if (r1 <= r3) goto L_0x00a1
            java.math.BigInteger r1 = new java.math.BigInteger
            r1.<init>(r2, r13)
            goto L_0x0106
        L_0x00a1:
            int r1 = r1 + -1
            r14 = r1
            r15 = 1
        L_0x00a5:
            r5 = 0
        L_0x00a7:
            r16 = 10
            if (r4 < r14) goto L_0x0107
            if (r15 == 0) goto L_0x00dc
            r14 = -922337203685477580(0xf333333333333334, double:-8.390303882365713E246)
            int r1 = (r5 > r14 ? 1 : (r5 == r14 ? 0 : -1))
            if (r1 <= 0) goto L_0x00b7
            goto L_0x00ca
        L_0x00b7:
            if (r1 >= 0) goto L_0x00ba
            goto L_0x00cb
        L_0x00ba:
            char r1 = r2.charAt(r4)
            if (r12 == 0) goto L_0x00c5
            r3 = 56
            if (r1 <= r3) goto L_0x00ca
            goto L_0x00cb
        L_0x00c5:
            r3 = 55
            if (r1 <= r3) goto L_0x00ca
            goto L_0x00cb
        L_0x00ca:
            r10 = 0
        L_0x00cb:
            if (r10 == 0) goto L_0x00d3
            java.math.BigInteger r1 = new java.math.BigInteger
            r1.<init>(r2, r13)
            goto L_0x0106
        L_0x00d3:
            long r5 = r5 * r16
            char r1 = r2.charAt(r4)
            int r8 = r8 - r1
            long r1 = (long) r8
            long r5 = r5 + r1
        L_0x00dc:
            if (r12 == 0) goto L_0x00f0
            boolean r1 = r0.u
            if (r1 == 0) goto L_0x00eb
            r1 = -2147483648(0xffffffff80000000, double:NaN)
            int r3 = (r5 > r1 ? 1 : (r5 == r1 ? 0 : -1))
            if (r3 < 0) goto L_0x00eb
            int r1 = (int) r5
            goto L_0x00fd
        L_0x00eb:
            java.lang.Long r1 = java.lang.Long.valueOf(r5)
            goto L_0x0106
        L_0x00f0:
            long r1 = -r5
            boolean r3 = r0.u
            if (r3 == 0) goto L_0x0102
            r3 = 2147483647(0x7fffffff, double:1.060997895E-314)
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 > 0) goto L_0x0102
            int r1 = (int) r1
        L_0x00fd:
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            goto L_0x0106
        L_0x0102:
            java.lang.Long r1 = java.lang.Long.valueOf(r1)
        L_0x0106:
            return r1
        L_0x0107:
            long r5 = r5 * r16
            int r1 = r4 + 1
            char r3 = r2.charAt(r4)
            int r3 = 48 - r3
            long r3 = (long) r3
            long r5 = r5 + r3
            r4 = r1
            goto L_0x00a7
        L_0x0115:
            char r2 = r0.f1924a
            if (r2 != r5) goto L_0x011f
            r18.d()
            r18.i()
        L_0x011f:
            char r2 = r0.f1924a
            if (r2 == r9) goto L_0x0157
            if (r2 == r4) goto L_0x0157
            r18.j()
            char r2 = r0.f1924a
            if (r2 < 0) goto L_0x014d
            if (r2 >= r7) goto L_0x014d
            boolean r3 = r19[r2]
            if (r3 != 0) goto L_0x014d
            if (r2 == r6) goto L_0x014d
            r18.c(r19)
            int r2 = r0.k
            r0.b(r1, r2)
            boolean r1 = r0.n
            if (r1 == 0) goto L_0x0143
            java.lang.String r1 = r0.j
            return r1
        L_0x0143:
            com.cardinalcommerce.dependencies.internal.minidev.json.b.i r1 = new com.cardinalcommerce.dependencies.internal.minidev.json.b.i
            int r2 = r0.k
            java.lang.String r3 = r0.j
            r1.<init>(r2, r10, r3)
            throw r1
        L_0x014d:
            int r2 = r0.k
            r0.b(r1, r2)
            java.lang.Number r1 = r18.c()
            return r1
        L_0x0157:
            com.cardinalcommerce.dependencies.internal.minidev.json.b.b$a r2 = r0.h
            r2.a(r9)
            r18.d()
            char r2 = r0.f1924a
            r4 = 43
            if (r2 == r4) goto L_0x018e
            if (r2 == r3) goto L_0x018e
            if (r2 < r8) goto L_0x016e
            r3 = 57
            if (r2 > r3) goto L_0x016e
            goto L_0x018e
        L_0x016e:
            r18.c(r19)
            int r2 = r0.k
            r0.b(r1, r2)
            boolean r1 = r0.n
            if (r1 == 0) goto L_0x0184
            boolean r1 = r0.l
            if (r1 != 0) goto L_0x0181
            r18.b()
        L_0x0181:
            java.lang.String r1 = r0.j
            return r1
        L_0x0184:
            com.cardinalcommerce.dependencies.internal.minidev.json.b.i r1 = new com.cardinalcommerce.dependencies.internal.minidev.json.b.i
            int r2 = r0.k
            java.lang.String r3 = r0.j
            r1.<init>(r2, r10, r3)
            throw r1
        L_0x018e:
            com.cardinalcommerce.dependencies.internal.minidev.json.b.b$a r2 = r0.h
            char r3 = r0.f1924a
            r2.a(r3)
            r18.d()
            r18.i()
            r18.j()
            char r2 = r0.f1924a
            if (r2 < 0) goto L_0x014d
            if (r2 >= r7) goto L_0x014d
            boolean r3 = r19[r2]
            if (r3 != 0) goto L_0x014d
            if (r2 == r6) goto L_0x014d
            r18.c(r19)
            int r2 = r0.k
            r0.b(r1, r2)
            boolean r1 = r0.n
            if (r1 == 0) goto L_0x01b9
            java.lang.String r1 = r0.j
            return r1
        L_0x01b9:
            com.cardinalcommerce.dependencies.internal.minidev.json.b.i r1 = new com.cardinalcommerce.dependencies.internal.minidev.json.b.i
            int r2 = r0.k
            java.lang.String r3 = r0.j
            r1.<init>(r2, r10, r3)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cardinalcommerce.dependencies.internal.minidev.json.b.e.b(boolean[]):java.lang.Object");
    }

    public abstract void b(int i, int i2);

    public void g() {
        a aVar;
        int i;
        if (this.o || this.f1924a != '\'') {
            h hVar = (h) this;
            int indexOf = hVar.x.indexOf(this.f1924a, this.k + 1);
            if (indexOf != -1) {
                hVar.j = hVar.x.substring(this.k + 1, indexOf);
                if (this.j.indexOf(92) == -1) {
                    if (!this.s) {
                        int length = this.j.length();
                        for (int i2 = 0; i2 < length; i2++) {
                            char charAt = this.j.charAt(i2);
                            if (charAt >= 0) {
                                if (charAt <= 31) {
                                    throw new i(this.k + i2, 0, Character.valueOf(charAt));
                                } else if (charAt == 127 && this.v) {
                                    throw new i(this.k + i2, 0, Character.valueOf(charAt));
                                }
                            }
                        }
                    }
                    this.k = indexOf;
                    d();
                    return;
                }
                this.h.f1926b = -1;
                char c2 = this.f1924a;
                while (true) {
                    d();
                    char c3 = this.f1924a;
                    char c4 = StringEscapeUtils.CSV_QUOTE;
                    if (c3 == '\"' || c3 == '\'') {
                        char c5 = this.f1924a;
                        if (c2 == c5) {
                            d();
                            this.j = this.h.toString();
                            return;
                        }
                        this.h.a(c5);
                    } else {
                        if (c3 != '\\') {
                            if (c3 != 127) {
                                switch (c3) {
                                    case 0:
                                    case 1:
                                    case 2:
                                    case 3:
                                    case 4:
                                    case 5:
                                    case 6:
                                    case 7:
                                    case 8:
                                    case 9:
                                    case 10:
                                    case 11:
                                    case 12:
                                    case 13:
                                    case 14:
                                    case 15:
                                    case 16:
                                    case 17:
                                    case 18:
                                    case 19:
                                    case 20:
                                    case 21:
                                    case 22:
                                    case 23:
                                    case 24:
                                    case 25:
                                    case 27:
                                    case 28:
                                    case 29:
                                    case 30:
                                    case 31:
                                        if (this.s) {
                                            continue;
                                        } else {
                                            throw new i(this.k, 0, Character.valueOf(this.f1924a));
                                        }
                                    case 26:
                                        throw new i(this.k - 1, 3, null);
                                }
                            } else if (this.s) {
                                continue;
                            } else if (this.v) {
                                throw new i(this.k, 0, Character.valueOf(this.f1924a));
                            }
                            aVar = this.h;
                            c4 = this.f1924a;
                        } else {
                            d();
                            char c6 = this.f1924a;
                            if (c6 != '\"') {
                                if (c6 != '\'') {
                                    c4 = '/';
                                    if (c6 != '/') {
                                        if (c6 == '\\') {
                                            this.h.a('\\');
                                        } else if (c6 == 'b') {
                                            aVar = this.h;
                                            c4 = 8;
                                        } else if (c6 == 'f') {
                                            aVar = this.h;
                                            c4 = Tokenizer.FF;
                                        } else if (c6 == 'n') {
                                            aVar = this.h;
                                            c4 = 10;
                                        } else if (c6 != 'r') {
                                            if (c6 == 'x') {
                                                aVar = this.h;
                                                i = 2;
                                            } else if (c6 == 't') {
                                                aVar = this.h;
                                                c4 = 9;
                                            } else if (c6 == 'u') {
                                                aVar = this.h;
                                                i = 4;
                                            }
                                            c4 = a(i);
                                        } else {
                                            aVar = this.h;
                                            c4 = 13;
                                        }
                                    }
                                } else {
                                    this.h.a(ExtendedMessageFormat.QUOTE);
                                }
                            }
                            aVar = this.h;
                        }
                        aVar.a(c4);
                    }
                }
            } else {
                throw new i(this.w, 3, null);
            }
        } else if (this.n) {
            a(b.f1920c);
        } else {
            throw new i(this.k, 0, Character.valueOf(this.f1924a));
        }
    }
}
