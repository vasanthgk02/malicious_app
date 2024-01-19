package com.netcore.android.geofence;

import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SMTGeofenceModel.kt */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    public String f1105a = "";

    /* renamed from: b  reason: collision with root package name */
    public int f1106b;

    /* renamed from: c  reason: collision with root package name */
    public String f1107c = "";

    /* renamed from: d  reason: collision with root package name */
    public String f1108d = "";

    /* renamed from: e  reason: collision with root package name */
    public ArrayList<b> f1109e = new ArrayList<>();

    /* renamed from: f  reason: collision with root package name */
    public String f1110f = "";
    public String g = "";
    public String h = "";
    public String i = "";

    public final String a() {
        return this.f1105a;
    }

    public final int b() {
        return this.f1106b;
    }

    public final String c() {
        return this.f1107c;
    }

    public final String d() {
        return this.f1108d;
    }

    public final ArrayList<b> e() {
        return this.f1109e;
    }

    public final String f() {
        return this.f1110f;
    }

    public final String g() {
        return this.g;
    }

    public final String h() {
        return this.h;
    }

    public final String i() {
        return this.i;
    }

    public final void a(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.f1105a = str;
    }

    public final void b(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.f1107c = str;
    }

    public final void c(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.f1108d = str;
    }

    public final void d(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.f1110f = str;
    }

    public final void e(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.g = str;
    }

    public final void f(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.h = str;
    }

    public final void g(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.i = str;
    }

    public final void a(int i2) {
        this.f1106b = i2;
    }

    public final boolean a(c cVar) {
        if (cVar != null) {
            return !Intrinsics.areEqual(this.i, cVar.i);
        }
        return false;
    }
}
