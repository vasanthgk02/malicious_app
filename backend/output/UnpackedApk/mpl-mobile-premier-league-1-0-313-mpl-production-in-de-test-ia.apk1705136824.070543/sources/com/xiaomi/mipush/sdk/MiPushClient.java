package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.google.firebase.perf.config.RemoteConfigManager;
import com.paynimo.android.payment.util.Constant;
import com.xiaomi.channel.commonutils.android.Region;
import com.xiaomi.channel.commonutils.android.a;
import com.xiaomi.channel.commonutils.android.c;
import com.xiaomi.channel.commonutils.android.f;
import com.xiaomi.channel.commonutils.android.g;
import com.xiaomi.channel.commonutils.android.h;
import com.xiaomi.channel.commonutils.android.j;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.BuildConfig;
import com.xiaomi.push.Cdo;
import com.xiaomi.push.ad;
import com.xiaomi.push.bg;
import com.xiaomi.push.cz;
import com.xiaomi.push.df;
import com.xiaomi.push.di;
import com.xiaomi.push.dj;
import com.xiaomi.push.dt;
import com.xiaomi.push.du;
import com.xiaomi.push.dy;
import com.xiaomi.push.ea;
import com.xiaomi.push.ec;
import com.xiaomi.push.o;
import com.xiaomi.push.service.at;
import com.xiaomi.push.service.aw;
import com.xiaomi.push.service.receivers.NetworkStatusReceiver;
import java.lang.Thread.UncaughtExceptionHandler;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.TimeZone;
import org.eclipse.paho.android.service.MqttServiceConstants;

public abstract class MiPushClient {
    public static final String COMMAND_REGISTER = "register";
    public static final String COMMAND_SET_ACCEPT_TIME = "accept-time";
    public static final String COMMAND_SET_ACCOUNT = "set-account";
    public static final String COMMAND_SET_ALIAS = "set-alias";
    public static final String COMMAND_SUBSCRIBE_TOPIC = "subscribe-topic";
    public static final String COMMAND_UNREGISTER = "unregister";
    public static final String COMMAND_UNSET_ACCOUNT = "unset-account";
    public static final String COMMAND_UNSET_ALIAS = "unset-alias";
    public static final String COMMAND_UNSUBSCRIBE_TOPIC = "unsubscibe-topic";
    public static final String PREF_EXTRA = "mipush_extra";
    public static Context sContext;
    public static long sCurMsgId = System.currentTimeMillis();
    public static volatile Region sUserSetRegion = null;

    public static class CodeResult {
        public long resultCode = -1;

        public long getResultCode() {
            return this.resultCode;
        }

        public void setResultCode(long j) {
            this.resultCode = j;
        }
    }

    public interface ICallbackResult<R> {
        void onResult(R r);
    }

    @Deprecated
    public static abstract class MiPushClientCallback {
        public String category;

        public String getCategory() {
            return this.category;
        }

        public void onCommandResult(String str, long j, String str2, List<String> list) {
        }

        public void onInitializeResult(long j, String str, String str2) {
        }

        public void onReceiveMessage(MiPushMessage miPushMessage) {
        }

        public void onReceiveMessage(String str, String str2, String str3, boolean z) {
        }

        public void onSubscribeResult(long j, String str, String str2) {
        }

        public void onUnsubscribeResult(long j, String str, String str2) {
        }

        public void setCategory(String str) {
            this.category = str;
        }
    }

    public static class TokenResult {
        public long resultCode = -1;
        public String token = null;

        public long getResultCode() {
            return this.resultCode;
        }

        public String getToken() {
            return this.token;
        }

        public void setResultCode(long j) {
            this.resultCode = j;
        }

        public void setToken(String str) {
            this.token = str;
        }
    }

    public interface UPSRegisterCallBack extends ICallbackResult<TokenResult> {
    }

    public interface UPSTurnCallBack extends ICallbackResult<CodeResult> {
    }

    public interface UPSUnRegisterCallBack extends ICallbackResult<TokenResult> {
    }

    public static boolean acceptTimeSet(Context context, String str, String str2) {
        String acceptTime = getAcceptTime(context);
        return TextUtils.equals(acceptTime, str + "," + str2);
    }

    public static long accountSetTime(Context context, String str) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("mipush_extra", 0);
        return sharedPreferences.getLong("account_" + str, -1);
    }

    public static synchronized void addAcceptTime(Context context, String str, String str2) {
        synchronized (MiPushClient.class) {
            Editor edit = context.getSharedPreferences("mipush_extra", 0).edit();
            edit.putString(Constants.EXTRA_KEY_ACCEPT_TIME, str + "," + str2);
            h.a(edit);
        }
    }

    public static synchronized void addAccount(Context context, String str) {
        synchronized (MiPushClient.class) {
            Editor edit = context.getSharedPreferences("mipush_extra", 0).edit();
            edit.putLong("account_" + str, System.currentTimeMillis()).commit();
        }
    }

    public static synchronized void addAlias(Context context, String str) {
        synchronized (MiPushClient.class) {
            Editor edit = context.getSharedPreferences("mipush_extra", 0).edit();
            edit.putLong("alias_" + str, System.currentTimeMillis()).commit();
        }
    }

    public static void addPullNotificationTime(Context context) {
        Editor edit = context.getSharedPreferences("mipush_extra", 0).edit();
        edit.putLong("last_pull_notification", System.currentTimeMillis());
        h.a(edit);
    }

    public static void addRegRequestTime(Context context) {
        Editor edit = context.getSharedPreferences("mipush_extra", 0).edit();
        edit.putLong("last_reg_request", System.currentTimeMillis());
        h.a(edit);
    }

    public static synchronized void addTopic(Context context, String str) {
        synchronized (MiPushClient.class) {
            Editor edit = context.getSharedPreferences("mipush_extra", 0).edit();
            edit.putLong("topic_" + str, System.currentTimeMillis()).commit();
        }
    }

    public static long aliasSetTime(Context context, String str) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("mipush_extra", 0);
        return sharedPreferences.getLong("alias_" + str, -1);
    }

    public static void checkNotNull(Object obj, String str) {
        if (obj == null) {
            throw new IllegalArgumentException(GeneratedOutlineSupport.outline52("param ", str, " is not nullable"));
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0050, code lost:
        if (com.xiaomi.channel.commonutils.android.Region.Global.name().equals(r8) != false) goto L_0x0060;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean checkRegionNotMIUIPhone(android.content.Context r7, java.lang.String r8) {
        /*
            android.content.Context r0 = sContext
            java.lang.String r1 = "mipush_region"
            r2 = 0
            android.content.SharedPreferences r0 = r0.getSharedPreferences(r1, r2)
            java.lang.String r1 = "user_region"
            java.lang.String r3 = ""
            java.lang.String r3 = r0.getString(r1, r3)
            android.content.SharedPreferences$Editor r0 = r0.edit()
            boolean r4 = android.text.TextUtils.isEmpty(r3)
            java.lang.String r5 = "req_hosts"
            r6 = 1
            if (r4 == 0) goto L_0x0053
            r0.putString(r1, r8)
            java.lang.String r7 = getAppRegion(r7)
            boolean r1 = android.text.TextUtils.isEmpty(r7)
            if (r1 != 0) goto L_0x005c
            com.xiaomi.channel.commonutils.android.Region r1 = com.xiaomi.channel.commonutils.android.Region.Europe
            java.lang.String r1 = r1.name()
            boolean r1 = r1.equals(r7)
            if (r1 != 0) goto L_0x005c
            boolean r1 = r7.equals(r8)
            if (r1 != 0) goto L_0x0060
            java.lang.String r1 = "Singapore"
            boolean r7 = r1.equals(r7)
            if (r7 == 0) goto L_0x005c
            com.xiaomi.channel.commonutils.android.Region r7 = com.xiaomi.channel.commonutils.android.Region.Global
            java.lang.String r7 = r7.name()
            boolean r7 = r7.equals(r8)
            if (r7 != 0) goto L_0x0060
            goto L_0x005c
        L_0x0053:
            boolean r7 = r8.equals(r3)
            if (r7 != 0) goto L_0x0060
            r0.putString(r1, r8)
        L_0x005c:
            r0.putBoolean(r5, r6)
            r2 = 1
        L_0x0060:
            r0.apply()
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r0 = "current register region: "
            r7.append(r0)
            r7.append(r8)
            java.lang.String r7 = r7.toString()
            com.xiaomi.channel.commonutils.logger.b.a(r7)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.mipush.sdk.MiPushClient.checkRegionNotMIUIPhone(android.content.Context, java.lang.String):boolean");
    }

    public static void clearExtras(Context context) {
        Editor edit = context.getSharedPreferences("mipush_extra", 0).edit();
        edit.clear();
        edit.commit();
    }

    public static void clearExtrasForInitialize(Context context) {
        Editor edit = context.getSharedPreferences("mipush_extra", 0).edit();
        Iterator<String> it = getAllAlias(context).iterator();
        while (it.hasNext()) {
            edit.remove("alias_" + it.next());
        }
        Iterator<String> it2 = getAllUserAccount(context).iterator();
        while (it2.hasNext()) {
            edit.remove("account_" + it2.next());
        }
        Iterator<String> it3 = getAllTopic(context).iterator();
        while (it3.hasNext()) {
            edit.remove("topic_" + it3.next());
        }
        edit.remove(Constants.EXTRA_KEY_ACCEPT_TIME);
        edit.commit();
    }

    public static void clearLocalNotificationType(Context context) {
        if (!ag.a(context).a((String) "clearLocalNotificationType")) {
            ag.a(context).e();
        }
    }

    public static void clearNotification(Context context) {
        if (!ag.a(context).a((String) "clearNotification")) {
            ag.a(context).a(-1);
        }
    }

    public static void clearNotification(Context context, int i) {
        if (!ag.a(context).a((String) "clearNotification")) {
            ag.a(context).a(i);
        }
    }

    public static void clearNotification(Context context, String str, String str2) {
        if (!ag.a(context).a((String) "clearNotification")) {
            ag.a(context).a(str, str2);
        }
    }

    public static void disablePush(Context context) {
        if (!ag.a(context).a((String) "disablePush")) {
            ag.a(context).a(true);
        }
    }

    public static void enablePush(Context context) {
        if (!ag.a(context).a((String) "enablePush")) {
            ag.a(context).a(false);
        }
    }

    public static String getAcceptTime(Context context) {
        return context.getSharedPreferences("mipush_extra", 0).getString(Constants.EXTRA_KEY_ACCEPT_TIME, "00:00-23:59");
    }

    public static List<String> getAllAlias(Context context) {
        ArrayList arrayList = new ArrayList();
        for (String next : context.getSharedPreferences("mipush_extra", 0).getAll().keySet()) {
            if (next.startsWith("alias_")) {
                arrayList.add(next.substring(6));
            }
        }
        return arrayList;
    }

    public static List<String> getAllTopic(Context context) {
        ArrayList arrayList = new ArrayList();
        for (String next : context.getSharedPreferences("mipush_extra", 0).getAll().keySet()) {
            if (next.startsWith("topic_") && !next.contains("**ALL**")) {
                arrayList.add(next.substring(6));
            }
        }
        return arrayList;
    }

    public static List<String> getAllUserAccount(Context context) {
        ArrayList arrayList = new ArrayList();
        for (String next : context.getSharedPreferences("mipush_extra", 0).getAll().keySet()) {
            if (next.startsWith("account_")) {
                arrayList.add(next.substring(8));
            }
        }
        return arrayList;
    }

    public static String getAppRegion(Context context) {
        if (a.a(context).c()) {
            return a.a(context).f();
        }
        return null;
    }

    public static boolean getOpenFCMPush(Context context) {
        checkNotNull(context, "context");
        return d.a(context).b(c.ASSEMBLE_PUSH_FCM);
    }

    public static boolean getOpenHmsPush(Context context) {
        checkNotNull(context, "context");
        return d.a(context).b(c.ASSEMBLE_PUSH_HUAWEI);
    }

    public static boolean getOpenOPPOPush(Context context) {
        checkNotNull(context, "context");
        return d.a(context).b(c.ASSEMBLE_PUSH_COS);
    }

    public static boolean getOpenVIVOPush(Context context) {
        return d.a(context).b(c.ASSEMBLE_PUSH_FTOS);
    }

    public static String getRegId(Context context) {
        if (a.a(context).c()) {
            return a.a(context).c();
        }
        return null;
    }

    @Deprecated
    public static void initialize(Context context, String str, String str2, MiPushClientCallback miPushClientCallback) {
    }

    /* JADX WARNING: Removed duplicated region for block: B:59:0x0274 A[Catch:{ all -> 0x028b }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void initialize(android.content.Context r11, java.lang.String r12, java.lang.String r13, com.xiaomi.mipush.sdk.MiPushClient.MiPushClientCallback r14, java.lang.String r15, com.xiaomi.mipush.sdk.MiPushClient.ICallbackResult r16, java.lang.String r17) {
        /*
            r0 = r12
            r1 = r13
            r2 = r14
            android.content.Context r3 = r11.getApplicationContext()     // Catch:{ all -> 0x028b }
            com.xiaomi.channel.commonutils.logger.b.a(r3)     // Catch:{ all -> 0x028b }
            java.lang.String r3 = "sdk_version = 5_1_1-G"
            com.xiaomi.channel.commonutils.logger.b.e(r3)     // Catch:{ all -> 0x028b }
            if (r2 == 0) goto L_0x0014
            com.xiaomi.mipush.sdk.PushMessageHandler.a(r14)     // Catch:{ all -> 0x028b }
        L_0x0014:
            if (r16 == 0) goto L_0x0019
            com.xiaomi.mipush.sdk.PushMessageHandler.a(r16)     // Catch:{ all -> 0x028b }
        L_0x0019:
            android.content.Context r3 = sContext     // Catch:{ all -> 0x028b }
            boolean r3 = com.xiaomi.channel.commonutils.android.j.a(r3)     // Catch:{ all -> 0x028b }
            if (r3 == 0) goto L_0x0026
            android.content.Context r3 = sContext     // Catch:{ all -> 0x028b }
            com.xiaomi.mipush.sdk.p.a(r3)     // Catch:{ all -> 0x028b }
        L_0x0026:
            boolean r3 = com.xiaomi.channel.commonutils.android.f.a()     // Catch:{ all -> 0x028b }
            r4 = 0
            if (r3 != 0) goto L_0x0042
            boolean r3 = android.text.TextUtils.isEmpty(r17)     // Catch:{ all -> 0x028b }
            if (r3 == 0) goto L_0x0039
            java.lang.String r0 = "please set region before registering"
            com.xiaomi.channel.commonutils.logger.b.a(r0)     // Catch:{ all -> 0x028b }
            return
        L_0x0039:
            android.content.Context r3 = sContext     // Catch:{ all -> 0x028b }
            r5 = r17
            boolean r3 = checkRegionNotMIUIPhone(r3, r5)     // Catch:{ all -> 0x028b }
            goto L_0x0043
        L_0x0042:
            r3 = 0
        L_0x0043:
            android.content.Context r5 = sContext     // Catch:{ all -> 0x028b }
            com.xiaomi.mipush.sdk.a r5 = com.xiaomi.mipush.sdk.a.a(r5)     // Catch:{ all -> 0x028b }
            int r5 = r5.a()     // Catch:{ all -> 0x028b }
            int r6 = com.xiaomi.mipush.sdk.Constants.a()     // Catch:{ all -> 0x028b }
            r7 = 1
            if (r5 == r6) goto L_0x0056
            r5 = 1
            goto L_0x0057
        L_0x0056:
            r5 = 0
        L_0x0057:
            if (r5 != 0) goto L_0x0070
            android.content.Context r6 = sContext     // Catch:{ all -> 0x028b }
            boolean r6 = shouldSendRegRequest(r6)     // Catch:{ all -> 0x028b }
            if (r6 != 0) goto L_0x0070
            android.content.Context r0 = sContext     // Catch:{ all -> 0x028b }
            com.xiaomi.mipush.sdk.ag r0 = com.xiaomi.mipush.sdk.ag.a(r0)     // Catch:{ all -> 0x028b }
            r0.a()     // Catch:{ all -> 0x028b }
            java.lang.String r0 = "Could not send  register message within 5s repeatly ."
            com.xiaomi.channel.commonutils.logger.b.a(r0)     // Catch:{ all -> 0x028b }
            return
        L_0x0070:
            r6 = 50011(0xc35b, float:7.008E-41)
            java.lang.String r8 = "5_1_1-G"
            if (r5 != 0) goto L_0x01c1
            android.content.Context r9 = sContext     // Catch:{ all -> 0x028b }
            com.xiaomi.mipush.sdk.a r9 = com.xiaomi.mipush.sdk.a.a(r9)     // Catch:{ all -> 0x028b }
            boolean r9 = r9.a(r12, r13)     // Catch:{ all -> 0x028b }
            if (r9 == 0) goto L_0x01c1
            android.content.Context r9 = sContext     // Catch:{ all -> 0x028b }
            com.xiaomi.mipush.sdk.a r9 = com.xiaomi.mipush.sdk.a.a(r9)     // Catch:{ all -> 0x028b }
            boolean r9 = r9.f()     // Catch:{ all -> 0x028b }
            if (r9 != 0) goto L_0x01c1
            if (r3 != 0) goto L_0x01c1
            android.content.Context r0 = sContext     // Catch:{ all -> 0x028b }
            int r0 = com.xiaomi.mipush.sdk.PushMessageHelper.getPushMode(r0)     // Catch:{ all -> 0x028b }
            r1 = 0
            if (r7 != r0) goto L_0x00af
            java.lang.String r0 = "callback"
            checkNotNull(r14, r0)     // Catch:{ all -> 0x028b }
            r9 = 0
            android.content.Context r0 = sContext     // Catch:{ all -> 0x028b }
            com.xiaomi.mipush.sdk.a r0 = com.xiaomi.mipush.sdk.a.a(r0)     // Catch:{ all -> 0x028b }
            java.lang.String r0 = r0.c()     // Catch:{ all -> 0x028b }
            r14.onInitializeResult(r9, r1, r0)     // Catch:{ all -> 0x028b }
            goto L_0x00d9
        L_0x00af:
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch:{ all -> 0x028b }
            r0.<init>()     // Catch:{ all -> 0x028b }
            android.content.Context r2 = sContext     // Catch:{ all -> 0x028b }
            com.xiaomi.mipush.sdk.a r2 = com.xiaomi.mipush.sdk.a.a(r2)     // Catch:{ all -> 0x028b }
            java.lang.String r2 = r2.c()     // Catch:{ all -> 0x028b }
            r0.add(r2)     // Catch:{ all -> 0x028b }
            com.xiaomi.push.bg r2 = com.xiaomi.push.bg.COMMAND_REGISTER     // Catch:{ all -> 0x028b }
            java.lang.String r2 = r2.f350a     // Catch:{ all -> 0x028b }
            r9 = 0
            r3 = 0
            r5 = 0
            r12 = r2
            r13 = r0
            r14 = r9
            r16 = r3
            r17 = r5
            com.xiaomi.mipush.sdk.MiPushCommandMessage r0 = com.xiaomi.mipush.sdk.PushMessageHelper.generateCommandMessage(r12, r13, r14, r16, r17)     // Catch:{ all -> 0x028b }
            android.content.Context r2 = sContext     // Catch:{ all -> 0x028b }
            com.xiaomi.mipush.sdk.PushMessageHelper.sendCommandMessageBroadcast(r2, r0)     // Catch:{ all -> 0x028b }
        L_0x00d9:
            android.content.Context r0 = sContext     // Catch:{ all -> 0x028b }
            com.xiaomi.mipush.sdk.ag r0 = com.xiaomi.mipush.sdk.ag.a(r0)     // Catch:{ all -> 0x028b }
            r0.a()     // Catch:{ all -> 0x028b }
            android.content.Context r0 = sContext     // Catch:{ all -> 0x028b }
            com.xiaomi.mipush.sdk.a r0 = com.xiaomi.mipush.sdk.a.a(r0)     // Catch:{ all -> 0x028b }
            boolean r0 = r0.a()     // Catch:{ all -> 0x028b }
            if (r0 == 0) goto L_0x0171
            com.xiaomi.push.dt r0 = new com.xiaomi.push.dt     // Catch:{ all -> 0x028b }
            r0.<init>()     // Catch:{ all -> 0x028b }
            android.content.Context r2 = sContext     // Catch:{ all -> 0x028b }
            com.xiaomi.mipush.sdk.a r2 = com.xiaomi.mipush.sdk.a.a(r2)     // Catch:{ all -> 0x028b }
            java.lang.String r2 = r2.a()     // Catch:{ all -> 0x028b }
            r0.b(r2)     // Catch:{ all -> 0x028b }
            com.xiaomi.push.df r2 = com.xiaomi.push.df.ClientInfoUpdate     // Catch:{ all -> 0x028b }
            java.lang.String r2 = r2.f458a     // Catch:{ all -> 0x028b }
            r0.c(r2)     // Catch:{ all -> 0x028b }
            java.lang.String r2 = com.xiaomi.push.service.aw.a()     // Catch:{ all -> 0x028b }
            r0.a(r2)     // Catch:{ all -> 0x028b }
            java.util.HashMap r2 = new java.util.HashMap     // Catch:{ all -> 0x028b }
            r2.<init>()     // Catch:{ all -> 0x028b }
            r0.f595a = r2     // Catch:{ all -> 0x028b }
            java.lang.String r3 = "app_version"
            android.content.Context r5 = sContext     // Catch:{ all -> 0x028b }
            android.content.Context r7 = sContext     // Catch:{ all -> 0x028b }
            java.lang.String r7 = r7.getPackageName()     // Catch:{ all -> 0x028b }
            java.lang.String r5 = com.xiaomi.channel.commonutils.android.a.a(r5, r7)     // Catch:{ all -> 0x028b }
            r2.put(r3, r5)     // Catch:{ all -> 0x028b }
            java.util.Map<java.lang.String, java.lang.String> r2 = r0.f595a     // Catch:{ all -> 0x028b }
            java.lang.String r3 = "app_version_code"
            android.content.Context r5 = sContext     // Catch:{ all -> 0x028b }
            android.content.Context r7 = sContext     // Catch:{ all -> 0x028b }
            java.lang.String r7 = r7.getPackageName()     // Catch:{ all -> 0x028b }
            int r5 = com.xiaomi.channel.commonutils.android.a.a(r5, r7)     // Catch:{ all -> 0x028b }
            java.lang.String r5 = java.lang.Integer.toString(r5)     // Catch:{ all -> 0x028b }
            r2.put(r3, r5)     // Catch:{ all -> 0x028b }
            java.util.Map<java.lang.String, java.lang.String> r2 = r0.f595a     // Catch:{ all -> 0x028b }
            java.lang.String r3 = "push_sdk_vn"
            r2.put(r3, r8)     // Catch:{ all -> 0x028b }
            java.util.Map<java.lang.String, java.lang.String> r2 = r0.f595a     // Catch:{ all -> 0x028b }
            java.lang.String r3 = "push_sdk_vc"
            java.lang.String r5 = java.lang.Integer.toString(r6)     // Catch:{ all -> 0x028b }
            r2.put(r3, r5)     // Catch:{ all -> 0x028b }
            android.content.Context r2 = sContext     // Catch:{ all -> 0x028b }
            com.xiaomi.mipush.sdk.a r2 = com.xiaomi.mipush.sdk.a.a(r2)     // Catch:{ all -> 0x028b }
            java.lang.String r2 = r2.e()     // Catch:{ all -> 0x028b }
            boolean r3 = android.text.TextUtils.isEmpty(r2)     // Catch:{ all -> 0x028b }
            if (r3 != 0) goto L_0x0166
            java.util.Map<java.lang.String, java.lang.String> r3 = r0.f595a     // Catch:{ all -> 0x028b }
            java.lang.String r5 = "deviceid"
            r3.put(r5, r2)     // Catch:{ all -> 0x028b }
        L_0x0166:
            android.content.Context r2 = sContext     // Catch:{ all -> 0x028b }
            com.xiaomi.mipush.sdk.ag r2 = com.xiaomi.mipush.sdk.ag.a(r2)     // Catch:{ all -> 0x028b }
            com.xiaomi.push.cz r3 = com.xiaomi.push.cz.Notification     // Catch:{ all -> 0x028b }
            r2.a(r0, r3, r4, r1)     // Catch:{ all -> 0x028b }
        L_0x0171:
            android.content.Context r0 = sContext     // Catch:{ all -> 0x028b }
            boolean r0 = shouldUseMIUIPush(r0)     // Catch:{ all -> 0x028b }
            if (r0 == 0) goto L_0x025e
            android.content.Context r0 = sContext     // Catch:{ all -> 0x028b }
            boolean r0 = shouldPullNotification(r0)     // Catch:{ all -> 0x028b }
            if (r0 == 0) goto L_0x025e
            com.xiaomi.push.dt r0 = new com.xiaomi.push.dt     // Catch:{ all -> 0x028b }
            r0.<init>()     // Catch:{ all -> 0x028b }
            android.content.Context r1 = sContext     // Catch:{ all -> 0x028b }
            com.xiaomi.mipush.sdk.a r1 = com.xiaomi.mipush.sdk.a.a(r1)     // Catch:{ all -> 0x028b }
            java.lang.String r1 = r1.a()     // Catch:{ all -> 0x028b }
            r0.b(r1)     // Catch:{ all -> 0x028b }
            com.xiaomi.push.df r1 = com.xiaomi.push.df.PullOfflineMessage     // Catch:{ all -> 0x028b }
            java.lang.String r1 = r1.f458a     // Catch:{ all -> 0x028b }
            r0.c(r1)     // Catch:{ all -> 0x028b }
            java.lang.String r1 = com.xiaomi.push.service.aw.a()     // Catch:{ all -> 0x028b }
            r0.a(r1)     // Catch:{ all -> 0x028b }
            r0.a(r4)     // Catch:{ all -> 0x028b }
            android.content.Context r1 = sContext     // Catch:{ all -> 0x028b }
            com.xiaomi.mipush.sdk.ag r1 = com.xiaomi.mipush.sdk.ag.a(r1)     // Catch:{ all -> 0x028b }
            com.xiaomi.push.cz r2 = com.xiaomi.push.cz.Notification     // Catch:{ all -> 0x028b }
            r3 = 0
            r4 = 0
            r5 = 0
            r12 = r1
            r13 = r0
            r14 = r2
            r15 = r3
            r16 = r4
            r17 = r5
            r12.a(r13, r14, r15, r16, r17)     // Catch:{ all -> 0x028b }
            android.content.Context r0 = sContext     // Catch:{ all -> 0x028b }
            addPullNotificationTime(r0)     // Catch:{ all -> 0x028b }
            goto L_0x025e
        L_0x01c1:
            r2 = 6
            java.lang.String r2 = com.xiaomi.push.ad.a(r2)     // Catch:{ all -> 0x028b }
            android.content.Context r4 = sContext     // Catch:{ all -> 0x028b }
            com.xiaomi.mipush.sdk.a r4 = com.xiaomi.mipush.sdk.a.a(r4)     // Catch:{ all -> 0x028b }
            r4.a()     // Catch:{ all -> 0x028b }
            android.content.Context r4 = sContext     // Catch:{ all -> 0x028b }
            com.xiaomi.mipush.sdk.a r4 = com.xiaomi.mipush.sdk.a.a(r4)     // Catch:{ all -> 0x028b }
            int r9 = com.xiaomi.mipush.sdk.Constants.a()     // Catch:{ all -> 0x028b }
            r4.a(r9)     // Catch:{ all -> 0x028b }
            android.content.Context r4 = sContext     // Catch:{ all -> 0x028b }
            com.xiaomi.mipush.sdk.a r4 = com.xiaomi.mipush.sdk.a.a(r4)     // Catch:{ all -> 0x028b }
            r4.a(r12, r13, r2)     // Catch:{ all -> 0x028b }
            android.content.Context r4 = sContext     // Catch:{ all -> 0x028b }
            clearExtras(r4)     // Catch:{ all -> 0x028b }
            clearNotification(r11)     // Catch:{ all -> 0x028b }
            com.xiaomi.push.du r4 = new com.xiaomi.push.du     // Catch:{ all -> 0x028b }
            r4.<init>()     // Catch:{ all -> 0x028b }
            java.lang.String r9 = com.xiaomi.push.service.aw.b()     // Catch:{ all -> 0x028b }
            r4.a(r9)     // Catch:{ all -> 0x028b }
            r4.b(r12)     // Catch:{ all -> 0x028b }
            r4.e(r13)     // Catch:{ all -> 0x028b }
            android.content.Context r0 = sContext     // Catch:{ all -> 0x028b }
            java.lang.String r0 = r0.getPackageName()     // Catch:{ all -> 0x028b }
            r4.d(r0)     // Catch:{ all -> 0x028b }
            r4.f(r2)     // Catch:{ all -> 0x028b }
            android.content.Context r0 = sContext     // Catch:{ all -> 0x028b }
            android.content.Context r1 = sContext     // Catch:{ all -> 0x028b }
            java.lang.String r1 = r1.getPackageName()     // Catch:{ all -> 0x028b }
            java.lang.String r0 = com.xiaomi.channel.commonutils.android.a.a(r0, r1)     // Catch:{ all -> 0x028b }
            r4.c(r0)     // Catch:{ all -> 0x028b }
            android.content.Context r0 = sContext     // Catch:{ all -> 0x028b }
            android.content.Context r1 = sContext     // Catch:{ all -> 0x028b }
            java.lang.String r1 = r1.getPackageName()     // Catch:{ all -> 0x028b }
            int r0 = com.xiaomi.channel.commonutils.android.a.a(r0, r1)     // Catch:{ all -> 0x028b }
            r4.b(r0)     // Catch:{ all -> 0x028b }
            r4.h(r8)     // Catch:{ all -> 0x028b }
            r4.a(r6)     // Catch:{ all -> 0x028b }
            com.xiaomi.push.dj r0 = com.xiaomi.push.dj.Init     // Catch:{ all -> 0x028b }
            r4.a(r0)     // Catch:{ all -> 0x028b }
            boolean r0 = android.text.TextUtils.isEmpty(r15)     // Catch:{ all -> 0x028b }
            if (r0 != 0) goto L_0x023e
            r0 = r15
            r4.g(r15)     // Catch:{ all -> 0x028b }
        L_0x023e:
            int r0 = com.xiaomi.channel.commonutils.android.c.a()     // Catch:{ all -> 0x028b }
            if (r0 < 0) goto L_0x0247
            r4.c(r0)     // Catch:{ all -> 0x028b }
        L_0x0247:
            android.content.Context r0 = sContext     // Catch:{ all -> 0x028b }
            com.xiaomi.mipush.sdk.ag r0 = com.xiaomi.mipush.sdk.ag.a(r0)     // Catch:{ all -> 0x028b }
            r0.a(r4, r5, r3)     // Catch:{ all -> 0x028b }
            android.content.Context r0 = sContext     // Catch:{ all -> 0x028b }
            java.lang.String r1 = "mipush_extra"
            r2 = 4
            android.content.SharedPreferences r0 = r0.getSharedPreferences(r1, r2)     // Catch:{ all -> 0x028b }
            java.lang.String r1 = "mipush_registed"
            r0.getBoolean(r1, r7)     // Catch:{ all -> 0x028b }
        L_0x025e:
            android.content.Context r0 = sContext     // Catch:{ all -> 0x028b }
            addRegRequestTime(r0)     // Catch:{ all -> 0x028b }
            scheduleOcVersionCheckJob()     // Catch:{ all -> 0x028b }
            android.content.Context r0 = sContext     // Catch:{ all -> 0x028b }
            java.lang.String r0 = r0.getPackageName()     // Catch:{ all -> 0x028b }
            java.lang.String r1 = "com.xiaomi.xmsf"
            boolean r0 = r0.equals(r1)     // Catch:{ all -> 0x028b }
            if (r0 != 0) goto L_0x0287
            com.xiaomi.channel.commonutils.logger.LoggerInterface r0 = com.xiaomi.mipush.sdk.Logger.getUserLogger()     // Catch:{ all -> 0x028b }
            if (r0 == 0) goto L_0x0283
            android.content.Context r0 = sContext     // Catch:{ all -> 0x028b }
            com.xiaomi.channel.commonutils.logger.LoggerInterface r1 = com.xiaomi.mipush.sdk.Logger.getUserLogger()     // Catch:{ all -> 0x028b }
            com.xiaomi.mipush.sdk.Logger.setLogger(r0, r1)     // Catch:{ all -> 0x028b }
        L_0x0283:
            r0 = 2
            com.xiaomi.channel.commonutils.logger.b.a(r0)     // Catch:{ all -> 0x028b }
        L_0x0287:
            operateSyncAction(r11)     // Catch:{ all -> 0x028b }
            goto L_0x028f
        L_0x028b:
            r0 = move-exception
            com.xiaomi.channel.commonutils.logger.b.a(r0)
        L_0x028f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.mipush.sdk.MiPushClient.initialize(android.content.Context, java.lang.String, java.lang.String, com.xiaomi.mipush.sdk.MiPushClient$MiPushClientCallback, java.lang.String, com.xiaomi.mipush.sdk.MiPushClient$ICallbackResult, java.lang.String):void");
    }

    public static void operateSyncAction(Context context) {
        if ("syncing".equals(x.a(sContext).a(am.DISABLE_PUSH))) {
            disablePush(sContext);
        }
        if ("syncing".equals(x.a(sContext).a(am.ENABLE_PUSH))) {
            enablePush(sContext);
        }
        if ("syncing".equals(x.a(sContext).a(am.UPLOAD_HUAWEI_TOKEN))) {
            syncAssemblePushToken(sContext);
        }
        if ("syncing".equals(x.a(sContext).a(am.UPLOAD_FCM_TOKEN))) {
            syncAssembleFCMPushToken(sContext);
        }
        if ("syncing".equals(x.a(sContext).a(am.UPLOAD_COS_TOKEN))) {
            syncAssembleCOSPushToken(context);
        }
        if ("syncing".equals(x.a(sContext).a(am.UPLOAD_FTOS_TOKEN))) {
            syncAssembleFTOSPushToken(context);
        }
    }

    public static void pausePush(Context context, String str) {
        if (!ag.a(context).a((String) "pausePush")) {
            setAcceptTime(context, 0, 0, 0, 0, str);
        }
    }

    public static void reInitialize(Context context, dj djVar) {
        b.e("re-register reason: " + djVar);
        String a2 = ad.a(6);
        String a3 = a.a(context).a();
        String b2 = a.a(context).b();
        a.a(context).a();
        clearExtrasForInitialize(context);
        clearNotification(context);
        a.a(context).a(Constants.a());
        a.a(context).a(a3, b2, a2);
        du duVar = new du();
        duVar.a(aw.b());
        duVar.b(a3);
        duVar.e(b2);
        duVar.f(a2);
        duVar.d(context.getPackageName());
        duVar.c(a.a(context, context.getPackageName()));
        duVar.b(a.a(context, context.getPackageName()));
        duVar.h((String) BuildConfig.VERSION_NAME);
        duVar.a((int) BuildConfig.VERSION_CODE);
        duVar.a(djVar);
        int a4 = c.a();
        if (a4 >= 0) {
            duVar.c(a4);
        }
        ag.a(context).a(duVar, false, false);
    }

    @Deprecated
    public static void registerCrashHandler(UncaughtExceptionHandler uncaughtExceptionHandler) {
        Thread.setDefaultUncaughtExceptionHandler(uncaughtExceptionHandler);
    }

    public static void registerNetworkReceiver(Context context) {
        try {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(Constant.INTENT_NETWORK_STATUS);
            intentFilter.addCategory("android.intent.category.DEFAULT");
            g.a(context.getApplicationContext(), new NetworkStatusReceiver(null), intentFilter, 2);
        } catch (Throwable th) {
            b.a("dynamic register network status receiver failed:" + th);
        }
    }

    public static void registerPush(Context context, String str, String str2) {
        registerPush(context, str, str2, new PushConfiguration());
    }

    public static void registerPush(Context context, String str, String str2, PushConfiguration pushConfiguration) {
        registerPush(context, str, str2, pushConfiguration, null, null);
    }

    public static void registerPush(Context context, final String str, final String str2, PushConfiguration pushConfiguration, final String str3, final ICallbackResult iCallbackResult) {
        checkNotNull(context, "context");
        checkNotNull(str, "appID");
        checkNotNull(str2, "appToken");
        if (!f.a()) {
            checkNotNull(sUserSetRegion, "region");
        }
        Context applicationContext = context.getApplicationContext();
        sContext = applicationContext;
        if (applicationContext == null) {
            sContext = context;
        }
        Context context2 = sContext;
        if (!ag.a(context2).a((String) "registerPush")) {
            j.a(context2);
            if (!NetworkStatusReceiver.a()) {
                registerNetworkReceiver(sContext);
            }
            d.a(sContext).a(pushConfiguration);
            o.a(context2).a((Runnable) new Runnable() {
                public void run() {
                    String str;
                    if (MiPushClient.sUserSetRegion != null) {
                        str = MiPushClient.sUserSetRegion.name();
                        MiPushClient.sUserSetRegion = null;
                    } else {
                        str = "";
                    }
                    MiPushClient.initialize(MiPushClient.sContext, str, str2, null, str3, iCallbackResult, str);
                }
            });
        }
    }

    public static void registerPush(Context context, String str, String str2, String str3) {
        registerPush(context, str, str2, new PushConfiguration(), str3, null);
    }

    public static void registerToken(Context context, String str, String str2, String str3, UPSRegisterCallBack uPSRegisterCallBack) {
        if (!ag.a(context).a((String) "registerToken")) {
            registerPush(context, str, str2, new PushConfiguration(), null, uPSRegisterCallBack);
        }
    }

    public static synchronized void removeAcceptTime(Context context) {
        synchronized (MiPushClient.class) {
            Editor edit = context.getSharedPreferences("mipush_extra", 0).edit();
            edit.remove(Constants.EXTRA_KEY_ACCEPT_TIME);
            h.a(edit);
        }
    }

    public static synchronized void removeAccount(Context context, String str) {
        synchronized (MiPushClient.class) {
            Editor edit = context.getSharedPreferences("mipush_extra", 0).edit();
            edit.remove("account_" + str).commit();
        }
    }

    public static synchronized void removeAlias(Context context, String str) {
        synchronized (MiPushClient.class) {
            Editor edit = context.getSharedPreferences("mipush_extra", 0).edit();
            edit.remove("alias_" + str).commit();
        }
    }

    public static synchronized void removeAllAccounts(Context context) {
        synchronized (MiPushClient.class) {
            for (String removeAccount : getAllUserAccount(context)) {
                removeAccount(context, removeAccount);
            }
        }
    }

    public static synchronized void removeAllAliases(Context context) {
        synchronized (MiPushClient.class) {
            for (String removeAlias : getAllAlias(context)) {
                removeAlias(context, removeAlias);
            }
        }
    }

    public static synchronized void removeAllTopics(Context context) {
        synchronized (MiPushClient.class) {
            for (String removeTopic : getAllTopic(context)) {
                removeTopic(context, removeTopic);
            }
        }
    }

    public static synchronized void removeTopic(Context context, String str) {
        synchronized (MiPushClient.class) {
            Editor edit = context.getSharedPreferences("mipush_extra", 0).edit();
            edit.remove("topic_" + str).commit();
        }
    }

    public static void reportAppRunInBackground(Context context, boolean z) {
        if (!ag.a(context).a((String) "reportAppRunInBackground") && a.a(context).b()) {
            df dfVar = z ? df.APP_SLEEP : df.APP_WAKEUP;
            dt dtVar = new dt();
            dtVar.b(a.a(context).a());
            dtVar.c(dfVar.f458a);
            dtVar.d(context.getPackageName());
            dtVar.a(aw.a());
            dtVar.a(false);
            ag.a(context).a(dtVar, cz.Notification, false, (di) null, false);
        }
    }

    public static void reportIgnoreRegMessageClicked(Context context, String str, di diVar, String str2, String str3) {
        dt dtVar = new dt();
        if (TextUtils.isEmpty(str3)) {
            b.d("do not report clicked message");
            return;
        }
        dtVar.b(str3);
        dtVar.c((String) "bar:click");
        dtVar.a(str);
        dtVar.a(false);
        ag.a(context).a(dtVar, cz.Notification, false, true, diVar, true, str2, str3);
    }

    public static void reportMessageClicked(Context context, MiPushMessage miPushMessage) {
        if (!ag.a(context).a((String) "reportMessageClicked")) {
            di diVar = new di();
            diVar.a(miPushMessage.getMessageId());
            diVar.b(miPushMessage.getTopic());
            diVar.d(miPushMessage.getDescription());
            diVar.c(miPushMessage.getTitle());
            diVar.c(miPushMessage.getNotifyId());
            diVar.a(miPushMessage.getNotifyType());
            diVar.b(miPushMessage.getPassThrough());
            diVar.a(miPushMessage.getExtra());
            reportMessageClicked(context, miPushMessage.getMessageId(), diVar, null);
        }
    }

    @Deprecated
    public static void reportMessageClicked(Context context, String str) {
        if (!ag.a(context).a((String) "reportMessageClicked")) {
            reportMessageClicked(context, str, null, null);
        }
    }

    public static void reportMessageClicked(Context context, String str, di diVar, String str2) {
        dt dtVar = new dt();
        if (TextUtils.isEmpty(str2)) {
            if (a.a(context).b()) {
                str2 = a.a(context).a();
            } else {
                b.d("do not report clicked message");
                return;
            }
        }
        dtVar.b(str2);
        dtVar.c((String) "bar:click");
        dtVar.a(str);
        dtVar.a(false);
        ag.a(context).a(dtVar, cz.Notification, false, diVar);
    }

    public static void resumePush(Context context, String str) {
        if (!ag.a(context).a((String) "resumePush")) {
            setAcceptTime(context, 0, 0, 23, 59, str);
        }
    }

    public static void scheduleOcVersionCheckJob() {
        o.a(sContext).a(new w(sContext), 86400, 5);
    }

    public static void setAcceptTime(Context context, int i, int i2, int i3, int i4, String str) {
        Context context2 = context;
        int i5 = i;
        int i6 = i2;
        int i7 = i3;
        int i8 = i4;
        if (!ag.a(context).a((String) "setAcceptTime")) {
            if (i5 < 0 || i5 >= 24 || i7 < 0 || i7 >= 24 || i6 < 0 || i6 >= 60 || i8 < 0 || i8 >= 60) {
                throw new IllegalArgumentException("the input parameter is not valid.");
            }
            long rawOffset = (long) (((TimeZone.getTimeZone("GMT+08").getRawOffset() - TimeZone.getDefault().getRawOffset()) / 1000) / 60);
            long j = ((((long) ((i5 * 60) + i6)) + rawOffset) + 1440) % 1440;
            long j2 = ((((long) ((i7 * 60) + i8)) + rawOffset) + 1440) % 1440;
            ArrayList arrayList = new ArrayList();
            arrayList.add(String.format("%1$02d:%2$02d", new Object[]{Long.valueOf(j / 60), Long.valueOf(j % 60)}));
            arrayList.add(String.format("%1$02d:%2$02d", new Object[]{Long.valueOf(j2 / 60), Long.valueOf(j2 % 60)}));
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(String.format("%1$02d:%2$02d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}));
            arrayList2.add(String.format("%1$02d:%2$02d", new Object[]{Integer.valueOf(i3), Integer.valueOf(i4)}));
            if (!acceptTimeSet(context2, (String) arrayList.get(0), (String) arrayList.get(1))) {
                setCommand(context2, bg.COMMAND_SET_ACCEPT_TIME.f350a, arrayList, str);
            } else if (1 == PushMessageHelper.getPushMode(context)) {
                PushMessageHandler.a(context, str, bg.COMMAND_SET_ACCEPT_TIME.f350a, 0, null, arrayList2);
            } else {
                PushMessageHelper.sendCommandMessageBroadcast(context2, PushMessageHelper.generateCommandMessage(bg.COMMAND_SET_ACCEPT_TIME.f350a, arrayList2, 0, null, null));
            }
        }
    }

    public static void setAlias(Context context, String str, String str2) {
        if (!ag.a(context).a((String) "setAlias") && !TextUtils.isEmpty(str)) {
            setCommand(context, bg.COMMAND_SET_ALIAS.f350a, str, str2);
        }
    }

    public static void setCommand(Context context, String str, String str2, String str3) {
        bg bgVar;
        String str4;
        StringBuilder sb;
        ArrayList arrayList = new ArrayList();
        if (!TextUtils.isEmpty(str2)) {
            arrayList.add(str2);
        }
        if (!bg.COMMAND_SET_ALIAS.f350a.equalsIgnoreCase(str) || Math.abs(System.currentTimeMillis() - aliasSetTime(context, str2)) >= 86400000) {
            if (bg.COMMAND_UNSET_ALIAS.f350a.equalsIgnoreCase(str) && aliasSetTime(context, str2) < 0) {
                sb = new StringBuilder();
                str4 = "Don't cancel alias for ";
            } else if (!bg.COMMAND_SET_ACCOUNT.f350a.equalsIgnoreCase(str) || Math.abs(System.currentTimeMillis() - accountSetTime(context, str2)) >= 3600000) {
                if (!bg.COMMAND_UNSET_ACCOUNT.f350a.equalsIgnoreCase(str) || accountSetTime(context, str2) >= 0) {
                    setCommand(context, str, arrayList, str3);
                    return;
                } else {
                    sb = new StringBuilder();
                    str4 = "Don't cancel account for ";
                }
            } else if (1 != PushMessageHelper.getPushMode(context)) {
                bgVar = bg.COMMAND_SET_ACCOUNT;
                PushMessageHelper.sendCommandMessageBroadcast(context, PushMessageHelper.generateCommandMessage(bgVar.f350a, arrayList, 0, null, str3));
                return;
            }
            sb.append(str4);
            sb.append(ad.a(arrayList.toString(), 3));
            sb.append(" is unseted");
            b.a(sb.toString());
            return;
        } else if (1 != PushMessageHelper.getPushMode(context)) {
            bgVar = bg.COMMAND_SET_ALIAS;
            PushMessageHelper.sendCommandMessageBroadcast(context, PushMessageHelper.generateCommandMessage(bgVar.f350a, arrayList, 0, null, str3));
            return;
        }
        PushMessageHandler.a(context, str3, str, 0, null, arrayList);
    }

    public static void setCommand(Context context, String str, ArrayList<String> arrayList, String str2) {
        if (!TextUtils.isEmpty(a.a(context).a())) {
            Cdo doVar = new Cdo();
            String a2 = aw.a();
            doVar.a(a2);
            doVar.b(a.a(context).a());
            doVar.c(str);
            Iterator<String> it = arrayList.iterator();
            while (it.hasNext()) {
                doVar.a(it.next());
            }
            doVar.e(str2);
            doVar.d(context.getPackageName());
            b.e("cmd:" + str + ", " + a2);
            ag.a(context).a(doVar, cz.Command, (di) null);
        }
    }

    public static void setLocalNotificationType(Context context, int i) {
        if (!ag.a(context).a((String) "setLocalNotificationType")) {
            ag.a(context).b(i & -1);
        }
    }

    public static void setRegion(Region region) {
        if (!f.a()) {
            sUserSetRegion = region;
        }
    }

    public static void setUserAccount(Context context, String str, String str2) {
        if (!ag.a(context).a((String) "setUserAccount") && !TextUtils.isEmpty(str)) {
            setCommand(context, bg.COMMAND_SET_ACCOUNT.f350a, str, str2);
        }
    }

    public static boolean shouldPullNotification(Context context) {
        return Math.abs(System.currentTimeMillis() - context.getSharedPreferences("mipush_extra", 0).getLong("last_pull_notification", -1)) > 300000;
    }

    public static boolean shouldSendRegRequest(Context context) {
        return Math.abs(System.currentTimeMillis() - context.getSharedPreferences("mipush_extra", 0).getLong("last_reg_request", -1)) > RemoteConfigManager.MIN_APP_START_CONFIG_FETCH_DELAY_MS;
    }

    public static boolean shouldUseMIUIPush(Context context) {
        return ag.a(context).a();
    }

    public static void subscribe(Context context, String str, String str2) {
        if (!ag.a(context).a((String) MqttServiceConstants.SUBSCRIBE_ACTION) && !TextUtils.isEmpty(a.a(context).a()) && !TextUtils.isEmpty(str)) {
            if (Math.abs(System.currentTimeMillis() - topicSubscribedTime(context, str)) > 86400000) {
                dy dyVar = new dy();
                String a2 = aw.a();
                dyVar.a(a2);
                dyVar.b(a.a(context).a());
                dyVar.c(str);
                dyVar.d(context.getPackageName());
                dyVar.e(str2);
                b.e("cmd:" + bg.COMMAND_SUBSCRIBE_TOPIC + ", " + a2);
                ag.a(context).a(dyVar, cz.Subscription, (di) null);
            } else if (1 == PushMessageHelper.getPushMode(context)) {
                PushMessageHandler.a(context, str2, 0, null, str);
            } else {
                ArrayList arrayList = new ArrayList();
                arrayList.add(str);
                PushMessageHelper.sendCommandMessageBroadcast(context, PushMessageHelper.generateCommandMessage(bg.COMMAND_SUBSCRIBE_TOPIC.f350a, arrayList, 0, null, null));
            }
        }
    }

    public static void syncAssembleCOSPushToken(Context context) {
        if (!ag.a(context).a((String) "syncAssembleCOSPushToken")) {
            ag.a(context).a((String) null, am.UPLOAD_COS_TOKEN, c.ASSEMBLE_PUSH_COS);
        }
    }

    public static void syncAssembleFCMPushToken(Context context) {
        if (!ag.a(context).a((String) "syncAssembleFCMPushToken")) {
            ag.a(context).a((String) null, am.UPLOAD_FCM_TOKEN, c.ASSEMBLE_PUSH_FCM);
        }
    }

    public static void syncAssembleFTOSPushToken(Context context) {
        if (!ag.a(context).a((String) "syncAssembleFTOSPushToken")) {
            ag.a(context).a((String) null, am.UPLOAD_FTOS_TOKEN, c.ASSEMBLE_PUSH_FTOS);
        }
    }

    public static void syncAssemblePushToken(Context context) {
        if (!ag.a(context).a((String) "syncAssemblePushToken")) {
            ag.a(context).a((String) null, am.UPLOAD_HUAWEI_TOKEN, c.ASSEMBLE_PUSH_HUAWEI);
        }
    }

    public static long topicSubscribedTime(Context context, String str) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("mipush_extra", 0);
        return sharedPreferences.getLong("topic_" + str, -1);
    }

    public static void turnOffPush(Context context, UPSTurnCallBack uPSTurnCallBack) {
        if (!ag.a(context).a((String) "turnOffPush")) {
            disablePush(context);
            if (uPSTurnCallBack != null) {
                CodeResult codeResult = new CodeResult();
                codeResult.setResultCode(0);
                codeResult.getResultCode();
                uPSTurnCallBack.onResult(codeResult);
            }
        }
    }

    public static void turnOnPush(Context context, UPSTurnCallBack uPSTurnCallBack) {
        if (!ag.a(context).a((String) "turnOnPush")) {
            enablePush(context);
            if (uPSTurnCallBack != null) {
                CodeResult codeResult = new CodeResult();
                codeResult.setResultCode(0);
                codeResult.getResultCode();
                uPSTurnCallBack.onResult(codeResult);
            }
        }
    }

    public static void unRegisterToken(Context context, UPSUnRegisterCallBack uPSUnRegisterCallBack) {
        if (!ag.a(context).a((String) "unRegisterToken")) {
            unregisterPush(context);
            if (uPSUnRegisterCallBack != null) {
                TokenResult tokenResult = new TokenResult();
                tokenResult.setToken(null);
                tokenResult.getToken();
                tokenResult.setResultCode(0);
                tokenResult.getResultCode();
                uPSUnRegisterCallBack.onResult(tokenResult);
            }
        }
    }

    public static void unregisterPush(Context context) {
        if (!ag.a(context).a((String) "unregisterPush")) {
            g.c(context);
            at.a(context).a();
            if (a.a(context).b()) {
                ea eaVar = new ea();
                eaVar.a(aw.a());
                eaVar.b(a.a(context).a());
                eaVar.c(a.a(context).c());
                eaVar.e(a.a(context).b());
                eaVar.d(context.getPackageName());
                ag.a(context).a(eaVar);
                PushMessageHandler.a();
                PushMessageHandler.b();
                a.a(context).b();
                clearLocalNotificationType(context);
                clearNotification(context);
                clearExtras(context);
            }
        }
    }

    public static void unsetAlias(Context context, String str, String str2) {
        if (!ag.a(context).a((String) "unsetAlias")) {
            setCommand(context, bg.COMMAND_UNSET_ALIAS.f350a, str, str2);
        }
    }

    public static void unsetUserAccount(Context context, String str, String str2) {
        if (!ag.a(context).a((String) "unsetUserAccount")) {
            setCommand(context, bg.COMMAND_UNSET_ACCOUNT.f350a, str, str2);
        }
    }

    public static void unsubscribe(Context context, String str, String str2) {
        if (ag.a(context).a((String) MqttServiceConstants.UNSUBSCRIBE_ACTION) || !a.a(context).b()) {
            return;
        }
        if (topicSubscribedTime(context, str) < 0) {
            b.a("Don't cancel subscribe for " + str + " is unsubscribed");
            return;
        }
        ec ecVar = new ec();
        String a2 = aw.a();
        ecVar.a(a2);
        ecVar.b(a.a(context).a());
        ecVar.c(str);
        ecVar.d(context.getPackageName());
        ecVar.e(str2);
        b.e("cmd:" + bg.COMMAND_UNSUBSCRIBE_TOPIC + ", " + a2);
        ag.a(context).a(ecVar, cz.UnSubscription, (di) null);
    }
}
