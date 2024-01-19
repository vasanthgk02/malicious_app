package com.google.android.gms.common;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.errorprone.annotations.RestrictedInheritance;

@RestrictedInheritance(allowedOnPath = ".*java.*/com/google/android/gms/common/testing/.*", explanation = "Sub classing of GMS Core's APIs are restricted to testing fakes.", link = "go/gmscore-restrictedinheritance")
@ShowFirstParty
@KeepForSdk
/* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
public class GoogleSignatureVerifier {
    public static GoogleSignatureVerifier zza;
    public final Context zzc;
    public volatile String zzd;

    public GoogleSignatureVerifier(Context context) {
        this.zzc = context.getApplicationContext();
    }

    @KeepForSdk
    public static GoogleSignatureVerifier getInstance(Context context) {
        Preconditions.checkNotNull(context);
        synchronized (GoogleSignatureVerifier.class) {
            try {
                if (zza == null) {
                    zzn.zze(context);
                    zza = new GoogleSignatureVerifier(context);
                }
            }
        }
        return zza;
    }

    public static final zzj zza(PackageInfo packageInfo, zzj... zzjArr) {
        Signature[] signatureArr = packageInfo.signatures;
        if (signatureArr == null || signatureArr.length != 1) {
            return null;
        }
        zzk zzk = new zzk(packageInfo.signatures[0].toByteArray());
        for (int i = 0; i < zzjArr.length; i++) {
            if (zzjArr[i].equals(zzk)) {
                return zzjArr[i];
            }
        }
        return null;
    }

    public static final boolean zzb(PackageInfo packageInfo, boolean z) {
        zzj zzj;
        if (z && packageInfo != null && ("com.android.vending".equals(packageInfo.packageName) || "com.google.android.gms".equals(packageInfo.packageName))) {
            ApplicationInfo applicationInfo = packageInfo.applicationInfo;
            if (applicationInfo == null || (applicationInfo.flags & 129) == 0) {
                z = false;
            } else {
                z = true;
            }
        }
        if (!(packageInfo == null || packageInfo.signatures == null)) {
            if (z) {
                zzj = zza(packageInfo, zzm.zza);
            } else {
                zzj = zza(packageInfo, zzm.zza[0]);
            }
            if (zzj != null) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: finally extract failed */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x0163  */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x0167  */
    @com.google.android.gms.common.internal.ShowFirstParty
    @com.google.android.gms.common.annotation.KeepForSdk
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean isUidGoogleSigned(int r15) {
        /*
            r14 = this;
            android.content.Context r0 = r14.zzc
            android.content.pm.PackageManager r0 = r0.getPackageManager()
            java.lang.String[] r15 = r0.getPackagesForUid(r15)
            if (r15 == 0) goto L_0x014c
            int r0 = r15.length
            if (r0 != 0) goto L_0x0011
            goto L_0x014c
        L_0x0011:
            r1 = 0
            r2 = 0
            r4 = r2
            r3 = 0
        L_0x0015:
            if (r3 >= r0) goto L_0x0148
            r4 = r15[r3]
            java.lang.String r5 = "null pkg"
            if (r4 != 0) goto L_0x0023
            com.google.android.gms.common.zzx r4 = com.google.android.gms.common.zzx.zzc(r5)
            goto L_0x013f
        L_0x0023:
            java.lang.String r6 = r14.zzd
            boolean r6 = r4.equals(r6)
            if (r6 != 0) goto L_0x013d
            boolean r6 = com.google.android.gms.common.zzn.zzg()
            r11 = 1
            if (r6 == 0) goto L_0x00b8
            android.content.Context r5 = r14.zzc
            boolean r7 = com.google.android.gms.common.GooglePlayServicesUtilLight.honorsDebugCertificates(r5)
            android.os.StrictMode$ThreadPolicy r12 = android.os.StrictMode.allowThreadDiskReads()
            android.content.Context r5 = com.google.android.gms.common.zzn.zzg     // Catch:{ all -> 0x00b3 }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r5)     // Catch:{ all -> 0x00b3 }
            com.google.android.gms.common.zzn.zzj()     // Catch:{ LoadingException -> 0x009b }
            com.google.android.gms.common.zzo r13 = new com.google.android.gms.common.zzo     // Catch:{ all -> 0x00b3 }
            r8 = 0
            android.content.Context r5 = com.google.android.gms.common.zzn.zzg     // Catch:{ all -> 0x00b3 }
            com.google.android.gms.dynamic.ObjectWrapper r9 = new com.google.android.gms.dynamic.ObjectWrapper     // Catch:{ all -> 0x00b3 }
            r9.<init>(r5)     // Catch:{ all -> 0x00b3 }
            r10 = 0
            r5 = r13
            r6 = r4
            r5.<init>(r6, r7, r8, r9, r10)     // Catch:{ all -> 0x00b3 }
            com.google.android.gms.common.internal.zzaf r5 = com.google.android.gms.common.zzn.zze     // Catch:{ RemoteException -> 0x0093 }
            com.google.android.gms.common.zzq r5 = r5.zze(r13)     // Catch:{ RemoteException -> 0x0093 }
            boolean r6 = r5.zza     // Catch:{ all -> 0x00b3 }
            if (r6 == 0) goto L_0x006a
            int r5 = r5.zzd     // Catch:{ all -> 0x00b3 }
            int r5 = com.facebook.drawee.backends.pipeline.info.ImageOriginUtils.zza1(r5)     // Catch:{ all -> 0x00b3 }
            com.google.android.gms.common.zzx r6 = new com.google.android.gms.common.zzx     // Catch:{ all -> 0x00b3 }
            r6.<init>(r11, r5, r2, r2)     // Catch:{ all -> 0x00b3 }
            goto L_0x00ae
        L_0x006a:
            java.lang.String r6 = r5.zzb     // Catch:{ all -> 0x00b3 }
            int r7 = r5.zzc     // Catch:{ all -> 0x00b3 }
            int r7 = com.facebook.drawee.backends.pipeline.info.ImageOriginUtils.zza2(r7)     // Catch:{ all -> 0x00b3 }
            r8 = 4
            if (r7 != r8) goto L_0x007b
            android.content.pm.PackageManager$NameNotFoundException r7 = new android.content.pm.PackageManager$NameNotFoundException     // Catch:{ all -> 0x00b3 }
            r7.<init>()     // Catch:{ all -> 0x00b3 }
            goto L_0x007c
        L_0x007b:
            r7 = r2
        L_0x007c:
            java.lang.String r8 = "error checking package certificate"
            if (r6 != 0) goto L_0x0081
            r6 = r8
        L_0x0081:
            int r8 = r5.zzd     // Catch:{ all -> 0x00b3 }
            int r8 = com.facebook.drawee.backends.pipeline.info.ImageOriginUtils.zza1(r8)     // Catch:{ all -> 0x00b3 }
            int r5 = r5.zzc     // Catch:{ all -> 0x00b3 }
            com.facebook.drawee.backends.pipeline.info.ImageOriginUtils.zza2(r5)     // Catch:{ all -> 0x00b3 }
            com.google.android.gms.common.zzx r5 = new com.google.android.gms.common.zzx     // Catch:{ all -> 0x00b3 }
            r5.<init>(r1, r8, r6, r7)     // Catch:{ all -> 0x00b3 }
            r6 = r5
            goto L_0x00ae
        L_0x0093:
            r5 = move-exception
            java.lang.String r6 = "module call"
            com.google.android.gms.common.zzx r6 = com.google.android.gms.common.zzx.zzd(r6, r5)     // Catch:{ all -> 0x00b3 }
            goto L_0x00ae
        L_0x009b:
            r5 = move-exception
            java.lang.String r6 = "module init: "
            java.lang.String r7 = r5.getMessage()     // Catch:{ all -> 0x00b3 }
            java.lang.String r7 = java.lang.String.valueOf(r7)     // Catch:{ all -> 0x00b3 }
            java.lang.String r6 = r6.concat(r7)     // Catch:{ all -> 0x00b3 }
            com.google.android.gms.common.zzx r6 = com.google.android.gms.common.zzx.zzd(r6, r5)     // Catch:{ all -> 0x00b3 }
        L_0x00ae:
            android.os.StrictMode.setThreadPolicy(r12)
            goto L_0x0129
        L_0x00b3:
            r15 = move-exception
            android.os.StrictMode.setThreadPolicy(r12)
            throw r15
        L_0x00b8:
            android.content.Context r6 = r14.zzc     // Catch:{ NameNotFoundException -> 0x0131 }
            android.content.pm.PackageManager r6 = r6.getPackageManager()     // Catch:{ NameNotFoundException -> 0x0131 }
            r7 = 64
            android.content.pm.PackageInfo r6 = r6.getPackageInfo(r4, r7)     // Catch:{ NameNotFoundException -> 0x0131 }
            android.content.Context r7 = r14.zzc
            boolean r7 = com.google.android.gms.common.GooglePlayServicesUtilLight.honorsDebugCertificates(r7)
            if (r6 != 0) goto L_0x00d1
            com.google.android.gms.common.zzx r6 = com.google.android.gms.common.zzx.zzc(r5)
            goto L_0x0129
        L_0x00d1:
            android.content.pm.Signature[] r5 = r6.signatures
            if (r5 == 0) goto L_0x0123
            int r5 = r5.length
            if (r5 == r11) goto L_0x00d9
            goto L_0x0123
        L_0x00d9:
            com.google.android.gms.common.zzk r5 = new com.google.android.gms.common.zzk
            android.content.pm.Signature[] r8 = r6.signatures
            r8 = r8[r1]
            byte[] r8 = r8.toByteArray()
            r5.<init>(r8)
            java.lang.String r8 = r6.packageName
            android.os.StrictMode$ThreadPolicy r9 = android.os.StrictMode.allowThreadDiskReads()
            com.google.android.gms.common.zzx r7 = com.google.android.gms.common.zzn.zzh(r8, r5, r7, r1)     // Catch:{ all -> 0x011e }
            android.os.StrictMode.setThreadPolicy(r9)
            boolean r9 = r7.zza
            if (r9 == 0) goto L_0x011c
            android.content.pm.ApplicationInfo r6 = r6.applicationInfo
            if (r6 == 0) goto L_0x011c
            int r6 = r6.flags
            r6 = r6 & 2
            if (r6 == 0) goto L_0x011c
            android.os.StrictMode$ThreadPolicy r6 = android.os.StrictMode.allowThreadDiskReads()
            com.google.android.gms.common.zzx r5 = com.google.android.gms.common.zzn.zzh(r8, r5, r1, r11)     // Catch:{ all -> 0x0117 }
            android.os.StrictMode.setThreadPolicy(r6)
            boolean r5 = r5.zza
            if (r5 == 0) goto L_0x011c
            java.lang.String r5 = "debuggable release cert app rejected"
            com.google.android.gms.common.zzx r6 = com.google.android.gms.common.zzx.zzc(r5)
            goto L_0x0129
        L_0x0117:
            r15 = move-exception
            android.os.StrictMode.setThreadPolicy(r6)
            throw r15
        L_0x011c:
            r6 = r7
            goto L_0x0129
        L_0x011e:
            r15 = move-exception
            android.os.StrictMode.setThreadPolicy(r9)
            throw r15
        L_0x0123:
            java.lang.String r5 = "single cert required"
            com.google.android.gms.common.zzx r6 = com.google.android.gms.common.zzx.zzc(r5)
        L_0x0129:
            boolean r5 = r6.zza
            if (r5 == 0) goto L_0x012f
            r14.zzd = r4
        L_0x012f:
            r4 = r6
            goto L_0x013f
        L_0x0131:
            r5 = move-exception
            java.lang.String r6 = "no pkg "
            java.lang.String r4 = r6.concat(r4)
            com.google.android.gms.common.zzx r4 = com.google.android.gms.common.zzx.zzd(r4, r5)
            goto L_0x013f
        L_0x013d:
            com.google.android.gms.common.zzx r4 = com.google.android.gms.common.zzx.zze
        L_0x013f:
            boolean r5 = r4.zza
            if (r5 == 0) goto L_0x0144
            goto L_0x0152
        L_0x0144:
            int r3 = r3 + 1
            goto L_0x0015
        L_0x0148:
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r4)
            goto L_0x0152
        L_0x014c:
            java.lang.String r15 = "no pkgs"
            com.google.android.gms.common.zzx r4 = com.google.android.gms.common.zzx.zzc(r15)
        L_0x0152:
            boolean r15 = r4.zza
            if (r15 != 0) goto L_0x016a
            r15 = 3
            java.lang.String r0 = "GoogleCertificatesRslt"
            boolean r15 = android.util.Log.isLoggable(r0, r15)
            if (r15 == 0) goto L_0x016a
            java.lang.Throwable r15 = r4.zzc
            if (r15 == 0) goto L_0x0167
            r4.zza()
            goto L_0x016a
        L_0x0167:
            r4.zza()
        L_0x016a:
            boolean r15 = r4.zza
            return r15
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.GoogleSignatureVerifier.isUidGoogleSigned(int):boolean");
    }
}
