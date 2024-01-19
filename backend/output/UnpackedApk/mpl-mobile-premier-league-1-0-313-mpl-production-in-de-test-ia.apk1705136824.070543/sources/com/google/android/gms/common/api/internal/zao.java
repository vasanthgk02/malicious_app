package com.google.android.gms.common.api.internal;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.PendingIntent;
import android.widget.ProgressBar;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.GoogleApiActivity;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.zac;

/* compiled from: com.google.android.gms:play-services-base@@18.1.0 */
public final class zao implements Runnable {
    public final /* synthetic */ zap zaa;
    public final zam zab;

    public zao(zap zap, zam zam) {
        this.zaa = zap;
        this.zab = zam;
    }

    public final void run() {
        if (this.zaa.zaa) {
            ConnectionResult connectionResult = this.zab.zab;
            if (connectionResult.hasResolution()) {
                zap zap = this.zaa;
                LifecycleFragment lifecycleFragment = zap.mLifecycleFragment;
                Activity activity = zap.getActivity();
                PendingIntent pendingIntent = connectionResult.zzc;
                Preconditions.checkNotNull(pendingIntent);
                lifecycleFragment.startActivityForResult(GoogleApiActivity.zaa(activity, pendingIntent, this.zab.zaa, false), 1);
                return;
            }
            zap zap2 = this.zaa;
            if (zap2.zac.getErrorResolutionIntent(zap2.getActivity(), connectionResult.zzb, null) != null) {
                zap zap3 = this.zaa;
                GoogleApiAvailability googleApiAvailability = zap3.zac;
                Activity activity2 = zap3.getActivity();
                zap zap4 = this.zaa;
                googleApiAvailability.zag(activity2, zap4.mLifecycleFragment, connectionResult.zzb, zap4);
            } else if (connectionResult.zzb == 18) {
                zap zap5 = this.zaa;
                GoogleApiAvailability googleApiAvailability2 = zap5.zac;
                Activity activity3 = zap5.getActivity();
                zap zap6 = this.zaa;
                if (googleApiAvailability2 != null) {
                    ProgressBar progressBar = new ProgressBar(activity3, null, 16842874);
                    progressBar.setIndeterminate(true);
                    progressBar.setVisibility(0);
                    Builder builder = new Builder(activity3);
                    builder.setView(progressBar);
                    builder.setMessage(zac.zad(activity3, 18));
                    builder.setPositiveButton("", null);
                    AlertDialog create = builder.create();
                    googleApiAvailability2.zad(activity3, create, "GooglePlayServicesUpdatingDialog", zap6);
                    zap zap7 = this.zaa;
                    zap7.zac.zac(zap7.getActivity().getApplicationContext(), new zan(this, create));
                    return;
                }
                throw null;
            } else {
                zap zap8 = this.zaa;
                int i = this.zab.zaa;
                zap8.zab.set(null);
                zap8.zab(connectionResult, i);
            }
        }
    }
}
