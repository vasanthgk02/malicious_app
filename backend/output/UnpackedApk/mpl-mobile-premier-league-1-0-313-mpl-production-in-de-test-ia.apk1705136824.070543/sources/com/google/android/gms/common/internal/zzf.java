package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.common.ConnectionResult;

/* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
public final class zzf extends zza {
    public final IBinder zze;
    public final /* synthetic */ BaseGmsClient zzf;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public zzf(BaseGmsClient baseGmsClient, int i, IBinder iBinder, Bundle bundle) {
        // this.zzf = baseGmsClient;
        super(baseGmsClient, i, bundle);
        this.zze = iBinder;
    }

    public final void zzb(ConnectionResult connectionResult) {
        if (this.zzf.zzx != null) {
            this.zzf.zzx.onConnectionFailed(connectionResult);
        }
        this.zzf.onConnectionFailed(connectionResult);
    }

    public final boolean zzd() {
        boolean z = false;
        try {
            IBinder iBinder = this.zze;
            Preconditions.checkNotNull(iBinder);
            if (!this.zzf.getServiceDescriptor().equals(iBinder.getInterfaceDescriptor())) {
                this.zzf.getServiceDescriptor();
                return false;
            }
            IInterface createServiceInterface = this.zzf.createServiceInterface(this.zze);
            if (createServiceInterface != null && (BaseGmsClient.zzn(this.zzf, 2, 4, createServiceInterface) || BaseGmsClient.zzn(this.zzf, 3, 4, createServiceInterface))) {
                this.zzf.zzB = null;
                Bundle connectionHint = this.zzf.getConnectionHint();
                BaseGmsClient baseGmsClient = this.zzf;
                if (baseGmsClient.zzw != null) {
                    baseGmsClient.zzw.onConnected(connectionHint);
                }
                z = true;
            }
            return z;
        } catch (RemoteException unused) {
        }
    }
}
