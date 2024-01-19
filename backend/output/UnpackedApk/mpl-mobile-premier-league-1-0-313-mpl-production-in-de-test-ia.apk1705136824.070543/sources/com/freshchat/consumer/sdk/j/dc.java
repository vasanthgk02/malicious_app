package com.freshchat.consumer.sdk.j;

import android.content.Context;
import com.freshchat.consumer.sdk.b.a;
import com.freshchat.consumer.sdk.j.bg.b;

public final class dc implements Runnable {
    public final /* synthetic */ Context iI;
    public final /* synthetic */ b sT;

    public dc(Context context, b bVar) {
        this.iI = context;
        this.sT = bVar;
    }

    public void run() {
        if (this.iI == null) {
            ai.e("FRESHCHAT_WARNING", "context cannot be null while broadcasting event.");
            return;
        }
        try {
            a.a(this.iI, bg.a(this.sT.gy()));
        } catch (Exception e2) {
            q.a(e2);
        }
    }
}
