package com.netcore.android.utility;

import android.content.Context;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SMTInfo.kt */
public final class g {

    /* renamed from: e  reason: collision with root package name */
    public static volatile g f1301e;

    /* renamed from: f  reason: collision with root package name */
    public static final a f1302f = new a(null);

    /* renamed from: a  reason: collision with root package name */
    public j f1303a;

    /* renamed from: b  reason: collision with root package name */
    public d f1304b;

    /* renamed from: c  reason: collision with root package name */
    public a f1305c;

    /* renamed from: d  reason: collision with root package name */
    public final WeakReference<Context> f1306d;

    /* compiled from: SMTInfo.kt */
    public static final class a {
        public a() {
        }

        private final g a(WeakReference<Context> weakReference) {
            return new g(weakReference, null);
        }

        public final g b(WeakReference<Context> weakReference) {
            g gVar;
            Intrinsics.checkNotNullParameter(weakReference, "context");
            g a2 = g.f1301e;
            if (a2 != null) {
                return a2;
            }
            synchronized (g.class) {
                try {
                    g a3 = g.f1301e;
                    if (a3 != null) {
                        gVar = a3;
                    } else {
                        gVar = g.f1302f.a(weakReference);
                        g.f1301e = gVar;
                    }
                }
            }
            return gVar;
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a() {
            g.f1301e = null;
        }
    }

    public g(WeakReference<Context> weakReference) {
        this.f1306d = weakReference;
        Context context = (Context) weakReference.get();
        if (context != null) {
            Intrinsics.checkNotNullExpressionValue(context, "it");
            this.f1305c = new a(context);
            this.f1303a = new j(context);
            this.f1304b = new d(context);
        }
    }

    public final a b() {
        return this.f1305c;
    }

    public final d c() {
        return this.f1304b;
    }

    public final j d() {
        return this.f1303a;
    }

    public final void a(boolean z) {
        if (z) {
            j jVar = this.f1303a;
            if (jVar != null) {
                jVar.a();
                return;
            }
            return;
        }
        j jVar2 = this.f1303a;
        if (jVar2 != null) {
            jVar2.c();
        }
    }

    public /* synthetic */ g(WeakReference weakReference, DefaultConstructorMarker defaultConstructorMarker) {
        this(weakReference);
    }
}
