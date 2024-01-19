package com.google.android.gms.internal.safetynet;

import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.internal.safetynet.zzk.zzb;

public final class zzl extends zzb {
    public final /* synthetic */ byte[] zzw;
    public final /* synthetic */ String zzx;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public zzl(GoogleApiClient googleApiClient, byte[] bArr, String str) {
        // this.zzw = bArr;
        // this.zzx = str;
        super(googleApiClient);
    }

    public final /* synthetic */ void doExecute(AnyClient anyClient) throws RemoteException {
        zzx zzx2 = (zzx) anyClient;
        zzg zzg = this.zzaf;
        byte[] bArr = this.zzw;
        String str = this.zzx;
        if (TextUtils.isEmpty(str)) {
            str = zzx2.zzb("com.google.android.safetynet.ATTEST_API_KEY");
        }
        ((zzi) zzx2.getService()).zza(zzg, bArr, str);
    }
}
