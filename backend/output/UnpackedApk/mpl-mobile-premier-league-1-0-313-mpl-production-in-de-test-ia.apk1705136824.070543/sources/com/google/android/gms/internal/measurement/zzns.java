package com.google.android.gms.internal.measurement;

import android.support.v4.media.session.PlaybackStateCompat;
import com.freshchat.consumer.sdk.beans.config.DefaultRemoteConfig;
import com.freshchat.consumer.sdk.beans.config.DefaultUserEventsConfig;
import com.google.firebase.perf.config.RemoteConfigManager;
import com.squareup.picasso.NetworkRequestHandler;
import org.eclipse.paho.client.mqttv3.MqttAsyncClient;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@20.1.2 */
public final class zzns implements zznr {
    public static final zzhy zzA;
    public static final zzhy zzB;
    public static final zzhy zzC;
    public static final zzhy zzD;
    public static final zzhy zzE;
    public static final zzhy zzF;
    public static final zzhy zzG;
    public static final zzhy zzH;
    public static final zzhy zzI;
    public static final zzhy zzJ;
    public static final zzhy zzK;
    public static final zzhy zzL;
    public static final zzhy zzM;
    public static final zzhy zza;
    public static final zzhy zzb;
    public static final zzhy zzc;
    public static final zzhy zzd;
    public static final zzhy zze;
    public static final zzhy zzf;
    public static final zzhy zzg;
    public static final zzhy zzh;
    public static final zzhy zzi;
    public static final zzhy zzj;
    public static final zzhy zzk;
    public static final zzhy zzl;
    public static final zzhy zzm;
    public static final zzhy zzn;
    public static final zzhy zzo;
    public static final zzhy zzp;
    public static final zzhy zzq;
    public static final zzhy zzr;
    public static final zzhy zzs;
    public static final zzhy zzt;
    public static final zzhy zzu;
    public static final zzhy zzv;
    public static final zzhy zzw;
    public static final zzhy zzx;
    public static final zzhy zzy;
    public static final zzhy zzz;

    static {
        zzhv zza2 = new zzhv(zzho.zza("com.google.android.gms.measurement")).zza();
        zza = zza2.zzd("measurement.ad_id_cache_time", MqttAsyncClient.DISCONNECT_TIMEOUT);
        zzb = zza2.zzd("measurement.max_bundles_per_iteration", 100);
        zzc = zza2.zzd("measurement.config.cache_time", 86400000);
        zzd = zza2.zze("measurement.log_tag", "FA");
        zze = zza2.zze("measurement.config.url_authority", "app-measurement.com");
        zzf = zza2.zze("measurement.config.url_scheme", NetworkRequestHandler.SCHEME_HTTPS);
        zzg = zza2.zzd("measurement.upload.debug_upload_interval", 1000);
        zzh = zza2.zzd("measurement.lifetimevalue.max_currency_tracked", 4);
        zzi = zza2.zzd("measurement.store.max_stored_events_per_app", 100000);
        zzj = zza2.zzd("measurement.experiment.max_ids", 50);
        zzk = zza2.zzd("measurement.audience.filter_result_max_count", 200);
        zzl = zza2.zzd("measurement.alarm_manager.minimum_interval", 60000);
        zzm = zza2.zzd("measurement.upload.minimum_delay", 500);
        zzn = zza2.zzd("measurement.monitoring.sample_period_millis", 86400000);
        zzo = zza2.zzd("measurement.upload.realtime_upload_interval", MqttAsyncClient.DISCONNECT_TIMEOUT);
        zzp = zza2.zzd("measurement.upload.refresh_blacklisted_config_interval", 604800000);
        zzq = zza2.zzd("measurement.config.cache_time.service", 3600000);
        zzr = zza2.zzd("measurement.service_client.idle_disconnect_millis", RemoteConfigManager.MIN_APP_START_CONFIG_FETCH_DELAY_MS);
        zzs = zza2.zze("measurement.log_tag.service", "FA-SVC");
        zzt = zza2.zzd("measurement.upload.stale_data_deletion_interval", 86400000);
        zzu = zza2.zzd("measurement.sdk.attribution.cache.ttl", 604800000);
        zzv = zza2.zzd("measurement.redaction.app_instance_id.ttl", 7200000);
        zzw = zza2.zzd("measurement.upload.backoff_period", 43200000);
        zzx = zza2.zzd("measurement.upload.initial_upload_delay_time", DefaultUserEventsConfig.MAX_DELAY_IN_MILLIS_UNTIL_UPLOAD);
        zzy = zza2.zzd("measurement.upload.interval", 3600000);
        zzz = zza2.zzd("measurement.upload.max_bundle_size", PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH);
        zzA = zza2.zzd("measurement.upload.max_bundles", 100);
        zzB = zza2.zzd("measurement.upload.max_conversions_per_day", 500);
        zzC = zza2.zzd("measurement.upload.max_error_events_per_day", 1000);
        zzD = zza2.zzd("measurement.upload.max_events_per_bundle", 1000);
        zzE = zza2.zzd("measurement.upload.max_events_per_day", 100000);
        zzF = zza2.zzd("measurement.upload.max_public_events_per_day", 50000);
        zzG = zza2.zzd("measurement.upload.max_queue_time", 2419200000L);
        zzH = zza2.zzd("measurement.upload.max_realtime_events_per_day", 10);
        zzI = zza2.zzd("measurement.upload.max_batch_size", PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH);
        zzJ = zza2.zzd("measurement.upload.retry_count", 6);
        zzK = zza2.zzd("measurement.upload.retry_time", DefaultRemoteConfig.SESSION_TIMEOUT_DURATION);
        zzL = zza2.zze("measurement.upload.url", "https://app-measurement.com/a");
        zzM = zza2.zzd("measurement.upload.window_interval", 3600000);
    }

    public final long zzA() {
        return ((Long) zzF.zzb()).longValue();
    }

    public final long zzB() {
        return ((Long) zzG.zzb()).longValue();
    }

    public final long zzC() {
        return ((Long) zzH.zzb()).longValue();
    }

    public final long zzD() {
        return ((Long) zzI.zzb()).longValue();
    }

    public final long zzE() {
        return ((Long) zzJ.zzb()).longValue();
    }

    public final long zzF() {
        return ((Long) zzK.zzb()).longValue();
    }

    public final long zzG() {
        return ((Long) zzM.zzb()).longValue();
    }

    public final String zzH() {
        return (String) zze.zzb();
    }

    public final String zzI() {
        return (String) zzf.zzb();
    }

    public final String zzJ() {
        return (String) zzL.zzb();
    }

    public final long zza() {
        return ((Long) zza.zzb()).longValue();
    }

    public final long zzb() {
        return ((Long) zzb.zzb()).longValue();
    }

    public final long zzc() {
        return ((Long) zzc.zzb()).longValue();
    }

    public final long zzd() {
        return ((Long) zzg.zzb()).longValue();
    }

    public final long zze() {
        return ((Long) zzh.zzb()).longValue();
    }

    public final long zzf() {
        return ((Long) zzi.zzb()).longValue();
    }

    public final long zzg() {
        return ((Long) zzj.zzb()).longValue();
    }

    public final long zzh() {
        return ((Long) zzk.zzb()).longValue();
    }

    public final long zzi() {
        return ((Long) zzl.zzb()).longValue();
    }

    public final long zzj() {
        return ((Long) zzm.zzb()).longValue();
    }

    public final long zzk() {
        return ((Long) zzn.zzb()).longValue();
    }

    public final long zzl() {
        return ((Long) zzo.zzb()).longValue();
    }

    public final long zzm() {
        return ((Long) zzp.zzb()).longValue();
    }

    public final long zzn() {
        return ((Long) zzr.zzb()).longValue();
    }

    public final long zzo() {
        return ((Long) zzt.zzb()).longValue();
    }

    public final long zzp() {
        return ((Long) zzu.zzb()).longValue();
    }

    public final long zzq() {
        return ((Long) zzv.zzb()).longValue();
    }

    public final long zzr() {
        return ((Long) zzw.zzb()).longValue();
    }

    public final long zzs() {
        return ((Long) zzx.zzb()).longValue();
    }

    public final long zzt() {
        return ((Long) zzy.zzb()).longValue();
    }

    public final long zzu() {
        return ((Long) zzz.zzb()).longValue();
    }

    public final long zzv() {
        return ((Long) zzA.zzb()).longValue();
    }

    public final long zzw() {
        return ((Long) zzB.zzb()).longValue();
    }

    public final long zzx() {
        return ((Long) zzC.zzb()).longValue();
    }

    public final long zzy() {
        return ((Long) zzD.zzb()).longValue();
    }

    public final long zzz() {
        return ((Long) zzE.zzb()).longValue();
    }
}
