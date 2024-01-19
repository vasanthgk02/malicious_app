package com.unity3d.player;

public final class m {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f3526a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f3527b = false;

    /* renamed from: c  reason: collision with root package name */
    public boolean f3528c = false;

    /* renamed from: d  reason: collision with root package name */
    public boolean f3529d = true;

    /* renamed from: e  reason: collision with root package name */
    public boolean f3530e = false;

    public static void a() {
        f3526a = true;
    }

    public static void b() {
        f3526a = false;
    }

    public static boolean c() {
        return f3526a;
    }

    public final void a(boolean z) {
        this.f3527b = z;
    }

    public final void b(boolean z) {
        this.f3529d = z;
    }

    public final void c(boolean z) {
        this.f3530e = z;
    }

    public final void d(boolean z) {
        this.f3528c = z;
    }

    public final boolean d() {
        return this.f3529d;
    }

    public final boolean e() {
        return this.f3530e;
    }

    public final boolean f() {
        return f3526a && this.f3527b && !this.f3529d && !this.f3528c;
    }

    public final boolean g() {
        return this.f3528c;
    }

    public final String toString() {
        return super.toString();
    }
}
