package com.google.android.gms.internal.auth;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.auth.api.accounttransfer.DeviceMetaData;
import com.google.android.gms.auth.api.accounttransfer.zzn;
import com.google.android.gms.auth.api.accounttransfer.zzv;
import com.google.android.gms.common.api.Status;

/* compiled from: com.google.android.gms:play-services-auth-base@@17.1.4 */
public abstract class zzas extends zzb implements zzat {
    public zzas() {
        super("com.google.android.gms.auth.api.accounttransfer.internal.IAccountTransferCallbacks");
    }

    public final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        switch (i) {
            case 1:
                zzh((Status) zzc.zza(parcel, Status.CREATOR));
                break;
            case 2:
                zzf((Status) zzc.zza(parcel, Status.CREATOR), (zzv) zzc.zza(parcel, zzv.CREATOR));
                break;
            case 3:
                zzg((Status) zzc.zza(parcel, Status.CREATOR), (zzn) zzc.zza(parcel, zzn.CREATOR));
                break;
            case 4:
                zze();
                break;
            case 5:
                zzd((Status) zzc.zza(parcel, Status.CREATOR));
                break;
            case 6:
                zzb(parcel.createByteArray());
                break;
            case 7:
                zzc((DeviceMetaData) zzc.zza(parcel, DeviceMetaData.CREATOR));
                break;
            default:
                return false;
        }
        return true;
    }
}
