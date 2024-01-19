package com.google.android.gms.common.api.internal;

import android.os.DeadObjectException;
import android.os.RemoteException;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-base@@18.1.0 */
public abstract class zad extends zac {
    public final TaskCompletionSource zaa;

    public zad(int i, TaskCompletionSource taskCompletionSource) {
        super(i);
        this.zaa = taskCompletionSource;
    }

    public abstract void zac(zabq zabq) throws RemoteException;

    public final void zad(Status status) {
        this.zaa.trySetException(new ApiException(status));
    }

    public final void zae(Exception exc) {
        this.zaa.trySetException(exc);
    }

    public final void zaf(zabq zabq) throws DeadObjectException {
        try {
            zac(zabq);
        } catch (DeadObjectException e2) {
            this.zaa.trySetException(new ApiException(zai.zah(e2)));
            throw e2;
        } catch (RemoteException e3) {
            this.zaa.trySetException(new ApiException(zai.zah(e3)));
        } catch (RuntimeException e4) {
            this.zaa.trySetException(e4);
        }
    }
}
