package com.xiaomi.push.service;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import com.xiaomi.channel.commonutils.logger.b;

public class bm implements ServiceConnection {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ServiceClient f4918a;

    public bm(ServiceClient serviceClient) {
        this.f4918a = serviceClient;
    }

    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        synchronized (this.f4918a) {
            this.f4918a.f785b = new Messenger(iBinder);
            this.f4918a.f786b = false;
            for (Message send : ServiceClient.a(this.f4918a)) {
                try {
                    ServiceClient.a(this.f4918a).send(send);
                } catch (RemoteException e2) {
                    b.a((Throwable) e2);
                }
            }
            ServiceClient.a(this.f4918a).clear();
        }
    }

    public void onServiceDisconnected(ComponentName componentName) {
        this.f4918a.f785b = null;
        this.f4918a.f786b = false;
    }
}
