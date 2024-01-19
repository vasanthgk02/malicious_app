package com.freshchat.consumer.sdk.j;

import android.content.Context;
import com.freshchat.consumer.sdk.beans.UserEvent;
import java.util.Map;

public class bz implements Runnable {
    public final /* synthetic */ Context iI;
    public final /* synthetic */ String mM;
    public final /* synthetic */ Map mN;
    public final /* synthetic */ by mO;

    public bz(by byVar, Context context, String str, Map map) {
        this.mO = byVar;
        this.iI = context;
        this.mM = str;
        this.mN = map;
    }

    public void run() {
        try {
            this.mO.E(this.iI, this.mM);
            this.mO.mI.a(this.iI, new UserEvent(this.mM, this.mO.b(this.iI, this.mN), n.fP()));
            this.mO.bQ(this.iI);
            this.mO.e(this.iI, false);
        } catch (Exception e2) {
            q.a(e2);
        }
    }
}
