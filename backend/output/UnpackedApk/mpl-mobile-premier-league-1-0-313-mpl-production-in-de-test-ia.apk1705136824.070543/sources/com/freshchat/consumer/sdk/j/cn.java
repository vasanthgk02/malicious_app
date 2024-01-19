package com.freshchat.consumer.sdk.j;

import android.content.Context;
import com.freshchat.consumer.sdk.beans.Message;
import java.util.ArrayList;
import java.util.List;

public final class cn implements Runnable {
    public final /* synthetic */ long fk;
    public final /* synthetic */ Context iI;
    public final /* synthetic */ Message os;

    public cn(Message message, Context context, long j) {
        this.os = message;
        this.iI = context;
        this.fk = j;
    }

    public void run() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.os);
        cm.a(this.iI, (List<Message>) arrayList, this.fk);
    }
}
