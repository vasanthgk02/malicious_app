package com.freshchat.consumer.sdk.k;

import com.freshchat.consumer.sdk.b.k;
import java.util.List;

public class d implements Runnable {
    public final /* synthetic */ c lC;
    public final /* synthetic */ List nr;

    public d(c cVar, List list) {
        this.lC = cVar;
        this.nr = list;
    }

    public void run() {
        if (this.lC.C(this.nr) == k.DROP_DOWN) {
            this.lC.x(this.lC.E(this.nr));
        }
    }
}
