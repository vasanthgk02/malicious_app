package com.google.android.gms.stats;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.PowerManager;
import android.os.WorkSource;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.common.util.Strings;
import com.google.android.gms.common.util.WorkSourceUtil;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.internal.stats.zzb;
import com.google.android.gms.internal.stats.zzh;
import com.google.android.gms.internal.stats.zzi;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

@ShowFirstParty
@KeepForSdk
/* compiled from: com.google.android.gms:play-services-stats@@17.0.1 */
public class WakeLock {
    public static final long zzb = TimeUnit.DAYS.toMillis(366);
    public static volatile ScheduledExecutorService zzc = null;
    public static final Object zzd = new Object();
    public static volatile zzd zze = new zzb();
    public zzb zza;
    public final Object zzf = new Object();
    public final android.os.PowerManager.WakeLock zzg;
    public int zzh = 0;
    public Future<?> zzi;
    public long zzj;
    public final Set<zze> zzk = new HashSet();
    public boolean zzl = true;
    public int zzm;
    public Clock zzn = DefaultClock.zza;
    public WorkSource zzo;
    public final String zzp;
    public final Context zzr;
    public final Map<String, zzc> zzs = new HashMap();
    public AtomicInteger zzt = new AtomicInteger(0);
    public final ScheduledExecutorService zzu;

    @KeepForSdk
    public WakeLock(Context context, int i, String str) {
        String str2;
        String packageName = context.getPackageName();
        Preconditions.checkNotNull(context, "WakeLock: context must not be null");
        Preconditions.checkNotEmpty(str, "WakeLock: wakeLockName must not be empty");
        this.zzr = context.getApplicationContext();
        WorkSource workSource = null;
        this.zza = null;
        if (!"com.google.android.gms".equals(context.getPackageName())) {
            if (str.length() != 0) {
                str2 = "*gcore*:".concat(str);
            } else {
                str2 = new String("*gcore*:");
            }
            this.zzp = str2;
        } else {
            this.zzp = str;
        }
        PowerManager powerManager = (PowerManager) context.getSystemService("power");
        if (powerManager != null) {
            this.zzg = powerManager.newWakeLock(i, str);
            if (WorkSourceUtil.hasWorkSourcePermission(context)) {
                packageName = Strings.isEmptyOrWhitespace(packageName) ? context.getPackageName() : packageName;
                if (!(context.getPackageManager() == null || packageName == null)) {
                    try {
                        ApplicationInfo applicationInfo = Wrappers.packageManager(context).zza.getPackageManager().getApplicationInfo(packageName, 0);
                        if (applicationInfo == null) {
                            "Could not get applicationInfo from package: ".concat(packageName);
                        } else {
                            int i2 = applicationInfo.uid;
                            workSource = new WorkSource();
                            Method method = WorkSourceUtil.zzc;
                            if (method != null) {
                                try {
                                    method.invoke(workSource, new Object[]{Integer.valueOf(i2), packageName});
                                } catch (Exception e2) {
                                    Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", e2);
                                }
                            } else {
                                Method method2 = WorkSourceUtil.zzb;
                                if (method2 != null) {
                                    try {
                                        method2.invoke(workSource, new Object[]{Integer.valueOf(i2)});
                                    } catch (Exception e3) {
                                        Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", e3);
                                    }
                                }
                            }
                        }
                    } catch (NameNotFoundException unused) {
                        "Could not find package: ".concat(packageName);
                    }
                }
                this.zzo = workSource;
                if (workSource != null) {
                    try {
                        this.zzg.setWorkSource(workSource);
                    } catch (ArrayIndexOutOfBoundsException | IllegalArgumentException e4) {
                        Log.wtf("WakeLock", e4.toString());
                    }
                }
            }
            ScheduledExecutorService scheduledExecutorService = zzc;
            if (scheduledExecutorService == null) {
                synchronized (zzd) {
                    scheduledExecutorService = zzc;
                    if (scheduledExecutorService == null) {
                        zzh.zza();
                        scheduledExecutorService = Executors.unconfigurableScheduledExecutorService(Executors.newScheduledThreadPool(1));
                        zzc = scheduledExecutorService;
                    }
                }
            }
            this.zzu = scheduledExecutorService;
            return;
        }
        StringBuilder sb = new StringBuilder(29);
        sb.append("expected a non-null reference", 0, 29);
        throw new zzi(sb.toString());
    }

    @KeepForSdk
    public void acquire(long j) {
        this.zzt.incrementAndGet();
        long j2 = Long.MAX_VALUE;
        long max = Math.max(Math.min(Long.MAX_VALUE, zzb), 1);
        if (j > 0) {
            max = Math.min(j, max);
        }
        synchronized (this.zzf) {
            if (!isHeld()) {
                this.zza = zzb.zza(false, null);
                this.zzg.acquire();
                this.zzn.elapsedRealtime();
            }
            this.zzh++;
            this.zzm++;
            zzb();
            zzc zzc2 = this.zzs.get(null);
            if (zzc2 == null) {
                zzc2 = new zzc(null);
                this.zzs.put(null, zzc2);
            }
            zzc2.zza++;
            long elapsedRealtime = this.zzn.elapsedRealtime();
            if (Long.MAX_VALUE - elapsedRealtime > max) {
                j2 = elapsedRealtime + max;
            }
            if (j2 > this.zzj) {
                this.zzj = j2;
                Future<?> future = this.zzi;
                if (future != null) {
                    future.cancel(false);
                }
                this.zzi = this.zzu.schedule(new zza(this), max, TimeUnit.MILLISECONDS);
            }
        }
    }

    @KeepForSdk
    public boolean isHeld() {
        boolean z;
        synchronized (this.zzf) {
            z = this.zzh > 0;
        }
        return z;
    }

    @KeepForSdk
    public void release() {
        if (this.zzt.decrementAndGet() < 0) {
            String.valueOf(this.zzp).concat(" release without a matched acquire!");
        }
        synchronized (this.zzf) {
            zzb();
            if (this.zzs.containsKey(null)) {
                zzc zzc2 = this.zzs.get(null);
                if (zzc2 != null) {
                    int i = zzc2.zza - 1;
                    zzc2.zza = i;
                    if (i == 0) {
                        this.zzs.remove(null);
                    }
                }
            } else {
                String.valueOf(this.zzp).concat(" counter does not exist");
            }
            zzd(0);
        }
    }

    public final String zzb() {
        if (!this.zzl || !TextUtils.isEmpty(null)) {
        }
        return null;
    }

    public final void zzc() {
        if (!this.zzk.isEmpty()) {
            ArrayList arrayList = new ArrayList(this.zzk);
            this.zzk.clear();
            if (arrayList.size() > 0) {
                zze zze2 = (zze) arrayList.get(0);
                throw null;
            }
        }
    }

    public final void zzd(int i) {
        synchronized (this.zzf) {
            if (isHeld()) {
                if (this.zzl) {
                    int i2 = this.zzh - 1;
                    this.zzh = i2;
                    if (i2 > 0) {
                        return;
                    }
                } else {
                    this.zzh = 0;
                }
                zzc();
                for (zzc zzc2 : this.zzs.values()) {
                    zzc2.zza = 0;
                }
                this.zzs.clear();
                Future<?> future = this.zzi;
                if (future != null) {
                    future.cancel(false);
                    this.zzi = null;
                    this.zzj = 0;
                }
                this.zzm = 0;
                if (this.zzg.isHeld()) {
                    try {
                        this.zzg.release();
                        if (this.zza != null) {
                            this.zza = null;
                        }
                    } catch (RuntimeException e2) {
                        if (e2.getClass().equals(RuntimeException.class)) {
                            String.valueOf(this.zzp).concat(" failed to release!");
                            if (this.zza != null) {
                                this.zza = null;
                            }
                            return;
                        }
                        throw e2;
                    } catch (Throwable th) {
                        if (this.zza != null) {
                            this.zza = null;
                        }
                        throw th;
                    }
                } else {
                    String.valueOf(this.zzp).concat(" should be held!");
                }
            }
        }
    }
}
