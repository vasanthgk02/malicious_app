package com.google.android.gms.dynamite;

import android.content.Context;
import com.google.android.gms.dynamite.DynamiteModule.LoadingException;
import com.google.android.gms.dynamite.DynamiteModule.VersionPolicy;
import com.google.android.gms.dynamite.DynamiteModule.VersionPolicy.IVersions;
import com.google.android.gms.dynamite.DynamiteModule.VersionPolicy.SelectionResult;

/* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
public final class zzj implements VersionPolicy {
    public final SelectionResult selectModule(Context context, String str, IVersions iVersions) throws LoadingException {
        int i;
        SelectionResult selectionResult = new SelectionResult();
        int zza = iVersions.zza(context, str);
        selectionResult.localVersion = zza;
        int i2 = 0;
        if (zza != 0) {
            i = iVersions.zzb(context, str, false);
            selectionResult.remoteVersion = i;
        } else {
            i = iVersions.zzb(context, str, true);
            selectionResult.remoteVersion = i;
        }
        int i3 = selectionResult.localVersion;
        if (i3 != 0) {
            i2 = i3;
        } else if (i == 0) {
            selectionResult.selection = 0;
            return selectionResult;
        }
        if (i2 >= i) {
            selectionResult.selection = -1;
        } else {
            selectionResult.selection = 1;
        }
        return selectionResult;
    }
}
