package com.google.android.gms.measurement.internal;

import android.content.ComponentName;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@20.1.2 */
public final class zzjw implements Runnable {
    public final /* synthetic */ ComponentName zza;
    public final /* synthetic */ zzka zzb;

    public zzjw(zzka zzka, ComponentName componentName) {
        this.zzb = zzka;
        this.zza = componentName;
    }

    public final void run() {
        zzkb.zzo(this.zzb.zza, this.zza);
    }
}
