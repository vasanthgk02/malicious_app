package com.google.android.gms.measurement.internal;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.facebook.drawee.backends.pipeline.info.ImageOriginUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Strings;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.measurement.zzoc;
import com.google.android.gms.internal.measurement.zzol;
import com.google.android.gms.internal.measurement.zzpm;
import com.google.firebase.crashlytics.CrashlyticsAnalyticsListener;
import io.hansel.core.criteria.HSLCriteriaBuilder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.apache.pdfbox.pdfparser.BaseParser;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@20.1.2 */
public final class zzin extends zzf {
    @VisibleForTesting
    public zzim zza;
    public final zzr zzb;
    @VisibleForTesting
    public boolean zzc = true;
    public zzhi zzd;
    public final Set zze = new CopyOnWriteArraySet();
    public boolean zzf;
    public final AtomicReference zzg = new AtomicReference();
    public final Object zzh = new Object();
    public zzah zzi = new zzah(null, null);
    public int zzj = 100;
    public final AtomicLong zzk = new AtomicLong(0);
    public long zzl = -1;
    public int zzm = 100;
    public final zzlo zzn = new zzib(this);

    public zzin(zzgi zzgi) {
        super(zzgi);
        this.zzb = new zzr(zzgi);
    }

    public static /* bridge */ /* synthetic */ void zzv(zzin zzin, zzah zzah, zzah zzah2) {
        boolean z;
        zzag[] zzagArr = {zzag.ANALYTICS_STORAGE, zzag.AD_STORAGE};
        int i = 0;
        while (true) {
            if (i >= 2) {
                z = false;
                break;
            }
            zzag zzag = zzagArr[i];
            if (!zzah2.zzi(zzag) && zzah.zzi(zzag)) {
                z = true;
                break;
            }
            i++;
        }
        boolean zzl2 = zzah.zzl(zzah2, zzag.ANALYTICS_STORAGE, zzag.AD_STORAGE);
        if (z || zzl2) {
            zzin.zzs.zzh().zzo();
        }
    }

    public static void zzw(zzin zzin, zzah zzah, int i, long j, boolean z, boolean z2) {
        zzin.zzg();
        zzin.zza();
        if (j > zzin.zzl || !zzah.zzj(zzin.zzm, i)) {
            zzfn zzm2 = zzin.zzs.zzm();
            zzgi zzgi = zzm2.zzs;
            zzm2.zzg();
            if (zzm2.zzl(i)) {
                Editor edit = zzm2.zza().edit();
                edit.putString("consent_settings", zzah.zzh());
                edit.putInt("consent_source", i);
                edit.apply();
                zzin.zzl = j;
                zzin.zzm = i;
                zzkb zzt = zzin.zzs.zzt();
                zzt.zzg();
                zzt.zza();
                if (z) {
                    zzt.zzS();
                    zzt.zzs.zzi().zzj();
                }
                if (zzt.zzM()) {
                    zzt.zzR(new zzjp(zzt, zzt.zzO(false)));
                }
                if (z2) {
                    zzin.zzs.zzt().zzu(new AtomicReference());
                }
                return;
            }
            zzin.zzs.zzaz().zzj.zzb("Lower precedence consent source ignored, proposed source", Integer.valueOf(i));
            return;
        }
        zzin.zzs.zzaz().zzj.zzb("Dropped out-of-date consent setting, proposed settings", zzah);
    }

    public final void zzA(String str, String str2, Bundle bundle) {
        long currentTimeMillis = this.zzs.zzr.currentTimeMillis();
        Preconditions.checkNotEmpty(str);
        Bundle bundle2 = new Bundle();
        bundle2.putString("name", str);
        bundle2.putLong("creation_timestamp", currentTimeMillis);
        if (str2 != null) {
            bundle2.putString("expired_event_name", str2);
            bundle2.putBundle("expired_event_params", bundle);
        }
        this.zzs.zzaA().zzp(new zzhx(this, bundle2));
    }

    public final void zzB() {
        if ((this.zzs.zze.getApplicationContext() instanceof Application) && this.zza != null) {
            ((Application) this.zzs.zze.getApplicationContext()).unregisterActivityLifecycleCallbacks(this.zza);
        }
    }

    public final void zzE(String str, String str2, Bundle bundle) {
        zzF(str, str2, bundle, true, true, this.zzs.zzr.currentTimeMillis());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0054, code lost:
        if (r3 > 100) goto L_0x0056;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0084, code lost:
        if (r6 > 100) goto L_0x0086;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzF(java.lang.String r21, java.lang.String r22, android.os.Bundle r23, boolean r24, boolean r25, long r26) {
        /*
            r20 = this;
            r11 = r20
            if (r21 != 0) goto L_0x0008
            java.lang.String r0 = "app"
            r2 = r0
            goto L_0x000a
        L_0x0008:
            r2 = r21
        L_0x000a:
            if (r23 != 0) goto L_0x0012
            android.os.Bundle r0 = new android.os.Bundle
            r0.<init>()
            goto L_0x0014
        L_0x0012:
            r0 = r23
        L_0x0014:
            java.lang.String r1 = "screen_view"
            r3 = r22
            boolean r1 = com.google.android.gms.measurement.internal.zzlp.zzal(r3, r1)
            r4 = 0
            if (r1 == 0) goto L_0x0140
            com.google.android.gms.measurement.internal.zzgi r1 = r11.zzs
            com.google.android.gms.measurement.internal.zzjb r1 = r1.zzs()
            java.lang.Object r5 = r1.zzj
            monitor-enter(r5)
            boolean r2 = r1.zzi     // Catch:{ all -> 0x013d }
            if (r2 != 0) goto L_0x003c
            com.google.android.gms.measurement.internal.zzgi r0 = r1.zzs     // Catch:{ all -> 0x013d }
            com.google.android.gms.measurement.internal.zzey r0 = r0.zzaz()     // Catch:{ all -> 0x013d }
            com.google.android.gms.measurement.internal.zzew r0 = r0.zzi     // Catch:{ all -> 0x013d }
            java.lang.String r1 = "Cannot log screen view event when the app is in the background."
            r0.zza(r1)     // Catch:{ all -> 0x013d }
            monitor-exit(r5)     // Catch:{ all -> 0x013d }
            goto L_0x013c
        L_0x003c:
            java.lang.String r2 = "screen_name"
            java.lang.String r13 = r0.getString(r2)     // Catch:{ all -> 0x013d }
            r2 = 100
            if (r13 == 0) goto L_0x006e
            int r3 = r13.length()     // Catch:{ all -> 0x013d }
            if (r3 <= 0) goto L_0x0056
            int r3 = r13.length()     // Catch:{ all -> 0x013d }
            com.google.android.gms.measurement.internal.zzgi r6 = r1.zzs     // Catch:{ all -> 0x013d }
            com.google.android.gms.measurement.internal.zzaf r6 = r6.zzk     // Catch:{ all -> 0x013d }
            if (r3 <= r2) goto L_0x006e
        L_0x0056:
            com.google.android.gms.measurement.internal.zzgi r0 = r1.zzs     // Catch:{ all -> 0x013d }
            com.google.android.gms.measurement.internal.zzey r0 = r0.zzaz()     // Catch:{ all -> 0x013d }
            com.google.android.gms.measurement.internal.zzew r0 = r0.zzi     // Catch:{ all -> 0x013d }
            java.lang.String r1 = "Invalid screen name length for screen view. Length"
            int r2 = r13.length()     // Catch:{ all -> 0x013d }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ all -> 0x013d }
            r0.zzb(r1, r2)     // Catch:{ all -> 0x013d }
            monitor-exit(r5)     // Catch:{ all -> 0x013d }
            goto L_0x013c
        L_0x006e:
            java.lang.String r3 = "screen_class"
            java.lang.String r3 = r0.getString(r3)     // Catch:{ all -> 0x013d }
            if (r3 == 0) goto L_0x009e
            int r6 = r3.length()     // Catch:{ all -> 0x013d }
            if (r6 <= 0) goto L_0x0086
            int r6 = r3.length()     // Catch:{ all -> 0x013d }
            com.google.android.gms.measurement.internal.zzgi r7 = r1.zzs     // Catch:{ all -> 0x013d }
            com.google.android.gms.measurement.internal.zzaf r7 = r7.zzk     // Catch:{ all -> 0x013d }
            if (r6 <= r2) goto L_0x009e
        L_0x0086:
            com.google.android.gms.measurement.internal.zzgi r0 = r1.zzs     // Catch:{ all -> 0x013d }
            com.google.android.gms.measurement.internal.zzey r0 = r0.zzaz()     // Catch:{ all -> 0x013d }
            com.google.android.gms.measurement.internal.zzew r0 = r0.zzi     // Catch:{ all -> 0x013d }
            java.lang.String r1 = "Invalid screen class length for screen view. Length"
            int r2 = r3.length()     // Catch:{ all -> 0x013d }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ all -> 0x013d }
            r0.zzb(r1, r2)     // Catch:{ all -> 0x013d }
            monitor-exit(r5)     // Catch:{ all -> 0x013d }
            goto L_0x013c
        L_0x009e:
            if (r3 != 0) goto L_0x00b3
            android.app.Activity r2 = r1.zze     // Catch:{ all -> 0x013d }
            if (r2 == 0) goto L_0x00af
            java.lang.Class r2 = r2.getClass()     // Catch:{ all -> 0x013d }
            java.lang.String r3 = "Activity"
            java.lang.String r2 = r1.zzl(r2, r3)     // Catch:{ all -> 0x013d }
            goto L_0x00b1
        L_0x00af:
            java.lang.String r2 = "Activity"
        L_0x00b1:
            r14 = r2
            goto L_0x00b4
        L_0x00b3:
            r14 = r3
        L_0x00b4:
            com.google.android.gms.measurement.internal.zziu r2 = r1.zzb     // Catch:{ all -> 0x013d }
            boolean r3 = r1.zzf     // Catch:{ all -> 0x013d }
            if (r3 == 0) goto L_0x00dd
            if (r2 == 0) goto L_0x00dd
            r1.zzf = r4     // Catch:{ all -> 0x013d }
            java.lang.String r3 = r2.zzb     // Catch:{ all -> 0x013d }
            boolean r3 = com.google.android.gms.measurement.internal.zzlp.zzal(r3, r14)     // Catch:{ all -> 0x013d }
            java.lang.String r2 = r2.zza     // Catch:{ all -> 0x013d }
            boolean r2 = com.google.android.gms.measurement.internal.zzlp.zzal(r2, r13)     // Catch:{ all -> 0x013d }
            if (r3 == 0) goto L_0x00dd
            if (r2 == 0) goto L_0x00dd
            com.google.android.gms.measurement.internal.zzgi r0 = r1.zzs     // Catch:{ all -> 0x013d }
            com.google.android.gms.measurement.internal.zzey r0 = r0.zzaz()     // Catch:{ all -> 0x013d }
            com.google.android.gms.measurement.internal.zzew r0 = r0.zzi     // Catch:{ all -> 0x013d }
            java.lang.String r1 = "Ignoring call to log screen view event with duplicate parameters."
            r0.zza(r1)     // Catch:{ all -> 0x013d }
            monitor-exit(r5)     // Catch:{ all -> 0x013d }
            goto L_0x013c
        L_0x00dd:
            monitor-exit(r5)     // Catch:{ all -> 0x013d }
            com.google.android.gms.measurement.internal.zzgi r2 = r1.zzs
            com.google.android.gms.measurement.internal.zzey r2 = r2.zzaz()
            com.google.android.gms.measurement.internal.zzew r2 = r2.zzl
            if (r13 != 0) goto L_0x00eb
            java.lang.String r3 = "null"
            goto L_0x00ec
        L_0x00eb:
            r3 = r13
        L_0x00ec:
            if (r14 != 0) goto L_0x00f1
            java.lang.String r4 = "null"
            goto L_0x00f2
        L_0x00f1:
            r4 = r14
        L_0x00f2:
            java.lang.String r5 = "Logging screen view with name, class"
            r2.zzc(r5, r3, r4)
            com.google.android.gms.measurement.internal.zziu r2 = r1.zzb
            if (r2 != 0) goto L_0x00fe
            com.google.android.gms.measurement.internal.zziu r2 = r1.zzc
            goto L_0x0100
        L_0x00fe:
            com.google.android.gms.measurement.internal.zziu r2 = r1.zzb
        L_0x0100:
            com.google.android.gms.measurement.internal.zziu r3 = new com.google.android.gms.measurement.internal.zziu
            com.google.android.gms.measurement.internal.zzgi r4 = r1.zzs
            com.google.android.gms.measurement.internal.zzlp r4 = r4.zzv()
            long r15 = r4.zzq()
            r17 = 1
            r12 = r3
            r18 = r26
            r12.<init>(r13, r14, r15, r17, r18)
            r1.zzb = r3
            r1.zzc = r2
            r1.zzg = r3
            com.google.android.gms.measurement.internal.zzgi r4 = r1.zzs
            com.google.android.gms.common.util.Clock r4 = r4.zzr
            long r4 = r4.elapsedRealtime()
            com.google.android.gms.measurement.internal.zzgi r6 = r1.zzs
            com.google.android.gms.measurement.internal.zzgf r6 = r6.zzaA()
            com.google.android.gms.measurement.internal.zziv r7 = new com.google.android.gms.measurement.internal.zziv
            r21 = r7
            r22 = r1
            r23 = r0
            r24 = r3
            r25 = r2
            r26 = r4
            r21.<init>(r22, r23, r24, r25, r26)
            r6.zzp(r7)
        L_0x013c:
            return
        L_0x013d:
            r0 = move-exception
            monitor-exit(r5)     // Catch:{ all -> 0x013d }
            throw r0
        L_0x0140:
            r1 = 1
            if (r25 == 0) goto L_0x0150
            com.google.android.gms.measurement.internal.zzhi r5 = r11.zzd
            if (r5 == 0) goto L_0x0150
            boolean r5 = com.google.android.gms.measurement.internal.zzlp.zzah(r22)
            if (r5 == 0) goto L_0x014e
            goto L_0x0150
        L_0x014e:
            r8 = 0
            goto L_0x0151
        L_0x0150:
            r8 = 1
        L_0x0151:
            r10 = 0
            r1 = r20
            r3 = r22
            r4 = r26
            r6 = r0
            r7 = r25
            r9 = r24
            r1.zzN(r2, r3, r4, r6, r7, r8, r9, r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzin.zzF(java.lang.String, java.lang.String, android.os.Bundle, boolean, boolean, long):void");
    }

    public final void zzH(String str, String str2, Bundle bundle) {
        zzg();
        zzI(str, str2, this.zzs.zzr.currentTimeMillis(), bundle);
    }

    public final void zzI(String str, String str2, long j, Bundle bundle) {
        zzg();
        zzJ(str, str2, j, bundle, true, this.zzd == null || zzlp.zzah(str2), true, null);
    }

    public final void zzJ(String str, String str2, long j, Bundle bundle, boolean z, boolean z2, boolean z3, String str3) {
        boolean z4;
        ArrayList arrayList;
        String str4;
        long j2;
        boolean z5;
        boolean z6;
        Bundle[] bundleArr;
        Class<?> cls;
        String str5 = str;
        String str6 = str2;
        long j3 = j;
        Bundle bundle2 = bundle;
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(bundle);
        zzg();
        zza();
        if (this.zzs.zzJ()) {
            List list = this.zzs.zzh().zzh;
            if (list == null || list.contains(str6)) {
                int i = 0;
                if (!this.zzf) {
                    this.zzf = true;
                    try {
                        if (!this.zzs.zzi) {
                            cls = Class.forName("com.google.android.gms.tagmanager.TagManagerService", true, this.zzs.zze.getClassLoader());
                        } else {
                            cls = Class.forName("com.google.android.gms.tagmanager.TagManagerService");
                        }
                        try {
                            cls.getDeclaredMethod("initialize", new Class[]{Context.class}).invoke(null, new Object[]{this.zzs.zze});
                        } catch (Exception e2) {
                            this.zzs.zzaz().zzg.zzb("Failed to invoke Tag Manager's initialize() method", e2);
                        }
                    } catch (ClassNotFoundException unused) {
                        this.zzs.zzaz().zzj.zza("Tag Manager is not found and thus will not be used");
                    }
                }
                if ("_cmp".equals(str6) && bundle2.containsKey("gclid")) {
                    zzaa zzaa = this.zzs.zzj;
                    zzaa("auto", "_lgclid", bundle2.getString("gclid"), this.zzs.zzr.currentTimeMillis());
                }
                zzaa zzaa2 = this.zzs.zzj;
                if (z && (!zzlp.zzc[0].equals(str6))) {
                    this.zzs.zzv().zzL(bundle2, this.zzs.zzm().zzr.zza());
                }
                if (!z3) {
                    zzaa zzaa3 = this.zzs.zzj;
                    if (!"_iap".equals(str6)) {
                        zzlp zzv = this.zzs.zzv();
                        int i2 = 2;
                        if (zzv.zzac("event", str6)) {
                            if (!zzv.zzZ("event", zzhf.zza, zzhf.zzb, str6)) {
                                i2 = 13;
                            } else {
                                zzaf zzaf = zzv.zzs.zzk;
                                if (zzv.zzY("event", 40, str6)) {
                                    i2 = 0;
                                }
                            }
                        }
                        if (i2 != 0) {
                            this.zzs.zzaz().zzf.zzb("Invalid public event name. Event will not be logged (FE)", this.zzs.zzq.zzd(str6));
                            zzlp zzv2 = this.zzs.zzv();
                            zzaf zzaf2 = this.zzs.zzk;
                            String zzD = zzv2.zzD(str6, 40, true);
                            if (str6 != null) {
                                i = str2.length();
                            }
                            this.zzs.zzv().zzN(this.zzn, null, i2, "_ev", zzD, i);
                            return;
                        }
                    }
                }
                zzpm.zzc();
                if (this.zzs.zzk.zzs(null, zzel.zzat)) {
                    zzgi zzgi = this.zzs;
                    zzaa zzaa4 = zzgi.zzj;
                    zziu zzj2 = zzgi.zzs().zzj(false);
                    if (zzj2 != null && !bundle2.containsKey("_sc")) {
                        zzj2.zzd = true;
                    }
                    zzlp.zzK(zzj2, bundle2, z && !z3);
                } else {
                    zzgi zzgi2 = this.zzs;
                    zzaa zzaa5 = zzgi2.zzj;
                    zziu zzj3 = zzgi2.zzs().zzj(false);
                    if (zzj3 != null && !bundle2.containsKey("_sc")) {
                        zzj3.zzd = true;
                    }
                    zzlp.zzK(zzj3, bundle2, z && !z3);
                }
                boolean equals = "am".equals(str5);
                boolean zzah = zzlp.zzah(str2);
                if (!z || this.zzd == null || zzah) {
                    z4 = equals;
                } else if (equals) {
                    z4 = true;
                } else {
                    this.zzs.zzaz().zzk.zzc("Passing event to registered event handler (FE)", this.zzs.zzq.zzd(str6), this.zzs.zzq.zzb(bundle2));
                    Preconditions.checkNotNull(this.zzd);
                    this.zzd.interceptEvent(str, str2, bundle, j);
                    return;
                }
                if (this.zzs.zzM()) {
                    int zzh2 = this.zzs.zzv().zzh(str6);
                    if (zzh2 != 0) {
                        this.zzs.zzaz().zzf.zzb("Invalid event name. Event will not be logged (FE)", this.zzs.zzq.zzd(str6));
                        zzlp zzv3 = this.zzs.zzv();
                        zzaf zzaf3 = this.zzs.zzk;
                        String zzD2 = zzv3.zzD(str6, 40, true);
                        if (str6 != null) {
                            i = str2.length();
                        }
                        this.zzs.zzv().zzN(this.zzn, str3, zzh2, "_ev", zzD2, i);
                        return;
                    }
                    Bundle zzy = this.zzs.zzv().zzy(str3, str2, bundle, Collections.unmodifiableList(Arrays.asList(new String[]{CrashlyticsAnalyticsListener.EVENT_ORIGIN_KEY, "_sn", "_sc", "_si"})), z3);
                    Preconditions.checkNotNull(zzy);
                    zzgi zzgi3 = this.zzs;
                    zzaa zzaa6 = zzgi3.zzj;
                    if (zzgi3.zzs().zzj(false) != null && "_ae".equals(str6)) {
                        zzkp zzkp = this.zzs.zzu().zzb;
                        long elapsedRealtime = zzkp.zzc.zzs.zzr.elapsedRealtime();
                        long j4 = elapsedRealtime - zzkp.zzb;
                        zzkp.zzb = elapsedRealtime;
                        if (j4 > 0) {
                            this.zzs.zzv().zzI(zzy, j4);
                        }
                    }
                    zzoc.zzc();
                    if (this.zzs.zzk.zzs(null, zzel.zzad)) {
                        if (!"auto".equals(str5) && "_ssr".equals(str6)) {
                            zzlp zzv4 = this.zzs.zzv();
                            String string = zzy.getString("_ffr");
                            if (Strings.isEmptyOrWhitespace(string)) {
                                string = null;
                            } else if (string != null) {
                                string = string.trim();
                            }
                            if (!zzlp.zzal(string, zzv4.zzs.zzm().zzo.zza())) {
                                zzv4.zzs.zzm().zzo.zzb(string);
                            } else {
                                zzv4.zzs.zzaz().zzk.zza("Not logging duplicate session_start_with_rollout event");
                                return;
                            }
                        } else if ("_ae".equals(str6)) {
                            String zza2 = this.zzs.zzv().zzs.zzm().zzo.zza();
                            if (!TextUtils.isEmpty(zza2)) {
                                zzy.putString("_ffr", zza2);
                            }
                        }
                    }
                    ArrayList arrayList2 = new ArrayList();
                    arrayList2.add(zzy);
                    if (this.zzs.zzm().zzj.zza() <= 0 || !this.zzs.zzm().zzk(j3) || !this.zzs.zzm().zzl.zzb()) {
                        str4 = "_ae";
                        arrayList = arrayList2;
                        j2 = 0;
                    } else {
                        this.zzs.zzaz().zzl.zza("Current session is expired, remove the session number, ID, and engagement time");
                        str4 = "_ae";
                        arrayList = arrayList2;
                        j2 = 0;
                        zzaa("auto", "_sid", null, this.zzs.zzr.currentTimeMillis());
                        zzaa("auto", "_sno", null, this.zzs.zzr.currentTimeMillis());
                        zzaa("auto", "_se", null, this.zzs.zzr.currentTimeMillis());
                    }
                    if (zzy.getLong("extend_session", j2) == 1) {
                        this.zzs.zzaz().zzl.zza("EXTEND_SESSION param attached: initiate a new session or extend the current active session");
                        this.zzs.zzu().zza.zzb(j3, true);
                    }
                    ArrayList arrayList3 = new ArrayList(zzy.keySet());
                    Collections.sort(arrayList3);
                    int size = arrayList3.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        String str7 = (String) arrayList3.get(i3);
                        if (str7 != null) {
                            this.zzs.zzv();
                            Object obj = zzy.get(str7);
                            if (obj instanceof Bundle) {
                                bundleArr = new Bundle[]{(Bundle) obj};
                            } else if (obj instanceof Parcelable[]) {
                                Parcelable[] parcelableArr = (Parcelable[]) obj;
                                bundleArr = (Bundle[]) Arrays.copyOf(parcelableArr, parcelableArr.length, Bundle[].class);
                            } else if (obj instanceof ArrayList) {
                                ArrayList arrayList4 = (ArrayList) obj;
                                bundleArr = (Bundle[]) arrayList4.toArray(new Bundle[arrayList4.size()]);
                            } else {
                                bundleArr = null;
                            }
                            if (bundleArr != null) {
                                zzy.putParcelableArray(str7, bundleArr);
                            }
                        }
                    }
                    int i4 = 0;
                    while (i4 < arrayList.size()) {
                        ArrayList arrayList5 = arrayList;
                        Bundle bundle3 = (Bundle) arrayList5.get(i4);
                        String str8 = i4 != 0 ? "_ep" : str6;
                        bundle3.putString(CrashlyticsAnalyticsListener.EVENT_ORIGIN_KEY, str5);
                        if (z2) {
                            bundle3 = this.zzs.zzv().zzt(bundle3);
                        }
                        Bundle bundle4 = bundle3;
                        zzav zzav = r1;
                        zzav zzav2 = new zzav(str8, new zzat(bundle4), str, j);
                        zzkb zzt = this.zzs.zzt();
                        if (zzt != null) {
                            Preconditions.checkNotNull(zzav);
                            zzt.zzg();
                            zzt.zza();
                            zzt.zzS();
                            zzer zzi2 = zzt.zzs.zzi();
                            if (zzi2 != null) {
                                Parcel obtain = Parcel.obtain();
                                zzav zzav3 = zzav;
                                zzaw.zza(zzav3, obtain, 0);
                                byte[] marshall = obtain.marshall();
                                obtain.recycle();
                                if (marshall.length > 131072) {
                                    zzi2.zzs.zzaz().zze.zza("Event is too long for local database. Sending event directly to service");
                                    z6 = true;
                                    z5 = false;
                                } else {
                                    z5 = zzi2.zzq(0, marshall);
                                    z6 = true;
                                }
                                zzjq zzjq = new zzjq(zzt, zzt.zzO(z6), z5, zzav3, str3);
                                zzt.zzR(zzjq);
                                if (!z4) {
                                    for (zzhj onEvent : this.zze) {
                                        onEvent.onEvent(str, str2, new Bundle(bundle4), j);
                                    }
                                }
                                i4++;
                                arrayList = arrayList5;
                            } else {
                                throw null;
                            }
                        } else {
                            throw null;
                        }
                    }
                    zzgi zzgi4 = this.zzs;
                    zzaa zzaa7 = zzgi4.zzj;
                    if (zzgi4.zzs().zzj(false) != null && str4.equals(str6)) {
                        this.zzs.zzu().zzb.zzd(true, true, this.zzs.zzr.elapsedRealtime());
                    }
                }
                return;
            }
            this.zzs.zzaz().zzk.zzc("Dropping non-safelisted event. event name, origin", str6, str5);
            return;
        }
        this.zzs.zzaz().zzk.zza("Event not sent since app measurement is disabled");
    }

    public final void zzM(long j, boolean z) {
        zzg();
        zza();
        this.zzs.zzaz().zzk.zza("Resetting analytics data (FE)");
        zzkr zzu = this.zzs.zzu();
        zzu.zzg();
        zzkp zzkp = zzu.zzb;
        zzkp.zzd.zzb();
        zzkp.zza = 0;
        zzkp.zzb = 0;
        boolean zzJ = this.zzs.zzJ();
        zzfn zzm2 = this.zzs.zzm();
        zzm2.zzc.zzb(j);
        if (!TextUtils.isEmpty(zzm2.zzs.zzm().zzo.zza())) {
            zzm2.zzo.zzb(null);
        }
        zzol.zzc();
        if (zzm2.zzs.zzk.zzs(null, zzel.zzae)) {
            zzm2.zzj.zzb(0);
        }
        if (!zzm2.zzs.zzk.zzv()) {
            zzm2.zzi(!zzJ);
        }
        zzm2.zzp.zzb(null);
        zzm2.zzq.zzb(0);
        zzm2.zzr.zzb(null);
        if (z) {
            zzkb zzt = this.zzs.zzt();
            zzt.zzg();
            zzt.zza();
            zzp zzO = zzt.zzO(false);
            zzt.zzS();
            zzt.zzs.zzi().zzj();
            zzt.zzR(new zzjf(zzt, zzO));
        }
        zzol.zzc();
        if (this.zzs.zzk.zzs(null, zzel.zzae)) {
            this.zzs.zzu().zza.zza();
        }
        this.zzc = !zzJ;
    }

    public final void zzN(String str, String str2, long j, Bundle bundle, boolean z, boolean z2, boolean z3, String str3) {
        Bundle bundle2 = new Bundle(bundle);
        for (String str4 : bundle2.keySet()) {
            Object obj = bundle2.get(str4);
            if (obj instanceof Bundle) {
                bundle2.putBundle(str4, new Bundle((Bundle) obj));
            } else {
                int i = 0;
                if (obj instanceof Parcelable[]) {
                    Parcelable[] parcelableArr = (Parcelable[]) obj;
                    while (i < parcelableArr.length) {
                        Parcelable parcelable = parcelableArr[i];
                        if (parcelable instanceof Bundle) {
                            parcelableArr[i] = new Bundle((Bundle) parcelable);
                        }
                        i++;
                    }
                } else if (obj instanceof List) {
                    List list = (List) obj;
                    while (i < list.size()) {
                        Object obj2 = list.get(i);
                        if (obj2 instanceof Bundle) {
                            list.set(i, new Bundle((Bundle) obj2));
                        }
                        i++;
                    }
                }
            }
        }
        zzgf zzaA = this.zzs.zzaA();
        zzhs zzhs = new zzhs(this, str, str2, j, bundle2, z, z2, z3, null);
        zzaA.zzp(zzhs);
    }

    public final void zzO(String str, String str2, long j, Object obj) {
        zzgf zzaA = this.zzs.zzaA();
        zzht zzht = new zzht(this, str, str2, obj, j);
        zzaA.zzp(zzht);
    }

    public final void zzR(Bundle bundle, long j) {
        Class<Long> cls = Long.class;
        Class<String> cls2 = String.class;
        Preconditions.checkNotNull(bundle);
        Bundle bundle2 = new Bundle(bundle);
        if (!TextUtils.isEmpty(bundle2.getString("app_id"))) {
            this.zzs.zzaz().zzg.zza("Package name should be null when calling setConditionalUserProperty");
        }
        bundle2.remove("app_id");
        Preconditions.checkNotNull(bundle2);
        ImageOriginUtils.zza(bundle2, "app_id", cls2, null);
        ImageOriginUtils.zza(bundle2, "origin", cls2, null);
        ImageOriginUtils.zza(bundle2, "name", cls2, null);
        ImageOriginUtils.zza(bundle2, HSLCriteriaBuilder.VALUE, Object.class, null);
        ImageOriginUtils.zza(bundle2, "trigger_event_name", cls2, null);
        Long valueOf = Long.valueOf(0);
        ImageOriginUtils.zza(bundle2, "trigger_timeout", cls, valueOf);
        ImageOriginUtils.zza(bundle2, "timed_out_event_name", cls2, null);
        ImageOriginUtils.zza(bundle2, "timed_out_event_params", Bundle.class, null);
        ImageOriginUtils.zza(bundle2, "triggered_event_name", cls2, null);
        ImageOriginUtils.zza(bundle2, "triggered_event_params", Bundle.class, null);
        ImageOriginUtils.zza(bundle2, "time_to_live", cls, valueOf);
        ImageOriginUtils.zza(bundle2, "expired_event_name", cls2, null);
        ImageOriginUtils.zza(bundle2, "expired_event_params", Bundle.class, null);
        Preconditions.checkNotEmpty(bundle2.getString("name"));
        Preconditions.checkNotEmpty(bundle2.getString("origin"));
        Preconditions.checkNotNull(bundle2.get(HSLCriteriaBuilder.VALUE));
        bundle2.putLong("creation_timestamp", j);
        String string = bundle2.getString("name");
        Object obj = bundle2.get(HSLCriteriaBuilder.VALUE);
        if (this.zzs.zzv().zzl(string) != 0) {
            this.zzs.zzaz().zzd.zzb("Invalid conditional user property name", this.zzs.zzq.zzf(string));
        } else if (this.zzs.zzv().zzd(string, obj) == 0) {
            Object zzB = this.zzs.zzv().zzB(string, obj);
            if (zzB == null) {
                this.zzs.zzaz().zzd.zzc("Unable to normalize conditional user property value", this.zzs.zzq.zzf(string), obj);
                return;
            }
            ImageOriginUtils.zzb(bundle2, zzB);
            long j2 = bundle2.getLong("trigger_timeout");
            if (!TextUtils.isEmpty(bundle2.getString("trigger_event_name"))) {
                zzaf zzaf = this.zzs.zzk;
                if (j2 > 15552000000L || j2 < 1) {
                    this.zzs.zzaz().zzd.zzc("Invalid conditional user property timeout", this.zzs.zzq.zzf(string), Long.valueOf(j2));
                    return;
                }
            }
            long j3 = bundle2.getLong("time_to_live");
            zzgi zzgi = this.zzs;
            zzaf zzaf2 = zzgi.zzk;
            if (j3 > 15552000000L || j3 < 1) {
                this.zzs.zzaz().zzd.zzc("Invalid conditional user property time to live", this.zzs.zzq.zzf(string), Long.valueOf(j3));
            } else {
                zzgi.zzaA().zzp(new zzhw(this, bundle2));
            }
        } else {
            this.zzs.zzaz().zzd.zzc("Invalid conditional user property value", this.zzs.zzq.zzf(string), obj);
        }
    }

    public final void zzS(Bundle bundle, int i, long j) {
        zza();
        String zzg2 = zzah.zzg(bundle);
        if (zzg2 != null) {
            this.zzs.zzaz().zzi.zzb("Ignoring invalid consent setting", zzg2);
            this.zzs.zzaz().zzi.zza("Valid consent values are 'granted', 'denied'");
        }
        zzT(zzah.zza(bundle), i, j);
    }

    public final void zzT(zzah zzah, int i, long j) {
        zzah zzah2;
        boolean z;
        boolean z2;
        boolean z3;
        zzah zzah3 = zzah;
        int i2 = i;
        zza();
        if (i2 != -10 && ((Boolean) zzah3.zzb.get(zzag.AD_STORAGE)) == null && ((Boolean) zzah3.zzb.get(zzag.ANALYTICS_STORAGE)) == null) {
            this.zzs.zzaz().zzi.zza("Discarding empty consent settings");
            return;
        }
        synchronized (this.zzh) {
            zzah2 = this.zzi;
            z = true;
            z2 = false;
            if (zzah.zzj(i2, this.zzj)) {
                boolean zzk2 = zzah3.zzk(this.zzi);
                if (zzah3.zzi(zzag.ANALYTICS_STORAGE) && !this.zzi.zzi(zzag.ANALYTICS_STORAGE)) {
                    z2 = true;
                }
                zzah3 = zzah3.zzd(this.zzi);
                this.zzi = zzah3;
                this.zzj = i2;
                z3 = z2;
                z2 = zzk2;
            } else {
                z = false;
                z3 = false;
            }
        }
        if (!z) {
            this.zzs.zzaz().zzj.zzb("Ignoring lower-priority consent settings, proposed settings", zzah3);
            return;
        }
        long andIncrement = this.zzk.getAndIncrement();
        if (z2) {
            this.zzg.set(null);
            zzgf zzaA = this.zzs.zzaA();
            zzih zzih = new zzih(this, zzah3, j, i, andIncrement, z3, zzah2);
            zzaA.zzq(zzih);
            return;
        }
        zzii zzii = new zzii(this, zzah3, i, andIncrement, z3, zzah2);
        if (i2 == 30 || i2 == -10) {
            this.zzs.zzaA().zzq(zzii);
        } else {
            this.zzs.zzaA().zzp(zzii);
        }
    }

    public final void zzV(zzhi zzhi) {
        zzg();
        zza();
        if (zzhi != null) {
            zzhi zzhi2 = this.zzd;
            if (zzhi != zzhi2) {
                Preconditions.checkState(zzhi2 == null, "EventInterceptor already set.");
            }
        }
        this.zzd = zzhi;
    }

    public final void zzX(zzah zzah) {
        zzg();
        boolean z = (zzah.zzi(zzag.ANALYTICS_STORAGE) && zzah.zzi(zzag.AD_STORAGE)) || this.zzs.zzt().zzM();
        zzgi zzgi = this.zzs;
        zzgi.zzaA().zzg();
        if (z != zzgi.zzF) {
            zzgi zzgi2 = this.zzs;
            zzgi2.zzaA().zzg();
            zzgi2.zzF = z;
            zzfn zzm2 = this.zzs.zzm();
            zzgi zzgi3 = zzm2.zzs;
            zzm2.zzg();
            Boolean valueOf = zzm2.zza().contains("measurement_enabled_from_api") ? Boolean.valueOf(zzm2.zza().getBoolean("measurement_enabled_from_api", true)) : null;
            if (!z || valueOf == null || valueOf.booleanValue()) {
                zzad(Boolean.valueOf(z), false);
            }
        }
    }

    public final void zzY(Object obj) {
        zzZ("auto", "_ldl", obj, true, this.zzs.zzr.currentTimeMillis());
    }

    public final void zzZ(String str, String str2, Object obj, boolean z, long j) {
        int i;
        int i2;
        String str3 = str2;
        Object obj2 = obj;
        String str4 = str == null ? "app" : str;
        if (z) {
            i = this.zzs.zzv().zzl(str3);
        } else {
            zzlp zzv = this.zzs.zzv();
            if (zzv.zzac("user property", str3)) {
                if (!zzv.zzZ("user property", zzhh.zza, null, str3)) {
                    i = 15;
                } else {
                    zzaf zzaf = zzv.zzs.zzk;
                    if (zzv.zzY("user property", 24, str3)) {
                        i = 0;
                    }
                }
            }
            i = 6;
        }
        if (i != 0) {
            zzlp zzv2 = this.zzs.zzv();
            zzaf zzaf2 = this.zzs.zzk;
            this.zzs.zzv().zzN(this.zzn, null, i, "_ev", zzv2.zzD(str3, 24, true), str3 != null ? str2.length() : 0);
        } else if (obj2 != null) {
            int zzd2 = this.zzs.zzv().zzd(str3, obj2);
            if (zzd2 != 0) {
                zzlp zzv3 = this.zzs.zzv();
                zzaf zzaf3 = this.zzs.zzk;
                String zzD = zzv3.zzD(str3, 24, true);
                if ((obj2 instanceof String) || (obj2 instanceof CharSequence)) {
                    i2 = obj.toString().length();
                } else {
                    i2 = 0;
                }
                this.zzs.zzv().zzN(this.zzn, null, zzd2, "_ev", zzD, i2);
                return;
            }
            Object zzB = this.zzs.zzv().zzB(str3, obj2);
            if (zzB != null) {
                zzO(str4, str2, j, zzB);
            }
        } else {
            zzO(str4, str2, j, null);
        }
    }

    /* JADX WARNING: type inference failed for: r12v0, types: [java.lang.Object] */
    /* JADX WARNING: type inference failed for: r7v0, types: [java.lang.Object] */
    /* JADX WARNING: type inference failed for: r7v1 */
    /* JADX WARNING: type inference failed for: r7v2 */
    /* JADX WARNING: type inference failed for: r7v3 */
    /* JADX WARNING: type inference failed for: r0v5 */
    /* JADX WARNING: type inference failed for: r11v13, types: [java.lang.Long] */
    /* JADX WARNING: type inference failed for: r7v5 */
    /* JADX WARNING: type inference failed for: r7v6 */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r7v2
      assigns: []
      uses: []
      mth insns count: 79
    	at jadx.core.dex.visitors.typeinference.TypeSearch.fillTypeCandidates(TypeSearch.java:237)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
    	at jadx.core.dex.visitors.typeinference.TypeSearch.run(TypeSearch.java:53)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runMultiVariableSearch(TypeInferenceVisitor.java:104)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:97)
     */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x006f  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x007d  */
    /* JADX WARNING: Unknown variable types count: 4 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzaa(java.lang.String r10, java.lang.String r11, java.lang.Object r12, long r13) {
        /*
            r9 = this;
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r10)
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r11)
            r9.zzg()
            r9.zza()
            java.lang.String r0 = "allow_personalized_ads"
            boolean r0 = r0.equals(r11)
            r1 = 1
            java.lang.String r2 = "_npa"
            if (r0 == 0) goto L_0x0065
            boolean r0 = r12 instanceof java.lang.String
            if (r0 == 0) goto L_0x0053
            r0 = r12
            java.lang.String r0 = (java.lang.String) r0
            boolean r3 = android.text.TextUtils.isEmpty(r0)
            if (r3 != 0) goto L_0x0053
            java.util.Locale r11 = java.util.Locale.ENGLISH
            java.lang.String r11 = r0.toLowerCase(r11)
            java.lang.String r12 = "false"
            boolean r11 = r12.equals(r11)
            r3 = 1
            if (r1 == r11) goto L_0x0037
            r5 = 0
            goto L_0x0038
        L_0x0037:
            r5 = r3
        L_0x0038:
            java.lang.Long r11 = java.lang.Long.valueOf(r5)
            com.google.android.gms.measurement.internal.zzgi r0 = r9.zzs
            com.google.android.gms.measurement.internal.zzfn r0 = r0.zzm()
            com.google.android.gms.measurement.internal.zzfm r0 = r0.zzh
            long r5 = r11.longValue()
            int r7 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r7 != 0) goto L_0x004e
            java.lang.String r12 = "true"
        L_0x004e:
            r0.zzb(r12)
            r7 = r11
            goto L_0x0063
        L_0x0053:
            if (r12 != 0) goto L_0x0065
            com.google.android.gms.measurement.internal.zzgi r11 = r9.zzs
            com.google.android.gms.measurement.internal.zzfn r11 = r11.zzm()
            com.google.android.gms.measurement.internal.zzfm r11 = r11.zzh
            java.lang.String r0 = "unset"
            r11.zzb(r0)
            r7 = r12
        L_0x0063:
            r4 = r2
            goto L_0x0067
        L_0x0065:
            r4 = r11
            r7 = r12
        L_0x0067:
            com.google.android.gms.measurement.internal.zzgi r11 = r9.zzs
            boolean r11 = r11.zzJ()
            if (r11 != 0) goto L_0x007d
            com.google.android.gms.measurement.internal.zzgi r10 = r9.zzs
            com.google.android.gms.measurement.internal.zzey r10 = r10.zzaz()
            com.google.android.gms.measurement.internal.zzew r10 = r10.zzl
            java.lang.String r11 = "User property not set since app measurement is disabled"
            r10.zza(r11)
            return
        L_0x007d:
            com.google.android.gms.measurement.internal.zzgi r11 = r9.zzs
            boolean r11 = r11.zzM()
            if (r11 != 0) goto L_0x0086
            return
        L_0x0086:
            com.google.android.gms.measurement.internal.zzll r11 = new com.google.android.gms.measurement.internal.zzll
            r3 = r11
            r5 = r13
            r8 = r10
            r3.<init>(r4, r5, r7, r8)
            com.google.android.gms.measurement.internal.zzgi r10 = r9.zzs
            com.google.android.gms.measurement.internal.zzkb r10 = r10.zzt()
            r10.zzg()
            r10.zza()
            r10.zzS()
            com.google.android.gms.measurement.internal.zzgi r12 = r10.zzs
            com.google.android.gms.measurement.internal.zzer r12 = r12.zzi()
            if (r12 == 0) goto L_0x00d8
            android.os.Parcel r13 = android.os.Parcel.obtain()
            r14 = 0
            com.google.android.gms.measurement.internal.zzlm.zza(r11, r13, r14)
            byte[] r0 = r13.marshall()
            r13.recycle()
            int r13 = r0.length
            r2 = 131072(0x20000, float:1.83671E-40)
            if (r13 <= r2) goto L_0x00c7
            com.google.android.gms.measurement.internal.zzgi r12 = r12.zzs
            com.google.android.gms.measurement.internal.zzey r12 = r12.zzaz()
            com.google.android.gms.measurement.internal.zzew r12 = r12.zze
            java.lang.String r13 = "User property too long for local database. Sending directly to service"
            r12.zza(r13)
            goto L_0x00cb
        L_0x00c7:
            boolean r14 = r12.zzq(r1, r0)
        L_0x00cb:
            com.google.android.gms.measurement.internal.zzp r12 = r10.zzO(r1)
            com.google.android.gms.measurement.internal.zzjd r13 = new com.google.android.gms.measurement.internal.zzjd
            r13.<init>(r10, r12, r14, r11)
            r10.zzR(r13)
            return
        L_0x00d8:
            r10 = 0
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzin.zzaa(java.lang.String, java.lang.String, java.lang.Object, long):void");
    }

    public final void zzac(Bundle bundle, long j) {
        if (TextUtils.isEmpty(this.zzs.zzh().zzm())) {
            zzS(bundle, 0, j);
        } else {
            this.zzs.zzaz().zzi.zza("Using developer consent only; google app id found");
        }
    }

    public final void zzad(Boolean bool, boolean z) {
        zzg();
        zza();
        this.zzs.zzaz().zzk.zzb("Setting app measurement enabled (FE)", bool);
        this.zzs.zzm().zzh(bool);
        if (z) {
            zzfn zzm2 = this.zzs.zzm();
            zzgi zzgi = zzm2.zzs;
            zzm2.zzg();
            Editor edit = zzm2.zza().edit();
            if (bool != null) {
                edit.putBoolean("measurement_enabled_from_api", bool.booleanValue());
            } else {
                edit.remove("measurement_enabled_from_api");
            }
            edit.apply();
        }
        zzgi zzgi2 = this.zzs;
        zzgi2.zzaA().zzg();
        if (zzgi2.zzF || (bool != null && !bool.booleanValue())) {
            zzae();
        }
    }

    public final void zzae() {
        zzg();
        String zza2 = this.zzs.zzm().zzh.zza();
        if (zza2 != null) {
            if ("unset".equals(zza2)) {
                zzaa("app", "_npa", null, this.zzs.zzr.currentTimeMillis());
            } else {
                zzaa("app", "_npa", Long.valueOf(true != BaseParser.TRUE.equals(zza2) ? 0 : 1), this.zzs.zzr.currentTimeMillis());
            }
        }
        if (!this.zzs.zzJ() || !this.zzc) {
            this.zzs.zzaz().zzk.zza("Updating Scion state (FE)");
            zzkb zzt = this.zzs.zzt();
            zzt.zzg();
            zzt.zza();
            zzt.zzR(new zzjo(zzt, zzt.zzO(true)));
            return;
        }
        this.zzs.zzaz().zzk.zza("Recording app launch after enabling measurement for the first time (FE)");
        zzz();
        zzol.zzc();
        if (this.zzs.zzk.zzs(null, zzel.zzae)) {
            this.zzs.zzu().zza.zza();
        }
        this.zzs.zzaA().zzp(new zzhq(this));
    }

    public final boolean zzf() {
        return false;
    }

    public final String zzo() {
        return (String) this.zzg.get();
    }

    public final void zzz() {
        zzg();
        zza();
        if (this.zzs.zzM()) {
            if (this.zzs.zzk.zzs(null, zzel.zzY)) {
                zzaf zzaf = this.zzs.zzk;
                zzaa zzaa = zzaf.zzs.zzj;
                Boolean zzk2 = zzaf.zzk("google_analytics_deferred_deep_link_enabled");
                if (zzk2 != null && zzk2.booleanValue()) {
                    this.zzs.zzaz().zzk.zza("Deferred Deep Link feature enabled.");
                    this.zzs.zzaA().zzp(new zzhm(this));
                }
            }
            zzkb zzt = this.zzs.zzt();
            zzt.zzg();
            zzt.zza();
            zzp zzO = zzt.zzO(true);
            zzt.zzs.zzi().zzq(3, new byte[0]);
            zzt.zzR(new zzji(zzt, zzO));
            this.zzc = false;
            zzfn zzm2 = this.zzs.zzm();
            zzm2.zzg();
            String string = zzm2.zza().getString("previous_os_version", null);
            zzm2.zzs.zzg().zzu();
            String str = VERSION.RELEASE;
            if (!TextUtils.isEmpty(str) && !str.equals(string)) {
                Editor edit = zzm2.zza().edit();
                edit.putString("previous_os_version", str);
                edit.apply();
            }
            if (!TextUtils.isEmpty(string)) {
                this.zzs.zzg().zzu();
                if (!string.equals(VERSION.RELEASE)) {
                    Bundle bundle = new Bundle();
                    bundle.putString("_po", string);
                    zzH("auto", "_ou", bundle);
                }
            }
        }
    }
}
