package com.google.android.gms.common;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager.NameNotFoundException;
import android.text.TextUtils;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.HideFirstParty;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.zzt;
import com.google.android.gms.common.util.DeviceProperties;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.internal.common.zzd;
import com.xiaomi.mipush.sdk.Constants;

@ShowFirstParty
@KeepForSdk
/* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
public class GoogleApiAvailabilityLight {
    @KeepForSdk
    public static final int GOOGLE_PLAY_SERVICES_VERSION_CODE = GooglePlayServicesUtilLight.GOOGLE_PLAY_SERVICES_VERSION_CODE;
    public static final GoogleApiAvailabilityLight zza = new GoogleApiAvailabilityLight();

    @ShowFirstParty
    @KeepForSdk
    public Intent getErrorResolutionIntent(Context context, int i, String str) {
        if (i == 1 || i == 2) {
            if (context != null && DeviceProperties.isWearableWithoutPlayStore(context)) {
                return zzt.zza();
            }
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("gcore_");
            outline73.append(GOOGLE_PLAY_SERVICES_VERSION_CODE);
            outline73.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
            if (!TextUtils.isEmpty(str)) {
                outline73.append(str);
            }
            outline73.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
            if (context != null) {
                outline73.append(context.getPackageName());
            }
            outline73.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
            if (context != null) {
                try {
                    outline73.append(Wrappers.packageManager(context).getPackageInfo(context.getPackageName(), 0).versionCode);
                } catch (NameNotFoundException unused) {
                }
            }
            return zzt.zzb("com.google.android.gms", outline73.toString());
        } else if (i != 3) {
            return null;
        } else {
            return zzt.zzc("com.google.android.gms");
        }
    }

    @KeepForSdk
    public PendingIntent getErrorResolutionPendingIntent(Context context, int i, int i2) {
        return getErrorResolutionPendingIntent(context, i, i2, null);
    }

    @KeepForSdk
    @HideFirstParty
    public int isGooglePlayServicesAvailable(Context context) {
        return isGooglePlayServicesAvailable(context, GOOGLE_PLAY_SERVICES_VERSION_CODE);
    }

    @ShowFirstParty
    @KeepForSdk
    public PendingIntent getErrorResolutionPendingIntent(Context context, int i, int i2, String str) {
        Intent errorResolutionIntent = getErrorResolutionIntent(context, i, str);
        if (errorResolutionIntent == null) {
            return null;
        }
        return PendingIntent.getActivity(context, i2, errorResolutionIntent, zzd.zza | 134217728);
    }

    @KeepForSdk
    public int isGooglePlayServicesAvailable(Context context, int i) {
        int isGooglePlayServicesAvailable = GooglePlayServicesUtilLight.isGooglePlayServicesAvailable(context, i);
        if (GooglePlayServicesUtilLight.isPlayServicesPossiblyUpdating(context, isGooglePlayServicesAvailable)) {
            return 18;
        }
        return isGooglePlayServicesAvailable;
    }
}
