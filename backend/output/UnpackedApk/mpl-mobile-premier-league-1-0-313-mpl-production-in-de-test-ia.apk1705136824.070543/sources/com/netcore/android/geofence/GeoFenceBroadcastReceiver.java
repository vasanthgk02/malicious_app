package com.netcore.android.geofence;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.google.android.gms.location.Geofence;
import com.google.android.gms.location.GeofencingEvent;
import com.netcore.android.SMTConfigConstants;
import com.netcore.android.geofence.f.a.C0007a;
import com.netcore.android.logger.SMTLogger;
import com.netcore.android.preference.SMTPreferenceConstants;
import com.netcore.android.preference.SMTPreferenceHelper;
import com.netcore.android.preference.SMTPreferenceHelper.Companion;
import com.netcore.android.utility.SMTCommonUtility;
import com.twitter.sdk.android.tweetui.TweetUtils;
import com.userexperior.models.recording.enums.UeCustomType;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0013\u0010\u0014J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ#\u0010\u000b\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\u000b\u0010\fR!\u0010\u0012\u001a\n \u000e*\u0004\u0018\u00010\r0\r8\u0006@\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0015"}, d2 = {"Lcom/netcore/android/geofence/GeoFenceBroadcastReceiver;", "Landroid/content/BroadcastReceiver;", "Landroid/content/Context;", "context", "Lcom/netcore/android/geofence/f$a$a;", "type", "", "a", "(Landroid/content/Context;Lcom/netcore/android/geofence/f$a$a;)V", "Landroid/content/Intent;", "intent", "onReceive", "(Landroid/content/Context;Landroid/content/Intent;)V", "", "kotlin.jvm.PlatformType", "Ljava/lang/String;", "getTAG", "()Ljava/lang/String;", "TAG", "<init>", "()V", "smartech_release"}, k = 1, mv = {1, 4, 1})
/* compiled from: GeoFenceBroadcastReceiver.kt */
public final class GeoFenceBroadcastReceiver extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    public final String f1094a = GeoFenceBroadcastReceiver.class.getSimpleName();

    private final void a(Context context, C0007a aVar) {
        SMTLogger sMTLogger = SMTLogger.INSTANCE;
        String str = this.f1094a;
        StringBuilder outline79 = GeneratedOutlineSupport.outline79(str, UeCustomType.TAG, "IS_GEOFECE_ENABLED: ");
        Companion companion = SMTPreferenceHelper.Companion;
        outline79.append(companion.getAppPreferenceInstance(context, null).getBoolean(SMTPreferenceConstants.IS_GEOFECE_ENABLED));
        sMTLogger.i(str, outline79.toString());
        if (companion.getAppPreferenceInstance(context, null).getBoolean(SMTPreferenceConstants.IS_GEOFECE_ENABLED)) {
            String str2 = this.f1094a;
            StringBuilder outline792 = GeneratedOutlineSupport.outline79(str2, UeCustomType.TAG, "");
            SMTCommonUtility sMTCommonUtility = SMTCommonUtility.INSTANCE;
            outline792.append(sMTCommonUtility.shouldCheckPermission$smartech_release());
            outline792.append("isPermissionGranted: ");
            outline792.append(sMTCommonUtility.isPermissionGranted$smartech_release(context, SMTConfigConstants.LOCATION_PERMISSION_MF_KEY));
            sMTLogger.i(str2, outline792.toString());
            if (!sMTCommonUtility.shouldCheckPermission$smartech_release() || sMTCommonUtility.isPermissionGranted$smartech_release(context, SMTConfigConstants.LOCATION_PERMISSION_MF_KEY)) {
                String str3 = this.f1094a;
                Intrinsics.checkNotNullExpressionValue(str3, UeCustomType.TAG);
                sMTLogger.i(str3, "ReRegisterSystemFence");
                d b2 = d.o.b(new WeakReference(context));
                b2.b((List<String>) TweetUtils.arrayListOf(aVar.getValue()));
                b2.c((List<? extends C0007a>) TweetUtils.arrayListOf(aVar));
            }
        }
    }

    public void onReceive(Context context, Intent intent) {
        SMTLogger sMTLogger = SMTLogger.INSTANCE;
        String str = this.f1094a;
        Intrinsics.checkNotNullExpressionValue(str, UeCustomType.TAG);
        sMTLogger.i(str, "GeoFenceBroadcastReceiver");
        if (context != null) {
            try {
                Companion companion = SMTPreferenceHelper.Companion;
                if (companion.getAppPreferenceInstance(context, null).getBoolean(SMTPreferenceConstants.IS_GEOFECE_ENABLED)) {
                    GeofencingEvent fromIntent = GeofencingEvent.fromIntent(intent);
                    Intrinsics.checkNotNullExpressionValue(fromIntent, "GeofencingEvent.fromIntent(intent)");
                    if (fromIntent.zza != -1) {
                        if (fromIntent.zza == 1000) {
                            companion.getAppPreferenceInstance(context, null).setArray("Registred_GeoFences", new ArrayList());
                        }
                        String str2 = this.f1094a;
                        Intrinsics.checkNotNullExpressionValue(str2, UeCustomType.TAG);
                        sMTLogger.e(str2, "Error in geofence broadcast");
                        return;
                    }
                    ArrayList arrayList = new ArrayList();
                    d b2 = d.o.b(new WeakReference(context));
                    List<Geofence> list = fromIntent.zzc;
                    if (list != null) {
                        for (Geofence geofence : list) {
                            SMTLogger sMTLogger2 = SMTLogger.INSTANCE;
                            String str3 = this.f1094a;
                            Intrinsics.checkNotNullExpressionValue(str3, UeCustomType.TAG);
                            StringBuilder sb = new StringBuilder();
                            Intrinsics.checkNotNullExpressionValue(geofence, "geofence");
                            sb.append(geofence.getRequestId());
                            sb.append(" GeofenceTransition: ");
                            sb.append(fromIntent.zzb);
                            sMTLogger2.i(str3, sb.toString());
                            String requestId = geofence.getRequestId();
                            C0007a aVar = C0007a.UPDATE_FROM_SERVER;
                            if (!Intrinsics.areEqual(requestId, aVar.getValue())) {
                                C0007a aVar2 = C0007a.UPDATE_FROM_LOCAL;
                                if (!Intrinsics.areEqual(requestId, aVar2.getValue())) {
                                    arrayList.add(geofence);
                                } else if (fromIntent.zzb == 2) {
                                    a(context, aVar2);
                                    b2.f();
                                } else {
                                    String str4 = this.f1094a;
                                    Intrinsics.checkNotNullExpressionValue(str4, UeCustomType.TAG);
                                    sMTLogger2.e(str4, "SyncWithLocalDB else block");
                                }
                            } else if (fromIntent.zzb == 2) {
                                a(context, aVar);
                                d.a(b2, (Integer) null, 1, (Object) null);
                            } else {
                                String str5 = this.f1094a;
                                Intrinsics.checkNotNullExpressionValue(str5, UeCustomType.TAG);
                                sMTLogger2.e(str5, "SyncWithServer else block");
                            }
                        }
                    }
                    SMTLogger sMTLogger3 = SMTLogger.INSTANCE;
                    String str6 = this.f1094a;
                    Intrinsics.checkNotNullExpressionValue(str6, UeCustomType.TAG);
                    sMTLogger3.i(str6, "triggeredGeofences: " + arrayList);
                    if (!arrayList.isEmpty()) {
                        int i = fromIntent.zzb;
                        String str7 = this.f1094a;
                        Intrinsics.checkNotNullExpressionValue(str7, UeCustomType.TAG);
                        sMTLogger3.i(str7, "geoFenceTransition: " + i);
                        if (i == 1) {
                            a.f1096d.b(context).b(arrayList);
                        } else if (i == 2) {
                            a.f1096d.b(context).c(arrayList);
                        } else if (i != 4) {
                            String str8 = this.f1094a;
                            Intrinsics.checkNotNullExpressionValue(str8, UeCustomType.TAG);
                            sMTLogger3.i(str8, "Geofence transition not matched.");
                        } else {
                            a.f1096d.b(context).a((List<? extends Geofence>) arrayList);
                        }
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }
}
