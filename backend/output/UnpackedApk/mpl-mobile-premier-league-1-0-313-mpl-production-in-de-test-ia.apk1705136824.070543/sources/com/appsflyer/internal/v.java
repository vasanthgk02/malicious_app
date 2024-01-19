package com.appsflyer.internal;

import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import com.netcore.android.SMTConfigConstants;

public final class v {

    public static final class b {
        public static final v AFKeystoreWrapper = new v();
    }

    public static boolean AFInAppEventType(Context context, String[] strArr) {
        for (String AFInAppEventType : strArr) {
            if (z.AFInAppEventType(context, AFInAppEventType)) {
                return true;
            }
        }
        return false;
    }

    public final Location valueOf(Context context) {
        try {
            LocationManager locationManager = (LocationManager) context.getSystemService("location");
            Location lastKnownLocation = AFInAppEventType(context, new String[]{SMTConfigConstants.LOCATION_PERMISSION_MF_KEY, "android.permission.ACCESS_COARSE_LOCATION"}) ? locationManager.getLastKnownLocation("network") : null;
            Location lastKnownLocation2 = AFInAppEventType(context, new String[]{SMTConfigConstants.LOCATION_PERMISSION_MF_KEY}) ? locationManager.getLastKnownLocation("gps") : null;
            if (lastKnownLocation2 == null && lastKnownLocation == null) {
                lastKnownLocation = null;
            } else if (lastKnownLocation2 != null || lastKnownLocation == null) {
                if ((lastKnownLocation == null && lastKnownLocation2 != null) || 60000 >= lastKnownLocation.getTime() - lastKnownLocation2.getTime()) {
                    lastKnownLocation = lastKnownLocation2;
                }
            }
            if (lastKnownLocation != null) {
                return lastKnownLocation;
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }
}
