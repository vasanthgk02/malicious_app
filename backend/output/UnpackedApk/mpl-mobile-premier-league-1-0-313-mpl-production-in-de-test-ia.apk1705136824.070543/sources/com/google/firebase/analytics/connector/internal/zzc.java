package com.google.firebase.analytics.connector.internal;

import android.os.Bundle;
import com.facebook.drawee.backends.pipeline.info.ImageOriginUtils;
import com.facebook.react.modules.appstate.AppStateModule;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.measurement.internal.zzhf;
import com.google.android.gms.measurement.internal.zzhh;
import com.google.firebase.analytics.connector.AnalyticsConnector.ConditionalUserProperty;
import io.hansel.core.criteria.HSLCriteriaBuilder;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-measurement-api@@20.1.2 */
public final class zzc {
    public static final Set zza = new HashSet(Arrays.asList(new String[]{"_in", "_xa", "_xu", "_aq", "_aa", "_ai", "_ac", "campaign_details", "_ug", "_iapx", "_exp_set", "_exp_clear", "_exp_activate", "_exp_timeout", "_exp_expire"}));
    public static final List zzb = Arrays.asList(new String[]{"_e", "_f", "_iap", "_s", "_au", "_ui", "_cd"});
    public static final List zzc = Arrays.asList(new String[]{"auto", "app", "am"});
    public static final List zzd = Arrays.asList(new String[]{"_r", "_dbg"});
    public static final List zze;
    public static final List zzf = Arrays.asList(new String[]{"^_ltv_[A-Z]{3}$", "^_cc[1-5]{1}$"});

    static {
        String[][] strArr = {zzhh.zza, zzhh.zzb};
        int i = 0;
        for (int i2 = 0; i2 < 2; i2++) {
            i += strArr[i2].length;
        }
        Object[] copyOf = Arrays.copyOf(strArr[0], i);
        int length = strArr[0].length;
        for (int i3 = 1; i3 < 2; i3++) {
            String[] strArr2 = strArr[i3];
            int length2 = strArr2.length;
            System.arraycopy(strArr2, 0, copyOf, length, length2);
            length += length2;
        }
        zze = Arrays.asList((String[]) copyOf);
    }

    public static ConditionalUserProperty zzb(Bundle bundle) {
        Class<Long> cls = Long.class;
        Class<String> cls2 = String.class;
        Preconditions.checkNotNull(bundle);
        ConditionalUserProperty conditionalUserProperty = new ConditionalUserProperty();
        String str = (String) ImageOriginUtils.zza(bundle, "origin", cls2, null);
        Preconditions.checkNotNull(str);
        conditionalUserProperty.origin = str;
        String str2 = (String) ImageOriginUtils.zza(bundle, "name", cls2, null);
        Preconditions.checkNotNull(str2);
        conditionalUserProperty.name = str2;
        conditionalUserProperty.value = ImageOriginUtils.zza(bundle, HSLCriteriaBuilder.VALUE, Object.class, null);
        conditionalUserProperty.triggerEventName = (String) ImageOriginUtils.zza(bundle, "trigger_event_name", cls2, null);
        Long valueOf = Long.valueOf(0);
        conditionalUserProperty.triggerTimeout = ((Long) ImageOriginUtils.zza(bundle, "trigger_timeout", cls, valueOf)).longValue();
        conditionalUserProperty.timedOutEventName = (String) ImageOriginUtils.zza(bundle, "timed_out_event_name", cls2, null);
        conditionalUserProperty.timedOutEventParams = (Bundle) ImageOriginUtils.zza(bundle, "timed_out_event_params", Bundle.class, null);
        conditionalUserProperty.triggeredEventName = (String) ImageOriginUtils.zza(bundle, "triggered_event_name", cls2, null);
        conditionalUserProperty.triggeredEventParams = (Bundle) ImageOriginUtils.zza(bundle, "triggered_event_params", Bundle.class, null);
        conditionalUserProperty.timeToLive = ((Long) ImageOriginUtils.zza(bundle, "time_to_live", cls, valueOf)).longValue();
        conditionalUserProperty.expiredEventName = (String) ImageOriginUtils.zza(bundle, "expired_event_name", cls2, null);
        conditionalUserProperty.expiredEventParams = (Bundle) ImageOriginUtils.zza(bundle, "expired_event_params", Bundle.class, null);
        conditionalUserProperty.active = ((Boolean) ImageOriginUtils.zza(bundle, AppStateModule.APP_STATE_ACTIVE, Boolean.class, Boolean.FALSE)).booleanValue();
        conditionalUserProperty.creationTimestamp = ((Long) ImageOriginUtils.zza(bundle, "creation_timestamp", cls, valueOf)).longValue();
        conditionalUserProperty.triggeredTimestamp = ((Long) ImageOriginUtils.zza(bundle, "triggered_timestamp", cls, valueOf)).longValue();
        return conditionalUserProperty;
    }

    public static String zzc(String str) {
        String zza2 = zzhf.zza(str);
        return zza2 != null ? zza2 : str;
    }

    /* JADX WARNING: Removed duplicated region for block: B:32:0x0066  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0077  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean zzh(java.lang.String r4, java.lang.String r5, android.os.Bundle r6) {
        /*
            java.lang.String r0 = "_cmp"
            boolean r5 = r0.equals(r5)
            r0 = 1
            if (r5 != 0) goto L_0x000a
            return r0
        L_0x000a:
            boolean r5 = zzl(r4)
            r1 = 0
            if (r5 != 0) goto L_0x0012
            return r1
        L_0x0012:
            if (r6 != 0) goto L_0x0015
            return r1
        L_0x0015:
            java.util.List r5 = zzd
            java.util.Iterator r5 = r5.iterator()
        L_0x001b:
            boolean r2 = r5.hasNext()
            if (r2 == 0) goto L_0x002e
            java.lang.Object r2 = r5.next()
            java.lang.String r2 = (java.lang.String) r2
            boolean r2 = r6.containsKey(r2)
            if (r2 == 0) goto L_0x001b
            return r1
        L_0x002e:
            int r5 = r4.hashCode()
            r2 = 101200(0x18b50, float:1.41811E-40)
            r3 = 2
            if (r5 == r2) goto L_0x0057
            r2 = 101230(0x18b6e, float:1.41853E-40)
            if (r5 == r2) goto L_0x004d
            r2 = 3142703(0x2ff42f, float:4.403865E-39)
            if (r5 == r2) goto L_0x0043
            goto L_0x0061
        L_0x0043:
            java.lang.String r5 = "fiam"
            boolean r4 = r4.equals(r5)
            if (r4 == 0) goto L_0x0061
            r4 = 2
            goto L_0x0062
        L_0x004d:
            java.lang.String r5 = "fdl"
            boolean r4 = r4.equals(r5)
            if (r4 == 0) goto L_0x0061
            r4 = 1
            goto L_0x0062
        L_0x0057:
            java.lang.String r5 = "fcm"
            boolean r4 = r4.equals(r5)
            if (r4 == 0) goto L_0x0061
            r4 = 0
            goto L_0x0062
        L_0x0061:
            r4 = -1
        L_0x0062:
            java.lang.String r5 = "_cis"
            if (r4 == 0) goto L_0x0077
            if (r4 == r0) goto L_0x0071
            if (r4 == r3) goto L_0x006b
            return r1
        L_0x006b:
            java.lang.String r4 = "fiam_integration"
            r6.putString(r5, r4)
            return r0
        L_0x0071:
            java.lang.String r4 = "fdl_integration"
            r6.putString(r5, r4)
            return r0
        L_0x0077:
            java.lang.String r4 = "fcm_integration"
            r6.putString(r5, r4)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.analytics.connector.internal.zzc.zzh(java.lang.String, java.lang.String, android.os.Bundle):boolean");
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x004d A[Catch:{ IOException | ClassNotFoundException -> 0x0056, IOException | ClassNotFoundException -> 0x0056 }] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0052 A[Catch:{ IOException | ClassNotFoundException -> 0x0056, IOException | ClassNotFoundException -> 0x0056 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean zzi(com.google.firebase.analytics.connector.AnalyticsConnector.ConditionalUserProperty r7) {
        /*
            r0 = 0
            if (r7 != 0) goto L_0x0004
            return r0
        L_0x0004:
            java.lang.String r1 = r7.origin
            if (r1 == 0) goto L_0x00b6
            boolean r2 = r1.isEmpty()
            if (r2 == 0) goto L_0x0010
            goto L_0x00b6
        L_0x0010:
            java.lang.Object r2 = r7.value
            if (r2 == 0) goto L_0x005a
            r3 = 0
            if (r2 == 0) goto L_0x0056
            java.io.ByteArrayOutputStream r4 = new java.io.ByteArrayOutputStream     // Catch:{ all -> 0x0047 }
            r4.<init>()     // Catch:{ all -> 0x0047 }
            java.io.ObjectOutputStream r5 = new java.io.ObjectOutputStream     // Catch:{ all -> 0x0047 }
            r5.<init>(r4)     // Catch:{ all -> 0x0047 }
            r5.writeObject(r2)     // Catch:{ all -> 0x0043 }
            r5.flush()     // Catch:{ all -> 0x0043 }
            java.io.ObjectInputStream r2 = new java.io.ObjectInputStream     // Catch:{ all -> 0x0043 }
            java.io.ByteArrayInputStream r6 = new java.io.ByteArrayInputStream     // Catch:{ all -> 0x0043 }
            byte[] r4 = r4.toByteArray()     // Catch:{ all -> 0x0043 }
            r6.<init>(r4)     // Catch:{ all -> 0x0043 }
            r2.<init>(r6)     // Catch:{ all -> 0x0043 }
            java.lang.Object r4 = r2.readObject()     // Catch:{ all -> 0x0041 }
            r5.close()     // Catch:{ IOException | ClassNotFoundException -> 0x0056 }
            r2.close()     // Catch:{ IOException | ClassNotFoundException -> 0x0056 }
            r3 = r4
            goto L_0x0056
        L_0x0041:
            r4 = move-exception
            goto L_0x004b
        L_0x0043:
            r2 = move-exception
            r4 = r2
            r2 = r3
            goto L_0x004b
        L_0x0047:
            r2 = move-exception
            r4 = r2
            r2 = r3
            r5 = r2
        L_0x004b:
            if (r5 == 0) goto L_0x0050
            r5.close()     // Catch:{ IOException | ClassNotFoundException -> 0x0056 }
        L_0x0050:
            if (r2 == 0) goto L_0x0055
            r2.close()     // Catch:{ IOException | ClassNotFoundException -> 0x0056 }
        L_0x0055:
            throw r4     // Catch:{ IOException | ClassNotFoundException -> 0x0056 }
        L_0x0056:
            if (r3 == 0) goto L_0x0059
            goto L_0x005a
        L_0x0059:
            return r0
        L_0x005a:
            boolean r2 = zzl(r1)
            if (r2 != 0) goto L_0x0061
            return r0
        L_0x0061:
            java.lang.String r2 = r7.name
            boolean r2 = zzm(r1, r2)
            if (r2 != 0) goto L_0x006a
            return r0
        L_0x006a:
            java.lang.String r2 = r7.expiredEventName
            if (r2 == 0) goto L_0x0083
            android.os.Bundle r3 = r7.expiredEventParams
            boolean r2 = zzj(r2, r3)
            if (r2 != 0) goto L_0x0077
            return r0
        L_0x0077:
            java.lang.String r2 = r7.expiredEventName
            android.os.Bundle r3 = r7.expiredEventParams
            boolean r2 = zzh(r1, r2, r3)
            if (r2 == 0) goto L_0x0082
            goto L_0x0083
        L_0x0082:
            return r0
        L_0x0083:
            java.lang.String r2 = r7.triggeredEventName
            if (r2 == 0) goto L_0x009c
            android.os.Bundle r3 = r7.triggeredEventParams
            boolean r2 = zzj(r2, r3)
            if (r2 != 0) goto L_0x0090
            return r0
        L_0x0090:
            java.lang.String r2 = r7.triggeredEventName
            android.os.Bundle r3 = r7.triggeredEventParams
            boolean r2 = zzh(r1, r2, r3)
            if (r2 == 0) goto L_0x009b
            goto L_0x009c
        L_0x009b:
            return r0
        L_0x009c:
            java.lang.String r2 = r7.timedOutEventName
            if (r2 == 0) goto L_0x00b4
            android.os.Bundle r3 = r7.timedOutEventParams
            boolean r2 = zzj(r2, r3)
            if (r2 != 0) goto L_0x00a9
            return r0
        L_0x00a9:
            java.lang.String r2 = r7.timedOutEventName
            android.os.Bundle r7 = r7.timedOutEventParams
            boolean r7 = zzh(r1, r2, r7)
            if (r7 != 0) goto L_0x00b4
            return r0
        L_0x00b4:
            r7 = 1
            return r7
        L_0x00b6:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.analytics.connector.internal.zzc.zzi(com.google.firebase.analytics.connector.AnalyticsConnector$ConditionalUserProperty):boolean");
    }

    public static boolean zzj(String str, Bundle bundle) {
        if (zzb.contains(str)) {
            return false;
        }
        if (bundle != null) {
            for (String containsKey : zzd) {
                if (bundle.containsKey(containsKey)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean zzl(String str) {
        return !zzc.contains(str);
    }

    public static boolean zzm(String str, String str2) {
        if ("_ce1".equals(str2) || "_ce2".equals(str2)) {
            return str.equals("fcm") || str.equals("frc");
        }
        if ("_ln".equals(str2)) {
            return str.equals("fcm") || str.equals("fiam");
        }
        if (zze.contains(str2)) {
            return false;
        }
        for (String matches : zzf) {
            if (str2.matches(matches)) {
                return false;
            }
        }
        return true;
    }
}
