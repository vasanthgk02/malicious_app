package com.cfg.mendikot.api.d.a.a.a.b;

import java.io.Serializable;

public final class i extends n implements Serializable {

    /* renamed from: d  reason: collision with root package name */
    public static final i f2270d = new i(0, 9);

    /* renamed from: e  reason: collision with root package name */
    public static final i f2271e = new i(1, 0);

    /* renamed from: f  reason: collision with root package name */
    public static final i f2272f = new i(1, 1);

    public i(int i, int i2) {
        super("HTTP", i, i2);
    }

    public n a(int i, int i2) {
        if (i == this.f2275b && i2 == this.f2276c) {
            return this;
        }
        if (i == 1) {
            if (i2 == 0) {
                return f2271e;
            }
            if (i2 == 1) {
                return f2272f;
            }
        }
        return (i == 0 && i2 == 9) ? f2270d : new i(i, i2);
    }
}
