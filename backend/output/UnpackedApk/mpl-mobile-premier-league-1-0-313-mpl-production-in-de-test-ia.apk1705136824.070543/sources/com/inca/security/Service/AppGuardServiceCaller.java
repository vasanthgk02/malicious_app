package com.inca.security.Service;

import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Message;
import android.os.Messenger;
import com.inca.security.Proxy.JNISoxProxy;

/* compiled from: zb */
public class AppGuardServiceCaller {
    private static /* synthetic */ int IiIIiiIIii;
    /* access modifiers changed from: private */
    public static /* synthetic */ Messenger IiIiiiIiII;
    private static /* synthetic */ ServiceConnection iiIIIiIIII = new iIIiiiiIiI();
    /* access modifiers changed from: private */
    public static /* synthetic */ Messenger iiIIIiiIiI;
    /* access modifiers changed from: private */
    public static /* synthetic */ boolean iiiiIiiiii;

    /* access modifiers changed from: private */
    public static native /* synthetic */ void IiiIiIiiIi(int i, int i2, int i3);

    public static void callService(int i, int i2) {
        IiIIiiIIii = i2;
        if (!iiiiIiiiii) {
            JNISoxProxy.getApplicationContext().bindService(new Intent(JNISoxProxy.getApplicationContext(), AppGuardService.class), iiIIIiIIII, 1);
            return;
        }
        Message obtain = Message.obtain(null, 1, 0, 0);
        obtain.replyTo = IiIiiiIiII;
        try {
            iiIIIiiIiI.send(obtain);
        } catch (Exception unused) {
        }
    }
}
