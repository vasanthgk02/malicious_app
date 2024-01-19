package com.xiaomi.mipush.sdk;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.o;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class MessageHandleService extends BaseService {

    /* renamed from: a  reason: collision with root package name */
    public static ConcurrentLinkedQueue<a> f4328a = new ConcurrentLinkedQueue<>();

    /* renamed from: a  reason: collision with other field name */
    public static ExecutorService f189a;

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public Intent f4329a;

        /* renamed from: a  reason: collision with other field name */
        public PushMessageReceiver f190a;

        public a(Intent intent, PushMessageReceiver pushMessageReceiver) {
            this.f190a = pushMessageReceiver;
            this.f4329a = intent;
        }

        public Intent a() {
            return this.f4329a;
        }

        /* renamed from: a  reason: collision with other method in class */
        public PushMessageReceiver m337a() {
            return this.f190a;
        }
    }

    static {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 1, 15, TimeUnit.SECONDS, new LinkedBlockingQueue());
        f189a = threadPoolExecutor;
    }

    public static void a(Context context, Intent intent) {
        if (intent != null) {
            b(context);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0093, code lost:
        if (r10.getResultCode() == 0) goto L_0x0095;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x0169, code lost:
        if (r1.getResultCode() == 0) goto L_0x0095;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(android.content.Context r9, com.xiaomi.mipush.sdk.MessageHandleService.a r10) {
        /*
            if (r10 != 0) goto L_0x0003
            return
        L_0x0003:
            com.xiaomi.mipush.sdk.PushMessageReceiver r0 = r10.a()     // Catch:{ RuntimeException -> 0x016d }
            android.content.Intent r10 = r10.a()     // Catch:{ RuntimeException -> 0x016d }
            java.lang.String r1 = "message_type"
            r2 = 1
            int r1 = r10.getIntExtra(r1, r2)     // Catch:{ RuntimeException -> 0x016d }
            r3 = 0
            java.lang.String r5 = ", reason="
            java.lang.String r6 = ", resultCode="
            if (r1 == r2) goto L_0x009a
            r2 = 3
            if (r1 == r2) goto L_0x0042
            r2 = 5
            if (r1 == r2) goto L_0x0022
            goto L_0x0171
        L_0x0022:
            java.lang.String r1 = "error_type"
            java.lang.String r1 = r10.getStringExtra(r1)     // Catch:{ RuntimeException -> 0x016d }
            java.lang.String r2 = "error_lack_of_permission"
            boolean r1 = r2.equals(r1)     // Catch:{ RuntimeException -> 0x016d }
            if (r1 == 0) goto L_0x0171
            java.lang.String r1 = "error_message"
            java.lang.String[] r10 = r10.getStringArrayExtra(r1)     // Catch:{ RuntimeException -> 0x016d }
            if (r10 == 0) goto L_0x0171
            java.lang.String r1 = "begin execute onRequirePermissions, lack of necessary permissions"
            com.xiaomi.channel.commonutils.logger.b.e(r1)     // Catch:{ RuntimeException -> 0x016d }
            r0.onRequirePermissions(r9, r10)     // Catch:{ RuntimeException -> 0x016d }
            goto L_0x0171
        L_0x0042:
            java.lang.String r1 = "key_command"
            java.io.Serializable r10 = r10.getSerializableExtra(r1)     // Catch:{ RuntimeException -> 0x016d }
            com.xiaomi.mipush.sdk.MiPushCommandMessage r10 = (com.xiaomi.mipush.sdk.MiPushCommandMessage) r10     // Catch:{ RuntimeException -> 0x016d }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ RuntimeException -> 0x016d }
            r1.<init>()     // Catch:{ RuntimeException -> 0x016d }
            java.lang.String r2 = "(Local) begin execute onCommandResult, command="
            r1.append(r2)     // Catch:{ RuntimeException -> 0x016d }
            java.lang.String r2 = r10.getCommand()     // Catch:{ RuntimeException -> 0x016d }
            r1.append(r2)     // Catch:{ RuntimeException -> 0x016d }
            r1.append(r6)     // Catch:{ RuntimeException -> 0x016d }
            long r6 = r10.getResultCode()     // Catch:{ RuntimeException -> 0x016d }
            r1.append(r6)     // Catch:{ RuntimeException -> 0x016d }
            r1.append(r5)     // Catch:{ RuntimeException -> 0x016d }
            java.lang.String r2 = r10.getReason()     // Catch:{ RuntimeException -> 0x016d }
            r1.append(r2)     // Catch:{ RuntimeException -> 0x016d }
            java.lang.String r1 = r1.toString()     // Catch:{ RuntimeException -> 0x016d }
            com.xiaomi.channel.commonutils.logger.b.e(r1)     // Catch:{ RuntimeException -> 0x016d }
            r0.onCommandResult(r9, r10)     // Catch:{ RuntimeException -> 0x016d }
            java.lang.String r1 = r10.getCommand()     // Catch:{ RuntimeException -> 0x016d }
            com.xiaomi.push.bg r2 = com.xiaomi.push.bg.COMMAND_REGISTER     // Catch:{ RuntimeException -> 0x016d }
            java.lang.String r2 = r2.f350a     // Catch:{ RuntimeException -> 0x016d }
            boolean r1 = android.text.TextUtils.equals(r1, r2)     // Catch:{ RuntimeException -> 0x016d }
            if (r1 == 0) goto L_0x0171
            r0.onReceiveRegisterResult(r9, r10)     // Catch:{ RuntimeException -> 0x016d }
            com.xiaomi.mipush.sdk.PushMessageHandler.a(r9, r10)     // Catch:{ RuntimeException -> 0x016d }
            long r0 = r10.getResultCode()     // Catch:{ RuntimeException -> 0x016d }
            int r10 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r10 != 0) goto L_0x0171
        L_0x0095:
            com.xiaomi.mipush.sdk.g.b(r9)     // Catch:{ RuntimeException -> 0x016d }
            goto L_0x0171
        L_0x009a:
            com.xiaomi.mipush.sdk.ae r1 = com.xiaomi.mipush.sdk.ae.a(r9)     // Catch:{ RuntimeException -> 0x016d }
            com.xiaomi.mipush.sdk.PushMessageHandler$a r1 = r1.a(r10)     // Catch:{ RuntimeException -> 0x016d }
            java.lang.String r7 = "eventMessageType"
            r8 = -1
            r10.getIntExtra(r7, r8)     // Catch:{ RuntimeException -> 0x016d }
            if (r1 == 0) goto L_0x0171
            boolean r10 = r1 instanceof com.xiaomi.mipush.sdk.MiPushMessage     // Catch:{ RuntimeException -> 0x016d }
            if (r10 == 0) goto L_0x011a
            com.xiaomi.mipush.sdk.MiPushMessage r1 = (com.xiaomi.mipush.sdk.MiPushMessage) r1     // Catch:{ RuntimeException -> 0x016d }
            boolean r10 = r1.isArrivedMessage()     // Catch:{ RuntimeException -> 0x016d }
            if (r10 != 0) goto L_0x00b9
            r0.onReceiveMessage(r9, r1)     // Catch:{ RuntimeException -> 0x016d }
        L_0x00b9:
            int r10 = r1.getPassThrough()     // Catch:{ RuntimeException -> 0x016d }
            if (r10 != r2) goto L_0x00dc
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ RuntimeException -> 0x016d }
            r10.<init>()     // Catch:{ RuntimeException -> 0x016d }
            java.lang.String r2 = "begin execute onReceivePassThroughMessage from "
            r10.append(r2)     // Catch:{ RuntimeException -> 0x016d }
            java.lang.String r2 = r1.getMessageId()     // Catch:{ RuntimeException -> 0x016d }
            r10.append(r2)     // Catch:{ RuntimeException -> 0x016d }
            java.lang.String r10 = r10.toString()     // Catch:{ RuntimeException -> 0x016d }
            com.xiaomi.channel.commonutils.logger.b.e(r10)     // Catch:{ RuntimeException -> 0x016d }
            r0.onReceivePassThroughMessage(r9, r1)     // Catch:{ RuntimeException -> 0x016d }
            goto L_0x0171
        L_0x00dc:
            boolean r10 = r1.isNotified()     // Catch:{ RuntimeException -> 0x016d }
            if (r10 == 0) goto L_0x00fe
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ RuntimeException -> 0x016d }
            r10.<init>()     // Catch:{ RuntimeException -> 0x016d }
            java.lang.String r2 = "begin execute onNotificationMessageClicked from　"
            r10.append(r2)     // Catch:{ RuntimeException -> 0x016d }
            java.lang.String r2 = r1.getMessageId()     // Catch:{ RuntimeException -> 0x016d }
            r10.append(r2)     // Catch:{ RuntimeException -> 0x016d }
            java.lang.String r10 = r10.toString()     // Catch:{ RuntimeException -> 0x016d }
            com.xiaomi.channel.commonutils.logger.b.e(r10)     // Catch:{ RuntimeException -> 0x016d }
            r0.onNotificationMessageClicked(r9, r1)     // Catch:{ RuntimeException -> 0x016d }
            goto L_0x0171
        L_0x00fe:
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ RuntimeException -> 0x016d }
            r10.<init>()     // Catch:{ RuntimeException -> 0x016d }
            java.lang.String r2 = "begin execute onNotificationMessageArrived from "
            r10.append(r2)     // Catch:{ RuntimeException -> 0x016d }
            java.lang.String r2 = r1.getMessageId()     // Catch:{ RuntimeException -> 0x016d }
            r10.append(r2)     // Catch:{ RuntimeException -> 0x016d }
            java.lang.String r10 = r10.toString()     // Catch:{ RuntimeException -> 0x016d }
            com.xiaomi.channel.commonutils.logger.b.e(r10)     // Catch:{ RuntimeException -> 0x016d }
            r0.onNotificationMessageArrived(r9, r1)     // Catch:{ RuntimeException -> 0x016d }
            goto L_0x0171
        L_0x011a:
            boolean r10 = r1 instanceof com.xiaomi.mipush.sdk.MiPushCommandMessage     // Catch:{ RuntimeException -> 0x016d }
            if (r10 == 0) goto L_0x0171
            com.xiaomi.mipush.sdk.MiPushCommandMessage r1 = (com.xiaomi.mipush.sdk.MiPushCommandMessage) r1     // Catch:{ RuntimeException -> 0x016d }
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ RuntimeException -> 0x016d }
            r10.<init>()     // Catch:{ RuntimeException -> 0x016d }
            java.lang.String r2 = "begin execute onCommandResult, command="
            r10.append(r2)     // Catch:{ RuntimeException -> 0x016d }
            java.lang.String r2 = r1.getCommand()     // Catch:{ RuntimeException -> 0x016d }
            r10.append(r2)     // Catch:{ RuntimeException -> 0x016d }
            r10.append(r6)     // Catch:{ RuntimeException -> 0x016d }
            long r6 = r1.getResultCode()     // Catch:{ RuntimeException -> 0x016d }
            r10.append(r6)     // Catch:{ RuntimeException -> 0x016d }
            r10.append(r5)     // Catch:{ RuntimeException -> 0x016d }
            java.lang.String r2 = r1.getReason()     // Catch:{ RuntimeException -> 0x016d }
            r10.append(r2)     // Catch:{ RuntimeException -> 0x016d }
            java.lang.String r10 = r10.toString()     // Catch:{ RuntimeException -> 0x016d }
            com.xiaomi.channel.commonutils.logger.b.e(r10)     // Catch:{ RuntimeException -> 0x016d }
            r0.onCommandResult(r9, r1)     // Catch:{ RuntimeException -> 0x016d }
            java.lang.String r10 = r1.getCommand()     // Catch:{ RuntimeException -> 0x016d }
            com.xiaomi.push.bg r2 = com.xiaomi.push.bg.COMMAND_REGISTER     // Catch:{ RuntimeException -> 0x016d }
            java.lang.String r2 = r2.f350a     // Catch:{ RuntimeException -> 0x016d }
            boolean r10 = android.text.TextUtils.equals(r10, r2)     // Catch:{ RuntimeException -> 0x016d }
            if (r10 == 0) goto L_0x0171
            r0.onReceiveRegisterResult(r9, r1)     // Catch:{ RuntimeException -> 0x016d }
            com.xiaomi.mipush.sdk.PushMessageHandler.a(r9, r1)     // Catch:{ RuntimeException -> 0x016d }
            long r0 = r1.getResultCode()     // Catch:{ RuntimeException -> 0x016d }
            int r10 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r10 != 0) goto L_0x0171
            goto L_0x0095
        L_0x016d:
            r9 = move-exception
            com.xiaomi.channel.commonutils.logger.b.a(r9)
        L_0x0171:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.mipush.sdk.MessageHandleService.a(android.content.Context, com.xiaomi.mipush.sdk.MessageHandleService$a):void");
    }

    public static void addJob(Context context, a aVar) {
        if (aVar != null) {
            f4328a.add(aVar);
            b(context);
            startService(context);
        }
    }

    public static void b(Context context) {
        if (!f189a.isShutdown()) {
            f189a.execute(new t(context));
        }
    }

    public static void c(Context context) {
        try {
            a(context, f4328a.poll());
        } catch (RuntimeException e2) {
            b.a((Throwable) e2);
        }
    }

    public static void startService(Context context) {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(context, MessageHandleService.class));
        o.a(context).a((Runnable) new s(context, intent));
    }

    public boolean a() {
        ConcurrentLinkedQueue<a> concurrentLinkedQueue = f4328a;
        return concurrentLinkedQueue != null && concurrentLinkedQueue.size() > 0;
    }

    public IBinder onBind(Intent intent) {
        return null;
    }

    public void onStart(Intent intent, int i) {
        super.onStart(intent, i);
    }
}
