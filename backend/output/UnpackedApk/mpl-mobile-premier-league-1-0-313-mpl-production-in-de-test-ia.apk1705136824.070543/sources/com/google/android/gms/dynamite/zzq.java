package com.google.android.gms.dynamite;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.IObjectWrapper.Stub;
import com.google.android.gms.internal.common.zza;
import com.google.android.gms.internal.common.zzc;

/* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
public final class zzq extends zza implements IInterface {
    public zzq(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.dynamite.IDynamiteLoader");
    }

    public final IObjectWrapper zzh(IObjectWrapper iObjectWrapper, String str, int i) throws RemoteException {
        Parcel zza = zza();
        zzc.zzf(zza, iObjectWrapper);
        zza.writeString(str);
        zza.writeInt(i);
        Parcel zzB = zzB(2, zza);
        IObjectWrapper asInterface = Stub.asInterface(zzB.readStrongBinder());
        zzB.recycle();
        return asInterface;
    }

    public final IObjectWrapper zzi(IObjectWrapper iObjectWrapper, String str, int i, IObjectWrapper iObjectWrapper2) throws RemoteException {
        Parcel zza = zza();
        zzc.zzf(zza, iObjectWrapper);
        zza.writeString(str);
        zza.writeInt(i);
        zzc.zzf(zza, iObjectWrapper2);
        Parcel zzB = zzB(8, zza);
        IObjectWrapper asInterface = Stub.asInterface(zzB.readStrongBinder());
        zzB.recycle();
        return asInterface;
    }

    public final IObjectWrapper zzj(IObjectWrapper iObjectWrapper, String str, int i) throws RemoteException {
        Parcel zza = zza();
        zzc.zzf(zza, iObjectWrapper);
        zza.writeString(str);
        zza.writeInt(i);
        Parcel zzB = zzB(4, zza);
        IObjectWrapper asInterface = Stub.asInterface(zzB.readStrongBinder());
        zzB.recycle();
        return asInterface;
    }

    public final IObjectWrapper zzk(IObjectWrapper iObjectWrapper, String str, boolean z, long j) throws RemoteException {
        Parcel zza = zza();
        zzc.zzf(zza, iObjectWrapper);
        zza.writeString(str);
        zzc.zzc(zza, z);
        zza.writeLong(j);
        Parcel zzB = zzB(7, zza);
        IObjectWrapper asInterface = Stub.asInterface(zzB.readStrongBinder());
        zzB.recycle();
        return asInterface;
    }
}