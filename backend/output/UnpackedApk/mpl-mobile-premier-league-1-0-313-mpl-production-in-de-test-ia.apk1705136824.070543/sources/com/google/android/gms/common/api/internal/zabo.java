package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.Api.Client;

/* compiled from: com.google.android.gms:play-services-base@@18.1.0 */
public final class zabo implements Runnable {
    public final /* synthetic */ zabp zaa;

    public zabo(zabp zabp) {
        this.zaa = zabp;
    }

    public final void run() {
        Client client = this.zaa.zaa.zac;
        client.disconnect(client.getClass().getName().concat(" disconnecting because it was signed out."));
    }
}
