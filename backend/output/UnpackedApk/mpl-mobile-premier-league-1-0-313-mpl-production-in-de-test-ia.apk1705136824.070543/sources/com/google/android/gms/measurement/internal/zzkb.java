package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.os.Looper;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.stats.ConnectionTracker;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

@VisibleForTesting
/* compiled from: com.google.android.gms:play-services-measurement-impl@@20.1.2 */
public final class zzkb extends zzf {
    public final zzka zza;
    public zzeo zzb;
    public volatile Boolean zzc;
    public final zzao zzd;
    public final zzks zze;
    public final List zzf = new ArrayList();
    public final zzao zzg;

    public zzkb(zzgi zzgi) {
        super(zzgi);
        this.zze = new zzks(zzgi.zzr);
        this.zza = new zzka(this);
        this.zzd = new zzjl(this, zzgi);
        this.zzg = new zzjn(this, zzgi);
    }

    public static void zzo(zzkb zzkb, ComponentName componentName) {
        zzkb.zzg();
        if (zzkb.zzb != null) {
            zzkb.zzb = null;
            zzkb.zzs.zzaz().zzl.zzb("Disconnected from device MeasurementService", componentName);
            zzkb.zzg();
            zzkb.zzr();
        }
    }

    /* JADX WARNING: type inference failed for: r7v0 */
    /* JADX WARNING: type inference failed for: r7v1 */
    /* JADX WARNING: type inference failed for: r17v0, types: [int] */
    /* JADX WARNING: type inference failed for: r7v3, types: [int] */
    /* JADX WARNING: type inference failed for: r17v1 */
    /* JADX WARNING: type inference failed for: r7v4 */
    /* JADX WARNING: type inference failed for: r17v2 */
    /* JADX WARNING: type inference failed for: r17v3 */
    /* JADX WARNING: type inference failed for: r17v4 */
    /* JADX WARNING: type inference failed for: r7v5 */
    /* JADX WARNING: type inference failed for: r17v5 */
    /* JADX WARNING: type inference failed for: r17v6 */
    /* JADX WARNING: type inference failed for: r7v7 */
    /* JADX WARNING: type inference failed for: r17v7 */
    /* JADX WARNING: type inference failed for: r17v8 */
    /* JADX WARNING: type inference failed for: r17v9 */
    /* JADX WARNING: type inference failed for: r17v10 */
    /* JADX WARNING: type inference failed for: r17v11 */
    /* JADX WARNING: type inference failed for: r17v12 */
    /* JADX WARNING: type inference failed for: r17v13 */
    /* JADX WARNING: type inference failed for: r17v14 */
    /* JADX WARNING: type inference failed for: r17v15 */
    /* JADX WARNING: type inference failed for: r17v16 */
    /* JADX WARNING: type inference failed for: r17v17 */
    /* JADX WARNING: type inference failed for: r17v18 */
    /* JADX WARNING: type inference failed for: r17v19 */
    /* JADX WARNING: type inference failed for: r17v20 */
    /* JADX WARNING: type inference failed for: r17v21 */
    /* JADX WARNING: type inference failed for: r17v23 */
    /* JADX WARNING: type inference failed for: r17v24 */
    /* JADX WARNING: type inference failed for: r17v25 */
    /* JADX WARNING: type inference failed for: r17v26, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r17v27 */
    /* JADX WARNING: type inference failed for: r7v21 */
    /* JADX WARNING: type inference failed for: r17v28 */
    /* JADX WARNING: type inference failed for: r17v29 */
    /* JADX WARNING: type inference failed for: r17v30 */
    /* JADX WARNING: type inference failed for: r17v31 */
    /* JADX WARNING: type inference failed for: r17v32 */
    /* JADX WARNING: type inference failed for: r17v33 */
    /* JADX WARNING: type inference failed for: r17v34 */
    /* JADX WARNING: type inference failed for: r17v35 */
    /* JADX WARNING: type inference failed for: r17v36 */
    /* JADX WARNING: type inference failed for: r17v37 */
    /* JADX WARNING: type inference failed for: r17v38 */
    /* JADX WARNING: type inference failed for: r17v39 */
    /* JADX WARNING: type inference failed for: r17v40 */
    /* JADX WARNING: type inference failed for: r17v41 */
    /* JADX WARNING: type inference failed for: r7v27 */
    /* JADX WARNING: type inference failed for: r17v42 */
    /* JADX WARNING: type inference failed for: r17v43 */
    /* JADX WARNING: type inference failed for: r17v44 */
    /* JADX WARNING: type inference failed for: r17v45 */
    /* JADX WARNING: type inference failed for: r17v46 */
    /* JADX WARNING: type inference failed for: r7v34 */
    /* JADX WARNING: type inference failed for: r7v35 */
    /* JADX WARNING: type inference failed for: r17v47 */
    /* JADX WARNING: type inference failed for: r17v48 */
    /* JADX WARNING: type inference failed for: r7v36 */
    /* JADX WARNING: type inference failed for: r7v37 */
    /* JADX WARNING: type inference failed for: r17v49 */
    /* JADX WARNING: type inference failed for: r17v50 */
    /* JADX WARNING: type inference failed for: r17v51 */
    /* JADX WARNING: type inference failed for: r17v52 */
    /* JADX WARNING: type inference failed for: r17v53 */
    /* JADX WARNING: type inference failed for: r17v54 */
    /* JADX WARNING: type inference failed for: r17v55 */
    /* JADX WARNING: type inference failed for: r17v56 */
    /* JADX WARNING: type inference failed for: r17v57 */
    /* JADX WARNING: type inference failed for: r17v58 */
    /* JADX WARNING: type inference failed for: r17v59 */
    /* JADX WARNING: type inference failed for: r17v60 */
    /* JADX WARNING: type inference failed for: r17v61 */
    /* JADX WARNING: type inference failed for: r17v62 */
    /* JADX WARNING: type inference failed for: r17v63 */
    /* JADX WARNING: type inference failed for: r17v64 */
    /* JADX WARNING: type inference failed for: r17v65 */
    /* JADX WARNING: type inference failed for: r17v66 */
    /* JADX WARNING: type inference failed for: r17v67 */
    /* JADX WARNING: type inference failed for: r17v68 */
    /* JADX WARNING: type inference failed for: r17v69 */
    /* JADX WARNING: type inference failed for: r17v70 */
    /* JADX WARNING: type inference failed for: r17v71 */
    /* JADX WARNING: type inference failed for: r17v72 */
    /* JADX WARNING: type inference failed for: r17v73 */
    /* JADX WARNING: type inference failed for: r17v74 */
    /* JADX WARNING: type inference failed for: r17v75 */
    /* JADX WARNING: type inference failed for: r17v76 */
    /* JADX WARNING: type inference failed for: r17v77 */
    /* JADX WARNING: type inference failed for: r17v78 */
    /* JADX WARNING: type inference failed for: r17v79 */
    /* JADX WARNING: type inference failed for: r17v80 */
    /* JADX WARNING: type inference failed for: r17v81 */
    /* JADX WARNING: type inference failed for: r17v82 */
    /* JADX WARNING: type inference failed for: r17v83 */
    /* JADX WARNING: type inference failed for: r17v84 */
    /* JADX WARNING: type inference failed for: r17v85 */
    /* JADX WARNING: type inference failed for: r17v86 */
    /* JADX WARNING: type inference failed for: r17v87 */
    /* JADX WARNING: type inference failed for: r17v88 */
    /* JADX WARNING: type inference failed for: r17v89 */
    /* JADX WARNING: type inference failed for: r17v90 */
    /* JADX WARNING: type inference failed for: r17v91 */
    /* JADX WARNING: type inference failed for: r17v92 */
    /* JADX WARNING: type inference failed for: r17v93 */
    /* JADX WARNING: type inference failed for: r17v94 */
    /* JADX WARNING: type inference failed for: r17v95 */
    /* JADX WARNING: type inference failed for: r17v96 */
    /* JADX WARNING: type inference failed for: r17v97 */
    /* JADX WARNING: type inference failed for: r17v98 */
    /* JADX WARNING: type inference failed for: r17v99 */
    /* JADX WARNING: type inference failed for: r17v100 */
    /* JADX WARNING: type inference failed for: r17v101 */
    /* JADX WARNING: type inference failed for: r17v102 */
    /* JADX WARNING: type inference failed for: r17v103 */
    /* JADX WARNING: type inference failed for: r17v104 */
    /* JADX WARNING: type inference failed for: r17v105 */
    /* JADX WARNING: type inference failed for: r17v106 */
    /* JADX WARNING: type inference failed for: r17v107 */
    /* JADX WARNING: Can't wrap try/catch for region: R(4:70|71|72|73) */
    /* JADX WARNING: Can't wrap try/catch for region: R(4:85|86|87|88) */
    /* JADX WARNING: Can't wrap try/catch for region: R(5:56|57|58|59|235) */
    /* JADX WARNING: Code restructure failed: missing block: B:134:0x0229, code lost:
        r0 = e;
        r17 = r17;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:135:0x022b, code lost:
        r0 = e;
        r17 = r17;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:136:0x022d, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:142:?, code lost:
        r17 = r17;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:235:0x01af, code lost:
        r17 = r17;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x0102, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:?, code lost:
        r9.zzs.zzaz().zzd.zza("Failed to load event from local database");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x0117, code lost:
        r17 = r17;
        r17 = r17;
        r17 = r17;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:?, code lost:
        r14.recycle();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:?, code lost:
        r9.zzs.zzaz().zzd.zza("Failed to load user property from local database");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x014c, code lost:
        r17 = r17;
        r17 = r17;
        r17 = r17;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:?, code lost:
        r7.recycle();
        r0 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:?, code lost:
        r9.zzs.zzaz().zzd.zza("Failed to load conditional user property from local database");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x0183, code lost:
        r17 = r17;
        r17 = r17;
        r17 = r17;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:?, code lost:
        r7.recycle();
        r0 = null;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:56:0x010a */
    /* JADX WARNING: Missing exception handler attribute for start block: B:70:0x013f */
    /* JADX WARNING: Missing exception handler attribute for start block: B:85:0x0176 */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r17v1
      assigns: []
      uses: []
      mth insns count: 406
    	at jadx.core.dex.visitors.typeinference.TypeSearch.fillTypeCandidates(TypeSearch.java:237)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
    	at jadx.core.dex.visitors.typeinference.TypeSearch.run(TypeSearch.java:53)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runMultiVariableSearch(TypeInferenceVisitor.java:104)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:97)
     */
    /* JADX WARNING: Removed duplicated region for block: B:131:0x0225 A[SYNTHETIC, Splitter:B:131:0x0225] */
    /* JADX WARNING: Removed duplicated region for block: B:136:0x022d A[ExcHandler: all (th java.lang.Throwable), Splitter:B:14:0x0059] */
    /* JADX WARNING: Removed duplicated region for block: B:156:0x0256 A[SYNTHETIC, Splitter:B:156:0x0256] */
    /* JADX WARNING: Removed duplicated region for block: B:162:0x026f  */
    /* JADX WARNING: Removed duplicated region for block: B:172:0x0286  */
    /* JADX WARNING: Removed duplicated region for block: B:179:0x02a4  */
    /* JADX WARNING: Removed duplicated region for block: B:186:0x02bd  */
    /* JADX WARNING: Removed duplicated region for block: B:188:0x02c2  */
    /* JADX WARNING: Removed duplicated region for block: B:195:0x02dc  */
    /* JADX WARNING: Removed duplicated region for block: B:196:0x02e5  */
    /* JADX WARNING: Removed duplicated region for block: B:203:0x02f6  */
    /* JADX WARNING: Removed duplicated region for block: B:226:0x0228 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:229:0x02ac A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:230:0x02ac A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:231:0x02ac A[SYNTHETIC] */
    /* JADX WARNING: Unknown variable types count: 29 */
    @com.google.android.gms.common.util.VisibleForTesting
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzD(com.google.android.gms.measurement.internal.zzeo r28, com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable r29, com.google.android.gms.measurement.internal.zzp r30) {
        /*
            r27 = this;
            r1 = r27
            r2 = r28
            r3 = r29
            r4 = r30
            r27.zzg()
            r27.zza()
            r27.zzS()
            com.google.android.gms.measurement.internal.zzgi r0 = r1.zzs
            com.google.android.gms.measurement.internal.zzaf r0 = r0.zzk
            r5 = 100
            r6 = 0
            r0 = 100
            r7 = 0
        L_0x001b:
            r8 = 1001(0x3e9, float:1.403E-42)
            if (r7 >= r8) goto L_0x035f
            if (r0 != r5) goto L_0x035f
            java.util.ArrayList r8 = new java.util.ArrayList
            r8.<init>()
            com.google.android.gms.measurement.internal.zzgi r0 = r1.zzs
            com.google.android.gms.measurement.internal.zzer r9 = r0.zzi()
            java.lang.String r10 = "rowid"
            java.lang.String r11 = "Error reading entries from local database"
            r9.zzg()
            boolean r0 = r9.zzb
            if (r0 == 0) goto L_0x0038
            goto L_0x005b
        L_0x0038:
            java.util.ArrayList r13 = new java.util.ArrayList
            r13.<init>()
            com.google.android.gms.measurement.internal.zzgi r0 = r9.zzs
            android.content.Context r0 = r0.zze
            java.lang.String r14 = "google_app_measurement_local.db"
            java.io.File r0 = r0.getDatabasePath(r14)
            boolean r0 = r0.exists()
            if (r0 == 0) goto L_0x02d7
            r14 = 5
            r12 = 5
            r15 = 0
        L_0x0050:
            if (r15 >= r14) goto L_0x02c6
            r14 = 1
            android.database.sqlite.SQLiteDatabase r5 = r9.zzh()     // Catch:{ SQLiteFullException -> 0x028c, SQLiteDatabaseLockedException -> 0x0276, SQLiteException -> 0x024c, all -> 0x0247 }
            if (r5 != 0) goto L_0x005f
            r9.zzb = r14     // Catch:{ SQLiteFullException -> 0x023e, SQLiteDatabaseLockedException -> 0x0236, SQLiteException -> 0x022f, all -> 0x022d }
        L_0x005b:
            r17 = r7
            goto L_0x02d5
        L_0x005f:
            r5.beginTransaction()     // Catch:{ SQLiteFullException -> 0x023e, SQLiteDatabaseLockedException -> 0x0236, SQLiteException -> 0x022f, all -> 0x022d }
            java.lang.String r0 = "3"
            java.lang.String r17 = "messages"
            java.lang.String[] r18 = new java.lang.String[]{r10}     // Catch:{ all -> 0x021c }
            java.lang.String r19 = "type=?"
            java.lang.String[] r20 = new java.lang.String[]{r0}     // Catch:{ all -> 0x021c }
            r21 = 0
            r22 = 0
            java.lang.String r23 = "rowid desc"
            java.lang.String r24 = "1"
            r16 = r5
            android.database.Cursor r14 = r16.query(r17, r18, r19, r20, r21, r22, r23, r24)     // Catch:{ all -> 0x021c }
            boolean r0 = r14.moveToFirst()     // Catch:{ all -> 0x0215 }
            r25 = -1
            if (r0 == 0) goto L_0x008e
            long r16 = r14.getLong(r6)     // Catch:{ all -> 0x0215 }
            r14.close()     // Catch:{ SQLiteFullException -> 0x023e, SQLiteDatabaseLockedException -> 0x0236, SQLiteException -> 0x022f, all -> 0x022d }
            goto L_0x0093
        L_0x008e:
            r14.close()     // Catch:{ SQLiteFullException -> 0x023e, SQLiteDatabaseLockedException -> 0x0236, SQLiteException -> 0x022f, all -> 0x022d }
            r16 = r25
        L_0x0093:
            int r0 = (r16 > r25 ? 1 : (r16 == r25 ? 0 : -1))
            if (r0 == 0) goto L_0x00a9
            java.lang.String r0 = "rowid<?"
            r14 = 1
            java.lang.String[] r6 = new java.lang.String[r14]     // Catch:{ SQLiteFullException -> 0x023e, SQLiteDatabaseLockedException -> 0x0236, SQLiteException -> 0x022f, all -> 0x022d }
            java.lang.String r14 = java.lang.String.valueOf(r16)     // Catch:{ SQLiteFullException -> 0x023e, SQLiteDatabaseLockedException -> 0x0236, SQLiteException -> 0x022f, all -> 0x022d }
            r16 = 0
            r6[r16] = r14     // Catch:{ SQLiteFullException -> 0x023e, SQLiteDatabaseLockedException -> 0x0236, SQLiteException -> 0x022f, all -> 0x022d }
            r19 = r0
            r20 = r6
            goto L_0x00ad
        L_0x00a9:
            r19 = 0
            r20 = 0
        L_0x00ad:
            java.lang.String r0 = "type"
            java.lang.String r6 = "entry"
            java.lang.String[] r18 = new java.lang.String[]{r10, r0, r6}     // Catch:{ SQLiteFullException -> 0x023e, SQLiteDatabaseLockedException -> 0x0236, SQLiteException -> 0x022f, all -> 0x022d }
            java.lang.String r17 = "messages"
            r21 = 0
            r22 = 0
            java.lang.String r23 = "rowid asc"
            r6 = 100
            java.lang.String r24 = java.lang.Integer.toString(r6)     // Catch:{ SQLiteFullException -> 0x023e, SQLiteDatabaseLockedException -> 0x0236, SQLiteException -> 0x022f, all -> 0x022d }
            r16 = r5
            android.database.Cursor r6 = r16.query(r17, r18, r19, r20, r21, r22, r23, r24)     // Catch:{ SQLiteFullException -> 0x023e, SQLiteDatabaseLockedException -> 0x0236, SQLiteException -> 0x022f, all -> 0x022d }
        L_0x00c9:
            boolean r0 = r6.moveToNext()     // Catch:{ SQLiteFullException -> 0x020f, SQLiteDatabaseLockedException -> 0x0209, SQLiteException -> 0x0203 }
            if (r0 == 0) goto L_0x01c0
            r14 = 0
            long r25 = r6.getLong(r14)     // Catch:{ SQLiteFullException -> 0x020f, SQLiteDatabaseLockedException -> 0x0209, SQLiteException -> 0x0203 }
            r14 = 1
            int r0 = r6.getInt(r14)     // Catch:{ SQLiteFullException -> 0x020f, SQLiteDatabaseLockedException -> 0x0209, SQLiteException -> 0x0203 }
            r14 = 2
            r16 = r10
            byte[] r10 = r6.getBlob(r14)     // Catch:{ SQLiteFullException -> 0x01bc, SQLiteDatabaseLockedException -> 0x01b9, SQLiteException -> 0x01b5 }
            if (r0 != 0) goto L_0x0120
            android.os.Parcel r14 = android.os.Parcel.obtain()     // Catch:{ SQLiteFullException -> 0x01bc, SQLiteDatabaseLockedException -> 0x01b9, SQLiteException -> 0x01b5 }
            int r0 = r10.length     // Catch:{ ParseException -> 0x0108, all -> 0x0104 }
            r17 = r7
            r7 = 0
            r14.unmarshall(r10, r7, r0)     // Catch:{ ParseException -> 0x010a }
            r14.setDataPosition(r7)     // Catch:{ ParseException -> 0x010a }
            android.os.Parcelable$Creator<com.google.android.gms.measurement.internal.zzav> r0 = com.google.android.gms.measurement.internal.zzav.CREATOR     // Catch:{ ParseException -> 0x010a }
            java.lang.Object r0 = r0.createFromParcel(r14)     // Catch:{ ParseException -> 0x010a }
            com.google.android.gms.measurement.internal.zzav r0 = (com.google.android.gms.measurement.internal.zzav) r0     // Catch:{ ParseException -> 0x010a }
            r14.recycle()     // Catch:{ SQLiteFullException -> 0x0200, SQLiteDatabaseLockedException -> 0x020d, SQLiteException -> 0x01fc }
            if (r0 == 0) goto L_0x01af
            r13.add(r0)     // Catch:{ SQLiteFullException -> 0x0200, SQLiteDatabaseLockedException -> 0x020d, SQLiteException -> 0x01fc }
            goto L_0x01af
        L_0x0102:
            r0 = move-exception
            goto L_0x011c
        L_0x0104:
            r0 = move-exception
            r17 = r7
            goto L_0x011c
        L_0x0108:
            r17 = r7
        L_0x010a:
            com.google.android.gms.measurement.internal.zzgi r0 = r9.zzs     // Catch:{ all -> 0x0102 }
            com.google.android.gms.measurement.internal.zzey r0 = r0.zzaz()     // Catch:{ all -> 0x0102 }
            com.google.android.gms.measurement.internal.zzew r0 = r0.zzd     // Catch:{ all -> 0x0102 }
            java.lang.String r7 = "Failed to load event from local database"
            r0.zza(r7)     // Catch:{ all -> 0x0102 }
            r14.recycle()     // Catch:{ SQLiteFullException -> 0x0200, SQLiteDatabaseLockedException -> 0x020d, SQLiteException -> 0x01fc }
            goto L_0x01af
        L_0x011c:
            r14.recycle()     // Catch:{ SQLiteFullException -> 0x0200, SQLiteDatabaseLockedException -> 0x020d, SQLiteException -> 0x01fc }
            throw r0     // Catch:{ SQLiteFullException -> 0x0200, SQLiteDatabaseLockedException -> 0x020d, SQLiteException -> 0x01fc }
        L_0x0120:
            r17 = r7
            r7 = 1
            if (r0 != r7) goto L_0x015a
            android.os.Parcel r7 = android.os.Parcel.obtain()     // Catch:{ SQLiteFullException -> 0x0200, SQLiteDatabaseLockedException -> 0x020d, SQLiteException -> 0x01fc }
            int r0 = r10.length     // Catch:{ ParseException -> 0x013f }
            r14 = 0
            r7.unmarshall(r10, r14, r0)     // Catch:{ ParseException -> 0x013f }
            r7.setDataPosition(r14)     // Catch:{ ParseException -> 0x013f }
            android.os.Parcelable$Creator<com.google.android.gms.measurement.internal.zzll> r0 = com.google.android.gms.measurement.internal.zzll.CREATOR     // Catch:{ ParseException -> 0x013f }
            java.lang.Object r0 = r0.createFromParcel(r7)     // Catch:{ ParseException -> 0x013f }
            com.google.android.gms.measurement.internal.zzll r0 = (com.google.android.gms.measurement.internal.zzll) r0     // Catch:{ ParseException -> 0x013f }
            r7.recycle()     // Catch:{ SQLiteFullException -> 0x0200, SQLiteDatabaseLockedException -> 0x020d, SQLiteException -> 0x01fc }
            goto L_0x0150
        L_0x013d:
            r0 = move-exception
            goto L_0x0156
        L_0x013f:
            com.google.android.gms.measurement.internal.zzgi r0 = r9.zzs     // Catch:{ all -> 0x013d }
            com.google.android.gms.measurement.internal.zzey r0 = r0.zzaz()     // Catch:{ all -> 0x013d }
            com.google.android.gms.measurement.internal.zzew r0 = r0.zzd     // Catch:{ all -> 0x013d }
            java.lang.String r10 = "Failed to load user property from local database"
            r0.zza(r10)     // Catch:{ all -> 0x013d }
            r7.recycle()     // Catch:{ SQLiteFullException -> 0x0200, SQLiteDatabaseLockedException -> 0x020d, SQLiteException -> 0x01fc }
            r0 = 0
        L_0x0150:
            if (r0 == 0) goto L_0x01af
            r13.add(r0)     // Catch:{ SQLiteFullException -> 0x0200, SQLiteDatabaseLockedException -> 0x020d, SQLiteException -> 0x01fc }
            goto L_0x01af
        L_0x0156:
            r7.recycle()     // Catch:{ SQLiteFullException -> 0x0200, SQLiteDatabaseLockedException -> 0x020d, SQLiteException -> 0x01fc }
            throw r0     // Catch:{ SQLiteFullException -> 0x0200, SQLiteDatabaseLockedException -> 0x020d, SQLiteException -> 0x01fc }
        L_0x015a:
            if (r0 != r14) goto L_0x0191
            android.os.Parcel r7 = android.os.Parcel.obtain()     // Catch:{ SQLiteFullException -> 0x0200, SQLiteDatabaseLockedException -> 0x020d, SQLiteException -> 0x01fc }
            int r0 = r10.length     // Catch:{ ParseException -> 0x0176 }
            r14 = 0
            r7.unmarshall(r10, r14, r0)     // Catch:{ ParseException -> 0x0176 }
            r7.setDataPosition(r14)     // Catch:{ ParseException -> 0x0176 }
            android.os.Parcelable$Creator<com.google.android.gms.measurement.internal.zzab> r0 = com.google.android.gms.measurement.internal.zzab.CREATOR     // Catch:{ ParseException -> 0x0176 }
            java.lang.Object r0 = r0.createFromParcel(r7)     // Catch:{ ParseException -> 0x0176 }
            com.google.android.gms.measurement.internal.zzab r0 = (com.google.android.gms.measurement.internal.zzab) r0     // Catch:{ ParseException -> 0x0176 }
            r7.recycle()     // Catch:{ SQLiteFullException -> 0x0200, SQLiteDatabaseLockedException -> 0x020d, SQLiteException -> 0x01fc }
            goto L_0x0187
        L_0x0174:
            r0 = move-exception
            goto L_0x018d
        L_0x0176:
            com.google.android.gms.measurement.internal.zzgi r0 = r9.zzs     // Catch:{ all -> 0x0174 }
            com.google.android.gms.measurement.internal.zzey r0 = r0.zzaz()     // Catch:{ all -> 0x0174 }
            com.google.android.gms.measurement.internal.zzew r0 = r0.zzd     // Catch:{ all -> 0x0174 }
            java.lang.String r10 = "Failed to load conditional user property from local database"
            r0.zza(r10)     // Catch:{ all -> 0x0174 }
            r7.recycle()     // Catch:{ SQLiteFullException -> 0x0200, SQLiteDatabaseLockedException -> 0x020d, SQLiteException -> 0x01fc }
            r0 = 0
        L_0x0187:
            if (r0 == 0) goto L_0x01af
            r13.add(r0)     // Catch:{ SQLiteFullException -> 0x0200, SQLiteDatabaseLockedException -> 0x020d, SQLiteException -> 0x01fc }
            goto L_0x01af
        L_0x018d:
            r7.recycle()     // Catch:{ SQLiteFullException -> 0x0200, SQLiteDatabaseLockedException -> 0x020d, SQLiteException -> 0x01fc }
            throw r0     // Catch:{ SQLiteFullException -> 0x0200, SQLiteDatabaseLockedException -> 0x020d, SQLiteException -> 0x01fc }
        L_0x0191:
            r7 = 3
            if (r0 != r7) goto L_0x01a2
            com.google.android.gms.measurement.internal.zzgi r0 = r9.zzs     // Catch:{ SQLiteFullException -> 0x0200, SQLiteDatabaseLockedException -> 0x020d, SQLiteException -> 0x01fc }
            com.google.android.gms.measurement.internal.zzey r0 = r0.zzaz()     // Catch:{ SQLiteFullException -> 0x0200, SQLiteDatabaseLockedException -> 0x020d, SQLiteException -> 0x01fc }
            com.google.android.gms.measurement.internal.zzew r0 = r0.zzg     // Catch:{ SQLiteFullException -> 0x0200, SQLiteDatabaseLockedException -> 0x020d, SQLiteException -> 0x01fc }
            java.lang.String r7 = "Skipping app launch break"
            r0.zza(r7)     // Catch:{ SQLiteFullException -> 0x0200, SQLiteDatabaseLockedException -> 0x020d, SQLiteException -> 0x01fc }
            goto L_0x01af
        L_0x01a2:
            com.google.android.gms.measurement.internal.zzgi r0 = r9.zzs     // Catch:{ SQLiteFullException -> 0x0200, SQLiteDatabaseLockedException -> 0x020d, SQLiteException -> 0x01fc }
            com.google.android.gms.measurement.internal.zzey r0 = r0.zzaz()     // Catch:{ SQLiteFullException -> 0x0200, SQLiteDatabaseLockedException -> 0x020d, SQLiteException -> 0x01fc }
            com.google.android.gms.measurement.internal.zzew r0 = r0.zzd     // Catch:{ SQLiteFullException -> 0x0200, SQLiteDatabaseLockedException -> 0x020d, SQLiteException -> 0x01fc }
            java.lang.String r7 = "Unknown record type in local database"
            r0.zza(r7)     // Catch:{ SQLiteFullException -> 0x0200, SQLiteDatabaseLockedException -> 0x020d, SQLiteException -> 0x01fc }
        L_0x01af:
            r10 = r16
            r7 = r17
            goto L_0x00c9
        L_0x01b5:
            r0 = move-exception
            r17 = r7
            goto L_0x01fd
        L_0x01b9:
            r17 = r7
            goto L_0x020d
        L_0x01bc:
            r0 = move-exception
            r17 = r7
            goto L_0x0201
        L_0x01c0:
            r17 = r7
            r16 = r10
            r7 = 1
            java.lang.String[] r0 = new java.lang.String[r7]     // Catch:{ SQLiteFullException -> 0x0200, SQLiteDatabaseLockedException -> 0x020d, SQLiteException -> 0x01fc }
            java.lang.String r7 = java.lang.Long.toString(r25)     // Catch:{ SQLiteFullException -> 0x0200, SQLiteDatabaseLockedException -> 0x020d, SQLiteException -> 0x01fc }
            r10 = 0
            r0[r10] = r7     // Catch:{ SQLiteFullException -> 0x01fa, SQLiteDatabaseLockedException -> 0x023c, SQLiteException -> 0x01f7 }
            java.lang.String r7 = "messages"
            java.lang.String r14 = "rowid <= ?"
            int r0 = r5.delete(r7, r14, r0)     // Catch:{ SQLiteFullException -> 0x01fa, SQLiteDatabaseLockedException -> 0x023c, SQLiteException -> 0x01f7 }
            int r7 = r13.size()     // Catch:{ SQLiteFullException -> 0x01fa, SQLiteDatabaseLockedException -> 0x023c, SQLiteException -> 0x01f7 }
            if (r0 >= r7) goto L_0x01e9
            com.google.android.gms.measurement.internal.zzgi r0 = r9.zzs     // Catch:{ SQLiteFullException -> 0x01fa, SQLiteDatabaseLockedException -> 0x023c, SQLiteException -> 0x01f7 }
            com.google.android.gms.measurement.internal.zzey r0 = r0.zzaz()     // Catch:{ SQLiteFullException -> 0x01fa, SQLiteDatabaseLockedException -> 0x023c, SQLiteException -> 0x01f7 }
            com.google.android.gms.measurement.internal.zzew r0 = r0.zzd     // Catch:{ SQLiteFullException -> 0x01fa, SQLiteDatabaseLockedException -> 0x023c, SQLiteException -> 0x01f7 }
            java.lang.String r7 = "Fewer entries removed from local database than expected"
            r0.zza(r7)     // Catch:{ SQLiteFullException -> 0x01fa, SQLiteDatabaseLockedException -> 0x023c, SQLiteException -> 0x01f7 }
        L_0x01e9:
            r5.setTransactionSuccessful()     // Catch:{ SQLiteFullException -> 0x01fa, SQLiteDatabaseLockedException -> 0x023c, SQLiteException -> 0x01f7 }
            r5.endTransaction()     // Catch:{ SQLiteFullException -> 0x01fa, SQLiteDatabaseLockedException -> 0x023c, SQLiteException -> 0x01f7 }
            r6.close()
            r5.close()
            goto L_0x02d9
        L_0x01f7:
            r0 = move-exception
            goto L_0x0254
        L_0x01fa:
            r0 = move-exception
            goto L_0x0245
        L_0x01fc:
            r0 = move-exception
        L_0x01fd:
            r10 = 0
            goto L_0x0254
        L_0x0200:
            r0 = move-exception
        L_0x0201:
            r10 = 0
            goto L_0x0245
        L_0x0203:
            r0 = move-exception
            r17 = r7
            r16 = r10
            goto L_0x01fd
        L_0x0209:
            r17 = r7
            r16 = r10
        L_0x020d:
            r10 = 0
            goto L_0x023c
        L_0x020f:
            r0 = move-exception
            r17 = r7
            r16 = r10
            goto L_0x0201
        L_0x0215:
            r0 = move-exception
            r17 = r7
            r16 = r10
            r10 = 0
            goto L_0x0223
        L_0x021c:
            r0 = move-exception
            r17 = r7
            r16 = r10
            r10 = 0
            r14 = 0
        L_0x0223:
            if (r14 == 0) goto L_0x0228
            r14.close()     // Catch:{ SQLiteFullException -> 0x022b, SQLiteDatabaseLockedException -> 0x023b, SQLiteException -> 0x0229, all -> 0x022d }
        L_0x0228:
            throw r0     // Catch:{ SQLiteFullException -> 0x022b, SQLiteDatabaseLockedException -> 0x023b, SQLiteException -> 0x0229, all -> 0x022d }
        L_0x0229:
            r0 = move-exception
            goto L_0x0253
        L_0x022b:
            r0 = move-exception
            goto L_0x0244
        L_0x022d:
            r0 = move-exception
            goto L_0x0249
        L_0x022f:
            r0 = move-exception
            r17 = r7
            r16 = r10
            r10 = 0
            goto L_0x0253
        L_0x0236:
            r17 = r7
            r16 = r10
            r10 = 0
        L_0x023b:
            r6 = 0
        L_0x023c:
            r7 = r11
            goto L_0x027e
        L_0x023e:
            r0 = move-exception
            r17 = r7
            r16 = r10
            r10 = 0
        L_0x0244:
            r6 = 0
        L_0x0245:
            r7 = r11
            goto L_0x0294
        L_0x0247:
            r0 = move-exception
            r5 = 0
        L_0x0249:
            r12 = 0
            goto L_0x02bb
        L_0x024c:
            r0 = move-exception
            r17 = r7
            r16 = r10
            r10 = 0
            r5 = 0
        L_0x0253:
            r6 = 0
        L_0x0254:
            if (r5 == 0) goto L_0x025f
            boolean r7 = r5.inTransaction()     // Catch:{ all -> 0x02b9 }
            if (r7 == 0) goto L_0x025f
            r5.endTransaction()     // Catch:{ all -> 0x02b9 }
        L_0x025f:
            com.google.android.gms.measurement.internal.zzgi r7 = r9.zzs     // Catch:{ all -> 0x02b9 }
            com.google.android.gms.measurement.internal.zzey r7 = r7.zzaz()     // Catch:{ all -> 0x02b9 }
            com.google.android.gms.measurement.internal.zzew r7 = r7.zzd     // Catch:{ all -> 0x02b9 }
            r7.zzb(r11, r0)     // Catch:{ all -> 0x02b9 }
            r7 = 1
            r9.zzb = r7     // Catch:{ all -> 0x02b9 }
            if (r6 == 0) goto L_0x0272
            r6.close()
        L_0x0272:
            r7 = r11
            if (r5 == 0) goto L_0x02ac
            goto L_0x02a9
        L_0x0276:
            r17 = r7
            r16 = r10
            r10 = 0
            r7 = r11
            r5 = 0
            r6 = 0
        L_0x027e:
            long r10 = (long) r12
            android.os.SystemClock.sleep(r10)     // Catch:{ all -> 0x02b9 }
            int r12 = r12 + 20
            if (r6 == 0) goto L_0x0289
            r6.close()
        L_0x0289:
            if (r5 == 0) goto L_0x02ac
            goto L_0x02a9
        L_0x028c:
            r0 = move-exception
            r17 = r7
            r16 = r10
            r7 = r11
            r5 = 0
            r6 = 0
        L_0x0294:
            com.google.android.gms.measurement.internal.zzgi r10 = r9.zzs     // Catch:{ all -> 0x02b9 }
            com.google.android.gms.measurement.internal.zzey r10 = r10.zzaz()     // Catch:{ all -> 0x02b9 }
            com.google.android.gms.measurement.internal.zzew r10 = r10.zzd     // Catch:{ all -> 0x02b9 }
            r10.zzb(r7, r0)     // Catch:{ all -> 0x02b9 }
            r10 = 1
            r9.zzb = r10     // Catch:{ all -> 0x02b9 }
            if (r6 == 0) goto L_0x02a7
            r6.close()
        L_0x02a7:
            if (r5 == 0) goto L_0x02ac
        L_0x02a9:
            r5.close()
        L_0x02ac:
            int r15 = r15 + 1
            r11 = r7
            r10 = r16
            r7 = r17
            r5 = 100
            r6 = 0
            r14 = 5
            goto L_0x0050
        L_0x02b9:
            r0 = move-exception
            r12 = r6
        L_0x02bb:
            if (r12 == 0) goto L_0x02c0
            r12.close()
        L_0x02c0:
            if (r5 == 0) goto L_0x02c5
            r5.close()
        L_0x02c5:
            throw r0
        L_0x02c6:
            r17 = r7
            com.google.android.gms.measurement.internal.zzgi r0 = r9.zzs
            com.google.android.gms.measurement.internal.zzey r0 = r0.zzaz()
            com.google.android.gms.measurement.internal.zzew r0 = r0.zzg
            java.lang.String r5 = "Failed to read events from database in reasonable time"
            r0.zza(r5)
        L_0x02d5:
            r12 = 0
            goto L_0x02da
        L_0x02d7:
            r17 = r7
        L_0x02d9:
            r12 = r13
        L_0x02da:
            if (r12 == 0) goto L_0x02e5
            r8.addAll(r12)
            int r0 = r12.size()
            r5 = r0
            goto L_0x02e6
        L_0x02e5:
            r5 = 0
        L_0x02e6:
            r6 = 100
            if (r3 == 0) goto L_0x02ef
            if (r5 >= r6) goto L_0x02ef
            r8.add(r3)
        L_0x02ef:
            int r7 = r8.size()
            r9 = 0
        L_0x02f4:
            if (r9 >= r7) goto L_0x0357
            java.lang.Object r0 = r8.get(r9)
            com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable r0 = (com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable) r0
            boolean r10 = r0 instanceof com.google.android.gms.measurement.internal.zzav
            if (r10 == 0) goto L_0x0315
            com.google.android.gms.measurement.internal.zzav r0 = (com.google.android.gms.measurement.internal.zzav) r0     // Catch:{ RemoteException -> 0x0306 }
            r2.zzk(r0, r4)     // Catch:{ RemoteException -> 0x0306 }
            goto L_0x0354
        L_0x0306:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzgi r10 = r1.zzs
            com.google.android.gms.measurement.internal.zzey r10 = r10.zzaz()
            com.google.android.gms.measurement.internal.zzew r10 = r10.zzd
            java.lang.String r11 = "Failed to send event to the service"
            r10.zzb(r11, r0)
            goto L_0x0354
        L_0x0315:
            boolean r10 = r0 instanceof com.google.android.gms.measurement.internal.zzll
            if (r10 == 0) goto L_0x032e
            com.google.android.gms.measurement.internal.zzll r0 = (com.google.android.gms.measurement.internal.zzll) r0     // Catch:{ RemoteException -> 0x031f }
            r2.zzt(r0, r4)     // Catch:{ RemoteException -> 0x031f }
            goto L_0x0354
        L_0x031f:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzgi r10 = r1.zzs
            com.google.android.gms.measurement.internal.zzey r10 = r10.zzaz()
            com.google.android.gms.measurement.internal.zzew r10 = r10.zzd
            java.lang.String r11 = "Failed to send user property to the service"
            r10.zzb(r11, r0)
            goto L_0x0354
        L_0x032e:
            boolean r10 = r0 instanceof com.google.android.gms.measurement.internal.zzab
            if (r10 == 0) goto L_0x0347
            com.google.android.gms.measurement.internal.zzab r0 = (com.google.android.gms.measurement.internal.zzab) r0     // Catch:{ RemoteException -> 0x0338 }
            r2.zzn(r0, r4)     // Catch:{ RemoteException -> 0x0338 }
            goto L_0x0354
        L_0x0338:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzgi r10 = r1.zzs
            com.google.android.gms.measurement.internal.zzey r10 = r10.zzaz()
            com.google.android.gms.measurement.internal.zzew r10 = r10.zzd
            java.lang.String r11 = "Failed to send conditional user property to the service"
            r10.zzb(r11, r0)
            goto L_0x0354
        L_0x0347:
            com.google.android.gms.measurement.internal.zzgi r0 = r1.zzs
            com.google.android.gms.measurement.internal.zzey r0 = r0.zzaz()
            com.google.android.gms.measurement.internal.zzew r0 = r0.zzd
            java.lang.String r10 = "Discarding data. Unrecognized parcel type."
            r0.zza(r10)
        L_0x0354:
            int r9 = r9 + 1
            goto L_0x02f4
        L_0x0357:
            int r7 = r17 + 1
            r0 = r5
            r5 = 100
            r6 = 0
            goto L_0x001b
        L_0x035f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzkb.zzD(com.google.android.gms.measurement.internal.zzeo, com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable, com.google.android.gms.measurement.internal.zzp):void");
    }

    public final void zzE(zzab zzab) {
        boolean z;
        Preconditions.checkNotNull(zzab);
        zzg();
        zza();
        zzgi zzgi = this.zzs;
        zzaa zzaa = zzgi.zzj;
        zzer zzi = zzgi.zzi();
        byte[] zzao = zzi.zzs.zzv().zzao(zzab);
        if (zzao.length > 131072) {
            zzi.zzs.zzaz().zze.zza("Conditional user property too long for local database. Sending directly to service");
            z = false;
        } else {
            z = zzi.zzq(2, zzao);
        }
        zzjr zzjr = new zzjr(this, zzO(true), z, new zzab(zzab), zzab);
        zzR(zzjr);
    }

    public final boolean zzL() {
        zzg();
        zza();
        return this.zzb != null;
    }

    public final boolean zzM() {
        zzg();
        zza();
        if (!zzN() || this.zzs.zzv().zzm() >= ((Integer) zzel.zzai.zza(null)).intValue()) {
            return true;
        }
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00de, code lost:
        if (r0 == null) goto L_0x00e0;
     */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x011b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zzN() {
        /*
            r7 = this;
            r7.zzg()
            r7.zza()
            java.lang.Boolean r0 = r7.zzc
            if (r0 != 0) goto L_0x013b
            r7.zzg()
            r7.zza()
            com.google.android.gms.measurement.internal.zzgi r0 = r7.zzs
            com.google.android.gms.measurement.internal.zzfn r0 = r0.zzm()
            r0.zzg()
            android.content.SharedPreferences r1 = r0.zza()
            java.lang.String r2 = "use_service"
            boolean r1 = r1.contains(r2)
            r3 = 0
            r4 = 0
            if (r1 != 0) goto L_0x0029
            r0 = r3
            goto L_0x0035
        L_0x0029:
            android.content.SharedPreferences r0 = r0.zza()
            boolean r0 = r0.getBoolean(r2, r4)
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
        L_0x0035:
            r1 = 1
            if (r0 == 0) goto L_0x0040
            boolean r5 = r0.booleanValue()
            if (r5 == 0) goto L_0x0040
            goto L_0x0133
        L_0x0040:
            com.google.android.gms.measurement.internal.zzgi r5 = r7.zzs
            com.google.android.gms.measurement.internal.zzaa r6 = r5.zzj
            com.google.android.gms.measurement.internal.zzep r5 = r5.zzh()
            r5.zza()
            int r5 = r5.zzj
            if (r5 != r1) goto L_0x0051
            goto L_0x00fe
        L_0x0051:
            com.google.android.gms.measurement.internal.zzgi r5 = r7.zzs
            com.google.android.gms.measurement.internal.zzey r5 = r5.zzaz()
            com.google.android.gms.measurement.internal.zzew r5 = r5.zzl
            java.lang.String r6 = "Checking service availability"
            r5.zza(r6)
            com.google.android.gms.measurement.internal.zzgi r5 = r7.zzs
            com.google.android.gms.measurement.internal.zzlp r5 = r5.zzv()
            if (r5 == 0) goto L_0x013a
            com.google.android.gms.common.GoogleApiAvailabilityLight r3 = com.google.android.gms.common.GoogleApiAvailabilityLight.zza
            com.google.android.gms.measurement.internal.zzgi r5 = r5.zzs
            android.content.Context r5 = r5.zze
            r6 = 12451000(0xbdfcb8, float:1.7447567E-38)
            int r3 = r3.isGooglePlayServicesAvailable(r5, r6)
            if (r3 == 0) goto L_0x00f1
            if (r3 == r1) goto L_0x00e3
            r5 = 2
            if (r3 == r5) goto L_0x00c2
            r0 = 3
            if (r3 == r0) goto L_0x00b3
            r0 = 9
            if (r3 == r0) goto L_0x00a5
            r0 = 18
            if (r3 == r0) goto L_0x0097
            com.google.android.gms.measurement.internal.zzgi r0 = r7.zzs
            com.google.android.gms.measurement.internal.zzey r0 = r0.zzaz()
            com.google.android.gms.measurement.internal.zzew r0 = r0.zzg
            java.lang.Integer r1 = java.lang.Integer.valueOf(r3)
            java.lang.String r3 = "Unexpected service status"
            r0.zzb(r3, r1)
            goto L_0x00c0
        L_0x0097:
            com.google.android.gms.measurement.internal.zzgi r0 = r7.zzs
            com.google.android.gms.measurement.internal.zzey r0 = r0.zzaz()
            com.google.android.gms.measurement.internal.zzew r0 = r0.zzg
            java.lang.String r3 = "Service updating"
            r0.zza(r3)
            goto L_0x00fe
        L_0x00a5:
            com.google.android.gms.measurement.internal.zzgi r0 = r7.zzs
            com.google.android.gms.measurement.internal.zzey r0 = r0.zzaz()
            com.google.android.gms.measurement.internal.zzew r0 = r0.zzg
            java.lang.String r1 = "Service invalid"
            r0.zza(r1)
            goto L_0x00c0
        L_0x00b3:
            com.google.android.gms.measurement.internal.zzgi r0 = r7.zzs
            com.google.android.gms.measurement.internal.zzey r0 = r0.zzaz()
            com.google.android.gms.measurement.internal.zzew r0 = r0.zzg
            java.lang.String r1 = "Service disabled"
            r0.zza(r1)
        L_0x00c0:
            r1 = 0
            goto L_0x00e0
        L_0x00c2:
            com.google.android.gms.measurement.internal.zzgi r3 = r7.zzs
            com.google.android.gms.measurement.internal.zzey r3 = r3.zzaz()
            com.google.android.gms.measurement.internal.zzew r3 = r3.zzk
            java.lang.String r5 = "Service container out of date"
            r3.zza(r5)
            com.google.android.gms.measurement.internal.zzgi r3 = r7.zzs
            com.google.android.gms.measurement.internal.zzlp r3 = r3.zzv()
            int r3 = r3.zzm()
            r5 = 17443(0x4423, float:2.4443E-41)
            if (r3 >= r5) goto L_0x00de
            goto L_0x00ff
        L_0x00de:
            if (r0 != 0) goto L_0x00c0
        L_0x00e0:
            r4 = r1
            r1 = 0
            goto L_0x00ff
        L_0x00e3:
            com.google.android.gms.measurement.internal.zzgi r0 = r7.zzs
            com.google.android.gms.measurement.internal.zzey r0 = r0.zzaz()
            com.google.android.gms.measurement.internal.zzew r0 = r0.zzl
            java.lang.String r3 = "Service missing"
            r0.zza(r3)
            goto L_0x00ff
        L_0x00f1:
            com.google.android.gms.measurement.internal.zzgi r0 = r7.zzs
            com.google.android.gms.measurement.internal.zzey r0 = r0.zzaz()
            com.google.android.gms.measurement.internal.zzew r0 = r0.zzl
            java.lang.String r3 = "Service available"
            r0.zza(r3)
        L_0x00fe:
            r4 = 1
        L_0x00ff:
            if (r4 != 0) goto L_0x0119
            com.google.android.gms.measurement.internal.zzgi r0 = r7.zzs
            com.google.android.gms.measurement.internal.zzaf r0 = r0.zzk
            boolean r0 = r0.zzx()
            if (r0 == 0) goto L_0x0119
            com.google.android.gms.measurement.internal.zzgi r0 = r7.zzs
            com.google.android.gms.measurement.internal.zzey r0 = r0.zzaz()
            com.google.android.gms.measurement.internal.zzew r0 = r0.zzd
            java.lang.String r1 = "No way to upload. Consider using the full version of Analytics"
            r0.zza(r1)
            goto L_0x0132
        L_0x0119:
            if (r1 == 0) goto L_0x0132
            com.google.android.gms.measurement.internal.zzgi r0 = r7.zzs
            com.google.android.gms.measurement.internal.zzfn r0 = r0.zzm()
            r0.zzg()
            android.content.SharedPreferences r0 = r0.zza()
            android.content.SharedPreferences$Editor r0 = r0.edit()
            r0.putBoolean(r2, r4)
            r0.apply()
        L_0x0132:
            r1 = r4
        L_0x0133:
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r1)
            r7.zzc = r0
            goto L_0x013b
        L_0x013a:
            throw r3
        L_0x013b:
            java.lang.Boolean r0 = r7.zzc
            boolean r0 = r0.booleanValue()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzkb.zzN():boolean");
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x00e8  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0170  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x018e  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x021b  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x021e  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x0258  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x025a  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x027c  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x02ae  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x02e7  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.measurement.internal.zzp zzO(boolean r38) {
        /*
            r37 = this;
            r1 = r37
            com.google.android.gms.measurement.internal.zzgi r0 = r1.zzs
            com.google.android.gms.measurement.internal.zzaa r2 = r0.zzj
            com.google.android.gms.measurement.internal.zzep r2 = r0.zzh()
            r3 = 0
            r5 = 0
            if (r38 == 0) goto L_0x00b0
            com.google.android.gms.measurement.internal.zzgi r0 = r1.zzs
            com.google.android.gms.measurement.internal.zzey r0 = r0.zzaz()
            com.google.android.gms.measurement.internal.zzgi r6 = r0.zzs
            com.google.android.gms.measurement.internal.zzfn r6 = r6.zzm()
            com.google.android.gms.measurement.internal.zzfl r6 = r6.zzb
            if (r6 != 0) goto L_0x0021
            goto L_0x00b0
        L_0x0021:
            com.google.android.gms.measurement.internal.zzgi r0 = r0.zzs
            com.google.android.gms.measurement.internal.zzfn r0 = r0.zzm()
            com.google.android.gms.measurement.internal.zzfl r0 = r0.zzb
            com.google.android.gms.measurement.internal.zzfn r6 = r0.zzb
            r6.zzg()
            com.google.android.gms.measurement.internal.zzfn r6 = r0.zzb
            r6.zzg()
            com.google.android.gms.measurement.internal.zzfn r6 = r0.zzb
            android.content.SharedPreferences r6 = r6.zza()
            java.lang.String r7 = r0.zza
            long r6 = r6.getLong(r7, r3)
            int r8 = (r6 > r3 ? 1 : (r6 == r3 ? 0 : -1))
            if (r8 != 0) goto L_0x0048
            r0.zzd()
            r6 = r3
            goto L_0x0057
        L_0x0048:
            com.google.android.gms.measurement.internal.zzfn r8 = r0.zzb
            com.google.android.gms.measurement.internal.zzgi r8 = r8.zzs
            com.google.android.gms.common.util.Clock r8 = r8.zzr
            long r8 = r8.currentTimeMillis()
            long r6 = r6 - r8
            long r6 = java.lang.Math.abs(r6)
        L_0x0057:
            long r8 = r0.zze
            int r10 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r10 >= 0) goto L_0x005e
            goto L_0x0066
        L_0x005e:
            long r8 = r8 + r8
            int r10 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r10 <= 0) goto L_0x0068
            r0.zzd()
        L_0x0066:
            r0 = r5
            goto L_0x0096
        L_0x0068:
            com.google.android.gms.measurement.internal.zzfn r6 = r0.zzb
            android.content.SharedPreferences r6 = r6.zza()
            java.lang.String r7 = r0.zzd
            java.lang.String r6 = r6.getString(r7, r5)
            com.google.android.gms.measurement.internal.zzfn r7 = r0.zzb
            android.content.SharedPreferences r7 = r7.zza()
            java.lang.String r8 = r0.zzc
            long r7 = r7.getLong(r8, r3)
            r0.zzd()
            if (r6 == 0) goto L_0x0094
            int r0 = (r7 > r3 ? 1 : (r7 == r3 ? 0 : -1))
            if (r0 > 0) goto L_0x008a
            goto L_0x0094
        L_0x008a:
            android.util.Pair r0 = new android.util.Pair
            java.lang.Long r7 = java.lang.Long.valueOf(r7)
            r0.<init>(r6, r7)
            goto L_0x0096
        L_0x0094:
            android.util.Pair r0 = com.google.android.gms.measurement.internal.zzfn.zza
        L_0x0096:
            if (r0 == 0) goto L_0x00b0
            android.util.Pair r6 = com.google.android.gms.measurement.internal.zzfn.zza
            if (r0 != r6) goto L_0x009d
            goto L_0x00b0
        L_0x009d:
            java.lang.Object r6 = r0.second
            java.lang.String r6 = java.lang.String.valueOf(r6)
            java.lang.Object r0 = r0.first
            java.lang.String r0 = (java.lang.String) r0
            java.lang.String r7 = ":"
            java.lang.String r0 = com.android.tools.r8.GeneratedOutlineSupport.outline52(r6, r7, r0)
            r17 = r0
            goto L_0x00b2
        L_0x00b0:
            r17 = r5
        L_0x00b2:
            r2.zzg()
            com.google.android.gms.measurement.internal.zzp r36 = new com.google.android.gms.measurement.internal.zzp
            java.lang.String r7 = r2.zzl()
            java.lang.String r8 = r2.zzm()
            r2.zza()
            java.lang.String r9 = r2.zzb
            r2.zza()
            int r0 = r2.zzc
            long r10 = (long) r0
            r2.zza()
            java.lang.String r0 = r2.zzd
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r0)
            java.lang.String r12 = r2.zzd
            com.google.android.gms.measurement.internal.zzgi r0 = r2.zzs
            com.google.android.gms.measurement.internal.zzaf r0 = r0.zzk
            r0.zzh()
            r2.zza()
            r2.zzg()
            long r13 = r2.zzf
            r6 = 0
            int r0 = (r13 > r3 ? 1 : (r13 == r3 ? 0 : -1))
            if (r0 != 0) goto L_0x0170
            com.google.android.gms.measurement.internal.zzgi r0 = r2.zzs
            com.google.android.gms.measurement.internal.zzlp r3 = r0.zzv()
            com.google.android.gms.measurement.internal.zzgi r0 = r2.zzs
            android.content.Context r0 = r0.zze
            java.lang.String r4 = r0.getPackageName()
            r3.zzg()
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r0)
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r4)
            android.content.pm.PackageManager r13 = r0.getPackageManager()
            java.security.MessageDigest r14 = com.google.android.gms.measurement.internal.zzlp.zzF()
            r15 = -1
            if (r14 != 0) goto L_0x0119
            com.google.android.gms.measurement.internal.zzgi r0 = r3.zzs
            com.google.android.gms.measurement.internal.zzey r0 = r0.zzaz()
            com.google.android.gms.measurement.internal.zzew r0 = r0.zzd
            java.lang.String r3 = "Could not get MD5 instance"
            r0.zza(r3)
            goto L_0x016b
        L_0x0119:
            if (r13 == 0) goto L_0x0169
            boolean r4 = r3.zzag(r0, r4)     // Catch:{ NameNotFoundException -> 0x015b }
            if (r4 != 0) goto L_0x0169
            com.google.android.gms.common.wrappers.PackageManagerWrapper r0 = com.google.android.gms.common.wrappers.Wrappers.packageManager(r0)     // Catch:{ NameNotFoundException -> 0x015b }
            com.google.android.gms.measurement.internal.zzgi r4 = r3.zzs     // Catch:{ NameNotFoundException -> 0x015b }
            android.content.Context r4 = r4.zze     // Catch:{ NameNotFoundException -> 0x015b }
            java.lang.String r4 = r4.getPackageName()     // Catch:{ NameNotFoundException -> 0x015b }
            r13 = 64
            android.content.pm.PackageInfo r0 = r0.getPackageInfo(r4, r13)     // Catch:{ NameNotFoundException -> 0x015b }
            android.content.pm.Signature[] r4 = r0.signatures     // Catch:{ NameNotFoundException -> 0x015b }
            if (r4 == 0) goto L_0x014d
            android.content.pm.Signature[] r4 = r0.signatures     // Catch:{ NameNotFoundException -> 0x015b }
            int r4 = r4.length     // Catch:{ NameNotFoundException -> 0x015b }
            if (r4 <= 0) goto L_0x014d
            android.content.pm.Signature[] r0 = r0.signatures     // Catch:{ NameNotFoundException -> 0x015b }
            r0 = r0[r6]     // Catch:{ NameNotFoundException -> 0x015b }
            byte[] r0 = r0.toByteArray()     // Catch:{ NameNotFoundException -> 0x015b }
            byte[] r0 = r14.digest(r0)     // Catch:{ NameNotFoundException -> 0x015b }
            long r15 = com.google.android.gms.measurement.internal.zzlp.zzp(r0)     // Catch:{ NameNotFoundException -> 0x015b }
            goto L_0x016b
        L_0x014d:
            com.google.android.gms.measurement.internal.zzgi r0 = r3.zzs     // Catch:{ NameNotFoundException -> 0x015b }
            com.google.android.gms.measurement.internal.zzey r0 = r0.zzaz()     // Catch:{ NameNotFoundException -> 0x015b }
            com.google.android.gms.measurement.internal.zzew r0 = r0.zzg     // Catch:{ NameNotFoundException -> 0x015b }
            java.lang.String r4 = "Could not get signatures"
            r0.zza(r4)     // Catch:{ NameNotFoundException -> 0x015b }
            goto L_0x016b
        L_0x015b:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzgi r3 = r3.zzs
            com.google.android.gms.measurement.internal.zzey r3 = r3.zzaz()
            com.google.android.gms.measurement.internal.zzew r3 = r3.zzd
            java.lang.String r4 = "Package name not found"
            r3.zzb(r4, r0)
        L_0x0169:
            r15 = 0
        L_0x016b:
            r3 = r15
            r2.zzf = r3
            r15 = r3
            goto L_0x0171
        L_0x0170:
            r15 = r13
        L_0x0171:
            com.google.android.gms.measurement.internal.zzgi r0 = r2.zzs
            boolean r18 = r0.zzJ()
            com.google.android.gms.measurement.internal.zzgi r0 = r2.zzs
            com.google.android.gms.measurement.internal.zzfn r0 = r0.zzm()
            boolean r0 = r0.zzk
            r3 = 1
            r19 = r0 ^ 1
            r2.zzg()
            com.google.android.gms.measurement.internal.zzgi r0 = r2.zzs
            boolean r0 = r0.zzJ()
            if (r0 != 0) goto L_0x018e
            goto L_0x01bb
        L_0x018e:
            com.google.android.gms.internal.measurement.zzpv.zzc()
            com.google.android.gms.measurement.internal.zzgi r0 = r2.zzs
            com.google.android.gms.measurement.internal.zzaf r0 = r0.zzk
            com.google.android.gms.measurement.internal.zzek r4 = com.google.android.gms.measurement.internal.zzel.zzab
            boolean r0 = r0.zzs(r5, r4)
            if (r0 == 0) goto L_0x01ab
            com.google.android.gms.measurement.internal.zzgi r0 = r2.zzs
            com.google.android.gms.measurement.internal.zzey r0 = r0.zzaz()
            com.google.android.gms.measurement.internal.zzew r0 = r0.zzl
            java.lang.String r3 = "Disabled IID for tests."
            r0.zza(r3)
            goto L_0x01bb
        L_0x01ab:
            com.google.android.gms.measurement.internal.zzgi r0 = r2.zzs     // Catch:{ ClassNotFoundException -> 0x0207 }
            android.content.Context r0 = r0.zze     // Catch:{ ClassNotFoundException -> 0x0207 }
            java.lang.ClassLoader r0 = r0.getClassLoader()     // Catch:{ ClassNotFoundException -> 0x0207 }
            java.lang.String r4 = "com.google.firebase.analytics.FirebaseAnalytics"
            java.lang.Class r0 = r0.loadClass(r4)     // Catch:{ ClassNotFoundException -> 0x0207 }
            if (r0 != 0) goto L_0x01be
        L_0x01bb:
            r20 = r5
            goto L_0x0209
        L_0x01be:
            java.lang.Class[] r4 = new java.lang.Class[r3]     // Catch:{ Exception -> 0x01fa }
            java.lang.Class<android.content.Context> r5 = android.content.Context.class
            r4[r6] = r5     // Catch:{ Exception -> 0x01fa }
            java.lang.String r5 = "getInstance"
            java.lang.reflect.Method r4 = r0.getDeclaredMethod(r5, r4)     // Catch:{ Exception -> 0x01fa }
            java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch:{ Exception -> 0x01fa }
            com.google.android.gms.measurement.internal.zzgi r5 = r2.zzs     // Catch:{ Exception -> 0x01fa }
            android.content.Context r5 = r5.zze     // Catch:{ Exception -> 0x01fa }
            r3[r6] = r5     // Catch:{ Exception -> 0x01fa }
            r5 = 0
            java.lang.Object r3 = r4.invoke(r5, r3)     // Catch:{ Exception -> 0x01fa }
            if (r3 != 0) goto L_0x01da
            goto L_0x0207
        L_0x01da:
            java.lang.String r4 = "getFirebaseInstanceId"
            java.lang.Class[] r5 = new java.lang.Class[r6]     // Catch:{ Exception -> 0x01ec }
            java.lang.reflect.Method r0 = r0.getDeclaredMethod(r4, r5)     // Catch:{ Exception -> 0x01ec }
            java.lang.Object[] r4 = new java.lang.Object[r6]     // Catch:{ Exception -> 0x01ec }
            java.lang.Object r0 = r0.invoke(r3, r4)     // Catch:{ Exception -> 0x01ec }
            r5 = r0
            java.lang.String r5 = (java.lang.String) r5     // Catch:{ Exception -> 0x01ec }
            goto L_0x01bb
        L_0x01ec:
            com.google.android.gms.measurement.internal.zzgi r0 = r2.zzs
            com.google.android.gms.measurement.internal.zzey r0 = r0.zzaz()
            com.google.android.gms.measurement.internal.zzew r0 = r0.zzi
            java.lang.String r3 = "Failed to retrieve Firebase Instance Id"
            r0.zza(r3)
            goto L_0x0207
        L_0x01fa:
            com.google.android.gms.measurement.internal.zzgi r0 = r2.zzs
            com.google.android.gms.measurement.internal.zzey r0 = r0.zzaz()
            com.google.android.gms.measurement.internal.zzew r0 = r0.zzh
            java.lang.String r3 = "Failed to obtain Firebase Analytics instance"
            r0.zza(r3)
        L_0x0207:
            r5 = 0
            goto L_0x01bb
        L_0x0209:
            com.google.android.gms.measurement.internal.zzgi r0 = r2.zzs
            com.google.android.gms.measurement.internal.zzfn r3 = r0.zzm()
            com.google.android.gms.measurement.internal.zzfj r3 = r3.zzc
            long r3 = r3.zza()
            r5 = 0
            int r13 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r13 != 0) goto L_0x021e
            long r3 = r0.zzc
            goto L_0x0224
        L_0x021e:
            long r5 = r0.zzc
            long r3 = java.lang.Math.min(r5, r3)
        L_0x0224:
            r23 = r3
            r2.zza()
            int r0 = r2.zzj
            com.google.android.gms.measurement.internal.zzgi r3 = r2.zzs
            com.google.android.gms.measurement.internal.zzaf r3 = r3.zzk
            boolean r26 = r3.zzr()
            com.google.android.gms.measurement.internal.zzgi r3 = r2.zzs
            com.google.android.gms.measurement.internal.zzfn r3 = r3.zzm()
            r3.zzg()
            android.content.SharedPreferences r3 = r3.zza()
            java.lang.String r4 = "deferred_analytics_collection"
            r5 = 0
            boolean r27 = r3.getBoolean(r4, r5)
            r2.zza()
            java.lang.String r3 = r2.zzl
            com.google.android.gms.measurement.internal.zzgi r4 = r2.zzs
            com.google.android.gms.measurement.internal.zzaf r4 = r4.zzk
            java.lang.String r5 = "google_analytics_default_allow_ad_personalization_signals"
            java.lang.Boolean r4 = r4.zzk(r5)
            if (r4 != 0) goto L_0x025a
            r4 = 0
            goto L_0x0264
        L_0x025a:
            boolean r4 = r4.booleanValue()
            r4 = r4 ^ 1
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r4)
        L_0x0264:
            r29 = r4
            long r4 = r2.zzg
            java.util.List r6 = r2.zzh
            com.google.android.gms.measurement.internal.zzgi r13 = r2.zzs
            com.google.android.gms.measurement.internal.zzfn r13 = r13.zzm()
            com.google.android.gms.measurement.internal.zzah r13 = r13.zzc()
            java.lang.String r33 = r13.zzh()
            java.lang.String r13 = r2.zzi
            if (r13 != 0) goto L_0x029a
            com.google.android.gms.measurement.internal.zzgi r13 = r2.zzs
            com.google.android.gms.measurement.internal.zzaf r13 = r13.zzk
            com.google.android.gms.measurement.internal.zzek r14 = com.google.android.gms.measurement.internal.zzel.zzaN
            r1 = 0
            boolean r1 = r13.zzs(r1, r14)
            if (r1 == 0) goto L_0x0296
            com.google.android.gms.measurement.internal.zzgi r1 = r2.zzs
            com.google.android.gms.measurement.internal.zzlp r1 = r1.zzv()
            java.lang.String r1 = r1.zzC()
            r2.zzi = r1
            goto L_0x029a
        L_0x0296:
            java.lang.String r1 = ""
            r2.zzi = r1
        L_0x029a:
            java.lang.String r1 = r2.zzi
            com.google.android.gms.internal.measurement.zzpp.zzc()
            com.google.android.gms.measurement.internal.zzgi r13 = r2.zzs
            com.google.android.gms.measurement.internal.zzaf r13 = r13.zzk
            com.google.android.gms.measurement.internal.zzek r14 = com.google.android.gms.measurement.internal.zzel.zzaI
            r25 = r6
            r6 = 0
            boolean r13 = r13.zzs(r6, r14)
            if (r13 == 0) goto L_0x02e7
            r2.zzg()
            long r13 = r2.zzn
            r21 = 0
            int r6 = (r13 > r21 ? 1 : (r13 == r21 ? 0 : -1))
            if (r6 != 0) goto L_0x02bc
            r30 = r4
            goto L_0x02db
        L_0x02bc:
            com.google.android.gms.measurement.internal.zzgi r6 = r2.zzs
            com.google.android.gms.common.util.Clock r6 = r6.zzr
            long r13 = r6.currentTimeMillis()
            r30 = r4
            long r4 = r2.zzn
            long r13 = r13 - r4
            java.lang.String r4 = r2.zzm
            if (r4 == 0) goto L_0x02db
            r4 = 86400000(0x5265c00, double:4.2687272E-316)
            int r6 = (r13 > r4 ? 1 : (r13 == r4 ? 0 : -1))
            if (r6 <= 0) goto L_0x02db
            java.lang.String r4 = r2.zzo
            if (r4 != 0) goto L_0x02db
            r2.zzo()
        L_0x02db:
            java.lang.String r4 = r2.zzm
            if (r4 != 0) goto L_0x02e2
            r2.zzo()
        L_0x02e2:
            java.lang.String r2 = r2.zzm
            r35 = r2
            goto L_0x02eb
        L_0x02e7:
            r30 = r4
            r35 = r6
        L_0x02eb:
            r13 = 61000(0xee48, double:3.0138E-319)
            r21 = 0
            r2 = r25
            r6 = r36
            r25 = r0
            r28 = r3
            r32 = r2
            r34 = r1
            r6.<init>(r7, r8, r9, r10, r12, r13, r15, r17, r18, r19, r20, r21, r23, r25, r26, r27, r28, r29, r30, r32, r33, r34, r35)
            return r36
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzkb.zzO(boolean):com.google.android.gms.measurement.internal.zzp");
    }

    public final void zzP() {
        zzg();
        this.zzs.zzaz().zzl.zzb("Processing queued up service tasks", Integer.valueOf(this.zzf.size()));
        for (Runnable run : this.zzf) {
            try {
                run.run();
            } catch (RuntimeException e2) {
                this.zzs.zzaz().zzd.zzb("Task exception while flushing queue", e2);
            }
        }
        this.zzf.clear();
        this.zzg.zzb();
    }

    public final void zzQ() {
        zzg();
        zzks zzks = this.zze;
        zzks.zzb = zzks.zza.elapsedRealtime();
        zzao zzao = this.zzd;
        zzaf zzaf = this.zzs.zzk;
        zzao.zzd(((Long) zzel.zzI.zza(null)).longValue());
    }

    public final void zzR(Runnable runnable) throws IllegalStateException {
        zzg();
        if (zzL()) {
            runnable.run();
            return;
        }
        int size = this.zzf.size();
        zzgi zzgi = this.zzs;
        zzaf zzaf = zzgi.zzk;
        if (((long) size) >= 1000) {
            zzgi.zzaz().zzd.zza("Discarding data. Max runnable queue size reached");
            return;
        }
        this.zzf.add(runnable);
        this.zzg.zzd(60000);
        zzr();
    }

    public final boolean zzS() {
        zzaa zzaa = this.zzs.zzj;
        return true;
    }

    public final boolean zzf() {
        return false;
    }

    public final Boolean zzj() {
        return this.zzc;
    }

    public final void zzr() {
        zzg();
        zza();
        if (!zzL()) {
            if (!zzN()) {
                if (!this.zzs.zzk.zzx()) {
                    zzgi zzgi = this.zzs;
                    zzaa zzaa = zzgi.zzj;
                    List<ResolveInfo> queryIntentServices = zzgi.zze.getPackageManager().queryIntentServices(new Intent().setClassName(this.zzs.zze, "com.google.android.gms.measurement.AppMeasurementService"), 65536);
                    if (queryIntentServices == null || queryIntentServices.isEmpty()) {
                        this.zzs.zzaz().zzd.zza("Unable to use remote or local measurement implementation. Please register the AppMeasurementService service in the app manifest");
                    } else {
                        Intent intent = new Intent("com.google.android.gms.measurement.START");
                        zzgi zzgi2 = this.zzs;
                        Context context = zzgi2.zze;
                        zzaa zzaa2 = zzgi2.zzj;
                        intent.setComponent(new ComponentName(context, "com.google.android.gms.measurement.AppMeasurementService"));
                        zzka zzka = this.zza;
                        zzka.zza.zzg();
                        Context context2 = zzka.zza.zzs.zze;
                        ConnectionTracker instance = ConnectionTracker.getInstance();
                        synchronized (zzka) {
                            if (zzka.zzb) {
                                zzka.zza.zzs.zzaz().zzl.zza("Connection attempt already in progress");
                            } else {
                                zzka.zza.zzs.zzaz().zzl.zza("Using local app measurement service");
                                zzka.zzb = true;
                                instance.bindService(context2, intent, zzka.zza.zza, 129);
                            }
                        }
                        return;
                    }
                }
                return;
            }
            zzka zzka2 = this.zza;
            zzka2.zza.zzg();
            Context context3 = zzka2.zza.zzs.zze;
            synchronized (zzka2) {
                if (zzka2.zzb) {
                    zzka2.zza.zzs.zzaz().zzl.zza("Connection attempt already in progress");
                } else if (zzka2.zzc == null || (!zzka2.zzc.isConnecting() && !zzka2.zzc.isConnected())) {
                    zzka2.zzc = new zzeu(context3, Looper.getMainLooper(), zzka2, zzka2);
                    zzka2.zza.zzs.zzaz().zzl.zza("Connecting to remote service");
                    zzka2.zzb = true;
                    Preconditions.checkNotNull(zzka2.zzc);
                    zzka2.zzc.checkAvailabilityAndConnect();
                } else {
                    zzka2.zza.zzs.zzaz().zzl.zza("Already awaiting connection attempt");
                }
            }
        }
    }

    public final void zzs() {
        zzg();
        zza();
        zzka zzka = this.zza;
        if (zzka.zzc != null && (zzka.zzc.isConnected() || zzka.zzc.isConnecting())) {
            zzka.zzc.disconnect();
        }
        zzka.zzc = null;
        try {
            ConnectionTracker.getInstance().unbindService(this.zzs.zze, this.zza);
        } catch (IllegalArgumentException | IllegalStateException unused) {
        }
        this.zzb = null;
    }

    public final void zzu(AtomicReference atomicReference) {
        zzg();
        zza();
        zzR(new zzjg(this, atomicReference, zzO(false)));
    }
}
