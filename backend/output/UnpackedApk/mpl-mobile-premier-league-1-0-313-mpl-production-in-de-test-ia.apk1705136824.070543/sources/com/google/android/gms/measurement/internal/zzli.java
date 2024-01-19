package com.google.android.gms.measurement.internal;

import android.content.ContentValues;
import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.net.Uri.Builder;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.collection.ArrayMap;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.internal.measurement.zzfe;
import com.google.android.gms.internal.measurement.zzfr;
import com.google.android.gms.internal.measurement.zzfs;
import com.google.android.gms.internal.measurement.zzfv;
import com.google.android.gms.internal.measurement.zzfw;
import com.google.android.gms.internal.measurement.zzgb;
import com.google.android.gms.internal.measurement.zzgk;
import com.google.android.gms.internal.measurement.zzgl;
import com.google.android.gms.internal.measurement.zzne;
import com.google.android.gms.internal.measurement.zznz;
import com.google.android.gms.internal.measurement.zzpg;
import com.google.android.gms.internal.measurement.zzpm;
import com.google.android.gms.internal.measurement.zzpp;
import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.jboss.netty.handler.codec.http.HttpHeaders.Names;
import sfs2x.client.requests.BaseRequest;

/* compiled from: com.google.android.gms:play-services-measurement@@20.1.2 */
public final class zzli implements zzhd {
    public static volatile zzli zzb;
    public long zzA;
    public final Map zzB;
    public final Map zzC;
    public zziu zzD;
    public String zzE;
    public final zzlo zzF = new zzld(this);
    @VisibleForTesting
    public long zza;
    public final zzfz zzc;
    public final zzfe zzd;
    public zzal zze;
    public zzfg zzf;
    public zzku zzg;
    public zzz zzh;
    public final zzlk zzi;
    public zzis zzj;
    public zzkd zzk;
    public final zzkx zzl;
    public zzfq zzm;
    public final zzgi zzn;
    public boolean zzo = false;
    public boolean zzp;
    public List zzq;
    public int zzr;
    public int zzs;
    public boolean zzt;
    public boolean zzu;
    public boolean zzv;
    public FileLock zzw;
    public FileChannel zzx;
    public List zzy;
    public List zzz;

    public zzli(zzlj zzlj, zzgi zzgi) {
        Preconditions.checkNotNull(zzlj);
        this.zzn = zzgi.zzp(zzlj.zza, null, null);
        this.zzA = -1;
        this.zzl = new zzkx(this);
        zzlk zzlk = new zzlk(this);
        zzlk.zzX();
        this.zzi = zzlk;
        zzfe zzfe = new zzfe(this);
        zzfe.zzX();
        this.zzd = zzfe;
        zzfz zzfz = new zzfz(this);
        zzfz.zzX();
        this.zzc = zzfz;
        this.zzB = new HashMap();
        this.zzC = new HashMap();
        zzaA().zzp(new zzky(this, zzlj));
    }

    @VisibleForTesting
    public static final void zzZ(zzfr zzfr, int i, String str) {
        List zzp2 = zzfr.zzp();
        int i2 = 0;
        while (i2 < zzp2.size()) {
            if (!"_err".equals(((zzfw) zzp2.get(i2)).zzg())) {
                i2++;
            } else {
                return;
            }
        }
        zzfv zze2 = zzfw.zze();
        zze2.zzj("_err");
        zze2.zzi(Long.valueOf((long) i).longValue());
        zzfv zze3 = zzfw.zze();
        zze3.zzj("_ev");
        zze3.zzk(str);
        zzfr.zzf((zzfw) zze2.zzaE());
        zzfr.zzf((zzfw) zze3.zzaE());
    }

    @VisibleForTesting
    public static final void zzaa(zzfr zzfr, String str) {
        List zzp2 = zzfr.zzp();
        for (int i = 0; i < zzp2.size(); i++) {
            if (str.equals(((zzfw) zzp2.get(i)).zzg())) {
                zzfr.zzh(i);
                return;
            }
        }
    }

    public static final boolean zzaj(zzp zzp2) {
        return !TextUtils.isEmpty(zzp2.zzb) || !TextUtils.isEmpty(zzp2.zzq);
    }

    public static final zzkw zzak(zzkw zzkw) {
        if (zzkw == null) {
            throw new IllegalStateException("Upload Component not created");
        } else if (zzkw.zza) {
            return zzkw;
        } else {
            throw new IllegalStateException("Component not initialized: ".concat(String.valueOf(zzkw.getClass())));
        }
    }

    public static zzli zzt(Context context) {
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(context.getApplicationContext());
        if (zzb == null) {
            synchronized (zzli.class) {
                try {
                    if (zzb == null) {
                        zzlj zzlj = new zzlj(context);
                        Preconditions.checkNotNull(zzlj);
                        zzb = new zzli(zzlj, null);
                    }
                }
            }
        }
        return zzb;
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x009a  */
    @com.google.android.gms.common.util.VisibleForTesting
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzA() {
        /*
            r10 = this;
            com.google.android.gms.measurement.internal.zzgf r0 = r10.zzaA()
            r0.zzg()
            r10.zzB()
            boolean r0 = r10.zzp
            if (r0 != 0) goto L_0x0198
            r0 = 1
            r10.zzp = r0
            com.google.android.gms.measurement.internal.zzgf r1 = r10.zzaA()
            r1.zzg()
            java.nio.channels.FileLock r1 = r10.zzw
            java.lang.String r2 = "Storage concurrent access okay"
            r3 = 0
            if (r1 == 0) goto L_0x0031
            boolean r1 = r1.isValid()
            if (r1 != 0) goto L_0x0026
            goto L_0x0031
        L_0x0026:
            com.google.android.gms.measurement.internal.zzey r1 = r10.zzaz()
            com.google.android.gms.measurement.internal.zzew r1 = r1.zzl
            r1.zza(r2)
        L_0x002f:
            r1 = 1
            goto L_0x0098
        L_0x0031:
            com.google.android.gms.measurement.internal.zzal r1 = r10.zze
            com.google.android.gms.measurement.internal.zzgi r1 = r1.zzs
            com.google.android.gms.measurement.internal.zzaf r1 = r1.zzk
            com.google.android.gms.measurement.internal.zzgi r1 = r10.zzn
            android.content.Context r1 = r1.zze
            java.io.File r1 = r1.getFilesDir()
            java.io.File r4 = new java.io.File
            java.lang.String r5 = "google_app_measurement.db"
            r4.<init>(r1, r5)
            java.io.RandomAccessFile r1 = new java.io.RandomAccessFile     // Catch:{ FileNotFoundException -> 0x008b, IOException -> 0x007e, OverlappingFileLockException -> 0x0071 }
            java.lang.String r5 = "rw"
            r1.<init>(r4, r5)     // Catch:{ FileNotFoundException -> 0x008b, IOException -> 0x007e, OverlappingFileLockException -> 0x0071 }
            java.nio.channels.FileChannel r1 = r1.getChannel()     // Catch:{ FileNotFoundException -> 0x008b, IOException -> 0x007e, OverlappingFileLockException -> 0x0071 }
            r10.zzx = r1     // Catch:{ FileNotFoundException -> 0x008b, IOException -> 0x007e, OverlappingFileLockException -> 0x0071 }
            java.nio.channels.FileLock r1 = r1.tryLock()     // Catch:{ FileNotFoundException -> 0x008b, IOException -> 0x007e, OverlappingFileLockException -> 0x0071 }
            r10.zzw = r1     // Catch:{ FileNotFoundException -> 0x008b, IOException -> 0x007e, OverlappingFileLockException -> 0x0071 }
            if (r1 == 0) goto L_0x0065
            com.google.android.gms.measurement.internal.zzey r1 = r10.zzaz()     // Catch:{ FileNotFoundException -> 0x008b, IOException -> 0x007e, OverlappingFileLockException -> 0x0071 }
            com.google.android.gms.measurement.internal.zzew r1 = r1.zzl     // Catch:{ FileNotFoundException -> 0x008b, IOException -> 0x007e, OverlappingFileLockException -> 0x0071 }
            r1.zza(r2)     // Catch:{ FileNotFoundException -> 0x008b, IOException -> 0x007e, OverlappingFileLockException -> 0x0071 }
            goto L_0x002f
        L_0x0065:
            com.google.android.gms.measurement.internal.zzey r1 = r10.zzaz()     // Catch:{ FileNotFoundException -> 0x008b, IOException -> 0x007e, OverlappingFileLockException -> 0x0071 }
            com.google.android.gms.measurement.internal.zzew r1 = r1.zzd     // Catch:{ FileNotFoundException -> 0x008b, IOException -> 0x007e, OverlappingFileLockException -> 0x0071 }
            java.lang.String r2 = "Storage concurrent data access panic"
            r1.zza(r2)     // Catch:{ FileNotFoundException -> 0x008b, IOException -> 0x007e, OverlappingFileLockException -> 0x0071 }
            goto L_0x0097
        L_0x0071:
            r1 = move-exception
            com.google.android.gms.measurement.internal.zzey r2 = r10.zzaz()
            com.google.android.gms.measurement.internal.zzew r2 = r2.zzg
            java.lang.String r4 = "Storage lock already acquired"
            r2.zzb(r4, r1)
            goto L_0x0097
        L_0x007e:
            r1 = move-exception
            com.google.android.gms.measurement.internal.zzey r2 = r10.zzaz()
            com.google.android.gms.measurement.internal.zzew r2 = r2.zzd
            java.lang.String r4 = "Failed to access storage lock file"
            r2.zzb(r4, r1)
            goto L_0x0097
        L_0x008b:
            r1 = move-exception
            com.google.android.gms.measurement.internal.zzey r2 = r10.zzaz()
            com.google.android.gms.measurement.internal.zzew r2 = r2.zzd
            java.lang.String r4 = "Failed to acquire storage lock"
            r2.zzb(r4, r1)
        L_0x0097:
            r1 = 0
        L_0x0098:
            if (r1 == 0) goto L_0x0198
            java.nio.channels.FileChannel r1 = r10.zzx
            com.google.android.gms.measurement.internal.zzgf r2 = r10.zzaA()
            r2.zzg()
            r4 = 0
            java.lang.String r2 = "Bad channel to read from"
            r6 = 4
            if (r1 == 0) goto L_0x00e6
            boolean r7 = r1.isOpen()
            if (r7 != 0) goto L_0x00b1
            goto L_0x00e6
        L_0x00b1:
            java.nio.ByteBuffer r7 = java.nio.ByteBuffer.allocate(r6)
            r1.position(r4)     // Catch:{ IOException -> 0x00d9 }
            int r1 = r1.read(r7)     // Catch:{ IOException -> 0x00d9 }
            if (r1 == r6) goto L_0x00d1
            r7 = -1
            if (r1 == r7) goto L_0x00ef
            com.google.android.gms.measurement.internal.zzey r7 = r10.zzaz()     // Catch:{ IOException -> 0x00d9 }
            com.google.android.gms.measurement.internal.zzew r7 = r7.zzg     // Catch:{ IOException -> 0x00d9 }
            java.lang.String r8 = "Unexpected data length. Bytes read"
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch:{ IOException -> 0x00d9 }
            r7.zzb(r8, r1)     // Catch:{ IOException -> 0x00d9 }
            goto L_0x00ef
        L_0x00d1:
            r7.flip()     // Catch:{ IOException -> 0x00d9 }
            int r3 = r7.getInt()     // Catch:{ IOException -> 0x00d9 }
            goto L_0x00ef
        L_0x00d9:
            r1 = move-exception
            com.google.android.gms.measurement.internal.zzey r7 = r10.zzaz()
            com.google.android.gms.measurement.internal.zzew r7 = r7.zzd
            java.lang.String r8 = "Failed to read from channel"
            r7.zzb(r8, r1)
            goto L_0x00ef
        L_0x00e6:
            com.google.android.gms.measurement.internal.zzey r1 = r10.zzaz()
            com.google.android.gms.measurement.internal.zzew r1 = r1.zzd
            r1.zza(r2)
        L_0x00ef:
            com.google.android.gms.measurement.internal.zzgi r1 = r10.zzn
            com.google.android.gms.measurement.internal.zzep r1 = r1.zzh()
            r1.zza()
            int r1 = r1.zzc
            com.google.android.gms.measurement.internal.zzgf r7 = r10.zzaA()
            r7.zzg()
            if (r3 <= r1) goto L_0x0117
            com.google.android.gms.measurement.internal.zzey r0 = r10.zzaz()
            com.google.android.gms.measurement.internal.zzew r0 = r0.zzd
            java.lang.Integer r2 = java.lang.Integer.valueOf(r3)
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            java.lang.String r3 = "Panic: can't downgrade version. Previous, current version"
            r0.zzc(r3, r2, r1)
            return
        L_0x0117:
            if (r3 >= r1) goto L_0x0198
            java.nio.channels.FileChannel r7 = r10.zzx
            com.google.android.gms.measurement.internal.zzgf r8 = r10.zzaA()
            r8.zzg()
            if (r7 == 0) goto L_0x017c
            boolean r8 = r7.isOpen()
            if (r8 != 0) goto L_0x012b
            goto L_0x017c
        L_0x012b:
            java.nio.ByteBuffer r2 = java.nio.ByteBuffer.allocate(r6)
            r2.putInt(r1)
            r2.flip()
            r7.truncate(r4)     // Catch:{ IOException -> 0x016f }
            r7.write(r2)     // Catch:{ IOException -> 0x016f }
            r7.force(r0)     // Catch:{ IOException -> 0x016f }
            long r4 = r7.size()     // Catch:{ IOException -> 0x016f }
            r8 = 4
            int r0 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1))
            if (r0 == 0) goto L_0x015b
            com.google.android.gms.measurement.internal.zzey r0 = r10.zzaz()     // Catch:{ IOException -> 0x016f }
            com.google.android.gms.measurement.internal.zzew r0 = r0.zzd     // Catch:{ IOException -> 0x016f }
            java.lang.String r2 = "Error writing to channel. Bytes written"
            long r4 = r7.size()     // Catch:{ IOException -> 0x016f }
            java.lang.Long r4 = java.lang.Long.valueOf(r4)     // Catch:{ IOException -> 0x016f }
            r0.zzb(r2, r4)     // Catch:{ IOException -> 0x016f }
        L_0x015b:
            com.google.android.gms.measurement.internal.zzey r0 = r10.zzaz()
            com.google.android.gms.measurement.internal.zzew r0 = r0.zzl
            java.lang.Integer r2 = java.lang.Integer.valueOf(r3)
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            java.lang.String r3 = "Storage version upgraded. Previous, current version"
            r0.zzc(r3, r2, r1)
            return
        L_0x016f:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzey r2 = r10.zzaz()
            com.google.android.gms.measurement.internal.zzew r2 = r2.zzd
            java.lang.String r4 = "Failed to write to channel"
            r2.zzb(r4, r0)
            goto L_0x0185
        L_0x017c:
            com.google.android.gms.measurement.internal.zzey r0 = r10.zzaz()
            com.google.android.gms.measurement.internal.zzew r0 = r0.zzd
            r0.zza(r2)
        L_0x0185:
            com.google.android.gms.measurement.internal.zzey r0 = r10.zzaz()
            com.google.android.gms.measurement.internal.zzew r0 = r0.zzd
            java.lang.Integer r2 = java.lang.Integer.valueOf(r3)
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            java.lang.String r3 = "Storage version upgrade failed. Previous, current version"
            r0.zzc(r3, r2, r1)
        L_0x0198:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzli.zzA():void");
    }

    public final void zzB() {
        if (!this.zzo) {
            throw new IllegalStateException("UploadController is not initialized");
        }
    }

    public final void zzC(zzg zzg2) {
        ArrayMap arrayMap;
        ArrayMap arrayMap2;
        zzaA().zzg();
        if (!TextUtils.isEmpty(zzg2.zzy()) || !TextUtils.isEmpty(zzg2.zzr())) {
            zzkx zzkx = this.zzl;
            Builder builder = new Builder();
            String zzy2 = zzg2.zzy();
            if (TextUtils.isEmpty(zzy2)) {
                zzy2 = zzg2.zzr();
            }
            ArrayMap arrayMap3 = null;
            Builder appendQueryParameter = builder.scheme((String) zzel.zzd.zza(null)).encodedAuthority((String) zzel.zze.zza(null)).path("config/app/".concat(String.valueOf(zzy2))).appendQueryParameter("platform", "android");
            zzkx.zzs.zzk.zzh();
            appendQueryParameter.appendQueryParameter("gmp_version", String.valueOf(61000)).appendQueryParameter("runtime_version", "0");
            zzpg.zzc();
            if (!zzkx.zzs.zzk.zzs(zzg2.zzt(), zzel.zzaA)) {
                builder.appendQueryParameter("app_instance_id", zzg2.zzu());
            }
            String uri = builder.build().toString();
            try {
                String zzt2 = zzg2.zzt();
                Preconditions.checkNotNull(zzt2);
                URL url = new URL(uri);
                zzaz().zzl.zzb("Fetching remote configuration", zzt2);
                zzfz zzfz = this.zzc;
                zzak(zzfz);
                zzfe zze2 = zzfz.zze(zzt2);
                zzfz zzfz2 = this.zzc;
                zzak(zzfz2);
                zzfz2.zzg();
                String str = (String) zzfz2.zzk.get(zzt2);
                if (zze2 != null) {
                    if (!TextUtils.isEmpty(str)) {
                        arrayMap2 = new ArrayMap();
                        arrayMap2.put("If-Modified-Since", str);
                    } else {
                        arrayMap2 = null;
                    }
                    zzpg.zzc();
                    if (zzg().zzs(null, zzel.zzaM)) {
                        zzfz zzfz3 = this.zzc;
                        zzak(zzfz3);
                        zzfz3.zzg();
                        String str2 = (String) zzfz3.zzl.get(zzt2);
                        if (!TextUtils.isEmpty(str2)) {
                            if (arrayMap2 == null) {
                                arrayMap2 = new ArrayMap();
                            }
                            arrayMap3 = arrayMap2;
                            arrayMap3.put(Names.IF_NONE_MATCH, str2);
                        }
                    }
                    arrayMap = arrayMap2;
                    this.zzt = true;
                    zzfe zzfe = this.zzd;
                    zzak(zzfe);
                    zzla zzla = new zzla(this);
                    zzfe.zzg();
                    zzfe.zzW();
                    Preconditions.checkNotNull(url);
                    Preconditions.checkNotNull(zzla);
                    zzgf zzaA = zzfe.zzs.zzaA();
                    zzfd zzfd = new zzfd(zzfe, zzt2, url, null, arrayMap, zzla);
                    zzaA.zzo(zzfd);
                }
                arrayMap = arrayMap3;
                this.zzt = true;
                zzfe zzfe2 = this.zzd;
                zzak(zzfe2);
                zzla zzla2 = new zzla(this);
                zzfe2.zzg();
                zzfe2.zzW();
                Preconditions.checkNotNull(url);
                Preconditions.checkNotNull(zzla2);
                zzgf zzaA2 = zzfe2.zzs.zzaA();
                zzfd zzfd2 = new zzfd(zzfe2, zzt2, url, null, arrayMap, zzla2);
                zzaA2.zzo(zzfd2);
            } catch (MalformedURLException unused) {
                zzaz().zzd.zzc("Failed to parse config URL. Not fetching. appId", zzey.zzn(zzg2.zzt()), uri);
            }
        } else {
            String zzt3 = zzg2.zzt();
            Preconditions.checkNotNull(zzt3);
            zzH(zzt3, BaseRequest.SetBuddyVariables, null, null, null);
        }
    }

    public final void zzD(zzav zzav, zzp zzp2) {
        zzav zzav2;
        List<zzab> list;
        List<zzab> list2;
        List<zzab> list3;
        zzp zzp3 = zzp2;
        Preconditions.checkNotNull(zzp2);
        Preconditions.checkNotEmpty(zzp3.zza);
        zzaA().zzg();
        zzB();
        String str = zzp3.zza;
        zzav zzav3 = zzav;
        long j = zzav3.zzd;
        zzpm.zzc();
        zziu zziu = null;
        if (zzg().zzs(null, zzel.zzat)) {
            zzez zzb2 = zzez.zzb(zzav);
            zzaA().zzg();
            if (this.zzD != null) {
                String str2 = this.zzE;
                if (str2 != null && str2.equals(str)) {
                    zziu = this.zzD;
                }
            }
            zzlp.zzK(zziu, zzb2.zzd, false);
            zzav3 = zzb2.zza();
        }
        zzak(this.zzi);
        if (zzlk.zzA(zzav3, zzp3)) {
            if (!zzp3.zzh) {
                zzd(zzp3);
                return;
            }
            List list4 = zzp3.zzt;
            if (list4 == null) {
                zzav2 = zzav3;
            } else if (list4.contains(zzav3.zza)) {
                Bundle zzc2 = zzav3.zzb.zzc();
                zzc2.putLong("ga_safelisted", 1);
                zzav2 = new zzav(zzav3.zza, new zzat(zzc2), zzav3.zzc, zzav3.zzd);
            } else {
                zzaz().zzk.zzd("Dropping non-safelisted event. appId, event name, origin", str, zzav3.zza, zzav3.zzc);
                return;
            }
            zzal zzal = this.zze;
            zzak(zzal);
            zzal.zzw();
            try {
                zzal zzal2 = this.zze;
                zzak(zzal2);
                Preconditions.checkNotEmpty(str);
                zzal2.zzg();
                zzal2.zzW();
                int i = (j > 0 ? 1 : (j == 0 ? 0 : -1));
                if (i < 0) {
                    zzal2.zzs.zzaz().zzg.zzc("Invalid time querying timed out conditional properties", zzey.zzn(str), Long.valueOf(j));
                    list = Collections.emptyList();
                } else {
                    list = zzal2.zzt("active=0 and app_id=? and abs(? - creation_timestamp) > trigger_timeout", new String[]{str, String.valueOf(j)});
                }
                for (zzab zzab : list) {
                    if (zzab != null) {
                        zzaz().zzl.zzd("User property timed out", zzab.zza, this.zzn.zzq.zzf(zzab.zzc.zzb), zzab.zzc.zza());
                        zzav zzav4 = zzab.zzg;
                        if (zzav4 != null) {
                            zzX(new zzav(zzav4, j), zzp3);
                        }
                        zzal zzal3 = this.zze;
                        zzak(zzal3);
                        zzal3.zza(str, zzab.zzc.zzb);
                    }
                }
                zzal zzal4 = this.zze;
                zzak(zzal4);
                Preconditions.checkNotEmpty(str);
                zzal4.zzg();
                zzal4.zzW();
                if (i < 0) {
                    zzal4.zzs.zzaz().zzg.zzc("Invalid time querying expired conditional properties", zzey.zzn(str), Long.valueOf(j));
                    list2 = Collections.emptyList();
                } else {
                    list2 = zzal4.zzt("active<>0 and app_id=? and abs(? - triggered_timestamp) > time_to_live", new String[]{str, String.valueOf(j)});
                }
                ArrayList arrayList = new ArrayList(list2.size());
                for (zzab zzab2 : list2) {
                    if (zzab2 != null) {
                        zzaz().zzl.zzd("User property expired", zzab2.zza, this.zzn.zzq.zzf(zzab2.zzc.zzb), zzab2.zzc.zza());
                        zzal zzal5 = this.zze;
                        zzak(zzal5);
                        zzal5.zzA(str, zzab2.zzc.zzb);
                        zzav zzav5 = zzab2.zzk;
                        if (zzav5 != null) {
                            arrayList.add(zzav5);
                        }
                        zzal zzal6 = this.zze;
                        zzak(zzal6);
                        zzal6.zza(str, zzab2.zzc.zzb);
                    }
                }
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    zzX(new zzav((zzav) it.next(), j), zzp3);
                }
                zzal zzal7 = this.zze;
                zzak(zzal7);
                String str3 = zzav2.zza;
                Preconditions.checkNotEmpty(str);
                Preconditions.checkNotEmpty(str3);
                zzal7.zzg();
                zzal7.zzW();
                if (i < 0) {
                    zzal7.zzs.zzaz().zzg.zzd("Invalid time querying triggered conditional properties", zzey.zzn(str), zzal7.zzs.zzq.zzd(str3), Long.valueOf(j));
                    list3 = Collections.emptyList();
                } else {
                    list3 = zzal7.zzt("active=0 and app_id=? and trigger_event_name=? and abs(? - creation_timestamp) <= trigger_timeout", new String[]{str, str3, String.valueOf(j)});
                }
                ArrayList arrayList2 = new ArrayList(list3.size());
                for (zzab zzab3 : list3) {
                    if (zzab3 != null) {
                        zzll zzll = zzab3.zzc;
                        String str4 = zzab3.zza;
                        Preconditions.checkNotNull(str4);
                        String str5 = zzab3.zzb;
                        String str6 = zzll.zzb;
                        Object zza2 = zzll.zza();
                        Preconditions.checkNotNull(zza2);
                        zzln zzln = new zzln(str4, str5, str6, j, zza2);
                        zzal zzal8 = this.zze;
                        zzak(zzal8);
                        if (zzal8.zzL(zzln)) {
                            zzaz().zzl.zzd("User property triggered", zzab3.zza, this.zzn.zzq.zzf(zzln.zzc), zzln.zze);
                        } else {
                            zzaz().zzd.zzd("Too many active user properties, ignoring", zzey.zzn(zzab3.zza), this.zzn.zzq.zzf(zzln.zzc), zzln.zze);
                        }
                        zzav zzav6 = zzab3.zzi;
                        if (zzav6 != null) {
                            arrayList2.add(zzav6);
                        }
                        zzab3.zzc = new zzll(zzln);
                        zzab3.zze = true;
                        zzal zzal9 = this.zze;
                        zzak(zzal9);
                        zzal9.zzK(zzab3);
                    }
                }
                zzX(zzav2, zzp3);
                Iterator it2 = arrayList2.iterator();
                while (it2.hasNext()) {
                    zzX(new zzav((zzav) it2.next(), j), zzp3);
                }
                zzal zzal10 = this.zze;
                zzak(zzal10);
                zzal10.zzC();
            } finally {
                zzal zzal11 = this.zze;
                zzak(zzal11);
                zzal11.zzx();
            }
        }
    }

    public final void zzE(zzav zzav, String str) {
        zzav zzav2 = zzav;
        String str2 = str;
        zzal zzal = this.zze;
        zzak(zzal);
        zzg zzj2 = zzal.zzj(str2);
        if (zzj2 == null || TextUtils.isEmpty(zzj2.zzw())) {
            zzaz().zzk.zzb("No app data available; dropping event", str2);
            return;
        }
        Boolean zzac = zzac(zzj2);
        if (zzac == null) {
            if (!"_ui".equals(zzav2.zza)) {
                zzaz().zzg.zzb("Could not find package. appId", zzey.zzn(str));
            }
        } else if (!zzac.booleanValue()) {
            zzaz().zzd.zzb("App version does not match; dropping event. appId", zzey.zzn(str));
            return;
        }
        String zzy2 = zzj2.zzy();
        String zzw2 = zzj2.zzw();
        long zzb2 = zzj2.zzb();
        String zzv2 = zzj2.zzv();
        long zzm2 = zzj2.zzm();
        long zzj3 = zzj2.zzj();
        boolean zzaj = zzj2.zzaj();
        zzp zzp2 = r2;
        String zzx2 = zzj2.zzx();
        long zza2 = zzj2.zza();
        boolean zzai = zzj2.zzai();
        String zzr2 = zzj2.zzr();
        zzj2.zza.zzaA().zzg();
        zzp zzp3 = new zzp(str, zzy2, zzw2, zzb2, zzv2, zzm2, zzj3, null, zzaj, false, zzx2, zza2, 0, 0, zzai, false, zzr2, zzj2.zzs, zzj2.zzk(), zzj2.zzC(), zzh(str2).zzh(), "", null);
        zzF(zzav, zzp2);
    }

    public final void zzF(zzav zzav, zzp zzp2) {
        Preconditions.checkNotEmpty(zzp2.zza);
        zzez zzb2 = zzez.zzb(zzav);
        zzlp zzv2 = zzv();
        Bundle bundle = zzb2.zzd;
        zzal zzal = this.zze;
        zzak(zzal);
        zzv2.zzL(bundle, zzal.zzi(zzp2.zza));
        zzv().zzM(zzb2, zzg().zzd(zzp2.zza));
        zzav zza2 = zzb2.zza();
        if ("_cmp".equals(zza2.zza) && "referrer API v2".equals(zza2.zzb.zza.getString("_cis"))) {
            String string = zza2.zzb.zza.getString("gclid");
            if (!TextUtils.isEmpty(string)) {
                zzll zzll = new zzll("_lgclid", zza2.zzd, string, "auto");
                zzV(zzll, zzp2);
            }
        }
        zzD(zza2, zzp2);
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0048 A[Catch:{ all -> 0x0059, all -> 0x019e }] */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x005c A[Catch:{ all -> 0x0059, all -> 0x019e }] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0107 A[Catch:{ all -> 0x0059, all -> 0x019e }] */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x012e A[Catch:{ all -> 0x0059, all -> 0x019e }] */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x0154 A[Catch:{ all -> 0x0059, all -> 0x019e }] */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x0160 A[Catch:{ all -> 0x0059, all -> 0x019e }] */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x017a A[Catch:{ all -> 0x0059, all -> 0x019e }] */
    @com.google.android.gms.common.util.VisibleForTesting
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzH(java.lang.String r9, int r10, java.lang.Throwable r11, byte[] r12, java.util.Map r13) {
        /*
            r8 = this;
            com.google.android.gms.measurement.internal.zzgf r0 = r8.zzaA()
            r0.zzg()
            r8.zzB()
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r9)
            r0 = 0
            if (r12 != 0) goto L_0x0012
            byte[] r12 = new byte[r0]     // Catch:{ all -> 0x019e }
        L_0x0012:
            com.google.android.gms.measurement.internal.zzey r1 = r8.zzaz()     // Catch:{ all -> 0x019e }
            com.google.android.gms.measurement.internal.zzew r1 = r1.zzl     // Catch:{ all -> 0x019e }
            int r2 = r12.length     // Catch:{ all -> 0x019e }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ all -> 0x019e }
            java.lang.String r3 = "onConfigFetched. Response size"
            r1.zzb(r3, r2)     // Catch:{ all -> 0x019e }
            com.google.android.gms.measurement.internal.zzal r1 = r8.zze     // Catch:{ all -> 0x019e }
            zzak(r1)     // Catch:{ all -> 0x019e }
            r1.zzw()     // Catch:{ all -> 0x019e }
            com.google.android.gms.measurement.internal.zzal r1 = r8.zze     // Catch:{ all -> 0x0059 }
            zzak(r1)     // Catch:{ all -> 0x0059 }
            com.google.android.gms.measurement.internal.zzg r1 = r1.zzj(r9)     // Catch:{ all -> 0x0059 }
            r3 = 200(0xc8, float:2.8E-43)
            r4 = 304(0x130, float:4.26E-43)
            if (r10 == r3) goto L_0x0041
            r3 = 204(0xcc, float:2.86E-43)
            if (r10 == r3) goto L_0x0041
            if (r10 != r4) goto L_0x0045
            r10 = 304(0x130, float:4.26E-43)
        L_0x0041:
            if (r11 != 0) goto L_0x0045
            r3 = 1
            goto L_0x0046
        L_0x0045:
            r3 = 0
        L_0x0046:
            if (r1 != 0) goto L_0x005c
            com.google.android.gms.measurement.internal.zzey r10 = r8.zzaz()     // Catch:{ all -> 0x0059 }
            com.google.android.gms.measurement.internal.zzew r10 = r10.zzg     // Catch:{ all -> 0x0059 }
            java.lang.String r11 = "App does not exist in onConfigFetched. appId"
            java.lang.Object r9 = com.google.android.gms.measurement.internal.zzey.zzn(r9)     // Catch:{ all -> 0x0059 }
            r10.zzb(r11, r9)     // Catch:{ all -> 0x0059 }
            goto L_0x0187
        L_0x0059:
            r9 = move-exception
            goto L_0x0195
        L_0x005c:
            r5 = 404(0x194, float:5.66E-43)
            r6 = 0
            if (r3 != 0) goto L_0x00be
            if (r10 != r5) goto L_0x0064
            goto L_0x00be
        L_0x0064:
            com.google.android.gms.common.util.Clock r12 = r8.zzaw()     // Catch:{ all -> 0x0059 }
            long r12 = r12.currentTimeMillis()     // Catch:{ all -> 0x0059 }
            r1.zzV(r12)     // Catch:{ all -> 0x0059 }
            com.google.android.gms.measurement.internal.zzal r12 = r8.zze     // Catch:{ all -> 0x0059 }
            zzak(r12)     // Catch:{ all -> 0x0059 }
            r12.zzD(r1)     // Catch:{ all -> 0x0059 }
            com.google.android.gms.measurement.internal.zzey r12 = r8.zzaz()     // Catch:{ all -> 0x0059 }
            com.google.android.gms.measurement.internal.zzew r12 = r12.zzl     // Catch:{ all -> 0x0059 }
            java.lang.String r13 = "Fetching config failed. code, error"
            java.lang.Integer r1 = java.lang.Integer.valueOf(r10)     // Catch:{ all -> 0x0059 }
            r12.zzc(r13, r1, r11)     // Catch:{ all -> 0x0059 }
            com.google.android.gms.measurement.internal.zzfz r11 = r8.zzc     // Catch:{ all -> 0x0059 }
            zzak(r11)     // Catch:{ all -> 0x0059 }
            r11.zzg()     // Catch:{ all -> 0x0059 }
            java.util.Map r11 = r11.zzk     // Catch:{ all -> 0x0059 }
            r11.put(r9, r6)     // Catch:{ all -> 0x0059 }
            com.google.android.gms.measurement.internal.zzkd r9 = r8.zzk     // Catch:{ all -> 0x0059 }
            com.google.android.gms.measurement.internal.zzfj r9 = r9.zzd     // Catch:{ all -> 0x0059 }
            com.google.android.gms.common.util.Clock r11 = r8.zzaw()     // Catch:{ all -> 0x0059 }
            long r11 = r11.currentTimeMillis()     // Catch:{ all -> 0x0059 }
            r9.zzb(r11)     // Catch:{ all -> 0x0059 }
            r9 = 503(0x1f7, float:7.05E-43)
            if (r10 == r9) goto L_0x00aa
            r9 = 429(0x1ad, float:6.01E-43)
            if (r10 != r9) goto L_0x00b9
        L_0x00aa:
            com.google.android.gms.measurement.internal.zzkd r9 = r8.zzk     // Catch:{ all -> 0x0059 }
            com.google.android.gms.measurement.internal.zzfj r9 = r9.zzb     // Catch:{ all -> 0x0059 }
            com.google.android.gms.common.util.Clock r10 = r8.zzaw()     // Catch:{ all -> 0x0059 }
            long r10 = r10.currentTimeMillis()     // Catch:{ all -> 0x0059 }
            r9.zzb(r10)     // Catch:{ all -> 0x0059 }
        L_0x00b9:
            r8.zzaf()     // Catch:{ all -> 0x0059 }
            goto L_0x0187
        L_0x00be:
            if (r13 == 0) goto L_0x00c9
            java.lang.String r11 = "Last-Modified"
            java.lang.Object r11 = r13.get(r11)     // Catch:{ all -> 0x0059 }
            java.util.List r11 = (java.util.List) r11     // Catch:{ all -> 0x0059 }
            goto L_0x00ca
        L_0x00c9:
            r11 = r6
        L_0x00ca:
            if (r11 == 0) goto L_0x00d9
            boolean r3 = r11.isEmpty()     // Catch:{ all -> 0x0059 }
            if (r3 != 0) goto L_0x00d9
            java.lang.Object r11 = r11.get(r0)     // Catch:{ all -> 0x0059 }
            java.lang.String r11 = (java.lang.String) r11     // Catch:{ all -> 0x0059 }
            goto L_0x00da
        L_0x00d9:
            r11 = r6
        L_0x00da:
            com.google.android.gms.internal.measurement.zzpg.zzc()     // Catch:{ all -> 0x0059 }
            com.google.android.gms.measurement.internal.zzaf r3 = r8.zzg()     // Catch:{ all -> 0x0059 }
            com.google.android.gms.measurement.internal.zzek r7 = com.google.android.gms.measurement.internal.zzel.zzaM     // Catch:{ all -> 0x0059 }
            boolean r3 = r3.zzs(r6, r7)     // Catch:{ all -> 0x0059 }
            if (r3 == 0) goto L_0x0104
            if (r13 == 0) goto L_0x00f4
            java.lang.String r3 = "ETag"
            java.lang.Object r13 = r13.get(r3)     // Catch:{ all -> 0x0059 }
            java.util.List r13 = (java.util.List) r13     // Catch:{ all -> 0x0059 }
            goto L_0x00f5
        L_0x00f4:
            r13 = r6
        L_0x00f5:
            if (r13 == 0) goto L_0x0104
            boolean r3 = r13.isEmpty()     // Catch:{ all -> 0x0059 }
            if (r3 != 0) goto L_0x0104
            java.lang.Object r13 = r13.get(r0)     // Catch:{ all -> 0x0059 }
            java.lang.String r13 = (java.lang.String) r13     // Catch:{ all -> 0x0059 }
            goto L_0x0105
        L_0x0104:
            r13 = r6
        L_0x0105:
            if (r10 == r5) goto L_0x0123
            if (r10 != r4) goto L_0x010a
            goto L_0x0123
        L_0x010a:
            com.google.android.gms.measurement.internal.zzfz r3 = r8.zzc     // Catch:{ all -> 0x0059 }
            zzak(r3)     // Catch:{ all -> 0x0059 }
            boolean r11 = r3.zzt(r9, r12, r11, r13)     // Catch:{ all -> 0x0059 }
            if (r11 != 0) goto L_0x013f
            com.google.android.gms.measurement.internal.zzal r9 = r8.zze     // Catch:{ all -> 0x019e }
            zzak(r9)     // Catch:{ all -> 0x019e }
        L_0x011a:
            r9.zzx()     // Catch:{ all -> 0x019e }
            r8.zzt = r0
            r8.zzad()
            return
        L_0x0123:
            com.google.android.gms.measurement.internal.zzfz r11 = r8.zzc     // Catch:{ all -> 0x0059 }
            zzak(r11)     // Catch:{ all -> 0x0059 }
            com.google.android.gms.internal.measurement.zzfe r11 = r11.zze(r9)     // Catch:{ all -> 0x0059 }
            if (r11 != 0) goto L_0x013f
            com.google.android.gms.measurement.internal.zzfz r11 = r8.zzc     // Catch:{ all -> 0x0059 }
            zzak(r11)     // Catch:{ all -> 0x0059 }
            boolean r11 = r11.zzt(r9, r6, r6, r6)     // Catch:{ all -> 0x0059 }
            if (r11 != 0) goto L_0x013f
            com.google.android.gms.measurement.internal.zzal r9 = r8.zze     // Catch:{ all -> 0x019e }
            zzak(r9)     // Catch:{ all -> 0x019e }
            goto L_0x011a
        L_0x013f:
            com.google.android.gms.common.util.Clock r11 = r8.zzaw()     // Catch:{ all -> 0x0059 }
            long r11 = r11.currentTimeMillis()     // Catch:{ all -> 0x0059 }
            r1.zzM(r11)     // Catch:{ all -> 0x0059 }
            com.google.android.gms.measurement.internal.zzal r11 = r8.zze     // Catch:{ all -> 0x0059 }
            zzak(r11)     // Catch:{ all -> 0x0059 }
            r11.zzD(r1)     // Catch:{ all -> 0x0059 }
            if (r10 != r5) goto L_0x0160
            com.google.android.gms.measurement.internal.zzey r10 = r8.zzaz()     // Catch:{ all -> 0x0059 }
            com.google.android.gms.measurement.internal.zzew r10 = r10.zzi     // Catch:{ all -> 0x0059 }
            java.lang.String r11 = "Config not found. Using empty config. appId"
            r10.zzb(r11, r9)     // Catch:{ all -> 0x0059 }
            goto L_0x016f
        L_0x0160:
            com.google.android.gms.measurement.internal.zzey r9 = r8.zzaz()     // Catch:{ all -> 0x0059 }
            com.google.android.gms.measurement.internal.zzew r9 = r9.zzl     // Catch:{ all -> 0x0059 }
            java.lang.String r11 = "Successfully fetched config. Got network response. code, size"
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)     // Catch:{ all -> 0x0059 }
            r9.zzc(r11, r10, r2)     // Catch:{ all -> 0x0059 }
        L_0x016f:
            com.google.android.gms.measurement.internal.zzfe r9 = r8.zzd     // Catch:{ all -> 0x0059 }
            zzak(r9)     // Catch:{ all -> 0x0059 }
            boolean r9 = r9.zza()     // Catch:{ all -> 0x0059 }
            if (r9 == 0) goto L_0x0184
            boolean r9 = r8.zzah()     // Catch:{ all -> 0x0059 }
            if (r9 == 0) goto L_0x0184
            r8.zzW()     // Catch:{ all -> 0x0059 }
            goto L_0x0187
        L_0x0184:
            r8.zzaf()     // Catch:{ all -> 0x0059 }
        L_0x0187:
            com.google.android.gms.measurement.internal.zzal r9 = r8.zze     // Catch:{ all -> 0x0059 }
            zzak(r9)     // Catch:{ all -> 0x0059 }
            r9.zzC()     // Catch:{ all -> 0x0059 }
            com.google.android.gms.measurement.internal.zzal r9 = r8.zze     // Catch:{ all -> 0x019e }
            zzak(r9)     // Catch:{ all -> 0x019e }
            goto L_0x011a
        L_0x0195:
            com.google.android.gms.measurement.internal.zzal r10 = r8.zze     // Catch:{ all -> 0x019e }
            zzak(r10)     // Catch:{ all -> 0x019e }
            r10.zzx()     // Catch:{ all -> 0x019e }
            throw r9     // Catch:{ all -> 0x019e }
        L_0x019e:
            r9 = move-exception
            r8.zzt = r0
            r8.zzad()
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzli.zzH(java.lang.String, int, java.lang.Throwable, byte[], java.util.Map):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:121:0x03be A[Catch:{ SQLiteException -> 0x01ca, all -> 0x054c }] */
    /* JADX WARNING: Removed duplicated region for block: B:124:0x03e7 A[Catch:{ SQLiteException -> 0x01ca, all -> 0x054c }] */
    /* JADX WARNING: Removed duplicated region for block: B:126:0x03fa A[SYNTHETIC, Splitter:B:126:0x03fa] */
    /* JADX WARNING: Removed duplicated region for block: B:164:0x04b6 A[Catch:{ SQLiteException -> 0x01ca, all -> 0x054c }] */
    /* JADX WARNING: Removed duplicated region for block: B:170:0x051c A[Catch:{ SQLiteException -> 0x01ca, all -> 0x054c }] */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x01b8 A[Catch:{ SQLiteException -> 0x01ca, all -> 0x054c }] */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x01df A[Catch:{ SQLiteException -> 0x01ca, all -> 0x054c }] */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x023e A[Catch:{ SQLiteException -> 0x01ca, all -> 0x054c }] */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x024d A[Catch:{ SQLiteException -> 0x01ca, all -> 0x054c }] */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x025d A[Catch:{ SQLiteException -> 0x01ca, all -> 0x054c }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzK(com.google.android.gms.measurement.internal.zzp r25) {
        /*
            r24 = this;
            r1 = r24
            r2 = r25
            java.lang.String r3 = "_sysu"
            java.lang.String r4 = "_sys"
            java.lang.String r5 = "com.android.vending"
            java.lang.String r6 = "_pfo"
            java.lang.String r7 = "_uwa"
            java.lang.String r0 = "app_id=?"
            com.google.android.gms.measurement.internal.zzgf r8 = r24.zzaA()
            r8.zzg()
            r24.zzB()
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r25)
            java.lang.String r8 = r2.zza
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r8)
            boolean r8 = zzaj(r25)
            if (r8 == 0) goto L_0x0556
            com.google.android.gms.measurement.internal.zzal r8 = r1.zze
            zzak(r8)
            java.lang.String r9 = r2.zza
            com.google.android.gms.measurement.internal.zzg r8 = r8.zzj(r9)
            r9 = 0
            if (r8 == 0) goto L_0x0063
            java.lang.String r11 = r8.zzy()
            boolean r11 = android.text.TextUtils.isEmpty(r11)
            if (r11 == 0) goto L_0x0063
            java.lang.String r11 = r2.zzb
            boolean r11 = android.text.TextUtils.isEmpty(r11)
            if (r11 != 0) goto L_0x0063
            r8.zzM(r9)
            com.google.android.gms.measurement.internal.zzal r11 = r1.zze
            zzak(r11)
            r11.zzD(r8)
            com.google.android.gms.measurement.internal.zzfz r8 = r1.zzc
            zzak(r8)
            java.lang.String r11 = r2.zza
            r8.zzg()
            java.util.Map r8 = r8.zzh
            r8.remove(r11)
        L_0x0063:
            boolean r8 = r2.zzh
            if (r8 != 0) goto L_0x006b
            r24.zzd(r25)
            return
        L_0x006b:
            long r11 = r2.zzm
            int r8 = (r11 > r9 ? 1 : (r11 == r9 ? 0 : -1))
            if (r8 != 0) goto L_0x0079
            com.google.android.gms.common.util.Clock r8 = r24.zzaw()
            long r11 = r8.currentTimeMillis()
        L_0x0079:
            com.google.android.gms.measurement.internal.zzgi r8 = r1.zzn
            com.google.android.gms.measurement.internal.zzap r8 = r8.zzg()
            r8.zzg()
            r15 = 0
            r8.zzd = r15
            r8.zze = r9
            int r8 = r2.zzn
            r14 = 1
            if (r8 == 0) goto L_0x00a4
            if (r8 == r14) goto L_0x00a4
            com.google.android.gms.measurement.internal.zzey r13 = r24.zzaz()
            com.google.android.gms.measurement.internal.zzew r13 = r13.zzg
            java.lang.String r15 = r2.zza
            java.lang.Object r15 = com.google.android.gms.measurement.internal.zzey.zzn(r15)
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)
            java.lang.String r9 = "Incorrect app type, assuming installed app. appId, appType"
            r13.zzc(r9, r15, r8)
            r8 = 0
        L_0x00a4:
            com.google.android.gms.measurement.internal.zzal r9 = r1.zze
            zzak(r9)
            r9.zzw()
            com.google.android.gms.measurement.internal.zzal r9 = r1.zze     // Catch:{ all -> 0x054c }
            zzak(r9)     // Catch:{ all -> 0x054c }
            java.lang.String r10 = r2.zza     // Catch:{ all -> 0x054c }
            java.lang.String r13 = "_npa"
            com.google.android.gms.measurement.internal.zzln r9 = r9.zzp(r10, r13)     // Catch:{ all -> 0x054c }
            if (r9 == 0) goto L_0x00ca
            java.lang.String r13 = "auto"
            java.lang.String r10 = r9.zzb     // Catch:{ all -> 0x054c }
            boolean r10 = r13.equals(r10)     // Catch:{ all -> 0x054c }
            if (r10 == 0) goto L_0x00c6
            goto L_0x00ca
        L_0x00c6:
            r23 = r3
            r3 = 1
            goto L_0x011a
        L_0x00ca:
            java.lang.Boolean r10 = r2.zzr     // Catch:{ all -> 0x054c }
            if (r10 == 0) goto L_0x0105
            com.google.android.gms.measurement.internal.zzll r10 = new com.google.android.gms.measurement.internal.zzll     // Catch:{ all -> 0x054c }
            java.lang.String r19 = "_npa"
            java.lang.Boolean r13 = r2.zzr     // Catch:{ all -> 0x054c }
            boolean r13 = r13.booleanValue()     // Catch:{ all -> 0x054c }
            r14 = 1
            if (r14 == r13) goto L_0x00de
            r22 = 0
            goto L_0x00e0
        L_0x00de:
            r22 = 1
        L_0x00e0:
            java.lang.Long r18 = java.lang.Long.valueOf(r22)     // Catch:{ all -> 0x054c }
            java.lang.String r22 = "auto"
            r15 = 0
            r13 = r10
            r23 = r3
            r3 = 1
            r14 = r19
            r15 = r11
            r17 = r18
            r18 = r22
            r13.<init>(r14, r15, r17, r18)     // Catch:{ all -> 0x054c }
            if (r9 == 0) goto L_0x0101
            java.lang.Object r9 = r9.zze     // Catch:{ all -> 0x054c }
            java.lang.Long r13 = r10.zzd     // Catch:{ all -> 0x054c }
            boolean r9 = r9.equals(r13)     // Catch:{ all -> 0x054c }
            if (r9 != 0) goto L_0x011a
        L_0x0101:
            r1.zzV(r10, r2)     // Catch:{ all -> 0x054c }
            goto L_0x011a
        L_0x0105:
            r23 = r3
            r3 = 1
            if (r9 == 0) goto L_0x011a
            com.google.android.gms.measurement.internal.zzll r9 = new com.google.android.gms.measurement.internal.zzll     // Catch:{ all -> 0x054c }
            java.lang.String r14 = "_npa"
            r17 = 0
            java.lang.String r18 = "auto"
            r13 = r9
            r15 = r11
            r13.<init>(r14, r15, r17, r18)     // Catch:{ all -> 0x054c }
            r1.zzO(r9, r2)     // Catch:{ all -> 0x054c }
        L_0x011a:
            com.google.android.gms.measurement.internal.zzal r9 = r1.zze     // Catch:{ all -> 0x054c }
            zzak(r9)     // Catch:{ all -> 0x054c }
            java.lang.String r10 = r2.zza     // Catch:{ all -> 0x054c }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r10)     // Catch:{ all -> 0x054c }
            java.lang.String r10 = (java.lang.String) r10     // Catch:{ all -> 0x054c }
            com.google.android.gms.measurement.internal.zzg r15 = r9.zzj(r10)     // Catch:{ all -> 0x054c }
            if (r15 == 0) goto L_0x01dd
            com.google.android.gms.measurement.internal.zzlp r9 = r24.zzv()     // Catch:{ all -> 0x054c }
            java.lang.String r10 = r2.zzb     // Catch:{ all -> 0x054c }
            java.lang.String r13 = r15.zzy()     // Catch:{ all -> 0x054c }
            java.lang.String r14 = r2.zzq     // Catch:{ all -> 0x054c }
            java.lang.String r3 = r15.zzr()     // Catch:{ all -> 0x054c }
            boolean r3 = r9.zzan(r10, r13, r14, r3)     // Catch:{ all -> 0x054c }
            if (r3 == 0) goto L_0x01dd
            com.google.android.gms.measurement.internal.zzey r3 = r24.zzaz()     // Catch:{ all -> 0x054c }
            com.google.android.gms.measurement.internal.zzew r3 = r3.zzg     // Catch:{ all -> 0x054c }
            java.lang.String r9 = "New GMP App Id passed in. Removing cached database data. appId"
            java.lang.String r10 = r15.zzt()     // Catch:{ all -> 0x054c }
            java.lang.Object r10 = com.google.android.gms.measurement.internal.zzey.zzn(r10)     // Catch:{ all -> 0x054c }
            r3.zzb(r9, r10)     // Catch:{ all -> 0x054c }
            com.google.android.gms.measurement.internal.zzal r3 = r1.zze     // Catch:{ all -> 0x054c }
            zzak(r3)     // Catch:{ all -> 0x054c }
            java.lang.String r9 = r15.zzt()     // Catch:{ all -> 0x054c }
            r3.zzW()     // Catch:{ all -> 0x054c }
            r3.zzg()     // Catch:{ all -> 0x054c }
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r9)     // Catch:{ all -> 0x054c }
            android.database.sqlite.SQLiteDatabase r10 = r3.zzh()     // Catch:{ SQLiteException -> 0x01ca }
            r13 = 1
            java.lang.String[] r14 = new java.lang.String[r13]     // Catch:{ SQLiteException -> 0x01ca }
            r13 = 0
            r14[r13] = r9     // Catch:{ SQLiteException -> 0x01ca }
            java.lang.String r15 = "events"
            int r15 = r10.delete(r15, r0, r14)     // Catch:{ SQLiteException -> 0x01ca }
            java.lang.String r13 = "user_attributes"
            int r13 = r10.delete(r13, r0, r14)     // Catch:{ SQLiteException -> 0x01ca }
            int r15 = r15 + r13
            java.lang.String r13 = "conditional_properties"
            int r13 = r10.delete(r13, r0, r14)     // Catch:{ SQLiteException -> 0x01ca }
            int r15 = r15 + r13
            java.lang.String r13 = "apps"
            int r13 = r10.delete(r13, r0, r14)     // Catch:{ SQLiteException -> 0x01ca }
            int r15 = r15 + r13
            java.lang.String r13 = "raw_events"
            int r13 = r10.delete(r13, r0, r14)     // Catch:{ SQLiteException -> 0x01ca }
            int r15 = r15 + r13
            java.lang.String r13 = "raw_events_metadata"
            int r13 = r10.delete(r13, r0, r14)     // Catch:{ SQLiteException -> 0x01ca }
            int r15 = r15 + r13
            java.lang.String r13 = "event_filters"
            int r13 = r10.delete(r13, r0, r14)     // Catch:{ SQLiteException -> 0x01ca }
            int r15 = r15 + r13
            java.lang.String r13 = "property_filters"
            int r13 = r10.delete(r13, r0, r14)     // Catch:{ SQLiteException -> 0x01ca }
            int r15 = r15 + r13
            java.lang.String r13 = "audience_filter_values"
            int r13 = r10.delete(r13, r0, r14)     // Catch:{ SQLiteException -> 0x01ca }
            int r15 = r15 + r13
            java.lang.String r13 = "consent_settings"
            int r0 = r10.delete(r13, r0, r14)     // Catch:{ SQLiteException -> 0x01ca }
            int r15 = r15 + r0
            if (r15 <= 0) goto L_0x01dc
            com.google.android.gms.measurement.internal.zzgi r0 = r3.zzs     // Catch:{ SQLiteException -> 0x01ca }
            com.google.android.gms.measurement.internal.zzey r0 = r0.zzaz()     // Catch:{ SQLiteException -> 0x01ca }
            com.google.android.gms.measurement.internal.zzew r0 = r0.zzl     // Catch:{ SQLiteException -> 0x01ca }
            java.lang.String r10 = "Deleted application data. app, records"
            java.lang.Integer r13 = java.lang.Integer.valueOf(r15)     // Catch:{ SQLiteException -> 0x01ca }
            r0.zzc(r10, r9, r13)     // Catch:{ SQLiteException -> 0x01ca }
            goto L_0x01dc
        L_0x01ca:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzgi r3 = r3.zzs     // Catch:{ all -> 0x054c }
            com.google.android.gms.measurement.internal.zzey r3 = r3.zzaz()     // Catch:{ all -> 0x054c }
            com.google.android.gms.measurement.internal.zzew r3 = r3.zzd     // Catch:{ all -> 0x054c }
            java.lang.String r10 = "Error deleting application data. appId, error"
            java.lang.Object r9 = com.google.android.gms.measurement.internal.zzey.zzn(r9)     // Catch:{ all -> 0x054c }
            r3.zzc(r10, r9, r0)     // Catch:{ all -> 0x054c }
        L_0x01dc:
            r15 = 0
        L_0x01dd:
            if (r15 == 0) goto L_0x0238
            long r9 = r15.zzb()     // Catch:{ all -> 0x054c }
            r13 = -2147483648(0xffffffff80000000, double:NaN)
            int r0 = (r9 > r13 ? 1 : (r9 == r13 ? 0 : -1))
            if (r0 == 0) goto L_0x01f6
            long r9 = r15.zzb()     // Catch:{ all -> 0x054c }
            long r13 = r2.zzj     // Catch:{ all -> 0x054c }
            int r0 = (r9 > r13 ? 1 : (r9 == r13 ? 0 : -1))
            if (r0 == 0) goto L_0x01f6
            r14 = 1
            goto L_0x01f7
        L_0x01f6:
            r14 = 0
        L_0x01f7:
            java.lang.String r0 = r15.zzw()     // Catch:{ all -> 0x054c }
            long r9 = r15.zzb()     // Catch:{ all -> 0x054c }
            r17 = -2147483648(0xffffffff80000000, double:NaN)
            int r3 = (r9 > r17 ? 1 : (r9 == r17 ? 0 : -1))
            if (r3 != 0) goto L_0x0212
            if (r0 == 0) goto L_0x0212
            java.lang.String r3 = r2.zzc     // Catch:{ all -> 0x054c }
            boolean r3 = r0.equals(r3)     // Catch:{ all -> 0x054c }
            if (r3 != 0) goto L_0x0212
            r3 = 1
            goto L_0x0213
        L_0x0212:
            r3 = 0
        L_0x0213:
            r3 = r3 | r14
            if (r3 == 0) goto L_0x0238
            android.os.Bundle r3 = new android.os.Bundle     // Catch:{ all -> 0x054c }
            r3.<init>()     // Catch:{ all -> 0x054c }
            java.lang.String r9 = "_pv"
            r3.putString(r9, r0)     // Catch:{ all -> 0x054c }
            com.google.android.gms.measurement.internal.zzav r0 = new com.google.android.gms.measurement.internal.zzav     // Catch:{ all -> 0x054c }
            com.google.android.gms.measurement.internal.zzat r15 = new com.google.android.gms.measurement.internal.zzat     // Catch:{ all -> 0x054c }
            r15.<init>(r3)     // Catch:{ all -> 0x054c }
            java.lang.String r14 = "_au"
            java.lang.String r3 = "auto"
            r9 = 0
            r13 = r0
            r16 = r3
            r17 = r11
            r13.<init>(r14, r15, r16, r17)     // Catch:{ all -> 0x054c }
            r1.zzD(r0, r2)     // Catch:{ all -> 0x054c }
            goto L_0x0239
        L_0x0238:
            r9 = 0
        L_0x0239:
            r24.zzd(r25)     // Catch:{ all -> 0x054c }
            if (r8 != 0) goto L_0x024d
            com.google.android.gms.measurement.internal.zzal r0 = r1.zze     // Catch:{ all -> 0x054c }
            zzak(r0)     // Catch:{ all -> 0x054c }
            java.lang.String r3 = r2.zza     // Catch:{ all -> 0x054c }
            java.lang.String r8 = "_f"
            com.google.android.gms.measurement.internal.zzar r0 = r0.zzn(r3, r8)     // Catch:{ all -> 0x054c }
            r14 = 0
            goto L_0x025b
        L_0x024d:
            com.google.android.gms.measurement.internal.zzal r0 = r1.zze     // Catch:{ all -> 0x054c }
            zzak(r0)     // Catch:{ all -> 0x054c }
            java.lang.String r3 = r2.zza     // Catch:{ all -> 0x054c }
            java.lang.String r8 = "_v"
            com.google.android.gms.measurement.internal.zzar r0 = r0.zzn(r3, r8)     // Catch:{ all -> 0x054c }
            r14 = 1
        L_0x025b:
            if (r0 != 0) goto L_0x051c
            r15 = 3600000(0x36ee80, double:1.7786363E-317)
            long r17 = r11 / r15
            r9 = 1
            long r17 = r17 + r9
            long r17 = r17 * r15
            java.lang.String r3 = "_dac"
            java.lang.String r8 = "_et"
            java.lang.String r15 = "_r"
            java.lang.String r13 = "_c"
            if (r14 != 0) goto L_0x04cf
            com.google.android.gms.measurement.internal.zzll r0 = new com.google.android.gms.measurement.internal.zzll     // Catch:{ all -> 0x054c }
            java.lang.String r14 = "_fot"
            java.lang.Long r17 = java.lang.Long.valueOf(r17)     // Catch:{ all -> 0x054c }
            java.lang.String r18 = "auto"
            r9 = r13
            r13 = r0
            r10 = r15
            r15 = r11
            r13.<init>(r14, r15, r17, r18)     // Catch:{ all -> 0x054c }
            r1.zzV(r0, r2)     // Catch:{ all -> 0x054c }
            com.google.android.gms.measurement.internal.zzgf r0 = r24.zzaA()     // Catch:{ all -> 0x054c }
            r0.zzg()     // Catch:{ all -> 0x054c }
            com.google.android.gms.measurement.internal.zzfq r0 = r1.zzm     // Catch:{ all -> 0x054c }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r0)     // Catch:{ all -> 0x054c }
            r13 = r0
            com.google.android.gms.measurement.internal.zzfq r13 = (com.google.android.gms.measurement.internal.zzfq) r13     // Catch:{ all -> 0x054c }
            java.lang.String r0 = r2.zza     // Catch:{ all -> 0x054c }
            if (r0 == 0) goto L_0x037f
            boolean r14 = r0.isEmpty()     // Catch:{ all -> 0x054c }
            if (r14 == 0) goto L_0x02a1
            goto L_0x037f
        L_0x02a1:
            com.google.android.gms.measurement.internal.zzgi r14 = r13.zza     // Catch:{ all -> 0x054c }
            com.google.android.gms.measurement.internal.zzgf r14 = r14.zzaA()     // Catch:{ all -> 0x054c }
            r14.zzg()     // Catch:{ all -> 0x054c }
            boolean r14 = r13.zza()     // Catch:{ all -> 0x054c }
            if (r14 != 0) goto L_0x02c1
            com.google.android.gms.measurement.internal.zzgi r0 = r13.zza     // Catch:{ all -> 0x054c }
            com.google.android.gms.measurement.internal.zzey r0 = r0.zzaz()     // Catch:{ all -> 0x054c }
            com.google.android.gms.measurement.internal.zzew r0 = r0.zzj     // Catch:{ all -> 0x054c }
            java.lang.String r5 = "Install Referrer Reporter is not available"
            r0.zza(r5)     // Catch:{ all -> 0x054c }
            r20 = r11
            goto L_0x038e
        L_0x02c1:
            com.google.android.gms.measurement.internal.zzfp r14 = new com.google.android.gms.measurement.internal.zzfp     // Catch:{ all -> 0x054c }
            r14.<init>(r13, r0)     // Catch:{ all -> 0x054c }
            com.google.android.gms.measurement.internal.zzgi r0 = r13.zza     // Catch:{ all -> 0x054c }
            com.google.android.gms.measurement.internal.zzgf r0 = r0.zzaA()     // Catch:{ all -> 0x054c }
            r0.zzg()     // Catch:{ all -> 0x054c }
            android.content.Intent r0 = new android.content.Intent     // Catch:{ all -> 0x054c }
            java.lang.String r15 = "com.google.android.finsky.BIND_GET_INSTALL_REFERRER_SERVICE"
            r0.<init>(r15)     // Catch:{ all -> 0x054c }
            android.content.ComponentName r15 = new android.content.ComponentName     // Catch:{ all -> 0x054c }
            r20 = r11
            java.lang.String r11 = "com.google.android.finsky.externalreferrer.GetInstallReferrerService"
            r15.<init>(r5, r11)     // Catch:{ all -> 0x054c }
            r0.setComponent(r15)     // Catch:{ all -> 0x054c }
            com.google.android.gms.measurement.internal.zzgi r11 = r13.zza     // Catch:{ all -> 0x054c }
            android.content.Context r11 = r11.zze     // Catch:{ all -> 0x054c }
            android.content.pm.PackageManager r11 = r11.getPackageManager()     // Catch:{ all -> 0x054c }
            if (r11 != 0) goto L_0x02fb
            com.google.android.gms.measurement.internal.zzgi r0 = r13.zza     // Catch:{ all -> 0x054c }
            com.google.android.gms.measurement.internal.zzey r0 = r0.zzaz()     // Catch:{ all -> 0x054c }
            com.google.android.gms.measurement.internal.zzew r0 = r0.zzh     // Catch:{ all -> 0x054c }
            java.lang.String r5 = "Failed to obtain Package Manager to verify binding conditions for Install Referrer"
            r0.zza(r5)     // Catch:{ all -> 0x054c }
            goto L_0x038e
        L_0x02fb:
            r12 = 0
            java.util.List r11 = r11.queryIntentServices(r0, r12)     // Catch:{ all -> 0x054c }
            if (r11 == 0) goto L_0x0371
            boolean r15 = r11.isEmpty()     // Catch:{ all -> 0x054c }
            if (r15 != 0) goto L_0x0371
            java.lang.Object r11 = r11.get(r12)     // Catch:{ all -> 0x054c }
            android.content.pm.ResolveInfo r11 = (android.content.pm.ResolveInfo) r11     // Catch:{ all -> 0x054c }
            android.content.pm.ServiceInfo r12 = r11.serviceInfo     // Catch:{ all -> 0x054c }
            if (r12 == 0) goto L_0x038e
            android.content.pm.ServiceInfo r12 = r11.serviceInfo     // Catch:{ all -> 0x054c }
            java.lang.String r12 = r12.packageName     // Catch:{ all -> 0x054c }
            android.content.pm.ServiceInfo r11 = r11.serviceInfo     // Catch:{ all -> 0x054c }
            java.lang.String r11 = r11.name     // Catch:{ all -> 0x054c }
            if (r11 == 0) goto L_0x0363
            boolean r5 = r5.equals(r12)     // Catch:{ all -> 0x054c }
            if (r5 == 0) goto L_0x0363
            boolean r5 = r13.zza()     // Catch:{ all -> 0x054c }
            if (r5 == 0) goto L_0x0363
            android.content.Intent r5 = new android.content.Intent     // Catch:{ all -> 0x054c }
            r5.<init>(r0)     // Catch:{ all -> 0x054c }
            com.google.android.gms.common.stats.ConnectionTracker r0 = com.google.android.gms.common.stats.ConnectionTracker.getInstance()     // Catch:{ RuntimeException -> 0x0350 }
            com.google.android.gms.measurement.internal.zzgi r11 = r13.zza     // Catch:{ RuntimeException -> 0x0350 }
            android.content.Context r11 = r11.zze     // Catch:{ RuntimeException -> 0x0350 }
            r12 = 1
            boolean r0 = r0.bindService(r11, r5, r14, r12)     // Catch:{ RuntimeException -> 0x0350 }
            com.google.android.gms.measurement.internal.zzgi r5 = r13.zza     // Catch:{ RuntimeException -> 0x0350 }
            com.google.android.gms.measurement.internal.zzey r5 = r5.zzaz()     // Catch:{ RuntimeException -> 0x0350 }
            com.google.android.gms.measurement.internal.zzew r5 = r5.zzl     // Catch:{ RuntimeException -> 0x0350 }
            java.lang.String r11 = "Install Referrer Service is"
            java.lang.String r12 = "available"
            java.lang.String r14 = "not available"
            r15 = 1
            if (r15 == r0) goto L_0x034c
            r12 = r14
        L_0x034c:
            r5.zzb(r11, r12)     // Catch:{ RuntimeException -> 0x0350 }
            goto L_0x038e
        L_0x0350:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzgi r5 = r13.zza     // Catch:{ all -> 0x054c }
            com.google.android.gms.measurement.internal.zzey r5 = r5.zzaz()     // Catch:{ all -> 0x054c }
            com.google.android.gms.measurement.internal.zzew r5 = r5.zzd     // Catch:{ all -> 0x054c }
            java.lang.String r11 = "Exception occurred while binding to Install Referrer Service"
            java.lang.String r0 = r0.getMessage()     // Catch:{ all -> 0x054c }
            r5.zzb(r11, r0)     // Catch:{ all -> 0x054c }
            goto L_0x038e
        L_0x0363:
            com.google.android.gms.measurement.internal.zzgi r0 = r13.zza     // Catch:{ all -> 0x054c }
            com.google.android.gms.measurement.internal.zzey r0 = r0.zzaz()     // Catch:{ all -> 0x054c }
            com.google.android.gms.measurement.internal.zzew r0 = r0.zzg     // Catch:{ all -> 0x054c }
            java.lang.String r5 = "Play Store version 8.3.73 or higher required for Install Referrer"
            r0.zza(r5)     // Catch:{ all -> 0x054c }
            goto L_0x038e
        L_0x0371:
            com.google.android.gms.measurement.internal.zzgi r0 = r13.zza     // Catch:{ all -> 0x054c }
            com.google.android.gms.measurement.internal.zzey r0 = r0.zzaz()     // Catch:{ all -> 0x054c }
            com.google.android.gms.measurement.internal.zzew r0 = r0.zzj     // Catch:{ all -> 0x054c }
            java.lang.String r5 = "Play Service for fetching Install Referrer is unavailable on device"
            r0.zza(r5)     // Catch:{ all -> 0x054c }
            goto L_0x038e
        L_0x037f:
            r20 = r11
            com.google.android.gms.measurement.internal.zzgi r0 = r13.zza     // Catch:{ all -> 0x054c }
            com.google.android.gms.measurement.internal.zzey r0 = r0.zzaz()     // Catch:{ all -> 0x054c }
            com.google.android.gms.measurement.internal.zzew r0 = r0.zzh     // Catch:{ all -> 0x054c }
            java.lang.String r5 = "Install Referrer Reporter was called with invalid app package name"
            r0.zza(r5)     // Catch:{ all -> 0x054c }
        L_0x038e:
            com.google.android.gms.measurement.internal.zzgf r0 = r24.zzaA()     // Catch:{ all -> 0x054c }
            r0.zzg()     // Catch:{ all -> 0x054c }
            r24.zzB()     // Catch:{ all -> 0x054c }
            android.os.Bundle r5 = new android.os.Bundle     // Catch:{ all -> 0x054c }
            r5.<init>()     // Catch:{ all -> 0x054c }
            r11 = 1
            r5.putLong(r9, r11)     // Catch:{ all -> 0x054c }
            r5.putLong(r10, r11)     // Catch:{ all -> 0x054c }
            r9 = 0
            r5.putLong(r7, r9)     // Catch:{ all -> 0x054c }
            r5.putLong(r6, r9)     // Catch:{ all -> 0x054c }
            r5.putLong(r4, r9)     // Catch:{ all -> 0x054c }
            r11 = r23
            r5.putLong(r11, r9)     // Catch:{ all -> 0x054c }
            r9 = 1
            r5.putLong(r8, r9)     // Catch:{ all -> 0x054c }
            boolean r0 = r2.zzp     // Catch:{ all -> 0x054c }
            if (r0 == 0) goto L_0x03c1
            r5.putLong(r3, r9)     // Catch:{ all -> 0x054c }
        L_0x03c1:
            java.lang.String r0 = r2.zza     // Catch:{ all -> 0x054c }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r0)     // Catch:{ all -> 0x054c }
            r3 = r0
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ all -> 0x054c }
            com.google.android.gms.measurement.internal.zzal r0 = r1.zze     // Catch:{ all -> 0x054c }
            zzak(r0)     // Catch:{ all -> 0x054c }
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r3)     // Catch:{ all -> 0x054c }
            r0.zzg()     // Catch:{ all -> 0x054c }
            r0.zzW()     // Catch:{ all -> 0x054c }
            java.lang.String r8 = "first_open_count"
            long r9 = r0.zzc(r3, r8)     // Catch:{ all -> 0x054c }
            com.google.android.gms.measurement.internal.zzgi r0 = r1.zzn     // Catch:{ all -> 0x054c }
            android.content.Context r0 = r0.zze     // Catch:{ all -> 0x054c }
            android.content.pm.PackageManager r0 = r0.getPackageManager()     // Catch:{ all -> 0x054c }
            if (r0 != 0) goto L_0x03fa
            com.google.android.gms.measurement.internal.zzey r0 = r24.zzaz()     // Catch:{ all -> 0x054c }
            com.google.android.gms.measurement.internal.zzew r0 = r0.zzd     // Catch:{ all -> 0x054c }
            java.lang.String r4 = "PackageManager is null, first open report might be inaccurate. appId"
            java.lang.Object r3 = com.google.android.gms.measurement.internal.zzey.zzn(r3)     // Catch:{ all -> 0x054c }
            r0.zzb(r4, r3)     // Catch:{ all -> 0x054c }
        L_0x03f6:
            r3 = 0
            goto L_0x04b2
        L_0x03fa:
            com.google.android.gms.measurement.internal.zzgi r0 = r1.zzn     // Catch:{ NameNotFoundException -> 0x040e }
            android.content.Context r0 = r0.zze     // Catch:{ NameNotFoundException -> 0x040e }
            com.google.android.gms.common.wrappers.PackageManagerWrapper r0 = com.google.android.gms.common.wrappers.Wrappers.packageManager(r0)     // Catch:{ NameNotFoundException -> 0x040e }
            android.content.Context r0 = r0.zza     // Catch:{ NameNotFoundException -> 0x040e }
            android.content.pm.PackageManager r0 = r0.getPackageManager()     // Catch:{ NameNotFoundException -> 0x040e }
            r8 = 0
            android.content.pm.PackageInfo r15 = r0.getPackageInfo(r3, r8)     // Catch:{ NameNotFoundException -> 0x040e }
            goto L_0x041f
        L_0x040e:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzey r8 = r24.zzaz()     // Catch:{ all -> 0x054c }
            com.google.android.gms.measurement.internal.zzew r8 = r8.zzd     // Catch:{ all -> 0x054c }
            java.lang.String r12 = "Package info is null, first open report might be inaccurate. appId"
            java.lang.Object r13 = com.google.android.gms.measurement.internal.zzey.zzn(r3)     // Catch:{ all -> 0x054c }
            r8.zzc(r12, r13, r0)     // Catch:{ all -> 0x054c }
            r15 = 0
        L_0x041f:
            if (r15 == 0) goto L_0x0472
            long r12 = r15.firstInstallTime     // Catch:{ all -> 0x054c }
            r16 = 0
            int r0 = (r12 > r16 ? 1 : (r12 == r16 ? 0 : -1))
            if (r0 == 0) goto L_0x0472
            long r12 = r15.firstInstallTime     // Catch:{ all -> 0x054c }
            long r14 = r15.lastUpdateTime     // Catch:{ all -> 0x054c }
            int r0 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1))
            if (r0 == 0) goto L_0x0453
            com.google.android.gms.measurement.internal.zzaf r0 = r24.zzg()     // Catch:{ all -> 0x054c }
            com.google.android.gms.measurement.internal.zzek r8 = com.google.android.gms.measurement.internal.zzel.zzac     // Catch:{ all -> 0x054c }
            r12 = 0
            boolean r0 = r0.zzs(r12, r8)     // Catch:{ all -> 0x054c }
            if (r0 == 0) goto L_0x044d
            r13 = 0
            int r0 = (r9 > r13 ? 1 : (r9 == r13 ? 0 : -1))
            if (r0 != 0) goto L_0x044b
            r13 = 1
            r5.putLong(r7, r13)     // Catch:{ all -> 0x054c }
            r9 = 0
        L_0x044b:
            r14 = 0
            goto L_0x0455
        L_0x044d:
            r13 = 1
            r5.putLong(r7, r13)     // Catch:{ all -> 0x054c }
            goto L_0x044b
        L_0x0453:
            r12 = 0
            r14 = 1
        L_0x0455:
            com.google.android.gms.measurement.internal.zzll r0 = new com.google.android.gms.measurement.internal.zzll     // Catch:{ all -> 0x054c }
            java.lang.String r7 = "_fi"
            r8 = 1
            if (r8 == r14) goto L_0x045f
            r14 = 0
            goto L_0x0461
        L_0x045f:
            r14 = 1
        L_0x0461:
            java.lang.Long r17 = java.lang.Long.valueOf(r14)     // Catch:{ all -> 0x054c }
            java.lang.String r18 = "auto"
            r13 = r0
            r14 = r7
            r15 = r20
            r13.<init>(r14, r15, r17, r18)     // Catch:{ all -> 0x054c }
            r1.zzV(r0, r2)     // Catch:{ all -> 0x054c }
            goto L_0x0473
        L_0x0472:
            r12 = 0
        L_0x0473:
            com.google.android.gms.measurement.internal.zzgi r0 = r1.zzn     // Catch:{ NameNotFoundException -> 0x0487 }
            android.content.Context r0 = r0.zze     // Catch:{ NameNotFoundException -> 0x0487 }
            com.google.android.gms.common.wrappers.PackageManagerWrapper r0 = com.google.android.gms.common.wrappers.Wrappers.packageManager(r0)     // Catch:{ NameNotFoundException -> 0x0487 }
            android.content.Context r0 = r0.zza     // Catch:{ NameNotFoundException -> 0x0487 }
            android.content.pm.PackageManager r0 = r0.getPackageManager()     // Catch:{ NameNotFoundException -> 0x0487 }
            r7 = 0
            android.content.pm.ApplicationInfo r15 = r0.getApplicationInfo(r3, r7)     // Catch:{ NameNotFoundException -> 0x0487 }
            goto L_0x0498
        L_0x0487:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzey r7 = r24.zzaz()     // Catch:{ all -> 0x054c }
            com.google.android.gms.measurement.internal.zzew r7 = r7.zzd     // Catch:{ all -> 0x054c }
            java.lang.String r8 = "Application info is null, first open report might be inaccurate. appId"
            java.lang.Object r3 = com.google.android.gms.measurement.internal.zzey.zzn(r3)     // Catch:{ all -> 0x054c }
            r7.zzc(r8, r3, r0)     // Catch:{ all -> 0x054c }
            r15 = r12
        L_0x0498:
            if (r15 == 0) goto L_0x03f6
            int r0 = r15.flags     // Catch:{ all -> 0x054c }
            r3 = 1
            r0 = r0 & r3
            if (r0 == 0) goto L_0x04a5
            r7 = 1
            r5.putLong(r4, r7)     // Catch:{ all -> 0x054c }
        L_0x04a5:
            int r0 = r15.flags     // Catch:{ all -> 0x054c }
            r0 = r0 & 128(0x80, float:1.8E-43)
            if (r0 == 0) goto L_0x03f6
            r3 = 1
            r5.putLong(r11, r3)     // Catch:{ all -> 0x054c }
            goto L_0x03f6
        L_0x04b2:
            int r0 = (r9 > r3 ? 1 : (r9 == r3 ? 0 : -1))
            if (r0 < 0) goto L_0x04b9
            r5.putLong(r6, r9)     // Catch:{ all -> 0x054c }
        L_0x04b9:
            com.google.android.gms.measurement.internal.zzav r0 = new com.google.android.gms.measurement.internal.zzav     // Catch:{ all -> 0x054c }
            com.google.android.gms.measurement.internal.zzat r15 = new com.google.android.gms.measurement.internal.zzat     // Catch:{ all -> 0x054c }
            r15.<init>(r5)     // Catch:{ all -> 0x054c }
            java.lang.String r14 = "_f"
            java.lang.String r16 = "auto"
            r13 = r0
            r17 = r20
            r13.<init>(r14, r15, r16, r17)     // Catch:{ all -> 0x054c }
            r1.zzF(r0, r2)     // Catch:{ all -> 0x054c }
            goto L_0x053b
        L_0x04cf:
            r20 = r11
            r9 = r13
            r10 = r15
            com.google.android.gms.measurement.internal.zzll r0 = new com.google.android.gms.measurement.internal.zzll     // Catch:{ all -> 0x054c }
            java.lang.String r14 = "_fvt"
            java.lang.Long r17 = java.lang.Long.valueOf(r17)     // Catch:{ all -> 0x054c }
            java.lang.String r18 = "auto"
            r13 = r0
            r15 = r20
            r13.<init>(r14, r15, r17, r18)     // Catch:{ all -> 0x054c }
            r1.zzV(r0, r2)     // Catch:{ all -> 0x054c }
            com.google.android.gms.measurement.internal.zzgf r0 = r24.zzaA()     // Catch:{ all -> 0x054c }
            r0.zzg()     // Catch:{ all -> 0x054c }
            r24.zzB()     // Catch:{ all -> 0x054c }
            android.os.Bundle r0 = new android.os.Bundle     // Catch:{ all -> 0x054c }
            r0.<init>()     // Catch:{ all -> 0x054c }
            r4 = 1
            r0.putLong(r9, r4)     // Catch:{ all -> 0x054c }
            r0.putLong(r10, r4)     // Catch:{ all -> 0x054c }
            r0.putLong(r8, r4)     // Catch:{ all -> 0x054c }
            boolean r6 = r2.zzp     // Catch:{ all -> 0x054c }
            if (r6 == 0) goto L_0x0507
            r0.putLong(r3, r4)     // Catch:{ all -> 0x054c }
        L_0x0507:
            com.google.android.gms.measurement.internal.zzav r3 = new com.google.android.gms.measurement.internal.zzav     // Catch:{ all -> 0x054c }
            com.google.android.gms.measurement.internal.zzat r15 = new com.google.android.gms.measurement.internal.zzat     // Catch:{ all -> 0x054c }
            r15.<init>(r0)     // Catch:{ all -> 0x054c }
            java.lang.String r14 = "_v"
            java.lang.String r16 = "auto"
            r13 = r3
            r17 = r20
            r13.<init>(r14, r15, r16, r17)     // Catch:{ all -> 0x054c }
            r1.zzF(r3, r2)     // Catch:{ all -> 0x054c }
            goto L_0x053b
        L_0x051c:
            r20 = r11
            boolean r0 = r2.zzi     // Catch:{ all -> 0x054c }
            if (r0 == 0) goto L_0x053b
            android.os.Bundle r0 = new android.os.Bundle     // Catch:{ all -> 0x054c }
            r0.<init>()     // Catch:{ all -> 0x054c }
            com.google.android.gms.measurement.internal.zzav r3 = new com.google.android.gms.measurement.internal.zzav     // Catch:{ all -> 0x054c }
            com.google.android.gms.measurement.internal.zzat r15 = new com.google.android.gms.measurement.internal.zzat     // Catch:{ all -> 0x054c }
            r15.<init>(r0)     // Catch:{ all -> 0x054c }
            java.lang.String r14 = "_cd"
            java.lang.String r16 = "auto"
            r13 = r3
            r17 = r20
            r13.<init>(r14, r15, r16, r17)     // Catch:{ all -> 0x054c }
            r1.zzF(r3, r2)     // Catch:{ all -> 0x054c }
        L_0x053b:
            com.google.android.gms.measurement.internal.zzal r0 = r1.zze     // Catch:{ all -> 0x054c }
            zzak(r0)     // Catch:{ all -> 0x054c }
            r0.zzC()     // Catch:{ all -> 0x054c }
            com.google.android.gms.measurement.internal.zzal r0 = r1.zze
            zzak(r0)
            r0.zzx()
            return
        L_0x054c:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzal r2 = r1.zze
            zzak(r2)
            r2.zzx()
            throw r0
        L_0x0556:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzli.zzK(com.google.android.gms.measurement.internal.zzp):void");
    }

    public final void zzN(zzab zzab, zzp zzp2) {
        Preconditions.checkNotNull(zzab);
        Preconditions.checkNotEmpty(zzab.zza);
        Preconditions.checkNotNull(zzab.zzc);
        Preconditions.checkNotEmpty(zzab.zzc.zzb);
        zzaA().zzg();
        zzB();
        if (zzaj(zzp2)) {
            if (zzp2.zzh) {
                zzal zzal = this.zze;
                zzak(zzal);
                zzal.zzw();
                try {
                    zzd(zzp2);
                    String str = zzab.zza;
                    Preconditions.checkNotNull(str);
                    String str2 = str;
                    zzal zzal2 = this.zze;
                    zzak(zzal2);
                    zzab zzk2 = zzal2.zzk(str2, zzab.zzc.zzb);
                    if (zzk2 != null) {
                        zzaz().zzk.zzc("Removing conditional user property", zzab.zza, this.zzn.zzq.zzf(zzab.zzc.zzb));
                        zzal zzal3 = this.zze;
                        zzak(zzal3);
                        zzal3.zza(str2, zzab.zzc.zzb);
                        if (zzk2.zze) {
                            zzal zzal4 = this.zze;
                            zzak(zzal4);
                            zzal4.zzA(str2, zzab.zzc.zzb);
                        }
                        zzav zzav = zzab.zzk;
                        if (zzav != null) {
                            zzat zzat = zzav.zzb;
                            Bundle zzc2 = zzat != null ? zzat.zzc() : null;
                            zzlp zzv2 = zzv();
                            zzav zzav2 = zzab.zzk;
                            Preconditions.checkNotNull(zzav2);
                            zzav zzz2 = zzv2.zzz(str2, zzav2.zza, zzc2, zzk2.zzb, zzab.zzk.zzd, true, true);
                            Preconditions.checkNotNull(zzz2);
                            zzX(zzz2, zzp2);
                        }
                    } else {
                        zzaz().zzg.zzc("Conditional user property doesn't exist", zzey.zzn(zzab.zza), this.zzn.zzq.zzf(zzab.zzc.zzb));
                    }
                    zzal zzal5 = this.zze;
                    zzak(zzal5);
                    zzal5.zzC();
                } finally {
                    zzal zzal6 = this.zze;
                    zzak(zzal6);
                    zzal6.zzx();
                }
            } else {
                zzd(zzp2);
            }
        }
    }

    public final void zzO(zzll zzll, zzp zzp2) {
        zzaA().zzg();
        zzB();
        if (zzaj(zzp2)) {
            if (!zzp2.zzh) {
                zzd(zzp2);
            } else if (!"_npa".equals(zzll.zzb) || zzp2.zzr == null) {
                zzaz().zzk.zzb("Removing user property", this.zzn.zzq.zzf(zzll.zzb));
                zzal zzal = this.zze;
                zzak(zzal);
                zzal.zzw();
                try {
                    zzd(zzp2);
                    zzne.zzc();
                    if (this.zzn.zzk.zzs(null, zzel.zzan) && this.zzn.zzk.zzs(null, zzel.zzap) && "_id".equals(zzll.zzb)) {
                        zzal zzal2 = this.zze;
                        zzak(zzal2);
                        String str = zzp2.zza;
                        Preconditions.checkNotNull(str);
                        zzal2.zzA(str, "_lair");
                    }
                    zzal zzal3 = this.zze;
                    zzak(zzal3);
                    String str2 = zzp2.zza;
                    Preconditions.checkNotNull(str2);
                    zzal3.zzA(str2, zzll.zzb);
                    zzal zzal4 = this.zze;
                    zzak(zzal4);
                    zzal4.zzC();
                    zzaz().zzk.zzb("User property removed", this.zzn.zzq.zzf(zzll.zzb));
                } finally {
                    zzal zzal5 = this.zze;
                    zzak(zzal5);
                    zzal5.zzx();
                }
            } else {
                zzaz().zzk.zza("Falling back to manifest metadata value for ad personalization");
                zzll zzll2 = new zzll("_npa", zzaw().currentTimeMillis(), Long.valueOf(true != zzp2.zzr.booleanValue() ? 0 : 1), "auto");
                zzV(zzll2, zzp2);
            }
        }
    }

    @VisibleForTesting
    public final void zzP(zzp zzp2) {
        if (this.zzy != null) {
            ArrayList arrayList = new ArrayList();
            this.zzz = arrayList;
            arrayList.addAll(this.zzy);
        }
        zzal zzal = this.zze;
        zzak(zzal);
        String str = zzp2.zza;
        Preconditions.checkNotNull(str);
        String str2 = str;
        Preconditions.checkNotEmpty(str2);
        zzal.zzg();
        zzal.zzW();
        try {
            SQLiteDatabase zzh2 = zzal.zzh();
            String[] strArr = {str2};
            int delete = zzh2.delete("apps", "app_id=?", strArr) + zzh2.delete("events", "app_id=?", strArr) + zzh2.delete("user_attributes", "app_id=?", strArr) + zzh2.delete("conditional_properties", "app_id=?", strArr) + zzh2.delete("raw_events", "app_id=?", strArr) + zzh2.delete("raw_events_metadata", "app_id=?", strArr) + zzh2.delete("queue", "app_id=?", strArr) + zzh2.delete("audience_filter_values", "app_id=?", strArr) + zzh2.delete("main_event_params", "app_id=?", strArr) + zzh2.delete("default_event_params", "app_id=?", strArr);
            if (delete > 0) {
                zzal.zzs.zzaz().zzl.zzc("Reset analytics data. app, records", str2, Integer.valueOf(delete));
            }
        } catch (SQLiteException e2) {
            zzal.zzs.zzaz().zzd.zzc("Error resetting analytics data. appId, error", zzey.zzn(str2), e2);
        }
        if (zzp2.zzh) {
            zzK(zzp2);
        }
    }

    public final void zzQ(String str, zziu zziu) {
        zzaA().zzg();
        String str2 = this.zzE;
        if (str2 == null || str2.equals(str) || zziu != null) {
            this.zzE = str;
            this.zzD = zziu;
        }
    }

    public final void zzT(zzab zzab, zzp zzp2) {
        Preconditions.checkNotNull(zzab);
        Preconditions.checkNotEmpty(zzab.zza);
        Preconditions.checkNotNull(zzab.zzb);
        Preconditions.checkNotNull(zzab.zzc);
        Preconditions.checkNotEmpty(zzab.zzc.zzb);
        zzaA().zzg();
        zzB();
        if (zzaj(zzp2)) {
            if (!zzp2.zzh) {
                zzd(zzp2);
                return;
            }
            zzab zzab2 = new zzab(zzab);
            boolean z = false;
            zzab2.zze = false;
            zzal zzal = this.zze;
            zzak(zzal);
            zzal.zzw();
            try {
                zzal zzal2 = this.zze;
                zzak(zzal2);
                String str = zzab2.zza;
                Preconditions.checkNotNull(str);
                zzab zzk2 = zzal2.zzk(str, zzab2.zzc.zzb);
                if (zzk2 != null && !zzk2.zzb.equals(zzab2.zzb)) {
                    zzaz().zzg.zzd("Updating a conditional user property with different origin. name, origin, origin (from DB)", this.zzn.zzq.zzf(zzab2.zzc.zzb), zzab2.zzb, zzk2.zzb);
                }
                if (zzk2 != null && zzk2.zze) {
                    zzab2.zzb = zzk2.zzb;
                    zzab2.zzd = zzk2.zzd;
                    zzab2.zzh = zzk2.zzh;
                    zzab2.zzf = zzk2.zzf;
                    zzab2.zzi = zzk2.zzi;
                    zzab2.zze = true;
                    zzll zzll = zzab2.zzc;
                    zzll zzll2 = new zzll(zzll.zzb, zzk2.zzc.zzc, zzll.zza(), zzk2.zzc.zzf);
                    zzab2.zzc = zzll2;
                } else if (TextUtils.isEmpty(zzab2.zzf)) {
                    zzll zzll3 = zzab2.zzc;
                    zzll zzll4 = new zzll(zzll3.zzb, zzab2.zzd, zzll3.zza(), zzab2.zzc.zzf);
                    zzab2.zzc = zzll4;
                    zzab2.zze = true;
                    z = true;
                }
                if (zzab2.zze) {
                    zzll zzll5 = zzab2.zzc;
                    String str2 = zzab2.zza;
                    Preconditions.checkNotNull(str2);
                    String str3 = zzab2.zzb;
                    String str4 = zzll5.zzb;
                    long j = zzll5.zzc;
                    Object zza2 = zzll5.zza();
                    Preconditions.checkNotNull(zza2);
                    zzln zzln = new zzln(str2, str3, str4, j, zza2);
                    zzal zzal3 = this.zze;
                    zzak(zzal3);
                    if (zzal3.zzL(zzln)) {
                        zzaz().zzk.zzd("User property updated immediately", zzab2.zza, this.zzn.zzq.zzf(zzln.zzc), zzln.zze);
                    } else {
                        zzaz().zzd.zzd("(2)Too many active user properties, ignoring", zzey.zzn(zzab2.zza), this.zzn.zzq.zzf(zzln.zzc), zzln.zze);
                    }
                    if (z && zzab2.zzi != null) {
                        zzX(new zzav(zzab2.zzi, zzab2.zzd), zzp2);
                    }
                }
                zzal zzal4 = this.zze;
                zzak(zzal4);
                if (zzal4.zzK(zzab2)) {
                    zzaz().zzk.zzd("Conditional property added", zzab2.zza, this.zzn.zzq.zzf(zzab2.zzc.zzb), zzab2.zzc.zza());
                } else {
                    zzaz().zzd.zzd("Too many conditional properties, ignoring", zzey.zzn(zzab2.zza), this.zzn.zzq.zzf(zzab2.zzc.zzb), zzab2.zzc.zza());
                }
                zzal zzal5 = this.zze;
                zzak(zzal5);
                zzal5.zzC();
            } finally {
                zzal zzal6 = this.zze;
                zzak(zzal6);
                zzal6.zzx();
            }
        }
    }

    public final void zzU(String str, zzah zzah) {
        zzaA().zzg();
        zzB();
        this.zzB.put(str, zzah);
        zzal zzal = this.zze;
        zzak(zzal);
        Preconditions.checkNotNull(str);
        Preconditions.checkNotNull(zzah);
        zzal.zzg();
        zzal.zzW();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("consent_state", zzah.zzh());
        try {
            if (zzal.zzh().insertWithOnConflict("consent_settings", null, contentValues, 5) == -1) {
                zzal.zzs.zzaz().zzd.zzb("Failed to insert/update consent setting (got -1). appId", zzey.zzn(str));
            }
        } catch (SQLiteException e2) {
            zzal.zzs.zzaz().zzd.zzc("Error storing consent setting. appId, error", zzey.zzn(str), e2);
        }
    }

    public final void zzV(zzll zzll, zzp zzp2) {
        long j;
        zzll zzll2 = zzll;
        zzp zzp3 = zzp2;
        zzaA().zzg();
        zzB();
        if (zzaj(zzp2)) {
            if (!zzp3.zzh) {
                zzd(zzp3);
                return;
            }
            int zzl2 = zzv().zzl(zzll2.zzb);
            if (zzl2 != 0) {
                zzlp zzv2 = zzv();
                String str = zzll2.zzb;
                zzg();
                String zzD2 = zzv2.zzD(str, 24, true);
                String str2 = zzll2.zzb;
                zzv().zzN(this.zzF, zzp3.zza, zzl2, "_ev", zzD2, str2 != null ? str2.length() : 0);
                return;
            }
            int zzd2 = zzv().zzd(zzll2.zzb, zzll.zza());
            if (zzd2 != 0) {
                zzlp zzv3 = zzv();
                String str3 = zzll2.zzb;
                zzg();
                String zzD3 = zzv3.zzD(str3, 24, true);
                Object zza2 = zzll.zza();
                zzv().zzN(this.zzF, zzp3.zza, zzd2, "_ev", zzD3, (zza2 == null || (!(zza2 instanceof String) && !(zza2 instanceof CharSequence))) ? 0 : zza2.toString().length());
                return;
            }
            Object zzB2 = zzv().zzB(zzll2.zzb, zzll.zza());
            if (zzB2 != null) {
                if ("_sid".equals(zzll2.zzb)) {
                    long j2 = zzll2.zzc;
                    String str4 = zzll2.zzf;
                    String str5 = zzp3.zza;
                    Preconditions.checkNotNull(str5);
                    String str6 = str5;
                    zzal zzal = this.zze;
                    zzak(zzal);
                    zzln zzp4 = zzal.zzp(str6, "_sno");
                    if (zzp4 != null) {
                        Object obj = zzp4.zze;
                        if (obj instanceof Long) {
                            j = ((Long) obj).longValue();
                            zzll zzll3 = new zzll("_sno", j2, Long.valueOf(j + 1), str4);
                            zzV(zzll3, zzp3);
                        }
                    }
                    if (zzp4 != null) {
                        zzaz().zzg.zzb("Retrieved last session number from database does not contain a valid (long) value", zzp4.zze);
                    }
                    zzal zzal2 = this.zze;
                    zzak(zzal2);
                    zzar zzn2 = zzal2.zzn(str6, "_s");
                    if (zzn2 != null) {
                        j = zzn2.zzc;
                        zzaz().zzl.zzb("Backfill the session number. Last used session number", Long.valueOf(j));
                    } else {
                        j = 0;
                    }
                    zzll zzll32 = new zzll("_sno", j2, Long.valueOf(j + 1), str4);
                    zzV(zzll32, zzp3);
                }
                String str7 = zzp3.zza;
                Preconditions.checkNotNull(str7);
                String str8 = zzll2.zzf;
                Preconditions.checkNotNull(str8);
                zzln zzln = new zzln(str7, str8, zzll2.zzb, zzll2.zzc, zzB2);
                zzaz().zzl.zzc("Setting user property", this.zzn.zzq.zzf(zzln.zzc), zzB2);
                zzal zzal3 = this.zze;
                zzak(zzal3);
                zzal3.zzw();
                try {
                    zzne.zzc();
                    if (this.zzn.zzk.zzs(null, zzel.zzan) && "_id".equals(zzln.zzc)) {
                        if (this.zzn.zzk.zzs(null, zzel.zzaq)) {
                            zzal zzal4 = this.zze;
                            zzak(zzal4);
                            zzln zzp5 = zzal4.zzp(zzp3.zza, "_id");
                            if (zzp5 != null && !zzln.zze.equals(zzp5.zze)) {
                                zzal zzal5 = this.zze;
                                zzak(zzal5);
                                zzal5.zzA(zzp3.zza, "_lair");
                            }
                        } else {
                            zzal zzal6 = this.zze;
                            zzak(zzal6);
                            zzal6.zzA(zzp3.zza, "_lair");
                        }
                    }
                    zzd(zzp3);
                    zzal zzal7 = this.zze;
                    zzak(zzal7);
                    boolean zzL = zzal7.zzL(zzln);
                    zzal zzal8 = this.zze;
                    zzak(zzal8);
                    zzal8.zzC();
                    if (!zzL) {
                        zzaz().zzd.zzc("Too many unique user properties are set. Ignoring user property", this.zzn.zzq.zzf(zzln.zzc), zzln.zze);
                        zzv().zzN(this.zzF, zzp3.zza, 9, null, null, 0);
                    }
                } finally {
                    zzal zzal9 = this.zze;
                    zzak(zzal9);
                    zzal9.zzx();
                }
            }
        }
    }

    /* JADX WARNING: type inference failed for: r8v11, types: [java.util.List] */
    /* JADX WARNING: type inference failed for: r8v12, types: [java.util.List] */
    /* JADX WARNING: type inference failed for: r8v13, types: [java.util.List] */
    /* JADX WARNING: type inference failed for: r15v8 */
    /* JADX WARNING: type inference failed for: r8v24 */
    /* JADX WARNING: type inference failed for: r15v9 */
    /* JADX WARNING: type inference failed for: r15v11 */
    /* JADX WARNING: type inference failed for: r15v12 */
    /* JADX WARNING: type inference failed for: r15v13 */
    /* JADX WARNING: type inference failed for: r15v14 */
    /* JADX WARNING: type inference failed for: r8v25, types: [java.util.List] */
    /* JADX WARNING: type inference failed for: r8v26, types: [java.util.List] */
    /* JADX WARNING: type inference failed for: r12v17, types: [java.util.ArrayList] */
    /* JADX WARNING: type inference failed for: r8v27 */
    /* JADX WARNING: type inference failed for: r8v28, types: [java.util.List] */
    /* JADX WARNING: type inference failed for: r8v35 */
    /* JADX WARNING: type inference failed for: r15v19 */
    /* JADX WARNING: type inference failed for: r15v20 */
    /* JADX WARNING: type inference failed for: r15v21 */
    /* JADX WARNING: type inference failed for: r15v22 */
    /* JADX WARNING: type inference failed for: r8v36 */
    /* JADX WARNING: type inference failed for: r8v37 */
    /* JADX WARNING: Can't wrap try/catch for region: R(2:261|262) */
    /* JADX WARNING: Code restructure failed: missing block: B:137:?, code lost:
        r7.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:138:0x0285, code lost:
        r8 = r12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:262:?, code lost:
        zzaz().zzd().zzc("Failed to parse upload URL. Not uploading. appId", com.google.android.gms.measurement.internal.zzey.zzn(r6), r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:286:0x0696, code lost:
        if (r12 != null) goto L_0x0698;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x0129, code lost:
        if (r11 != null) goto L_0x012b;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:261:0x0616 */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r15v11
      assigns: []
      uses: []
      mth insns count: 633
    	at jadx.core.dex.visitors.typeinference.TypeSearch.fillTypeCandidates(TypeSearch.java:237)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
    	at jadx.core.dex.visitors.typeinference.TypeSearch.run(TypeSearch.java:53)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runMultiVariableSearch(TypeInferenceVisitor.java:104)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:97)
     */
    /* JADX WARNING: Removed duplicated region for block: B:150:0x02b1 A[SYNTHETIC, Splitter:B:150:0x02b1] */
    /* JADX WARNING: Removed duplicated region for block: B:154:0x02ba A[Catch:{ all -> 0x0131, all -> 0x06c0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:232:0x04b3 A[Catch:{ all -> 0x0131, all -> 0x06c0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:236:0x04c3 A[Catch:{ all -> 0x0131, all -> 0x06c0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:239:0x04d2 A[Catch:{ all -> 0x0131, all -> 0x06c0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:266:0x062e A[Catch:{ all -> 0x0131, all -> 0x06c0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:292:0x06a2 A[Catch:{ all -> 0x0131, all -> 0x06c0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:301:0x06bc A[SYNTHETIC, Splitter:B:301:0x06bc] */
    /* JADX WARNING: Removed duplicated region for block: B:318:0x04e8 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x0136 A[Catch:{ all -> 0x0131, all -> 0x06c0 }] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:136:0x0282=Splitter:B:136:0x0282, B:252:0x0596=Splitter:B:252:0x0596, B:147:0x0298=Splitter:B:147:0x0298, B:287:0x0698=Splitter:B:287:0x0698, B:54:0x011a=Splitter:B:54:0x011a, B:57:0x012b=Splitter:B:57:0x012b} */
    /* JADX WARNING: Unknown variable types count: 8 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzW() {
        /*
            r26 = this;
            r1 = r26
            com.google.android.gms.measurement.internal.zzgf r2 = r26.zzaA()
            r2.zzg()
            r26.zzB()
            r2 = 1
            r1.zzv = r2
            r3 = 0
            com.google.android.gms.measurement.internal.zzgi r4 = r1.zzn     // Catch:{ all -> 0x06c0 }
            r4.zzax()     // Catch:{ all -> 0x06c0 }
            com.google.android.gms.measurement.internal.zzgi r4 = r1.zzn     // Catch:{ all -> 0x06c0 }
            com.google.android.gms.measurement.internal.zzkb r4 = r4.zzt()     // Catch:{ all -> 0x06c0 }
            java.lang.Boolean r4 = r4.zzj()     // Catch:{ all -> 0x06c0 }
            if (r4 != 0) goto L_0x0032
            com.google.android.gms.measurement.internal.zzey r2 = r26.zzaz()     // Catch:{ all -> 0x06c0 }
            com.google.android.gms.measurement.internal.zzew r2 = r2.zzk()     // Catch:{ all -> 0x06c0 }
            java.lang.String r4 = "Upload data called on the client side before use of service was decided"
            r2.zza(r4)     // Catch:{ all -> 0x06c0 }
            r1.zzv = r3
            goto L_0x06b3
        L_0x0032:
            boolean r4 = r4.booleanValue()     // Catch:{ all -> 0x06c0 }
            if (r4 == 0) goto L_0x0049
            com.google.android.gms.measurement.internal.zzey r2 = r26.zzaz()     // Catch:{ all -> 0x06c0 }
            com.google.android.gms.measurement.internal.zzew r2 = r2.zzd()     // Catch:{ all -> 0x06c0 }
            java.lang.String r4 = "Upload called in the client side when service should be used"
            r2.zza(r4)     // Catch:{ all -> 0x06c0 }
            r1.zzv = r3
            goto L_0x06b3
        L_0x0049:
            long r4 = r1.zza     // Catch:{ all -> 0x06c0 }
            r6 = 0
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 <= 0) goto L_0x0058
            r26.zzaf()     // Catch:{ all -> 0x06c0 }
            r1.zzv = r3
            goto L_0x06b3
        L_0x0058:
            com.google.android.gms.measurement.internal.zzgf r4 = r26.zzaA()     // Catch:{ all -> 0x06c0 }
            r4.zzg()     // Catch:{ all -> 0x06c0 }
            java.util.List r4 = r1.zzy     // Catch:{ all -> 0x06c0 }
            if (r4 == 0) goto L_0x0074
            com.google.android.gms.measurement.internal.zzey r2 = r26.zzaz()     // Catch:{ all -> 0x06c0 }
            com.google.android.gms.measurement.internal.zzew r2 = r2.zzj()     // Catch:{ all -> 0x06c0 }
            java.lang.String r4 = "Uploading requested multiple times"
            r2.zza(r4)     // Catch:{ all -> 0x06c0 }
            r1.zzv = r3
            goto L_0x06b3
        L_0x0074:
            com.google.android.gms.measurement.internal.zzfe r4 = r1.zzd     // Catch:{ all -> 0x06c0 }
            zzak(r4)     // Catch:{ all -> 0x06c0 }
            boolean r4 = r4.zza()     // Catch:{ all -> 0x06c0 }
            if (r4 != 0) goto L_0x0093
            com.google.android.gms.measurement.internal.zzey r2 = r26.zzaz()     // Catch:{ all -> 0x06c0 }
            com.google.android.gms.measurement.internal.zzew r2 = r2.zzj()     // Catch:{ all -> 0x06c0 }
            java.lang.String r4 = "Network not connected, ignoring upload request"
            r2.zza(r4)     // Catch:{ all -> 0x06c0 }
            r26.zzaf()     // Catch:{ all -> 0x06c0 }
            r1.zzv = r3
            goto L_0x06b3
        L_0x0093:
            com.google.android.gms.common.util.Clock r4 = r26.zzaw()     // Catch:{ all -> 0x06c0 }
            long r4 = r4.currentTimeMillis()     // Catch:{ all -> 0x06c0 }
            com.google.android.gms.measurement.internal.zzaf r8 = r26.zzg()     // Catch:{ all -> 0x06c0 }
            com.google.android.gms.measurement.internal.zzek r9 = com.google.android.gms.measurement.internal.zzel.zzP     // Catch:{ all -> 0x06c0 }
            r10 = 0
            int r8 = r8.zze(r10, r9)     // Catch:{ all -> 0x06c0 }
            r26.zzg()     // Catch:{ all -> 0x06c0 }
            long r11 = com.google.android.gms.measurement.internal.zzaf.zzz()     // Catch:{ all -> 0x06c0 }
            long r11 = r4 - r11
            r9 = 0
        L_0x00b0:
            if (r9 >= r8) goto L_0x00bb
            boolean r13 = r1.zzag(r10, r11)     // Catch:{ all -> 0x06c0 }
            if (r13 == 0) goto L_0x00bb
            int r9 = r9 + 1
            goto L_0x00b0
        L_0x00bb:
            com.google.android.gms.measurement.internal.zzkd r8 = r1.zzk     // Catch:{ all -> 0x06c0 }
            com.google.android.gms.measurement.internal.zzfj r8 = r8.zzc     // Catch:{ all -> 0x06c0 }
            long r8 = r8.zza()     // Catch:{ all -> 0x06c0 }
            int r11 = (r8 > r6 ? 1 : (r8 == r6 ? 0 : -1))
            if (r11 == 0) goto L_0x00de
            com.google.android.gms.measurement.internal.zzey r6 = r26.zzaz()     // Catch:{ all -> 0x06c0 }
            com.google.android.gms.measurement.internal.zzew r6 = r6.zzc()     // Catch:{ all -> 0x06c0 }
            java.lang.String r7 = "Uploading events. Elapsed time since last upload attempt (ms)"
            long r8 = r4 - r8
            long r8 = java.lang.Math.abs(r8)     // Catch:{ all -> 0x06c0 }
            java.lang.Long r8 = java.lang.Long.valueOf(r8)     // Catch:{ all -> 0x06c0 }
            r6.zzb(r7, r8)     // Catch:{ all -> 0x06c0 }
        L_0x00de:
            com.google.android.gms.measurement.internal.zzal r6 = r1.zze     // Catch:{ all -> 0x06c0 }
            zzak(r6)     // Catch:{ all -> 0x06c0 }
            java.lang.String r6 = r6.zzr()     // Catch:{ all -> 0x06c0 }
            boolean r7 = android.text.TextUtils.isEmpty(r6)     // Catch:{ all -> 0x06c0 }
            r8 = -1
            if (r7 != 0) goto L_0x0632
            long r11 = r1.zzA     // Catch:{ all -> 0x06c0 }
            int r7 = (r11 > r8 ? 1 : (r11 == r8 ? 0 : -1))
            if (r7 != 0) goto L_0x013a
            com.google.android.gms.measurement.internal.zzal r7 = r1.zze     // Catch:{ all -> 0x06c0 }
            zzak(r7)     // Catch:{ all -> 0x06c0 }
            android.database.sqlite.SQLiteDatabase r11 = r7.zzh()     // Catch:{ SQLiteException -> 0x0117, all -> 0x0114 }
            java.lang.String r12 = "select rowid from raw_events order by rowid desc limit 1;"
            android.database.Cursor r11 = r11.rawQuery(r12, r10)     // Catch:{ SQLiteException -> 0x0117, all -> 0x0114 }
            boolean r12 = r11.moveToFirst()     // Catch:{ SQLiteException -> 0x0111 }
            if (r12 != 0) goto L_0x010b
            goto L_0x012b
        L_0x010b:
            long r7 = r11.getLong(r3)     // Catch:{ SQLiteException -> 0x0111 }
            r8 = r7
            goto L_0x012b
        L_0x0111:
            r0 = move-exception
            r12 = r0
            goto L_0x011a
        L_0x0114:
            r0 = move-exception
            r2 = r0
            goto L_0x0134
        L_0x0117:
            r0 = move-exception
            r12 = r0
            r11 = r10
        L_0x011a:
            com.google.android.gms.measurement.internal.zzgi r7 = r7.zzs     // Catch:{ all -> 0x0131 }
            com.google.android.gms.measurement.internal.zzey r7 = r7.zzaz()     // Catch:{ all -> 0x0131 }
            com.google.android.gms.measurement.internal.zzew r7 = r7.zzd()     // Catch:{ all -> 0x0131 }
            java.lang.String r13 = "Error querying raw events"
            r7.zzb(r13, r12)     // Catch:{ all -> 0x0131 }
            if (r11 == 0) goto L_0x012e
        L_0x012b:
            r11.close()     // Catch:{ all -> 0x06c0 }
        L_0x012e:
            r1.zzA = r8     // Catch:{ all -> 0x06c0 }
            goto L_0x013a
        L_0x0131:
            r0 = move-exception
            r2 = r0
            r10 = r11
        L_0x0134:
            if (r10 == 0) goto L_0x0139
            r10.close()     // Catch:{ all -> 0x06c0 }
        L_0x0139:
            throw r2     // Catch:{ all -> 0x06c0 }
        L_0x013a:
            com.google.android.gms.measurement.internal.zzaf r7 = r26.zzg()     // Catch:{ all -> 0x06c0 }
            com.google.android.gms.measurement.internal.zzek r8 = com.google.android.gms.measurement.internal.zzel.zzf     // Catch:{ all -> 0x06c0 }
            int r7 = r7.zze(r6, r8)     // Catch:{ all -> 0x06c0 }
            com.google.android.gms.measurement.internal.zzaf r8 = r26.zzg()     // Catch:{ all -> 0x06c0 }
            com.google.android.gms.measurement.internal.zzek r9 = com.google.android.gms.measurement.internal.zzel.zzg     // Catch:{ all -> 0x06c0 }
            int r8 = r8.zze(r6, r9)     // Catch:{ all -> 0x06c0 }
            int r8 = java.lang.Math.max(r3, r8)     // Catch:{ all -> 0x06c0 }
            com.google.android.gms.measurement.internal.zzal r9 = r1.zze     // Catch:{ all -> 0x06c0 }
            zzak(r9)     // Catch:{ all -> 0x06c0 }
            r9.zzg()     // Catch:{ all -> 0x06c0 }
            r9.zzW()     // Catch:{ all -> 0x06c0 }
            if (r7 <= 0) goto L_0x0161
            r11 = 1
            goto L_0x0162
        L_0x0161:
            r11 = 0
        L_0x0162:
            com.google.android.gms.common.internal.Preconditions.checkArgument(r11)     // Catch:{ all -> 0x06c0 }
            if (r8 <= 0) goto L_0x0169
            r11 = 1
            goto L_0x016a
        L_0x0169:
            r11 = 0
        L_0x016a:
            com.google.android.gms.common.internal.Preconditions.checkArgument(r11)     // Catch:{ all -> 0x06c0 }
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r6)     // Catch:{ all -> 0x06c0 }
            android.database.sqlite.SQLiteDatabase r12 = r9.zzh()     // Catch:{ SQLiteException -> 0x0293, all -> 0x028e }
            java.lang.String r13 = "rowid"
            java.lang.String r14 = "data"
            java.lang.String r15 = "retry_count"
            java.lang.String[] r14 = new java.lang.String[]{r13, r14, r15}     // Catch:{ SQLiteException -> 0x0293, all -> 0x028e }
            java.lang.String[] r15 = new java.lang.String[r2]     // Catch:{ SQLiteException -> 0x0293, all -> 0x028e }
            r15[r3] = r6     // Catch:{ SQLiteException -> 0x0293, all -> 0x028e }
            java.lang.String r13 = "queue"
            java.lang.String r16 = "app_id=?"
            r17 = 0
            r18 = 0
            java.lang.String r19 = "rowid"
            java.lang.String r20 = java.lang.String.valueOf(r7)     // Catch:{ SQLiteException -> 0x0293, all -> 0x028e }
            r7 = r15
            r15 = r16
            r16 = r7
            android.database.Cursor r7 = r12.query(r13, r14, r15, r16, r17, r18, r19, r20)     // Catch:{ SQLiteException -> 0x0293, all -> 0x028e }
            boolean r12 = r7.moveToFirst()     // Catch:{ SQLiteException -> 0x028a }
            if (r12 != 0) goto L_0x01b0
            java.util.List r8 = java.util.Collections.emptyList()     // Catch:{ SQLiteException -> 0x01aa }
            r7.close()     // Catch:{ all -> 0x06c0 }
            r20 = r4
            goto L_0x02b4
        L_0x01aa:
            r0 = move-exception
            r2 = r0
            r20 = r4
            goto L_0x0298
        L_0x01b0:
            java.util.ArrayList r12 = new java.util.ArrayList     // Catch:{ SQLiteException -> 0x028a }
            r12.<init>()     // Catch:{ SQLiteException -> 0x028a }
            r13 = 0
        L_0x01b6:
            long r14 = r7.getLong(r3)     // Catch:{ SQLiteException -> 0x028a }
            byte[] r10 = r7.getBlob(r2)     // Catch:{ IOException -> 0x025b }
            com.google.android.gms.measurement.internal.zzli r2 = r9.zzf     // Catch:{ IOException -> 0x025b }
            com.google.android.gms.measurement.internal.zzlk r2 = r2.zzi     // Catch:{ IOException -> 0x025b }
            zzak(r2)     // Catch:{ IOException -> 0x025b }
            java.io.ByteArrayInputStream r3 = new java.io.ByteArrayInputStream     // Catch:{ IOException -> 0x0244 }
            r3.<init>(r10)     // Catch:{ IOException -> 0x0244 }
            java.util.zip.GZIPInputStream r10 = new java.util.zip.GZIPInputStream     // Catch:{ IOException -> 0x0244 }
            r10.<init>(r3)     // Catch:{ IOException -> 0x0244 }
            java.io.ByteArrayOutputStream r11 = new java.io.ByteArrayOutputStream     // Catch:{ IOException -> 0x0244 }
            r11.<init>()     // Catch:{ IOException -> 0x0244 }
            r20 = r4
            r4 = 1024(0x400, float:1.435E-42)
            byte[] r4 = new byte[r4]     // Catch:{ IOException -> 0x0241 }
        L_0x01da:
            int r5 = r10.read(r4)     // Catch:{ IOException -> 0x0241 }
            if (r5 > 0) goto L_0x0238
            r10.close()     // Catch:{ IOException -> 0x0241 }
            r3.close()     // Catch:{ IOException -> 0x0241 }
            byte[] r2 = r11.toByteArray()     // Catch:{ IOException -> 0x0241 }
            boolean r3 = r12.isEmpty()     // Catch:{ SQLiteException -> 0x0287 }
            if (r3 != 0) goto L_0x01f6
            int r3 = r2.length     // Catch:{ SQLiteException -> 0x0287 }
            int r3 = r3 + r13
            if (r3 <= r8) goto L_0x01f6
            goto L_0x0282
        L_0x01f6:
            com.google.android.gms.internal.measurement.zzgb r3 = com.google.android.gms.internal.measurement.zzgc.zzu()     // Catch:{ IOException -> 0x0222 }
            com.google.android.gms.internal.measurement.zzli r3 = com.google.android.gms.measurement.internal.zzlk.zzl(r3, r2)     // Catch:{ IOException -> 0x0222 }
            com.google.android.gms.internal.measurement.zzgb r3 = (com.google.android.gms.internal.measurement.zzgb) r3     // Catch:{ IOException -> 0x0222 }
            r4 = 2
            boolean r5 = r7.isNull(r4)     // Catch:{ SQLiteException -> 0x0287 }
            if (r5 != 0) goto L_0x020e
            int r5 = r7.getInt(r4)     // Catch:{ SQLiteException -> 0x0287 }
            r3.zzag(r5)     // Catch:{ SQLiteException -> 0x0287 }
        L_0x020e:
            int r2 = r2.length     // Catch:{ SQLiteException -> 0x0287 }
            int r13 = r13 + r2
            com.google.android.gms.internal.measurement.zzkc r2 = r3.zzaE()     // Catch:{ SQLiteException -> 0x0287 }
            com.google.android.gms.internal.measurement.zzgc r2 = (com.google.android.gms.internal.measurement.zzgc) r2     // Catch:{ SQLiteException -> 0x0287 }
            java.lang.Long r3 = java.lang.Long.valueOf(r14)     // Catch:{ SQLiteException -> 0x0287 }
            android.util.Pair r2 = android.util.Pair.create(r2, r3)     // Catch:{ SQLiteException -> 0x0287 }
            r12.add(r2)     // Catch:{ SQLiteException -> 0x0287 }
            goto L_0x0272
        L_0x0222:
            r0 = move-exception
            r2 = r0
            com.google.android.gms.measurement.internal.zzgi r3 = r9.zzs     // Catch:{ SQLiteException -> 0x0287 }
            com.google.android.gms.measurement.internal.zzey r3 = r3.zzaz()     // Catch:{ SQLiteException -> 0x0287 }
            com.google.android.gms.measurement.internal.zzew r3 = r3.zzd()     // Catch:{ SQLiteException -> 0x0287 }
            java.lang.String r4 = "Failed to merge queued bundle. appId"
            java.lang.Object r5 = com.google.android.gms.measurement.internal.zzey.zzn(r6)     // Catch:{ SQLiteException -> 0x0287 }
            r3.zzc(r4, r5, r2)     // Catch:{ SQLiteException -> 0x0287 }
            goto L_0x0272
        L_0x0238:
            r22 = r3
            r3 = 0
            r11.write(r4, r3, r5)     // Catch:{ IOException -> 0x0241 }
            r3 = r22
            goto L_0x01da
        L_0x0241:
            r0 = move-exception
        L_0x0242:
            r3 = r0
            goto L_0x0248
        L_0x0244:
            r0 = move-exception
            r20 = r4
            goto L_0x0242
        L_0x0248:
            com.google.android.gms.measurement.internal.zzgi r2 = r2.zzs     // Catch:{ IOException -> 0x0258 }
            com.google.android.gms.measurement.internal.zzey r2 = r2.zzaz()     // Catch:{ IOException -> 0x0258 }
            com.google.android.gms.measurement.internal.zzew r2 = r2.zzd()     // Catch:{ IOException -> 0x0258 }
            java.lang.String r4 = "Failed to ungzip content"
            r2.zzb(r4, r3)     // Catch:{ IOException -> 0x0258 }
            throw r3     // Catch:{ IOException -> 0x0258 }
        L_0x0258:
            r0 = move-exception
        L_0x0259:
            r2 = r0
            goto L_0x025f
        L_0x025b:
            r0 = move-exception
            r20 = r4
            goto L_0x0259
        L_0x025f:
            com.google.android.gms.measurement.internal.zzgi r3 = r9.zzs     // Catch:{ SQLiteException -> 0x0287 }
            com.google.android.gms.measurement.internal.zzey r3 = r3.zzaz()     // Catch:{ SQLiteException -> 0x0287 }
            com.google.android.gms.measurement.internal.zzew r3 = r3.zzd()     // Catch:{ SQLiteException -> 0x0287 }
            java.lang.String r4 = "Failed to unzip queued bundle. appId"
            java.lang.Object r5 = com.google.android.gms.measurement.internal.zzey.zzn(r6)     // Catch:{ SQLiteException -> 0x0287 }
            r3.zzc(r4, r5, r2)     // Catch:{ SQLiteException -> 0x0287 }
        L_0x0272:
            boolean r2 = r7.moveToNext()     // Catch:{ SQLiteException -> 0x0287 }
            if (r2 == 0) goto L_0x0282
            if (r13 <= r8) goto L_0x027b
            goto L_0x0282
        L_0x027b:
            r4 = r20
            r2 = 1
            r3 = 0
            r10 = 0
            goto L_0x01b6
        L_0x0282:
            r7.close()     // Catch:{ all -> 0x06c0 }
            r8 = r12
            goto L_0x02b4
        L_0x0287:
            r0 = move-exception
        L_0x0288:
            r2 = r0
            goto L_0x0298
        L_0x028a:
            r0 = move-exception
            r20 = r4
            goto L_0x0288
        L_0x028e:
            r0 = move-exception
            r2 = r0
            r10 = 0
            goto L_0x062c
        L_0x0293:
            r0 = move-exception
            r20 = r4
            r2 = r0
            r7 = 0
        L_0x0298:
            com.google.android.gms.measurement.internal.zzgi r3 = r9.zzs     // Catch:{ all -> 0x0629 }
            com.google.android.gms.measurement.internal.zzey r3 = r3.zzaz()     // Catch:{ all -> 0x0629 }
            com.google.android.gms.measurement.internal.zzew r3 = r3.zzd()     // Catch:{ all -> 0x0629 }
            java.lang.String r4 = "Error querying bundles. appId"
            java.lang.Object r5 = com.google.android.gms.measurement.internal.zzey.zzn(r6)     // Catch:{ all -> 0x0629 }
            r3.zzc(r4, r5, r2)     // Catch:{ all -> 0x0629 }
            java.util.List r8 = java.util.Collections.emptyList()     // Catch:{ all -> 0x0629 }
            if (r7 == 0) goto L_0x02b4
            r7.close()     // Catch:{ all -> 0x06c0 }
        L_0x02b4:
            boolean r2 = r8.isEmpty()     // Catch:{ all -> 0x06c0 }
            if (r2 != 0) goto L_0x06b0
            com.google.android.gms.measurement.internal.zzah r2 = r1.zzh(r6)     // Catch:{ all -> 0x06c0 }
            com.google.android.gms.measurement.internal.zzag r3 = com.google.android.gms.measurement.internal.zzag.AD_STORAGE     // Catch:{ all -> 0x06c0 }
            boolean r2 = r2.zzi(r3)     // Catch:{ all -> 0x06c0 }
            if (r2 == 0) goto L_0x031b
            java.util.Iterator r2 = r8.iterator()     // Catch:{ all -> 0x06c0 }
        L_0x02ca:
            boolean r3 = r2.hasNext()     // Catch:{ all -> 0x06c0 }
            if (r3 == 0) goto L_0x02e9
            java.lang.Object r3 = r2.next()     // Catch:{ all -> 0x06c0 }
            android.util.Pair r3 = (android.util.Pair) r3     // Catch:{ all -> 0x06c0 }
            java.lang.Object r3 = r3.first     // Catch:{ all -> 0x06c0 }
            com.google.android.gms.internal.measurement.zzgc r3 = (com.google.android.gms.internal.measurement.zzgc) r3     // Catch:{ all -> 0x06c0 }
            java.lang.String r4 = r3.zzK()     // Catch:{ all -> 0x06c0 }
            boolean r4 = android.text.TextUtils.isEmpty(r4)     // Catch:{ all -> 0x06c0 }
            if (r4 != 0) goto L_0x02ca
            java.lang.String r2 = r3.zzK()     // Catch:{ all -> 0x06c0 }
            goto L_0x02ea
        L_0x02e9:
            r2 = 0
        L_0x02ea:
            if (r2 == 0) goto L_0x031b
            r3 = 0
        L_0x02ed:
            int r4 = r8.size()     // Catch:{ all -> 0x06c0 }
            if (r3 >= r4) goto L_0x031b
            java.lang.Object r4 = r8.get(r3)     // Catch:{ all -> 0x06c0 }
            android.util.Pair r4 = (android.util.Pair) r4     // Catch:{ all -> 0x06c0 }
            java.lang.Object r4 = r4.first     // Catch:{ all -> 0x06c0 }
            com.google.android.gms.internal.measurement.zzgc r4 = (com.google.android.gms.internal.measurement.zzgc) r4     // Catch:{ all -> 0x06c0 }
            java.lang.String r5 = r4.zzK()     // Catch:{ all -> 0x06c0 }
            boolean r5 = android.text.TextUtils.isEmpty(r5)     // Catch:{ all -> 0x06c0 }
            if (r5 == 0) goto L_0x0308
            goto L_0x0318
        L_0x0308:
            java.lang.String r4 = r4.zzK()     // Catch:{ all -> 0x06c0 }
            boolean r4 = r4.equals(r2)     // Catch:{ all -> 0x06c0 }
            if (r4 != 0) goto L_0x0318
            r4 = 0
            java.util.List r8 = r8.subList(r4, r3)     // Catch:{ all -> 0x06c0 }
            goto L_0x031b
        L_0x0318:
            int r3 = r3 + 1
            goto L_0x02ed
        L_0x031b:
            com.google.android.gms.internal.measurement.zzfz r2 = com.google.android.gms.internal.measurement.zzga.zza()     // Catch:{ all -> 0x06c0 }
            int r3 = r8.size()     // Catch:{ all -> 0x06c0 }
            java.util.ArrayList r4 = new java.util.ArrayList     // Catch:{ all -> 0x06c0 }
            int r5 = r8.size()     // Catch:{ all -> 0x06c0 }
            r4.<init>(r5)     // Catch:{ all -> 0x06c0 }
            com.google.android.gms.measurement.internal.zzaf r5 = r26.zzg()     // Catch:{ all -> 0x06c0 }
            boolean r5 = r5.zzt(r6)     // Catch:{ all -> 0x06c0 }
            if (r5 == 0) goto L_0x0344
            com.google.android.gms.measurement.internal.zzah r5 = r1.zzh(r6)     // Catch:{ all -> 0x06c0 }
            com.google.android.gms.measurement.internal.zzag r7 = com.google.android.gms.measurement.internal.zzag.AD_STORAGE     // Catch:{ all -> 0x06c0 }
            boolean r5 = r5.zzi(r7)     // Catch:{ all -> 0x06c0 }
            if (r5 == 0) goto L_0x0344
            r5 = 1
            goto L_0x0345
        L_0x0344:
            r5 = 0
        L_0x0345:
            com.google.android.gms.measurement.internal.zzah r7 = r1.zzh(r6)     // Catch:{ all -> 0x06c0 }
            com.google.android.gms.measurement.internal.zzag r9 = com.google.android.gms.measurement.internal.zzag.AD_STORAGE     // Catch:{ all -> 0x06c0 }
            boolean r7 = r7.zzi(r9)     // Catch:{ all -> 0x06c0 }
            com.google.android.gms.measurement.internal.zzah r9 = r1.zzh(r6)     // Catch:{ all -> 0x06c0 }
            com.google.android.gms.measurement.internal.zzag r10 = com.google.android.gms.measurement.internal.zzag.ANALYTICS_STORAGE     // Catch:{ all -> 0x06c0 }
            boolean r9 = r9.zzi(r10)     // Catch:{ all -> 0x06c0 }
            com.google.android.gms.internal.measurement.zzpp.zzc()     // Catch:{ all -> 0x06c0 }
            com.google.android.gms.measurement.internal.zzaf r10 = r26.zzg()     // Catch:{ all -> 0x06c0 }
            com.google.android.gms.measurement.internal.zzek r11 = com.google.android.gms.measurement.internal.zzel.zzaH     // Catch:{ all -> 0x06c0 }
            r12 = 0
            boolean r10 = r10.zzs(r12, r11)     // Catch:{ all -> 0x06c0 }
            r11 = 0
        L_0x0368:
            if (r11 >= r3) goto L_0x04f8
            java.lang.Object r12 = r8.get(r11)     // Catch:{ all -> 0x06c0 }
            android.util.Pair r12 = (android.util.Pair) r12     // Catch:{ all -> 0x06c0 }
            java.lang.Object r12 = r12.first     // Catch:{ all -> 0x06c0 }
            com.google.android.gms.internal.measurement.zzgc r12 = (com.google.android.gms.internal.measurement.zzgc) r12     // Catch:{ all -> 0x06c0 }
            com.google.android.gms.internal.measurement.zzjy r12 = r12.zzbB()     // Catch:{ all -> 0x06c0 }
            com.google.android.gms.internal.measurement.zzgb r12 = (com.google.android.gms.internal.measurement.zzgb) r12     // Catch:{ all -> 0x06c0 }
            java.lang.Object r13 = r8.get(r11)     // Catch:{ all -> 0x06c0 }
            android.util.Pair r13 = (android.util.Pair) r13     // Catch:{ all -> 0x06c0 }
            java.lang.Object r13 = r13.second     // Catch:{ all -> 0x06c0 }
            java.lang.Long r13 = (java.lang.Long) r13     // Catch:{ all -> 0x06c0 }
            r4.add(r13)     // Catch:{ all -> 0x06c0 }
            com.google.android.gms.measurement.internal.zzaf r13 = r26.zzg()     // Catch:{ all -> 0x06c0 }
            r13.zzh()     // Catch:{ all -> 0x06c0 }
            r13 = 61000(0xee48, double:3.0138E-319)
            r12.zzam(r13)     // Catch:{ all -> 0x06c0 }
            r13 = r20
            r12.zzal(r13)     // Catch:{ all -> 0x06c0 }
            com.google.android.gms.measurement.internal.zzgi r15 = r1.zzn     // Catch:{ all -> 0x06c0 }
            r15.zzax()     // Catch:{ all -> 0x06c0 }
            r15 = 0
            r12.zzah(r15)     // Catch:{ all -> 0x06c0 }
            if (r5 != 0) goto L_0x03a7
            r12.zzq()     // Catch:{ all -> 0x06c0 }
        L_0x03a7:
            if (r7 != 0) goto L_0x03af
            r12.zzx()     // Catch:{ all -> 0x06c0 }
            r12.zzt()     // Catch:{ all -> 0x06c0 }
        L_0x03af:
            if (r9 != 0) goto L_0x03b4
            r12.zzn()     // Catch:{ all -> 0x06c0 }
        L_0x03b4:
            com.google.android.gms.internal.measurement.zzpg.zzc()     // Catch:{ all -> 0x06c0 }
            com.google.android.gms.measurement.internal.zzaf r15 = r26.zzg()     // Catch:{ all -> 0x06c0 }
            r20 = r5
            com.google.android.gms.measurement.internal.zzek r5 = com.google.android.gms.measurement.internal.zzel.zzaC     // Catch:{ all -> 0x06c0 }
            boolean r5 = r15.zzs(r6, r5)     // Catch:{ all -> 0x06c0 }
            if (r5 == 0) goto L_0x03d3
            com.google.android.gms.measurement.internal.zzfz r5 = r1.zzc     // Catch:{ all -> 0x06c0 }
            zzak(r5)     // Catch:{ all -> 0x06c0 }
            java.util.Set r5 = r5.zzk(r6)     // Catch:{ all -> 0x06c0 }
            if (r5 == 0) goto L_0x03d3
            r12.zzi(r5)     // Catch:{ all -> 0x06c0 }
        L_0x03d3:
            com.google.android.gms.measurement.internal.zzaf r5 = r26.zzg()     // Catch:{ all -> 0x06c0 }
            com.google.android.gms.measurement.internal.zzek r15 = com.google.android.gms.measurement.internal.zzel.zzaE     // Catch:{ all -> 0x06c0 }
            boolean r5 = r5.zzs(r6, r15)     // Catch:{ all -> 0x06c0 }
            if (r5 == 0) goto L_0x03fb
            com.google.android.gms.measurement.internal.zzfz r5 = r1.zzc     // Catch:{ all -> 0x06c0 }
            zzak(r5)     // Catch:{ all -> 0x06c0 }
            boolean r5 = r5.zzv(r6)     // Catch:{ all -> 0x06c0 }
            if (r5 == 0) goto L_0x03ed
            r12.zzp()     // Catch:{ all -> 0x06c0 }
        L_0x03ed:
            com.google.android.gms.measurement.internal.zzfz r5 = r1.zzc     // Catch:{ all -> 0x06c0 }
            zzak(r5)     // Catch:{ all -> 0x06c0 }
            boolean r5 = r5.zzy(r6)     // Catch:{ all -> 0x06c0 }
            if (r5 == 0) goto L_0x03fb
            r12.zzu()     // Catch:{ all -> 0x06c0 }
        L_0x03fb:
            com.google.android.gms.measurement.internal.zzaf r5 = r26.zzg()     // Catch:{ all -> 0x06c0 }
            com.google.android.gms.measurement.internal.zzek r15 = com.google.android.gms.measurement.internal.zzel.zzaF     // Catch:{ all -> 0x06c0 }
            boolean r5 = r5.zzs(r6, r15)     // Catch:{ all -> 0x06c0 }
            if (r5 == 0) goto L_0x041e
            com.google.android.gms.measurement.internal.zzfz r5 = r1.zzc     // Catch:{ all -> 0x06c0 }
            zzak(r5)     // Catch:{ all -> 0x06c0 }
            boolean r5 = r5.zzz(r6)     // Catch:{ all -> 0x06c0 }
            if (r5 == 0) goto L_0x041e
            java.lang.String r5 = "_id"
            int r5 = com.google.android.gms.measurement.internal.zzlk.zza(r12, r5)     // Catch:{ all -> 0x06c0 }
            r15 = -1
            if (r5 == r15) goto L_0x041e
            r12.zzB(r5)     // Catch:{ all -> 0x06c0 }
        L_0x041e:
            com.google.android.gms.measurement.internal.zzaf r5 = r26.zzg()     // Catch:{ all -> 0x06c0 }
            com.google.android.gms.measurement.internal.zzek r15 = com.google.android.gms.measurement.internal.zzel.zzaG     // Catch:{ all -> 0x06c0 }
            boolean r5 = r5.zzs(r6, r15)     // Catch:{ all -> 0x06c0 }
            if (r5 == 0) goto L_0x0438
            com.google.android.gms.measurement.internal.zzfz r5 = r1.zzc     // Catch:{ all -> 0x06c0 }
            zzak(r5)     // Catch:{ all -> 0x06c0 }
            boolean r5 = r5.zzx(r6)     // Catch:{ all -> 0x06c0 }
            if (r5 == 0) goto L_0x0438
            r12.zzq()     // Catch:{ all -> 0x06c0 }
        L_0x0438:
            com.google.android.gms.measurement.internal.zzaf r5 = r26.zzg()     // Catch:{ all -> 0x06c0 }
            com.google.android.gms.measurement.internal.zzek r15 = com.google.android.gms.measurement.internal.zzel.zzaJ     // Catch:{ all -> 0x06c0 }
            boolean r5 = r5.zzs(r6, r15)     // Catch:{ all -> 0x06c0 }
            if (r5 == 0) goto L_0x04a2
            com.google.android.gms.measurement.internal.zzfz r5 = r1.zzc     // Catch:{ all -> 0x06c0 }
            zzak(r5)     // Catch:{ all -> 0x06c0 }
            boolean r5 = r5.zzu(r6)     // Catch:{ all -> 0x06c0 }
            if (r5 == 0) goto L_0x04a2
            r12.zzn()     // Catch:{ all -> 0x06c0 }
            com.google.android.gms.measurement.internal.zzaf r5 = r26.zzg()     // Catch:{ all -> 0x06c0 }
            com.google.android.gms.measurement.internal.zzek r15 = com.google.android.gms.measurement.internal.zzel.zzaK     // Catch:{ all -> 0x06c0 }
            boolean r5 = r5.zzs(r6, r15)     // Catch:{ all -> 0x06c0 }
            if (r5 == 0) goto L_0x04a2
            java.util.Map r5 = r1.zzC     // Catch:{ all -> 0x06c0 }
            java.lang.Object r5 = r5.get(r6)     // Catch:{ all -> 0x06c0 }
            com.google.android.gms.measurement.internal.zzlh r5 = (com.google.android.gms.measurement.internal.zzlh) r5     // Catch:{ all -> 0x06c0 }
            if (r5 == 0) goto L_0x048d
            r21 = r7
            r15 = r8
            long r7 = r5.zzb     // Catch:{ all -> 0x06c0 }
            r22 = r5
            com.google.android.gms.measurement.internal.zzaf r5 = r26.zzg()     // Catch:{ all -> 0x06c0 }
            r23 = r9
            com.google.android.gms.measurement.internal.zzek r9 = com.google.android.gms.measurement.internal.zzel.zzR     // Catch:{ all -> 0x06c0 }
            long r24 = r5.zzi(r6, r9)     // Catch:{ all -> 0x06c0 }
            long r7 = r7 + r24
            com.google.android.gms.common.util.Clock r5 = r26.zzaw()     // Catch:{ all -> 0x06c0 }
            long r24 = r5.elapsedRealtime()     // Catch:{ all -> 0x06c0 }
            int r5 = (r7 > r24 ? 1 : (r7 == r24 ? 0 : -1))
            if (r5 >= 0) goto L_0x048a
            goto L_0x0492
        L_0x048a:
            r5 = r22
            goto L_0x049c
        L_0x048d:
            r21 = r7
            r15 = r8
            r23 = r9
        L_0x0492:
            com.google.android.gms.measurement.internal.zzlh r5 = new com.google.android.gms.measurement.internal.zzlh     // Catch:{ all -> 0x06c0 }
            r5.<init>(r1)     // Catch:{ all -> 0x06c0 }
            java.util.Map r7 = r1.zzC     // Catch:{ all -> 0x06c0 }
            r7.put(r6, r5)     // Catch:{ all -> 0x06c0 }
        L_0x049c:
            java.lang.String r5 = r5.zza     // Catch:{ all -> 0x06c0 }
            r12.zzS(r5)     // Catch:{ all -> 0x06c0 }
            goto L_0x04a7
        L_0x04a2:
            r21 = r7
            r15 = r8
            r23 = r9
        L_0x04a7:
            com.google.android.gms.measurement.internal.zzaf r5 = r26.zzg()     // Catch:{ all -> 0x06c0 }
            com.google.android.gms.measurement.internal.zzek r7 = com.google.android.gms.measurement.internal.zzel.zzaL     // Catch:{ all -> 0x06c0 }
            boolean r5 = r5.zzs(r6, r7)     // Catch:{ all -> 0x06c0 }
            if (r5 == 0) goto L_0x04c1
            com.google.android.gms.measurement.internal.zzfz r5 = r1.zzc     // Catch:{ all -> 0x06c0 }
            zzak(r5)     // Catch:{ all -> 0x06c0 }
            boolean r5 = r5.zzw(r6)     // Catch:{ all -> 0x06c0 }
            if (r5 == 0) goto L_0x04c1
            r12.zzy()     // Catch:{ all -> 0x06c0 }
        L_0x04c1:
            if (r10 != 0) goto L_0x04c6
            r12.zzy()     // Catch:{ all -> 0x06c0 }
        L_0x04c6:
            com.google.android.gms.measurement.internal.zzaf r5 = r26.zzg()     // Catch:{ all -> 0x06c0 }
            com.google.android.gms.measurement.internal.zzek r7 = com.google.android.gms.measurement.internal.zzel.zzU     // Catch:{ all -> 0x06c0 }
            boolean r5 = r5.zzs(r6, r7)     // Catch:{ all -> 0x06c0 }
            if (r5 == 0) goto L_0x04e8
            com.google.android.gms.internal.measurement.zzkc r5 = r12.zzaE()     // Catch:{ all -> 0x06c0 }
            com.google.android.gms.internal.measurement.zzgc r5 = (com.google.android.gms.internal.measurement.zzgc) r5     // Catch:{ all -> 0x06c0 }
            byte[] r5 = r5.zzby()     // Catch:{ all -> 0x06c0 }
            com.google.android.gms.measurement.internal.zzlk r7 = r1.zzi     // Catch:{ all -> 0x06c0 }
            zzak(r7)     // Catch:{ all -> 0x06c0 }
            long r7 = r7.zzd(r5)     // Catch:{ all -> 0x06c0 }
            r12.zzK(r7)     // Catch:{ all -> 0x06c0 }
        L_0x04e8:
            r2.zza(r12)     // Catch:{ all -> 0x06c0 }
            int r11 = r11 + 1
            r8 = r15
            r5 = r20
            r7 = r21
            r9 = r23
            r20 = r13
            goto L_0x0368
        L_0x04f8:
            r13 = r20
            com.google.android.gms.measurement.internal.zzey r5 = r26.zzaz()     // Catch:{ all -> 0x06c0 }
            java.lang.String r5 = r5.zzq()     // Catch:{ all -> 0x06c0 }
            r7 = 2
            boolean r5 = android.util.Log.isLoggable(r5, r7)     // Catch:{ all -> 0x06c0 }
            if (r5 == 0) goto L_0x051a
            com.google.android.gms.measurement.internal.zzlk r5 = r1.zzi     // Catch:{ all -> 0x06c0 }
            zzak(r5)     // Catch:{ all -> 0x06c0 }
            com.google.android.gms.internal.measurement.zzkc r7 = r2.zzaE()     // Catch:{ all -> 0x06c0 }
            com.google.android.gms.internal.measurement.zzga r7 = (com.google.android.gms.internal.measurement.zzga) r7     // Catch:{ all -> 0x06c0 }
            java.lang.String r5 = r5.zzm(r7)     // Catch:{ all -> 0x06c0 }
            r12 = r5
            goto L_0x051b
        L_0x051a:
            r12 = 0
        L_0x051b:
            com.google.android.gms.measurement.internal.zzlk r5 = r1.zzi     // Catch:{ all -> 0x06c0 }
            zzak(r5)     // Catch:{ all -> 0x06c0 }
            com.google.android.gms.internal.measurement.zzkc r5 = r2.zzaE()     // Catch:{ all -> 0x06c0 }
            com.google.android.gms.internal.measurement.zzga r5 = (com.google.android.gms.internal.measurement.zzga) r5     // Catch:{ all -> 0x06c0 }
            byte[] r15 = r5.zzby()     // Catch:{ all -> 0x06c0 }
            com.google.android.gms.measurement.internal.zzkx r5 = r1.zzl     // Catch:{ all -> 0x06c0 }
            com.google.android.gms.internal.measurement.zzpg.zzc()     // Catch:{ all -> 0x06c0 }
            com.google.android.gms.measurement.internal.zzgi r7 = r5.zzs     // Catch:{ all -> 0x06c0 }
            com.google.android.gms.measurement.internal.zzaf r7 = r7.zzf()     // Catch:{ all -> 0x06c0 }
            com.google.android.gms.measurement.internal.zzek r8 = com.google.android.gms.measurement.internal.zzel.zzaD     // Catch:{ all -> 0x06c0 }
            boolean r7 = r7.zzs(r6, r8)     // Catch:{ all -> 0x06c0 }
            if (r7 == 0) goto L_0x058d
            com.google.android.gms.measurement.internal.zzli r5 = r5.zzf     // Catch:{ all -> 0x06c0 }
            com.google.android.gms.measurement.internal.zzfz r5 = r5.zzc     // Catch:{ all -> 0x06c0 }
            zzak(r5)     // Catch:{ all -> 0x06c0 }
            java.lang.String r5 = r5.zzi(r6)     // Catch:{ all -> 0x06c0 }
            boolean r7 = android.text.TextUtils.isEmpty(r5)     // Catch:{ all -> 0x06c0 }
            if (r7 != 0) goto L_0x0583
            com.google.android.gms.measurement.internal.zzek r7 = com.google.android.gms.measurement.internal.zzel.zzp     // Catch:{ all -> 0x06c0 }
            r8 = 0
            java.lang.Object r7 = r7.zza(r8)     // Catch:{ all -> 0x06c0 }
            java.lang.String r7 = (java.lang.String) r7     // Catch:{ all -> 0x06c0 }
            android.net.Uri r7 = android.net.Uri.parse(r7)     // Catch:{ all -> 0x06c0 }
            android.net.Uri$Builder r8 = r7.buildUpon()     // Catch:{ all -> 0x06c0 }
            java.lang.String r7 = r7.getAuthority()     // Catch:{ all -> 0x06c0 }
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ all -> 0x06c0 }
            r9.<init>()     // Catch:{ all -> 0x06c0 }
            r9.append(r5)     // Catch:{ all -> 0x06c0 }
            java.lang.String r5 = "."
            r9.append(r5)     // Catch:{ all -> 0x06c0 }
            r9.append(r7)     // Catch:{ all -> 0x06c0 }
            java.lang.String r5 = r9.toString()     // Catch:{ all -> 0x06c0 }
            r8.authority(r5)     // Catch:{ all -> 0x06c0 }
            android.net.Uri r5 = r8.build()     // Catch:{ all -> 0x06c0 }
            java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x06c0 }
            goto L_0x0596
        L_0x0583:
            com.google.android.gms.measurement.internal.zzek r5 = com.google.android.gms.measurement.internal.zzel.zzp     // Catch:{ all -> 0x06c0 }
            r7 = 0
            java.lang.Object r5 = r5.zza(r7)     // Catch:{ all -> 0x06c0 }
            java.lang.String r5 = (java.lang.String) r5     // Catch:{ all -> 0x06c0 }
            goto L_0x0596
        L_0x058d:
            com.google.android.gms.measurement.internal.zzek r5 = com.google.android.gms.measurement.internal.zzel.zzp     // Catch:{ all -> 0x06c0 }
            r7 = 0
            java.lang.Object r5 = r5.zza(r7)     // Catch:{ all -> 0x06c0 }
            java.lang.String r5 = (java.lang.String) r5     // Catch:{ all -> 0x06c0 }
        L_0x0596:
            java.net.URL r7 = new java.net.URL     // Catch:{ MalformedURLException -> 0x0616 }
            r7.<init>(r5)     // Catch:{ MalformedURLException -> 0x0616 }
            boolean r8 = r4.isEmpty()     // Catch:{ MalformedURLException -> 0x0616 }
            r9 = 1
            r8 = r8 ^ r9
            com.google.android.gms.common.internal.Preconditions.checkArgument(r8)     // Catch:{ MalformedURLException -> 0x0616 }
            java.util.List r8 = r1.zzy     // Catch:{ MalformedURLException -> 0x0616 }
            if (r8 == 0) goto L_0x05b6
            com.google.android.gms.measurement.internal.zzey r4 = r26.zzaz()     // Catch:{ MalformedURLException -> 0x0616 }
            com.google.android.gms.measurement.internal.zzew r4 = r4.zzd()     // Catch:{ MalformedURLException -> 0x0616 }
            java.lang.String r8 = "Set uploading progress before finishing the previous upload"
            r4.zza(r8)     // Catch:{ MalformedURLException -> 0x0616 }
            goto L_0x05bd
        L_0x05b6:
            java.util.ArrayList r8 = new java.util.ArrayList     // Catch:{ MalformedURLException -> 0x0616 }
            r8.<init>(r4)     // Catch:{ MalformedURLException -> 0x0616 }
            r1.zzy = r8     // Catch:{ MalformedURLException -> 0x0616 }
        L_0x05bd:
            com.google.android.gms.measurement.internal.zzkd r4 = r1.zzk     // Catch:{ MalformedURLException -> 0x0616 }
            com.google.android.gms.measurement.internal.zzfj r4 = r4.zzd     // Catch:{ MalformedURLException -> 0x0616 }
            r4.zzb(r13)     // Catch:{ MalformedURLException -> 0x0616 }
            java.lang.String r4 = "?"
            if (r3 <= 0) goto L_0x05d1
            r3 = 0
            com.google.android.gms.internal.measurement.zzgc r2 = r2.zzb(r3)     // Catch:{ MalformedURLException -> 0x0616 }
            java.lang.String r4 = r2.zzy()     // Catch:{ MalformedURLException -> 0x0616 }
        L_0x05d1:
            com.google.android.gms.measurement.internal.zzey r2 = r26.zzaz()     // Catch:{ MalformedURLException -> 0x0616 }
            com.google.android.gms.measurement.internal.zzew r2 = r2.zzj()     // Catch:{ MalformedURLException -> 0x0616 }
            java.lang.String r3 = "Uploading data. app, uncompressed size, data"
            int r8 = r15.length     // Catch:{ MalformedURLException -> 0x0616 }
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)     // Catch:{ MalformedURLException -> 0x0616 }
            r2.zzd(r3, r4, r8, r12)     // Catch:{ MalformedURLException -> 0x0616 }
            r2 = 1
            r1.zzu = r2     // Catch:{ MalformedURLException -> 0x0616 }
            com.google.android.gms.measurement.internal.zzfe r12 = r1.zzd     // Catch:{ MalformedURLException -> 0x0616 }
            zzak(r12)     // Catch:{ MalformedURLException -> 0x0616 }
            com.google.android.gms.measurement.internal.zzkz r2 = new com.google.android.gms.measurement.internal.zzkz     // Catch:{ MalformedURLException -> 0x0616 }
            r2.<init>(r1, r6)     // Catch:{ MalformedURLException -> 0x0616 }
            r12.zzg()     // Catch:{ MalformedURLException -> 0x0616 }
            r12.zzW()     // Catch:{ MalformedURLException -> 0x0616 }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r7)     // Catch:{ MalformedURLException -> 0x0616 }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r15)     // Catch:{ MalformedURLException -> 0x0616 }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r2)     // Catch:{ MalformedURLException -> 0x0616 }
            com.google.android.gms.measurement.internal.zzgi r3 = r12.zzs     // Catch:{ MalformedURLException -> 0x0616 }
            com.google.android.gms.measurement.internal.zzgf r3 = r3.zzaA()     // Catch:{ MalformedURLException -> 0x0616 }
            com.google.android.gms.measurement.internal.zzfd r4 = new com.google.android.gms.measurement.internal.zzfd     // Catch:{ MalformedURLException -> 0x0616 }
            r16 = 0
            r11 = r4
            r13 = r6
            r14 = r7
            r17 = r2
            r11.<init>(r12, r13, r14, r15, r16, r17)     // Catch:{ MalformedURLException -> 0x0616 }
            r3.zzo(r4)     // Catch:{ MalformedURLException -> 0x0616 }
            goto L_0x06b0
        L_0x0616:
            com.google.android.gms.measurement.internal.zzey r2 = r26.zzaz()     // Catch:{ all -> 0x06c0 }
            com.google.android.gms.measurement.internal.zzew r2 = r2.zzd()     // Catch:{ all -> 0x06c0 }
            java.lang.String r3 = "Failed to parse upload URL. Not uploading. appId"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzey.zzn(r6)     // Catch:{ all -> 0x06c0 }
            r2.zzc(r3, r4, r5)     // Catch:{ all -> 0x06c0 }
            goto L_0x06b0
        L_0x0629:
            r0 = move-exception
            r2 = r0
            r10 = r7
        L_0x062c:
            if (r10 == 0) goto L_0x0631
            r10.close()     // Catch:{ all -> 0x06c0 }
        L_0x0631:
            throw r2     // Catch:{ all -> 0x06c0 }
        L_0x0632:
            r13 = r4
            r7 = r10
            r1.zzA = r8     // Catch:{ all -> 0x06c0 }
            com.google.android.gms.measurement.internal.zzal r2 = r1.zze     // Catch:{ all -> 0x06c0 }
            zzak(r2)     // Catch:{ all -> 0x06c0 }
            r26.zzg()     // Catch:{ all -> 0x06c0 }
            long r3 = com.google.android.gms.measurement.internal.zzaf.zzz()     // Catch:{ all -> 0x06c0 }
            long r4 = r13 - r3
            r2.zzg()     // Catch:{ all -> 0x06c0 }
            r2.zzW()     // Catch:{ all -> 0x06c0 }
            android.database.sqlite.SQLiteDatabase r3 = r2.zzh()     // Catch:{ SQLiteException -> 0x0684, all -> 0x0680 }
            r6 = 1
            java.lang.String[] r6 = new java.lang.String[r6]     // Catch:{ SQLiteException -> 0x0684, all -> 0x0680 }
            java.lang.String r4 = java.lang.String.valueOf(r4)     // Catch:{ SQLiteException -> 0x0684, all -> 0x0680 }
            r5 = 0
            r6[r5] = r4     // Catch:{ SQLiteException -> 0x0684, all -> 0x0680 }
            java.lang.String r4 = "select app_id from apps where app_id in (select distinct app_id from raw_events) and config_fetched_time < ? order by failed_config_fetch_time limit 1;"
            android.database.Cursor r12 = r3.rawQuery(r4, r6)     // Catch:{ SQLiteException -> 0x0684, all -> 0x0680 }
            boolean r3 = r12.moveToFirst()     // Catch:{ SQLiteException -> 0x067d }
            if (r3 != 0) goto L_0x0674
            com.google.android.gms.measurement.internal.zzgi r3 = r2.zzs     // Catch:{ SQLiteException -> 0x067d }
            com.google.android.gms.measurement.internal.zzey r3 = r3.zzaz()     // Catch:{ SQLiteException -> 0x067d }
            com.google.android.gms.measurement.internal.zzew r3 = r3.zzj()     // Catch:{ SQLiteException -> 0x067d }
            java.lang.String r4 = "No expired configs for apps with pending events"
            r3.zza(r4)     // Catch:{ SQLiteException -> 0x067d }
            goto L_0x0698
        L_0x0674:
            r3 = 0
            java.lang.String r10 = r12.getString(r3)     // Catch:{ SQLiteException -> 0x067d }
            r12.close()     // Catch:{ all -> 0x06c0 }
            goto L_0x069c
        L_0x067d:
            r0 = move-exception
            r3 = r0
            goto L_0x0687
        L_0x0680:
            r0 = move-exception
            r2 = r0
            r10 = r7
            goto L_0x06ba
        L_0x0684:
            r0 = move-exception
            r3 = r0
            r12 = r7
        L_0x0687:
            com.google.android.gms.measurement.internal.zzgi r2 = r2.zzs     // Catch:{ all -> 0x06b7 }
            com.google.android.gms.measurement.internal.zzey r2 = r2.zzaz()     // Catch:{ all -> 0x06b7 }
            com.google.android.gms.measurement.internal.zzew r2 = r2.zzd()     // Catch:{ all -> 0x06b7 }
            java.lang.String r4 = "Error selecting expired configs"
            r2.zzb(r4, r3)     // Catch:{ all -> 0x06b7 }
            if (r12 == 0) goto L_0x069b
        L_0x0698:
            r12.close()     // Catch:{ all -> 0x06c0 }
        L_0x069b:
            r10 = r7
        L_0x069c:
            boolean r2 = android.text.TextUtils.isEmpty(r10)     // Catch:{ all -> 0x06c0 }
            if (r2 != 0) goto L_0x06b0
            com.google.android.gms.measurement.internal.zzal r2 = r1.zze     // Catch:{ all -> 0x06c0 }
            zzak(r2)     // Catch:{ all -> 0x06c0 }
            com.google.android.gms.measurement.internal.zzg r2 = r2.zzj(r10)     // Catch:{ all -> 0x06c0 }
            if (r2 == 0) goto L_0x06b0
            r1.zzC(r2)     // Catch:{ all -> 0x06c0 }
        L_0x06b0:
            r2 = 0
            r1.zzv = r2
        L_0x06b3:
            r26.zzad()
            return
        L_0x06b7:
            r0 = move-exception
            r2 = r0
            r10 = r12
        L_0x06ba:
            if (r10 == 0) goto L_0x06bf
            r10.close()     // Catch:{ all -> 0x06c0 }
        L_0x06bf:
            throw r2     // Catch:{ all -> 0x06c0 }
        L_0x06c0:
            r0 = move-exception
            r2 = r0
            r3 = 0
            r1.zzv = r3
            r26.zzad()
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzli.zzW():void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:228:0x075a, code lost:
        if (r14.size() == 0) goto L_0x075c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:286:0x09a5, code lost:
        r13 = 1;
     */
    /* JADX WARNING: Removed duplicated region for block: B:103:0x032c A[Catch:{ NumberFormatException -> 0x0744, all -> 0x0a9d }] */
    /* JADX WARNING: Removed duplicated region for block: B:104:0x032f A[Catch:{ NumberFormatException -> 0x0744, all -> 0x0a9d }] */
    /* JADX WARNING: Removed duplicated region for block: B:112:0x0394 A[Catch:{ NumberFormatException -> 0x0744, all -> 0x0a9d }] */
    /* JADX WARNING: Removed duplicated region for block: B:118:0x03c1  */
    /* JADX WARNING: Removed duplicated region for block: B:167:0x0525 A[Catch:{ NumberFormatException -> 0x0744, all -> 0x0a9d }] */
    /* JADX WARNING: Removed duplicated region for block: B:170:0x0564 A[Catch:{ NumberFormatException -> 0x0744, all -> 0x0a9d }] */
    /* JADX WARNING: Removed duplicated region for block: B:178:0x05dd A[Catch:{ NumberFormatException -> 0x0744, all -> 0x0a9d }] */
    /* JADX WARNING: Removed duplicated region for block: B:181:0x062a A[Catch:{ NumberFormatException -> 0x0744, all -> 0x0a9d }] */
    /* JADX WARNING: Removed duplicated region for block: B:184:0x0637 A[Catch:{ NumberFormatException -> 0x0744, all -> 0x0a9d }] */
    /* JADX WARNING: Removed duplicated region for block: B:187:0x0644 A[Catch:{ NumberFormatException -> 0x0744, all -> 0x0a9d }] */
    /* JADX WARNING: Removed duplicated region for block: B:195:0x066e A[Catch:{ NumberFormatException -> 0x0744, all -> 0x0a9d }] */
    /* JADX WARNING: Removed duplicated region for block: B:198:0x067f A[Catch:{ NumberFormatException -> 0x0744, all -> 0x0a9d }] */
    /* JADX WARNING: Removed duplicated region for block: B:206:0x06bd A[Catch:{ NumberFormatException -> 0x0744, all -> 0x0a9d }] */
    /* JADX WARNING: Removed duplicated region for block: B:209:0x06d8 A[Catch:{ NumberFormatException -> 0x0744, all -> 0x0a9d }] */
    /* JADX WARNING: Removed duplicated region for block: B:231:0x075f A[Catch:{ NumberFormatException -> 0x0744, all -> 0x0a9d }] */
    /* JADX WARNING: Removed duplicated region for block: B:234:0x077d A[Catch:{ NumberFormatException -> 0x0744, all -> 0x0a9d }] */
    /* JADX WARNING: Removed duplicated region for block: B:243:0x07ec A[Catch:{ NumberFormatException -> 0x0744, all -> 0x0a9d }] */
    /* JADX WARNING: Removed duplicated region for block: B:246:0x07f9 A[Catch:{ NumberFormatException -> 0x0744, all -> 0x0a9d }] */
    /* JADX WARNING: Removed duplicated region for block: B:251:0x0812 A[Catch:{ NumberFormatException -> 0x0744, all -> 0x0a9d }] */
    /* JADX WARNING: Removed duplicated region for block: B:265:0x08ac A[Catch:{ NumberFormatException -> 0x0744, all -> 0x0a9d }] */
    /* JADX WARNING: Removed duplicated region for block: B:269:0x08c8 A[Catch:{ NumberFormatException -> 0x0744, all -> 0x0a9d }] */
    /* JADX WARNING: Removed duplicated region for block: B:279:0x095f A[Catch:{ NumberFormatException -> 0x0744, all -> 0x0a9d }] */
    /* JADX WARNING: Removed duplicated region for block: B:292:0x0a06 A[Catch:{ SQLiteException -> 0x0a21 }] */
    /* JADX WARNING: Removed duplicated region for block: B:293:0x0a1c  */
    /* JADX WARNING: Removed duplicated region for block: B:327:0x096c A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x017c A[Catch:{ NumberFormatException -> 0x0744, all -> 0x0a9d }] */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x018f A[Catch:{ NumberFormatException -> 0x0744, all -> 0x0a9d }] */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x01f8  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x020a A[Catch:{ NumberFormatException -> 0x0744, all -> 0x0a9d }] */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x02e3 A[Catch:{ NumberFormatException -> 0x0744, all -> 0x0a9d }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzX(com.google.android.gms.measurement.internal.zzav r35, com.google.android.gms.measurement.internal.zzp r36) {
        /*
            r34 = this;
            r1 = r34
            r2 = r35
            r3 = r36
            java.lang.String r4 = "metadata_fingerprint"
            java.lang.String r5 = "app_id"
            java.lang.String r6 = "raw_events"
            java.lang.String r7 = "_sno"
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r36)
            java.lang.String r8 = r3.zza
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r8)
            long r8 = java.lang.System.nanoTime()
            com.google.android.gms.measurement.internal.zzgf r10 = r34.zzaA()
            r10.zzg()
            r34.zzB()
            java.lang.String r10 = r3.zza
            com.google.android.gms.measurement.internal.zzlk r11 = r1.zzi
            zzak(r11)
            boolean r11 = com.google.android.gms.measurement.internal.zzlk.zzA(r35, r36)
            if (r11 != 0) goto L_0x0032
            return
        L_0x0032:
            boolean r11 = r3.zzh
            if (r11 == 0) goto L_0x0aa8
            com.google.android.gms.measurement.internal.zzfz r11 = r1.zzc
            zzak(r11)
            java.lang.String r12 = r2.zza
            boolean r11 = r11.zzr(r10, r12)
            java.lang.String r15 = "_err"
            r14 = 0
            if (r11 == 0) goto L_0x00df
            com.google.android.gms.measurement.internal.zzey r3 = r34.zzaz()
            com.google.android.gms.measurement.internal.zzew r3 = r3.zzk()
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzey.zzn(r10)
            com.google.android.gms.measurement.internal.zzgi r5 = r1.zzn
            com.google.android.gms.measurement.internal.zzet r5 = r5.zzj()
            java.lang.String r6 = r2.zza
            java.lang.String r5 = r5.zzd(r6)
            java.lang.String r6 = "Dropping blocked event. appId"
            r3.zzc(r6, r4, r5)
            com.google.android.gms.measurement.internal.zzfz r3 = r1.zzc
            zzak(r3)
            boolean r3 = r3.zzp(r10)
            if (r3 != 0) goto L_0x0097
            com.google.android.gms.measurement.internal.zzfz r3 = r1.zzc
            zzak(r3)
            boolean r3 = r3.zzs(r10)
            if (r3 == 0) goto L_0x007a
            goto L_0x0097
        L_0x007a:
            java.lang.String r3 = r2.zza
            boolean r3 = r15.equals(r3)
            if (r3 != 0) goto L_0x00de
            com.google.android.gms.measurement.internal.zzlp r11 = r34.zzv()
            com.google.android.gms.measurement.internal.zzlo r12 = r1.zzF
            r14 = 11
            java.lang.String r2 = r2.zza
            r17 = 0
            java.lang.String r15 = "_ev"
            r13 = r10
            r16 = r2
            r11.zzN(r12, r13, r14, r15, r16, r17)
            return
        L_0x0097:
            com.google.android.gms.measurement.internal.zzal r2 = r1.zze
            zzak(r2)
            com.google.android.gms.measurement.internal.zzg r2 = r2.zzj(r10)
            if (r2 == 0) goto L_0x00de
            long r3 = r2.zzl()
            long r5 = r2.zzc()
            long r3 = java.lang.Math.max(r3, r5)
            com.google.android.gms.common.util.Clock r5 = r34.zzaw()
            long r5 = r5.currentTimeMillis()
            long r5 = r5 - r3
            long r3 = java.lang.Math.abs(r5)
            r34.zzg()
            com.google.android.gms.measurement.internal.zzek r5 = com.google.android.gms.measurement.internal.zzel.zzy
            java.lang.Object r5 = r5.zza(r14)
            java.lang.Long r5 = (java.lang.Long) r5
            long r5 = r5.longValue()
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 <= 0) goto L_0x00de
            com.google.android.gms.measurement.internal.zzey r3 = r34.zzaz()
            com.google.android.gms.measurement.internal.zzew r3 = r3.zzc()
            java.lang.String r4 = "Fetching config for blocked app"
            r3.zza(r4)
            r1.zzC(r2)
        L_0x00de:
            return
        L_0x00df:
            com.google.android.gms.measurement.internal.zzez r2 = com.google.android.gms.measurement.internal.zzez.zzb(r35)
            com.google.android.gms.measurement.internal.zzlp r11 = r34.zzv()
            com.google.android.gms.measurement.internal.zzaf r12 = r34.zzg()
            int r12 = r12.zzd(r10)
            r11.zzM(r2, r12)
            com.google.android.gms.measurement.internal.zzav r2 = r2.zza()
            com.google.android.gms.measurement.internal.zzey r11 = r34.zzaz()
            java.lang.String r11 = r11.zzq()
            r13 = 2
            boolean r11 = android.util.Log.isLoggable(r11, r13)
            if (r11 == 0) goto L_0x011c
            com.google.android.gms.measurement.internal.zzey r11 = r34.zzaz()
            com.google.android.gms.measurement.internal.zzew r11 = r11.zzj()
            com.google.android.gms.measurement.internal.zzgi r12 = r1.zzn
            com.google.android.gms.measurement.internal.zzet r12 = r12.zzj()
            java.lang.String r12 = r12.zzc(r2)
            java.lang.String r13 = "Logging event"
            r11.zzb(r13, r12)
        L_0x011c:
            com.google.android.gms.measurement.internal.zzal r11 = r1.zze
            zzak(r11)
            r11.zzw()
            r1.zzd(r3)     // Catch:{ all -> 0x0a9d }
            com.google.android.gms.internal.measurement.zzne.zzc()     // Catch:{ all -> 0x0a9d }
            com.google.android.gms.measurement.internal.zzaf r11 = r34.zzg()     // Catch:{ all -> 0x0a9d }
            com.google.android.gms.measurement.internal.zzek r12 = com.google.android.gms.measurement.internal.zzel.zzan     // Catch:{ all -> 0x0a9d }
            boolean r11 = r11.zzs(r14, r12)     // Catch:{ all -> 0x0a9d }
            if (r11 != 0) goto L_0x014e
            com.google.android.gms.measurement.internal.zzaf r11 = r34.zzg()     // Catch:{ all -> 0x0a9d }
            com.google.android.gms.measurement.internal.zzek r12 = com.google.android.gms.measurement.internal.zzel.zzao     // Catch:{ all -> 0x0a9d }
            boolean r11 = r11.zzs(r14, r12)     // Catch:{ all -> 0x0a9d }
            if (r11 == 0) goto L_0x014e
            com.google.android.gms.measurement.internal.zzal r11 = r1.zze     // Catch:{ all -> 0x0a9d }
            zzak(r11)     // Catch:{ all -> 0x0a9d }
            java.lang.String r12 = r3.zza     // Catch:{ all -> 0x0a9d }
            java.lang.String r13 = "_lair"
            r11.zzA(r12, r13)     // Catch:{ all -> 0x0a9d }
        L_0x014e:
            java.lang.String r11 = "ecommerce_purchase"
            java.lang.String r12 = r2.zza     // Catch:{ all -> 0x0a9d }
            boolean r11 = r11.equals(r12)     // Catch:{ all -> 0x0a9d }
            java.lang.String r12 = "refund"
            r28 = r8
            if (r11 != 0) goto L_0x0171
            java.lang.String r9 = "purchase"
            java.lang.String r11 = r2.zza     // Catch:{ all -> 0x0a9d }
            boolean r9 = r9.equals(r11)     // Catch:{ all -> 0x0a9d }
            if (r9 != 0) goto L_0x0171
            java.lang.String r9 = r2.zza     // Catch:{ all -> 0x0a9d }
            boolean r9 = r12.equals(r9)     // Catch:{ all -> 0x0a9d }
            if (r9 == 0) goto L_0x016f
            goto L_0x0171
        L_0x016f:
            r9 = 0
            goto L_0x0172
        L_0x0171:
            r9 = 1
        L_0x0172:
            java.lang.String r11 = "_iap"
            java.lang.String r13 = r2.zza     // Catch:{ all -> 0x0a9d }
            boolean r11 = r11.equals(r13)     // Catch:{ all -> 0x0a9d }
            if (r11 != 0) goto L_0x0185
            if (r9 == 0) goto L_0x0180
            r9 = 1
            goto L_0x0185
        L_0x0180:
            r33 = r4
            r8 = r15
            goto L_0x0318
        L_0x0185:
            com.google.android.gms.measurement.internal.zzat r11 = r2.zzb     // Catch:{ all -> 0x0a9d }
            java.lang.String r13 = "currency"
            java.lang.String r11 = r11.zzg(r13)     // Catch:{ all -> 0x0a9d }
            if (r9 == 0) goto L_0x01f8
            com.google.android.gms.measurement.internal.zzat r9 = r2.zzb     // Catch:{ all -> 0x0a9d }
            java.lang.Double r9 = r9.zzd()     // Catch:{ all -> 0x0a9d }
            double r17 = r9.doubleValue()     // Catch:{ all -> 0x0a9d }
            r19 = 4696837146684686336(0x412e848000000000, double:1000000.0)
            double r17 = r17 * r19
            r21 = 0
            int r9 = (r17 > r21 ? 1 : (r17 == r21 ? 0 : -1))
            if (r9 != 0) goto L_0x01b6
            com.google.android.gms.measurement.internal.zzat r9 = r2.zzb     // Catch:{ all -> 0x0a9d }
            java.lang.Long r9 = r9.zze()     // Catch:{ all -> 0x0a9d }
            r21 = r15
            long r14 = r9.longValue()     // Catch:{ all -> 0x0a9d }
            double r13 = (double) r14     // Catch:{ all -> 0x0a9d }
            double r17 = r13 * r19
            goto L_0x01b8
        L_0x01b6:
            r21 = r15
        L_0x01b8:
            r13 = 4890909195324358656(0x43e0000000000000, double:9.223372036854776E18)
            int r9 = (r17 > r13 ? 1 : (r17 == r13 ? 0 : -1))
            if (r9 > 0) goto L_0x01d2
            r13 = -4332462841530417152(0xc3e0000000000000, double:-9.223372036854776E18)
            int r9 = (r17 > r13 ? 1 : (r17 == r13 ? 0 : -1))
            if (r9 < 0) goto L_0x01d2
            long r13 = java.lang.Math.round(r17)     // Catch:{ all -> 0x0a9d }
            java.lang.String r9 = r2.zza     // Catch:{ all -> 0x0a9d }
            boolean r9 = r12.equals(r9)     // Catch:{ all -> 0x0a9d }
            if (r9 == 0) goto L_0x0204
            long r13 = -r13
            goto L_0x0204
        L_0x01d2:
            com.google.android.gms.measurement.internal.zzey r2 = r34.zzaz()     // Catch:{ all -> 0x0a9d }
            com.google.android.gms.measurement.internal.zzew r2 = r2.zzk()     // Catch:{ all -> 0x0a9d }
            java.lang.String r3 = "Data lost. Currency value is too big. appId"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzey.zzn(r10)     // Catch:{ all -> 0x0a9d }
            java.lang.Double r5 = java.lang.Double.valueOf(r17)     // Catch:{ all -> 0x0a9d }
            r2.zzc(r3, r4, r5)     // Catch:{ all -> 0x0a9d }
            com.google.android.gms.measurement.internal.zzal r2 = r1.zze     // Catch:{ all -> 0x0a9d }
            zzak(r2)     // Catch:{ all -> 0x0a9d }
            r2.zzC()     // Catch:{ all -> 0x0a9d }
            com.google.android.gms.measurement.internal.zzal r2 = r1.zze
            zzak(r2)
            r2.zzx()
            return
        L_0x01f8:
            r21 = r15
            com.google.android.gms.measurement.internal.zzat r9 = r2.zzb     // Catch:{ all -> 0x0a9d }
            java.lang.Long r9 = r9.zze()     // Catch:{ all -> 0x0a9d }
            long r13 = r9.longValue()     // Catch:{ all -> 0x0a9d }
        L_0x0204:
            boolean r9 = android.text.TextUtils.isEmpty(r11)     // Catch:{ all -> 0x0a9d }
            if (r9 != 0) goto L_0x0314
            java.util.Locale r9 = java.util.Locale.US     // Catch:{ all -> 0x0a9d }
            java.lang.String r9 = r11.toUpperCase(r9)     // Catch:{ all -> 0x0a9d }
            java.lang.String r11 = "[A-Z]{3}"
            boolean r11 = r9.matches(r11)     // Catch:{ all -> 0x0a9d }
            if (r11 == 0) goto L_0x0314
            java.lang.String r11 = "_ltv_"
            java.lang.String r9 = r11.concat(r9)     // Catch:{ all -> 0x0a9d }
            com.google.android.gms.measurement.internal.zzal r11 = r1.zze     // Catch:{ all -> 0x0a9d }
            zzak(r11)     // Catch:{ all -> 0x0a9d }
            com.google.android.gms.measurement.internal.zzln r11 = r11.zzp(r10, r9)     // Catch:{ all -> 0x0a9d }
            if (r11 == 0) goto L_0x025e
            java.lang.Object r11 = r11.zze     // Catch:{ all -> 0x0a9d }
            boolean r12 = r11 instanceof java.lang.Long     // Catch:{ all -> 0x0a9d }
            if (r12 != 0) goto L_0x0230
            goto L_0x025e
        L_0x0230:
            java.lang.Long r11 = (java.lang.Long) r11     // Catch:{ all -> 0x0a9d }
            long r11 = r11.longValue()     // Catch:{ all -> 0x0a9d }
            com.google.android.gms.measurement.internal.zzln r18 = new com.google.android.gms.measurement.internal.zzln     // Catch:{ all -> 0x0a9d }
            java.lang.String r15 = r2.zzc     // Catch:{ all -> 0x0a9d }
            com.google.android.gms.common.util.Clock r17 = r34.zzaw()     // Catch:{ all -> 0x0a9d }
            long r19 = r17.currentTimeMillis()     // Catch:{ all -> 0x0a9d }
            long r11 = r11 + r13
            java.lang.Long r17 = java.lang.Long.valueOf(r11)     // Catch:{ all -> 0x0a9d }
            r11 = r18
            r12 = r10
            r14 = 0
            r13 = r15
            r8 = 0
            r15 = 0
            r14 = r9
            r9 = r21
            r15 = r19
            r11.<init>(r12, r13, r14, r15, r17)     // Catch:{ all -> 0x0a9d }
            r33 = r4
            r8 = r9
            r9 = r18
            r4 = 2
            goto L_0x02d8
        L_0x025e:
            r15 = r21
            r8 = 0
            com.google.android.gms.measurement.internal.zzal r11 = r1.zze     // Catch:{ all -> 0x0a9d }
            zzak(r11)     // Catch:{ all -> 0x0a9d }
            com.google.android.gms.measurement.internal.zzaf r12 = r34.zzg()     // Catch:{ all -> 0x0a9d }
            com.google.android.gms.measurement.internal.zzek r8 = com.google.android.gms.measurement.internal.zzel.zzD     // Catch:{ all -> 0x0a9d }
            int r8 = r12.zze(r10, r8)     // Catch:{ all -> 0x0a9d }
            int r8 = r8 + -1
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r10)     // Catch:{ all -> 0x0a9d }
            r11.zzg()     // Catch:{ all -> 0x0a9d }
            r11.zzW()     // Catch:{ all -> 0x0a9d }
            android.database.sqlite.SQLiteDatabase r12 = r11.zzh()     // Catch:{ SQLiteException -> 0x02a3 }
            r21 = r15
            r15 = 3
            java.lang.String[] r15 = new java.lang.String[r15]     // Catch:{ SQLiteException -> 0x029e }
            r16 = 0
            r15[r16] = r10     // Catch:{ SQLiteException -> 0x029e }
            r16 = 1
            r15[r16] = r10     // Catch:{ SQLiteException -> 0x029e }
            java.lang.String r8 = java.lang.String.valueOf(r8)     // Catch:{ SQLiteException -> 0x029e }
            r33 = r4
            r4 = 2
            r15[r4] = r8     // Catch:{ SQLiteException -> 0x029b }
            java.lang.String r8 = "delete from user_attributes where app_id=? and name in (select name from user_attributes where app_id=? and name like '_ltv_%' order by set_timestamp desc limit ?,10);"
            r12.execSQL(r8, r15)     // Catch:{ SQLiteException -> 0x029b }
            goto L_0x02bc
        L_0x029b:
            r0 = move-exception
        L_0x029c:
            r8 = r0
            goto L_0x02a9
        L_0x029e:
            r0 = move-exception
            r33 = r4
        L_0x02a1:
            r4 = 2
            goto L_0x029c
        L_0x02a3:
            r0 = move-exception
            r33 = r4
            r21 = r15
            goto L_0x02a1
        L_0x02a9:
            com.google.android.gms.measurement.internal.zzgi r11 = r11.zzs     // Catch:{ all -> 0x0a9d }
            com.google.android.gms.measurement.internal.zzey r11 = r11.zzaz()     // Catch:{ all -> 0x0a9d }
            com.google.android.gms.measurement.internal.zzew r11 = r11.zzd()     // Catch:{ all -> 0x0a9d }
            java.lang.String r12 = "Error pruning currencies. appId"
            java.lang.Object r15 = com.google.android.gms.measurement.internal.zzey.zzn(r10)     // Catch:{ all -> 0x0a9d }
            r11.zzc(r12, r15, r8)     // Catch:{ all -> 0x0a9d }
        L_0x02bc:
            com.google.android.gms.measurement.internal.zzln r18 = new com.google.android.gms.measurement.internal.zzln     // Catch:{ all -> 0x0a9d }
            java.lang.String r8 = r2.zzc     // Catch:{ all -> 0x0a9d }
            com.google.android.gms.common.util.Clock r11 = r34.zzaw()     // Catch:{ all -> 0x0a9d }
            long r15 = r11.currentTimeMillis()     // Catch:{ all -> 0x0a9d }
            java.lang.Long r17 = java.lang.Long.valueOf(r13)     // Catch:{ all -> 0x0a9d }
            r11 = r18
            r12 = r10
            r13 = r8
            r14 = r9
            r8 = r21
            r11.<init>(r12, r13, r14, r15, r17)     // Catch:{ all -> 0x0a9d }
            r9 = r18
        L_0x02d8:
            com.google.android.gms.measurement.internal.zzal r11 = r1.zze     // Catch:{ all -> 0x0a9d }
            zzak(r11)     // Catch:{ all -> 0x0a9d }
            boolean r11 = r11.zzL(r9)     // Catch:{ all -> 0x0a9d }
            if (r11 != 0) goto L_0x0319
            com.google.android.gms.measurement.internal.zzey r11 = r34.zzaz()     // Catch:{ all -> 0x0a9d }
            com.google.android.gms.measurement.internal.zzew r11 = r11.zzd()     // Catch:{ all -> 0x0a9d }
            java.lang.String r12 = "Too many unique user properties are set. Ignoring user property. appId"
            java.lang.Object r13 = com.google.android.gms.measurement.internal.zzey.zzn(r10)     // Catch:{ all -> 0x0a9d }
            com.google.android.gms.measurement.internal.zzgi r14 = r1.zzn     // Catch:{ all -> 0x0a9d }
            com.google.android.gms.measurement.internal.zzet r14 = r14.zzj()     // Catch:{ all -> 0x0a9d }
            java.lang.String r15 = r9.zzc     // Catch:{ all -> 0x0a9d }
            java.lang.String r14 = r14.zzf(r15)     // Catch:{ all -> 0x0a9d }
            java.lang.Object r9 = r9.zze     // Catch:{ all -> 0x0a9d }
            r11.zzd(r12, r13, r14, r9)     // Catch:{ all -> 0x0a9d }
            com.google.android.gms.measurement.internal.zzlp r11 = r34.zzv()     // Catch:{ all -> 0x0a9d }
            com.google.android.gms.measurement.internal.zzlo r12 = r1.zzF     // Catch:{ all -> 0x0a9d }
            r14 = 9
            r15 = 0
            r16 = 0
            r17 = 0
            r13 = r10
            r11.zzN(r12, r13, r14, r15, r16, r17)     // Catch:{ all -> 0x0a9d }
            goto L_0x0319
        L_0x0314:
            r33 = r4
            r8 = r21
        L_0x0318:
            r4 = 2
        L_0x0319:
            java.lang.String r9 = r2.zza     // Catch:{ all -> 0x0a9d }
            boolean r9 = com.google.android.gms.measurement.internal.zzlp.zzai(r9)     // Catch:{ all -> 0x0a9d }
            java.lang.String r11 = r2.zza     // Catch:{ all -> 0x0a9d }
            boolean r8 = r8.equals(r11)     // Catch:{ all -> 0x0a9d }
            r34.zzv()     // Catch:{ all -> 0x0a9d }
            com.google.android.gms.measurement.internal.zzat r11 = r2.zzb     // Catch:{ all -> 0x0a9d }
            if (r11 != 0) goto L_0x032f
            r16 = 0
            goto L_0x0356
        L_0x032f:
            android.os.Bundle r12 = r11.zza     // Catch:{ all -> 0x0a9d }
            java.util.Set r12 = r12.keySet()     // Catch:{ all -> 0x0a9d }
            java.util.Iterator r12 = r12.iterator()     // Catch:{ all -> 0x0a9d }
            r16 = 0
        L_0x033b:
            boolean r13 = r12.hasNext()     // Catch:{ all -> 0x0a9d }
            if (r13 == 0) goto L_0x0356
            java.lang.Object r13 = r12.next()     // Catch:{ all -> 0x0a9d }
            java.lang.String r13 = (java.lang.String) r13     // Catch:{ all -> 0x0a9d }
            java.lang.Object r13 = r11.zzf(r13)     // Catch:{ all -> 0x0a9d }
            boolean r14 = r13 instanceof android.os.Parcelable[]     // Catch:{ all -> 0x0a9d }
            if (r14 == 0) goto L_0x033b
            android.os.Parcelable[] r13 = (android.os.Parcelable[]) r13     // Catch:{ all -> 0x0a9d }
            int r13 = r13.length     // Catch:{ all -> 0x0a9d }
            long r13 = (long) r13     // Catch:{ all -> 0x0a9d }
            long r16 = r16 + r13
            goto L_0x033b
        L_0x0356:
            r22 = 1
            long r15 = r16 + r22
            com.google.android.gms.measurement.internal.zzal r11 = r1.zze     // Catch:{ all -> 0x0a9d }
            zzak(r11)     // Catch:{ all -> 0x0a9d }
            long r12 = r34.zza()     // Catch:{ all -> 0x0a9d }
            r17 = 1
            r20 = 0
            r21 = 0
            r30 = r5
            r4 = 0
            r14 = r10
            r18 = r9
            r19 = r20
            r20 = r8
            com.google.android.gms.measurement.internal.zzaj r11 = r11.zzm(r12, r14, r15, r17, r18, r19, r20, r21)     // Catch:{ all -> 0x0a9d }
            long r12 = r11.zzb     // Catch:{ all -> 0x0a9d }
            r34.zzg()     // Catch:{ all -> 0x0a9d }
            com.google.android.gms.measurement.internal.zzek r14 = com.google.android.gms.measurement.internal.zzel.zzj     // Catch:{ all -> 0x0a9d }
            r15 = 0
            java.lang.Object r14 = r14.zza(r15)     // Catch:{ all -> 0x0a9d }
            java.lang.Integer r14 = (java.lang.Integer) r14     // Catch:{ all -> 0x0a9d }
            int r14 = r14.intValue()     // Catch:{ all -> 0x0a9d }
            long r4 = (long) r14     // Catch:{ all -> 0x0a9d }
            long r12 = r12 - r4
            r4 = 1000(0x3e8, double:4.94E-321)
            r16 = 0
            int r14 = (r12 > r16 ? 1 : (r12 == r16 ? 0 : -1))
            if (r14 <= 0) goto L_0x03c1
            long r12 = r12 % r4
            int r2 = (r12 > r22 ? 1 : (r12 == r22 ? 0 : -1))
            if (r2 != 0) goto L_0x03b0
            com.google.android.gms.measurement.internal.zzey r2 = r34.zzaz()     // Catch:{ all -> 0x0a9d }
            com.google.android.gms.measurement.internal.zzew r2 = r2.zzd()     // Catch:{ all -> 0x0a9d }
            java.lang.String r3 = "Data loss. Too many events logged. appId, count"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzey.zzn(r10)     // Catch:{ all -> 0x0a9d }
            long r5 = r11.zzb     // Catch:{ all -> 0x0a9d }
            java.lang.Long r5 = java.lang.Long.valueOf(r5)     // Catch:{ all -> 0x0a9d }
            r2.zzc(r3, r4, r5)     // Catch:{ all -> 0x0a9d }
        L_0x03b0:
            com.google.android.gms.measurement.internal.zzal r2 = r1.zze     // Catch:{ all -> 0x0a9d }
            zzak(r2)     // Catch:{ all -> 0x0a9d }
            r2.zzC()     // Catch:{ all -> 0x0a9d }
            com.google.android.gms.measurement.internal.zzal r2 = r1.zze
            zzak(r2)
            r2.zzx()
            return
        L_0x03c1:
            if (r9 == 0) goto L_0x041f
            long r12 = r11.zza     // Catch:{ all -> 0x0a9d }
            r34.zzg()     // Catch:{ all -> 0x0a9d }
            com.google.android.gms.measurement.internal.zzek r14 = com.google.android.gms.measurement.internal.zzel.zzl     // Catch:{ all -> 0x0a9d }
            java.lang.Object r14 = r14.zza(r15)     // Catch:{ all -> 0x0a9d }
            java.lang.Integer r14 = (java.lang.Integer) r14     // Catch:{ all -> 0x0a9d }
            int r14 = r14.intValue()     // Catch:{ all -> 0x0a9d }
            long r4 = (long) r14     // Catch:{ all -> 0x0a9d }
            long r12 = r12 - r4
            r4 = 0
            int r14 = (r12 > r4 ? 1 : (r12 == r4 ? 0 : -1))
            if (r14 <= 0) goto L_0x041f
            r4 = 1000(0x3e8, double:4.94E-321)
            long r12 = r12 % r4
            int r3 = (r12 > r22 ? 1 : (r12 == r22 ? 0 : -1))
            if (r3 != 0) goto L_0x03fa
            com.google.android.gms.measurement.internal.zzey r3 = r34.zzaz()     // Catch:{ all -> 0x0a9d }
            com.google.android.gms.measurement.internal.zzew r3 = r3.zzd()     // Catch:{ all -> 0x0a9d }
            java.lang.String r4 = "Data loss. Too many public events logged. appId, count"
            java.lang.Object r5 = com.google.android.gms.measurement.internal.zzey.zzn(r10)     // Catch:{ all -> 0x0a9d }
            long r6 = r11.zza     // Catch:{ all -> 0x0a9d }
            java.lang.Long r6 = java.lang.Long.valueOf(r6)     // Catch:{ all -> 0x0a9d }
            r3.zzc(r4, r5, r6)     // Catch:{ all -> 0x0a9d }
        L_0x03fa:
            com.google.android.gms.measurement.internal.zzlp r11 = r34.zzv()     // Catch:{ all -> 0x0a9d }
            com.google.android.gms.measurement.internal.zzlo r12 = r1.zzF     // Catch:{ all -> 0x0a9d }
            r14 = 16
            java.lang.String r15 = "_ev"
            java.lang.String r2 = r2.zza     // Catch:{ all -> 0x0a9d }
            r17 = 0
            r13 = r10
            r16 = r2
            r11.zzN(r12, r13, r14, r15, r16, r17)     // Catch:{ all -> 0x0a9d }
            com.google.android.gms.measurement.internal.zzal r2 = r1.zze     // Catch:{ all -> 0x0a9d }
            zzak(r2)     // Catch:{ all -> 0x0a9d }
            r2.zzC()     // Catch:{ all -> 0x0a9d }
            com.google.android.gms.measurement.internal.zzal r2 = r1.zze
            zzak(r2)
            r2.zzx()
            return
        L_0x041f:
            r4 = 1000000(0xf4240, float:1.401298E-39)
            if (r8 == 0) goto L_0x046f
            long r12 = r11.zzd     // Catch:{ all -> 0x0a9d }
            com.google.android.gms.measurement.internal.zzaf r5 = r34.zzg()     // Catch:{ all -> 0x0a9d }
            java.lang.String r8 = r3.zza     // Catch:{ all -> 0x0a9d }
            com.google.android.gms.measurement.internal.zzek r14 = com.google.android.gms.measurement.internal.zzel.zzk     // Catch:{ all -> 0x0a9d }
            int r5 = r5.zze(r8, r14)     // Catch:{ all -> 0x0a9d }
            int r5 = java.lang.Math.min(r4, r5)     // Catch:{ all -> 0x0a9d }
            r8 = 0
            int r5 = java.lang.Math.max(r8, r5)     // Catch:{ all -> 0x0a9d }
            long r4 = (long) r5     // Catch:{ all -> 0x0a9d }
            long r12 = r12 - r4
            r4 = 0
            int r14 = (r12 > r4 ? 1 : (r12 == r4 ? 0 : -1))
            if (r14 <= 0) goto L_0x046f
            int r2 = (r12 > r22 ? 1 : (r12 == r22 ? 0 : -1))
            if (r2 != 0) goto L_0x045e
            com.google.android.gms.measurement.internal.zzey r2 = r34.zzaz()     // Catch:{ all -> 0x0a9d }
            com.google.android.gms.measurement.internal.zzew r2 = r2.zzd()     // Catch:{ all -> 0x0a9d }
            java.lang.String r3 = "Too many error events logged. appId, count"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzey.zzn(r10)     // Catch:{ all -> 0x0a9d }
            long r5 = r11.zzd     // Catch:{ all -> 0x0a9d }
            java.lang.Long r5 = java.lang.Long.valueOf(r5)     // Catch:{ all -> 0x0a9d }
            r2.zzc(r3, r4, r5)     // Catch:{ all -> 0x0a9d }
        L_0x045e:
            com.google.android.gms.measurement.internal.zzal r2 = r1.zze     // Catch:{ all -> 0x0a9d }
            zzak(r2)     // Catch:{ all -> 0x0a9d }
            r2.zzC()     // Catch:{ all -> 0x0a9d }
            com.google.android.gms.measurement.internal.zzal r2 = r1.zze
            zzak(r2)
            r2.zzx()
            return
        L_0x046f:
            com.google.android.gms.measurement.internal.zzat r4 = r2.zzb     // Catch:{ all -> 0x0a9d }
            android.os.Bundle r4 = r4.zzc()     // Catch:{ all -> 0x0a9d }
            com.google.android.gms.measurement.internal.zzlp r5 = r34.zzv()     // Catch:{ all -> 0x0a9d }
            java.lang.String r11 = "_o"
            java.lang.String r12 = r2.zzc     // Catch:{ all -> 0x0a9d }
            r5.zzO(r4, r11, r12)     // Catch:{ all -> 0x0a9d }
            com.google.android.gms.measurement.internal.zzlp r5 = r34.zzv()     // Catch:{ all -> 0x0a9d }
            boolean r5 = r5.zzae(r10)     // Catch:{ all -> 0x0a9d }
            java.lang.String r14 = "_r"
            if (r5 == 0) goto L_0x04a0
            com.google.android.gms.measurement.internal.zzlp r5 = r34.zzv()     // Catch:{ all -> 0x0a9d }
            java.lang.Long r11 = java.lang.Long.valueOf(r22)     // Catch:{ all -> 0x0a9d }
            java.lang.String r12 = "_dbg"
            r5.zzO(r4, r12, r11)     // Catch:{ all -> 0x0a9d }
            com.google.android.gms.measurement.internal.zzlp r5 = r34.zzv()     // Catch:{ all -> 0x0a9d }
            r5.zzO(r4, r14, r11)     // Catch:{ all -> 0x0a9d }
        L_0x04a0:
            java.lang.String r5 = "_s"
            java.lang.String r11 = r2.zza     // Catch:{ all -> 0x0a9d }
            boolean r5 = r5.equals(r11)     // Catch:{ all -> 0x0a9d }
            if (r5 == 0) goto L_0x04c6
            com.google.android.gms.measurement.internal.zzal r5 = r1.zze     // Catch:{ all -> 0x0a9d }
            zzak(r5)     // Catch:{ all -> 0x0a9d }
            java.lang.String r11 = r3.zza     // Catch:{ all -> 0x0a9d }
            com.google.android.gms.measurement.internal.zzln r5 = r5.zzp(r11, r7)     // Catch:{ all -> 0x0a9d }
            if (r5 == 0) goto L_0x04c6
            java.lang.Object r11 = r5.zze     // Catch:{ all -> 0x0a9d }
            boolean r11 = r11 instanceof java.lang.Long     // Catch:{ all -> 0x0a9d }
            if (r11 == 0) goto L_0x04c6
            com.google.android.gms.measurement.internal.zzlp r11 = r34.zzv()     // Catch:{ all -> 0x0a9d }
            java.lang.Object r5 = r5.zze     // Catch:{ all -> 0x0a9d }
            r11.zzO(r4, r7, r5)     // Catch:{ all -> 0x0a9d }
        L_0x04c6:
            com.google.android.gms.measurement.internal.zzal r5 = r1.zze     // Catch:{ all -> 0x0a9d }
            zzak(r5)     // Catch:{ all -> 0x0a9d }
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r10)     // Catch:{ all -> 0x0a9d }
            r5.zzg()     // Catch:{ all -> 0x0a9d }
            r5.zzW()     // Catch:{ all -> 0x0a9d }
            android.database.sqlite.SQLiteDatabase r7 = r5.zzh()     // Catch:{ SQLiteException -> 0x0507 }
            com.google.android.gms.measurement.internal.zzgi r11 = r5.zzs     // Catch:{ SQLiteException -> 0x0507 }
            com.google.android.gms.measurement.internal.zzaf r11 = r11.zzf()     // Catch:{ SQLiteException -> 0x0507 }
            com.google.android.gms.measurement.internal.zzek r12 = com.google.android.gms.measurement.internal.zzel.zzo     // Catch:{ SQLiteException -> 0x0507 }
            int r11 = r11.zze(r10, r12)     // Catch:{ SQLiteException -> 0x0507 }
            r8 = 1000000(0xf4240, float:1.401298E-39)
            int r8 = java.lang.Math.min(r8, r11)     // Catch:{ SQLiteException -> 0x0507 }
            r13 = 0
            int r8 = java.lang.Math.max(r13, r8)     // Catch:{ SQLiteException -> 0x0504 }
            java.lang.String r8 = java.lang.String.valueOf(r8)     // Catch:{ SQLiteException -> 0x0504 }
            r11 = 2
            java.lang.String[] r11 = new java.lang.String[r11]     // Catch:{ SQLiteException -> 0x0504 }
            r11[r13] = r10     // Catch:{ SQLiteException -> 0x0504 }
            r12 = 1
            r11[r12] = r8     // Catch:{ SQLiteException -> 0x0504 }
            java.lang.String r8 = "rowid in (select rowid from raw_events where app_id=? order by rowid desc limit -1 offset ?)"
            int r5 = r7.delete(r6, r8, r11)     // Catch:{ SQLiteException -> 0x0504 }
            long r7 = (long) r5
            goto L_0x051f
        L_0x0504:
            r0 = move-exception
        L_0x0505:
            r7 = r0
            goto L_0x050a
        L_0x0507:
            r0 = move-exception
            r13 = 0
            goto L_0x0505
        L_0x050a:
            com.google.android.gms.measurement.internal.zzgi r5 = r5.zzs     // Catch:{ all -> 0x0a9d }
            com.google.android.gms.measurement.internal.zzey r5 = r5.zzaz()     // Catch:{ all -> 0x0a9d }
            com.google.android.gms.measurement.internal.zzew r5 = r5.zzd()     // Catch:{ all -> 0x0a9d }
            java.lang.String r8 = "Error deleting over the limit events. appId"
            java.lang.Object r11 = com.google.android.gms.measurement.internal.zzey.zzn(r10)     // Catch:{ all -> 0x0a9d }
            r5.zzc(r8, r11, r7)     // Catch:{ all -> 0x0a9d }
            r7 = 0
        L_0x051f:
            r11 = 0
            int r5 = (r7 > r11 ? 1 : (r7 == r11 ? 0 : -1))
            if (r5 <= 0) goto L_0x053a
            com.google.android.gms.measurement.internal.zzey r5 = r34.zzaz()     // Catch:{ all -> 0x0a9d }
            com.google.android.gms.measurement.internal.zzew r5 = r5.zzk()     // Catch:{ all -> 0x0a9d }
            java.lang.String r11 = "Data lost. Too many events stored on disk, deleted. appId"
            java.lang.Object r12 = com.google.android.gms.measurement.internal.zzey.zzn(r10)     // Catch:{ all -> 0x0a9d }
            java.lang.Long r7 = java.lang.Long.valueOf(r7)     // Catch:{ all -> 0x0a9d }
            r5.zzc(r11, r12, r7)     // Catch:{ all -> 0x0a9d }
        L_0x053a:
            com.google.android.gms.measurement.internal.zzaq r5 = new com.google.android.gms.measurement.internal.zzaq     // Catch:{ all -> 0x0a9d }
            com.google.android.gms.measurement.internal.zzgi r12 = r1.zzn     // Catch:{ all -> 0x0a9d }
            java.lang.String r7 = r2.zzc     // Catch:{ all -> 0x0a9d }
            java.lang.String r8 = r2.zza     // Catch:{ all -> 0x0a9d }
            long r2 = r2.zzd     // Catch:{ all -> 0x0a9d }
            r18 = 0
            r11 = r5
            r31 = 0
            r13 = r7
            r7 = r14
            r14 = r10
            r32 = r6
            r6 = r15
            r15 = r8
            r16 = r2
            r20 = r4
            r11.<init>(r12, r13, r14, r15, r16, r18, r20)     // Catch:{ all -> 0x0a9d }
            com.google.android.gms.measurement.internal.zzal r2 = r1.zze     // Catch:{ all -> 0x0a9d }
            zzak(r2)     // Catch:{ all -> 0x0a9d }
            java.lang.String r3 = r5.zzb     // Catch:{ all -> 0x0a9d }
            com.google.android.gms.measurement.internal.zzar r2 = r2.zzn(r10, r3)     // Catch:{ all -> 0x0a9d }
            if (r2 != 0) goto L_0x05dd
            com.google.android.gms.measurement.internal.zzal r2 = r1.zze     // Catch:{ all -> 0x0a9d }
            zzak(r2)     // Catch:{ all -> 0x0a9d }
            long r2 = r2.zzf(r10)     // Catch:{ all -> 0x0a9d }
            com.google.android.gms.measurement.internal.zzaf r4 = r34.zzg()     // Catch:{ all -> 0x0a9d }
            int r4 = r4.zzb(r10)     // Catch:{ all -> 0x0a9d }
            long r11 = (long) r4     // Catch:{ all -> 0x0a9d }
            int r4 = (r2 > r11 ? 1 : (r2 == r11 ? 0 : -1))
            if (r4 < 0) goto L_0x05bf
            if (r9 == 0) goto L_0x05bf
            com.google.android.gms.measurement.internal.zzey r2 = r34.zzaz()     // Catch:{ all -> 0x0a9d }
            com.google.android.gms.measurement.internal.zzew r2 = r2.zzd()     // Catch:{ all -> 0x0a9d }
            java.lang.String r3 = "Too many event names used, ignoring event. appId, name, supported count"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzey.zzn(r10)     // Catch:{ all -> 0x0a9d }
            com.google.android.gms.measurement.internal.zzgi r6 = r1.zzn     // Catch:{ all -> 0x0a9d }
            com.google.android.gms.measurement.internal.zzet r6 = r6.zzj()     // Catch:{ all -> 0x0a9d }
            java.lang.String r5 = r5.zzb     // Catch:{ all -> 0x0a9d }
            java.lang.String r5 = r6.zzd(r5)     // Catch:{ all -> 0x0a9d }
            com.google.android.gms.measurement.internal.zzaf r6 = r34.zzg()     // Catch:{ all -> 0x0a9d }
            int r6 = r6.zzb(r10)     // Catch:{ all -> 0x0a9d }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ all -> 0x0a9d }
            r2.zzd(r3, r4, r5, r6)     // Catch:{ all -> 0x0a9d }
            com.google.android.gms.measurement.internal.zzlp r11 = r34.zzv()     // Catch:{ all -> 0x0a9d }
            com.google.android.gms.measurement.internal.zzlo r12 = r1.zzF     // Catch:{ all -> 0x0a9d }
            r14 = 8
            r15 = 0
            r16 = 0
            r17 = 0
            r13 = r10
            r11.zzN(r12, r13, r14, r15, r16, r17)     // Catch:{ all -> 0x0a9d }
            com.google.android.gms.measurement.internal.zzal r2 = r1.zze
            zzak(r2)
            r2.zzx()
            return
        L_0x05bf:
            com.google.android.gms.measurement.internal.zzar r2 = new com.google.android.gms.measurement.internal.zzar     // Catch:{ all -> 0x0a9d }
            java.lang.String r13 = r5.zzb     // Catch:{ all -> 0x0a9d }
            long r3 = r5.zzd     // Catch:{ all -> 0x0a9d }
            r14 = 0
            r16 = 0
            r18 = 0
            r22 = 0
            r24 = 0
            r25 = 0
            r26 = 0
            r27 = 0
            r11 = r2
            r12 = r10
            r20 = r3
            r11.<init>(r12, r13, r14, r16, r18, r20, r22, r24, r25, r26, r27)     // Catch:{ all -> 0x0a9d }
            goto L_0x05eb
        L_0x05dd:
            com.google.android.gms.measurement.internal.zzgi r3 = r1.zzn     // Catch:{ all -> 0x0a9d }
            long r8 = r2.zzf     // Catch:{ all -> 0x0a9d }
            com.google.android.gms.measurement.internal.zzaq r5 = r5.zza(r3, r8)     // Catch:{ all -> 0x0a9d }
            long r3 = r5.zzd     // Catch:{ all -> 0x0a9d }
            com.google.android.gms.measurement.internal.zzar r2 = r2.zzc(r3)     // Catch:{ all -> 0x0a9d }
        L_0x05eb:
            com.google.android.gms.measurement.internal.zzal r3 = r1.zze     // Catch:{ all -> 0x0a9d }
            zzak(r3)     // Catch:{ all -> 0x0a9d }
            r3.zzE(r2)     // Catch:{ all -> 0x0a9d }
            com.google.android.gms.measurement.internal.zzgf r2 = r34.zzaA()     // Catch:{ all -> 0x0a9d }
            r2.zzg()     // Catch:{ all -> 0x0a9d }
            r34.zzB()     // Catch:{ all -> 0x0a9d }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r5)     // Catch:{ all -> 0x0a9d }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r36)     // Catch:{ all -> 0x0a9d }
            java.lang.String r2 = r5.zza     // Catch:{ all -> 0x0a9d }
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r2)     // Catch:{ all -> 0x0a9d }
            java.lang.String r2 = r5.zza     // Catch:{ all -> 0x0a9d }
            r3 = r36
            java.lang.String r4 = r3.zza     // Catch:{ all -> 0x0a9d }
            boolean r2 = r2.equals(r4)     // Catch:{ all -> 0x0a9d }
            com.google.android.gms.common.internal.Preconditions.checkArgument(r2)     // Catch:{ all -> 0x0a9d }
            com.google.android.gms.internal.measurement.zzgb r2 = com.google.android.gms.internal.measurement.zzgc.zzu()     // Catch:{ all -> 0x0a9d }
            r4 = 1
            r2.zzae(r4)     // Catch:{ all -> 0x0a9d }
            java.lang.String r8 = "android"
            r2.zzaa(r8)     // Catch:{ all -> 0x0a9d }
            java.lang.String r8 = r3.zza     // Catch:{ all -> 0x0a9d }
            boolean r8 = android.text.TextUtils.isEmpty(r8)     // Catch:{ all -> 0x0a9d }
            if (r8 != 0) goto L_0x062f
            java.lang.String r8 = r3.zza     // Catch:{ all -> 0x0a9d }
            r2.zzE(r8)     // Catch:{ all -> 0x0a9d }
        L_0x062f:
            java.lang.String r8 = r3.zzd     // Catch:{ all -> 0x0a9d }
            boolean r8 = android.text.TextUtils.isEmpty(r8)     // Catch:{ all -> 0x0a9d }
            if (r8 != 0) goto L_0x063c
            java.lang.String r8 = r3.zzd     // Catch:{ all -> 0x0a9d }
            r2.zzG(r8)     // Catch:{ all -> 0x0a9d }
        L_0x063c:
            java.lang.String r8 = r3.zzc     // Catch:{ all -> 0x0a9d }
            boolean r8 = android.text.TextUtils.isEmpty(r8)     // Catch:{ all -> 0x0a9d }
            if (r8 != 0) goto L_0x0649
            java.lang.String r8 = r3.zzc     // Catch:{ all -> 0x0a9d }
            r2.zzH(r8)     // Catch:{ all -> 0x0a9d }
        L_0x0649:
            com.google.android.gms.internal.measurement.zzpp.zzc()     // Catch:{ all -> 0x0a9d }
            com.google.android.gms.measurement.internal.zzaf r8 = r34.zzg()     // Catch:{ all -> 0x0a9d }
            com.google.android.gms.measurement.internal.zzek r9 = com.google.android.gms.measurement.internal.zzel.zzaH     // Catch:{ all -> 0x0a9d }
            boolean r8 = r8.zzs(r6, r9)     // Catch:{ all -> 0x0a9d }
            if (r8 == 0) goto L_0x0665
            java.lang.String r8 = r3.zzx     // Catch:{ all -> 0x0a9d }
            boolean r8 = android.text.TextUtils.isEmpty(r8)     // Catch:{ all -> 0x0a9d }
            if (r8 != 0) goto L_0x0665
            java.lang.String r8 = r3.zzx     // Catch:{ all -> 0x0a9d }
            r2.zzai(r8)     // Catch:{ all -> 0x0a9d }
        L_0x0665:
            long r8 = r3.zzj     // Catch:{ all -> 0x0a9d }
            r10 = -2147483648(0xffffffff80000000, double:NaN)
            int r12 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r12 == 0) goto L_0x0672
            int r9 = (int) r8     // Catch:{ all -> 0x0a9d }
            r2.zzI(r9)     // Catch:{ all -> 0x0a9d }
        L_0x0672:
            long r8 = r3.zze     // Catch:{ all -> 0x0a9d }
            r2.zzW(r8)     // Catch:{ all -> 0x0a9d }
            java.lang.String r8 = r3.zzb     // Catch:{ all -> 0x0a9d }
            boolean r8 = android.text.TextUtils.isEmpty(r8)     // Catch:{ all -> 0x0a9d }
            if (r8 != 0) goto L_0x0684
            java.lang.String r8 = r3.zzb     // Catch:{ all -> 0x0a9d }
            r2.zzV(r8)     // Catch:{ all -> 0x0a9d }
        L_0x0684:
            java.lang.String r8 = r3.zza     // Catch:{ all -> 0x0a9d }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r8)     // Catch:{ all -> 0x0a9d }
            com.google.android.gms.measurement.internal.zzah r8 = r1.zzh(r8)     // Catch:{ all -> 0x0a9d }
            java.lang.String r9 = r3.zzv     // Catch:{ all -> 0x0a9d }
            com.google.android.gms.measurement.internal.zzah r9 = com.google.android.gms.measurement.internal.zzah.zzb(r9)     // Catch:{ all -> 0x0a9d }
            com.google.android.gms.measurement.internal.zzah r8 = r8.zzc(r9)     // Catch:{ all -> 0x0a9d }
            java.lang.String r8 = r8.zzh()     // Catch:{ all -> 0x0a9d }
            r2.zzM(r8)     // Catch:{ all -> 0x0a9d }
            java.lang.String r8 = r2.zzar()     // Catch:{ all -> 0x0a9d }
            boolean r8 = android.text.TextUtils.isEmpty(r8)     // Catch:{ all -> 0x0a9d }
            if (r8 == 0) goto L_0x06b5
            java.lang.String r8 = r3.zzq     // Catch:{ all -> 0x0a9d }
            boolean r8 = android.text.TextUtils.isEmpty(r8)     // Catch:{ all -> 0x0a9d }
            if (r8 != 0) goto L_0x06b5
            java.lang.String r8 = r3.zzq     // Catch:{ all -> 0x0a9d }
            r2.zzC(r8)     // Catch:{ all -> 0x0a9d }
        L_0x06b5:
            long r8 = r3.zzf     // Catch:{ all -> 0x0a9d }
            r10 = 0
            int r12 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r12 == 0) goto L_0x06c0
            r2.zzN(r8)     // Catch:{ all -> 0x0a9d }
        L_0x06c0:
            long r8 = r3.zzs     // Catch:{ all -> 0x0a9d }
            r2.zzQ(r8)     // Catch:{ all -> 0x0a9d }
            com.google.android.gms.measurement.internal.zzlk r8 = r1.zzi     // Catch:{ all -> 0x0a9d }
            zzak(r8)     // Catch:{ all -> 0x0a9d }
            com.google.android.gms.measurement.internal.zzli r9 = r8.zzf     // Catch:{ all -> 0x0a9d }
            com.google.android.gms.measurement.internal.zzgi r9 = r9.zzn     // Catch:{ all -> 0x0a9d }
            android.content.Context r9 = r9.zzav()     // Catch:{ all -> 0x0a9d }
            java.util.Map r9 = com.google.android.gms.measurement.internal.zzel.zzc(r9)     // Catch:{ all -> 0x0a9d }
            if (r9 == 0) goto L_0x075c
            int r10 = r9.size()     // Catch:{ all -> 0x0a9d }
            if (r10 != 0) goto L_0x06e0
            goto L_0x075c
        L_0x06e0:
            java.util.ArrayList r14 = new java.util.ArrayList     // Catch:{ all -> 0x0a9d }
            r14.<init>()     // Catch:{ all -> 0x0a9d }
            com.google.android.gms.measurement.internal.zzek r10 = com.google.android.gms.measurement.internal.zzel.zzO     // Catch:{ all -> 0x0a9d }
            java.lang.Object r10 = r10.zza(r6)     // Catch:{ all -> 0x0a9d }
            java.lang.Integer r10 = (java.lang.Integer) r10     // Catch:{ all -> 0x0a9d }
            int r10 = r10.intValue()     // Catch:{ all -> 0x0a9d }
            java.util.Set r9 = r9.entrySet()     // Catch:{ all -> 0x0a9d }
            java.util.Iterator r9 = r9.iterator()     // Catch:{ all -> 0x0a9d }
        L_0x06f9:
            boolean r11 = r9.hasNext()     // Catch:{ all -> 0x0a9d }
            if (r11 == 0) goto L_0x0756
            java.lang.Object r11 = r9.next()     // Catch:{ all -> 0x0a9d }
            java.util.Map$Entry r11 = (java.util.Map.Entry) r11     // Catch:{ all -> 0x0a9d }
            java.lang.Object r12 = r11.getKey()     // Catch:{ all -> 0x0a9d }
            java.lang.String r12 = (java.lang.String) r12     // Catch:{ all -> 0x0a9d }
            java.lang.String r13 = "measurement.id."
            boolean r12 = r12.startsWith(r13)     // Catch:{ all -> 0x0a9d }
            if (r12 == 0) goto L_0x06f9
            java.lang.Object r11 = r11.getValue()     // Catch:{ NumberFormatException -> 0x0744 }
            java.lang.String r11 = (java.lang.String) r11     // Catch:{ NumberFormatException -> 0x0744 }
            int r11 = java.lang.Integer.parseInt(r11)     // Catch:{ NumberFormatException -> 0x0744 }
            if (r11 == 0) goto L_0x06f9
            java.lang.Integer r11 = java.lang.Integer.valueOf(r11)     // Catch:{ NumberFormatException -> 0x0744 }
            r14.add(r11)     // Catch:{ NumberFormatException -> 0x0744 }
            int r11 = r14.size()     // Catch:{ NumberFormatException -> 0x0744 }
            if (r11 < r10) goto L_0x06f9
            com.google.android.gms.measurement.internal.zzgi r11 = r8.zzs     // Catch:{ NumberFormatException -> 0x0744 }
            com.google.android.gms.measurement.internal.zzey r11 = r11.zzaz()     // Catch:{ NumberFormatException -> 0x0744 }
            com.google.android.gms.measurement.internal.zzew r11 = r11.zzk()     // Catch:{ NumberFormatException -> 0x0744 }
            java.lang.String r12 = "Too many experiment IDs. Number of IDs"
            int r13 = r14.size()     // Catch:{ NumberFormatException -> 0x0744 }
            java.lang.Integer r13 = java.lang.Integer.valueOf(r13)     // Catch:{ NumberFormatException -> 0x0744 }
            r11.zzb(r12, r13)     // Catch:{ NumberFormatException -> 0x0744 }
            goto L_0x0756
        L_0x0744:
            r0 = move-exception
            r11 = r0
            com.google.android.gms.measurement.internal.zzgi r12 = r8.zzs     // Catch:{ all -> 0x0a9d }
            com.google.android.gms.measurement.internal.zzey r12 = r12.zzaz()     // Catch:{ all -> 0x0a9d }
            com.google.android.gms.measurement.internal.zzew r12 = r12.zzk()     // Catch:{ all -> 0x0a9d }
            java.lang.String r13 = "Experiment ID NumberFormatException"
            r12.zzb(r13, r11)     // Catch:{ all -> 0x0a9d }
            goto L_0x06f9
        L_0x0756:
            int r8 = r14.size()     // Catch:{ all -> 0x0a9d }
            if (r8 != 0) goto L_0x075d
        L_0x075c:
            r14 = r6
        L_0x075d:
            if (r14 == 0) goto L_0x0762
            r2.zzh(r14)     // Catch:{ all -> 0x0a9d }
        L_0x0762:
            java.lang.String r8 = r3.zza     // Catch:{ all -> 0x0a9d }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r8)     // Catch:{ all -> 0x0a9d }
            com.google.android.gms.measurement.internal.zzah r8 = r1.zzh(r8)     // Catch:{ all -> 0x0a9d }
            java.lang.String r9 = r3.zzv     // Catch:{ all -> 0x0a9d }
            com.google.android.gms.measurement.internal.zzah r9 = com.google.android.gms.measurement.internal.zzah.zzb(r9)     // Catch:{ all -> 0x0a9d }
            com.google.android.gms.measurement.internal.zzah r8 = r8.zzc(r9)     // Catch:{ all -> 0x0a9d }
            com.google.android.gms.measurement.internal.zzag r9 = com.google.android.gms.measurement.internal.zzag.AD_STORAGE     // Catch:{ all -> 0x0a9d }
            boolean r9 = r8.zzi(r9)     // Catch:{ all -> 0x0a9d }
            if (r9 == 0) goto L_0x07a9
            com.google.android.gms.measurement.internal.zzkd r9 = r1.zzk     // Catch:{ all -> 0x0a9d }
            java.lang.String r10 = r3.zza     // Catch:{ all -> 0x0a9d }
            android.util.Pair r9 = r9.zzd(r10, r8)     // Catch:{ all -> 0x0a9d }
            java.lang.Object r10 = r9.first     // Catch:{ all -> 0x0a9d }
            java.lang.CharSequence r10 = (java.lang.CharSequence) r10     // Catch:{ all -> 0x0a9d }
            boolean r10 = android.text.TextUtils.isEmpty(r10)     // Catch:{ all -> 0x0a9d }
            if (r10 != 0) goto L_0x07a9
            boolean r10 = r3.zzo     // Catch:{ all -> 0x0a9d }
            if (r10 == 0) goto L_0x07a9
            java.lang.Object r10 = r9.first     // Catch:{ all -> 0x0a9d }
            java.lang.String r10 = (java.lang.String) r10     // Catch:{ all -> 0x0a9d }
            r2.zzaf(r10)     // Catch:{ all -> 0x0a9d }
            java.lang.Object r10 = r9.second     // Catch:{ all -> 0x0a9d }
            if (r10 == 0) goto L_0x07a9
            java.lang.Object r9 = r9.second     // Catch:{ all -> 0x0a9d }
            java.lang.Boolean r9 = (java.lang.Boolean) r9     // Catch:{ all -> 0x0a9d }
            boolean r9 = r9.booleanValue()     // Catch:{ all -> 0x0a9d }
            r2.zzY(r9)     // Catch:{ all -> 0x0a9d }
        L_0x07a9:
            com.google.android.gms.measurement.internal.zzgi r9 = r1.zzn     // Catch:{ all -> 0x0a9d }
            com.google.android.gms.measurement.internal.zzap r9 = r9.zzg()     // Catch:{ all -> 0x0a9d }
            r9.zzu()     // Catch:{ all -> 0x0a9d }
            java.lang.String r9 = android.os.Build.MODEL     // Catch:{ all -> 0x0a9d }
            r2.zzO(r9)     // Catch:{ all -> 0x0a9d }
            com.google.android.gms.measurement.internal.zzgi r9 = r1.zzn     // Catch:{ all -> 0x0a9d }
            com.google.android.gms.measurement.internal.zzap r9 = r9.zzg()     // Catch:{ all -> 0x0a9d }
            r9.zzu()     // Catch:{ all -> 0x0a9d }
            java.lang.String r9 = android.os.Build.VERSION.RELEASE     // Catch:{ all -> 0x0a9d }
            r2.zzZ(r9)     // Catch:{ all -> 0x0a9d }
            com.google.android.gms.measurement.internal.zzgi r9 = r1.zzn     // Catch:{ all -> 0x0a9d }
            com.google.android.gms.measurement.internal.zzap r9 = r9.zzg()     // Catch:{ all -> 0x0a9d }
            long r9 = r9.zzb()     // Catch:{ all -> 0x0a9d }
            int r10 = (int) r9     // Catch:{ all -> 0x0a9d }
            r2.zzak(r10)     // Catch:{ all -> 0x0a9d }
            com.google.android.gms.measurement.internal.zzgi r9 = r1.zzn     // Catch:{ all -> 0x0a9d }
            com.google.android.gms.measurement.internal.zzap r9 = r9.zzg()     // Catch:{ all -> 0x0a9d }
            java.lang.String r9 = r9.zzc()     // Catch:{ all -> 0x0a9d }
            r2.zzao(r9)     // Catch:{ all -> 0x0a9d }
            com.google.android.gms.measurement.internal.zzaf r9 = r34.zzg()     // Catch:{ all -> 0x0a9d }
            com.google.android.gms.measurement.internal.zzek r10 = com.google.android.gms.measurement.internal.zzel.zzah     // Catch:{ all -> 0x0a9d }
            boolean r9 = r9.zzs(r6, r10)     // Catch:{ all -> 0x0a9d }
            if (r9 != 0) goto L_0x07f1
            long r9 = r3.zzl     // Catch:{ all -> 0x0a9d }
            r2.zzD(r9)     // Catch:{ all -> 0x0a9d }
        L_0x07f1:
            com.google.android.gms.measurement.internal.zzgi r9 = r1.zzn     // Catch:{ all -> 0x0a9d }
            boolean r9 = r9.zzJ()     // Catch:{ all -> 0x0a9d }
            if (r9 == 0) goto L_0x0805
            r2.zzaq()     // Catch:{ all -> 0x0a9d }
            boolean r9 = android.text.TextUtils.isEmpty(r6)     // Catch:{ all -> 0x0a9d }
            if (r9 != 0) goto L_0x0805
            r2.zzP(r6)     // Catch:{ all -> 0x0a9d }
        L_0x0805:
            com.google.android.gms.measurement.internal.zzal r9 = r1.zze     // Catch:{ all -> 0x0a9d }
            zzak(r9)     // Catch:{ all -> 0x0a9d }
            java.lang.String r10 = r3.zza     // Catch:{ all -> 0x0a9d }
            com.google.android.gms.measurement.internal.zzg r9 = r9.zzj(r10)     // Catch:{ all -> 0x0a9d }
            if (r9 != 0) goto L_0x0886
            com.google.android.gms.measurement.internal.zzg r9 = new com.google.android.gms.measurement.internal.zzg     // Catch:{ all -> 0x0a9d }
            com.google.android.gms.measurement.internal.zzgi r10 = r1.zzn     // Catch:{ all -> 0x0a9d }
            java.lang.String r11 = r3.zza     // Catch:{ all -> 0x0a9d }
            r9.<init>(r10, r11)     // Catch:{ all -> 0x0a9d }
            java.lang.String r10 = r1.zzw(r8)     // Catch:{ all -> 0x0a9d }
            r9.zzI(r10)     // Catch:{ all -> 0x0a9d }
            java.lang.String r10 = r3.zzk     // Catch:{ all -> 0x0a9d }
            r9.zzW(r10)     // Catch:{ all -> 0x0a9d }
            java.lang.String r10 = r3.zzb     // Catch:{ all -> 0x0a9d }
            r9.zzX(r10)     // Catch:{ all -> 0x0a9d }
            com.google.android.gms.measurement.internal.zzag r10 = com.google.android.gms.measurement.internal.zzag.AD_STORAGE     // Catch:{ all -> 0x0a9d }
            boolean r10 = r8.zzi(r10)     // Catch:{ all -> 0x0a9d }
            if (r10 == 0) goto L_0x083f
            com.google.android.gms.measurement.internal.zzkd r10 = r1.zzk     // Catch:{ all -> 0x0a9d }
            java.lang.String r11 = r3.zza     // Catch:{ all -> 0x0a9d }
            java.lang.String r10 = r10.zzf(r11)     // Catch:{ all -> 0x0a9d }
            r9.zzaf(r10)     // Catch:{ all -> 0x0a9d }
        L_0x083f:
            r10 = 0
            r9.zzab(r10)     // Catch:{ all -> 0x0a9d }
            r9.zzac(r10)     // Catch:{ all -> 0x0a9d }
            r9.zzaa(r10)     // Catch:{ all -> 0x0a9d }
            java.lang.String r10 = r3.zzc     // Catch:{ all -> 0x0a9d }
            r9.zzK(r10)     // Catch:{ all -> 0x0a9d }
            long r10 = r3.zzj     // Catch:{ all -> 0x0a9d }
            r9.zzL(r10)     // Catch:{ all -> 0x0a9d }
            java.lang.String r10 = r3.zzd     // Catch:{ all -> 0x0a9d }
            r9.zzJ(r10)     // Catch:{ all -> 0x0a9d }
            long r10 = r3.zze     // Catch:{ all -> 0x0a9d }
            r9.zzY(r10)     // Catch:{ all -> 0x0a9d }
            long r10 = r3.zzf     // Catch:{ all -> 0x0a9d }
            r9.zzT(r10)     // Catch:{ all -> 0x0a9d }
            boolean r10 = r3.zzh     // Catch:{ all -> 0x0a9d }
            r9.zzad(r10)     // Catch:{ all -> 0x0a9d }
            com.google.android.gms.measurement.internal.zzaf r10 = r34.zzg()     // Catch:{ all -> 0x0a9d }
            com.google.android.gms.measurement.internal.zzek r11 = com.google.android.gms.measurement.internal.zzel.zzah     // Catch:{ all -> 0x0a9d }
            boolean r10 = r10.zzs(r6, r11)     // Catch:{ all -> 0x0a9d }
            if (r10 != 0) goto L_0x0879
            long r10 = r3.zzl     // Catch:{ all -> 0x0a9d }
            r9.zzH(r10)     // Catch:{ all -> 0x0a9d }
        L_0x0879:
            long r10 = r3.zzs     // Catch:{ all -> 0x0a9d }
            r9.zzU(r10)     // Catch:{ all -> 0x0a9d }
            com.google.android.gms.measurement.internal.zzal r10 = r1.zze     // Catch:{ all -> 0x0a9d }
            zzak(r10)     // Catch:{ all -> 0x0a9d }
            r10.zzD(r9)     // Catch:{ all -> 0x0a9d }
        L_0x0886:
            com.google.android.gms.measurement.internal.zzag r10 = com.google.android.gms.measurement.internal.zzag.ANALYTICS_STORAGE     // Catch:{ all -> 0x0a9d }
            boolean r8 = r8.zzi(r10)     // Catch:{ all -> 0x0a9d }
            if (r8 == 0) goto L_0x08a2
            java.lang.String r8 = r9.zzu()     // Catch:{ all -> 0x0a9d }
            boolean r8 = android.text.TextUtils.isEmpty(r8)     // Catch:{ all -> 0x0a9d }
            if (r8 != 0) goto L_0x08a2
            java.lang.String r8 = r9.zzu()     // Catch:{ all -> 0x0a9d }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r8)     // Catch:{ all -> 0x0a9d }
            r2.zzF(r8)     // Catch:{ all -> 0x0a9d }
        L_0x08a2:
            java.lang.String r8 = r9.zzx()     // Catch:{ all -> 0x0a9d }
            boolean r8 = android.text.TextUtils.isEmpty(r8)     // Catch:{ all -> 0x0a9d }
            if (r8 != 0) goto L_0x08b6
            java.lang.String r8 = r9.zzx()     // Catch:{ all -> 0x0a9d }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r8)     // Catch:{ all -> 0x0a9d }
            r2.zzU(r8)     // Catch:{ all -> 0x0a9d }
        L_0x08b6:
            com.google.android.gms.measurement.internal.zzal r8 = r1.zze     // Catch:{ all -> 0x0a9d }
            zzak(r8)     // Catch:{ all -> 0x0a9d }
            java.lang.String r3 = r3.zza     // Catch:{ all -> 0x0a9d }
            java.util.List r3 = r8.zzu(r3)     // Catch:{ all -> 0x0a9d }
            r13 = 0
        L_0x08c2:
            int r8 = r3.size()     // Catch:{ all -> 0x0a9d }
            if (r13 >= r8) goto L_0x08f8
            com.google.android.gms.internal.measurement.zzgk r8 = com.google.android.gms.internal.measurement.zzgl.zzd()     // Catch:{ all -> 0x0a9d }
            java.lang.Object r9 = r3.get(r13)     // Catch:{ all -> 0x0a9d }
            com.google.android.gms.measurement.internal.zzln r9 = (com.google.android.gms.measurement.internal.zzln) r9     // Catch:{ all -> 0x0a9d }
            java.lang.String r9 = r9.zzc     // Catch:{ all -> 0x0a9d }
            r8.zzf(r9)     // Catch:{ all -> 0x0a9d }
            java.lang.Object r9 = r3.get(r13)     // Catch:{ all -> 0x0a9d }
            com.google.android.gms.measurement.internal.zzln r9 = (com.google.android.gms.measurement.internal.zzln) r9     // Catch:{ all -> 0x0a9d }
            long r9 = r9.zzd     // Catch:{ all -> 0x0a9d }
            r8.zzg(r9)     // Catch:{ all -> 0x0a9d }
            com.google.android.gms.measurement.internal.zzlk r9 = r1.zzi     // Catch:{ all -> 0x0a9d }
            zzak(r9)     // Catch:{ all -> 0x0a9d }
            java.lang.Object r10 = r3.get(r13)     // Catch:{ all -> 0x0a9d }
            com.google.android.gms.measurement.internal.zzln r10 = (com.google.android.gms.measurement.internal.zzln) r10     // Catch:{ all -> 0x0a9d }
            java.lang.Object r10 = r10.zze     // Catch:{ all -> 0x0a9d }
            r9.zzu(r8, r10)     // Catch:{ all -> 0x0a9d }
            r2.zzl(r8)     // Catch:{ all -> 0x0a9d }
            int r13 = r13 + 1
            goto L_0x08c2
        L_0x08f8:
            com.google.android.gms.measurement.internal.zzal r3 = r1.zze     // Catch:{ IOException -> 0x0a53 }
            zzak(r3)     // Catch:{ IOException -> 0x0a53 }
            com.google.android.gms.internal.measurement.zzkc r8 = r2.zzaE()     // Catch:{ IOException -> 0x0a53 }
            com.google.android.gms.internal.measurement.zzgc r8 = (com.google.android.gms.internal.measurement.zzgc) r8     // Catch:{ IOException -> 0x0a53 }
            r3.zzg()     // Catch:{ IOException -> 0x0a53 }
            r3.zzW()     // Catch:{ IOException -> 0x0a53 }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r8)     // Catch:{ IOException -> 0x0a53 }
            java.lang.String r9 = r8.zzy()     // Catch:{ IOException -> 0x0a53 }
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r9)     // Catch:{ IOException -> 0x0a53 }
            byte[] r9 = r8.zzby()     // Catch:{ IOException -> 0x0a53 }
            com.google.android.gms.measurement.internal.zzli r10 = r3.zzf     // Catch:{ IOException -> 0x0a53 }
            com.google.android.gms.measurement.internal.zzlk r10 = r10.zzi     // Catch:{ IOException -> 0x0a53 }
            zzak(r10)     // Catch:{ IOException -> 0x0a53 }
            long r10 = r10.zzd(r9)     // Catch:{ IOException -> 0x0a53 }
            android.content.ContentValues r12 = new android.content.ContentValues     // Catch:{ IOException -> 0x0a53 }
            r12.<init>()     // Catch:{ IOException -> 0x0a53 }
            java.lang.String r13 = r8.zzy()     // Catch:{ IOException -> 0x0a53 }
            r14 = r30
            r12.put(r14, r13)     // Catch:{ IOException -> 0x0a53 }
            java.lang.Long r13 = java.lang.Long.valueOf(r10)     // Catch:{ IOException -> 0x0a53 }
            r15 = r33
            r12.put(r15, r13)     // Catch:{ IOException -> 0x0a53 }
            java.lang.String r13 = "metadata"
            r12.put(r13, r9)     // Catch:{ IOException -> 0x0a53 }
            android.database.sqlite.SQLiteDatabase r9 = r3.zzh()     // Catch:{ SQLiteException -> 0x0a39 }
            java.lang.String r13 = "raw_events_metadata"
            r4 = 4
            r9.insertWithOnConflict(r13, r6, r12, r4)     // Catch:{ SQLiteException -> 0x0a39 }
            com.google.android.gms.measurement.internal.zzal r2 = r1.zze     // Catch:{ all -> 0x0a9d }
            zzak(r2)     // Catch:{ all -> 0x0a9d }
            com.google.android.gms.measurement.internal.zzat r3 = r5.zzf     // Catch:{ all -> 0x0a9d }
            android.os.Bundle r3 = r3.zza     // Catch:{ all -> 0x0a9d }
            java.util.Set r3 = r3.keySet()     // Catch:{ all -> 0x0a9d }
            java.util.Iterator r3 = r3.iterator()     // Catch:{ all -> 0x0a9d }
        L_0x0959:
            boolean r4 = r3.hasNext()     // Catch:{ all -> 0x0a9d }
            if (r4 == 0) goto L_0x096c
            java.lang.Object r4 = r3.next()     // Catch:{ all -> 0x0a9d }
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ all -> 0x0a9d }
            boolean r4 = r7.equals(r4)     // Catch:{ all -> 0x0a9d }
            if (r4 == 0) goto L_0x0959
            goto L_0x09a5
        L_0x096c:
            com.google.android.gms.measurement.internal.zzfz r3 = r1.zzc     // Catch:{ all -> 0x0a9d }
            zzak(r3)     // Catch:{ all -> 0x0a9d }
            java.lang.String r4 = r5.zza     // Catch:{ all -> 0x0a9d }
            java.lang.String r7 = r5.zzb     // Catch:{ all -> 0x0a9d }
            boolean r3 = r3.zzq(r4, r7)     // Catch:{ all -> 0x0a9d }
            com.google.android.gms.measurement.internal.zzal r4 = r1.zze     // Catch:{ all -> 0x0a9d }
            zzak(r4)     // Catch:{ all -> 0x0a9d }
            long r17 = r34.zza()     // Catch:{ all -> 0x0a9d }
            java.lang.String r7 = r5.zza     // Catch:{ all -> 0x0a9d }
            r20 = 0
            r21 = 0
            r16 = r4
            r19 = r7
            com.google.android.gms.measurement.internal.zzaj r4 = r16.zzl(r17, r19, r20, r21)     // Catch:{ all -> 0x0a9d }
            if (r3 == 0) goto L_0x09a7
            long r3 = r4.zze     // Catch:{ all -> 0x0a9d }
            com.google.android.gms.measurement.internal.zzaf r7 = r34.zzg()     // Catch:{ all -> 0x0a9d }
            java.lang.String r8 = r5.zza     // Catch:{ all -> 0x0a9d }
            com.google.android.gms.measurement.internal.zzek r9 = com.google.android.gms.measurement.internal.zzel.zzn     // Catch:{ all -> 0x0a9d }
            int r7 = r7.zze(r8, r9)     // Catch:{ all -> 0x0a9d }
            long r7 = (long) r7     // Catch:{ all -> 0x0a9d }
            int r9 = (r3 > r7 ? 1 : (r3 == r7 ? 0 : -1))
            if (r9 >= 0) goto L_0x09a7
        L_0x09a5:
            r13 = 1
            goto L_0x09a8
        L_0x09a7:
            r13 = 0
        L_0x09a8:
            r2.zzg()     // Catch:{ all -> 0x0a9d }
            r2.zzW()     // Catch:{ all -> 0x0a9d }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r5)     // Catch:{ all -> 0x0a9d }
            java.lang.String r3 = r5.zza     // Catch:{ all -> 0x0a9d }
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r3)     // Catch:{ all -> 0x0a9d }
            com.google.android.gms.measurement.internal.zzli r3 = r2.zzf     // Catch:{ all -> 0x0a9d }
            com.google.android.gms.measurement.internal.zzlk r3 = r3.zzi     // Catch:{ all -> 0x0a9d }
            zzak(r3)     // Catch:{ all -> 0x0a9d }
            com.google.android.gms.internal.measurement.zzfs r3 = r3.zzj(r5)     // Catch:{ all -> 0x0a9d }
            byte[] r3 = r3.zzby()     // Catch:{ all -> 0x0a9d }
            android.content.ContentValues r4 = new android.content.ContentValues     // Catch:{ all -> 0x0a9d }
            r4.<init>()     // Catch:{ all -> 0x0a9d }
            java.lang.String r7 = r5.zza     // Catch:{ all -> 0x0a9d }
            r4.put(r14, r7)     // Catch:{ all -> 0x0a9d }
            java.lang.String r7 = "name"
            java.lang.String r8 = r5.zzb     // Catch:{ all -> 0x0a9d }
            r4.put(r7, r8)     // Catch:{ all -> 0x0a9d }
            java.lang.String r7 = "timestamp"
            long r8 = r5.zzd     // Catch:{ all -> 0x0a9d }
            java.lang.Long r8 = java.lang.Long.valueOf(r8)     // Catch:{ all -> 0x0a9d }
            r4.put(r7, r8)     // Catch:{ all -> 0x0a9d }
            java.lang.Long r7 = java.lang.Long.valueOf(r10)     // Catch:{ all -> 0x0a9d }
            r4.put(r15, r7)     // Catch:{ all -> 0x0a9d }
            java.lang.String r7 = "data"
            r4.put(r7, r3)     // Catch:{ all -> 0x0a9d }
            java.lang.String r3 = "realtime"
            java.lang.Integer r7 = java.lang.Integer.valueOf(r13)     // Catch:{ all -> 0x0a9d }
            r4.put(r3, r7)     // Catch:{ all -> 0x0a9d }
            android.database.sqlite.SQLiteDatabase r3 = r2.zzh()     // Catch:{ SQLiteException -> 0x0a21 }
            r7 = r32
            long r3 = r3.insert(r7, r6, r4)     // Catch:{ SQLiteException -> 0x0a21 }
            r6 = -1
            int r8 = (r3 > r6 ? 1 : (r3 == r6 ? 0 : -1))
            if (r8 != 0) goto L_0x0a1c
            com.google.android.gms.measurement.internal.zzgi r3 = r2.zzs     // Catch:{ SQLiteException -> 0x0a21 }
            com.google.android.gms.measurement.internal.zzey r3 = r3.zzaz()     // Catch:{ SQLiteException -> 0x0a21 }
            com.google.android.gms.measurement.internal.zzew r3 = r3.zzd()     // Catch:{ SQLiteException -> 0x0a21 }
            java.lang.String r4 = "Failed to insert raw event (got -1). appId"
            java.lang.String r6 = r5.zza     // Catch:{ SQLiteException -> 0x0a21 }
            java.lang.Object r6 = com.google.android.gms.measurement.internal.zzey.zzn(r6)     // Catch:{ SQLiteException -> 0x0a21 }
            r3.zzb(r4, r6)     // Catch:{ SQLiteException -> 0x0a21 }
            goto L_0x0a6a
        L_0x0a1c:
            r2 = 0
            r1.zza = r2     // Catch:{ all -> 0x0a9d }
            goto L_0x0a6a
        L_0x0a21:
            r0 = move-exception
            r3 = r0
            com.google.android.gms.measurement.internal.zzgi r2 = r2.zzs     // Catch:{ all -> 0x0a9d }
            com.google.android.gms.measurement.internal.zzey r2 = r2.zzaz()     // Catch:{ all -> 0x0a9d }
            com.google.android.gms.measurement.internal.zzew r2 = r2.zzd()     // Catch:{ all -> 0x0a9d }
            java.lang.String r4 = "Error storing raw event. appId"
            java.lang.String r5 = r5.zza     // Catch:{ all -> 0x0a9d }
            java.lang.Object r5 = com.google.android.gms.measurement.internal.zzey.zzn(r5)     // Catch:{ all -> 0x0a9d }
            r2.zzc(r4, r5, r3)     // Catch:{ all -> 0x0a9d }
            goto L_0x0a6a
        L_0x0a39:
            r0 = move-exception
            r4 = r0
            com.google.android.gms.measurement.internal.zzgi r3 = r3.zzs     // Catch:{ IOException -> 0x0a53 }
            com.google.android.gms.measurement.internal.zzey r3 = r3.zzaz()     // Catch:{ IOException -> 0x0a53 }
            com.google.android.gms.measurement.internal.zzew r3 = r3.zzd()     // Catch:{ IOException -> 0x0a53 }
            java.lang.String r5 = "Error storing raw event metadata. appId"
            java.lang.String r6 = r8.zzy()     // Catch:{ IOException -> 0x0a53 }
            java.lang.Object r6 = com.google.android.gms.measurement.internal.zzey.zzn(r6)     // Catch:{ IOException -> 0x0a53 }
            r3.zzc(r5, r6, r4)     // Catch:{ IOException -> 0x0a53 }
            throw r4     // Catch:{ IOException -> 0x0a53 }
        L_0x0a53:
            r0 = move-exception
            r3 = r0
            com.google.android.gms.measurement.internal.zzey r4 = r34.zzaz()     // Catch:{ all -> 0x0a9d }
            com.google.android.gms.measurement.internal.zzew r4 = r4.zzd()     // Catch:{ all -> 0x0a9d }
            java.lang.String r5 = "Data loss. Failed to insert raw event metadata. appId"
            java.lang.String r2 = r2.zzaq()     // Catch:{ all -> 0x0a9d }
            java.lang.Object r2 = com.google.android.gms.measurement.internal.zzey.zzn(r2)     // Catch:{ all -> 0x0a9d }
            r4.zzc(r5, r2, r3)     // Catch:{ all -> 0x0a9d }
        L_0x0a6a:
            com.google.android.gms.measurement.internal.zzal r2 = r1.zze     // Catch:{ all -> 0x0a9d }
            zzak(r2)     // Catch:{ all -> 0x0a9d }
            r2.zzC()     // Catch:{ all -> 0x0a9d }
            com.google.android.gms.measurement.internal.zzal r2 = r1.zze
            zzak(r2)
            r2.zzx()
            r34.zzaf()
            com.google.android.gms.measurement.internal.zzey r2 = r34.zzaz()
            com.google.android.gms.measurement.internal.zzew r2 = r2.zzj()
            long r3 = java.lang.System.nanoTime()
            long r3 = r3 - r28
            r5 = 500000(0x7a120, double:2.47033E-318)
            long r3 = r3 + r5
            r5 = 1000000(0xf4240, double:4.940656E-318)
            long r3 = r3 / r5
            java.lang.Long r3 = java.lang.Long.valueOf(r3)
            java.lang.String r4 = "Background event processing time, ms"
            r2.zzb(r4, r3)
            return
        L_0x0a9d:
            r0 = move-exception
            r2 = r0
            com.google.android.gms.measurement.internal.zzal r3 = r1.zze
            zzak(r3)
            r3.zzx()
            throw r2
        L_0x0aa8:
            r1.zzd(r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzli.zzX(com.google.android.gms.measurement.internal.zzav, com.google.android.gms.measurement.internal.zzp):void");
    }

    public final long zza() {
        long currentTimeMillis = zzaw().currentTimeMillis();
        zzkd zzkd = this.zzk;
        zzkd.zzW();
        zzkd.zzg();
        long zza2 = zzkd.zze.zza();
        if (zza2 == 0) {
            zza2 = ((long) zzkd.zzs.zzv().zzG().nextInt(86400000)) + 1;
            zzkd.zze.zzb(zza2);
        }
        return ((((currentTimeMillis + zza2) / 1000) / 60) / 60) / 24;
    }

    public final zzgf zzaA() {
        zzgi zzgi = this.zzn;
        Preconditions.checkNotNull(zzgi);
        return zzgi.zzaA();
    }

    public final zzp zzab(String str) {
        String str2 = str;
        zzal zzal = this.zze;
        zzak(zzal);
        zzg zzj2 = zzal.zzj(str2);
        if (zzj2 == null || TextUtils.isEmpty(zzj2.zzw())) {
            zzaz().zzk.zzb("No app data available; dropping", str2);
            return null;
        }
        Boolean zzac = zzac(zzj2);
        if (zzac == null || zzac.booleanValue()) {
            String zzy2 = zzj2.zzy();
            String zzw2 = zzj2.zzw();
            long zzb2 = zzj2.zzb();
            String zzv2 = zzj2.zzv();
            long zzm2 = zzj2.zzm();
            long zzj3 = zzj2.zzj();
            boolean zzaj = zzj2.zzaj();
            String zzx2 = zzj2.zzx();
            long zza2 = zzj2.zza();
            boolean zzai = zzj2.zzai();
            String zzr2 = zzj2.zzr();
            zzj2.zza.zzaA().zzg();
            zzp zzp2 = new zzp(str, zzy2, zzw2, zzb2, zzv2, zzm2, zzj3, null, zzaj, false, zzx2, zza2, 0, 0, zzai, false, zzr2, zzj2.zzs, zzj2.zzk(), zzj2.zzC(), zzh(str).zzh(), "", null);
            return zzp2;
        }
        zzaz().zzd.zzb("App version does not match; dropping. appId", zzey.zzn(str));
        return null;
    }

    public final Boolean zzac(zzg zzg2) {
        try {
            if (zzg2.zzb() != -2147483648L) {
                if (zzg2.zzb() == ((long) Wrappers.packageManager(this.zzn.zze).getPackageInfo(zzg2.zzt(), 0).versionCode)) {
                    return Boolean.TRUE;
                }
            } else {
                String str = Wrappers.packageManager(this.zzn.zze).getPackageInfo(zzg2.zzt(), 0).versionName;
                String zzw2 = zzg2.zzw();
                if (zzw2 != null && zzw2.equals(str)) {
                    return Boolean.TRUE;
                }
            }
            return Boolean.FALSE;
        } catch (NameNotFoundException unused) {
            return null;
        }
    }

    public final void zzad() {
        zzaA().zzg();
        if (this.zzt || this.zzu || this.zzv) {
            zzaz().zzl.zzd("Not stopping services. fetch, network, upload", Boolean.valueOf(this.zzt), Boolean.valueOf(this.zzu), Boolean.valueOf(this.zzv));
            return;
        }
        zzaz().zzl.zza("Stopping uploading service(s)");
        List<Runnable> list = this.zzq;
        if (list != null) {
            for (Runnable run : list) {
                run.run();
            }
            List list2 = this.zzq;
            Preconditions.checkNotNull(list2);
            list2.clear();
        }
    }

    @VisibleForTesting
    public final void zzae(zzgb zzgb, long j, boolean z) {
        zzln zzln;
        String str = true != z ? "_lte" : "_se";
        zzal zzal = this.zze;
        zzak(zzal);
        zzln zzp2 = zzal.zzp(zzgb.zzaq(), str);
        if (zzp2 == null || zzp2.zze == null) {
            zzln = new zzln(zzgb.zzaq(), "auto", str, zzaw().currentTimeMillis(), Long.valueOf(j));
        } else {
            zzln = new zzln(zzgb.zzaq(), "auto", str, zzaw().currentTimeMillis(), Long.valueOf(((Long) zzp2.zze).longValue() + j));
        }
        zzgk zzd2 = zzgl.zzd();
        zzd2.zzf(str);
        zzd2.zzg(zzaw().currentTimeMillis());
        zzd2.zze(((Long) zzln.zze).longValue());
        zzgl zzgl = (zzgl) zzd2.zzaE();
        int zza2 = zzlk.zza(zzgb, str);
        if (zza2 >= 0) {
            zzgb.zzan(zza2, zzgl);
        } else {
            zzgb.zzm(zzgl);
        }
        if (j > 0) {
            zzal zzal2 = this.zze;
            zzak(zzal2);
            zzal2.zzL(zzln);
            zzaz().zzl.zzc("Updated engagement user property. scope, value", true != z ? "lifetime" : "session-scoped", zzln.zze);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x00a6  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00e8  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x012c  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x012f  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x01b0  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x036a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzaf() {
        /*
            r25 = this;
            r0 = r25
            com.google.android.gms.measurement.internal.zzgf r1 = r25.zzaA()
            r1.zzg()
            r25.zzB()
            long r1 = r0.zza
            r3 = 0
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 <= 0) goto L_0x004c
            r1 = 3600000(0x36ee80, double:1.7786363E-317)
            com.google.android.gms.common.util.Clock r5 = r25.zzaw()
            long r5 = r5.elapsedRealtime()
            long r7 = r0.zza
            long r5 = r5 - r7
            long r5 = java.lang.Math.abs(r5)
            long r1 = r1 - r5
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 <= 0) goto L_0x004a
            com.google.android.gms.measurement.internal.zzey r3 = r25.zzaz()
            com.google.android.gms.measurement.internal.zzew r3 = r3.zzl
            java.lang.Long r1 = java.lang.Long.valueOf(r1)
            java.lang.String r2 = "Upload has been suspended. Will update scheduling later in approximately ms"
            r3.zzb(r2, r1)
            com.google.android.gms.measurement.internal.zzfg r1 = r25.zzm()
            r1.zzc()
            com.google.android.gms.measurement.internal.zzku r1 = r0.zzg
            zzak(r1)
            r1.zza()
            return
        L_0x004a:
            r0.zza = r3
        L_0x004c:
            com.google.android.gms.measurement.internal.zzgi r1 = r0.zzn
            boolean r1 = r1.zzM()
            if (r1 == 0) goto L_0x0385
            boolean r1 = r25.zzah()
            if (r1 != 0) goto L_0x005c
            goto L_0x0385
        L_0x005c:
            com.google.android.gms.common.util.Clock r1 = r25.zzaw()
            long r1 = r1.currentTimeMillis()
            r25.zzg()
            com.google.android.gms.measurement.internal.zzek r5 = com.google.android.gms.measurement.internal.zzel.zzz
            r6 = 0
            java.lang.Object r5 = r5.zza(r6)
            java.lang.Long r5 = (java.lang.Long) r5
            long r7 = r5.longValue()
            long r7 = java.lang.Math.max(r3, r7)
            com.google.android.gms.measurement.internal.zzal r5 = r0.zze
            zzak(r5)
            java.lang.String r9 = "select count(1) > 0 from raw_events where realtime = 1"
            long r9 = r5.zzZ(r9, r6)
            int r12 = (r9 > r3 ? 1 : (r9 == r3 ? 0 : -1))
            if (r12 == 0) goto L_0x0089
            r9 = 1
            goto L_0x008a
        L_0x0089:
            r9 = 0
        L_0x008a:
            if (r9 != 0) goto L_0x00a3
            com.google.android.gms.measurement.internal.zzal r9 = r0.zze
            zzak(r9)
            java.lang.String r10 = "select count(1) > 0 from queue where has_realtime = 1"
            long r9 = r9.zzZ(r10, r6)
            int r12 = (r9 > r3 ? 1 : (r9 == r3 ? 0 : -1))
            if (r12 == 0) goto L_0x009d
            r9 = 1
            goto L_0x009e
        L_0x009d:
            r9 = 0
        L_0x009e:
            if (r9 == 0) goto L_0x00a1
            goto L_0x00a3
        L_0x00a1:
            r9 = 0
            goto L_0x00a4
        L_0x00a3:
            r9 = 1
        L_0x00a4:
            if (r9 == 0) goto L_0x00e8
            com.google.android.gms.measurement.internal.zzaf r10 = r25.zzg()
            java.lang.String r12 = "debug.firebase.analytics.app"
            java.lang.String r13 = ""
            java.lang.String r10 = r10.zzB(r12, r13)
            boolean r12 = android.text.TextUtils.isEmpty(r10)
            if (r12 != 0) goto L_0x00d4
            java.lang.String r12 = ".none."
            boolean r10 = r12.equals(r10)
            if (r10 != 0) goto L_0x00d4
            r25.zzg()
            com.google.android.gms.measurement.internal.zzek r10 = com.google.android.gms.measurement.internal.zzel.zzu
            java.lang.Object r10 = r10.zza(r6)
            java.lang.Long r10 = (java.lang.Long) r10
            long r12 = r10.longValue()
            long r12 = java.lang.Math.max(r3, r12)
            goto L_0x00fb
        L_0x00d4:
            r25.zzg()
            com.google.android.gms.measurement.internal.zzek r10 = com.google.android.gms.measurement.internal.zzel.zzt
            java.lang.Object r10 = r10.zza(r6)
            java.lang.Long r10 = (java.lang.Long) r10
            long r12 = r10.longValue()
            long r12 = java.lang.Math.max(r3, r12)
            goto L_0x00fb
        L_0x00e8:
            r25.zzg()
            com.google.android.gms.measurement.internal.zzek r10 = com.google.android.gms.measurement.internal.zzel.zzs
            java.lang.Object r10 = r10.zza(r6)
            java.lang.Long r10 = (java.lang.Long) r10
            long r12 = r10.longValue()
            long r12 = java.lang.Math.max(r3, r12)
        L_0x00fb:
            com.google.android.gms.measurement.internal.zzkd r10 = r0.zzk
            com.google.android.gms.measurement.internal.zzfj r10 = r10.zzc
            long r14 = r10.zza()
            com.google.android.gms.measurement.internal.zzkd r10 = r0.zzk
            com.google.android.gms.measurement.internal.zzfj r10 = r10.zzd
            long r16 = r10.zza()
            com.google.android.gms.measurement.internal.zzal r10 = r0.zze
            zzak(r10)
            java.lang.String r5 = "select max(bundle_end_timestamp) from queue"
            r19 = r12
            long r11 = r10.zzaa(r5, r6, r3)
            com.google.android.gms.measurement.internal.zzal r5 = r0.zze
            zzak(r5)
            java.lang.String r10 = "select max(timestamp) from raw_events"
            r13 = r9
            long r9 = r5.zzaa(r10, r6, r3)
            long r9 = java.lang.Math.max(r11, r9)
            int r5 = (r9 > r3 ? 1 : (r9 == r3 ? 0 : -1))
            if (r5 != 0) goto L_0x012f
            r9 = 0
            goto L_0x01a9
        L_0x012f:
            long r9 = r9 - r1
            long r9 = java.lang.Math.abs(r9)
            long r9 = r1 - r9
            long r14 = r14 - r1
            long r11 = java.lang.Math.abs(r14)
            long r16 = r16 - r1
            long r14 = java.lang.Math.abs(r16)
            long r14 = r1 - r14
            long r1 = r1 - r11
            long r1 = java.lang.Math.max(r1, r14)
            long r7 = r7 + r9
            if (r13 == 0) goto L_0x0155
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 <= 0) goto L_0x0155
            long r7 = java.lang.Math.min(r9, r1)
            long r7 = r7 + r19
        L_0x0155:
            com.google.android.gms.measurement.internal.zzlk r5 = r0.zzi
            zzak(r5)
            r12 = r19
            boolean r5 = r5.zzw(r1, r12)
            if (r5 != 0) goto L_0x0164
            long r7 = r1 + r12
        L_0x0164:
            int r1 = (r14 > r3 ? 1 : (r14 == r3 ? 0 : -1))
            if (r1 == 0) goto L_0x01ab
            int r1 = (r14 > r9 ? 1 : (r14 == r9 ? 0 : -1))
            if (r1 < 0) goto L_0x01ab
            r1 = 0
        L_0x016d:
            r25.zzg()
            r2 = 20
            com.google.android.gms.measurement.internal.zzek r5 = com.google.android.gms.measurement.internal.zzel.zzB
            java.lang.Object r5 = r5.zza(r6)
            java.lang.Integer r5 = (java.lang.Integer) r5
            int r5 = r5.intValue()
            r9 = 0
            int r5 = java.lang.Math.max(r9, r5)
            int r2 = java.lang.Math.min(r2, r5)
            if (r1 >= r2) goto L_0x01a9
            r25.zzg()
            com.google.android.gms.measurement.internal.zzek r2 = com.google.android.gms.measurement.internal.zzel.zzA
            java.lang.Object r2 = r2.zza(r6)
            java.lang.Long r2 = (java.lang.Long) r2
            long r10 = r2.longValue()
            long r10 = java.lang.Math.max(r3, r10)
            r12 = 1
            long r12 = r12 << r1
            long r10 = r10 * r12
            long r7 = r7 + r10
            int r2 = (r7 > r14 ? 1 : (r7 == r14 ? 0 : -1))
            if (r2 > 0) goto L_0x01ac
            int r1 = r1 + 1
            goto L_0x016d
        L_0x01a9:
            r7 = r3
            goto L_0x01ac
        L_0x01ab:
            r9 = 0
        L_0x01ac:
            int r1 = (r7 > r3 ? 1 : (r7 == r3 ? 0 : -1))
            if (r1 == 0) goto L_0x036a
            com.google.android.gms.measurement.internal.zzfe r1 = r0.zzd
            zzak(r1)
            boolean r1 = r1.zza()
            if (r1 == 0) goto L_0x030c
            com.google.android.gms.measurement.internal.zzkd r1 = r0.zzk
            com.google.android.gms.measurement.internal.zzfj r1 = r1.zzb
            long r1 = r1.zza()
            r25.zzg()
            com.google.android.gms.measurement.internal.zzek r5 = com.google.android.gms.measurement.internal.zzel.zzq
            java.lang.Object r5 = r5.zza(r6)
            java.lang.Long r5 = (java.lang.Long) r5
            long r10 = r5.longValue()
            long r10 = java.lang.Math.max(r3, r10)
            com.google.android.gms.measurement.internal.zzlk r5 = r0.zzi
            zzak(r5)
            boolean r5 = r5.zzw(r1, r10)
            if (r5 != 0) goto L_0x01e6
            long r1 = r1 + r10
            long r7 = java.lang.Math.max(r7, r1)
        L_0x01e6:
            com.google.android.gms.measurement.internal.zzfg r1 = r25.zzm()
            r1.zzc()
            com.google.android.gms.common.util.Clock r1 = r25.zzaw()
            long r1 = r1.currentTimeMillis()
            long r7 = r7 - r1
            int r1 = (r7 > r3 ? 1 : (r7 == r3 ? 0 : -1))
            if (r1 > 0) goto L_0x021c
            r25.zzg()
            com.google.android.gms.measurement.internal.zzek r1 = com.google.android.gms.measurement.internal.zzel.zzv
            java.lang.Object r1 = r1.zza(r6)
            java.lang.Long r1 = (java.lang.Long) r1
            long r1 = r1.longValue()
            long r7 = java.lang.Math.max(r3, r1)
            com.google.android.gms.measurement.internal.zzkd r1 = r0.zzk
            com.google.android.gms.measurement.internal.zzfj r1 = r1.zzc
            com.google.android.gms.common.util.Clock r2 = r25.zzaw()
            long r10 = r2.currentTimeMillis()
            r1.zzb(r10)
        L_0x021c:
            com.google.android.gms.measurement.internal.zzey r1 = r25.zzaz()
            com.google.android.gms.measurement.internal.zzew r1 = r1.zzl
            java.lang.Long r2 = java.lang.Long.valueOf(r7)
            java.lang.String r5 = "Upload scheduled in approximately ms"
            r1.zzb(r5, r2)
            com.google.android.gms.measurement.internal.zzku r1 = r0.zzg
            zzak(r1)
            r1.zzW()
            com.google.android.gms.measurement.internal.zzgi r2 = r1.zzs
            com.google.android.gms.measurement.internal.zzaa r5 = r2.zzj
            android.content.Context r2 = r2.zze
            boolean r5 = com.google.android.gms.measurement.internal.zzlp.zzaj(r2)
            if (r5 != 0) goto L_0x024c
            com.google.android.gms.measurement.internal.zzgi r5 = r1.zzs
            com.google.android.gms.measurement.internal.zzey r5 = r5.zzaz()
            com.google.android.gms.measurement.internal.zzew r5 = r5.zzk
            java.lang.String r10 = "Receiver not registered/enabled"
            r5.zza(r10)
        L_0x024c:
            boolean r2 = com.google.android.gms.measurement.internal.zzlp.zzak(r2)
            if (r2 != 0) goto L_0x025f
            com.google.android.gms.measurement.internal.zzgi r2 = r1.zzs
            com.google.android.gms.measurement.internal.zzey r2 = r2.zzaz()
            com.google.android.gms.measurement.internal.zzew r2 = r2.zzk
            java.lang.String r5 = "Service not registered/enabled"
            r2.zza(r5)
        L_0x025f:
            r1.zza()
            com.google.android.gms.measurement.internal.zzgi r2 = r1.zzs
            com.google.android.gms.measurement.internal.zzey r2 = r2.zzaz()
            com.google.android.gms.measurement.internal.zzew r2 = r2.zzl
            java.lang.Long r5 = java.lang.Long.valueOf(r7)
            java.lang.String r10 = "Scheduling upload, millis"
            r2.zzb(r10, r5)
            com.google.android.gms.measurement.internal.zzgi r2 = r1.zzs
            com.google.android.gms.common.util.Clock r2 = r2.zzr
            long r10 = r2.elapsedRealtime()
            long r20 = r10 + r7
            com.google.android.gms.measurement.internal.zzgi r2 = r1.zzs
            com.google.android.gms.measurement.internal.zzaf r2 = r2.zzk
            com.google.android.gms.measurement.internal.zzek r2 = com.google.android.gms.measurement.internal.zzel.zzw
            java.lang.Object r2 = r2.zza(r6)
            java.lang.Long r2 = (java.lang.Long) r2
            long r10 = r2.longValue()
            long r10 = java.lang.Math.max(r3, r10)
            int r2 = (r7 > r10 ? 1 : (r7 == r10 ? 0 : -1))
            if (r2 >= 0) goto L_0x02ab
            com.google.android.gms.measurement.internal.zzao r2 = r1.zzi()
            long r10 = r2.zzd
            int r2 = (r10 > r3 ? 1 : (r10 == r3 ? 0 : -1))
            if (r2 == 0) goto L_0x02a1
            r5 = 1
            goto L_0x02a2
        L_0x02a1:
            r5 = 0
        L_0x02a2:
            if (r5 != 0) goto L_0x02ab
            com.google.android.gms.measurement.internal.zzao r2 = r1.zzi()
            r2.zzd(r7)
        L_0x02ab:
            com.google.android.gms.measurement.internal.zzgi r2 = r1.zzs
            com.google.android.gms.measurement.internal.zzaa r3 = r2.zzj
            int r3 = android.os.Build.VERSION.SDK_INT
            r4 = 24
            if (r3 < r4) goto L_0x02ec
            android.content.Context r2 = r2.zze
            android.content.ComponentName r3 = new android.content.ComponentName
            java.lang.String r4 = "com.google.android.gms.measurement.AppMeasurementJobService"
            r3.<init>(r2, r4)
            int r1 = r1.zzf()
            android.os.PersistableBundle r4 = new android.os.PersistableBundle
            r4.<init>()
            java.lang.String r5 = "action"
            java.lang.String r6 = "com.google.android.gms.measurement.UPLOAD"
            r4.putString(r5, r6)
            android.app.job.JobInfo$Builder r5 = new android.app.job.JobInfo$Builder
            r5.<init>(r1, r3)
            android.app.job.JobInfo$Builder r1 = r5.setMinimumLatency(r7)
            long r7 = r7 + r7
            android.app.job.JobInfo$Builder r1 = r1.setOverrideDeadline(r7)
            android.app.job.JobInfo$Builder r1 = r1.setExtras(r4)
            android.app.job.JobInfo r1 = r1.build()
            java.lang.String r3 = "com.google.android.gms"
            java.lang.String r4 = "UploadAlarm"
            com.google.android.gms.internal.measurement.zzbt.zza(r2, r1, r3, r4)
            goto L_0x030b
        L_0x02ec:
            android.app.AlarmManager r2 = r1.zza
            if (r2 == 0) goto L_0x030b
            r19 = 2
            com.google.android.gms.measurement.internal.zzek r3 = com.google.android.gms.measurement.internal.zzel.zzr
            java.lang.Object r3 = r3.zza(r6)
            java.lang.Long r3 = (java.lang.Long) r3
            long r3 = r3.longValue()
            long r22 = java.lang.Math.max(r3, r7)
            android.app.PendingIntent r24 = r1.zzh()
            r18 = r2
            r18.setInexactRepeating(r19, r20, r22, r24)
        L_0x030b:
            return
        L_0x030c:
            com.google.android.gms.measurement.internal.zzey r1 = r25.zzaz()
            com.google.android.gms.measurement.internal.zzew r1 = r1.zzl
            java.lang.String r2 = "No network"
            r1.zza(r2)
            com.google.android.gms.measurement.internal.zzfg r1 = r25.zzm()
            com.google.android.gms.measurement.internal.zzli r2 = r1.zzb
            r2.zzB()
            com.google.android.gms.measurement.internal.zzli r2 = r1.zzb
            com.google.android.gms.measurement.internal.zzgf r2 = r2.zzaA()
            r2.zzg()
            boolean r2 = r1.zzc
            if (r2 == 0) goto L_0x032e
            goto L_0x0361
        L_0x032e:
            com.google.android.gms.measurement.internal.zzli r2 = r1.zzb
            com.google.android.gms.measurement.internal.zzgi r2 = r2.zzn
            android.content.Context r2 = r2.zze
            android.content.IntentFilter r3 = new android.content.IntentFilter
            java.lang.String r4 = "android.net.conn.CONNECTIVITY_CHANGE"
            r3.<init>(r4)
            r2.registerReceiver(r1, r3)
            com.google.android.gms.measurement.internal.zzli r2 = r1.zzb
            com.google.android.gms.measurement.internal.zzfe r2 = r2.zzd
            zzak(r2)
            boolean r2 = r2.zza()
            r1.zzd = r2
            com.google.android.gms.measurement.internal.zzli r2 = r1.zzb
            com.google.android.gms.measurement.internal.zzey r2 = r2.zzaz()
            com.google.android.gms.measurement.internal.zzew r2 = r2.zzl
            boolean r3 = r1.zzd
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r3)
            java.lang.String r4 = "Registering connectivity change receiver. Network connected"
            r2.zzb(r4, r3)
            r2 = 1
            r1.zzc = r2
        L_0x0361:
            com.google.android.gms.measurement.internal.zzku r1 = r0.zzg
            zzak(r1)
            r1.zza()
            return
        L_0x036a:
            com.google.android.gms.measurement.internal.zzey r1 = r25.zzaz()
            com.google.android.gms.measurement.internal.zzew r1 = r1.zzl
            java.lang.String r2 = "Next upload time is 0"
            r1.zza(r2)
            com.google.android.gms.measurement.internal.zzfg r1 = r25.zzm()
            r1.zzc()
            com.google.android.gms.measurement.internal.zzku r1 = r0.zzg
            zzak(r1)
            r1.zza()
            return
        L_0x0385:
            com.google.android.gms.measurement.internal.zzey r1 = r25.zzaz()
            com.google.android.gms.measurement.internal.zzew r1 = r1.zzl
            java.lang.String r2 = "Nothing to upload or uploading impossible"
            r1.zza(r2)
            com.google.android.gms.measurement.internal.zzfg r1 = r25.zzm()
            r1.zzc()
            com.google.android.gms.measurement.internal.zzku r1 = r0.zzg
            zzak(r1)
            r1.zza()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzli.zzaf():void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:379:0x0b6e, code lost:
        if (r10 > (com.google.android.gms.measurement.internal.zzaf.zzA() + r8)) goto L_0x0b70;
     */
    /* JADX WARNING: Removed duplicated region for block: B:114:0x0398 A[Catch:{ NumberFormatException -> 0x07ca, all -> 0x0d07 }] */
    /* JADX WARNING: Removed duplicated region for block: B:149:0x045c A[Catch:{ NumberFormatException -> 0x07ca, all -> 0x0d07 }] */
    /* JADX WARNING: Removed duplicated region for block: B:161:0x04b4 A[Catch:{ NumberFormatException -> 0x07ca, all -> 0x0d07 }] */
    /* JADX WARNING: Removed duplicated region for block: B:277:0x0805 A[Catch:{ NumberFormatException -> 0x07ca, all -> 0x0d07 }] */
    /* JADX WARNING: Removed duplicated region for block: B:289:0x084e A[Catch:{ NumberFormatException -> 0x07ca, all -> 0x0d07 }] */
    /* JADX WARNING: Removed duplicated region for block: B:290:0x0871 A[Catch:{ NumberFormatException -> 0x07ca, all -> 0x0d07 }] */
    /* JADX WARNING: Removed duplicated region for block: B:298:0x08e9 A[Catch:{ NumberFormatException -> 0x07ca, all -> 0x0d07 }] */
    /* JADX WARNING: Removed duplicated region for block: B:299:0x08eb A[Catch:{ NumberFormatException -> 0x07ca, all -> 0x0d07 }] */
    /* JADX WARNING: Removed duplicated region for block: B:302:0x08f3 A[Catch:{ NumberFormatException -> 0x07ca, all -> 0x0d07 }] */
    /* JADX WARNING: Removed duplicated region for block: B:313:0x0927 A[Catch:{ NumberFormatException -> 0x07ca, all -> 0x0d07 }] */
    /* JADX WARNING: Removed duplicated region for block: B:378:0x0b5e A[Catch:{ NumberFormatException -> 0x07ca, all -> 0x0d07 }] */
    /* JADX WARNING: Removed duplicated region for block: B:387:0x0be5 A[Catch:{ NumberFormatException -> 0x07ca, all -> 0x0d07 }] */
    /* JADX WARNING: Removed duplicated region for block: B:391:0x0c01 A[Catch:{ SQLiteException -> 0x0c19 }] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:69:0x01e1=Splitter:B:69:0x01e1, B:418:0x0cf5=Splitter:B:418:0x0cf5} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zzag(java.lang.String r44, long r45) {
        /*
            r43 = this;
            r1 = r43
            java.lang.String r2 = "_npa"
            java.lang.String r3 = "_ai"
            com.google.android.gms.measurement.internal.zzal r4 = r1.zze
            zzak(r4)
            r4.zzw()
            com.google.android.gms.measurement.internal.zzlf r4 = new com.google.android.gms.measurement.internal.zzlf     // Catch:{ all -> 0x0d07 }
            r4.<init>(r1)     // Catch:{ all -> 0x0d07 }
            com.google.android.gms.measurement.internal.zzal r5 = r1.zze     // Catch:{ all -> 0x0d07 }
            zzak(r5)     // Catch:{ all -> 0x0d07 }
            r6 = 0
            long r9 = r1.zzA     // Catch:{ all -> 0x0d07 }
            r7 = r45
            r11 = r4
            r5.zzU(r6, r7, r9, r11)     // Catch:{ all -> 0x0d07 }
            java.util.List r5 = r4.zzc     // Catch:{ all -> 0x0d07 }
            if (r5 == 0) goto L_0x0cf5
            boolean r5 = r5.isEmpty()     // Catch:{ all -> 0x0d07 }
            if (r5 == 0) goto L_0x002d
            goto L_0x0cf5
        L_0x002d:
            com.google.android.gms.internal.measurement.zzgc r5 = r4.zza     // Catch:{ all -> 0x0d07 }
            com.google.android.gms.internal.measurement.zzjy r5 = r5.zzbB()     // Catch:{ all -> 0x0d07 }
            com.google.android.gms.internal.measurement.zzgb r5 = (com.google.android.gms.internal.measurement.zzgb) r5     // Catch:{ all -> 0x0d07 }
            r5.zzr()     // Catch:{ all -> 0x0d07 }
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = -1
            r14 = 0
            r15 = -1
        L_0x003f:
            java.util.List r8 = r4.zzc     // Catch:{ all -> 0x0d07 }
            int r8 = r8.size()     // Catch:{ all -> 0x0d07 }
            java.lang.String r6 = "_fr"
            java.lang.String r7 = "_et"
            r16 = r9
            java.lang.String r9 = "_e"
            r17 = r2
            r18 = r3
            if (r10 >= r8) goto L_0x0534
            java.util.List r3 = r4.zzc     // Catch:{ all -> 0x0d07 }
            java.lang.Object r3 = r3.get(r10)     // Catch:{ all -> 0x0d07 }
            com.google.android.gms.internal.measurement.zzfs r3 = (com.google.android.gms.internal.measurement.zzfs) r3     // Catch:{ all -> 0x0d07 }
            com.google.android.gms.internal.measurement.zzjy r3 = r3.zzbB()     // Catch:{ all -> 0x0d07 }
            com.google.android.gms.internal.measurement.zzfr r3 = (com.google.android.gms.internal.measurement.zzfr) r3     // Catch:{ all -> 0x0d07 }
            com.google.android.gms.measurement.internal.zzfz r8 = r1.zzc     // Catch:{ all -> 0x0d07 }
            zzak(r8)     // Catch:{ all -> 0x0d07 }
            com.google.android.gms.internal.measurement.zzgc r2 = r4.zza     // Catch:{ all -> 0x0d07 }
            java.lang.String r2 = r2.zzy()     // Catch:{ all -> 0x0d07 }
            r22 = r11
            java.lang.String r11 = r3.zzo()     // Catch:{ all -> 0x0d07 }
            boolean r2 = r8.zzr(r2, r11)     // Catch:{ all -> 0x0d07 }
            java.lang.String r8 = "_err"
            if (r2 == 0) goto L_0x00f0
            com.google.android.gms.measurement.internal.zzey r2 = r43.zzaz()     // Catch:{ all -> 0x0d07 }
            com.google.android.gms.measurement.internal.zzew r2 = r2.zzk()     // Catch:{ all -> 0x0d07 }
            java.lang.String r6 = "Dropping blocked raw event. appId"
            com.google.android.gms.internal.measurement.zzgc r7 = r4.zza     // Catch:{ all -> 0x0d07 }
            java.lang.String r7 = r7.zzy()     // Catch:{ all -> 0x0d07 }
            java.lang.Object r7 = com.google.android.gms.measurement.internal.zzey.zzn(r7)     // Catch:{ all -> 0x0d07 }
            com.google.android.gms.measurement.internal.zzgi r9 = r1.zzn     // Catch:{ all -> 0x0d07 }
            com.google.android.gms.measurement.internal.zzet r9 = r9.zzj()     // Catch:{ all -> 0x0d07 }
            java.lang.String r11 = r3.zzo()     // Catch:{ all -> 0x0d07 }
            java.lang.String r9 = r9.zzd(r11)     // Catch:{ all -> 0x0d07 }
            r2.zzc(r6, r7, r9)     // Catch:{ all -> 0x0d07 }
            com.google.android.gms.measurement.internal.zzfz r2 = r1.zzc     // Catch:{ all -> 0x0d07 }
            zzak(r2)     // Catch:{ all -> 0x0d07 }
            com.google.android.gms.internal.measurement.zzgc r6 = r4.zza     // Catch:{ all -> 0x0d07 }
            java.lang.String r6 = r6.zzy()     // Catch:{ all -> 0x0d07 }
            boolean r2 = r2.zzp(r6)     // Catch:{ all -> 0x0d07 }
            if (r2 != 0) goto L_0x00e7
            com.google.android.gms.measurement.internal.zzfz r2 = r1.zzc     // Catch:{ all -> 0x0d07 }
            zzak(r2)     // Catch:{ all -> 0x0d07 }
            com.google.android.gms.internal.measurement.zzgc r6 = r4.zza     // Catch:{ all -> 0x0d07 }
            java.lang.String r6 = r6.zzy()     // Catch:{ all -> 0x0d07 }
            boolean r2 = r2.zzs(r6)     // Catch:{ all -> 0x0d07 }
            if (r2 == 0) goto L_0x00c2
            goto L_0x00e7
        L_0x00c2:
            java.lang.String r2 = r3.zzo()     // Catch:{ all -> 0x0d07 }
            boolean r2 = r8.equals(r2)     // Catch:{ all -> 0x0d07 }
            if (r2 != 0) goto L_0x00e7
            com.google.android.gms.measurement.internal.zzlp r23 = r43.zzv()     // Catch:{ all -> 0x0d07 }
            com.google.android.gms.measurement.internal.zzlo r2 = r1.zzF     // Catch:{ all -> 0x0d07 }
            com.google.android.gms.internal.measurement.zzgc r6 = r4.zza     // Catch:{ all -> 0x0d07 }
            java.lang.String r25 = r6.zzy()     // Catch:{ all -> 0x0d07 }
            r26 = 11
            java.lang.String r27 = "_ev"
            java.lang.String r28 = r3.zzo()     // Catch:{ all -> 0x0d07 }
            r29 = 0
            r24 = r2
            r23.zzN(r24, r25, r26, r27, r28, r29)     // Catch:{ all -> 0x0d07 }
        L_0x00e7:
            r7 = r10
            r9 = r16
            r11 = r22
            r10 = r5
            r5 = -1
            goto L_0x052a
        L_0x00f0:
            java.lang.String r2 = r3.zzo()     // Catch:{ all -> 0x0d07 }
            java.lang.String r11 = com.google.android.gms.measurement.internal.zzhf.zza(r18)     // Catch:{ all -> 0x0d07 }
            boolean r2 = r2.equals(r11)     // Catch:{ all -> 0x0d07 }
            if (r2 == 0) goto L_0x016a
            r2 = r18
            r3.zzi(r2)     // Catch:{ all -> 0x0d07 }
            com.google.android.gms.measurement.internal.zzey r11 = r43.zzaz()     // Catch:{ all -> 0x0d07 }
            com.google.android.gms.measurement.internal.zzew r11 = r11.zzj()     // Catch:{ all -> 0x0d07 }
            r18 = r2
            java.lang.String r2 = "Renaming ad_impression to _ai"
            r11.zza(r2)     // Catch:{ all -> 0x0d07 }
            com.google.android.gms.measurement.internal.zzey r2 = r43.zzaz()     // Catch:{ all -> 0x0d07 }
            java.lang.String r2 = r2.zzq()     // Catch:{ all -> 0x0d07 }
            r11 = 5
            boolean r2 = android.util.Log.isLoggable(r2, r11)     // Catch:{ all -> 0x0d07 }
            if (r2 == 0) goto L_0x016a
            r2 = 0
        L_0x0122:
            int r11 = r3.zza()     // Catch:{ all -> 0x0d07 }
            if (r2 >= r11) goto L_0x016a
            java.lang.String r11 = "ad_platform"
            com.google.android.gms.internal.measurement.zzfw r23 = r3.zzn(r2)     // Catch:{ all -> 0x0d07 }
            r24 = r10
            java.lang.String r10 = r23.zzg()     // Catch:{ all -> 0x0d07 }
            boolean r10 = r11.equals(r10)     // Catch:{ all -> 0x0d07 }
            if (r10 == 0) goto L_0x0165
            com.google.android.gms.internal.measurement.zzfw r10 = r3.zzn(r2)     // Catch:{ all -> 0x0d07 }
            java.lang.String r10 = r10.zzh()     // Catch:{ all -> 0x0d07 }
            boolean r10 = android.text.TextUtils.isEmpty(r10)     // Catch:{ all -> 0x0d07 }
            if (r10 != 0) goto L_0x0165
            java.lang.String r10 = "admob"
            com.google.android.gms.internal.measurement.zzfw r11 = r3.zzn(r2)     // Catch:{ all -> 0x0d07 }
            java.lang.String r11 = r11.zzh()     // Catch:{ all -> 0x0d07 }
            boolean r10 = r10.equalsIgnoreCase(r11)     // Catch:{ all -> 0x0d07 }
            if (r10 == 0) goto L_0x0165
            com.google.android.gms.measurement.internal.zzey r10 = r43.zzaz()     // Catch:{ all -> 0x0d07 }
            com.google.android.gms.measurement.internal.zzew r10 = r10.zzl()     // Catch:{ all -> 0x0d07 }
            java.lang.String r11 = "AdMob ad impression logged from app. Potentially duplicative."
            r10.zza(r11)     // Catch:{ all -> 0x0d07 }
        L_0x0165:
            int r2 = r2 + 1
            r10 = r24
            goto L_0x0122
        L_0x016a:
            r24 = r10
            com.google.android.gms.measurement.internal.zzfz r2 = r1.zzc     // Catch:{ all -> 0x0d07 }
            zzak(r2)     // Catch:{ all -> 0x0d07 }
            com.google.android.gms.internal.measurement.zzgc r10 = r4.zza     // Catch:{ all -> 0x0d07 }
            java.lang.String r10 = r10.zzy()     // Catch:{ all -> 0x0d07 }
            java.lang.String r11 = r3.zzo()     // Catch:{ all -> 0x0d07 }
            boolean r2 = r2.zzq(r10, r11)     // Catch:{ all -> 0x0d07 }
            java.lang.String r10 = "_c"
            if (r2 != 0) goto L_0x01d8
            com.google.android.gms.measurement.internal.zzlk r11 = r1.zzi     // Catch:{ all -> 0x0d07 }
            zzak(r11)     // Catch:{ all -> 0x0d07 }
            java.lang.String r11 = r3.zzo()     // Catch:{ all -> 0x0d07 }
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r11)     // Catch:{ all -> 0x0d07 }
            r23 = r13
            int r13 = r11.hashCode()     // Catch:{ all -> 0x0d07 }
            r25 = r12
            r12 = 94660(0x171c4, float:1.32647E-40)
            if (r13 == r12) goto L_0x01bb
            r12 = 95025(0x17331, float:1.33158E-40)
            if (r13 == r12) goto L_0x01b1
            r12 = 95027(0x17333, float:1.33161E-40)
            if (r13 == r12) goto L_0x01a7
            goto L_0x01c5
        L_0x01a7:
            java.lang.String r12 = "_ui"
            boolean r11 = r11.equals(r12)
            if (r11 == 0) goto L_0x01c5
            r11 = 1
            goto L_0x01c6
        L_0x01b1:
            java.lang.String r12 = "_ug"
            boolean r11 = r11.equals(r12)
            if (r11 == 0) goto L_0x01c5
            r11 = 2
            goto L_0x01c6
        L_0x01bb:
            java.lang.String r12 = "_in"
            boolean r11 = r11.equals(r12)
            if (r11 == 0) goto L_0x01c5
            r11 = 0
            goto L_0x01c6
        L_0x01c5:
            r11 = -1
        L_0x01c6:
            if (r11 == 0) goto L_0x01dc
            r12 = 1
            if (r11 == r12) goto L_0x01dc
            r12 = 2
            if (r11 == r12) goto L_0x01dc
            r27 = r5
            r26 = r7
            r7 = r14
            r19 = r15
            r2 = 0
            goto L_0x0396
        L_0x01d8:
            r25 = r12
            r23 = r13
        L_0x01dc:
            r26 = r7
            r11 = 0
            r12 = 0
            r13 = 0
        L_0x01e1:
            int r7 = r3.zza()     // Catch:{ all -> 0x0d07 }
            r27 = r5
            java.lang.String r5 = "_r"
            if (r11 >= r7) goto L_0x0248
            com.google.android.gms.internal.measurement.zzfw r7 = r3.zzn(r11)     // Catch:{ all -> 0x0d07 }
            java.lang.String r7 = r7.zzg()     // Catch:{ all -> 0x0d07 }
            boolean r7 = r10.equals(r7)     // Catch:{ all -> 0x0d07 }
            if (r7 == 0) goto L_0x0216
            com.google.android.gms.internal.measurement.zzfw r5 = r3.zzn(r11)     // Catch:{ all -> 0x0d07 }
            com.google.android.gms.internal.measurement.zzjy r5 = r5.zzbB()     // Catch:{ all -> 0x0d07 }
            com.google.android.gms.internal.measurement.zzfv r5 = (com.google.android.gms.internal.measurement.zzfv) r5     // Catch:{ all -> 0x0d07 }
            r7 = r14
            r19 = r15
            r14 = 1
            r5.zzi(r14)     // Catch:{ all -> 0x0d07 }
            com.google.android.gms.internal.measurement.zzkc r5 = r5.zzaE()     // Catch:{ all -> 0x0d07 }
            com.google.android.gms.internal.measurement.zzfw r5 = (com.google.android.gms.internal.measurement.zzfw) r5     // Catch:{ all -> 0x0d07 }
            r3.zzk(r11, r5)     // Catch:{ all -> 0x0d07 }
            r12 = 1
            goto L_0x0240
        L_0x0216:
            r7 = r14
            r19 = r15
            com.google.android.gms.internal.measurement.zzfw r14 = r3.zzn(r11)     // Catch:{ all -> 0x0d07 }
            java.lang.String r14 = r14.zzg()     // Catch:{ all -> 0x0d07 }
            boolean r5 = r5.equals(r14)     // Catch:{ all -> 0x0d07 }
            if (r5 == 0) goto L_0x0240
            com.google.android.gms.internal.measurement.zzfw r5 = r3.zzn(r11)     // Catch:{ all -> 0x0d07 }
            com.google.android.gms.internal.measurement.zzjy r5 = r5.zzbB()     // Catch:{ all -> 0x0d07 }
            com.google.android.gms.internal.measurement.zzfv r5 = (com.google.android.gms.internal.measurement.zzfv) r5     // Catch:{ all -> 0x0d07 }
            r13 = 1
            r5.zzi(r13)     // Catch:{ all -> 0x0d07 }
            com.google.android.gms.internal.measurement.zzkc r5 = r5.zzaE()     // Catch:{ all -> 0x0d07 }
            com.google.android.gms.internal.measurement.zzfw r5 = (com.google.android.gms.internal.measurement.zzfw) r5     // Catch:{ all -> 0x0d07 }
            r3.zzk(r11, r5)     // Catch:{ all -> 0x0d07 }
            r13 = 1
        L_0x0240:
            int r11 = r11 + 1
            r14 = r7
            r15 = r19
            r5 = r27
            goto L_0x01e1
        L_0x0248:
            r7 = r14
            r19 = r15
            if (r12 != 0) goto L_0x0279
            if (r2 == 0) goto L_0x0279
            com.google.android.gms.measurement.internal.zzey r11 = r43.zzaz()     // Catch:{ all -> 0x0d07 }
            com.google.android.gms.measurement.internal.zzew r11 = r11.zzj()     // Catch:{ all -> 0x0d07 }
            java.lang.String r12 = "Marking event as conversion"
            com.google.android.gms.measurement.internal.zzgi r14 = r1.zzn     // Catch:{ all -> 0x0d07 }
            com.google.android.gms.measurement.internal.zzet r14 = r14.zzj()     // Catch:{ all -> 0x0d07 }
            java.lang.String r15 = r3.zzo()     // Catch:{ all -> 0x0d07 }
            java.lang.String r14 = r14.zzd(r15)     // Catch:{ all -> 0x0d07 }
            r11.zzb(r12, r14)     // Catch:{ all -> 0x0d07 }
            com.google.android.gms.internal.measurement.zzfv r11 = com.google.android.gms.internal.measurement.zzfw.zze()     // Catch:{ all -> 0x0d07 }
            r11.zzj(r10)     // Catch:{ all -> 0x0d07 }
            r14 = 1
            r11.zzi(r14)     // Catch:{ all -> 0x0d07 }
            r3.zze(r11)     // Catch:{ all -> 0x0d07 }
        L_0x0279:
            if (r13 != 0) goto L_0x02a5
            com.google.android.gms.measurement.internal.zzey r11 = r43.zzaz()     // Catch:{ all -> 0x0d07 }
            com.google.android.gms.measurement.internal.zzew r11 = r11.zzj()     // Catch:{ all -> 0x0d07 }
            java.lang.String r12 = "Marking event as real-time"
            com.google.android.gms.measurement.internal.zzgi r13 = r1.zzn     // Catch:{ all -> 0x0d07 }
            com.google.android.gms.measurement.internal.zzet r13 = r13.zzj()     // Catch:{ all -> 0x0d07 }
            java.lang.String r14 = r3.zzo()     // Catch:{ all -> 0x0d07 }
            java.lang.String r13 = r13.zzd(r14)     // Catch:{ all -> 0x0d07 }
            r11.zzb(r12, r13)     // Catch:{ all -> 0x0d07 }
            com.google.android.gms.internal.measurement.zzfv r11 = com.google.android.gms.internal.measurement.zzfw.zze()     // Catch:{ all -> 0x0d07 }
            r11.zzj(r5)     // Catch:{ all -> 0x0d07 }
            r12 = 1
            r11.zzi(r12)     // Catch:{ all -> 0x0d07 }
            r3.zze(r11)     // Catch:{ all -> 0x0d07 }
        L_0x02a5:
            com.google.android.gms.measurement.internal.zzal r11 = r1.zze     // Catch:{ all -> 0x0d07 }
            zzak(r11)     // Catch:{ all -> 0x0d07 }
            long r29 = r43.zza()     // Catch:{ all -> 0x0d07 }
            com.google.android.gms.internal.measurement.zzgc r12 = r4.zza     // Catch:{ all -> 0x0d07 }
            java.lang.String r31 = r12.zzy()     // Catch:{ all -> 0x0d07 }
            r32 = 0
            r33 = 1
            r28 = r11
            com.google.android.gms.measurement.internal.zzaj r11 = r28.zzl(r29, r31, r32, r33)     // Catch:{ all -> 0x0d07 }
            long r11 = r11.zze     // Catch:{ all -> 0x0d07 }
            com.google.android.gms.measurement.internal.zzaf r13 = r43.zzg()     // Catch:{ all -> 0x0d07 }
            com.google.android.gms.internal.measurement.zzgc r14 = r4.zza     // Catch:{ all -> 0x0d07 }
            java.lang.String r14 = r14.zzy()     // Catch:{ all -> 0x0d07 }
            com.google.android.gms.measurement.internal.zzek r15 = com.google.android.gms.measurement.internal.zzel.zzn     // Catch:{ all -> 0x0d07 }
            int r13 = r13.zze(r14, r15)     // Catch:{ all -> 0x0d07 }
            long r13 = (long) r13     // Catch:{ all -> 0x0d07 }
            int r15 = (r11 > r13 ? 1 : (r11 == r13 ? 0 : -1))
            if (r15 <= 0) goto L_0x02d9
            zzaa(r3, r5)     // Catch:{ all -> 0x0d07 }
            goto L_0x02db
        L_0x02d9:
            r16 = 1
        L_0x02db:
            java.lang.String r5 = r3.zzo()     // Catch:{ all -> 0x0d07 }
            boolean r5 = com.google.android.gms.measurement.internal.zzlp.zzai(r5)     // Catch:{ all -> 0x0d07 }
            if (r5 == 0) goto L_0x0396
            if (r2 == 0) goto L_0x0396
            com.google.android.gms.measurement.internal.zzal r5 = r1.zze     // Catch:{ all -> 0x0d07 }
            zzak(r5)     // Catch:{ all -> 0x0d07 }
            long r29 = r43.zza()     // Catch:{ all -> 0x0d07 }
            com.google.android.gms.internal.measurement.zzgc r11 = r4.zza     // Catch:{ all -> 0x0d07 }
            java.lang.String r31 = r11.zzy()     // Catch:{ all -> 0x0d07 }
            r32 = 1
            r33 = 0
            r28 = r5
            com.google.android.gms.measurement.internal.zzaj r5 = r28.zzl(r29, r31, r32, r33)     // Catch:{ all -> 0x0d07 }
            long r11 = r5.zzc     // Catch:{ all -> 0x0d07 }
            com.google.android.gms.measurement.internal.zzaf r5 = r43.zzg()     // Catch:{ all -> 0x0d07 }
            com.google.android.gms.internal.measurement.zzgc r13 = r4.zza     // Catch:{ all -> 0x0d07 }
            java.lang.String r13 = r13.zzy()     // Catch:{ all -> 0x0d07 }
            com.google.android.gms.measurement.internal.zzek r14 = com.google.android.gms.measurement.internal.zzel.zzm     // Catch:{ all -> 0x0d07 }
            int r5 = r5.zze(r13, r14)     // Catch:{ all -> 0x0d07 }
            long r13 = (long) r5     // Catch:{ all -> 0x0d07 }
            int r5 = (r11 > r13 ? 1 : (r11 == r13 ? 0 : -1))
            if (r5 <= 0) goto L_0x0396
            com.google.android.gms.measurement.internal.zzey r5 = r43.zzaz()     // Catch:{ all -> 0x0d07 }
            com.google.android.gms.measurement.internal.zzew r5 = r5.zzk()     // Catch:{ all -> 0x0d07 }
            java.lang.String r11 = "Too many conversions. Not logging as conversion. appId"
            com.google.android.gms.internal.measurement.zzgc r12 = r4.zza     // Catch:{ all -> 0x0d07 }
            java.lang.String r12 = r12.zzy()     // Catch:{ all -> 0x0d07 }
            java.lang.Object r12 = com.google.android.gms.measurement.internal.zzey.zzn(r12)     // Catch:{ all -> 0x0d07 }
            r5.zzb(r11, r12)     // Catch:{ all -> 0x0d07 }
            r5 = 0
            r11 = 0
            r12 = 0
            r13 = -1
        L_0x0332:
            int r14 = r3.zza()     // Catch:{ all -> 0x0d07 }
            if (r11 >= r14) goto L_0x035c
            com.google.android.gms.internal.measurement.zzfw r14 = r3.zzn(r11)     // Catch:{ all -> 0x0d07 }
            java.lang.String r15 = r14.zzg()     // Catch:{ all -> 0x0d07 }
            boolean r15 = r10.equals(r15)     // Catch:{ all -> 0x0d07 }
            if (r15 == 0) goto L_0x034e
            com.google.android.gms.internal.measurement.zzjy r5 = r14.zzbB()     // Catch:{ all -> 0x0d07 }
            com.google.android.gms.internal.measurement.zzfv r5 = (com.google.android.gms.internal.measurement.zzfv) r5     // Catch:{ all -> 0x0d07 }
            r13 = r11
            goto L_0x0359
        L_0x034e:
            java.lang.String r14 = r14.zzg()     // Catch:{ all -> 0x0d07 }
            boolean r14 = r8.equals(r14)     // Catch:{ all -> 0x0d07 }
            if (r14 == 0) goto L_0x0359
            r12 = 1
        L_0x0359:
            int r11 = r11 + 1
            goto L_0x0332
        L_0x035c:
            if (r12 == 0) goto L_0x0365
            if (r5 == 0) goto L_0x0364
            r3.zzh(r13)     // Catch:{ all -> 0x0d07 }
            goto L_0x0396
        L_0x0364:
            r5 = 0
        L_0x0365:
            if (r5 == 0) goto L_0x037f
            com.google.android.gms.internal.measurement.zzjy r5 = r5.zzau()     // Catch:{ all -> 0x0d07 }
            com.google.android.gms.internal.measurement.zzfv r5 = (com.google.android.gms.internal.measurement.zzfv) r5     // Catch:{ all -> 0x0d07 }
            r5.zzj(r8)     // Catch:{ all -> 0x0d07 }
            r11 = 10
            r5.zzi(r11)     // Catch:{ all -> 0x0d07 }
            com.google.android.gms.internal.measurement.zzkc r5 = r5.zzaE()     // Catch:{ all -> 0x0d07 }
            com.google.android.gms.internal.measurement.zzfw r5 = (com.google.android.gms.internal.measurement.zzfw) r5     // Catch:{ all -> 0x0d07 }
            r3.zzk(r13, r5)     // Catch:{ all -> 0x0d07 }
            goto L_0x0396
        L_0x037f:
            com.google.android.gms.measurement.internal.zzey r5 = r43.zzaz()     // Catch:{ all -> 0x0d07 }
            com.google.android.gms.measurement.internal.zzew r5 = r5.zzd()     // Catch:{ all -> 0x0d07 }
            java.lang.String r8 = "Did not find conversion parameter. appId"
            com.google.android.gms.internal.measurement.zzgc r11 = r4.zza     // Catch:{ all -> 0x0d07 }
            java.lang.String r11 = r11.zzy()     // Catch:{ all -> 0x0d07 }
            java.lang.Object r11 = com.google.android.gms.measurement.internal.zzey.zzn(r11)     // Catch:{ all -> 0x0d07 }
            r5.zzb(r8, r11)     // Catch:{ all -> 0x0d07 }
        L_0x0396:
            if (r2 == 0) goto L_0x044f
            java.util.ArrayList r2 = new java.util.ArrayList     // Catch:{ all -> 0x0d07 }
            java.util.List r5 = r3.zzp()     // Catch:{ all -> 0x0d07 }
            r2.<init>(r5)     // Catch:{ all -> 0x0d07 }
            r5 = 0
            r8 = -1
            r11 = -1
        L_0x03a4:
            int r12 = r2.size()     // Catch:{ all -> 0x0d07 }
            java.lang.String r13 = "currency"
            java.lang.String r14 = "value"
            if (r5 >= r12) goto L_0x03d4
            java.lang.Object r12 = r2.get(r5)     // Catch:{ all -> 0x0d07 }
            com.google.android.gms.internal.measurement.zzfw r12 = (com.google.android.gms.internal.measurement.zzfw) r12     // Catch:{ all -> 0x0d07 }
            java.lang.String r12 = r12.zzg()     // Catch:{ all -> 0x0d07 }
            boolean r12 = r14.equals(r12)     // Catch:{ all -> 0x0d07 }
            if (r12 == 0) goto L_0x03c0
            r8 = r5
            goto L_0x03d1
        L_0x03c0:
            java.lang.Object r12 = r2.get(r5)     // Catch:{ all -> 0x0d07 }
            com.google.android.gms.internal.measurement.zzfw r12 = (com.google.android.gms.internal.measurement.zzfw) r12     // Catch:{ all -> 0x0d07 }
            java.lang.String r12 = r12.zzg()     // Catch:{ all -> 0x0d07 }
            boolean r12 = r13.equals(r12)     // Catch:{ all -> 0x0d07 }
            if (r12 == 0) goto L_0x03d1
            r11 = r5
        L_0x03d1:
            int r5 = r5 + 1
            goto L_0x03a4
        L_0x03d4:
            r5 = -1
            if (r8 != r5) goto L_0x03d9
            goto L_0x0450
        L_0x03d9:
            java.lang.Object r5 = r2.get(r8)     // Catch:{ all -> 0x0d07 }
            com.google.android.gms.internal.measurement.zzfw r5 = (com.google.android.gms.internal.measurement.zzfw) r5     // Catch:{ all -> 0x0d07 }
            boolean r5 = r5.zzw()     // Catch:{ all -> 0x0d07 }
            if (r5 != 0) goto L_0x040a
            java.lang.Object r5 = r2.get(r8)     // Catch:{ all -> 0x0d07 }
            com.google.android.gms.internal.measurement.zzfw r5 = (com.google.android.gms.internal.measurement.zzfw) r5     // Catch:{ all -> 0x0d07 }
            boolean r5 = r5.zzu()     // Catch:{ all -> 0x0d07 }
            if (r5 != 0) goto L_0x040a
            com.google.android.gms.measurement.internal.zzey r2 = r43.zzaz()     // Catch:{ all -> 0x0d07 }
            com.google.android.gms.measurement.internal.zzew r2 = r2.zzl()     // Catch:{ all -> 0x0d07 }
            java.lang.String r5 = "Value must be specified with a numeric type."
            r2.zza(r5)     // Catch:{ all -> 0x0d07 }
            r3.zzh(r8)     // Catch:{ all -> 0x0d07 }
            zzaa(r3, r10)     // Catch:{ all -> 0x0d07 }
            r2 = 18
            zzZ(r3, r2, r14)     // Catch:{ all -> 0x0d07 }
            goto L_0x044f
        L_0x040a:
            r5 = -1
            if (r11 != r5) goto L_0x040e
            goto L_0x0436
        L_0x040e:
            java.lang.Object r2 = r2.get(r11)     // Catch:{ all -> 0x0d07 }
            com.google.android.gms.internal.measurement.zzfw r2 = (com.google.android.gms.internal.measurement.zzfw) r2     // Catch:{ all -> 0x0d07 }
            java.lang.String r2 = r2.zzh()     // Catch:{ all -> 0x0d07 }
            int r11 = r2.length()     // Catch:{ all -> 0x0d07 }
            r12 = 3
            if (r11 != r12) goto L_0x0436
            r11 = 0
        L_0x0420:
            int r12 = r2.length()     // Catch:{ all -> 0x0d07 }
            if (r11 >= r12) goto L_0x0450
            int r12 = r2.codePointAt(r11)     // Catch:{ all -> 0x0d07 }
            boolean r14 = java.lang.Character.isLetter(r12)     // Catch:{ all -> 0x0d07 }
            if (r14 == 0) goto L_0x0436
            int r12 = java.lang.Character.charCount(r12)     // Catch:{ all -> 0x0d07 }
            int r11 = r11 + r12
            goto L_0x0420
        L_0x0436:
            com.google.android.gms.measurement.internal.zzey r2 = r43.zzaz()     // Catch:{ all -> 0x0d07 }
            com.google.android.gms.measurement.internal.zzew r2 = r2.zzl()     // Catch:{ all -> 0x0d07 }
            java.lang.String r11 = "Value parameter discarded. You must also supply a 3-letter ISO_4217 currency code in the currency parameter."
            r2.zza(r11)     // Catch:{ all -> 0x0d07 }
            r3.zzh(r8)     // Catch:{ all -> 0x0d07 }
            zzaa(r3, r10)     // Catch:{ all -> 0x0d07 }
            r2 = 19
            zzZ(r3, r2, r13)     // Catch:{ all -> 0x0d07 }
            goto L_0x0450
        L_0x044f:
            r5 = -1
        L_0x0450:
            java.lang.String r2 = r3.zzo()     // Catch:{ all -> 0x0d07 }
            boolean r2 = r9.equals(r2)     // Catch:{ all -> 0x0d07 }
            r8 = 1000(0x3e8, double:4.94E-321)
            if (r2 == 0) goto L_0x04b4
            com.google.android.gms.measurement.internal.zzlk r2 = r1.zzi     // Catch:{ all -> 0x0d07 }
            zzak(r2)     // Catch:{ all -> 0x0d07 }
            com.google.android.gms.internal.measurement.zzkc r2 = r3.zzaE()     // Catch:{ all -> 0x0d07 }
            com.google.android.gms.internal.measurement.zzfs r2 = (com.google.android.gms.internal.measurement.zzfs) r2     // Catch:{ all -> 0x0d07 }
            com.google.android.gms.internal.measurement.zzfw r2 = com.google.android.gms.measurement.internal.zzlk.zzB(r2, r6)     // Catch:{ all -> 0x0d07 }
            if (r2 != 0) goto L_0x04af
            if (r7 == 0) goto L_0x04a4
            long r10 = r7.zzc()     // Catch:{ all -> 0x0d07 }
            long r12 = r3.zzc()     // Catch:{ all -> 0x0d07 }
            long r10 = r10 - r12
            long r10 = java.lang.Math.abs(r10)     // Catch:{ all -> 0x0d07 }
            int r2 = (r10 > r8 ? 1 : (r10 == r8 ? 0 : -1))
            if (r2 > 0) goto L_0x04a4
            com.google.android.gms.internal.measurement.zzjy r2 = r7.zzau()     // Catch:{ all -> 0x0d07 }
            com.google.android.gms.internal.measurement.zzfr r2 = (com.google.android.gms.internal.measurement.zzfr) r2     // Catch:{ all -> 0x0d07 }
            boolean r6 = r1.zzai(r3, r2)     // Catch:{ all -> 0x0d07 }
            if (r6 == 0) goto L_0x0498
            r6 = r19
            r10 = r27
            r10.zzT(r6, r2)     // Catch:{ all -> 0x0d07 }
            r13 = r23
            r2 = 0
            r14 = 0
            goto L_0x04a0
        L_0x0498:
            r6 = r19
            r10 = r27
            r2 = r3
            r14 = r7
            r13 = r22
        L_0x04a0:
            r12 = r2
            r15 = r6
            goto L_0x0516
        L_0x04a4:
            r6 = r19
            r10 = r27
            r12 = r3
            r15 = r6
            r14 = r7
            r13 = r22
            goto L_0x0516
        L_0x04af:
            r6 = r19
            r10 = r27
            goto L_0x050f
        L_0x04b4:
            r6 = r19
            r10 = r27
            java.lang.String r2 = "_vs"
            java.lang.String r11 = r3.zzo()     // Catch:{ all -> 0x0d07 }
            boolean r2 = r2.equals(r11)     // Catch:{ all -> 0x0d07 }
            if (r2 == 0) goto L_0x050f
            com.google.android.gms.measurement.internal.zzlk r2 = r1.zzi     // Catch:{ all -> 0x0d07 }
            zzak(r2)     // Catch:{ all -> 0x0d07 }
            com.google.android.gms.internal.measurement.zzkc r2 = r3.zzaE()     // Catch:{ all -> 0x0d07 }
            com.google.android.gms.internal.measurement.zzfs r2 = (com.google.android.gms.internal.measurement.zzfs) r2     // Catch:{ all -> 0x0d07 }
            r11 = r26
            com.google.android.gms.internal.measurement.zzfw r2 = com.google.android.gms.measurement.internal.zzlk.zzB(r2, r11)     // Catch:{ all -> 0x0d07 }
            if (r2 != 0) goto L_0x050f
            if (r25 == 0) goto L_0x0509
            long r11 = r25.zzc()     // Catch:{ all -> 0x0d07 }
            long r13 = r3.zzc()     // Catch:{ all -> 0x0d07 }
            long r11 = r11 - r13
            long r11 = java.lang.Math.abs(r11)     // Catch:{ all -> 0x0d07 }
            int r2 = (r11 > r8 ? 1 : (r11 == r8 ? 0 : -1))
            if (r2 > 0) goto L_0x0509
            com.google.android.gms.internal.measurement.zzjy r2 = r25.zzau()     // Catch:{ all -> 0x0d07 }
            com.google.android.gms.internal.measurement.zzfr r2 = (com.google.android.gms.internal.measurement.zzfr) r2     // Catch:{ all -> 0x0d07 }
            boolean r7 = r1.zzai(r2, r3)     // Catch:{ all -> 0x0d07 }
            if (r7 == 0) goto L_0x04ff
            r8 = r23
            r10.zzT(r8, r2)     // Catch:{ all -> 0x0d07 }
            r15 = r6
            r2 = 0
            r12 = 0
            goto L_0x0506
        L_0x04ff:
            r8 = r23
            r2 = r3
            r15 = r22
            r12 = r25
        L_0x0506:
            r14 = r2
            r13 = r8
            goto L_0x0516
        L_0x0509:
            r8 = r23
            r14 = r3
            r15 = r22
            goto L_0x0513
        L_0x050f:
            r8 = r23
            r15 = r6
            r14 = r7
        L_0x0513:
            r13 = r8
            r12 = r25
        L_0x0516:
            java.util.List r2 = r4.zzc     // Catch:{ all -> 0x0d07 }
            com.google.android.gms.internal.measurement.zzkc r6 = r3.zzaE()     // Catch:{ all -> 0x0d07 }
            com.google.android.gms.internal.measurement.zzfs r6 = (com.google.android.gms.internal.measurement.zzfs) r6     // Catch:{ all -> 0x0d07 }
            r7 = r24
            r2.set(r7, r6)     // Catch:{ all -> 0x0d07 }
            int r11 = r22 + 1
            r10.zzk(r3)     // Catch:{ all -> 0x0d07 }
            r9 = r16
        L_0x052a:
            int r2 = r7 + 1
            r5 = r10
            r3 = r18
            r10 = r2
            r2 = r17
            goto L_0x003f
        L_0x0534:
            r10 = r5
            r22 = r11
            r11 = r7
            r2 = 0
            r12 = r2
            r7 = r22
            r5 = 0
        L_0x053e:
            if (r5 >= r7) goto L_0x058e
            com.google.android.gms.internal.measurement.zzfs r8 = r10.zze(r5)     // Catch:{ all -> 0x0d07 }
            java.lang.String r14 = r8.zzh()     // Catch:{ all -> 0x0d07 }
            boolean r14 = r9.equals(r14)     // Catch:{ all -> 0x0d07 }
            if (r14 == 0) goto L_0x0561
            com.google.android.gms.measurement.internal.zzlk r14 = r1.zzi     // Catch:{ all -> 0x0d07 }
            zzak(r14)     // Catch:{ all -> 0x0d07 }
            com.google.android.gms.internal.measurement.zzfw r14 = com.google.android.gms.measurement.internal.zzlk.zzB(r8, r6)     // Catch:{ all -> 0x0d07 }
            if (r14 == 0) goto L_0x0561
            r10.zzA(r5)     // Catch:{ all -> 0x0d07 }
            int r7 = r7 + -1
            int r5 = r5 + -1
            goto L_0x058b
        L_0x0561:
            com.google.android.gms.measurement.internal.zzlk r14 = r1.zzi     // Catch:{ all -> 0x0d07 }
            zzak(r14)     // Catch:{ all -> 0x0d07 }
            com.google.android.gms.internal.measurement.zzfw r8 = com.google.android.gms.measurement.internal.zzlk.zzB(r8, r11)     // Catch:{ all -> 0x0d07 }
            if (r8 == 0) goto L_0x058b
            boolean r14 = r8.zzw()     // Catch:{ all -> 0x0d07 }
            if (r14 == 0) goto L_0x057b
            long r14 = r8.zzd()     // Catch:{ all -> 0x0d07 }
            java.lang.Long r8 = java.lang.Long.valueOf(r14)     // Catch:{ all -> 0x0d07 }
            goto L_0x057c
        L_0x057b:
            r8 = 0
        L_0x057c:
            if (r8 == 0) goto L_0x058b
            long r14 = r8.longValue()     // Catch:{ all -> 0x0d07 }
            int r18 = (r14 > r2 ? 1 : (r14 == r2 ? 0 : -1))
            if (r18 <= 0) goto L_0x058b
            long r14 = r8.longValue()     // Catch:{ all -> 0x0d07 }
            long r12 = r12 + r14
        L_0x058b:
            r8 = 1
            int r5 = r5 + r8
            goto L_0x053e
        L_0x058e:
            r5 = 0
            r1.zzae(r10, r12, r5)     // Catch:{ all -> 0x0d07 }
            java.util.List r5 = r10.zzas()     // Catch:{ all -> 0x0d07 }
            java.util.Iterator r5 = r5.iterator()     // Catch:{ all -> 0x0d07 }
        L_0x059a:
            boolean r6 = r5.hasNext()     // Catch:{ all -> 0x0d07 }
            java.lang.String r7 = "_se"
            if (r6 == 0) goto L_0x05c0
            java.lang.String r6 = "_s"
            java.lang.Object r8 = r5.next()     // Catch:{ all -> 0x0d07 }
            com.google.android.gms.internal.measurement.zzfs r8 = (com.google.android.gms.internal.measurement.zzfs) r8     // Catch:{ all -> 0x0d07 }
            java.lang.String r8 = r8.zzh()     // Catch:{ all -> 0x0d07 }
            boolean r6 = r6.equals(r8)     // Catch:{ all -> 0x0d07 }
            if (r6 == 0) goto L_0x059a
            com.google.android.gms.measurement.internal.zzal r5 = r1.zze     // Catch:{ all -> 0x0d07 }
            zzak(r5)     // Catch:{ all -> 0x0d07 }
            java.lang.String r6 = r10.zzaq()     // Catch:{ all -> 0x0d07 }
            r5.zzA(r6, r7)     // Catch:{ all -> 0x0d07 }
        L_0x05c0:
            java.lang.String r5 = "_sid"
            int r5 = com.google.android.gms.measurement.internal.zzlk.zza(r10, r5)     // Catch:{ all -> 0x0d07 }
            if (r5 < 0) goto L_0x05cd
            r5 = 1
            r1.zzae(r10, r12, r5)     // Catch:{ all -> 0x0d07 }
            goto L_0x05ed
        L_0x05cd:
            int r5 = com.google.android.gms.measurement.internal.zzlk.zza(r10, r7)     // Catch:{ all -> 0x0d07 }
            if (r5 < 0) goto L_0x05ed
            r10.zzB(r5)     // Catch:{ all -> 0x0d07 }
            com.google.android.gms.measurement.internal.zzey r5 = r43.zzaz()     // Catch:{ all -> 0x0d07 }
            com.google.android.gms.measurement.internal.zzew r5 = r5.zzd()     // Catch:{ all -> 0x0d07 }
            java.lang.String r6 = "Session engagement user property is in the bundle without session ID. appId"
            com.google.android.gms.internal.measurement.zzgc r7 = r4.zza     // Catch:{ all -> 0x0d07 }
            java.lang.String r7 = r7.zzy()     // Catch:{ all -> 0x0d07 }
            java.lang.Object r7 = com.google.android.gms.measurement.internal.zzey.zzn(r7)     // Catch:{ all -> 0x0d07 }
            r5.zzb(r6, r7)     // Catch:{ all -> 0x0d07 }
        L_0x05ed:
            com.google.android.gms.measurement.internal.zzlk r5 = r1.zzi     // Catch:{ all -> 0x0d07 }
            zzak(r5)     // Catch:{ all -> 0x0d07 }
            com.google.android.gms.measurement.internal.zzgi r6 = r5.zzs     // Catch:{ all -> 0x0d07 }
            com.google.android.gms.measurement.internal.zzey r6 = r6.zzaz()     // Catch:{ all -> 0x0d07 }
            com.google.android.gms.measurement.internal.zzew r6 = r6.zzj()     // Catch:{ all -> 0x0d07 }
            java.lang.String r7 = "Checking account type status for ad personalization signals"
            r6.zza(r7)     // Catch:{ all -> 0x0d07 }
            com.google.android.gms.measurement.internal.zzli r6 = r5.zzf     // Catch:{ all -> 0x0d07 }
            com.google.android.gms.measurement.internal.zzfz r6 = r6.zzc     // Catch:{ all -> 0x0d07 }
            zzak(r6)     // Catch:{ all -> 0x0d07 }
            java.lang.String r7 = r10.zzaq()     // Catch:{ all -> 0x0d07 }
            boolean r6 = r6.zzn(r7)     // Catch:{ all -> 0x0d07 }
            if (r6 == 0) goto L_0x0684
            com.google.android.gms.measurement.internal.zzli r6 = r5.zzf     // Catch:{ all -> 0x0d07 }
            com.google.android.gms.measurement.internal.zzal r6 = r6.zze     // Catch:{ all -> 0x0d07 }
            zzak(r6)     // Catch:{ all -> 0x0d07 }
            java.lang.String r7 = r10.zzaq()     // Catch:{ all -> 0x0d07 }
            com.google.android.gms.measurement.internal.zzg r6 = r6.zzj(r7)     // Catch:{ all -> 0x0d07 }
            if (r6 == 0) goto L_0x0684
            boolean r6 = r6.zzai()     // Catch:{ all -> 0x0d07 }
            if (r6 == 0) goto L_0x0684
            com.google.android.gms.measurement.internal.zzgi r6 = r5.zzs     // Catch:{ all -> 0x0d07 }
            com.google.android.gms.measurement.internal.zzap r6 = r6.zzg()     // Catch:{ all -> 0x0d07 }
            boolean r6 = r6.zze()     // Catch:{ all -> 0x0d07 }
            if (r6 == 0) goto L_0x0684
            com.google.android.gms.measurement.internal.zzgi r6 = r5.zzs     // Catch:{ all -> 0x0d07 }
            com.google.android.gms.measurement.internal.zzey r6 = r6.zzaz()     // Catch:{ all -> 0x0d07 }
            com.google.android.gms.measurement.internal.zzew r6 = r6.zzc()     // Catch:{ all -> 0x0d07 }
            java.lang.String r7 = "Turning off ad personalization due to account type"
            r6.zza(r7)     // Catch:{ all -> 0x0d07 }
            com.google.android.gms.internal.measurement.zzgk r6 = com.google.android.gms.internal.measurement.zzgl.zzd()     // Catch:{ all -> 0x0d07 }
            r7 = r17
            r6.zzf(r7)     // Catch:{ all -> 0x0d07 }
            com.google.android.gms.measurement.internal.zzgi r5 = r5.zzs     // Catch:{ all -> 0x0d07 }
            com.google.android.gms.measurement.internal.zzap r5 = r5.zzg()     // Catch:{ all -> 0x0d07 }
            long r8 = r5.zza()     // Catch:{ all -> 0x0d07 }
            r6.zzg(r8)     // Catch:{ all -> 0x0d07 }
            r8 = 1
            r6.zze(r8)     // Catch:{ all -> 0x0d07 }
            com.google.android.gms.internal.measurement.zzkc r5 = r6.zzaE()     // Catch:{ all -> 0x0d07 }
            com.google.android.gms.internal.measurement.zzgl r5 = (com.google.android.gms.internal.measurement.zzgl) r5     // Catch:{ all -> 0x0d07 }
            r6 = 0
        L_0x0666:
            int r8 = r10.zzb()     // Catch:{ all -> 0x0d07 }
            if (r6 >= r8) goto L_0x0681
            com.google.android.gms.internal.measurement.zzgl r8 = r10.zzap(r6)     // Catch:{ all -> 0x0d07 }
            java.lang.String r8 = r8.zzf()     // Catch:{ all -> 0x0d07 }
            boolean r8 = r7.equals(r8)     // Catch:{ all -> 0x0d07 }
            if (r8 == 0) goto L_0x067e
            r10.zzan(r6, r5)     // Catch:{ all -> 0x0d07 }
            goto L_0x0684
        L_0x067e:
            int r6 = r6 + 1
            goto L_0x0666
        L_0x0681:
            r10.zzm(r5)     // Catch:{ all -> 0x0d07 }
        L_0x0684:
            r5 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            r10.zzaj(r5)     // Catch:{ all -> 0x0d07 }
            r5 = -9223372036854775808
            r10.zzR(r5)     // Catch:{ all -> 0x0d07 }
            r5 = 0
        L_0x0692:
            int r6 = r10.zza()     // Catch:{ all -> 0x0d07 }
            if (r5 >= r6) goto L_0x06c5
            com.google.android.gms.internal.measurement.zzfs r6 = r10.zze(r5)     // Catch:{ all -> 0x0d07 }
            long r7 = r6.zzd()     // Catch:{ all -> 0x0d07 }
            long r11 = r10.zzd()     // Catch:{ all -> 0x0d07 }
            int r9 = (r7 > r11 ? 1 : (r7 == r11 ? 0 : -1))
            if (r9 >= 0) goto L_0x06af
            long r7 = r6.zzd()     // Catch:{ all -> 0x0d07 }
            r10.zzaj(r7)     // Catch:{ all -> 0x0d07 }
        L_0x06af:
            long r7 = r6.zzd()     // Catch:{ all -> 0x0d07 }
            long r11 = r10.zzc()     // Catch:{ all -> 0x0d07 }
            int r9 = (r7 > r11 ? 1 : (r7 == r11 ? 0 : -1))
            if (r9 <= 0) goto L_0x06c2
            long r6 = r6.zzd()     // Catch:{ all -> 0x0d07 }
            r10.zzR(r6)     // Catch:{ all -> 0x0d07 }
        L_0x06c2:
            int r5 = r5 + 1
            goto L_0x0692
        L_0x06c5:
            r10.zzz()     // Catch:{ all -> 0x0d07 }
            r10.zzo()     // Catch:{ all -> 0x0d07 }
            com.google.android.gms.measurement.internal.zzz r5 = r1.zzh     // Catch:{ all -> 0x0d07 }
            zzak(r5)     // Catch:{ all -> 0x0d07 }
            java.lang.String r23 = r10.zzaq()     // Catch:{ all -> 0x0d07 }
            java.util.List r24 = r10.zzas()     // Catch:{ all -> 0x0d07 }
            java.util.List r25 = r10.zzat()     // Catch:{ all -> 0x0d07 }
            long r6 = r10.zzd()     // Catch:{ all -> 0x0d07 }
            java.lang.Long r26 = java.lang.Long.valueOf(r6)     // Catch:{ all -> 0x0d07 }
            long r6 = r10.zzc()     // Catch:{ all -> 0x0d07 }
            java.lang.Long r27 = java.lang.Long.valueOf(r6)     // Catch:{ all -> 0x0d07 }
            r22 = r5
            java.util.List r5 = r22.zza(r23, r24, r25, r26, r27)     // Catch:{ all -> 0x0d07 }
            r10.zzf(r5)     // Catch:{ all -> 0x0d07 }
            com.google.android.gms.measurement.internal.zzaf r5 = r43.zzg()     // Catch:{ all -> 0x0d07 }
            com.google.android.gms.internal.measurement.zzgc r6 = r4.zza     // Catch:{ all -> 0x0d07 }
            java.lang.String r6 = r6.zzy()     // Catch:{ all -> 0x0d07 }
            boolean r5 = r5.zzw(r6)     // Catch:{ all -> 0x0d07 }
            if (r5 == 0) goto L_0x0a3f
            java.util.HashMap r5 = new java.util.HashMap     // Catch:{ all -> 0x0d07 }
            r5.<init>()     // Catch:{ all -> 0x0d07 }
            java.util.ArrayList r6 = new java.util.ArrayList     // Catch:{ all -> 0x0d07 }
            r6.<init>()     // Catch:{ all -> 0x0d07 }
            com.google.android.gms.measurement.internal.zzlp r7 = r43.zzv()     // Catch:{ all -> 0x0d07 }
            java.security.SecureRandom r7 = r7.zzG()     // Catch:{ all -> 0x0d07 }
            r8 = 0
        L_0x0718:
            int r9 = r10.zza()     // Catch:{ all -> 0x0d07 }
            if (r8 >= r9) goto L_0x0a08
            com.google.android.gms.internal.measurement.zzfs r9 = r10.zze(r8)     // Catch:{ all -> 0x0d07 }
            com.google.android.gms.internal.measurement.zzjy r9 = r9.zzbB()     // Catch:{ all -> 0x0d07 }
            com.google.android.gms.internal.measurement.zzfr r9 = (com.google.android.gms.internal.measurement.zzfr) r9     // Catch:{ all -> 0x0d07 }
            java.lang.String r11 = r9.zzo()     // Catch:{ all -> 0x0d07 }
            java.lang.String r12 = "_ep"
            boolean r11 = r11.equals(r12)     // Catch:{ all -> 0x0d07 }
            java.lang.String r12 = "_efs"
            java.lang.String r13 = "_sr"
            if (r11 == 0) goto L_0x07ae
            com.google.android.gms.measurement.internal.zzlk r11 = r1.zzi     // Catch:{ all -> 0x0d07 }
            zzak(r11)     // Catch:{ all -> 0x0d07 }
            com.google.android.gms.internal.measurement.zzkc r11 = r9.zzaE()     // Catch:{ all -> 0x0d07 }
            com.google.android.gms.internal.measurement.zzfs r11 = (com.google.android.gms.internal.measurement.zzfs) r11     // Catch:{ all -> 0x0d07 }
            java.lang.String r14 = "_en"
            java.lang.Object r11 = com.google.android.gms.measurement.internal.zzlk.zzC(r11, r14)     // Catch:{ all -> 0x0d07 }
            java.lang.String r11 = (java.lang.String) r11     // Catch:{ all -> 0x0d07 }
            java.lang.Object r14 = r5.get(r11)     // Catch:{ all -> 0x0d07 }
            com.google.android.gms.measurement.internal.zzar r14 = (com.google.android.gms.measurement.internal.zzar) r14     // Catch:{ all -> 0x0d07 }
            if (r14 != 0) goto L_0x076a
            com.google.android.gms.measurement.internal.zzal r14 = r1.zze     // Catch:{ all -> 0x0d07 }
            zzak(r14)     // Catch:{ all -> 0x0d07 }
            com.google.android.gms.internal.measurement.zzgc r15 = r4.zza     // Catch:{ all -> 0x0d07 }
            java.lang.String r15 = r15.zzy()     // Catch:{ all -> 0x0d07 }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r11)     // Catch:{ all -> 0x0d07 }
            com.google.android.gms.measurement.internal.zzar r14 = r14.zzn(r15, r11)     // Catch:{ all -> 0x0d07 }
            if (r14 == 0) goto L_0x076a
            r5.put(r11, r14)     // Catch:{ all -> 0x0d07 }
        L_0x076a:
            if (r14 == 0) goto L_0x07a9
            java.lang.Long r11 = r14.zzi     // Catch:{ all -> 0x0d07 }
            if (r11 != 0) goto L_0x07a9
            java.lang.Long r11 = r14.zzj     // Catch:{ all -> 0x0d07 }
            if (r11 == 0) goto L_0x0788
            long r17 = r11.longValue()     // Catch:{ all -> 0x0d07 }
            r20 = 1
            int r11 = (r17 > r20 ? 1 : (r17 == r20 ? 0 : -1))
            if (r11 <= 0) goto L_0x0788
            com.google.android.gms.measurement.internal.zzlk r11 = r1.zzi     // Catch:{ all -> 0x0d07 }
            zzak(r11)     // Catch:{ all -> 0x0d07 }
            java.lang.Long r11 = r14.zzj     // Catch:{ all -> 0x0d07 }
            com.google.android.gms.measurement.internal.zzlk.zzz(r9, r13, r11)     // Catch:{ all -> 0x0d07 }
        L_0x0788:
            java.lang.Boolean r11 = r14.zzk     // Catch:{ all -> 0x0d07 }
            if (r11 == 0) goto L_0x07a0
            boolean r11 = r11.booleanValue()     // Catch:{ all -> 0x0d07 }
            if (r11 == 0) goto L_0x07a0
            com.google.android.gms.measurement.internal.zzlk r11 = r1.zzi     // Catch:{ all -> 0x0d07 }
            zzak(r11)     // Catch:{ all -> 0x0d07 }
            r13 = 1
            java.lang.Long r11 = java.lang.Long.valueOf(r13)     // Catch:{ all -> 0x0d07 }
            com.google.android.gms.measurement.internal.zzlk.zzz(r9, r12, r11)     // Catch:{ all -> 0x0d07 }
        L_0x07a0:
            com.google.android.gms.internal.measurement.zzkc r11 = r9.zzaE()     // Catch:{ all -> 0x0d07 }
            com.google.android.gms.internal.measurement.zzfs r11 = (com.google.android.gms.internal.measurement.zzfs) r11     // Catch:{ all -> 0x0d07 }
            r6.add(r11)     // Catch:{ all -> 0x0d07 }
        L_0x07a9:
            r10.zzT(r8, r9)     // Catch:{ all -> 0x0d07 }
            goto L_0x091d
        L_0x07ae:
            com.google.android.gms.measurement.internal.zzfz r11 = r1.zzc     // Catch:{ all -> 0x0d07 }
            zzak(r11)     // Catch:{ all -> 0x0d07 }
            com.google.android.gms.internal.measurement.zzgc r14 = r4.zza     // Catch:{ all -> 0x0d07 }
            java.lang.String r14 = r14.zzy()     // Catch:{ all -> 0x0d07 }
            java.lang.String r15 = "measurement.account.time_zone_offset_minutes"
            java.lang.String r15 = r11.zza(r14, r15)     // Catch:{ all -> 0x0d07 }
            boolean r17 = android.text.TextUtils.isEmpty(r15)     // Catch:{ all -> 0x0d07 }
            if (r17 != 0) goto L_0x07df
            long r14 = java.lang.Long.parseLong(r15)     // Catch:{ NumberFormatException -> 0x07ca }
            goto L_0x07e1
        L_0x07ca:
            r0 = move-exception
            r15 = r0
            com.google.android.gms.measurement.internal.zzgi r11 = r11.zzs     // Catch:{ all -> 0x0d07 }
            com.google.android.gms.measurement.internal.zzey r11 = r11.zzaz()     // Catch:{ all -> 0x0d07 }
            com.google.android.gms.measurement.internal.zzew r11 = r11.zzk()     // Catch:{ all -> 0x0d07 }
            java.lang.String r2 = "Unable to parse timezone offset. appId"
            java.lang.Object r3 = com.google.android.gms.measurement.internal.zzey.zzn(r14)     // Catch:{ all -> 0x0d07 }
            r11.zzc(r2, r3, r15)     // Catch:{ all -> 0x0d07 }
        L_0x07df:
            r14 = 0
        L_0x07e1:
            com.google.android.gms.measurement.internal.zzlp r2 = r43.zzv()     // Catch:{ all -> 0x0d07 }
            r46 = r12
            long r11 = r9.zzc()     // Catch:{ all -> 0x0d07 }
            long r2 = r2.zzr(r11, r14)     // Catch:{ all -> 0x0d07 }
            com.google.android.gms.internal.measurement.zzkc r11 = r9.zzaE()     // Catch:{ all -> 0x0d07 }
            com.google.android.gms.internal.measurement.zzfs r11 = (com.google.android.gms.internal.measurement.zzfs) r11     // Catch:{ all -> 0x0d07 }
            r20 = 1
            java.lang.Long r12 = java.lang.Long.valueOf(r20)     // Catch:{ all -> 0x0d07 }
            r22 = r14
            java.lang.String r14 = "_dbg"
            boolean r15 = android.text.TextUtils.isEmpty(r14)     // Catch:{ all -> 0x0d07 }
            if (r15 != 0) goto L_0x0839
            java.util.List r11 = r11.zzi()     // Catch:{ all -> 0x0d07 }
            java.util.Iterator r11 = r11.iterator()     // Catch:{ all -> 0x0d07 }
        L_0x080d:
            boolean r15 = r11.hasNext()     // Catch:{ all -> 0x0d07 }
            if (r15 == 0) goto L_0x0839
            java.lang.Object r15 = r11.next()     // Catch:{ all -> 0x0d07 }
            com.google.android.gms.internal.measurement.zzfw r15 = (com.google.android.gms.internal.measurement.zzfw) r15     // Catch:{ all -> 0x0d07 }
            r24 = r11
            java.lang.String r11 = r15.zzg()     // Catch:{ all -> 0x0d07 }
            boolean r11 = r14.equals(r11)     // Catch:{ all -> 0x0d07 }
            if (r11 == 0) goto L_0x0836
            long r14 = r15.zzd()     // Catch:{ all -> 0x0d07 }
            java.lang.Long r11 = java.lang.Long.valueOf(r14)     // Catch:{ all -> 0x0d07 }
            boolean r11 = r12.equals(r11)     // Catch:{ all -> 0x0d07 }
            if (r11 != 0) goto L_0x0834
            goto L_0x0839
        L_0x0834:
            r11 = 1
            goto L_0x084c
        L_0x0836:
            r11 = r24
            goto L_0x080d
        L_0x0839:
            com.google.android.gms.measurement.internal.zzfz r11 = r1.zzc     // Catch:{ all -> 0x0d07 }
            zzak(r11)     // Catch:{ all -> 0x0d07 }
            com.google.android.gms.internal.measurement.zzgc r12 = r4.zza     // Catch:{ all -> 0x0d07 }
            java.lang.String r12 = r12.zzy()     // Catch:{ all -> 0x0d07 }
            java.lang.String r14 = r9.zzo()     // Catch:{ all -> 0x0d07 }
            int r11 = r11.zzc(r12, r14)     // Catch:{ all -> 0x0d07 }
        L_0x084c:
            if (r11 > 0) goto L_0x0871
            com.google.android.gms.measurement.internal.zzey r2 = r43.zzaz()     // Catch:{ all -> 0x0d07 }
            com.google.android.gms.measurement.internal.zzew r2 = r2.zzk()     // Catch:{ all -> 0x0d07 }
            java.lang.String r3 = "Sample rate must be positive. event, rate"
            java.lang.String r12 = r9.zzo()     // Catch:{ all -> 0x0d07 }
            java.lang.Integer r11 = java.lang.Integer.valueOf(r11)     // Catch:{ all -> 0x0d07 }
            r2.zzc(r3, r12, r11)     // Catch:{ all -> 0x0d07 }
            com.google.android.gms.internal.measurement.zzkc r2 = r9.zzaE()     // Catch:{ all -> 0x0d07 }
            com.google.android.gms.internal.measurement.zzfs r2 = (com.google.android.gms.internal.measurement.zzfs) r2     // Catch:{ all -> 0x0d07 }
            r6.add(r2)     // Catch:{ all -> 0x0d07 }
            r10.zzT(r8, r9)     // Catch:{ all -> 0x0d07 }
            goto L_0x091d
        L_0x0871:
            java.lang.String r12 = r9.zzo()     // Catch:{ all -> 0x0d07 }
            java.lang.Object r12 = r5.get(r12)     // Catch:{ all -> 0x0d07 }
            com.google.android.gms.measurement.internal.zzar r12 = (com.google.android.gms.measurement.internal.zzar) r12     // Catch:{ all -> 0x0d07 }
            if (r12 != 0) goto L_0x08d1
            com.google.android.gms.measurement.internal.zzal r12 = r1.zze     // Catch:{ all -> 0x0d07 }
            zzak(r12)     // Catch:{ all -> 0x0d07 }
            com.google.android.gms.internal.measurement.zzgc r14 = r4.zza     // Catch:{ all -> 0x0d07 }
            java.lang.String r14 = r14.zzy()     // Catch:{ all -> 0x0d07 }
            java.lang.String r15 = r9.zzo()     // Catch:{ all -> 0x0d07 }
            com.google.android.gms.measurement.internal.zzar r12 = r12.zzn(r14, r15)     // Catch:{ all -> 0x0d07 }
            if (r12 != 0) goto L_0x08d1
            com.google.android.gms.measurement.internal.zzey r12 = r43.zzaz()     // Catch:{ all -> 0x0d07 }
            com.google.android.gms.measurement.internal.zzew r12 = r12.zzk()     // Catch:{ all -> 0x0d07 }
            java.lang.String r14 = "Event being bundled has no eventAggregate. appId, eventName"
            com.google.android.gms.internal.measurement.zzgc r15 = r4.zza     // Catch:{ all -> 0x0d07 }
            java.lang.String r15 = r15.zzy()     // Catch:{ all -> 0x0d07 }
            r24 = r2
            java.lang.String r2 = r9.zzo()     // Catch:{ all -> 0x0d07 }
            r12.zzc(r14, r15, r2)     // Catch:{ all -> 0x0d07 }
            com.google.android.gms.measurement.internal.zzar r2 = new com.google.android.gms.measurement.internal.zzar     // Catch:{ all -> 0x0d07 }
            com.google.android.gms.internal.measurement.zzgc r3 = r4.zza     // Catch:{ all -> 0x0d07 }
            java.lang.String r27 = r3.zzy()     // Catch:{ all -> 0x0d07 }
            java.lang.String r28 = r9.zzo()     // Catch:{ all -> 0x0d07 }
            r29 = 1
            r31 = 1
            r33 = 1
            long r35 = r9.zzc()     // Catch:{ all -> 0x0d07 }
            r37 = 0
            r39 = 0
            r40 = 0
            r41 = 0
            r42 = 0
            r26 = r2
            r26.<init>(r27, r28, r29, r31, r33, r35, r37, r39, r40, r41, r42)     // Catch:{ all -> 0x0d07 }
            goto L_0x08d4
        L_0x08d1:
            r24 = r2
            r2 = r12
        L_0x08d4:
            com.google.android.gms.measurement.internal.zzlk r3 = r1.zzi     // Catch:{ all -> 0x0d07 }
            zzak(r3)     // Catch:{ all -> 0x0d07 }
            com.google.android.gms.internal.measurement.zzkc r3 = r9.zzaE()     // Catch:{ all -> 0x0d07 }
            com.google.android.gms.internal.measurement.zzfs r3 = (com.google.android.gms.internal.measurement.zzfs) r3     // Catch:{ all -> 0x0d07 }
            java.lang.String r12 = "_eid"
            java.lang.Object r3 = com.google.android.gms.measurement.internal.zzlk.zzC(r3, r12)     // Catch:{ all -> 0x0d07 }
            java.lang.Long r3 = (java.lang.Long) r3     // Catch:{ all -> 0x0d07 }
            if (r3 == 0) goto L_0x08eb
            r12 = 1
            goto L_0x08ec
        L_0x08eb:
            r12 = 0
        L_0x08ec:
            java.lang.Boolean r12 = java.lang.Boolean.valueOf(r12)     // Catch:{ all -> 0x0d07 }
            r14 = 1
            if (r11 != r14) goto L_0x0927
            com.google.android.gms.internal.measurement.zzkc r3 = r9.zzaE()     // Catch:{ all -> 0x0d07 }
            com.google.android.gms.internal.measurement.zzfs r3 = (com.google.android.gms.internal.measurement.zzfs) r3     // Catch:{ all -> 0x0d07 }
            r6.add(r3)     // Catch:{ all -> 0x0d07 }
            boolean r3 = r12.booleanValue()     // Catch:{ all -> 0x0d07 }
            if (r3 == 0) goto L_0x091a
            java.lang.Long r3 = r2.zzi     // Catch:{ all -> 0x0d07 }
            if (r3 != 0) goto L_0x090e
            java.lang.Long r3 = r2.zzj     // Catch:{ all -> 0x0d07 }
            if (r3 != 0) goto L_0x090e
            java.lang.Boolean r3 = r2.zzk     // Catch:{ all -> 0x0d07 }
            if (r3 == 0) goto L_0x091a
        L_0x090e:
            r3 = 0
            com.google.android.gms.measurement.internal.zzar r2 = r2.zza(r3, r3, r3)     // Catch:{ all -> 0x0d07 }
            java.lang.String r3 = r9.zzo()     // Catch:{ all -> 0x0d07 }
            r5.put(r3, r2)     // Catch:{ all -> 0x0d07 }
        L_0x091a:
            r10.zzT(r8, r9)     // Catch:{ all -> 0x0d07 }
        L_0x091d:
            r25 = r4
            r24 = r7
            r3 = 1
            r7 = r6
            r6 = r5
            goto L_0x09fc
        L_0x0927:
            int r14 = r7.nextInt(r11)     // Catch:{ all -> 0x0d07 }
            if (r14 != 0) goto L_0x0969
            com.google.android.gms.measurement.internal.zzlk r3 = r1.zzi     // Catch:{ all -> 0x0d07 }
            zzak(r3)     // Catch:{ all -> 0x0d07 }
            long r14 = (long) r11     // Catch:{ all -> 0x0d07 }
            java.lang.Long r3 = java.lang.Long.valueOf(r14)     // Catch:{ all -> 0x0d07 }
            com.google.android.gms.measurement.internal.zzlk.zzz(r9, r13, r3)     // Catch:{ all -> 0x0d07 }
            com.google.android.gms.internal.measurement.zzkc r11 = r9.zzaE()     // Catch:{ all -> 0x0d07 }
            com.google.android.gms.internal.measurement.zzfs r11 = (com.google.android.gms.internal.measurement.zzfs) r11     // Catch:{ all -> 0x0d07 }
            r6.add(r11)     // Catch:{ all -> 0x0d07 }
            boolean r11 = r12.booleanValue()     // Catch:{ all -> 0x0d07 }
            if (r11 == 0) goto L_0x094e
            r11 = 0
            com.google.android.gms.measurement.internal.zzar r2 = r2.zza(r11, r3, r11)     // Catch:{ all -> 0x0d07 }
        L_0x094e:
            java.lang.String r3 = r9.zzo()     // Catch:{ all -> 0x0d07 }
            long r11 = r9.zzc()     // Catch:{ all -> 0x0d07 }
            r14 = r24
            com.google.android.gms.measurement.internal.zzar r2 = r2.zzb(r11, r14)     // Catch:{ all -> 0x0d07 }
            r5.put(r3, r2)     // Catch:{ all -> 0x0d07 }
            r25 = r4
            r24 = r7
            r3 = 1
            r7 = r6
            r6 = r5
            goto L_0x09f9
        L_0x0969:
            r14 = r24
            r24 = r7
            java.lang.Long r7 = r2.zzh     // Catch:{ all -> 0x0d07 }
            if (r7 == 0) goto L_0x097e
            long r22 = r7.longValue()     // Catch:{ all -> 0x0d07 }
            r26 = r3
            r25 = r4
            r27 = r5
            r28 = r6
            goto L_0x0994
        L_0x097e:
            com.google.android.gms.measurement.internal.zzlp r7 = r43.zzv()     // Catch:{ all -> 0x0d07 }
            r26 = r3
            r25 = r4
            long r3 = r9.zzb()     // Catch:{ all -> 0x0d07 }
            r27 = r5
            r28 = r6
            r5 = r22
            long r22 = r7.zzr(r3, r5)     // Catch:{ all -> 0x0d07 }
        L_0x0994:
            int r3 = (r22 > r14 ? 1 : (r22 == r14 ? 0 : -1))
            if (r3 == 0) goto L_0x09df
            com.google.android.gms.measurement.internal.zzlk r3 = r1.zzi     // Catch:{ all -> 0x0d07 }
            zzak(r3)     // Catch:{ all -> 0x0d07 }
            r3 = 1
            java.lang.Long r5 = java.lang.Long.valueOf(r3)     // Catch:{ all -> 0x0d07 }
            r6 = r46
            com.google.android.gms.measurement.internal.zzlk.zzz(r9, r6, r5)     // Catch:{ all -> 0x0d07 }
            com.google.android.gms.measurement.internal.zzlk r5 = r1.zzi     // Catch:{ all -> 0x0d07 }
            zzak(r5)     // Catch:{ all -> 0x0d07 }
            long r5 = (long) r11     // Catch:{ all -> 0x0d07 }
            java.lang.Long r5 = java.lang.Long.valueOf(r5)     // Catch:{ all -> 0x0d07 }
            com.google.android.gms.measurement.internal.zzlk.zzz(r9, r13, r5)     // Catch:{ all -> 0x0d07 }
            com.google.android.gms.internal.measurement.zzkc r6 = r9.zzaE()     // Catch:{ all -> 0x0d07 }
            com.google.android.gms.internal.measurement.zzfs r6 = (com.google.android.gms.internal.measurement.zzfs) r6     // Catch:{ all -> 0x0d07 }
            r7 = r28
            r7.add(r6)     // Catch:{ all -> 0x0d07 }
            boolean r6 = r12.booleanValue()     // Catch:{ all -> 0x0d07 }
            if (r6 == 0) goto L_0x09cd
            java.lang.Boolean r6 = java.lang.Boolean.TRUE     // Catch:{ all -> 0x0d07 }
            r11 = 0
            com.google.android.gms.measurement.internal.zzar r2 = r2.zza(r11, r5, r6)     // Catch:{ all -> 0x0d07 }
        L_0x09cd:
            java.lang.String r5 = r9.zzo()     // Catch:{ all -> 0x0d07 }
            long r11 = r9.zzc()     // Catch:{ all -> 0x0d07 }
            com.google.android.gms.measurement.internal.zzar r2 = r2.zzb(r11, r14)     // Catch:{ all -> 0x0d07 }
            r6 = r27
            r6.put(r5, r2)     // Catch:{ all -> 0x0d07 }
            goto L_0x09f9
        L_0x09df:
            r6 = r27
            r7 = r28
            r3 = 1
            boolean r5 = r12.booleanValue()     // Catch:{ all -> 0x0d07 }
            if (r5 == 0) goto L_0x09f9
            java.lang.String r5 = r9.zzo()     // Catch:{ all -> 0x0d07 }
            r11 = r26
            r12 = 0
            com.google.android.gms.measurement.internal.zzar r2 = r2.zza(r11, r12, r12)     // Catch:{ all -> 0x0d07 }
            r6.put(r5, r2)     // Catch:{ all -> 0x0d07 }
        L_0x09f9:
            r10.zzT(r8, r9)     // Catch:{ all -> 0x0d07 }
        L_0x09fc:
            int r8 = r8 + 1
            r5 = r6
            r6 = r7
            r7 = r24
            r4 = r25
            r2 = 0
            goto L_0x0718
        L_0x0a08:
            r25 = r4
            r7 = r6
            r6 = r5
            int r2 = r7.size()     // Catch:{ all -> 0x0d07 }
            int r3 = r10.zza()     // Catch:{ all -> 0x0d07 }
            if (r2 >= r3) goto L_0x0a1c
            r10.zzr()     // Catch:{ all -> 0x0d07 }
            r10.zzg(r7)     // Catch:{ all -> 0x0d07 }
        L_0x0a1c:
            java.util.Set r2 = r6.entrySet()     // Catch:{ all -> 0x0d07 }
            java.util.Iterator r2 = r2.iterator()     // Catch:{ all -> 0x0d07 }
        L_0x0a24:
            boolean r3 = r2.hasNext()     // Catch:{ all -> 0x0d07 }
            if (r3 == 0) goto L_0x0a41
            java.lang.Object r3 = r2.next()     // Catch:{ all -> 0x0d07 }
            java.util.Map$Entry r3 = (java.util.Map.Entry) r3     // Catch:{ all -> 0x0d07 }
            com.google.android.gms.measurement.internal.zzal r4 = r1.zze     // Catch:{ all -> 0x0d07 }
            zzak(r4)     // Catch:{ all -> 0x0d07 }
            java.lang.Object r3 = r3.getValue()     // Catch:{ all -> 0x0d07 }
            com.google.android.gms.measurement.internal.zzar r3 = (com.google.android.gms.measurement.internal.zzar) r3     // Catch:{ all -> 0x0d07 }
            r4.zzE(r3)     // Catch:{ all -> 0x0d07 }
            goto L_0x0a24
        L_0x0a3f:
            r25 = r4
        L_0x0a41:
            r2 = r25
            com.google.android.gms.internal.measurement.zzgc r3 = r2.zza     // Catch:{ all -> 0x0d07 }
            java.lang.String r3 = r3.zzy()     // Catch:{ all -> 0x0d07 }
            com.google.android.gms.measurement.internal.zzal r4 = r1.zze     // Catch:{ all -> 0x0d07 }
            zzak(r4)     // Catch:{ all -> 0x0d07 }
            com.google.android.gms.measurement.internal.zzg r4 = r4.zzj(r3)     // Catch:{ all -> 0x0d07 }
            if (r4 != 0) goto L_0x0a6c
            com.google.android.gms.measurement.internal.zzey r4 = r43.zzaz()     // Catch:{ all -> 0x0d07 }
            com.google.android.gms.measurement.internal.zzew r4 = r4.zzd()     // Catch:{ all -> 0x0d07 }
            java.lang.String r5 = "Bundling raw events w/o app info. appId"
            com.google.android.gms.internal.measurement.zzgc r6 = r2.zza     // Catch:{ all -> 0x0d07 }
            java.lang.String r6 = r6.zzy()     // Catch:{ all -> 0x0d07 }
            java.lang.Object r6 = com.google.android.gms.measurement.internal.zzey.zzn(r6)     // Catch:{ all -> 0x0d07 }
            r4.zzb(r5, r6)     // Catch:{ all -> 0x0d07 }
            goto L_0x0ac8
        L_0x0a6c:
            int r5 = r10.zza()     // Catch:{ all -> 0x0d07 }
            if (r5 <= 0) goto L_0x0ac8
            long r5 = r4.zzn()     // Catch:{ all -> 0x0d07 }
            r7 = 0
            int r9 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r9 == 0) goto L_0x0a80
            r10.zzac(r5)     // Catch:{ all -> 0x0d07 }
            goto L_0x0a83
        L_0x0a80:
            r10.zzv()     // Catch:{ all -> 0x0d07 }
        L_0x0a83:
            long r7 = r4.zzp()     // Catch:{ all -> 0x0d07 }
            r11 = 0
            int r9 = (r7 > r11 ? 1 : (r7 == r11 ? 0 : -1))
            if (r9 != 0) goto L_0x0a8e
            goto L_0x0a8f
        L_0x0a8e:
            r5 = r7
        L_0x0a8f:
            int r7 = (r5 > r11 ? 1 : (r5 == r11 ? 0 : -1))
            if (r7 == 0) goto L_0x0a97
            r10.zzad(r5)     // Catch:{ all -> 0x0d07 }
            goto L_0x0a9a
        L_0x0a97:
            r10.zzw()     // Catch:{ all -> 0x0d07 }
        L_0x0a9a:
            r4.zzE()     // Catch:{ all -> 0x0d07 }
            long r5 = r4.zzo()     // Catch:{ all -> 0x0d07 }
            int r6 = (int) r5     // Catch:{ all -> 0x0d07 }
            r10.zzJ(r6)     // Catch:{ all -> 0x0d07 }
            long r5 = r10.zzd()     // Catch:{ all -> 0x0d07 }
            r4.zzac(r5)     // Catch:{ all -> 0x0d07 }
            long r5 = r10.zzc()     // Catch:{ all -> 0x0d07 }
            r4.zzaa(r5)     // Catch:{ all -> 0x0d07 }
            java.lang.String r5 = r4.zzs()     // Catch:{ all -> 0x0d07 }
            if (r5 == 0) goto L_0x0abd
            r10.zzX(r5)     // Catch:{ all -> 0x0d07 }
            goto L_0x0ac0
        L_0x0abd:
            r10.zzs()     // Catch:{ all -> 0x0d07 }
        L_0x0ac0:
            com.google.android.gms.measurement.internal.zzal r5 = r1.zze     // Catch:{ all -> 0x0d07 }
            zzak(r5)     // Catch:{ all -> 0x0d07 }
            r5.zzD(r4)     // Catch:{ all -> 0x0d07 }
        L_0x0ac8:
            int r4 = r10.zza()     // Catch:{ all -> 0x0d07 }
            if (r4 <= 0) goto L_0x0c4c
            com.google.android.gms.measurement.internal.zzgi r4 = r1.zzn     // Catch:{ all -> 0x0d07 }
            r4.zzax()     // Catch:{ all -> 0x0d07 }
            com.google.android.gms.measurement.internal.zzfz r4 = r1.zzc     // Catch:{ all -> 0x0d07 }
            zzak(r4)     // Catch:{ all -> 0x0d07 }
            com.google.android.gms.internal.measurement.zzgc r5 = r2.zza     // Catch:{ all -> 0x0d07 }
            java.lang.String r5 = r5.zzy()     // Catch:{ all -> 0x0d07 }
            com.google.android.gms.internal.measurement.zzfe r4 = r4.zze(r5)     // Catch:{ all -> 0x0d07 }
            r5 = -1
            if (r4 == 0) goto L_0x0af5
            boolean r7 = r4.zzs()     // Catch:{ all -> 0x0d07 }
            if (r7 != 0) goto L_0x0aed
            goto L_0x0af5
        L_0x0aed:
            long r7 = r4.zzc()     // Catch:{ all -> 0x0d07 }
            r10.zzL(r7)     // Catch:{ all -> 0x0d07 }
            goto L_0x0b1c
        L_0x0af5:
            com.google.android.gms.internal.measurement.zzgc r4 = r2.zza     // Catch:{ all -> 0x0d07 }
            java.lang.String r4 = r4.zzG()     // Catch:{ all -> 0x0d07 }
            boolean r4 = android.text.TextUtils.isEmpty(r4)     // Catch:{ all -> 0x0d07 }
            if (r4 == 0) goto L_0x0b05
            r10.zzL(r5)     // Catch:{ all -> 0x0d07 }
            goto L_0x0b1c
        L_0x0b05:
            com.google.android.gms.measurement.internal.zzey r4 = r43.zzaz()     // Catch:{ all -> 0x0d07 }
            com.google.android.gms.measurement.internal.zzew r4 = r4.zzk()     // Catch:{ all -> 0x0d07 }
            java.lang.String r7 = "Did not find measurement config or missing version info. appId"
            com.google.android.gms.internal.measurement.zzgc r8 = r2.zza     // Catch:{ all -> 0x0d07 }
            java.lang.String r8 = r8.zzy()     // Catch:{ all -> 0x0d07 }
            java.lang.Object r8 = com.google.android.gms.measurement.internal.zzey.zzn(r8)     // Catch:{ all -> 0x0d07 }
            r4.zzb(r7, r8)     // Catch:{ all -> 0x0d07 }
        L_0x0b1c:
            com.google.android.gms.measurement.internal.zzal r4 = r1.zze     // Catch:{ all -> 0x0d07 }
            zzak(r4)     // Catch:{ all -> 0x0d07 }
            com.google.android.gms.internal.measurement.zzkc r7 = r10.zzaE()     // Catch:{ all -> 0x0d07 }
            com.google.android.gms.internal.measurement.zzgc r7 = (com.google.android.gms.internal.measurement.zzgc) r7     // Catch:{ all -> 0x0d07 }
            r4.zzg()     // Catch:{ all -> 0x0d07 }
            r4.zzW()     // Catch:{ all -> 0x0d07 }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r7)     // Catch:{ all -> 0x0d07 }
            java.lang.String r8 = r7.zzy()     // Catch:{ all -> 0x0d07 }
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r8)     // Catch:{ all -> 0x0d07 }
            boolean r8 = r7.zzbh()     // Catch:{ all -> 0x0d07 }
            com.google.android.gms.common.internal.Preconditions.checkState(r8)     // Catch:{ all -> 0x0d07 }
            r4.zzz()     // Catch:{ all -> 0x0d07 }
            com.google.android.gms.measurement.internal.zzgi r8 = r4.zzs     // Catch:{ all -> 0x0d07 }
            com.google.android.gms.common.util.Clock r8 = r8.zzaw()     // Catch:{ all -> 0x0d07 }
            long r8 = r8.currentTimeMillis()     // Catch:{ all -> 0x0d07 }
            long r10 = r7.zzm()     // Catch:{ all -> 0x0d07 }
            com.google.android.gms.measurement.internal.zzgi r12 = r4.zzs     // Catch:{ all -> 0x0d07 }
            r12.zzf()     // Catch:{ all -> 0x0d07 }
            long r12 = com.google.android.gms.measurement.internal.zzaf.zzA()     // Catch:{ all -> 0x0d07 }
            long r12 = r8 - r12
            int r14 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r14 < 0) goto L_0x0b70
            long r10 = r7.zzm()     // Catch:{ all -> 0x0d07 }
            com.google.android.gms.measurement.internal.zzgi r12 = r4.zzs     // Catch:{ all -> 0x0d07 }
            r12.zzf()     // Catch:{ all -> 0x0d07 }
            long r12 = com.google.android.gms.measurement.internal.zzaf.zzA()     // Catch:{ all -> 0x0d07 }
            long r12 = r12 + r8
            int r14 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r14 <= 0) goto L_0x0b93
        L_0x0b70:
            com.google.android.gms.measurement.internal.zzgi r10 = r4.zzs     // Catch:{ all -> 0x0d07 }
            com.google.android.gms.measurement.internal.zzey r10 = r10.zzaz()     // Catch:{ all -> 0x0d07 }
            com.google.android.gms.measurement.internal.zzew r10 = r10.zzk()     // Catch:{ all -> 0x0d07 }
            java.lang.String r11 = "Storing bundle outside of the max uploading time span. appId, now, timestamp"
            java.lang.String r12 = r7.zzy()     // Catch:{ all -> 0x0d07 }
            java.lang.Object r12 = com.google.android.gms.measurement.internal.zzey.zzn(r12)     // Catch:{ all -> 0x0d07 }
            java.lang.Long r8 = java.lang.Long.valueOf(r8)     // Catch:{ all -> 0x0d07 }
            long r13 = r7.zzm()     // Catch:{ all -> 0x0d07 }
            java.lang.Long r9 = java.lang.Long.valueOf(r13)     // Catch:{ all -> 0x0d07 }
            r10.zzd(r11, r12, r8, r9)     // Catch:{ all -> 0x0d07 }
        L_0x0b93:
            byte[] r8 = r7.zzby()     // Catch:{ all -> 0x0d07 }
            com.google.android.gms.measurement.internal.zzli r9 = r4.zzf     // Catch:{ IOException -> 0x0c33 }
            com.google.android.gms.measurement.internal.zzlk r9 = r9.zzi     // Catch:{ IOException -> 0x0c33 }
            zzak(r9)     // Catch:{ IOException -> 0x0c33 }
            byte[] r8 = r9.zzy(r8)     // Catch:{ IOException -> 0x0c33 }
            com.google.android.gms.measurement.internal.zzgi r9 = r4.zzs     // Catch:{ all -> 0x0d07 }
            com.google.android.gms.measurement.internal.zzey r9 = r9.zzaz()     // Catch:{ all -> 0x0d07 }
            com.google.android.gms.measurement.internal.zzew r9 = r9.zzj()     // Catch:{ all -> 0x0d07 }
            java.lang.String r10 = "Saving bundle, size"
            int r11 = r8.length     // Catch:{ all -> 0x0d07 }
            java.lang.Integer r11 = java.lang.Integer.valueOf(r11)     // Catch:{ all -> 0x0d07 }
            r9.zzb(r10, r11)     // Catch:{ all -> 0x0d07 }
            android.content.ContentValues r9 = new android.content.ContentValues     // Catch:{ all -> 0x0d07 }
            r9.<init>()     // Catch:{ all -> 0x0d07 }
            java.lang.String r10 = "app_id"
            java.lang.String r11 = r7.zzy()     // Catch:{ all -> 0x0d07 }
            r9.put(r10, r11)     // Catch:{ all -> 0x0d07 }
            java.lang.String r10 = "bundle_end_timestamp"
            long r11 = r7.zzm()     // Catch:{ all -> 0x0d07 }
            java.lang.Long r11 = java.lang.Long.valueOf(r11)     // Catch:{ all -> 0x0d07 }
            r9.put(r10, r11)     // Catch:{ all -> 0x0d07 }
            java.lang.String r10 = "data"
            r9.put(r10, r8)     // Catch:{ all -> 0x0d07 }
            java.lang.String r8 = "has_realtime"
            java.lang.Integer r10 = java.lang.Integer.valueOf(r16)     // Catch:{ all -> 0x0d07 }
            r9.put(r8, r10)     // Catch:{ all -> 0x0d07 }
            boolean r8 = r7.zzbn()     // Catch:{ all -> 0x0d07 }
            if (r8 == 0) goto L_0x0bf2
            java.lang.String r8 = "retry_count"
            int r10 = r7.zze()     // Catch:{ all -> 0x0d07 }
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)     // Catch:{ all -> 0x0d07 }
            r9.put(r8, r10)     // Catch:{ all -> 0x0d07 }
        L_0x0bf2:
            android.database.sqlite.SQLiteDatabase r8 = r4.zzh()     // Catch:{ SQLiteException -> 0x0c19 }
            java.lang.String r10 = "queue"
            r11 = 0
            long r8 = r8.insert(r10, r11, r9)     // Catch:{ SQLiteException -> 0x0c19 }
            int r10 = (r8 > r5 ? 1 : (r8 == r5 ? 0 : -1))
            if (r10 != 0) goto L_0x0c4c
            com.google.android.gms.measurement.internal.zzgi r5 = r4.zzs     // Catch:{ SQLiteException -> 0x0c19 }
            com.google.android.gms.measurement.internal.zzey r5 = r5.zzaz()     // Catch:{ SQLiteException -> 0x0c19 }
            com.google.android.gms.measurement.internal.zzew r5 = r5.zzd()     // Catch:{ SQLiteException -> 0x0c19 }
            java.lang.String r6 = "Failed to insert bundle (got -1). appId"
            java.lang.String r8 = r7.zzy()     // Catch:{ SQLiteException -> 0x0c19 }
            java.lang.Object r8 = com.google.android.gms.measurement.internal.zzey.zzn(r8)     // Catch:{ SQLiteException -> 0x0c19 }
            r5.zzb(r6, r8)     // Catch:{ SQLiteException -> 0x0c19 }
            goto L_0x0c4c
        L_0x0c19:
            r0 = move-exception
            r5 = r0
            com.google.android.gms.measurement.internal.zzgi r4 = r4.zzs     // Catch:{ all -> 0x0d07 }
            com.google.android.gms.measurement.internal.zzey r4 = r4.zzaz()     // Catch:{ all -> 0x0d07 }
            com.google.android.gms.measurement.internal.zzew r4 = r4.zzd()     // Catch:{ all -> 0x0d07 }
            java.lang.String r6 = "Error storing bundle. appId"
            java.lang.String r7 = r7.zzy()     // Catch:{ all -> 0x0d07 }
            java.lang.Object r7 = com.google.android.gms.measurement.internal.zzey.zzn(r7)     // Catch:{ all -> 0x0d07 }
            r4.zzc(r6, r7, r5)     // Catch:{ all -> 0x0d07 }
            goto L_0x0c4c
        L_0x0c33:
            r0 = move-exception
            r5 = r0
            com.google.android.gms.measurement.internal.zzgi r4 = r4.zzs     // Catch:{ all -> 0x0d07 }
            com.google.android.gms.measurement.internal.zzey r4 = r4.zzaz()     // Catch:{ all -> 0x0d07 }
            com.google.android.gms.measurement.internal.zzew r4 = r4.zzd()     // Catch:{ all -> 0x0d07 }
            java.lang.String r6 = "Data loss. Failed to serialize bundle. appId"
            java.lang.String r7 = r7.zzy()     // Catch:{ all -> 0x0d07 }
            java.lang.Object r7 = com.google.android.gms.measurement.internal.zzey.zzn(r7)     // Catch:{ all -> 0x0d07 }
            r4.zzc(r6, r7, r5)     // Catch:{ all -> 0x0d07 }
        L_0x0c4c:
            com.google.android.gms.measurement.internal.zzal r4 = r1.zze     // Catch:{ all -> 0x0d07 }
            zzak(r4)     // Catch:{ all -> 0x0d07 }
            java.util.List r2 = r2.zzb     // Catch:{ all -> 0x0d07 }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r2)     // Catch:{ all -> 0x0d07 }
            r4.zzg()     // Catch:{ all -> 0x0d07 }
            r4.zzW()     // Catch:{ all -> 0x0d07 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x0d07 }
            java.lang.String r6 = "rowid in ("
            r5.<init>(r6)     // Catch:{ all -> 0x0d07 }
            r6 = 0
        L_0x0c64:
            int r7 = r2.size()     // Catch:{ all -> 0x0d07 }
            if (r6 >= r7) goto L_0x0c81
            if (r6 == 0) goto L_0x0c71
            java.lang.String r7 = ","
            r5.append(r7)     // Catch:{ all -> 0x0d07 }
        L_0x0c71:
            java.lang.Object r7 = r2.get(r6)     // Catch:{ all -> 0x0d07 }
            java.lang.Long r7 = (java.lang.Long) r7     // Catch:{ all -> 0x0d07 }
            long r7 = r7.longValue()     // Catch:{ all -> 0x0d07 }
            r5.append(r7)     // Catch:{ all -> 0x0d07 }
            int r6 = r6 + 1
            goto L_0x0c64
        L_0x0c81:
            java.lang.String r6 = ")"
            r5.append(r6)     // Catch:{ all -> 0x0d07 }
            android.database.sqlite.SQLiteDatabase r6 = r4.zzh()     // Catch:{ all -> 0x0d07 }
            java.lang.String r7 = "raw_events"
            java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x0d07 }
            r8 = 0
            int r5 = r6.delete(r7, r5, r8)     // Catch:{ all -> 0x0d07 }
            int r6 = r2.size()     // Catch:{ all -> 0x0d07 }
            if (r5 == r6) goto L_0x0cb6
            com.google.android.gms.measurement.internal.zzgi r4 = r4.zzs     // Catch:{ all -> 0x0d07 }
            com.google.android.gms.measurement.internal.zzey r4 = r4.zzaz()     // Catch:{ all -> 0x0d07 }
            com.google.android.gms.measurement.internal.zzew r4 = r4.zzd()     // Catch:{ all -> 0x0d07 }
            java.lang.String r6 = "Deleted fewer rows from raw events table than expected"
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ all -> 0x0d07 }
            int r2 = r2.size()     // Catch:{ all -> 0x0d07 }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ all -> 0x0d07 }
            r4.zzc(r6, r5, r2)     // Catch:{ all -> 0x0d07 }
        L_0x0cb6:
            com.google.android.gms.measurement.internal.zzal r2 = r1.zze     // Catch:{ all -> 0x0d07 }
            zzak(r2)     // Catch:{ all -> 0x0d07 }
            android.database.sqlite.SQLiteDatabase r4 = r2.zzh()     // Catch:{ all -> 0x0d07 }
            r5 = 2
            java.lang.String[] r5 = new java.lang.String[r5]     // Catch:{ SQLiteException -> 0x0cce }
            r6 = 0
            r5[r6] = r3     // Catch:{ SQLiteException -> 0x0cce }
            r6 = 1
            r5[r6] = r3     // Catch:{ SQLiteException -> 0x0cce }
            java.lang.String r6 = "delete from raw_events_metadata where app_id=? and metadata_fingerprint not in (select distinct metadata_fingerprint from raw_events where app_id=?)"
            r4.execSQL(r6, r5)     // Catch:{ SQLiteException -> 0x0cce }
            goto L_0x0ce3
        L_0x0cce:
            r0 = move-exception
            r4 = r0
            com.google.android.gms.measurement.internal.zzgi r2 = r2.zzs     // Catch:{ all -> 0x0d07 }
            com.google.android.gms.measurement.internal.zzey r2 = r2.zzaz()     // Catch:{ all -> 0x0d07 }
            com.google.android.gms.measurement.internal.zzew r2 = r2.zzd()     // Catch:{ all -> 0x0d07 }
            java.lang.String r5 = "Failed to remove unused event metadata. appId"
            java.lang.Object r3 = com.google.android.gms.measurement.internal.zzey.zzn(r3)     // Catch:{ all -> 0x0d07 }
            r2.zzc(r5, r3, r4)     // Catch:{ all -> 0x0d07 }
        L_0x0ce3:
            com.google.android.gms.measurement.internal.zzal r2 = r1.zze     // Catch:{ all -> 0x0d07 }
            zzak(r2)     // Catch:{ all -> 0x0d07 }
            r2.zzC()     // Catch:{ all -> 0x0d07 }
            com.google.android.gms.measurement.internal.zzal r2 = r1.zze
            zzak(r2)
            r2.zzx()
            r2 = 1
            return r2
        L_0x0cf5:
            com.google.android.gms.measurement.internal.zzal r2 = r1.zze     // Catch:{ all -> 0x0d07 }
            zzak(r2)     // Catch:{ all -> 0x0d07 }
            r2.zzC()     // Catch:{ all -> 0x0d07 }
            com.google.android.gms.measurement.internal.zzal r2 = r1.zze
            zzak(r2)
            r2.zzx()
            r2 = 0
            return r2
        L_0x0d07:
            r0 = move-exception
            r2 = r0
            com.google.android.gms.measurement.internal.zzal r3 = r1.zze
            zzak(r3)
            r3.zzx()
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzli.zzag(java.lang.String, long):boolean");
    }

    public final boolean zzah() {
        zzaA().zzg();
        zzB();
        zzal zzal = this.zze;
        zzak(zzal);
        if (!(zzal.zzZ("select count(1) > 0 from raw_events", null) != 0)) {
            zzal zzal2 = this.zze;
            zzak(zzal2);
            return !TextUtils.isEmpty(zzal2.zzr());
        }
    }

    public final boolean zzai(zzfr zzfr, zzfr zzfr2) {
        Object obj;
        Preconditions.checkArgument("_e".equals(zzfr.zzo()));
        zzak(this.zzi);
        zzfw zzB2 = zzlk.zzB((zzfs) zzfr.zzaE(), "_sc");
        String str = null;
        if (zzB2 == null) {
            obj = null;
        } else {
            obj = zzB2.zzh();
        }
        zzak(this.zzi);
        zzfw zzB3 = zzlk.zzB((zzfs) zzfr2.zzaE(), "_pc");
        if (zzB3 != null) {
            str = zzB3.zzh();
        }
        if (str == null || !str.equals(obj)) {
            return false;
        }
        Preconditions.checkArgument("_e".equals(zzfr.zzo()));
        zzak(this.zzi);
        zzfw zzB4 = zzlk.zzB((zzfs) zzfr.zzaE(), "_et");
        if (zzB4 != null && zzB4.zzw() && zzB4.zzd() > 0) {
            long zzd2 = zzB4.zzd();
            zzak(this.zzi);
            zzfw zzB5 = zzlk.zzB((zzfs) zzfr2.zzaE(), "_et");
            if (zzB5 != null && zzB5.zzd() > 0) {
                zzd2 += zzB5.zzd();
            }
            zzak(this.zzi);
            zzlk.zzz(zzfr2, "_et", Long.valueOf(zzd2));
            zzak(this.zzi);
            zzlk.zzz(zzfr, "_fr", Long.valueOf(1));
        }
        return true;
    }

    public final Context zzav() {
        return this.zzn.zze;
    }

    public final Clock zzaw() {
        zzgi zzgi = this.zzn;
        Preconditions.checkNotNull(zzgi);
        return zzgi.zzr;
    }

    public final zzaa zzax() {
        throw null;
    }

    public final zzey zzaz() {
        zzgi zzgi = this.zzn;
        Preconditions.checkNotNull(zzgi);
        return zzgi.zzaz();
    }

    public final zzg zzd(zzp zzp2) {
        zzaA().zzg();
        zzB();
        Preconditions.checkNotNull(zzp2);
        Preconditions.checkNotEmpty(zzp2.zza);
        zzpg.zzc();
        if (zzg().zzs(zzp2.zza, zzel.zzaJ) && !zzp2.zzw.isEmpty()) {
            this.zzC.put(zzp2.zza, new zzlh(this, zzp2.zzw, null));
        }
        zzal zzal = this.zze;
        zzak(zzal);
        zzg zzj2 = zzal.zzj(zzp2.zza);
        zzah zzc2 = zzh(zzp2.zza).zzc(zzah.zzb(zzp2.zzv));
        String zzf2 = zzc2.zzi(zzag.AD_STORAGE) ? this.zzk.zzf(zzp2.zza) : "";
        if (zzj2 == null) {
            zzj2 = new zzg(this.zzn, zzp2.zza);
            if (zzc2.zzi(zzag.ANALYTICS_STORAGE)) {
                zzj2.zzI(zzw(zzc2));
            }
            if (zzc2.zzi(zzag.AD_STORAGE)) {
                zzj2.zzaf(zzf2);
            }
        } else {
            if (zzc2.zzi(zzag.AD_STORAGE) && zzf2 != null) {
                zzj2.zza.zzaA().zzg();
                if (!zzf2.equals(zzj2.zze)) {
                    zzj2.zzaf(zzf2);
                    zzne.zzc();
                    if (!zzg().zzs(null, zzel.zzan) || !zzg().zzs(null, zzel.zzas)) {
                        zzj2.zzI(zzw(zzc2));
                    } else if (!"00000000-0000-0000-0000-000000000000".equals(this.zzk.zzd(zzp2.zza, zzc2).first)) {
                        zzj2.zzI(zzw(zzc2));
                    }
                    zzne.zzc();
                    if (zzg().zzs(null, zzel.zzan) && !"00000000-0000-0000-0000-000000000000".equals(this.zzk.zzd(zzp2.zza, zzc2).first)) {
                        zzal zzal2 = this.zze;
                        zzak(zzal2);
                        if (zzal2.zzp(zzp2.zza, "_id") != null) {
                            zzal zzal3 = this.zze;
                            zzak(zzal3);
                            if (zzal3.zzp(zzp2.zza, "_lair") == null) {
                                zzln zzln = new zzln(zzp2.zza, "auto", "_lair", zzaw().currentTimeMillis(), Long.valueOf(1));
                                zzal zzal4 = this.zze;
                                zzak(zzal4);
                                zzal4.zzL(zzln);
                            }
                        }
                    }
                }
            }
            if (TextUtils.isEmpty(zzj2.zzu()) && zzc2.zzi(zzag.ANALYTICS_STORAGE)) {
                zzj2.zzI(zzw(zzc2));
            }
        }
        zzj2.zzX(zzp2.zzb);
        zzj2.zzF(zzp2.zzq);
        if (!TextUtils.isEmpty(zzp2.zzk)) {
            zzj2.zzW(zzp2.zzk);
        }
        long j = zzp2.zze;
        if (j != 0) {
            zzj2.zzY(j);
        }
        if (!TextUtils.isEmpty(zzp2.zzc)) {
            zzj2.zzK(zzp2.zzc);
        }
        zzj2.zzL(zzp2.zzj);
        String str = zzp2.zzd;
        if (str != null) {
            zzj2.zzJ(str);
        }
        zzj2.zzT(zzp2.zzf);
        zzj2.zzad(zzp2.zzh);
        if (!TextUtils.isEmpty(zzp2.zzg)) {
            zzj2.zzZ(zzp2.zzg);
        }
        if (!zzg().zzs(null, zzel.zzah)) {
            zzj2.zzH(zzp2.zzl);
        }
        zzj2.zzG(zzp2.zzo);
        Boolean bool = zzp2.zzr;
        zzj2.zza.zzaA().zzg();
        boolean z = zzj2.zzD;
        Boolean bool2 = zzj2.zzs;
        zzj2.zzD = z | (!((bool2 == null && bool == null) ? true : bool2 == null ? false : bool2.equals(bool)));
        zzj2.zzs = bool;
        zzj2.zzU(zzp2.zzs);
        zzpp.zzc();
        if (zzg().zzs(null, zzel.zzaH)) {
            zzj2.zzah(zzp2.zzx);
        }
        zznz.zzc();
        if (zzg().zzs(null, zzel.zzaz)) {
            zzj2.zzag(zzp2.zzt);
        } else {
            zznz.zzc();
            if (zzg().zzs(null, zzel.zzay)) {
                zzj2.zzag(null);
            }
        }
        zzj2.zza.zzaA().zzg();
        if (zzj2.zzD) {
            zzal zzal5 = this.zze;
            zzak(zzal5);
            zzal5.zzD(zzj2);
        }
        return zzj2;
    }

    public final zzaf zzg() {
        zzgi zzgi = this.zzn;
        Preconditions.checkNotNull(zzgi);
        return zzgi.zzk;
    }

    public final zzah zzh(String str) {
        String str2;
        zzah zzah = zzah.zza;
        zzaA().zzg();
        zzB();
        zzah zzah2 = (zzah) this.zzB.get(str);
        if (zzah2 != null) {
            return zzah2;
        }
        zzal zzal = this.zze;
        zzak(zzal);
        Preconditions.checkNotNull(str);
        zzal.zzg();
        zzal.zzW();
        Cursor cursor = null;
        try {
            Cursor rawQuery = zzal.zzh().rawQuery("select consent_state from consent_settings where app_id=? limit 1;", new String[]{str});
            if (rawQuery.moveToFirst()) {
                str2 = rawQuery.getString(0);
                rawQuery.close();
            } else {
                rawQuery.close();
                str2 = "G1";
            }
            zzah zzb2 = zzah.zzb(str2);
            zzU(str, zzb2);
            return zzb2;
        } catch (SQLiteException e2) {
            zzal.zzs.zzaz().zzd.zzc("Database error", "select consent_state from consent_settings where app_id=? limit 1;", e2);
            throw e2;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    public final zzal zzi() {
        zzal zzal = this.zze;
        zzak(zzal);
        return zzal;
    }

    public final zzfg zzm() {
        zzfg zzfg = this.zzf;
        if (zzfg != null) {
            return zzfg;
        }
        throw new IllegalStateException("Network broadcast receiver not created");
    }

    public final zzlk zzu() {
        zzlk zzlk = this.zzi;
        zzak(zzlk);
        return zzlk;
    }

    public final zzlp zzv() {
        zzgi zzgi = this.zzn;
        Preconditions.checkNotNull(zzgi);
        return zzgi.zzv();
    }

    public final String zzw(zzah zzah) {
        if (!zzah.zzi(zzag.ANALYTICS_STORAGE)) {
            return null;
        }
        byte[] bArr = new byte[16];
        zzv().zzG().nextBytes(bArr);
        return String.format(Locale.US, "%032x", new Object[]{new BigInteger(1, bArr)});
    }
}
