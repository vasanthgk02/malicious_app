package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.Intent;
import com.xiaomi.channel.commonutils.logger.b;

public final class s implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Context f4379a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ Intent f231a;

    public s(Context context, Intent intent) {
        this.f4379a = context;
        this.f231a = intent;
    }

    public void run() {
        try {
            this.f4379a.startService(this.f231a);
        } catch (Exception e2) {
            b.a(e2.getMessage());
        }
    }
}
