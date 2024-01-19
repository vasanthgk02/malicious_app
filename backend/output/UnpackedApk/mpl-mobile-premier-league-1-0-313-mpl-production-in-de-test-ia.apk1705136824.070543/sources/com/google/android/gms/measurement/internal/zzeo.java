package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.IInterface;
import android.os.RemoteException;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@20.1.2 */
public interface zzeo extends IInterface {
    String zzd(zzp zzp) throws RemoteException;

    List zze(zzp zzp, boolean z) throws RemoteException;

    List zzf(String str, String str2, zzp zzp) throws RemoteException;

    List zzg(String str, String str2, String str3) throws RemoteException;

    List zzh(String str, String str2, boolean z, zzp zzp) throws RemoteException;

    List zzi(String str, String str2, String str3, boolean z) throws RemoteException;

    void zzj(zzp zzp) throws RemoteException;

    void zzk(zzav zzav, zzp zzp) throws RemoteException;

    void zzl(zzav zzav, String str, String str2) throws RemoteException;

    void zzm(zzp zzp) throws RemoteException;

    void zzn(zzab zzab, zzp zzp) throws RemoteException;

    void zzo(zzab zzab) throws RemoteException;

    void zzp(zzp zzp) throws RemoteException;

    void zzq(long j, String str, String str2, String str3) throws RemoteException;

    void zzr(Bundle bundle, zzp zzp) throws RemoteException;

    void zzs(zzp zzp) throws RemoteException;

    void zzt(zzll zzll, zzp zzp) throws RemoteException;

    byte[] zzu(zzav zzav, String str) throws RemoteException;
}
