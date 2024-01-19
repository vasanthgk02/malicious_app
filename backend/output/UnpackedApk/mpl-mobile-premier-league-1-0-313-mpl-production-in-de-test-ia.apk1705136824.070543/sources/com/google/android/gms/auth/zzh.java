package com.google.android.gms.auth;

import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.internal.auth.zze;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-auth-base@@17.1.4 */
public final class zzh implements zzk<Void> {
    public final /* synthetic */ String zza;
    public final /* synthetic */ Bundle zzb;

    public zzh(String str, Bundle bundle) {
        this.zza = str;
        this.zzb = bundle;
    }

    public final /* synthetic */ Object zza(IBinder iBinder) throws RemoteException, IOException, GoogleAuthException {
        Bundle zzd = zze.zzb(iBinder).zzd(this.zza, this.zzb);
        zzl.zzi(zzd);
        String string = zzd.getString("Error");
        if (zzd.getBoolean("booleanResult")) {
            return null;
        }
        throw new GoogleAuthException(string);
    }
}
