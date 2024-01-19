package com.google.android.gms.internal.auth;

import android.net.Uri;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-auth-base@@17.1.4 */
public final class zzco {
    public final Map<String, Map<String, String>> zza;

    public zzco(Map<String, Map<String, String>> map) {
        this.zza = map;
    }

    public final String zza(Uri uri, String str, String str2, String str3) {
        String str4;
        if (uri == null) {
            return null;
        }
        Map map = this.zza.get(uri.toString());
        if (map == null) {
            return null;
        }
        String valueOf = String.valueOf(str3);
        if (valueOf.length() != 0) {
            str4 = "".concat(valueOf);
        } else {
            str4 = new String("");
        }
        return (String) map.get(str4);
    }
}
