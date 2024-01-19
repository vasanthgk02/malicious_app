package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.google.firebase.perf.config.RemoteConfigManager;
import com.xiaomi.channel.commonutils.android.a;
import com.xiaomi.channel.commonutils.android.a.b;
import com.xiaomi.channel.commonutils.android.c;
import com.xiaomi.mipush.sdk.a.C0067a;
import com.xiaomi.push.BuildConfig;
import com.xiaomi.push.ad;
import com.xiaomi.push.bg;
import com.xiaomi.push.cz;
import com.xiaomi.push.df;
import com.xiaomi.push.di;
import com.xiaomi.push.dj;
import com.xiaomi.push.dl;
import com.xiaomi.push.dt;
import com.xiaomi.push.du;
import com.xiaomi.push.dv;
import com.xiaomi.push.ea;
import com.xiaomi.push.eb;
import com.xiaomi.push.ee;
import com.xiaomi.push.service.ag;
import com.xiaomi.push.service.aw;
import com.xiaomi.push.service.bj;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class MiPushClient4Hybrid {
    public static Map<String, C0067a> dataMap = new HashMap();
    public static MiPushCallback sCallback;
    public static Map<String, Long> sRegisterTimeMap = new HashMap();

    public static class MiPushCallback {
        public void onCommandResult(String str, MiPushCommandMessage miPushCommandMessage) {
        }

        public void onReceiveRegisterResult(String str, MiPushCommandMessage miPushCommandMessage) {
        }

        public void onReceiveUnregisterResult(String str, MiPushCommandMessage miPushCommandMessage) {
        }
    }

    public static void addPullNotificationTime(Context context, String str) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("mipush_extra", 0);
        sharedPreferences.edit().putLong(GeneratedOutlineSupport.outline50("last_pull_notification_", str), System.currentTimeMillis()).commit();
    }

    public static short getDeviceStatus(MiPushMessage miPushMessage, boolean z) {
        String str = miPushMessage.getExtra() == null ? "" : miPushMessage.getExtra().get(Constants.EXTRA_KEY_HYBRID_DEVICE_STATUS);
        int i = 0;
        if (!TextUtils.isEmpty(str)) {
            i = Integer.valueOf(str).intValue();
        }
        if (!z) {
            i = b.NOT_ALLOWED.a() + (i & -4);
        }
        return (short) i;
    }

    public static boolean isRegistered(Context context, String str) {
        return a.a(context).a(str) != null;
    }

    public static void onReceiveRegisterResult(Context context, dv dvVar) {
        String c2 = dvVar.c();
        if (dvVar.a() == 0) {
            C0067a aVar = dataMap.get(c2);
            if (aVar != null) {
                aVar.a(dvVar.f649e, dvVar.f650f);
                a.a(context).a(c2, aVar);
            }
        }
        ArrayList arrayList = null;
        if (!TextUtils.isEmpty(dvVar.f649e)) {
            arrayList = new ArrayList();
            arrayList.add(dvVar.f649e);
        }
        MiPushCommandMessage generateCommandMessage = PushMessageHelper.generateCommandMessage(bg.COMMAND_REGISTER.f350a, arrayList, dvVar.f639a, dvVar.f648d, null);
        MiPushCallback miPushCallback = sCallback;
        if (miPushCallback != null) {
            miPushCallback.onReceiveRegisterResult(c2, generateCommandMessage);
        }
    }

    public static void onReceiveUnregisterResult(Context context, eb ebVar) {
        MiPushCommandMessage generateCommandMessage = PushMessageHelper.generateCommandMessage(bg.COMMAND_UNREGISTER.f350a, null, ebVar.f715a, ebVar.f723d, null);
        String a2 = ebVar.a();
        MiPushCallback miPushCallback = sCallback;
        if (miPushCallback != null) {
            miPushCallback.onReceiveUnregisterResult(a2, generateCommandMessage);
        }
    }

    public static void registerPush(Context context, String str, String str2, String str3) {
        if (a.a(context).a(str2, str3, str)) {
            ArrayList arrayList = new ArrayList();
            C0067a a2 = a.a(context).a(str);
            if (a2 != null) {
                arrayList.add(a2.f4336c);
                MiPushCommandMessage generateCommandMessage = PushMessageHelper.generateCommandMessage(bg.COMMAND_REGISTER.f350a, arrayList, 0, null, null);
                MiPushCallback miPushCallback = sCallback;
                if (miPushCallback != null) {
                    miPushCallback.onReceiveRegisterResult(str, generateCommandMessage);
                }
            }
            if (shouldPullNotification(context, str)) {
                dt dtVar = new dt();
                dtVar.b(str2);
                dtVar.c(df.PullOfflineMessage.f458a);
                dtVar.a(aw.a());
                dtVar.a(false);
                ag.a(context).a(dtVar, cz.Notification, false, true, null, false, str, str2);
                com.xiaomi.channel.commonutils.logger.b.b("MiPushClient4Hybrid pull offline pass through message");
                addPullNotificationTime(context, str);
            }
        } else {
            long currentTimeMillis = System.currentTimeMillis();
            if (Math.abs(currentTimeMillis - (sRegisterTimeMap.get(str) != null ? sRegisterTimeMap.get(str).longValue() : 0)) < RemoteConfigManager.MIN_APP_START_CONFIG_FETCH_DELAY_MS) {
                com.xiaomi.channel.commonutils.logger.b.a((String) "MiPushClient4Hybrid  Could not send register message within 5s repeatedly.");
                return;
            }
            sRegisterTimeMap.put(str, Long.valueOf(currentTimeMillis));
            String a3 = ad.a(6);
            C0067a aVar = new C0067a(context);
            aVar.c(str2, str3, a3);
            dataMap.put(str, aVar);
            du duVar = new du();
            duVar.a(aw.a());
            duVar.b(str2);
            duVar.e(str3);
            duVar.d(str);
            duVar.f(a3);
            duVar.c(a.a(context, context.getPackageName()));
            duVar.b(a.a(context, context.getPackageName()));
            duVar.h((String) BuildConfig.VERSION_NAME);
            duVar.a((int) BuildConfig.VERSION_CODE);
            duVar.a(dj.Init);
            int a4 = c.a();
            if (a4 >= 0) {
                duVar.c(a4);
            }
            dt dtVar2 = new dt();
            dtVar2.c(df.HybridRegister.f458a);
            dtVar2.b(a.a(context).a());
            dtVar2.d(context.getPackageName());
            dtVar2.a(ee.a(duVar));
            dtVar2.a(aw.a());
            ag.a(context).a(dtVar2, cz.Notification, (di) null);
        }
    }

    public static void removeDuplicateCache(Context context, MiPushMessage miPushMessage) {
        String str = miPushMessage.getExtra() != null ? miPushMessage.getExtra().get("jobkey") : null;
        if (TextUtils.isEmpty(str)) {
            str = miPushMessage.getMessageId();
        }
        ae.a(context, str);
    }

    public static void reportMessageArrived(Context context, MiPushMessage miPushMessage, boolean z) {
        if (miPushMessage == null || miPushMessage.getExtra() == null) {
            com.xiaomi.channel.commonutils.logger.b.a((String) "do not ack message, message is null");
            return;
        }
        try {
            dl dlVar = new dl();
            dlVar.b(a.a(context).a());
            dlVar.a(miPushMessage.getMessageId());
            dlVar.a(Long.valueOf(miPushMessage.getExtra().get(Constants.EXTRA_KEY_HYBRID_MESSAGE_TS)).longValue());
            dlVar.a(getDeviceStatus(miPushMessage, z));
            if (!TextUtils.isEmpty(miPushMessage.getTopic())) {
                dlVar.c(miPushMessage.getTopic());
            }
            ag.a(context).a(dlVar, cz.AckMessage, false, bj.a(PushMessageHelper.generateMessage(miPushMessage)));
            com.xiaomi.channel.commonutils.logger.b.b("MiPushClient4Hybrid ack mina message, messageId is " + miPushMessage.getMessageId());
        } catch (Throwable th) {
            miPushMessage.getExtra().remove(Constants.EXTRA_KEY_HYBRID_MESSAGE_TS);
            miPushMessage.getExtra().remove(Constants.EXTRA_KEY_HYBRID_DEVICE_STATUS);
            throw th;
        }
        miPushMessage.getExtra().remove(Constants.EXTRA_KEY_HYBRID_MESSAGE_TS);
        miPushMessage.getExtra().remove(Constants.EXTRA_KEY_HYBRID_DEVICE_STATUS);
    }

    public static void reportMessageClicked(Context context, MiPushMessage miPushMessage) {
        MiPushClient.reportMessageClicked(context, miPushMessage);
    }

    public static void setCallback(MiPushCallback miPushCallback) {
        sCallback = miPushCallback;
    }

    public static boolean shouldPullNotification(Context context, String str) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("mipush_extra", 0);
        StringBuilder sb = new StringBuilder();
        sb.append("last_pull_notification_");
        sb.append(str);
        return Math.abs(System.currentTimeMillis() - sharedPreferences.getLong(sb.toString(), -1)) > 300000;
    }

    public static void unregisterPush(Context context, String str) {
        sRegisterTimeMap.remove(str);
        C0067a a2 = a.a(context).a(str);
        if (a2 != null) {
            ea eaVar = new ea();
            eaVar.a(aw.a());
            eaVar.d(str);
            eaVar.b(a2.f198a);
            eaVar.c(a2.f4336c);
            eaVar.e(a2.f4335b);
            dt dtVar = new dt();
            dtVar.c(df.HybridUnregister.f458a);
            dtVar.b(a.a(context).a());
            dtVar.d(context.getPackageName());
            dtVar.a(ee.a(eaVar));
            dtVar.a(aw.a());
            ag.a(context).a(dtVar, cz.Notification, (di) null);
            a.a(context).b(str);
        }
    }

    public static void uploadClearMessageData(Context context, LinkedList<? extends Object> linkedList) {
        ag.a(context, linkedList);
    }
}
