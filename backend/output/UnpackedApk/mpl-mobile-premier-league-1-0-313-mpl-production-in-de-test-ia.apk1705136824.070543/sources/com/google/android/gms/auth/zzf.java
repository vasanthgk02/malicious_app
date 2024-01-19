package com.google.android.gms.auth;

import android.os.Bundle;
import android.os.IBinder;
import com.google.android.gms.internal.auth.zze;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-auth-base@@17.1.4 */
public final /* synthetic */ class zzf implements zzk {
    public final Object zza(IBinder iBinder) {
        Bundle zzf = zze.zzb(iBinder).zzf(null);
        if (zzf != null) {
            return zzf;
        }
        throw new IOException("Service call returned null.");
    }
}
