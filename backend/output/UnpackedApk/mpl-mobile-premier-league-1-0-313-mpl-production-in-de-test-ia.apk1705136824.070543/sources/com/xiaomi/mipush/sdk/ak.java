package com.xiaomi.mipush.sdk;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import com.xiaomi.channel.commonutils.logger.b;

public class ak implements ServiceConnection {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ag f4351a;

    public ak(ag agVar) {
        this.f4351a = agVar;
    }

    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        synchronized (this.f4351a) {
            this.f4351a.f210a = new Messenger(iBinder);
            this.f4351a.f4346c = false;
            for (Message send : ag.a(this.f4351a)) {
                try {
                    ag.a(this.f4351a).send(send);
                } catch (RemoteException e2) {
                    b.a((Throwable) e2);
                }
            }
            ag.a(this.f4351a).clear();
        }
    }

    public void onServiceDisconnected(ComponentName componentName) {
        this.f4351a.f210a = null;
        this.f4351a.f4346c = false;
    }
}
