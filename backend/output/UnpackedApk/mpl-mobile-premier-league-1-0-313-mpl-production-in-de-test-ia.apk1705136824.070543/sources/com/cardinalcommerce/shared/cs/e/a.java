package com.cardinalcommerce.shared.cs.e;

import com.cardinalcommerce.shared.cs.utils.ThreeDSStrings;
import com.cardinalcommerce.shared.cs.utils.h;

public class a {

    /* renamed from: a  reason: collision with root package name */
    public b f2078a;

    /* renamed from: b  reason: collision with root package name */
    public i f2079b = new i();

    /* renamed from: c  reason: collision with root package name */
    public char[] f2080c;

    /* renamed from: d  reason: collision with root package name */
    public char[] f2081d;

    /* renamed from: e  reason: collision with root package name */
    public char[] f2082e;

    /* renamed from: f  reason: collision with root package name */
    public char[] f2083f;
    public char[] g;
    public char[] i;
    public char[] j;
    public char[] k;
    public boolean l;
    public char[] m;
    public char[] n;
    public char[] o;
    public char[] p;
    public char[] q;
    public char[] r;
    public char[] s;
    public char[] t;
    public char[] u;

    public a(b bVar, c cVar) {
        this.f2078a = bVar;
        this.f2080c = h.a(bVar.f2088d);
        this.f2081d = h.a(bVar.f2089e);
        this.n = h.a(bVar.z);
        this.i = h.a((String) "CReq");
        this.j = h.a(bVar.t);
        if (!h.a(cVar.f2091a)) {
            this.f2082e = cVar.f2091a;
        } else if (!h.a(cVar.f2092b)) {
            char[] cArr = cVar.f2092b;
            if (cArr.length <= 45) {
                this.f2083f = cArr;
            } else {
                this.f2079b.a(false, "challengeDataEntry");
            }
        } else if (!h.a(cVar.f2093c)) {
            char[] cArr2 = cVar.f2093c;
            if (cArr2.length <= 256) {
                this.g = cArr2;
            } else {
                this.f2079b.a(false, "challengeHTMLDataEntry");
            }
        } else if (!h.a(cVar.f2095e)) {
            this.m = cVar.f2095e;
        } else if (bVar.t.equalsIgnoreCase("2.2.0") && t()) {
            this.r = ThreeDSStrings.DEFAULT_CHALLENGE_NO_ENTRY_VALUE;
        }
        char[] cArr3 = cVar.f2096f;
        if (cArr3 != null && !h.a(cArr3)) {
            this.p = cVar.f2096f;
        }
        if (cVar.f2094d) {
            this.l = true;
        }
    }

    public final boolean t() {
        return !this.f2078a.g.equals("05") && !this.f2078a.g.equals("04");
    }
}
