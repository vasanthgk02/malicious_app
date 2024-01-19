package defpackage;

import android.content.Context;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.razorpay.BaseConstants;

/* renamed from: t  reason: default package */
public class t {

    /* renamed from: a  reason: collision with root package name */
    public static final bi f3332a = new bi();

    /* renamed from: a  reason: collision with other field name */
    public static final j f147a = new j();

    /* renamed from: a  reason: collision with other field name */
    public static t f148a;

    /* renamed from: a  reason: collision with other field name */
    public ag f149a;

    /* renamed from: b  reason: collision with root package name */
    public String f3333b;

    public t(Context context) {
        ag a2 = f147a.a(context.getPackageName(), context);
        this.f149a = a2;
        if (a2 != null) {
            String str = a2.f2708e;
            if (str != null) {
                this.f3333b = str;
                String a3 = cj.a(context, context.getPackageName());
                if (BaseConstants.DEVELOPMENT.equalsIgnoreCase(a3)) {
                    z zVar = z.DEVO;
                } else if ("gamma".equalsIgnoreCase(a3)) {
                    z zVar2 = z.PRE_PROD;
                } else {
                    return;
                }
                cd.a();
                return;
            }
        }
        throw new IllegalArgumentException("Invalid API Key");
    }

    public static t a(Context context) {
        if (f148a == null) {
            synchronized (t.class) {
                try {
                    if (f148a == null) {
                        f148a = new t(context);
                    }
                }
            }
        }
        return f148a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m307a(Context context) {
        if (f147a != null) {
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("amzn://");
            outline73.append(context.getPackageName());
            return outline73.toString();
        }
        throw null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m308a(Context context) {
        boolean z;
        j jVar = f147a;
        if (jVar != null) {
            if (context == null) {
                cp.d(j.f3317a, "context can't be null!");
            } else {
                String packageName = context.getPackageName();
                String str = j.f3317a;
                cp.c(str, "isAPIKeyValid : packageName=" + packageName);
                if (!(packageName == null || jVar.a(packageName, context) == null)) {
                    z = true;
                    if (z || this.f3333b == null) {
                        return false;
                    }
                    return true;
                }
            }
            z = false;
            if (z) {
            }
            return false;
        }
        throw null;
    }
}
