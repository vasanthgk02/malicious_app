package com.google.android.gms.common.api.internal;

import android.os.DeadObjectException;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-base@@18.1.0 */
public final class zae extends zai {
    public final ApiMethodImpl zaa;

    public zae(int i, ApiMethodImpl apiMethodImpl) {
        super(i);
        Preconditions.checkNotNull(apiMethodImpl, "Null methods are not runnable.");
        this.zaa = apiMethodImpl;
    }

    public final void zad(Status status) {
        try {
            this.zaa.setFailedResult(status);
        } catch (IllegalStateException unused) {
        }
    }

    public final void zae(Exception exc) {
        try {
            this.zaa.setFailedResult(new Status(10, GeneratedOutlineSupport.outline52(exc.getClass().getSimpleName(), ": ", exc.getLocalizedMessage())));
        } catch (IllegalStateException unused) {
        }
    }

    public final void zaf(zabq zabq) throws DeadObjectException {
        try {
            this.zaa.run(zabq.zac);
        } catch (RuntimeException e2) {
            zae(e2);
        }
    }

    public final void zag(zaad zaad, boolean z) {
        ApiMethodImpl apiMethodImpl = this.zaa;
        zaad.zaa.put(apiMethodImpl, Boolean.valueOf(z));
        apiMethodImpl.addStatusListener(new zaab(zaad, apiMethodImpl));
    }
}
