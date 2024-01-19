package com.google.android.gms.internal.safetynet;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.internal.safetynet.zzk.zzf;
import java.util.ArrayList;

public final class zzn extends zzf {
    public final /* synthetic */ int[] zzaa;
    public final /* synthetic */ int zzab;
    public final /* synthetic */ String zzx;
    public final /* synthetic */ String zzz;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public zzn(GoogleApiClient googleApiClient, int[] iArr, int i, String str, String str2) {
        // this.zzaa = iArr;
        // this.zzab = i;
        // this.zzz = str;
        // this.zzx = str2;
        super(googleApiClient);
    }

    public final /* synthetic */ void doExecute(AnyClient anyClient) throws RemoteException {
        zzx zzx2 = (zzx) anyClient;
        ArrayList arrayList = new ArrayList();
        for (int valueOf : this.zzaa) {
            arrayList.add(Integer.valueOf(valueOf));
        }
        zzx2.zza(this.zzaf, arrayList, this.zzab, this.zzz, this.zzx);
    }
}
