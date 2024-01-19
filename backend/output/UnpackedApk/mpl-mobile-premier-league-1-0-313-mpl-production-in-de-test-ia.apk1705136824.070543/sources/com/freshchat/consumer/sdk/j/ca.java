package com.freshchat.consumer.sdk.j;

import android.content.Context;
import com.freshchat.consumer.sdk.b.e;
import java.util.Map;

public class ca implements Runnable {
    public final /* synthetic */ Context iI;
    public final /* synthetic */ by mO;
    public final /* synthetic */ boolean mP;

    public ca(by byVar, boolean z, Context context) {
        this.mO = byVar;
        this.mP = z;
        this.iI = context;
    }

    public void run() {
        if (this.mP) {
            Map a2 = this.mO.bO(this.iI);
            this.mO.c(this.iI, e.i(this.iI).bj(), a2);
        }
        this.mO.e(this.iI, true);
    }
}
