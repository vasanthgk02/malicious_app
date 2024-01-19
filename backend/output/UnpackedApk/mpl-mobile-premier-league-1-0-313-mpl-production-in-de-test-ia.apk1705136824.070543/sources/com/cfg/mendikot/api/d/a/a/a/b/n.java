package com.cfg.mendikot.api.d.a.a.a.b;

import co.hyperverge.hypersnapsdk.c.k;
import com.mpl.androidapp.updater.util.UpdaterConstant;
import java.io.Serializable;

public class n implements Serializable, Cloneable {

    /* renamed from: a  reason: collision with root package name */
    public final String f2274a;

    /* renamed from: b  reason: collision with root package name */
    public final int f2275b;

    /* renamed from: c  reason: collision with root package name */
    public final int f2276c;

    public n(String str, int i, int i2) {
        k.a(str, (String) "Protocol name");
        this.f2274a = str;
        k.a(i, (String) "Protocol minor version");
        this.f2275b = i;
        k.a(i2, (String) "Protocol minor version");
        this.f2276c = i2;
    }

    public n a(int i, int i2) {
        return (i == this.f2275b && i2 == this.f2276c) ? this : new n(this.f2274a, i, i2);
    }

    public Object clone() {
        return super.clone();
    }

    public final boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof n)) {
            return false;
        }
        n nVar = (n) obj;
        if (!(this.f2274a.equals(nVar.f2274a) && this.f2275b == nVar.f2275b && this.f2276c == nVar.f2276c)) {
            z = false;
        }
        return z;
    }

    public final int hashCode() {
        return (this.f2274a.hashCode() ^ (this.f2275b * UpdaterConstant.APK_MIN_VERSION_CODE_ID)) ^ this.f2276c;
    }

    public String toString() {
        return this.f2274a + '/' + Integer.toString(this.f2275b) + '.' + Integer.toString(this.f2276c);
    }
}
