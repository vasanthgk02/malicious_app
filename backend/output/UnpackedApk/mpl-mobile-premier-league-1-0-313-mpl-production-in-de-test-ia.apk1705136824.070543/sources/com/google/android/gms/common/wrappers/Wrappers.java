package com.google.android.gms.common.wrappers;

import android.content.Context;
import com.google.android.gms.common.annotation.KeepForSdk;

@KeepForSdk
/* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
public class Wrappers {
    public static Wrappers zza = new Wrappers();
    public PackageManagerWrapper zzb = null;

    @KeepForSdk
    public static PackageManagerWrapper packageManager(Context context) {
        PackageManagerWrapper packageManagerWrapper;
        Wrappers wrappers = zza;
        synchronized (wrappers) {
            try {
                if (wrappers.zzb == null) {
                    if (context.getApplicationContext() != null) {
                        context = context.getApplicationContext();
                    }
                    wrappers.zzb = new PackageManagerWrapper(context);
                }
                packageManagerWrapper = wrappers.zzb;
            }
        }
        return packageManagerWrapper;
    }
}
