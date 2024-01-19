package com.google.android.gms.measurement.internal;

import android.text.TextUtils;
import androidx.collection.ArrayMap;
import androidx.collection.LruCache;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.measurement.zzc;
import com.google.android.gms.internal.measurement.zzd;
import com.google.android.gms.internal.measurement.zzfa;
import com.google.android.gms.internal.measurement.zzfb;
import com.google.android.gms.internal.measurement.zzfd;
import com.google.android.gms.internal.measurement.zzfe;
import com.google.android.gms.internal.measurement.zzfi;
import com.google.android.gms.internal.measurement.zzgq;
import com.google.android.gms.internal.measurement.zzgs;
import com.google.android.gms.internal.measurement.zzkm;
import com.google.android.gms.internal.measurement.zzpg;
import com.google.android.gms.internal.measurement.zzr;
import com.mpl.androidapp.onesignal.OneSingnalConstant;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-measurement@@20.1.2 */
public final class zzfz extends zzkw implements zzae {
    @VisibleForTesting
    public final Map zza = new ArrayMap();
    @VisibleForTesting
    public final Map zzb = new ArrayMap();
    @VisibleForTesting
    public final Map zzc = new ArrayMap();
    @VisibleForTesting
    public final LruCache zzd = new zzfw(this);
    public final zzr zze = new zzfx(this);
    public final Map zzg = new ArrayMap();
    public final Map zzh = new ArrayMap();
    public final Map zzi = new ArrayMap();
    public final Map zzj = new ArrayMap();
    public final Map zzk = new ArrayMap();
    public final Map zzl = new ArrayMap();

    public zzfz(zzli zzli) {
        super(zzli);
    }

    public static final Map zzE(zzfe zzfe) {
        ArrayMap arrayMap = new ArrayMap();
        if (zzfe != null) {
            for (zzfi zzfi : zzfe.zzn()) {
                arrayMap.put(zzfi.zzb(), zzfi.zzc());
            }
        }
        return arrayMap;
    }

    public final zzfe zzA(String str, byte[] bArr) {
        if (bArr == null) {
            return zzfe.zzg();
        }
        try {
            zzfe zzfe = (zzfe) ((zzfd) zzlk.zzl(zzfe.zze(), bArr)).zzaE();
            zzew zzew = this.zzs.zzaz().zzl;
            String str2 = null;
            Object valueOf = zzfe.zzs() ? Long.valueOf(zzfe.zzc()) : null;
            if (zzfe.zzr()) {
                str2 = zzfe.zzh();
            }
            zzew.zzc("Parsed config. version, gmp_app_id", valueOf, str2);
            return zzfe;
        } catch (zzkm e2) {
            this.zzs.zzaz().zzg.zzc("Unable to merge remote config. appId", zzey.zzn(str), e2);
            return zzfe.zzg();
        } catch (RuntimeException e3) {
            this.zzs.zzaz().zzg.zzc("Unable to merge remote config. appId", zzey.zzn(str), e3);
            return zzfe.zzg();
        }
    }

    public final void zzB(String str, zzfd zzfd) {
        HashSet hashSet = new HashSet();
        ArrayMap arrayMap = new ArrayMap();
        ArrayMap arrayMap2 = new ArrayMap();
        ArrayMap arrayMap3 = new ArrayMap();
        if (zzfd != null) {
            zzpg.zzc();
            if (this.zzs.zzk.zzs(null, zzel.zzaB)) {
                for (zzfa zzb2 : zzfd.zzg()) {
                    hashSet.add(zzb2.zzb());
                }
            }
            for (int i = 0; i < zzfd.zza(); i++) {
                zzfb zzfb = (zzfb) zzfd.zzb(i).zzbB();
                if (TextUtils.isEmpty(zzfb.zzc())) {
                    this.zzs.zzaz().zzg.zza("EventConfig contained null event name");
                } else {
                    String zzc2 = zzfb.zzc();
                    String zzb3 = zzhf.zzb(zzfb.zzc());
                    if (!TextUtils.isEmpty(zzb3)) {
                        zzfb.zzb(zzb3);
                        zzfd.zzd(i, zzfb);
                    }
                    if (zzfb.zzf() && zzfb.zzd()) {
                        arrayMap.put(zzc2, Boolean.TRUE);
                    }
                    if (zzfb.zzg() && zzfb.zze()) {
                        arrayMap2.put(zzfb.zzc(), Boolean.TRUE);
                    }
                    if (zzfb.zzh()) {
                        if (zzfb.zza() < 2 || zzfb.zza() > 65535) {
                            this.zzs.zzaz().zzg.zzc("Invalid sampling rate. Event name, sample rate", zzfb.zzc(), Integer.valueOf(zzfb.zza()));
                        } else {
                            arrayMap3.put(zzfb.zzc(), Integer.valueOf(zzfb.zza()));
                        }
                    }
                }
            }
        }
        this.zza.put(str, hashSet);
        this.zzb.put(str, arrayMap);
        this.zzc.put(str, arrayMap2);
        this.zzi.put(str, arrayMap3);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:27:0x00a0, code lost:
        if (r2 != null) goto L_0x00a2;
     */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00a8  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00d6  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0124  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzC(java.lang.String r13) {
        /*
            r12 = this;
            r12.zzW()
            r12.zzg()
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r13)
            java.util.Map r0 = r12.zzh
            java.lang.Object r0 = r0.get(r13)
            if (r0 != 0) goto L_0x0128
            com.google.android.gms.measurement.internal.zzli r0 = r12.zzf
            com.google.android.gms.measurement.internal.zzal r0 = r0.zze
            com.google.android.gms.measurement.internal.zzli.zzak(r0)
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r13)
            r0.zzg()
            r0.zzW()
            r1 = 0
            android.database.sqlite.SQLiteDatabase r2 = r0.zzh()     // Catch:{ SQLiteException -> 0x008c, all -> 0x0089 }
            java.lang.String r3 = "remote_config"
            java.lang.String r4 = "config_last_modified_time"
            java.lang.String r5 = "e_tag"
            java.lang.String[] r4 = new java.lang.String[]{r3, r4, r5}     // Catch:{ SQLiteException -> 0x008c, all -> 0x0089 }
            r10 = 1
            java.lang.String[] r6 = new java.lang.String[r10]     // Catch:{ SQLiteException -> 0x008c, all -> 0x0089 }
            r11 = 0
            r6[r11] = r13     // Catch:{ SQLiteException -> 0x008c, all -> 0x0089 }
            java.lang.String r3 = "apps"
            java.lang.String r5 = "app_id=?"
            r7 = 0
            r8 = 0
            r9 = 0
            android.database.Cursor r2 = r2.query(r3, r4, r5, r6, r7, r8, r9)     // Catch:{ SQLiteException -> 0x008c, all -> 0x0089 }
            boolean r3 = r2.moveToFirst()     // Catch:{ SQLiteException -> 0x007b }
            if (r3 != 0) goto L_0x0048
            goto L_0x00a2
        L_0x0048:
            byte[] r3 = r2.getBlob(r11)     // Catch:{ SQLiteException -> 0x007b }
            java.lang.String r4 = r2.getString(r10)     // Catch:{ SQLiteException -> 0x007b }
            com.google.android.gms.measurement.internal.zzgi r5 = r0.zzs     // Catch:{ SQLiteException -> 0x007b }
            com.google.android.gms.measurement.internal.zzaf r5 = r5.zzk     // Catch:{ SQLiteException -> 0x007b }
            com.google.android.gms.measurement.internal.zzek r6 = com.google.android.gms.measurement.internal.zzel.zzaM     // Catch:{ SQLiteException -> 0x007b }
            boolean r5 = r5.zzs(r1, r6)     // Catch:{ SQLiteException -> 0x007b }
            if (r5 == 0) goto L_0x0062
            r5 = 2
            java.lang.String r5 = r2.getString(r5)     // Catch:{ SQLiteException -> 0x007b }
            goto L_0x0063
        L_0x0062:
            r5 = r1
        L_0x0063:
            boolean r6 = r2.moveToNext()     // Catch:{ SQLiteException -> 0x007b }
            if (r6 == 0) goto L_0x007d
            com.google.android.gms.measurement.internal.zzgi r6 = r0.zzs     // Catch:{ SQLiteException -> 0x007b }
            com.google.android.gms.measurement.internal.zzey r6 = r6.zzaz()     // Catch:{ SQLiteException -> 0x007b }
            com.google.android.gms.measurement.internal.zzew r6 = r6.zzd     // Catch:{ SQLiteException -> 0x007b }
            java.lang.String r7 = "Got multiple records for app config, expected one. appId"
            java.lang.Object r8 = com.google.android.gms.measurement.internal.zzey.zzn(r13)     // Catch:{ SQLiteException -> 0x007b }
            r6.zzb(r7, r8)     // Catch:{ SQLiteException -> 0x007b }
            goto L_0x007d
        L_0x007b:
            r3 = move-exception
            goto L_0x008f
        L_0x007d:
            if (r3 != 0) goto L_0x0080
            goto L_0x00a2
        L_0x0080:
            com.google.android.gms.measurement.internal.zzai r6 = new com.google.android.gms.measurement.internal.zzai     // Catch:{ SQLiteException -> 0x007b }
            r6.<init>(r3, r4, r5)     // Catch:{ SQLiteException -> 0x007b }
            r2.close()
            goto L_0x00a6
        L_0x0089:
            r13 = move-exception
            goto L_0x0122
        L_0x008c:
            r2 = move-exception
            r3 = r2
            r2 = r1
        L_0x008f:
            com.google.android.gms.measurement.internal.zzgi r0 = r0.zzs     // Catch:{ all -> 0x0120 }
            com.google.android.gms.measurement.internal.zzey r0 = r0.zzaz()     // Catch:{ all -> 0x0120 }
            com.google.android.gms.measurement.internal.zzew r0 = r0.zzd     // Catch:{ all -> 0x0120 }
            java.lang.String r4 = "Error querying remote config. appId"
            java.lang.Object r5 = com.google.android.gms.measurement.internal.zzey.zzn(r13)     // Catch:{ all -> 0x0120 }
            r0.zzc(r4, r5, r3)     // Catch:{ all -> 0x0120 }
            if (r2 == 0) goto L_0x00a5
        L_0x00a2:
            r2.close()
        L_0x00a5:
            r6 = r1
        L_0x00a6:
            if (r6 != 0) goto L_0x00d6
            java.util.Map r0 = r12.zzg
            r0.put(r13, r1)
            java.util.Map r0 = r12.zzb
            r0.put(r13, r1)
            java.util.Map r0 = r12.zza
            r0.put(r13, r1)
            java.util.Map r0 = r12.zzc
            r0.put(r13, r1)
            java.util.Map r0 = r12.zzh
            r0.put(r13, r1)
            java.util.Map r0 = r12.zzj
            r0.put(r13, r1)
            java.util.Map r0 = r12.zzk
            r0.put(r13, r1)
            java.util.Map r0 = r12.zzl
            r0.put(r13, r1)
            java.util.Map r0 = r12.zzi
            r0.put(r13, r1)
            return
        L_0x00d6:
            byte[] r0 = r6.zza
            com.google.android.gms.internal.measurement.zzfe r0 = r12.zzA(r13, r0)
            com.google.android.gms.internal.measurement.zzjy r0 = r0.zzbB()
            com.google.android.gms.internal.measurement.zzfd r0 = (com.google.android.gms.internal.measurement.zzfd) r0
            r12.zzB(r13, r0)
            java.util.Map r1 = r12.zzg
            com.google.android.gms.internal.measurement.zzkc r2 = r0.zzaE()
            com.google.android.gms.internal.measurement.zzfe r2 = (com.google.android.gms.internal.measurement.zzfe) r2
            java.util.Map r2 = zzE(r2)
            r1.put(r13, r2)
            java.util.Map r1 = r12.zzh
            com.google.android.gms.internal.measurement.zzkc r2 = r0.zzaE()
            com.google.android.gms.internal.measurement.zzfe r2 = (com.google.android.gms.internal.measurement.zzfe) r2
            r1.put(r13, r2)
            com.google.android.gms.internal.measurement.zzkc r1 = r0.zzaE()
            com.google.android.gms.internal.measurement.zzfe r1 = (com.google.android.gms.internal.measurement.zzfe) r1
            r12.zzD(r13, r1)
            java.util.Map r1 = r12.zzj
            java.lang.String r0 = r0.zze()
            r1.put(r13, r0)
            java.util.Map r0 = r12.zzk
            java.lang.String r1 = r6.zzb
            r0.put(r13, r1)
            java.util.Map r0 = r12.zzl
            java.lang.String r1 = r6.zzc
            r0.put(r13, r1)
            return
        L_0x0120:
            r13 = move-exception
            r1 = r2
        L_0x0122:
            if (r1 == 0) goto L_0x0127
            r1.close()
        L_0x0127:
            throw r13
        L_0x0128:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzfz.zzC(java.lang.String):void");
    }

    public final void zzD(String str, zzfe zzfe) {
        if (zzfe.zza() != 0) {
            this.zzs.zzaz().zzl.zzb("EES programs found", Integer.valueOf(zzfe.zza()));
            zzgs zzgs = (zzgs) zzfe.zzm().get(0);
            try {
                zzc zzc2 = new zzc();
                zzc2.zzd("internal.remoteConfig", new zzft(this, str));
                zzc2.zzd("internal.appMetadata", new zzfv(this, str));
                zzc2.zzd("internal.logger", new zzfs(this));
                zzc2.zzc(zzgs);
                this.zzd.put(str, zzc2);
                this.zzs.zzaz().zzl.zzc("EES program loaded for appId, activities", str, Integer.valueOf(zzgs.zza().zza()));
                for (zzgq zzb2 : zzgs.zza().zzd()) {
                    this.zzs.zzaz().zzl.zzb("EES program activity", zzb2.zzb());
                }
            } catch (zzd unused) {
                this.zzs.zzaz().zzd.zzb("Failed to load EES program. appId", str);
            }
        } else {
            this.zzd.remove(str);
        }
    }

    public final String zza(String str, String str2) {
        zzg();
        zzC(str);
        Map map = (Map) this.zzg.get(str);
        if (map != null) {
            return (String) map.get(str2);
        }
        return null;
    }

    public final boolean zzb() {
        return false;
    }

    public final int zzc(String str, String str2) {
        zzg();
        zzC(str);
        Map map = (Map) this.zzi.get(str);
        if (map == null) {
            return 1;
        }
        Integer num = (Integer) map.get(str2);
        if (num == null) {
            return 1;
        }
        return num.intValue();
    }

    public final zzfe zze(String str) {
        zzW();
        zzg();
        Preconditions.checkNotEmpty(str);
        zzC(str);
        return (zzfe) this.zzh.get(str);
    }

    public final String zzi(String str) {
        zzg();
        zzC(str);
        return (String) this.zzj.get(str);
    }

    public final Set zzk(String str) {
        zzg();
        zzC(str);
        return (Set) this.zza.get(str);
    }

    public final boolean zzn(String str) {
        zzg();
        zzfe zze2 = zze(str);
        if (zze2 == null) {
            return false;
        }
        return zze2.zzq();
    }

    public final boolean zzo(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        zzfe zzfe = (zzfe) this.zzh.get(str);
        if (zzfe == null || zzfe.zza() == 0) {
            return false;
        }
        return true;
    }

    public final boolean zzp(String str) {
        return "1".equals(zza(str, "measurement.upload.blacklist_internal"));
    }

    public final boolean zzq(String str, String str2) {
        zzg();
        zzC(str);
        if ("ecommerce_purchase".equals(str2) || "purchase".equals(str2) || "refund".equals(str2)) {
            return true;
        }
        Map map = (Map) this.zzc.get(str);
        if (map == null) {
            return false;
        }
        Boolean bool = (Boolean) map.get(str2);
        if (bool == null) {
            return false;
        }
        return bool.booleanValue();
    }

    public final boolean zzr(String str, String str2) {
        zzg();
        zzC(str);
        if ("1".equals(zza(str, "measurement.upload.blacklist_internal")) && zzlp.zzah(str2)) {
            return true;
        }
        if ("1".equals(zza(str, "measurement.upload.blacklist_public")) && zzlp.zzai(str2)) {
            return true;
        }
        Map map = (Map) this.zzb.get(str);
        if (map == null) {
            return false;
        }
        Boolean bool = (Boolean) map.get(str2);
        if (bool == null) {
            return false;
        }
        return bool.booleanValue();
    }

    public final boolean zzs(String str) {
        return "1".equals(zza(str, "measurement.upload.blacklist_public"));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:100:0x0395, code lost:
        r0 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:101:0x0396, code lost:
        r12.put("filter_id", r0);
        r25 = r4;
        r12.put("property_name", r3.zze());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:102:0x03a8, code lost:
        if (r3.zzk() == false) goto L_0x03b3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:103:0x03aa, code lost:
        r0 = java.lang.Boolean.valueOf(r3.zzi());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:104:0x03b3, code lost:
        r0 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:105:0x03b4, code lost:
        r12.put("session_scoped", r0);
        r12.put("data", r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:108:0x03c6, code lost:
        if (r7.zzh().insertWithOnConflict("property_filters", null, r12, 5) != -1) goto L_0x03da;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:109:0x03c8, code lost:
        r7.zzs.zzaz().zzd.zzb("Failed to insert property filter (got -1). appId", com.google.android.gms.measurement.internal.zzey.zzn(r29));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:110:0x03da, code lost:
        r0 = r24;
        r4 = r25;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:111:0x03e0, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:113:?, code lost:
        r7.zzs.zzaz().zzd.zzc("Error storing property filter. appId", com.google.android.gms.measurement.internal.zzey.zzn(r29), r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x0202, code lost:
        r9 = r0.zzh().iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x020e, code lost:
        if (r9.hasNext() == false) goto L_0x0233;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x021a, code lost:
        if (((com.google.android.gms.internal.measurement.zzes) r9.next()).zzj() != false) goto L_0x020a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x021c, code lost:
        r7.zzs.zzaz().zzg.zzc("Property filter with no ID. Audience definition ignored. appId, audienceId", com.google.android.gms.measurement.internal.zzey.zzn(r29), java.lang.Integer.valueOf(r6));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x0233, code lost:
        r9 = r0.zzg().iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x023f, code lost:
        r4 = "audience_id";
        r22 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x024d, code lost:
        if (r9.hasNext() == false) goto L_0x0319;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:?, code lost:
        r12 = (com.google.android.gms.internal.measurement.zzej) r9.next();
        r7.zzW();
        r7.zzg();
        com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r29);
        com.google.android.gms.common.internal.Preconditions.checkNotNull(r12);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x0269, code lost:
        if (android.text.TextUtils.isEmpty(r12.zzg()) == false) goto L_0x0299;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x026b, code lost:
        r0 = r7.zzs.zzaz().zzg;
        r4 = com.google.android.gms.measurement.internal.zzey.zzn(r29);
        r5 = java.lang.Integer.valueOf(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x0281, code lost:
        if (r12.zzp() == false) goto L_0x028e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x0283, code lost:
        r17 = java.lang.Integer.valueOf(r12.zzb());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x028e, code lost:
        r17 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x0290, code lost:
        r0.zzd("Event filter had no event name. Audience definition ignored. appId, audienceId, filterId", r4, r5, java.lang.String.valueOf(r17));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x0299, code lost:
        r3 = r12.zzby();
        r24 = r9;
        r9 = new android.content.ContentValues();
        r9.put("app_id", r2);
        r9.put(r4, java.lang.Integer.valueOf(r6));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x02b2, code lost:
        if (r12.zzp() == false) goto L_0x02bd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x02b4, code lost:
        r4 = java.lang.Integer.valueOf(r12.zzb());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x02bd, code lost:
        r4 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x02be, code lost:
        r9.put("filter_id", r4);
        r9.put("event_name", r12.zzg());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x02ce, code lost:
        if (r12.zzq() == false) goto L_0x02d9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x02d0, code lost:
        r4 = java.lang.Boolean.valueOf(r12.zzn());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x02d9, code lost:
        r4 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x02da, code lost:
        r9.put("session_scoped", r4);
        r9.put("data", r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x02ec, code lost:
        if (r7.zzh().insertWithOnConflict("event_filters", null, r9, 5) != -1) goto L_0x02ff;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x02ee, code lost:
        r7.zzs.zzaz().zzd.zzb("Failed to insert event filter (got -1). appId", com.google.android.gms.measurement.internal.zzey.zzn(r29));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x02ff, code lost:
        r3 = r22;
        r9 = r24;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x0319, code lost:
        r0 = r0.zzh().iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:89:0x0325, code lost:
        if (r0.hasNext() == false) goto L_0x0420;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:90:0x0327, code lost:
        r3 = (com.google.android.gms.internal.measurement.zzes) r0.next();
        r7.zzW();
        r7.zzg();
        com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r29);
        com.google.android.gms.common.internal.Preconditions.checkNotNull(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:91:0x0341, code lost:
        if (android.text.TextUtils.isEmpty(r3.zze()) == false) goto L_0x0371;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:92:0x0343, code lost:
        r0 = r7.zzs.zzaz().zzg;
        r5 = com.google.android.gms.measurement.internal.zzey.zzn(r29);
        r9 = java.lang.Integer.valueOf(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:93:0x0359, code lost:
        if (r3.zzj() == false) goto L_0x0366;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:94:0x035b, code lost:
        r17 = java.lang.Integer.valueOf(r3.zza());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:95:0x0366, code lost:
        r17 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:96:0x0368, code lost:
        r0.zzd("Property filter had no property name. Audience definition ignored. appId, audienceId, filterId", r5, r9, java.lang.String.valueOf(r17));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:97:0x0371, code lost:
        r9 = r3.zzby();
        r12 = new android.content.ContentValues();
        r12.put("app_id", r2);
        r24 = r0;
        r12.put(r4, java.lang.Integer.valueOf(r6));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:0x038a, code lost:
        if (r3.zzj() == false) goto L_0x0395;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:99:0x038c, code lost:
        r0 = java.lang.Integer.valueOf(r3.zza());
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zzt(java.lang.String r29, byte[] r30, java.lang.String r31, java.lang.String r32) {
        /*
            r28 = this;
            r1 = r28
            r2 = r29
            r3 = r31
            r4 = r32
            r28.zzW()
            r28.zzg()
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r29)
            com.google.android.gms.internal.measurement.zzfe r0 = r28.zzA(r29, r30)
            com.google.android.gms.internal.measurement.zzjy r0 = r0.zzbB()
            r5 = r0
            com.google.android.gms.internal.measurement.zzfd r5 = (com.google.android.gms.internal.measurement.zzfd) r5
            r6 = 0
            if (r5 != 0) goto L_0x0020
            return r6
        L_0x0020:
            r1.zzB(r2, r5)
            com.google.android.gms.internal.measurement.zzkc r0 = r5.zzaE()
            com.google.android.gms.internal.measurement.zzfe r0 = (com.google.android.gms.internal.measurement.zzfe) r0
            r1.zzD(r2, r0)
            java.util.Map r0 = r1.zzh
            com.google.android.gms.internal.measurement.zzkc r7 = r5.zzaE()
            com.google.android.gms.internal.measurement.zzfe r7 = (com.google.android.gms.internal.measurement.zzfe) r7
            r0.put(r2, r7)
            java.util.Map r0 = r1.zzj
            java.lang.String r7 = r5.zze()
            r0.put(r2, r7)
            java.util.Map r0 = r1.zzk
            r0.put(r2, r3)
            java.util.Map r0 = r1.zzl
            r0.put(r2, r4)
            java.util.Map r0 = r1.zzg
            com.google.android.gms.internal.measurement.zzkc r7 = r5.zzaE()
            com.google.android.gms.internal.measurement.zzfe r7 = (com.google.android.gms.internal.measurement.zzfe) r7
            java.util.Map r7 = zzE(r7)
            r0.put(r2, r7)
            com.google.android.gms.measurement.internal.zzli r0 = r1.zzf
            com.google.android.gms.measurement.internal.zzal r7 = r0.zze
            com.google.android.gms.measurement.internal.zzli.zzak(r7)
            java.util.ArrayList r8 = new java.util.ArrayList
            java.util.List r0 = r5.zzf()
            r8.<init>(r0)
            java.lang.String r9 = "app_id=? and audience_id=?"
            java.lang.String r0 = "app_id=?"
            java.lang.String r10 = "event_filters"
            java.lang.String r11 = "property_filters"
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r8)
            r12 = 0
        L_0x0075:
            int r13 = r8.size()
            if (r12 >= r13) goto L_0x0166
            java.lang.Object r13 = r8.get(r12)
            com.google.android.gms.internal.measurement.zzeh r13 = (com.google.android.gms.internal.measurement.zzeh) r13
            com.google.android.gms.internal.measurement.zzjy r13 = r13.zzbB()
            com.google.android.gms.internal.measurement.zzeg r13 = (com.google.android.gms.internal.measurement.zzeg) r13
            int r15 = r13.zza()
            if (r15 == 0) goto L_0x011a
            r15 = r13
        L_0x008e:
            int r14 = r15.zza()
            if (r6 >= r14) goto L_0x0115
            com.google.android.gms.internal.measurement.zzej r14 = r15.zze(r6)
            com.google.android.gms.internal.measurement.zzjy r14 = r14.zzbB()
            com.google.android.gms.internal.measurement.zzei r14 = (com.google.android.gms.internal.measurement.zzei) r14
            com.google.android.gms.internal.measurement.zzjy r16 = r14.zzau()
            r4 = r16
            com.google.android.gms.internal.measurement.zzei r4 = (com.google.android.gms.internal.measurement.zzei) r4
            java.lang.String r16 = r14.zze()
            java.lang.String r3 = com.google.android.gms.measurement.internal.zzhf.zzb(r16)
            if (r3 == 0) goto L_0x00b5
            r4.zzb(r3)
            r3 = 1
            goto L_0x00b6
        L_0x00b5:
            r3 = 0
        L_0x00b6:
            r16 = r3
            r3 = 0
        L_0x00b9:
            int r1 = r14.zza()
            if (r3 >= r1) goto L_0x00f4
            com.google.android.gms.internal.measurement.zzel r1 = r14.zzd(r3)
            r17 = r14
            java.lang.String r14 = r1.zze()
            r18 = r5
            java.lang.String[] r5 = com.google.android.gms.measurement.internal.zzhg.zza
            r19 = r9
            java.lang.String[] r9 = com.google.android.gms.measurement.internal.zzhg.zzb
            java.lang.String r5 = com.google.android.gms.measurement.internal.zzit.zzb(r14, r5, r9)
            if (r5 == 0) goto L_0x00eb
            com.google.android.gms.internal.measurement.zzjy r1 = r1.zzbB()
            com.google.android.gms.internal.measurement.zzek r1 = (com.google.android.gms.internal.measurement.zzek) r1
            r1.zza(r5)
            com.google.android.gms.internal.measurement.zzkc r1 = r1.zzaE()
            com.google.android.gms.internal.measurement.zzel r1 = (com.google.android.gms.internal.measurement.zzel) r1
            r4.zzc(r3, r1)
            r16 = 1
        L_0x00eb:
            int r3 = r3 + 1
            r14 = r17
            r5 = r18
            r9 = r19
            goto L_0x00b9
        L_0x00f4:
            r18 = r5
            r19 = r9
            if (r16 == 0) goto L_0x0107
            r15.zzc(r6, r4)
            com.google.android.gms.internal.measurement.zzkc r1 = r13.zzaE()
            com.google.android.gms.internal.measurement.zzeh r1 = (com.google.android.gms.internal.measurement.zzeh) r1
            r8.set(r12, r1)
            r15 = r13
        L_0x0107:
            int r6 = r6 + 1
            r1 = r28
            r3 = r31
            r4 = r32
            r5 = r18
            r9 = r19
            goto L_0x008e
        L_0x0115:
            r18 = r5
            r19 = r9
            goto L_0x011f
        L_0x011a:
            r18 = r5
            r19 = r9
            r15 = r13
        L_0x011f:
            int r1 = r15.zzb()
            if (r1 == 0) goto L_0x0157
            r1 = 0
        L_0x0126:
            int r3 = r15.zzb()
            if (r1 >= r3) goto L_0x0157
            com.google.android.gms.internal.measurement.zzes r3 = r15.zzf(r1)
            java.lang.String r4 = r3.zze()
            java.lang.String[] r5 = com.google.android.gms.measurement.internal.zzhh.zza
            java.lang.String[] r6 = com.google.android.gms.measurement.internal.zzhh.zzb
            java.lang.String r4 = com.google.android.gms.measurement.internal.zzit.zzb(r4, r5, r6)
            if (r4 == 0) goto L_0x0154
            com.google.android.gms.internal.measurement.zzjy r3 = r3.zzbB()
            com.google.android.gms.internal.measurement.zzer r3 = (com.google.android.gms.internal.measurement.zzer) r3
            r3.zza(r4)
            r15.zzd(r1, r3)
            com.google.android.gms.internal.measurement.zzkc r3 = r13.zzaE()
            com.google.android.gms.internal.measurement.zzeh r3 = (com.google.android.gms.internal.measurement.zzeh) r3
            r8.set(r12, r3)
            r15 = r13
        L_0x0154:
            int r1 = r1 + 1
            goto L_0x0126
        L_0x0157:
            int r12 = r12 + 1
            r1 = r28
            r3 = r31
            r4 = r32
            r5 = r18
            r9 = r19
            r6 = 0
            goto L_0x0075
        L_0x0166:
            r18 = r5
            r19 = r9
            r7.zzW()
            r7.zzg()
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r29)
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r8)
            android.database.sqlite.SQLiteDatabase r1 = r7.zzh()
            r1.beginTransaction()
            r7.zzW()     // Catch:{ all -> 0x05a6 }
            r7.zzg()     // Catch:{ all -> 0x05a6 }
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r29)     // Catch:{ all -> 0x05a6 }
            android.database.sqlite.SQLiteDatabase r3 = r7.zzh()     // Catch:{ all -> 0x05a6 }
            r4 = 1
            java.lang.String[] r5 = new java.lang.String[r4]     // Catch:{ all -> 0x05a6 }
            r6 = 0
            r5[r6] = r2     // Catch:{ all -> 0x05a6 }
            r3.delete(r11, r0, r5)     // Catch:{ all -> 0x05a6 }
            java.lang.String[] r5 = new java.lang.String[r4]     // Catch:{ all -> 0x05a6 }
            r5[r6] = r2     // Catch:{ all -> 0x05a6 }
            r3.delete(r10, r0, r5)     // Catch:{ all -> 0x05a6 }
            java.util.Iterator r3 = r8.iterator()     // Catch:{ all -> 0x05a6 }
        L_0x019e:
            boolean r0 = r3.hasNext()     // Catch:{ all -> 0x05a6 }
            if (r0 == 0) goto L_0x0424
            java.lang.Object r0 = r3.next()     // Catch:{ all -> 0x05a6 }
            com.google.android.gms.internal.measurement.zzeh r0 = (com.google.android.gms.internal.measurement.zzeh) r0     // Catch:{ all -> 0x05a6 }
            r7.zzW()     // Catch:{ all -> 0x05a6 }
            r7.zzg()     // Catch:{ all -> 0x05a6 }
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r29)     // Catch:{ all -> 0x05a6 }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r0)     // Catch:{ all -> 0x05a6 }
            boolean r6 = r0.zzk()     // Catch:{ all -> 0x05a6 }
            if (r6 != 0) goto L_0x01ce
            com.google.android.gms.measurement.internal.zzgi r0 = r7.zzs     // Catch:{ all -> 0x05a6 }
            com.google.android.gms.measurement.internal.zzey r0 = r0.zzaz()     // Catch:{ all -> 0x05a6 }
            com.google.android.gms.measurement.internal.zzew r0 = r0.zzg     // Catch:{ all -> 0x05a6 }
            java.lang.String r4 = "Audience with no ID. appId"
            java.lang.Object r5 = com.google.android.gms.measurement.internal.zzey.zzn(r29)     // Catch:{ all -> 0x05a6 }
            r0.zzb(r4, r5)     // Catch:{ all -> 0x05a6 }
            goto L_0x019e
        L_0x01ce:
            int r6 = r0.zza()     // Catch:{ all -> 0x05a6 }
            java.util.List r9 = r0.zzg()     // Catch:{ all -> 0x05a6 }
            java.util.Iterator r9 = r9.iterator()     // Catch:{ all -> 0x05a6 }
        L_0x01da:
            boolean r12 = r9.hasNext()     // Catch:{ all -> 0x05a6 }
            if (r12 == 0) goto L_0x0202
            java.lang.Object r12 = r9.next()     // Catch:{ all -> 0x05a6 }
            com.google.android.gms.internal.measurement.zzej r12 = (com.google.android.gms.internal.measurement.zzej) r12     // Catch:{ all -> 0x05a6 }
            boolean r12 = r12.zzp()     // Catch:{ all -> 0x05a6 }
            if (r12 != 0) goto L_0x01da
            com.google.android.gms.measurement.internal.zzgi r0 = r7.zzs     // Catch:{ all -> 0x05a6 }
            com.google.android.gms.measurement.internal.zzey r0 = r0.zzaz()     // Catch:{ all -> 0x05a6 }
            com.google.android.gms.measurement.internal.zzew r0 = r0.zzg     // Catch:{ all -> 0x05a6 }
            java.lang.String r4 = "Event filter with no ID. Audience definition ignored. appId, audienceId"
            java.lang.Object r5 = com.google.android.gms.measurement.internal.zzey.zzn(r29)     // Catch:{ all -> 0x05a6 }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ all -> 0x05a6 }
            r0.zzc(r4, r5, r6)     // Catch:{ all -> 0x05a6 }
            goto L_0x019e
        L_0x0202:
            java.util.List r9 = r0.zzh()     // Catch:{ all -> 0x05a6 }
            java.util.Iterator r9 = r9.iterator()     // Catch:{ all -> 0x05a6 }
        L_0x020a:
            boolean r12 = r9.hasNext()     // Catch:{ all -> 0x05a6 }
            if (r12 == 0) goto L_0x0233
            java.lang.Object r12 = r9.next()     // Catch:{ all -> 0x05a6 }
            com.google.android.gms.internal.measurement.zzes r12 = (com.google.android.gms.internal.measurement.zzes) r12     // Catch:{ all -> 0x05a6 }
            boolean r12 = r12.zzj()     // Catch:{ all -> 0x05a6 }
            if (r12 != 0) goto L_0x020a
            com.google.android.gms.measurement.internal.zzgi r0 = r7.zzs     // Catch:{ all -> 0x05a6 }
            com.google.android.gms.measurement.internal.zzey r0 = r0.zzaz()     // Catch:{ all -> 0x05a6 }
            com.google.android.gms.measurement.internal.zzew r0 = r0.zzg     // Catch:{ all -> 0x05a6 }
            java.lang.String r4 = "Property filter with no ID. Audience definition ignored. appId, audienceId"
            java.lang.Object r5 = com.google.android.gms.measurement.internal.zzey.zzn(r29)     // Catch:{ all -> 0x05a6 }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ all -> 0x05a6 }
            r0.zzc(r4, r5, r6)     // Catch:{ all -> 0x05a6 }
            goto L_0x019e
        L_0x0233:
            java.util.List r9 = r0.zzg()     // Catch:{ all -> 0x05a6 }
            java.util.Iterator r9 = r9.iterator()     // Catch:{ all -> 0x05a6 }
        L_0x023b:
            boolean r12 = r9.hasNext()     // Catch:{ all -> 0x05a6 }
            java.lang.String r13 = "data"
            java.lang.String r14 = "session_scoped"
            java.lang.String r15 = "filter_id"
            java.lang.String r4 = "audience_id"
            java.lang.String r5 = "app_id"
            r20 = -1
            r22 = r3
            if (r12 == 0) goto L_0x0319
            java.lang.Object r12 = r9.next()     // Catch:{ all -> 0x05a6 }
            com.google.android.gms.internal.measurement.zzej r12 = (com.google.android.gms.internal.measurement.zzej) r12     // Catch:{ all -> 0x05a6 }
            r7.zzW()     // Catch:{ all -> 0x05a6 }
            r7.zzg()     // Catch:{ all -> 0x05a6 }
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r29)     // Catch:{ all -> 0x05a6 }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r12)     // Catch:{ all -> 0x05a6 }
            java.lang.String r23 = r12.zzg()     // Catch:{ all -> 0x05a6 }
            boolean r23 = android.text.TextUtils.isEmpty(r23)     // Catch:{ all -> 0x05a6 }
            if (r23 == 0) goto L_0x0299
            com.google.android.gms.measurement.internal.zzgi r0 = r7.zzs     // Catch:{ all -> 0x05a6 }
            com.google.android.gms.measurement.internal.zzey r0 = r0.zzaz()     // Catch:{ all -> 0x05a6 }
            com.google.android.gms.measurement.internal.zzew r0 = r0.zzg     // Catch:{ all -> 0x05a6 }
            java.lang.String r3 = "Event filter had no event name. Audience definition ignored. appId, audienceId, filterId"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzey.zzn(r29)     // Catch:{ all -> 0x05a6 }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r6)     // Catch:{ all -> 0x05a6 }
            boolean r9 = r12.zzp()     // Catch:{ all -> 0x05a6 }
            if (r9 == 0) goto L_0x028e
            int r9 = r12.zzb()     // Catch:{ all -> 0x05a6 }
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)     // Catch:{ all -> 0x05a6 }
            r17 = r9
            goto L_0x0290
        L_0x028e:
            r17 = 0
        L_0x0290:
            java.lang.String r9 = java.lang.String.valueOf(r17)     // Catch:{ all -> 0x05a6 }
            r0.zzd(r3, r4, r5, r9)     // Catch:{ all -> 0x05a6 }
            goto L_0x03f2
        L_0x0299:
            byte[] r3 = r12.zzby()     // Catch:{ all -> 0x05a6 }
            r24 = r9
            android.content.ContentValues r9 = new android.content.ContentValues     // Catch:{ all -> 0x05a6 }
            r9.<init>()     // Catch:{ all -> 0x05a6 }
            r9.put(r5, r2)     // Catch:{ all -> 0x05a6 }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r6)     // Catch:{ all -> 0x05a6 }
            r9.put(r4, r5)     // Catch:{ all -> 0x05a6 }
            boolean r4 = r12.zzp()     // Catch:{ all -> 0x05a6 }
            if (r4 == 0) goto L_0x02bd
            int r4 = r12.zzb()     // Catch:{ all -> 0x05a6 }
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch:{ all -> 0x05a6 }
            goto L_0x02be
        L_0x02bd:
            r4 = 0
        L_0x02be:
            r9.put(r15, r4)     // Catch:{ all -> 0x05a6 }
            java.lang.String r4 = "event_name"
            java.lang.String r5 = r12.zzg()     // Catch:{ all -> 0x05a6 }
            r9.put(r4, r5)     // Catch:{ all -> 0x05a6 }
            boolean r4 = r12.zzq()     // Catch:{ all -> 0x05a6 }
            if (r4 == 0) goto L_0x02d9
            boolean r4 = r12.zzn()     // Catch:{ all -> 0x05a6 }
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r4)     // Catch:{ all -> 0x05a6 }
            goto L_0x02da
        L_0x02d9:
            r4 = 0
        L_0x02da:
            r9.put(r14, r4)     // Catch:{ all -> 0x05a6 }
            r9.put(r13, r3)     // Catch:{ all -> 0x05a6 }
            android.database.sqlite.SQLiteDatabase r3 = r7.zzh()     // Catch:{ SQLiteException -> 0x0305 }
            r4 = 5
            r5 = 0
            long r3 = r3.insertWithOnConflict(r10, r5, r9, r4)     // Catch:{ SQLiteException -> 0x0305 }
            int r5 = (r3 > r20 ? 1 : (r3 == r20 ? 0 : -1))
            if (r5 != 0) goto L_0x02ff
            com.google.android.gms.measurement.internal.zzgi r3 = r7.zzs     // Catch:{ SQLiteException -> 0x0305 }
            com.google.android.gms.measurement.internal.zzey r3 = r3.zzaz()     // Catch:{ SQLiteException -> 0x0305 }
            com.google.android.gms.measurement.internal.zzew r3 = r3.zzd     // Catch:{ SQLiteException -> 0x0305 }
            java.lang.String r4 = "Failed to insert event filter (got -1). appId"
            java.lang.Object r5 = com.google.android.gms.measurement.internal.zzey.zzn(r29)     // Catch:{ SQLiteException -> 0x0305 }
            r3.zzb(r4, r5)     // Catch:{ SQLiteException -> 0x0305 }
        L_0x02ff:
            r3 = r22
            r9 = r24
            goto L_0x023b
        L_0x0305:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzgi r3 = r7.zzs     // Catch:{ all -> 0x05a6 }
            com.google.android.gms.measurement.internal.zzey r3 = r3.zzaz()     // Catch:{ all -> 0x05a6 }
            com.google.android.gms.measurement.internal.zzew r3 = r3.zzd     // Catch:{ all -> 0x05a6 }
            java.lang.String r4 = "Error storing event filter. appId"
            java.lang.Object r5 = com.google.android.gms.measurement.internal.zzey.zzn(r29)     // Catch:{ all -> 0x05a6 }
            r3.zzc(r4, r5, r0)     // Catch:{ all -> 0x05a6 }
            goto L_0x03f2
        L_0x0319:
            java.util.List r0 = r0.zzh()     // Catch:{ all -> 0x05a6 }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ all -> 0x05a6 }
        L_0x0321:
            boolean r3 = r0.hasNext()     // Catch:{ all -> 0x05a6 }
            if (r3 == 0) goto L_0x0420
            java.lang.Object r3 = r0.next()     // Catch:{ all -> 0x05a6 }
            com.google.android.gms.internal.measurement.zzes r3 = (com.google.android.gms.internal.measurement.zzes) r3     // Catch:{ all -> 0x05a6 }
            r7.zzW()     // Catch:{ all -> 0x05a6 }
            r7.zzg()     // Catch:{ all -> 0x05a6 }
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r29)     // Catch:{ all -> 0x05a6 }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r3)     // Catch:{ all -> 0x05a6 }
            java.lang.String r9 = r3.zze()     // Catch:{ all -> 0x05a6 }
            boolean r9 = android.text.TextUtils.isEmpty(r9)     // Catch:{ all -> 0x05a6 }
            if (r9 == 0) goto L_0x0371
            com.google.android.gms.measurement.internal.zzgi r0 = r7.zzs     // Catch:{ all -> 0x05a6 }
            com.google.android.gms.measurement.internal.zzey r0 = r0.zzaz()     // Catch:{ all -> 0x05a6 }
            com.google.android.gms.measurement.internal.zzew r0 = r0.zzg     // Catch:{ all -> 0x05a6 }
            java.lang.String r4 = "Property filter had no property name. Audience definition ignored. appId, audienceId, filterId"
            java.lang.Object r5 = com.google.android.gms.measurement.internal.zzey.zzn(r29)     // Catch:{ all -> 0x05a6 }
            java.lang.Integer r9 = java.lang.Integer.valueOf(r6)     // Catch:{ all -> 0x05a6 }
            boolean r12 = r3.zzj()     // Catch:{ all -> 0x05a6 }
            if (r12 == 0) goto L_0x0366
            int r3 = r3.zza()     // Catch:{ all -> 0x05a6 }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ all -> 0x05a6 }
            r17 = r3
            goto L_0x0368
        L_0x0366:
            r17 = 0
        L_0x0368:
            java.lang.String r3 = java.lang.String.valueOf(r17)     // Catch:{ all -> 0x05a6 }
            r0.zzd(r4, r5, r9, r3)     // Catch:{ all -> 0x05a6 }
            goto L_0x03f2
        L_0x0371:
            byte[] r9 = r3.zzby()     // Catch:{ all -> 0x05a6 }
            android.content.ContentValues r12 = new android.content.ContentValues     // Catch:{ all -> 0x05a6 }
            r12.<init>()     // Catch:{ all -> 0x05a6 }
            r12.put(r5, r2)     // Catch:{ all -> 0x05a6 }
            r24 = r0
            java.lang.Integer r0 = java.lang.Integer.valueOf(r6)     // Catch:{ all -> 0x05a6 }
            r12.put(r4, r0)     // Catch:{ all -> 0x05a6 }
            boolean r0 = r3.zzj()     // Catch:{ all -> 0x05a6 }
            if (r0 == 0) goto L_0x0395
            int r0 = r3.zza()     // Catch:{ all -> 0x05a6 }
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{ all -> 0x05a6 }
            goto L_0x0396
        L_0x0395:
            r0 = 0
        L_0x0396:
            r12.put(r15, r0)     // Catch:{ all -> 0x05a6 }
            java.lang.String r0 = "property_name"
            r25 = r4
            java.lang.String r4 = r3.zze()     // Catch:{ all -> 0x05a6 }
            r12.put(r0, r4)     // Catch:{ all -> 0x05a6 }
            boolean r0 = r3.zzk()     // Catch:{ all -> 0x05a6 }
            if (r0 == 0) goto L_0x03b3
            boolean r0 = r3.zzi()     // Catch:{ all -> 0x05a6 }
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)     // Catch:{ all -> 0x05a6 }
            goto L_0x03b4
        L_0x03b3:
            r0 = 0
        L_0x03b4:
            r12.put(r14, r0)     // Catch:{ all -> 0x05a6 }
            r12.put(r13, r9)     // Catch:{ all -> 0x05a6 }
            android.database.sqlite.SQLiteDatabase r0 = r7.zzh()     // Catch:{ SQLiteException -> 0x03e0 }
            r3 = 5
            r4 = 0
            long r26 = r0.insertWithOnConflict(r11, r4, r12, r3)     // Catch:{ SQLiteException -> 0x03e0 }
            int r0 = (r26 > r20 ? 1 : (r26 == r20 ? 0 : -1))
            if (r0 != 0) goto L_0x03da
            com.google.android.gms.measurement.internal.zzgi r0 = r7.zzs     // Catch:{ SQLiteException -> 0x03e0 }
            com.google.android.gms.measurement.internal.zzey r0 = r0.zzaz()     // Catch:{ SQLiteException -> 0x03e0 }
            com.google.android.gms.measurement.internal.zzew r0 = r0.zzd     // Catch:{ SQLiteException -> 0x03e0 }
            java.lang.String r3 = "Failed to insert property filter (got -1). appId"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzey.zzn(r29)     // Catch:{ SQLiteException -> 0x03e0 }
            r0.zzb(r3, r4)     // Catch:{ SQLiteException -> 0x03e0 }
            goto L_0x03f2
        L_0x03da:
            r0 = r24
            r4 = r25
            goto L_0x0321
        L_0x03e0:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzgi r3 = r7.zzs     // Catch:{ all -> 0x05a6 }
            com.google.android.gms.measurement.internal.zzey r3 = r3.zzaz()     // Catch:{ all -> 0x05a6 }
            com.google.android.gms.measurement.internal.zzew r3 = r3.zzd     // Catch:{ all -> 0x05a6 }
            java.lang.String r4 = "Error storing property filter. appId"
            java.lang.Object r5 = com.google.android.gms.measurement.internal.zzey.zzn(r29)     // Catch:{ all -> 0x05a6 }
            r3.zzc(r4, r5, r0)     // Catch:{ all -> 0x05a6 }
        L_0x03f2:
            r7.zzW()     // Catch:{ all -> 0x05a6 }
            r7.zzg()     // Catch:{ all -> 0x05a6 }
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r29)     // Catch:{ all -> 0x05a6 }
            android.database.sqlite.SQLiteDatabase r0 = r7.zzh()     // Catch:{ all -> 0x05a6 }
            r3 = 2
            java.lang.String[] r4 = new java.lang.String[r3]     // Catch:{ all -> 0x05a6 }
            r5 = 0
            r4[r5] = r2     // Catch:{ all -> 0x05a6 }
            java.lang.String r9 = java.lang.String.valueOf(r6)     // Catch:{ all -> 0x05a6 }
            r12 = 1
            r4[r12] = r9     // Catch:{ all -> 0x05a6 }
            r9 = r19
            r0.delete(r11, r9, r4)     // Catch:{ all -> 0x05a6 }
            java.lang.String[] r3 = new java.lang.String[r3]     // Catch:{ all -> 0x05a6 }
            r3[r5] = r2     // Catch:{ all -> 0x05a6 }
            java.lang.String r4 = java.lang.String.valueOf(r6)     // Catch:{ all -> 0x05a6 }
            r3[r12] = r4     // Catch:{ all -> 0x05a6 }
            r0.delete(r10, r9, r3)     // Catch:{ all -> 0x05a6 }
            r19 = r9
        L_0x0420:
            r3 = r22
            goto L_0x019e
        L_0x0424:
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch:{ all -> 0x05a6 }
            r0.<init>()     // Catch:{ all -> 0x05a6 }
            java.util.Iterator r3 = r8.iterator()     // Catch:{ all -> 0x05a6 }
        L_0x042d:
            boolean r4 = r3.hasNext()     // Catch:{ all -> 0x05a6 }
            if (r4 == 0) goto L_0x044d
            java.lang.Object r4 = r3.next()     // Catch:{ all -> 0x05a6 }
            com.google.android.gms.internal.measurement.zzeh r4 = (com.google.android.gms.internal.measurement.zzeh) r4     // Catch:{ all -> 0x05a6 }
            boolean r5 = r4.zzk()     // Catch:{ all -> 0x05a6 }
            if (r5 == 0) goto L_0x0448
            int r4 = r4.zza()     // Catch:{ all -> 0x05a6 }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r4)     // Catch:{ all -> 0x05a6 }
            goto L_0x0449
        L_0x0448:
            r5 = 0
        L_0x0449:
            r0.add(r5)     // Catch:{ all -> 0x05a6 }
            goto L_0x042d
        L_0x044d:
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r29)     // Catch:{ all -> 0x05a6 }
            r7.zzW()     // Catch:{ all -> 0x05a6 }
            r7.zzg()     // Catch:{ all -> 0x05a6 }
            android.database.sqlite.SQLiteDatabase r3 = r7.zzh()     // Catch:{ all -> 0x05a6 }
            r4 = 1
            java.lang.String[] r5 = new java.lang.String[r4]     // Catch:{ SQLiteException -> 0x04e9 }
            r4 = 0
            r5[r4] = r2     // Catch:{ SQLiteException -> 0x04e9 }
            java.lang.String r4 = "select count(1) from audience_filter_values where app_id=?"
            long r4 = r7.zzZ(r4, r5)     // Catch:{ SQLiteException -> 0x04e9 }
            com.google.android.gms.measurement.internal.zzgi r6 = r7.zzs     // Catch:{ all -> 0x05a6 }
            com.google.android.gms.measurement.internal.zzaf r6 = r6.zzk     // Catch:{ all -> 0x05a6 }
            r7 = 2000(0x7d0, float:2.803E-42)
            com.google.android.gms.measurement.internal.zzek r8 = com.google.android.gms.measurement.internal.zzel.zzE     // Catch:{ all -> 0x05a6 }
            int r6 = r6.zze(r2, r8)     // Catch:{ all -> 0x05a6 }
            int r6 = java.lang.Math.min(r7, r6)     // Catch:{ all -> 0x05a6 }
            r7 = 0
            int r6 = java.lang.Math.max(r7, r6)     // Catch:{ all -> 0x05a6 }
            long r7 = (long) r6     // Catch:{ all -> 0x05a6 }
            int r9 = (r4 > r7 ? 1 : (r4 == r7 ? 0 : -1))
            if (r9 > 0) goto L_0x0482
            goto L_0x04fb
        L_0x0482:
            java.util.ArrayList r4 = new java.util.ArrayList     // Catch:{ all -> 0x05a6 }
            r4.<init>()     // Catch:{ all -> 0x05a6 }
            r5 = 0
        L_0x0488:
            int r7 = r0.size()     // Catch:{ all -> 0x05a6 }
            if (r5 >= r7) goto L_0x04a4
            java.lang.Object r7 = r0.get(r5)     // Catch:{ all -> 0x05a6 }
            java.lang.Integer r7 = (java.lang.Integer) r7     // Catch:{ all -> 0x05a6 }
            if (r7 == 0) goto L_0x04fb
            int r7 = r7.intValue()     // Catch:{ all -> 0x05a6 }
            java.lang.String r7 = java.lang.Integer.toString(r7)     // Catch:{ all -> 0x05a6 }
            r4.add(r7)     // Catch:{ all -> 0x05a6 }
            int r5 = r5 + 1
            goto L_0x0488
        L_0x04a4:
            java.lang.String r0 = ","
            java.lang.String r0 = android.text.TextUtils.join(r0, r4)     // Catch:{ all -> 0x05a6 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x05a6 }
            r4.<init>()     // Catch:{ all -> 0x05a6 }
            java.lang.String r5 = "("
            r4.append(r5)     // Catch:{ all -> 0x05a6 }
            r4.append(r0)     // Catch:{ all -> 0x05a6 }
            java.lang.String r0 = ")"
            r4.append(r0)     // Catch:{ all -> 0x05a6 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x05a6 }
            r0.<init>()     // Catch:{ all -> 0x05a6 }
            java.lang.String r5 = "audience_id in (select audience_id from audience_filter_values where app_id=? and audience_id not in "
            r0.append(r5)     // Catch:{ all -> 0x05a6 }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x05a6 }
            r0.append(r4)     // Catch:{ all -> 0x05a6 }
            java.lang.String r4 = " order by rowid desc limit -1 offset ?)"
            r0.append(r4)     // Catch:{ all -> 0x05a6 }
            r4 = 2
            java.lang.String[] r4 = new java.lang.String[r4]     // Catch:{ all -> 0x05a6 }
            r5 = 0
            r4[r5] = r2     // Catch:{ all -> 0x05a6 }
            java.lang.String r5 = java.lang.Integer.toString(r6)     // Catch:{ all -> 0x05a6 }
            r6 = 1
            r4[r6] = r5     // Catch:{ all -> 0x05a6 }
            java.lang.String r5 = "audience_filter_values"
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x05a6 }
            r3.delete(r5, r0, r4)     // Catch:{ all -> 0x05a6 }
            goto L_0x04fb
        L_0x04e9:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzgi r3 = r7.zzs     // Catch:{ all -> 0x05a6 }
            com.google.android.gms.measurement.internal.zzey r3 = r3.zzaz()     // Catch:{ all -> 0x05a6 }
            com.google.android.gms.measurement.internal.zzew r3 = r3.zzd     // Catch:{ all -> 0x05a6 }
            java.lang.String r4 = "Database error querying filters. appId"
            java.lang.Object r5 = com.google.android.gms.measurement.internal.zzey.zzn(r29)     // Catch:{ all -> 0x05a6 }
            r3.zzc(r4, r5, r0)     // Catch:{ all -> 0x05a6 }
        L_0x04fb:
            r1.setTransactionSuccessful()     // Catch:{ all -> 0x05a6 }
            r1.endTransaction()
            r18.zzc()     // Catch:{ RuntimeException -> 0x0511 }
            com.google.android.gms.internal.measurement.zzkc r0 = r18.zzaE()     // Catch:{ RuntimeException -> 0x0511 }
            com.google.android.gms.internal.measurement.zzfe r0 = (com.google.android.gms.internal.measurement.zzfe) r0     // Catch:{ RuntimeException -> 0x0511 }
            byte[] r0 = r0.zzby()     // Catch:{ RuntimeException -> 0x0511 }
            r3 = r28
            goto L_0x0527
        L_0x0511:
            r0 = move-exception
            r3 = r28
            com.google.android.gms.measurement.internal.zzgi r1 = r3.zzs
            com.google.android.gms.measurement.internal.zzey r1 = r1.zzaz()
            com.google.android.gms.measurement.internal.zzew r1 = r1.zzg
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzey.zzn(r29)
            java.lang.String r5 = "Unable to serialize reduced-size config. Storing full config instead. appId"
            r1.zzc(r5, r4, r0)
            r0 = r30
        L_0x0527:
            com.google.android.gms.measurement.internal.zzli r1 = r3.zzf
            com.google.android.gms.measurement.internal.zzal r1 = r1.zze
            com.google.android.gms.measurement.internal.zzli.zzak(r1)
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r29)
            r1.zzg()
            r1.zzW()
            android.content.ContentValues r4 = new android.content.ContentValues
            r4.<init>()
            java.lang.String r5 = "remote_config"
            r4.put(r5, r0)
            java.lang.String r0 = "config_last_modified_time"
            r5 = r31
            r4.put(r0, r5)
            com.google.android.gms.measurement.internal.zzgi r0 = r1.zzs
            com.google.android.gms.measurement.internal.zzaf r0 = r0.zzk
            com.google.android.gms.measurement.internal.zzek r5 = com.google.android.gms.measurement.internal.zzel.zzaM
            r6 = 0
            boolean r0 = r0.zzs(r6, r5)
            if (r0 == 0) goto L_0x055c
            java.lang.String r0 = "e_tag"
            r5 = r32
            r4.put(r0, r5)
        L_0x055c:
            android.database.sqlite.SQLiteDatabase r0 = r1.zzh()     // Catch:{ SQLiteException -> 0x0587 }
            r5 = 1
            java.lang.String[] r6 = new java.lang.String[r5]     // Catch:{ SQLiteException -> 0x0587 }
            r5 = 0
            r6[r5] = r2     // Catch:{ SQLiteException -> 0x0587 }
            java.lang.String r5 = "apps"
            java.lang.String r7 = "app_id = ?"
            int r0 = r0.update(r5, r4, r7, r6)     // Catch:{ SQLiteException -> 0x0587 }
            long r4 = (long) r0     // Catch:{ SQLiteException -> 0x0587 }
            r6 = 0
            int r0 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r0 != 0) goto L_0x0599
            com.google.android.gms.measurement.internal.zzgi r0 = r1.zzs     // Catch:{ SQLiteException -> 0x0587 }
            com.google.android.gms.measurement.internal.zzey r0 = r0.zzaz()     // Catch:{ SQLiteException -> 0x0587 }
            com.google.android.gms.measurement.internal.zzew r0 = r0.zzd     // Catch:{ SQLiteException -> 0x0587 }
            java.lang.String r4 = "Failed to update remote config (got 0). appId"
            java.lang.Object r5 = com.google.android.gms.measurement.internal.zzey.zzn(r29)     // Catch:{ SQLiteException -> 0x0587 }
            r0.zzb(r4, r5)     // Catch:{ SQLiteException -> 0x0587 }
            goto L_0x0599
        L_0x0587:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzgi r1 = r1.zzs
            com.google.android.gms.measurement.internal.zzey r1 = r1.zzaz()
            com.google.android.gms.measurement.internal.zzew r1 = r1.zzd
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzey.zzn(r29)
            java.lang.String r5 = "Error storing remote config. appId"
            r1.zzc(r5, r4, r0)
        L_0x0599:
            java.util.Map r0 = r3.zzh
            com.google.android.gms.internal.measurement.zzkc r1 = r18.zzaE()
            com.google.android.gms.internal.measurement.zzfe r1 = (com.google.android.gms.internal.measurement.zzfe) r1
            r0.put(r2, r1)
            r1 = 1
            return r1
        L_0x05a6:
            r0 = move-exception
            r3 = r28
            r1.endTransaction()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzfz.zzt(java.lang.String, byte[], java.lang.String, java.lang.String):boolean");
    }

    public final boolean zzu(String str) {
        zzg();
        zzC(str);
        return this.zza.get(str) != null && ((Set) this.zza.get(str)).contains("app_instance_id");
    }

    public final boolean zzv(String str) {
        zzg();
        zzC(str);
        boolean z = true;
        if (this.zza.get(str) != null) {
            if (!((Set) this.zza.get(str)).contains(OneSingnalConstant.TAG_DEVICE_MODEL)) {
                if (((Set) this.zza.get(str)).contains(OneSingnalConstant.TAG_DEVICE_INFO)) {
                    return true;
                }
            }
            return z;
        }
        z = false;
        return z;
    }

    public final boolean zzw(String str) {
        zzg();
        zzC(str);
        return this.zza.get(str) != null && ((Set) this.zza.get(str)).contains("enhanced_user_id");
    }

    public final boolean zzx(String str) {
        zzg();
        zzC(str);
        return this.zza.get(str) != null && ((Set) this.zza.get(str)).contains("google_signals");
    }

    public final boolean zzy(String str) {
        zzg();
        zzC(str);
        boolean z = true;
        if (this.zza.get(str) != null) {
            if (!((Set) this.zza.get(str)).contains("os_version")) {
                if (((Set) this.zza.get(str)).contains(OneSingnalConstant.TAG_DEVICE_INFO)) {
                    return true;
                }
            }
            return z;
        }
        z = false;
        return z;
    }

    public final boolean zzz(String str) {
        zzg();
        zzC(str);
        return this.zza.get(str) != null && ((Set) this.zza.get(str)).contains("user_id");
    }
}
