package com.google.android.gms.common;

import android.annotation.TargetApi;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.os.UserManager;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.HideFirstParty;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.util.DeviceProperties;
import com.google.android.gms.common.util.UidVerifier;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.common.wrappers.Wrappers;
import in.juspay.hypersdk.core.PaymentConstants.SubCategory.Action;
import java.util.concurrent.atomic.AtomicBoolean;
import org.apache.pdfbox.pdfparser.BaseParser;

@ShowFirstParty
@KeepForSdk
/* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
public class GooglePlayServicesUtilLight {
    @KeepForSdk
    public static final int GMS_AVAILABILITY_NOTIFICATION_ID = 10436;
    @KeepForSdk
    public static final int GMS_GENERAL_ERROR_NOTIFICATION_ID = 39789;
    @KeepForSdk
    public static final String GOOGLE_PLAY_GAMES_PACKAGE = "com.google.android.play.games";
    @KeepForSdk
    @Deprecated
    public static final String GOOGLE_PLAY_SERVICES_PACKAGE = "com.google.android.gms";
    @KeepForSdk
    @Deprecated
    public static final int GOOGLE_PLAY_SERVICES_VERSION_CODE = 12451000;
    @KeepForSdk
    public static final String GOOGLE_PLAY_STORE_PACKAGE = "com.android.vending";
    @KeepForSdk
    @VisibleForTesting
    public static final AtomicBoolean sCanceledAvailabilityNotification = new AtomicBoolean();
    @VisibleForTesting
    public static boolean zza;
    public static boolean zzb;
    public static final AtomicBoolean zzc = new AtomicBoolean();

    @KeepForSdk
    @Deprecated
    public static void cancelAvailabilityErrorNotifications(Context context) {
        if (!sCanceledAvailabilityNotification.getAndSet(true)) {
            try {
                NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
                if (notificationManager != null) {
                    notificationManager.cancel(GMS_AVAILABILITY_NOTIFICATION_ID);
                }
            } catch (SecurityException unused) {
            }
        }
    }

    @ShowFirstParty
    @KeepForSdk
    public static void enableUsingApkIndependentContext() {
        zzc.set(true);
    }

    @KeepForSdk
    @Deprecated
    public static void ensurePlayServicesAvailable(Context context, int i) throws GooglePlayServicesRepairableException, GooglePlayServicesNotAvailableException {
        int isGooglePlayServicesAvailable = GoogleApiAvailabilityLight.zza.isGooglePlayServicesAvailable(context, i);
        if (isGooglePlayServicesAvailable != 0) {
            Intent errorResolutionIntent = GoogleApiAvailabilityLight.zza.getErrorResolutionIntent(context, isGooglePlayServicesAvailable, "e");
            if (errorResolutionIntent == null) {
                throw new GooglePlayServicesNotAvailableException(isGooglePlayServicesAvailable);
            }
            throw new GooglePlayServicesRepairableException(isGooglePlayServicesAvailable, "Google Play Services not available", errorResolutionIntent);
        }
    }

    @ShowFirstParty
    @KeepForSdk
    @Deprecated
    public static int getApkVersion(Context context) {
        try {
            return context.getPackageManager().getPackageInfo("com.google.android.gms", 0).versionCode;
        } catch (NameNotFoundException unused) {
            return 0;
        }
    }

    @ShowFirstParty
    @KeepForSdk
    @Deprecated
    public static int getClientVersion(Context context) {
        PackageInfo packageInfo;
        Preconditions.checkState(true);
        try {
            packageInfo = Wrappers.packageManager(context).zza.getPackageManager().getPackageInfo(context.getPackageName(), 128);
        } catch (NameNotFoundException unused) {
            packageInfo = null;
        }
        if (packageInfo == null) {
            return -1;
        }
        ApplicationInfo applicationInfo = packageInfo.applicationInfo;
        if (applicationInfo == null) {
            return -1;
        }
        Bundle bundle = applicationInfo.metaData;
        if (bundle != null) {
            return bundle.getInt("com.google.android.gms.version", -1);
        }
        return -1;
    }

    @KeepForSdk
    @Deprecated
    public static PendingIntent getErrorPendingIntent(int i, Context context, int i2) {
        return GoogleApiAvailabilityLight.zza.getErrorResolutionPendingIntent(context, i, i2);
    }

    @KeepForSdk
    @Deprecated
    @VisibleForTesting
    public static String getErrorString(int i) {
        return ConnectionResult.zza(i);
    }

    @ShowFirstParty
    @KeepForSdk
    @Deprecated
    public static Intent getGooglePlayServicesAvailabilityRecoveryIntent(int i) {
        return GoogleApiAvailabilityLight.zza.getErrorResolutionIntent(null, i, null);
    }

    @KeepForSdk
    public static Context getRemoteContext(Context context) {
        try {
            return context.createPackageContext("com.google.android.gms", 3);
        } catch (NameNotFoundException unused) {
            return null;
        }
    }

    @KeepForSdk
    public static Resources getRemoteResource(Context context) {
        try {
            return context.getPackageManager().getResourcesForApplication("com.google.android.gms");
        } catch (NameNotFoundException unused) {
            return null;
        }
    }

    @ShowFirstParty
    @KeepForSdk
    public static boolean honorsDebugCertificates(Context context) {
        if (!zza) {
            try {
                PackageInfo packageInfo = Wrappers.packageManager(context).zza.getPackageManager().getPackageInfo("com.google.android.gms", 64);
                GoogleSignatureVerifier.getInstance(context);
                if (packageInfo == null || GoogleSignatureVerifier.zzb(packageInfo, false) || !GoogleSignatureVerifier.zzb(packageInfo, true)) {
                    zzb = false;
                } else {
                    zzb = true;
                }
            } catch (NameNotFoundException unused) {
            } finally {
                zza = true;
            }
        }
        return zzb || !Action.USER.equals(Build.TYPE);
    }

    @KeepForSdk
    @Deprecated
    @HideFirstParty
    public static int isGooglePlayServicesAvailable(Context context) {
        return isGooglePlayServicesAvailable(context, GOOGLE_PLAY_SERVICES_VERSION_CODE);
    }

    @KeepForSdk
    @Deprecated
    public static boolean isGooglePlayServicesUid(Context context, int i) {
        return UidVerifier.isGooglePlayServicesUid(context, i);
    }

    @ShowFirstParty
    @KeepForSdk
    @Deprecated
    public static boolean isPlayServicesPossiblyUpdating(Context context, int i) {
        if (i == 18) {
            return true;
        }
        if (i == 1) {
            return zza(context, "com.google.android.gms");
        }
        return false;
    }

    @ShowFirstParty
    @KeepForSdk
    @Deprecated
    public static boolean isPlayStorePossiblyUpdating(Context context, int i) {
        if (i == 9) {
            return zza(context, "com.android.vending");
        }
        return false;
    }

    @TargetApi(18)
    @KeepForSdk
    public static boolean isRestrictedUserProfile(Context context) {
        Object systemService = context.getSystemService(Action.USER);
        Preconditions.checkNotNull(systemService);
        Bundle applicationRestrictions = ((UserManager) systemService).getApplicationRestrictions(context.getPackageName());
        return applicationRestrictions != null && BaseParser.TRUE.equals(applicationRestrictions.getString("restricted_profile"));
    }

    @ShowFirstParty
    @KeepForSdk
    @Deprecated
    @VisibleForTesting
    public static boolean isSidewinderDevice(Context context) {
        return DeviceProperties.zza(context);
    }

    @KeepForSdk
    @Deprecated
    public static boolean isUserRecoverableError(int i) {
        return i == 1 || i == 2 || i == 3 || i == 9;
    }

    @TargetApi(19)
    @KeepForSdk
    @Deprecated
    public static boolean uidHasPackageName(Context context, int i, String str) {
        return UidVerifier.uidHasPackageName(context, i, str);
    }

    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    @android.annotation.TargetApi(21)
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean zza(android.content.Context r5, java.lang.String r6) {
        /*
            java.lang.String r0 = "com.google.android.gms"
            boolean r0 = r6.equals(r0)
            r1 = 0
            android.content.pm.PackageManager r2 = r5.getPackageManager()     // Catch:{ Exception -> 0x0049 }
            android.content.pm.PackageInstaller r2 = r2.getPackageInstaller()     // Catch:{ Exception -> 0x0049 }
            java.util.List r2 = r2.getAllSessions()     // Catch:{ Exception -> 0x0049 }
            java.util.Iterator r2 = r2.iterator()
        L_0x0017:
            boolean r3 = r2.hasNext()
            r4 = 1
            if (r3 == 0) goto L_0x002f
            java.lang.Object r3 = r2.next()
            android.content.pm.PackageInstaller$SessionInfo r3 = (android.content.pm.PackageInstaller.SessionInfo) r3
            java.lang.String r3 = r3.getAppPackageName()
            boolean r3 = r6.equals(r3)
            if (r3 == 0) goto L_0x0017
            return r4
        L_0x002f:
            android.content.pm.PackageManager r2 = r5.getPackageManager()
            r3 = 8192(0x2000, float:1.148E-41)
            android.content.pm.ApplicationInfo r6 = r2.getApplicationInfo(r6, r3)     // Catch:{  }
            if (r0 == 0) goto L_0x003e
            boolean r5 = r6.enabled     // Catch:{  }
            return r5
        L_0x003e:
            boolean r6 = r6.enabled     // Catch:{  }
            if (r6 == 0) goto L_0x0049
            boolean r5 = isRestrictedUserProfile(r5)     // Catch:{  }
            if (r5 != 0) goto L_0x0049
            return r4
        L_0x0049:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.GooglePlayServicesUtilLight.zza(android.content.Context, java.lang.String):boolean");
    }

    /* JADX WARNING: Removed duplicated region for block: B:57:0x00a9  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00ab  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x00b9  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x00cc  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x00de  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x00e8  */
    @com.google.android.gms.common.annotation.KeepForSdk
    @java.lang.Deprecated
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int isGooglePlayServicesAvailable(android.content.Context r8, int r9) {
        /*
            android.content.res.Resources r0 = r8.getResources()     // Catch:{ all -> 0x000a }
            int r1 = com.google.android.gms.common.R.string.common_google_play_services_unknown_issue     // Catch:{ all -> 0x000a }
            r0.getString(r1)     // Catch:{ all -> 0x000a }
            goto L_0x000b
        L_0x000a:
        L_0x000b:
            java.lang.String r0 = "com.google.android.gms"
            java.lang.String r1 = r8.getPackageName()
            boolean r0 = r0.equals(r1)
            r1 = 1
            if (r0 != 0) goto L_0x006f
            java.util.concurrent.atomic.AtomicBoolean r0 = zzc
            boolean r0 = r0.get()
            if (r0 == 0) goto L_0x0021
            goto L_0x006f
        L_0x0021:
            java.lang.Object r0 = com.google.android.gms.common.internal.zzag.zza
            monitor-enter(r0)
            boolean r2 = com.google.android.gms.common.internal.zzag.zzb     // Catch:{ all -> 0x006c }
            if (r2 == 0) goto L_0x002a
            monitor-exit(r0)     // Catch:{ all -> 0x006c }
            goto L_0x0057
        L_0x002a:
            com.google.android.gms.common.internal.zzag.zzb = r1     // Catch:{ all -> 0x006c }
            java.lang.String r2 = r8.getPackageName()     // Catch:{ all -> 0x006c }
            com.google.android.gms.common.wrappers.PackageManagerWrapper r3 = com.google.android.gms.common.wrappers.Wrappers.packageManager(r8)     // Catch:{ all -> 0x006c }
            r4 = 128(0x80, float:1.8E-43)
            android.content.pm.ApplicationInfo r2 = r3.getApplicationInfo(r2, r4)     // Catch:{ NameNotFoundException -> 0x004e }
            android.os.Bundle r2 = r2.metaData     // Catch:{ NameNotFoundException -> 0x004e }
            if (r2 != 0) goto L_0x0040
            monitor-exit(r0)     // Catch:{ all -> 0x006c }
            goto L_0x0057
        L_0x0040:
            java.lang.String r3 = "com.google.app.id"
            r2.getString(r3)     // Catch:{ NameNotFoundException -> 0x004e }
            java.lang.String r3 = "com.google.android.gms.version"
            int r2 = r2.getInt(r3)     // Catch:{ NameNotFoundException -> 0x004e }
            com.google.android.gms.common.internal.zzag.zzd = r2     // Catch:{ NameNotFoundException -> 0x004e }
            goto L_0x0056
        L_0x004e:
            r2 = move-exception
            java.lang.String r3 = "MetadataValueReader"
            java.lang.String r4 = "This should never happen."
            android.util.Log.wtf(r3, r4, r2)     // Catch:{ all -> 0x006c }
        L_0x0056:
            monitor-exit(r0)     // Catch:{ all -> 0x006c }
        L_0x0057:
            int r0 = com.google.android.gms.common.internal.zzag.zzd
            if (r0 == 0) goto L_0x0066
            int r2 = GOOGLE_PLAY_SERVICES_VERSION_CODE
            if (r0 != r2) goto L_0x0060
            goto L_0x006f
        L_0x0060:
            com.google.android.gms.common.GooglePlayServicesIncorrectManifestValueException r8 = new com.google.android.gms.common.GooglePlayServicesIncorrectManifestValueException
            r8.<init>(r0)
            throw r8
        L_0x0066:
            com.google.android.gms.common.GooglePlayServicesMissingManifestValueException r8 = new com.google.android.gms.common.GooglePlayServicesMissingManifestValueException
            r8.<init>()
            throw r8
        L_0x006c:
            r8 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x006c }
            throw r8
        L_0x006f:
            boolean r0 = com.google.android.gms.common.util.DeviceProperties.isWearableWithoutPlayStore(r8)
            r2 = 0
            if (r0 != 0) goto L_0x00a6
            java.lang.Boolean r0 = com.google.android.gms.common.util.DeviceProperties.zzg
            if (r0 != 0) goto L_0x009c
            android.content.pm.PackageManager r0 = r8.getPackageManager()
            java.lang.String r3 = "android.hardware.type.iot"
            boolean r0 = r0.hasSystemFeature(r3)
            if (r0 != 0) goto L_0x0095
            android.content.pm.PackageManager r0 = r8.getPackageManager()
            java.lang.String r3 = "android.hardware.type.embedded"
            boolean r0 = r0.hasSystemFeature(r3)
            if (r0 == 0) goto L_0x0093
            goto L_0x0095
        L_0x0093:
            r0 = 0
            goto L_0x0096
        L_0x0095:
            r0 = 1
        L_0x0096:
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
            com.google.android.gms.common.util.DeviceProperties.zzg = r0
        L_0x009c:
            java.lang.Boolean r0 = com.google.android.gms.common.util.DeviceProperties.zzg
            boolean r0 = r0.booleanValue()
            if (r0 != 0) goto L_0x00a6
            r0 = 1
            goto L_0x00a7
        L_0x00a6:
            r0 = 0
        L_0x00a7:
            if (r9 < 0) goto L_0x00ab
            r3 = 1
            goto L_0x00ac
        L_0x00ab:
            r3 = 0
        L_0x00ac:
            com.google.android.gms.common.internal.Preconditions.checkArgument(r3)
            java.lang.String r3 = r8.getPackageName()
            android.content.pm.PackageManager r4 = r8.getPackageManager()
            if (r0 == 0) goto L_0x00cc
            java.lang.String r5 = "com.android.vending"
            r6 = 8256(0x2040, float:1.1569E-41)
            android.content.pm.PackageInfo r5 = r4.getPackageInfo(r5, r6)     // Catch:{ NameNotFoundException -> 0x00c2 }
            goto L_0x00cd
        L_0x00c2:
            java.lang.String r8 = java.lang.String.valueOf(r3)
            java.lang.String r9 = " requires the Google Play Store, but it is missing."
            r8.concat(r9)
            goto L_0x0118
        L_0x00cc:
            r5 = 0
        L_0x00cd:
            java.lang.String r6 = "com.google.android.gms"
            r7 = 64
            android.content.pm.PackageInfo r6 = r4.getPackageInfo(r6, r7)     // Catch:{ NameNotFoundException -> 0x0150 }
            com.google.android.gms.common.GoogleSignatureVerifier.getInstance(r8)
            boolean r8 = com.google.android.gms.common.GoogleSignatureVerifier.zzb(r6, r1)
            if (r8 != 0) goto L_0x00e8
            java.lang.String r8 = java.lang.String.valueOf(r3)
            java.lang.String r9 = " requires Google Play services, but their signature is invalid."
            r8.concat(r9)
            goto L_0x0118
        L_0x00e8:
            if (r0 == 0) goto L_0x00fd
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r5)
            boolean r8 = com.google.android.gms.common.GoogleSignatureVerifier.zzb(r5, r1)
            if (r8 != 0) goto L_0x00fd
            java.lang.String r8 = java.lang.String.valueOf(r3)
            java.lang.String r9 = " requires Google Play Store, but its signature is invalid."
            r8.concat(r9)
            goto L_0x0118
        L_0x00fd:
            if (r0 == 0) goto L_0x011b
            if (r5 == 0) goto L_0x011b
            android.content.pm.Signature[] r8 = r5.signatures
            r8 = r8[r2]
            android.content.pm.Signature[] r0 = r6.signatures
            r0 = r0[r2]
            boolean r8 = r8.equals(r0)
            if (r8 != 0) goto L_0x011b
            java.lang.String r8 = java.lang.String.valueOf(r3)
            java.lang.String r9 = " requires Google Play Store, but its signature doesn't match that of Google Play services."
            r8.concat(r9)
        L_0x0118:
            r1 = 9
            goto L_0x0159
        L_0x011b:
            int r8 = r6.versionCode
            r0 = -1
            if (r8 != r0) goto L_0x0122
            r8 = -1
            goto L_0x0124
        L_0x0122:
            int r8 = r8 / 1000
        L_0x0124:
            if (r9 != r0) goto L_0x0127
            goto L_0x0129
        L_0x0127:
            int r0 = r9 / 1000
        L_0x0129:
            if (r8 >= r0) goto L_0x012d
            r1 = 2
            goto L_0x0159
        L_0x012d:
            android.content.pm.ApplicationInfo r8 = r6.applicationInfo
            if (r8 != 0) goto L_0x0149
            java.lang.String r8 = "com.google.android.gms"
            android.content.pm.ApplicationInfo r8 = r4.getApplicationInfo(r8, r2)     // Catch:{ NameNotFoundException -> 0x0138 }
            goto L_0x0149
        L_0x0138:
            r8 = move-exception
            java.lang.String r9 = "GooglePlayServicesUtil"
            java.lang.String r0 = java.lang.String.valueOf(r3)
            java.lang.String r2 = " requires Google Play services, but they're missing when getting application info."
            java.lang.String r0 = r0.concat(r2)
            android.util.Log.wtf(r9, r0, r8)
            goto L_0x0159
        L_0x0149:
            boolean r8 = r8.enabled
            if (r8 != 0) goto L_0x014f
            r1 = 3
            goto L_0x0159
        L_0x014f:
            return r2
        L_0x0150:
            java.lang.String r8 = java.lang.String.valueOf(r3)
            java.lang.String r9 = " requires Google Play services, but they are missing."
            r8.concat(r9)
        L_0x0159:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.GooglePlayServicesUtilLight.isGooglePlayServicesAvailable(android.content.Context, int):int");
    }
}
