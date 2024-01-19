package com.google.android.gms.location;

import android.content.Context;
import android.location.Location;
import android.os.Looper;
import android.os.SystemClock;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Api.ApiOptions;
import com.google.android.gms.common.api.Api.ApiOptions.NoOptions;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.internal.ApiExceptionMapper;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.api.internal.ListenerHolder.ListenerKey;
import com.google.android.gms.common.api.internal.ListenerHolders;
import com.google.android.gms.common.api.internal.RegistrationMethods;
import com.google.android.gms.common.api.internal.StatusExceptionMapper;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.common.api.internal.TaskApiCall.Builder;
import com.google.android.gms.common.api.internal.zack;
import com.google.android.gms.common.api.internal.zacl;
import com.google.android.gms.common.api.internal.zacx;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.location.zzba;
import com.google.android.gms.internal.location.zzbj;
import com.google.android.gms.tasks.CancellationToken;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import org.eclipse.paho.client.mqttv3.MqttAsyncClient;

/* compiled from: com.google.android.gms:play-services-location@@18.0.0 */
public class FusedLocationProviderClient extends GoogleApi<NoOptions> {
    public FusedLocationProviderClient(Context context) {
        super(context, LocationServices.API, ApiOptions.NO_OPTIONS, (StatusExceptionMapper) new ApiExceptionMapper());
    }

    public Task<Void> flushLocations() {
        Builder builder = TaskApiCall.builder();
        builder.zaa = zzw.zza;
        builder.zad = 2422;
        return doWrite(builder.build());
    }

    public Task<Location> getCurrentLocation(int i, CancellationToken cancellationToken) {
        LocationRequest create = LocationRequest.create();
        create.setPriority(i);
        create.setInterval(0);
        create.setFastestInterval(0);
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long j = Long.MAX_VALUE;
        if (30000 <= Long.MAX_VALUE - elapsedRealtime) {
            j = elapsedRealtime + 30000;
        }
        create.zze = j;
        if (j < 0) {
            create.zze = 0;
        }
        zzba zza = zzba.zza(null, create);
        zza.zzd(true);
        zza.zzb(MqttAsyncClient.DISCONNECT_TIMEOUT);
        zzab zzab = new zzab(this, cancellationToken, zza);
        Builder builder = TaskApiCall.builder();
        builder.zaa = zzab;
        builder.zac = new Feature[]{zzu.zzd};
        builder.zad = 2415;
        Task<Location> doRead = doRead(builder.build());
        if (cancellationToken == null) {
            return doRead;
        }
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource(cancellationToken);
        doRead.continueWithTask(new zzac(taskCompletionSource));
        return taskCompletionSource.zza;
    }

    public Task<Location> getLastLocation() {
        Builder builder = TaskApiCall.builder();
        builder.zaa = new zzv(this);
        builder.zad = 2414;
        return doRead(builder.build());
    }

    public Task<Void> removeLocationUpdates(LocationCallback locationCallback) {
        return doUnregisterEventListener(ListenerHolders.createListenerKey(locationCallback, LocationCallback.class.getSimpleName())).continueWith(new zacx());
    }

    public Task<Void> requestLocationUpdates(LocationRequest locationRequest, LocationCallback locationCallback, Looper looper) {
        return zze(zzba.zza(null, locationRequest), locationCallback, looper, null, 2436);
    }

    public final Task<Void> zze(zzba zzba, LocationCallback locationCallback, Looper looper, zzan zzan, int i) {
        ListenerHolder createListenerHolder = ListenerHolders.createListenerHolder(locationCallback, zzbj.zza(looper), LocationCallback.class.getSimpleName());
        zzak zzak = new zzak(this, createListenerHolder);
        zzae zzae = new zzae(this, zzak, locationCallback, zzan, zzba, createListenerHolder);
        RegistrationMethods.Builder builder = new RegistrationMethods.Builder(null);
        builder.zaa = zzae;
        builder.zab = zzak;
        builder.zad = createListenerHolder;
        builder.zag = i;
        boolean z = true;
        Preconditions.checkArgument(true, "Must set register function");
        Preconditions.checkArgument(builder.zab != null, "Must set unregister function");
        if (builder.zad == null) {
            z = false;
        }
        Preconditions.checkArgument(z, "Must set holder");
        ListenerKey listenerKey = builder.zad.zac;
        Preconditions.checkNotNull(listenerKey, "Key must not be null");
        zack zack = new zack(builder, builder.zad, null, builder.zaf, builder.zag);
        return doRegisterEventListener(new RegistrationMethods(zack, new zacl(builder, listenerKey), builder.zac));
    }
}
