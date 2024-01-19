package com.google.android.gms.common.wrappers;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Binder;
import android.os.Process;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.util.PlatformVersion;

@KeepForSdk
/* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
public class PackageManagerWrapper {
    public final Context zza;

    public PackageManagerWrapper(Context context) {
        this.zza = context;
    }

    @KeepForSdk
    public ApplicationInfo getApplicationInfo(String str, int i) throws NameNotFoundException {
        return this.zza.getPackageManager().getApplicationInfo(str, i);
    }

    @KeepForSdk
    public PackageInfo getPackageInfo(String str, int i) throws NameNotFoundException {
        return this.zza.getPackageManager().getPackageInfo(str, i);
    }

    @KeepForSdk
    public boolean isCallerInstantApp() {
        if (Binder.getCallingUid() == Process.myUid()) {
            return InstantApps.isInstantApp(this.zza);
        }
        if (PlatformVersion.isAtLeastO()) {
            String nameForUid = this.zza.getPackageManager().getNameForUid(Binder.getCallingUid());
            if (nameForUid != null) {
                return this.zza.getPackageManager().isInstantApp(nameForUid);
            }
        }
        return false;
    }
}
