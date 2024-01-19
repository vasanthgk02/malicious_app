package com.xiaomi.push.service.receivers;

import android.content.Context;

public class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Context f4976a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ NetworkStatusReceiver f938a;

    public a(NetworkStatusReceiver networkStatusReceiver, Context context) {
        this.f938a = networkStatusReceiver;
        this.f4976a = context;
    }

    public void run() {
        this.f938a.a(this.f4976a);
    }
}
