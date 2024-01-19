package com.netcore.android.h;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/* compiled from: HSLTaskHandler */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public b f1169a;

    /* renamed from: b  reason: collision with root package name */
    public BlockingQueue<Runnable> f1170b = new LinkedBlockingQueue();

    public a() {
        b bVar = new b(1, 1, 0, TimeUnit.MILLISECONDS, this.f1170b);
        this.f1169a = bVar;
    }

    public void a(Runnable runnable) {
        this.f1169a.execute(runnable);
    }
}
