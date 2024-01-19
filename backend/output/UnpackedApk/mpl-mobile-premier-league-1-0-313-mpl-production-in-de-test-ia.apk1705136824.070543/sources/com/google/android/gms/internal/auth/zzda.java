package com.google.android.gms.internal.auth;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.os.StrictMode;
import android.os.StrictMode.ThreadPolicy;
import androidx.collection.ArrayMap;
import java.util.Iterator;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-auth-base@@17.1.4 */
public final class zzda implements zzck {
    public static final Map<String, zzda> zza = new ArrayMap();
    public final SharedPreferences zzb;
    public final OnSharedPreferenceChangeListener zzc;

    public static zzda zza(Context context, String str) {
        zzda zzda;
        if (!zzcc.zza()) {
            synchronized (zzda.class) {
                zzda = zza.get(null);
                if (zzda == null) {
                    ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
                    try {
                        throw null;
                    } catch (Throwable th) {
                        StrictMode.setThreadPolicy(allowThreadDiskReads);
                        throw th;
                    }
                }
            }
            return zzda;
        }
        throw null;
    }

    public static synchronized void zzc() {
        synchronized (zzda.class) {
            Iterator<zzda> it = zza.values().iterator();
            if (!it.hasNext()) {
                zza.clear();
            } else {
                SharedPreferences sharedPreferences = it.next().zzb;
                throw null;
            }
        }
    }

    public final Object zzb(String str) {
        throw null;
    }
}
