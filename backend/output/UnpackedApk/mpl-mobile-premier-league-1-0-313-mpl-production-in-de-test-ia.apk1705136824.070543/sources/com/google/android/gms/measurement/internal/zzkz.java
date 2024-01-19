package com.google.android.gms.measurement.internal;

import android.database.sqlite.SQLiteException;
import com.google.android.gms.common.internal.Preconditions;
import java.util.List;
import java.util.Map;
import sfs2x.client.requests.BaseRequest;

/* compiled from: com.google.android.gms:play-services-measurement@@20.1.2 */
public final class zzkz implements zzfa {
    public final /* synthetic */ String zza;
    public final /* synthetic */ zzli zzb;

    public zzkz(zzli zzli, String str) {
        this.zzb = zzli;
        this.zza = str;
    }

    /* JADX INFO: finally extract failed */
    public final void zza(String str, int i, Throwable th, byte[] bArr, Map map) {
        zzal zzal;
        zzli zzli = this.zzb;
        zzli.zzaA().zzg();
        zzli.zzB();
        if (bArr == null) {
            try {
                bArr = new byte[0];
            } catch (Throwable th2) {
                zzli.zzu = false;
                zzli.zzad();
                throw th2;
            }
        }
        List<Long> list = zzli.zzy;
        Preconditions.checkNotNull(list);
        zzli.zzy = null;
        if (i != 200) {
            if (i == 204) {
                i = BaseRequest.SetBuddyVariables;
            }
            zzli.zzaz().zzl.zzc("Network upload failed. Will retry later. code, error", Integer.valueOf(i), th);
            zzli.zzk.zzd.zzb(zzli.zzaw().currentTimeMillis());
            if (i == 503 || i == 429) {
                zzli.zzk.zzb.zzb(zzli.zzaw().currentTimeMillis());
            }
            zzal zzal2 = zzli.zze;
            zzli.zzak(zzal2);
            zzal2.zzy(list);
            zzli.zzaf();
            zzli.zzu = false;
            zzli.zzad();
        }
        if (th == null) {
            try {
                zzli.zzk.zzc.zzb(zzli.zzaw().currentTimeMillis());
                zzli.zzk.zzd.zzb(0);
                zzli.zzaf();
                zzli.zzaz().zzl.zzc("Successful upload. Got network response. code, size", Integer.valueOf(i), Integer.valueOf(bArr.length));
                zzal zzal3 = zzli.zze;
                zzli.zzak(zzal3);
                zzal3.zzw();
                try {
                    for (Long l : list) {
                        try {
                            zzal = zzli.zze;
                            zzli.zzak(zzal);
                            long longValue = l.longValue();
                            zzal.zzg();
                            zzal.zzW();
                            if (zzal.zzh().delete("queue", "rowid=?", new String[]{String.valueOf(longValue)}) != 1) {
                                throw new SQLiteException("Deleted fewer rows from queue than expected");
                            }
                        } catch (SQLiteException e2) {
                            zzal.zzs.zzaz().zzd.zzb("Failed to delete a bundle in a queue table", e2);
                            throw e2;
                        } catch (SQLiteException e3) {
                            List list2 = zzli.zzz;
                            if (list2 == null || !list2.contains(l)) {
                                throw e3;
                            }
                        }
                    }
                    zzal zzal4 = zzli.zze;
                    zzli.zzak(zzal4);
                    zzal4.zzC();
                    zzal zzal5 = zzli.zze;
                    zzli.zzak(zzal5);
                    zzal5.zzx();
                    zzli.zzz = null;
                    zzfe zzfe = zzli.zzd;
                    zzli.zzak(zzfe);
                    if (!zzfe.zza() || !zzli.zzah()) {
                        zzli.zzA = -1;
                        zzli.zzaf();
                    } else {
                        zzli.zzW();
                    }
                    zzli.zza = 0;
                    zzli.zzu = false;
                    zzli.zzad();
                } catch (Throwable th3) {
                    zzal zzal6 = zzli.zze;
                    zzli.zzak(zzal6);
                    zzal6.zzx();
                    throw th3;
                }
            } catch (SQLiteException e4) {
                zzli.zzaz().zzd.zzb("Database error while trying to delete uploaded bundles", e4);
                zzli.zza = zzli.zzaw().elapsedRealtime();
                zzli.zzaz().zzl.zzb("Disable upload, time", Long.valueOf(zzli.zza));
            }
        }
        zzli.zzaz().zzl.zzc("Network upload failed. Will retry later. code, error", Integer.valueOf(i), th);
        zzli.zzk.zzd.zzb(zzli.zzaw().currentTimeMillis());
        zzli.zzk.zzb.zzb(zzli.zzaw().currentTimeMillis());
        zzal zzal22 = zzli.zze;
        zzli.zzak(zzal22);
        zzal22.zzy(list);
        zzli.zzaf();
        zzli.zzu = false;
        zzli.zzad();
    }
}
