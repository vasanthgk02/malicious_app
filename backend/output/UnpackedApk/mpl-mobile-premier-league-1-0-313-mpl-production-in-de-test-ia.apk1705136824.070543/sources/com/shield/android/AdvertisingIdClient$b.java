package com.shield.android;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import java.util.concurrent.LinkedBlockingQueue;

public final class AdvertisingIdClient$b implements ServiceConnection {

    /* renamed from: a  reason: collision with root package name */
    public final LinkedBlockingQueue<IBinder> f1443a = new LinkedBlockingQueue<>(1);

    /* renamed from: b  reason: collision with root package name */
    public boolean f1444b = false;

    public AdvertisingIdClient$b(AdvertisingIdClient$a advertisingIdClient$a) {
    }

    public IBinder a() throws InterruptedException {
        if (!this.f1444b) {
            this.f1444b = true;
            return this.f1443a.take();
        }
        throw new IllegalStateException();
    }

    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        try {
            this.f1443a.put(iBinder);
        } catch (InterruptedException unused) {
        }
    }

    public void onServiceDisconnected(ComponentName componentName) {
    }
}
