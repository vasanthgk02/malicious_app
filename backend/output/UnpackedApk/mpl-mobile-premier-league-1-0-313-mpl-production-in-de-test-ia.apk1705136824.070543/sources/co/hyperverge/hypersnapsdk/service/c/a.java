package co.hyperverge.hypersnapsdk.service.c;

import android.annotation.SuppressLint;
import android.content.Context;
import android.location.Location;
import android.os.Looper;
import co.hyperverge.hypersnapsdk.f.i;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.LocationSettingsRequest.Builder;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskExecutors;
import com.google.android.gms.tasks.zzw;
import com.google.firebase.perf.config.RemoteConfigManager;

/* compiled from: LocationServiceImpl */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static a f3195a;

    /* renamed from: b  reason: collision with root package name */
    public final FusedLocationProviderClient f3196b;

    /* renamed from: c  reason: collision with root package name */
    public co.hyperverge.hypersnapsdk.listeners.a f3197c;

    /* renamed from: d  reason: collision with root package name */
    public final LocationCallback f3198d = new C0059a();

    /* renamed from: e  reason: collision with root package name */
    public Location f3199e = null;

    /* renamed from: f  reason: collision with root package name */
    public final Context f3200f;

    /* renamed from: co.hyperverge.hypersnapsdk.service.c.a$a  reason: collision with other inner class name */
    /* compiled from: LocationServiceImpl */
    public class C0059a extends LocationCallback {
        public C0059a() {
        }

        public void onLocationResult(LocationResult locationResult) {
            co.hyperverge.hypersnapsdk.listeners.a aVar = a.this.f3197c;
            if (aVar != null) {
                aVar.a(locationResult.getLastLocation());
            }
        }
    }

    /* compiled from: LocationServiceImpl */
    public class b implements OnSuccessListener<Location> {
        public b() {
        }

        public void onSuccess(Object obj) {
            Location location = (Location) obj;
            if (location != null) {
                a.this.f3199e = location;
            }
        }
    }

    public a(Context context) {
        this.f3200f = context;
        this.f3196b = LocationServices.getFusedLocationProviderClient(context.getApplicationContext());
    }

    public static a a(Context context) {
        if (f3195a == null) {
            f3195a = new a(context);
        }
        return f3195a;
    }

    @SuppressLint({"MissingPermission"})
    public void c() {
        try {
            LocationRequest locationRequest = new LocationRequest();
            locationRequest.setInterval(RemoteConfigManager.MIN_APP_START_CONFIG_FETCH_DELAY_MS);
            locationRequest.setFastestInterval(1000);
            LocationRequest.zza(500);
            locationRequest.zzh = 500;
            locationRequest.setPriority(100);
            new Builder().addLocationRequest(locationRequest);
            this.f3196b.requestLocationUpdates(locationRequest, this.f3198d, Looper.getMainLooper());
        } catch (NoClassDefFoundError e2) {
            i.a((Throwable) e2);
        }
    }

    @SuppressLint({"MissingPermission"})
    public Location a() {
        try {
            Task<Location> lastLocation = this.f3196b.getLastLocation();
            b bVar = new b();
            zzw zzw = (zzw) lastLocation;
            if (zzw != null) {
                zzw.addOnSuccessListener(TaskExecutors.MAIN_THREAD, (OnSuccessListener<? super TResult>) bVar);
                return this.f3199e;
            }
            throw null;
        } catch (NoClassDefFoundError e2) {
            i.a((Throwable) e2);
        }
    }
}
