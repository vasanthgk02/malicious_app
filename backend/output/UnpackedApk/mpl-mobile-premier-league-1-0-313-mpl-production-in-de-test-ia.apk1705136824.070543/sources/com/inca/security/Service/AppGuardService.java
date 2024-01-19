package com.inca.security.Service;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Messenger;
import android.support.annotation.Nullable;

/* compiled from: db */
public class AppGuardService extends Service {
    private static final /* synthetic */ int iiIIIiiIiI = 1;
    private /* synthetic */ Handler IiIIiiIIii = new C0096iiiIiiiiiI(this);

    /* access modifiers changed from: private */
    public native /* synthetic */ int IiiiIIiIIi(int i);

    @Nullable
    public IBinder onBind(Intent intent) {
        return new Messenger(this.IiIIiiIIii).getBinder();
    }

    public void onDestroy() {
        super.onDestroy();
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        super.onStartCommand(intent, i, i2);
        return 2;
    }

    public void onCreate() {
        super.onCreate();
    }

    public boolean onUnbind(Intent intent) {
        return super.onUnbind(intent);
    }
}
