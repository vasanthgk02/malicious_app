package defpackage;

import android.content.ContentValues;
import android.content.Context;
import com.android.tools.r8.GeneratedOutlineSupport;

/* renamed from: af  reason: default package */
public abstract class af {

    /* renamed from: a  reason: collision with root package name */
    public long f2703a = -1;

    public abstract ContentValues a();

    public boolean a(Object obj, Object obj2) {
        if (obj == null || obj2 == null) {
            return false;
        }
        return obj.equals(obj2);
    }

    public boolean c(Context context) {
        boolean z = true;
        if (an.a(context).f56a.delete("AuthorizationToken", GeneratedOutlineSupport.outline45("rowid = ", this.f2703a), null) != 1) {
            z = false;
        }
        if (z) {
            this.f2703a = -1;
        }
        return z;
    }
}
