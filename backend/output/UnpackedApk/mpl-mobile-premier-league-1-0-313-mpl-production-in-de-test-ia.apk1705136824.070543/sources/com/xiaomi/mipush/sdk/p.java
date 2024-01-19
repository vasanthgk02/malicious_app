package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.text.TextUtils;
import java.util.HashMap;

public class p {

    public static class a extends RuntimeException {
        public a(String str) {
            super(str);
        }
    }

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public String f4375a;

        /* renamed from: a  reason: collision with other field name */
        public boolean f228a;

        /* renamed from: b  reason: collision with root package name */
        public String f4376b;

        /* renamed from: b  reason: collision with other field name */
        public boolean f229b;

        public b(String str, boolean z, boolean z2, String str2) {
            this.f4375a = str;
            this.f228a = z;
            this.f229b = z2;
            this.f4376b = str2;
        }
    }

    public static ActivityInfo a(PackageManager packageManager, Intent intent, Class<?> cls) {
        for (ResolveInfo resolveInfo : packageManager.queryBroadcastReceivers(intent, 16384)) {
            ActivityInfo activityInfo = resolveInfo.activityInfo;
            if (activityInfo != null && cls.getCanonicalName().equals(activityInfo.name)) {
                return activityInfo;
            }
        }
        return null;
    }

    public static void a(Context context) {
        new Thread(new q(context)).start();
    }

    public static void a(Context context, String str, String str2) {
        PackageManager packageManager = context.getPackageManager();
        String packageName = context.getPackageName();
        Intent intent = new Intent(str);
        intent.setPackage(packageName);
        boolean z = false;
        for (ResolveInfo resolveInfo : packageManager.queryBroadcastReceivers(intent, 16384)) {
            ActivityInfo activityInfo = resolveInfo.activityInfo;
            if (activityInfo == null || TextUtils.isEmpty(activityInfo.name) || !activityInfo.name.equals(str2)) {
                z = false;
                continue;
            } else {
                z = true;
                continue;
            }
            if (z) {
                break;
            }
        }
        if (!z) {
            throw new a(String.format("<receiver android:name=\"%1$s\" .../> is missing or disabled in AndroidManifest.", new Object[]{str2}));
        }
    }

    public static void a(ActivityInfo activityInfo, Boolean[] boolArr) {
        if (boolArr[0].booleanValue() != activityInfo.enabled) {
            throw new a(String.format("<receiver android:name=\"%1$s\" .../> in AndroidManifest had the wrong enabled attribute, which should be android:enabled=%2$b.", new Object[]{activityInfo.name, boolArr[0]}));
        } else if (boolArr[1].booleanValue() != activityInfo.exported) {
            throw new a(String.format("<receiver android:name=\"%1$s\" .../> in AndroidManifest had the wrong exported attribute, which should be android:exported=%2$b.", new Object[]{activityInfo.name, boolArr[1]}));
        }
    }

    public static boolean a(PackageInfo packageInfo, String[] strArr) {
        for (ServiceInfo serviceInfo : packageInfo.services) {
            if (a(strArr, serviceInfo.name)) {
                return true;
            }
        }
        return false;
    }

    public static boolean a(String[] strArr, String str) {
        if (!(strArr == null || str == null)) {
            for (String equals : strArr) {
                if (TextUtils.equals(equals, str)) {
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:39:0x00a2 A[EDGE_INSN: B:39:0x00a2->B:29:0x00a2 ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x006e A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void c(android.content.Context r8) {
        /*
            java.lang.String r0 = "com.xiaomi.push.service.receivers.PingReceiver"
            android.content.pm.PackageManager r1 = r8.getPackageManager()
            java.lang.String r2 = r8.getPackageName()
            android.content.Intent r3 = new android.content.Intent
            java.lang.String r4 = com.xiaomi.push.service.bd.q
            r3.<init>(r4)
            r3.setPackage(r2)
            r4 = 1
            r5 = 0
            java.lang.Class r6 = com.xiaomi.channel.commonutils.android.j.a(r8, r0)     // Catch:{ ClassNotFoundException -> 0x0055 }
            android.content.pm.ActivityInfo r3 = a(r1, r3, r6)     // Catch:{ ClassNotFoundException -> 0x0055 }
            boolean r6 = com.xiaomi.mipush.sdk.MiPushClient.shouldUseMIUIPush(r8)     // Catch:{ ClassNotFoundException -> 0x0055 }
            r7 = 2
            if (r6 != 0) goto L_0x0045
            if (r3 == 0) goto L_0x0035
            java.lang.Boolean[] r0 = new java.lang.Boolean[r7]     // Catch:{ ClassNotFoundException -> 0x0055 }
            java.lang.Boolean r6 = java.lang.Boolean.TRUE     // Catch:{ ClassNotFoundException -> 0x0055 }
            r0[r5] = r6     // Catch:{ ClassNotFoundException -> 0x0055 }
            java.lang.Boolean r6 = java.lang.Boolean.FALSE     // Catch:{ ClassNotFoundException -> 0x0055 }
            r0[r4] = r6     // Catch:{ ClassNotFoundException -> 0x0055 }
            a(r3, r0)     // Catch:{ ClassNotFoundException -> 0x0055 }
            goto L_0x0059
        L_0x0035:
            com.xiaomi.mipush.sdk.p$a r3 = new com.xiaomi.mipush.sdk.p$a     // Catch:{ ClassNotFoundException -> 0x0055 }
            java.lang.String r6 = "<receiver android:name=\"%1$s\" .../> is missing or disabled in AndroidManifest."
            java.lang.Object[] r7 = new java.lang.Object[r4]     // Catch:{ ClassNotFoundException -> 0x0055 }
            r7[r5] = r0     // Catch:{ ClassNotFoundException -> 0x0055 }
            java.lang.String r0 = java.lang.String.format(r6, r7)     // Catch:{ ClassNotFoundException -> 0x0055 }
            r3.<init>(r0)     // Catch:{ ClassNotFoundException -> 0x0055 }
            throw r3     // Catch:{ ClassNotFoundException -> 0x0055 }
        L_0x0045:
            if (r3 == 0) goto L_0x0059
            java.lang.Boolean[] r0 = new java.lang.Boolean[r7]     // Catch:{ ClassNotFoundException -> 0x0055 }
            java.lang.Boolean r6 = java.lang.Boolean.TRUE     // Catch:{ ClassNotFoundException -> 0x0055 }
            r0[r5] = r6     // Catch:{ ClassNotFoundException -> 0x0055 }
            java.lang.Boolean r6 = java.lang.Boolean.FALSE     // Catch:{ ClassNotFoundException -> 0x0055 }
            r0[r4] = r6     // Catch:{ ClassNotFoundException -> 0x0055 }
            a(r3, r0)     // Catch:{ ClassNotFoundException -> 0x0055 }
            goto L_0x0059
        L_0x0055:
            r0 = move-exception
            com.xiaomi.channel.commonutils.logger.b.a(r0)
        L_0x0059:
            android.content.Intent r0 = new android.content.Intent
            java.lang.String r3 = "com.xiaomi.mipush.RECEIVE_MESSAGE"
            r0.<init>(r3)
            r0.setPackage(r2)
            r2 = 16384(0x4000, float:2.2959E-41)
            java.util.List r0 = r1.queryBroadcastReceivers(r0, r2)
            java.util.Iterator r0 = r0.iterator()
            r1 = 0
        L_0x006e:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x00a2
            java.lang.Object r2 = r0.next()
            android.content.pm.ResolveInfo r2 = (android.content.pm.ResolveInfo) r2
            android.content.pm.ActivityInfo r2 = r2.activityInfo
            if (r2 == 0) goto L_0x009f
            java.lang.String r3 = r2.name     // Catch:{ ClassNotFoundException -> 0x009a }
            boolean r3 = android.text.TextUtils.isEmpty(r3)     // Catch:{ ClassNotFoundException -> 0x009a }
            if (r3 != 0) goto L_0x009f
            java.lang.Class<com.xiaomi.mipush.sdk.PushMessageReceiver> r3 = com.xiaomi.mipush.sdk.PushMessageReceiver.class
            java.lang.String r6 = r2.name     // Catch:{ ClassNotFoundException -> 0x009a }
            java.lang.Class r6 = com.xiaomi.channel.commonutils.android.j.a(r8, r6)     // Catch:{ ClassNotFoundException -> 0x009a }
            boolean r3 = r3.isAssignableFrom(r6)     // Catch:{ ClassNotFoundException -> 0x009a }
            if (r3 == 0) goto L_0x009f
            boolean r1 = r2.enabled     // Catch:{ ClassNotFoundException -> 0x009a }
            if (r1 == 0) goto L_0x009f
            r1 = 1
            goto L_0x00a0
        L_0x009a:
            r2 = move-exception
            com.xiaomi.channel.commonutils.logger.b.a(r2)
            goto L_0x006e
        L_0x009f:
            r1 = 0
        L_0x00a0:
            if (r1 == 0) goto L_0x006e
        L_0x00a2:
            if (r1 == 0) goto L_0x00c6
            boolean r0 = com.xiaomi.mipush.sdk.MiPushClient.getOpenHmsPush(r8)
            if (r0 == 0) goto L_0x00b8
            java.lang.String r0 = "com.huawei.android.push.intent.RECEIVE"
            java.lang.String r1 = "com.xiaomi.assemble.control.HmsPushReceiver"
            a(r8, r0, r1)
            java.lang.String r0 = "com.huawei.intent.action.PUSH"
            java.lang.String r1 = "com.huawei.hms.support.api.push.PushEventReceiver"
            a(r8, r0, r1)
        L_0x00b8:
            boolean r0 = com.xiaomi.mipush.sdk.MiPushClient.getOpenVIVOPush(r8)
            if (r0 == 0) goto L_0x00c5
            java.lang.String r0 = "com.vivo.pushclient.action.RECEIVE"
            java.lang.String r1 = "com.xiaomi.assemble.control.FTOSPushMessageReceiver"
            a(r8, r0, r1)
        L_0x00c5:
            return
        L_0x00c6:
            com.xiaomi.mipush.sdk.p$a r8 = new com.xiaomi.mipush.sdk.p$a
            java.lang.String r0 = "Receiver: none of the subclasses of PushMessageReceiver is enabled or defined."
            r8.<init>(r0)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.mipush.sdk.p.c(android.content.Context):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0055  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0097  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void c(android.content.Context r7, android.content.pm.PackageInfo r8) {
        /*
            java.util.HashSet r0 = new java.util.HashSet
            r0.<init>()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r7 = r7.getPackageName()
            r1.append(r7)
            java.lang.String r7 = ".permission.MIPUSH_RECEIVE"
            r1.append(r7)
            java.lang.String r7 = r1.toString()
            r1 = 5
            java.lang.String[] r1 = new java.lang.String[r1]
            java.lang.String r2 = "android.permission.INTERNET"
            r3 = 0
            r1[r3] = r2
            java.lang.String r2 = "android.permission.ACCESS_NETWORK_STATE"
            r4 = 1
            r1[r4] = r2
            r2 = 2
            r1[r2] = r7
            r2 = 3
            java.lang.String r5 = "android.permission.ACCESS_WIFI_STATE"
            r1[r2] = r5
            r2 = 4
            java.lang.String r5 = "android.permission.VIBRATE"
            r1[r2] = r5
            java.util.List r1 = java.util.Arrays.asList(r1)
            r0.addAll(r1)
            android.content.pm.PermissionInfo[] r1 = r8.permissions
            if (r1 == 0) goto L_0x0052
            int r2 = r1.length
            r5 = 0
        L_0x0041:
            if (r5 >= r2) goto L_0x0052
            r6 = r1[r5]
            java.lang.String r6 = r6.name
            boolean r6 = r7.equals(r6)
            if (r6 == 0) goto L_0x004f
            r1 = 1
            goto L_0x0053
        L_0x004f:
            int r5 = r5 + 1
            goto L_0x0041
        L_0x0052:
            r1 = 0
        L_0x0053:
            if (r1 == 0) goto L_0x0097
            java.lang.String[] r7 = r8.requestedPermissions
            if (r7 == 0) goto L_0x0078
            int r8 = r7.length
            r1 = 0
        L_0x005b:
            if (r1 >= r8) goto L_0x0078
            r2 = r7[r1]
            boolean r5 = android.text.TextUtils.isEmpty(r2)
            if (r5 != 0) goto L_0x0075
            boolean r5 = r0.contains(r2)
            if (r5 == 0) goto L_0x0075
            r0.remove(r2)
            boolean r2 = r0.isEmpty()
            if (r2 == 0) goto L_0x0075
            goto L_0x0078
        L_0x0075:
            int r1 = r1 + 1
            goto L_0x005b
        L_0x0078:
            boolean r7 = r0.isEmpty()
            if (r7 == 0) goto L_0x007f
            return
        L_0x007f:
            com.xiaomi.mipush.sdk.p$a r7 = new com.xiaomi.mipush.sdk.p$a
            java.lang.Object[] r8 = new java.lang.Object[r4]
            java.util.Iterator r0 = r0.iterator()
            java.lang.Object r0 = r0.next()
            r8[r3] = r0
            java.lang.String r0 = "<uses-permission android:name=\"%1$s\"/> is missing in AndroidManifest."
            java.lang.String r8 = java.lang.String.format(r0, r8)
            r7.<init>(r8)
            throw r7
        L_0x0097:
            com.xiaomi.mipush.sdk.p$a r8 = new com.xiaomi.mipush.sdk.p$a
            java.lang.Object[] r0 = new java.lang.Object[r4]
            r0[r3] = r7
            java.lang.String r7 = "<permission android:name=\"%1$s\" .../> is undefined in AndroidManifest."
            java.lang.String r7 = java.lang.String.format(r7, r0)
            r8.<init>(r7)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.mipush.sdk.p.c(android.content.Context, android.content.pm.PackageInfo):void");
    }

    public static void d(Context context, PackageInfo packageInfo) {
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        hashMap2.put(PushMessageHandler.class.getCanonicalName(), new b(PushMessageHandler.class.getCanonicalName(), true, true, ""));
        hashMap2.put(MessageHandleService.class.getCanonicalName(), new b(MessageHandleService.class.getCanonicalName(), true, false, ""));
        if (!MiPushClient.shouldUseMIUIPush(context) || a(packageInfo, new String[]{"com.xiaomi.push.service.XMJobService", "com.xiaomi.push.service.XMPushService"})) {
            hashMap2.put("com.xiaomi.push.service.XMJobService", new b("com.xiaomi.push.service.XMJobService", true, false, "android.permission.BIND_JOB_SERVICE"));
            hashMap2.put("com.xiaomi.push.service.XMPushService", new b("com.xiaomi.push.service.XMPushService", true, false, ""));
        }
        if (MiPushClient.getOpenFCMPush(context)) {
            hashMap2.put("com.xiaomi.assemble.control.MiFireBaseInstanceIdService", new b("com.xiaomi.assemble.control.MiFireBaseInstanceIdService", true, false, ""));
            hashMap2.put("com.xiaomi.assemble.control.MiFirebaseMessagingService", new b("com.xiaomi.assemble.control.MiFirebaseMessagingService", true, false, ""));
        }
        if (MiPushClient.getOpenOPPOPush(context)) {
            hashMap2.put("com.xiaomi.assemble.control.COSPushMessageService", new b("com.xiaomi.assemble.control.COSPushMessageService", true, true, "com.coloros.mcs.permission.SEND_MCS_MESSAGE"));
        }
        ServiceInfo[] serviceInfoArr = packageInfo.services;
        if (serviceInfoArr != null) {
            for (ServiceInfo serviceInfo : serviceInfoArr) {
                if (!TextUtils.isEmpty(serviceInfo.name) && hashMap2.containsKey(serviceInfo.name)) {
                    b bVar = (b) hashMap2.remove(serviceInfo.name);
                    boolean z = bVar.f228a;
                    boolean z2 = bVar.f229b;
                    String str = bVar.f4376b;
                    if (z != serviceInfo.enabled) {
                        throw new a(String.format("<service android:name=\"%1$s\" .../> in AndroidManifest had the wrong enabled attribute, which should be android:enabled=%2$b.", new Object[]{serviceInfo.name, Boolean.valueOf(z)}));
                    } else if (z2 != serviceInfo.exported) {
                        throw new a(String.format("<service android:name=\"%1$s\" .../> in AndroidManifest had the wrong exported attribute, which should be android:exported=%2$b.", new Object[]{serviceInfo.name, Boolean.valueOf(z2)}));
                    } else if (TextUtils.isEmpty(str) || TextUtils.equals(str, serviceInfo.permission)) {
                        hashMap.put(serviceInfo.name, serviceInfo.processName);
                        if (hashMap2.isEmpty()) {
                            break;
                        }
                    } else {
                        throw new a(String.format("<service android:name=\"%1$s\" .../> in AndroidManifest had the wrong permission attribute, which should be android:permission=\"%2$s\".", new Object[]{serviceInfo.name, str}));
                    }
                }
            }
        }
        if (!hashMap2.isEmpty()) {
            throw new a(String.format("<service android:name=\"%1$s\" .../> is missing or disabled in AndroidManifest.", new Object[]{hashMap2.keySet().iterator().next()}));
        } else if (!TextUtils.equals((CharSequence) hashMap.get(PushMessageHandler.class.getCanonicalName()), (CharSequence) hashMap.get(MessageHandleService.class.getCanonicalName()))) {
            throw new a(String.format("\"%1$s\" and \"%2$s\" must be running in the same process.", new Object[]{PushMessageHandler.class.getCanonicalName(), MessageHandleService.class.getCanonicalName()}));
        } else if (hashMap.containsKey("com.xiaomi.push.service.XMJobService") && hashMap.containsKey("com.xiaomi.push.service.XMPushService") && !TextUtils.equals((CharSequence) hashMap.get("com.xiaomi.push.service.XMJobService"), (CharSequence) hashMap.get("com.xiaomi.push.service.XMPushService"))) {
            throw new a(String.format("\"%1$s\" and \"%2$s\" must be running in the same process.", new Object[]{"com.xiaomi.push.service.XMJobService", "com.xiaomi.push.service.XMPushService"}));
        }
    }
}
