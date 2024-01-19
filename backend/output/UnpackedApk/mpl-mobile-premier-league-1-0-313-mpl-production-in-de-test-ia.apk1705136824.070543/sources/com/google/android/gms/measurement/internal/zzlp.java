package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ServiceInfo;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.text.TextUtils;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.drawee.backends.pipeline.info.ImageOriginUtils;
import com.facebook.react.modules.appstate.AppStateModule;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.internal.measurement.zzcf;
import com.google.firebase.crashlytics.CrashlyticsAnalyticsListener;
import com.google.firebase.crashlytics.internal.settings.network.DefaultSettingsSpiCall;
import com.netcore.android.notification.SMTNotificationConstants;
import java.io.ByteArrayInputStream;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.TreeSet;
import java.util.concurrent.atomic.AtomicLong;
import javax.security.auth.x500.X500Principal;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@20.1.2 */
public final class zzlp extends zzhc {
    public static final String[] zzb = {"firebase_", "google_", "ga_"};
    public static final String[] zzc = {"_err"};
    public SecureRandom zzd;
    public final AtomicLong zze = new AtomicLong(0);
    public int zzf;
    public Integer zzg = null;

    public zzlp(zzgi zzgi) {
        super(zzgi);
    }

    public static MessageDigest zzF() {
        int i = 0;
        while (i < 2) {
            try {
                MessageDigest instance = MessageDigest.getInstance("MD5");
                if (instance != null) {
                    return instance;
                }
                i++;
            } catch (NoSuchAlgorithmException unused) {
            }
        }
        return null;
    }

    public static ArrayList zzH(List<zzab> list) {
        if (list == null) {
            return new ArrayList(0);
        }
        ArrayList arrayList = new ArrayList(list.size());
        for (zzab zzab : list) {
            Bundle bundle = new Bundle();
            bundle.putString("app_id", zzab.zza);
            bundle.putString("origin", zzab.zzb);
            bundle.putLong("creation_timestamp", zzab.zzd);
            bundle.putString("name", zzab.zzc.zzb);
            Object zza = zzab.zzc.zza();
            Preconditions.checkNotNull(zza);
            ImageOriginUtils.zzb(bundle, zza);
            bundle.putBoolean(AppStateModule.APP_STATE_ACTIVE, zzab.zze);
            String str = zzab.zzf;
            if (str != null) {
                bundle.putString("trigger_event_name", str);
            }
            zzav zzav = zzab.zzg;
            if (zzav != null) {
                bundle.putString("timed_out_event_name", zzav.zza);
                zzat zzat = zzav.zzb;
                if (zzat != null) {
                    bundle.putBundle("timed_out_event_params", zzat.zzc());
                }
            }
            bundle.putLong("trigger_timeout", zzab.zzh);
            zzav zzav2 = zzab.zzi;
            if (zzav2 != null) {
                bundle.putString("triggered_event_name", zzav2.zza);
                zzat zzat2 = zzav2.zzb;
                if (zzat2 != null) {
                    bundle.putBundle("triggered_event_params", zzat2.zzc());
                }
            }
            bundle.putLong("triggered_timestamp", zzab.zzc.zzc);
            bundle.putLong("time_to_live", zzab.zzj);
            zzav zzav3 = zzab.zzk;
            if (zzav3 != null) {
                bundle.putString("expired_event_name", zzav3.zza);
                zzat zzat3 = zzav3.zzb;
                if (zzat3 != null) {
                    bundle.putBundle("expired_event_params", zzat3.zzc());
                }
            }
            arrayList.add(bundle);
        }
        return arrayList;
    }

    public static void zzK(zziu zziu, Bundle bundle, boolean z) {
        if (!(bundle == null || zziu == null)) {
            if (!bundle.containsKey("_sc") || z) {
                String str = zziu.zza;
                if (str != null) {
                    bundle.putString("_sn", str);
                } else {
                    bundle.remove("_sn");
                }
                String str2 = zziu.zzb;
                if (str2 != null) {
                    bundle.putString("_sc", str2);
                } else {
                    bundle.remove("_sc");
                }
                bundle.putLong("_si", zziu.zzc);
                return;
            }
            z = false;
        }
        if (bundle != null && zziu == null && z) {
            bundle.remove("_sn");
            bundle.remove("_sc");
            bundle.remove("_si");
        }
    }

    public static boolean zzah(String str) {
        return !TextUtils.isEmpty(str) && str.startsWith("_");
    }

    public static boolean zzai(String str) {
        Preconditions.checkNotEmpty(str);
        if (str.charAt(0) != '_' || str.equals("_ep")) {
            return true;
        }
        return false;
    }

    public static boolean zzaj(Context context) {
        Preconditions.checkNotNull(context);
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null) {
                return false;
            }
            ActivityInfo receiverInfo = packageManager.getReceiverInfo(new ComponentName(context, "com.google.android.gms.measurement.AppMeasurementReceiver"), 0);
            if (receiverInfo != null && receiverInfo.enabled) {
                return true;
            }
            return false;
        } catch (NameNotFoundException unused) {
        }
    }

    public static boolean zzak(Context context) {
        Preconditions.checkNotNull(context);
        if (VERSION.SDK_INT >= 24) {
            return zzau(context, "com.google.android.gms.measurement.AppMeasurementJobService");
        }
        return zzau(context, "com.google.android.gms.measurement.AppMeasurementService");
    }

    public static boolean zzal(String str, String str2) {
        if (str == null && str2 == null) {
            return true;
        }
        if (str == null) {
            return false;
        }
        return str.equals(str2);
    }

    public static final boolean zzap(Bundle bundle, int i) {
        if (bundle.getLong("_err") != 0) {
            return false;
        }
        bundle.putLong("_err", (long) i);
        return true;
    }

    public static boolean zzat(String str, String[] strArr) {
        Preconditions.checkNotNull(strArr);
        for (String zzal : strArr) {
            if (zzal(str, zzal)) {
                return true;
            }
        }
        return false;
    }

    public static boolean zzau(Context context, String str) {
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null) {
                return false;
            }
            ServiceInfo serviceInfo = packageManager.getServiceInfo(new ComponentName(context, str), 0);
            if (serviceInfo != null && serviceInfo.enabled) {
                return true;
            }
            return false;
        } catch (NameNotFoundException unused) {
        }
    }

    @VisibleForTesting
    public static long zzp(byte[] bArr) {
        Preconditions.checkNotNull(bArr);
        int length = bArr.length;
        int i = 0;
        Preconditions.checkState(length > 0);
        int i2 = length - 1;
        long j = 0;
        while (i2 >= 0 && i2 >= bArr.length - 8) {
            j += (((long) bArr[i2]) & 255) << i;
            i += 8;
            i2--;
        }
        return j;
    }

    public final Object zzA(String str, Object obj) {
        int i = 256;
        if ("_ev".equals(str)) {
            zzaf zzaf = this.zzs.zzk;
            return zzas(256, obj, true, true);
        }
        if (zzah(str)) {
            zzaf zzaf2 = this.zzs.zzk;
        } else {
            zzaf zzaf3 = this.zzs.zzk;
            i = 100;
        }
        return zzas(i, obj, false, true);
    }

    public final Object zzB(String str, Object obj) {
        if ("_ldl".equals(str)) {
            return zzas(zzar(str), obj, true, false);
        }
        return zzas(zzar(str), obj, false, false);
    }

    public final String zzC() {
        byte[] bArr = new byte[16];
        zzG().nextBytes(bArr);
        return String.format(Locale.US, "%032x", new Object[]{new BigInteger(1, bArr)});
    }

    public final String zzD(String str, int i, boolean z) {
        if (str == null) {
            return null;
        }
        if (str.codePointCount(0, str.length()) <= i) {
            return str;
        }
        if (z) {
            return String.valueOf(str.substring(0, str.offsetByCodePoints(0, i))).concat("...");
        }
        return null;
    }

    @EnsuresNonNull({"this.secureRandom"})
    public final SecureRandom zzG() {
        zzg();
        if (this.zzd == null) {
            this.zzd = new SecureRandom();
        }
        return this.zzd;
    }

    public final void zzI(Bundle bundle, long j) {
        long j2 = bundle.getLong("_et");
        if (j2 != 0) {
            this.zzs.zzaz().zzg.zzb("Params already contained engagement", Long.valueOf(j2));
        } else {
            j2 = 0;
        }
        bundle.putLong("_et", j + j2);
    }

    public final void zzJ(Bundle bundle, int i, String str, Object obj) {
        if (zzap(bundle, i)) {
            zzaf zzaf = this.zzs.zzk;
            bundle.putString("_ev", zzD(str, 40, true));
            if (obj != null) {
                Preconditions.checkNotNull(bundle);
                if ((obj instanceof String) || (obj instanceof CharSequence)) {
                    bundle.putLong("_el", (long) obj.toString().length());
                }
            }
        }
    }

    public final void zzL(Bundle bundle, Bundle bundle2) {
        if (bundle2 != null) {
            for (String str : bundle2.keySet()) {
                if (!bundle.containsKey(str)) {
                    this.zzs.zzv().zzO(bundle, str, bundle2.get(str));
                }
            }
        }
    }

    public final void zzM(zzez zzez, int i) {
        Iterator it = new TreeSet(zzez.zzd.keySet()).iterator();
        int i2 = 0;
        while (it.hasNext()) {
            String str = (String) it.next();
            if (zzai(str)) {
                i2++;
                if (i2 > i) {
                    this.zzs.zzaz().zzf.zzc(GeneratedOutlineSupport.outline74("Event can't contain more than ", i, " params").toString(), this.zzs.zzq.zzd(zzez.zza), this.zzs.zzq.zzb(zzez.zzd));
                    zzap(zzez.zzd, 5);
                    zzez.zzd.remove(str);
                }
            }
        }
    }

    public final void zzN(zzlo zzlo, String str, int i, String str2, String str3, int i2) {
        Bundle bundle = new Bundle();
        zzap(bundle, i);
        if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
            bundle.putString(str2, str3);
        }
        if (i == 6 || i == 7 || i == 2) {
            bundle.putLong("_el", (long) i2);
        }
        zzlo.zza(str, "_err", bundle);
    }

    public final void zzO(Bundle bundle, String str, Object obj) {
        if (bundle != null) {
            if (obj instanceof Long) {
                bundle.putLong(str, ((Long) obj).longValue());
            } else if (obj instanceof String) {
                bundle.putString(str, String.valueOf(obj));
            } else if (obj instanceof Double) {
                bundle.putDouble(str, ((Double) obj).doubleValue());
            } else if (obj instanceof Bundle[]) {
                bundle.putParcelableArray(str, (Bundle[]) obj);
            } else {
                if (str != null) {
                    this.zzs.zzaz().zzi.zzc("Not putting event parameter. Invalid value type. name, type", this.zzs.zzq.zze(str), obj != null ? obj.getClass().getSimpleName() : null);
                }
            }
        }
    }

    public final void zzP(zzcf zzcf, boolean z) {
        Bundle bundle = new Bundle();
        bundle.putBoolean("r", z);
        try {
            zzcf.zzd(bundle);
        } catch (RemoteException e2) {
            this.zzs.zzaz().zzg.zzb("Error returning boolean value to wrapper", e2);
        }
    }

    public final void zzQ(zzcf zzcf, ArrayList arrayList) {
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("r", arrayList);
        try {
            zzcf.zzd(bundle);
        } catch (RemoteException e2) {
            this.zzs.zzaz().zzg.zzb("Error returning bundle list to wrapper", e2);
        }
    }

    public final void zzR(zzcf zzcf, Bundle bundle) {
        try {
            zzcf.zzd(bundle);
        } catch (RemoteException e2) {
            this.zzs.zzaz().zzg.zzb("Error returning bundle value to wrapper", e2);
        }
    }

    public final void zzS(zzcf zzcf, byte[] bArr) {
        Bundle bundle = new Bundle();
        bundle.putByteArray("r", bArr);
        try {
            zzcf.zzd(bundle);
        } catch (RemoteException e2) {
            this.zzs.zzaz().zzg.zzb("Error returning byte array to wrapper", e2);
        }
    }

    public final void zzT(zzcf zzcf, int i) {
        Bundle bundle = new Bundle();
        bundle.putInt("r", i);
        try {
            zzcf.zzd(bundle);
        } catch (RemoteException e2) {
            this.zzs.zzaz().zzg.zzb("Error returning int value to wrapper", e2);
        }
    }

    public final void zzU(zzcf zzcf, long j) {
        Bundle bundle = new Bundle();
        bundle.putLong("r", j);
        try {
            zzcf.zzd(bundle);
        } catch (RemoteException e2) {
            this.zzs.zzaz().zzg.zzb("Error returning long value to wrapper", e2);
        }
    }

    public final void zzV(zzcf zzcf, String str) {
        try {
            zzcf.zzd(GeneratedOutlineSupport.outline14("r", str));
        } catch (RemoteException e2) {
            this.zzs.zzaz().zzg.zzb("Error returning string value to wrapper", e2);
        }
    }

    public final void zzW(String str, String str2, String str3, Bundle bundle, List list, boolean z) {
        int i;
        String str4;
        int i2;
        String str5 = str2;
        Bundle bundle2 = bundle;
        List list2 = list;
        if (bundle2 != null) {
            zzaf zzaf = this.zzs.zzk;
            Iterator it = new TreeSet(bundle.keySet()).iterator();
            int i3 = 0;
            while (it.hasNext()) {
                String str6 = (String) it.next();
                if (list2 == null || !list2.contains(str6)) {
                    i = !z ? zzj(str6) : 0;
                    if (i == 0) {
                        i = zzi(str6);
                    }
                } else {
                    i = 0;
                }
                if (i != 0) {
                    zzJ(bundle2, i, str6, i == 3 ? str6 : null);
                    bundle2.remove(str6);
                } else {
                    if (zzaf(bundle2.get(str6))) {
                        this.zzs.zzaz().zzi.zzd("Nested Bundle parameters are not allowed; discarded. event name, param name, child param name", str5, str3, str6);
                        i2 = 22;
                        str4 = str6;
                    } else {
                        String str7 = str3;
                        str4 = str6;
                        i2 = zza(str, str2, str6, bundle2.get(str6), bundle, list, z, false);
                    }
                    if (i2 != 0 && !"_ev".equals(str4)) {
                        zzJ(bundle2, i2, str4, bundle2.get(str4));
                        bundle2.remove(str4);
                    } else if (zzai(str4) && !zzat(str4, zzhg.zzd)) {
                        i3++;
                        if (i3 > 0) {
                            this.zzs.zzaz().zzf.zzc("Item cannot contain custom parameters", this.zzs.zzq.zzd(str5), this.zzs.zzq.zzb(bundle2));
                            zzap(bundle2, 23);
                            bundle2.remove(str4);
                        }
                    }
                }
            }
        }
    }

    public final boolean zzX(String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            Preconditions.checkNotNull(str);
            if (!str.matches("^(1:\\d+:android:[a-f0-9]+|ca-app-pub-.*)$")) {
                if (this.zzs.zzL()) {
                    this.zzs.zzaz().zzf.zzb("Invalid google_app_id. Firebase Analytics disabled. See https://goo.gl/NAOOOI. provided id", zzey.zzn(str));
                }
                return false;
            }
        } else if (!TextUtils.isEmpty(str2)) {
            Preconditions.checkNotNull(str2);
            if (!str2.matches("^(1:\\d+:android:[a-f0-9]+|ca-app-pub-.*)$")) {
                this.zzs.zzaz().zzf.zzb("Invalid admob_app_id. Analytics disabled.", zzey.zzn(str2));
                return false;
            }
        } else {
            if (this.zzs.zzL()) {
                this.zzs.zzaz().zzf.zza("Missing google_app_id. Firebase Analytics disabled. See https://goo.gl/NAOOOI");
            }
            return false;
        }
        return true;
    }

    public final boolean zzY(String str, int i, String str2) {
        if (str2 == null) {
            this.zzs.zzaz().zzf.zzb("Name is required and can't be null. Type", str);
            return false;
        } else if (str2.codePointCount(0, str2.length()) <= i) {
            return true;
        } else {
            this.zzs.zzaz().zzf.zzd("Name is too long. Type, maximum supported length, name", str, Integer.valueOf(i), str2);
            return false;
        }
    }

    public final boolean zzZ(String str, String[] strArr, String[] strArr2, String str2) {
        if (str2 == null) {
            this.zzs.zzaz().zzf.zzb("Name is required and can't be null. Type", str);
            return false;
        }
        Preconditions.checkNotNull(str2);
        String[] strArr3 = zzb;
        for (int i = 0; i < 3; i++) {
            if (str2.startsWith(strArr3[i])) {
                this.zzs.zzaz().zzf.zzc("Name starts with reserved prefix. Type, name", str, str2);
                return false;
            }
        }
        if (strArr == null || !zzat(str2, strArr) || (strArr2 != null && zzat(str2, strArr2))) {
            return true;
        }
        this.zzs.zzaz().zzf.zzc("Name is reserved. Type, name", str, str2);
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:45:0x00d6 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00d7  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int zza(java.lang.String r15, java.lang.String r16, java.lang.String r17, java.lang.Object r18, android.os.Bundle r19, java.util.List r20, boolean r21, boolean r22) {
        /*
            r14 = this;
            r7 = r14
            r8 = r17
            r0 = r18
            r1 = r19
            r14.zzg()
            boolean r2 = r14.zzaf(r0)
            r3 = 0
            java.lang.String r4 = "param"
            if (r2 == 0) goto L_0x00a9
            if (r22 == 0) goto L_0x00a6
            java.lang.String[] r2 = com.google.android.gms.measurement.internal.zzhg.zzc
            boolean r2 = zzat(r8, r2)
            if (r2 != 0) goto L_0x0020
            r0 = 20
            return r0
        L_0x0020:
            com.google.android.gms.measurement.internal.zzgi r2 = r7.zzs
            com.google.android.gms.measurement.internal.zzkb r2 = r2.zzt()
            r2.zzg()
            r2.zza()
            boolean r5 = r2.zzN()
            if (r5 != 0) goto L_0x0033
            goto L_0x0045
        L_0x0033:
            com.google.android.gms.measurement.internal.zzgi r2 = r2.zzs
            com.google.android.gms.measurement.internal.zzlp r2 = r2.zzv()
            int r2 = r2.zzm()
            r5 = 200900(0x310c4, float:2.81521E-40)
            if (r2 >= r5) goto L_0x0045
            r0 = 25
            return r0
        L_0x0045:
            com.google.android.gms.measurement.internal.zzgi r2 = r7.zzs
            com.google.android.gms.measurement.internal.zzaf r2 = r2.zzk
            boolean r2 = r0 instanceof android.os.Parcelable[]
            if (r2 == 0) goto L_0x0052
            r5 = r0
            android.os.Parcelable[] r5 = (android.os.Parcelable[]) r5
            int r5 = r5.length
            goto L_0x005d
        L_0x0052:
            boolean r5 = r0 instanceof java.util.ArrayList
            if (r5 == 0) goto L_0x00a9
            r5 = r0
            java.util.ArrayList r5 = (java.util.ArrayList) r5
            int r5 = r5.size()
        L_0x005d:
            r6 = 200(0xc8, float:2.8E-43)
            if (r5 <= r6) goto L_0x00a9
            com.google.android.gms.measurement.internal.zzgi r9 = r7.zzs
            com.google.android.gms.measurement.internal.zzey r9 = r9.zzaz()
            com.google.android.gms.measurement.internal.zzew r9 = r9.zzi
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            java.lang.String r10 = "Parameter array is too long; discarded. Value kind, name, array length"
            r9.zzd(r10, r4, r8, r5)
            com.google.android.gms.measurement.internal.zzgi r5 = r7.zzs
            com.google.android.gms.measurement.internal.zzaf r5 = r5.zzk
            if (r2 == 0) goto L_0x0088
            r2 = r0
            android.os.Parcelable[] r2 = (android.os.Parcelable[]) r2
            int r5 = r2.length
            if (r5 <= r6) goto L_0x00a1
            java.lang.Object[] r2 = java.util.Arrays.copyOf(r2, r6)
            android.os.Parcelable[] r2 = (android.os.Parcelable[]) r2
            r1.putParcelableArray(r8, r2)
            goto L_0x00a1
        L_0x0088:
            boolean r2 = r0 instanceof java.util.ArrayList
            if (r2 == 0) goto L_0x00a1
            r2 = r0
            java.util.ArrayList r2 = (java.util.ArrayList) r2
            int r5 = r2.size()
            if (r5 <= r6) goto L_0x00a1
            java.util.ArrayList r5 = new java.util.ArrayList
            java.util.List r2 = r2.subList(r3, r6)
            r5.<init>(r2)
            r1.putParcelableArrayList(r8, r5)
        L_0x00a1:
            r1 = 17
            r9 = 17
            goto L_0x00aa
        L_0x00a6:
            r0 = 21
            return r0
        L_0x00a9:
            r9 = 0
        L_0x00aa:
            com.google.android.gms.measurement.internal.zzgi r1 = r7.zzs
            com.google.android.gms.measurement.internal.zzaf r1 = r1.zzk
            com.google.android.gms.measurement.internal.zzek r2 = com.google.android.gms.measurement.internal.zzel.zzS
            r10 = r15
            boolean r1 = r1.zzs(r15, r2)
            if (r1 == 0) goto L_0x00bd
            boolean r1 = zzah(r16)
            if (r1 != 0) goto L_0x00c3
        L_0x00bd:
            boolean r1 = zzah(r17)
            if (r1 == 0) goto L_0x00ca
        L_0x00c3:
            com.google.android.gms.measurement.internal.zzgi r1 = r7.zzs
            com.google.android.gms.measurement.internal.zzaf r1 = r1.zzk
            r1 = 256(0x100, float:3.59E-43)
            goto L_0x00d0
        L_0x00ca:
            com.google.android.gms.measurement.internal.zzgi r1 = r7.zzs
            com.google.android.gms.measurement.internal.zzaf r1 = r1.zzk
            r1 = 100
        L_0x00d0:
            boolean r1 = r14.zzaa(r4, r8, r1, r0)
            if (r1 == 0) goto L_0x00d7
            return r9
        L_0x00d7:
            if (r22 == 0) goto L_0x0166
            boolean r1 = r0 instanceof android.os.Bundle
            if (r1 == 0) goto L_0x00ef
            r4 = r0
            android.os.Bundle r4 = (android.os.Bundle) r4
            r0 = r14
            r1 = r15
            r2 = r16
            r3 = r17
            r5 = r20
            r6 = r21
            r0.zzW(r1, r2, r3, r4, r5, r6)
            goto L_0x0165
        L_0x00ef:
            boolean r1 = r0 instanceof android.os.Parcelable[]
            if (r1 == 0) goto L_0x0125
            r11 = r0
            android.os.Parcelable[] r11 = (android.os.Parcelable[]) r11
            int r12 = r11.length
            r13 = 0
        L_0x00f8:
            if (r13 >= r12) goto L_0x0165
            r0 = r11[r13]
            boolean r1 = r0 instanceof android.os.Bundle
            if (r1 != 0) goto L_0x0112
            com.google.android.gms.measurement.internal.zzgi r1 = r7.zzs
            com.google.android.gms.measurement.internal.zzey r1 = r1.zzaz()
            com.google.android.gms.measurement.internal.zzew r1 = r1.zzi
            java.lang.Class r0 = r0.getClass()
            java.lang.String r2 = "All Parcelable[] elements must be of type Bundle. Value type, name"
            r1.zzc(r2, r0, r8)
            goto L_0x0166
        L_0x0112:
            r4 = r0
            android.os.Bundle r4 = (android.os.Bundle) r4
            r0 = r14
            r1 = r15
            r2 = r16
            r3 = r17
            r5 = r20
            r6 = r21
            r0.zzW(r1, r2, r3, r4, r5, r6)
            int r13 = r13 + 1
            goto L_0x00f8
        L_0x0125:
            boolean r1 = r0 instanceof java.util.ArrayList
            if (r1 == 0) goto L_0x0166
            r11 = r0
            java.util.ArrayList r11 = (java.util.ArrayList) r11
            int r12 = r11.size()
            r13 = 0
        L_0x0131:
            if (r13 >= r12) goto L_0x0165
            java.lang.Object r0 = r11.get(r13)
            boolean r1 = r0 instanceof android.os.Bundle
            if (r1 != 0) goto L_0x0152
            com.google.android.gms.measurement.internal.zzgi r1 = r7.zzs
            com.google.android.gms.measurement.internal.zzey r1 = r1.zzaz()
            com.google.android.gms.measurement.internal.zzew r1 = r1.zzi
            if (r0 == 0) goto L_0x014a
            java.lang.Class r0 = r0.getClass()
            goto L_0x014c
        L_0x014a:
            java.lang.String r0 = "null"
        L_0x014c:
            java.lang.String r2 = "All ArrayList elements must be of type Bundle. Value type, name"
            r1.zzc(r2, r0, r8)
            goto L_0x0166
        L_0x0152:
            r4 = r0
            android.os.Bundle r4 = (android.os.Bundle) r4
            r0 = r14
            r1 = r15
            r2 = r16
            r3 = r17
            r5 = r20
            r6 = r21
            r0.zzW(r1, r2, r3, r4, r5, r6)
            int r13 = r13 + 1
            goto L_0x0131
        L_0x0165:
            return r9
        L_0x0166:
            r0 = 4
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzlp.zza(java.lang.String, java.lang.String, java.lang.String, java.lang.Object, android.os.Bundle, java.util.List, boolean, boolean):int");
    }

    public final void zzaB() {
        zzg();
        SecureRandom secureRandom = new SecureRandom();
        long nextLong = secureRandom.nextLong();
        if (nextLong == 0) {
            nextLong = secureRandom.nextLong();
            if (nextLong == 0) {
                this.zzs.zzaz().zzg.zza("Utils falling back to Random for random id");
            }
        }
        this.zze.set(nextLong);
    }

    public final boolean zzaa(String str, String str2, int i, Object obj) {
        if (obj != null && !(obj instanceof Long) && !(obj instanceof Float) && !(obj instanceof Integer) && !(obj instanceof Byte) && !(obj instanceof Short) && !(obj instanceof Boolean) && !(obj instanceof Double)) {
            if (!(obj instanceof String) && !(obj instanceof Character) && !(obj instanceof CharSequence)) {
                return false;
            }
            String obj2 = obj.toString();
            if (obj2.codePointCount(0, obj2.length()) > i) {
                this.zzs.zzaz().zzi.zzd("Value is too long; discarded. Value kind, name, value length", str, str2, Integer.valueOf(obj2.length()));
                return false;
            }
        }
        return true;
    }

    public final boolean zzab(String str, String str2) {
        if (str2 == null) {
            this.zzs.zzaz().zzf.zzb("Name is required and can't be null. Type", str);
            return false;
        } else if (str2.length() == 0) {
            this.zzs.zzaz().zzf.zzb("Name is required and can't be empty. Type", str);
            return false;
        } else {
            int codePointAt = str2.codePointAt(0);
            if (!Character.isLetter(codePointAt)) {
                if (codePointAt == 95) {
                    codePointAt = 95;
                } else {
                    this.zzs.zzaz().zzf.zzc("Name must start with a letter or _ (underscore). Type, name", str, str2);
                    return false;
                }
            }
            int length = str2.length();
            int charCount = Character.charCount(codePointAt);
            while (charCount < length) {
                int codePointAt2 = str2.codePointAt(charCount);
                if (codePointAt2 == 95 || Character.isLetterOrDigit(codePointAt2)) {
                    charCount += Character.charCount(codePointAt2);
                } else {
                    this.zzs.zzaz().zzf.zzc("Name must consist of letters, digits or _ (underscores). Type, name", str, str2);
                    return false;
                }
            }
            return true;
        }
    }

    public final boolean zzac(String str, String str2) {
        if (str2 == null) {
            this.zzs.zzaz().zzf.zzb("Name is required and can't be null. Type", str);
            return false;
        } else if (str2.length() == 0) {
            this.zzs.zzaz().zzf.zzb("Name is required and can't be empty. Type", str);
            return false;
        } else {
            int codePointAt = str2.codePointAt(0);
            if (!Character.isLetter(codePointAt)) {
                this.zzs.zzaz().zzf.zzc("Name must start with a letter. Type, name", str, str2);
                return false;
            }
            int length = str2.length();
            int charCount = Character.charCount(codePointAt);
            while (charCount < length) {
                int codePointAt2 = str2.codePointAt(charCount);
                if (codePointAt2 == 95 || Character.isLetterOrDigit(codePointAt2)) {
                    charCount += Character.charCount(codePointAt2);
                } else {
                    this.zzs.zzaz().zzf.zzc("Name must consist of letters, digits or _ (underscores). Type, name", str, str2);
                    return false;
                }
            }
            return true;
        }
    }

    public final boolean zzad(String str) {
        zzg();
        if (Wrappers.packageManager(this.zzs.zze).zza.checkCallingOrSelfPermission(str) == 0) {
            return true;
        }
        this.zzs.zzaz().zzk.zzb("Permission not granted", str);
        return false;
    }

    public final boolean zzae(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String zzB = this.zzs.zzk.zzB("debug.firebase.analytics.app", "");
        zzaa zzaa = this.zzs.zzj;
        return zzB.equals(str);
    }

    public final boolean zzaf(Object obj) {
        return (obj instanceof Parcelable[]) || (obj instanceof ArrayList) || (obj instanceof Bundle);
    }

    @VisibleForTesting
    public final boolean zzag(Context context, String str) {
        X500Principal x500Principal = new X500Principal("CN=Android Debug,O=Android,C=US");
        try {
            PackageInfo packageInfo = Wrappers.packageManager(context).zza.getPackageManager().getPackageInfo(str, 64);
            if (!(packageInfo == null || packageInfo.signatures == null || packageInfo.signatures.length <= 0)) {
                return ((X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(packageInfo.signatures[0].toByteArray()))).getSubjectX500Principal().equals(x500Principal);
            }
        } catch (CertificateException e2) {
            this.zzs.zzaz().zzd.zzb("Error obtaining certificate", e2);
        } catch (NameNotFoundException e3) {
            this.zzs.zzaz().zzd.zzb("Package name not found", e3);
        }
        return true;
    }

    public final boolean zzan(String str, String str2, String str3, String str4) {
        boolean isEmpty = TextUtils.isEmpty(str);
        boolean isEmpty2 = TextUtils.isEmpty(str2);
        if (!isEmpty && !isEmpty2) {
            Preconditions.checkNotNull(str);
            return !str.equals(str2);
        } else if (isEmpty && isEmpty2) {
            return (TextUtils.isEmpty(str3) || TextUtils.isEmpty(str4)) ? !TextUtils.isEmpty(str4) : !str3.equals(str4);
        } else {
            if (isEmpty) {
                return TextUtils.isEmpty(str3) || !str3.equals(str4);
            }
            if (TextUtils.isEmpty(str4)) {
                return false;
            }
            return TextUtils.isEmpty(str3) || !str3.equals(str4);
        }
    }

    public final byte[] zzao(Parcelable parcelable) {
        if (parcelable == null) {
            return null;
        }
        Parcel obtain = Parcel.obtain();
        try {
            parcelable.writeToParcel(obtain, 0);
            return obtain.marshall();
        } finally {
            obtain.recycle();
        }
    }

    public final int zzar(String str) {
        if ("_ldl".equals(str)) {
            zzaf zzaf = this.zzs.zzk;
            return 2048;
        } else if ("_id".equals(str)) {
            zzaf zzaf2 = this.zzs.zzk;
            return 256;
        } else if ("_lgclid".equals(str)) {
            zzaf zzaf3 = this.zzs.zzk;
            return 100;
        } else {
            zzaf zzaf4 = this.zzs.zzk;
            return 36;
        }
    }

    public final Object zzas(int i, Object obj, boolean z, boolean z2) {
        if (obj == null) {
            return null;
        }
        if ((obj instanceof Long) || (obj instanceof Double)) {
            return obj;
        }
        if (obj instanceof Integer) {
            return Long.valueOf((long) ((Integer) obj).intValue());
        }
        if (obj instanceof Byte) {
            return Long.valueOf((long) ((Byte) obj).byteValue());
        }
        if (obj instanceof Short) {
            return Long.valueOf((long) ((Short) obj).shortValue());
        }
        if (obj instanceof Boolean) {
            return Long.valueOf(true != ((Boolean) obj).booleanValue() ? 0 : 1);
        } else if (obj instanceof Float) {
            return Double.valueOf(((Float) obj).doubleValue());
        } else {
            if ((obj instanceof String) || (obj instanceof Character) || (obj instanceof CharSequence)) {
                return zzD(obj.toString(), i, z);
            }
            if (!z2 || (!(obj instanceof Bundle[]) && !(obj instanceof Parcelable[]))) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (Parcelable parcelable : (Parcelable[]) obj) {
                if (parcelable instanceof Bundle) {
                    Bundle zzt = zzt((Bundle) parcelable);
                    if (!zzt.isEmpty()) {
                        arrayList.add(zzt);
                    }
                }
            }
            return arrayList.toArray(new Bundle[arrayList.size()]);
        }
    }

    public final int zzd(String str, Object obj) {
        boolean z;
        if ("_ldl".equals(str)) {
            z = zzaa("user property referrer", str, zzar(str), obj);
        } else {
            z = zzaa("user property", str, zzar(str), obj);
        }
        return z ? 0 : 7;
    }

    public final boolean zzf() {
        return true;
    }

    public final int zzh(String str) {
        if (!zzab("event", str)) {
            return 2;
        }
        if (!zzZ("event", zzhf.zza, zzhf.zzb, str)) {
            return 13;
        }
        zzaf zzaf = this.zzs.zzk;
        if (!zzY("event", 40, str)) {
            return 2;
        }
        return 0;
    }

    public final int zzi(String str) {
        if (!zzab("event param", str)) {
            return 3;
        }
        if (!zzZ("event param", null, null, str)) {
            return 14;
        }
        zzaf zzaf = this.zzs.zzk;
        if (!zzY("event param", 40, str)) {
            return 3;
        }
        return 0;
    }

    public final int zzj(String str) {
        if (!zzac("event param", str)) {
            return 3;
        }
        if (!zzZ("event param", null, null, str)) {
            return 14;
        }
        zzaf zzaf = this.zzs.zzk;
        if (!zzY("event param", 40, str)) {
            return 3;
        }
        return 0;
    }

    public final int zzl(String str) {
        if (!zzab("user property", str)) {
            return 6;
        }
        if (!zzZ("user property", zzhh.zza, null, str)) {
            return 15;
        }
        zzaf zzaf = this.zzs.zzk;
        if (!zzY("user property", 24, str)) {
            return 6;
        }
        return 0;
    }

    @EnsuresNonNull({"this.apkVersion"})
    public final int zzm() {
        if (this.zzg == null) {
            GoogleApiAvailabilityLight googleApiAvailabilityLight = GoogleApiAvailabilityLight.zza;
            Context context = this.zzs.zze;
            if (googleApiAvailabilityLight != null) {
                this.zzg = Integer.valueOf(GooglePlayServicesUtilLight.getApkVersion(context) / 1000);
            } else {
                throw null;
            }
        }
        return this.zzg.intValue();
    }

    public final long zzq() {
        long andIncrement;
        long j;
        if (this.zze.get() == 0) {
            synchronized (this.zze) {
                try {
                    long nextLong = new Random(System.nanoTime() ^ this.zzs.zzr.currentTimeMillis()).nextLong();
                    int i = this.zzf + 1;
                    this.zzf = i;
                    j = nextLong + ((long) i);
                }
            }
            return j;
        }
        synchronized (this.zze) {
            try {
                this.zze.compareAndSet(-1, 1);
                andIncrement = this.zze.getAndIncrement();
            }
        }
        return andIncrement;
    }

    public final long zzr(long j, long j2) {
        return ((j2 * 60000) + j) / 86400000;
    }

    public final Bundle zzs(Uri uri, boolean z, boolean z2) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        if (uri != null) {
            try {
                if (uri.isHierarchical()) {
                    str7 = uri.getQueryParameter(SMTNotificationConstants.NOTIF_ATTRIBUTION_UTM_CAMPAIGN);
                    str6 = uri.getQueryParameter(SMTNotificationConstants.NOTIF_ATTRIBUTION_UTM_SOURCE);
                    str5 = uri.getQueryParameter(SMTNotificationConstants.NOTIF_ATTRIBUTION_UTM_MEDIUM);
                    str4 = uri.getQueryParameter("gclid");
                    if (z) {
                        str3 = uri.getQueryParameter("utm_id");
                        str2 = uri.getQueryParameter("dclid");
                    } else {
                        str3 = null;
                        str2 = null;
                    }
                    str = z2 ? uri.getQueryParameter("srsltid") : null;
                } else {
                    str7 = null;
                    str6 = null;
                    str5 = null;
                    str4 = null;
                    str3 = null;
                    str2 = null;
                    str = null;
                }
                if (TextUtils.isEmpty(str7) && TextUtils.isEmpty(str6) && TextUtils.isEmpty(str5) && TextUtils.isEmpty(str4) && ((!z || (TextUtils.isEmpty(str3) && TextUtils.isEmpty(str2))) && (!z2 || TextUtils.isEmpty(str)))) {
                    return null;
                }
                Bundle bundle = new Bundle();
                if (!TextUtils.isEmpty(str7)) {
                    bundle.putString("campaign", str7);
                }
                if (!TextUtils.isEmpty(str6)) {
                    bundle.putString(DefaultSettingsSpiCall.SOURCE_PARAM, str6);
                }
                if (!TextUtils.isEmpty(str5)) {
                    bundle.putString("medium", str5);
                }
                if (!TextUtils.isEmpty(str4)) {
                    bundle.putString("gclid", str4);
                }
                String queryParameter = uri.getQueryParameter("utm_term");
                if (!TextUtils.isEmpty(queryParameter)) {
                    bundle.putString("term", queryParameter);
                }
                String queryParameter2 = uri.getQueryParameter("utm_content");
                if (!TextUtils.isEmpty(queryParameter2)) {
                    bundle.putString("content", queryParameter2);
                }
                String queryParameter3 = uri.getQueryParameter("aclid");
                if (!TextUtils.isEmpty(queryParameter3)) {
                    bundle.putString("aclid", queryParameter3);
                }
                String queryParameter4 = uri.getQueryParameter("cp1");
                if (!TextUtils.isEmpty(queryParameter4)) {
                    bundle.putString("cp1", queryParameter4);
                }
                String queryParameter5 = uri.getQueryParameter("anid");
                if (!TextUtils.isEmpty(queryParameter5)) {
                    bundle.putString("anid", queryParameter5);
                }
                if (z) {
                    if (!TextUtils.isEmpty(str3)) {
                        bundle.putString("campaign_id", str3);
                    }
                    if (!TextUtils.isEmpty(str2)) {
                        bundle.putString("dclid", str2);
                    }
                    String queryParameter6 = uri.getQueryParameter("utm_source_platform");
                    if (!TextUtils.isEmpty(queryParameter6)) {
                        bundle.putString("source_platform", queryParameter6);
                    }
                    String queryParameter7 = uri.getQueryParameter("utm_creative_format");
                    if (!TextUtils.isEmpty(queryParameter7)) {
                        bundle.putString("creative_format", queryParameter7);
                    }
                    String queryParameter8 = uri.getQueryParameter("utm_marketing_tactic");
                    if (!TextUtils.isEmpty(queryParameter8)) {
                        bundle.putString("marketing_tactic", queryParameter8);
                    }
                }
                if (z2 && !TextUtils.isEmpty(str)) {
                    bundle.putString("srsltid", str);
                }
                return bundle;
            } catch (UnsupportedOperationException e2) {
                this.zzs.zzaz().zzg.zzb("Install referrer url isn't a hierarchical URI", e2);
            }
        }
        return null;
    }

    public final Bundle zzt(Bundle bundle) {
        Bundle bundle2 = new Bundle();
        if (bundle != null) {
            for (String str : bundle.keySet()) {
                Object zzA = zzA(str, bundle.get(str));
                if (zzA == null) {
                    this.zzs.zzaz().zzi.zzb("Param value can't be null", this.zzs.zzq.zze(str));
                } else {
                    zzO(bundle2, str, zzA);
                }
            }
        }
        return bundle2;
    }

    public final Bundle zzy(String str, String str2, Bundle bundle, List list, boolean z) {
        int i;
        String str3 = str2;
        Bundle bundle2 = bundle;
        List list2 = list;
        boolean zzat = zzat(str3, zzhf.zzd);
        Bundle bundle3 = new Bundle(bundle2);
        int zzc2 = this.zzs.zzk.zzc();
        Iterator it = new TreeSet(bundle.keySet()).iterator();
        int i2 = 0;
        while (it.hasNext()) {
            String str4 = (String) it.next();
            if (list2 == null || !list2.contains(str4)) {
                i = !z ? zzj(str4) : 0;
                if (i == 0) {
                    i = zzi(str4);
                }
            } else {
                i = 0;
            }
            if (i != 0) {
                zzJ(bundle3, i, str4, i == 3 ? str4 : null);
                bundle3.remove(str4);
            } else {
                String str5 = str4;
                int zza = zza(str, str2, str4, bundle2.get(str4), bundle3, list, z, zzat);
                if (zza == 17) {
                    zzJ(bundle3, 17, str5, Boolean.FALSE);
                } else if (zza != 0 && !"_ev".equals(str5)) {
                    zzJ(bundle3, zza, zza == 21 ? str3 : str5, bundle2.get(str5));
                    bundle3.remove(str5);
                }
                if (zzai(str5)) {
                    int i3 = i2 + 1;
                    if (i3 > zzc2) {
                        this.zzs.zzaz().zzf.zzc(GeneratedOutlineSupport.outline74("Event can't contain more than ", zzc2, " params").toString(), this.zzs.zzq.zzd(str3), this.zzs.zzq.zzb(bundle2));
                        zzap(bundle3, 5);
                        bundle3.remove(str5);
                    }
                    i2 = i3;
                }
            }
            list2 = list;
        }
        return bundle3;
    }

    public final zzav zzz(String str, String str2, Bundle bundle, String str3, long j, boolean z, boolean z2) {
        Bundle bundle2;
        if (TextUtils.isEmpty(str2)) {
            return null;
        }
        if (zzh(str2) == 0) {
            if (bundle != null) {
                bundle2 = new Bundle(bundle);
            } else {
                bundle2 = new Bundle();
            }
            Bundle bundle3 = bundle2;
            bundle3.putString(CrashlyticsAnalyticsListener.EVENT_ORIGIN_KEY, str3);
            Bundle zzy = zzy(str, str2, bundle3, Collections.singletonList(CrashlyticsAnalyticsListener.EVENT_ORIGIN_KEY), true);
            if (z) {
                zzy = zzt(zzy);
            }
            Preconditions.checkNotNull(zzy);
            zzav zzav = new zzav(str2, new zzat(zzy), str3, j);
            return zzav;
        }
        this.zzs.zzaz().zzd.zzb("Invalid conditional property event name", this.zzs.zzq.zzf(str2));
        throw new IllegalArgumentException();
    }
}
