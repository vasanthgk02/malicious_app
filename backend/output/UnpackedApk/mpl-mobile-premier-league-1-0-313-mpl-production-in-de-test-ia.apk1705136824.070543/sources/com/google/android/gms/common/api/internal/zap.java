package com.google.android.gms.common.api.internal;

import android.app.PendingIntent;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.base.zau;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-base@@18.1.0 */
public abstract class zap extends LifecycleCallback implements OnCancelListener {
    public volatile boolean zaa;
    public final AtomicReference zab = new AtomicReference(null);
    public final GoogleApiAvailability zac;
    public final Handler zad = new zau(Looper.getMainLooper());

    @VisibleForTesting
    public zap(LifecycleFragment lifecycleFragment, GoogleApiAvailability googleApiAvailability) {
        super(lifecycleFragment);
        this.zac = googleApiAvailability;
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
        zam zam = (zam) this.zab.get();
        if (i != 1) {
            if (i == 2) {
                int isGooglePlayServicesAvailable = this.zac.isGooglePlayServicesAvailable(getActivity(), GoogleApiAvailabilityLight.GOOGLE_PLAY_SERVICES_VERSION_CODE);
                if (isGooglePlayServicesAvailable == 0) {
                    zad();
                    return;
                } else if (zam != null) {
                    if (zam.zab.zzb == 18 && isGooglePlayServicesAvailable == 18) {
                        return;
                    }
                } else {
                    return;
                }
            }
        } else if (i2 == -1) {
            zad();
            return;
        } else if (i2 == 0) {
            if (zam != null) {
                int i3 = 13;
                if (intent != null) {
                    i3 = intent.getIntExtra("<<ResolutionFailureErrorDetail>>", 13);
                }
                ConnectionResult connectionResult = new ConnectionResult(i3, null, zam.zab.toString());
                int i4 = zam.zaa;
                this.zab.set(null);
                zab(connectionResult, i4);
                return;
            }
            return;
        }
        if (zam != null) {
            zaa(zam.zab, zam.zaa);
        }
    }

    public final void onCancel(DialogInterface dialogInterface) {
        int i;
        ConnectionResult connectionResult = new ConnectionResult(13, null);
        zam zam = (zam) this.zab.get();
        if (zam == null) {
            i = -1;
        } else {
            i = zam.zaa;
        }
        this.zab.set(null);
        zab(connectionResult, i);
    }

    public final void onCreate(Bundle bundle) {
        if (bundle != null) {
            this.zab.set(bundle.getBoolean("resolving_error", false) ? new zam(new ConnectionResult(bundle.getInt("failed_status"), (PendingIntent) bundle.getParcelable("failed_resolution")), bundle.getInt("failed_client_id", -1)) : null);
        }
    }

    public final void onSaveInstanceState(Bundle bundle) {
        zam zam = (zam) this.zab.get();
        if (zam != null) {
            bundle.putBoolean("resolving_error", true);
            bundle.putInt("failed_client_id", zam.zaa);
            bundle.putInt("failed_status", zam.zab.zzb);
            bundle.putParcelable("failed_resolution", zam.zab.zzc);
        }
    }

    public void onStart() {
        this.zaa = true;
    }

    public void onStop() {
        this.zaa = false;
    }

    public final void zaa(ConnectionResult connectionResult, int i) {
        this.zab.set(null);
        zab(connectionResult, i);
    }

    public abstract void zab(ConnectionResult connectionResult, int i);

    public abstract void zac();

    public final void zad() {
        this.zab.set(null);
        zac();
    }

    public final void zah(ConnectionResult connectionResult, int i) {
        zam zam = new zam(connectionResult, i);
        AtomicReference atomicReference = this.zab;
        while (!atomicReference.compareAndSet(null, zam)) {
            if (atomicReference.get() != null) {
                return;
            }
        }
        this.zad.post(new zao(this, zam));
    }
}
