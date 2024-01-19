package com.google.android.gms.measurement.internal;

import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.xiaomi.mipush.sdk.Constants;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@20.1.2 */
public final class zzey extends zzhc {
    public char zza = 0;
    public long zzb = -1;
    public String zzc;
    public final zzew zzd = new zzew(this, 6, false, false);
    public final zzew zze = new zzew(this, 6, true, false);
    public final zzew zzf = new zzew(this, 6, false, true);
    public final zzew zzg = new zzew(this, 5, false, false);
    public final zzew zzh = new zzew(this, 5, true, false);
    public final zzew zzi = new zzew(this, 5, false, true);
    public final zzew zzj = new zzew(this, 4, false, false);
    public final zzew zzk = new zzew(this, 3, false, false);
    public final zzew zzl = new zzew(this, 2, false, false);

    public zzey(zzgi zzgi) {
        super(zzgi);
    }

    public static Object zzn(String str) {
        if (str == null) {
            return null;
        }
        return new zzex(str);
    }

    public static String zzo(boolean z, String str, Object obj, Object obj2, Object obj3) {
        String str2 = "";
        if (str == null) {
            str = str2;
        }
        String zzp = zzp(z, obj);
        String zzp2 = zzp(z, obj2);
        String zzp3 = zzp(z, obj3);
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(str)) {
            sb.append(str);
            str2 = ": ";
        }
        String str3 = ", ";
        if (!TextUtils.isEmpty(zzp)) {
            sb.append(str2);
            sb.append(zzp);
            str2 = str3;
        }
        if (!TextUtils.isEmpty(zzp2)) {
            sb.append(str2);
            sb.append(zzp2);
        } else {
            str3 = str2;
        }
        if (!TextUtils.isEmpty(zzp3)) {
            sb.append(str3);
            sb.append(zzp3);
        }
        return sb.toString();
    }

    @VisibleForTesting
    public static String zzp(boolean z, Object obj) {
        String str = "";
        if (obj == null) {
            return str;
        }
        if (obj instanceof Integer) {
            obj = Long.valueOf((long) ((Integer) obj).intValue());
        }
        int i = 0;
        if (obj instanceof Long) {
            if (!z) {
                return obj.toString();
            }
            Long l = (Long) obj;
            if (Math.abs(l.longValue()) < 100) {
                return obj.toString();
            }
            if (obj.toString().charAt(0) == '-') {
                str = Constants.ACCEPT_TIME_SEPARATOR_SERVER;
            }
            String valueOf = String.valueOf(Math.abs(l.longValue()));
            long round = Math.round(Math.pow(10.0d, (double) (valueOf.length() - 1)));
            long round2 = Math.round(Math.pow(10.0d, (double) valueOf.length()) - 4.0d);
            return str + round + "..." + str + round2;
        } else if (obj instanceof Boolean) {
            return obj.toString();
        } else {
            if (obj instanceof Throwable) {
                Throwable th = (Throwable) obj;
                StringBuilder sb = new StringBuilder(z ? th.getClass().getName() : th.toString());
                String zzy = zzy(zzgi.class.getCanonicalName());
                StackTraceElement[] stackTrace = th.getStackTrace();
                int length = stackTrace.length;
                while (true) {
                    if (i >= length) {
                        break;
                    }
                    StackTraceElement stackTraceElement = stackTrace[i];
                    if (!stackTraceElement.isNativeMethod()) {
                        String className = stackTraceElement.getClassName();
                        if (className != null && zzy(className).equals(zzy)) {
                            sb.append(": ");
                            sb.append(stackTraceElement);
                            break;
                        }
                    }
                    i++;
                }
                return sb.toString();
            } else if (obj instanceof zzex) {
                return ((zzex) obj).zza;
            } else {
                if (z) {
                    return Constants.ACCEPT_TIME_SEPARATOR_SERVER;
                }
                return obj.toString();
            }
        }
    }

    public static String zzy(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        int lastIndexOf = str.lastIndexOf(46);
        if (lastIndexOf == -1) {
            return str;
        }
        return str.substring(0, lastIndexOf);
    }

    public final zzew zzc() {
        return this.zzk;
    }

    public final zzew zzd() {
        return this.zzd;
    }

    public final boolean zzf() {
        return false;
    }

    public final zzew zzj() {
        return this.zzl;
    }

    public final zzew zzk() {
        return this.zzg;
    }

    public final zzew zzl() {
        return this.zzi;
    }

    @EnsuresNonNull({"logTagDoNotUseDirectly"})
    @VisibleForTesting
    public final String zzq() {
        String str;
        synchronized (this) {
            if (this.zzc == null) {
                if (this.zzs.zzh != null) {
                    this.zzc = this.zzs.zzh;
                } else {
                    zzaa zzaa = this.zzs.zzk.zzs.zzj;
                    this.zzc = "FA";
                }
            }
            Preconditions.checkNotNull(this.zzc);
            str = this.zzc;
        }
        return str;
    }

    public final void zzt(int i, boolean z, boolean z2, String str, Object obj, Object obj2, Object obj3) {
        if (!z && Log.isLoggable(zzq(), i)) {
            Log.println(i, zzq(), zzo(false, str, obj, obj2, obj3));
        }
        if (!z2 && i >= 5) {
            Preconditions.checkNotNull(str);
            zzgf zzgf = this.zzs.zzn;
            if (zzgf == null) {
                Log.println(6, zzq(), "Scheduler not set. Not logging error/warn");
            } else if (!zzgf.zzx()) {
                Log.println(6, zzq(), "Scheduler not initialized. Not logging error/warn");
            } else {
                zzev zzev = new zzev(this, i >= 9 ? 8 : i, str, obj, obj2, obj3);
                zzgf.zzp(zzev);
            }
        }
    }
}
