package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences.Editor;
import android.content.pm.ApplicationInfo;
import android.util.Log;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.google.android.gms.common.util.ProcessUtils;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@20.1.2 */
public final class zzev implements Runnable {
    public final /* synthetic */ int zza;
    public final /* synthetic */ String zzb;
    public final /* synthetic */ Object zzc;
    public final /* synthetic */ Object zzd;
    public final /* synthetic */ Object zze;
    public final /* synthetic */ zzey zzf;

    public zzev(zzey zzey, int i, String str, Object obj, Object obj2, Object obj3) {
        this.zzf = zzey;
        this.zza = i;
        this.zzb = str;
        this.zzc = obj;
        this.zzd = obj2;
        this.zze = obj3;
    }

    public final void run() {
        zzfn zzm = this.zzf.zzs.zzm();
        if (zzm.zzx()) {
            zzey zzey = this.zzf;
            if (zzey.zza == 0) {
                zzaf zzaf = zzey.zzs.zzk;
                if (zzaf.zzc == null) {
                    synchronized (zzaf) {
                        if (zzaf.zzc == null) {
                            ApplicationInfo applicationInfo = zzaf.zzs.zze.getApplicationInfo();
                            String myProcessName = ProcessUtils.getMyProcessName();
                            if (applicationInfo != null) {
                                String str = applicationInfo.processName;
                                zzaf.zzc = Boolean.valueOf(str != null && str.equals(myProcessName));
                            }
                            if (zzaf.zzc == null) {
                                zzaf.zzc = Boolean.TRUE;
                                zzaf.zzs.zzaz().zzd.zza("My process not in the list of running processes");
                            }
                        }
                    }
                }
                if (zzaf.zzc.booleanValue()) {
                    zzey zzey2 = this.zzf;
                    zzaa zzaa = zzey2.zzs.zzj;
                    zzey2.zza = 'C';
                } else {
                    zzey zzey3 = this.zzf;
                    zzaa zzaa2 = zzey3.zzs.zzj;
                    zzey3.zza = 'c';
                }
            }
            zzey zzey4 = this.zzf;
            if (zzey4.zzb < 0) {
                zzey4.zzs.zzk.zzh();
                zzey4.zzb = 61000;
            }
            char charAt = "01VDIWEA?".charAt(this.zza);
            zzey zzey5 = this.zzf;
            char c2 = zzey5.zza;
            long j = zzey5.zzb;
            String zzo = zzey.zzo(true, this.zzb, this.zzc, this.zzd, this.zze);
            StringBuilder sb = new StringBuilder();
            sb.append("2");
            sb.append(charAt);
            sb.append(c2);
            sb.append(j);
            String outline62 = GeneratedOutlineSupport.outline62(sb, ":", zzo);
            if (outline62.length() > 1024) {
                outline62 = this.zzb.substring(0, 1024);
            }
            zzfl zzfl = zzm.zzb;
            if (zzfl != null) {
                zzfl.zzb.zzg();
                if (zzfl.zzb.zza().getLong(zzfl.zza, 0) == 0) {
                    zzfl.zzd();
                }
                if (outline62 == null) {
                    outline62 = "";
                }
                long j2 = zzfl.zzb.zza().getLong(zzfl.zzc, 0);
                if (j2 <= 0) {
                    Editor edit = zzfl.zzb.zza().edit();
                    edit.putString(zzfl.zzd, outline62);
                    edit.putLong(zzfl.zzc, 1);
                    edit.apply();
                } else {
                    long nextLong = zzfl.zzb.zzs.zzv().zzG().nextLong();
                    long j3 = j2 + 1;
                    Editor edit2 = zzfl.zzb.zza().edit();
                    if ((Long.MAX_VALUE & nextLong) < Long.MAX_VALUE / j3) {
                        edit2.putString(zzfl.zzd, outline62);
                    }
                    edit2.putLong(zzfl.zzc, j3);
                    edit2.apply();
                }
            }
            return;
        }
        Log.println(6, this.zzf.zzq(), "Persisted config not initialized. Not logging error/warn");
    }
}
