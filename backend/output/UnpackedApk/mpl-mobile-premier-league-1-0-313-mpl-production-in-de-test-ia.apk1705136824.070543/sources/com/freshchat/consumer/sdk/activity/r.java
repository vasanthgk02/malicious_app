package com.freshchat.consumer.sdk.activity;

import androidx.recyclerview.widget.RecyclerView.Adapter;
import com.freshchat.consumer.sdk.j.cq;

public class r extends cq {
    public final /* synthetic */ f lx;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public r(f fVar, Adapter adapter) {
        // this.lx = fVar;
        super(adapter);
    }

    public void ht() {
        this.lx.be.aB.scrollToPosition(this.lx.be.aM.size() - 1);
    }
}
