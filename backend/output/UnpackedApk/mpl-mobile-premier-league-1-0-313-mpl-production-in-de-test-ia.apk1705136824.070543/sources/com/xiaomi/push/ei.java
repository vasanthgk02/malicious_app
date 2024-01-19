package com.xiaomi.push;

import com.xiaomi.push.el.a;

public class ei {

    /* renamed from: a  reason: collision with root package name */
    public final ep f4755a;

    /* renamed from: a  reason: collision with other field name */
    public final ex f745a;

    public ei() {
        this(new a());
    }

    public ei(er erVar) {
        ex exVar = new ex();
        this.f745a = exVar;
        this.f4755a = erVar.a(exVar);
    }

    public void a(ef efVar, byte[] bArr) {
        try {
            this.f745a.a(bArr);
            efVar.a(this.f4755a);
        } finally {
            this.f4755a.k();
        }
    }
}
