package com.google.android.gms.internal.auth;

import android.os.RemoteException;
import com.google.android.gms.auth.account.zze;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl;

/* compiled from: com.google.android.gms:play-services-auth-base@@17.1.4 */
public final class zzac extends ApiMethodImpl<Result, zzam> {
    public final /* synthetic */ boolean zza;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public zzac(zzal zzal, Api api, GoogleApiClient googleApiClient, boolean z) {
        // this.zza = z;
        super(api, googleApiClient);
    }

    public final Result createFailedResult(Status status) {
        return new zzaj(status);
    }

    public final /* bridge */ /* synthetic */ void doExecute(AnyClient anyClient) throws RemoteException {
        ((zze) ((zzam) anyClient).getService()).zzf(this.zza);
        setResult(new zzaj(Status.RESULT_SUCCESS));
    }

    @KeepForSdk
    public final /* bridge */ /* synthetic */ void setResult(Object obj) {
        super.setResult((Result) obj);
    }
}
