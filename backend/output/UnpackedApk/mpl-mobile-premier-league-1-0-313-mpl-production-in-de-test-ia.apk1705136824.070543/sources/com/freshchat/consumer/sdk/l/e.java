package com.freshchat.consumer.sdk.l;

import com.freshchat.consumer.sdk.beans.reqres.AgentAvailabilityResponse;

public class e implements Runnable {
    public final /* synthetic */ AgentAvailabilityResponse pA;
    public final /* synthetic */ d pB;

    public e(d dVar, AgentAvailabilityResponse agentAvailabilityResponse) {
        this.pB = dVar;
        this.pA = agentAvailabilityResponse;
    }

    public void run() {
        this.pB.py.a(this.pA);
    }
}
