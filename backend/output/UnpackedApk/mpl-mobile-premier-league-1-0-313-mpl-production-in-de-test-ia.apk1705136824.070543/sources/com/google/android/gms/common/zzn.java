package com.google.android.gms.common;

import android.content.Context;
import android.os.RemoteException;
import android.os.StrictMode;
import android.os.StrictMode.ThreadPolicy;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.zzae;
import com.google.android.gms.common.internal.zzaf;
import com.google.android.gms.common.util.AndroidUtilsLight;
import com.google.android.gms.common.util.Hex;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.DynamiteModule.LoadingException;
import java.security.MessageDigest;

/* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
public final class zzn {
    public static final zzl zza = new zzf(zzj.zze("0\u0005È0\u0003° \u0003\u0002\u0001\u0002\u0002\u0014\u0010e\bsù/Qí"));
    public static final zzl zzb = new zzg(zzj.zze("0\u0006\u00040\u0003ì \u0003\u0002\u0001\u0002\u0002\u0014\u0003£²­×árÊkì"));
    public static final zzl zzc = new zzh(zzj.zze("0\u0004C0\u0003+ \u0003\u0002\u0001\u0002\u0002\t\u0000ÂàFdJ00"));
    public static final zzl zzd = new zzi(zzj.zze("0\u0004¨0\u0003 \u0003\u0002\u0001\u0002\u0002\t\u0000Õ¸l}ÓNõ0"));
    public static volatile zzaf zze;
    public static final Object zzf = new Object();
    public static Context zzg;

    public static String zzd(boolean z, String str, zzj zzj) throws Exception {
        Object[] objArr = new Object[5];
        objArr[0] = true != (!z && zzh(str, zzj, true, false).zza) ? "not allowed" : "debug cert rejected";
        objArr[1] = str;
        MessageDigest zza2 = AndroidUtilsLight.zza("SHA-256");
        Preconditions.checkNotNull(zza2);
        byte[] digest = zza2.digest(zzj.zzf());
        int length = digest.length;
        char[] cArr = new char[(length + length)];
        int i = 0;
        for (byte b2 : digest) {
            byte b3 = b2 & 255;
            int i2 = i + 1;
            char[] cArr2 = Hex.zzb;
            cArr[i] = cArr2[b3 >>> 4];
            i = i2 + 1;
            cArr[i2] = cArr2[b3 & 15];
        }
        objArr[2] = new String(cArr);
        objArr[3] = Boolean.valueOf(z);
        objArr[4] = "12451000.false";
        return String.format("%s: pkg=%s, sha256=%s, atk=%s, ver=%s", objArr);
    }

    public static synchronized void zze(Context context) {
        synchronized (zzn.class) {
            if (zzg == null) {
                zzg = context.getApplicationContext();
            }
        }
    }

    /* JADX INFO: finally extract failed */
    public static boolean zzg() {
        ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            zzj();
            boolean zzi = zze.zzi();
            StrictMode.setThreadPolicy(allowThreadDiskReads);
            return zzi;
        } catch (RemoteException | LoadingException unused) {
            StrictMode.setThreadPolicy(allowThreadDiskReads);
            return false;
        } catch (Throwable th) {
            StrictMode.setThreadPolicy(allowThreadDiskReads);
            throw th;
        }
    }

    public static zzx zzh(String str, zzj zzj, boolean z, boolean z2) {
        try {
            zzj();
            Preconditions.checkNotNull(zzg);
            try {
                if (zze.zzh(new zzs(str, zzj, z, z2), new ObjectWrapper(zzg.getPackageManager()))) {
                    return zzx.zze;
                }
                return new zzv(new zze(z, str, zzj));
            } catch (RemoteException e2) {
                return zzx.zzd("module call", e2);
            }
        } catch (LoadingException e3) {
            return zzx.zzd("module init: ".concat(String.valueOf(e3.getMessage())), e3);
        }
    }

    public static void zzj() throws LoadingException {
        if (zze == null) {
            Preconditions.checkNotNull(zzg);
            synchronized (zzf) {
                if (zze == null) {
                    zze = zzae.zzb(DynamiteModule.load(zzg, DynamiteModule.PREFER_HIGHEST_OR_LOCAL_VERSION_NO_FORCE_STAGING, "com.google.android.gms.googlecertificates").instantiate("com.google.android.gms.common.GoogleCertificatesImpl"));
                }
            }
        }
    }
}
