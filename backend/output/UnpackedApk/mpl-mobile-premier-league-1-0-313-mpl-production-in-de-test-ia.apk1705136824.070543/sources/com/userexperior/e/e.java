package com.userexperior.e;

public final class e implements v {

    /* renamed from: a  reason: collision with root package name */
    public int f3987a;

    /* renamed from: b  reason: collision with root package name */
    public int f3988b;

    /* renamed from: c  reason: collision with root package name */
    public final int f3989c;

    /* renamed from: d  reason: collision with root package name */
    public final float f3990d;

    public e() {
        this(0);
    }

    public e(byte b2) {
        this.f3987a = 30000;
        this.f3989c = 0;
        this.f3990d = 1.0f;
    }

    public final int a() {
        return this.f3987a;
    }

    public final void a(y yVar) throws y {
        boolean z = true;
        int i = this.f3988b + 1;
        this.f3988b = i;
        int i2 = this.f3987a;
        this.f3987a = (int) ((((float) i2) * this.f3990d) + ((float) i2));
        if (i > this.f3989c) {
            z = false;
        }
        if (!z) {
            throw yVar;
        }
    }

    public final int b() {
        return this.f3988b;
    }
}
