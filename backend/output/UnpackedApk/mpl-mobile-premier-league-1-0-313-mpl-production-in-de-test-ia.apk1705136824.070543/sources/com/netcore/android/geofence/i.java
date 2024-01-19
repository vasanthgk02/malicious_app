package com.netcore.android.geofence;

import android.annotation.SuppressLint;
import android.content.Context;
import android.location.Location;
import android.os.Looper;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskExecutors;
import com.google.android.gms.tasks.zzw;
import com.google.firebase.perf.config.RemoteConfigManager;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.eclipse.paho.client.mqttv3.MqttAsyncClient;

/* compiled from: SMTLocationManager.kt */
public final class i {

    /* renamed from: a  reason: collision with root package name */
    public Context f1155a;

    /* renamed from: b  reason: collision with root package name */
    public float f1156b = 500.0f;

    /* renamed from: c  reason: collision with root package name */
    public long f1157c = 60000;

    /* renamed from: d  reason: collision with root package name */
    public long f1158d = 30000;

    /* renamed from: e  reason: collision with root package name */
    public long f1159e = (((long) 5) * 60000);

    /* renamed from: f  reason: collision with root package name */
    public LocationRequest f1160f;
    public FusedLocationProviderClient g;
    public com.netcore.android.f.b h;
    public final LocationCallback i;

    /* compiled from: SMTLocationManager.kt */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public float f1161a;

        /* renamed from: b  reason: collision with root package name */
        public long f1162b = RemoteConfigManager.MIN_APP_START_CONFIG_FETCH_DELAY_MS;

        /* renamed from: c  reason: collision with root package name */
        public long f1163c = MqttAsyncClient.DISCONNECT_TIMEOUT;

        /* renamed from: d  reason: collision with root package name */
        public com.netcore.android.f.b f1164d;

        /* renamed from: e  reason: collision with root package name */
        public final Context f1165e;

        public a(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            this.f1165e = context;
        }

        public final a a(com.netcore.android.f.b bVar) {
            Intrinsics.checkNotNullParameter(bVar, "listner");
            this.f1164d = bVar;
            return this;
        }

        public final Context b() {
            return this.f1165e;
        }

        public final long c() {
            return this.f1163c;
        }

        public final com.netcore.android.f.b d() {
            return this.f1164d;
        }

        public final float e() {
            return this.f1161a;
        }

        public final long f() {
            return this.f1162b;
        }

        public final i a() {
            return new i(this);
        }
    }

    /* compiled from: SMTLocationManager.kt */
    public static final class b<TResult> implements OnSuccessListener<Location> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ i f1166a;

        public b(i iVar) {
            this.f1166a = iVar;
        }

        /* renamed from: a */
        public final void onSuccess(Location location) {
            Unit unit;
            if (location != null) {
                com.netcore.android.f.b a2 = this.f1166a.h;
                if (a2 != null) {
                    a2.onLocationFetchSuccess(location);
                    unit = Unit.INSTANCE;
                } else {
                    unit = null;
                }
                if (unit != null) {
                    return;
                }
            }
            this.f1166a.c();
        }
    }

    /* compiled from: SMTLocationManager.kt */
    public static final class c implements OnFailureListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ i f1167a;

        public c(i iVar) {
            this.f1167a = iVar;
        }

        public final void onFailure(Exception exc) {
            Intrinsics.checkNotNullParameter(exc, "it");
            com.netcore.android.f.b a2 = this.f1167a.h;
            if (a2 != null) {
                a2.onLocationFetchFailed(exc);
            }
        }
    }

    /* compiled from: SMTLocationManager.kt */
    public static final class d extends LocationCallback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ i f1168a;

        public d(i iVar) {
            this.f1168a = iVar;
        }

        public void onLocationResult(LocationResult locationResult) {
            if (locationResult != null) {
                com.netcore.android.f.b a2 = this.f1168a.h;
                if (a2 != null) {
                    Location lastLocation = locationResult.getLastLocation();
                    Intrinsics.checkNotNullExpressionValue(lastLocation, "locationResult.lastLocation");
                    a2.onLocationFetchSuccess(lastLocation);
                }
                this.f1168a.b();
            }
        }
    }

    public i(a aVar) {
        Intrinsics.checkNotNullParameter(aVar, "builder");
        LocationRequest create = LocationRequest.create();
        float f2 = this.f1156b;
        if (f2 >= 0.0f) {
            create.zzg = f2;
            create.setInterval(this.f1157c);
            create.setFastestInterval(this.f1158d);
            create.setPriority(100);
            long j = this.f1159e;
            LocationRequest.zza(j);
            create.zzh = j;
            this.f1160f = create;
            Context b2 = aVar.b();
            this.f1155a = b2;
            if (b2 != null) {
                FusedLocationProviderClient fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(b2);
                Intrinsics.checkNotNullExpressionValue(fusedLocationProviderClient, "LocationServices.getFuse…nProviderClient(mContext)");
                this.g = fusedLocationProviderClient;
                this.f1156b = aVar.e();
                this.f1157c = aVar.f();
                this.f1158d = aVar.c();
                this.h = aVar.d();
                this.i = new d(this);
                return;
            }
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
            throw null;
        }
        StringBuilder sb = new StringBuilder(37);
        sb.append("invalid displacement: ");
        sb.append(f2);
        throw new IllegalArgumentException(sb.toString());
    }

    /* access modifiers changed from: private */
    @SuppressLint({"MissingPermission"})
    public final void c() {
        try {
            FusedLocationProviderClient fusedLocationProviderClient = this.g;
            if (fusedLocationProviderClient != null) {
                fusedLocationProviderClient.requestLocationUpdates(this.f1160f, this.i, Looper.getMainLooper());
            } else {
                Intrinsics.throwUninitializedPropertyAccessException("mFusedLocationClient");
                throw null;
            }
        } catch (SecurityException e2) {
            e2.printStackTrace();
        }
    }

    @SuppressLint({"MissingPermission"})
    public final void a() {
        FusedLocationProviderClient fusedLocationProviderClient = this.g;
        if (fusedLocationProviderClient != null) {
            Task<Location> lastLocation = fusedLocationProviderClient.getLastLocation();
            b bVar = new b(this);
            zzw zzw = (zzw) lastLocation;
            if (zzw != null) {
                zzw.addOnSuccessListener(TaskExecutors.MAIN_THREAD, (OnSuccessListener<? super TResult>) bVar);
                zzw.addOnFailureListener(TaskExecutors.MAIN_THREAD, new c(this));
                return;
            }
            throw null;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mFusedLocationClient");
        throw null;
    }

    public final void b() {
        FusedLocationProviderClient fusedLocationProviderClient = this.g;
        if (fusedLocationProviderClient != null) {
            fusedLocationProviderClient.removeLocationUpdates(this.i);
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("mFusedLocationClient");
            throw null;
        }
    }
}
