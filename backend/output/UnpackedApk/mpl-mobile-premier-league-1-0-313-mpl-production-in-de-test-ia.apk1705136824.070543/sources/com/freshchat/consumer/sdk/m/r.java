package com.freshchat.consumer.sdk.m;

import com.freshchat.consumer.sdk.a.l.b;
import com.freshchat.consumer.sdk.service.c;
import java.util.List;

public class r implements c<List<b>> {
    public final /* synthetic */ n pl;

    public r(n nVar) {
        this.pl = nVar;
    }

    public void b(com.freshchat.consumer.sdk.service.b<List<b>> bVar) {
        this.pl.a(bVar);
        this.pl.ra.post(new s(this));
    }
}
