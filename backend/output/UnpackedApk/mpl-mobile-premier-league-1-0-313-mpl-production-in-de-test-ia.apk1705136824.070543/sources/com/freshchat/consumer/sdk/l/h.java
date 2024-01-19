package com.freshchat.consumer.sdk.l;

import com.freshchat.consumer.sdk.beans.Message;

public class h implements Runnable {
    public final /* synthetic */ Message pE;
    public final /* synthetic */ g pF;

    public h(g gVar, Message message) {
        this.pF = gVar;
        this.pE = message;
    }

    public void run() {
        this.pF.pD.o(this.pE);
    }
}
