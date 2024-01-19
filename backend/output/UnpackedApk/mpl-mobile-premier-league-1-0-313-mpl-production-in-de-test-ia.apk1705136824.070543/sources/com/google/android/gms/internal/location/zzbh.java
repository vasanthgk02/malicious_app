package com.google.android.gms.internal.location;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.LocationSettingsResult;
import com.google.android.gms.location.zzbi;

/* compiled from: com.google.android.gms:play-services-location@@18.0.0 */
public final class zzbh extends zzbi<LocationSettingsResult> {
    public final /* synthetic */ LocationSettingsRequest zza;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public zzbh(zzbi zzbi, GoogleApiClient googleApiClient, LocationSettingsRequest locationSettingsRequest, String str) {
        // this.zza = locationSettingsRequest;
        super(googleApiClient);
    }

    public final /* bridge */ /* synthetic */ Result createFailedResult(Status status) {
        return new LocationSettingsResult(status, null);
    }

    public final /* bridge */ /* synthetic */ void doExecute(AnyClient anyClient) throws RemoteException {
        ((zzaz) anyClient).zzL(this.zza, this, null);
    }
}
