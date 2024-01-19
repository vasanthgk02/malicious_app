package com.xiaomi.mipush.sdk;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.os.IBinder;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.android.j;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.mipush.sdk.MiPushClient.ICallbackResult;
import com.xiaomi.mipush.sdk.MiPushClient.MiPushClientCallback;
import com.xiaomi.mipush.sdk.MiPushClient.TokenResult;
import com.xiaomi.mipush.sdk.MiPushClient.UPSRegisterCallBack;
import com.xiaomi.push.bg;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class PushMessageHandler extends BaseService {

    /* renamed from: a  reason: collision with root package name */
    public static List<ICallbackResult> f4331a = new ArrayList();

    /* renamed from: a  reason: collision with other field name */
    public static ThreadPoolExecutor f192a;

    /* renamed from: b  reason: collision with root package name */
    public static List<MiPushClientCallback> f4332b = new ArrayList();

    public interface a extends Serializable {
    }

    static {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 1, 15, TimeUnit.SECONDS, new LinkedBlockingQueue());
        f192a = threadPoolExecutor;
    }

    public static void a() {
        synchronized (f4332b) {
            f4332b.clear();
        }
    }

    public static void a(long j, String str, String str2) {
        synchronized (f4332b) {
            for (MiPushClientCallback onInitializeResult : f4332b) {
                onInitializeResult.onInitializeResult(j, str, str2);
            }
        }
    }

    public static void a(Context context) {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(context, PushMessageHandler.class));
        try {
            context.startService(intent);
        } catch (Exception e2) {
            b.a(e2.getMessage());
        }
    }

    public static void a(Context context, Intent intent) {
        b.c("addjob PushMessageHandler " + intent);
        if (intent != null) {
            c(context, intent);
            a(context);
        }
    }

    public static void a(Context context, Intent intent, ResolveInfo resolveInfo, boolean z) {
        try {
            com.xiaomi.mipush.sdk.MessageHandleService.a aVar = new com.xiaomi.mipush.sdk.MessageHandleService.a(intent, (PushMessageReceiver) j.a(context, resolveInfo.activityInfo.name).newInstance());
            if (z) {
                MessageHandleService.a(context.getApplicationContext(), aVar);
            } else {
                MessageHandleService.addJob(context.getApplicationContext(), aVar);
            }
            MessageHandleService.a(context, new Intent(context.getApplicationContext(), MessageHandleService.class));
        } catch (Throwable th) {
            b.a(th);
        }
    }

    public static void a(Context context, MiPushCommandMessage miPushCommandMessage) {
        synchronized (f4331a) {
            for (ICallbackResult next : f4331a) {
                if (next instanceof UPSRegisterCallBack) {
                    TokenResult tokenResult = new TokenResult();
                    if (!(miPushCommandMessage == null || miPushCommandMessage.getCommandArguments() == null || miPushCommandMessage.getCommandArguments().size() <= 0)) {
                        tokenResult.setResultCode(miPushCommandMessage.getResultCode());
                        tokenResult.setToken(miPushCommandMessage.getCommandArguments().get(0));
                    }
                    next.onResult(tokenResult);
                }
            }
        }
    }

    public static void a(Context context, MiPushMessage miPushMessage) {
        synchronized (f4332b) {
            for (MiPushClientCallback next : f4332b) {
                if (a(miPushMessage.getCategory(), next.getCategory())) {
                    next.onReceiveMessage(miPushMessage.getContent(), miPushMessage.getAlias(), miPushMessage.getTopic(), miPushMessage.isNotified());
                    next.onReceiveMessage(miPushMessage);
                }
            }
        }
    }

    public static void a(Context context, a aVar) {
        if (aVar instanceof MiPushMessage) {
            a(context, (MiPushMessage) aVar);
        } else if (aVar instanceof MiPushCommandMessage) {
            MiPushCommandMessage miPushCommandMessage = (MiPushCommandMessage) aVar;
            String command = miPushCommandMessage.getCommand();
            String str = null;
            if (bg.COMMAND_REGISTER.f350a.equals(command)) {
                List<String> commandArguments = miPushCommandMessage.getCommandArguments();
                if (commandArguments != null && !commandArguments.isEmpty()) {
                    str = commandArguments.get(0);
                }
                a(miPushCommandMessage.getResultCode(), miPushCommandMessage.getReason(), str);
            } else if (bg.COMMAND_SET_ALIAS.f350a.equals(command) || bg.COMMAND_UNSET_ALIAS.f350a.equals(command) || bg.COMMAND_SET_ACCEPT_TIME.f350a.equals(command)) {
                a(context, miPushCommandMessage.getCategory(), command, miPushCommandMessage.getResultCode(), miPushCommandMessage.getReason(), miPushCommandMessage.getCommandArguments());
            } else if (bg.COMMAND_SUBSCRIBE_TOPIC.f350a.equals(command)) {
                List<String> commandArguments2 = miPushCommandMessage.getCommandArguments();
                if (commandArguments2 != null && !commandArguments2.isEmpty()) {
                    str = commandArguments2.get(0);
                }
                Context context2 = context;
                a(context2, miPushCommandMessage.getCategory(), miPushCommandMessage.getResultCode(), miPushCommandMessage.getReason(), str);
            } else if (bg.COMMAND_UNSUBSCRIBE_TOPIC.f350a.equals(command)) {
                List<String> commandArguments3 = miPushCommandMessage.getCommandArguments();
                if (commandArguments3 != null && !commandArguments3.isEmpty()) {
                    str = commandArguments3.get(0);
                }
                Context context3 = context;
                b(context3, miPushCommandMessage.getCategory(), miPushCommandMessage.getResultCode(), miPushCommandMessage.getReason(), str);
            }
        }
    }

    public static void a(Context context, String str, long j, String str2, String str3) {
        synchronized (f4332b) {
            for (MiPushClientCallback next : f4332b) {
                if (a(str, next.getCategory())) {
                    next.onSubscribeResult(j, str2, str3);
                }
            }
        }
    }

    public static void a(Context context, String str, String str2, long j, String str3, List<String> list) {
        synchronized (f4332b) {
            for (MiPushClientCallback next : f4332b) {
                if (a(str, next.getCategory())) {
                    next.onCommandResult(str2, j, str3, list);
                }
            }
        }
    }

    public static void a(ICallbackResult iCallbackResult) {
        synchronized (f4331a) {
            if (!f4331a.contains(iCallbackResult)) {
                f4331a.add(iCallbackResult);
            }
        }
    }

    public static void a(MiPushClientCallback miPushClientCallback) {
        synchronized (f4332b) {
            if (!f4332b.contains(miPushClientCallback)) {
                f4332b.add(miPushClientCallback);
            }
        }
    }

    public static boolean a(String str, String str2) {
        return (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) || TextUtils.equals(str, str2);
    }

    public static void b() {
        synchronized (f4331a) {
            f4331a.clear();
        }
    }

    public static void b(Context context) {
        try {
            Intent intent = new Intent();
            intent.setPackage(context.getPackageName());
            intent.setAction("action_clicked_activity_finish");
            context.sendBroadcast(intent, b.a(context));
        } catch (Exception e2) {
            b.a("callback sync error" + e2);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00c0, code lost:
        if (r0 == false) goto L_0x00cc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x00cc, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void b(android.content.Context r6, android.content.Intent r7) {
        /*
            r0 = 0
            java.lang.String r1 = "is_clicked_activity_call"
            boolean r0 = r7.getBooleanExtra(r1, r0)     // Catch:{ all -> 0x0008 }
            goto L_0x001d
        L_0x0008:
            r1 = move-exception
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "intent unparcel error:"
            r2.append(r3)
            r2.append(r1)
            java.lang.String r1 = r2.toString()
            com.xiaomi.channel.commonutils.logger.b.a(r1)
        L_0x001d:
            java.lang.String r1 = "com.xiaomi.mipush.SEND_TINYDATA"
            java.lang.String r2 = r7.getAction()     // Catch:{ all -> 0x00c3 }
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x00c3 }
            if (r1 == 0) goto L_0x002b
            goto L_0x00c0
        L_0x002b:
            r1 = 1
            int r2 = com.xiaomi.mipush.sdk.PushMessageHelper.getPushMode(r6)     // Catch:{ all -> 0x00c3 }
            if (r1 != r2) goto L_0x0052
            boolean r1 = b()     // Catch:{ all -> 0x00c3 }
            if (r1 == 0) goto L_0x0043
            java.lang.String r7 = "receive a message before application calling initialize"
            com.xiaomi.channel.commonutils.logger.b.d(r7)     // Catch:{ all -> 0x00c3 }
            if (r0 == 0) goto L_0x0042
            b(r6)
        L_0x0042:
            return
        L_0x0043:
            com.xiaomi.mipush.sdk.ae r1 = com.xiaomi.mipush.sdk.ae.a(r6)     // Catch:{ all -> 0x00c3 }
            com.xiaomi.mipush.sdk.PushMessageHandler$a r7 = r1.a(r7)     // Catch:{ all -> 0x00c3 }
            if (r7 == 0) goto L_0x00c0
            a(r6, r7)     // Catch:{ all -> 0x00c3 }
            goto L_0x00c0
        L_0x0052:
            java.lang.String r1 = "com.xiaomi.mipush.sdk.SYNC_LOG"
            java.lang.String r2 = r7.getAction()     // Catch:{ all -> 0x00c3 }
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x00c3 }
            if (r1 == 0) goto L_0x005f
            goto L_0x00c0
        L_0x005f:
            android.content.Intent r1 = new android.content.Intent     // Catch:{ all -> 0x00c3 }
            java.lang.String r2 = "com.xiaomi.mipush.RECEIVE_MESSAGE"
            r1.<init>(r2)     // Catch:{ all -> 0x00c3 }
            java.lang.String r2 = r6.getPackageName()     // Catch:{ all -> 0x00c3 }
            r1.setPackage(r2)     // Catch:{ all -> 0x00c3 }
            r1.putExtras(r7)     // Catch:{ all -> 0x00c3 }
            android.content.pm.PackageManager r7 = r6.getPackageManager()     // Catch:{ all -> 0x00c3 }
            r2 = 32
            java.util.List r7 = r7.queryBroadcastReceivers(r1, r2)     // Catch:{ Exception -> 0x00bc }
            r2 = 0
            if (r7 == 0) goto L_0x00b0
            java.util.Iterator r7 = r7.iterator()     // Catch:{ Exception -> 0x00bc }
        L_0x0081:
            boolean r3 = r7.hasNext()     // Catch:{ Exception -> 0x00bc }
            if (r3 == 0) goto L_0x00b0
            java.lang.Object r3 = r7.next()     // Catch:{ Exception -> 0x00bc }
            android.content.pm.ResolveInfo r3 = (android.content.pm.ResolveInfo) r3     // Catch:{ Exception -> 0x00bc }
            android.content.pm.ActivityInfo r4 = r3.activityInfo     // Catch:{ Exception -> 0x00bc }
            if (r4 == 0) goto L_0x0081
            android.content.pm.ActivityInfo r4 = r3.activityInfo     // Catch:{ Exception -> 0x00bc }
            java.lang.String r4 = r4.packageName     // Catch:{ Exception -> 0x00bc }
            java.lang.String r5 = r6.getPackageName()     // Catch:{ Exception -> 0x00bc }
            boolean r4 = r4.equals(r5)     // Catch:{ Exception -> 0x00bc }
            if (r4 == 0) goto L_0x0081
            java.lang.Class<com.xiaomi.mipush.sdk.PushMessageReceiver> r4 = com.xiaomi.mipush.sdk.PushMessageReceiver.class
            android.content.pm.ActivityInfo r5 = r3.activityInfo     // Catch:{ Exception -> 0x00bc }
            java.lang.String r5 = r5.name     // Catch:{ Exception -> 0x00bc }
            java.lang.Class r5 = com.xiaomi.channel.commonutils.android.j.a(r6, r5)     // Catch:{ Exception -> 0x00bc }
            boolean r4 = r4.isAssignableFrom(r5)     // Catch:{ Exception -> 0x00bc }
            if (r4 == 0) goto L_0x0081
            r2 = r3
        L_0x00b0:
            if (r2 == 0) goto L_0x00b6
            a(r6, r1, r2, r0)     // Catch:{ Exception -> 0x00bc }
            goto L_0x00c0
        L_0x00b6:
            java.lang.String r7 = "cannot find the receiver to handler this message, check your manifest"
            com.xiaomi.channel.commonutils.logger.b.d(r7)     // Catch:{ Exception -> 0x00bc }
            goto L_0x00c0
        L_0x00bc:
            r7 = move-exception
            com.xiaomi.channel.commonutils.logger.b.a(r7)     // Catch:{ all -> 0x00c3 }
        L_0x00c0:
            if (r0 == 0) goto L_0x00cc
            goto L_0x00c9
        L_0x00c3:
            r7 = move-exception
            com.xiaomi.channel.commonutils.logger.b.a(r7)     // Catch:{ all -> 0x00cd }
            if (r0 == 0) goto L_0x00cc
        L_0x00c9:
            b(r6)
        L_0x00cc:
            return
        L_0x00cd:
            r7 = move-exception
            if (r0 == 0) goto L_0x00d3
            b(r6)
        L_0x00d3:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.mipush.sdk.PushMessageHandler.b(android.content.Context, android.content.Intent):void");
    }

    public static void b(Context context, String str, long j, String str2, String str3) {
        synchronized (f4332b) {
            for (MiPushClientCallback next : f4332b) {
                if (a(str, next.getCategory())) {
                    next.onUnsubscribeResult(j, str2, str3);
                }
            }
        }
    }

    /* renamed from: b  reason: collision with other method in class */
    public static boolean m338b() {
        return f4332b.isEmpty();
    }

    public static void c(Context context, Intent intent) {
        if (intent != null && !f192a.isShutdown()) {
            f192a.execute(new ad(context, intent));
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m339a() {
        ThreadPoolExecutor threadPoolExecutor = f192a;
        return (threadPoolExecutor == null || threadPoolExecutor.getQueue() == null || f192a.getQueue().size() <= 0) ? false : true;
    }

    public IBinder onBind(Intent intent) {
        return null;
    }

    public void onStart(Intent intent, int i) {
        super.onStart(intent, i);
        c(getApplicationContext(), intent);
    }
}
