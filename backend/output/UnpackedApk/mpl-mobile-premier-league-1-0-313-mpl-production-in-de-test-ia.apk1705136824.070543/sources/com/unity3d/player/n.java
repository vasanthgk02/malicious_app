package com.unity3d.player;

import java.lang.reflect.Method;
import java.util.HashMap;

public final class n {

    /* renamed from: a  reason: collision with root package name */
    public HashMap f3531a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    public Class f3532b = null;

    /* renamed from: c  reason: collision with root package name */
    public Object f3533c = null;

    public class a {

        /* renamed from: a  reason: collision with root package name */
        public Class[] f3534a;

        /* renamed from: b  reason: collision with root package name */
        public Method f3535b = null;

        public a(Class[] clsArr) {
            this.f3534a = clsArr;
        }
    }

    public n(Class cls, Object obj) {
        this.f3532b = cls;
        this.f3533c = obj;
    }

    private void a(String str, a aVar) {
        try {
            aVar.f3535b = this.f3532b.getMethod(str, aVar.f3534a);
        } catch (Exception e2) {
            f.Log(6, "Exception while trying to get method " + str + ". " + e2.getLocalizedMessage());
            aVar.f3535b = null;
        }
    }

    public final Object a(String str, Object... objArr) {
        StringBuilder sb;
        Object obj = null;
        if (!this.f3531a.containsKey(str)) {
            sb = new StringBuilder("No definition for method ");
            sb.append(str);
            str = " can be found";
        } else {
            a aVar = (a) this.f3531a.get(str);
            if (aVar.f3535b == null) {
                a(str, aVar);
            }
            Method method = aVar.f3535b;
            if (method == null) {
                sb = new StringBuilder("Unable to create method: ");
            } else {
                try {
                    obj = objArr.length == 0 ? method.invoke(this.f3533c, new Object[0]) : method.invoke(this.f3533c, objArr);
                } catch (Exception e2) {
                    f.Log(6, "Error trying to call delegated method " + str + ". " + e2.getLocalizedMessage());
                }
                return obj;
            }
        }
        sb.append(str);
        f.Log(6, sb.toString());
        return null;
    }

    public final void a(String str, Class[] clsArr) {
        this.f3531a.put(str, new a(clsArr));
    }
}
