package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.measurement.zzeq;
import com.google.android.gms.internal.measurement.zzex;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

/* compiled from: com.google.android.gms:play-services-measurement@@20.1.2 */
public abstract class zzx {
    public final String zzb;
    public final int zzc;
    public Boolean zzd;
    public Boolean zze;
    public Long zzf;
    public Long zzg;

    public zzx(String str, int i) {
        this.zzb = str;
        this.zzc = i;
    }

    @VisibleForTesting
    public static Boolean zze(BigDecimal bigDecimal, zzeq zzeq, double d2) {
        BigDecimal bigDecimal2;
        BigDecimal bigDecimal3;
        BigDecimal bigDecimal4;
        Preconditions.checkNotNull(zzeq);
        Boolean bool = null;
        if (zzeq.zzg()) {
            boolean z = true;
            if (zzeq.zzm() != 1) {
                if (zzeq.zzm() == 5) {
                    if (!zzeq.zzk() || !zzeq.zzj()) {
                        return null;
                    }
                } else if (!zzeq.zzh()) {
                    return null;
                }
                int zzm = zzeq.zzm();
                if (zzeq.zzm() == 5) {
                    if (zzlk.zzx(zzeq.zze()) && zzlk.zzx(zzeq.zzd())) {
                        try {
                            BigDecimal bigDecimal5 = new BigDecimal(zzeq.zze());
                            bigDecimal3 = new BigDecimal(zzeq.zzd());
                            bigDecimal2 = bigDecimal5;
                            bigDecimal4 = null;
                        } catch (NumberFormatException unused) {
                        }
                    }
                    return null;
                } else if (!zzlk.zzx(zzeq.zzc())) {
                    return null;
                } else {
                    try {
                        bigDecimal4 = new BigDecimal(zzeq.zzc());
                        bigDecimal2 = null;
                        bigDecimal3 = null;
                    } catch (NumberFormatException unused2) {
                    }
                }
                if (zzm != 5 ? bigDecimal4 != null : bigDecimal2 != null) {
                    int i = zzm - 1;
                    if (i != 1) {
                        if (i != 2) {
                            if (i != 3) {
                                if (i == 4 && bigDecimal2 != null) {
                                    if (bigDecimal.compareTo(bigDecimal2) < 0 || bigDecimal.compareTo(bigDecimal3) > 0) {
                                        z = false;
                                    }
                                    bool = Boolean.valueOf(z);
                                }
                            } else if (bigDecimal4 != null) {
                                if (d2 != 0.0d) {
                                    if (bigDecimal.compareTo(bigDecimal4.subtract(new BigDecimal(d2).multiply(new BigDecimal(2)))) <= 0 || bigDecimal.compareTo(bigDecimal4.add(new BigDecimal(d2).multiply(new BigDecimal(2)))) >= 0) {
                                        z = false;
                                    }
                                    bool = Boolean.valueOf(z);
                                } else {
                                    if (bigDecimal.compareTo(bigDecimal4) != 0) {
                                        z = false;
                                    }
                                    bool = Boolean.valueOf(z);
                                }
                            }
                        } else if (bigDecimal4 != null) {
                            if (bigDecimal.compareTo(bigDecimal4) <= 0) {
                                z = false;
                            }
                            return Boolean.valueOf(z);
                        }
                    } else if (bigDecimal4 != null) {
                        if (bigDecimal.compareTo(bigDecimal4) >= 0) {
                            z = false;
                        }
                        return Boolean.valueOf(z);
                    }
                }
                return bool;
            }
        }
        return null;
    }

    @VisibleForTesting
    public static Boolean zzf(String str, zzex zzex, zzey zzey) {
        String str2;
        List<String> list;
        Preconditions.checkNotNull(zzex);
        Boolean bool = null;
        if (str == null) {
            return null;
        }
        if (zzex.zzi() && zzex.zzj() != 1) {
            if (zzex.zzj() == 7) {
                if (zzex.zza() == 0) {
                    return null;
                }
            } else if (!zzex.zzh()) {
                return null;
            }
            int zzj = zzex.zzj();
            boolean zzf2 = zzex.zzf();
            if (zzf2 || zzj == 2 || zzj == 7) {
                str2 = zzex.zzd();
            } else {
                str2 = zzex.zzd().toUpperCase(Locale.ENGLISH);
            }
            if (zzex.zza() == 0) {
                list = null;
            } else {
                list = zzex.zze();
                if (!zzf2) {
                    ArrayList arrayList = new ArrayList(list.size());
                    for (String upperCase : list) {
                        arrayList.add(upperCase.toUpperCase(Locale.ENGLISH));
                    }
                    list = Collections.unmodifiableList(arrayList);
                }
            }
            String str3 = zzj == 2 ? str2 : null;
            if (zzj != 7 ? str2 != null : !(list == null || list.size() == 0)) {
                if (!zzf2 && zzj != 2) {
                    str = str.toUpperCase(Locale.ENGLISH);
                }
                switch (zzj - 1) {
                    case 1:
                        if (str3 != null) {
                            try {
                                bool = Boolean.valueOf(Pattern.compile(str3, true != zzf2 ? 66 : 0).matcher(str).matches());
                                break;
                            } catch (PatternSyntaxException unused) {
                                if (zzey != null) {
                                    zzey.zzg.zzb("Invalid regular expression in REGEXP audience filter. expression", str3);
                                    break;
                                }
                            }
                        }
                        break;
                    case 2:
                        bool = Boolean.valueOf(str.startsWith(str2));
                        break;
                    case 3:
                        bool = Boolean.valueOf(str.endsWith(str2));
                        break;
                    case 4:
                        bool = Boolean.valueOf(str.contains(str2));
                        break;
                    case 5:
                        bool = Boolean.valueOf(str.equals(str2));
                        break;
                    case 6:
                        if (list != null) {
                            bool = Boolean.valueOf(list.contains(str));
                            break;
                        }
                        break;
                }
            }
        }
        return bool;
    }

    public static Boolean zzh(long j, zzeq zzeq) {
        try {
            return zze(new BigDecimal(j), zzeq, 0.0d);
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    public static Boolean zzi(String str, zzeq zzeq) {
        if (!zzlk.zzx(str)) {
            return null;
        }
        try {
            return zze(new BigDecimal(str), zzeq, 0.0d);
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    @VisibleForTesting
    public static Boolean zzj(Boolean bool, boolean z) {
        if (bool == null) {
            return null;
        }
        return Boolean.valueOf(bool.booleanValue() != z);
    }

    public abstract int zza();

    public abstract boolean zzb();

    public abstract boolean zzc();
}
