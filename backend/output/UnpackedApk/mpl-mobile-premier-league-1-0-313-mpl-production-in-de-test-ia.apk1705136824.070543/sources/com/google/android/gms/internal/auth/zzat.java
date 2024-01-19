package com.google.android.gms.internal.auth;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.auth.api.accounttransfer.DeviceMetaData;
import com.google.android.gms.auth.api.accounttransfer.zzn;
import com.google.android.gms.auth.api.accounttransfer.zzv;
import com.google.android.gms.common.api.Status;

/* compiled from: com.google.android.gms:play-services-auth-base@@17.1.4 */
public interface zzat extends IInterface {
    void zzb(byte[] bArr) throws RemoteException;

    void zzc(DeviceMetaData deviceMetaData) throws RemoteException;

    void zzd(Status status) throws RemoteException;

    void zze() throws RemoteException;

    void zzf(Status status, zzv zzv) throws RemoteException;

    void zzg(Status status, zzn zzn) throws RemoteException;

    void zzh(Status status) throws RemoteException;
}
