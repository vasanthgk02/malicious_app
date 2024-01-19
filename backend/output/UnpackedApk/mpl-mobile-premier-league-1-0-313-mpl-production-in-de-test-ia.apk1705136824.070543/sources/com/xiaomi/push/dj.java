package com.xiaomi.push;

public enum dj {
    RegIdExpired(0),
    PackageUnregistered(1),
    Init(2);
    

    /* renamed from: a  reason: collision with other field name */
    public final int f504a;

    /* access modifiers changed from: public */
    dj(int i) {
        this.f504a = i;
    }

    public static dj a(int i) {
        if (i == 0) {
            return RegIdExpired;
        }
        if (i == 1) {
            return PackageUnregistered;
        }
        if (i != 2) {
            return null;
        }
        return Init;
    }

    public int a() {
        return this.f504a;
    }
}
