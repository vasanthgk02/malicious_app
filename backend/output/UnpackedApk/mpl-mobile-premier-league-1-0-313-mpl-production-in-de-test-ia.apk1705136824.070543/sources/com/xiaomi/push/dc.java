package com.xiaomi.push;

public enum dc {
    MISC_CONFIG(1),
    PLUGIN_CONFIG(2);
    

    /* renamed from: a  reason: collision with other field name */
    public final int f449a;

    /* access modifiers changed from: public */
    dc(int i) {
        this.f449a = i;
    }

    public static dc a(int i) {
        if (i == 1) {
            return MISC_CONFIG;
        }
        if (i != 2) {
            return null;
        }
        return PLUGIN_CONFIG;
    }

    public int a() {
        return this.f449a;
    }
}
