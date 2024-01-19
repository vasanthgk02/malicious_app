package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.common.wrappers.PackageManagerWrapper;
import com.google.android.gms.common.wrappers.Wrappers;

/* compiled from: com.google.android.gms:play-services-measurement@@20.1.2 */
public final class zzfq {
    public final zzgi zza;

    public zzfq(zzli zzli) {
        this.zza = zzli.zzn;
    }

    @VisibleForTesting
    public final boolean zza() {
        boolean z = false;
        try {
            PackageManagerWrapper packageManager = Wrappers.packageManager(this.zza.zze);
            if (packageManager == null) {
                this.zza.zzaz().zzl.zza("Failed to get PackageManager for Install Referrer Play Store compatibility check");
                return false;
            }
            if (packageManager.zza.getPackageManager().getPackageInfo("com.android.vending", 128).versionCode >= 80837300) {
                z = true;
            }
            return z;
        } catch (Exception e2) {
            this.zza.zzaz().zzl.zzb("Failed to retrieve Play Store version for Install Referrer", e2);
            return false;
        }
    }
}
