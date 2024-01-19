package com.inca.security;

import android.os.Handler;
import android.os.Message;
import com.inca.security.Service.AppGuardService;

/* renamed from: com.inca.security.iiiIiiiiiI  reason: case insensitive filesystem */
/* compiled from: db */
class C0096iiiIiiiiiI extends Handler {
    public final /* synthetic */ AppGuardService iiIIIiiIiI;

    public void handleMessage(Message message) {
        int i;
        try {
            if (message.what != 1) {
                i = 0;
                try {
                    message.replyTo.send(Message.obtain(null, message.what, i, 0));
                } catch (Exception unused) {
                }
            } else {
                i = this.iiIIIiiIiI.IiiiIIiIIi(1);
                message.replyTo.send(Message.obtain(null, message.what, i, 0));
            }
        } catch (UnsatisfiedLinkError unused2) {
        }
    }

    public C0096iiiIiiiiiI(AppGuardService appGuardService) {
        this.iiIIIiiIiI = appGuardService;
    }
}
