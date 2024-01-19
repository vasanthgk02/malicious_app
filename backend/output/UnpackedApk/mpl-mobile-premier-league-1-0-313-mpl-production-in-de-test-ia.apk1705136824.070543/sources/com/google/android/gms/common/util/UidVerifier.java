package com.google.android.gms.common.util;

import android.annotation.TargetApi;
import android.app.AppOpsManager;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.util.Log;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.GoogleSignatureVerifier;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.wrappers.PackageManagerWrapper;
import com.google.android.gms.common.wrappers.Wrappers;

@KeepForSdk
/* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
public final class UidVerifier {
    @KeepForSdk
    public static boolean isGooglePlayServicesUid(Context context, int i) {
        boolean z = false;
        if (!uidHasPackageName(context, i, "com.google.android.gms")) {
            return false;
        }
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo("com.google.android.gms", 64);
            GoogleSignatureVerifier instance = GoogleSignatureVerifier.getInstance(context);
            if (instance != null) {
                if (packageInfo != null && (GoogleSignatureVerifier.zzb(packageInfo, false) || (GoogleSignatureVerifier.zzb(packageInfo, true) && GooglePlayServicesUtilLight.honorsDebugCertificates(instance.zzc)))) {
                    z = true;
                }
                return z;
            }
            throw null;
        } catch (NameNotFoundException unused) {
            boolean isLoggable = Log.isLoggable("UidVerifier", 3);
            return false;
        }
    }

    @TargetApi(19)
    @KeepForSdk
    public static boolean uidHasPackageName(Context context, int i, String str) {
        PackageManagerWrapper packageManager = Wrappers.packageManager(context);
        if (packageManager != null) {
            try {
                AppOpsManager appOpsManager = (AppOpsManager) packageManager.zza.getSystemService("appops");
                if (appOpsManager != null) {
                    appOpsManager.checkPackage(i, str);
                    return true;
                }
                throw new NullPointerException("context.getSystemService(Context.APP_OPS_SERVICE) is null");
            } catch (SecurityException unused) {
                return false;
            }
        } else {
            throw null;
        }
    }
}
