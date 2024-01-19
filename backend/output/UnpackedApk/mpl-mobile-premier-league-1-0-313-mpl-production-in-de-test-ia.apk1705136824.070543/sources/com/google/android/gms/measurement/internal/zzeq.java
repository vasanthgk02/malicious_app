package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.core.app.NotificationCompat.CarExtender;
import com.facebook.drawee.backends.pipeline.info.ImageOriginUtils;
import com.google.android.gms.common.util.VisibleForTesting;

@VisibleForTesting
/* compiled from: com.google.android.gms:play-services-measurement-impl@@20.1.2 */
public final class zzeq extends SQLiteOpenHelper {
    public final /* synthetic */ zzer zza;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public zzeq(zzer zzer, Context context) {
        // this.zza = zzer;
        super(context, "google_app_measurement_local.db", null, 1);
    }

    public final SQLiteDatabase getWritableDatabase() throws SQLiteException {
        try {
            return super.getWritableDatabase();
        } catch (SQLiteDatabaseLockedException e2) {
            throw e2;
        } catch (SQLiteException unused) {
            this.zza.zzs.zzaz().zzd.zza("Opening the local database failed, dropping and recreating it");
            zzgi zzgi = this.zza.zzs;
            zzaf zzaf = zzgi.zzk;
            if (!zzgi.zze.getDatabasePath("google_app_measurement_local.db").delete()) {
                this.zza.zzs.zzaz().zzd.zzb("Failed to delete corrupted local db file", "google_app_measurement_local.db");
            }
            try {
                return super.getWritableDatabase();
            } catch (SQLiteException e3) {
                this.zza.zzs.zzaz().zzd.zzb("Failed to open local database. Events will bypass local storage", e3);
                return null;
            }
        }
    }

    public final void onCreate(SQLiteDatabase sQLiteDatabase) {
        ImageOriginUtils.zzb(this.zza.zzs.zzaz(), sQLiteDatabase);
    }

    public final void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }

    public final void onOpen(SQLiteDatabase sQLiteDatabase) {
        ImageOriginUtils.zza(this.zza.zzs.zzaz(), sQLiteDatabase, CarExtender.KEY_MESSAGES, "create table if not exists messages ( type INTEGER NOT NULL, entry BLOB NOT NULL)", "type,entry", null);
    }

    public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }
}
