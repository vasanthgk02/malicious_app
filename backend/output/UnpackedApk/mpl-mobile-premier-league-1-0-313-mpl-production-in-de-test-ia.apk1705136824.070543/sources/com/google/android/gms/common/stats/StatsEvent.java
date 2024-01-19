package com.google.android.gms.common.stats;

import android.text.TextUtils;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.smartfoxserver.bitswarm.util.Logging;
import java.util.List;

@KeepForSdk
@Deprecated
/* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
public abstract class StatsEvent extends AbstractSafeParcelable implements ReflectedParcelable {

    @KeepForSdk
    /* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
    public interface Types {
    }

    public final String toString() {
        String str;
        WakeLockEvent wakeLockEvent = (WakeLockEvent) this;
        long j = wakeLockEvent.zzb;
        int i = wakeLockEvent.zzc;
        long j2 = wakeLockEvent.zzp;
        List list = wakeLockEvent.zzh;
        String str2 = wakeLockEvent.zzd;
        int i2 = wakeLockEvent.zzg;
        String str3 = "";
        if (list == null) {
            str = str3;
        } else {
            str = TextUtils.join(",", list);
        }
        int i3 = wakeLockEvent.zzk;
        String str4 = wakeLockEvent.zze;
        if (str4 == null) {
            str4 = str3;
        }
        String str5 = wakeLockEvent.zzl;
        if (str5 == null) {
            str5 = str3;
        }
        float f2 = wakeLockEvent.zzm;
        String str6 = wakeLockEvent.zzf;
        if (str6 != null) {
            str3 = str6;
        }
        boolean z = wakeLockEvent.zzo;
        StringBuilder sb = new StringBuilder();
        sb.append(Logging.TAB);
        sb.append(str2);
        sb.append(Logging.TAB);
        sb.append(i2);
        sb.append(Logging.TAB);
        sb.append(str);
        sb.append(Logging.TAB);
        sb.append(i3);
        sb.append(Logging.TAB);
        GeneratedOutlineSupport.outline103(sb, str4, Logging.TAB, str5, Logging.TAB);
        sb.append(f2);
        sb.append(Logging.TAB);
        sb.append(str3);
        sb.append(Logging.TAB);
        sb.append(z);
        String sb2 = sb.toString();
        StringBuilder sb3 = new StringBuilder();
        sb3.append(j);
        sb3.append(Logging.TAB);
        sb3.append(i);
        sb3.append(Logging.TAB);
        return GeneratedOutlineSupport.outline58(sb3, j2, sb2);
    }
}
