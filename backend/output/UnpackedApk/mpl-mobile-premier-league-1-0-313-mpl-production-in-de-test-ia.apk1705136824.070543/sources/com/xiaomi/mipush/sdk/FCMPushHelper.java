package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import android.util.Base64;
import com.mpl.androidapp.onesignal.OneSingnalConstant;
import com.xiaomi.channel.commonutils.android.f;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.cz;
import com.xiaomi.push.dq;
import com.xiaomi.push.dx;
import com.xiaomi.push.ee;
import com.xiaomi.push.service.v;
import java.util.HashMap;
import java.util.Map;

public class FCMPushHelper {
    public static Map<String, String> a(Context context) {
        HashMap hashMap = new HashMap();
        hashMap.put(OneSingnalConstant.PARAM_ACTION_TYPE, String.valueOf(cz.AckMessage.a()));
        hashMap.put("deviceStatus", String.valueOf(ee.a(context, context.getPackageName())));
        hashMap.put("isMIUI", String.valueOf(f.a()));
        hashMap.put("mat", Long.toString(System.currentTimeMillis()));
        return hashMap;
    }

    public static void a(Context context, dq dqVar) {
        try {
            MiPushMessage generateMessage = PushMessageHelper.generateMessage((dx) aa.a(context, dqVar), dqVar.a(), false);
            PushMessageReceiver a2 = g.a(context);
            if (a2 != null) {
                a2.onNotificationMessageArrived(context, generateMessage);
            }
        } catch (Throwable th) {
            b.a((String) "fcm broadcast notification come error ", th);
        }
    }

    /* JADX WARNING: type inference failed for: r4v0, types: [boolean] */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r4v0, types: [boolean]
      assigns: [java.util.Map<java.lang.String, java.lang.String>]
      uses: [boolean, ?[int, boolean, OBJECT, ARRAY, byte, short, char]]
      mth insns count: 46
    	at jadx.core.dex.visitors.typeinference.TypeSearch.fillTypeCandidates(TypeSearch.java:237)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
    	at jadx.core.dex.visitors.typeinference.TypeSearch.run(TypeSearch.java:53)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runMultiVariableSearch(TypeInferenceVisitor.java:104)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:97)
     */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x008a  */
    /* JADX WARNING: Removed duplicated region for block: B:17:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(android.content.Context r7, byte[] r8) {
        /*
            com.xiaomi.mipush.sdk.ag r0 = com.xiaomi.mipush.sdk.ag.a(r7)
            boolean r0 = r0.a()
            java.lang.String r1 = r7.getPackageName()
            java.lang.String r2 = "com.xiaomi.xmsf"
            boolean r1 = r2.equals(r1)
            r3 = 1
            r1 = r1 ^ r3
            boolean r4 = a(r7)
            r5 = 2
            r6 = 0
            if (r0 == 0) goto L_0x0069
            if (r1 == 0) goto L_0x0069
            if (r4 == 0) goto L_0x0069
            com.xiaomi.mipush.sdk.a r0 = com.xiaomi.mipush.sdk.a.a(r7)
            java.lang.String r0 = r0.d()
            byte[] r8 = com.xiaomi.push.service.m.a(r8, r0)
            if (r8 != 0) goto L_0x0031
            java.lang.String r0 = "fcm message encrypt failed"
            goto L_0x0085
        L_0x0031:
            java.lang.String r0 = android.util.Base64.encodeToString(r8, r5)
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            if (r1 == 0) goto L_0x0042
            java.lang.String r0 = "fcm message buf base64 encode failed"
            com.xiaomi.channel.commonutils.logger.b.a(r0)
            r3 = 0
            goto L_0x0067
        L_0x0042:
            android.content.Intent r1 = new android.content.Intent
            java.lang.String r4 = com.xiaomi.push.service.bd.n
            r1.<init>(r4)
            r1.setPackage(r2)
            java.lang.String r4 = "com.xiaomi.push.service.XMPushService"
            r1.setClassName(r2, r4)
            java.lang.String r2 = "ext_fcm_container_buffer"
            r1.putExtra(r2, r0)
            java.lang.String r0 = r7.getPackageName()
            java.lang.String r2 = "mipush_app_package"
            r1.putExtra(r2, r0)
            r7.startService(r1)
            java.lang.String r0 = "fcm message reroute to xmsf"
            com.xiaomi.channel.commonutils.logger.b.a(r0)
        L_0x0067:
            r6 = r3
            goto L_0x0088
        L_0x0069:
            r2 = 3
            java.lang.Object[] r2 = new java.lang.Object[r2]
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
            r2[r6] = r0
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r1)
            r2[r3] = r0
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r4)
            r2[r5] = r0
            java.lang.String r0 = "xmsf can not receive fcm msg - shouldUseMIUIPush=%s;isNotXmsf=%s;xmsfSupport=%s"
            java.lang.String r0 = java.lang.String.format(r0, r2)
        L_0x0085:
            com.xiaomi.channel.commonutils.logger.b.a(r0)
        L_0x0088:
            if (r6 != 0) goto L_0x0096
            java.lang.String r0 = "fcm message post local"
            com.xiaomi.channel.commonutils.logger.b.b(r0)
            com.xiaomi.push.dq r0 = com.xiaomi.push.service.v.a(r8)
            com.xiaomi.push.service.ag.a(r7, r0, r8)
        L_0x0096:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.mipush.sdk.FCMPushHelper.a(android.content.Context, byte[]):void");
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m336a(Context context) {
        return ((long) f.b(context)) >= 50002000 && b(context);
    }

    public static boolean b(Context context) {
        return context.getSharedPreferences("mipush_extra", 0).getBoolean("is_xmsf_sup_decrypt", false);
    }

    public static void clearToken(Context context) {
        g.a(context, c.ASSEMBLE_PUSH_FCM);
    }

    public static void convertMessage(Intent intent) {
        g.a(intent);
    }

    public static String getSenderId(Context context) {
        return context.getSharedPreferences("mipush_extra", 0).getString("fcm_sender_id", "");
    }

    public static boolean isFCMSwitchOpen(Context context) {
        return g.a(context, c.ASSEMBLE_PUSH_FCM) && MiPushClient.getOpenFCMPush(context);
    }

    public static void notifyFCMNotificationCome(Context context, Map<String, String> map) {
        String str = map.get("pushMsg");
        if (!TextUtils.isEmpty(str)) {
            PushMessageReceiver a2 = g.a(context);
            if (a2 != null) {
                a2.onNotificationMessageArrived(context, g.a(str));
            }
        }
    }

    public static Map<String, String> notifyFCMPassThoughMessageCome(Context context, Map<String, String> map) {
        String str = map.get("pushMsg");
        if (!TextUtils.isEmpty(str)) {
            PushMessageReceiver a2 = g.a(context);
            if (a2 != null) {
                a2.onReceivePassThroughMessage(context, g.a(str));
            }
        }
        String str2 = map.get("mipushContainer");
        if (TextUtils.isEmpty(str2)) {
            return new HashMap();
        }
        try {
            byte[] decode = Base64.decode(str2, 2);
            a(context, v.a(decode));
            a(context, decode);
        } catch (Throwable th) {
            b.a((String) "fcm notify notification error ", th);
        }
        return a(context);
    }

    public static void persistIfXmsfSupDecrypt(Context context) {
        boolean z = false;
        Editor edit = context.getSharedPreferences("mipush_extra", 0).edit();
        if (((long) f.b(context)) >= 50002000) {
            z = true;
        }
        edit.putBoolean("is_xmsf_sup_decrypt", z).apply();
    }

    public static void reportFCMMessageDelete() {
    }

    public static void saveSenderId(Context context, String str) {
        if (!TextUtils.isEmpty(str)) {
            context.getSharedPreferences("mipush_extra", 0).edit().putString("fcm_sender_id", str).apply();
        }
    }

    public static void uploadToken(Context context, String str) {
        g.a(context, c.ASSEMBLE_PUSH_FCM, str);
    }
}
