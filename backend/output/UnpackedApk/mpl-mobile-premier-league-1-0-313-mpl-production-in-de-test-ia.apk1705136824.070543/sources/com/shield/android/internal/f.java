package com.shield.android.internal;

import android.app.Application;
import com.mpl.androidapp.Featurestag;

public final class f {

    /* renamed from: c  reason: collision with root package name */
    public static f f1674c;

    /* renamed from: d  reason: collision with root package name */
    public static Application f1675d;

    /* renamed from: a  reason: collision with root package name */
    public final String f1676a;

    /* renamed from: b  reason: collision with root package name */
    public final boolean f1677b;

    public f(String str) {
        if (j.a((CharSequence) str)) {
            this.f1676a = Featurestag.SHIELD;
        } else {
            this.f1676a = str;
        }
        this.f1677b = false;
    }

    public static f a(String str) {
        f fVar = f1674c;
        if (fVar == null || !fVar.f1676a.equals(str)) {
            f1674c = new f(str);
        }
        if (f1675d == null) {
            Object[] objArr = new Object[0];
            if (f1674c.f1677b) {
                String.format("Application is not initialized. There'll be no app_version", objArr);
            }
        }
        return f1674c;
    }

    public void b(String str, Object... objArr) {
        if (this.f1677b) {
            String.format(str, objArr);
        }
    }

    public static f a() {
        f fVar = f1674c;
        if (fVar == null || !fVar.f1676a.equals(Featurestag.SHIELD)) {
            f1674c = new f(Featurestag.SHIELD);
        }
        return f1674c;
    }

    public void a(String str, Object... objArr) {
        if (this.f1677b) {
            String.format(str, objArr);
        }
    }
}
