package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.google.android.gms.common.internal.Preconditions;
import in.juspay.hypersdk.core.InflateView;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReference;
import okhttp3.HttpUrl;
import org.apache.fontbox.cmap.CMapParser;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@20.1.2 */
public final class zzet {
    public static final AtomicReference zza = new AtomicReference();
    public static final AtomicReference zzb = new AtomicReference();
    public static final AtomicReference zzc = new AtomicReference();
    public final zzes zzd;

    public zzet(zzes zzes) {
        this.zzd = zzes;
    }

    public static final String zzg(String str, String[] strArr, String[] strArr2, AtomicReference atomicReference) {
        String str2;
        Preconditions.checkNotNull(strArr);
        Preconditions.checkNotNull(strArr2);
        Preconditions.checkNotNull(atomicReference);
        Preconditions.checkArgument(strArr.length == strArr2.length);
        for (int i = 0; i < strArr.length; i++) {
            if (zzlp.zzal(str, strArr[i])) {
                synchronized (atomicReference) {
                    String[] strArr3 = (String[]) atomicReference.get();
                    if (strArr3 == null) {
                        strArr3 = new String[strArr2.length];
                        atomicReference.set(strArr3);
                    }
                    str2 = strArr3[i];
                    if (str2 == null) {
                        str2 = strArr2[i] + "(" + strArr[i] + ")";
                        strArr3[i] = str2;
                    }
                }
                return str2;
            }
        }
        return str;
    }

    public final String zza(Object[] objArr) {
        String str;
        if (objArr == null) {
            return HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
        }
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("[");
        for (Bundle bundle : objArr) {
            if (bundle instanceof Bundle) {
                str = zzb(bundle);
            } else {
                str = String.valueOf(bundle);
            }
            if (str != null) {
                if (outline73.length() != 1) {
                    outline73.append(", ");
                }
                outline73.append(str);
            }
        }
        outline73.append(CMapParser.MARK_END_OF_ARRAY);
        return outline73.toString();
    }

    public final String zzb(Bundle bundle) {
        String str;
        if (bundle == null) {
            return null;
        }
        if (!this.zzd.zza()) {
            return bundle.toString();
        }
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("Bundle[{");
        for (String str2 : bundle.keySet()) {
            if (outline73.length() != 8) {
                outline73.append(", ");
            }
            outline73.append(zze(str2));
            outline73.append(InflateView.SETTER_EQUALS);
            Object obj = bundle.get(str2);
            if (obj instanceof Bundle) {
                str = zza(new Object[]{obj});
            } else if (obj instanceof Object[]) {
                str = zza((Object[]) obj);
            } else if (obj instanceof ArrayList) {
                str = zza(((ArrayList) obj).toArray());
            } else {
                str = String.valueOf(obj);
            }
            outline73.append(str);
        }
        outline73.append("}]");
        return outline73.toString();
    }

    public final String zzc(zzav zzav) {
        String str;
        if (!this.zzd.zza()) {
            return zzav.toString();
        }
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("origin=");
        outline73.append(zzav.zzc);
        outline73.append(",name=");
        outline73.append(zzd(zzav.zza));
        outline73.append(",params=");
        zzat zzat = zzav.zzb;
        if (zzat == null) {
            str = null;
        } else if (!this.zzd.zza()) {
            str = zzat.toString();
        } else {
            str = zzb(zzat.zzc());
        }
        outline73.append(str);
        return outline73.toString();
    }

    public final String zzd(String str) {
        if (str == null) {
            return null;
        }
        if (!this.zzd.zza()) {
            return str;
        }
        return zzg(str, zzhf.zzc, zzhf.zza, zza);
    }

    public final String zze(String str) {
        if (str == null) {
            return null;
        }
        if (!this.zzd.zza()) {
            return str;
        }
        return zzg(str, zzhg.zzb, zzhg.zza, zzb);
    }

    public final String zzf(String str) {
        if (str == null) {
            return null;
        }
        if (!this.zzd.zza()) {
            return str;
        }
        if (str.startsWith("_exp_")) {
            return GeneratedOutlineSupport.outline52("experiment_id(", str, ")");
        }
        return zzg(str, zzhh.zzb, zzhh.zza, zzc);
    }
}
