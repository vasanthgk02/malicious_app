package com.freshchat.consumer.sdk.k;

import com.freshchat.consumer.sdk.beans.reqres.AgentAvailabilityResponse;
import com.freshchat.consumer.sdk.l.c.a;
import com.freshchat.consumer.sdk.service.c;

public class s implements a {
    public final /* synthetic */ c rw;
    public final /* synthetic */ r rx;

    public s(r rVar, c cVar) {
        this.rx = rVar;
        this.rw = cVar;
    }

    public void a(AgentAvailabilityResponse agentAvailabilityResponse) {
        this.rx.ru = agentAvailabilityResponse;
        r rVar = this.rx;
        rVar.rv = rVar.jq();
        this.rx.b(this.rw);
    }

    public void hU() {
        this.rx.c(this.rw);
    }
}
