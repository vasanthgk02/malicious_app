package com.freshchat.consumer.sdk.service.c;

import com.freshchat.consumer.sdk.beans.config.RefreshIntervals;
import com.freshchat.consumer.sdk.j.ap;
import com.freshchat.consumer.sdk.service.e.j;
import com.freshchat.consumer.sdk.service.e.k;

public abstract class a<T1 extends j, T2 extends k> extends b<T1, T2> {
    public RefreshIntervals getRefreshIntervals() {
        return ap.bD(getContext()).getRefreshIntervals();
    }
}
