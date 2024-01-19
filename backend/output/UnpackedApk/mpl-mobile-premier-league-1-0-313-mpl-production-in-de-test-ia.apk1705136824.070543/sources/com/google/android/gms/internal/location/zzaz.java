package com.google.android.gms.internal.location;

import android.app.PendingIntent;
import android.content.Context;
import android.location.Location;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation.ResultHolder;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.api.internal.ListenerHolder.ListenerKey;
import com.google.android.gms.common.api.internal.StatusCallback;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.ArrayUtils;
import com.google.android.gms.location.ActivityTransitionRequest;
import com.google.android.gms.location.GeofencingRequest;
import com.google.android.gms.location.LocationAvailability;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.LocationSettingsResult;
import com.google.android.gms.location.zzbq;
import com.google.android.gms.location.zzu;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-location@@18.0.0 */
public final class zzaz extends zzi {
    public final zzav zzf;

    public zzaz(Context context, Looper looper, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener, String str, ClientSettings clientSettings) {
        super(context, looper, connectionCallbacks, onConnectionFailedListener, str, clientSettings);
        this.zzf = new zzav(context, this.zze);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(6:2|3|(2:5|6)|7|8|9) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0013 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void disconnect() {
        /*
            r2 = this;
            com.google.android.gms.internal.location.zzav r0 = r2.zzf
            monitor-enter(r0)
            boolean r1 = r2.isConnected()     // Catch:{ all -> 0x0018 }
            if (r1 == 0) goto L_0x0013
            com.google.android.gms.internal.location.zzav r1 = r2.zzf     // Catch:{ Exception -> 0x0013 }
            r1.zzn()     // Catch:{ Exception -> 0x0013 }
            com.google.android.gms.internal.location.zzav r1 = r2.zzf     // Catch:{ Exception -> 0x0013 }
            r1.zzo()     // Catch:{ Exception -> 0x0013 }
        L_0x0013:
            super.disconnect()     // Catch:{ all -> 0x0018 }
            monitor-exit(r0)     // Catch:{ all -> 0x0018 }
            return
        L_0x0018:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0018 }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.location.zzaz.disconnect():void");
    }

    public final boolean usesClientTelemetry() {
        return true;
    }

    public final LocationAvailability zzA() throws RemoteException {
        return this.zzf.zzc();
    }

    public final void zzB(zzba zzba, ListenerHolder<LocationCallback> listenerHolder, zzai zzai) throws RemoteException {
        synchronized (this.zzf) {
            this.zzf.zze(zzba, listenerHolder, zzai);
        }
    }

    public final void zzC(LocationRequest locationRequest, ListenerHolder<LocationListener> listenerHolder, zzai zzai) throws RemoteException {
        synchronized (this.zzf) {
            this.zzf.zzd(locationRequest, listenerHolder, zzai);
        }
    }

    public final void zzD(zzba zzba, PendingIntent pendingIntent, zzai zzai) throws RemoteException {
        this.zzf.zzf(zzba, pendingIntent, zzai);
    }

    public final void zzE(LocationRequest locationRequest, PendingIntent pendingIntent, zzai zzai) throws RemoteException {
        this.zzf.zzg(locationRequest, pendingIntent, zzai);
    }

    public final void zzF(ListenerKey<LocationListener> listenerKey, zzai zzai) throws RemoteException {
        this.zzf.zzh(listenerKey, zzai);
    }

    public final void zzG(PendingIntent pendingIntent, zzai zzai) throws RemoteException {
        this.zzf.zzj(pendingIntent, zzai);
    }

    public final void zzH(ListenerKey<LocationCallback> listenerKey, zzai zzai) throws RemoteException {
        this.zzf.zzi(listenerKey, zzai);
    }

    public final void zzI(boolean z) throws RemoteException {
        this.zzf.zzk(z);
    }

    public final void zzJ(Location location) throws RemoteException {
        this.zzf.zzl(location);
    }

    public final void zzK(zzai zzai) throws RemoteException {
        this.zzf.zzm(zzai);
    }

    public final void zzL(LocationSettingsRequest locationSettingsRequest, ResultHolder<LocationSettingsResult> resultHolder, String str) throws RemoteException {
        checkConnected();
        boolean z = true;
        Preconditions.checkArgument(locationSettingsRequest != null, "locationSettingsRequest can't be null nor empty.");
        if (resultHolder == null) {
            z = false;
        }
        Preconditions.checkArgument(z, "listener can't be null.");
        ((zzam) getService()).zzt(locationSettingsRequest, new zzay(resultHolder), null);
    }

    public final void zzq(long j, PendingIntent pendingIntent) throws RemoteException {
        checkConnected();
        Preconditions.checkNotNull(pendingIntent);
        Preconditions.checkArgument(j >= 0, "detectionIntervalMillis must be >= 0");
        ((zzam) getService()).zzh(j, true, pendingIntent);
    }

    public final void zzr(ActivityTransitionRequest activityTransitionRequest, PendingIntent pendingIntent, ResultHolder<Status> resultHolder) throws RemoteException {
        checkConnected();
        Preconditions.checkNotNull(activityTransitionRequest, "activityTransitionRequest must be specified.");
        Preconditions.checkNotNull(pendingIntent, "PendingIntent must be specified.");
        Preconditions.checkNotNull(resultHolder, "ResultHolder not provided.");
        ((zzam) getService()).zzi(activityTransitionRequest, pendingIntent, new StatusCallback(resultHolder));
    }

    public final void zzs(PendingIntent pendingIntent, ResultHolder<Status> resultHolder) throws RemoteException {
        checkConnected();
        Preconditions.checkNotNull(resultHolder, "ResultHolder not provided.");
        ((zzam) getService()).zzj(pendingIntent, new StatusCallback(resultHolder));
    }

    public final void zzt(PendingIntent pendingIntent) throws RemoteException {
        checkConnected();
        Preconditions.checkNotNull(pendingIntent);
        ((zzam) getService()).zzk(pendingIntent);
    }

    public final void zzu(PendingIntent pendingIntent, ResultHolder<Status> resultHolder) throws RemoteException {
        checkConnected();
        Preconditions.checkNotNull(pendingIntent, "PendingIntent must be specified.");
        Preconditions.checkNotNull(resultHolder, "ResultHolder not provided.");
        ((zzam) getService()).zzl(pendingIntent, new StatusCallback(resultHolder));
    }

    public final void zzv(GeofencingRequest geofencingRequest, PendingIntent pendingIntent, ResultHolder<Status> resultHolder) throws RemoteException {
        checkConnected();
        Preconditions.checkNotNull(geofencingRequest, "geofencingRequest can't be null.");
        Preconditions.checkNotNull(pendingIntent, "PendingIntent must be specified.");
        Preconditions.checkNotNull(resultHolder, "ResultHolder not provided.");
        ((zzam) getService()).zzd(geofencingRequest, pendingIntent, new zzaw(resultHolder));
    }

    public final void zzw(zzbq zzbq, ResultHolder<Status> resultHolder) throws RemoteException {
        checkConnected();
        Preconditions.checkNotNull(zzbq, "removeGeofencingRequest can't be null.");
        Preconditions.checkNotNull(resultHolder, "ResultHolder not provided.");
        ((zzam) getService()).zzg(zzbq, new zzax(resultHolder));
    }

    public final void zzx(PendingIntent pendingIntent, ResultHolder<Status> resultHolder) throws RemoteException {
        checkConnected();
        Preconditions.checkNotNull(pendingIntent, "PendingIntent must be specified.");
        Preconditions.checkNotNull(resultHolder, "ResultHolder not provided.");
        ((zzam) getService()).zze(pendingIntent, new zzax(resultHolder), getContext().getPackageName());
    }

    public final void zzy(List<String> list, ResultHolder<Status> resultHolder) throws RemoteException {
        checkConnected();
        Preconditions.checkArgument(list != null && list.size() > 0, "geofenceRequestIds can't be null nor empty.");
        Preconditions.checkNotNull(resultHolder, "ResultHolder not provided.");
        ((zzam) getService()).zzf((String[]) list.toArray(new String[0]), new zzax(resultHolder), getContext().getPackageName());
    }

    public final Location zzz(String str) throws RemoteException {
        if (ArrayUtils.contains((T[]) getAvailableFeatures(), zzu.zzc)) {
            return this.zzf.zza(str);
        }
        return this.zzf.zzb();
    }
}
