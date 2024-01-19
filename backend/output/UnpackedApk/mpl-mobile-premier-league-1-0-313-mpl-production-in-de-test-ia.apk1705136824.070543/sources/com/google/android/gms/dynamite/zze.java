package com.google.android.gms.dynamite;

import android.content.Context;
import com.google.android.gms.dynamite.DynamiteModule.LoadingException;
import com.google.android.gms.dynamite.DynamiteModule.VersionPolicy.IVersions;

/* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
public final class zze implements IVersions {
    public final int zza(Context context, String str) {
        return DynamiteModule.getLocalVersion(context, str);
    }

    public final int zzb(Context context, String str, boolean z) throws LoadingException {
        return DynamiteModule.zza(context, str, z);
    }
}
