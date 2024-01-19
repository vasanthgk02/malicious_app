package com.google.android.gms.common.internal;

import com.google.android.gms.common.api.Response;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.internal.PendingResultUtil.ResultConverter;

/* compiled from: com.google.android.gms:play-services-base@@18.1.0 */
public final class zaq implements ResultConverter {
    public final /* synthetic */ Response zaa;

    public zaq(Response response) {
        this.zaa = response;
    }

    public final Object convert(Result result) {
        Response response = this.zaa;
        response.zza = result;
        return response;
    }
}
