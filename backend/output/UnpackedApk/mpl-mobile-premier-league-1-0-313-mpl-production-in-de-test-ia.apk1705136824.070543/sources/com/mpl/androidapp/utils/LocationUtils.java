package com.mpl.androidapp.utils;

import android.app.Activity;
import android.location.Location;
import android.os.Build.VERSION;
import android.os.Looper;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.tasks.CancellationTokenSource;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskExecutors;
import com.google.android.gms.tasks.zzb;
import com.google.android.gms.tasks.zzw;
import com.mpl.androidapp.config.ConfigManager;
import com.mpl.androidapp.webview.ct.EventConstants.ZltGameLoading;
import com.mpl.securepreferences.MPreferences;
import io.hansel.actions.configs.HanselConfigs;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;

public class LocationUtils {
    public static final String LOCATION_FIRST_LAUNCH_FLAG = "LOCATION_FIRST_LAUNCH_FLAG";
    public static final String TAG = "LocationUtils";
    public FusedLocationProviderClient mFusedLocationClient;

    public interface ILocationListener {
        void onLocationFetchSuccess(Location location);

        void onLocationFetchedFailed(String str);

        void onLocationMocked();
    }

    public enum LocationFailedReasons {
        PERMISSION_NOT_PRESENT,
        UNABLE_TO_FETCH_LOCATION
    }

    public enum LocationStatus {
        SUCCESS,
        FAIL,
        LOCATION_NULL,
        LOCATION_MOCKED
    }

    public LocationUtils(FusedLocationProviderClient fusedLocationProviderClient) {
        this.mFusedLocationClient = fusedLocationProviderClient;
    }

    /* access modifiers changed from: private */
    public void flushAndDetectCurrentLocation(final ILocationListener iLocationListener) {
        final Long valueOf = Long.valueOf(System.currentTimeMillis());
        Task<Void> flushLocations = this.mFusedLocationClient.flushLocations();
        AnonymousClass4 r2 = new OnSuccessListener<Void>() {
            public void onSuccess(Void voidR) {
                MLogger.d(LocationUtils.TAG, "onSuccess:flushLocations ");
                long currentTimeMillis = System.currentTimeMillis() - valueOf.longValue();
                MLogger.d(LocationUtils.TAG, GeneratedOutlineSupport.outline45("Time take to flush location (Seconds)--->", currentTimeMillis));
                LocationUtils.this.sendFlushingLocationEvent(LocationStatus.SUCCESS, TimeUnit.MILLISECONDS.toSeconds(currentTimeMillis));
                LocationUtils.this.getCurrentLocation(iLocationListener, false);
            }
        };
        zzw zzw = (zzw) flushLocations;
        if (zzw != null) {
            zzw.addOnSuccessListener(TaskExecutors.MAIN_THREAD, (OnSuccessListener<? super TResult>) r2);
            zzw.addOnFailureListener(TaskExecutors.MAIN_THREAD, new OnFailureListener() {
                public void onFailure(Exception exc) {
                    long currentTimeMillis = System.currentTimeMillis() - valueOf.longValue();
                    StringBuilder sb = new StringBuilder("Exception in getFlushLocation");
                    String str = "";
                    if (!(exc == null || exc.getMessage() == null)) {
                        str = exc.getMessage();
                    }
                    sb.append(str);
                    LocationUtils.this.sendFlushingLocationEvent(LocationStatus.FAIL, TimeUnit.MILLISECONDS.toSeconds(currentTimeMillis), sb.toString());
                    iLocationListener.onLocationFetchedFailed(sb.toString());
                }
            });
            return;
        }
        throw null;
    }

    private void flushAndDetectNewLocation(final ILocationListener iLocationListener) {
        final Long valueOf = Long.valueOf(System.currentTimeMillis());
        Task<Void> flushLocations = this.mFusedLocationClient.flushLocations();
        AnonymousClass6 r2 = new OnSuccessListener<Void>() {
            public void onSuccess(Void voidR) {
                MLogger.d(LocationUtils.TAG, "onSuccess:flushLocations ");
                long currentTimeMillis = System.currentTimeMillis() - valueOf.longValue();
                MLogger.d(LocationUtils.TAG, GeneratedOutlineSupport.outline45("Time take to flush location (Seconds)--->", currentTimeMillis));
                LocationUtils.this.sendFlushingLocationEvent(LocationStatus.SUCCESS, TimeUnit.MILLISECONDS.toSeconds(currentTimeMillis));
                LocationUtils.this.getNewLocationFix(iLocationListener, true);
            }
        };
        zzw zzw = (zzw) flushLocations;
        if (zzw != null) {
            zzw.addOnSuccessListener(TaskExecutors.MAIN_THREAD, (OnSuccessListener<? super TResult>) r2);
            zzw.addOnFailureListener(TaskExecutors.MAIN_THREAD, new OnFailureListener() {
                public void onFailure(Exception exc) {
                    long currentTimeMillis = System.currentTimeMillis() - valueOf.longValue();
                    StringBuilder sb = new StringBuilder("Exception in getFlushLocation");
                    String str = "";
                    if (!(exc == null || exc.getMessage() == null)) {
                        str = exc.getMessage();
                    }
                    sb.append(str);
                    LocationUtils.this.sendFlushingLocationEvent(LocationStatus.FAIL, TimeUnit.MILLISECONDS.toSeconds(currentTimeMillis), sb.toString());
                    iLocationListener.onLocationFetchedFailed(sb.toString());
                }
            });
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void getCurrentLocation(final ILocationListener iLocationListener, final boolean z) {
        zzb zzb = new CancellationTokenSource().zza;
        final Long valueOf = Long.valueOf(System.currentTimeMillis());
        Task<Location> currentLocation = this.mFusedLocationClient.getCurrentLocation(100, zzb);
        AnonymousClass2 r2 = new OnSuccessListener<Location>() {
            public void onSuccess(Location location) {
                long currentTimeMillis = System.currentTimeMillis() - valueOf.longValue();
                if (location != null) {
                    MLogger.d(LocationUtils.TAG, "get Location Current onSuccess:location is not null ");
                    if (!LocationUtils.this.isMockLocation(location)) {
                        MLogger.d(LocationUtils.TAG, "location is not mocked");
                        LocationUtils.this.sendCurrentLocationEvent(LocationStatus.SUCCESS, TimeUnit.MILLISECONDS.toSeconds(currentTimeMillis));
                        iLocationListener.onLocationFetchSuccess(location);
                        return;
                    }
                    MLogger.d(LocationUtils.TAG, "location is mocked");
                    LocationUtils.this.sendCurrentLocationEvent(LocationStatus.LOCATION_MOCKED, TimeUnit.MILLISECONDS.toSeconds(currentTimeMillis));
                    if (z) {
                        MLogger.d(LocationUtils.TAG, "Flushing locations and retrying");
                        LocationUtils.this.flushAndDetectCurrentLocation(iLocationListener);
                        return;
                    }
                    iLocationListener.onLocationMocked();
                    return;
                }
                MLogger.d(LocationUtils.TAG, "get Location Current onSuccess:location is NULL");
                LocationUtils.this.sendCurrentLocationEvent(LocationStatus.LOCATION_NULL, TimeUnit.MILLISECONDS.toSeconds(currentTimeMillis));
                LocationUtils.this.getLastKnownLocation(iLocationListener);
            }
        };
        zzw zzw = (zzw) currentLocation;
        if (zzw != null) {
            zzw.addOnSuccessListener(TaskExecutors.MAIN_THREAD, (OnSuccessListener<? super TResult>) r2);
            zzw.addOnFailureListener(TaskExecutors.MAIN_THREAD, new OnFailureListener() {
                public void onFailure(Exception exc) {
                    long currentTimeMillis = System.currentTimeMillis() - valueOf.longValue();
                    StringBuilder sb = new StringBuilder("Exception in getCurrentLocation");
                    String str = "";
                    if (!(exc == null || exc.getMessage() == null)) {
                        str = exc.getMessage();
                    }
                    sb.append(str);
                    LocationUtils.this.sendCurrentLocationEvent(LocationStatus.FAIL, TimeUnit.MILLISECONDS.toSeconds(currentTimeMillis), sb.toString());
                    iLocationListener.onLocationFetchedFailed(sb.toString());
                }
            });
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void getLastKnownLocation(final ILocationListener iLocationListener) {
        MLogger.d(TAG, "Trying to getLastKnownLocation");
        final Long valueOf = Long.valueOf(System.currentTimeMillis());
        Task<Location> lastLocation = this.mFusedLocationClient.getLastLocation();
        AnonymousClass8 r2 = new OnSuccessListener<Location>() {
            public void onSuccess(Location location) {
                long currentTimeMillis = System.currentTimeMillis() - valueOf.longValue();
                MLogger.d(LocationUtils.TAG, "onSuccess:getLastLocation ");
                if (location != null) {
                    MLogger.d(LocationUtils.TAG, "location is not null");
                    if (!LocationUtils.this.isMockLocation(location)) {
                        MLogger.d(LocationUtils.TAG, "location is not mocked");
                        LocationUtils.this.sendLastKnownLocationEvent(LocationStatus.SUCCESS, TimeUnit.MILLISECONDS.toSeconds(currentTimeMillis));
                        iLocationListener.onLocationFetchSuccess(location);
                        return;
                    }
                    MLogger.d(LocationUtils.TAG, "location is mocked");
                    LocationUtils.this.sendLastKnownLocationEvent(LocationStatus.LOCATION_MOCKED, TimeUnit.MILLISECONDS.toSeconds(currentTimeMillis));
                    LocationUtils.this.getNewLocationFix(iLocationListener, false);
                    return;
                }
                LocationUtils.this.sendLastKnownLocationEvent(LocationStatus.LOCATION_NULL, TimeUnit.MILLISECONDS.toSeconds(currentTimeMillis));
                LocationUtils.this.getNewLocationFix(iLocationListener, false);
            }
        };
        zzw zzw = (zzw) lastLocation;
        if (zzw != null) {
            zzw.addOnSuccessListener(TaskExecutors.MAIN_THREAD, (OnSuccessListener<? super TResult>) r2);
            zzw.addOnFailureListener(TaskExecutors.MAIN_THREAD, new OnFailureListener() {
                public void onFailure(Exception exc) {
                    long currentTimeMillis = System.currentTimeMillis() - valueOf.longValue();
                    StringBuilder sb = new StringBuilder("Exception in getLastKnownLocation");
                    String str = "";
                    if (!(exc == null || exc.getMessage() == null)) {
                        str = exc.getMessage();
                    }
                    sb.append(str);
                    LocationUtils.this.sendLastKnownLocationEvent(LocationStatus.FAIL, TimeUnit.MILLISECONDS.toSeconds(currentTimeMillis), sb.toString());
                    iLocationListener.onLocationFetchedFailed(sb.toString());
                }
            });
            return;
        }
        throw null;
    }

    /* access modifiers changed from: private */
    public void getNewLocationFix(final ILocationListener iLocationListener, final boolean z) {
        MLogger.d(TAG, "onSuccess:Attempting to get a new location fix!");
        LocationRequest create = LocationRequest.create();
        create.setPriority(100);
        create.setInterval(1000);
        final Long valueOf = Long.valueOf(System.currentTimeMillis());
        this.mFusedLocationClient.requestLocationUpdates(create, new LocationCallback() {
            public void onLocationResult(LocationResult locationResult) {
                long currentTimeMillis = System.currentTimeMillis() - valueOf.longValue();
                super.onLocationResult(locationResult);
                if (locationResult == null) {
                    MLogger.d(LocationUtils.TAG, "Received NULL location result returning ");
                    LocationUtils.this.sendNewLocationEvent(LocationStatus.LOCATION_NULL, TimeUnit.MILLISECONDS.toSeconds(currentTimeMillis), z);
                    return;
                }
                Iterator<Location> it = locationResult.zzb.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    Location next = it.next();
                    if (next != null) {
                        MLogger.d(LocationUtils.TAG, "Received new non null locationResult with non null location");
                        LocationUtils.this.mFusedLocationClient.removeLocationUpdates(this);
                        MLogger.d(LocationUtils.TAG, "Stopped location updates");
                        if (!LocationUtils.this.isMockLocation(next)) {
                            MLogger.d(LocationUtils.TAG, "location is not mocked");
                            LocationUtils.this.sendNewLocationEvent(LocationStatus.SUCCESS, TimeUnit.MILLISECONDS.toSeconds(currentTimeMillis), z);
                            LocationUtils.this.setIsFirstLaunchAfterInstallation();
                            iLocationListener.onLocationFetchSuccess(next);
                        } else {
                            LocationUtils.this.sendNewLocationEvent(LocationStatus.LOCATION_MOCKED, TimeUnit.MILLISECONDS.toSeconds(currentTimeMillis), z);
                            iLocationListener.onLocationMocked();
                        }
                    }
                }
            }
        }, Looper.getMainLooper());
    }

    private boolean isFirstLaunchFlushingEnabled() {
        try {
            return ConfigManager.getPlatformConfig().getBoolean("location.firstLaunchFlushingEnabled");
        } catch (JSONException unused) {
            return HanselConfigs.getBoolean(Constant.FIRST_LAUNCH_FLUSHING_ENABLED, false);
        }
    }

    /* access modifiers changed from: private */
    public boolean isMockLocation(Location location) {
        if (ConfigManager.getPlatformConfig().optBoolean("location.isNativeMockDetectionEnabled", false)) {
            try {
                if (VERSION.SDK_INT <= 30) {
                    return location.isFromMockProvider();
                }
                if (VERSION.SDK_INT >= 31) {
                    try {
                        return ((Boolean) location.getClass().getDeclaredMethod("isMock", new Class[0]).invoke(location, new Object[0])).booleanValue();
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
            } catch (Exception unused) {
            }
        }
        return false;
    }

    /* access modifiers changed from: private */
    public void sendCurrentLocationEvent(LocationStatus locationStatus, long j) {
        sendLocationEvent("Current Location", locationStatus, j, "");
    }

    /* access modifiers changed from: private */
    public void sendFlushingLocationEvent(LocationStatus locationStatus, long j) {
        sendLocationEvent("Flushing Location", locationStatus, j, "");
    }

    /* access modifiers changed from: private */
    public void sendLastKnownLocationEvent(LocationStatus locationStatus, long j) {
        sendLocationEvent("Last Known Location", locationStatus, j, "");
    }

    private void sendLocationEvent(String str, LocationStatus locationStatus, long j, String str2) {
        HashMap outline87 = GeneratedOutlineSupport.outline87("Type", str);
        outline87.put("Status", locationStatus.name());
        outline87.put(ZltGameLoading.PROPERTY_TIME_TAKEN, Long.valueOf(j));
        if (str2 != null && !str2.isEmpty()) {
            outline87.put("Fail reason", str2);
        }
        CleverTapAnalyticsUtils.sendEvent((String) "Location Fetch Status", outline87);
    }

    /* access modifiers changed from: private */
    public void sendNewLocationEvent(LocationStatus locationStatus, long j, boolean z) {
        if (!z) {
            sendLocationEvent("New Location", locationStatus, j, "");
        } else {
            sendLocationEvent("New Location Flushing", locationStatus, j, "");
        }
    }

    public boolean isFirstLaunchAfterInstallation() {
        return MPreferences.getBoolean(LOCATION_FIRST_LAUNCH_FLAG, true, false);
    }

    public void setIsFirstLaunchAfterInstallation() {
        MPreferences.putBoolean(LOCATION_FIRST_LAUNCH_FLAG, false, false);
    }

    public void startLocationRequest(Activity activity, ILocationListener iLocationListener) {
        boolean optBoolean = ConfigManager.getPlatformConfig().optBoolean("location.addressFromCurrentLocationEnabled", false);
        if (isFirstLaunchFlushingEnabled() && isFirstLaunchAfterInstallation()) {
            flushAndDetectNewLocation(iLocationListener);
        } else if (optBoolean) {
            getCurrentLocation(iLocationListener, true);
        } else {
            getLastKnownLocation(iLocationListener);
        }
    }

    /* access modifiers changed from: private */
    public void sendCurrentLocationEvent(LocationStatus locationStatus, long j, String str) {
        sendLocationEvent("Current Location", locationStatus, j, str);
    }

    /* access modifiers changed from: private */
    public void sendFlushingLocationEvent(LocationStatus locationStatus, long j, String str) {
        sendLocationEvent("Flushing Location", locationStatus, j, str);
    }

    /* access modifiers changed from: private */
    public void sendLastKnownLocationEvent(LocationStatus locationStatus, long j, String str) {
        sendLocationEvent("Last Known Location", locationStatus, j, str);
    }
}
