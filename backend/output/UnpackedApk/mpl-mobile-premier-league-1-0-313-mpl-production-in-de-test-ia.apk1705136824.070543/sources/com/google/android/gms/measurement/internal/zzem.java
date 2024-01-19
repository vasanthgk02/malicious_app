package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzbm;
import com.google.android.gms.internal.measurement.zzbo;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@20.1.2 */
public final class zzem extends zzbm implements zzeo {
    public zzem(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.measurement.internal.IMeasurementService");
    }

    public final String zzd(zzp zzp) throws RemoteException {
        Parcel zza = zza();
        zzbo.zze(zza, zzp);
        Parcel zzb = zzb(11, zza);
        String readString = zzb.readString();
        zzb.recycle();
        return readString;
    }

    public final List zze(zzp zzp, boolean z) throws RemoteException {
        Parcel zza = zza();
        zzbo.zze(zza, zzp);
        zzbo.zzd(zza, z);
        Parcel zzb = zzb(7, zza);
        ArrayList<zzll> createTypedArrayList = zzb.createTypedArrayList(zzll.CREATOR);
        zzb.recycle();
        return createTypedArrayList;
    }

    public final List zzf(String str, String str2, zzp zzp) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zza.writeString(str2);
        zzbo.zze(zza, zzp);
        Parcel zzb = zzb(16, zza);
        ArrayList<zzab> createTypedArrayList = zzb.createTypedArrayList(zzab.CREATOR);
        zzb.recycle();
        return createTypedArrayList;
    }

    public final List zzg(String str, String str2, String str3) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(null);
        zza.writeString(str2);
        zza.writeString(str3);
        Parcel zzb = zzb(17, zza);
        ArrayList<zzab> createTypedArrayList = zzb.createTypedArrayList(zzab.CREATOR);
        zzb.recycle();
        return createTypedArrayList;
    }

    public final List zzh(String str, String str2, boolean z, zzp zzp) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zza.writeString(str2);
        zzbo.zzd(zza, z);
        zzbo.zze(zza, zzp);
        Parcel zzb = zzb(14, zza);
        ArrayList<zzll> createTypedArrayList = zzb.createTypedArrayList(zzll.CREATOR);
        zzb.recycle();
        return createTypedArrayList;
    }

    public final List zzi(String str, String str2, String str3, boolean z) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(null);
        zza.writeString(str2);
        zza.writeString(str3);
        zzbo.zzd(zza, z);
        Parcel zzb = zzb(15, zza);
        ArrayList<zzll> createTypedArrayList = zzb.createTypedArrayList(zzll.CREATOR);
        zzb.recycle();
        return createTypedArrayList;
    }

    public final void zzj(zzp zzp) throws RemoteException {
        Parcel zza = zza();
        zzbo.zze(zza, zzp);
        zzc(4, zza);
    }

    public final void zzk(zzav zzav, zzp zzp) throws RemoteException {
        Parcel zza = zza();
        zzbo.zze(zza, zzav);
        zzbo.zze(zza, zzp);
        zzc(1, zza);
    }

    public final void zzl(zzav zzav, String str, String str2) throws RemoteException {
        throw null;
    }

    public final void zzm(zzp zzp) throws RemoteException {
        Parcel zza = zza();
        zzbo.zze(zza, zzp);
        zzc(18, zza);
    }

    public final void zzn(zzab zzab, zzp zzp) throws RemoteException {
        Parcel zza = zza();
        zzbo.zze(zza, zzab);
        zzbo.zze(zza, zzp);
        zzc(12, zza);
    }

    public final void zzo(zzab zzab) throws RemoteException {
        throw null;
    }

    public final void zzp(zzp zzp) throws RemoteException {
        Parcel zza = zza();
        zzbo.zze(zza, zzp);
        zzc(20, zza);
    }

    public final void zzq(long j, String str, String str2, String str3) throws RemoteException {
        Parcel zza = zza();
        zza.writeLong(j);
        zza.writeString(str);
        zza.writeString(str2);
        zza.writeString(str3);
        zzc(10, zza);
    }

    public final void zzr(Bundle bundle, zzp zzp) throws RemoteException {
        Parcel zza = zza();
        zzbo.zze(zza, bundle);
        zzbo.zze(zza, zzp);
        zzc(19, zza);
    }

    public final void zzs(zzp zzp) throws RemoteException {
        Parcel zza = zza();
        zzbo.zze(zza, zzp);
        zzc(6, zza);
    }

    public final void zzt(zzll zzll, zzp zzp) throws RemoteException {
        Parcel zza = zza();
        zzbo.zze(zza, zzll);
        zzbo.zze(zza, zzp);
        zzc(2, zza);
    }

    public final byte[] zzu(zzav zzav, String str) throws RemoteException {
        Parcel zza = zza();
        zzbo.zze(zza, zzav);
        zza.writeString(str);
        Parcel zzb = zzb(9, zza);
        byte[] createByteArray = zzb.createByteArray();
        zzb.recycle();
        return createByteArray;
    }
}
