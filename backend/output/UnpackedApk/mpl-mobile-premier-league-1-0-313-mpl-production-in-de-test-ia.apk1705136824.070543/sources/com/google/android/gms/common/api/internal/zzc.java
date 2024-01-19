package com.google.android.gms.common.api.internal;

import android.os.Bundle;

/* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
public final class zzc implements Runnable {
    public final /* synthetic */ LifecycleCallback zza;
    public final /* synthetic */ String zzb;
    public final /* synthetic */ zzd zzc;

    public zzc(zzd zzd, LifecycleCallback lifecycleCallback, String str) {
        this.zzc = zzd;
        this.zza = lifecycleCallback;
        this.zzb = str;
    }

    public final void run() {
        zzd zzd = this.zzc;
        if (zzd.zzc > 0) {
            LifecycleCallback lifecycleCallback = this.zza;
            Bundle bundle = zzd.zzd;
            lifecycleCallback.onCreate(bundle != null ? bundle.getBundle(this.zzb) : null);
        }
        if (this.zzc.zzc >= 2) {
            this.zza.onStart();
        }
        if (this.zzc.zzc >= 3) {
            this.zza.onResume();
        }
        if (this.zzc.zzc >= 4) {
            this.zza.onStop();
        }
        if (this.zzc.zzc >= 5) {
            this.zza.onDestroy();
        }
    }
}
