package com.google.android.gms.measurement.internal;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import androidx.collection.ArrayMap;
import com.freshchat.consumer.sdk.beans.config.DefaultUserEventsConfig;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.DynamiteApi;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.measurement.zzcb;
import com.google.android.gms.internal.measurement.zzcf;
import com.google.android.gms.internal.measurement.zzci;
import com.google.android.gms.internal.measurement.zzck;
import com.google.android.gms.internal.measurement.zzcl;
import com.google.android.gms.internal.measurement.zzof;
import com.google.firebase.crashlytics.CrashlyticsAnalyticsListener;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;

@DynamiteApi
/* compiled from: com.google.android.gms:play-services-measurement-sdk@@20.1.2 */
public class AppMeasurementDynamiteService extends zzcb {
    @VisibleForTesting
    public zzgi zza = null;
    public final Map zzb = new ArrayMap();

    public void beginAdUnitExposure(String str, long j) throws RemoteException {
        zzb();
        this.zza.zzd().zzd(str, j);
    }

    public void clearConditionalUserProperty(String str, String str2, Bundle bundle) throws RemoteException {
        zzb();
        this.zza.zzq().zzA(str, str2, bundle);
    }

    public void clearMeasurementEnabled(long j) throws RemoteException {
        zzb();
        zzin zzq = this.zza.zzq();
        zzq.zza();
        zzq.zzs.zzaA().zzp(new zzig(zzq, null));
    }

    public void endAdUnitExposure(String str, long j) throws RemoteException {
        zzb();
        this.zza.zzd().zze(str, j);
    }

    public void generateEventId(zzcf zzcf) throws RemoteException {
        zzb();
        long zzq = this.zza.zzv().zzq();
        zzb();
        this.zza.zzv().zzU(zzcf, zzq);
    }

    public void getAppInstanceId(zzcf zzcf) throws RemoteException {
        zzb();
        this.zza.zzaA().zzp(new zzh(this, zzcf));
    }

    public void getCachedAppInstanceId(zzcf zzcf) throws RemoteException {
        zzb();
        String zzo = this.zza.zzq().zzo();
        zzb();
        this.zza.zzv().zzV(zzcf, zzo);
    }

    public void getConditionalUserProperties(String str, String str2, zzcf zzcf) throws RemoteException {
        zzb();
        this.zza.zzaA().zzp(new zzl(this, zzcf, str, str2));
    }

    public void getCurrentScreenClass(zzcf zzcf) throws RemoteException {
        zzb();
        zziu zziu = this.zza.zzq().zzs.zzs().zzb;
        String str = zziu != null ? zziu.zzb : null;
        zzb();
        this.zza.zzv().zzV(zzcf, str);
    }

    public void getCurrentScreenName(zzcf zzcf) throws RemoteException {
        zzb();
        zziu zziu = this.zza.zzq().zzs.zzs().zzb;
        String str = zziu != null ? zziu.zza : null;
        zzb();
        this.zza.zzv().zzV(zzcf, str);
    }

    public void getGmpAppId(zzcf zzcf) throws RemoteException {
        zzb();
        zzin zzq = this.zza.zzq();
        zzgi zzgi = zzq.zzs;
        String str = zzgi.zzf;
        if (str == null) {
            try {
                str = zzit.zzc(zzgi.zze, "google_app_id", zzgi.zzw);
            } catch (IllegalStateException e2) {
                zzq.zzs.zzaz().zzd.zzb("getGoogleAppId failed with exception", e2);
                str = null;
            }
        }
        zzb();
        this.zza.zzv().zzV(zzcf, str);
    }

    public void getMaxUserProperties(String str, zzcf zzcf) throws RemoteException {
        zzb();
        zzin zzq = this.zza.zzq();
        if (zzq != null) {
            Preconditions.checkNotEmpty(str);
            zzaf zzaf = zzq.zzs.zzk;
            zzb();
            this.zza.zzv().zzT(zzcf, 25);
            return;
        }
        throw null;
    }

    public void getTestFlag(zzcf zzcf, int i) throws RemoteException {
        zzb();
        if (i == 0) {
            zzlp zzv = this.zza.zzv();
            zzin zzq = this.zza.zzq();
            if (zzq != null) {
                AtomicReference atomicReference = new AtomicReference();
                zzv.zzV(zzcf, (String) zzq.zzs.zzaA().zzd(atomicReference, DefaultUserEventsConfig.MAX_DELAY_IN_MILLIS_UNTIL_UPLOAD, "String test flag value", new zzic(zzq, atomicReference)));
                return;
            }
            throw null;
        } else if (i == 1) {
            zzlp zzv2 = this.zza.zzv();
            zzin zzq2 = this.zza.zzq();
            if (zzq2 != null) {
                AtomicReference atomicReference2 = new AtomicReference();
                zzv2.zzU(zzcf, ((Long) zzq2.zzs.zzaA().zzd(atomicReference2, DefaultUserEventsConfig.MAX_DELAY_IN_MILLIS_UNTIL_UPLOAD, "long test flag value", new zzid(zzq2, atomicReference2))).longValue());
                return;
            }
            throw null;
        } else if (i == 2) {
            zzlp zzv3 = this.zza.zzv();
            zzin zzq3 = this.zza.zzq();
            if (zzq3 != null) {
                AtomicReference atomicReference3 = new AtomicReference();
                double doubleValue = ((Double) zzq3.zzs.zzaA().zzd(atomicReference3, DefaultUserEventsConfig.MAX_DELAY_IN_MILLIS_UNTIL_UPLOAD, "double test flag value", new zzif(zzq3, atomicReference3))).doubleValue();
                Bundle bundle = new Bundle();
                bundle.putDouble("r", doubleValue);
                try {
                    zzcf.zzd(bundle);
                } catch (RemoteException e2) {
                    zzv3.zzs.zzaz().zzg.zzb("Error returning double value to wrapper", e2);
                }
            } else {
                throw null;
            }
        } else if (i == 3) {
            zzlp zzv4 = this.zza.zzv();
            zzin zzq4 = this.zza.zzq();
            if (zzq4 != null) {
                AtomicReference atomicReference4 = new AtomicReference();
                zzv4.zzT(zzcf, ((Integer) zzq4.zzs.zzaA().zzd(atomicReference4, DefaultUserEventsConfig.MAX_DELAY_IN_MILLIS_UNTIL_UPLOAD, "int test flag value", new zzie(zzq4, atomicReference4))).intValue());
                return;
            }
            throw null;
        } else if (i == 4) {
            zzlp zzv5 = this.zza.zzv();
            zzin zzq5 = this.zza.zzq();
            if (zzq5 != null) {
                AtomicReference atomicReference5 = new AtomicReference();
                zzv5.zzP(zzcf, ((Boolean) zzq5.zzs.zzaA().zzd(atomicReference5, DefaultUserEventsConfig.MAX_DELAY_IN_MILLIS_UNTIL_UPLOAD, "boolean test flag value", new zzhz(zzq5, atomicReference5))).booleanValue());
                return;
            }
            throw null;
        }
    }

    public void getUserProperties(String str, String str2, boolean z, zzcf zzcf) throws RemoteException {
        zzb();
        zzgf zzaA = this.zza.zzaA();
        zzj zzj = new zzj(this, zzcf, str, str2, z);
        zzaA.zzp(zzj);
    }

    public void initForTests(Map map) throws RemoteException {
        zzb();
    }

    public void initialize(IObjectWrapper iObjectWrapper, zzcl zzcl, long j) throws RemoteException {
        zzgi zzgi = this.zza;
        if (zzgi == null) {
            Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
            Preconditions.checkNotNull(context);
            this.zza = zzgi.zzp(context, zzcl, Long.valueOf(j));
            return;
        }
        zzgi.zzaz().zzg.zza("Attempting to initialize multiple times");
    }

    public void isDataCollectionEnabled(zzcf zzcf) throws RemoteException {
        zzb();
        this.zza.zzaA().zzp(new zzm(this, zzcf));
    }

    public void logEvent(String str, String str2, Bundle bundle, boolean z, boolean z2, long j) throws RemoteException {
        zzb();
        this.zza.zzq().zzF(str, str2, bundle, z, z2, j);
    }

    public void logEventAndBundle(String str, String str2, Bundle bundle, zzcf zzcf, long j) throws RemoteException {
        Bundle bundle2;
        zzb();
        Preconditions.checkNotEmpty(str2);
        if (bundle != null) {
            bundle2 = new Bundle(bundle);
        } else {
            bundle2 = new Bundle();
        }
        bundle2.putString(CrashlyticsAnalyticsListener.EVENT_ORIGIN_KEY, "app");
        zzav zzav = new zzav(str2, new zzat(bundle), "app", j);
        this.zza.zzaA().zzp(new zzi(this, zzcf, zzav, str));
    }

    public void logHealthData(int i, String str, IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3) throws RemoteException {
        Object obj;
        Object obj2;
        zzb();
        Object obj3 = null;
        if (iObjectWrapper == null) {
            obj = null;
        } else {
            obj = ObjectWrapper.unwrap(iObjectWrapper);
        }
        if (iObjectWrapper2 == null) {
            obj2 = null;
        } else {
            obj2 = ObjectWrapper.unwrap(iObjectWrapper2);
        }
        if (iObjectWrapper3 != null) {
            obj3 = ObjectWrapper.unwrap(iObjectWrapper3);
        }
        this.zza.zzaz().zzt(i, true, false, str, obj, obj2, obj3);
    }

    public void onActivityCreated(IObjectWrapper iObjectWrapper, Bundle bundle, long j) throws RemoteException {
        zzb();
        zzim zzim = this.zza.zzq().zza;
        if (zzim != null) {
            this.zza.zzq().zzB();
            zzim.onActivityCreated((Activity) ObjectWrapper.unwrap(iObjectWrapper), bundle);
        }
    }

    public void onActivityDestroyed(IObjectWrapper iObjectWrapper, long j) throws RemoteException {
        zzb();
        zzim zzim = this.zza.zzq().zza;
        if (zzim != null) {
            this.zza.zzq().zzB();
            zzim.onActivityDestroyed((Activity) ObjectWrapper.unwrap(iObjectWrapper));
        }
    }

    public void onActivityPaused(IObjectWrapper iObjectWrapper, long j) throws RemoteException {
        zzb();
        zzim zzim = this.zza.zzq().zza;
        if (zzim != null) {
            this.zza.zzq().zzB();
            zzim.onActivityPaused((Activity) ObjectWrapper.unwrap(iObjectWrapper));
        }
    }

    public void onActivityResumed(IObjectWrapper iObjectWrapper, long j) throws RemoteException {
        zzb();
        zzim zzim = this.zza.zzq().zza;
        if (zzim != null) {
            this.zza.zzq().zzB();
            zzim.onActivityResumed((Activity) ObjectWrapper.unwrap(iObjectWrapper));
        }
    }

    public void onActivitySaveInstanceState(IObjectWrapper iObjectWrapper, zzcf zzcf, long j) throws RemoteException {
        zzb();
        zzim zzim = this.zza.zzq().zza;
        Bundle bundle = new Bundle();
        if (zzim != null) {
            this.zza.zzq().zzB();
            zzim.onActivitySaveInstanceState((Activity) ObjectWrapper.unwrap(iObjectWrapper), bundle);
        }
        try {
            zzcf.zzd(bundle);
        } catch (RemoteException e2) {
            this.zza.zzaz().zzg.zzb("Error returning bundle value to wrapper", e2);
        }
    }

    public void onActivityStarted(IObjectWrapper iObjectWrapper, long j) throws RemoteException {
        zzb();
        if (this.zza.zzq().zza != null) {
            this.zza.zzq().zzB();
            Activity activity = (Activity) ObjectWrapper.unwrap(iObjectWrapper);
        }
    }

    public void onActivityStopped(IObjectWrapper iObjectWrapper, long j) throws RemoteException {
        zzb();
        if (this.zza.zzq().zza != null) {
            this.zza.zzq().zzB();
            Activity activity = (Activity) ObjectWrapper.unwrap(iObjectWrapper);
        }
    }

    public void performAction(Bundle bundle, zzcf zzcf, long j) throws RemoteException {
        zzb();
        zzcf.zzd(null);
    }

    public void registerOnMeasurementEventListener(zzci zzci) throws RemoteException {
        Object obj;
        zzb();
        synchronized (this.zzb) {
            obj = (zzhj) this.zzb.get(Integer.valueOf(zzci.zzd()));
            if (obj == null) {
                obj = new zzo(this, zzci);
                this.zzb.put(Integer.valueOf(zzci.zzd()), obj);
            }
        }
        zzin zzq = this.zza.zzq();
        zzq.zza();
        Preconditions.checkNotNull(obj);
        if (!zzq.zze.add(obj)) {
            zzq.zzs.zzaz().zzg.zza("OnEventListener already registered");
        }
    }

    public void resetAnalyticsData(long j) throws RemoteException {
        zzb();
        zzin zzq = this.zza.zzq();
        zzq.zzg.set(null);
        zzq.zzs.zzaA().zzp(new zzhv(zzq, j));
    }

    public void setConditionalUserProperty(Bundle bundle, long j) throws RemoteException {
        zzb();
        if (bundle == null) {
            this.zza.zzaz().zzd.zza("Conditional user property must not be null");
        } else {
            this.zza.zzq().zzR(bundle, j);
        }
    }

    public void setConsent(Bundle bundle, long j) throws RemoteException {
        zzb();
        zzin zzq = this.zza.zzq();
        if (zzq != null) {
            zzof.zzc();
            if (zzq.zzs.zzk.zzs(null, zzel.zzal)) {
                zzq.zzs.zzaA().zzq(new zzho(zzq, bundle, j));
            } else {
                zzq.zzac(bundle, j);
            }
        } else {
            throw null;
        }
    }

    public void setConsentThirdParty(Bundle bundle, long j) throws RemoteException {
        zzb();
        this.zza.zzq().zzS(bundle, -20, j);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0090, code lost:
        if (r4.length() <= 100) goto L_0x00a9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x00b9, code lost:
        if (r5.length() <= 100) goto L_0x00d2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setCurrentScreen(com.google.android.gms.dynamic.IObjectWrapper r3, java.lang.String r4, java.lang.String r5, long r6) throws android.os.RemoteException {
        /*
            r2 = this;
            r2.zzb()
            com.google.android.gms.measurement.internal.zzgi r6 = r2.zza
            com.google.android.gms.measurement.internal.zzjb r6 = r6.zzs()
            java.lang.Object r3 = com.google.android.gms.dynamic.ObjectWrapper.unwrap(r3)
            android.app.Activity r3 = (android.app.Activity) r3
            com.google.android.gms.measurement.internal.zzgi r7 = r6.zzs
            com.google.android.gms.measurement.internal.zzaf r7 = r7.zzk
            boolean r7 = r7.zzu()
            if (r7 != 0) goto L_0x0028
            com.google.android.gms.measurement.internal.zzgi r3 = r6.zzs
            com.google.android.gms.measurement.internal.zzey r3 = r3.zzaz()
            com.google.android.gms.measurement.internal.zzew r3 = r3.zzi
            java.lang.String r4 = "setCurrentScreen cannot be called while screen reporting is disabled."
            r3.zza(r4)
            goto L_0x00fd
        L_0x0028:
            com.google.android.gms.measurement.internal.zziu r7 = r6.zzb
            if (r7 != 0) goto L_0x003b
            com.google.android.gms.measurement.internal.zzgi r3 = r6.zzs
            com.google.android.gms.measurement.internal.zzey r3 = r3.zzaz()
            com.google.android.gms.measurement.internal.zzew r3 = r3.zzi
            java.lang.String r4 = "setCurrentScreen cannot be called while no activity active"
            r3.zza(r4)
            goto L_0x00fd
        L_0x003b:
            java.util.Map r0 = r6.zzd
            java.lang.Object r0 = r0.get(r3)
            if (r0 != 0) goto L_0x0052
            com.google.android.gms.measurement.internal.zzgi r3 = r6.zzs
            com.google.android.gms.measurement.internal.zzey r3 = r3.zzaz()
            com.google.android.gms.measurement.internal.zzew r3 = r3.zzi
            java.lang.String r4 = "setCurrentScreen must be called with an activity in the activity lifecycle"
            r3.zza(r4)
            goto L_0x00fd
        L_0x0052:
            if (r5 != 0) goto L_0x005e
            java.lang.Class r5 = r3.getClass()
            java.lang.String r0 = "Activity"
            java.lang.String r5 = r6.zzl(r5, r0)
        L_0x005e:
            java.lang.String r0 = r7.zzb
            boolean r0 = com.google.android.gms.measurement.internal.zzlp.zzal(r0, r5)
            java.lang.String r7 = r7.zza
            boolean r7 = com.google.android.gms.measurement.internal.zzlp.zzal(r7, r4)
            if (r0 == 0) goto L_0x007e
            if (r7 != 0) goto L_0x006f
            goto L_0x007e
        L_0x006f:
            com.google.android.gms.measurement.internal.zzgi r3 = r6.zzs
            com.google.android.gms.measurement.internal.zzey r3 = r3.zzaz()
            com.google.android.gms.measurement.internal.zzew r3 = r3.zzi
            java.lang.String r4 = "setCurrentScreen cannot be called with the same class and name"
            r3.zza(r4)
            goto L_0x00fd
        L_0x007e:
            r7 = 100
            if (r4 == 0) goto L_0x00a9
            int r0 = r4.length()
            if (r0 <= 0) goto L_0x0093
            com.google.android.gms.measurement.internal.zzgi r0 = r6.zzs
            com.google.android.gms.measurement.internal.zzaf r0 = r0.zzk
            int r0 = r4.length()
            if (r0 > r7) goto L_0x0093
            goto L_0x00a9
        L_0x0093:
            com.google.android.gms.measurement.internal.zzgi r3 = r6.zzs
            com.google.android.gms.measurement.internal.zzey r3 = r3.zzaz()
            com.google.android.gms.measurement.internal.zzew r3 = r3.zzi
            int r4 = r4.length()
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            java.lang.String r5 = "Invalid screen name length in setCurrentScreen. Length"
            r3.zzb(r5, r4)
            goto L_0x00fd
        L_0x00a9:
            if (r5 == 0) goto L_0x00d2
            int r0 = r5.length()
            if (r0 <= 0) goto L_0x00bc
            com.google.android.gms.measurement.internal.zzgi r0 = r6.zzs
            com.google.android.gms.measurement.internal.zzaf r0 = r0.zzk
            int r0 = r5.length()
            if (r0 > r7) goto L_0x00bc
            goto L_0x00d2
        L_0x00bc:
            com.google.android.gms.measurement.internal.zzgi r3 = r6.zzs
            com.google.android.gms.measurement.internal.zzey r3 = r3.zzaz()
            com.google.android.gms.measurement.internal.zzew r3 = r3.zzi
            int r4 = r5.length()
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            java.lang.String r5 = "Invalid class name length in setCurrentScreen. Length"
            r3.zzb(r5, r4)
            goto L_0x00fd
        L_0x00d2:
            com.google.android.gms.measurement.internal.zzgi r7 = r6.zzs
            com.google.android.gms.measurement.internal.zzey r7 = r7.zzaz()
            com.google.android.gms.measurement.internal.zzew r7 = r7.zzl
            if (r4 != 0) goto L_0x00df
            java.lang.String r0 = "null"
            goto L_0x00e0
        L_0x00df:
            r0 = r4
        L_0x00e0:
            java.lang.String r1 = "Setting current screen to name, class"
            r7.zzc(r1, r0, r5)
            com.google.android.gms.measurement.internal.zziu r7 = new com.google.android.gms.measurement.internal.zziu
            com.google.android.gms.measurement.internal.zzgi r0 = r6.zzs
            com.google.android.gms.measurement.internal.zzlp r0 = r0.zzv()
            long r0 = r0.zzq()
            r7.<init>(r4, r5, r0)
            java.util.Map r4 = r6.zzd
            r4.put(r3, r7)
            r4 = 1
            r6.zzA(r3, r7, r4)
        L_0x00fd:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.AppMeasurementDynamiteService.setCurrentScreen(com.google.android.gms.dynamic.IObjectWrapper, java.lang.String, java.lang.String, long):void");
    }

    public void setDataCollectionEnabled(boolean z) throws RemoteException {
        zzb();
        zzin zzq = this.zza.zzq();
        zzq.zza();
        zzq.zzs.zzaA().zzp(new zzij(zzq, z));
    }

    public void setDefaultEventParameters(Bundle bundle) {
        Bundle bundle2;
        zzb();
        zzin zzq = this.zza.zzq();
        if (bundle == null) {
            bundle2 = null;
        } else {
            bundle2 = new Bundle(bundle);
        }
        zzq.zzs.zzaA().zzp(new zzhn(zzq, bundle2));
    }

    public void setEventInterceptor(zzci zzci) throws RemoteException {
        zzb();
        zzn zzn = new zzn(this, zzci);
        if (this.zza.zzaA().zzs()) {
            this.zza.zzq().zzV(zzn);
        } else {
            this.zza.zzaA().zzp(new zzk(this, zzn));
        }
    }

    public void setInstanceIdProvider(zzck zzck) throws RemoteException {
        zzb();
    }

    public void setMeasurementEnabled(boolean z, long j) throws RemoteException {
        zzb();
        zzin zzq = this.zza.zzq();
        Boolean valueOf = Boolean.valueOf(z);
        zzq.zza();
        zzq.zzs.zzaA().zzp(new zzig(zzq, valueOf));
    }

    public void setMinimumSessionDuration(long j) throws RemoteException {
        zzb();
    }

    public void setSessionTimeoutDuration(long j) throws RemoteException {
        zzb();
        zzin zzq = this.zza.zzq();
        zzq.zzs.zzaA().zzp(new zzhr(zzq, j));
    }

    public void setUserId(String str, long j) throws RemoteException {
        zzb();
        zzin zzq = this.zza.zzq();
        if (str == null || !TextUtils.isEmpty(str)) {
            zzq.zzs.zzaA().zzp(new zzhp(zzq, str));
            zzq.zzZ(null, "_id", str, true, j);
            return;
        }
        zzq.zzs.zzaz().zzg.zza("User ID must be non-empty or null");
    }

    public void setUserProperty(String str, String str2, IObjectWrapper iObjectWrapper, boolean z, long j) throws RemoteException {
        zzb();
        this.zza.zzq().zzZ(str, str2, ObjectWrapper.unwrap(iObjectWrapper), z, j);
    }

    public void unregisterOnMeasurementEventListener(zzci zzci) throws RemoteException {
        Object obj;
        zzb();
        synchronized (this.zzb) {
            obj = (zzhj) this.zzb.remove(Integer.valueOf(zzci.zzd()));
        }
        if (obj == null) {
            obj = new zzo(this, zzci);
        }
        zzin zzq = this.zza.zzq();
        zzq.zza();
        Preconditions.checkNotNull(obj);
        if (!zzq.zze.remove(obj)) {
            zzq.zzs.zzaz().zzg.zza("OnEventListener had not been registered");
        }
    }

    @EnsuresNonNull({"scion"})
    public final void zzb() {
        if (this.zza == null) {
            throw new IllegalStateException("Attempting to perform action before initialize.");
        }
    }
}
