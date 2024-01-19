package com.mpl.androidapp.notification;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat.BigPictureStyle;
import androidx.core.app.NotificationCompat.Builder;
import androidx.core.content.ContextCompat;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.freshchat.consumer.sdk.beans.config.DefaultRemoteConfig;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import com.mpl.androidapp.R;
import com.mpl.androidapp.react.MPLReactContainerActivity;
import com.mpl.androidapp.utils.CleverTapAnalyticsUtils;
import com.mpl.androidapp.utils.CommonUtils;
import com.mpl.androidapp.utils.Constant;
import com.mpl.androidapp.utils.Constant.ChannelConstants;
import com.mpl.androidapp.utils.Constant.EventsConstants;
import com.mpl.androidapp.utils.MBuildConfigUtils;
import com.mpl.androidapp.utils.MLogger;
import com.mpl.androidapp.utils.MSharedPreferencesUtils;
import com.mpl.androidapp.utils.Util;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Calendar;
import org.apache.pdfbox.pdmodel.interactive.form.PDChoice;
import org.json.JSONObject;
import sfs2x.client.core.SFSEvent;

public class LocalGeneratedNotificationReceiver extends BroadcastReceiver {
    public static final String TAG = "LocalGeneratedNotificat";

    private Intent buildGameLaunchIntent(Context context, int i) {
        Intent intent = new Intent(context, MPLReactContainerActivity.class);
        Bundle outline14 = GeneratedOutlineSupport.outline14("action", "OPEN_DEEP_LINK");
        outline14.putString("actionParams", "{\"actionType\":\"nav\",\"actionPayload\":{\"route\":\"GamesTab\",\"param\":{\"id\":" + i + "}}}");
        intent.putExtras(outline14);
        return intent;
    }

    private Intent buildIntentWithDeepLink(Context context, String str, int i) {
        MLogger.d(TAG, "buildIntentWithDeepLink: ");
        Intent intent = new Intent(context, MPLReactContainerActivity.class);
        try {
            Bundle jsonToBundle = Util.jsonToBundle(new JSONObject(str));
            jsonToBundle.putInt(Constant.INTENT_EXTRA_NOTIFICATION_ID, i);
            intent.putExtra(Constant.INTENT_EXTRA_NOTIFICATION_ID, i);
            intent.putExtras(jsonToBundle);
        } catch (Exception e2) {
            MLogger.e(TAG, "buildIntentWithDeepLink: ", e2);
        }
        return intent;
    }

    private BigPictureStyle getBigPictureInNotification(String str) {
        Bitmap bitmap;
        BigPictureStyle bigPictureStyle = new BigPictureStyle();
        try {
            URLConnection uRLConnection = (URLConnection) FirebasePerfUrlConnection.instrument(new URL(str).openConnection());
            uRLConnection.setConnectTimeout(10000);
            uRLConnection.setReadTimeout(10000);
            bitmap = BitmapFactory.decodeStream(uRLConnection.getInputStream());
        } catch (IOException unused) {
            bitmap = null;
        }
        if (bitmap != null) {
            bigPictureStyle.bigPicture(bitmap).build();
        }
        return bigPictureStyle;
    }

    private JSONObject getEventProps(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("Type", str);
            jSONObject.put("TimeStamp", Calendar.getInstance().getTimeInMillis());
            jSONObject.put("Game ID", MBuildConfigUtils.getLaunchingGameId());
            jSONObject.put("Game Name", CommonUtils.getGameNameForID(MBuildConfigUtils.getLaunchingGameId()));
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    private void showNonStickyNotification(Context context, String str) {
        new NotificationBuilder(context).postTaskToBackgroundThread(new Runnable(str, context) {
            public final /* synthetic */ String f$1;
            public final /* synthetic */ Context f$2;

            {
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final void run() {
                LocalGeneratedNotificationReceiver.this.lambda$showNonStickyNotification$0$LocalGeneratedNotificationReceiver(this.f$1, this.f$2);
            }
        });
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(2:12|13) */
    /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
        com.mpl.androidapp.utils.MLogger.e(TAG, "showNonStickyNotification: Exception in sender avatar");
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:12:0x0071 */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x00f3 A[Catch:{ Exception -> 0x01bd }] */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x00fb A[Catch:{ Exception -> 0x01bd }] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0197 A[Catch:{ Exception -> 0x01bd }] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x01a1 A[Catch:{ Exception -> 0x01bd }] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x01b8 A[Catch:{ Exception -> 0x01bd }] */
    /* JADX WARNING: Removed duplicated region for block: B:43:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ void lambda$showNonStickyNotification$0$LocalGeneratedNotificationReceiver(java.lang.String r23, android.content.Context r24) {
        /*
            r22 = this;
            r0 = r22
            r1 = r24
            java.lang.String r2 = "showNonStickyNotification: Exception in sender avatar"
            java.lang.String r3 = ".circlevtw"
            java.lang.String r4 = "LocalGeneratedNotificat"
            java.lang.String r5 = ""
            org.json.JSONObject r6 = new org.json.JSONObject     // Catch:{ Exception -> 0x01bd }
            r7 = r23
            r6.<init>(r7)     // Catch:{ Exception -> 0x01bd }
            java.lang.String r7 = "when"
            r8 = 0
            long r10 = r6.optLong(r7, r8)     // Catch:{ Exception -> 0x01bd }
            java.lang.String r7 = "title"
            java.lang.String r7 = r6.optString(r7, r5)     // Catch:{ Exception -> 0x01bd }
            java.lang.String r12 = "message"
            java.lang.String r12 = r6.optString(r12, r5)     // Catch:{ Exception -> 0x01bd }
            java.lang.String r13 = "deepLink"
            java.lang.String r13 = r6.optString(r13, r5)     // Catch:{ Exception -> 0x01bd }
            java.lang.String r14 = "largeIcon"
            java.lang.String r14 = r6.optString(r14, r5)     // Catch:{ Exception -> 0x01bd }
            java.lang.String r15 = "bigPicture"
            java.lang.String r5 = r6.optString(r15, r5)     // Catch:{ Exception -> 0x01bd }
            r15 = 0
            r8 = 1
            boolean r9 = android.text.TextUtils.isEmpty(r14)     // Catch:{ Exception -> 0x0071 }
            if (r9 != 0) goto L_0x0078
            boolean r9 = r3.equalsIgnoreCase(r14)     // Catch:{ Exception -> 0x0071 }
            if (r9 != 0) goto L_0x0078
            boolean r9 = android.webkit.URLUtil.isValidUrl(r14)     // Catch:{ Exception -> 0x0071 }
            if (r9 == 0) goto L_0x0078
            java.net.URL r9 = new java.net.URL     // Catch:{ Exception -> 0x0071 }
            r9.<init>(r14)     // Catch:{ Exception -> 0x0071 }
            java.net.URLConnection r9 = r9.openConnection()     // Catch:{ Exception -> 0x0071 }
            java.lang.Object r9 = com.google.firebase.perf.network.FirebasePerfUrlConnection.instrument(r9)     // Catch:{ Exception -> 0x0071 }
            java.net.URLConnection r9 = (java.net.URLConnection) r9     // Catch:{ Exception -> 0x0071 }
            r14 = 10000(0x2710, float:1.4013E-41)
            r9.setConnectTimeout(r14)     // Catch:{ Exception -> 0x0071 }
            r9.setReadTimeout(r14)     // Catch:{ Exception -> 0x0071 }
            java.io.InputStream r9 = r9.getInputStream()     // Catch:{ Exception -> 0x0071 }
            android.graphics.Bitmap r9 = android.graphics.BitmapFactory.decodeStream(r9)     // Catch:{ Exception -> 0x0071 }
            android.graphics.Bitmap r9 = com.mpl.androidapp.utils.CommonUtils.getCircularBitmap(r9)     // Catch:{ Exception -> 0x0071 }
            goto L_0x0079
        L_0x0071:
            java.lang.Object[] r9 = new java.lang.Object[r8]     // Catch:{ Exception -> 0x01bd }
            r9[r15] = r2     // Catch:{ Exception -> 0x01bd }
            com.mpl.androidapp.utils.MLogger.e(r4, r9)     // Catch:{ Exception -> 0x01bd }
        L_0x0078:
            r9 = 0
        L_0x0079:
            java.lang.String r14 = "dismissTime"
            r17 = r9
            r8 = 0
            long r8 = r6.optLong(r14, r8)     // Catch:{ Exception -> 0x01bd }
            java.lang.String r14 = "autoCancel"
            r15 = 1
            boolean r14 = r6.optBoolean(r14, r15)     // Catch:{ Exception -> 0x01bd }
            java.lang.String r15 = "setOngoing"
            r18 = r10
            r10 = 0
            boolean r11 = r6.optBoolean(r15, r10)     // Catch:{ Exception -> 0x01bd }
            java.lang.String r15 = "priority"
            int r15 = r6.optInt(r15, r10)     // Catch:{ Exception -> 0x01bd }
            java.lang.String r10 = "notification"
            java.lang.Object r10 = r1.getSystemService(r10)     // Catch:{ Exception -> 0x01bd }
            android.app.NotificationManager r10 = (android.app.NotificationManager) r10     // Catch:{ Exception -> 0x01bd }
            r16 = r10
            java.util.Random r10 = new java.util.Random     // Catch:{ Exception -> 0x01bd }
            r20 = r8
            r8 = 999(0x3e7, double:4.936E-321)
            r10.<init>(r8)     // Catch:{ Exception -> 0x01bd }
            int r8 = r10.nextInt()     // Catch:{ Exception -> 0x01bd }
            android.content.Intent r8 = r0.buildIntentWithDeepLink(r1, r13, r8)     // Catch:{ Exception -> 0x01bd }
            java.lang.String r9 = "Time To Send"
            java.util.Calendar r10 = java.util.Calendar.getInstance()     // Catch:{ Exception -> 0x01bd }
            r13 = r11
            long r10 = r10.getTimeInMillis()     // Catch:{ Exception -> 0x01bd }
            r8.putExtra(r9, r10)     // Catch:{ Exception -> 0x01bd }
            java.lang.String r9 = "Notification Type"
            java.lang.String r10 = "Game Specific"
            r8.putExtra(r9, r10)     // Catch:{ Exception -> 0x01bd }
            r9 = 67108864(0x4000000, float:1.5046328E-36)
            r8.setFlags(r9)     // Catch:{ Exception -> 0x01bd }
            r9 = 134217728(0x8000000, float:3.85186E-34)
            r10 = 0
            android.app.PendingIntent r8 = android.app.PendingIntent.getActivity(r1, r10, r8, r9)     // Catch:{ Exception -> 0x01bd }
            r10 = 2
            android.net.Uri r11 = android.media.RingtoneManager.getDefaultUri(r10)     // Catch:{ Exception -> 0x01bd }
            androidx.core.app.NotificationCompat$Builder r10 = new androidx.core.app.NotificationCompat$Builder     // Catch:{ Exception -> 0x01bd }
            java.lang.String r9 = "CHAT"
            r10.<init>(r1, r9)     // Catch:{ Exception -> 0x01bd }
            r9 = 2131231343(0x7f08026f, float:1.8078764E38)
            r10.setSmallIcon(r9)     // Catch:{ Exception -> 0x01bd }
            r9 = 2131100229(0x7f060245, float:1.7812834E38)
            int r9 = androidx.core.content.ContextCompat.getColor(r1, r9)     // Catch:{ Exception -> 0x01bd }
            r10.setColor(r9)     // Catch:{ Exception -> 0x01bd }
            if (r17 == 0) goto L_0x00fb
            r9 = r17
            r10.setLargeIcon(r9)     // Catch:{ Exception -> 0x01bd }
            r17 = r13
            goto L_0x010a
        L_0x00fb:
            android.content.res.Resources r9 = r24.getResources()     // Catch:{ Exception -> 0x01bd }
            r17 = r13
            r13 = 2131689472(0x7f0f0000, float:1.900796E38)
            android.graphics.Bitmap r9 = android.graphics.BitmapFactory.decodeResource(r9, r13)     // Catch:{ Exception -> 0x01bd }
            r10.setLargeIcon(r9)     // Catch:{ Exception -> 0x01bd }
        L_0x010a:
            boolean r9 = android.text.TextUtils.isEmpty(r5)     // Catch:{ Exception -> 0x0124 }
            if (r9 != 0) goto L_0x012d
            boolean r3 = r3.equalsIgnoreCase(r5)     // Catch:{ Exception -> 0x0124 }
            if (r3 != 0) goto L_0x012d
            boolean r3 = android.webkit.URLUtil.isValidUrl(r5)     // Catch:{ Exception -> 0x0124 }
            if (r3 == 0) goto L_0x012d
            androidx.core.app.NotificationCompat$BigPictureStyle r3 = r0.getBigPictureInNotification(r5)     // Catch:{ Exception -> 0x0124 }
            r10.setStyle(r3)     // Catch:{ Exception -> 0x0124 }
            goto L_0x012d
        L_0x0124:
            r3 = 1
            java.lang.Object[] r5 = new java.lang.Object[r3]     // Catch:{ Exception -> 0x01bd }
            r3 = 0
            r5[r3] = r2     // Catch:{ Exception -> 0x01bd }
            com.mpl.androidapp.utils.MLogger.e(r4, r5)     // Catch:{ Exception -> 0x01bd }
        L_0x012d:
            androidx.core.app.NotificationCompat$Builder r2 = r10.setContentTitle(r7)     // Catch:{ Exception -> 0x01bd }
            androidx.core.app.NotificationCompat$Builder r2 = r2.setContentText(r12)     // Catch:{ Exception -> 0x01bd }
            androidx.core.app.NotificationCompat$Builder r2 = r2.setContentInfo(r12)     // Catch:{ Exception -> 0x01bd }
            androidx.core.app.NotificationCompat$Builder r2 = r2.setSound(r11)     // Catch:{ Exception -> 0x01bd }
            androidx.core.app.NotificationCompat$Builder r2 = r2.setAutoCancel(r14)     // Catch:{ Exception -> 0x01bd }
            androidx.core.app.NotificationCompat$BigTextStyle r3 = new androidx.core.app.NotificationCompat$BigTextStyle     // Catch:{ Exception -> 0x01bd }
            r3.<init>()     // Catch:{ Exception -> 0x01bd }
            androidx.core.app.NotificationCompat$BigTextStyle r3 = r3.bigText(r12)     // Catch:{ Exception -> 0x01bd }
            androidx.core.app.NotificationCompat$Builder r2 = r2.setStyle(r3)     // Catch:{ Exception -> 0x01bd }
            r3 = r17
            androidx.core.app.NotificationCompat$Builder r2 = r2.setOngoing(r3)     // Catch:{ Exception -> 0x01bd }
            r4 = 1
            androidx.core.app.NotificationCompat$Builder r2 = r2.setOnlyAlertOnce(r4)     // Catch:{ Exception -> 0x01bd }
            androidx.core.app.NotificationCompat$Builder r2 = r2.setPriority(r15)     // Catch:{ Exception -> 0x01bd }
            r4 = r20
            androidx.core.app.NotificationCompat$Builder r2 = r2.setTimeoutAfter(r4)     // Catch:{ Exception -> 0x01bd }
            androidx.core.app.NotificationCompat$Builder r2 = r2.setContentIntent(r8)     // Catch:{ Exception -> 0x01bd }
            r4 = 3
            androidx.core.app.NotificationCompat$Builder r2 = r2.setDefaults(r4)     // Catch:{ Exception -> 0x01bd }
            r4 = 0
            androidx.core.app.NotificationCompat$Builder r2 = r2.setGroupAlertBehavior(r4)     // Catch:{ Exception -> 0x01bd }
            r4 = r18
            androidx.core.app.NotificationCompat$Builder r2 = r2.setWhen(r4)     // Catch:{ Exception -> 0x01bd }
            android.os.Bundle r4 = com.mpl.androidapp.utils.Util.jsonToBundle(r6)     // Catch:{ Exception -> 0x01bd }
            androidx.core.app.NotificationCompat$Builder r2 = r2.setExtras(r4)     // Catch:{ Exception -> 0x01bd }
            r4 = 1
            androidx.core.app.NotificationCompat$Builder r2 = r2.setShowWhen(r4)     // Catch:{ Exception -> 0x01bd }
            r5 = 2
            long[] r5 = new long[r5]     // Catch:{ Exception -> 0x01bd }
            r7 = 1000(0x3e8, double:4.94E-321)
            r9 = 0
            r5[r9] = r7     // Catch:{ Exception -> 0x01bd }
            r5[r4] = r7     // Catch:{ Exception -> 0x01bd }
            r2.setVibrate(r5)     // Catch:{ Exception -> 0x01bd }
            android.app.Notification r2 = r10.build()     // Catch:{ Exception -> 0x01bd }
            if (r3 == 0) goto L_0x019d
            int r3 = r2.flags     // Catch:{ Exception -> 0x01bd }
            r3 = r3 | 34
            r2.flags = r3     // Catch:{ Exception -> 0x01bd }
        L_0x019d:
            r3 = 2006(0x7d6, float:2.811E-42)
            if (r16 == 0) goto L_0x01a6
            r10 = r16
            r10.notify(r3, r2)     // Catch:{ Exception -> 0x01bd }
        L_0x01a6:
            java.lang.String r4 = "Login Reminder"
            org.json.JSONObject r4 = r0.getEventProps(r4)     // Catch:{ Exception -> 0x01bd }
            com.mpl.androidapp.utils.CleverTapAnalyticsUtils.sendLocalNotificationDeliverEvent(r4)     // Catch:{ Exception -> 0x01bd }
            java.lang.String r4 = "shouldSendEvent"
            r5 = 1
            boolean r4 = r6.optBoolean(r4, r5)     // Catch:{ Exception -> 0x01bd }
            if (r4 == 0) goto L_0x01bd
            android.os.Bundle r2 = r2.extras     // Catch:{ Exception -> 0x01bd }
            com.mpl.androidapp.notification.NotificationBuilder.sendEvent(r1, r2, r3)     // Catch:{ Exception -> 0x01bd }
        L_0x01bd:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mpl.androidapp.notification.LocalGeneratedNotificationReceiver.lambda$showNonStickyNotification$0$LocalGeneratedNotificationReceiver(java.lang.String, android.content.Context):void");
    }

    public void onReceive(Context context, Intent intent) {
        Context context2 = context;
        Intent intent2 = intent;
        String stringExtra = intent2.hasExtra(Constant.NOTIFICATION_TYPE) ? intent2.getStringExtra(Constant.NOTIFICATION_TYPE) : "";
        MLogger.d(TAG, "onReceive:notificationType ", stringExtra);
        if (stringExtra != null && !TextUtils.isEmpty(stringExtra)) {
            long j = 43200000;
            if (SFSEvent.LOGIN.equalsIgnoreCase(stringExtra)) {
                if (!MSharedPreferencesUtils.getBooleanInNormalPref(context2, Constant.IS_USER_LOGGED_IN_v2, false)) {
                    long longExtra = intent2.getLongExtra(Constant.LOGIN_INTERVAL_TIME, 0);
                    MLogger.d(TAG, "onReceive:intervalTime ", Long.valueOf(longExtra));
                    showLoginNotification(context);
                    if (longExtra == 300000) {
                        j = 10800000;
                    } else if (longExtra != 10800000) {
                        j = 129600000;
                    }
                    new NotificationBuilder(context2).createNotificationAlarmManagerForLogin(j);
                }
            } else if ("gamePlay".equalsIgnoreCase(stringExtra)) {
                if (MSharedPreferencesUtils.getBooleanInNormalPref(context2, Constant.IS_USER_LOGGED_IN_v2, false) && MSharedPreferencesUtils.getBooleanInNormalPref(context2, Constant.IS_NEW_USER_FOR_NOTIFICATION, false) && !MSharedPreferencesUtils.getBooleanInNormalPref(context2, Constant.IS_USER_PLAYED_GAME_V2, false)) {
                    long longInNormalPref = MSharedPreferencesUtils.getLongInNormalPref(context2, Constant.LOGIN_TIME, 0);
                    MLogger.d(TAG, "onReceive:loginTime ", Long.valueOf(longInNormalPref));
                    if (Calendar.getInstance().getTimeInMillis() - longInNormalPref > 1500000) {
                        showGamePlayNotification(context);
                        long longExtra2 = intent2.getLongExtra(Constant.LOGIN_INTERVAL_TIME, 0);
                        if (longExtra2 == DefaultRemoteConfig.SESSION_TIMEOUT_DURATION) {
                            j = 10800000;
                        } else if (longExtra2 != 10800000) {
                            j = 129600000;
                        }
                        new NotificationBuilder(context2).createNotificationAlarmManagerForGamePlayReminder(j);
                    }
                }
            } else if (!Constant.SPIN_WHEEL_CHANNEL_ID.equalsIgnoreCase(stringExtra)) {
                if ("nonSticky".equalsIgnoreCase(stringExtra) || "schedule".equalsIgnoreCase(stringExtra)) {
                    showNonStickyNotification(context2, intent2.getStringExtra("notification_data"));
                    return;
                } else if ("cancelNotification".equalsIgnoreCase(stringExtra)) {
                    int intExtra = intent2.getIntExtra(Constant.NOTIFICATION_CANCEL_ID, 0);
                    NotificationManager notificationManager = (NotificationManager) context2.getSystemService("notification");
                    if (notificationManager != null) {
                        notificationManager.cancel(intExtra);
                    }
                }
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0065  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x006d  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x00c5  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void showGamePlayNotification(android.content.Context r10) {
        /*
            r9 = this;
            java.lang.String r0 = "notification"
            java.lang.Object r0 = r10.getSystemService(r0)
            android.app.NotificationManager r0 = (android.app.NotificationManager) r0
            int r1 = com.mpl.androidapp.utils.MBuildConfigUtils.getLaunchingGameId()
            android.content.Intent r1 = r9.buildGameLaunchIntent(r10, r1)
            java.util.Calendar r2 = java.util.Calendar.getInstance()
            long r2 = r2.getTimeInMillis()
            java.lang.String r4 = "Time To Send"
            r1.putExtra(r4, r2)
            java.lang.String r2 = "Notification Type"
            java.lang.String r3 = "Game Play"
            r1.putExtra(r2, r3)
            r2 = 0
            r3 = 134217728(0x8000000, float:3.85186E-34)
            android.app.PendingIntent r1 = android.app.PendingIntent.getActivity(r10, r2, r1, r3)
            java.lang.String r3 = com.mpl.androidapp.utils.MSharedPreferencesUtils.getGameReminderTitle(r10)
            java.lang.String r4 = com.mpl.androidapp.utils.MSharedPreferencesUtils.getGameReminderMessage(r10)
            int r5 = com.mpl.androidapp.utils.MBuildConfigUtils.getLaunchingGameId()
            r6 = 777(0x309, float:1.089E-42)
            java.lang.String r7 = "More than Rs.2 Crore worth of prizes daily!"
            java.lang.String r8 = "Play your first game for FREE"
            if (r5 == r6) goto L_0x0059
            r6 = 1000039(0xf4267, float:1.401353E-39)
            if (r5 == r6) goto L_0x0055
            r6 = 1000077(0xf428d, float:1.401406E-39)
            if (r5 == r6) goto L_0x004d
            r5 = 2131231533(0x7f08032d, float:1.807915E38)
            goto L_0x005e
        L_0x004d:
            r5 = 2131231535(0x7f08032f, float:1.8079154E38)
            java.lang.String r3 = "Check out our Points rummy wi"
            java.lang.String r4 = "20 Lakhs of daily prizes"
            goto L_0x005e
        L_0x0055:
            r5 = 2131231534(0x7f08032e, float:1.8079152E38)
            goto L_0x005c
        L_0x0059:
            r5 = 2131231532(0x7f08032c, float:1.8079148E38)
        L_0x005c:
            r4 = r7
            r3 = r8
        L_0x005e:
            boolean r6 = android.text.TextUtils.isEmpty(r3)
            if (r6 == 0) goto L_0x0065
            goto L_0x0066
        L_0x0065:
            r8 = r3
        L_0x0066:
            boolean r3 = android.text.TextUtils.isEmpty(r4)
            if (r3 == 0) goto L_0x006d
            goto L_0x006e
        L_0x006d:
            r7 = r4
        L_0x006e:
            r3 = 3
            java.lang.Object[] r3 = new java.lang.Object[r3]
            java.lang.String r4 = "showGamePlayNotification: "
            r3[r2] = r4
            r2 = 1
            r3[r2] = r8
            r4 = 2
            r3[r4] = r7
            java.lang.String r6 = "LocalGeneratedNotificat"
            com.mpl.androidapp.utils.MLogger.d(r6, r3)
            android.net.Uri r3 = android.media.RingtoneManager.getDefaultUri(r4)
            androidx.core.app.NotificationCompat$Builder r4 = new androidx.core.app.NotificationCompat$Builder
            java.lang.String r6 = "CHAT"
            r4.<init>(r10, r6)
            android.content.res.Resources r6 = r10.getResources()
            android.graphics.Bitmap r5 = android.graphics.BitmapFactory.decodeResource(r6, r5)
            r4.setLargeIcon(r5)
            r5 = 2131231343(0x7f08026f, float:1.8078764E38)
            r4.setSmallIcon(r5)
            r5 = 2131100229(0x7f060245, float:1.7812834E38)
            int r10 = androidx.core.content.ContextCompat.getColor(r10, r5)
            r4.setColor(r10)
            androidx.core.app.NotificationCompat$Builder r10 = r4.setContentTitle(r8)
            androidx.core.app.NotificationCompat$Builder r10 = r10.setContentText(r7)
            androidx.core.app.NotificationCompat$Builder r10 = r10.setSound(r3)
            androidx.core.app.NotificationCompat$Builder r10 = r10.setAutoCancel(r2)
            androidx.core.app.NotificationCompat$Builder r10 = r10.setContentIntent(r1)
            r1 = 5
            long[] r1 = new long[r1]
            r1 = {1000, 1000, 1000, 1000, 1000} // fill-array
            r10.setVibrate(r1)
            if (r0 == 0) goto L_0x00ce
            r10 = 2006(0x7d6, float:2.811E-42)
            android.app.Notification r1 = r4.build()
            r0.notify(r10, r1)
        L_0x00ce:
            java.lang.String r10 = "Game Play Reminder"
            org.json.JSONObject r10 = r9.getEventProps(r10)
            com.mpl.androidapp.utils.CleverTapAnalyticsUtils.sendLocalNotificationDeliverEvent(r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mpl.androidapp.notification.LocalGeneratedNotificationReceiver.showGamePlayNotification(android.content.Context):void");
    }

    public void showLoginNotification(Context context) {
        NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
        Intent intent = new Intent(context, MPLReactContainerActivity.class);
        intent.putExtra(Constant.TIME_TO_SEND, Calendar.getInstance().getTimeInMillis());
        intent.putExtra(EventsConstants.PROP_NOTIFICATION_TYPE, "Login");
        intent.setFlags(PDChoice.FLAG_COMMIT_ON_SEL_CHANGE);
        PendingIntent activity = PendingIntent.getActivity(context, 0, intent, 134217728);
        Uri defaultUri = RingtoneManager.getDefaultUri(2);
        Builder builder = new Builder(context, (String) ChannelConstants.CHAT_NOTIFICATION_CHANNEL_ID);
        builder.setLargeIcon(BitmapFactory.decodeResource(context.getResources(), R.drawable.notif_login_reminder));
        builder.setSmallIcon((int) R.drawable.ic_stat_mpl);
        builder.setColor(ContextCompat.getColor(context, R.color.notif_action_button));
        builder.setContentTitle("Login to MPL to collect your Sign Up Bonus").setContentText("More than Rs.2 Crore worth of prizes daily!").setSound(defaultUri).setAutoCancel(true).setContentIntent(activity).setVibrate(new long[]{1000, 1000, 1000, 1000, 1000});
        if (notificationManager != null) {
            notificationManager.notify(Constant.LOGIN_NOTIFICATION_ID, builder.build());
        }
        CleverTapAnalyticsUtils.sendLocalNotificationDeliverEvent(getEventProps("Login Reminder"));
    }
}
