package io.hansel.segments;

import android.content.Context;
import io.hansel.core.json.CoreJSONObject;
import io.hansel.core.security.ICrypto;
import java.util.HashMap;
import java.util.Set;

public class o {

    /* renamed from: d  reason: collision with root package name */
    public static o f5282d;

    /* renamed from: a  reason: collision with root package name */
    public ICrypto f5283a;

    /* renamed from: b  reason: collision with root package name */
    public HashMap<String, m> f5284b = new HashMap<>();

    /* renamed from: c  reason: collision with root package name */
    public Set<String> f5285c;

    public o(ICrypto iCrypto) {
        this.f5283a = iCrypto;
    }

    public static o a(ICrypto iCrypto) {
        if (f5282d == null) {
            synchronized (o.class) {
                if (f5282d == null) {
                    f5282d = new o(iCrypto);
                }
            }
        }
        return f5282d;
    }

    public Set<String> a(Context context) {
        return p.a(context);
    }

    public void a(Context context, String str) {
        this.f5284b.remove(str);
        p.a(context, str);
    }

    public void a(Context context, String str, CoreJSONObject coreJSONObject, boolean z) {
        this.f5284b.put(str, new m(context, str, coreJSONObject, false));
        p.a(context, str, coreJSONObject, this.f5283a, Boolean.valueOf(z));
    }

    public void b(Context context, String str, CoreJSONObject coreJSONObject, boolean z) {
        this.f5284b.put(str, new m(context, str, coreJSONObject, true));
        p.a(context, str, coreJSONObject);
        p.a(context, str, coreJSONObject, this.f5283a, Boolean.valueOf(z));
    }

    public boolean b(Context context, String str) {
        if (this.f5285c == null) {
            this.f5285c = p.n(context);
        }
        Set<String> set = this.f5285c;
        if (set == null) {
            return false;
        }
        return set.contains(str);
    }

    public m c(Context context, String str) {
        m mVar;
        m mVar2 = this.f5284b.get(str);
        if (mVar2 == null) {
            if (b(context, str)) {
                CoreJSONObject f2 = p.f(context, str);
                if (f2 == null) {
                    return null;
                }
                mVar = new m(context, str, f2, true);
            } else {
                CoreJSONObject a2 = p.a(context, str, this.f5283a);
                if (a2 == null) {
                    return null;
                }
                mVar = new m(context, str, a2, false);
            }
            mVar2 = mVar;
            this.f5284b.put(str, mVar2);
        }
        return mVar2;
    }
}
