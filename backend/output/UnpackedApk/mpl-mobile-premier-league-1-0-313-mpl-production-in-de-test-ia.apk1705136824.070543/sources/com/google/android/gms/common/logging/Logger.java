package com.google.android.gms.common.logging;

import android.util.Log;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.GmsLogger;
import java.util.Locale;

@KeepForSdk
/* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
public class Logger {
    public final String zza;
    public final String zzb;
    public final int zzd;

    @KeepForSdk
    public Logger(String str, String... strArr) {
        String str2;
        if (r0 == 0) {
            str2 = "";
        } else {
            StringBuilder outline72 = GeneratedOutlineSupport.outline72('[');
            for (String str3 : strArr) {
                if (outline72.length() > 1) {
                    outline72.append(",");
                }
                outline72.append(str3);
            }
            outline72.append("] ");
            str2 = outline72.toString();
        }
        this.zzb = str2;
        this.zza = str;
        new GmsLogger(str, null);
        int i = 2;
        while (i <= 7 && !Log.isLoggable(this.zza, i)) {
            i++;
        }
        this.zzd = i;
    }

    @KeepForSdk
    public void d(String str, Object... objArr) {
        if (this.zzd <= 3) {
            format(str, objArr);
        }
    }

    @KeepForSdk
    public String format(String str, Object... objArr) {
        if (objArr != null && objArr.length > 0) {
            str = String.format(Locale.US, str, objArr);
        }
        return this.zzb.concat(str);
    }
}
