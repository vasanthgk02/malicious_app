package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.util.Pair;
import com.freshchat.consumer.sdk.beans.config.DefaultRemoteConfig;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull.List;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@20.1.2 */
public final class zzfn extends zzhc {
    @VisibleForTesting
    public static final Pair zza = new Pair("", Long.valueOf(0));
    public zzfl zzb;
    public final zzfj zzc = new zzfj(this, "first_open_time", 0);
    public final zzfj zzd = new zzfj(this, "app_install_time", 0);
    public final zzfm zze = new zzfm(this, "app_instance_id");
    public final zzfj zzf = new zzfj(this, "session_timeout", DefaultRemoteConfig.SESSION_TIMEOUT_DURATION);
    public final zzfh zzg = new zzfh(this, "start_new_session", true);
    public final zzfm zzh = new zzfm(this, "non_personalized_ads");
    public final zzfh zzi = new zzfh(this, "allow_remote_dynamite", false);
    public final zzfj zzj = new zzfj(this, "last_pause_time", 0);
    public boolean zzk;
    public final zzfh zzl = new zzfh(this, "app_backgrounded", false);
    public final zzfh zzm = new zzfh(this, "deep_link_retrieval_complete", false);
    public final zzfj zzn = new zzfj(this, "deep_link_retrieval_attempts", 0);
    public final zzfm zzo = new zzfm(this, "firebase_feature_rollouts");
    public final zzfm zzp = new zzfm(this, "deferred_attribution_cache");
    public final zzfj zzq = new zzfj(this, "deferred_attribution_cache_timestamp", 0);
    public final zzfi zzr = new zzfi(this);
    public SharedPreferences zzt;
    public String zzu;
    public boolean zzv;
    public long zzw;

    public zzfn(zzgi zzgi) {
        super(zzgi);
    }

    @VisibleForTesting
    public final SharedPreferences zza() {
        zzg();
        zzu();
        Preconditions.checkNotNull(this.zzt);
        return this.zzt;
    }

    @List({@EnsuresNonNull({"this.preferences"}), @EnsuresNonNull({"this.monitoringSample"})})
    public final void zzaB() {
        SharedPreferences sharedPreferences = this.zzs.zze.getSharedPreferences("com.google.android.gms.measurement.prefs", 0);
        this.zzt = sharedPreferences;
        boolean z = sharedPreferences.getBoolean("has_been_opened", false);
        this.zzk = z;
        if (!z) {
            Editor edit = this.zzt.edit();
            edit.putBoolean("has_been_opened", true);
            edit.apply();
        }
        zzaf zzaf = this.zzs.zzk;
        this.zzb = new zzfl(this, Math.max(0, ((Long) zzel.zzb.zza(null)).longValue()));
    }

    public final zzah zzc() {
        zzg();
        return zzah.zzb(zza().getString("consent_settings", "G1"));
    }

    public final Boolean zzd() {
        zzg();
        if (zza().contains("measurement_enabled")) {
            return Boolean.valueOf(zza().getBoolean("measurement_enabled", true));
        }
        return null;
    }

    public final boolean zzf() {
        return true;
    }

    public final void zzh(Boolean bool) {
        zzg();
        Editor edit = zza().edit();
        if (bool != null) {
            edit.putBoolean("measurement_enabled", bool.booleanValue());
        } else {
            edit.remove("measurement_enabled");
        }
        edit.apply();
    }

    public final void zzi(boolean z) {
        zzg();
        this.zzs.zzaz().zzl.zzb("App measurement setting deferred collection", Boolean.valueOf(z));
        Editor edit = zza().edit();
        edit.putBoolean("deferred_analytics_collection", z);
        edit.apply();
    }

    public final boolean zzk(long j) {
        return j - this.zzf.zza() > this.zzj.zza();
    }

    public final boolean zzl(int i) {
        return zzah.zzj(i, zza().getInt("consent_source", 100));
    }
}
