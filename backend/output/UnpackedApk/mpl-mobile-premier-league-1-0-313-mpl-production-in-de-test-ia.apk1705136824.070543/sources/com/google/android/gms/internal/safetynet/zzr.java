package com.google.android.gms.internal.safetynet;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.internal.safetynet.zzk.zze;

public final class zzr extends zze {
    public final /* synthetic */ String zzac;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public zzr(zzk zzk, GoogleApiClient googleApiClient, String str) {
        // this.zzac = str;
        super(googleApiClient);
    }

    public final /* synthetic */ void doExecute(AnyClient anyClient) throws RemoteException {
        ((zzi) ((zzx) anyClient).getService()).zza(this.zzaf, this.zzac);
    }
}
