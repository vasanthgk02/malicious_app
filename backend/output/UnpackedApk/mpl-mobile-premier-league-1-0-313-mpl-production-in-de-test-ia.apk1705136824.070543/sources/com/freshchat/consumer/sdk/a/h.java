package com.freshchat.consumer.sdk.a;

import android.view.View;
import com.freshchat.consumer.sdk.a.d.e;
import com.freshchat.consumer.sdk.b.i;

public class h implements Runnable {
    public final /* synthetic */ d ot;
    public final /* synthetic */ View pW;
    public final /* synthetic */ e pX;

    public h(d dVar, View view, e eVar) {
        this.ot = dVar;
        this.pW = view;
        this.pX = eVar;
    }

    public void run() {
        this.ot.pV = this.pW.getWidth();
        i.a(this.ot.context, this.pX.bc(), 0, this.ot.cK - this.ot.pV);
    }
}
