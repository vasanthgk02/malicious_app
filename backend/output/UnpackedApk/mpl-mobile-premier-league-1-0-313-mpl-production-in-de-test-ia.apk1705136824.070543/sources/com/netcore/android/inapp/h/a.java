package com.netcore.android.inapp.h;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: SMTEvents.kt */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public String f1216a;

    /* renamed from: b  reason: collision with root package name */
    public String f1217b;

    /* renamed from: c  reason: collision with root package name */
    public String f1218c;

    public final String a() {
        String str = this.f1218c;
        if (str != null) {
            return str;
        }
        Intrinsics.throwUninitializedPropertyAccessException("eventDate");
        throw null;
    }

    public final String b() {
        String str = this.f1217b;
        if (str != null) {
            return str;
        }
        Intrinsics.throwUninitializedPropertyAccessException("eventPayload");
        throw null;
    }

    public final void b(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
    }

    public final String c() {
        String str = this.f1216a;
        if (str != null) {
            return str;
        }
        Intrinsics.throwUninitializedPropertyAccessException("id");
        throw null;
    }

    public final void c(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
    }

    public final void d(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.f1217b = str;
    }

    public final void e(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.f1216a = str;
    }

    public final void a(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.f1218c = str;
    }
}
