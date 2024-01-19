package com.freshchat.consumer.sdk.m;

import android.view.View;

public class k implements Runnable {
    public final /* synthetic */ View cV;
    public final /* synthetic */ j pf;

    public k(j jVar, View view) {
        this.pf = jVar;
        this.cV = view;
    }

    public void run() {
        f hB = this.pf.hB();
        if (hB != null) {
            hB.R(this.cV.getMeasuredHeight());
        }
    }
}
