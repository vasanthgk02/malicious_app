package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzof;
import java.math.BigInteger;
import java.util.List;
import java.util.Locale;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@20.1.2 */
public final class zzep extends zzf {
    public String zza;
    public String zzb;
    public int zzc;
    public String zzd;
    public long zzf;
    public final long zzg;
    public List zzh;
    public String zzi;
    public int zzj;
    public String zzk;
    public String zzl;
    public String zzm;
    public long zzn = 0;
    public String zzo = null;

    public zzep(zzgi zzgi, long j) {
        super(zzgi);
        this.zzg = j;
    }

    /* JADX WARNING: Removed duplicated region for block: B:102:0x0259  */
    /* JADX WARNING: Removed duplicated region for block: B:104:0x0264  */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x0267  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00bb  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00c3  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00d1  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00df  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00ed  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00fb  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0109  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0117  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0125  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0144  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x015d A[Catch:{ IllegalStateException -> 0x01b2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x0166 A[Catch:{ IllegalStateException -> 0x01b2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x0195 A[Catch:{ IllegalStateException -> 0x01b2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x01ce  */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x01f9 A[SYNTHETIC, Splitter:B:84:0x01f9] */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x0222  */
    @org.checkerframework.checker.nullness.qual.EnsuresNonNull({"appId", "appStore", "appName", "gmpAppId", "gaAppId"})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzd() {
        /*
            r11 = this;
            com.google.android.gms.measurement.internal.zzgi r0 = r11.zzs
            android.content.Context r0 = r0.zze
            java.lang.String r0 = r0.getPackageName()
            com.google.android.gms.measurement.internal.zzgi r1 = r11.zzs
            android.content.Context r1 = r1.zze
            android.content.pm.PackageManager r1 = r1.getPackageManager()
            r2 = 0
            java.lang.String r3 = "unknown"
            java.lang.String r4 = "Unknown"
            r5 = -2147483648(0xffffffff80000000, float:-0.0)
            java.lang.String r6 = ""
            if (r1 != 0) goto L_0x002d
            com.google.android.gms.measurement.internal.zzgi r7 = r11.zzs
            com.google.android.gms.measurement.internal.zzey r7 = r7.zzaz()
            com.google.android.gms.measurement.internal.zzew r7 = r7.zzd
            java.lang.Object r8 = com.google.android.gms.measurement.internal.zzey.zzn(r0)
            java.lang.String r9 = "PackageManager is null, app identity information might be inaccurate. appId"
            r7.zzb(r9, r8)
            goto L_0x008c
        L_0x002d:
            java.lang.String r3 = r1.getInstallerPackageName(r0)     // Catch:{ IllegalArgumentException -> 0x0032 }
            goto L_0x0043
        L_0x0032:
            com.google.android.gms.measurement.internal.zzgi r7 = r11.zzs
            com.google.android.gms.measurement.internal.zzey r7 = r7.zzaz()
            com.google.android.gms.measurement.internal.zzew r7 = r7.zzd
            java.lang.Object r8 = com.google.android.gms.measurement.internal.zzey.zzn(r0)
            java.lang.String r9 = "Error retrieving app installer package name. appId"
            r7.zzb(r9, r8)
        L_0x0043:
            if (r3 != 0) goto L_0x0048
            java.lang.String r3 = "manual_install"
            goto L_0x0051
        L_0x0048:
            java.lang.String r7 = "com.android.vending"
            boolean r7 = r7.equals(r3)
            if (r7 == 0) goto L_0x0051
            r3 = r6
        L_0x0051:
            com.google.android.gms.measurement.internal.zzgi r7 = r11.zzs     // Catch:{ NameNotFoundException -> 0x0079 }
            android.content.Context r7 = r7.zze     // Catch:{ NameNotFoundException -> 0x0079 }
            java.lang.String r7 = r7.getPackageName()     // Catch:{ NameNotFoundException -> 0x0079 }
            android.content.pm.PackageInfo r7 = r1.getPackageInfo(r7, r2)     // Catch:{ NameNotFoundException -> 0x0079 }
            if (r7 == 0) goto L_0x008c
            android.content.pm.ApplicationInfo r8 = r7.applicationInfo     // Catch:{ NameNotFoundException -> 0x0079 }
            java.lang.CharSequence r8 = r1.getApplicationLabel(r8)     // Catch:{ NameNotFoundException -> 0x0079 }
            boolean r9 = android.text.TextUtils.isEmpty(r8)     // Catch:{ NameNotFoundException -> 0x0079 }
            if (r9 != 0) goto L_0x0070
            java.lang.String r8 = r8.toString()     // Catch:{ NameNotFoundException -> 0x0079 }
            goto L_0x0071
        L_0x0070:
            r8 = r4
        L_0x0071:
            java.lang.String r4 = r7.versionName     // Catch:{ NameNotFoundException -> 0x0076 }
            int r5 = r7.versionCode     // Catch:{ NameNotFoundException -> 0x0076 }
            goto L_0x008c
        L_0x0076:
            r7 = r4
            r4 = r8
            goto L_0x007a
        L_0x0079:
            r7 = r4
        L_0x007a:
            com.google.android.gms.measurement.internal.zzgi r8 = r11.zzs
            com.google.android.gms.measurement.internal.zzey r8 = r8.zzaz()
            com.google.android.gms.measurement.internal.zzew r8 = r8.zzd
            java.lang.Object r9 = com.google.android.gms.measurement.internal.zzey.zzn(r0)
            java.lang.String r10 = "Error retrieving package info. appId, appName"
            r8.zzc(r10, r9, r4)
            r4 = r7
        L_0x008c:
            r11.zza = r0
            r11.zzd = r3
            r11.zzb = r4
            r11.zzc = r5
            r3 = 0
            r11.zzf = r3
            com.google.android.gms.measurement.internal.zzgi r3 = r11.zzs
            java.lang.String r3 = r3.zzf
            boolean r3 = android.text.TextUtils.isEmpty(r3)
            r4 = 1
            if (r3 != 0) goto L_0x00b1
            com.google.android.gms.measurement.internal.zzgi r3 = r11.zzs
            java.lang.String r3 = r3.zzg
            java.lang.String r5 = "am"
            boolean r3 = r5.equals(r3)
            if (r3 == 0) goto L_0x00b1
            r3 = 1
            goto L_0x00b2
        L_0x00b1:
            r3 = 0
        L_0x00b2:
            com.google.android.gms.measurement.internal.zzgi r5 = r11.zzs
            int r5 = r5.zza()
            switch(r5) {
                case 0: goto L_0x0125;
                case 1: goto L_0x0117;
                case 2: goto L_0x0109;
                case 3: goto L_0x00fb;
                case 4: goto L_0x00ed;
                case 5: goto L_0x00df;
                case 6: goto L_0x00d1;
                case 7: goto L_0x00c3;
                default: goto L_0x00bb;
            }
        L_0x00bb:
            com.google.android.gms.measurement.internal.zzgi r7 = r11.zzs
            com.google.android.gms.measurement.internal.zzey r7 = r7.zzaz()
            goto L_0x0133
        L_0x00c3:
            com.google.android.gms.measurement.internal.zzgi r7 = r11.zzs
            com.google.android.gms.measurement.internal.zzey r7 = r7.zzaz()
            com.google.android.gms.measurement.internal.zzew r7 = r7.zzj
            java.lang.String r8 = "App measurement disabled via the global data collection setting"
            r7.zza(r8)
            goto L_0x013a
        L_0x00d1:
            com.google.android.gms.measurement.internal.zzgi r7 = r11.zzs
            com.google.android.gms.measurement.internal.zzey r7 = r7.zzaz()
            com.google.android.gms.measurement.internal.zzew r7 = r7.zzi
            java.lang.String r8 = "App measurement deactivated via resources. This method is being deprecated. Please refer to https://firebase.google.com/support/guides/disable-analytics"
            r7.zza(r8)
            goto L_0x013a
        L_0x00df:
            com.google.android.gms.measurement.internal.zzgi r7 = r11.zzs
            com.google.android.gms.measurement.internal.zzey r7 = r7.zzaz()
            com.google.android.gms.measurement.internal.zzew r7 = r7.zzl
            java.lang.String r8 = "App measurement disabled via the init parameters"
            r7.zza(r8)
            goto L_0x013a
        L_0x00ed:
            com.google.android.gms.measurement.internal.zzgi r7 = r11.zzs
            com.google.android.gms.measurement.internal.zzey r7 = r7.zzaz()
            com.google.android.gms.measurement.internal.zzew r7 = r7.zzj
            java.lang.String r8 = "App measurement disabled via the manifest"
            r7.zza(r8)
            goto L_0x013a
        L_0x00fb:
            com.google.android.gms.measurement.internal.zzgi r7 = r11.zzs
            com.google.android.gms.measurement.internal.zzey r7 = r7.zzaz()
            com.google.android.gms.measurement.internal.zzew r7 = r7.zzj
            java.lang.String r8 = "App measurement disabled by setAnalyticsCollectionEnabled(false)"
            r7.zza(r8)
            goto L_0x013a
        L_0x0109:
            com.google.android.gms.measurement.internal.zzgi r7 = r11.zzs
            com.google.android.gms.measurement.internal.zzey r7 = r7.zzaz()
            com.google.android.gms.measurement.internal.zzew r7 = r7.zzl
            java.lang.String r8 = "App measurement deactivated via the init parameters"
            r7.zza(r8)
            goto L_0x013a
        L_0x0117:
            com.google.android.gms.measurement.internal.zzgi r7 = r11.zzs
            com.google.android.gms.measurement.internal.zzey r7 = r7.zzaz()
            com.google.android.gms.measurement.internal.zzew r7 = r7.zzj
            java.lang.String r8 = "App measurement deactivated via the manifest"
            r7.zza(r8)
            goto L_0x013a
        L_0x0125:
            com.google.android.gms.measurement.internal.zzgi r7 = r11.zzs
            com.google.android.gms.measurement.internal.zzey r7 = r7.zzaz()
            com.google.android.gms.measurement.internal.zzew r7 = r7.zzl
            java.lang.String r8 = "App measurement collection enabled"
            r7.zza(r8)
            goto L_0x013a
        L_0x0133:
            com.google.android.gms.measurement.internal.zzew r7 = r7.zzj
            java.lang.String r8 = "App measurement disabled due to denied storage consent"
            r7.zza(r8)
        L_0x013a:
            r11.zzk = r6
            r11.zzl = r6
            com.google.android.gms.measurement.internal.zzgi r7 = r11.zzs
            com.google.android.gms.measurement.internal.zzaa r8 = r7.zzj
            if (r3 == 0) goto L_0x0148
            java.lang.String r3 = r7.zzf
            r11.zzl = r3
        L_0x0148:
            r3 = 0
            com.google.android.gms.measurement.internal.zzgi r7 = r11.zzs     // Catch:{ IllegalStateException -> 0x01b2 }
            android.content.Context r7 = r7.zze     // Catch:{ IllegalStateException -> 0x01b2 }
            com.google.android.gms.measurement.internal.zzgi r8 = r11.zzs     // Catch:{ IllegalStateException -> 0x01b2 }
            java.lang.String r8 = r8.zzw     // Catch:{ IllegalStateException -> 0x01b2 }
            java.lang.String r9 = "google_app_id"
            java.lang.String r7 = com.google.android.gms.measurement.internal.zzit.zzc(r7, r9, r8)     // Catch:{ IllegalStateException -> 0x01b2 }
            boolean r8 = android.text.TextUtils.isEmpty(r7)     // Catch:{ IllegalStateException -> 0x01b2 }
            if (r4 == r8) goto L_0x015e
            r6 = r7
        L_0x015e:
            r11.zzk = r6     // Catch:{ IllegalStateException -> 0x01b2 }
            boolean r4 = android.text.TextUtils.isEmpty(r7)     // Catch:{ IllegalStateException -> 0x01b2 }
            if (r4 != 0) goto L_0x0193
            com.google.android.gms.measurement.internal.zzgi r4 = r11.zzs     // Catch:{ IllegalStateException -> 0x01b2 }
            android.content.Context r4 = r4.zze     // Catch:{ IllegalStateException -> 0x01b2 }
            com.google.android.gms.measurement.internal.zzgi r6 = r11.zzs     // Catch:{ IllegalStateException -> 0x01b2 }
            java.lang.String r6 = r6.zzw     // Catch:{ IllegalStateException -> 0x01b2 }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r4)     // Catch:{ IllegalStateException -> 0x01b2 }
            android.content.res.Resources r7 = r4.getResources()     // Catch:{ IllegalStateException -> 0x01b2 }
            boolean r8 = android.text.TextUtils.isEmpty(r6)     // Catch:{ IllegalStateException -> 0x01b2 }
            if (r8 != 0) goto L_0x017c
            goto L_0x0180
        L_0x017c:
            java.lang.String r6 = com.facebook.drawee.backends.pipeline.info.ImageOriginUtils.zza(r4)     // Catch:{ IllegalStateException -> 0x01b2 }
        L_0x0180:
            java.lang.String r4 = "admob_app_id"
            java.lang.String r8 = "string"
            int r4 = r7.getIdentifier(r4, r8, r6)     // Catch:{ IllegalStateException -> 0x01b2 }
            if (r4 != 0) goto L_0x018b
            goto L_0x0190
        L_0x018b:
            java.lang.String r4 = r7.getString(r4)     // Catch:{ NotFoundException -> 0x0190 }
            goto L_0x0191
        L_0x0190:
            r4 = r3
        L_0x0191:
            r11.zzl = r4     // Catch:{ IllegalStateException -> 0x01b2 }
        L_0x0193:
            if (r5 != 0) goto L_0x01c4
            com.google.android.gms.measurement.internal.zzgi r4 = r11.zzs     // Catch:{ IllegalStateException -> 0x01b2 }
            com.google.android.gms.measurement.internal.zzey r4 = r4.zzaz()     // Catch:{ IllegalStateException -> 0x01b2 }
            com.google.android.gms.measurement.internal.zzew r4 = r4.zzl     // Catch:{ IllegalStateException -> 0x01b2 }
            java.lang.String r5 = "App measurement enabled for app package, google app id"
            java.lang.String r6 = r11.zza     // Catch:{ IllegalStateException -> 0x01b2 }
            java.lang.String r7 = r11.zzk     // Catch:{ IllegalStateException -> 0x01b2 }
            boolean r7 = android.text.TextUtils.isEmpty(r7)     // Catch:{ IllegalStateException -> 0x01b2 }
            if (r7 == 0) goto L_0x01ac
            java.lang.String r7 = r11.zzl     // Catch:{ IllegalStateException -> 0x01b2 }
            goto L_0x01ae
        L_0x01ac:
            java.lang.String r7 = r11.zzk     // Catch:{ IllegalStateException -> 0x01b2 }
        L_0x01ae:
            r4.zzc(r5, r6, r7)     // Catch:{ IllegalStateException -> 0x01b2 }
            goto L_0x01c4
        L_0x01b2:
            r4 = move-exception
            com.google.android.gms.measurement.internal.zzgi r5 = r11.zzs
            com.google.android.gms.measurement.internal.zzey r5 = r5.zzaz()
            com.google.android.gms.measurement.internal.zzew r5 = r5.zzd
            java.lang.Object r0 = com.google.android.gms.measurement.internal.zzey.zzn(r0)
            java.lang.String r6 = "Fetching Google App Id failed with exception. appId"
            r5.zzc(r6, r0, r4)
        L_0x01c4:
            r11.zzh = r3
            com.google.android.gms.measurement.internal.zzgi r0 = r11.zzs
            com.google.android.gms.measurement.internal.zzaa r4 = r0.zzj
            com.google.android.gms.measurement.internal.zzaf r0 = r0.zzk
            if (r0 == 0) goto L_0x0267
            java.lang.String r4 = "analytics.safelisted_events"
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r4)
            android.os.Bundle r5 = r0.zzj()
            if (r5 != 0) goto L_0x01e7
            com.google.android.gms.measurement.internal.zzgi r4 = r0.zzs
            com.google.android.gms.measurement.internal.zzey r4 = r4.zzaz()
            com.google.android.gms.measurement.internal.zzew r4 = r4.zzd
            java.lang.String r5 = "Failed to load metadata: Metadata bundle is null"
            r4.zza(r5)
            goto L_0x01ed
        L_0x01e7:
            boolean r6 = r5.containsKey(r4)
            if (r6 != 0) goto L_0x01ef
        L_0x01ed:
            r4 = r3
            goto L_0x01f7
        L_0x01ef:
            int r4 = r5.getInt(r4)
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
        L_0x01f7:
            if (r4 == 0) goto L_0x021f
            com.google.android.gms.measurement.internal.zzgi r5 = r0.zzs     // Catch:{ NotFoundException -> 0x0211 }
            android.content.Context r5 = r5.zze     // Catch:{ NotFoundException -> 0x0211 }
            android.content.res.Resources r5 = r5.getResources()     // Catch:{ NotFoundException -> 0x0211 }
            int r4 = r4.intValue()     // Catch:{ NotFoundException -> 0x0211 }
            java.lang.String[] r4 = r5.getStringArray(r4)     // Catch:{ NotFoundException -> 0x0211 }
            if (r4 != 0) goto L_0x020c
            goto L_0x021f
        L_0x020c:
            java.util.List r3 = java.util.Arrays.asList(r4)     // Catch:{ NotFoundException -> 0x0211 }
            goto L_0x021f
        L_0x0211:
            r4 = move-exception
            com.google.android.gms.measurement.internal.zzgi r0 = r0.zzs
            com.google.android.gms.measurement.internal.zzey r0 = r0.zzaz()
            com.google.android.gms.measurement.internal.zzew r0 = r0.zzd
            java.lang.String r5 = "Failed to load string array from metadata: resource not found"
            r0.zzb(r5, r4)
        L_0x021f:
            if (r3 != 0) goto L_0x0222
            goto L_0x0255
        L_0x0222:
            boolean r0 = r3.isEmpty()
            if (r0 == 0) goto L_0x0236
            com.google.android.gms.measurement.internal.zzgi r0 = r11.zzs
            com.google.android.gms.measurement.internal.zzey r0 = r0.zzaz()
            com.google.android.gms.measurement.internal.zzew r0 = r0.zzi
            java.lang.String r3 = "Safelisted event list is empty. Ignoring"
            r0.zza(r3)
            goto L_0x0257
        L_0x0236:
            java.util.Iterator r0 = r3.iterator()
        L_0x023a:
            boolean r4 = r0.hasNext()
            if (r4 == 0) goto L_0x0255
            java.lang.Object r4 = r0.next()
            java.lang.String r4 = (java.lang.String) r4
            com.google.android.gms.measurement.internal.zzgi r5 = r11.zzs
            com.google.android.gms.measurement.internal.zzlp r5 = r5.zzv()
            java.lang.String r6 = "safelisted event"
            boolean r4 = r5.zzab(r6, r4)
            if (r4 != 0) goto L_0x023a
            goto L_0x0257
        L_0x0255:
            r11.zzh = r3
        L_0x0257:
            if (r1 == 0) goto L_0x0264
            com.google.android.gms.measurement.internal.zzgi r0 = r11.zzs
            android.content.Context r0 = r0.zze
            boolean r0 = com.google.android.gms.common.wrappers.InstantApps.isInstantApp(r0)
            r11.zzj = r0
            return
        L_0x0264:
            r11.zzj = r2
            return
        L_0x0267:
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzep.zzd():void");
    }

    public final boolean zzf() {
        return true;
    }

    public final String zzl() {
        zza();
        Preconditions.checkNotNull(this.zza);
        return this.zza;
    }

    public final String zzm() {
        zzof.zzc();
        if (this.zzs.zzk.zzs(null, zzel.zzal)) {
            zzg();
        }
        zza();
        Preconditions.checkNotNull(this.zzk);
        return this.zzk;
    }

    public final void zzo() {
        String str;
        zzg();
        if (!this.zzs.zzm().zzc().zzi(zzag.ANALYTICS_STORAGE)) {
            this.zzs.zzaz().zzk.zza("Analytics Storage consent is not granted");
            str = null;
        } else {
            byte[] bArr = new byte[16];
            this.zzs.zzv().zzG().nextBytes(bArr);
            str = String.format(Locale.US, "%032x", new Object[]{new BigInteger(1, bArr)});
        }
        zzew zzew = this.zzs.zzaz().zzk;
        Object[] objArr = new Object[1];
        objArr[0] = str == null ? "null" : "not null";
        zzew.zza(String.format("Resetting session stitching token to %s", objArr));
        this.zzm = str;
        this.zzn = this.zzs.zzr.currentTimeMillis();
    }
}
