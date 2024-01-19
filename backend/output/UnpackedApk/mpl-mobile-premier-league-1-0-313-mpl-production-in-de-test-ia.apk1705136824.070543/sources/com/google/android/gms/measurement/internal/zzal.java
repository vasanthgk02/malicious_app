package com.google.android.gms.measurement.internal;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.text.TextUtils;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.react.modules.appstate.AppStateModule;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.measurement.zzfs;
import com.google.android.gms.internal.measurement.zznz;
import io.hansel.core.criteria.HSLCriteriaBuilder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement@@20.1.2 */
public final class zzal extends zzkw {
    public static final String[] zza = {"last_bundled_timestamp", "ALTER TABLE events ADD COLUMN last_bundled_timestamp INTEGER;", "last_bundled_day", "ALTER TABLE events ADD COLUMN last_bundled_day INTEGER;", "last_sampled_complex_event_id", "ALTER TABLE events ADD COLUMN last_sampled_complex_event_id INTEGER;", "last_sampling_rate", "ALTER TABLE events ADD COLUMN last_sampling_rate INTEGER;", "last_exempt_from_sampling", "ALTER TABLE events ADD COLUMN last_exempt_from_sampling INTEGER;", "current_session_count", "ALTER TABLE events ADD COLUMN current_session_count INTEGER;"};
    public static final String[] zzb = {"origin", "ALTER TABLE user_attributes ADD COLUMN origin TEXT;"};
    public static final String[] zzc = {"app_version", "ALTER TABLE apps ADD COLUMN app_version TEXT;", "app_store", "ALTER TABLE apps ADD COLUMN app_store TEXT;", "gmp_version", "ALTER TABLE apps ADD COLUMN gmp_version INTEGER;", "dev_cert_hash", "ALTER TABLE apps ADD COLUMN dev_cert_hash INTEGER;", "measurement_enabled", "ALTER TABLE apps ADD COLUMN measurement_enabled INTEGER;", "last_bundle_start_timestamp", "ALTER TABLE apps ADD COLUMN last_bundle_start_timestamp INTEGER;", "day", "ALTER TABLE apps ADD COLUMN day INTEGER;", "daily_public_events_count", "ALTER TABLE apps ADD COLUMN daily_public_events_count INTEGER;", "daily_events_count", "ALTER TABLE apps ADD COLUMN daily_events_count INTEGER;", "daily_conversions_count", "ALTER TABLE apps ADD COLUMN daily_conversions_count INTEGER;", "remote_config", "ALTER TABLE apps ADD COLUMN remote_config BLOB;", "config_fetched_time", "ALTER TABLE apps ADD COLUMN config_fetched_time INTEGER;", "failed_config_fetch_time", "ALTER TABLE apps ADD COLUMN failed_config_fetch_time INTEGER;", "app_version_int", "ALTER TABLE apps ADD COLUMN app_version_int INTEGER;", "firebase_instance_id", "ALTER TABLE apps ADD COLUMN firebase_instance_id TEXT;", "daily_error_events_count", "ALTER TABLE apps ADD COLUMN daily_error_events_count INTEGER;", "daily_realtime_events_count", "ALTER TABLE apps ADD COLUMN daily_realtime_events_count INTEGER;", "health_monitor_sample", "ALTER TABLE apps ADD COLUMN health_monitor_sample TEXT;", "android_id", "ALTER TABLE apps ADD COLUMN android_id INTEGER;", "adid_reporting_enabled", "ALTER TABLE apps ADD COLUMN adid_reporting_enabled INTEGER;", "ssaid_reporting_enabled", "ALTER TABLE apps ADD COLUMN ssaid_reporting_enabled INTEGER;", "admob_app_id", "ALTER TABLE apps ADD COLUMN admob_app_id TEXT;", "linked_admob_app_id", "ALTER TABLE apps ADD COLUMN linked_admob_app_id TEXT;", "dynamite_version", "ALTER TABLE apps ADD COLUMN dynamite_version INTEGER;", "safelisted_events", "ALTER TABLE apps ADD COLUMN safelisted_events TEXT;", "ga_app_id", "ALTER TABLE apps ADD COLUMN ga_app_id TEXT;", "config_last_modified_time", "ALTER TABLE apps ADD COLUMN config_last_modified_time TEXT;", "e_tag", "ALTER TABLE apps ADD COLUMN e_tag TEXT;", "session_stitching_token", "ALTER TABLE apps ADD COLUMN session_stitching_token TEXT;"};
    public static final String[] zzd = {"realtime", "ALTER TABLE raw_events ADD COLUMN realtime INTEGER;"};
    public static final String[] zze = {"has_realtime", "ALTER TABLE queue ADD COLUMN has_realtime INTEGER;", "retry_count", "ALTER TABLE queue ADD COLUMN retry_count INTEGER;"};
    public static final String[] zzg = {"session_scoped", "ALTER TABLE event_filters ADD COLUMN session_scoped BOOLEAN;"};
    public static final String[] zzh = {"session_scoped", "ALTER TABLE property_filters ADD COLUMN session_scoped BOOLEAN;"};
    public static final String[] zzi = {"previous_install_count", "ALTER TABLE app2 ADD COLUMN previous_install_count INTEGER;"};
    public final zzak zzj;
    public final zzks zzk = new zzks(this.zzs.zzr);

    public zzal(zzli zzli) {
        super(zzli);
        zzaf zzaf = this.zzs.zzk;
        this.zzj = new zzak(this, this.zzs.zze);
    }

    public static final void zzV(ContentValues contentValues, String str, Object obj) {
        Preconditions.checkNotEmpty(HSLCriteriaBuilder.VALUE);
        Preconditions.checkNotNull(obj);
        if (obj instanceof String) {
            contentValues.put(HSLCriteriaBuilder.VALUE, (String) obj);
        } else if (obj instanceof Long) {
            contentValues.put(HSLCriteriaBuilder.VALUE, (Long) obj);
        } else if (obj instanceof Double) {
            contentValues.put(HSLCriteriaBuilder.VALUE, (Double) obj);
        } else {
            throw new IllegalArgumentException("Invalid value type");
        }
    }

    public final void zzA(String str, String str2) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        zzg();
        zzW();
        try {
            zzh().delete("user_attributes", "app_id=? and name=?", new String[]{str, str2});
        } catch (SQLiteException e2) {
            this.zzs.zzaz().zzd.zzd("Error deleting user property. appId", zzey.zzn(str), this.zzs.zzq.zzf(str2), e2);
        }
    }

    public final void zzC() {
        zzW();
        zzh().setTransactionSuccessful();
    }

    public final void zzD(zzg zzg2) {
        Preconditions.checkNotNull(zzg2);
        zzg();
        zzW();
        String zzt = zzg2.zzt();
        Preconditions.checkNotNull(zzt);
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", zzt);
        contentValues.put("app_instance_id", zzg2.zzu());
        contentValues.put("gmp_app_id", zzg2.zzy());
        zzg2.zza.zzaA().zzg();
        contentValues.put("resettable_device_id_hash", zzg2.zze);
        contentValues.put("last_bundle_index", Long.valueOf(zzg2.zzo()));
        contentValues.put("last_bundle_start_timestamp", Long.valueOf(zzg2.zzp()));
        contentValues.put("last_bundle_end_timestamp", Long.valueOf(zzg2.zzn()));
        contentValues.put("app_version", zzg2.zzw());
        contentValues.put("app_store", zzg2.zzv());
        contentValues.put("gmp_version", Long.valueOf(zzg2.zzm()));
        contentValues.put("dev_cert_hash", Long.valueOf(zzg2.zzj()));
        contentValues.put("measurement_enabled", Boolean.valueOf(zzg2.zzaj()));
        zzg2.zza.zzaA().zzg();
        contentValues.put("day", Long.valueOf(zzg2.zzw));
        zzg2.zza.zzaA().zzg();
        contentValues.put("daily_public_events_count", Long.valueOf(zzg2.zzx));
        zzg2.zza.zzaA().zzg();
        contentValues.put("daily_events_count", Long.valueOf(zzg2.zzy));
        zzg2.zza.zzaA().zzg();
        contentValues.put("daily_conversions_count", Long.valueOf(zzg2.zzz));
        zzg2.zza.zzaA().zzg();
        contentValues.put("config_fetched_time", Long.valueOf(zzg2.zzE));
        zzg2.zza.zzaA().zzg();
        contentValues.put("failed_config_fetch_time", Long.valueOf(zzg2.zzF));
        contentValues.put("app_version_int", Long.valueOf(zzg2.zzb()));
        contentValues.put("firebase_instance_id", zzg2.zzx());
        zzg2.zza.zzaA().zzg();
        contentValues.put("daily_error_events_count", Long.valueOf(zzg2.zzA));
        zzg2.zza.zzaA().zzg();
        contentValues.put("daily_realtime_events_count", Long.valueOf(zzg2.zzB));
        zzg2.zza.zzaA().zzg();
        contentValues.put("health_monitor_sample", zzg2.zzC);
        contentValues.put("android_id", Long.valueOf(zzg2.zza()));
        contentValues.put("adid_reporting_enabled", Boolean.valueOf(zzg2.zzai()));
        contentValues.put("admob_app_id", zzg2.zzr());
        contentValues.put("dynamite_version", Long.valueOf(zzg2.zzk()));
        zzg2.zza.zzaA().zzg();
        contentValues.put("session_stitching_token", zzg2.zzv);
        List zzC = zzg2.zzC();
        if (zzC != null) {
            if (zzC.isEmpty()) {
                this.zzs.zzaz().zzg.zzb("Safelisted events should not be an empty list. appId", zzt);
            } else {
                contentValues.put("safelisted_events", TextUtils.join(",", zzC));
            }
        }
        zznz.zzc();
        if (this.zzs.zzk.zzs(null, zzel.zzay) && !contentValues.containsKey("safelisted_events")) {
            contentValues.put("safelisted_events", null);
        }
        try {
            SQLiteDatabase zzh2 = zzh();
            if (((long) zzh2.update("apps", contentValues, "app_id = ?", new String[]{zzt})) == 0 && zzh2.insertWithOnConflict("apps", null, contentValues, 5) == -1) {
                this.zzs.zzaz().zzd.zzb("Failed to insert/update app (got -1). appId", zzey.zzn(zzt));
            }
        } catch (SQLiteException e2) {
            this.zzs.zzaz().zzd.zzc("Error storing app. appId", zzey.zzn(zzt), e2);
        }
    }

    public final void zzE(zzar zzar) {
        Preconditions.checkNotNull(zzar);
        zzg();
        zzW();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", zzar.zza);
        contentValues.put("name", zzar.zzb);
        contentValues.put("lifetime_count", Long.valueOf(zzar.zzc));
        contentValues.put("current_bundle_count", Long.valueOf(zzar.zzd));
        contentValues.put("last_fire_timestamp", Long.valueOf(zzar.zzf));
        contentValues.put("last_bundled_timestamp", Long.valueOf(zzar.zzg));
        contentValues.put("last_bundled_day", zzar.zzh);
        contentValues.put("last_sampled_complex_event_id", zzar.zzi);
        contentValues.put("last_sampling_rate", zzar.zzj);
        contentValues.put("current_session_count", Long.valueOf(zzar.zze));
        Boolean bool = zzar.zzk;
        contentValues.put("last_exempt_from_sampling", (bool == null || !bool.booleanValue()) ? null : Long.valueOf(1));
        try {
            if (zzh().insertWithOnConflict("events", null, contentValues, 5) == -1) {
                this.zzs.zzaz().zzd.zzb("Failed to insert/update event aggregates (got -1). appId", zzey.zzn(zzar.zza));
            }
        } catch (SQLiteException e2) {
            this.zzs.zzaz().zzd.zzc("Error storing event aggregates. appId", zzey.zzn(zzar.zza), e2);
        }
    }

    @VisibleForTesting
    public final boolean zzI() {
        zzgi zzgi = this.zzs;
        Context context = zzgi.zze;
        zzaf zzaf = zzgi.zzk;
        return context.getDatabasePath("google_app_measurement.db").exists();
    }

    public final boolean zzJ(String str, Long l, long j, zzfs zzfs) {
        zzg();
        zzW();
        Preconditions.checkNotNull(zzfs);
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(l);
        byte[] zzby = zzfs.zzby();
        this.zzs.zzaz().zzl.zzc("Saving complex main event, appId, data size", this.zzs.zzq.zzd(str), Integer.valueOf(zzby.length));
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("event_id", l);
        contentValues.put("children_to_process", Long.valueOf(j));
        contentValues.put("main_event", zzby);
        try {
            if (zzh().insertWithOnConflict("main_event_params", null, contentValues, 5) != -1) {
                return true;
            }
            this.zzs.zzaz().zzd.zzb("Failed to insert complex main event (got -1). appId", zzey.zzn(str));
            return false;
        } catch (SQLiteException e2) {
            this.zzs.zzaz().zzd.zzc("Error storing complex main event. appId", zzey.zzn(str), e2);
            return false;
        }
    }

    public final boolean zzK(zzab zzab) {
        Preconditions.checkNotNull(zzab);
        zzg();
        zzW();
        String str = zzab.zza;
        Preconditions.checkNotNull(str);
        if (zzp(str, zzab.zzc.zzb) == null) {
            long zzZ = zzZ("SELECT COUNT(1) FROM conditional_properties WHERE app_id=?", new String[]{str});
            zzaf zzaf = this.zzs.zzk;
            if (zzZ >= 1000) {
                return false;
            }
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("origin", zzab.zzb);
        contentValues.put("name", zzab.zzc.zzb);
        Object zza2 = zzab.zzc.zza();
        Preconditions.checkNotNull(zza2);
        zzV(contentValues, HSLCriteriaBuilder.VALUE, zza2);
        contentValues.put(AppStateModule.APP_STATE_ACTIVE, Boolean.valueOf(zzab.zze));
        contentValues.put("trigger_event_name", zzab.zzf);
        contentValues.put("trigger_timeout", Long.valueOf(zzab.zzh));
        contentValues.put("timed_out_event", this.zzs.zzv().zzao(zzab.zzg));
        contentValues.put("creation_timestamp", Long.valueOf(zzab.zzd));
        contentValues.put("triggered_event", this.zzs.zzv().zzao(zzab.zzi));
        contentValues.put("triggered_timestamp", Long.valueOf(zzab.zzc.zzc));
        contentValues.put("time_to_live", Long.valueOf(zzab.zzj));
        contentValues.put("expired_event", this.zzs.zzv().zzao(zzab.zzk));
        try {
            if (zzh().insertWithOnConflict("conditional_properties", null, contentValues, 5) == -1) {
                this.zzs.zzaz().zzd.zzb("Failed to insert/update conditional user property (got -1)", zzey.zzn(str));
            }
        } catch (SQLiteException e2) {
            this.zzs.zzaz().zzd.zzc("Error storing conditional user property", zzey.zzn(str), e2);
        }
        return true;
    }

    public final boolean zzL(zzln zzln) {
        Preconditions.checkNotNull(zzln);
        zzg();
        zzW();
        if (zzp(zzln.zza, zzln.zzc) == null) {
            if (zzlp.zzai(zzln.zzc)) {
                if (zzZ("select count(1) from user_attributes where app_id=? and name not like '!_%' escape '!'", new String[]{zzln.zza}) >= ((long) this.zzs.zzk.zzf(zzln.zza, zzel.zzF, 25, 100))) {
                    return false;
                }
            } else if (!"_npa".equals(zzln.zzc)) {
                long zzZ = zzZ("select count(1) from user_attributes where app_id=? and origin=? AND name like '!_%' escape '!'", new String[]{zzln.zza, zzln.zzb});
                zzaf zzaf = this.zzs.zzk;
                if (zzZ >= 25) {
                    return false;
                }
            }
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", zzln.zza);
        contentValues.put("origin", zzln.zzb);
        contentValues.put("name", zzln.zzc);
        contentValues.put("set_timestamp", Long.valueOf(zzln.zzd));
        zzV(contentValues, HSLCriteriaBuilder.VALUE, zzln.zze);
        try {
            if (zzh().insertWithOnConflict("user_attributes", null, contentValues, 5) == -1) {
                this.zzs.zzaz().zzd.zzb("Failed to insert/update user property (got -1). appId", zzey.zzn(zzln.zza));
            }
        } catch (SQLiteException e2) {
            this.zzs.zzaz().zzd.zzc("Error storing user property. appId", zzey.zzn(zzln.zza), e2);
        }
        return true;
    }

    /* JADX WARNING: type inference failed for: r3v0 */
    /* JADX WARNING: type inference failed for: r3v1, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r4v0, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r3v2, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r3v3 */
    /* JADX WARNING: type inference failed for: r4v1 */
    /* JADX WARNING: type inference failed for: r3v5 */
    /* JADX WARNING: type inference failed for: r4v3 */
    /* JADX WARNING: type inference failed for: r3v6 */
    /* JADX WARNING: type inference failed for: r4v4 */
    /* JADX WARNING: type inference failed for: r3v7 */
    /* JADX WARNING: type inference failed for: r16v0, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r3v8 */
    /* JADX WARNING: type inference failed for: r3v9 */
    /* JADX WARNING: type inference failed for: r4v6 */
    /* JADX WARNING: type inference failed for: r3v10 */
    /* JADX WARNING: type inference failed for: r8v0, types: [java.lang.String[]] */
    /* JADX WARNING: type inference failed for: r3v11, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r5v7 */
    /* JADX WARNING: type inference failed for: r8v1, types: [java.lang.String[]] */
    /* JADX WARNING: type inference failed for: r3v12, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r5v11, types: [java.lang.String[]] */
    /* JADX WARNING: type inference failed for: r5v12, types: [java.lang.String[]] */
    /* JADX WARNING: type inference failed for: r4v30, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r4v34, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r3v13, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r3v14 */
    /* JADX WARNING: type inference failed for: r3v15 */
    /* JADX WARNING: type inference failed for: r3v16 */
    /* JADX WARNING: type inference failed for: r3v17 */
    /* JADX WARNING: type inference failed for: r3v18 */
    /* JADX WARNING: type inference failed for: r3v19 */
    /* JADX WARNING: type inference failed for: r3v20 */
    /* JADX WARNING: type inference failed for: r3v21 */
    /* JADX WARNING: type inference failed for: r3v22 */
    /* JADX WARNING: type inference failed for: r3v23 */
    /* JADX WARNING: type inference failed for: r3v24 */
    /* JADX WARNING: type inference failed for: r3v25 */
    /* JADX WARNING: type inference failed for: r3v26 */
    /* JADX WARNING: type inference failed for: r4v35 */
    /* JADX WARNING: type inference failed for: r3v27 */
    /* JADX WARNING: type inference failed for: r3v28 */
    /* JADX WARNING: type inference failed for: r3v29 */
    /* JADX WARNING: type inference failed for: r3v30 */
    /* JADX WARNING: type inference failed for: r3v31 */
    /* JADX WARNING: type inference failed for: r3v32 */
    /* JADX WARNING: type inference failed for: r3v33 */
    /* JADX WARNING: type inference failed for: r3v34 */
    /* JADX WARNING: type inference failed for: r3v35 */
    /* JADX WARNING: type inference failed for: r3v36 */
    /* JADX WARNING: type inference failed for: r3v37 */
    /* JADX WARNING: type inference failed for: r3v38 */
    /* JADX WARNING: type inference failed for: r3v39 */
    /* JADX WARNING: type inference failed for: r3v40 */
    /* JADX WARNING: type inference failed for: r3v41 */
    /* JADX WARNING: type inference failed for: r3v42 */
    /* JADX WARNING: type inference failed for: r3v43 */
    /* JADX WARNING: type inference failed for: r3v44 */
    /* JADX WARNING: type inference failed for: r3v45 */
    /* JADX WARNING: type inference failed for: r5v26 */
    /* JADX WARNING: type inference failed for: r5v27 */
    /* JADX WARNING: type inference failed for: r4v36 */
    /* JADX WARNING: type inference failed for: r4v37 */
    /* JADX WARNING: type inference failed for: r4v38 */
    /* JADX WARNING: type inference failed for: r4v39 */
    /* JADX WARNING: type inference failed for: r4v40 */
    /* JADX WARNING: type inference failed for: r4v41 */
    /* JADX WARNING: type inference failed for: r4v42 */
    /* JADX WARNING: type inference failed for: r4v43 */
    /* JADX WARNING: type inference failed for: r3v46 */
    /* JADX WARNING: type inference failed for: r3v47 */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x01e1, code lost:
        r0 = th;
        r3 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x01e9, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:0x01ea, code lost:
        r4 = 0;
        r3 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:92:0x01fe, code lost:
        r4.close();
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r3v5
      assigns: []
      uses: []
      mth insns count: 231
    	at jadx.core.dex.visitors.typeinference.TypeSearch.fillTypeCandidates(TypeSearch.java:237)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
    	at jadx.core.dex.visitors.typeinference.TypeSearch.run(TypeSearch.java:53)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runMultiVariableSearch(TypeInferenceVisitor.java:104)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:97)
     */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x01e1 A[ExcHandler: all (th java.lang.Throwable), PHI: r3 
      PHI: (r3v5 ?) = (r3v14 ?), (r3v16 ?), (r3v21 ?), (r3v22 ?), (r3v25 ?), (r3v29 ?), (r3v31 ?), (r3v33 ?), (r3v35 ?), (r3v37 ?), (r3v39 ?), (r3v41 ?), (r3v43 ?), (r3v45 ?) binds: [B:1:0x000e, B:28:0x0085, B:23:0x0072, B:12:0x003e, B:7:0x0023, B:38:0x00b7, B:44:0x00ef, B:80:0x01cc, B:81:?, B:48:0x0103, B:74:0x01b4, B:75:?, B:68:0x0199, B:61:0x0178] A[DONT_GENERATE, DONT_INLINE], Splitter:B:1:0x000e] */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x01fe  */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x0206  */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:28:0x0085=Splitter:B:28:0x0085, B:12:0x003e=Splitter:B:12:0x003e} */
    /* JADX WARNING: Unknown variable types count: 18 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzU(java.lang.String r21, long r22, long r24, com.google.android.gms.measurement.internal.zzlf r26) {
        /*
            r20 = this;
            r1 = r20
            r2 = r26
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r26)
            r20.zzg()
            r20.zzW()
            r3 = 0
            android.database.sqlite.SQLiteDatabase r0 = r20.zzh()     // Catch:{ SQLiteException -> 0x01e9, all -> 0x01e1 }
            boolean r4 = android.text.TextUtils.isEmpty(r3)     // Catch:{ SQLiteException -> 0x01e9, all -> 0x01e1 }
            java.lang.String r5 = ""
            r13 = -1
            r15 = 0
            r12 = 1
            r11 = 2
            if (r4 == 0) goto L_0x006e
            int r4 = (r24 > r13 ? 1 : (r24 == r13 ? 0 : -1))
            if (r4 == 0) goto L_0x0032
            java.lang.String[] r6 = new java.lang.String[r11]     // Catch:{ SQLiteException -> 0x01e9, all -> 0x01e1 }
            java.lang.String r7 = java.lang.String.valueOf(r24)     // Catch:{ SQLiteException -> 0x01e9, all -> 0x01e1 }
            r6[r15] = r7     // Catch:{ SQLiteException -> 0x01e9, all -> 0x01e1 }
            java.lang.String r7 = java.lang.String.valueOf(r22)     // Catch:{ SQLiteException -> 0x01e9, all -> 0x01e1 }
            r6[r12] = r7     // Catch:{ SQLiteException -> 0x01e9, all -> 0x01e1 }
            goto L_0x003a
        L_0x0032:
            java.lang.String[] r6 = new java.lang.String[r12]     // Catch:{ SQLiteException -> 0x01e9, all -> 0x01e1 }
            java.lang.String r7 = java.lang.String.valueOf(r22)     // Catch:{ SQLiteException -> 0x01e9, all -> 0x01e1 }
            r6[r15] = r7     // Catch:{ SQLiteException -> 0x01e9, all -> 0x01e1 }
        L_0x003a:
            if (r4 == 0) goto L_0x003e
            java.lang.String r5 = "rowid <= ? and "
        L_0x003e:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ SQLiteException -> 0x01e9, all -> 0x01e1 }
            r4.<init>()     // Catch:{ SQLiteException -> 0x01e9, all -> 0x01e1 }
            java.lang.String r7 = "select app_id, metadata_fingerprint from raw_events where "
            r4.append(r7)     // Catch:{ SQLiteException -> 0x01e9, all -> 0x01e1 }
            r4.append(r5)     // Catch:{ SQLiteException -> 0x01e9, all -> 0x01e1 }
            java.lang.String r5 = "app_id in (select app_id from apps where config_fetched_time >= ?) order by rowid limit 1;"
            r4.append(r5)     // Catch:{ SQLiteException -> 0x01e9, all -> 0x01e1 }
            java.lang.String r4 = r4.toString()     // Catch:{ SQLiteException -> 0x01e9, all -> 0x01e1 }
            android.database.Cursor r4 = r0.rawQuery(r4, r6)     // Catch:{ SQLiteException -> 0x01e9, all -> 0x01e1 }
            boolean r5 = r4.moveToFirst()     // Catch:{ SQLiteException -> 0x01e7 }
            if (r5 != 0) goto L_0x0062
            r4.close()
            return
        L_0x0062:
            java.lang.String r3 = r4.getString(r15)     // Catch:{ SQLiteException -> 0x01e7 }
            java.lang.String r5 = r4.getString(r12)     // Catch:{ SQLiteException -> 0x01e7 }
            r4.close()     // Catch:{ SQLiteException -> 0x01e7 }
            goto L_0x00b0
        L_0x006e:
            int r4 = (r24 > r13 ? 1 : (r24 == r13 ? 0 : -1))
            if (r4 == 0) goto L_0x007d
            java.lang.String[] r6 = new java.lang.String[r11]     // Catch:{ SQLiteException -> 0x01e9, all -> 0x01e1 }
            r6[r15] = r3     // Catch:{ SQLiteException -> 0x01e9, all -> 0x01e1 }
            java.lang.String r7 = java.lang.String.valueOf(r24)     // Catch:{ SQLiteException -> 0x01e9, all -> 0x01e1 }
            r6[r12] = r7     // Catch:{ SQLiteException -> 0x01e9, all -> 0x01e1 }
            goto L_0x0081
        L_0x007d:
            java.lang.String[] r6 = new java.lang.String[]{r3}     // Catch:{ SQLiteException -> 0x01e9, all -> 0x01e1 }
        L_0x0081:
            if (r4 == 0) goto L_0x0085
            java.lang.String r5 = " and rowid <= ?"
        L_0x0085:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ SQLiteException -> 0x01e9, all -> 0x01e1 }
            r4.<init>()     // Catch:{ SQLiteException -> 0x01e9, all -> 0x01e1 }
            java.lang.String r7 = "select metadata_fingerprint from raw_events where app_id = ?"
            r4.append(r7)     // Catch:{ SQLiteException -> 0x01e9, all -> 0x01e1 }
            r4.append(r5)     // Catch:{ SQLiteException -> 0x01e9, all -> 0x01e1 }
            java.lang.String r5 = " order by rowid limit 1;"
            r4.append(r5)     // Catch:{ SQLiteException -> 0x01e9, all -> 0x01e1 }
            java.lang.String r4 = r4.toString()     // Catch:{ SQLiteException -> 0x01e9, all -> 0x01e1 }
            android.database.Cursor r4 = r0.rawQuery(r4, r6)     // Catch:{ SQLiteException -> 0x01e9, all -> 0x01e1 }
            boolean r5 = r4.moveToFirst()     // Catch:{ SQLiteException -> 0x01e7 }
            if (r5 != 0) goto L_0x00a9
            r4.close()
            return
        L_0x00a9:
            java.lang.String r5 = r4.getString(r15)     // Catch:{ SQLiteException -> 0x01e7 }
            r4.close()     // Catch:{ SQLiteException -> 0x01e7 }
        L_0x00b0:
            r16 = r3
            r3 = r4
            r17 = r5
            java.lang.String r4 = "metadata"
            java.lang.String[] r6 = new java.lang.String[]{r4}     // Catch:{ SQLiteException -> 0x01c9, all -> 0x01e1 }
            java.lang.String[] r8 = new java.lang.String[r11]     // Catch:{ SQLiteException -> 0x01c9, all -> 0x01e1 }
            r8[r15] = r16     // Catch:{ SQLiteException -> 0x01c9, all -> 0x01e1 }
            r8[r12] = r17     // Catch:{ SQLiteException -> 0x01c9, all -> 0x01e1 }
            java.lang.String r5 = "raw_events_metadata"
            java.lang.String r7 = "app_id = ? and metadata_fingerprint = ?"
            r9 = 0
            r10 = 0
            java.lang.String r18 = "rowid"
            java.lang.String r19 = "2"
            r4 = r0
            r11 = r18
            r12 = r19
            android.database.Cursor r3 = r4.query(r5, r6, r7, r8, r9, r10, r11, r12)     // Catch:{ SQLiteException -> 0x01c9, all -> 0x01e1 }
            boolean r4 = r3.moveToFirst()     // Catch:{ SQLiteException -> 0x01c9, all -> 0x01e1 }
            if (r4 != 0) goto L_0x00ef
            com.google.android.gms.measurement.internal.zzgi r0 = r1.zzs     // Catch:{ SQLiteException -> 0x01c9, all -> 0x01e1 }
            com.google.android.gms.measurement.internal.zzey r0 = r0.zzaz()     // Catch:{ SQLiteException -> 0x01c9, all -> 0x01e1 }
            com.google.android.gms.measurement.internal.zzew r0 = r0.zzd     // Catch:{ SQLiteException -> 0x01c9, all -> 0x01e1 }
            java.lang.String r2 = "Raw event metadata record is missing. appId"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzey.zzn(r16)     // Catch:{ SQLiteException -> 0x01c9, all -> 0x01e1 }
            r0.zzb(r2, r4)     // Catch:{ SQLiteException -> 0x01c9, all -> 0x01e1 }
            r3.close()
            return
        L_0x00ef:
            byte[] r4 = r3.getBlob(r15)     // Catch:{ SQLiteException -> 0x01c9, all -> 0x01e1 }
            com.google.android.gms.internal.measurement.zzgb r5 = com.google.android.gms.internal.measurement.zzgc.zzu()     // Catch:{ IOException -> 0x01cb }
            com.google.android.gms.internal.measurement.zzli r4 = com.google.android.gms.measurement.internal.zzlk.zzl(r5, r4)     // Catch:{ IOException -> 0x01cb }
            com.google.android.gms.internal.measurement.zzgb r4 = (com.google.android.gms.internal.measurement.zzgb) r4     // Catch:{ IOException -> 0x01cb }
            com.google.android.gms.internal.measurement.zzkc r4 = r4.zzaE()     // Catch:{ IOException -> 0x01cb }
            com.google.android.gms.internal.measurement.zzgc r4 = (com.google.android.gms.internal.measurement.zzgc) r4     // Catch:{ IOException -> 0x01cb }
            boolean r5 = r3.moveToNext()     // Catch:{ SQLiteException -> 0x01c9, all -> 0x01e1 }
            if (r5 == 0) goto L_0x011a
            com.google.android.gms.measurement.internal.zzgi r5 = r1.zzs     // Catch:{ SQLiteException -> 0x01c9, all -> 0x01e1 }
            com.google.android.gms.measurement.internal.zzey r5 = r5.zzaz()     // Catch:{ SQLiteException -> 0x01c9, all -> 0x01e1 }
            com.google.android.gms.measurement.internal.zzew r5 = r5.zzg     // Catch:{ SQLiteException -> 0x01c9, all -> 0x01e1 }
            java.lang.String r6 = "Get multiple raw event metadata records, expected one. appId"
            java.lang.Object r7 = com.google.android.gms.measurement.internal.zzey.zzn(r16)     // Catch:{ SQLiteException -> 0x01c9, all -> 0x01e1 }
            r5.zzb(r6, r7)     // Catch:{ SQLiteException -> 0x01c9, all -> 0x01e1 }
        L_0x011a:
            r3.close()     // Catch:{ SQLiteException -> 0x01c9, all -> 0x01e1 }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r4)     // Catch:{ SQLiteException -> 0x01c9, all -> 0x01e1 }
            r2.zza = r4     // Catch:{ SQLiteException -> 0x01c9, all -> 0x01e1 }
            r12 = 3
            int r4 = (r24 > r13 ? 1 : (r24 == r13 ? 0 : -1))
            if (r4 == 0) goto L_0x0138
            java.lang.String r4 = "app_id = ? and metadata_fingerprint = ? and rowid <= ?"
            java.lang.String[] r5 = new java.lang.String[r12]     // Catch:{ SQLiteException -> 0x01c9, all -> 0x01e1 }
            r5[r15] = r16     // Catch:{ SQLiteException -> 0x01c9, all -> 0x01e1 }
            r13 = 1
            r5[r13] = r17     // Catch:{ SQLiteException -> 0x01c9, all -> 0x01e1 }
            java.lang.String r6 = java.lang.String.valueOf(r24)     // Catch:{ SQLiteException -> 0x01c9, all -> 0x01e1 }
            r14 = 2
            r5[r14] = r6     // Catch:{ SQLiteException -> 0x01c9, all -> 0x01e1 }
            goto L_0x0142
        L_0x0138:
            r13 = 1
            r14 = 2
            java.lang.String r4 = "app_id = ? and metadata_fingerprint = ?"
            java.lang.String[] r5 = new java.lang.String[r14]     // Catch:{ SQLiteException -> 0x01c9, all -> 0x01e1 }
            r5[r15] = r16     // Catch:{ SQLiteException -> 0x01c9, all -> 0x01e1 }
            r5[r13] = r17     // Catch:{ SQLiteException -> 0x01c9, all -> 0x01e1 }
        L_0x0142:
            r7 = r4
            r8 = r5
            java.lang.String r4 = "rowid"
            java.lang.String r5 = "name"
            java.lang.String r6 = "timestamp"
            java.lang.String r9 = "data"
            java.lang.String[] r6 = new java.lang.String[]{r4, r5, r6, r9}     // Catch:{ SQLiteException -> 0x01c9, all -> 0x01e1 }
            java.lang.String r5 = "raw_events"
            r9 = 0
            r10 = 0
            java.lang.String r11 = "rowid"
            r17 = 0
            r4 = r0
            r14 = 3
            r12 = r17
            android.database.Cursor r3 = r4.query(r5, r6, r7, r8, r9, r10, r11, r12)     // Catch:{ SQLiteException -> 0x01c9, all -> 0x01e1 }
            boolean r0 = r3.moveToFirst()     // Catch:{ SQLiteException -> 0x01c9, all -> 0x01e1 }
            if (r0 == 0) goto L_0x01b4
        L_0x0166:
            long r4 = r3.getLong(r15)     // Catch:{ SQLiteException -> 0x01c9, all -> 0x01e1 }
            byte[] r0 = r3.getBlob(r14)     // Catch:{ SQLiteException -> 0x01c9, all -> 0x01e1 }
            com.google.android.gms.internal.measurement.zzfr r6 = com.google.android.gms.internal.measurement.zzfs.zze()     // Catch:{ IOException -> 0x0197 }
            com.google.android.gms.internal.measurement.zzli r0 = com.google.android.gms.measurement.internal.zzlk.zzl(r6, r0)     // Catch:{ IOException -> 0x0197 }
            com.google.android.gms.internal.measurement.zzfr r0 = (com.google.android.gms.internal.measurement.zzfr) r0     // Catch:{ IOException -> 0x0197 }
            java.lang.String r6 = r3.getString(r13)     // Catch:{ SQLiteException -> 0x01c9, all -> 0x01e1 }
            r0.zzi(r6)     // Catch:{ SQLiteException -> 0x01c9, all -> 0x01e1 }
            r6 = 2
            long r7 = r3.getLong(r6)     // Catch:{ SQLiteException -> 0x01c9, all -> 0x01e1 }
            r0.zzm(r7)     // Catch:{ SQLiteException -> 0x01c9, all -> 0x01e1 }
            com.google.android.gms.internal.measurement.zzkc r0 = r0.zzaE()     // Catch:{ SQLiteException -> 0x01c9, all -> 0x01e1 }
            com.google.android.gms.internal.measurement.zzfs r0 = (com.google.android.gms.internal.measurement.zzfs) r0     // Catch:{ SQLiteException -> 0x01c9, all -> 0x01e1 }
            boolean r0 = r2.zza(r4, r0)     // Catch:{ SQLiteException -> 0x01c9, all -> 0x01e1 }
            if (r0 != 0) goto L_0x01aa
            r3.close()
            return
        L_0x0197:
            r0 = move-exception
            r6 = 2
            com.google.android.gms.measurement.internal.zzgi r4 = r1.zzs     // Catch:{ SQLiteException -> 0x01c9, all -> 0x01e1 }
            com.google.android.gms.measurement.internal.zzey r4 = r4.zzaz()     // Catch:{ SQLiteException -> 0x01c9, all -> 0x01e1 }
            com.google.android.gms.measurement.internal.zzew r4 = r4.zzd     // Catch:{ SQLiteException -> 0x01c9, all -> 0x01e1 }
            java.lang.String r5 = "Data loss. Failed to merge raw event. appId"
            java.lang.Object r7 = com.google.android.gms.measurement.internal.zzey.zzn(r16)     // Catch:{ SQLiteException -> 0x01c9, all -> 0x01e1 }
            r4.zzc(r5, r7, r0)     // Catch:{ SQLiteException -> 0x01c9, all -> 0x01e1 }
        L_0x01aa:
            boolean r0 = r3.moveToNext()     // Catch:{ SQLiteException -> 0x01c9, all -> 0x01e1 }
            if (r0 != 0) goto L_0x0166
            r3.close()
            return
        L_0x01b4:
            com.google.android.gms.measurement.internal.zzgi r0 = r1.zzs     // Catch:{ SQLiteException -> 0x01c9, all -> 0x01e1 }
            com.google.android.gms.measurement.internal.zzey r0 = r0.zzaz()     // Catch:{ SQLiteException -> 0x01c9, all -> 0x01e1 }
            com.google.android.gms.measurement.internal.zzew r0 = r0.zzg     // Catch:{ SQLiteException -> 0x01c9, all -> 0x01e1 }
            java.lang.String r2 = "Raw event data disappeared while in transaction. appId"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzey.zzn(r16)     // Catch:{ SQLiteException -> 0x01c9, all -> 0x01e1 }
            r0.zzb(r2, r4)     // Catch:{ SQLiteException -> 0x01c9, all -> 0x01e1 }
            r3.close()
            return
        L_0x01c9:
            r0 = move-exception
            goto L_0x01e3
        L_0x01cb:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzgi r2 = r1.zzs     // Catch:{ SQLiteException -> 0x01c9, all -> 0x01e1 }
            com.google.android.gms.measurement.internal.zzey r2 = r2.zzaz()     // Catch:{ SQLiteException -> 0x01c9, all -> 0x01e1 }
            com.google.android.gms.measurement.internal.zzew r2 = r2.zzd     // Catch:{ SQLiteException -> 0x01c9, all -> 0x01e1 }
            java.lang.String r4 = "Data loss. Failed to merge raw event metadata. appId"
            java.lang.Object r5 = com.google.android.gms.measurement.internal.zzey.zzn(r16)     // Catch:{ SQLiteException -> 0x01c9, all -> 0x01e1 }
            r2.zzc(r4, r5, r0)     // Catch:{ SQLiteException -> 0x01c9, all -> 0x01e1 }
            r3.close()
            return
        L_0x01e1:
            r0 = move-exception
            goto L_0x0204
        L_0x01e3:
            r4 = r3
            r3 = r16
            goto L_0x01eb
        L_0x01e7:
            r0 = move-exception
            goto L_0x01eb
        L_0x01e9:
            r0 = move-exception
            r4 = r3
        L_0x01eb:
            com.google.android.gms.measurement.internal.zzgi r2 = r1.zzs     // Catch:{ all -> 0x0202 }
            com.google.android.gms.measurement.internal.zzey r2 = r2.zzaz()     // Catch:{ all -> 0x0202 }
            com.google.android.gms.measurement.internal.zzew r2 = r2.zzd     // Catch:{ all -> 0x0202 }
            java.lang.String r5 = "Data loss. Error selecting raw event. appId"
            java.lang.Object r3 = com.google.android.gms.measurement.internal.zzey.zzn(r3)     // Catch:{ all -> 0x0202 }
            r2.zzc(r5, r3, r0)     // Catch:{ all -> 0x0202 }
            if (r4 == 0) goto L_0x0201
            r4.close()
        L_0x0201:
            return
        L_0x0202:
            r0 = move-exception
            r3 = r4
        L_0x0204:
            if (r3 == 0) goto L_0x0209
            r3.close()
        L_0x0209:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzal.zzU(java.lang.String, long, long, com.google.android.gms.measurement.internal.zzlf):void");
    }

    public final long zzZ(String str, String[] strArr) {
        Cursor cursor = null;
        try {
            cursor = zzh().rawQuery(str, strArr);
            if (cursor.moveToFirst()) {
                long j = cursor.getLong(0);
                cursor.close();
                return j;
            }
            throw new SQLiteException("Database returned empty set");
        } catch (SQLiteException e2) {
            this.zzs.zzaz().zzd.zzc("Database error", str, e2);
            throw e2;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    public final int zza(String str, String str2) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        zzg();
        zzW();
        try {
            return zzh().delete("conditional_properties", "app_id=? and name=?", new String[]{str, str2});
        } catch (SQLiteException e2) {
            this.zzs.zzaz().zzd.zzd("Error deleting conditional property", zzey.zzn(str), this.zzs.zzq.zzf(str2), e2);
            return 0;
        }
    }

    public final long zzaa(String str, String[] strArr, long j) {
        Cursor cursor = null;
        try {
            Cursor rawQuery = zzh().rawQuery(str, strArr);
            if (rawQuery.moveToFirst()) {
                long j2 = rawQuery.getLong(0);
                rawQuery.close();
                return j2;
            }
            rawQuery.close();
            return j;
        } catch (SQLiteException e2) {
            this.zzs.zzaz().zzd.zzc("Database error", str, e2);
            throw e2;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    public final boolean zzb() {
        return false;
    }

    /* JADX INFO: finally extract failed */
    @VisibleForTesting
    public final long zzc(String str, String str2) {
        long j;
        String str3 = str;
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty("first_open_count");
        zzg();
        zzW();
        SQLiteDatabase zzh2 = zzh();
        zzh2.beginTransaction();
        long j2 = 0;
        try {
            j = zzaa("select first_open_count from app2 where app_id=?", new String[]{str3}, -1);
            if (j == -1) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("app_id", str3);
                Integer valueOf = Integer.valueOf(0);
                contentValues.put("first_open_count", valueOf);
                contentValues.put("previous_install_count", valueOf);
                if (zzh2.insertWithOnConflict("app2", null, contentValues, 5) == -1) {
                    this.zzs.zzaz().zzd.zzc("Failed to insert column (got -1). appId", zzey.zzn(str), "first_open_count");
                    zzh2.endTransaction();
                    return -1;
                }
                j = 0;
            }
            try {
                ContentValues contentValues2 = new ContentValues();
                contentValues2.put("app_id", str3);
                contentValues2.put("first_open_count", Long.valueOf(1 + j));
                if (((long) zzh2.update("app2", contentValues2, "app_id = ?", new String[]{str3})) == 0) {
                    this.zzs.zzaz().zzd.zzc("Failed to update column (got 0). appId", zzey.zzn(str), "first_open_count");
                    zzh2.endTransaction();
                    return -1;
                }
                zzh2.setTransactionSuccessful();
                zzh2.endTransaction();
                return j;
            } catch (SQLiteException e2) {
                e = e2;
                j2 = j;
                try {
                    this.zzs.zzaz().zzd.zzd("Error inserting column. appId", zzey.zzn(str), "first_open_count", e);
                    zzh2.endTransaction();
                    j = j2;
                    return j;
                } catch (Throwable th) {
                    zzh2.endTransaction();
                    throw th;
                }
            }
        } catch (SQLiteException e3) {
            e = e3;
            this.zzs.zzaz().zzd.zzd("Error inserting column. appId", zzey.zzn(str), "first_open_count", e);
            zzh2.endTransaction();
            j = j2;
            return j;
        }
    }

    public final long zzf(String str) {
        Preconditions.checkNotEmpty(str);
        return zzaa("select count(1) from events where app_id=? and name not like '!_%' escape '!'", new String[]{str}, 0);
    }

    @VisibleForTesting
    public final SQLiteDatabase zzh() {
        zzg();
        try {
            return this.zzj.getWritableDatabase();
        } catch (SQLiteException e2) {
            this.zzs.zzaz().zzg.zzb("Error opening database", e2);
            throw e2;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:43:0x00ce  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00d6  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.os.Bundle zzi(java.lang.String r8) {
        /*
            r7 = this;
            r7.zzg()
            r7.zzW()
            r0 = 0
            android.database.sqlite.SQLiteDatabase r1 = r7.zzh()     // Catch:{ SQLiteException -> 0x00bd, all -> 0x00bb }
            r2 = 1
            java.lang.String[] r2 = new java.lang.String[r2]     // Catch:{ SQLiteException -> 0x00bd, all -> 0x00bb }
            r3 = 0
            r2[r3] = r8     // Catch:{ SQLiteException -> 0x00bd, all -> 0x00bb }
            java.lang.String r4 = "select parameters from default_event_params where app_id=?"
            android.database.Cursor r1 = r1.rawQuery(r4, r2)     // Catch:{ SQLiteException -> 0x00bd, all -> 0x00bb }
            boolean r2 = r1.moveToFirst()     // Catch:{ SQLiteException -> 0x002e }
            if (r2 != 0) goto L_0x0031
            com.google.android.gms.measurement.internal.zzgi r8 = r7.zzs     // Catch:{ SQLiteException -> 0x002e }
            com.google.android.gms.measurement.internal.zzey r8 = r8.zzaz()     // Catch:{ SQLiteException -> 0x002e }
            com.google.android.gms.measurement.internal.zzew r8 = r8.zzl     // Catch:{ SQLiteException -> 0x002e }
            java.lang.String r2 = "Default event parameters not found"
            r8.zza(r2)     // Catch:{ SQLiteException -> 0x002e }
            r1.close()
            return r0
        L_0x002e:
            r8 = move-exception
            goto L_0x00bf
        L_0x0031:
            byte[] r2 = r1.getBlob(r3)     // Catch:{ SQLiteException -> 0x002e }
            com.google.android.gms.internal.measurement.zzfr r3 = com.google.android.gms.internal.measurement.zzfs.zze()     // Catch:{ IOException -> 0x00a5 }
            com.google.android.gms.internal.measurement.zzli r2 = com.google.android.gms.measurement.internal.zzlk.zzl(r3, r2)     // Catch:{ IOException -> 0x00a5 }
            com.google.android.gms.internal.measurement.zzfr r2 = (com.google.android.gms.internal.measurement.zzfr) r2     // Catch:{ IOException -> 0x00a5 }
            com.google.android.gms.internal.measurement.zzkc r2 = r2.zzaE()     // Catch:{ IOException -> 0x00a5 }
            com.google.android.gms.internal.measurement.zzfs r2 = (com.google.android.gms.internal.measurement.zzfs) r2     // Catch:{ IOException -> 0x00a5 }
            com.google.android.gms.measurement.internal.zzli r8 = r7.zzf     // Catch:{ SQLiteException -> 0x002e }
            com.google.android.gms.measurement.internal.zzlk r8 = r8.zzi     // Catch:{ SQLiteException -> 0x002e }
            com.google.android.gms.measurement.internal.zzli.zzak(r8)     // Catch:{ SQLiteException -> 0x002e }
            java.util.List r8 = r2.zzi()     // Catch:{ SQLiteException -> 0x002e }
            android.os.Bundle r2 = new android.os.Bundle     // Catch:{ SQLiteException -> 0x002e }
            r2.<init>()     // Catch:{ SQLiteException -> 0x002e }
            java.util.Iterator r8 = r8.iterator()     // Catch:{ SQLiteException -> 0x002e }
        L_0x0059:
            boolean r3 = r8.hasNext()     // Catch:{ SQLiteException -> 0x002e }
            if (r3 == 0) goto L_0x00a1
            java.lang.Object r3 = r8.next()     // Catch:{ SQLiteException -> 0x002e }
            com.google.android.gms.internal.measurement.zzfw r3 = (com.google.android.gms.internal.measurement.zzfw) r3     // Catch:{ SQLiteException -> 0x002e }
            java.lang.String r4 = r3.zzg()     // Catch:{ SQLiteException -> 0x002e }
            boolean r5 = r3.zzu()     // Catch:{ SQLiteException -> 0x002e }
            if (r5 == 0) goto L_0x0077
            double r5 = r3.zza()     // Catch:{ SQLiteException -> 0x002e }
            r2.putDouble(r4, r5)     // Catch:{ SQLiteException -> 0x002e }
            goto L_0x0059
        L_0x0077:
            boolean r5 = r3.zzv()     // Catch:{ SQLiteException -> 0x002e }
            if (r5 == 0) goto L_0x0085
            float r3 = r3.zzb()     // Catch:{ SQLiteException -> 0x002e }
            r2.putFloat(r4, r3)     // Catch:{ SQLiteException -> 0x002e }
            goto L_0x0059
        L_0x0085:
            boolean r5 = r3.zzy()     // Catch:{ SQLiteException -> 0x002e }
            if (r5 == 0) goto L_0x0093
            java.lang.String r3 = r3.zzh()     // Catch:{ SQLiteException -> 0x002e }
            r2.putString(r4, r3)     // Catch:{ SQLiteException -> 0x002e }
            goto L_0x0059
        L_0x0093:
            boolean r5 = r3.zzw()     // Catch:{ SQLiteException -> 0x002e }
            if (r5 == 0) goto L_0x0059
            long r5 = r3.zzd()     // Catch:{ SQLiteException -> 0x002e }
            r2.putLong(r4, r5)     // Catch:{ SQLiteException -> 0x002e }
            goto L_0x0059
        L_0x00a1:
            r1.close()
            return r2
        L_0x00a5:
            r2 = move-exception
            com.google.android.gms.measurement.internal.zzgi r3 = r7.zzs     // Catch:{ SQLiteException -> 0x002e }
            com.google.android.gms.measurement.internal.zzey r3 = r3.zzaz()     // Catch:{ SQLiteException -> 0x002e }
            com.google.android.gms.measurement.internal.zzew r3 = r3.zzd     // Catch:{ SQLiteException -> 0x002e }
            java.lang.String r4 = "Failed to retrieve default event parameters. appId"
            java.lang.Object r8 = com.google.android.gms.measurement.internal.zzey.zzn(r8)     // Catch:{ SQLiteException -> 0x002e }
            r3.zzc(r4, r8, r2)     // Catch:{ SQLiteException -> 0x002e }
            r1.close()
            return r0
        L_0x00bb:
            r8 = move-exception
            goto L_0x00d4
        L_0x00bd:
            r8 = move-exception
            r1 = r0
        L_0x00bf:
            com.google.android.gms.measurement.internal.zzgi r2 = r7.zzs     // Catch:{ all -> 0x00d2 }
            com.google.android.gms.measurement.internal.zzey r2 = r2.zzaz()     // Catch:{ all -> 0x00d2 }
            com.google.android.gms.measurement.internal.zzew r2 = r2.zzd     // Catch:{ all -> 0x00d2 }
            java.lang.String r3 = "Error selecting default event parameters"
            r2.zzb(r3, r8)     // Catch:{ all -> 0x00d2 }
            if (r1 == 0) goto L_0x00d1
            r1.close()
        L_0x00d1:
            return r0
        L_0x00d2:
            r8 = move-exception
            r0 = r1
        L_0x00d4:
            if (r0 == 0) goto L_0x00d9
            r0.close()
        L_0x00d9:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzal.zzi(java.lang.String):android.os.Bundle");
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x00f0 A[Catch:{ SQLiteException -> 0x026b }] */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x00f2 A[Catch:{ SQLiteException -> 0x026b }] */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x010f A[Catch:{ SQLiteException -> 0x026b }] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0111 A[Catch:{ SQLiteException -> 0x026b }] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x012e A[Catch:{ SQLiteException -> 0x026b }] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0130 A[Catch:{ SQLiteException -> 0x026b }] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x014d A[Catch:{ SQLiteException -> 0x026b }] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x014f A[Catch:{ SQLiteException -> 0x026b }] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x016f A[Catch:{ SQLiteException -> 0x026b }] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0173 A[Catch:{ SQLiteException -> 0x026b }] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x019b A[Catch:{ SQLiteException -> 0x026b }] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x019d A[Catch:{ SQLiteException -> 0x026b }] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x01ba A[Catch:{ SQLiteException -> 0x026b }] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x01bc A[Catch:{ SQLiteException -> 0x026b }] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x01d9 A[Catch:{ SQLiteException -> 0x026b }] */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x01f2 A[Catch:{ SQLiteException -> 0x026b }] */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x020e A[Catch:{ SQLiteException -> 0x026b }] */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x020f A[Catch:{ SQLiteException -> 0x026b }] */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x021e A[Catch:{ SQLiteException -> 0x026b }] */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x023f A[Catch:{ SQLiteException -> 0x026b }] */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x0259 A[Catch:{ SQLiteException -> 0x026b }] */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x0288  */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x0290  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.measurement.internal.zzg zzj(java.lang.String r35) {
        /*
            r34 = this;
            r1 = r34
            r2 = r35
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r35)
            r34.zzg()
            r34.zzW()
            r3 = 0
            android.database.sqlite.SQLiteDatabase r4 = r34.zzh()     // Catch:{ SQLiteException -> 0x0273, all -> 0x0271 }
            java.lang.String r5 = "app_instance_id"
            java.lang.String r6 = "gmp_app_id"
            java.lang.String r7 = "resettable_device_id_hash"
            java.lang.String r8 = "last_bundle_index"
            java.lang.String r9 = "last_bundle_start_timestamp"
            java.lang.String r10 = "last_bundle_end_timestamp"
            java.lang.String r11 = "app_version"
            java.lang.String r12 = "app_store"
            java.lang.String r13 = "gmp_version"
            java.lang.String r14 = "dev_cert_hash"
            java.lang.String r15 = "measurement_enabled"
            java.lang.String r16 = "day"
            java.lang.String r17 = "daily_public_events_count"
            java.lang.String r18 = "daily_events_count"
            java.lang.String r19 = "daily_conversions_count"
            java.lang.String r20 = "config_fetched_time"
            java.lang.String r21 = "failed_config_fetch_time"
            java.lang.String r22 = "app_version_int"
            java.lang.String r23 = "firebase_instance_id"
            java.lang.String r24 = "daily_error_events_count"
            java.lang.String r25 = "daily_realtime_events_count"
            java.lang.String r26 = "health_monitor_sample"
            java.lang.String r27 = "android_id"
            java.lang.String r28 = "adid_reporting_enabled"
            java.lang.String r29 = "admob_app_id"
            java.lang.String r30 = "dynamite_version"
            java.lang.String r31 = "safelisted_events"
            java.lang.String r32 = "ga_app_id"
            java.lang.String r33 = "session_stitching_token"
            java.lang.String[] r6 = new java.lang.String[]{r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33}     // Catch:{ SQLiteException -> 0x0273, all -> 0x0271 }
            r0 = 1
            java.lang.String[] r8 = new java.lang.String[r0]     // Catch:{ SQLiteException -> 0x0273, all -> 0x0271 }
            r12 = 0
            r8[r12] = r2     // Catch:{ SQLiteException -> 0x0273, all -> 0x0271 }
            java.lang.String r5 = "apps"
            java.lang.String r7 = "app_id=?"
            r9 = 0
            r10 = 0
            r11 = 0
            android.database.Cursor r4 = r4.query(r5, r6, r7, r8, r9, r10, r11)     // Catch:{ SQLiteException -> 0x0273, all -> 0x0271 }
            boolean r5 = r4.moveToFirst()     // Catch:{ SQLiteException -> 0x026b }
            if (r5 != 0) goto L_0x006b
            r4.close()
            return r3
        L_0x006b:
            com.google.android.gms.measurement.internal.zzg r5 = new com.google.android.gms.measurement.internal.zzg     // Catch:{ SQLiteException -> 0x026b }
            com.google.android.gms.measurement.internal.zzli r6 = r1.zzf     // Catch:{ SQLiteException -> 0x026b }
            com.google.android.gms.measurement.internal.zzgi r6 = r6.zzn     // Catch:{ SQLiteException -> 0x026b }
            r5.<init>(r6, r2)     // Catch:{ SQLiteException -> 0x026b }
            java.lang.String r6 = r4.getString(r12)     // Catch:{ SQLiteException -> 0x026b }
            r5.zzI(r6)     // Catch:{ SQLiteException -> 0x026b }
            java.lang.String r6 = r4.getString(r0)     // Catch:{ SQLiteException -> 0x026b }
            r5.zzX(r6)     // Catch:{ SQLiteException -> 0x026b }
            r6 = 2
            java.lang.String r6 = r4.getString(r6)     // Catch:{ SQLiteException -> 0x026b }
            r5.zzaf(r6)     // Catch:{ SQLiteException -> 0x026b }
            r6 = 3
            long r6 = r4.getLong(r6)     // Catch:{ SQLiteException -> 0x026b }
            r5.zzab(r6)     // Catch:{ SQLiteException -> 0x026b }
            r6 = 4
            long r6 = r4.getLong(r6)     // Catch:{ SQLiteException -> 0x026b }
            r5.zzac(r6)     // Catch:{ SQLiteException -> 0x026b }
            r6 = 5
            long r6 = r4.getLong(r6)     // Catch:{ SQLiteException -> 0x026b }
            r5.zzaa(r6)     // Catch:{ SQLiteException -> 0x026b }
            r6 = 6
            java.lang.String r6 = r4.getString(r6)     // Catch:{ SQLiteException -> 0x026b }
            r5.zzK(r6)     // Catch:{ SQLiteException -> 0x026b }
            r6 = 7
            java.lang.String r6 = r4.getString(r6)     // Catch:{ SQLiteException -> 0x026b }
            r5.zzJ(r6)     // Catch:{ SQLiteException -> 0x026b }
            r6 = 8
            long r6 = r4.getLong(r6)     // Catch:{ SQLiteException -> 0x026b }
            r5.zzY(r6)     // Catch:{ SQLiteException -> 0x026b }
            r6 = 9
            long r6 = r4.getLong(r6)     // Catch:{ SQLiteException -> 0x026b }
            r5.zzT(r6)     // Catch:{ SQLiteException -> 0x026b }
            r6 = 10
            boolean r7 = r4.isNull(r6)     // Catch:{ SQLiteException -> 0x026b }
            if (r7 != 0) goto L_0x00d5
            int r6 = r4.getInt(r6)     // Catch:{ SQLiteException -> 0x026b }
            if (r6 == 0) goto L_0x00d3
            goto L_0x00d5
        L_0x00d3:
            r6 = 0
            goto L_0x00d6
        L_0x00d5:
            r6 = 1
        L_0x00d6:
            r5.zzad(r6)     // Catch:{ SQLiteException -> 0x026b }
            r6 = 11
            long r6 = r4.getLong(r6)     // Catch:{ SQLiteException -> 0x026b }
            com.google.android.gms.measurement.internal.zzgi r8 = r5.zza     // Catch:{ SQLiteException -> 0x026b }
            com.google.android.gms.measurement.internal.zzgf r8 = r8.zzaA()     // Catch:{ SQLiteException -> 0x026b }
            r8.zzg()     // Catch:{ SQLiteException -> 0x026b }
            boolean r8 = r5.zzD     // Catch:{ SQLiteException -> 0x026b }
            long r9 = r5.zzw     // Catch:{ SQLiteException -> 0x026b }
            int r11 = (r9 > r6 ? 1 : (r9 == r6 ? 0 : -1))
            if (r11 == 0) goto L_0x00f2
            r9 = 1
            goto L_0x00f3
        L_0x00f2:
            r9 = 0
        L_0x00f3:
            r8 = r8 | r9
            r5.zzD = r8     // Catch:{ SQLiteException -> 0x026b }
            r5.zzw = r6     // Catch:{ SQLiteException -> 0x026b }
            r6 = 12
            long r6 = r4.getLong(r6)     // Catch:{ SQLiteException -> 0x026b }
            com.google.android.gms.measurement.internal.zzgi r8 = r5.zza     // Catch:{ SQLiteException -> 0x026b }
            com.google.android.gms.measurement.internal.zzgf r8 = r8.zzaA()     // Catch:{ SQLiteException -> 0x026b }
            r8.zzg()     // Catch:{ SQLiteException -> 0x026b }
            boolean r8 = r5.zzD     // Catch:{ SQLiteException -> 0x026b }
            long r9 = r5.zzx     // Catch:{ SQLiteException -> 0x026b }
            int r11 = (r9 > r6 ? 1 : (r9 == r6 ? 0 : -1))
            if (r11 == 0) goto L_0x0111
            r9 = 1
            goto L_0x0112
        L_0x0111:
            r9 = 0
        L_0x0112:
            r8 = r8 | r9
            r5.zzD = r8     // Catch:{ SQLiteException -> 0x026b }
            r5.zzx = r6     // Catch:{ SQLiteException -> 0x026b }
            r6 = 13
            long r6 = r4.getLong(r6)     // Catch:{ SQLiteException -> 0x026b }
            com.google.android.gms.measurement.internal.zzgi r8 = r5.zza     // Catch:{ SQLiteException -> 0x026b }
            com.google.android.gms.measurement.internal.zzgf r8 = r8.zzaA()     // Catch:{ SQLiteException -> 0x026b }
            r8.zzg()     // Catch:{ SQLiteException -> 0x026b }
            boolean r8 = r5.zzD     // Catch:{ SQLiteException -> 0x026b }
            long r9 = r5.zzy     // Catch:{ SQLiteException -> 0x026b }
            int r11 = (r9 > r6 ? 1 : (r9 == r6 ? 0 : -1))
            if (r11 == 0) goto L_0x0130
            r9 = 1
            goto L_0x0131
        L_0x0130:
            r9 = 0
        L_0x0131:
            r8 = r8 | r9
            r5.zzD = r8     // Catch:{ SQLiteException -> 0x026b }
            r5.zzy = r6     // Catch:{ SQLiteException -> 0x026b }
            r6 = 14
            long r6 = r4.getLong(r6)     // Catch:{ SQLiteException -> 0x026b }
            com.google.android.gms.measurement.internal.zzgi r8 = r5.zza     // Catch:{ SQLiteException -> 0x026b }
            com.google.android.gms.measurement.internal.zzgf r8 = r8.zzaA()     // Catch:{ SQLiteException -> 0x026b }
            r8.zzg()     // Catch:{ SQLiteException -> 0x026b }
            boolean r8 = r5.zzD     // Catch:{ SQLiteException -> 0x026b }
            long r9 = r5.zzz     // Catch:{ SQLiteException -> 0x026b }
            int r11 = (r9 > r6 ? 1 : (r9 == r6 ? 0 : -1))
            if (r11 == 0) goto L_0x014f
            r9 = 1
            goto L_0x0150
        L_0x014f:
            r9 = 0
        L_0x0150:
            r8 = r8 | r9
            r5.zzD = r8     // Catch:{ SQLiteException -> 0x026b }
            r5.zzz = r6     // Catch:{ SQLiteException -> 0x026b }
            r6 = 15
            long r6 = r4.getLong(r6)     // Catch:{ SQLiteException -> 0x026b }
            r5.zzM(r6)     // Catch:{ SQLiteException -> 0x026b }
            r6 = 16
            long r6 = r4.getLong(r6)     // Catch:{ SQLiteException -> 0x026b }
            r5.zzV(r6)     // Catch:{ SQLiteException -> 0x026b }
            r6 = 17
            boolean r7 = r4.isNull(r6)     // Catch:{ SQLiteException -> 0x026b }
            if (r7 == 0) goto L_0x0173
            r6 = -2147483648(0xffffffff80000000, double:NaN)
            goto L_0x0178
        L_0x0173:
            int r6 = r4.getInt(r6)     // Catch:{ SQLiteException -> 0x026b }
            long r6 = (long) r6     // Catch:{ SQLiteException -> 0x026b }
        L_0x0178:
            r5.zzL(r6)     // Catch:{ SQLiteException -> 0x026b }
            r6 = 18
            java.lang.String r6 = r4.getString(r6)     // Catch:{ SQLiteException -> 0x026b }
            r5.zzW(r6)     // Catch:{ SQLiteException -> 0x026b }
            r6 = 19
            long r6 = r4.getLong(r6)     // Catch:{ SQLiteException -> 0x026b }
            com.google.android.gms.measurement.internal.zzgi r8 = r5.zza     // Catch:{ SQLiteException -> 0x026b }
            com.google.android.gms.measurement.internal.zzgf r8 = r8.zzaA()     // Catch:{ SQLiteException -> 0x026b }
            r8.zzg()     // Catch:{ SQLiteException -> 0x026b }
            boolean r8 = r5.zzD     // Catch:{ SQLiteException -> 0x026b }
            long r9 = r5.zzA     // Catch:{ SQLiteException -> 0x026b }
            int r11 = (r9 > r6 ? 1 : (r9 == r6 ? 0 : -1))
            if (r11 == 0) goto L_0x019d
            r9 = 1
            goto L_0x019e
        L_0x019d:
            r9 = 0
        L_0x019e:
            r8 = r8 | r9
            r5.zzD = r8     // Catch:{ SQLiteException -> 0x026b }
            r5.zzA = r6     // Catch:{ SQLiteException -> 0x026b }
            r6 = 20
            long r6 = r4.getLong(r6)     // Catch:{ SQLiteException -> 0x026b }
            com.google.android.gms.measurement.internal.zzgi r8 = r5.zza     // Catch:{ SQLiteException -> 0x026b }
            com.google.android.gms.measurement.internal.zzgf r8 = r8.zzaA()     // Catch:{ SQLiteException -> 0x026b }
            r8.zzg()     // Catch:{ SQLiteException -> 0x026b }
            boolean r8 = r5.zzD     // Catch:{ SQLiteException -> 0x026b }
            long r9 = r5.zzB     // Catch:{ SQLiteException -> 0x026b }
            int r11 = (r9 > r6 ? 1 : (r9 == r6 ? 0 : -1))
            if (r11 == 0) goto L_0x01bc
            r9 = 1
            goto L_0x01bd
        L_0x01bc:
            r9 = 0
        L_0x01bd:
            r8 = r8 | r9
            r5.zzD = r8     // Catch:{ SQLiteException -> 0x026b }
            r5.zzB = r6     // Catch:{ SQLiteException -> 0x026b }
            r6 = 21
            java.lang.String r6 = r4.getString(r6)     // Catch:{ SQLiteException -> 0x026b }
            r5.zzZ(r6)     // Catch:{ SQLiteException -> 0x026b }
            com.google.android.gms.measurement.internal.zzgi r6 = r1.zzs     // Catch:{ SQLiteException -> 0x026b }
            com.google.android.gms.measurement.internal.zzaf r6 = r6.zzk     // Catch:{ SQLiteException -> 0x026b }
            com.google.android.gms.measurement.internal.zzek r7 = com.google.android.gms.measurement.internal.zzel.zzah     // Catch:{ SQLiteException -> 0x026b }
            boolean r6 = r6.zzs(r3, r7)     // Catch:{ SQLiteException -> 0x026b }
            r7 = 0
            if (r6 != 0) goto L_0x01ea
            r6 = 22
            boolean r9 = r4.isNull(r6)     // Catch:{ SQLiteException -> 0x026b }
            if (r9 == 0) goto L_0x01e3
            r9 = r7
            goto L_0x01e7
        L_0x01e3:
            long r9 = r4.getLong(r6)     // Catch:{ SQLiteException -> 0x026b }
        L_0x01e7:
            r5.zzH(r9)     // Catch:{ SQLiteException -> 0x026b }
        L_0x01ea:
            r6 = 23
            boolean r9 = r4.isNull(r6)     // Catch:{ SQLiteException -> 0x026b }
            if (r9 != 0) goto L_0x01fa
            int r6 = r4.getInt(r6)     // Catch:{ SQLiteException -> 0x026b }
            if (r6 == 0) goto L_0x01f9
            goto L_0x01fa
        L_0x01f9:
            r0 = 0
        L_0x01fa:
            r5.zzG(r0)     // Catch:{ SQLiteException -> 0x026b }
            r0 = 24
            java.lang.String r0 = r4.getString(r0)     // Catch:{ SQLiteException -> 0x026b }
            r5.zzF(r0)     // Catch:{ SQLiteException -> 0x026b }
            r0 = 25
            boolean r6 = r4.isNull(r0)     // Catch:{ SQLiteException -> 0x026b }
            if (r6 == 0) goto L_0x020f
            goto L_0x0213
        L_0x020f:
            long r7 = r4.getLong(r0)     // Catch:{ SQLiteException -> 0x026b }
        L_0x0213:
            r5.zzU(r7)     // Catch:{ SQLiteException -> 0x026b }
            r0 = 26
            boolean r6 = r4.isNull(r0)     // Catch:{ SQLiteException -> 0x026b }
            if (r6 != 0) goto L_0x0230
            java.lang.String r0 = r4.getString(r0)     // Catch:{ SQLiteException -> 0x026b }
            java.lang.String r6 = ","
            r7 = -1
            java.lang.String[] r0 = r0.split(r6, r7)     // Catch:{ SQLiteException -> 0x026b }
            java.util.List r0 = java.util.Arrays.asList(r0)     // Catch:{ SQLiteException -> 0x026b }
            r5.zzag(r0)     // Catch:{ SQLiteException -> 0x026b }
        L_0x0230:
            com.google.android.gms.internal.measurement.zzpp.zzc()     // Catch:{ SQLiteException -> 0x026b }
            com.google.android.gms.measurement.internal.zzgi r0 = r1.zzs     // Catch:{ SQLiteException -> 0x026b }
            com.google.android.gms.measurement.internal.zzaf r0 = r0.zzk     // Catch:{ SQLiteException -> 0x026b }
            com.google.android.gms.measurement.internal.zzek r6 = com.google.android.gms.measurement.internal.zzel.zzaH     // Catch:{ SQLiteException -> 0x026b }
            boolean r0 = r0.zzs(r3, r6)     // Catch:{ SQLiteException -> 0x026b }
            if (r0 == 0) goto L_0x0248
            r0 = 28
            java.lang.String r0 = r4.getString(r0)     // Catch:{ SQLiteException -> 0x026b }
            r5.zzah(r0)     // Catch:{ SQLiteException -> 0x026b }
        L_0x0248:
            com.google.android.gms.measurement.internal.zzgi r0 = r5.zza     // Catch:{ SQLiteException -> 0x026b }
            com.google.android.gms.measurement.internal.zzgf r0 = r0.zzaA()     // Catch:{ SQLiteException -> 0x026b }
            r0.zzg()     // Catch:{ SQLiteException -> 0x026b }
            r5.zzD = r12     // Catch:{ SQLiteException -> 0x026b }
            boolean r0 = r4.moveToNext()     // Catch:{ SQLiteException -> 0x026b }
            if (r0 == 0) goto L_0x026d
            com.google.android.gms.measurement.internal.zzgi r0 = r1.zzs     // Catch:{ SQLiteException -> 0x026b }
            com.google.android.gms.measurement.internal.zzey r0 = r0.zzaz()     // Catch:{ SQLiteException -> 0x026b }
            com.google.android.gms.measurement.internal.zzew r0 = r0.zzd     // Catch:{ SQLiteException -> 0x026b }
            java.lang.String r6 = "Got multiple records for app, expected one. appId"
            java.lang.Object r7 = com.google.android.gms.measurement.internal.zzey.zzn(r35)     // Catch:{ SQLiteException -> 0x026b }
            r0.zzb(r6, r7)     // Catch:{ SQLiteException -> 0x026b }
            goto L_0x026d
        L_0x026b:
            r0 = move-exception
            goto L_0x0275
        L_0x026d:
            r4.close()
            return r5
        L_0x0271:
            r0 = move-exception
            goto L_0x028e
        L_0x0273:
            r0 = move-exception
            r4 = r3
        L_0x0275:
            com.google.android.gms.measurement.internal.zzgi r5 = r1.zzs     // Catch:{ all -> 0x028c }
            com.google.android.gms.measurement.internal.zzey r5 = r5.zzaz()     // Catch:{ all -> 0x028c }
            com.google.android.gms.measurement.internal.zzew r5 = r5.zzd     // Catch:{ all -> 0x028c }
            java.lang.String r6 = "Error querying app. appId"
            java.lang.Object r2 = com.google.android.gms.measurement.internal.zzey.zzn(r35)     // Catch:{ all -> 0x028c }
            r5.zzc(r6, r2, r0)     // Catch:{ all -> 0x028c }
            if (r4 == 0) goto L_0x028b
            r4.close()
        L_0x028b:
            return r3
        L_0x028c:
            r0 = move-exception
            r3 = r4
        L_0x028e:
            if (r3 == 0) goto L_0x0293
            r3.close()
        L_0x0293:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzal.zzj(java.lang.String):com.google.android.gms.measurement.internal.zzg");
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x011d  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0125  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.measurement.internal.zzab zzk(java.lang.String r31, java.lang.String r32) {
        /*
            r30 = this;
            r1 = r30
            r8 = r32
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r31)
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r32)
            r30.zzg()
            r30.zzW()
            r9 = 0
            android.database.sqlite.SQLiteDatabase r10 = r30.zzh()     // Catch:{ SQLiteException -> 0x0100, all -> 0x00fe }
            java.lang.String r11 = "origin"
            java.lang.String r12 = "value"
            java.lang.String r13 = "active"
            java.lang.String r14 = "trigger_event_name"
            java.lang.String r15 = "trigger_timeout"
            java.lang.String r16 = "timed_out_event"
            java.lang.String r17 = "creation_timestamp"
            java.lang.String r18 = "triggered_event"
            java.lang.String r19 = "triggered_timestamp"
            java.lang.String r20 = "time_to_live"
            java.lang.String r21 = "expired_event"
            java.lang.String[] r12 = new java.lang.String[]{r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21}     // Catch:{ SQLiteException -> 0x0100, all -> 0x00fe }
            r0 = 2
            java.lang.String[] r14 = new java.lang.String[r0]     // Catch:{ SQLiteException -> 0x0100, all -> 0x00fe }
            r2 = 0
            r14[r2] = r31     // Catch:{ SQLiteException -> 0x0100, all -> 0x00fe }
            r3 = 1
            r14[r3] = r8     // Catch:{ SQLiteException -> 0x0100, all -> 0x00fe }
            java.lang.String r11 = "conditional_properties"
            java.lang.String r13 = "app_id=? and name=?"
            r15 = 0
            r16 = 0
            r17 = 0
            android.database.Cursor r10 = r10.query(r11, r12, r13, r14, r15, r16, r17)     // Catch:{ SQLiteException -> 0x0100, all -> 0x00fe }
            boolean r4 = r10.moveToFirst()     // Catch:{ SQLiteException -> 0x00fc }
            if (r4 != 0) goto L_0x004f
            r10.close()
            return r9
        L_0x004f:
            java.lang.String r4 = r10.getString(r2)     // Catch:{ SQLiteException -> 0x00fc }
            if (r4 != 0) goto L_0x0057
            java.lang.String r4 = ""
        L_0x0057:
            r17 = r4
            java.lang.Object r6 = r1.zzq(r10, r3)     // Catch:{ SQLiteException -> 0x00fc }
            int r0 = r10.getInt(r0)     // Catch:{ SQLiteException -> 0x00fc }
            if (r0 == 0) goto L_0x0066
            r21 = 1
            goto L_0x0068
        L_0x0066:
            r21 = 0
        L_0x0068:
            r0 = 3
            java.lang.String r22 = r10.getString(r0)     // Catch:{ SQLiteException -> 0x00fc }
            r0 = 4
            long r24 = r10.getLong(r0)     // Catch:{ SQLiteException -> 0x00fc }
            com.google.android.gms.measurement.internal.zzli r0 = r1.zzf     // Catch:{ SQLiteException -> 0x00fc }
            com.google.android.gms.measurement.internal.zzlk r0 = r0.zzi     // Catch:{ SQLiteException -> 0x00fc }
            com.google.android.gms.measurement.internal.zzli.zzak(r0)     // Catch:{ SQLiteException -> 0x00fc }
            r2 = 5
            byte[] r2 = r10.getBlob(r2)     // Catch:{ SQLiteException -> 0x00fc }
            android.os.Parcelable$Creator<com.google.android.gms.measurement.internal.zzav> r3 = com.google.android.gms.measurement.internal.zzav.CREATOR     // Catch:{ SQLiteException -> 0x00fc }
            android.os.Parcelable r0 = r0.zzh(r2, r3)     // Catch:{ SQLiteException -> 0x00fc }
            r23 = r0
            com.google.android.gms.measurement.internal.zzav r23 = (com.google.android.gms.measurement.internal.zzav) r23     // Catch:{ SQLiteException -> 0x00fc }
            r0 = 6
            long r19 = r10.getLong(r0)     // Catch:{ SQLiteException -> 0x00fc }
            com.google.android.gms.measurement.internal.zzli r0 = r1.zzf     // Catch:{ SQLiteException -> 0x00fc }
            com.google.android.gms.measurement.internal.zzlk r0 = r0.zzi     // Catch:{ SQLiteException -> 0x00fc }
            com.google.android.gms.measurement.internal.zzli.zzak(r0)     // Catch:{ SQLiteException -> 0x00fc }
            r2 = 7
            byte[] r2 = r10.getBlob(r2)     // Catch:{ SQLiteException -> 0x00fc }
            android.os.Parcelable$Creator<com.google.android.gms.measurement.internal.zzav> r3 = com.google.android.gms.measurement.internal.zzav.CREATOR     // Catch:{ SQLiteException -> 0x00fc }
            android.os.Parcelable r0 = r0.zzh(r2, r3)     // Catch:{ SQLiteException -> 0x00fc }
            r26 = r0
            com.google.android.gms.measurement.internal.zzav r26 = (com.google.android.gms.measurement.internal.zzav) r26     // Catch:{ SQLiteException -> 0x00fc }
            r0 = 8
            long r4 = r10.getLong(r0)     // Catch:{ SQLiteException -> 0x00fc }
            r0 = 9
            long r27 = r10.getLong(r0)     // Catch:{ SQLiteException -> 0x00fc }
            com.google.android.gms.measurement.internal.zzli r0 = r1.zzf     // Catch:{ SQLiteException -> 0x00fc }
            com.google.android.gms.measurement.internal.zzlk r0 = r0.zzi     // Catch:{ SQLiteException -> 0x00fc }
            com.google.android.gms.measurement.internal.zzli.zzak(r0)     // Catch:{ SQLiteException -> 0x00fc }
            r2 = 10
            byte[] r2 = r10.getBlob(r2)     // Catch:{ SQLiteException -> 0x00fc }
            android.os.Parcelable$Creator<com.google.android.gms.measurement.internal.zzav> r3 = com.google.android.gms.measurement.internal.zzav.CREATOR     // Catch:{ SQLiteException -> 0x00fc }
            android.os.Parcelable r0 = r0.zzh(r2, r3)     // Catch:{ SQLiteException -> 0x00fc }
            r29 = r0
            com.google.android.gms.measurement.internal.zzav r29 = (com.google.android.gms.measurement.internal.zzav) r29     // Catch:{ SQLiteException -> 0x00fc }
            com.google.android.gms.measurement.internal.zzll r18 = new com.google.android.gms.measurement.internal.zzll     // Catch:{ SQLiteException -> 0x00fc }
            r2 = r18
            r3 = r32
            r7 = r17
            r2.<init>(r3, r4, r6, r7)     // Catch:{ SQLiteException -> 0x00fc }
            com.google.android.gms.measurement.internal.zzab r0 = new com.google.android.gms.measurement.internal.zzab     // Catch:{ SQLiteException -> 0x00fc }
            r15 = r0
            r16 = r31
            r15.<init>(r16, r17, r18, r19, r21, r22, r23, r24, r26, r27, r29)     // Catch:{ SQLiteException -> 0x00fc }
            boolean r2 = r10.moveToNext()     // Catch:{ SQLiteException -> 0x00fc }
            if (r2 == 0) goto L_0x00f8
            com.google.android.gms.measurement.internal.zzgi r2 = r1.zzs     // Catch:{ SQLiteException -> 0x00fc }
            com.google.android.gms.measurement.internal.zzey r2 = r2.zzaz()     // Catch:{ SQLiteException -> 0x00fc }
            com.google.android.gms.measurement.internal.zzew r2 = r2.zzd     // Catch:{ SQLiteException -> 0x00fc }
            java.lang.String r3 = "Got multiple records for conditional property, expected one"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzey.zzn(r31)     // Catch:{ SQLiteException -> 0x00fc }
            com.google.android.gms.measurement.internal.zzgi r5 = r1.zzs     // Catch:{ SQLiteException -> 0x00fc }
            com.google.android.gms.measurement.internal.zzet r5 = r5.zzq     // Catch:{ SQLiteException -> 0x00fc }
            java.lang.String r5 = r5.zzf(r8)     // Catch:{ SQLiteException -> 0x00fc }
            r2.zzc(r3, r4, r5)     // Catch:{ SQLiteException -> 0x00fc }
        L_0x00f8:
            r10.close()
            return r0
        L_0x00fc:
            r0 = move-exception
            goto L_0x0102
        L_0x00fe:
            r0 = move-exception
            goto L_0x0123
        L_0x0100:
            r0 = move-exception
            r10 = r9
        L_0x0102:
            com.google.android.gms.measurement.internal.zzgi r2 = r1.zzs     // Catch:{ all -> 0x0121 }
            com.google.android.gms.measurement.internal.zzey r2 = r2.zzaz()     // Catch:{ all -> 0x0121 }
            com.google.android.gms.measurement.internal.zzew r2 = r2.zzd     // Catch:{ all -> 0x0121 }
            java.lang.String r3 = "Error querying conditional property"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzey.zzn(r31)     // Catch:{ all -> 0x0121 }
            com.google.android.gms.measurement.internal.zzgi r5 = r1.zzs     // Catch:{ all -> 0x0121 }
            com.google.android.gms.measurement.internal.zzet r5 = r5.zzq     // Catch:{ all -> 0x0121 }
            java.lang.String r5 = r5.zzf(r8)     // Catch:{ all -> 0x0121 }
            r2.zzd(r3, r4, r5, r0)     // Catch:{ all -> 0x0121 }
            if (r10 == 0) goto L_0x0120
            r10.close()
        L_0x0120:
            return r9
        L_0x0121:
            r0 = move-exception
            r9 = r10
        L_0x0123:
            if (r9 == 0) goto L_0x0128
            r9.close()
        L_0x0128:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzal.zzk(java.lang.String, java.lang.String):com.google.android.gms.measurement.internal.zzab");
    }

    public final zzaj zzl(long j, String str, boolean z, boolean z2) {
        return zzm(j, str, 1, false, false, z, false, z2);
    }

    public final zzaj zzm(long j, String str, long j2, boolean z, boolean z2, boolean z3, boolean z4, boolean z5) {
        Preconditions.checkNotEmpty(str);
        zzg();
        zzW();
        String[] strArr = {str};
        zzaj zzaj = new zzaj();
        Cursor cursor = null;
        try {
            SQLiteDatabase zzh2 = zzh();
            cursor = zzh2.query("apps", new String[]{"day", "daily_events_count", "daily_public_events_count", "daily_conversions_count", "daily_error_events_count", "daily_realtime_events_count"}, "app_id=?", new String[]{str}, null, null, null);
            if (!cursor.moveToFirst()) {
                this.zzs.zzaz().zzg.zzb("Not updating daily counts, app is not known. appId", zzey.zzn(str));
                cursor.close();
                return zzaj;
            }
            if (cursor.getLong(0) == j) {
                zzaj.zzb = cursor.getLong(1);
                zzaj.zza = cursor.getLong(2);
                zzaj.zzc = cursor.getLong(3);
                zzaj.zzd = cursor.getLong(4);
                zzaj.zze = cursor.getLong(5);
            }
            if (z) {
                zzaj.zzb += j2;
            }
            if (z2) {
                zzaj.zza += j2;
            }
            if (z3) {
                zzaj.zzc += j2;
            }
            if (z4) {
                zzaj.zzd += j2;
            }
            if (z5) {
                zzaj.zze += j2;
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("day", Long.valueOf(j));
            contentValues.put("daily_public_events_count", Long.valueOf(zzaj.zza));
            contentValues.put("daily_events_count", Long.valueOf(zzaj.zzb));
            contentValues.put("daily_conversions_count", Long.valueOf(zzaj.zzc));
            contentValues.put("daily_error_events_count", Long.valueOf(zzaj.zzd));
            contentValues.put("daily_realtime_events_count", Long.valueOf(zzaj.zze));
            zzh2.update("apps", contentValues, "app_id=?", strArr);
            cursor.close();
            return zzaj;
        } catch (SQLiteException e2) {
            this.zzs.zzaz().zzd.zzc("Error updating daily counts. appId", zzey.zzn(str), e2);
            if (cursor != null) {
                cursor.close();
            }
            return zzaj;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:58:0x0141  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x014a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.measurement.internal.zzar zzn(java.lang.String r28, java.lang.String r29) {
        /*
            r27 = this;
            r1 = r27
            r15 = r29
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r28)
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r29)
            r27.zzg()
            r27.zzW()
            java.util.ArrayList r0 = new java.util.ArrayList
            java.lang.String r2 = "lifetime_count"
            java.lang.String r3 = "current_bundle_count"
            java.lang.String r4 = "last_fire_timestamp"
            java.lang.String r5 = "last_bundled_timestamp"
            java.lang.String r6 = "last_bundled_day"
            java.lang.String r7 = "last_sampled_complex_event_id"
            java.lang.String r8 = "last_sampling_rate"
            java.lang.String r9 = "last_exempt_from_sampling"
            java.lang.String r10 = "current_session_count"
            java.lang.String[] r2 = new java.lang.String[]{r2, r3, r4, r5, r6, r7, r8, r9, r10}
            java.util.List r2 = java.util.Arrays.asList(r2)
            r0.<init>(r2)
            r19 = 0
            android.database.sqlite.SQLiteDatabase r2 = r27.zzh()     // Catch:{ SQLiteException -> 0x0121, all -> 0x011f }
            r10 = 0
            java.lang.String[] r3 = new java.lang.String[r10]     // Catch:{ SQLiteException -> 0x0121, all -> 0x011f }
            java.lang.Object[] r0 = r0.toArray(r3)     // Catch:{ SQLiteException -> 0x0121, all -> 0x011f }
            r4 = r0
            java.lang.String[] r4 = (java.lang.String[]) r4     // Catch:{ SQLiteException -> 0x0121, all -> 0x011f }
            r0 = 2
            java.lang.String[] r6 = new java.lang.String[r0]     // Catch:{ SQLiteException -> 0x0121, all -> 0x011f }
            r6[r10] = r28     // Catch:{ SQLiteException -> 0x0121, all -> 0x011f }
            r11 = 1
            r6[r11] = r15     // Catch:{ SQLiteException -> 0x0121, all -> 0x011f }
            java.lang.String r3 = "events"
            java.lang.String r5 = "app_id=? and name=?"
            r7 = 0
            r8 = 0
            r9 = 0
            android.database.Cursor r13 = r2.query(r3, r4, r5, r6, r7, r8, r9)     // Catch:{ SQLiteException -> 0x0121, all -> 0x011f }
            boolean r2 = r13.moveToFirst()     // Catch:{ SQLiteException -> 0x0119, all -> 0x0113 }
            if (r2 != 0) goto L_0x005c
            r13.close()
            return r19
        L_0x005c:
            long r5 = r13.getLong(r10)     // Catch:{ SQLiteException -> 0x0119, all -> 0x0113 }
            long r7 = r13.getLong(r11)     // Catch:{ SQLiteException -> 0x0119, all -> 0x0113 }
            long r16 = r13.getLong(r0)     // Catch:{ SQLiteException -> 0x0119, all -> 0x0113 }
            r0 = 3
            boolean r2 = r13.isNull(r0)     // Catch:{ SQLiteException -> 0x0119, all -> 0x0113 }
            r3 = 0
            if (r2 == 0) goto L_0x0074
            r20 = r3
            goto L_0x0078
        L_0x0074:
            long r20 = r13.getLong(r0)     // Catch:{ SQLiteException -> 0x0119, all -> 0x0113 }
        L_0x0078:
            r0 = 4
            boolean r2 = r13.isNull(r0)     // Catch:{ SQLiteException -> 0x0119, all -> 0x0113 }
            if (r2 == 0) goto L_0x0082
            r0 = r19
            goto L_0x008a
        L_0x0082:
            long r22 = r13.getLong(r0)     // Catch:{ SQLiteException -> 0x0119, all -> 0x0113 }
            java.lang.Long r0 = java.lang.Long.valueOf(r22)     // Catch:{ SQLiteException -> 0x0119, all -> 0x0113 }
        L_0x008a:
            r2 = 5
            boolean r9 = r13.isNull(r2)     // Catch:{ SQLiteException -> 0x0119, all -> 0x0113 }
            if (r9 == 0) goto L_0x0094
            r18 = r19
            goto L_0x009e
        L_0x0094:
            long r22 = r13.getLong(r2)     // Catch:{ SQLiteException -> 0x0119, all -> 0x0113 }
            java.lang.Long r2 = java.lang.Long.valueOf(r22)     // Catch:{ SQLiteException -> 0x0119, all -> 0x0113 }
            r18 = r2
        L_0x009e:
            r2 = 6
            boolean r9 = r13.isNull(r2)     // Catch:{ SQLiteException -> 0x0119, all -> 0x0113 }
            if (r9 == 0) goto L_0x00a8
            r22 = r19
            goto L_0x00b2
        L_0x00a8:
            long r22 = r13.getLong(r2)     // Catch:{ SQLiteException -> 0x0119, all -> 0x0113 }
            java.lang.Long r2 = java.lang.Long.valueOf(r22)     // Catch:{ SQLiteException -> 0x0119, all -> 0x0113 }
            r22 = r2
        L_0x00b2:
            r2 = 7
            boolean r9 = r13.isNull(r2)     // Catch:{ SQLiteException -> 0x0119, all -> 0x0113 }
            if (r9 != 0) goto L_0x00cb
            long r23 = r13.getLong(r2)     // Catch:{ SQLiteException -> 0x0119, all -> 0x0113 }
            r25 = 1
            int r2 = (r23 > r25 ? 1 : (r23 == r25 ? 0 : -1))
            if (r2 != 0) goto L_0x00c4
            r10 = 1
        L_0x00c4:
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r10)     // Catch:{ SQLiteException -> 0x0119, all -> 0x0113 }
            r23 = r2
            goto L_0x00cd
        L_0x00cb:
            r23 = r19
        L_0x00cd:
            r2 = 8
            boolean r9 = r13.isNull(r2)     // Catch:{ SQLiteException -> 0x0119, all -> 0x0113 }
            if (r9 == 0) goto L_0x00d7
            r9 = r3
            goto L_0x00dc
        L_0x00d7:
            long r2 = r13.getLong(r2)     // Catch:{ SQLiteException -> 0x0119, all -> 0x0113 }
            r9 = r2
        L_0x00dc:
            com.google.android.gms.measurement.internal.zzar r24 = new com.google.android.gms.measurement.internal.zzar     // Catch:{ SQLiteException -> 0x0119, all -> 0x0113 }
            r2 = r24
            r3 = r28
            r4 = r29
            r11 = r16
            r25 = r13
            r13 = r20
            r15 = r0
            r16 = r18
            r17 = r22
            r18 = r23
            r2.<init>(r3, r4, r5, r7, r9, r11, r13, r15, r16, r17, r18)     // Catch:{ SQLiteException -> 0x0111, all -> 0x010f }
            boolean r0 = r25.moveToNext()     // Catch:{ SQLiteException -> 0x0111, all -> 0x010f }
            if (r0 == 0) goto L_0x010b
            com.google.android.gms.measurement.internal.zzgi r0 = r1.zzs     // Catch:{ SQLiteException -> 0x0111, all -> 0x010f }
            com.google.android.gms.measurement.internal.zzey r0 = r0.zzaz()     // Catch:{ SQLiteException -> 0x0111, all -> 0x010f }
            com.google.android.gms.measurement.internal.zzew r0 = r0.zzd     // Catch:{ SQLiteException -> 0x0111, all -> 0x010f }
            java.lang.String r2 = "Got multiple records for event aggregates, expected one. appId"
            java.lang.Object r3 = com.google.android.gms.measurement.internal.zzey.zzn(r28)     // Catch:{ SQLiteException -> 0x0111, all -> 0x010f }
            r0.zzb(r2, r3)     // Catch:{ SQLiteException -> 0x0111, all -> 0x010f }
        L_0x010b:
            r25.close()
            return r24
        L_0x010f:
            r0 = move-exception
            goto L_0x0116
        L_0x0111:
            r0 = move-exception
            goto L_0x011c
        L_0x0113:
            r0 = move-exception
            r25 = r13
        L_0x0116:
            r19 = r25
            goto L_0x0148
        L_0x0119:
            r0 = move-exception
            r25 = r13
        L_0x011c:
            r13 = r25
            goto L_0x0124
        L_0x011f:
            r0 = move-exception
            goto L_0x0148
        L_0x0121:
            r0 = move-exception
            r13 = r19
        L_0x0124:
            com.google.android.gms.measurement.internal.zzgi r2 = r1.zzs     // Catch:{ all -> 0x0145 }
            com.google.android.gms.measurement.internal.zzey r2 = r2.zzaz()     // Catch:{ all -> 0x0145 }
            com.google.android.gms.measurement.internal.zzew r2 = r2.zzd     // Catch:{ all -> 0x0145 }
            java.lang.String r3 = "Error querying events. appId"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzey.zzn(r28)     // Catch:{ all -> 0x0145 }
            com.google.android.gms.measurement.internal.zzgi r5 = r1.zzs     // Catch:{ all -> 0x0145 }
            com.google.android.gms.measurement.internal.zzet r5 = r5.zzq     // Catch:{ all -> 0x0145 }
            r6 = r29
            java.lang.String r5 = r5.zzd(r6)     // Catch:{ all -> 0x0145 }
            r2.zzd(r3, r4, r5, r0)     // Catch:{ all -> 0x0145 }
            if (r13 == 0) goto L_0x0144
            r13.close()
        L_0x0144:
            return r19
        L_0x0145:
            r0 = move-exception
            r19 = r13
        L_0x0148:
            if (r19 == 0) goto L_0x014d
            r19.close()
        L_0x014d:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzal.zzn(java.lang.String, java.lang.String):com.google.android.gms.measurement.internal.zzar");
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x0099  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00a1  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.measurement.internal.zzln zzp(java.lang.String r20, java.lang.String r21) {
        /*
            r19 = this;
            r1 = r19
            r9 = r21
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r20)
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r21)
            r19.zzg()
            r19.zzW()
            r10 = 0
            android.database.sqlite.SQLiteDatabase r11 = r19.zzh()     // Catch:{ SQLiteException -> 0x007c, all -> 0x007a }
            java.lang.String r0 = "set_timestamp"
            java.lang.String r2 = "value"
            java.lang.String r3 = "origin"
            java.lang.String[] r13 = new java.lang.String[]{r0, r2, r3}     // Catch:{ SQLiteException -> 0x007c, all -> 0x007a }
            r0 = 2
            java.lang.String[] r15 = new java.lang.String[r0]     // Catch:{ SQLiteException -> 0x007c, all -> 0x007a }
            r2 = 0
            r15[r2] = r20     // Catch:{ SQLiteException -> 0x007c, all -> 0x007a }
            r3 = 1
            r15[r3] = r9     // Catch:{ SQLiteException -> 0x007c, all -> 0x007a }
            java.lang.String r12 = "user_attributes"
            java.lang.String r14 = "app_id=? and name=?"
            r16 = 0
            r17 = 0
            r18 = 0
            android.database.Cursor r11 = r11.query(r12, r13, r14, r15, r16, r17, r18)     // Catch:{ SQLiteException -> 0x007c, all -> 0x007a }
            boolean r4 = r11.moveToFirst()     // Catch:{ SQLiteException -> 0x0074 }
            if (r4 != 0) goto L_0x0040
            r11.close()
            return r10
        L_0x0040:
            long r6 = r11.getLong(r2)     // Catch:{ SQLiteException -> 0x0074 }
            java.lang.Object r8 = r1.zzq(r11, r3)     // Catch:{ SQLiteException -> 0x0074 }
            if (r8 != 0) goto L_0x004e
            r11.close()
            return r10
        L_0x004e:
            java.lang.String r4 = r11.getString(r0)     // Catch:{ SQLiteException -> 0x0074 }
            com.google.android.gms.measurement.internal.zzln r0 = new com.google.android.gms.measurement.internal.zzln     // Catch:{ SQLiteException -> 0x0074 }
            r2 = r0
            r3 = r20
            r5 = r21
            r2.<init>(r3, r4, r5, r6, r8)     // Catch:{ SQLiteException -> 0x0074 }
            boolean r2 = r11.moveToNext()     // Catch:{ SQLiteException -> 0x0074 }
            if (r2 == 0) goto L_0x0076
            com.google.android.gms.measurement.internal.zzgi r2 = r1.zzs     // Catch:{ SQLiteException -> 0x0074 }
            com.google.android.gms.measurement.internal.zzey r2 = r2.zzaz()     // Catch:{ SQLiteException -> 0x0074 }
            com.google.android.gms.measurement.internal.zzew r2 = r2.zzd     // Catch:{ SQLiteException -> 0x0074 }
            java.lang.String r3 = "Got multiple records for user property, expected one. appId"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzey.zzn(r20)     // Catch:{ SQLiteException -> 0x0074 }
            r2.zzb(r3, r4)     // Catch:{ SQLiteException -> 0x0074 }
            goto L_0x0076
        L_0x0074:
            r0 = move-exception
            goto L_0x007e
        L_0x0076:
            r11.close()
            return r0
        L_0x007a:
            r0 = move-exception
            goto L_0x009f
        L_0x007c:
            r0 = move-exception
            r11 = r10
        L_0x007e:
            com.google.android.gms.measurement.internal.zzgi r2 = r1.zzs     // Catch:{ all -> 0x009d }
            com.google.android.gms.measurement.internal.zzey r2 = r2.zzaz()     // Catch:{ all -> 0x009d }
            com.google.android.gms.measurement.internal.zzew r2 = r2.zzd     // Catch:{ all -> 0x009d }
            java.lang.String r3 = "Error querying user property. appId"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzey.zzn(r20)     // Catch:{ all -> 0x009d }
            com.google.android.gms.measurement.internal.zzgi r5 = r1.zzs     // Catch:{ all -> 0x009d }
            com.google.android.gms.measurement.internal.zzet r5 = r5.zzq     // Catch:{ all -> 0x009d }
            java.lang.String r5 = r5.zzf(r9)     // Catch:{ all -> 0x009d }
            r2.zzd(r3, r4, r5, r0)     // Catch:{ all -> 0x009d }
            if (r11 == 0) goto L_0x009c
            r11.close()
        L_0x009c:
            return r10
        L_0x009d:
            r0 = move-exception
            r10 = r11
        L_0x009f:
            if (r10 == 0) goto L_0x00a4
            r10.close()
        L_0x00a4:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzal.zzp(java.lang.String, java.lang.String):com.google.android.gms.measurement.internal.zzln");
    }

    @VisibleForTesting
    public final Object zzq(Cursor cursor, int i) {
        int type = cursor.getType(i);
        if (type == 0) {
            this.zzs.zzaz().zzd.zza("Loaded invalid null value from database");
            return null;
        } else if (type == 1) {
            return Long.valueOf(cursor.getLong(i));
        } else {
            if (type == 2) {
                return Double.valueOf(cursor.getDouble(i));
            }
            if (type == 3) {
                return cursor.getString(i);
            }
            if (type != 4) {
                this.zzs.zzaz().zzd.zzb("Loaded invalid unknown value type, ignoring it", Integer.valueOf(type));
                return null;
            }
            this.zzs.zzaz().zzd.zza("Loaded invalid blob type value, ignoring it");
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0034  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x003e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String zzr() {
        /*
            r6 = this;
            android.database.sqlite.SQLiteDatabase r0 = r6.zzh()
            r1 = 0
            java.lang.String r2 = "select app_id from queue order by has_realtime desc, rowid asc limit 1;"
            android.database.Cursor r0 = r0.rawQuery(r2, r1)     // Catch:{ SQLiteException -> 0x0022, all -> 0x0020 }
            boolean r2 = r0.moveToFirst()     // Catch:{ SQLiteException -> 0x001e }
            if (r2 == 0) goto L_0x001a
            r2 = 0
            java.lang.String r1 = r0.getString(r2)     // Catch:{ SQLiteException -> 0x001e }
            r0.close()
            return r1
        L_0x001a:
            r0.close()
            return r1
        L_0x001e:
            r2 = move-exception
            goto L_0x0025
        L_0x0020:
            r0 = move-exception
            goto L_0x003c
        L_0x0022:
            r0 = move-exception
            r2 = r0
            r0 = r1
        L_0x0025:
            com.google.android.gms.measurement.internal.zzgi r3 = r6.zzs     // Catch:{ all -> 0x0038 }
            com.google.android.gms.measurement.internal.zzey r3 = r3.zzaz()     // Catch:{ all -> 0x0038 }
            com.google.android.gms.measurement.internal.zzew r3 = r3.zzd     // Catch:{ all -> 0x0038 }
            java.lang.String r4 = "Database error getting next bundle app id"
            r3.zzb(r4, r2)     // Catch:{ all -> 0x0038 }
            if (r0 == 0) goto L_0x0037
            r0.close()
        L_0x0037:
            return r1
        L_0x0038:
            r1 = move-exception
            r5 = r1
            r1 = r0
            r0 = r5
        L_0x003c:
            if (r1 == 0) goto L_0x0041
            r1.close()
        L_0x0041:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzal.zzr():java.lang.String");
    }

    public final List zzs(String str, String str2, String str3) {
        Preconditions.checkNotEmpty(str);
        zzg();
        zzW();
        ArrayList arrayList = new ArrayList(3);
        arrayList.add(str);
        StringBuilder sb = new StringBuilder("app_id=?");
        if (!TextUtils.isEmpty(str2)) {
            arrayList.add(str2);
            sb.append(" and origin=?");
        }
        if (!TextUtils.isEmpty(str3)) {
            arrayList.add(String.valueOf(str3).concat("*"));
            sb.append(" and name glob ?");
        }
        return zzt(sb.toString(), (String[]) arrayList.toArray(new String[arrayList.size()]));
    }

    public final List zzt(String str, String[] strArr) {
        zzg();
        zzW();
        ArrayList arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            SQLiteDatabase zzh2 = zzh();
            String[] strArr2 = {"app_id", "origin", "name", HSLCriteriaBuilder.VALUE, AppStateModule.APP_STATE_ACTIVE, "trigger_event_name", "trigger_timeout", "timed_out_event", "creation_timestamp", "triggered_event", "triggered_timestamp", "time_to_live", "expired_event"};
            zzaf zzaf = this.zzs.zzk;
            Cursor query = zzh2.query("conditional_properties", strArr2, str, strArr, null, null, "rowid", "1001");
            if (query.moveToFirst()) {
                while (true) {
                    int size = arrayList.size();
                    zzaf zzaf2 = this.zzs.zzk;
                    if (size < 1000) {
                        String string = query.getString(0);
                        String string2 = query.getString(1);
                        String string3 = query.getString(2);
                        Object zzq = zzq(query, 3);
                        boolean z = query.getInt(4) != 0;
                        String string4 = query.getString(5);
                        long j = query.getLong(6);
                        zzlk zzlk = this.zzf.zzi;
                        zzli.zzak(zzlk);
                        long j2 = query.getLong(8);
                        zzlk zzlk2 = this.zzf.zzi;
                        zzli.zzak(zzlk2);
                        long j3 = query.getLong(10);
                        long j4 = query.getLong(11);
                        zzlk zzlk3 = this.zzf.zzi;
                        zzli.zzak(zzlk3);
                        zzll zzll = new zzll(string3, j3, zzq, string2);
                        zzab zzab = new zzab(string, string2, zzll, j2, z, string4, (zzav) zzlk.zzh(query.getBlob(7), zzav.CREATOR), j, (zzav) zzlk2.zzh(query.getBlob(9), zzav.CREATOR), j4, (zzav) zzlk3.zzh(query.getBlob(12), zzav.CREATOR));
                        arrayList.add(zzab);
                        if (!query.moveToNext()) {
                            break;
                        }
                    } else {
                        zzew zzew = this.zzs.zzaz().zzd;
                        zzaf zzaf3 = this.zzs.zzk;
                        zzew.zzb("Read more than the max allowed conditional properties, ignoring extra", Integer.valueOf(1000));
                        break;
                    }
                }
                query.close();
                return arrayList;
            }
            query.close();
            return arrayList;
        } catch (SQLiteException e2) {
            this.zzs.zzaz().zzd.zzb("Error querying conditional user property value", e2);
            List emptyList = Collections.emptyList();
            if (cursor != null) {
                cursor.close();
            }
            return emptyList;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    public final List zzu(String str) {
        Preconditions.checkNotEmpty(str);
        zzg();
        zzW();
        ArrayList arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            zzaf zzaf = this.zzs.zzk;
            Cursor query = zzh().query("user_attributes", new String[]{"name", "origin", "set_timestamp", HSLCriteriaBuilder.VALUE}, "app_id=?", new String[]{str}, null, null, "rowid", "1000");
            if (query.moveToFirst()) {
                do {
                    String string = query.getString(0);
                    String string2 = query.getString(1);
                    if (string2 == null) {
                        string2 = "";
                    }
                    String str2 = string2;
                    long j = query.getLong(2);
                    Object zzq = zzq(query, 3);
                    if (zzq == null) {
                        this.zzs.zzaz().zzd.zzb("Read invalid user property value, ignoring it. appId", zzey.zzn(str));
                    } else {
                        zzln zzln = new zzln(str, str2, string, j, zzq);
                        arrayList.add(zzln);
                    }
                } while (query.moveToNext());
                query.close();
                return arrayList;
            }
            query.close();
            return arrayList;
        } catch (SQLiteException e2) {
            this.zzs.zzaz().zzd.zzc("Error querying user properties. appId", zzey.zzn(str), e2);
            List emptyList = Collections.emptyList();
            if (cursor != null) {
                cursor.close();
            }
            return emptyList;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:41:0x011b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List zzv(java.lang.String r18, java.lang.String r19, java.lang.String r20) {
        /*
            r17 = this;
            r1 = r17
            r0 = r20
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r18)
            r17.zzg()
            r17.zzW()
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            java.lang.String r11 = "1001"
            r12 = 0
            java.util.ArrayList r3 = new java.util.ArrayList     // Catch:{ SQLiteException -> 0x00ff }
            r13 = 3
            r3.<init>(r13)     // Catch:{ SQLiteException -> 0x00ff }
            r14 = r18
            r3.add(r14)     // Catch:{ SQLiteException -> 0x00fd }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ SQLiteException -> 0x00fd }
            java.lang.String r5 = "app_id=?"
            r4.<init>(r5)     // Catch:{ SQLiteException -> 0x00fd }
            boolean r5 = android.text.TextUtils.isEmpty(r19)     // Catch:{ SQLiteException -> 0x00fd }
            if (r5 != 0) goto L_0x0038
            r15 = r19
            r3.add(r15)     // Catch:{ SQLiteException -> 0x00bd }
            java.lang.String r5 = " and origin=?"
            r4.append(r5)     // Catch:{ SQLiteException -> 0x00bd }
            goto L_0x003a
        L_0x0038:
            r15 = r19
        L_0x003a:
            boolean r5 = android.text.TextUtils.isEmpty(r20)     // Catch:{ SQLiteException -> 0x00bd }
            if (r5 != 0) goto L_0x0059
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ SQLiteException -> 0x00bd }
            r5.<init>()     // Catch:{ SQLiteException -> 0x00bd }
            r5.append(r0)     // Catch:{ SQLiteException -> 0x00bd }
            java.lang.String r6 = "*"
            r5.append(r6)     // Catch:{ SQLiteException -> 0x00bd }
            java.lang.String r5 = r5.toString()     // Catch:{ SQLiteException -> 0x00bd }
            r3.add(r5)     // Catch:{ SQLiteException -> 0x00bd }
            java.lang.String r5 = " and name glob ?"
            r4.append(r5)     // Catch:{ SQLiteException -> 0x00bd }
        L_0x0059:
            int r5 = r3.size()     // Catch:{ SQLiteException -> 0x00bd }
            java.lang.String[] r5 = new java.lang.String[r5]     // Catch:{ SQLiteException -> 0x00bd }
            java.lang.Object[] r3 = r3.toArray(r5)     // Catch:{ SQLiteException -> 0x00bd }
            r7 = r3
            java.lang.String[] r7 = (java.lang.String[]) r7     // Catch:{ SQLiteException -> 0x00bd }
            android.database.sqlite.SQLiteDatabase r3 = r17.zzh()     // Catch:{ SQLiteException -> 0x00bd }
            java.lang.String r5 = "user_attributes"
            java.lang.String r6 = "name"
            java.lang.String r8 = "set_timestamp"
            java.lang.String r9 = "value"
            java.lang.String r10 = "origin"
            java.lang.String[] r6 = new java.lang.String[]{r6, r8, r9, r10}     // Catch:{ SQLiteException -> 0x00bd }
            java.lang.String r8 = r4.toString()     // Catch:{ SQLiteException -> 0x00bd }
            java.lang.String r10 = "rowid"
            com.google.android.gms.measurement.internal.zzgi r4 = r1.zzs     // Catch:{ SQLiteException -> 0x00bd }
            com.google.android.gms.measurement.internal.zzaf r4 = r4.zzk     // Catch:{ SQLiteException -> 0x00bd }
            r9 = 0
            r16 = 0
            r4 = r5
            r5 = r6
            r6 = r8
            r8 = r9
            r9 = r16
            android.database.Cursor r12 = r3.query(r4, r5, r6, r7, r8, r9, r10, r11)     // Catch:{ SQLiteException -> 0x00bd }
            boolean r3 = r12.moveToFirst()     // Catch:{ SQLiteException -> 0x00bd }
            if (r3 != 0) goto L_0x0099
            r12.close()
            return r2
        L_0x0099:
            int r3 = r2.size()     // Catch:{ SQLiteException -> 0x00bd }
            com.google.android.gms.measurement.internal.zzgi r4 = r1.zzs     // Catch:{ SQLiteException -> 0x00bd }
            com.google.android.gms.measurement.internal.zzaf r4 = r4.zzk     // Catch:{ SQLiteException -> 0x00bd }
            r4 = 1000(0x3e8, float:1.401E-42)
            if (r3 < r4) goto L_0x00bf
            com.google.android.gms.measurement.internal.zzgi r0 = r1.zzs     // Catch:{ SQLiteException -> 0x00bd }
            com.google.android.gms.measurement.internal.zzey r0 = r0.zzaz()     // Catch:{ SQLiteException -> 0x00bd }
            com.google.android.gms.measurement.internal.zzew r0 = r0.zzd     // Catch:{ SQLiteException -> 0x00bd }
            java.lang.String r3 = "Read more than the max allowed user properties, ignoring excess"
            com.google.android.gms.measurement.internal.zzgi r5 = r1.zzs     // Catch:{ SQLiteException -> 0x00bd }
            com.google.android.gms.measurement.internal.zzaf r5 = r5.zzk     // Catch:{ SQLiteException -> 0x00bd }
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch:{ SQLiteException -> 0x00bd }
            r0.zzb(r3, r4)     // Catch:{ SQLiteException -> 0x00bd }
            goto L_0x00f9
        L_0x00bb:
            r0 = move-exception
            goto L_0x011f
        L_0x00bd:
            r0 = move-exception
            goto L_0x0104
        L_0x00bf:
            r3 = 0
            java.lang.String r7 = r12.getString(r3)     // Catch:{ SQLiteException -> 0x00bd }
            r3 = 1
            long r8 = r12.getLong(r3)     // Catch:{ SQLiteException -> 0x00bd }
            r3 = 2
            java.lang.Object r10 = r1.zzq(r12, r3)     // Catch:{ SQLiteException -> 0x00bd }
            java.lang.String r15 = r12.getString(r13)     // Catch:{ SQLiteException -> 0x00bd }
            if (r10 != 0) goto L_0x00e6
            com.google.android.gms.measurement.internal.zzgi r3 = r1.zzs     // Catch:{ SQLiteException -> 0x00bd }
            com.google.android.gms.measurement.internal.zzey r3 = r3.zzaz()     // Catch:{ SQLiteException -> 0x00bd }
            com.google.android.gms.measurement.internal.zzew r3 = r3.zzd     // Catch:{ SQLiteException -> 0x00bd }
            java.lang.String r4 = "(2)Read invalid user property value, ignoring it"
            java.lang.Object r5 = com.google.android.gms.measurement.internal.zzey.zzn(r18)     // Catch:{ SQLiteException -> 0x00bd }
            r3.zzd(r4, r5, r15, r0)     // Catch:{ SQLiteException -> 0x00bd }
            goto L_0x00f2
        L_0x00e6:
            com.google.android.gms.measurement.internal.zzln r3 = new com.google.android.gms.measurement.internal.zzln     // Catch:{ SQLiteException -> 0x00bd }
            r4 = r3
            r5 = r18
            r6 = r15
            r4.<init>(r5, r6, r7, r8, r10)     // Catch:{ SQLiteException -> 0x00bd }
            r2.add(r3)     // Catch:{ SQLiteException -> 0x00bd }
        L_0x00f2:
            boolean r3 = r12.moveToNext()     // Catch:{ SQLiteException -> 0x00bd }
            if (r3 == 0) goto L_0x00f9
            goto L_0x0099
        L_0x00f9:
            r12.close()
            return r2
        L_0x00fd:
            r0 = move-exception
            goto L_0x0102
        L_0x00ff:
            r0 = move-exception
            r14 = r18
        L_0x0102:
            r15 = r19
        L_0x0104:
            com.google.android.gms.measurement.internal.zzgi r2 = r1.zzs     // Catch:{ all -> 0x00bb }
            com.google.android.gms.measurement.internal.zzey r2 = r2.zzaz()     // Catch:{ all -> 0x00bb }
            com.google.android.gms.measurement.internal.zzew r2 = r2.zzd     // Catch:{ all -> 0x00bb }
            java.lang.String r3 = "(2)Error querying user properties"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzey.zzn(r18)     // Catch:{ all -> 0x00bb }
            r2.zzd(r3, r4, r15, r0)     // Catch:{ all -> 0x00bb }
            java.util.List r0 = java.util.Collections.emptyList()     // Catch:{ all -> 0x00bb }
            if (r12 == 0) goto L_0x011e
            r12.close()
        L_0x011e:
            return r0
        L_0x011f:
            if (r12 == 0) goto L_0x0124
            r12.close()
        L_0x0124:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzal.zzv(java.lang.String, java.lang.String, java.lang.String):java.util.List");
    }

    public final void zzw() {
        zzW();
        zzh().beginTransaction();
    }

    public final void zzx() {
        zzW();
        zzh().endTransaction();
    }

    @VisibleForTesting
    public final void zzy(List list) {
        zzg();
        zzW();
        Preconditions.checkNotNull(list);
        if (list.size() == 0) {
            throw new IllegalArgumentException("Given Integer is zero");
        } else if (zzI()) {
            String outline52 = GeneratedOutlineSupport.outline52("(", TextUtils.join(",", list), ")");
            if (zzZ("SELECT COUNT(1) FROM queue WHERE rowid IN " + outline52 + " AND retry_count =  2147483647 LIMIT 1", null) > 0) {
                this.zzs.zzaz().zzg.zza("The number of upload retries exceeds the limit. Will remain unchanged.");
            }
            try {
                SQLiteDatabase zzh2 = zzh();
                zzh2.execSQL("UPDATE queue SET retry_count = IFNULL(retry_count, 0) + 1 WHERE rowid IN " + outline52 + " AND (retry_count IS NULL OR retry_count < 2147483647)");
            } catch (SQLiteException e2) {
                this.zzs.zzaz().zzd.zzb("Error incrementing retry count. error", e2);
            }
        }
    }

    public final void zzz() {
        zzg();
        zzW();
        if (zzI()) {
            long zza2 = this.zzf.zzk.zza.zza();
            long elapsedRealtime = this.zzs.zzr.elapsedRealtime();
            long abs = Math.abs(elapsedRealtime - zza2);
            zzaf zzaf = this.zzs.zzk;
            if (abs > ((Long) zzel.zzx.zza(null)).longValue()) {
                this.zzf.zzk.zza.zzb(elapsedRealtime);
                zzg();
                zzW();
                if (zzI()) {
                    SQLiteDatabase zzh2 = zzh();
                    zzaf zzaf2 = this.zzs.zzk;
                    int delete = zzh2.delete("queue", "abs(bundle_end_timestamp - ?) > cast(? as integer)", new String[]{String.valueOf(this.zzs.zzr.currentTimeMillis()), String.valueOf(zzaf.zzA())});
                    if (delete > 0) {
                        this.zzs.zzaz().zzl.zzb("Deleted stale rows. rowsDeleted", Integer.valueOf(delete));
                    }
                }
            }
        }
    }
}
