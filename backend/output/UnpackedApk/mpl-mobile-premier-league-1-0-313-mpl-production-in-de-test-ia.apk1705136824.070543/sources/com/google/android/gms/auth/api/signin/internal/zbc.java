package com.google.android.gms.auth.api.signin.internal;

import android.content.Context;
import androidx.loader.content.AsyncTaskLoader;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.internal.SignInConnectionListener;
import java.util.Set;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-auth@@20.1.0 */
public final class zbc extends AsyncTaskLoader implements SignInConnectionListener {
    public final Semaphore zba = new Semaphore(0);
    public final Set zbb;

    public zbc(Context context, Set set) {
        super(context);
        this.zbb = set;
    }

    public final /* bridge */ /* synthetic */ Object loadInBackground() {
        int i = 0;
        for (GoogleApiClient maybeSignIn : this.zbb) {
            if (maybeSignIn.maybeSignIn(this)) {
                i++;
            }
        }
        try {
            this.zba.tryAcquire(i, 5, TimeUnit.SECONDS);
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
        }
        return null;
    }

    public final void onComplete() {
        this.zba.release();
    }

    public final void onStartLoading() {
        this.zba.drainPermits();
        forceLoad();
    }
}
