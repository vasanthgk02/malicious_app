package com.xiaomi.push.service;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.Notification.BigPictureStyle;
import android.app.Notification.BigTextStyle;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.service.notification.StatusBarNotification;
import android.text.TextUtils;
import android.util.Pair;
import android.widget.RemoteViews;
import com.netcore.android.notification.SMTNotificationConstants;
import com.squareup.picasso.NetworkRequestHandler;
import com.xiaomi.channel.commonutils.android.f;
import com.xiaomi.channel.commonutils.android.k;
import com.xiaomi.push.ax;
import com.xiaomi.push.ay;
import com.xiaomi.push.az;
import com.xiaomi.push.di;
import com.xiaomi.push.dq;
import com.xiaomi.push.z;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.jboss.netty.handler.codec.rtsp.RtspHeaders.Values;
import org.json.JSONException;
import org.json.JSONObject;

public class ag {

    /* renamed from: a  reason: collision with root package name */
    public static long f4846a;

    /* renamed from: a  reason: collision with other field name */
    public static volatile al f831a;

    /* renamed from: a  reason: collision with other field name */
    public static final LinkedList<Pair<Integer, dq>> f832a = new LinkedList<>();

    /* renamed from: a  reason: collision with other field name */
    public static ExecutorService f833a = Executors.newCachedThreadPool();

    public static class a implements Callable<Bitmap> {

        /* renamed from: a  reason: collision with root package name */
        public Context f4847a;

        /* renamed from: a  reason: collision with other field name */
        public String f834a;

        /* renamed from: a  reason: collision with other field name */
        public boolean f835a;

        public a(String str, Context context, boolean z) {
            this.f4847a = context;
            this.f834a = str;
            this.f835a = z;
        }

        /* renamed from: a */
        public Bitmap call() {
            Bitmap bitmap = null;
            if (!TextUtils.isEmpty(this.f834a)) {
                if (this.f834a.startsWith(NetworkRequestHandler.SCHEME_HTTP)) {
                    com.xiaomi.push.service.ap.b a2 = ap.a(this.f4847a, this.f834a, this.f835a);
                    if (a2 != null) {
                        return a2.f848a;
                    }
                } else {
                    bitmap = ap.a(this.f4847a, this.f834a);
                    if (bitmap != null) {
                        return bitmap;
                    }
                }
                com.xiaomi.channel.commonutils.logger.b.a((String) "Failed get online picture/icon resource");
                return bitmap;
            }
            com.xiaomi.channel.commonutils.logger.b.a((String) "Failed get online picture/icon resource cause picUrl is empty");
            return null;
        }
    }

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public long f4848a = 0;

        /* renamed from: a  reason: collision with other field name */
        public Notification f836a;
    }

    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public long f4849a = 0;

        /* renamed from: a  reason: collision with other field name */
        public String f837a;

        /* renamed from: a  reason: collision with other field name */
        public boolean f838a = false;
    }

    public static int a(Context context, String str) {
        return context.getSharedPreferences("pref_notify_type", 0).getInt(str, Integer.MAX_VALUE);
    }

    public static int a(Context context, String str, String str2) {
        if (str.equals(context.getPackageName())) {
            return context.getResources().getIdentifier(str2, "drawable", str);
        }
        return 0;
    }

    public static int a(Context context, String str, Map<String, String> map, int i) {
        Intent b2 = b(context, str, map, i);
        if (b2 != null) {
            ComponentName a2 = l.a(context, b2);
            if (a2 != null) {
                return a2.hashCode();
            }
        }
        return 0;
    }

    public static int a(Map<String, String> map) {
        String str = map == null ? null : map.get(Values.TIMEOUT);
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        try {
            return Integer.parseInt(str);
        } catch (Exception unused) {
            return 0;
        }
    }

    public static Notification a(Notification notification) {
        Object a2 = z.a((Object) notification, (String) "extraNotification");
        if (a2 != null) {
            z.a(a2, (String) "setCustomizedIcon", Boolean.TRUE);
        }
        return notification;
    }

    public static PendingIntent a(Context context, dq dqVar, String str, byte[] bArr, int i) {
        return a(context, dqVar, str, bArr, i, 0, a(context, dqVar, str));
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x0095  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x009a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.app.PendingIntent a(android.content.Context r15, com.xiaomi.push.dq r16, java.lang.String r17, byte[] r18, int r19, int r20, boolean r21) {
        /*
            r6 = r15
            r0 = r17
            boolean r1 = c(r16)
            if (r1 == 0) goto L_0x000c
            r1 = 1000(0x3e8, float:1.401E-42)
            goto L_0x0016
        L_0x000c:
            boolean r1 = a(r16)
            if (r1 == 0) goto L_0x0015
            r1 = 3000(0xbb8, float:4.204E-42)
            goto L_0x0016
        L_0x0015:
            r1 = -1
        L_0x0016:
            com.xiaomi.push.di r3 = r16.a()
            if (r3 == 0) goto L_0x0021
            java.lang.String r2 = r3.a()
            goto L_0x0023
        L_0x0021:
            java.lang.String r2 = ""
        L_0x0023:
            r4 = r2
            boolean r2 = a(r16)
            java.lang.String r5 = "eventMessageType"
            java.lang.String r7 = "messageId"
            r8 = 167772160(0xa000000, float:6.162976E-33)
            r9 = 134217728(0x8000000, float:3.85186E-34)
            r10 = 31
            r11 = 0
            if (r3 == 0) goto L_0x009f
            java.lang.String r12 = r3.f502e
            boolean r12 = android.text.TextUtils.isEmpty(r12)
            if (r12 != 0) goto L_0x009f
            android.content.Intent r2 = new android.content.Intent
            java.lang.String r12 = "android.intent.action.VIEW"
            r2.<init>(r12)
            java.lang.String r12 = r3.f502e
            android.net.Uri r12 = android.net.Uri.parse(r12)
            r2.setData(r12)
            java.net.URL r12 = new java.net.URL     // Catch:{ MalformedURLException -> 0x0071 }
            java.lang.String r13 = r3.f502e     // Catch:{ MalformedURLException -> 0x0071 }
            r12.<init>(r13)     // Catch:{ MalformedURLException -> 0x0071 }
            java.lang.String r12 = r12.getProtocol()     // Catch:{ MalformedURLException -> 0x0071 }
            java.lang.String r13 = "http"
            boolean r13 = r13.equals(r12)     // Catch:{ MalformedURLException -> 0x0071 }
            if (r13 != 0) goto L_0x006d
            java.lang.String r13 = "https"
            boolean r12 = r13.equals(r12)     // Catch:{ MalformedURLException -> 0x0071 }
            if (r12 == 0) goto L_0x0069
            goto L_0x006d
        L_0x0069:
            r2.setPackage(r0)     // Catch:{ MalformedURLException -> 0x0071 }
            goto L_0x0086
        L_0x006d:
            com.xiaomi.push.service.ar.a(r15, r2)     // Catch:{ MalformedURLException -> 0x0071 }
            goto L_0x0086
        L_0x0071:
            java.lang.String r12 = "meet URL exception : "
            java.lang.StringBuilder r12 = com.android.tools.r8.GeneratedOutlineSupport.outline73(r12)
            java.lang.String r3 = r3.f502e
            r12.append(r3)
            java.lang.String r3 = r12.toString()
            com.xiaomi.channel.commonutils.logger.b.a(r3)
            r2.setPackage(r0)
        L_0x0086:
            r0 = 268435456(0x10000000, float:2.524355E-29)
            r2.addFlags(r0)
            r2.putExtra(r7, r4)
            r2.putExtra(r5, r1)
            int r0 = android.os.Build.VERSION.SDK_INT
            if (r0 < r10) goto L_0x009a
            android.app.PendingIntent r0 = android.app.PendingIntent.getActivity(r15, r11, r2, r8)
            return r0
        L_0x009a:
            android.app.PendingIntent r0 = android.app.PendingIntent.getActivity(r15, r11, r2, r9)
            return r0
        L_0x009f:
            r8 = 1
            java.lang.String r9 = "mipush_notified"
            java.lang.String r10 = "mipush_payload"
            java.lang.String r11 = "com.xiaomi.mipush.sdk.PushMessageHandler"
            android.content.Intent r12 = new android.content.Intent
            if (r2 == 0) goto L_0x00b5
            r12.<init>()
            android.content.ComponentName r13 = new android.content.ComponentName
            java.lang.String r14 = "com.xiaomi.xmsf"
            r13.<init>(r14, r11)
            goto L_0x00bf
        L_0x00b5:
            java.lang.String r13 = "com.xiaomi.mipush.RECEIVE_MESSAGE"
            r12.<init>(r13)
            android.content.ComponentName r13 = new android.content.ComponentName
            r13.<init>(r0, r11)
        L_0x00bf:
            r12.setComponent(r13)
            r11 = r18
            r12.putExtra(r10, r11)
            r12.putExtra(r9, r8)
            java.lang.String r8 = java.lang.String.valueOf(r19)
            r12.addCategory(r8)
            java.lang.String r8 = java.lang.String.valueOf(r4)
            r12.addCategory(r8)
            java.lang.String r8 = "notification_click_button"
            r9 = r20
            r12.putExtra(r8, r9)
            r12.putExtra(r7, r4)
            r12.putExtra(r5, r1)
            if (r2 != 0) goto L_0x0133
            if (r21 == 0) goto L_0x0133
            android.content.Intent r7 = new android.content.Intent
            r7.<init>()
            android.content.ComponentName r0 = a(r17)
            r7.setComponent(r0)
            r0 = 276824064(0x10800000, float:5.04871E-29)
            r7.addFlags(r0)
            java.lang.String r0 = "mipush_serviceIntent"
            r7.putExtra(r0, r12)
            java.lang.String r0 = java.lang.String.valueOf(r19)
            r7.addCategory(r0)
            java.lang.String r0 = java.lang.String.valueOf(r4)
            r7.addCategory(r0)
            java.lang.String r0 = java.lang.String.valueOf(r20)
            r7.addCategory(r0)
            r0 = r15
            r1 = r7
            r2 = r16
            r5 = r20
            a(r0, r1, r2, r3, r4, r5)
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 31
            if (r0 < r1) goto L_0x012b
            r0 = 167772160(0xa000000, float:6.162976E-33)
            r1 = 0
            android.app.PendingIntent r0 = android.app.PendingIntent.getActivity(r15, r1, r7, r0)
            return r0
        L_0x012b:
            r0 = 134217728(0x8000000, float:3.85186E-34)
            r1 = 0
            android.app.PendingIntent r0 = android.app.PendingIntent.getActivity(r15, r1, r7, r0)
            return r0
        L_0x0133:
            r0 = r15
            r1 = r12
            r2 = r16
            r5 = r20
            a(r0, r1, r2, r3, r4, r5)
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 31
            if (r0 < r1) goto L_0x014a
            r0 = 167772160(0xa000000, float:6.162976E-33)
            r1 = 0
            android.app.PendingIntent r0 = android.app.PendingIntent.getService(r15, r1, r12, r0)
            return r0
        L_0x014a:
            r0 = 134217728(0x8000000, float:3.85186E-34)
            r1 = 0
            android.app.PendingIntent r0 = android.app.PendingIntent.getService(r15, r1, r12, r0)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.service.ag.a(android.content.Context, com.xiaomi.push.dq, java.lang.String, byte[], int, int, boolean):android.app.PendingIntent");
    }

    public static PendingIntent a(Context context, String str, dq dqVar, byte[] bArr, int i, int i2) {
        Map a2 = dqVar.a().a();
        PendingIntent pendingIntent = null;
        if (a2 == null) {
            return null;
        }
        boolean a3 = a(context, dqVar, str);
        if (a3) {
            pendingIntent = a(context, dqVar, str, bArr, i, i2, a3);
        } else {
            Intent a4 = a(context, str, a2, i2);
            if (a4 != null) {
                pendingIntent = PendingIntent.getActivity(context, 0, a4, VERSION.SDK_INT >= 31 ? 167772160 : 134217728);
            }
        }
        return pendingIntent;
    }

    public static ComponentName a(String str) {
        return new ComponentName(str, "com.xiaomi.mipush.sdk.NotificationClickedActivity");
    }

    /* renamed from: a  reason: collision with other method in class */
    public static Intent m792a(Context context, String str, Map<String, String> map, int i) {
        if (b(map)) {
            return a(context, str, map, String.format("cust_btn_%s_ne", new Object[]{Integer.valueOf(i)}), String.format("cust_btn_%s_iu", new Object[]{Integer.valueOf(i)}), String.format("cust_btn_%s_ic", new Object[]{Integer.valueOf(i)}), String.format("cust_btn_%s_wu", new Object[]{Integer.valueOf(i)}));
        } else if (i == 1) {
            return a(context, str, map, (String) "notification_style_button_left_notify_effect", (String) "notification_style_button_left_intent_uri", (String) "notification_style_button_left_intent_class", (String) "notification_style_button_left_web_uri");
        } else {
            if (i == 2) {
                return a(context, str, map, (String) "notification_style_button_mid_notify_effect", (String) "notification_style_button_mid_intent_uri", (String) "notification_style_button_mid_intent_class", (String) "notification_style_button_mid_web_uri");
            }
            if (i == 3) {
                return a(context, str, map, (String) "notification_style_button_right_notify_effect", (String) "notification_style_button_right_intent_uri", (String) "notification_style_button_right_intent_class", (String) "notification_style_button_right_web_uri");
            }
            if (i != 4) {
                return null;
            }
            return a(context, str, map, (String) "notification_colorful_button_notify_effect", (String) "notification_colorful_button_intent_uri", (String) "notification_colorful_button_intent_class", (String) "notification_colorful_button_web_uri");
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:52:0x00f5  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.content.Intent a(android.content.Context r3, java.lang.String r4, java.util.Map<java.lang.String, java.lang.String> r5, java.lang.String r6, java.lang.String r7, java.lang.String r8, java.lang.String r9) {
        /*
            java.lang.Object r6 = r5.get(r6)
            java.lang.String r6 = (java.lang.String) r6
            boolean r0 = android.text.TextUtils.isEmpty(r6)
            r1 = 0
            if (r0 == 0) goto L_0x000e
            return r1
        L_0x000e:
            java.lang.String r0 = com.xiaomi.push.service.bd.f4898a
            boolean r0 = r0.equals(r6)
            java.lang.String r2 = "Cause: "
            if (r0 == 0) goto L_0x0037
            android.content.pm.PackageManager r5 = r3.getPackageManager()     // Catch:{ Exception -> 0x0022 }
            android.content.Intent r4 = r5.getLaunchIntentForPackage(r4)     // Catch:{ Exception -> 0x0022 }
            goto L_0x00f3
        L_0x0022:
            r4 = move-exception
            java.lang.StringBuilder r5 = com.android.tools.r8.GeneratedOutlineSupport.outline73(r2)
            java.lang.String r4 = r4.getMessage()
            r5.append(r4)
            java.lang.String r4 = r5.toString()
            com.xiaomi.channel.commonutils.logger.b.d(r4)
            goto L_0x00f2
        L_0x0037:
            java.lang.String r0 = com.xiaomi.push.service.bd.f4899b
            boolean r0 = r0.equals(r6)
            if (r0 == 0) goto L_0x0082
            boolean r9 = r5.containsKey(r7)
            if (r9 == 0) goto L_0x0066
            java.lang.Object r5 = r5.get(r7)
            java.lang.String r5 = (java.lang.String) r5
            if (r5 == 0) goto L_0x00f2
            r7 = 1
            android.content.Intent r5 = android.content.Intent.parseUri(r5, r7)     // Catch:{ URISyntaxException -> 0x005a }
            r5.setPackage(r4)     // Catch:{ URISyntaxException -> 0x0058 }
        L_0x0055:
            r4 = r5
            goto L_0x00f3
        L_0x0058:
            r4 = move-exception
            goto L_0x005c
        L_0x005a:
            r4 = move-exception
            r5 = r1
        L_0x005c:
            java.lang.StringBuilder r7 = com.android.tools.r8.GeneratedOutlineSupport.outline73(r2)
            java.lang.String r4 = r4.getMessage()
            goto L_0x00e6
        L_0x0066:
            boolean r7 = r5.containsKey(r8)
            if (r7 == 0) goto L_0x00f2
            java.lang.Object r5 = r5.get(r8)
            java.lang.String r5 = (java.lang.String) r5
            android.content.Intent r7 = new android.content.Intent
            r7.<init>()
            android.content.ComponentName r8 = new android.content.ComponentName
            r8.<init>(r4, r5)
            r7.setComponent(r8)
            r4 = r7
            goto L_0x00f3
        L_0x0082:
            java.lang.String r4 = com.xiaomi.push.service.bd.f4900c
            boolean r4 = r4.equals(r6)
            if (r4 == 0) goto L_0x00f2
            java.lang.Object r4 = r5.get(r9)
            java.lang.String r4 = (java.lang.String) r4
            boolean r5 = android.text.TextUtils.isEmpty(r4)
            if (r5 != 0) goto L_0x00f2
            java.lang.String r4 = r4.trim()
            java.lang.String r5 = "http://"
            boolean r7 = r4.startsWith(r5)
            if (r7 != 0) goto L_0x00ae
            java.lang.String r7 = "https://"
            boolean r7 = r4.startsWith(r7)
            if (r7 != 0) goto L_0x00ae
            java.lang.String r4 = com.android.tools.r8.GeneratedOutlineSupport.outline50(r5, r4)
        L_0x00ae:
            java.net.URL r5 = new java.net.URL     // Catch:{ MalformedURLException -> 0x00dc }
            r5.<init>(r4)     // Catch:{ MalformedURLException -> 0x00dc }
            java.lang.String r5 = r5.getProtocol()     // Catch:{ MalformedURLException -> 0x00dc }
            java.lang.String r7 = "http"
            boolean r7 = r7.equals(r5)     // Catch:{ MalformedURLException -> 0x00dc }
            if (r7 != 0) goto L_0x00c7
            java.lang.String r7 = "https"
            boolean r5 = r7.equals(r5)     // Catch:{ MalformedURLException -> 0x00dc }
            if (r5 == 0) goto L_0x00f2
        L_0x00c7:
            android.content.Intent r5 = new android.content.Intent     // Catch:{ MalformedURLException -> 0x00dc }
            java.lang.String r7 = "android.intent.action.VIEW"
            r5.<init>(r7)     // Catch:{ MalformedURLException -> 0x00dc }
            android.net.Uri r4 = android.net.Uri.parse(r4)     // Catch:{ MalformedURLException -> 0x00da }
            r5.setData(r4)     // Catch:{ MalformedURLException -> 0x00da }
            com.xiaomi.push.service.ar.a(r3, r5)     // Catch:{ MalformedURLException -> 0x00da }
            goto L_0x0055
        L_0x00da:
            r4 = move-exception
            goto L_0x00de
        L_0x00dc:
            r4 = move-exception
            r5 = r1
        L_0x00de:
            java.lang.StringBuilder r7 = com.android.tools.r8.GeneratedOutlineSupport.outline73(r2)
            java.lang.String r4 = r4.getMessage()
        L_0x00e6:
            r7.append(r4)
            java.lang.String r4 = r7.toString()
            com.xiaomi.channel.commonutils.logger.b.d(r4)
            goto L_0x0055
        L_0x00f2:
            r4 = r1
        L_0x00f3:
            if (r4 == 0) goto L_0x0149
            r5 = 268435456(0x10000000, float:2.524355E-29)
            r4.addFlags(r5)
            android.content.pm.PackageManager r5 = r3.getPackageManager()     // Catch:{ Exception -> 0x0136 }
            r7 = 65536(0x10000, float:9.1835E-41)
            android.content.pm.ResolveInfo r5 = r5.resolveActivity(r4, r7)     // Catch:{ Exception -> 0x0136 }
            if (r5 == 0) goto L_0x0107
            return r4
        L_0x0107:
            int r5 = android.os.Build.VERSION.SDK_INT     // Catch:{ Exception -> 0x0136 }
            r7 = 30
            if (r5 < r7) goto L_0x011c
            boolean r3 = com.xiaomi.channel.commonutils.android.f.a(r3)     // Catch:{ Exception -> 0x0136 }
            if (r3 != 0) goto L_0x011c
            java.lang.String r3 = com.xiaomi.push.service.bd.f4900c     // Catch:{ Exception -> 0x0136 }
            boolean r3 = r3.equals(r6)     // Catch:{ Exception -> 0x0136 }
            if (r3 == 0) goto L_0x011c
            return r4
        L_0x011c:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0136 }
            r3.<init>()     // Catch:{ Exception -> 0x0136 }
            java.lang.String r5 = "not resolve activity:"
            r3.append(r5)     // Catch:{ Exception -> 0x0136 }
            r3.append(r4)     // Catch:{ Exception -> 0x0136 }
            java.lang.String r4 = "for buttons"
            r3.append(r4)     // Catch:{ Exception -> 0x0136 }
            java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x0136 }
            com.xiaomi.channel.commonutils.logger.b.a(r3)     // Catch:{ Exception -> 0x0136 }
            goto L_0x0149
        L_0x0136:
            r3 = move-exception
            java.lang.StringBuilder r4 = com.android.tools.r8.GeneratedOutlineSupport.outline73(r2)
            java.lang.String r3 = r3.getMessage()
            r4.append(r3)
            java.lang.String r3 = r4.toString()
            com.xiaomi.channel.commonutils.logger.b.d(r3)
        L_0x0149:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.service.ag.a(android.content.Context, java.lang.String, java.util.Map, java.lang.String, java.lang.String, java.lang.String, java.lang.String):android.content.Intent");
    }

    public static Bitmap a(Context context, int i) {
        return a(context.getResources().getDrawable(i));
    }

    /* JADX INFO: finally extract failed */
    public static Bitmap a(Context context, String str, boolean z) {
        Future submit = f833a.submit(new a(str, context, z));
        try {
            Bitmap bitmap = (Bitmap) submit.get(180, TimeUnit.SECONDS);
            if (bitmap != null) {
                return bitmap;
            }
            submit.cancel(true);
            return bitmap;
        } catch (InterruptedException | ExecutionException | TimeoutException e2) {
            com.xiaomi.channel.commonutils.logger.b.a(e2);
            submit.cancel(true);
            return null;
        } catch (Throwable th) {
            submit.cancel(true);
            throw th;
        }
    }

    public static Bitmap a(Drawable drawable) {
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int i = 1;
        if (intrinsicWidth <= 0) {
            intrinsicWidth = 1;
        }
        int intrinsicHeight = drawable.getIntrinsicHeight();
        if (intrinsicHeight > 0) {
            i = intrinsicHeight;
        }
        Bitmap createBitmap = Bitmap.createBitmap(intrinsicWidth, i, Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);
        return createBitmap;
    }

    public static RemoteViews a(Context context, dq dqVar, byte[] bArr) {
        di a2 = dqVar.a();
        String a3 = a(dqVar);
        if (!(a2 == null || a2.a() == null)) {
            Map a4 = a2.a();
            String str = (String) a4.get("layout_name");
            String str2 = (String) a4.get("layout_value");
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                try {
                    Resources resourcesForApplication = context.getPackageManager().getResourcesForApplication(a3);
                    int identifier = resourcesForApplication.getIdentifier(str, "layout", a3);
                    if (identifier == 0) {
                        return null;
                    }
                    RemoteViews remoteViews = new RemoteViews(a3, identifier);
                    try {
                        JSONObject jSONObject = new JSONObject(str2);
                        if (jSONObject.has("text")) {
                            JSONObject jSONObject2 = jSONObject.getJSONObject("text");
                            Iterator<String> keys = jSONObject2.keys();
                            while (keys.hasNext()) {
                                String next = keys.next();
                                String string = jSONObject2.getString(next);
                                int identifier2 = resourcesForApplication.getIdentifier(next, "id", a3);
                                if (identifier2 > 0) {
                                    remoteViews.setTextViewText(identifier2, string);
                                }
                            }
                        }
                        if (jSONObject.has(SMTNotificationConstants.NOTIF_IMAGE_URL_KEY)) {
                            JSONObject jSONObject3 = jSONObject.getJSONObject(SMTNotificationConstants.NOTIF_IMAGE_URL_KEY);
                            Iterator<String> keys2 = jSONObject3.keys();
                            while (keys2.hasNext()) {
                                String next2 = keys2.next();
                                String string2 = jSONObject3.getString(next2);
                                int identifier3 = resourcesForApplication.getIdentifier(next2, "id", a3);
                                int identifier4 = resourcesForApplication.getIdentifier(string2, "drawable", a3);
                                if (identifier3 > 0) {
                                    remoteViews.setImageViewResource(identifier3, identifier4);
                                }
                            }
                        }
                        if (jSONObject.has("time")) {
                            JSONObject jSONObject4 = jSONObject.getJSONObject("time");
                            Iterator<String> keys3 = jSONObject4.keys();
                            while (keys3.hasNext()) {
                                String next3 = keys3.next();
                                String string3 = jSONObject4.getString(next3);
                                if (string3.length() == 0) {
                                    string3 = "yy-MM-dd hh:mm";
                                }
                                int identifier5 = resourcesForApplication.getIdentifier(next3, "id", a3);
                                if (identifier5 > 0) {
                                    remoteViews.setTextViewText(identifier5, new SimpleDateFormat(string3).format(new Date(System.currentTimeMillis())));
                                }
                            }
                        }
                        return remoteViews;
                    } catch (JSONException e2) {
                        com.xiaomi.channel.commonutils.logger.b.a((Throwable) e2);
                        return null;
                    }
                } catch (NameNotFoundException e3) {
                    com.xiaomi.channel.commonutils.logger.b.a((Throwable) e3);
                }
            }
        }
        return null;
    }

    @TargetApi(16)
    public static ay a(Context context, dq dqVar, byte[] bArr, String str, int i) {
        ay ayVar;
        String a2 = a(dqVar);
        Map a3 = dqVar.a().a();
        String str2 = (String) a3.get("notification_style_type");
        ay a4 = (!f.a(context) || f831a == null) ? 0 : f831a.a(context, i, a2, a3);
        if (a4 != 0) {
            a4.a(a3);
            ayVar = a4;
        } else if ("2".equals(str2)) {
            ay ayVar2 = new ay(context);
            Bitmap a5 = TextUtils.isEmpty((String) a3.get("notification_bigPic_uri")) ? null : a(context, (String) a3.get("notification_bigPic_uri"), false);
            if (a5 == null) {
                com.xiaomi.channel.commonutils.logger.b.a((String) "can not get big picture.");
                return ayVar2;
            }
            BigPictureStyle bigPictureStyle = new BigPictureStyle(ayVar2);
            bigPictureStyle.bigPicture(a5);
            bigPictureStyle.setSummaryText(str);
            bigPictureStyle.bigLargeIcon(null);
            ayVar2.setStyle(bigPictureStyle);
            ayVar = ayVar2;
        } else if ("1".equals(str2)) {
            ay ayVar3 = new ay(context);
            ayVar3.setStyle(new BigTextStyle().bigText(str));
            ayVar = ayVar3;
        } else if ("4".equals(str2) && f.a()) {
            ax axVar = new ax(context, a2);
            if (!TextUtils.isEmpty((CharSequence) a3.get("notification_banner_image_uri"))) {
                axVar.setLargeIcon(a(context, (String) a3.get("notification_banner_image_uri"), false));
            }
            if (!TextUtils.isEmpty((CharSequence) a3.get("notification_banner_icon_uri"))) {
                axVar.b(a(context, (String) a3.get("notification_banner_icon_uri"), false));
            }
            axVar.a(a3);
            ayVar = axVar;
        } else if (!"3".equals(str2) || !f.a()) {
            ayVar = new ay(context);
        } else {
            az azVar = new az(context, i, a2);
            if (!TextUtils.isEmpty((CharSequence) a3.get("notification_colorful_button_text"))) {
                PendingIntent a6 = a(context, a2, dqVar, bArr, i, 4);
                if (a6 != null) {
                    azVar.a((CharSequence) a3.get("notification_colorful_button_text"), a6).a((String) a3.get("notification_colorful_button_bg_color"));
                }
            }
            if (!TextUtils.isEmpty((CharSequence) a3.get("notification_colorful_bg_color"))) {
                azVar.b((String) a3.get("notification_colorful_bg_color"));
            } else if (!TextUtils.isEmpty((CharSequence) a3.get("notification_colorful_bg_image_uri"))) {
                azVar.a(a(context, (String) a3.get("notification_colorful_bg_image_uri"), false));
            }
            azVar.a(a3);
            ayVar = azVar;
        }
        return ayVar;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0082, code lost:
        if (android.os.Build.VERSION.SDK_INT >= 24) goto L_0x0089;
     */
    /* JADX WARNING: Removed duplicated region for block: B:135:0x0383  */
    /* JADX WARNING: Removed duplicated region for block: B:140:0x039e  */
    /* JADX WARNING: Removed duplicated region for block: B:149:0x03d2  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x0147  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0149  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0158  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x0217  */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x0267  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x0273  */
    @android.annotation.SuppressLint({"NewApi"})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.xiaomi.push.service.ag.b a(android.content.Context r25, com.xiaomi.push.dq r26, byte[] r27, android.widget.RemoteViews r28, android.app.PendingIntent r29, int r30) {
        /*
            r7 = r25
            r0 = r28
            com.xiaomi.push.service.ag$b r8 = new com.xiaomi.push.service.ag$b
            r8.<init>()
            com.xiaomi.push.di r9 = r26.a()
            java.lang.String r10 = a(r26)
            java.util.Map r11 = r9.a()
            java.lang.String[] r12 = a(r7, r9)
            java.lang.String r13 = "notification_style_type"
            r1 = 1
            if (r0 == 0) goto L_0x002e
            com.xiaomi.push.ay r1 = new com.xiaomi.push.ay
            r1.<init>(r7)
            r1.setCustomContentView(r0)
            r14 = r26
            r5 = r27
            r6 = r30
        L_0x002c:
            r15 = r1
            goto L_0x004f
        L_0x002e:
            if (r11 == 0) goto L_0x0043
            boolean r0 = r11.containsKey(r13)
            if (r0 == 0) goto L_0x0043
            r0 = r12[r1]
            r14 = r26
            r5 = r27
            r6 = r30
            com.xiaomi.push.ay r1 = a(r7, r14, r5, r0, r6)
            goto L_0x002c
        L_0x0043:
            r14 = r26
            r5 = r27
            r6 = r30
            com.xiaomi.push.ay r1 = new com.xiaomi.push.ay
            r1.<init>(r7)
            goto L_0x002c
        L_0x004f:
            java.lang.String r3 = r26.b()
            r1 = r15
            r2 = r25
            r4 = r26
            r5 = r27
            r6 = r30
            a(r1, r2, r3, r4, r5, r6)
            r0 = 0
            r1 = r12[r0]
            r15.setContentTitle(r1)
            r1 = 1
            r2 = r12[r1]
            r15.setContentText(r2)
            long r2 = java.lang.System.currentTimeMillis()
            r15.setWhen(r2)
            java.lang.String r4 = "notification_show_when"
            java.lang.String r4 = a(r11, r4)
            boolean r5 = android.text.TextUtils.isEmpty(r4)
            r6 = 24
            if (r5 == 0) goto L_0x0085
            int r4 = android.os.Build.VERSION.SDK_INT
            if (r4 < r6) goto L_0x008c
            goto L_0x0089
        L_0x0085:
            boolean r1 = java.lang.Boolean.parseBoolean(r4)
        L_0x0089:
            r15.setShowWhen(r1)
        L_0x008c:
            r1 = r29
            r15.setContentIntent(r1)
            a(r7, r10, r15, r11)
            int r1 = android.os.Build.VERSION.SDK_INT
            r4 = 23
            if (r1 < r4) goto L_0x00fd
            java.lang.String r1 = "notification_small_icon_uri"
            if (r11 != 0) goto L_0x00a1
            r4 = 0
            r5 = 1
            goto L_0x00ac
        L_0x00a1:
            java.lang.Object r4 = r11.get(r1)
            java.lang.String r4 = (java.lang.String) r4
            r5 = 1
            android.graphics.Bitmap r4 = a(r7, r4, r5)
        L_0x00ac:
            if (r4 == 0) goto L_0x00e0
            java.lang.Object[] r6 = new java.lang.Object[r5]
            r6[r0] = r4
            java.lang.String r4 = "android.graphics.drawable.Icon"
            java.lang.String r12 = "createWithBitmap"
            java.lang.Object r4 = com.xiaomi.push.z.a(r4, r12, r6)
            if (r4 == 0) goto L_0x00d3
            java.lang.Object[] r1 = new java.lang.Object[r5]
            r1[r0] = r4
            java.lang.String r4 = "setSmallIcon"
            com.xiaomi.push.z.a(r15, r4, r1)
            android.os.Bundle r1 = new android.os.Bundle
            r1.<init>()
            java.lang.String r4 = "miui.isGrayscaleIcon"
            r1.putBoolean(r4, r5)
            r15.addExtras(r1)
            goto L_0x00f4
        L_0x00d3:
            java.lang.String r4 = "failed te get small icon with url:"
            java.lang.StringBuilder r4 = com.android.tools.r8.GeneratedOutlineSupport.outline73(r4)
            java.lang.Object r1 = r11.get(r1)
            java.lang.String r1 = (java.lang.String) r1
            goto L_0x00ea
        L_0x00e0:
            java.lang.String r4 = "failed to get small icon url:"
            java.lang.StringBuilder r4 = com.android.tools.r8.GeneratedOutlineSupport.outline73(r4)
            java.lang.String r1 = a(r11, r1)
        L_0x00ea:
            r4.append(r1)
            java.lang.String r1 = r4.toString()
            com.xiaomi.channel.commonutils.logger.b.a(r1)
        L_0x00f4:
            java.lang.String r1 = "notification_small_icon_color"
            java.lang.String r1 = a(r11, r1)
            r15.a(r1)
        L_0x00fd:
            java.lang.String r1 = "__dynamic_icon_uri"
            java.lang.String r1 = a(r11, r1)
            java.lang.String r4 = "__adiom"
            java.lang.String r4 = a(r11, r4)
            boolean r4 = java.lang.Boolean.parseBoolean(r4)
            if (r4 != 0) goto L_0x0118
            boolean r4 = com.xiaomi.channel.commonutils.android.f.a()
            if (r4 != 0) goto L_0x0116
            goto L_0x0118
        L_0x0116:
            r4 = 0
            goto L_0x0119
        L_0x0118:
            r4 = 1
        L_0x0119:
            boolean r5 = android.text.TextUtils.isEmpty(r1)
            if (r5 != 0) goto L_0x0144
            if (r4 == 0) goto L_0x0144
            java.lang.String r4 = "http"
            boolean r4 = r1.startsWith(r4)
            if (r4 == 0) goto L_0x0139
            r4 = 1
            com.xiaomi.push.service.ap$b r1 = com.xiaomi.push.service.ap.a(r7, r1, r4)
            if (r1 == 0) goto L_0x0137
            android.graphics.Bitmap r4 = r1.f848a
            long r5 = r1.f4860a
            r8.f4848a = r5
            goto L_0x013d
        L_0x0137:
            r4 = 0
            goto L_0x013d
        L_0x0139:
            android.graphics.Bitmap r4 = com.xiaomi.push.service.ap.a(r7, r1)
        L_0x013d:
            if (r4 == 0) goto L_0x0144
            r15.setLargeIcon(r4)
            r1 = 1
            goto L_0x0145
        L_0x0144:
            r1 = 0
        L_0x0145:
            if (r11 != 0) goto L_0x0149
            r4 = 0
            goto L_0x0156
        L_0x0149:
            java.lang.String r4 = "notification_large_icon_uri"
            java.lang.Object r4 = r11.get(r4)
            java.lang.String r4 = (java.lang.String) r4
            r5 = 1
            android.graphics.Bitmap r4 = a(r7, r4, r5)
        L_0x0156:
            if (r4 == 0) goto L_0x015b
            r15.setLargeIcon(r4)
        L_0x015b:
            java.lang.String r4 = "com.xiaomi.xmsf"
            if (r11 == 0) goto L_0x01e8
            int r5 = android.os.Build.VERSION.SDK_INT
            r6 = 24
            if (r5 < r6) goto L_0x01e8
            java.lang.String r5 = "notification_group"
            java.lang.Object r5 = r11.get(r5)
            java.lang.String r5 = (java.lang.String) r5
            java.lang.String r6 = "notification_is_summary"
            java.lang.Object r6 = r11.get(r6)
            java.lang.String r6 = (java.lang.String) r6
            boolean r6 = java.lang.Boolean.parseBoolean(r6)
            java.lang.String r12 = "notification_group_disable_default"
            java.lang.Object r12 = r11.get(r12)
            java.lang.String r12 = (java.lang.String) r12
            boolean r12 = java.lang.Boolean.parseBoolean(r12)
            boolean r16 = android.text.TextUtils.isEmpty(r5)
            if (r16 == 0) goto L_0x0197
            boolean r16 = com.xiaomi.channel.commonutils.android.f.a()
            if (r16 != 0) goto L_0x0193
            if (r12 != 0) goto L_0x0197
        L_0x0193:
            java.lang.String r5 = a(r26)
        L_0x0197:
            r12 = 1
            java.lang.Object[] r12 = new java.lang.Object[r12]
            java.lang.Boolean r16 = java.lang.Boolean.valueOf(r6)
            r12[r0] = r16
            java.lang.String r0 = "setGroupSummary"
            com.xiaomi.push.z.a(r15, r0, r12)
            java.lang.Object r0 = r11.get(r13)
            java.lang.String r0 = (java.lang.String) r0
            java.lang.String r12 = r25.getPackageName()
            boolean r12 = r4.equals(r12)
            if (r12 == 0) goto L_0x01e3
            java.lang.String r12 = "4"
            boolean r12 = r12.equals(r0)
            if (r12 != 0) goto L_0x01c5
            java.lang.String r12 = "3"
            boolean r0 = r12.equals(r0)
            if (r0 == 0) goto L_0x01e3
        L_0x01c5:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r5 = a(r26)
            r0.append(r5)
            java.lang.String r5 = "_custom_"
            r0.append(r5)
            r0.append(r2)
            java.lang.String r5 = r0.toString()
            r0 = 1
            r12 = 1
            r0 = r6
            r6 = r5
            r5 = 1
            goto L_0x01ef
        L_0x01e3:
            r0 = 0
            r12 = 1
            r0 = r6
            r6 = r5
            goto L_0x01ee
        L_0x01e8:
            r6 = 0
            r5 = 0
            r0 = 0
            r12 = 1
            r6 = r5
            r0 = 0
        L_0x01ee:
            r5 = 0
        L_0x01ef:
            r15.setAutoCancel(r12)
            long r12 = java.lang.System.currentTimeMillis()
            if (r11 == 0) goto L_0x020a
            java.lang.String r14 = "ticker"
            boolean r16 = r11.containsKey(r14)
            if (r16 == 0) goto L_0x020a
            java.lang.Object r14 = r11.get(r14)
            java.lang.CharSequence r14 = (java.lang.CharSequence) r14
            r15.setTicker(r14)
        L_0x020a:
            long r16 = f4846a
            long r16 = r12 - r16
            r18 = 10000(0x2710, double:4.9407E-320)
            java.lang.String r14 = "sound_uri"
            int r20 = (r16 > r18 ? 1 : (r16 == r18 ? 0 : -1))
            if (r20 <= 0) goto L_0x0267
            f4846a = r12
            int r12 = r9.f489a
            boolean r13 = b(r7, r10)
            if (r13 == 0) goto L_0x0225
            int r12 = a(r7, r10)
        L_0x0225:
            r15.setDefaults(r12)
            if (r11 == 0) goto L_0x0262
            r13 = r12 & 1
            if (r13 == 0) goto L_0x0262
            java.lang.Object r13 = r11.get(r14)
            java.lang.String r13 = (java.lang.String) r13
            boolean r16 = android.text.TextUtils.isEmpty(r13)
            if (r16 != 0) goto L_0x0262
            r16 = r8
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            r27 = r1
            java.lang.String r1 = "android.resource://"
            r8.append(r1)
            r8.append(r10)
            java.lang.String r1 = r8.toString()
            boolean r1 = r13.startsWith(r1)
            if (r1 == 0) goto L_0x026d
            r1 = r12 ^ 1
            r15.setDefaults(r1)
            android.net.Uri r1 = android.net.Uri.parse(r13)
            r15.setSound(r1)
            goto L_0x026d
        L_0x0262:
            r27 = r1
            r16 = r8
            goto L_0x026d
        L_0x0267:
            r27 = r1
            r16 = r8
            r12 = -100
        L_0x026d:
            java.lang.String r1 = "0"
            r8 = 26
            if (r11 == 0) goto L_0x0362
            int r13 = android.os.Build.VERSION.SDK_INT
            if (r13 < r8) goto L_0x0362
            com.xiaomi.push.service.aq r17 = com.xiaomi.push.service.aq.a(r7, r10)
            int r8 = a(r11)
            if (r8 <= 0) goto L_0x0298
            r13 = 1
            java.lang.Object[] r13 = new java.lang.Object[r13]
            int r8 = r8 * 1000
            r28 = r4
            r29 = r5
            long r4 = (long) r8
            java.lang.Long r4 = java.lang.Long.valueOf(r4)
            r5 = 0
            r13[r5] = r4
            java.lang.String r4 = "setTimeoutAfter"
            com.xiaomi.push.z.a(r15, r4, r13)
            goto L_0x029c
        L_0x0298:
            r28 = r4
            r29 = r5
        L_0x029c:
            com.xiaomi.push.service.am.a(r9)
            java.lang.String r4 = "channel_id"
            java.lang.Object r4 = r11.get(r4)
            r18 = r4
            java.lang.String r18 = (java.lang.String) r18
            boolean r4 = android.text.TextUtils.isEmpty(r18)
            if (r4 == 0) goto L_0x02b9
            android.content.pm.ApplicationInfo r4 = r25.getApplicationInfo()
            int r4 = r4.targetSdkVersion
            r5 = 26
            if (r4 < r5) goto L_0x0337
        L_0x02b9:
            java.lang.String r19 = a(r7, r10, r11)
            int r22 = b(r11)
            int r4 = r9.f489a
            java.lang.String r5 = "channel_description"
            java.lang.Object r5 = r11.get(r5)
            r20 = r5
            java.lang.String r20 = (java.lang.String) r20
            java.lang.Object r5 = r11.get(r14)
            r23 = r5
            java.lang.String r23 = (java.lang.String) r23
            java.lang.String r5 = "channel_perm"
            java.lang.Object r5 = r11.get(r5)
            r24 = r5
            java.lang.String r24 = (java.lang.String) r24
            com.xiaomi.push.service.br.a(r7, r11, r15, r2)
            r21 = r4
            java.lang.String r2 = com.xiaomi.push.service.am.a(r17, r18, r19, r20, r21, r22, r23, r24)
            r3 = 1
            java.lang.Object[] r3 = new java.lang.Object[r3]
            r4 = 0
            r3[r4] = r2
            java.lang.String r2 = "setChannelId"
            com.xiaomi.push.z.a(r15, r2, r3)
            r2 = -100
            if (r12 != r2) goto L_0x0300
            boolean r2 = com.xiaomi.push.service.ar.a(r11)
            if (r2 == 0) goto L_0x0300
            com.xiaomi.push.service.ar.a(r15, r0)
        L_0x0300:
            java.lang.String r2 = com.xiaomi.push.service.ar.a(r11)
            java.lang.String r3 = "pulldown"
            boolean r2 = r3.equals(r2)
            if (r2 == 0) goto L_0x0321
            boolean r2 = com.xiaomi.push.service.ar.a(r11)
            if (r2 == 0) goto L_0x0321
            java.lang.String r2 = "pull_down_pop_type"
            java.lang.Object r2 = r11.get(r2)
            boolean r2 = java.util.Objects.equals(r2, r1)
            if (r2 == 0) goto L_0x0321
            com.xiaomi.push.service.ar.a(r15, r0)
        L_0x0321:
            java.lang.String r2 = com.xiaomi.push.service.ar.a(r11)
            java.lang.String r3 = "tts"
            boolean r2 = r3.equals(r2)
            if (r2 == 0) goto L_0x0337
            boolean r2 = com.xiaomi.push.service.ar.a(r11)
            if (r2 == 0) goto L_0x0337
            com.xiaomi.push.service.ar.a(r15, r0)
        L_0x0337:
            java.lang.String r0 = "background_color"
            java.lang.Object r0 = r11.get(r0)
            java.lang.String r0 = (java.lang.String) r0
            boolean r2 = android.text.TextUtils.isEmpty(r0)
            if (r2 != 0) goto L_0x0381
            int r0 = java.lang.Integer.parseInt(r0)     // Catch:{ Exception -> 0x035d }
            r2 = 1
            r15.setOngoing(r2)     // Catch:{ Exception -> 0x035d }
            r15.setColor(r0)     // Catch:{ Exception -> 0x035d }
            java.lang.String r0 = "setColorized"
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch:{ Exception -> 0x035d }
            java.lang.Boolean r3 = java.lang.Boolean.TRUE     // Catch:{ Exception -> 0x035d }
            r4 = 0
            r2[r4] = r3     // Catch:{ Exception -> 0x035d }
            com.xiaomi.push.z.a(r15, r0, r2)     // Catch:{ Exception -> 0x035d }
            goto L_0x0381
        L_0x035d:
            r0 = move-exception
            com.xiaomi.channel.commonutils.logger.b.a(r0)
            goto L_0x0381
        L_0x0362:
            r28 = r4
            r29 = r5
            if (r11 == 0) goto L_0x0381
            int r0 = android.os.Build.VERSION.SDK_INT
            r2 = 26
            if (r0 >= r2) goto L_0x0381
            int r0 = c(r11)
            r2 = 1
            java.lang.Object[] r2 = new java.lang.Object[r2]
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r3 = 0
            r2[r3] = r0
            java.lang.String r0 = "setPriority"
            com.xiaomi.push.z.a(r15, r0, r2)
        L_0x0381:
            if (r6 == 0) goto L_0x0398
            if (r29 != 0) goto L_0x038d
            com.xiaomi.push.service.an r0 = com.xiaomi.push.service.an.a()
            java.lang.String r6 = r0.a(r7, r15, r6)
        L_0x038d:
            r0 = 1
            java.lang.Object[] r0 = new java.lang.Object[r0]
            r2 = 0
            r0[r2] = r6
            java.lang.String r2 = "setGroup"
            com.xiaomi.push.z.a(r15, r2, r0)
        L_0x0398:
            boolean r0 = com.xiaomi.channel.commonutils.android.f.b()
            if (r0 == 0) goto L_0x03c1
            java.lang.String r0 = r25.getPackageName()
            r2 = r28
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x03c1
            r0 = 3
            java.lang.Object[] r0 = new java.lang.Object[r0]
            r2 = 0
            r0[r2] = r7
            r2 = 1
            r0[r2] = r15
            r2 = 2
            java.lang.String r3 = a(r26)
            r0[r2] = r3
            java.lang.String r2 = "miui.util.NotificationHelper"
            java.lang.String r3 = "setTargetPkg"
            com.xiaomi.push.z.a(r2, r3, r0)
        L_0x03c1:
            android.app.Notification r0 = r15.getNotification()
            if (r27 == 0) goto L_0x03d0
            boolean r2 = com.xiaomi.channel.commonutils.android.f.a()
            if (r2 == 0) goto L_0x03d0
            a(r0)
        L_0x03d0:
            if (r11 == 0) goto L_0x0457
            android.os.Bundle r2 = r0.extras
            if (r2 != 0) goto L_0x03dd
            android.os.Bundle r2 = new android.os.Bundle
            r2.<init>()
            r0.extras = r2
        L_0x03dd:
            java.lang.String r2 = "enable_keyguard"
            java.lang.Object r3 = r11.get(r2)
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            boolean r3 = android.text.TextUtils.isEmpty(r3)
            if (r3 != 0) goto L_0x03f8
            java.lang.Object r2 = r11.get(r2)
            java.lang.String r2 = (java.lang.String) r2
            boolean r2 = java.lang.Boolean.parseBoolean(r2)
            com.xiaomi.push.service.ar.b(r0, r2)
        L_0x03f8:
            java.lang.String r2 = "enable_float"
            java.lang.Object r3 = r11.get(r2)
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            boolean r3 = android.text.TextUtils.isEmpty(r3)
            if (r3 != 0) goto L_0x0413
            java.lang.Object r2 = r11.get(r2)
            java.lang.String r2 = (java.lang.String) r2
            boolean r2 = java.lang.Boolean.parseBoolean(r2)
            com.xiaomi.push.service.ar.a(r0, r2)
        L_0x0413:
            java.lang.String r2 = "float_small_win"
            java.lang.Object r3 = r11.get(r2)
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            boolean r3 = android.text.TextUtils.isEmpty(r3)
            if (r3 != 0) goto L_0x0437
            java.lang.Object r2 = r11.get(r2)
            java.lang.String r2 = (java.lang.String) r2
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0437
            boolean r1 = com.xiaomi.channel.commonutils.android.a.c(r7, r10)
            if (r1 == 0) goto L_0x0437
            r1 = 0
            com.xiaomi.push.service.ar.a(r0, r1)
        L_0x0437:
            java.lang.String r1 = "section_is_prr"
            java.lang.Object r1 = r11.get(r1)
            java.lang.String r1 = (java.lang.String) r1
            r2 = -1
            int r1 = com.xiaomi.channel.commonutils.android.k.a(r1, r2)
            java.lang.String r3 = "section_prr_cl"
            java.lang.Object r3 = r11.get(r3)
            java.lang.String r3 = (java.lang.String) r3
            int r2 = com.xiaomi.channel.commonutils.android.k.a(r3, r2)
            if (r1 < 0) goto L_0x0457
            if (r2 < 0) goto L_0x0457
            com.xiaomi.push.service.ar.a(r0, r1, r2)
        L_0x0457:
            r1 = r16
            r1.f836a = r0
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.service.ag.a(android.content.Context, com.xiaomi.push.dq, byte[], android.widget.RemoteViews, android.app.PendingIntent, int):com.xiaomi.push.service.ag$b");
    }

    /* JADX WARNING: Removed duplicated region for block: B:105:0x02a2  */
    /* JADX WARNING: Removed duplicated region for block: B:112:0x02e2 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0126  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x017b  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x0183  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x0210  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x0212  */
    /* renamed from: a  reason: collision with other method in class */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.xiaomi.push.service.ag.c m793a(android.content.Context r19, com.xiaomi.push.dq r20, byte[] r21) {
        /*
            r7 = r19
            r8 = r20
            com.xiaomi.push.service.ag$c r9 = new com.xiaomi.push.service.ag$c
            r9.<init>()
            java.lang.String r0 = a(r20)
            r10 = 1
            com.xiaomi.channel.commonutils.android.a$b r0 = com.xiaomi.channel.commonutils.android.a.a(r7, r0, r10)
            com.xiaomi.push.di r11 = r20.a()
            r12 = 0
            if (r11 == 0) goto L_0x0022
            int r1 = r11.c()
            java.util.Map r2 = r11.a()
            goto L_0x0024
        L_0x0022:
            r1 = 0
            r2 = 0
        L_0x0024:
            r13 = r2
            java.lang.String r2 = a(r20)
            int r14 = com.xiaomi.channel.commonutils.android.k.b(r2, r1)
            boolean r1 = com.xiaomi.channel.commonutils.android.f.a(r19)
            if (r1 == 0) goto L_0x004f
            com.xiaomi.channel.commonutils.android.a$b r1 = com.xiaomi.channel.commonutils.android.a.b.NOT_ALLOWED
            if (r0 != r1) goto L_0x004f
            java.lang.String r0 = "Do not notify because user block "
            java.lang.StringBuilder r0 = com.android.tools.r8.GeneratedOutlineSupport.outline73(r0)
            java.lang.String r1 = a(r20)
            r0.append(r1)
            java.lang.String r1 = "‘s notification"
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            goto L_0x007a
        L_0x004f:
            boolean r0 = com.xiaomi.channel.commonutils.android.f.a(r19)
            if (r0 == 0) goto L_0x0068
            com.xiaomi.push.service.al r0 = f831a
            if (r0 == 0) goto L_0x0068
            com.xiaomi.push.service.al r0 = f831a
            java.lang.String r1 = a(r20)
            boolean r0 = r0.a(r7, r14, r1, r13)
            if (r0 == 0) goto L_0x0068
            java.lang.String r0 = "Do not notify because card notification is canceled or sequence incorrect"
            goto L_0x007a
        L_0x0068:
            android.widget.RemoteViews r15 = a(r19, r20, r21)
            java.lang.String r0 = r20.b()
            r3 = r21
            android.app.PendingIntent r0 = a(r7, r8, r0, r3, r14)
            if (r0 != 0) goto L_0x007e
            java.lang.String r0 = "The click PendingIntent is null. "
        L_0x007a:
            com.xiaomi.channel.commonutils.logger.b.a(r0)
            return r9
        L_0x007e:
            r1 = r19
            r2 = r20
            r3 = r21
            r4 = r15
            r5 = r0
            r6 = r14
            com.xiaomi.push.service.ag$b r1 = a(r1, r2, r3, r4, r5, r6)
            long r2 = r1.f4848a
            r9.f4849a = r2
            java.lang.String r2 = a(r20)
            r9.f837a = r2
            android.app.Notification r1 = r1.f836a
            java.lang.String[] r2 = a(r7, r11)
            java.lang.Class r3 = r1.getClass()     // Catch:{ NoSuchMethodException -> 0x00e9, IllegalAccessException -> 0x00e0, IllegalArgumentException -> 0x00d7, InvocationTargetException -> 0x00ce }
            java.lang.String r4 = "setLatestEventInfo"
            r5 = 4
            java.lang.Class[] r6 = new java.lang.Class[r5]     // Catch:{ NoSuchMethodException -> 0x00e9, IllegalAccessException -> 0x00e0, IllegalArgumentException -> 0x00d7, InvocationTargetException -> 0x00ce }
            java.lang.Class<android.content.Context> r16 = android.content.Context.class
            r6[r12] = r16     // Catch:{ NoSuchMethodException -> 0x00e9, IllegalAccessException -> 0x00e0, IllegalArgumentException -> 0x00d7, InvocationTargetException -> 0x00ce }
            java.lang.Class<java.lang.CharSequence> r16 = java.lang.CharSequence.class
            r6[r10] = r16     // Catch:{ NoSuchMethodException -> 0x00e9, IllegalAccessException -> 0x00e0, IllegalArgumentException -> 0x00d7, InvocationTargetException -> 0x00ce }
            java.lang.Class<java.lang.CharSequence> r16 = java.lang.CharSequence.class
            r17 = 2
            r6[r17] = r16     // Catch:{ NoSuchMethodException -> 0x00e9, IllegalAccessException -> 0x00e0, IllegalArgumentException -> 0x00d7, InvocationTargetException -> 0x00ce }
            java.lang.Class<android.app.PendingIntent> r16 = android.app.PendingIntent.class
            r18 = 3
            r6[r18] = r16     // Catch:{ NoSuchMethodException -> 0x00e9, IllegalAccessException -> 0x00e0, IllegalArgumentException -> 0x00d7, InvocationTargetException -> 0x00ce }
            java.lang.reflect.Method r3 = r3.getMethod(r4, r6)     // Catch:{ NoSuchMethodException -> 0x00e9, IllegalAccessException -> 0x00e0, IllegalArgumentException -> 0x00d7, InvocationTargetException -> 0x00ce }
            java.lang.Object[] r4 = new java.lang.Object[r5]     // Catch:{ NoSuchMethodException -> 0x00e9, IllegalAccessException -> 0x00e0, IllegalArgumentException -> 0x00d7, InvocationTargetException -> 0x00ce }
            r4[r12] = r7     // Catch:{ NoSuchMethodException -> 0x00e9, IllegalAccessException -> 0x00e0, IllegalArgumentException -> 0x00d7, InvocationTargetException -> 0x00ce }
            r5 = r2[r12]     // Catch:{ NoSuchMethodException -> 0x00e9, IllegalAccessException -> 0x00e0, IllegalArgumentException -> 0x00d7, InvocationTargetException -> 0x00ce }
            r4[r10] = r5     // Catch:{ NoSuchMethodException -> 0x00e9, IllegalAccessException -> 0x00e0, IllegalArgumentException -> 0x00d7, InvocationTargetException -> 0x00ce }
            r2 = r2[r10]     // Catch:{ NoSuchMethodException -> 0x00e9, IllegalAccessException -> 0x00e0, IllegalArgumentException -> 0x00d7, InvocationTargetException -> 0x00ce }
            r4[r17] = r2     // Catch:{ NoSuchMethodException -> 0x00e9, IllegalAccessException -> 0x00e0, IllegalArgumentException -> 0x00d7, InvocationTargetException -> 0x00ce }
            r4[r18] = r0     // Catch:{ NoSuchMethodException -> 0x00e9, IllegalAccessException -> 0x00e0, IllegalArgumentException -> 0x00d7, InvocationTargetException -> 0x00ce }
            r3.invoke(r1, r4)     // Catch:{ NoSuchMethodException -> 0x00e9, IllegalAccessException -> 0x00e0, IllegalArgumentException -> 0x00d7, InvocationTargetException -> 0x00ce }
            goto L_0x00fe
        L_0x00ce:
            r0 = move-exception
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "meet invocation target error. "
            goto L_0x00f1
        L_0x00d7:
            r0 = move-exception
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "meet illegal argument error. "
            goto L_0x00f1
        L_0x00e0:
            r0 = move-exception
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "meet illegal access error. "
            goto L_0x00f1
        L_0x00e9:
            r0 = move-exception
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "meet no such method error. "
        L_0x00f1:
            r2.append(r3)
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            com.xiaomi.channel.commonutils.logger.b.d(r0)
        L_0x00fe:
            java.util.Map r0 = r11.a()
            if (r0 == 0) goto L_0x0118
            java.lang.String r2 = "ticker"
            boolean r2 = r0.containsKey(r2)
            if (r2 == 0) goto L_0x0118
            java.lang.String r2 = "ticker"
            java.lang.Object r2 = r0.get(r2)
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            r1.tickerText = r2
        L_0x0118:
            long r2 = java.lang.System.currentTimeMillis()
            long r4 = f4846a
            long r4 = r2 - r4
            r16 = 10000(0x2710, double:4.9407E-320)
            int r6 = (r4 > r16 ? 1 : (r4 == r16 ? 0 : -1))
            if (r6 <= 0) goto L_0x0173
            f4846a = r2
            int r2 = r11.f489a
            java.lang.String r3 = a(r20)
            boolean r3 = b(r7, r3)
            if (r3 == 0) goto L_0x013c
            java.lang.String r2 = a(r20)
            int r2 = a(r7, r2)
        L_0x013c:
            r1.defaults = r2
            if (r0 == 0) goto L_0x0173
            r3 = r2 & 1
            if (r3 == 0) goto L_0x0173
            java.lang.String r3 = "sound_uri"
            java.lang.Object r0 = r0.get(r3)
            java.lang.String r0 = (java.lang.String) r0
            boolean r3 = android.text.TextUtils.isEmpty(r0)
            if (r3 != 0) goto L_0x0173
            java.lang.String r3 = "android.resource://"
            java.lang.StringBuilder r3 = com.android.tools.r8.GeneratedOutlineSupport.outline73(r3)
            java.lang.String r4 = a(r20)
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            boolean r3 = r0.startsWith(r3)
            if (r3 == 0) goto L_0x0173
            r2 = r2 ^ r10
            r1.defaults = r2
            android.net.Uri r0 = android.net.Uri.parse(r0)
            r1.sound = r0
        L_0x0173:
            int r0 = r1.flags
            r0 = r0 | 16
            r1.flags = r0
            if (r15 == 0) goto L_0x017d
            r1.contentView = r15
        L_0x017d:
            boolean r0 = com.xiaomi.channel.commonutils.android.f.a()
            if (r0 == 0) goto L_0x020a
            java.lang.String r0 = r11.a()
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x0198
            android.os.Bundle r0 = r1.extras
            java.lang.String r2 = "message_id"
            java.lang.String r3 = r11.a()
            r0.putString(r2, r3)
        L_0x0198:
            android.os.Bundle r0 = r1.extras
            java.lang.String r2 = "local_paid"
            java.lang.String r3 = r20.a()
            r0.putString(r2, r3)
            android.os.Bundle r0 = r1.extras
            java.lang.String r2 = "msg_busi_type"
            com.xiaomi.push.service.ar.a(r13, r0, r2)
            android.os.Bundle r0 = r1.extras
            java.lang.String r2 = "disable_notification_flags"
            com.xiaomi.push.service.ar.a(r13, r0, r2)
            java.util.Map r0 = r11.b()
            if (r0 != 0) goto L_0x01b9
            r0 = 0
            goto L_0x01c5
        L_0x01b9:
            java.util.Map r0 = r11.b()
            java.lang.String r2 = "score_info"
            java.lang.Object r0 = r0.get(r2)
            java.lang.String r0 = (java.lang.String) r0
        L_0x01c5:
            boolean r2 = android.text.TextUtils.isEmpty(r0)
            if (r2 != 0) goto L_0x01d2
            android.os.Bundle r2 = r1.extras
            java.lang.String r3 = "score_info"
            r2.putString(r3, r0)
        L_0x01d2:
            android.os.Bundle r0 = r1.extras
            java.lang.String r2 = "pushUid"
            java.util.Map<java.lang.String, java.lang.String> r3 = r11.f493a
            java.lang.String r4 = "n_stats_expose"
            java.lang.String r3 = a(r3, r4)
            r0.putString(r2, r3)
            r0 = -1
            boolean r2 = c(r20)
            if (r2 == 0) goto L_0x01eb
            r0 = 1000(0x3e8, float:1.401E-42)
            goto L_0x01f3
        L_0x01eb:
            boolean r2 = a(r20)
            if (r2 == 0) goto L_0x01f3
            r0 = 3000(0xbb8, float:4.204E-42)
        L_0x01f3:
            android.os.Bundle r2 = r1.extras
            java.lang.String r3 = "eventMessageType"
            java.lang.String r0 = java.lang.String.valueOf(r0)
            r2.putString(r3, r0)
            android.os.Bundle r0 = r1.extras
            java.lang.String r2 = "target_package"
            java.lang.String r3 = a(r20)
            r0.putString(r2, r3)
        L_0x020a:
            java.util.Map r0 = r11.a()
            if (r0 != 0) goto L_0x0212
            r0 = 0
            goto L_0x021e
        L_0x0212:
            java.util.Map r0 = r11.a()
            java.lang.String r2 = "message_count"
            java.lang.Object r0 = r0.get(r2)
            java.lang.String r0 = (java.lang.String) r0
        L_0x021e:
            boolean r2 = com.xiaomi.channel.commonutils.android.f.a()
            if (r2 == 0) goto L_0x0243
            if (r0 == 0) goto L_0x0243
            int r0 = java.lang.Integer.parseInt(r0)     // Catch:{ NumberFormatException -> 0x022e }
            com.xiaomi.push.service.ar.a(r1, r0)     // Catch:{ NumberFormatException -> 0x022e }
            goto L_0x0243
        L_0x022e:
            r0 = move-exception
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "fail to set message count. "
            r2.append(r3)
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            com.xiaomi.channel.commonutils.logger.b.d(r0)
        L_0x0243:
            java.lang.String r0 = a(r20)
            com.xiaomi.push.service.ar.a(r1, r0)
            com.xiaomi.push.service.aq r2 = com.xiaomi.push.service.aq.a(r7, r0)
            boolean r3 = com.xiaomi.channel.commonutils.android.f.a(r19)
            if (r3 == 0) goto L_0x0261
            com.xiaomi.push.service.al r3 = f831a
            if (r3 == 0) goto L_0x0261
            com.xiaomi.push.service.al r3 = f831a
            java.util.Map r4 = r11.a()
            r3.a(r8, r4, r14, r1)
        L_0x0261:
            boolean r3 = com.xiaomi.channel.commonutils.android.f.a(r19)
            if (r3 == 0) goto L_0x027d
            com.xiaomi.push.service.al r3 = f831a
            if (r3 == 0) goto L_0x027d
            com.xiaomi.push.service.al r3 = f831a
            java.util.Map r4 = r11.a()
            boolean r3 = r3.a(r4, r14, r1)
            if (r3 == 0) goto L_0x027d
            java.lang.String r3 = "consume this notificaiton by agent"
            com.xiaomi.channel.commonutils.logger.b.b(r3)
            goto L_0x0282
        L_0x027d:
            r2.a(r14, r1)
            r9.f838a = r10
        L_0x0282:
            boolean r3 = com.xiaomi.channel.commonutils.android.f.a()
            if (r3 == 0) goto L_0x029c
            boolean r3 = com.xiaomi.channel.commonutils.android.f.a(r19)
            if (r3 == 0) goto L_0x029c
            com.xiaomi.push.service.an r3 = com.xiaomi.push.service.an.a()
            r3.a(r7, r14, r1)
            java.lang.String r3 = r11.a()
            com.xiaomi.push.service.br.a(r7, r0, r14, r3, r1)
        L_0x029c:
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 26
            if (r0 >= r1) goto L_0x02d6
            java.lang.String r0 = r11.a()
            com.xiaomi.push.o r1 = com.xiaomi.push.o.a(r19)
            java.util.Map r3 = r11.a()
            int r3 = a(r3)
            if (r3 <= 0) goto L_0x02d6
            boolean r4 = android.text.TextUtils.isEmpty(r0)
            if (r4 != 0) goto L_0x02d6
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "n_timeout_"
            r4.append(r5)
            r4.append(r0)
            java.lang.String r0 = r4.toString()
            r1.a(r0)
            com.xiaomi.push.service.ah r4 = new com.xiaomi.push.service.ah
            r4.<init>(r0, r2, r14)
            r1.b(r4, r3)
        L_0x02d6:
            android.util.Pair r0 = new android.util.Pair
            java.lang.Integer r1 = java.lang.Integer.valueOf(r14)
            r0.<init>(r1, r8)
            java.util.LinkedList<android.util.Pair<java.lang.Integer, com.xiaomi.push.dq>> r1 = f832a
            monitor-enter(r1)
            java.util.LinkedList<android.util.Pair<java.lang.Integer, com.xiaomi.push.dq>> r2 = f832a     // Catch:{ all -> 0x02f8 }
            r2.add(r0)     // Catch:{ all -> 0x02f8 }
            java.util.LinkedList<android.util.Pair<java.lang.Integer, com.xiaomi.push.dq>> r0 = f832a     // Catch:{ all -> 0x02f8 }
            int r0 = r0.size()     // Catch:{ all -> 0x02f8 }
            r2 = 100
            if (r0 <= r2) goto L_0x02f6
            java.util.LinkedList<android.util.Pair<java.lang.Integer, com.xiaomi.push.dq>> r0 = f832a     // Catch:{ all -> 0x02f8 }
            r0.remove()     // Catch:{ all -> 0x02f8 }
        L_0x02f6:
            monitor-exit(r1)     // Catch:{ all -> 0x02f8 }
            return r9
        L_0x02f8:
            r0 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x02f8 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.service.ag.m793a(android.content.Context, com.xiaomi.push.dq, byte[]):com.xiaomi.push.service.ag$c");
    }

    public static String a(Context context, String str, Map<String, String> map) {
        return (map == null || TextUtils.isEmpty(map.get("channel_name"))) ? com.xiaomi.channel.commonutils.android.a.b(context, str) : map.get("channel_name");
    }

    public static String a(dq dqVar) {
        if ("com.xiaomi.xmsf".equals(dqVar.f583b)) {
            di a2 = dqVar.a();
            if (!(a2 == null || a2.a() == null)) {
                String str = (String) a2.a().get("miui_package_name");
                if (!TextUtils.isEmpty(str)) {
                    return str;
                }
            }
        }
        return dqVar.f583b;
    }

    public static String a(Map<String, String> map, int i) {
        Object format = i == 0 ? "notify_effect" : b(map) ? String.format("cust_btn_%s_ne", new Object[]{Integer.valueOf(i)}) : i == 1 ? "notification_style_button_left_notify_effect" : i == 2 ? "notification_style_button_mid_notify_effect" : i == 3 ? "notification_style_button_right_notify_effect" : i == 4 ? "notification_colorful_button_notify_effect" : null;
        if (map == null || format == null) {
            return null;
        }
        return map.get(format);
    }

    public static String a(Map<String, String> map, String str) {
        if (map != null) {
            return map.get(str);
        }
        return null;
    }

    public static void a(Context context, Intent intent, dq dqVar, di diVar, String str, int i) {
        if (dqVar != null && diVar != null && !TextUtils.isEmpty(str)) {
            String a2 = a(diVar.a(), i);
            if (TextUtils.isEmpty(a2)) {
                return;
            }
            if (bd.f4898a.equals(a2) || bd.f4899b.equals(a2) || bd.f4900c.equals(a2)) {
                intent.putExtra("messageId", str);
                intent.putExtra("local_paid", dqVar.f579a);
                if (!TextUtils.isEmpty(dqVar.f583b)) {
                    intent.putExtra("target_package", dqVar.f583b);
                }
                intent.putExtra("job_key", a(diVar.a(), (String) "jobkey"));
                intent.putExtra(i + "_" + "target_component", a(context, dqVar.f583b, diVar.a(), i));
            }
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public static void m794a(Context context, String str) {
        a(context, str, -1);
    }

    public static void a(Context context, String str, int i) {
        a(context, str, i, -1);
    }

    public static void a(Context context, String str, int i, int i2) {
        int i3;
        if (context != null && !TextUtils.isEmpty(str) && i >= -1) {
            aq a2 = aq.a(context, str);
            List b2 = a2.b();
            if (!k.a(b2)) {
                LinkedList linkedList = new LinkedList();
                boolean z = false;
                if (i == -1) {
                    i3 = 0;
                    z = true;
                } else {
                    i3 = ((str.hashCode() / 10) * 10) + i;
                }
                Iterator it = b2.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    StatusBarNotification statusBarNotification = (StatusBarNotification) it.next();
                    if (!TextUtils.isEmpty(String.valueOf(statusBarNotification.getId()))) {
                        int id = statusBarNotification.getId();
                        if (z) {
                            linkedList.add(statusBarNotification);
                            a2.a(id);
                        } else if (i3 == id) {
                            d.a(context, statusBarNotification, i2);
                            linkedList.add(statusBarNotification);
                            a2.a(id);
                            break;
                        }
                    }
                }
                a(context, linkedList);
            }
        }
    }

    public static void a(Context context, String str, ay ayVar, Map<String, String> map) {
        int a2 = a(context, str, (String) "mipush_small_notification");
        int a3 = a(context, str, (String) "mipush_notification");
        if (!f.a(context)) {
            if (a2 > 0) {
                ayVar.setSmallIcon(a2);
            } else {
                b(context, str, ayVar, map);
            }
            if (a3 <= 0) {
                return;
            }
        } else if (a2 <= 0 || a3 <= 0) {
            b(context, str, ayVar, map);
            return;
        } else {
            ayVar.setSmallIcon(a2);
        }
        ayVar.setLargeIcon(a(context, a3));
    }

    public static void a(Context context, String str, String str2, String str3) {
        if (context != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
            aq a2 = aq.a(context, str);
            List<StatusBarNotification> b2 = a2.b();
            if (!k.a(b2)) {
                LinkedList linkedList = new LinkedList();
                for (StatusBarNotification statusBarNotification : b2) {
                    Notification notification = statusBarNotification.getNotification();
                    if (notification != null && !TextUtils.isEmpty(String.valueOf(statusBarNotification.getId()))) {
                        int id = statusBarNotification.getId();
                        String a3 = ar.a(notification);
                        String b3 = ar.b(notification);
                        if (!TextUtils.isEmpty(a3) && !TextUtils.isEmpty(b3) && a(a3, str2) && a(b3, str3)) {
                            linkedList.add(statusBarNotification);
                            a2.a(id);
                        }
                    }
                }
                a(context, linkedList);
            }
        }
    }

    public static void a(Context context, LinkedList<? extends Object> linkedList) {
    }

    public static void a(Intent intent) {
        if (intent != null) {
            intent.setFlags(intent.getFlags() & -2 & -3 & -65 & -129);
        }
    }

    @TargetApi(16)
    public static void a(ay ayVar, Context context, String str, dq dqVar, byte[] bArr, int i) {
        ay ayVar2 = ayVar;
        Map a2 = dqVar.a().a();
        if (!TextUtils.equals("3", (CharSequence) a2.get("notification_style_type")) && !TextUtils.equals("4", (CharSequence) a2.get("notification_style_type"))) {
            if (b(a2)) {
                for (int i2 = 1; i2 <= 3; i2++) {
                    String str2 = (String) a2.get(String.format("cust_btn_%s_n", new Object[]{Integer.valueOf(i2)}));
                    if (!TextUtils.isEmpty(str2)) {
                        PendingIntent a3 = a(context, str, dqVar, bArr, i, i2);
                        if (a3 != null) {
                            ayVar.addAction(0, str2, a3);
                        }
                    }
                }
                return;
            }
            if (!TextUtils.isEmpty((CharSequence) a2.get("notification_style_button_left_name"))) {
                PendingIntent a4 = a(context, str, dqVar, bArr, i, 1);
                if (a4 != null) {
                    ayVar.addAction(0, (CharSequence) a2.get("notification_style_button_left_name"), a4);
                }
            }
            if (!TextUtils.isEmpty((CharSequence) a2.get("notification_style_button_mid_name"))) {
                PendingIntent a5 = a(context, str, dqVar, bArr, i, 2);
                if (a5 != null) {
                    ayVar.addAction(0, (CharSequence) a2.get("notification_style_button_mid_name"), a5);
                }
            }
            if (!TextUtils.isEmpty((CharSequence) a2.get("notification_style_button_right_name"))) {
                PendingIntent a6 = a(context, str, dqVar, bArr, i, 3);
                if (a6 != null) {
                    ayVar.addAction(0, (CharSequence) a2.get("notification_style_button_right_name"), a6);
                }
            }
        }
    }

    public static boolean a(Context context, dq dqVar, String str) {
        boolean z = false;
        if (dqVar == null || dqVar.a() == null || dqVar.a().a() == null || TextUtils.isEmpty(str)) {
            com.xiaomi.channel.commonutils.logger.b.a((String) "should clicked activity params are null.");
            return false;
        }
        if (Boolean.parseBoolean((String) dqVar.a().a().get("use_clicked_activity")) && l.a(context, a(str))) {
            z = true;
        }
        return z;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m795a(Context context, String str) {
        return com.xiaomi.channel.commonutils.android.a.b(context, str);
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m796a(Context context, String str, boolean z) {
        boolean z2 = false;
        if (!f.a()) {
            return false;
        }
        if (!z && a(context, str)) {
            z2 = true;
        }
        return z2;
    }

    public static boolean a(di diVar) {
        if (diVar == null) {
            return false;
        }
        String a2 = diVar.a();
        return !TextUtils.isEmpty(a2) && a2.length() == 22 && "satuigmo".indexOf(a2.charAt(0)) >= 0;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m797a(dq dqVar) {
        di a2 = dqVar.a();
        return a(a2) && a2.l();
    }

    public static boolean a(String str, String str2) {
        return TextUtils.isEmpty(str) || str2.contains(str);
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m798a(Map<String, String> map) {
        if (map == null || !map.containsKey("notify_foreground")) {
            return true;
        }
        return "1".equals(map.get("notify_foreground"));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0072, code lost:
        if (android.text.TextUtils.isEmpty(r3) == false) goto L_0x0074;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x004f, code lost:
        if (android.text.TextUtils.isEmpty(r3) == false) goto L_0x0074;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String[] a(android.content.Context r3, com.xiaomi.push.di r4) {
        /*
            java.lang.String r0 = r4.c()
            java.lang.String r1 = r4.d()
            java.util.Map r4 = r4.a()
            if (r4 == 0) goto L_0x0075
            android.content.res.Resources r2 = r3.getResources()
            android.util.DisplayMetrics r2 = r2.getDisplayMetrics()
            int r2 = r2.widthPixels
            android.content.res.Resources r3 = r3.getResources()
            android.util.DisplayMetrics r3 = r3.getDisplayMetrics()
            float r3 = r3.density
            float r2 = (float) r2
            float r2 = r2 / r3
            r3 = 1056964608(0x3f000000, float:0.5)
            float r2 = r2 + r3
            java.lang.Float r3 = java.lang.Float.valueOf(r2)
            int r3 = r3.intValue()
            r2 = 320(0x140, float:4.48E-43)
            if (r3 > r2) goto L_0x0052
            java.lang.String r3 = "title_short"
            java.lang.Object r3 = r4.get(r3)
            java.lang.String r3 = (java.lang.String) r3
            boolean r2 = android.text.TextUtils.isEmpty(r3)
            if (r2 != 0) goto L_0x0043
            r0 = r3
        L_0x0043:
            java.lang.String r3 = "description_short"
            java.lang.Object r3 = r4.get(r3)
            java.lang.String r3 = (java.lang.String) r3
            boolean r4 = android.text.TextUtils.isEmpty(r3)
            if (r4 != 0) goto L_0x0075
            goto L_0x0074
        L_0x0052:
            r2 = 360(0x168, float:5.04E-43)
            if (r3 <= r2) goto L_0x0075
            java.lang.String r3 = "title_long"
            java.lang.Object r3 = r4.get(r3)
            java.lang.String r3 = (java.lang.String) r3
            boolean r2 = android.text.TextUtils.isEmpty(r3)
            if (r2 != 0) goto L_0x0066
            r0 = r3
        L_0x0066:
            java.lang.String r3 = "description_long"
            java.lang.Object r3 = r4.get(r3)
            java.lang.String r3 = (java.lang.String) r3
            boolean r4 = android.text.TextUtils.isEmpty(r3)
            if (r4 != 0) goto L_0x0075
        L_0x0074:
            r1 = r3
        L_0x0075:
            r3 = 2
            java.lang.String[] r3 = new java.lang.String[r3]
            r4 = 0
            r3[r4] = r0
            r4 = 1
            r3[r4] = r1
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.service.ag.a(android.content.Context, com.xiaomi.push.di):java.lang.String[]");
    }

    public static int b(Context context, String str) {
        int a2 = a(context, str, (String) "mipush_notification");
        int a3 = a(context, str, (String) "mipush_small_notification");
        if (a2 <= 0) {
            a2 = a3 > 0 ? a3 : context.getApplicationInfo().icon;
        }
        return a2 == 0 ? context.getApplicationInfo().logo : a2;
    }

    public static int b(Map<String, String> map) {
        if (map == null) {
            return 3;
        }
        String str = map.get("channel_importance");
        if (TextUtils.isEmpty(str)) {
            return 3;
        }
        try {
            com.xiaomi.channel.commonutils.logger.b.c("importance=" + str);
            return Integer.parseInt(str);
        } catch (Exception e2) {
            com.xiaomi.channel.commonutils.logger.b.d("parsing channel importance error: " + e2);
            return 3;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:65:0x012d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.content.Intent b(android.content.Context r5, java.lang.String r6, java.util.Map<java.lang.String, java.lang.String> r7, int r8) {
        /*
            r0 = 0
            if (r7 != 0) goto L_0x0004
            return r0
        L_0x0004:
            if (r8 == 0) goto L_0x000b
            android.content.Intent r5 = a(r5, r6, r7, r8)
            return r5
        L_0x000b:
            java.lang.String r8 = "notify_effect"
            boolean r1 = r7.containsKey(r8)
            if (r1 != 0) goto L_0x0014
            return r0
        L_0x0014:
            java.lang.Object r8 = r7.get(r8)
            java.lang.String r8 = (java.lang.String) r8
            r1 = -1
            java.lang.String r2 = "intent_flag"
            java.lang.Object r2 = r7.get(r2)
            java.lang.String r2 = (java.lang.String) r2
            boolean r3 = android.text.TextUtils.isEmpty(r2)     // Catch:{ NumberFormatException -> 0x002e }
            if (r3 != 0) goto L_0x0043
            int r1 = java.lang.Integer.parseInt(r2)     // Catch:{ NumberFormatException -> 0x002e }
            goto L_0x0043
        L_0x002e:
            r2 = move-exception
            java.lang.String r3 = "Cause by intent_flag: "
            java.lang.StringBuilder r3 = com.android.tools.r8.GeneratedOutlineSupport.outline73(r3)
            java.lang.String r2 = r2.getMessage()
            r3.append(r2)
            java.lang.String r2 = r3.toString()
            com.xiaomi.channel.commonutils.logger.b.d(r2)
        L_0x0043:
            java.lang.String r2 = com.xiaomi.push.service.bd.f4898a
            boolean r2 = r2.equals(r8)
            java.lang.String r3 = "Cause: "
            if (r2 == 0) goto L_0x006c
            android.content.pm.PackageManager r7 = r5.getPackageManager()     // Catch:{ Exception -> 0x0057 }
            android.content.Intent r6 = r7.getLaunchIntentForPackage(r6)     // Catch:{ Exception -> 0x0057 }
            goto L_0x012b
        L_0x0057:
            r6 = move-exception
            java.lang.StringBuilder r7 = com.android.tools.r8.GeneratedOutlineSupport.outline73(r3)
            java.lang.String r6 = r6.getMessage()
            r7.append(r6)
            java.lang.String r6 = r7.toString()
            com.xiaomi.channel.commonutils.logger.b.d(r6)
            goto L_0x012a
        L_0x006c:
            java.lang.String r2 = com.xiaomi.push.service.bd.f4899b
            boolean r2 = r2.equals(r8)
            if (r2 == 0) goto L_0x00bb
            java.lang.String r2 = "intent_uri"
            boolean r4 = r7.containsKey(r2)
            if (r4 == 0) goto L_0x009d
            java.lang.Object r7 = r7.get(r2)
            java.lang.String r7 = (java.lang.String) r7
            if (r7 == 0) goto L_0x012a
            r2 = 1
            android.content.Intent r7 = android.content.Intent.parseUri(r7, r2)     // Catch:{ URISyntaxException -> 0x0091 }
            r7.setPackage(r6)     // Catch:{ URISyntaxException -> 0x008f }
        L_0x008c:
            r6 = r7
            goto L_0x012b
        L_0x008f:
            r6 = move-exception
            goto L_0x0093
        L_0x0091:
            r6 = move-exception
            r7 = r0
        L_0x0093:
            java.lang.StringBuilder r2 = com.android.tools.r8.GeneratedOutlineSupport.outline73(r3)
            java.lang.String r6 = r6.getMessage()
            goto L_0x011e
        L_0x009d:
            java.lang.String r2 = "class_name"
            boolean r4 = r7.containsKey(r2)
            if (r4 == 0) goto L_0x012a
            java.lang.Object r7 = r7.get(r2)
            java.lang.String r7 = (java.lang.String) r7
            android.content.Intent r2 = new android.content.Intent
            r2.<init>()
            android.content.ComponentName r4 = new android.content.ComponentName
            r4.<init>(r6, r7)
            r2.setComponent(r4)
            r6 = r2
            goto L_0x012b
        L_0x00bb:
            java.lang.String r6 = com.xiaomi.push.service.bd.f4900c
            boolean r6 = r6.equals(r8)
            if (r6 == 0) goto L_0x012a
            java.lang.String r6 = "web_uri"
            java.lang.Object r6 = r7.get(r6)
            java.lang.String r6 = (java.lang.String) r6
            if (r6 == 0) goto L_0x012a
            java.lang.String r6 = r6.trim()
            java.lang.String r7 = "http://"
            boolean r2 = r6.startsWith(r7)
            if (r2 != 0) goto L_0x00e6
            java.lang.String r2 = "https://"
            boolean r2 = r6.startsWith(r2)
            if (r2 != 0) goto L_0x00e6
            java.lang.String r6 = com.android.tools.r8.GeneratedOutlineSupport.outline50(r7, r6)
        L_0x00e6:
            java.net.URL r7 = new java.net.URL     // Catch:{ MalformedURLException -> 0x0114 }
            r7.<init>(r6)     // Catch:{ MalformedURLException -> 0x0114 }
            java.lang.String r7 = r7.getProtocol()     // Catch:{ MalformedURLException -> 0x0114 }
            java.lang.String r2 = "http"
            boolean r2 = r2.equals(r7)     // Catch:{ MalformedURLException -> 0x0114 }
            if (r2 != 0) goto L_0x00ff
            java.lang.String r2 = "https"
            boolean r7 = r2.equals(r7)     // Catch:{ MalformedURLException -> 0x0114 }
            if (r7 == 0) goto L_0x012a
        L_0x00ff:
            android.content.Intent r7 = new android.content.Intent     // Catch:{ MalformedURLException -> 0x0114 }
            java.lang.String r2 = "android.intent.action.VIEW"
            r7.<init>(r2)     // Catch:{ MalformedURLException -> 0x0114 }
            android.net.Uri r6 = android.net.Uri.parse(r6)     // Catch:{ MalformedURLException -> 0x0112 }
            r7.setData(r6)     // Catch:{ MalformedURLException -> 0x0112 }
            com.xiaomi.push.service.ar.a(r5, r7)     // Catch:{ MalformedURLException -> 0x0112 }
            goto L_0x008c
        L_0x0112:
            r6 = move-exception
            goto L_0x0116
        L_0x0114:
            r6 = move-exception
            r7 = r0
        L_0x0116:
            java.lang.StringBuilder r2 = com.android.tools.r8.GeneratedOutlineSupport.outline73(r3)
            java.lang.String r6 = r6.getMessage()
        L_0x011e:
            r2.append(r6)
            java.lang.String r6 = r2.toString()
            com.xiaomi.channel.commonutils.logger.b.d(r6)
            goto L_0x008c
        L_0x012a:
            r6 = r0
        L_0x012b:
            if (r6 == 0) goto L_0x0184
            if (r1 < 0) goto L_0x0132
            r6.setFlags(r1)
        L_0x0132:
            a(r6)
            r7 = 268435456(0x10000000, float:2.524355E-29)
            r6.addFlags(r7)
            android.content.pm.PackageManager r7 = r5.getPackageManager()     // Catch:{ Exception -> 0x0171 }
            r1 = 65536(0x10000, float:9.1835E-41)
            android.content.pm.ResolveInfo r7 = r7.resolveActivity(r6, r1)     // Catch:{ Exception -> 0x0171 }
            if (r7 == 0) goto L_0x0147
            return r6
        L_0x0147:
            int r7 = android.os.Build.VERSION.SDK_INT     // Catch:{ Exception -> 0x0171 }
            r1 = 30
            if (r7 < r1) goto L_0x015c
            boolean r5 = com.xiaomi.channel.commonutils.android.f.a(r5)     // Catch:{ Exception -> 0x0171 }
            if (r5 != 0) goto L_0x015c
            java.lang.String r5 = com.xiaomi.push.service.bd.f4900c     // Catch:{ Exception -> 0x0171 }
            boolean r5 = r5.equals(r8)     // Catch:{ Exception -> 0x0171 }
            if (r5 == 0) goto L_0x015c
            return r6
        L_0x015c:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0171 }
            r5.<init>()     // Catch:{ Exception -> 0x0171 }
            java.lang.String r7 = "not resolve activity:"
            r5.append(r7)     // Catch:{ Exception -> 0x0171 }
            r5.append(r6)     // Catch:{ Exception -> 0x0171 }
            java.lang.String r5 = r5.toString()     // Catch:{ Exception -> 0x0171 }
            com.xiaomi.channel.commonutils.logger.b.a(r5)     // Catch:{ Exception -> 0x0171 }
            goto L_0x0184
        L_0x0171:
            r5 = move-exception
            java.lang.StringBuilder r6 = com.android.tools.r8.GeneratedOutlineSupport.outline73(r3)
            java.lang.String r5 = r5.getMessage()
            r6.append(r5)
            java.lang.String r5 = r6.toString()
            com.xiaomi.channel.commonutils.logger.b.d(r5)
        L_0x0184:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.service.ag.b(android.content.Context, java.lang.String, java.util.Map, int):android.content.Intent");
    }

    /* renamed from: b  reason: collision with other method in class */
    public static void m799b(Context context, String str) {
        context.getSharedPreferences("pref_notify_type", 0).edit().remove(str).commit();
    }

    public static void b(Context context, String str, int i) {
        context.getSharedPreferences("pref_notify_type", 0).edit().putInt(str, i).commit();
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x002f  */
    /* JADX WARNING: Removed duplicated region for block: B:16:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void b(android.content.Context r2, java.lang.String r3, com.xiaomi.push.ay r4, java.util.Map<java.lang.String, java.lang.String> r5) {
        /*
            boolean r0 = com.xiaomi.channel.commonutils.android.f.a(r2)
            if (r0 != 0) goto L_0x002c
            java.lang.String r0 = "fcm_icon_uri"
            java.lang.String r0 = a(r5, r0)
            java.lang.String r1 = "fcm_icon_color"
            java.lang.String r5 = a(r5, r1)
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            if (r1 != 0) goto L_0x002c
            boolean r1 = android.text.TextUtils.isEmpty(r5)
            if (r1 != 0) goto L_0x002c
            int r0 = a(r2, r3, r0)
            if (r0 <= 0) goto L_0x002c
            r1 = 1
            r4.setSmallIcon(r0)
            r4.a(r5)
            goto L_0x002d
        L_0x002c:
            r1 = 0
        L_0x002d:
            if (r1 != 0) goto L_0x0048
            int r5 = android.os.Build.VERSION.SDK_INT
            r0 = 23
            if (r5 < r0) goto L_0x0041
            int r2 = com.xiaomi.push.service.ar.a(r2, r3)
            android.graphics.drawable.Icon r2 = android.graphics.drawable.Icon.createWithResource(r3, r2)
            r4.setSmallIcon(r2)
            goto L_0x0048
        L_0x0041:
            int r2 = b(r2, r3)
            r4.setSmallIcon(r2)
        L_0x0048:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.service.ag.b(android.content.Context, java.lang.String, com.xiaomi.push.ay, java.util.Map):void");
    }

    /* renamed from: b  reason: collision with other method in class */
    public static boolean m800b(Context context, String str) {
        return context.getSharedPreferences("pref_notify_type", 0).contains(str);
    }

    public static boolean b(dq dqVar) {
        di a2 = dqVar.a();
        return a(a2) && a2.f495b == 1 && !a(dqVar);
    }

    /* renamed from: b  reason: collision with other method in class */
    public static boolean m801b(Map<String, String> map) {
        if (map != null) {
            return "6".equals(map.get("notification_style_type"));
        }
        com.xiaomi.channel.commonutils.logger.b.a((String) "meta extra is null");
        return false;
    }

    public static int c(Map<String, String> map) {
        if (map == null) {
            return 0;
        }
        String str = map.get("notification_priority");
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        try {
            com.xiaomi.channel.commonutils.logger.b.c("priority=" + str);
            return Integer.parseInt(str);
        } catch (Exception e2) {
            com.xiaomi.channel.commonutils.logger.b.d("parsing notification priority error: " + e2);
            return 0;
        }
    }

    public static boolean c(dq dqVar) {
        di a2 = dqVar.a();
        return a(a2) && a2.f495b == 0 && !a(dqVar);
    }
}
