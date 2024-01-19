package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.common.zzb;
import com.google.android.gms.internal.common.zzc;

/* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
public abstract class zzab extends zzb implements IGmsCallbacks {
    public zzab() {
        super("com.google.android.gms.common.internal.IGmsCallbacks");
    }

    public final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i == 1) {
            zzc.zzb(parcel);
            onPostInitComplete(parcel.readInt(), parcel.readStrongBinder(), (Bundle) zzc.zza(parcel, Bundle.CREATOR));
        } else if (i == 2) {
            zzc.zzb(parcel);
            zzb(parcel.readInt(), (Bundle) zzc.zza(parcel, Bundle.CREATOR));
        } else if (i != 3) {
            return false;
        } else {
            zzc.zzb(parcel);
            zzc(parcel.readInt(), parcel.readStrongBinder(), (zzj) zzc.zza(parcel, zzj.CREATOR));
        }
        parcel2.writeNoException();
        return true;
    }
}
