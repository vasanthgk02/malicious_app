package com.mpl.androidapp.utils;

import android.app.Activity;
import android.content.Context;
import android.content.IntentSender.SendIntentException;
import android.location.LocationManager;
import android.widget.Toast;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.ResolvableApiException;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.LocationSettingsRequest.Builder;
import com.google.android.gms.location.LocationSettingsResponse;
import com.google.android.gms.location.SettingsClient;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskExecutors;
import com.google.android.gms.tasks.zzl;
import com.google.android.gms.tasks.zzv;
import com.google.android.gms.tasks.zzw;
import com.mpl.androidapp.utils.GpsUtilsV2.OnGpsListenerV2;
import org.eclipse.paho.client.mqttv3.MqttAsyncClient;

public class GpsUtilsV2 {
    public static final String TAG = "GpsUtilsV2";
    public Context context;
    public LocationManager locationManager;
    public LocationRequest locationRequest;
    public LocationSettingsRequest mLocationSettingsRequest;
    public SettingsClient mSettingsClient;

    public interface OnGpsListenerV2 {
        void gpsStatus(boolean z);
    }

    public GpsUtilsV2(Context context2) {
        this.context = context2;
        this.locationManager = (LocationManager) context2.getSystemService("location");
        this.mSettingsClient = LocationServices.getSettingsClient(context2);
        LocationRequest create = LocationRequest.create();
        this.locationRequest = create;
        create.setPriority(100);
        this.locationRequest.setInterval(MqttAsyncClient.DISCONNECT_TIMEOUT);
        this.locationRequest.setFastestInterval(2000);
        Builder builder = new Builder();
        builder.addLocationRequest(this.locationRequest);
        this.mLocationSettingsRequest = builder.build();
        builder.zzb = true;
    }

    public static /* synthetic */ void lambda$turnGPSOn$0(OnGpsListenerV2 onGpsListenerV2, LocationSettingsResponse locationSettingsResponse) {
        MLogger.d(TAG, "onSuccess: gps settings dont need changing");
        if (onGpsListenerV2 != null) {
            onGpsListenerV2.gpsStatus(true);
        }
    }

    public void lambda$turnGPSOn$1$GpsUtilsV2(Exception exc) {
        int i = ((ApiException) exc).mStatus.zzc;
        MLogger.d(TAG, "onFailure: ", Integer.valueOf(i));
        MLogger.d(TAG, "onFailure:getMessage ", exc.getMessage());
        if (i == 6) {
            MLogger.d(TAG, "GPS settings need to change");
            try {
                ((ResolvableApiException) exc).mStatus.startResolutionForResult((Activity) this.context, Constant.GPS_REQUEST_ID_V2);
            } catch (SendIntentException unused) {
                MLogger.i(TAG, "PendingIntent unable to execute request.");
            }
        } else if (i == 8502) {
            MLogger.e(TAG, "Location settings are inadequate, and cannot be fixed here. Fix in Settings.");
            Toast.makeText((Activity) this.context, "Location settings are inadequate, and cannot be fixed here. Fix in Settings.", 1).show();
        }
    }

    public void turnGPSOn(OnGpsListenerV2 onGpsListenerV2) {
        if (!this.locationManager.isProviderEnabled("gps")) {
            Task<LocationSettingsResponse> checkLocationSettings = this.mSettingsClient.checkLocationSettings(this.mLocationSettingsRequest);
            checkLocationSettings.addOnSuccessListener((Activity) this.context, (OnSuccessListener<? super TResult>) new OnSuccessListener() {
                public final void onSuccess(Object obj) {
                    GpsUtilsV2.lambda$turnGPSOn$0(OnGpsListenerV2.this, (LocationSettingsResponse) obj);
                }
            });
            zzw zzw = (zzw) checkLocationSettings;
            zzl zzl = new zzl(TaskExecutors.MAIN_THREAD, new OnFailureListener() {
                public final void onFailure(Exception exc) {
                    GpsUtilsV2.this.lambda$turnGPSOn$1$GpsUtilsV2(exc);
                }
            });
            zzw.zzb.zza(zzl);
            zzv.zza((Activity) this.context).zzb(zzl);
            zzw.zzi();
        } else if (onGpsListenerV2 != null) {
            onGpsListenerV2.gpsStatus(true);
        }
    }
}
