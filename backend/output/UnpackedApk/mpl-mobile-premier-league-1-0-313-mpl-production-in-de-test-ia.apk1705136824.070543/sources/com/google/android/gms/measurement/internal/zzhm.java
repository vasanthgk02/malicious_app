package com.google.android.gms.measurement.internal;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import android.util.Pair;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.ads.identifier.AdvertisingIdClient.Info;
import com.google.android.gms.common.internal.Preconditions;
import java.net.MalformedURLException;
import java.net.URL;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@20.1.2 */
public final /* synthetic */ class zzhm implements Runnable {
    public final /* synthetic */ zzin zza;

    public /* synthetic */ zzhm(zzin zzin) {
        this.zza = zzin;
    }

    public final void run() {
        Pair pair;
        NetworkInfo networkInfo;
        zzin zzin = this.zza;
        zzin.zzg();
        if (!zzin.zzs.zzm().zzm.zzb()) {
            long zza2 = zzin.zzs.zzm().zzn.zza();
            zzin.zzs.zzm().zzn.zzb(1 + zza2);
            zzgi zzgi = zzin.zzs;
            zzaf zzaf = zzgi.zzk;
            if (zza2 >= 5) {
                zzgi.zzaz().zzg.zza("Permanently failed to retrieve Deferred Deep Link. Reached maximum retries.");
                zzin.zzs.zzm().zzm.zza(true);
                return;
            }
            zzgi.zzaA().zzg();
            zzgi.zzR(zzgi.zzr());
            String zzl = zzgi.zzh().zzl();
            zzfn zzm = zzgi.zzm();
            zzm.zzg();
            long elapsedRealtime = zzm.zzs.zzr.elapsedRealtime();
            String str = zzm.zzu;
            if (str == null || elapsedRealtime >= zzm.zzw) {
                zzm.zzw = zzm.zzs.zzk.zzi(zzl, zzel.zza) + elapsedRealtime;
                AdvertisingIdClient.setShouldSkipGmsCoreVersionCheck(true);
                try {
                    Info advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(zzm.zzs.zze);
                    zzm.zzu = "";
                    String id = advertisingIdInfo.getId();
                    if (id != null) {
                        zzm.zzu = id;
                    }
                    zzm.zzv = advertisingIdInfo.isLimitAdTrackingEnabled();
                } catch (Exception e2) {
                    zzm.zzs.zzaz().zzk.zzb("Unable to get advertising id", e2);
                    zzm.zzu = "";
                }
                AdvertisingIdClient.setShouldSkipGmsCoreVersionCheck(false);
                pair = new Pair(zzm.zzu, Boolean.valueOf(zzm.zzv));
            } else {
                pair = new Pair(str, Boolean.valueOf(zzm.zzv));
            }
            if (!zzgi.zzk.zzr() || ((Boolean) pair.second).booleanValue() || TextUtils.isEmpty((CharSequence) pair.first)) {
                zzgi.zzaz().zzk.zza("ADID unavailable to retrieve Deferred Deep Link. Skipping");
            } else {
                zzir zzr = zzgi.zzr();
                zzr.zzu();
                ConnectivityManager connectivityManager = (ConnectivityManager) zzr.zzs.zze.getSystemService("connectivity");
                URL url = null;
                if (connectivityManager != null) {
                    try {
                        networkInfo = connectivityManager.getActiveNetworkInfo();
                    } catch (SecurityException unused) {
                    }
                    if (networkInfo != null || !networkInfo.isConnected()) {
                        zzgi.zzaz().zzg.zza("Network is not available for Deferred Deep Link request. Skipping");
                    } else {
                        zzlp zzv = zzgi.zzv();
                        zzgi.zzh().zzs.zzk.zzh();
                        String str2 = (String) pair.first;
                        long zza3 = zzgi.zzm().zzn.zza() - 1;
                        if (zzv != null) {
                            try {
                                Preconditions.checkNotEmpty(str2);
                                Preconditions.checkNotEmpty(zzl);
                                String format = String.format("https://www.googleadservices.com/pagead/conversion/app/deeplink?id_type=adid&sdk_version=%s&rdid=%s&bundleid=%s&retry=%s", new Object[]{String.format("v%s.%s", new Object[]{Long.valueOf(61000), Integer.valueOf(zzv.zzm())}), str2, zzl, Long.valueOf(zza3)});
                                if (zzl.equals(zzv.zzs.zzk.zzB("debug.deferred.deeplink", ""))) {
                                    format = format.concat("&ddl_test=1");
                                }
                                url = new URL(format);
                            } catch (IllegalArgumentException | MalformedURLException e3) {
                                zzv.zzs.zzaz().zzd.zzb("Failed to create BOW URL for Deferred Deep Link. exception", e3.getMessage());
                            }
                            if (url != null) {
                                zzir zzr2 = zzgi.zzr();
                                zzgg zzgg = new zzgg(zzgi);
                                zzr2.zzg();
                                zzr2.zzu();
                                Preconditions.checkNotNull(url);
                                Preconditions.checkNotNull(zzgg);
                                zzr2.zzs.zzaA().zzo(new zziq(zzr2, zzl, url, zzgg));
                            }
                        } else {
                            throw null;
                        }
                    }
                }
                networkInfo = null;
                if (networkInfo != null) {
                }
                zzgi.zzaz().zzg.zza("Network is not available for Deferred Deep Link request. Skipping");
            }
            return;
        }
        zzin.zzs.zzaz().zzk.zza("Deferred Deep Link already retrieved. Not fetching again.");
    }
}
