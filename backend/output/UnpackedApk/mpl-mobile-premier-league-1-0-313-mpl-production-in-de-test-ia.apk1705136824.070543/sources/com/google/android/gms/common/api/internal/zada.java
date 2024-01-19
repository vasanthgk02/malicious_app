package com.google.android.gms.common.api.internal;

import android.os.Looper;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.ResultCallbacks;
import com.google.android.gms.common.api.ResultTransform;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.TransformedResult;
import com.google.android.gms.common.internal.Preconditions;
import java.lang.ref.WeakReference;

/* compiled from: com.google.android.gms:play-services-base@@18.1.0 */
public final class zada<R extends Result> extends TransformedResult<R> implements ResultCallback<R> {
    public ResultTransform zaa = null;
    public zada zab = null;
    public volatile ResultCallbacks zac = null;
    public PendingResult zad = null;
    public final Object zae = new Object();
    public Status zaf = null;
    public final WeakReference zag;
    public final zacz zah;
    public boolean zai = false;

    public zada(WeakReference weakReference) {
        Preconditions.checkNotNull(weakReference, "GoogleApiClient reference must not be null");
        this.zag = weakReference;
        GoogleApiClient googleApiClient = (GoogleApiClient) weakReference.get();
        this.zah = new zacz(this, googleApiClient != null ? googleApiClient.getLooper() : Looper.getMainLooper());
    }

    public static final void zan(Result result) {
        if (result instanceof Releasable) {
            try {
                ((Releasable) result).release();
            } catch (RuntimeException unused) {
                "Unable to release ".concat(String.valueOf(result));
            }
        }
    }

    public final void onResult(Result result) {
        synchronized (this.zae) {
            try {
                if (!result.getStatus().isSuccess()) {
                    zaj(result.getStatus());
                    zan(result);
                } else if (this.zaa != null) {
                    zaco.zaa.submit(new zacy(this, result));
                } else if (zam()) {
                    ResultCallbacks resultCallbacks = this.zac;
                    Preconditions.checkNotNull(resultCallbacks);
                    resultCallbacks.onSuccess(result);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final <S extends Result> TransformedResult<S> then(ResultTransform<? super R, ? extends S> resultTransform) {
        zada zada;
        synchronized (this.zae) {
            try {
                boolean z = true;
                Preconditions.checkState(this.zaa == null, "Cannot call then() twice.");
                if (this.zac != null) {
                    z = false;
                }
                Preconditions.checkState(z, "Cannot call then() and andFinally() on the same TransformedResult.");
                this.zaa = resultTransform;
                zada = new zada(this.zag);
                this.zab = zada;
                zak();
            }
        }
        return zada;
    }

    public final void zaj(Status status) {
        synchronized (this.zae) {
            this.zaf = status;
            zal(status);
        }
    }

    public final void zak() {
        if (this.zaa != null || this.zac != null) {
            GoogleApiClient googleApiClient = (GoogleApiClient) this.zag.get();
            if (!(this.zai || this.zaa == null || googleApiClient == null)) {
                googleApiClient.zao(this);
                this.zai = true;
            }
            Status status = this.zaf;
            if (status != null) {
                zal(status);
                return;
            }
            PendingResult pendingResult = this.zad;
            if (pendingResult != null) {
                pendingResult.setResultCallback(this);
            }
        }
    }

    public final void zal(Status status) {
        synchronized (this.zae) {
            ResultTransform resultTransform = this.zaa;
            if (resultTransform != null) {
                Status onFailure = resultTransform.onFailure(status);
                Preconditions.checkNotNull(onFailure, "onFailure must not return null");
                zada zada = this.zab;
                Preconditions.checkNotNull(zada);
                zada.zaj(onFailure);
            } else if (zam()) {
                ResultCallbacks resultCallbacks = this.zac;
                Preconditions.checkNotNull(resultCallbacks);
                resultCallbacks.onFailure(status);
            }
        }
    }

    public final boolean zam() {
        return (this.zac == null || ((GoogleApiClient) this.zag.get()) == null) ? false : true;
    }
}
