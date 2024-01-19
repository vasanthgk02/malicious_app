package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.os.StrictMode;
import android.os.StrictMode.ThreadPolicy;
import androidx.collection.ArrayMap;
import java.util.Iterator;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@20.1.2 */
public final class zzhz implements zzhj {
    public static final Map zza = new ArrayMap();
    public final SharedPreferences zzb;
    public final OnSharedPreferenceChangeListener zzc;

    public static zzhz zza(Context context, String str) {
        zzhz zzhz;
        if (!zzha.zza()) {
            synchronized (zzhz.class) {
                zzhz = (zzhz) zza.get(null);
                if (zzhz == null) {
                    ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
                    try {
                        throw null;
                    } catch (Throwable th) {
                        StrictMode.setThreadPolicy(allowThreadDiskReads);
                        throw th;
                    }
                }
            }
            return zzhz;
        }
        throw null;
    }

    public static synchronized void zzc() {
        synchronized (zzhz.class) {
            Iterator it = zza.values().iterator();
            if (!it.hasNext()) {
                zza.clear();
            } else {
                SharedPreferences sharedPreferences = ((zzhz) it.next()).zzb;
                throw null;
            }
        }
    }

    public final Object zzb(String str) {
        throw null;
    }
}
