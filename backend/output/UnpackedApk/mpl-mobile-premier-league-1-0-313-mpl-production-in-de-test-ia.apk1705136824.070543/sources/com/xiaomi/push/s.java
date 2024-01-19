package com.xiaomi.push;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.xiaomi.push.C0097r.b;

public class s extends Handler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0097r f4806a;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public s(C0097r rVar, Looper looper) {
        // this.f4806a = rVar;
        super(looper);
    }

    public void handleMessage(Message message) {
        b bVar = (b) message.obj;
        int i = message.what;
        if (i == 0) {
            bVar.a();
        } else if (i == 1) {
            bVar.c();
        }
        super.handleMessage(message);
    }
}
