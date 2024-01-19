package com.google.android.gms.internal.safetynet;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.internal.safetynet.zzk.zzf;
import java.util.List;

public final class zzm extends zzf {
    public final /* synthetic */ String zzx = null;
    public final /* synthetic */ List zzy;
    public final /* synthetic */ String zzz;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public zzm(zzk zzk, GoogleApiClient googleApiClient, List list, String str, String str2) {
        // this.zzy = list;
        // this.zzz = str;
        super(googleApiClient);
    }

    public final /* synthetic */ void doExecute(AnyClient anyClient) throws RemoteException {
        ((zzx) anyClient).zza(this.zzaf, this.zzy, 1, this.zzz, this.zzx);
    }
}
