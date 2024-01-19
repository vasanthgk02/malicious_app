package com.google.android.gms.internal.measurement;

import android.net.Uri;
import androidx.collection.ArrayMap;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@20.1.2 */
public final class zzho {
    public static final ArrayMap zza = new ArrayMap();

    public static synchronized Uri zza(String str) {
        synchronized (zzho.class) {
            Uri uri = (Uri) zza.getOrDefault("com.google.android.gms.measurement", null);
            if (uri != null) {
                return uri;
            }
            Uri parse = Uri.parse("content://com.google.android.gms.phenotype/".concat(String.valueOf(Uri.encode("com.google.android.gms.measurement"))));
            zza.put("com.google.android.gms.measurement", parse);
            return parse;
        }
    }
}
