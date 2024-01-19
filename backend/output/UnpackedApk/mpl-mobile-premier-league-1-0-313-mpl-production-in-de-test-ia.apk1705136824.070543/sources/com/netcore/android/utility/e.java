package com.netcore.android.utility;

import android.annotation.SuppressLint;
import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.netcore.android.f.b;
import com.netcore.android.logger.SMTLogger;
import com.userexperior.models.recording.enums.UeCustomType;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SMTFusedLocationManager.kt */
public final class e {

    /* renamed from: a  reason: collision with root package name */
    public final String f1285a = e.class.getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    public final Context f1286b;

    /* renamed from: c  reason: collision with root package name */
    public final b f1287c;

    public e(Context context, b bVar) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(bVar, "locationListener");
        this.f1286b = context;
        this.f1287c = bVar;
    }

    @SuppressLint({"MissingPermission"})
    public final void a() {
        try {
            Object systemService = this.f1286b.getSystemService("location");
            if (systemService != null) {
                LocationManager locationManager = (LocationManager) systemService;
                Location location = null;
                Location location2 = null;
                for (String lastKnownLocation : locationManager.getProviders(true)) {
                    try {
                        location2 = locationManager.getLastKnownLocation(lastKnownLocation);
                    } catch (SecurityException e2) {
                        SMTLogger sMTLogger = SMTLogger.INSTANCE;
                        String str = this.f1285a;
                        Intrinsics.checkNotNullExpressionValue(str, UeCustomType.TAG);
                        sMTLogger.e(str, String.valueOf(e2.getMessage()));
                    }
                    if (location2 != null) {
                        if (location == null || location2.getAccuracy() < location.getAccuracy()) {
                            location = location2;
                        }
                    }
                }
                if (location != null) {
                    this.f1287c.onLocationFetchSuccess(location);
                } else {
                    this.f1287c.onLocationFetchFailed(new Exception("Location fetched: but value is null"));
                }
            } else {
                throw new NullPointerException("null cannot be cast to non-null type android.location.LocationManager");
            }
        } catch (Exception e3) {
            SMTLogger sMTLogger2 = SMTLogger.INSTANCE;
            String str2 = this.f1285a;
            GeneratedOutlineSupport.outline96(str2, UeCustomType.TAG, e3, sMTLogger2, str2);
        }
    }
}
