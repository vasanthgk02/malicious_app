package com.xiaomi.push;

public class cc implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ bz f4536a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ String f409a;

    public cc(bz bzVar, String str) {
        this.f4536a = bzVar;
        this.f409a = str;
    }

    public void run() {
        ak.a().a(this.f409a, true);
    }
}
