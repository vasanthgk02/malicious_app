package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.DeadObjectException;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks;
import com.google.android.gms.common.internal.BaseGmsClient.BaseOnConnectionFailedListener;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;

@VisibleForTesting
/* compiled from: com.google.android.gms:play-services-measurement-impl@@20.1.2 */
public final class zzka implements ServiceConnection, BaseConnectionCallbacks, BaseOnConnectionFailedListener {
    public final /* synthetic */ zzkb zza;
    public volatile boolean zzb;
    public volatile zzeu zzc;

    public zzka(zzkb zzkb) {
        this.zza = zzkb;
    }

    public final void onConnected(Bundle bundle) {
        Preconditions.checkMainThread("MeasurementServiceConnection.onConnected");
        synchronized (this) {
            try {
                Preconditions.checkNotNull(this.zzc);
                this.zza.zzs.zzaA().zzp(new zzjx(this, (zzeo) this.zzc.getService()));
            } catch (DeadObjectException | IllegalStateException unused) {
                this.zzc = null;
                this.zzb = false;
            }
        }
    }

    public final void onConnectionFailed(ConnectionResult connectionResult) {
        Preconditions.checkMainThread("MeasurementServiceConnection.onConnectionFailed");
        zzey zzey = this.zza.zzs.zzm;
        if (zzey == null || !zzey.zzx()) {
            zzey = null;
        }
        if (zzey != null) {
            zzey.zzg.zzb("Service connection failed", connectionResult);
        }
        synchronized (this) {
            this.zzb = false;
            this.zzc = null;
        }
        this.zza.zzs.zzaA().zzp(new zzjz(this));
    }

    public final void onConnectionSuspended(int i) {
        Preconditions.checkMainThread("MeasurementServiceConnection.onConnectionSuspended");
        this.zza.zzs.zzaz().zzk.zza("Service connection suspended");
        this.zza.zzs.zzaA().zzp(new zzjy(this));
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(2:20|21) */
    /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
        r3.zza.zzs.zzaz().zzd.zza("Service connect failed to get IMeasurementService");
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:20:0x0060 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onServiceConnected(android.content.ComponentName r4, android.os.IBinder r5) {
        /*
            r3 = this;
            java.lang.String r4 = "MeasurementServiceConnection.onServiceConnected"
            com.google.android.gms.common.internal.Preconditions.checkMainThread(r4)
            monitor-enter(r3)
            r4 = 0
            if (r5 != 0) goto L_0x001f
            r3.zzb = r4     // Catch:{ all -> 0x001c }
            com.google.android.gms.measurement.internal.zzkb r4 = r3.zza     // Catch:{ all -> 0x001c }
            com.google.android.gms.measurement.internal.zzgi r4 = r4.zzs     // Catch:{ all -> 0x001c }
            com.google.android.gms.measurement.internal.zzey r4 = r4.zzaz()     // Catch:{ all -> 0x001c }
            com.google.android.gms.measurement.internal.zzew r4 = r4.zzd     // Catch:{ all -> 0x001c }
            java.lang.String r5 = "Service connected with null binder"
            r4.zza(r5)     // Catch:{ all -> 0x001c }
            monitor-exit(r3)     // Catch:{ all -> 0x001c }
            return
        L_0x001c:
            r4 = move-exception
            goto L_0x0097
        L_0x001f:
            r0 = 0
            java.lang.String r1 = r5.getInterfaceDescriptor()     // Catch:{ RemoteException -> 0x0060 }
            java.lang.String r2 = "com.google.android.gms.measurement.internal.IMeasurementService"
            boolean r2 = r2.equals(r1)     // Catch:{ RemoteException -> 0x0060 }
            if (r2 == 0) goto L_0x0050
            java.lang.String r1 = "com.google.android.gms.measurement.internal.IMeasurementService"
            android.os.IInterface r1 = r5.queryLocalInterface(r1)     // Catch:{ RemoteException -> 0x0060 }
            boolean r2 = r1 instanceof com.google.android.gms.measurement.internal.zzeo     // Catch:{ RemoteException -> 0x0060 }
            if (r2 == 0) goto L_0x003a
            com.google.android.gms.measurement.internal.zzeo r1 = (com.google.android.gms.measurement.internal.zzeo) r1     // Catch:{ RemoteException -> 0x0060 }
        L_0x0038:
            r0 = r1
            goto L_0x0040
        L_0x003a:
            com.google.android.gms.measurement.internal.zzem r1 = new com.google.android.gms.measurement.internal.zzem     // Catch:{ RemoteException -> 0x0060 }
            r1.<init>(r5)     // Catch:{ RemoteException -> 0x0060 }
            goto L_0x0038
        L_0x0040:
            com.google.android.gms.measurement.internal.zzkb r5 = r3.zza     // Catch:{ RemoteException -> 0x0060 }
            com.google.android.gms.measurement.internal.zzgi r5 = r5.zzs     // Catch:{ RemoteException -> 0x0060 }
            com.google.android.gms.measurement.internal.zzey r5 = r5.zzaz()     // Catch:{ RemoteException -> 0x0060 }
            com.google.android.gms.measurement.internal.zzew r5 = r5.zzl     // Catch:{ RemoteException -> 0x0060 }
            java.lang.String r1 = "Bound to IMeasurementService interface"
            r5.zza(r1)     // Catch:{ RemoteException -> 0x0060 }
            goto L_0x006f
        L_0x0050:
            com.google.android.gms.measurement.internal.zzkb r5 = r3.zza     // Catch:{ RemoteException -> 0x0060 }
            com.google.android.gms.measurement.internal.zzgi r5 = r5.zzs     // Catch:{ RemoteException -> 0x0060 }
            com.google.android.gms.measurement.internal.zzey r5 = r5.zzaz()     // Catch:{ RemoteException -> 0x0060 }
            com.google.android.gms.measurement.internal.zzew r5 = r5.zzd     // Catch:{ RemoteException -> 0x0060 }
            java.lang.String r2 = "Got binder with a wrong descriptor"
            r5.zzb(r2, r1)     // Catch:{ RemoteException -> 0x0060 }
            goto L_0x006f
        L_0x0060:
            com.google.android.gms.measurement.internal.zzkb r5 = r3.zza     // Catch:{ all -> 0x001c }
            com.google.android.gms.measurement.internal.zzgi r5 = r5.zzs     // Catch:{ all -> 0x001c }
            com.google.android.gms.measurement.internal.zzey r5 = r5.zzaz()     // Catch:{ all -> 0x001c }
            com.google.android.gms.measurement.internal.zzew r5 = r5.zzd     // Catch:{ all -> 0x001c }
            java.lang.String r1 = "Service connect failed to get IMeasurementService"
            r5.zza(r1)     // Catch:{ all -> 0x001c }
        L_0x006f:
            if (r0 != 0) goto L_0x0085
            r3.zzb = r4     // Catch:{ all -> 0x001c }
            com.google.android.gms.common.stats.ConnectionTracker r4 = com.google.android.gms.common.stats.ConnectionTracker.getInstance()     // Catch:{ IllegalArgumentException -> 0x0095 }
            com.google.android.gms.measurement.internal.zzkb r5 = r3.zza     // Catch:{ IllegalArgumentException -> 0x0095 }
            com.google.android.gms.measurement.internal.zzgi r5 = r5.zzs     // Catch:{ IllegalArgumentException -> 0x0095 }
            android.content.Context r5 = r5.zze     // Catch:{ IllegalArgumentException -> 0x0095 }
            com.google.android.gms.measurement.internal.zzkb r0 = r3.zza     // Catch:{ IllegalArgumentException -> 0x0095 }
            com.google.android.gms.measurement.internal.zzka r0 = r0.zza     // Catch:{ IllegalArgumentException -> 0x0095 }
            r4.unbindService(r5, r0)     // Catch:{ IllegalArgumentException -> 0x0095 }
            goto L_0x0095
        L_0x0085:
            com.google.android.gms.measurement.internal.zzkb r4 = r3.zza     // Catch:{ all -> 0x001c }
            com.google.android.gms.measurement.internal.zzgi r4 = r4.zzs     // Catch:{ all -> 0x001c }
            com.google.android.gms.measurement.internal.zzgf r4 = r4.zzaA()     // Catch:{ all -> 0x001c }
            com.google.android.gms.measurement.internal.zzjv r5 = new com.google.android.gms.measurement.internal.zzjv     // Catch:{ all -> 0x001c }
            r5.<init>(r3, r0)     // Catch:{ all -> 0x001c }
            r4.zzp(r5)     // Catch:{ all -> 0x001c }
        L_0x0095:
            monitor-exit(r3)     // Catch:{ all -> 0x001c }
            return
        L_0x0097:
            monitor-exit(r3)     // Catch:{ all -> 0x001c }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzka.onServiceConnected(android.content.ComponentName, android.os.IBinder):void");
    }

    public final void onServiceDisconnected(ComponentName componentName) {
        Preconditions.checkMainThread("MeasurementServiceConnection.onServiceDisconnected");
        this.zza.zzs.zzaz().zzk.zza("Service disconnected");
        this.zza.zzs.zzaA().zzp(new zzjw(this, componentName));
    }
}
