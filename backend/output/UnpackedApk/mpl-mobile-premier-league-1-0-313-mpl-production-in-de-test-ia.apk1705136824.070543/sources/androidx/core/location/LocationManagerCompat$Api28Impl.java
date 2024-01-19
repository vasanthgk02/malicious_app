package androidx.core.location;

import android.location.LocationManager;

public class LocationManagerCompat$Api28Impl {
    public static String getGnssHardwareModelName(LocationManager locationManager) {
        return locationManager.getGnssHardwareModelName();
    }

    public static int getGnssYearOfHardware(LocationManager locationManager) {
        return locationManager.getGnssYearOfHardware();
    }

    public static boolean isLocationEnabled(LocationManager locationManager) {
        return locationManager.isLocationEnabled();
    }
}
