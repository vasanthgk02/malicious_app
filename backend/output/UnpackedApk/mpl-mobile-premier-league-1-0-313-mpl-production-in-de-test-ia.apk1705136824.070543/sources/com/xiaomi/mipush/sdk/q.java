package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.pm.PackageInfo;

public final class q implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Context f4377a;

    public q(Context context) {
        this.f4377a = context;
    }

    public void run() {
        try {
            PackageInfo packageInfo = this.f4377a.getPackageManager().getPackageInfo(this.f4377a.getPackageName(), 4612);
            p.c(this.f4377a);
            p.d(this.f4377a, packageInfo);
            p.c(this.f4377a, packageInfo);
        } catch (Throwable unused) {
        }
    }
}
