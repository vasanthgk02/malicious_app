package com.google.firebase.messaging;

import android.annotation.TargetApi;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.graphics.drawable.AdaptiveIconDrawable;
import android.os.Build.VERSION;
import android.os.SystemClock;
import androidx.core.app.NotificationCompat.Builder;
import java.util.concurrent.atomic.AtomicInteger;

public final class CommonNotificationBuilder {
    public static final AtomicInteger requestCodeProvider = new AtomicInteger((int) SystemClock.elapsedRealtime());

    public static class DisplayNotificationInfo {
        public final int id;
        public final Builder notificationBuilder;
        public final String tag;

        public DisplayNotificationInfo(Builder builder, String str, int i) {
            this.notificationBuilder = builder;
            this.tag = str;
            this.id = i;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:47:0x0100, code lost:
        if (isValidIcon(r4, r9) != false) goto L_0x0134;
     */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x0236  */
    /* JADX WARNING: Removed duplicated region for block: B:110:0x0238  */
    /* JADX WARNING: Removed duplicated region for block: B:116:0x0274  */
    /* JADX WARNING: Removed duplicated region for block: B:119:0x0283 A[SYNTHETIC, Splitter:B:119:0x0283] */
    /* JADX WARNING: Removed duplicated region for block: B:124:0x0295 A[SYNTHETIC, Splitter:B:124:0x0295] */
    /* JADX WARNING: Removed duplicated region for block: B:129:0x02a1  */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x003d A[SYNTHETIC, Splitter:B:12:0x003d] */
    /* JADX WARNING: Removed duplicated region for block: B:132:0x02c3  */
    /* JADX WARNING: Removed duplicated region for block: B:135:0x02cf  */
    /* JADX WARNING: Removed duplicated region for block: B:142:0x02f4  */
    /* JADX WARNING: Removed duplicated region for block: B:145:0x0304  */
    /* JADX WARNING: Removed duplicated region for block: B:152:0x0329  */
    /* JADX WARNING: Removed duplicated region for block: B:155:0x0339  */
    /* JADX WARNING: Removed duplicated region for block: B:160:0x0358  */
    /* JADX WARNING: Removed duplicated region for block: B:163:0x0367  */
    /* JADX WARNING: Removed duplicated region for block: B:166:0x0377  */
    /* JADX WARNING: Removed duplicated region for block: B:169:0x0380  */
    /* JADX WARNING: Removed duplicated region for block: B:172:0x0397  */
    /* JADX WARNING: Removed duplicated region for block: B:175:0x03a1  */
    /* JADX WARNING: Removed duplicated region for block: B:178:0x03b5  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00bb  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00ca  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00e5  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x0143  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x0150  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x0152  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x0186  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x0195  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x01a3  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x01c2  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x01c4  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.firebase.messaging.CommonNotificationBuilder.DisplayNotificationInfo createNotificationInfo(android.content.Context r13, com.google.firebase.messaging.NotificationParams r14) {
        /*
            java.lang.String r0 = "Couldn't get own application info: "
            android.content.pm.PackageManager r1 = r13.getPackageManager()
            java.lang.String r2 = r13.getPackageName()
            r3 = 128(0x80, float:1.8E-43)
            android.content.pm.ApplicationInfo r1 = r1.getApplicationInfo(r2, r3)     // Catch:{ NameNotFoundException -> 0x0019 }
            if (r1 == 0) goto L_0x0028
            android.os.Bundle r2 = r1.metaData     // Catch:{ NameNotFoundException -> 0x0019 }
            if (r2 == 0) goto L_0x0028
            android.os.Bundle r1 = r1.metaData     // Catch:{ NameNotFoundException -> 0x0019 }
            goto L_0x002a
        L_0x0019:
            r1 = move-exception
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r0)
            r2.append(r1)
            r2.toString()
        L_0x0028:
            android.os.Bundle r1 = android.os.Bundle.EMPTY
        L_0x002a:
            java.lang.String r2 = r13.getPackageName()
            java.lang.String r3 = "gcm.n.android_channel_id"
            java.lang.String r3 = r14.getString(r3)
            int r4 = android.os.Build.VERSION.SDK_INT
            r5 = 26
            r6 = 0
            r7 = 0
            if (r4 >= r5) goto L_0x003d
            goto L_0x00a1
        L_0x003d:
            android.content.pm.PackageManager r4 = r13.getPackageManager()     // Catch:{ NameNotFoundException -> 0x00a1 }
            java.lang.String r8 = r13.getPackageName()     // Catch:{ NameNotFoundException -> 0x00a1 }
            android.content.pm.ApplicationInfo r4 = r4.getApplicationInfo(r8, r7)     // Catch:{ NameNotFoundException -> 0x00a1 }
            int r4 = r4.targetSdkVersion     // Catch:{ NameNotFoundException -> 0x00a1 }
            if (r4 >= r5) goto L_0x004e
            goto L_0x00a1
        L_0x004e:
            java.lang.Class<android.app.NotificationManager> r4 = android.app.NotificationManager.class
            java.lang.Object r4 = r13.getSystemService(r4)
            android.app.NotificationManager r4 = (android.app.NotificationManager) r4
            boolean r5 = android.text.TextUtils.isEmpty(r3)
            if (r5 != 0) goto L_0x0063
            android.app.NotificationChannel r5 = r4.getNotificationChannel(r3)
            if (r5 == 0) goto L_0x0063
            goto L_0x00a2
        L_0x0063:
            java.lang.String r3 = "com.google.firebase.messaging.default_notification_channel_id"
            java.lang.String r3 = r1.getString(r3)
            boolean r5 = android.text.TextUtils.isEmpty(r3)
            if (r5 != 0) goto L_0x0076
            android.app.NotificationChannel r5 = r4.getNotificationChannel(r3)
            if (r5 == 0) goto L_0x0076
            goto L_0x00a2
        L_0x0076:
            java.lang.String r3 = "fcm_fallback_notification_channel"
            android.app.NotificationChannel r5 = r4.getNotificationChannel(r3)
            if (r5 != 0) goto L_0x00a2
            android.content.res.Resources r5 = r13.getResources()
            java.lang.String r8 = r13.getPackageName()
            java.lang.String r9 = "fcm_fallback_notification_channel_label"
            java.lang.String r10 = "string"
            int r5 = r5.getIdentifier(r9, r10, r8)
            if (r5 != 0) goto L_0x0093
            java.lang.String r5 = "Misc"
            goto L_0x0097
        L_0x0093:
            java.lang.String r5 = r13.getString(r5)
        L_0x0097:
            android.app.NotificationChannel r8 = new android.app.NotificationChannel
            r9 = 3
            r8.<init>(r3, r5, r9)
            r4.createNotificationChannel(r8)
            goto L_0x00a2
        L_0x00a1:
            r3 = r6
        L_0x00a2:
            android.content.res.Resources r4 = r13.getResources()
            android.content.pm.PackageManager r5 = r13.getPackageManager()
            androidx.core.app.NotificationCompat$Builder r8 = new androidx.core.app.NotificationCompat$Builder
            r8.<init>(r13, r3)
            java.lang.String r3 = "gcm.n.title"
            java.lang.String r3 = r14.getPossiblyLocalizedString(r4, r2, r3)
            boolean r9 = android.text.TextUtils.isEmpty(r3)
            if (r9 != 0) goto L_0x00be
            r8.setContentTitle(r3)
        L_0x00be:
            java.lang.String r3 = "gcm.n.body"
            java.lang.String r3 = r14.getPossiblyLocalizedString(r4, r2, r3)
            boolean r9 = android.text.TextUtils.isEmpty(r3)
            if (r9 != 0) goto L_0x00d9
            r8.setContentText(r3)
            androidx.core.app.NotificationCompat$BigTextStyle r9 = new androidx.core.app.NotificationCompat$BigTextStyle
            r9.<init>()
            androidx.core.app.NotificationCompat$BigTextStyle r3 = r9.bigText(r3)
            r8.setStyle(r3)
        L_0x00d9:
            java.lang.String r3 = "gcm.n.icon"
            java.lang.String r3 = r14.getString(r3)
            boolean r9 = android.text.TextUtils.isEmpty(r3)
            if (r9 != 0) goto L_0x0103
            java.lang.String r9 = "drawable"
            int r9 = r4.getIdentifier(r3, r9, r2)
            if (r9 == 0) goto L_0x00f4
            boolean r10 = isValidIcon(r4, r9)
            if (r10 == 0) goto L_0x00f4
            goto L_0x0134
        L_0x00f4:
            java.lang.String r9 = "mipmap"
            int r9 = r4.getIdentifier(r3, r9, r2)
            if (r9 == 0) goto L_0x0103
            boolean r3 = isValidIcon(r4, r9)
            if (r3 == 0) goto L_0x0103
            goto L_0x0134
        L_0x0103:
            java.lang.String r3 = "com.google.firebase.messaging.default_notification_icon"
            int r3 = r1.getInt(r3, r7)
            if (r3 == 0) goto L_0x0111
            boolean r9 = isValidIcon(r4, r3)
            if (r9 != 0) goto L_0x0128
        L_0x0111:
            android.content.pm.ApplicationInfo r9 = r5.getApplicationInfo(r2, r7)     // Catch:{ NameNotFoundException -> 0x0119 }
            int r0 = r9.icon     // Catch:{ NameNotFoundException -> 0x0119 }
            r9 = r0
            goto L_0x0129
        L_0x0119:
            r9 = move-exception
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            r10.append(r0)
            r10.append(r9)
            r10.toString()
        L_0x0128:
            r9 = r3
        L_0x0129:
            if (r9 == 0) goto L_0x0131
            boolean r0 = isValidIcon(r4, r9)
            if (r0 != 0) goto L_0x0134
        L_0x0131:
            r9 = 17301651(0x1080093, float:2.4979667E-38)
        L_0x0134:
            r8.setSmallIcon(r9)
            java.lang.String r0 = "gcm.n.sound2"
            java.lang.String r0 = r14.getString(r0)
            boolean r3 = android.text.TextUtils.isEmpty(r0)
            if (r3 == 0) goto L_0x0149
            java.lang.String r0 = "gcm.n.sound"
            java.lang.String r0 = r14.getString(r0)
        L_0x0149:
            boolean r3 = android.text.TextUtils.isEmpty(r0)
            r9 = 2
            if (r3 == 0) goto L_0x0152
            r0 = r6
            goto L_0x0184
        L_0x0152:
            java.lang.String r3 = "default"
            boolean r3 = r3.equals(r0)
            if (r3 != 0) goto L_0x0180
            java.lang.String r3 = "raw"
            int r3 = r4.getIdentifier(r0, r3, r2)
            if (r3 == 0) goto L_0x0180
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "android.resource://"
            r3.append(r4)
            r3.append(r2)
            java.lang.String r4 = "/raw/"
            r3.append(r4)
            r3.append(r0)
            java.lang.String r0 = r3.toString()
            android.net.Uri r0 = android.net.Uri.parse(r0)
            goto L_0x0184
        L_0x0180:
            android.net.Uri r0 = android.media.RingtoneManager.getDefaultUri(r9)
        L_0x0184:
            if (r0 == 0) goto L_0x0189
            r8.setSound(r0)
        L_0x0189:
            java.lang.String r0 = "gcm.n.click_action"
            java.lang.String r0 = r14.getString(r0)
            boolean r3 = android.text.TextUtils.isEmpty(r0)
            if (r3 != 0) goto L_0x01a3
            android.content.Intent r3 = new android.content.Intent
            r3.<init>(r0)
            r3.setPackage(r2)
            r0 = 268435456(0x10000000, float:2.524355E-29)
            r3.setFlags(r0)
            goto L_0x01bb
        L_0x01a3:
            android.net.Uri r0 = r14.getLink()
            if (r0 == 0) goto L_0x01b7
            android.content.Intent r3 = new android.content.Intent
            java.lang.String r4 = "android.intent.action.VIEW"
            r3.<init>(r4)
            r3.setPackage(r2)
            r3.setData(r0)
            goto L_0x01bb
        L_0x01b7:
            android.content.Intent r3 = r5.getLaunchIntentForPackage(r2)
        L_0x01bb:
            r0 = 23
            java.lang.String r2 = "google.c.a.e"
            r4 = 1
            if (r3 != 0) goto L_0x01c4
            r3 = r6
            goto L_0x022d
        L_0x01c4:
            r5 = 67108864(0x4000000, float:1.5046328E-36)
            r3.addFlags(r5)
            android.os.Bundle r5 = new android.os.Bundle
            android.os.Bundle r10 = r14.data
            r5.<init>(r10)
            android.os.Bundle r10 = r14.data
            java.util.Set r10 = r10.keySet()
            java.util.Iterator r10 = r10.iterator()
        L_0x01da:
            boolean r11 = r10.hasNext()
            if (r11 == 0) goto L_0x0208
            java.lang.Object r11 = r10.next()
            java.lang.String r11 = (java.lang.String) r11
            java.lang.String r12 = "google.c."
            boolean r12 = r11.startsWith(r12)
            if (r12 != 0) goto L_0x0201
            java.lang.String r12 = "gcm.n."
            boolean r12 = r11.startsWith(r12)
            if (r12 != 0) goto L_0x0201
            java.lang.String r12 = "gcm.notification."
            boolean r12 = r11.startsWith(r12)
            if (r12 == 0) goto L_0x01ff
            goto L_0x0201
        L_0x01ff:
            r12 = 0
            goto L_0x0202
        L_0x0201:
            r12 = 1
        L_0x0202:
            if (r12 == 0) goto L_0x01da
            r5.remove(r11)
            goto L_0x01da
        L_0x0208:
            r3.putExtras(r5)
            boolean r5 = r14.getBoolean(r2)
            if (r5 == 0) goto L_0x021a
            android.os.Bundle r5 = r14.paramsForAnalyticsIntent()
            java.lang.String r10 = "gcm.n.analytics_data"
            r3.putExtra(r10, r5)
        L_0x021a:
            java.util.concurrent.atomic.AtomicInteger r5 = requestCodeProvider
            int r5 = r5.incrementAndGet()
            int r10 = android.os.Build.VERSION.SDK_INT
            if (r10 < r0) goto L_0x0227
            r10 = 1140850688(0x44000000, float:512.0)
            goto L_0x0229
        L_0x0227:
            r10 = 1073741824(0x40000000, float:2.0)
        L_0x0229:
            android.app.PendingIntent r3 = android.app.PendingIntent.getActivity(r13, r5, r3, r10)
        L_0x022d:
            r8.setContentIntent(r3)
            boolean r2 = r14.getBoolean(r2)
            if (r2 != 0) goto L_0x0238
            r0 = r6
            goto L_0x0272
        L_0x0238:
            android.content.Intent r2 = new android.content.Intent
            java.lang.String r3 = "com.google.firebase.messaging.NOTIFICATION_DISMISS"
            r2.<init>(r3)
            android.os.Bundle r3 = r14.paramsForAnalyticsIntent()
            android.content.Intent r2 = r2.putExtras(r3)
            java.util.concurrent.atomic.AtomicInteger r3 = requestCodeProvider
            int r3 = r3.incrementAndGet()
            android.content.Intent r5 = new android.content.Intent
            java.lang.String r10 = "com.google.firebase.MESSAGING_EVENT"
            r5.<init>(r10)
            android.content.ComponentName r10 = new android.content.ComponentName
            java.lang.String r11 = "com.google.firebase.iid.FirebaseInstanceIdReceiver"
            r10.<init>(r13, r11)
            android.content.Intent r5 = r5.setComponent(r10)
            java.lang.String r10 = "wrapped_intent"
            android.content.Intent r2 = r5.putExtra(r10, r2)
            int r5 = android.os.Build.VERSION.SDK_INT
            if (r5 < r0) goto L_0x026c
            r0 = 1140850688(0x44000000, float:512.0)
            goto L_0x026e
        L_0x026c:
            r0 = 1073741824(0x40000000, float:2.0)
        L_0x026e:
            android.app.PendingIntent r0 = android.app.PendingIntent.getBroadcast(r13, r3, r2, r0)
        L_0x0272:
            if (r0 == 0) goto L_0x0277
            r8.setDeleteIntent(r0)
        L_0x0277:
            java.lang.String r0 = "gcm.n.color"
            java.lang.String r0 = r14.getString(r0)
            boolean r2 = android.text.TextUtils.isEmpty(r0)
            if (r2 != 0) goto L_0x028d
            int r0 = android.graphics.Color.parseColor(r0)     // Catch:{ IllegalArgumentException -> 0x028c }
            java.lang.Integer r13 = java.lang.Integer.valueOf(r0)     // Catch:{ IllegalArgumentException -> 0x028c }
            goto L_0x029f
        L_0x028c:
        L_0x028d:
            java.lang.String r0 = "com.google.firebase.messaging.default_notification_color"
            int r0 = r1.getInt(r0, r7)
            if (r0 == 0) goto L_0x029e
            int r13 = androidx.core.content.ContextCompat.getColor(r13, r0)     // Catch:{ NotFoundException -> 0x029e }
            java.lang.Integer r13 = java.lang.Integer.valueOf(r13)     // Catch:{ NotFoundException -> 0x029e }
            goto L_0x029f
        L_0x029e:
            r13 = r6
        L_0x029f:
            if (r13 == 0) goto L_0x02a8
            int r13 = r13.intValue()
            r8.setColor(r13)
        L_0x02a8:
            java.lang.String r13 = "gcm.n.sticky"
            boolean r13 = r14.getBoolean(r13)
            r13 = r13 ^ r4
            r8.setAutoCancel(r13)
            java.lang.String r13 = "gcm.n.local_only"
            boolean r13 = r14.getBoolean(r13)
            r8.setLocalOnly(r13)
            java.lang.String r13 = "gcm.n.ticker"
            java.lang.String r13 = r14.getString(r13)
            if (r13 == 0) goto L_0x02c6
            r8.setTicker(r13)
        L_0x02c6:
            java.lang.String r13 = "gcm.n.notification_priority"
            java.lang.Integer r13 = r14.getInteger(r13)
            if (r13 != 0) goto L_0x02cf
            goto L_0x02f1
        L_0x02cf:
            int r0 = r13.intValue()
            r1 = -2
            if (r0 < r1) goto L_0x02dc
            int r0 = r13.intValue()
            if (r0 <= r9) goto L_0x02f2
        L_0x02dc:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "notificationPriority is invalid "
            r0.append(r1)
            r0.append(r13)
            java.lang.String r13 = ". Skipping setting notificationPriority."
            r0.append(r13)
            r0.toString()
        L_0x02f1:
            r13 = r6
        L_0x02f2:
            if (r13 == 0) goto L_0x02fb
            int r13 = r13.intValue()
            r8.setPriority(r13)
        L_0x02fb:
            java.lang.String r13 = "gcm.n.visibility"
            java.lang.Integer r13 = r14.getInteger(r13)
            if (r13 != 0) goto L_0x0304
            goto L_0x0326
        L_0x0304:
            int r0 = r13.intValue()
            r1 = -1
            if (r0 < r1) goto L_0x0311
            int r0 = r13.intValue()
            if (r0 <= r4) goto L_0x0327
        L_0x0311:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "visibility is invalid: "
            r0.append(r1)
            r0.append(r13)
            java.lang.String r13 = ". Skipping setting visibility."
            r0.append(r13)
            r0.toString()
        L_0x0326:
            r13 = r6
        L_0x0327:
            if (r13 == 0) goto L_0x0330
            int r13 = r13.intValue()
            r8.setVisibility(r13)
        L_0x0330:
            java.lang.String r13 = "gcm.n.notification_count"
            java.lang.Integer r13 = r14.getInteger(r13)
            if (r13 != 0) goto L_0x0339
            goto L_0x0356
        L_0x0339:
            int r0 = r13.intValue()
            if (r0 >= 0) goto L_0x0355
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "notificationCount is invalid: "
            r0.append(r1)
            r0.append(r13)
            java.lang.String r13 = ". Skipping setting notificationCount."
            r0.append(r13)
            r0.toString()
            goto L_0x0356
        L_0x0355:
            r6 = r13
        L_0x0356:
            if (r6 == 0) goto L_0x035f
            int r13 = r6.intValue()
            r8.setNumber(r13)
        L_0x035f:
            java.lang.String r13 = "gcm.n.event_time"
            java.lang.Long r13 = r14.getLong(r13)
            if (r13 == 0) goto L_0x0371
            r8.setShowWhen(r4)
            long r0 = r13.longValue()
            r8.setWhen(r0)
        L_0x0371:
            long[] r13 = r14.getVibrateTimings()
            if (r13 == 0) goto L_0x037a
            r8.setVibrate(r13)
        L_0x037a:
            int[] r13 = r14.getLightSettings()
            if (r13 == 0) goto L_0x0389
            r0 = r13[r7]
            r1 = r13[r4]
            r13 = r13[r9]
            r8.setLights(r0, r1, r13)
        L_0x0389:
            java.lang.String r13 = "gcm.n.default_sound"
            boolean r13 = r14.getBoolean(r13)
            java.lang.String r0 = "gcm.n.default_vibrate_timings"
            boolean r0 = r14.getBoolean(r0)
            if (r0 == 0) goto L_0x0399
            r13 = r13 | 2
        L_0x0399:
            java.lang.String r0 = "gcm.n.default_light_settings"
            boolean r0 = r14.getBoolean(r0)
            if (r0 == 0) goto L_0x03a3
            r13 = r13 | 4
        L_0x03a3:
            r8.setDefaults(r13)
            com.google.firebase.messaging.CommonNotificationBuilder$DisplayNotificationInfo r13 = new com.google.firebase.messaging.CommonNotificationBuilder$DisplayNotificationInfo
            java.lang.String r0 = "gcm.n.tag"
            java.lang.String r14 = r14.getString(r0)
            boolean r0 = android.text.TextUtils.isEmpty(r14)
            if (r0 != 0) goto L_0x03b5
            goto L_0x03c6
        L_0x03b5:
            java.lang.String r14 = "FCM-Notification:"
            java.lang.StringBuilder r14 = com.android.tools.r8.GeneratedOutlineSupport.outline73(r14)
            long r0 = android.os.SystemClock.uptimeMillis()
            r14.append(r0)
            java.lang.String r14 = r14.toString()
        L_0x03c6:
            r13.<init>(r8, r14, r7)
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.messaging.CommonNotificationBuilder.createNotificationInfo(android.content.Context, com.google.firebase.messaging.NotificationParams):com.google.firebase.messaging.CommonNotificationBuilder$DisplayNotificationInfo");
    }

    @TargetApi(26)
    public static boolean isValidIcon(Resources resources, int i) {
        if (VERSION.SDK_INT != 26) {
            return true;
        }
        try {
            return !(resources.getDrawable(i, null) instanceof AdaptiveIconDrawable);
        } catch (NotFoundException unused) {
            return false;
        }
    }
}
