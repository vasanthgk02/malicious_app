package com.netcore.android.e;

import android.content.Context;
import com.netcore.android.geofence.c;
import com.netcore.android.geofence.h;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SMTDataBaseService.kt */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    public static d f1028a;

    /* renamed from: b  reason: collision with root package name */
    public static volatile b f1029b;

    /* renamed from: c  reason: collision with root package name */
    public static final a f1030c = new a(null);

    /* compiled from: SMTDataBaseService.kt */
    public static final class a {
        public a() {
        }

        private final b a(WeakReference<Context> weakReference) {
            Context context = (Context) weakReference.get();
            if (context != null) {
                com.netcore.android.e.d.a aVar = d.i;
                Intrinsics.checkNotNullExpressionValue(context, "it");
                b.f1028a = aVar.b(context);
            }
            return new b(weakReference, null);
        }

        public final b b(WeakReference<Context> weakReference) {
            b bVar;
            Intrinsics.checkNotNullParameter(weakReference, "context");
            b a2 = b.f1029b;
            if (a2 != null) {
                return a2;
            }
            synchronized (b.class) {
                try {
                    b a3 = b.f1029b;
                    if (a3 != null) {
                        bVar = a3;
                    } else {
                        bVar = b.f1030c.a(weakReference);
                        b.f1029b = bVar;
                    }
                }
            }
            return bVar;
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public b(WeakReference<Context> weakReference) {
    }

    public final boolean b(int i) {
        d dVar = f1028a;
        if (dVar != null) {
            e c2 = dVar.c();
            if (c2 != null) {
                return c2.c(i);
            }
        }
        return false;
    }

    public final void c() {
        d dVar = f1028a;
        if (dVar != null) {
            e c2 = dVar.c();
            if (c2 != null) {
                c2.c();
            }
        }
    }

    public final HashMap<String, String> d(int i) {
        d dVar = f1028a;
        if (dVar != null) {
            e c2 = dVar.c();
            if (c2 != null) {
                HashMap<String, String> b2 = c2.b(i);
                if (b2 != null) {
                    return b2;
                }
            }
        }
        return new HashMap<>();
    }

    public final c e(String str) {
        Intrinsics.checkNotNullParameter(str, "groupId");
        d dVar = f1028a;
        if (dVar != null) {
            f d2 = dVar.d();
            if (d2 != null) {
                return d2.d(str);
            }
        }
        return null;
    }

    public final void f(String str) {
        Intrinsics.checkNotNullParameter(str, "tableName");
        d dVar = f1028a;
        if (dVar != null) {
            h f2 = dVar.f();
            if (f2 != null) {
                f2.a(str);
            }
        }
    }

    public /* synthetic */ b(WeakReference weakReference, DefaultConstructorMarker defaultConstructorMarker) {
        this(weakReference);
    }

    public final void b() {
        d dVar = f1028a;
        if (dVar != null) {
            h f2 = dVar.f();
            if (f2 != null) {
                f2.e();
            }
        }
    }

    public final void c(String str) {
        d dVar = f1028a;
        if (dVar != null) {
            h f2 = dVar.f();
            if (f2 != null) {
                f2.c(str);
            }
        }
    }

    public final List<com.netcore.android.inapp.h.a> b(HashMap<String, Object> hashMap) {
        Intrinsics.checkNotNullParameter(hashMap, "payloadMap");
        d dVar = f1028a;
        if (dVar != null) {
            e c2 = dVar.c();
            if (c2 != null) {
                return c2.a(hashMap);
            }
        }
        return null;
    }

    public final void c(int i) {
        d dVar = f1028a;
        if (dVar != null) {
            e c2 = dVar.c();
            if (c2 != null) {
                c2.a(i);
            }
        }
    }

    public final com.netcore.android.geofence.b d(String str) {
        Intrinsics.checkNotNullParameter(str, "geoFenceId");
        d dVar = f1028a;
        if (dVar != null) {
            g e2 = dVar.e();
            if (e2 != null) {
                return e2.d(str);
            }
        }
        return null;
    }

    public final HashMap<String, String> a(int i, int i2) {
        d dVar = f1028a;
        if (dVar != null) {
            e c2 = dVar.c();
            if (c2 != null) {
                HashMap<String, String> a2 = c2.a(i, i2);
                if (a2 != null) {
                    return a2;
                }
            }
        }
        return new HashMap<>();
    }

    public final void b(String str) {
        d dVar = f1028a;
        if (dVar != null) {
            g e2 = dVar.e();
            if (e2 != null) {
                e2.c(str);
            }
        }
    }

    public final Map<Integer, h> b(List<String> list) {
        Intrinsics.checkNotNullParameter(list, "ids");
        d dVar = f1028a;
        if (dVar != null) {
            g e2 = dVar.e();
            if (e2 != null) {
                return e2.b(list);
            }
        }
        return null;
    }

    public final void a(Integer[] numArr, String str, int i) {
        Intrinsics.checkNotNullParameter(numArr, "ids");
        Intrinsics.checkNotNullParameter(str, "columneName");
        d dVar = f1028a;
        if (dVar != null) {
            e c2 = dVar.c();
            if (c2 != null) {
                c2.a(numArr, str, i);
            }
        }
    }

    public final boolean a(int i) {
        d dVar = f1028a;
        if (dVar != null) {
            e c2 = dVar.c();
            if (c2 != null) {
                return c2.d(i);
            }
        }
        return false;
    }

    public final void a(int i, String str, String str2, String str3) {
        Intrinsics.checkNotNullParameter(str2, "payload");
        Intrinsics.checkNotNullParameter(str3, "eventType");
        d dVar = f1028a;
        if (dVar != null) {
            e c2 = dVar.c();
            if (c2 != null) {
                c2.a(Integer.valueOf(i), str, str2, str3);
            }
        }
    }

    public final List<com.netcore.android.inapp.h.b> a(HashMap<String, Object> hashMap) {
        Intrinsics.checkNotNullParameter(hashMap, "payloadMap");
        d dVar = f1028a;
        if (dVar != null) {
            h f2 = dVar.f();
            if (f2 != null) {
                return f2.a(hashMap);
            }
        }
        return null;
    }

    public final void a(com.netcore.android.inapp.h.b bVar, long j) {
        Intrinsics.checkNotNullParameter(bVar, "inAppRule");
        d dVar = f1028a;
        if (dVar != null) {
            h f2 = dVar.f();
            if (f2 != null) {
                f2.a(bVar, j);
            }
        }
    }

    public final void a(String str, String str2) {
        d dVar = f1028a;
        if (dVar != null) {
            h f2 = dVar.f();
            if (f2 != null) {
                f2.a(str, str2);
            }
        }
    }

    public final void a(ArrayList<com.netcore.android.inapp.h.b> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "inAppRules");
        d dVar = f1028a;
        if (dVar != null) {
            h f2 = dVar.f();
            if (f2 != null) {
                f2.a(arrayList);
            }
        }
    }

    public final void a(c cVar) {
        Intrinsics.checkNotNullParameter(cVar, "geoFenceGroup");
        d dVar = f1028a;
        if (dVar != null) {
            f d2 = dVar.d();
            if (d2 != null) {
                d2.a(cVar);
            }
        }
    }

    public final void a(c cVar, ArrayList<com.netcore.android.geofence.b> arrayList) {
        Intrinsics.checkNotNullParameter(cVar, "geoFenceGroup");
        Intrinsics.checkNotNullParameter(arrayList, "geoFences");
        d dVar = f1028a;
        if (dVar != null) {
            g e2 = dVar.e();
            if (e2 != null) {
                e2.a(cVar, arrayList);
            }
        }
    }

    public final void a(String str) {
        d dVar = f1028a;
        if (dVar != null) {
            f d2 = dVar.d();
            if (d2 != null) {
                d2.c(str);
            }
        }
    }

    public final Map<Integer, h> a(double d2, double d3) {
        d dVar = f1028a;
        if (dVar != null) {
            g e2 = dVar.e();
            if (e2 != null) {
                return e2.a(d2, d3);
            }
        }
        return null;
    }

    public final List<String> a(List<String> list) {
        Intrinsics.checkNotNullParameter(list, "ids");
        d dVar = f1028a;
        if (dVar != null) {
            g e2 = dVar.e();
            if (e2 != null) {
                return e2.a(list);
            }
        }
        return null;
    }
}
