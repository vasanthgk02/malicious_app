package com.google.firebase.analytics.connector;

import android.os.Bundle;
import com.facebook.drawee.backends.pipeline.info.ImageOriginUtils;
import com.facebook.react.modules.appstate.AppStateModule;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.firebase.analytics.connector.AnalyticsConnector.AnalyticsConnectorHandle;
import com.google.firebase.analytics.connector.AnalyticsConnector.AnalyticsConnectorListener;
import com.google.firebase.analytics.connector.AnalyticsConnector.ConditionalUserProperty;
import com.google.firebase.analytics.connector.internal.zzc;
import com.google.firebase.analytics.connector.internal.zze;
import com.google.firebase.analytics.connector.internal.zzg;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: com.google.android.gms:play-services-measurement-api@@20.1.2 */
public class AnalyticsConnectorImpl implements AnalyticsConnector {
    public static volatile AnalyticsConnector zzc;
    @VisibleForTesting
    public final AppMeasurementSdk zza;
    @VisibleForTesting
    public final Map zzb = new ConcurrentHashMap();

    public AnalyticsConnectorImpl(AppMeasurementSdk appMeasurementSdk) {
        Preconditions.checkNotNull(appMeasurementSdk);
        this.zza = appMeasurementSdk;
    }

    @KeepForSdk
    public void clearConditionalUserProperty(String str, String str2, Bundle bundle) {
        this.zza.zza.zzv(str, null, null);
    }

    @KeepForSdk
    public List<ConditionalUserProperty> getConditionalUserProperties(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        for (Bundle zzb2 : this.zza.zza.zzp(str, str2)) {
            arrayList.add(zzc.zzb(zzb2));
        }
        return arrayList;
    }

    @KeepForSdk
    public int getMaxUserProperties(String str) {
        return this.zza.zza.zza(str);
    }

    @KeepForSdk
    public Map<String, Object> getUserProperties(boolean z) {
        return this.zza.zza.zzq(null, null, z);
    }

    @KeepForSdk
    public void logEvent(String str, String str2, Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        if (zzc.zzl(str) && zzc.zzj(str2, bundle) && zzc.zzh(str, str2, bundle)) {
            if ("clx".equals(str) && "_ae".equals(str2)) {
                bundle.putLong("_r", 1);
            }
            this.zza.zza.zzy(str, str2, bundle);
        }
    }

    @KeepForSdk
    public AnalyticsConnectorHandle registerAnalyticsConnectorListener(String str, AnalyticsConnectorListener analyticsConnectorListener) {
        Object obj;
        Preconditions.checkNotNull(analyticsConnectorListener);
        if (!zzc.zzl(str)) {
            return null;
        }
        if (!str.isEmpty() && this.zzb.containsKey(str) && this.zzb.get(str) != null) {
            return null;
        }
        AppMeasurementSdk appMeasurementSdk = this.zza;
        if ("fiam".equals(str)) {
            obj = new zze(appMeasurementSdk, analyticsConnectorListener);
        } else if ("crash".equals(str) || "clx".equals(str)) {
            obj = new zzg(appMeasurementSdk, analyticsConnectorListener);
        } else {
            obj = null;
        }
        if (obj == null) {
            return null;
        }
        this.zzb.put(str, obj);
        return new AnalyticsConnectorHandle(this, str) {
        };
    }

    @KeepForSdk
    public void setConditionalUserProperty(ConditionalUserProperty conditionalUserProperty) {
        if (zzc.zzi(conditionalUserProperty)) {
            AppMeasurementSdk appMeasurementSdk = this.zza;
            Bundle bundle = new Bundle();
            String str = conditionalUserProperty.origin;
            if (str != null) {
                bundle.putString("origin", str);
            }
            String str2 = conditionalUserProperty.name;
            if (str2 != null) {
                bundle.putString("name", str2);
            }
            Object obj = conditionalUserProperty.value;
            if (obj != null) {
                ImageOriginUtils.zzb(bundle, obj);
            }
            String str3 = conditionalUserProperty.triggerEventName;
            if (str3 != null) {
                bundle.putString("trigger_event_name", str3);
            }
            bundle.putLong("trigger_timeout", conditionalUserProperty.triggerTimeout);
            String str4 = conditionalUserProperty.timedOutEventName;
            if (str4 != null) {
                bundle.putString("timed_out_event_name", str4);
            }
            Bundle bundle2 = conditionalUserProperty.timedOutEventParams;
            if (bundle2 != null) {
                bundle.putBundle("timed_out_event_params", bundle2);
            }
            String str5 = conditionalUserProperty.triggeredEventName;
            if (str5 != null) {
                bundle.putString("triggered_event_name", str5);
            }
            Bundle bundle3 = conditionalUserProperty.triggeredEventParams;
            if (bundle3 != null) {
                bundle.putBundle("triggered_event_params", bundle3);
            }
            bundle.putLong("time_to_live", conditionalUserProperty.timeToLive);
            String str6 = conditionalUserProperty.expiredEventName;
            if (str6 != null) {
                bundle.putString("expired_event_name", str6);
            }
            Bundle bundle4 = conditionalUserProperty.expiredEventParams;
            if (bundle4 != null) {
                bundle.putBundle("expired_event_params", bundle4);
            }
            bundle.putLong("creation_timestamp", conditionalUserProperty.creationTimestamp);
            bundle.putBoolean(AppStateModule.APP_STATE_ACTIVE, conditionalUserProperty.active);
            bundle.putLong("triggered_timestamp", conditionalUserProperty.triggeredTimestamp);
            appMeasurementSdk.zza.zzD(bundle);
        }
    }

    @KeepForSdk
    public void setUserProperty(String str, String str2, Object obj) {
        if (zzc.zzl(str) && zzc.zzm(str, str2)) {
            this.zza.zza.zzN(str, str2, obj, true);
        }
    }
}
