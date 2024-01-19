package com.inca.security;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import com.inca.security.Service.AppGuardServiceCaller;

/* compiled from: zb */
class iIIiiiiIiI implements ServiceConnection {
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        if (AppGuardServiceCaller.IiIiiiIiII == null) {
            AppGuardServiceCaller.IiIiiiIiII = new Messenger(new Handler(new iIiIiiiiIi(this)));
        }
        AppGuardServiceCaller.iiIIIiiIiI = new Messenger(iBinder);
        Message obtain = Message.obtain(null, 1, 0, 0);
        obtain.replyTo = AppGuardServiceCaller.IiIiiiIiII;
        try {
            AppGuardServiceCaller.iIiiIiiiIi().send(obtain);
        } catch (Exception unused) {
        }
        AppGuardServiceCaller.iiiiIiiiii = true;
    }

    public void onBindingDied(ComponentName componentName) {
        AppGuardServiceCaller.IiIiiiIiII = null;
        AppGuardServiceCaller.iiiiIiiiii = false;
    }

    public void onServiceDisconnected(ComponentName componentName) {
        AppGuardServiceCaller.IiIiiiIiII = null;
        AppGuardServiceCaller.iiiiIiiiii = false;
    }
}
