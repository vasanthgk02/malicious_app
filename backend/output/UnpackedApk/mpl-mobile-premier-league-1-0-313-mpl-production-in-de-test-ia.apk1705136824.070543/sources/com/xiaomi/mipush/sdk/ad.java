package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.Intent;

public final class ad implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Context f4341a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ Intent f201a;

    public ad(Context context, Intent intent) {
        this.f4341a = context;
        this.f201a = intent;
    }

    public void run() {
        PushMessageHandler.b(this.f4341a, this.f201a);
    }
}
