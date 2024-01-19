package com.shield.android.c;

import android.annotation.SuppressLint;
import android.content.Context;
import android.location.Location;
import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.LocationSettingsRequest.Builder;
import com.google.android.gms.location.LocationSettingsResponse;
import com.google.android.gms.location.SettingsClient;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskExecutors;
import com.google.android.gms.tasks.zzw;
import com.google.firebase.perf.config.RemoteConfigManager;
import com.netcore.android.SMTConfigConstants;
import com.shield.android.internal.f;
import com.shield.android.internal.j;

public class k implements p {

    /* renamed from: a  reason: collision with root package name */
    public final Object f1525a = new Object();

    /* renamed from: b  reason: collision with root package name */
    public FusedLocationProviderClient f1526b;

    /* renamed from: c  reason: collision with root package name */
    public LocationRequest f1527c;

    /* renamed from: d  reason: collision with root package name */
    public LocationSettingsRequest f1528d;

    /* renamed from: e  reason: collision with root package name */
    public LocationCallback f1529e;

    /* renamed from: f  reason: collision with root package name */
    public final Context f1530f;
    public SettingsClient g;
    public boolean h = false;
    public q i;
    public Location j = null;
    public boolean k = false;

    public class a extends LocationCallback {
        public a() {
        }

        public void onLocationResult(LocationResult locationResult) {
            super.onLocationResult(locationResult);
            if (locationResult == null || locationResult.getLastLocation() == null || k.this.i == null) {
                k.this.c();
                return;
            }
            Location lastLocation = locationResult.getLastLocation();
            k kVar = k.this;
            kVar.k = true;
            kVar.i.a(lastLocation);
        }
    }

    public k(Context context) {
        this.f1530f = context;
        this.f1526b = LocationServices.getFusedLocationProviderClient(context);
        this.g = new SettingsClient(this.f1530f);
        LocationRequest create = LocationRequest.create();
        this.f1527c = create;
        create.setPriority(100);
        this.f1527c.setInterval(400);
        this.f1527c.setFastestInterval(200);
        this.f1529e = new a();
        Builder builder = new Builder();
        builder.addLocationRequest(this.f1527c);
        this.f1528d = builder.build();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void f() {
        if (!this.k) {
            try {
                this.f1526b.removeLocationUpdates(this.f1529e);
                q qVar = this.i;
                if (qVar != null) {
                    qVar.a(b());
                }
            } catch (Exception unused) {
                q qVar2 = this.i;
                if (qVar2 != null) {
                    qVar2.a(null);
                }
            }
        }
    }

    public void a(q qVar) {
        this.i = qVar;
    }

    @SuppressLint({"MissingPermission"})
    public Location b() {
        try {
            this.f1526b.getLastLocation().addOnCompleteListener(new OnCompleteListener() {
                public final void onComplete(Task task) {
                    k.this.a(task);
                }
            });
            synchronized (this.f1525a) {
                try {
                    this.f1525a.wait(2000);
                } catch (InterruptedException e2) {
                    if (f.a().f1677b && e2.getMessage() != null) {
                        e2.getLocalizedMessage();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        } catch (Exception e3) {
            if (f.a().f1677b && e3.getMessage() != null) {
                e3.getLocalizedMessage();
            }
        }
        return this.j;
    }

    public void c() {
        if (j.h(this.f1530f, SMTConfigConstants.LOCATION_PERMISSION_MF_KEY) || j.h(this.f1530f, "android.permission.ACCESS_COARSE_LOCATION")) {
            this.h = true;
            if (1 != 0) {
                Task<LocationSettingsResponse> checkLocationSettings = this.g.checkLocationSettings(this.f1528d);
                $$Lambda$k$XvgwPGFsgPGtViHUw_ubWdwmRQ r1 = new OnSuccessListener() {
                    public final void onSuccess(Object obj) {
                        k.this.a((LocationSettingsResponse) obj);
                    }
                };
                zzw zzw = (zzw) checkLocationSettings;
                if (zzw != null) {
                    zzw.addOnSuccessListener(TaskExecutors.MAIN_THREAD, (OnSuccessListener<? super TResult>) r1);
                    return;
                }
                throw null;
            }
        }
    }

    public void d() {
        if (this.h) {
            try {
                this.f1526b.removeLocationUpdates(this.f1529e).addOnCompleteListener(new OnCompleteListener() {
                    public final void onComplete(Task task) {
                        k.this.h = false;
                    }
                });
            } catch (Exception e2) {
                if (f.a().f1677b && e2.getMessage() != null) {
                    e2.getLocalizedMessage();
                }
            }
        }
    }

    public void a() {
        try {
            this.f1526b.flushLocations();
        } catch (Exception unused) {
        }
    }

    /* access modifiers changed from: private */
    public void a(Task task) {
        try {
            this.j = (Location) task.getResult();
        } catch (Exception unused) {
        }
        synchronized (this.f1525a) {
            try {
                this.f1525a.notifyAll();
            } catch (Exception e2) {
                if (f.a().f1677b && e2.getMessage() != null) {
                    e2.getLocalizedMessage();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* access modifiers changed from: private */
    public void a(LocationSettingsResponse locationSettingsResponse) {
        try {
            this.f1526b.requestLocationUpdates(this.f1527c, this.f1529e, Looper.getMainLooper());
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                public final void run() {
                    k.this.f();
                }
            }, RemoteConfigManager.MIN_APP_START_CONFIG_FETCH_DELAY_MS);
        } catch (Exception e2) {
            if (f.a().f1677b && e2.getMessage() != null) {
                e2.getLocalizedMessage();
            }
        }
    }
}
