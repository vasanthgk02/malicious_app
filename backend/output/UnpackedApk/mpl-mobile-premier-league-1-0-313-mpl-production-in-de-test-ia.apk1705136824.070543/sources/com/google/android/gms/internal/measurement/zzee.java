package com.google.android.gms.internal.measurement;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.BadParcelableException;
import android.os.Bundle;
import android.os.NetworkOnMainThreadException;
import android.os.RemoteException;
import com.facebook.drawee.backends.pipeline.info.ImageOriginUtils;
import com.freshchat.consumer.sdk.beans.config.DefaultUserEventsConfig;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.DynamiteModule.LoadingException;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.measurement.dynamite.ModuleDescriptor;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.android.gms.measurement.internal.zzhi;
import com.google.android.gms.measurement.internal.zzit;
import com.google.firebase.perf.config.RemoteConfigManager;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.eclipse.paho.client.mqttv3.MqttAsyncClient;

/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@20.1.2 */
public final class zzee {
    public static volatile zzee zzc;
    public final Clock zza;
    public final ExecutorService zzb;
    public final String zzd;
    public final AppMeasurementSdk zze;
    public final List zzf;
    public int zzg;
    public boolean zzh;
    public final String zzi;
    public volatile zzcc zzj;

    public zzee(Context context, String str, String str2, String str3, Bundle bundle) {
        if (str == null || !zzV(str2, str3)) {
            this.zzd = "FA";
        } else {
            this.zzd = str;
        }
        this.zza = DefaultClock.zza;
        zzbx.zza();
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), new zzdi(this));
        boolean z = true;
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        this.zzb = Executors.unconfigurableExecutorService(threadPoolExecutor);
        this.zze = new AppMeasurementSdk(this);
        this.zzf = new ArrayList();
        try {
            if (zzit.zzc(context, "google_app_id", ImageOriginUtils.zza(context)) != null && !zzR()) {
                this.zzi = null;
                this.zzh = true;
                return;
            }
        } catch (IllegalStateException unused) {
        }
        if (!zzV(str2, str3)) {
            this.zzi = "fa";
            if (str2 == null || str3 == null) {
                boolean z2 = (str2 == null) ^ (str3 != null ? false : z);
            }
        } else {
            this.zzi = str2;
        }
        zzcx zzcx = new zzcx(this, str2, str3, context, bundle);
        zzU(zzcx);
        Application application = (Application) context.getApplicationContext();
        if (application != null) {
            application.registerActivityLifecycleCallbacks(new zzed(this));
        }
    }

    public static final boolean zzR() {
        try {
            Class.forName("com.google.firebase.analytics.FirebaseAnalytics");
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    /* access modifiers changed from: private */
    public final void zzS(Exception exc, boolean z, boolean z2) {
        this.zzh |= z;
        if (!z && z2) {
            zzA(5, "Error with data collection. Data lost.", exc, null, null);
        }
    }

    private final void zzT(String str, String str2, Bundle bundle, boolean z, boolean z2, Long l) {
        zzdr zzdr = new zzdr(this, l, str, str2, bundle, z, z2);
        zzU(zzdr);
    }

    /* access modifiers changed from: private */
    public final void zzU(zzdt zzdt) {
        this.zzb.execute(zzdt);
    }

    public static final boolean zzV(String str, String str2) {
        return (str2 == null || str == null || zzR()) ? false : true;
    }

    public static zzee zzg(Context context, String str, String str2, String str3, Bundle bundle) {
        Preconditions.checkNotNull(context);
        if (zzc == null) {
            synchronized (zzee.class) {
                if (zzc == null) {
                    zzee zzee = new zzee(context, str, str2, str3, bundle);
                    zzc = zzee;
                }
            }
        }
        return zzc;
    }

    public final void zzA(int i, String str, Object obj, Object obj2, Object obj3) {
        zzdg zzdg = new zzdg(this, false, 5, str, obj, null, null);
        zzU(zzdg);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0036, code lost:
        if (r4.zzj == null) goto L_0x003e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:?, code lost:
        r4.zzj.registerOnMeasurementEventListener(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x003d, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x003e, code lost:
        zzU(new com.google.android.gms.internal.measurement.zzdp(r4, r1));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0046, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzB(com.google.android.gms.measurement.internal.zzhj r5) {
        /*
            r4 = this;
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r5)
            java.util.List r0 = r4.zzf
            monitor-enter(r0)
            r1 = 0
        L_0x0007:
            java.util.List r2 = r4.zzf     // Catch:{ all -> 0x0047 }
            int r2 = r2.size()     // Catch:{ all -> 0x0047 }
            if (r1 >= r2) goto L_0x0024
            java.util.List r2 = r4.zzf     // Catch:{ all -> 0x0047 }
            java.lang.Object r2 = r2.get(r1)     // Catch:{ all -> 0x0047 }
            android.util.Pair r2 = (android.util.Pair) r2     // Catch:{ all -> 0x0047 }
            java.lang.Object r2 = r2.first     // Catch:{ all -> 0x0047 }
            boolean r2 = r5.equals(r2)     // Catch:{ all -> 0x0047 }
            if (r2 == 0) goto L_0x0021
            monitor-exit(r0)     // Catch:{ all -> 0x0047 }
            return
        L_0x0021:
            int r1 = r1 + 1
            goto L_0x0007
        L_0x0024:
            com.google.android.gms.internal.measurement.zzdv r1 = new com.google.android.gms.internal.measurement.zzdv     // Catch:{ all -> 0x0047 }
            r1.<init>(r5)     // Catch:{ all -> 0x0047 }
            java.util.List r2 = r4.zzf     // Catch:{ all -> 0x0047 }
            android.util.Pair r3 = new android.util.Pair     // Catch:{ all -> 0x0047 }
            r3.<init>(r5, r1)     // Catch:{ all -> 0x0047 }
            r2.add(r3)     // Catch:{ all -> 0x0047 }
            monitor-exit(r0)     // Catch:{ all -> 0x0047 }
            com.google.android.gms.internal.measurement.zzcc r5 = r4.zzj
            if (r5 == 0) goto L_0x003e
            com.google.android.gms.internal.measurement.zzcc r5 = r4.zzj     // Catch:{ BadParcelableException | NetworkOnMainThreadException | RemoteException | IllegalArgumentException | IllegalStateException | NullPointerException | SecurityException | UnsupportedOperationException -> 0x003e }
            r5.registerOnMeasurementEventListener(r1)     // Catch:{ BadParcelableException | NetworkOnMainThreadException | RemoteException | IllegalArgumentException | IllegalStateException | NullPointerException | SecurityException | UnsupportedOperationException -> 0x003e }
            return
        L_0x003e:
            com.google.android.gms.internal.measurement.zzdp r5 = new com.google.android.gms.internal.measurement.zzdp
            r5.<init>(r4, r1)
            r4.zzU(r5)
            return
        L_0x0047:
            r5 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0047 }
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzee.zzB(com.google.android.gms.measurement.internal.zzhj):void");
    }

    public final void zzC() {
        zzU(new zzcv(this));
    }

    public final void zzD(Bundle bundle) {
        zzU(new zzcn(this, bundle));
    }

    public final void zzE(Bundle bundle) {
        zzU(new zzct(this, bundle));
    }

    public final void zzF(Bundle bundle) {
        zzU(new zzcu(this, bundle));
    }

    public final void zzG(Activity activity, String str, String str2) {
        zzU(new zzcr(this, activity, str, str2));
    }

    public final void zzH(boolean z) {
        zzU(new zzdm(this, z));
    }

    public final void zzI(Bundle bundle) {
        zzU(new zzdn(this, bundle));
    }

    public final void zzJ(zzhi zzhi) {
        zzdu zzdu = new zzdu(zzhi);
        if (this.zzj != null) {
            try {
                this.zzj.setEventInterceptor(zzdu);
                return;
            } catch (BadParcelableException | NetworkOnMainThreadException | RemoteException | IllegalArgumentException | IllegalStateException | NullPointerException | SecurityException | UnsupportedOperationException unused) {
            }
        }
        zzU(new zzdo(this, zzdu));
    }

    public final void zzK(Boolean bool) {
        zzU(new zzcs(this, bool));
    }

    public final void zzL(long j) {
        zzU(new zzcw(this, j));
    }

    public final void zzM(String str) {
        zzU(new zzcq(this, str));
    }

    public final void zzN(String str, String str2, Object obj, boolean z) {
        zzds zzds = new zzds(this, str, str2, obj, z);
        zzU(zzds);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x003c, code lost:
        if (r3.zzj == null) goto L_0x0044;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
        r3.zzj.unregisterOnMeasurementEventListener(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0043, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0044, code lost:
        zzU(new com.google.android.gms.internal.measurement.zzdq(r3, r4));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x004c, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzO(com.google.android.gms.measurement.internal.zzhj r4) {
        /*
            r3 = this;
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r4)
            java.util.List r0 = r3.zzf
            monitor-enter(r0)
            r1 = 0
        L_0x0007:
            java.util.List r2 = r3.zzf     // Catch:{ all -> 0x004d }
            int r2 = r2.size()     // Catch:{ all -> 0x004d }
            if (r1 >= r2) goto L_0x002b
            java.util.List r2 = r3.zzf     // Catch:{ all -> 0x004d }
            java.lang.Object r2 = r2.get(r1)     // Catch:{ all -> 0x004d }
            android.util.Pair r2 = (android.util.Pair) r2     // Catch:{ all -> 0x004d }
            java.lang.Object r2 = r2.first     // Catch:{ all -> 0x004d }
            boolean r2 = r4.equals(r2)     // Catch:{ all -> 0x004d }
            if (r2 == 0) goto L_0x0028
            java.util.List r4 = r3.zzf     // Catch:{ all -> 0x004d }
            java.lang.Object r4 = r4.get(r1)     // Catch:{ all -> 0x004d }
            android.util.Pair r4 = (android.util.Pair) r4     // Catch:{ all -> 0x004d }
            goto L_0x002c
        L_0x0028:
            int r1 = r1 + 1
            goto L_0x0007
        L_0x002b:
            r4 = 0
        L_0x002c:
            if (r4 != 0) goto L_0x0030
            monitor-exit(r0)     // Catch:{ all -> 0x004d }
            return
        L_0x0030:
            java.util.List r1 = r3.zzf     // Catch:{ all -> 0x004d }
            r1.remove(r4)     // Catch:{ all -> 0x004d }
            java.lang.Object r4 = r4.second     // Catch:{ all -> 0x004d }
            com.google.android.gms.internal.measurement.zzdv r4 = (com.google.android.gms.internal.measurement.zzdv) r4     // Catch:{ all -> 0x004d }
            monitor-exit(r0)     // Catch:{ all -> 0x004d }
            com.google.android.gms.internal.measurement.zzcc r0 = r3.zzj
            if (r0 == 0) goto L_0x0044
            com.google.android.gms.internal.measurement.zzcc r0 = r3.zzj     // Catch:{ BadParcelableException | NetworkOnMainThreadException | RemoteException | IllegalArgumentException | IllegalStateException | NullPointerException | SecurityException | UnsupportedOperationException -> 0x0044 }
            r0.unregisterOnMeasurementEventListener(r4)     // Catch:{ BadParcelableException | NetworkOnMainThreadException | RemoteException | IllegalArgumentException | IllegalStateException | NullPointerException | SecurityException | UnsupportedOperationException -> 0x0044 }
            return
        L_0x0044:
            com.google.android.gms.internal.measurement.zzdq r0 = new com.google.android.gms.internal.measurement.zzdq
            r0.<init>(r3, r4)
            r3.zzU(r0)
            return
        L_0x004d:
            r4 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x004d }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzee.zzO(com.google.android.gms.measurement.internal.zzhj):void");
    }

    public final int zza(String str) {
        zzbz zzbz = new zzbz();
        zzU(new zzdj(this, str, zzbz));
        Integer num = (Integer) zzbz.zze(zzbz.zzb(MqttAsyncClient.DISCONNECT_TIMEOUT), Integer.class);
        if (num == null) {
            return 25;
        }
        return num.intValue();
    }

    public final long zzb() {
        zzbz zzbz = new zzbz();
        zzU(new zzdc(this, zzbz));
        Long l = (Long) zzbz.zze(zzbz.zzb(500), Long.class);
        if (l != null) {
            return l.longValue();
        }
        long nextLong = new Random(System.nanoTime() ^ this.zza.currentTimeMillis()).nextLong();
        int i = this.zzg + 1;
        this.zzg = i;
        return nextLong + ((long) i);
    }

    public final Bundle zzc(Bundle bundle, boolean z) {
        zzbz zzbz = new zzbz();
        zzU(new zzdh(this, bundle, zzbz));
        if (z) {
            return zzbz.zzb(RemoteConfigManager.MIN_APP_START_CONFIG_FETCH_DELAY_MS);
        }
        return null;
    }

    public final AppMeasurementSdk zzd() {
        return this.zze;
    }

    public final zzcc zzf(Context context, boolean z) {
        try {
            return zzcb.asInterface(DynamiteModule.load(context, DynamiteModule.PREFER_HIGHEST_OR_LOCAL_VERSION, ModuleDescriptor.MODULE_ID).instantiate("com.google.android.gms.measurement.internal.AppMeasurementDynamiteService"));
        } catch (LoadingException e2) {
            zzS(e2, true, false);
            return null;
        }
    }

    public final Object zzh(int i) {
        zzbz zzbz = new zzbz();
        zzU(new zzdl(this, zzbz, i));
        return zzbz.zze(zzbz.zzb(DefaultUserEventsConfig.MAX_DELAY_IN_MILLIS_UNTIL_UPLOAD), Object.class);
    }

    public final String zzj() {
        return this.zzi;
    }

    public final String zzk() {
        zzbz zzbz = new zzbz();
        zzU(new zzdk(this, zzbz));
        return zzbz.zzc(120000);
    }

    public final String zzl() {
        zzbz zzbz = new zzbz();
        zzU(new zzdb(this, zzbz));
        return zzbz.zzc(50);
    }

    public final String zzm() {
        zzbz zzbz = new zzbz();
        zzU(new zzde(this, zzbz));
        return zzbz.zzc(500);
    }

    public final String zzn() {
        zzbz zzbz = new zzbz();
        zzU(new zzdd(this, zzbz));
        return zzbz.zzc(500);
    }

    public final String zzo() {
        zzbz zzbz = new zzbz();
        zzU(new zzda(this, zzbz));
        return zzbz.zzc(500);
    }

    public final List zzp(String str, String str2) {
        zzbz zzbz = new zzbz();
        zzU(new zzcp(this, str, str2, zzbz));
        List list = (List) zzbz.zze(zzbz.zzb(RemoteConfigManager.MIN_APP_START_CONFIG_FETCH_DELAY_MS), List.class);
        return list == null ? Collections.emptyList() : list;
    }

    public final Map zzq(String str, String str2, boolean z) {
        zzbz zzbz = new zzbz();
        zzdf zzdf = new zzdf(this, str, str2, z, zzbz);
        zzU(zzdf);
        Bundle zzb2 = zzbz.zzb(RemoteConfigManager.MIN_APP_START_CONFIG_FETCH_DELAY_MS);
        if (zzb2 == null || zzb2.size() == 0) {
            return Collections.emptyMap();
        }
        HashMap hashMap = new HashMap(zzb2.size());
        for (String str3 : zzb2.keySet()) {
            Object obj = zzb2.get(str3);
            if ((obj instanceof Double) || (obj instanceof Long) || (obj instanceof String)) {
                hashMap.put(str3, obj);
            }
        }
        return hashMap;
    }

    public final void zzu(String str) {
        zzU(new zzcy(this, str));
    }

    public final void zzv(String str, String str2, Bundle bundle) {
        zzU(new zzco(this, str, str2, bundle));
    }

    public final void zzw(String str) {
        zzU(new zzcz(this, str));
    }

    public final void zzx(String str, Bundle bundle) {
        zzT(null, str, bundle, false, true, null);
    }

    public final void zzy(String str, String str2, Bundle bundle) {
        zzT(str, str2, bundle, true, true, null);
    }

    public final void zzz(String str, String str2, Bundle bundle, long j) {
        zzT(str, str2, bundle, true, false, Long.valueOf(j));
    }
}
