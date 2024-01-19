package com.google.android.gms.internal.auth;

import android.net.Uri;
import androidx.collection.ArrayMap;

/* compiled from: com.google.android.gms:play-services-auth-base@@17.1.4 */
public final class zzcq {
    public static final ArrayMap<String, Uri> zza = new ArrayMap<>();

    public static synchronized Uri zza(String str) {
        Uri uri;
        String str2;
        synchronized (zzcq.class) {
            uri = (Uri) zza.getOrDefault("com.google.android.gms.auth_account", null);
            if (uri == null) {
                String valueOf = String.valueOf(Uri.encode("com.google.android.gms.auth_account"));
                if (valueOf.length() != 0) {
                    str2 = "content://com.google.android.gms.phenotype/".concat(valueOf);
                } else {
                    str2 = new String("content://com.google.android.gms.phenotype/");
                }
                uri = Uri.parse(str2);
                zza.put("com.google.android.gms.auth_account", uri);
            }
        }
        return uri;
    }
}
