package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.android.h;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.ac;
import com.xiaomi.push.db;
import com.xiaomi.push.dq;
import com.xiaomi.push.o;
import com.xiaomi.push.y;
import com.xiaomi.push.z;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONObject;

public class g {

    /* renamed from: a  reason: collision with root package name */
    public static HashMap<String, String> f4366a = new HashMap<>();

    public static int a() {
        Integer num = (Integer) z.a((String) "com.xiaomi.assemble.control.AssembleConstants", (String) "ASSEMBLE_VERSION_CODE");
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0049, code lost:
        r6 = r0.getInt(b(r7), 0);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int a(android.content.Context r6, com.xiaomi.mipush.sdk.c r7, java.lang.String r8) {
        /*
            java.lang.String r0 = "mipush_extra"
            r1 = 0
            android.content.SharedPreferences r0 = r6.getSharedPreferences(r0, r1)
            java.lang.String r2 = a(r7)
            java.lang.String r3 = ""
            java.lang.String r4 = r0.getString(r2, r3)
            com.xiaomi.mipush.sdk.a r6 = com.xiaomi.mipush.sdk.a.a(r6)
            java.lang.String r6 = r6.c()
            java.lang.String r5 = "last_check_token"
            java.lang.String r3 = r0.getString(r5, r3)
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 == 0) goto L_0x002b
            java.lang.String r6 = "ASSEMBLE_PUSH : can not find the key of token used in sp file"
            com.xiaomi.channel.commonutils.logger.b.a(r6)
            return r1
        L_0x002b:
            boolean r2 = android.text.TextUtils.isEmpty(r4)
            if (r2 == 0) goto L_0x0033
            r6 = 1
            return r6
        L_0x0033:
            boolean r8 = r4.equals(r8)
            if (r8 != 0) goto L_0x003b
            r6 = 2
            return r6
        L_0x003b:
            boolean r6 = android.text.TextUtils.equals(r6, r3)
            if (r6 != 0) goto L_0x0043
            r6 = 3
            return r6
        L_0x0043:
            boolean r6 = a(r7)
            if (r6 == 0) goto L_0x0059
            java.lang.String r6 = b(r7)
            int r6 = r0.getInt(r6, r1)
            int r7 = a()
            if (r7 == r6) goto L_0x0059
            r6 = 4
            return r6
        L_0x0059:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.mipush.sdk.g.a(android.content.Context, com.xiaomi.mipush.sdk.c, java.lang.String):int");
    }

    public static MiPushMessage a(String str) {
        MiPushMessage miPushMessage = new MiPushMessage();
        if (!TextUtils.isEmpty(str)) {
            try {
                String str2 = MiPushMessage.KEY_EXTRA;
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.has("messageId")) {
                    miPushMessage.setMessageId(jSONObject.getString("messageId"));
                }
                if (jSONObject.has("description")) {
                    miPushMessage.setDescription(jSONObject.getString("description"));
                }
                if (jSONObject.has("title")) {
                    miPushMessage.setTitle(jSONObject.getString("title"));
                }
                if (jSONObject.has("content")) {
                    miPushMessage.setContent(jSONObject.getString("content"));
                }
                if (jSONObject.has(MiPushMessage.KEY_PASS_THROUGH)) {
                    miPushMessage.setPassThrough(jSONObject.getInt(MiPushMessage.KEY_PASS_THROUGH));
                }
                if (jSONObject.has(MiPushMessage.KEY_NOTIFY_TYPE)) {
                    miPushMessage.setNotifyType(jSONObject.getInt(MiPushMessage.KEY_NOTIFY_TYPE));
                }
                if (jSONObject.has(MiPushMessage.KEY_MESSAGE_TYPE)) {
                    miPushMessage.setMessageType(jSONObject.getInt(MiPushMessage.KEY_MESSAGE_TYPE));
                }
                if (jSONObject.has("alias")) {
                    miPushMessage.setAlias(jSONObject.getString("alias"));
                }
                if (jSONObject.has(MiPushMessage.KEY_TOPIC)) {
                    miPushMessage.setTopic(jSONObject.getString(MiPushMessage.KEY_TOPIC));
                }
                if (jSONObject.has(MiPushMessage.KEY_USER_ACCOUNT)) {
                    miPushMessage.setUserAccount(jSONObject.getString(MiPushMessage.KEY_USER_ACCOUNT));
                }
                if (jSONObject.has(MiPushMessage.KEY_NOTIFY_ID)) {
                    miPushMessage.setNotifyId(jSONObject.getInt(MiPushMessage.KEY_NOTIFY_ID));
                }
                if (jSONObject.has("category")) {
                    miPushMessage.setCategory(jSONObject.getString("category"));
                }
                if (jSONObject.has(MiPushMessage.KEY_NOTIFIED)) {
                    miPushMessage.setNotified(jSONObject.getBoolean(MiPushMessage.KEY_NOTIFIED));
                }
                String str3 = str2;
                if (jSONObject.has(str3)) {
                    JSONObject jSONObject2 = jSONObject.getJSONObject(str3);
                    Iterator<String> keys = jSONObject2.keys();
                    HashMap hashMap = new HashMap();
                    while (keys != null && keys.hasNext()) {
                        String next = keys.next();
                        hashMap.put(next, jSONObject2.getString(next));
                    }
                    if (hashMap.size() > 0) {
                        miPushMessage.setExtra(hashMap);
                    }
                }
            } catch (Exception e2) {
                b.d(e2.toString());
            }
        }
        return miPushMessage;
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0041 A[Catch:{ Exception -> 0x0051 }] */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0050 A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.xiaomi.mipush.sdk.PushMessageReceiver a(android.content.Context r5) {
        /*
            android.content.Intent r0 = new android.content.Intent
            java.lang.String r1 = "com.xiaomi.mipush.RECEIVE_MESSAGE"
            r0.<init>(r1)
            java.lang.String r1 = r5.getPackageName()
            r0.setPackage(r1)
            android.content.pm.PackageManager r1 = r5.getPackageManager()
            r2 = 32
            r3 = 0
            java.util.List r0 = r1.queryBroadcastReceivers(r0, r2)     // Catch:{ Exception -> 0x0051 }
            if (r0 == 0) goto L_0x003e
            java.util.Iterator r0 = r0.iterator()     // Catch:{ Exception -> 0x0051 }
        L_0x001f:
            boolean r1 = r0.hasNext()     // Catch:{ Exception -> 0x0051 }
            if (r1 == 0) goto L_0x003e
            java.lang.Object r1 = r0.next()     // Catch:{ Exception -> 0x0051 }
            android.content.pm.ResolveInfo r1 = (android.content.pm.ResolveInfo) r1     // Catch:{ Exception -> 0x0051 }
            android.content.pm.ActivityInfo r2 = r1.activityInfo     // Catch:{ Exception -> 0x0051 }
            if (r2 == 0) goto L_0x001f
            android.content.pm.ActivityInfo r2 = r1.activityInfo     // Catch:{ Exception -> 0x0051 }
            java.lang.String r2 = r2.packageName     // Catch:{ Exception -> 0x0051 }
            java.lang.String r4 = r5.getPackageName()     // Catch:{ Exception -> 0x0051 }
            boolean r2 = r2.equals(r4)     // Catch:{ Exception -> 0x0051 }
            if (r2 == 0) goto L_0x001f
            goto L_0x003f
        L_0x003e:
            r1 = r3
        L_0x003f:
            if (r1 == 0) goto L_0x0050
            android.content.pm.ActivityInfo r0 = r1.activityInfo     // Catch:{ Exception -> 0x0051 }
            java.lang.String r0 = r0.name     // Catch:{ Exception -> 0x0051 }
            java.lang.Class r5 = com.xiaomi.channel.commonutils.android.j.a(r5, r0)     // Catch:{ Exception -> 0x0051 }
            java.lang.Object r5 = r5.newInstance()     // Catch:{ Exception -> 0x0051 }
            com.xiaomi.mipush.sdk.PushMessageReceiver r5 = (com.xiaomi.mipush.sdk.PushMessageReceiver) r5     // Catch:{ Exception -> 0x0051 }
            return r5
        L_0x0050:
            return r3
        L_0x0051:
            r5 = move-exception
            java.lang.String r5 = r5.toString()
            com.xiaomi.channel.commonutils.logger.b.d(r5)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.mipush.sdk.g.a(android.content.Context):com.xiaomi.mipush.sdk.PushMessageReceiver");
    }

    public static String a(Context context, c cVar) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("mipush_extra", 0);
        String a2 = a(cVar);
        if (!TextUtils.isEmpty(a2)) {
            return sharedPreferences.getString(a2, "");
        }
        return null;
    }

    public static synchronized String a(Context context, String str) {
        String str2;
        synchronized (g.class) {
            str2 = f4366a.get(str);
            if (TextUtils.isEmpty(str2)) {
                str2 = "";
            }
        }
        return str2;
    }

    public static String a(c cVar) {
        int i = i.f4368a[cVar.ordinal()];
        if (i == 1) {
            return "hms_push_token";
        }
        if (i == 2) {
            return "fcm_push_token_v2";
        }
        if (i == 3) {
            return "cos_push_token";
        }
        if (i != 4) {
            return null;
        }
        return "ftos_push_token";
    }

    /* JADX WARNING: type inference failed for: r4v0 */
    /* JADX WARNING: type inference failed for: r4v3, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r4v5, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r4v6, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r4v8 */
    /* JADX WARNING: type inference failed for: r4v10 */
    /* JADX WARNING: type inference failed for: r4v11 */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x005b, code lost:
        if (r12 != 0) goto L_0x00ba;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: a  reason: collision with other method in class */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.HashMap<java.lang.String, java.lang.String> m375a(android.content.Context r11, com.xiaomi.mipush.sdk.c r12) {
        /*
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            java.lang.String r1 = a(r12)
            boolean r2 = android.text.TextUtils.isEmpty(r1)
            if (r2 == 0) goto L_0x0010
            return r0
        L_0x0010:
            int[] r2 = com.xiaomi.mipush.sdk.i.f4368a
            int r12 = r12.ordinal()
            r12 = r2[r12]
            r2 = 1
            java.lang.String r3 = "brand:"
            r4 = 0
            java.lang.String r5 = "package_name"
            java.lang.String r6 = "token"
            java.lang.String r7 = "~"
            java.lang.String r8 = ":"
            if (r12 == r2) goto L_0x00c6
            r2 = 2
            java.lang.String r9 = "brand"
            java.lang.String r10 = "version"
            if (r12 == r2) goto L_0x0091
            r2 = 3
            if (r12 == r2) goto L_0x005e
            r2 = 4
            if (r12 == r2) goto L_0x0038
            goto L_0x0129
        L_0x0038:
            com.xiaomi.channel.commonutils.android.k$a r12 = new com.xiaomi.channel.commonutils.android.k$a
            r12.<init>(r8, r7)
            com.xiaomi.mipush.sdk.y r2 = com.xiaomi.mipush.sdk.y.VIVO
            java.lang.String r2 = r2.name()
            com.xiaomi.channel.commonutils.android.k$a r12 = r12.a(r9, r2)
            java.lang.String r1 = a(r11, r1)
            com.xiaomi.channel.commonutils.android.k$a r12 = r12.a(r6, r1)
            java.lang.String r11 = r11.getPackageName()
            com.xiaomi.channel.commonutils.android.k$a r11 = r12.a(r5, r11)
            int r12 = a()
            if (r12 == 0) goto L_0x00c1
            goto L_0x00ba
        L_0x005e:
            java.lang.StringBuilder r12 = com.android.tools.r8.GeneratedOutlineSupport.outline73(r3)
            com.xiaomi.mipush.sdk.y r2 = com.xiaomi.mipush.sdk.y.OPPO
            java.lang.String r2 = r2.name()
            r12.append(r2)
            r12.append(r7)
            r12.append(r6)
            r12.append(r8)
            java.lang.String r1 = a(r11, r1)
            r12.append(r1)
            r12.append(r7)
            r12.append(r5)
            r12.append(r8)
            java.lang.String r11 = r11.getPackageName()
            r12.append(r11)
            java.lang.String r4 = r12.toString()
            goto L_0x0129
        L_0x0091:
            com.xiaomi.channel.commonutils.android.k$a r12 = new com.xiaomi.channel.commonutils.android.k$a
            r12.<init>(r8, r7)
            com.xiaomi.mipush.sdk.y r2 = com.xiaomi.mipush.sdk.y.FCM
            java.lang.String r2 = r2.name()
            com.xiaomi.channel.commonutils.android.k$a r12 = r12.a(r9, r2)
            java.lang.String r1 = a(r11, r1)
            com.xiaomi.channel.commonutils.android.k$a r12 = r12.a(r6, r1)
            java.lang.String r11 = r11.getPackageName()
            com.xiaomi.channel.commonutils.android.k$a r11 = r12.a(r5, r11)
            int r12 = a()
            if (r12 == 0) goto L_0x00b7
            goto L_0x00ba
        L_0x00b7:
            r12 = 50011(0xc35b, float:7.008E-41)
        L_0x00ba:
            java.lang.Integer r12 = java.lang.Integer.valueOf(r12)
            r11.a(r10, r12)
        L_0x00c1:
            java.lang.String r4 = r11.toString()
            goto L_0x0129
        L_0x00c6:
            android.content.pm.PackageManager r12 = r11.getPackageManager()     // Catch:{ Exception -> 0x00d5 }
            java.lang.String r2 = r11.getPackageName()     // Catch:{ Exception -> 0x00d5 }
            r9 = 128(0x80, float:1.8E-43)
            android.content.pm.ApplicationInfo r4 = r12.getApplicationInfo(r2, r9)     // Catch:{ Exception -> 0x00d5 }
            goto L_0x00dd
        L_0x00d5:
            r12 = move-exception
            java.lang.String r12 = r12.toString()
            com.xiaomi.channel.commonutils.logger.b.d(r12)
        L_0x00dd:
            r12 = -1
            if (r4 == 0) goto L_0x00e8
            android.os.Bundle r12 = r4.metaData
            java.lang.String r2 = "com.huawei.hms.client.appid"
            int r12 = r12.getInt(r2)
        L_0x00e8:
            java.lang.StringBuilder r2 = com.android.tools.r8.GeneratedOutlineSupport.outline73(r3)
            com.xiaomi.mipush.sdk.y r3 = com.xiaomi.mipush.sdk.l.a(r11)
            java.lang.String r3 = r3.name()
            r2.append(r3)
            r2.append(r7)
            r2.append(r6)
            r2.append(r8)
            java.lang.String r1 = a(r11, r1)
            r2.append(r1)
            r2.append(r7)
            r2.append(r5)
            r2.append(r8)
            java.lang.String r11 = r11.getPackageName()
            r2.append(r11)
            r2.append(r7)
            java.lang.String r11 = "app_id"
            r2.append(r11)
            r2.append(r8)
            r2.append(r12)
            java.lang.String r4 = r2.toString()
        L_0x0129:
            java.lang.String r11 = "RegInfo"
            r0.put(r11, r4)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.mipush.sdk.g.m375a(android.content.Context, com.xiaomi.mipush.sdk.c):java.util.HashMap");
    }

    /* renamed from: a  reason: collision with other method in class */
    public static void m376a(Context context) {
        boolean z = false;
        SharedPreferences sharedPreferences = context.getSharedPreferences("mipush_extra", 0);
        String a2 = a(c.ASSEMBLE_PUSH_HUAWEI);
        String a3 = a(c.ASSEMBLE_PUSH_FCM);
        if (!TextUtils.isEmpty(sharedPreferences.getString(a2, "")) && TextUtils.isEmpty(sharedPreferences.getString(a3, ""))) {
            z = true;
        }
        if (z) {
            ag.a(context).a(2, a2);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public static void m377a(Context context, c cVar) {
        String a2 = a(cVar);
        if (!TextUtils.isEmpty(a2)) {
            h.a(context.getSharedPreferences("mipush_extra", 0).edit().putString(a2, ""));
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public static void m378a(Context context, c cVar, String str) {
        if (!TextUtils.isEmpty(str)) {
            int a2 = a(context, cVar, str);
            if (a2 != 0) {
                b.a("ASSEMBLE_PUSH : send token upload, check:" + a2);
                a(cVar, str);
                am a3 = j.a(cVar);
                if (a3 != null) {
                    ag.a(context).a((String) null, a3, cVar);
                }
            } else {
                b.a((String) "ASSEMBLE_PUSH : do not need to send token");
            }
        }
    }

    public static void a(Intent intent) {
        if (intent != null) {
            Bundle extras = intent.getExtras();
            if (extras != null && extras.containsKey("pushMsg")) {
                intent.putExtra(PushMessageHelper.KEY_MESSAGE, a(extras.getString("pushMsg")));
            }
        }
    }

    public static synchronized void a(c cVar, String str) {
        synchronized (g.class) {
            String a2 = a(cVar);
            if (TextUtils.isEmpty(a2)) {
                b.a((String) "ASSEMBLE_PUSH : can not find the key of token used in sp file");
            } else if (TextUtils.isEmpty(str)) {
                b.a((String) "ASSEMBLE_PUSH : token is null");
            } else {
                f4366a.put(a2, str);
            }
        }
    }

    public static void a(String str, int i) {
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m379a(Context context) {
        if (context == null) {
            return false;
        }
        return y.a(context);
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m380a(Context context, c cVar) {
        db a2 = j.a(cVar);
        return true;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m381a(c cVar) {
        return cVar == c.ASSEMBLE_PUSH_FTOS || cVar == c.ASSEMBLE_PUSH_FCM;
    }

    public static boolean a(dq dqVar, c cVar) {
        if (dqVar == null || dqVar.a() == null || dqVar.a().a() == null) {
            return false;
        }
        return (cVar == c.ASSEMBLE_PUSH_FCM ? "FCM" : "").equalsIgnoreCase((String) dqVar.a().a().get("assemble_push_type"));
    }

    public static byte[] a(Context context, dq dqVar, c cVar) {
        if (a(dqVar, cVar)) {
            return ac.a(a(context, cVar));
        }
        return null;
    }

    public static String b(c cVar) {
        return a(cVar) + "_version";
    }

    public static void b(Context context) {
        d.a(context).register();
    }

    public static void b(Context context, c cVar, String str) {
        o.a(context).a((Runnable) new h(str, context, cVar));
    }

    public static void c(Context context) {
        d.a(context).unregister();
    }

    public static synchronized void d(Context context, c cVar, String str) {
        synchronized (g.class) {
            String a2 = a(cVar);
            if (TextUtils.isEmpty(a2)) {
                b.a((String) "ASSEMBLE_PUSH : can not find the key of token used in sp file");
                return;
            }
            Editor edit = context.getSharedPreferences("mipush_extra", 0).edit();
            edit.putString(a2, str).putString("last_check_token", a.a(context).c());
            if (a(cVar)) {
                edit.putInt(b(cVar), a());
            }
            h.a(edit);
            b.a("ASSEMBLE_PUSH : update sp file success!  " + str);
        }
    }
}
