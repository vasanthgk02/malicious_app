package com.google.android.gms.internal.location;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.zzbi;

/* compiled from: com.google.android.gms:play-services-location@@18.0.0 */
public abstract class zzae extends zzbi<Status> {
    public zzae(GoogleApiClient googleApiClient) {
        super(googleApiClient);
    }

    public final /* bridge */ /* synthetic */ Result createFailedResult(Status status) {
        return status;
    }
}
