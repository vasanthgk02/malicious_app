package com.freshchat.consumer.sdk.l;

import android.content.Context;
import com.freshchat.consumer.sdk.beans.Message;
import com.freshchat.consumer.sdk.l.c.b;
import java.lang.ref.WeakReference;

public class g implements Runnable {
    public final /* synthetic */ long fk;
    public final /* synthetic */ WeakReference pC;
    public final /* synthetic */ b pD;
    public final /* synthetic */ c pz;

    public g(c cVar, WeakReference weakReference, b bVar, long j) {
        this.pz = cVar;
        this.pC = weakReference;
        this.pD = bVar;
        this.fk = j;
    }

    public void run() {
        Context context = (Context) this.pC.get();
        if (context == null) {
            this.pz.a(this.pD);
            return;
        }
        Message B = new com.freshchat.consumer.sdk.c.g(context).B(this.fk);
        if (B == null) {
            this.pz.a(this.pD);
        } else {
            this.pz.a(new h(this, B));
        }
    }
}
