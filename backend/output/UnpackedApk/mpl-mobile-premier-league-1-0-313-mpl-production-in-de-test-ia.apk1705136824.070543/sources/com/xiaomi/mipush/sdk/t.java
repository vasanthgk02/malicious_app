package com.xiaomi.mipush.sdk;

import android.content.Context;

public final class t implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Context f4380a;

    public t(Context context) {
        this.f4380a = context;
    }

    public void run() {
        MessageHandleService.c(this.f4380a);
    }
}
