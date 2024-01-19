package com.xiaomi.push;

import com.xiaomi.push.el.a;
import java.io.ByteArrayOutputStream;

public class ek {

    /* renamed from: a  reason: collision with root package name */
    public ep f4756a;

    /* renamed from: a  reason: collision with other field name */
    public final ew f746a;

    /* renamed from: a  reason: collision with other field name */
    public final ByteArrayOutputStream f747a;

    public ek() {
        this(new a());
    }

    public ek(er erVar) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        this.f747a = byteArrayOutputStream;
        ew ewVar = new ew(byteArrayOutputStream);
        this.f746a = ewVar;
        this.f4756a = erVar.a(ewVar);
    }

    public byte[] a(ef efVar) {
        this.f747a.reset();
        efVar.b(this.f4756a);
        return this.f747a.toByteArray();
    }
}
