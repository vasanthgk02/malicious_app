package com.google.android.gms.measurement.internal;

import android.content.Intent;
import android.content.SharedPreferences.Editor;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.netcore.android.notification.SMTNotificationConstants;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
import sfs2x.client.requests.BaseRequest;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@20.1.2 */
public final /* synthetic */ class zzip implements Runnable {
    public final /* synthetic */ zziq zza;
    public final /* synthetic */ int zzb;
    public final /* synthetic */ Exception zzc;
    public final /* synthetic */ byte[] zzd;
    public final /* synthetic */ Map zze;

    public /* synthetic */ zzip(zziq zziq, int i, Exception exc, byte[] bArr, Map map) {
        this.zza = zziq;
        this.zzb = i;
        this.zzc = exc;
        this.zzd = bArr;
        this.zze = map;
    }

    public final void run() {
        zziq zziq = this.zza;
        int i = this.zzb;
        Exception exc = this.zzc;
        byte[] bArr = this.zzd;
        zzgi zzgi = zziq.zzd.zza;
        if (!(i == 200 || i == 204)) {
            if (i == 304) {
                i = BaseRequest.JoinRoomInvite;
            }
            zzgi.zzaz().zzg.zzc("Network Request for Deferred Deep Link failed. response, exception", Integer.valueOf(i), exc);
        }
        if (exc == null) {
            zzgi.zzm().zzm.zza(true);
            if (bArr == null || bArr.length == 0) {
                zzgi.zzaz().zzk.zza("Deferred Deep Link response empty.");
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject(new String(bArr));
                String optString = jSONObject.optString(SMTNotificationConstants.NOTIF_DEEPLINK_KEY, "");
                String optString2 = jSONObject.optString("gclid", "");
                double optDouble = jSONObject.optDouble("timestamp", 0.0d);
                if (TextUtils.isEmpty(optString)) {
                    zzgi.zzaz().zzk.zza("Deferred Deep Link is empty.");
                    return;
                }
                zzlp zzv = zzgi.zzv();
                zzgi zzgi2 = zzv.zzs;
                if (!TextUtils.isEmpty(optString)) {
                    List<ResolveInfo> queryIntentActivities = zzv.zzs.zze.getPackageManager().queryIntentActivities(new Intent("android.intent.action.VIEW", Uri.parse(optString)), 0);
                    if (queryIntentActivities != null && !queryIntentActivities.isEmpty()) {
                        Bundle bundle = new Bundle();
                        bundle.putString("gclid", optString2);
                        bundle.putString("_cis", "ddp");
                        zzgi.zzt.zzH("auto", "_cmp", bundle);
                        zzlp zzv2 = zzgi.zzv();
                        if (!TextUtils.isEmpty(optString)) {
                            try {
                                Editor edit = zzv2.zzs.zze.getSharedPreferences("google.analytics.deferred.deeplink.prefs", 0).edit();
                                edit.putString(SMTNotificationConstants.NOTIF_DEEPLINK_KEY, optString);
                                edit.putLong("timestamp", Double.doubleToRawLongBits(optDouble));
                                if (edit.commit()) {
                                    zzv2.zzs.zze.sendBroadcast(new Intent("android.google.analytics.action.DEEPLINK_ACTION"));
                                    return;
                                }
                                return;
                            } catch (RuntimeException e2) {
                                zzv2.zzs.zzaz().zzd.zzb("Failed to persist Deferred Deep Link. exception", e2);
                                return;
                            }
                        } else {
                            return;
                        }
                    }
                }
                zzgi.zzaz().zzg.zzc("Deferred Deep Link validation failed. gclid, deep link", optString2, optString);
                return;
            } catch (JSONException e3) {
                zzgi.zzaz().zzd.zzb("Failed to parse the Deferred Deep Link response. exception", e3);
                return;
            }
        }
        zzgi.zzaz().zzg.zzc("Network Request for Deferred Deep Link failed. response, exception", Integer.valueOf(i), exc);
    }
}
