package com.shield.android.c;

import android.annotation.SuppressLint;
import android.content.Context;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.google.firebase.perf.config.RemoteConfigManager;
import com.netcore.android.SMTConfigConstants;
import com.shield.android.internal.f;
import com.shield.android.internal.j;

public class o implements p {

    /* renamed from: a  reason: collision with root package name */
    public final String f1540a = o.class.getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    public q f1541b;

    /* renamed from: c  reason: collision with root package name */
    public final LocationListener f1542c;

    /* renamed from: d  reason: collision with root package name */
    public final LocationManager f1543d;

    /* renamed from: e  reason: collision with root package name */
    public final Context f1544e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f1545f = false;

    public class a implements LocationListener {
        public a() {
        }

        public void onLocationChanged(Location location) {
            o oVar = o.this;
            q qVar = oVar.f1541b;
            if (qVar == null || location == null) {
                o.this.c();
                return;
            }
            oVar.f1545f = true;
            qVar.a(location);
        }

        public void onProviderDisabled(String str) {
            Object[] objArr = {str};
            if (f.a(o.this.f1540a).f1677b) {
                String.format("Request updates from %s provider disabled", objArr);
            }
        }

        public void onProviderEnabled(String str) {
            Object[] objArr = {str};
            if (f.a(o.this.f1540a).f1677b) {
                String.format("Request updates from %s provider enabled.", objArr);
            }
        }

        public void onStatusChanged(String str, int i, Bundle bundle) {
        }
    }

    public o(Context context) {
        this.f1544e = context;
        this.f1543d = (LocationManager) context.getSystemService("location");
        this.f1542c = new a();
    }

    public void a() {
    }

    public void a(q qVar) {
        this.f1541b = qVar;
    }

    @SuppressLint({"MissingPermission"})
    public Location b() {
        try {
            if (j.i(this.f1544e, SMTConfigConstants.LOCATION_PERMISSION_MF_KEY) || j.i(this.f1544e, "android.permission.ACCESS_COARSE_LOCATION")) {
                String bestProvider = this.f1543d.getBestProvider(new Criteria(), true);
                if (bestProvider != null) {
                    return this.f1543d.getLastKnownLocation(bestProvider);
                }
            }
        } catch (Exception e2) {
            if (f.a().f1677b && e2.getMessage() != null) {
                e2.getLocalizedMessage();
            }
        }
        return null;
    }

    @SuppressLint({"MissingPermission"})
    public void c() {
        if (j.i(this.f1544e, SMTConfigConstants.LOCATION_PERMISSION_MF_KEY) || j.i(this.f1544e, "android.permission.ACCESS_COARSE_LOCATION")) {
            String bestProvider = this.f1543d.getBestProvider(new Criteria(), true);
            if (bestProvider != null) {
                this.f1543d.requestLocationUpdates(bestProvider, 2000, 0.0f, this.f1542c, Looper.getMainLooper());
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable(bestProvider) {
                    public final /* synthetic */ String f$1;

                    {
                        this.f$1 = r2;
                    }

                    public final void run() {
                        o.this.a(this.f$1);
                    }
                }, RemoteConfigManager.MIN_APP_START_CONFIG_FETCH_DELAY_MS);
            }
        }
    }

    @SuppressLint({"MissingPermission"})
    public void d() {
        this.f1543d.removeUpdates(this.f1542c);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(String str) {
        if (!this.f1545f) {
            try {
                this.f1543d.removeUpdates(this.f1542c);
                q qVar = this.f1541b;
                if (qVar != null) {
                    qVar.a(this.f1543d.getLastKnownLocation(str));
                }
            } catch (Exception unused) {
                q qVar2 = this.f1541b;
                if (qVar2 != null) {
                    qVar2.a(null);
                }
            }
        }
    }
}
