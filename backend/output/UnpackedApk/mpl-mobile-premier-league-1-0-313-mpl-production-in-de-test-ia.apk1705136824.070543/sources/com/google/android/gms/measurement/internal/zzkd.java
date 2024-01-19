package com.google.android.gms.measurement.internal;

import android.util.Pair;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.ads.identifier.AdvertisingIdClient.Info;
import com.google.android.gms.internal.measurement.zzne;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement@@20.1.2 */
public final class zzkd extends zzkw {
    public final zzfj zza;
    public final zzfj zzb;
    public final zzfj zzc;
    public final zzfj zzd;
    public final zzfj zze;
    public final Map zzg = new HashMap();
    public String zzh;
    public boolean zzi;
    public long zzj;

    public zzkd(zzli zzli) {
        super(zzli);
        zzfn zzm = this.zzs.zzm();
        zzm.getClass();
        this.zza = new zzfj(zzm, "last_delete_stale", 0);
        zzfn zzm2 = this.zzs.zzm();
        zzm2.getClass();
        this.zzb = new zzfj(zzm2, "backoff", 0);
        zzfn zzm3 = this.zzs.zzm();
        zzm3.getClass();
        this.zzc = new zzfj(zzm3, "last_upload", 0);
        zzfn zzm4 = this.zzs.zzm();
        zzm4.getClass();
        this.zzd = new zzfj(zzm4, "last_upload_attempt", 0);
        zzfn zzm5 = this.zzs.zzm();
        zzm5.getClass();
        this.zze = new zzfj(zzm5, "midnight_offset", 0);
    }

    @Deprecated
    public final Pair zza(String str) {
        zzkc zzkc;
        zzg();
        long elapsedRealtime = this.zzs.zzr.elapsedRealtime();
        zzne.zzc();
        if (this.zzs.zzk.zzs(null, zzel.zzar)) {
            zzkc zzkc2 = (zzkc) this.zzg.get(str);
            if (zzkc2 != null && elapsedRealtime < zzkc2.zzc) {
                return new Pair(zzkc2.zza, Boolean.valueOf(zzkc2.zzb));
            }
            AdvertisingIdClient.setShouldSkipGmsCoreVersionCheck(true);
            long zzi2 = this.zzs.zzk.zzi(str, zzel.zza) + elapsedRealtime;
            try {
                Info advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(this.zzs.zze);
                if (advertisingIdInfo == null) {
                    return new Pair("", Boolean.FALSE);
                }
                String id = advertisingIdInfo.getId();
                if (id != null) {
                    zzkc = new zzkc(id, advertisingIdInfo.isLimitAdTrackingEnabled(), zzi2);
                } else {
                    zzkc = new zzkc("", advertisingIdInfo.isLimitAdTrackingEnabled(), zzi2);
                }
                this.zzg.put(str, zzkc);
                AdvertisingIdClient.setShouldSkipGmsCoreVersionCheck(false);
                return new Pair(zzkc.zza, Boolean.valueOf(zzkc.zzb));
            } catch (Exception e2) {
                this.zzs.zzaz().zzk.zzb("Unable to get advertising id", e2);
                zzkc = new zzkc("", false, zzi2);
            }
        } else {
            String str2 = this.zzh;
            if (str2 != null && elapsedRealtime < this.zzj) {
                return new Pair(str2, Boolean.valueOf(this.zzi));
            }
            this.zzj = this.zzs.zzk.zzi(str, zzel.zza) + elapsedRealtime;
            AdvertisingIdClient.setShouldSkipGmsCoreVersionCheck(true);
            try {
                Info advertisingIdInfo2 = AdvertisingIdClient.getAdvertisingIdInfo(this.zzs.zze);
                if (advertisingIdInfo2 == null) {
                    return new Pair("", Boolean.FALSE);
                }
                this.zzh = "";
                String id2 = advertisingIdInfo2.getId();
                if (id2 != null) {
                    this.zzh = id2;
                }
                this.zzi = advertisingIdInfo2.isLimitAdTrackingEnabled();
                AdvertisingIdClient.setShouldSkipGmsCoreVersionCheck(false);
                return new Pair(this.zzh, Boolean.valueOf(this.zzi));
            } catch (Exception e3) {
                this.zzs.zzaz().zzk.zzb("Unable to get advertising id", e3);
                this.zzh = "";
            }
        }
    }

    public final boolean zzb() {
        return false;
    }

    public final Pair zzd(String str, zzah zzah) {
        if (zzah.zzi(zzag.AD_STORAGE)) {
            return zza(str);
        }
        return new Pair("", Boolean.FALSE);
    }

    @Deprecated
    public final String zzf(String str) {
        zzg();
        String str2 = (String) zza(str).first;
        MessageDigest zzF = zzlp.zzF();
        if (zzF == null) {
            return null;
        }
        return String.format(Locale.US, "%032X", new Object[]{new BigInteger(1, zzF.digest(str2.getBytes()))});
    }
}
