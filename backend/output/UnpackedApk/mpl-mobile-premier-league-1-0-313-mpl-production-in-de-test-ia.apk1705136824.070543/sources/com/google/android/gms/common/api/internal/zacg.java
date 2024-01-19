package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import android.os.IBinder;

/* compiled from: com.google.android.gms:play-services-base@@18.1.0 */
public final /* synthetic */ class zacg implements Runnable {
    public final /* synthetic */ NonGmsServiceBrokerClient zaa;
    public final /* synthetic */ IBinder zab;

    public final void run() {
        NonGmsServiceBrokerClient nonGmsServiceBrokerClient = this.zaa;
        IBinder iBinder = this.zab;
        nonGmsServiceBrokerClient.zaj = false;
        nonGmsServiceBrokerClient.zai = iBinder;
        String.valueOf(iBinder);
        new Bundle();
        throw null;
    }
}
