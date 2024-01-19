package com.mpl.androidapp.notification;

import android.app.AlarmManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.webkit.URLUtil;
import android.widget.RemoteViews;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationCompat.Action;
import androidx.core.app.NotificationCompat.BigPictureStyle;
import androidx.core.app.NotificationCompat.BigTextStyle;
import androidx.core.app.NotificationCompat.Builder;
import androidx.core.app.NotificationCompat.DecoratedCustomViewStyle;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.content.ContextCompat;
import androidx.core.content.FileProvider;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.react.bridge.PromiseImpl;
import com.google.firebase.messaging.RemoteMessage;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.mpl.androidapp.EventPublishHelper;
import com.mpl.androidapp.MPLApplication;
import com.mpl.androidapp.R;
import com.mpl.androidapp.cleverTap.MplCtEventConstants.CtNativeLaunchInitiated;
import com.mpl.androidapp.config.ConfigManager;
import com.mpl.androidapp.contact.ContactUtils;
import com.mpl.androidapp.database.NotificationDataManager;
import com.mpl.androidapp.database.entity.Contact;
import com.mpl.androidapp.game.MPLUnityPlayerActivity;
import com.mpl.androidapp.onesignal.MNotification;
import com.mpl.androidapp.onesignal.OneSingnalConstant;
import com.mpl.androidapp.react.MPLReactContainerActivity;
import com.mpl.androidapp.react.modules.GameLaunchHelper;
import com.mpl.androidapp.receiver.MSMSBroadCastReceiver;
import com.mpl.androidapp.updater.downloadmanager.DownloadNotificationDisplayFeature;
import com.mpl.androidapp.updater.downloadmanager.DownloadNotificationDisplayFeatureCallback;
import com.mpl.androidapp.updater.downloadmanager.di.entrypoints.NotificationDisplayEntryPoint;
import com.mpl.androidapp.utils.CleverTapAnalyticsUtils;
import com.mpl.androidapp.utils.CommonUtils;
import com.mpl.androidapp.utils.Constant;
import com.mpl.androidapp.utils.Constant.ChannelConstants;
import com.mpl.androidapp.utils.Constant.EventsConstants;
import com.mpl.androidapp.utils.CountryUtils;
import com.mpl.androidapp.utils.FileUtils;
import com.mpl.androidapp.utils.MBuildConfigUtils;
import com.mpl.androidapp.utils.MLogger;
import com.mpl.androidapp.utils.MSharedPreferencesUtils;
import com.mpl.androidapp.utils.OriginalGameConstant;
import com.mpl.androidapp.utils.Util;
import com.mpl.androidapp.webview.vm.WebViewGameVm;
import com.netcore.android.notification.SMTNotificationConstants;
import com.twitter.sdk.android.tweetui.TweetUtils;
import in.juspay.hypersdk.core.PaymentConstants.SubCategory;
import in.juspay.hypersdk.mystique.AnimationHolder.InlineAnimation;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Calendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.apache.pdfbox.pdfparser.BaseParser;
import org.apache.pdfbox.pdmodel.interactive.form.PDChoice;
import org.eclipse.paho.client.mqttv3.MqttTopic;
import org.eclipse.paho.client.mqttv3.internal.ClientDefaults;
import org.joda.time.DateTime;
import org.json.JSONException;
import org.json.JSONObject;
import sfs2x.client.core.SFSEvent;

public class NotificationBuilder implements DownloadNotificationDisplayFeatureCallback {
    public static final String TAG = "NotificationBuilder";
    public static final Set<String> mSendBirdSenderIds = new HashSet();
    public BackgroundTaskHandler backgroundTaskHandler;
    public final Context mContext;
    public final Random mRandom = new Random(999);

    public static class Data {
        public List<String> supportedCountryCode;
        public List<String> supportedDeviceType;

        public List<String> getSupportedCountryCode() {
            return this.supportedCountryCode;
        }

        public List<String> getSupportedDeviceType() {
            return this.supportedDeviceType;
        }

        public void setSupportedCountryCode(List<String> list) {
            this.supportedCountryCode = list;
        }

        public void setSupportedDeviceType(List<String> list) {
            this.supportedDeviceType = list;
        }
    }

    public NotificationBuilder(Context context) {
        this.mContext = context;
    }

    private Intent buildChatListIntent(int i) {
        MLogger.d(TAG, "buildChatListIntent: ");
        Intent intent = new Intent(this.mContext, MPLReactContainerActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("action", "OPEN_DEEP_LINK");
        bundle.putString("actionParams", "{\"actionType\":\"nav\",\"actionPayload\":{\"route\":\"Messages\",\"param\":{}}}");
        bundle.putInt(Constant.INTENT_EXTRA_NOTIFICATION_ID, i);
        intent.putExtra(Constant.INTENT_EXTRA_NOTIFICATION_ID, i);
        intent.putExtras(bundle);
        return intent;
    }

    private Intent buildContestDetailsIntent(int i, int i2, int i3, int i4) {
        MLogger.d(TAG, "buildContestDetailsIntent: ");
        Intent intent = new Intent(this.mContext, MPLReactContainerActivity.class);
        Bundle outline14 = GeneratedOutlineSupport.outline14("action", "OPEN_DEEP_LINK");
        StringBuilder outline75 = GeneratedOutlineSupport.outline75("{\"actionType\":\"nav\",\"actionPayload\":{\"route\":\"SuperTeamContestDetail\",\"param\":{\"matchId\":", i, ",\"contestId\":", i2, ",\"sportId\":");
        outline75.append(i3);
        outline75.append("}}}");
        outline14.putString("actionParams", outline75.toString());
        outline14.putInt(Constant.INTENT_EXTRA_NOTIFICATION_ID, i4);
        intent.putExtra(Constant.INTENT_EXTRA_NOTIFICATION_ID, i4);
        intent.putExtras(outline14);
        return intent;
    }

    /* access modifiers changed from: private */
    public Intent buildIntentWithDeepLink(String str, int i, JSONObject jSONObject) {
        MLogger.d(TAG, "buildIntentWithDeepLink: ");
        Intent intent = new Intent(this.mContext, MPLReactContainerActivity.class);
        try {
            Bundle jsonToBundle = Util.jsonToBundle(new JSONObject(str));
            jsonToBundle.putInt(Constant.INTENT_EXTRA_NOTIFICATION_ID, i);
            intent.putExtra(Constant.INTENT_EXTRA_NOTIFICATION_ID, i);
            if (jSONObject != null) {
                jsonToBundle.putAll(Util.jsonToBundle(jSONObject));
            }
            intent.putExtras(jsonToBundle);
        } catch (Exception e2) {
            MLogger.e(TAG, "buildIntentWithDeepLink: ", e2);
        }
        return intent;
    }

    private Intent buildSendBirdIntent(String str, int i) {
        MLogger.d(TAG, "buildSendBirdIntent:1 ");
        Intent intent = new Intent(this.mContext, MPLReactContainerActivity.class);
        Bundle outline14 = GeneratedOutlineSupport.outline14("action", "OPEN_DEEP_LINK");
        outline14.putString("actionParams", "{\"actionType\":\"chat\",\"actionPayload\":" + str + "}");
        outline14.putInt(Constant.INTENT_EXTRA_NOTIFICATION_ID, i);
        intent.putExtra(Constant.INTENT_EXTRA_NOTIFICATION_ID, i);
        intent.putExtras(outline14);
        return intent;
    }

    private Intent buildTournamentLaunchIntent(int i, int i2, int i3) {
        MLogger.d(TAG, "buildTournamentLaunchIntent: ");
        Intent intent = new Intent(this.mContext, MPLReactContainerActivity.class);
        Bundle outline14 = GeneratedOutlineSupport.outline14("action", "OPEN_DEEP_LINK");
        if (i2 == 0) {
            outline14.putString("actionParams", "{\"actionType\":\"nav\",\"actionPayload\":{\"route\":\"Home\",\"param\":{}}}");
        } else if (i < 1000000) {
            outline14.putString("actionParams", "{\"actionType\":\"nav\",\"actionPayload\":{\"route\":\"TournamentDetails\",\"param\":{\"id\":" + i2 + "}}}");
        } else if (i == 1000044 || i == 1000054 || i == 1000056 || i == 1000058 || i == 1000063 || i == 1000068 || i == 1000077) {
            outline14.putString("actionParams", "{\"actionType\":\"nav\",\"actionPayload\":{\"route\":\"GamesTab\",\"param\":{\"id\":" + i + "}}}");
        } else if (CommonUtils.isRummyGameId(i)) {
            outline14.putString("actionParams", "{\"actionType\":\"nav\",\"actionPayload\":{\"route\":\"RummyGameList\",\"param\":{\"id\":" + i + "}}}");
        } else {
            outline14.putString("actionParams", "{\"actionType\":\"nav\",\"actionPayload\":{\"route\":\"LobbyDetails\",\"param\":{\"id\":" + i2 + "}}}");
        }
        outline14.putInt(Constant.INTENT_EXTRA_NOTIFICATION_ID, i3);
        intent.putExtra(Constant.INTENT_EXTRA_NOTIFICATION_ID, i3);
        intent.putExtras(outline14);
        return intent;
    }

    private void cancelNotificationAlarmManagerForGamplay() {
        MLogger.d(Constant.NOTIFICATION_SCHEDULER, "cancelNotificationAlarmManagerForGamplay");
        ((AlarmManager) this.mContext.getSystemService(NotificationCompat.CATEGORY_ALARM)).cancel(createPendingIntentForGamePlay(0));
    }

    private void checkIfOptionalDownloadScreenIsVisited(ApkDownloadNotificationData apkDownloadNotificationData, Context context, int i) {
        String valueOf = String.valueOf(apkDownloadNotificationData.getGameId());
        NotificationDisplayEntryPoint notificationDisplayEntryPoint = (NotificationDisplayEntryPoint) TweetUtils.get(TweetUtils.getApplication(context.getApplicationContext()), NotificationDisplayEntryPoint.class);
        DownloadNotificationDisplayFeature downloadNotificationDisplayFeature = new DownloadNotificationDisplayFeature(notificationDisplayEntryPoint.ioDispatcher(), notificationDisplayEntryPoint.optionalDownloadVisitInsertUseCase(), notificationDisplayEntryPoint.OptionalDownloadVisitUpdateUseCase(), notificationDisplayEntryPoint.optionalDownloadVisitCheckUseCase(), notificationDisplayEntryPoint.optionalDownloadVisitDeleteUseCase());
        downloadNotificationDisplayFeature.checkIfNotificationToBeDisplayed(valueOf, apkDownloadNotificationData, this, i);
    }

    public static void clearSingleGenericNotification(Context context, int i) {
        NotificationManagerCompat.from(context).cancel(i);
    }

    private PendingIntent createCancelPendingIntentForApkDownloadFlow(ApkDownloadNotificationData apkDownloadNotificationData) {
        Context context = this.mContext;
        long parseLong = Long.parseLong(MSharedPreferencesUtils.getStringInNormalPref(context, Constant.THIRD_PARTY_APK_GAME_STATUS, apkDownloadNotificationData.getGameId() + "_" + apkDownloadNotificationData.getServerVersion(), String.valueOf(0)));
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(this.mContext, MPLNotificationCancelReceiver.class));
        intent.putExtra(Constant.NOTIFICATION_ID, apkDownloadNotificationData.getGameId());
        intent.putExtra("downloadRequestId", parseLong);
        intent.putExtra("serverVersion", apkDownloadNotificationData.getServerVersion());
        intent.putExtra(Constant.NOTIFICATION_TYPE, Constant.APK_DOWNLOAD_FLOW);
        return PendingIntent.getBroadcast(this.mContext, 0, intent, ClientDefaults.MAX_MSG_SIZE);
    }

    private PendingIntent createCancelPendingIntentForNonStickyNotification(int i) {
        Intent intent = new Intent(this.mContext, LocalGeneratedNotificationReceiver.class);
        intent.putExtra(Constant.NOTIFICATION_TYPE, "cancelNotification");
        intent.putExtra(Constant.NOTIFICATION_CANCEL_ID, i);
        intent.putExtra(Constant.NOTIFICATION_REQUEST_CODE, i);
        return PendingIntent.getBroadcast(this.mContext, i, intent, 134217728);
    }

    private void createCollectibleNotification(Context context, Bundle bundle) {
        postTaskToBackgroundThread(new Runnable(context, bundle) {
            public final /* synthetic */ Context f$1;
            public final /* synthetic */ Bundle f$2;

            {
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final void run() {
                NotificationBuilder.this.lambda$createCollectibleNotification$4$NotificationBuilder(this.f$1, this.f$2);
            }
        });
    }

    private PendingIntent createInstallPendingIntent(ApkDownloadNotificationData apkDownloadNotificationData) {
        Context context = this.mContext;
        File file = new File(Uri.parse(FileUtils.getApkDownloadedFilePath(this.mContext, Long.parseLong(MSharedPreferencesUtils.getStringInNormalPref(context, Constant.THIRD_PARTY_APK_GAME_STATUS, apkDownloadNotificationData.getGameId() + "_" + apkDownloadNotificationData.getServerVersion(), String.valueOf(0))))).getPath());
        Intent intent = new Intent("android.intent.action.VIEW");
        if (VERSION.SDK_INT > 23) {
            Context context2 = apkDownloadNotificationData.getContext();
            intent.setDataAndType(FileProvider.getUriForFile(context2, apkDownloadNotificationData.getContext().getApplicationContext().getPackageName() + ".provider", file), "application/vnd.android.package-archive");
            intent.addFlags(1);
        } else {
            intent.addFlags(ClientDefaults.MAX_MSG_SIZE);
            intent.setDataAndType(Uri.fromFile(file), "application/vnd.android.package-archive");
        }
        return PendingIntent.getActivity(apkDownloadNotificationData.getContext(), 0, intent, 1073741824);
    }

    private void createNotificationMoreThanFiveUnreadMessages(int i) {
        Uri defaultUri = RingtoneManager.getDefaultUri(2);
        int nextInt = this.mRandom.nextInt();
        notifyNotification("", nextInt, getNotificationBuilder(this.mContext, Constant.GAME_CHANNEL_ID).setContentTitle("You have 5+ unread messages.").setContentText("Tap to see all messages!").setSmallIcon((int) R.drawable.ic_stat_mpl).setSound(defaultUri).setBadgeIconType(1).setStyle(new DecoratedCustomViewStyle()).setVibrate(new long[]{1000, 1000}).setLights(-65536, 3000, 3000).setWhen(System.currentTimeMillis() + 1000).setShowWhen(true).setCategory("msg").setGroupAlertBehavior(0).setContentIntent(PendingIntent.getActivity(this.mContext, 0, buildChatListIntent(nextInt), 134217728)).setAutoCancel(true).build(), i, true);
    }

    private PendingIntent createPendingIntentForGamePlay(long j) {
        Intent intent = new Intent(this.mContext, LocalGeneratedNotificationReceiver.class);
        intent.putExtra(Constant.LOGIN_INTERVAL_TIME, j);
        intent.putExtra(Constant.NOTIFICATION_TYPE, "gamePlay");
        intent.putExtra(Constant.NOTIFICATION_REQUEST_CODE, 3333);
        return PendingIntent.getBroadcast(this.mContext, 3333, intent, 134217728);
    }

    private PendingIntent createPendingIntentForLogin(long j) {
        Intent intent = new Intent(this.mContext, LocalGeneratedNotificationReceiver.class);
        intent.putExtra(Constant.LOGIN_INTERVAL_TIME, j);
        intent.putExtra(Constant.NOTIFICATION_TYPE, SFSEvent.LOGIN);
        intent.putExtra(Constant.NOTIFICATION_REQUEST_CODE, Constant.LOGIN_REQUEST_CODE);
        return PendingIntent.getBroadcast(this.mContext, Constant.LOGIN_REQUEST_CODE, intent, 134217728);
    }

    private PendingIntent createPendingIntentForNonStickyNotification(String str) {
        Intent intent = new Intent(this.mContext, LocalGeneratedNotificationReceiver.class);
        intent.putExtra(Constant.NOTIFICATION_TYPE, "nonSticky");
        intent.putExtra(Constant.NOTIFICATION_DEEP_LINK, str);
        intent.putExtra("notification_data", str);
        intent.putExtra(Constant.NOTIFICATION_REQUEST_CODE, Constant.NON_STICKY_NOTIF_REQUEST_CODE);
        return PendingIntent.getBroadcast(this.mContext, Constant.NON_STICKY_NOTIF_REQUEST_CODE, intent, 134217728);
    }

    private Builder generateChatNotificationBuilder(String str, String str2, String str3) {
        return getNotificationBuilder(this.mContext, str3).setLargeIcon(BitmapFactory.decodeResource(this.mContext.getResources(), R.mipmap.ic_launcher)).setSmallIcon((int) R.drawable.ic_stat_mpl).setStyle(new BigTextStyle().bigText(str2)).setColor(ContextCompat.getColor(this.mContext, R.color.notif_action_button)).setContentTitle(str).setDefaults(3).setAutoCancel(true).setContentInfo(str2).setContentText(str2);
    }

    private Builder generateDownloadNotificationBuilder(String str, String str2) {
        Builder notificationBuilder = getNotificationBuilder(this.mContext, Constant.GAME_CHANNEL_ID);
        notificationBuilder.setLargeIcon(BitmapFactory.decodeResource(this.mContext.getResources(), R.mipmap.ic_launcher));
        notificationBuilder.setSmallIcon((int) R.drawable.ic_stat_mpl);
        notificationBuilder.setColor(ContextCompat.getColor(this.mContext, R.color.notif_action_button));
        notificationBuilder.setContentTitle(str);
        notificationBuilder.setContentText(str2);
        return notificationBuilder;
    }

    /* access modifiers changed from: private */
    public Builder generateNotificationBuilder(String str, String str2) {
        Builder notificationBuilder = getNotificationBuilder(this.mContext, "assets");
        notificationBuilder.setLargeIcon(BitmapFactory.decodeResource(this.mContext.getResources(), R.mipmap.ic_launcher));
        notificationBuilder.setSmallIcon((int) R.drawable.ic_stat_mpl);
        notificationBuilder.setColor(ContextCompat.getColor(this.mContext, R.color.notif_action_button));
        notificationBuilder.setContentTitle(str);
        notificationBuilder.setContentText(str2);
        return notificationBuilder;
    }

    /* access modifiers changed from: private */
    public BigPictureStyle getBigPictureInNotification(String str, String str2) {
        Bitmap bitmap;
        BigPictureStyle bigPictureStyle = new BigPictureStyle();
        try {
            URLConnection uRLConnection = (URLConnection) FirebasePerfUrlConnection.instrument(new URL(str).openConnection());
            uRLConnection.setConnectTimeout(10000);
            uRLConnection.setReadTimeout(10000);
            bitmap = BitmapFactory.decodeStream(uRLConnection.getInputStream());
        } catch (IOException e2) {
            MLogger.e(TAG, "getBigPictureInNotification: ", e2);
            bitmap = null;
        }
        if (bitmap != null) {
            bigPictureStyle.bigPicture(bitmap).setSummaryText(str2).build();
        }
        return bigPictureStyle;
    }

    private int getGroupNotificationId(String str) {
        return new Random().nextInt();
    }

    /* access modifiers changed from: private */
    public Bitmap getLargeIconInNotification(String str) {
        Bitmap bitmap;
        try {
            URLConnection uRLConnection = (URLConnection) FirebasePerfUrlConnection.instrument(new URL(str).openConnection());
            uRLConnection.setConnectTimeout(10000);
            uRLConnection.setReadTimeout(10000);
            bitmap = BitmapFactory.decodeStream(uRLConnection.getInputStream());
        } catch (Exception e2) {
            MLogger.e(TAG, "getLargeIconInNotification: ", e2);
            bitmap = null;
        }
        return bitmap == null ? BitmapFactory.decodeResource(this.mContext.getResources(), R.mipmap.ic_launcher) : bitmap;
    }

    /* access modifiers changed from: private */
    public Builder getNotificationBuilder(Context context, String str) {
        if (MSharedPreferencesUtils.isUserPlayingGame()) {
            str = ChannelConstants.GAME_PLAY_CHANNEL_ID;
        }
        return new Builder(context, str).setColor(ContextCompat.getColor(context, R.color.notif_action_button));
    }

    /* access modifiers changed from: private */
    public int getPriority() {
        return (VERSION.SDK_INT >= 26 || MSharedPreferencesUtils.isUserPlayingGame()) ? -2 : 1;
    }

    private void handleNotification(ApkDownloadNotificationData apkDownloadNotificationData, Context context) {
        String str;
        String str2;
        MLogger.d(TAG, "createApkDownloadIntent: ", Integer.valueOf(apkDownloadNotificationData.getPercentage()));
        RemoteViews remoteViews = new RemoteViews(apkDownloadNotificationData.getContext().getPackageName(), R.layout.apk_download_notification);
        String format = String.format(apkDownloadNotificationData.getContext().getString(R.string.downloading_57), new Object[]{String.valueOf(apkDownloadNotificationData.getPercentage())});
        JSONObject jSONObject = new JSONObject();
        try {
            String str3 = "Ready To Play";
            if (apkDownloadNotificationData.getPercentage() >= 100) {
                remoteViews.setViewVisibility(R.id.apkDownloadProgress, 8);
                remoteViews.setViewVisibility(R.id.downloadPercentage, 8);
                remoteViews.setViewVisibility(R.id.gameStatus, 0);
                if (apkDownloadNotificationData.isDownloaded()) {
                    str = str3;
                } else {
                    str = "Ready To Install";
                }
                remoteViews.setTextViewText(R.id.gameStatus, str);
                if (apkDownloadNotificationData.isDownloaded()) {
                    str2 = str3;
                } else {
                    str2 = "Ready To Install";
                }
                jSONObject.put("Notification Name", str2);
            } else {
                remoteViews.setViewVisibility(R.id.apkDownloadProgress, 0);
                remoteViews.setViewVisibility(R.id.downloadPercentage, 0);
                remoteViews.setViewVisibility(R.id.gameStatus, 8);
                jSONObject.put("Notification Name", "Downloading Game");
            }
            remoteViews.setTextViewText(R.id.gameName, apkDownloadNotificationData.getGameName());
            remoteViews.setTextViewText(R.id.downloadPercentage, format);
            remoteViews.setProgressBar(R.id.apkDownloadProgress, 100, apkDownloadNotificationData.getPercentage(), false);
            try {
                if (!TextUtils.isEmpty(apkDownloadNotificationData.getGameName()) && (apkDownloadNotificationData.getGameName().contains("WCC") || apkDownloadNotificationData.getGameName().contains("wcc") || apkDownloadNotificationData.getGameId() == 1000117)) {
                    remoteViews.setImageViewResource(R.id.notification_gameIcon, R.drawable.wcc_icon);
                }
                if (!TextUtils.isEmpty(apkDownloadNotificationData.getGameName()) && (apkDownloadNotificationData.getGameName().contains("Call Break") || apkDownloadNotificationData.getGameName().contains("call break") || apkDownloadNotificationData.getGameId() == 1000087)) {
                    remoteViews.setImageViewResource(R.id.notification_gameIcon, R.drawable.callbreak_icon);
                }
            } catch (Exception unused) {
                MLogger.e(TAG, "createApkDownloadIntent: ");
            }
            Builder notificationBuilder = getNotificationBuilder(apkDownloadNotificationData.getContext(), "assets");
            jSONObject.put("action", "OPEN_DEEP_LINK");
            jSONObject.put("feature", "Apk Download Flow");
            if (TextUtils.isEmpty(apkDownloadNotificationData.getPackageName())) {
                jSONObject.put("actionParams", "{\"actionType\":\"nav\",\"actionPayload\":{\"route\":\"GamesTab\",\"param\":{\"id\":" + apkDownloadNotificationData.getGameId() + "}}}");
            } else {
                jSONObject.put("actionParams", "{\"actionType\":\"nav\",\"actionPayload\":{\"route\":\"GamesTab\",\"param\":{\"id\":" + apkDownloadNotificationData.getGameId() + ",\"isThirdPartyApkFlow\":true,\"packageName\":\"" + apkDownloadNotificationData.getPackageName() + "\"}}}");
            }
            jSONObject.put("eventProps", apkDownloadNotificationData.toJson().toString());
            Intent buildIntentWithDeepLink = buildIntentWithDeepLink(jSONObject.toString(), apkDownloadNotificationData.getGameId(), null);
            PendingIntent activity = PendingIntent.getActivity(apkDownloadNotificationData.getContext(), 0, buildIntentWithDeepLink, 134217728);
            if (apkDownloadNotificationData.getPercentage() < 100 || TextUtils.isEmpty(apkDownloadNotificationData.getServerVersion())) {
                notificationBuilder.addAction(new Action(0, (CharSequence) "Cancel", createCancelPendingIntentForApkDownloadFlow(apkDownloadNotificationData)));
            } else {
                activity = createInstallPendingIntent(apkDownloadNotificationData);
                notificationBuilder.addAction(new Action(0, (CharSequence) "Install", activity));
            }
            if (VERSION.SDK_INT < 26) {
                notificationBuilder.setPriority(-2);
            }
            notificationBuilder.setSmallIcon((int) R.drawable.ic_stat_mpl).setBadgeIconType(1).setCustomContentView(remoteViews).setCustomBigContentView(remoteViews).setStyle(new DecoratedCustomViewStyle());
            notificationBuilder.setContentIntent(activity);
            notificationBuilder.setOngoing(false);
            notificationBuilder.setAutoCancel(true);
            if (buildIntentWithDeepLink.getExtras() != null) {
                if (apkDownloadNotificationData.getPercentage() >= 100) {
                    notificationBuilder.setSilent(false);
                    if (!apkDownloadNotificationData.isDownloaded()) {
                        str3 = "Ready To Install";
                    }
                    buildIntentWithDeepLink.putExtra("Notification Name", str3);
                } else {
                    notificationBuilder.setSilent(true);
                    buildIntentWithDeepLink.putExtra("Notification Name", "Downloading Game");
                }
                notificationBuilder.setExtras(buildIntentWithDeepLink.getExtras());
            }
            notificationBuilder.setLights(-65536, 3000, 3000);
            notifyNotification(null, apkDownloadNotificationData.getGameId(), notificationBuilder.build(), 0, true);
        } catch (Exception e2) {
            MLogger.e(TAG, "createApkDownloadIntent:", e2);
        }
    }

    public static boolean isChallengeCancelNotification(String str) {
        if (str == null || TextUtils.isEmpty(str)) {
            return false;
        }
        if ("CHALLENGE_CANCELLED".equalsIgnoreCase(str) || "CHALLENGE_REJECTED".equalsIgnoreCase(str) || "CHALLENGE_EXPIRED".equalsIgnoreCase(str)) {
            return true;
        }
        return false;
    }

    public static boolean isChallengeNotification(String str) {
        if (str == null || TextUtils.isEmpty(str)) {
            return false;
        }
        if ("CHALLENGE_CREATED".equalsIgnoreCase(str) || "CHALLENGE_ACCEPTED".equalsIgnoreCase(str)) {
            return true;
        }
        return false;
    }

    public static boolean isChallengeRelatedNotification(String str) {
        if (str == null || TextUtils.isEmpty(str)) {
            return false;
        }
        if ("CHALLENGE_CREATED".equalsIgnoreCase(str) || "CHALLENGE_ACCEPTED".equalsIgnoreCase(str) || "CHALLENGE_CANCELLED".equalsIgnoreCase(str) || "CHALLENGE_REJECTED".equalsIgnoreCase(str) || "CHALLENGE_FINISHED".equalsIgnoreCase(str) || "CHALLENGE_EXPIRED".equalsIgnoreCase(str)) {
            return true;
        }
        return false;
    }

    private boolean isDeviceAndCountrySupported(String str) {
        try {
            Data data = (Data) new Gson().fromJson(str, new TypeToken<Data>() {
            }.getType());
            MLogger.d(TAG, "isDeviceAndCountrySupported : Data -> " + new Gson().toJson((Object) data));
            List<String> supportedDeviceType = data.getSupportedDeviceType();
            List<String> supportedCountryCode = data.getSupportedCountryCode();
            if (supportedDeviceType != null && !supportedDeviceType.contains("android")) {
                return false;
            }
            String str2 = MqttTopic.SINGLE_LEVEL_WILDCARD + CountryUtils.getSavedCountryCallingCode();
            String countryCodeInNormalPref = CountryUtils.getCountryCodeInNormalPref();
            Object[] objArr = new Object[1];
            StringBuilder sb = new StringBuilder();
            sb.append("isDeviceAndCountrySupported -> User Country Code : ");
            sb.append(str2 != null ? str2 : "null");
            objArr[0] = sb.toString();
            MLogger.d(TAG, objArr);
            return supportedCountryCode == null || supportedCountryCode.contains(str2) || supportedCountryCode.contains(countryCodeInNormalPref);
        } catch (Exception e2) {
            MLogger.e(TAG, GeneratedOutlineSupport.outline39(e2, GeneratedOutlineSupport.outline73("Error in isDeviceAndCountrySupported : ")));
        }
    }

    public static boolean isGroupChallengeEventRelatedNotification(String str) {
        if (str == null || TextUtils.isEmpty(str)) {
            return false;
        }
        if ("GROUP_CHALLENGE_FINISHED".equalsIgnoreCase(str) || "GROUP_USER_JOINED_CHALLENGE".equalsIgnoreCase(str) || "GROUP_CHALLENGE_CREATED".equalsIgnoreCase(str)) {
            return true;
        }
        return false;
    }

    public static boolean isGroupEventRelatedNotification(String str) {
        if (str == null || TextUtils.isEmpty(str)) {
            return false;
        }
        if ("USER_REMOVED".equalsIgnoreCase(str) || "USER_ADDED".equalsIgnoreCase(str) || "USER_MESSAGE".equalsIgnoreCase(str)) {
            return true;
        }
        return false;
    }

    public static boolean isNoNotificationEvent(String str) {
        if (str == null || TextUtils.isEmpty(str)) {
            return false;
        }
        if ("user_left".equalsIgnoreCase(str) || "CHANNEL_CHANGE".equalsIgnoreCase(str)) {
            return true;
        }
        return false;
    }

    public static boolean isOnLineOffLieNotification(String str) {
        if (str == null || TextUtils.isEmpty(str)) {
            return false;
        }
        if ("USER_ONLINE".equalsIgnoreCase(str) || "USER_OFFLINE".equalsIgnoreCase(str)) {
            return true;
        }
        return false;
    }

    public static /* synthetic */ void lambda$createSendBirdMessageNotification$2(JSONObject jSONObject, String str) {
        if (jSONObject != null) {
            JSONObject optJSONObject = jSONObject.optJSONObject("channelInfo");
            JSONObject optJSONObject2 = jSONObject.optJSONObject(PromiseImpl.ERROR_MAP_KEY_USER_INFO);
            JSONObject optJSONObject3 = jSONObject.optJSONObject("messageInfo");
            MLogger.d(TAG, "createSendBirdMessageNotification:6 channelInfo ", optJSONObject);
            MLogger.d(TAG, "createSendBirdMessageNotification:7 eventName ", str);
            MLogger.d(TAG, "createSendBirdMessageNotification:8 userInfo ", optJSONObject2);
            MLogger.d(TAG, "createSendBirdMessageNotification:9 messageInfo ", optJSONObject3);
        }
    }

    /* access modifiers changed from: private */
    public void notifyNotification(String str, int i, Notification notification, int i2, boolean z) {
        MLogger.d(TAG, "notifyNotification:", "notificationId: ", Integer.valueOf(i), "tag: ", str, "isGamePlayStarted: ", Boolean.valueOf(MSharedPreferencesUtils.isUserPlayingGame()), "priority: ", Integer.valueOf(notification.priority));
        MSharedPreferencesUtils.saveBooleanInNormalPref(this.mContext, "notification.drawer.enabled", ConfigManager.getPlatformConfig().optBoolean("notification.drawer.enabled", true));
        MLogger.d(NotificationDataManager.TAG, Boolean.valueOf(MSharedPreferencesUtils.getBooleanInNormalPref(this.mContext, "notification.drawer.enabled", false)));
        if ((ConfigManager.getPlatformConfig() != null && ConfigManager.getPlatformConfig().optBoolean("notification.drawer.enabled", false)) || MSharedPreferencesUtils.getBooleanInNormalPref(this.mContext, "notification.drawer.enabled", false)) {
            JSONObject jSONObject = new JSONObject();
            for (String str2 : notification.extras.keySet()) {
                try {
                    jSONObject.put(str2, JSONObject.wrap(notification.extras.get(str2)));
                } catch (JSONException e2) {
                    System.out.println(e2.toString());
                }
            }
            if (jSONObject.optString(NotificationCompat.EXTRA_TITLE) != null && jSONObject.optString(NotificationCompat.EXTRA_TEXT) != null && !jSONObject.optString(NotificationCompat.EXTRA_TITLE).equalsIgnoreCase("null") && !jSONObject.optString(NotificationCompat.EXTRA_TEXT).equalsIgnoreCase("null") && jSONObject.optBoolean("isShownInAppDrawer", true)) {
                addNotifDataToDb(jSONObject.toString(), String.valueOf(System.currentTimeMillis()), false);
                HashMap hashMap = new HashMap();
                hashMap.put("title", jSONObject.optString(NotificationCompat.EXTRA_TITLE, ""));
                hashMap.put(SMTNotificationConstants.NOTIF_BODY_KEY, jSONObject.optString(NotificationCompat.EXTRA_TEXT, ""));
                hashMap.put("Notification Name", notification.extras.getString("Notification Name", "default"));
                hashMap.put("Notif Category", jSONObject.optString("category", ""));
                hashMap.put("Notif Subcategory", jSONObject.optString("subCategory", ""));
                hashMap.put("Deeplink", jSONObject.optString("actionParams", ""));
                CleverTapAnalyticsUtils.sendEvent((String) "Notification added", hashMap);
            }
        }
        if (i <= 0) {
            Random random = this.mRandom;
            if (random != null) {
                i = random.nextInt();
            }
        }
        NotificationManagerCompat from = NotificationManagerCompat.from(this.mContext);
        if (i2 > 4) {
            from.cancel(i);
        }
        if (!"tournament".equalsIgnoreCase(str)) {
            notification.flags |= 16;
        }
        if (str == null || TextUtils.isEmpty(str)) {
            from.notify(i, notification);
        } else {
            from.notify(str, i, notification);
        }
        if (z) {
            sendEvent(this.mContext, notification.extras, i);
        }
    }

    private JSONObject parseResponse(Bundle bundle) {
        MLogger.d(TAG, "parseResponse:[START]");
        JSONObject jSONObject = new JSONObject();
        if (bundle != null) {
            try {
                if (bundle.size() > 0) {
                    for (String str : bundle.keySet()) {
                        jSONObject.put(str, String.valueOf(bundle.get(str)));
                    }
                }
            } catch (Exception e2) {
                MLogger.e(TAG, e2);
            }
        }
        MLogger.d(TAG, "parseResponse:[END]", Integer.valueOf(jSONObject.length()));
        return jSONObject;
    }

    /* JADX WARNING: Removed duplicated region for block: B:8:0x0043 A[Catch:{ Exception -> 0x00b7 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void publishNotificationToReact(java.lang.String r10, java.lang.String r11, java.lang.String r12, java.lang.String r13) {
        /*
            r9 = this;
            java.lang.String r0 = "message"
            org.json.JSONObject r1 = new org.json.JSONObject
            r1.<init>()
            org.json.JSONObject r2 = new org.json.JSONObject
            r2.<init>()
            org.json.JSONObject r3 = new org.json.JSONObject
            r3.<init>()
            r4 = 1
            r5 = 0
            if (r10 == 0) goto L_0x0040
            boolean r6 = android.text.TextUtils.isEmpty(r10)     // Catch:{ Exception -> 0x00b7 }
            if (r6 != 0) goto L_0x0040
            org.json.JSONObject r5 = new org.json.JSONObject     // Catch:{ Exception -> 0x00b7 }
            r5.<init>(r10)     // Catch:{ Exception -> 0x00b7 }
            java.lang.String r10 = "mobileNumber"
            r5.remove(r10)     // Catch:{ Exception -> 0x00b7 }
            java.lang.String r10 = "detailedProfile"
            r5.remove(r10)     // Catch:{ Exception -> 0x00b7 }
            java.lang.String r10 = "avatars"
            r5.remove(r10)     // Catch:{ Exception -> 0x00b7 }
            java.lang.String r10 = "referralCode"
            r5.remove(r10)     // Catch:{ Exception -> 0x00b7 }
            java.lang.String r10 = "coverPhotos"
            r5.remove(r10)     // Catch:{ Exception -> 0x00b7 }
            java.lang.String r10 = "profile"
            org.json.JSONObject r10 = r5.optJSONObject(r10)     // Catch:{ Exception -> 0x00b7 }
            goto L_0x0041
        L_0x0040:
            r10 = r5
        L_0x0041:
            if (r5 == 0) goto L_0x00ad
            r5.put(r0, r12)     // Catch:{ Exception -> 0x00b7 }
            java.lang.String r6 = "lastSeen"
            java.util.Calendar r7 = java.util.Calendar.getInstance()     // Catch:{ Exception -> 0x00b7 }
            long r7 = r7.getTimeInMillis()     // Catch:{ Exception -> 0x00b7 }
            r5.put(r6, r7)     // Catch:{ Exception -> 0x00b7 }
            java.lang.String r6 = "online"
            r5.put(r6, r4)     // Catch:{ Exception -> 0x00b7 }
            java.lang.String r6 = "route"
            java.lang.String r7 = "UserProfileStatus"
            r3.put(r6, r7)     // Catch:{ Exception -> 0x00b7 }
            java.lang.String r6 = "param"
            r3.put(r6, r10)     // Catch:{ Exception -> 0x00b7 }
            java.lang.String r10 = "actionType"
            java.lang.String r6 = "nav"
            r2.put(r10, r6)     // Catch:{ Exception -> 0x00b7 }
            java.lang.String r10 = "actionPayload"
            r2.put(r10, r3)     // Catch:{ Exception -> 0x00b7 }
            java.lang.String r10 = "action"
            java.lang.String r3 = "MQTT_FOREGROUND"
            r1.put(r10, r3)     // Catch:{ Exception -> 0x00b7 }
            java.lang.String r10 = "actionParams"
            r1.put(r10, r2)     // Catch:{ Exception -> 0x00b7 }
            java.lang.String r10 = "type"
            java.lang.String r2 = "USER_ONLINE"
            r1.put(r10, r2)     // Catch:{ Exception -> 0x00b7 }
            java.lang.String r10 = "messageType"
            java.lang.String r2 = "Online Notify"
            r1.put(r10, r2)     // Catch:{ Exception -> 0x00b7 }
            java.lang.String r10 = "userid"
            java.lang.String r2 = "id"
            int r2 = r5.optInt(r2)     // Catch:{ Exception -> 0x00b7 }
            r1.put(r10, r2)     // Catch:{ Exception -> 0x00b7 }
            java.lang.String r10 = "name"
            java.lang.String r2 = "displayName"
            java.lang.String r2 = r5.optString(r2)     // Catch:{ Exception -> 0x00b7 }
            r1.put(r10, r2)     // Catch:{ Exception -> 0x00b7 }
            java.lang.String r10 = "avatar"
            r1.put(r10, r13)     // Catch:{ Exception -> 0x00b7 }
            java.lang.String r10 = "title"
            r1.put(r10, r11)     // Catch:{ Exception -> 0x00b7 }
            r1.put(r0, r12)     // Catch:{ Exception -> 0x00b7 }
        L_0x00ad:
            android.content.Context r10 = r9.mContext     // Catch:{ Exception -> 0x00b7 }
            java.lang.String r11 = r1.toString()     // Catch:{ Exception -> 0x00b7 }
            com.mpl.androidapp.EventPublishHelper.publishMqttMessageReceiveEvent(r10, r11)     // Catch:{ Exception -> 0x00b7 }
            goto L_0x00c3
        L_0x00b7:
            java.lang.Object[] r10 = new java.lang.Object[r4]
            r11 = 0
            java.lang.String r12 = "publishOnlineMessageOwnTopic: "
            r10[r11] = r12
            java.lang.String r11 = "NotificationBuilder"
            com.mpl.androidapp.utils.MLogger.e(r11, r10)
        L_0x00c3:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mpl.androidapp.notification.NotificationBuilder.publishNotificationToReact(java.lang.String, java.lang.String, java.lang.String, java.lang.String):void");
    }

    public static String replaceServerNameWithContactName(String str, String str2) {
        String str3;
        if (str == null) {
            return str2;
        }
        try {
            if (TextUtils.isEmpty(str) || !CommonUtils.isJSONValid(str)) {
                return str2;
            }
            JSONObject jSONObject = new JSONObject(str);
            String str4 = "";
            if (jSONObject.has("id")) {
                int optInt = jSONObject.optInt("id", 0);
                str4 = jSONObject.optString("displayName", str4);
                str3 = ContactUtils.getNameFromLocalDbFromUserId(String.valueOf(optInt));
            } else {
                str3 = str4;
            }
            if (str2 == null || TextUtils.isEmpty(str2) || !str2.contains(str4) || str3 == null || TextUtils.isEmpty(str3)) {
                return str2;
            }
            return str2.replace(str4, str3);
        } catch (Exception e2) {
            MLogger.e(TAG, "replaceServerNameWithContactName: ", e2);
            return str2;
        }
    }

    public static void sendEvent(Context context, Bundle bundle, int i) {
        String str;
        String str2;
        Bundle bundle2 = bundle;
        MLogger.d(TAG, "sendEvent: ");
        if (bundle2 != null && Boolean.parseBoolean(bundle2.getString("shouldSendEvent", BaseParser.TRUE))) {
            MLogger.d(TAG, "sendEvent: ", bundle.toString());
            MNotification mNotification = new MNotification();
            String str3 = "";
            String string = bundle2.containsKey("feature") ? bundle2.getString("feature") : str3;
            if (TextUtils.isEmpty(string) && bundle2.containsKey("Feature")) {
                string = bundle2.getString("Feature");
            }
            if (TextUtils.isEmpty(string)) {
                string = "Does not have feature or Feature key";
            }
            mNotification.setTitle(bundle2.getString("title", str3));
            mNotification.setBody(bundle2.getString(SMTNotificationConstants.NOTIF_BODY_KEY, str3));
            mNotification.setFeature(string);
            mNotification.setCampaignId(bundle2.getString("CampaignId", "0"));
            mNotification.setBigPicture(bundle2.getString("bigPicture", "0"));
            mNotification.setDeepLink(bundle2.getString("actionParams", str3));
            mNotification.setTtl(Long.parseLong(bundle2.getString("ttl", "0")));
            mNotification.setNotificationID(String.valueOf(i));
            mNotification.setNotifCategory(bundle2.getString("category", str3));
            mNotification.setNotifSubCategory(bundle2.getString("subCategory", str3));
            if (bundle2.containsKey("Notification Name")) {
                mNotification.setNotificationName(bundle2.getString("Notification Name", "Default"));
            }
            if (bundle2.containsKey("eventProps") && !TextUtils.isEmpty(bundle2.getString("eventProps"))) {
                mNotification.setEventProps(bundle2.getString("eventProps"));
            }
            if (bundle2.containsKey(OneSingnalConstant.PARAM_EXPIRY_TIME)) {
                long parseLong = Long.parseLong(bundle2.getString(OneSingnalConstant.PARAM_EXPIRY_TIME, "0"));
                mNotification.setExpiryTime(parseLong);
                str = "shouldSendEvent";
                mNotification.setReceivedBeforeTTL(new DateTime().iMillis < parseLong);
            } else {
                str = "shouldSendEvent";
            }
            if (bundle2.containsKey("sentTime")) {
                long parseLong2 = Long.parseLong(bundle2.getString("sentTime", "0"));
                mNotification.setSentTime(parseLong2);
                mNotification.setTimeToDelivery(TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis() - parseLong2));
            }
            if (bundle2.containsKey(OneSingnalConstant.PARAM_MIN_VERSION)) {
                mNotification.setMinVersion(Integer.parseInt(bundle2.getString(OneSingnalConstant.PARAM_MIN_VERSION, "0")));
            }
            mNotification.setShouldSendEvent(Boolean.parseBoolean(bundle2.getString(str, BaseParser.FALSE)));
            mNotification.setReceiveTime(System.currentTimeMillis());
            if (bundle2.containsKey("Type") || bundle2.containsKey("type")) {
                str2 = bundle2.getString("Type", str3);
                if (TextUtils.isEmpty(str2)) {
                    str2 = bundle2.getString("type", str3);
                }
                mNotification.setNotificationType(str2);
            } else {
                str2 = str3;
            }
            if (TextUtils.isEmpty(str2) || !isChallengeRelatedNotification(str2)) {
                sendNotificationReceiveEvent(mNotification);
                return;
            }
            JSONObject jSonObject = mNotification.toJSonObject();
            String string2 = bundle2.getString(Constant.PROFILE, str3);
            if (!TextUtils.isEmpty(string2) && CommonUtils.isJSONValid(string2)) {
                try {
                    JSONObject jSONObject = new JSONObject(string2);
                    jSonObject.put("Sender ID", jSONObject.optInt("id", 0));
                    boolean z = true;
                    jSonObject.put("Is Challenge", true);
                    jSonObject.put("Sender Mobile Number", jSONObject.optString("mobileNumber", str3));
                    jSonObject.put("Sender is New User", jSONObject.optBoolean(Constant.APPSFLYER_IS_NEW_USER, false));
                    jSonObject.put("Receiver ID", MSharedPreferencesUtils.getUserIdInNormalPref(context));
                    jSonObject.put("Receiver Mobile Number", MSharedPreferencesUtils.getMobileNumberInNormalPref(context));
                    if (!bundle2.containsKey(Constant.IS_NEW_USER) || !bundle2.getBoolean(Constant.IS_NEW_USER)) {
                        z = false;
                    }
                    jSonObject.put("Receiver is New User", z);
                    jSonObject.put("Receiver is Online", false);
                    jSonObject.put("Game ID", bundle2.containsKey("gameId") ? bundle2.getString("gameId") : Integer.valueOf(0));
                    jSonObject.put("Game Name", bundle2.containsKey("gameName") ? bundle2.getString("gameName") : str3);
                    jSonObject.put("Entry Fee", bundle2.containsKey("amount") ? bundle2.getString("amount") : str3);
                    jSonObject.put(CtNativeLaunchInitiated.PROPERTY_CURRENCY, bundle2.containsKey("currency") ? bundle2.getString("currency") : str3);
                    jSonObject.put("Tournament Style", bundle2.containsKey("gameType") ? bundle2.getString("gameType") : str3);
                    jSonObject.put("Duration", bundle2.containsKey(InlineAnimation.DURATION) ? bundle2.getString(InlineAnimation.DURATION) : str3);
                    jSonObject.put("Challenge Id", bundle2.containsKey("challengeId") ? bundle2.getString("challengeId") : str3);
                    jSonObject.put("Campaign Id", bundle2.containsKey("CampaignId") ? bundle2.getString("CampaignId") : str3);
                    jSonObject.put("Winning Amount", bundle2.containsKey("winningAmount") ? bundle2.getString("winningAmount") : str3);
                    if (bundle2.containsKey("type")) {
                        str3 = bundle2.getString("type");
                    }
                    jSonObject.put(EventsConstants.PROP_NOTIFICATION_TYPE, str3);
                    sendNotificationReceiveEvent(jSonObject);
                } catch (Exception e2) {
                    MLogger.printStackTrace(e2);
                }
            }
        }
    }

    public static void sendNotificationReceiveEvent(MNotification mNotification) {
        try {
            CleverTapAnalyticsUtils.sendNotificationReceivedEvent(mNotification.toJSonObject());
        } catch (Exception e2) {
            MLogger.e(TAG, "sendNotificationReceiveEvent: ", e2);
        }
    }

    public static void sendNotificationWithImageFromUnity(Context context, Integer num, String str, String str2, String str3) {
        MLogger.d(TAG, "SendLocalNotification: ", GeneratedOutlineSupport.outline53("Sending Local Notification with title: ", str, ", message: ", str2));
        NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
        Intent intent = new Intent(context, MPLUnityPlayerActivity.class);
        Bundle bundle = new Bundle();
        intent.putExtras(bundle);
        PendingIntent activity = PendingIntent.getActivity(context, num.intValue(), intent, 134217728);
        Builder builder = new Builder(context, (String) "MPL");
        Resources resources = context.getResources();
        if (str3 == null || str3.length() <= 0) {
            builder.setLargeIcon(BitmapFactory.decodeResource(context.getResources(), R.drawable.ic_stat_mpl));
        } else {
            try {
                builder.setLargeIcon(BitmapFactory.decodeResource(context.getResources(), resources.getIdentifier("drawable/" + str3, null, context.getPackageName())));
            } catch (Exception unused) {
                builder.setLargeIcon(BitmapFactory.decodeResource(context.getResources(), R.drawable.ic_stat_mpl));
            }
        }
        builder.setColor(ContextCompat.getColor(context, R.color.notif_action_button));
        builder.setContentTitle(str);
        builder.setContentText(str2);
        builder.setContentIntent(activity);
        builder.addExtras(bundle);
        builder.setSmallIcon((int) R.drawable.ic_stat_mpl);
        builder.setAutoCancel(true);
        builder.setDefaults(-1);
        builder.setPriority(1);
        builder.setCategory("msg");
        builder.setSubText(MBuildConfigUtils.getAppName());
        Notification build = builder.build();
        build.flags |= 16;
        if (notificationManager != null) {
            notificationManager.notify(num.intValue(), build);
        }
    }

    private void showChallengeNotification(Context context, Bundle bundle) {
        Object obj;
        Context context2 = context;
        Bundle bundle2 = bundle;
        try {
            MLogger.d(TAG, "showChallengeNotification: ");
            try {
                RemoteViews remoteViews = new RemoteViews(context.getPackageName(), R.layout.notification_challenge);
                String packageName = context.getPackageName();
                String str = Constant.INTENT_EXTRA_NOTIFICATION_ID;
                RemoteViews remoteViews2 = new RemoteViews(packageName, R.layout.notification_challenge_large);
                if (bundle2.containsKey("notificationSource")) {
                    obj = bundle2.getString("notificationSource");
                } else {
                    obj = "";
                }
                String str2 = "";
                MLogger.d(TAG, "showChallengeNotification: ", obj);
                String string = bundle2.containsKey("title") ? bundle2.getString("title") : str2;
                String string2 = bundle2.containsKey(SMTNotificationConstants.NOTIF_BODY_KEY) ? bundle2.getString(SMTNotificationConstants.NOTIF_BODY_KEY) : str2;
                if (TextUtils.isEmpty(string2) && bundle2.containsKey("message")) {
                    string2 = bundle2.getString("message");
                }
                String string3 = bundle2.containsKey("avatar") ? bundle2.getString("avatar") : str2;
                if (TextUtils.isEmpty(string3) && bundle2.containsKey("bigIcon")) {
                    string3 = bundle2.getString("bigIcon");
                }
                if (TextUtils.isEmpty(string3) && bundle2.containsKey("largeIcon")) {
                    string3 = bundle2.getString("largeIcon");
                }
                String string4 = bundle2.containsKey(WebViewGameVm.KEY_GAME_ICON) ? bundle2.getString(WebViewGameVm.KEY_GAME_ICON) : str2;
                if (bundle2.containsKey(Constant.PROFILE)) {
                    String string5 = bundle2.getString(Constant.PROFILE, "{}");
                    if (string5 != null && !TextUtils.isEmpty(string5) && string != null && !TextUtils.isEmpty(string)) {
                        string = replaceServerNameWithContactName(string5, string);
                    }
                }
                if (!TextUtils.isEmpty(string) || !TextUtils.isEmpty(string2)) {
                    remoteViews.setTextViewText(R.id.notification_title, string);
                    remoteViews.setTextViewText(R.id.notification_msg, string2);
                    remoteViews2.setTextViewText(R.id.notification_title, string);
                    remoteViews2.setTextViewText(R.id.notification_msg, string2);
                    try {
                        if (!TextUtils.isEmpty(string3) && !".circlevtw".equalsIgnoreCase(string3) && URLUtil.isValidUrl(string3)) {
                            URLConnection uRLConnection = (URLConnection) FirebasePerfUrlConnection.instrument(new URL(string3).openConnection());
                            uRLConnection.setConnectTimeout(10000);
                            uRLConnection.setReadTimeout(10000);
                            Bitmap circularBitmap = CommonUtils.getCircularBitmap(BitmapFactory.decodeStream(uRLConnection.getInputStream()));
                            remoteViews.setImageViewBitmap(R.id.notification_sender_avatar, circularBitmap);
                            remoteViews2.setImageViewBitmap(R.id.notification_sender_avatar, circularBitmap);
                        }
                    } catch (Exception unused) {
                        MLogger.e(TAG, "showChallengeNotification: Exception in Avatar Creation");
                    }
                    try {
                        if (!TextUtils.isEmpty(string4) && URLUtil.isValidUrl(string4)) {
                            URLConnection uRLConnection2 = (URLConnection) FirebasePerfUrlConnection.instrument(new URL(string4).openConnection());
                            uRLConnection2.setConnectTimeout(10000);
                            uRLConnection2.setReadTimeout(10000);
                            Bitmap circularBitmap2 = CommonUtils.getCircularBitmap(BitmapFactory.decodeStream(uRLConnection2.getInputStream()));
                            remoteViews.setImageViewBitmap(R.id.notification_groupIcon, circularBitmap2);
                            remoteViews2.setImageViewBitmap(R.id.notification_groupIcon, circularBitmap2);
                        }
                    } catch (Exception unused2) {
                        MLogger.e(TAG, "showChallengeNotification: Exception in Game Icon Creation");
                        remoteViews.setImageViewResource(R.id.notification_groupIcon, R.drawable.default_image_group);
                        remoteViews2.setImageViewResource(R.id.notification_groupIcon, R.drawable.default_image_group);
                    }
                    String str3 = str;
                    if (!bundle2.containsKey(str3)) {
                        bundle2.putInt(str3, Constant.SPIN_WHEEL_NOTIFICATION_ID);
                    } else {
                        MLogger.d(TAG, "showGroupEventNotification:already having notification ID ");
                    }
                    try {
                        Intent buildSendBirdIntent = buildSendBirdIntent(this.mContext, parseResponse(bundle2), Constant.SPIN_WHEEL_NOTIFICATION_ID);
                        buildSendBirdIntent.setFlags(PDChoice.FLAG_COMMIT_ON_SEL_CHANGE);
                        buildSendBirdIntent.putExtra(Constant.TIME_TO_SEND, Calendar.getInstance().getTimeInMillis());
                        buildSendBirdIntent.putExtra(EventsConstants.PROP_NOTIFICATION_TYPE, Constant.CHALLENGES_CHANNEL_ID);
                        Context context3 = context;
                        Builder autoCancel = getNotificationBuilder(context3, Constant.CHALLENGES_CHANNEL_ID).setSmallIcon((int) R.drawable.ic_stat_mpl).setSound(RingtoneManager.getDefaultUri(2)).setBadgeIconType(1).setCustomContentView(remoteViews).setCustomHeadsUpContentView(remoteViews2).setCustomBigContentView(remoteViews2).setStyle(new DecoratedCustomViewStyle()).setVibrate(new long[]{1000, 1000}).setLights(-65536, 3000, 3000).addExtras(bundle2).setWhen(System.currentTimeMillis() + 1000).setShowWhen(true).setContentIntent(PendingIntent.getActivity(context3, 0, buildSendBirdIntent, 134217728)).setAutoCancel(true);
                        if (VERSION.SDK_INT < 26) {
                            autoCancel.setPriority(getPriority());
                        }
                        if (CommonUtils.isAppIsInBackground(this.mContext)) {
                            notifyNotification(null, Constant.SPIN_WHEEL_NOTIFICATION_ID, autoCancel.build(), 0, true);
                        }
                    } catch (Exception e2) {
                        e = e2;
                        MLogger.e(TAG, "showChallengeNotification: ", e);
                    }
                } else {
                    MLogger.d(TAG, "showChallengeNotification: title or body is empty");
                }
            } catch (Exception e3) {
                e = e3;
                MLogger.e(TAG, "showChallengeNotification: ", e);
            }
        } catch (Exception e4) {
            e = e4;
            MLogger.e(TAG, "showChallengeNotification: ", e);
        }
    }

    private void showGroupChallengeNotification(Context context, Bundle bundle) {
        MLogger.d(TAG, "showGroupChallengeNotification:1 [Start]");
        postTaskToBackgroundThread(new Runnable(context, bundle) {
            public final /* synthetic */ Context f$1;
            public final /* synthetic */ Bundle f$2;

            {
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final void run() {
                NotificationBuilder.this.lambda$showGroupChallengeNotification$10$NotificationBuilder(this.f$1, this.f$2);
            }
        });
    }

    private void showGroupEventNotification(Context context, Bundle bundle) {
        MLogger.d(TAG, "showGroupEventNotification:[Start] ");
        postTaskToBackgroundThread(new Runnable(bundle, context) {
            public final /* synthetic */ Bundle f$1;
            public final /* synthetic */ Context f$2;

            {
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final void run() {
                NotificationBuilder.this.lambda$showGroupEventNotification$9$NotificationBuilder(this.f$1, this.f$2);
            }
        });
    }

    private void showGroupStoryNotification(Bundle bundle) {
    }

    private void showLiveVideoGroupEventNotification(Context context, Bundle bundle, String str) {
    }

    private void showLiveVideoGroupEventNotification(Context context, JSONObject jSONObject, String str, String str2, String str3) {
    }

    private void showNewUserOnBoardingNotification(Context context, Bundle bundle) {
        postTaskToBackgroundThread(new Runnable(bundle, context) {
            public final /* synthetic */ Bundle f$1;
            public final /* synthetic */ Context f$2;

            {
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final void run() {
                NotificationBuilder.this.lambda$showNewUserOnBoardingNotification$5$NotificationBuilder(this.f$1, this.f$2);
            }
        });
    }

    /* access modifiers changed from: private */
    public void showNotification(Builder builder, int i, int i2) {
        MLogger.d(TAG, "showNotification:gameId ", Integer.valueOf(i), Integer.valueOf(i2));
        builder.setContentIntent(PendingIntent.getActivity(this.mContext, (int) Calendar.getInstance().getTimeInMillis(), buildTournamentLaunchIntent(i, i2, i), 134217728));
        builder.setAutoCancel(true);
        if (VERSION.SDK_INT < 26) {
            builder.setPriority(getPriority());
        }
        builder.setDefaults(3);
        notifyNotification(null, i, builder.build(), 0, true);
    }

    private void smallTextNotification(String str, String str2, int i, int i2) {
        final String str3 = str;
        final String str4 = str2;
        final int i3 = i;
        final int i4 = i2;
        AnonymousClass1 r0 = new Runnable() {
            public void run() {
                NotificationBuilder.this.showNotification(NotificationBuilder.this.generateNotificationBuilder(str3, str4), i3, i4);
            }
        };
        postTaskToBackgroundThread(r0);
    }

    public void addNotifDataToDb(final String str, final String str2, final boolean z) {
        AsyncTask.THREAD_POOL_EXECUTOR.execute(new Runnable() {
            public void run() {
                MPLApplication.getNotificationDataManager().addNotificationData(str, str2, z);
            }
        });
    }

    public void buildNotification(String str, String str2, int i, int i2) {
        MLogger.d(TAG, "buildNotification:gameId ", Integer.valueOf(i), Integer.valueOf(i2));
        smallTextNotification(str, str2, i, i2);
    }

    public void cancelNotification(String str, boolean z) {
        try {
            NotificationManagerCompat.from(this.mContext).cancel(z ? Integer.parseInt(str) : getGroupNotificationId(str));
        } catch (Exception unused) {
        }
    }

    public void cancelNotificationAlarmManagerForLogin() {
        MLogger.d(Constant.NOTIFICATION_SCHEDULER, "cancelNotificationAlarmManagerForLogin");
        ((AlarmManager) this.mContext.getSystemService(NotificationCompat.CATEGORY_ALARM)).cancel(createPendingIntentForLogin(0));
    }

    public void cancelStickyNotification(String str) {
    }

    public void createApkDownloadIntent(ApkDownloadNotificationData apkDownloadNotificationData, Context context, int i) {
        if (context != null && apkDownloadNotificationData != null) {
            checkIfOptionalDownloadScreenIsVisited(apkDownloadNotificationData, context, i);
        }
    }

    public void createFCMNotificationDeepLink(RemoteMessage remoteMessage) {
        MLogger.d(TAG, "createFCMNotificationDeepLink");
        postTaskToBackgroundThread(new Runnable(remoteMessage) {
            public final /* synthetic */ RemoteMessage f$1;

            {
                this.f$1 = r2;
            }

            public final void run() {
                NotificationBuilder.this.lambda$createFCMNotificationDeepLink$3$NotificationBuilder(this.f$1);
            }
        });
    }

    public void createFailNotification(int i) {
        Builder generateDownloadNotificationBuilder = generateDownloadNotificationBuilder("Downloading", "Downloading video Failed");
        generateDownloadNotificationBuilder.setOngoing(false);
        generateDownloadNotificationBuilder.setAutoCancel(true);
        if (VERSION.SDK_INT < 26) {
            generateDownloadNotificationBuilder.setPriority(-1);
        }
        generateDownloadNotificationBuilder.setSound(null);
        generateDownloadNotificationBuilder.setVibrate(null);
        generateDownloadNotificationBuilder.setContentInfo("Downloading video...");
        notifyNotification(null, i, generateDownloadNotificationBuilder.build(), 0, true);
    }

    public void createNotificationAlarmManagerForCancelNonStickyNotification(int i, long j) {
        MLogger.d(Constant.NOTIFICATION_SCHEDULER, "createNotificationAlarmManagerForCancelNonStickyNotification");
        try {
            AlarmManager alarmManager = (AlarmManager) this.mContext.getSystemService(NotificationCompat.CATEGORY_ALARM);
            if (VERSION.SDK_INT >= 23) {
                alarmManager.setExactAndAllowWhileIdle(0, j, createCancelPendingIntentForNonStickyNotification(i));
            } else {
                alarmManager.setExact(0, j, createCancelPendingIntentForNonStickyNotification(i));
            }
        } catch (Exception unused) {
            MLogger.e(TAG, "createNotificationAlarmManagerForCancelNonStickyNotification: ");
        }
    }

    public void createNotificationAlarmManagerForGamePlayReminder(long j) {
        MLogger.d(Constant.NOTIFICATION_SCHEDULER, "createNotificationAlarmManagerForGamePlayReminder");
        if (MSharedPreferencesUtils.isGameReminderNotifEnabeled(this.mContext)) {
            Calendar instance = Calendar.getInstance();
            AlarmManager alarmManager = (AlarmManager) this.mContext.getSystemService(NotificationCompat.CATEGORY_ALARM);
            if (VERSION.SDK_INT >= 23) {
                alarmManager.setExactAndAllowWhileIdle(0, instance.getTimeInMillis() + j, createPendingIntentForGamePlay(j));
            } else {
                alarmManager.setExact(0, instance.getTimeInMillis() + j, createPendingIntentForGamePlay(j));
            }
        } else {
            cancelNotificationAlarmManagerForGamplay();
        }
    }

    public void createNotificationAlarmManagerForLogin(long j) {
        MLogger.d(Constant.NOTIFICATION_SCHEDULER, "createNotificationAlarmManagerForLogin");
        if (MSharedPreferencesUtils.isLoginReminderNotifEnabeled(this.mContext)) {
            Calendar instance = Calendar.getInstance();
            AlarmManager alarmManager = (AlarmManager) this.mContext.getSystemService(NotificationCompat.CATEGORY_ALARM);
            if (VERSION.SDK_INT >= 23) {
                alarmManager.setExactAndAllowWhileIdle(0, instance.getTimeInMillis() + j, createPendingIntentForLogin(j));
            } else {
                alarmManager.setExact(0, instance.getTimeInMillis() + j, createPendingIntentForLogin(j));
            }
        } else {
            cancelNotificationAlarmManagerForLogin();
        }
    }

    public void createNotificationAlarmManagerForNonStickyNotification(String str) {
        MLogger.d(Constant.NOTIFICATION_SCHEDULER, "createNotificationAlarmManagerForNonStickyNotification");
        try {
            long optLong = new JSONObject(str).optLong("when", 0);
            AlarmManager alarmManager = (AlarmManager) this.mContext.getSystemService(NotificationCompat.CATEGORY_ALARM);
            if (VERSION.SDK_INT >= 23) {
                alarmManager.setExactAndAllowWhileIdle(0, optLong, createPendingIntentForNonStickyNotification(str));
            } else {
                alarmManager.setExact(0, optLong, createPendingIntentForNonStickyNotification(str));
            }
        } catch (Exception unused) {
        }
    }

    public void createProgressNotification(int i, int i2) {
        Builder generateDownloadNotificationBuilder = generateDownloadNotificationBuilder("Downloading", "Downloading video...");
        generateDownloadNotificationBuilder.setOngoing(false);
        generateDownloadNotificationBuilder.setAutoCancel(true);
        if (VERSION.SDK_INT < 26) {
            generateDownloadNotificationBuilder.setPriority(-1);
        }
        generateDownloadNotificationBuilder.setSound(null);
        generateDownloadNotificationBuilder.setVibrate(null);
        generateDownloadNotificationBuilder.setContentInfo("Downloading Video...");
        generateDownloadNotificationBuilder.setProgress(100, i2, false);
        generateDownloadNotificationBuilder.setGroup("" + i);
        notifyNotification(null, i, generateDownloadNotificationBuilder.build(), 0, true);
    }

    public void createSendBirdChallengeNotification(RemoteMessage remoteMessage) {
        try {
            MLogger.d(TAG, "createSendBirdChallengeNotification");
            postTaskToBackgroundThread(new Runnable(remoteMessage) {
                public final /* synthetic */ RemoteMessage f$1;

                {
                    this.f$1 = r2;
                }

                public final void run() {
                    NotificationBuilder.this.lambda$createSendBirdChallengeNotification$6$NotificationBuilder(this.f$1);
                }
            });
        } catch (Exception e2) {
            MLogger.e(TAG, "createSendBirdChallengeNotification: ", e2.getMessage());
        }
    }

    public void createSendBirdGroupNotification(RemoteMessage remoteMessage) {
        try {
            MLogger.d(TAG, "createSendBirdChallengeNotification");
            postTaskToBackgroundThread(new Runnable(remoteMessage) {
                public final /* synthetic */ RemoteMessage f$1;

                {
                    this.f$1 = r2;
                }

                public final void run() {
                    NotificationBuilder.this.lambda$createSendBirdGroupNotification$7$NotificationBuilder(this.f$1);
                }
            });
        } catch (Exception e2) {
            MLogger.e(TAG, "createSendBirdChallengeNotification: ", e2.getMessage());
        }
    }

    public void createSendBirdMessageNotification(JSONObject jSONObject) {
        MLogger.d(TAG, "createSendBirdMessageNotification:1 ");
        postTaskToBackgroundThread(new Runnable(jSONObject) {
            public final /* synthetic */ JSONObject f$1;

            {
                this.f$1 = r2;
            }

            public final void run() {
                NotificationBuilder.this.lambda$createSendBirdMessageNotification$1$NotificationBuilder(this.f$1);
            }
        });
    }

    public void createSendBirdNotification(JSONObject jSONObject) {
        MLogger.d(TAG, "createSendBirdNotification: ");
        postTaskToBackgroundThread(new Runnable(jSONObject) {
            public final /* synthetic */ JSONObject f$1;

            {
                this.f$1 = r2;
            }

            public final void run() {
                NotificationBuilder.this.lambda$createSendBirdNotification$0$NotificationBuilder(this.f$1);
            }
        });
    }

    public void createStickyNotification(Bundle bundle) {
        MLogger.d(TAG, "createStickyNotification:Bundle ");
        createStickyNotification(parseResponse(bundle).toString());
    }

    public void createStickyNotificationForOriginals(int i) {
        try {
            String appNameBasedOnGameId = Util.getAppNameBasedOnGameId(i);
            JSONObject jSONObject = new JSONObject();
            if (TextUtils.isEmpty(appNameBasedOnGameId)) {
                appNameBasedOnGameId = "Download from playstore";
            }
            jSONObject.put("title", appNameBasedOnGameId);
            jSONObject.put("message", "Ready to install");
            jSONObject.put("type", "Originals");
            jSONObject.put("autoCancel", false);
            jSONObject.put("setOngoing", true);
            jSONObject.put(Constant.NOTIFICATION_ID, i);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("action", "OPEN_DEEP_LINK");
            if (GameLaunchHelper.mOriginals.containsKey(Integer.valueOf(i))) {
                if (GameLaunchHelper.mOriginals.get(Integer.valueOf(i)) != null) {
                    OriginalGameConstant originalGameConstant = GameLaunchHelper.mOriginals.get(Integer.valueOf(i));
                    int tournamentId = originalGameConstant.getTournamentId();
                    if (originalGameConstant.isTournament()) {
                        jSONObject2.put("actionParams", "{\"actionType\":\"nav\",\"actionPayload\":{\"route\":\"TournamentDetails\",\"param\":{\"id\":" + tournamentId + "}}}");
                    } else if (originalGameConstant.isBattle()) {
                        jSONObject2.put("actionParams", "{\"actionType\":\"nav\",\"actionPayload\":{\"route\":\"LobbyDetails\",\"param\":{\"id\":" + tournamentId + "}}}");
                    } else if (originalGameConstant.isKO()) {
                        jSONObject2.put("actionParams", "{\"actionType\":\"nav\",\"actionPayload\":{\"route\":\"KnockoutDetails\",\"param\":{\"id\":" + tournamentId + "}}}");
                    } else {
                        jSONObject2.put("actionParams", "{\"actionType\":\"nav\",\"actionPayload\":{\"route\":\"GamesTab\",\"param\":{\"id\":" + i + "}}}");
                    }
                    jSONObject.put("deepLink", jSONObject2);
                    jSONObject.put("actionButtons", "[{\"title\":\"Dismiss\"}]");
                    createStickyNotification(jSONObject.toString());
                    CleverTapAnalyticsUtils.setOriginalNotificationEvent(false);
                }
            }
            jSONObject2.put("actionParams", "{\"actionType\":\"nav\",\"actionPayload\":{\"route\":\"GamesTab\",\"param\":{\"id\":" + i + "}}}");
            jSONObject.put("deepLink", jSONObject2);
            jSONObject.put("actionButtons", "[{\"title\":\"Dismiss\"}]");
            createStickyNotification(jSONObject.toString());
            CleverTapAnalyticsUtils.setOriginalNotificationEvent(false);
        } catch (Exception unused) {
        }
    }

    public void createVideoDownloadIntent(int i, String str) {
        Intent intent = new Intent(this.mContext, MSMSBroadCastReceiver.class);
        intent.setAction("share_youtube");
        intent.putExtra("notification_id", i);
        intent.putExtra("file_url", str);
        PendingIntent broadcast = PendingIntent.getBroadcast(this.mContext, 1, intent, 134217728);
        Builder generateDownloadNotificationBuilder = generateDownloadNotificationBuilder("Gameplay video download successful!", "Tap to share it with friends on YouTube");
        generateDownloadNotificationBuilder.setContentIntent(broadcast);
        generateDownloadNotificationBuilder.addAction(new Action((int) R.drawable.share, (CharSequence) "SHARE ON YOUTUBE", broadcast));
        generateDownloadNotificationBuilder.setOngoing(false);
        generateDownloadNotificationBuilder.setAutoCancel(true);
        if (VERSION.SDK_INT < 26) {
            generateDownloadNotificationBuilder.setPriority(getPriority());
        }
        generateDownloadNotificationBuilder.setDefaults(3);
        notifyNotification(null, i, generateDownloadNotificationBuilder.build(), 0, true);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(2:36|37) */
    /* JADX WARNING: Code restructure failed: missing block: B:37:?, code lost:
        r10.setViewVisibility(com.mpl.androidapp.R.id.notification_groupIcon, 8);
        r11.setViewVisibility(com.mpl.androidapp.R.id.notification_groupIcon, 8);
        r12.setViewVisibility(com.mpl.androidapp.R.id.notification_groupIcon, 8);
        com.mpl.androidapp.utils.MLogger.e(TAG, "createCollectibleNotification: Exception in Group Icon creation");
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:36:0x016d */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ void lambda$createCollectibleNotification$4$NotificationBuilder(android.content.Context r24, android.os.Bundle r25) {
        /*
            r23 = this;
            r0 = r24
            r1 = r25
            java.lang.String r2 = "groupNotification"
            java.lang.String r3 = "imageUrl"
            java.lang.String r4 = "createCollectibleNotification: "
            java.lang.String r5 = "shouldShowInBackground"
            java.lang.String r6 = ""
            java.lang.String r7 = "NotificationBuilder"
            r8 = 0
            r9 = 1
            java.lang.Object[] r10 = new java.lang.Object[r9]     // Catch:{ Exception -> 0x0234 }
            r10[r8] = r4     // Catch:{ Exception -> 0x0234 }
            com.mpl.androidapp.utils.MLogger.d(r7, r10)     // Catch:{ Exception -> 0x0234 }
            android.widget.RemoteViews r10 = new android.widget.RemoteViews     // Catch:{ Exception -> 0x0234 }
            java.lang.String r11 = r24.getPackageName()     // Catch:{ Exception -> 0x0234 }
            r12 = 2131558762(0x7f0d016a, float:1.8742849E38)
            r10.<init>(r11, r12)     // Catch:{ Exception -> 0x0234 }
            android.widget.RemoteViews r11 = new android.widget.RemoteViews     // Catch:{ Exception -> 0x0234 }
            java.lang.String r12 = r24.getPackageName()     // Catch:{ Exception -> 0x0234 }
            r13 = 2131558757(0x7f0d0165, float:1.8742839E38)
            r11.<init>(r12, r13)     // Catch:{ Exception -> 0x0234 }
            android.widget.RemoteViews r12 = new android.widget.RemoteViews     // Catch:{ Exception -> 0x0234 }
            java.lang.String r13 = r24.getPackageName()     // Catch:{ Exception -> 0x0234 }
            r14 = 2131558761(0x7f0d0169, float:1.8742847E38)
            r12.<init>(r13, r14)     // Catch:{ Exception -> 0x0234 }
            java.lang.String r13 = "title"
            java.lang.String r13 = r1.getString(r13, r6)     // Catch:{ Exception -> 0x0234 }
            java.lang.String r14 = "body"
            java.lang.String r14 = r1.getString(r14, r6)     // Catch:{ Exception -> 0x0234 }
            java.lang.String r15 = "avatar"
            java.lang.String r15 = r1.getString(r15, r6)     // Catch:{ Exception -> 0x0234 }
            java.lang.String r9 = "largeIcon"
            java.lang.String r9 = r1.getString(r9, r6)     // Catch:{ Exception -> 0x0234 }
            boolean r16 = android.text.TextUtils.isEmpty(r9)     // Catch:{ Exception -> 0x0234 }
            if (r16 == 0) goto L_0x0065
            boolean r16 = r1.containsKey(r3)     // Catch:{ Exception -> 0x0234 }
            if (r16 == 0) goto L_0x0065
            java.lang.String r9 = r1.getString(r3, r6)     // Catch:{ Exception -> 0x0234 }
        L_0x0065:
            java.lang.String r3 = "eventType"
            java.lang.String r3 = r1.getString(r3, r6)     // Catch:{ Exception -> 0x0234 }
            boolean r6 = r1.containsKey(r5)     // Catch:{ Exception -> 0x0234 }
            if (r6 == 0) goto L_0x0086
            java.lang.String r6 = r1.getString(r5)     // Catch:{ Exception -> 0x0234 }
            boolean r6 = android.text.TextUtils.isEmpty(r6)     // Catch:{ Exception -> 0x0234 }
            if (r6 != 0) goto L_0x0086
            java.lang.String r6 = "true"
            java.lang.String r5 = r1.getString(r5, r6)     // Catch:{ Exception -> 0x0234 }
            boolean r5 = java.lang.Boolean.parseBoolean(r5)     // Catch:{ Exception -> 0x0234 }
            goto L_0x0087
        L_0x0086:
            r5 = 1
        L_0x0087:
            r6 = 2131362915(0x7f0a0463, float:1.8345624E38)
            r10.setTextViewText(r6, r13)     // Catch:{ Exception -> 0x0234 }
            r8 = 2131362910(0x7f0a045e, float:1.8345614E38)
            r10.setTextViewText(r8, r14)     // Catch:{ Exception -> 0x0234 }
            r11.setTextViewText(r6, r13)     // Catch:{ Exception -> 0x0234 }
            r11.setTextViewText(r8, r14)     // Catch:{ Exception -> 0x0234 }
            r12.setTextViewText(r6, r13)     // Catch:{ Exception -> 0x0234 }
            r12.setTextViewText(r8, r14)     // Catch:{ Exception -> 0x0234 }
            r6 = 2
            java.lang.Object[] r8 = new java.lang.Object[r6]     // Catch:{ Exception -> 0x0234 }
            java.lang.String r13 = "createCollectibleNotification:eventType "
            r14 = 0
            r8[r14] = r13     // Catch:{ Exception -> 0x0234 }
            r13 = 1
            r8[r13] = r3     // Catch:{ Exception -> 0x0234 }
            com.mpl.androidapp.utils.MLogger.d(r7, r8)     // Catch:{ Exception -> 0x0234 }
            r3 = 10000(0x2710, float:1.4013E-41)
            r8 = 2131362914(0x7f0a0462, float:1.8345622E38)
            r13 = 8
            boolean r14 = android.text.TextUtils.isEmpty(r15)     // Catch:{ Exception -> 0x0109 }
            if (r14 != 0) goto L_0x00f3
            java.lang.String r14 = ".circlevtw"
            boolean r14 = r14.equalsIgnoreCase(r15)     // Catch:{ Exception -> 0x0109 }
            if (r14 != 0) goto L_0x00f3
            boolean r14 = android.webkit.URLUtil.isValidUrl(r15)     // Catch:{ Exception -> 0x0109 }
            if (r14 == 0) goto L_0x00f3
            java.net.URL r14 = new java.net.URL     // Catch:{ Exception -> 0x0109 }
            r14.<init>(r15)     // Catch:{ Exception -> 0x0109 }
            java.net.URLConnection r14 = r14.openConnection()     // Catch:{ Exception -> 0x0109 }
            java.lang.Object r14 = com.google.firebase.perf.network.FirebasePerfUrlConnection.instrument(r14)     // Catch:{ Exception -> 0x0109 }
            java.net.URLConnection r14 = (java.net.URLConnection) r14     // Catch:{ Exception -> 0x0109 }
            r14.setConnectTimeout(r3)     // Catch:{ Exception -> 0x0109 }
            r14.setReadTimeout(r3)     // Catch:{ Exception -> 0x0109 }
            java.io.InputStream r14 = r14.getInputStream()     // Catch:{ Exception -> 0x0109 }
            android.graphics.Bitmap r14 = android.graphics.BitmapFactory.decodeStream(r14)     // Catch:{ Exception -> 0x0109 }
            android.graphics.Bitmap r14 = com.mpl.androidapp.utils.CommonUtils.getCircularBitmap(r14)     // Catch:{ Exception -> 0x0109 }
            r10.setImageViewBitmap(r8, r14)     // Catch:{ Exception -> 0x0109 }
            r11.setImageViewBitmap(r8, r14)     // Catch:{ Exception -> 0x0109 }
            r12.setImageViewBitmap(r8, r14)     // Catch:{ Exception -> 0x0109 }
            goto L_0x011e
        L_0x00f3:
            r14 = 1
            java.lang.Object[] r15 = new java.lang.Object[r14]     // Catch:{ Exception -> 0x0109 }
            java.lang.String r14 = "createCollectibleNotification: Sender Url is not proper"
            r16 = 0
            r15[r16] = r14     // Catch:{ Exception -> 0x0109 }
            com.mpl.androidapp.utils.MLogger.d(r7, r15)     // Catch:{ Exception -> 0x0109 }
            r10.setViewVisibility(r8, r13)     // Catch:{ Exception -> 0x0109 }
            r11.setViewVisibility(r8, r13)     // Catch:{ Exception -> 0x0109 }
            r12.setViewVisibility(r8, r13)     // Catch:{ Exception -> 0x0109 }
            goto L_0x011e
        L_0x0109:
            r14 = 1
            java.lang.Object[] r15 = new java.lang.Object[r14]     // Catch:{ Exception -> 0x0234 }
            java.lang.String r14 = "createCollectibleNotification: Exception in Avtar creation"
            r16 = 0
            r15[r16] = r14     // Catch:{ Exception -> 0x0234 }
            com.mpl.androidapp.utils.MLogger.e(r7, r15)     // Catch:{ Exception -> 0x0234 }
            r10.setViewVisibility(r8, r13)     // Catch:{ Exception -> 0x0234 }
            r11.setViewVisibility(r8, r13)     // Catch:{ Exception -> 0x0234 }
            r12.setViewVisibility(r8, r13)     // Catch:{ Exception -> 0x0234 }
        L_0x011e:
            r8 = 2131362905(0x7f0a0459, float:1.8345604E38)
            boolean r14 = android.text.TextUtils.isEmpty(r9)     // Catch:{ Exception -> 0x016d }
            if (r14 != 0) goto L_0x0158
            boolean r14 = android.webkit.URLUtil.isValidUrl(r9)     // Catch:{ Exception -> 0x016d }
            if (r14 == 0) goto L_0x0158
            java.net.URL r14 = new java.net.URL     // Catch:{ Exception -> 0x016d }
            r14.<init>(r9)     // Catch:{ Exception -> 0x016d }
            java.net.URLConnection r9 = r14.openConnection()     // Catch:{ Exception -> 0x016d }
            java.lang.Object r9 = com.google.firebase.perf.network.FirebasePerfUrlConnection.instrument(r9)     // Catch:{ Exception -> 0x016d }
            java.net.URLConnection r9 = (java.net.URLConnection) r9     // Catch:{ Exception -> 0x016d }
            r9.setConnectTimeout(r3)     // Catch:{ Exception -> 0x016d }
            r9.setReadTimeout(r3)     // Catch:{ Exception -> 0x016d }
            java.io.InputStream r3 = r9.getInputStream()     // Catch:{ Exception -> 0x016d }
            android.graphics.Bitmap r3 = android.graphics.BitmapFactory.decodeStream(r3)     // Catch:{ Exception -> 0x016d }
            android.graphics.Bitmap r3 = com.mpl.androidapp.utils.CommonUtils.getCircularBitmap(r3)     // Catch:{ Exception -> 0x016d }
            r10.setImageViewBitmap(r8, r3)     // Catch:{ Exception -> 0x016d }
            r11.setImageViewBitmap(r8, r3)     // Catch:{ Exception -> 0x016d }
            r12.setImageViewBitmap(r8, r3)     // Catch:{ Exception -> 0x016d }
            goto L_0x0181
        L_0x0158:
            r3 = 1
            java.lang.Object[] r9 = new java.lang.Object[r3]     // Catch:{ Exception -> 0x016d }
            java.lang.String r3 = "createCollectibleNotification: group url is not proper"
            r14 = 0
            r9[r14] = r3     // Catch:{ Exception -> 0x016d }
            com.mpl.androidapp.utils.MLogger.d(r7, r9)     // Catch:{ Exception -> 0x016d }
            r10.setViewVisibility(r8, r13)     // Catch:{ Exception -> 0x016d }
            r11.setViewVisibility(r8, r13)     // Catch:{ Exception -> 0x016d }
            r12.setViewVisibility(r8, r13)     // Catch:{ Exception -> 0x016d }
            goto L_0x0181
        L_0x016d:
            r10.setViewVisibility(r8, r13)     // Catch:{ Exception -> 0x0234 }
            r11.setViewVisibility(r8, r13)     // Catch:{ Exception -> 0x0234 }
            r12.setViewVisibility(r8, r13)     // Catch:{ Exception -> 0x0234 }
            r3 = 1
            java.lang.Object[] r8 = new java.lang.Object[r3]     // Catch:{ Exception -> 0x0234 }
            java.lang.String r3 = "createCollectibleNotification: Exception in Group Icon creation"
            r9 = 0
            r8[r9] = r3     // Catch:{ Exception -> 0x0234 }
            com.mpl.androidapp.utils.MLogger.e(r7, r8)     // Catch:{ Exception -> 0x0234 }
        L_0x0181:
            android.content.Intent r3 = new android.content.Intent     // Catch:{ Exception -> 0x0234 }
            java.lang.Class<com.mpl.androidapp.react.MPLReactContainerActivity> r8 = com.mpl.androidapp.react.MPLReactContainerActivity.class
            r3.<init>(r0, r8)     // Catch:{ Exception -> 0x0234 }
            r3.putExtras(r1)     // Catch:{ Exception -> 0x0234 }
            r8 = 134217728(0x8000000, float:3.85186E-34)
            r9 = 0
            android.app.PendingIntent r3 = android.app.PendingIntent.getActivity(r0, r9, r3, r8)     // Catch:{ Exception -> 0x0234 }
            android.net.Uri r8 = android.media.RingtoneManager.getDefaultUri(r6)     // Catch:{ Exception -> 0x0234 }
            boolean r9 = com.mpl.androidapp.utils.CommonUtils.isAppIsInBackground(r24)     // Catch:{ Exception -> 0x0234 }
            if (r9 == 0) goto L_0x019f
            java.lang.String r9 = "Challenge"
            goto L_0x01a1
        L_0x019f:
            java.lang.String r9 = "GAME"
        L_0x01a1:
            r13 = r23
            androidx.core.app.NotificationCompat$Builder r0 = r13.getNotificationBuilder(r0, r9)     // Catch:{ Exception -> 0x0236 }
            r9 = 2131231343(0x7f08026f, float:1.8078764E38)
            androidx.core.app.NotificationCompat$Builder r0 = r0.setSmallIcon(r9)     // Catch:{ Exception -> 0x0236 }
            androidx.core.app.NotificationCompat$Builder r0 = r0.setSound(r8)     // Catch:{ Exception -> 0x0236 }
            r8 = 1
            androidx.core.app.NotificationCompat$Builder r0 = r0.setBadgeIconType(r8)     // Catch:{ Exception -> 0x0236 }
            androidx.core.app.NotificationCompat$Builder r0 = r0.setCustomContentView(r10)     // Catch:{ Exception -> 0x0236 }
            androidx.core.app.NotificationCompat$Builder r0 = r0.setCustomHeadsUpContentView(r12)     // Catch:{ Exception -> 0x0236 }
            androidx.core.app.NotificationCompat$Builder r0 = r0.setCustomBigContentView(r11)     // Catch:{ Exception -> 0x0236 }
            androidx.core.app.NotificationCompat$DecoratedCustomViewStyle r8 = new androidx.core.app.NotificationCompat$DecoratedCustomViewStyle     // Catch:{ Exception -> 0x0236 }
            r8.<init>()     // Catch:{ Exception -> 0x0236 }
            androidx.core.app.NotificationCompat$Builder r0 = r0.setStyle(r8)     // Catch:{ Exception -> 0x0236 }
            long[] r6 = new long[r6]     // Catch:{ Exception -> 0x0236 }
            r8 = 1000(0x3e8, double:4.94E-321)
            r10 = 0
            r6[r10] = r8     // Catch:{ Exception -> 0x0236 }
            r10 = 1
            r6[r10] = r8     // Catch:{ Exception -> 0x0236 }
            androidx.core.app.NotificationCompat$Builder r0 = r0.setVibrate(r6)     // Catch:{ Exception -> 0x0236 }
            r6 = -65536(0xffffffffffff0000, float:NaN)
            r10 = 3000(0xbb8, float:4.204E-42)
            androidx.core.app.NotificationCompat$Builder r0 = r0.setLights(r6, r10, r10)     // Catch:{ Exception -> 0x0236 }
            r6 = 0
            androidx.core.app.NotificationCompat$Builder r0 = r0.setGroupSummary(r6)     // Catch:{ Exception -> 0x0236 }
            androidx.core.app.NotificationCompat$Builder r0 = r0.addExtras(r1)     // Catch:{ Exception -> 0x0236 }
            long r10 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x0236 }
            long r10 = r10 + r8
            androidx.core.app.NotificationCompat$Builder r0 = r0.setWhen(r10)     // Catch:{ Exception -> 0x0236 }
            java.lang.String r6 = "msg"
            androidx.core.app.NotificationCompat$Builder r0 = r0.setCategory(r6)     // Catch:{ Exception -> 0x0236 }
            r6 = 0
            androidx.core.app.NotificationCompat$Builder r0 = r0.setGroupAlertBehavior(r6)     // Catch:{ Exception -> 0x0236 }
            androidx.core.app.NotificationCompat$Builder r0 = r0.setContentIntent(r3)     // Catch:{ Exception -> 0x0236 }
            r3 = 1
            androidx.core.app.NotificationCompat$Builder r0 = r0.setAutoCancel(r3)     // Catch:{ Exception -> 0x0236 }
            boolean r3 = r1.containsKey(r2)     // Catch:{ Exception -> 0x0236 }
            if (r3 == 0) goto L_0x0219
            java.lang.String r3 = com.mpl.androidapp.utils.MBuildConfigUtils.getAppName()     // Catch:{ Exception -> 0x0236 }
            java.lang.String r1 = r1.getString(r2, r3)     // Catch:{ Exception -> 0x0236 }
            r0.setGroup(r1)     // Catch:{ Exception -> 0x0236 }
        L_0x0219:
            if (r5 == 0) goto L_0x023f
            java.lang.String r18 = ""
            java.util.Random r1 = new java.util.Random     // Catch:{ Exception -> 0x0236 }
            r1.<init>()     // Catch:{ Exception -> 0x0236 }
            int r19 = r1.nextInt()     // Catch:{ Exception -> 0x0236 }
            android.app.Notification r20 = r0.build()     // Catch:{ Exception -> 0x0236 }
            r21 = 0
            r22 = 1
            r17 = r23
            r17.notifyNotification(r18, r19, r20, r21, r22)     // Catch:{ Exception -> 0x0236 }
            goto L_0x023f
        L_0x0234:
            r13 = r23
        L_0x0236:
            r0 = 1
            java.lang.Object[] r0 = new java.lang.Object[r0]
            r1 = 0
            r0[r1] = r4
            com.mpl.androidapp.utils.MLogger.e(r7, r0)
        L_0x023f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mpl.androidapp.notification.NotificationBuilder.lambda$createCollectibleNotification$4$NotificationBuilder(android.content.Context, android.os.Bundle):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:310:0x0668, code lost:
        if ("Generic".equalsIgnoreCase(r9) == false) goto L_0x066d;
     */
    /* JADX WARNING: Removed duplicated region for block: B:104:0x01f7  */
    /* JADX WARNING: Removed duplicated region for block: B:112:0x020f  */
    /* JADX WARNING: Removed duplicated region for block: B:115:0x021d  */
    /* JADX WARNING: Removed duplicated region for block: B:116:0x0225  */
    /* JADX WARNING: Removed duplicated region for block: B:126:0x0240  */
    /* JADX WARNING: Removed duplicated region for block: B:129:0x024c  */
    /* JADX WARNING: Removed duplicated region for block: B:135:0x0264  */
    /* JADX WARNING: Removed duplicated region for block: B:150:0x02c6  */
    /* JADX WARNING: Removed duplicated region for block: B:151:0x02ce  */
    /* JADX WARNING: Removed duplicated region for block: B:154:0x02e2  */
    /* JADX WARNING: Removed duplicated region for block: B:177:0x0354  */
    /* JADX WARNING: Removed duplicated region for block: B:182:0x0375  */
    /* JADX WARNING: Removed duplicated region for block: B:185:0x0390  */
    /* JADX WARNING: Removed duplicated region for block: B:232:0x04ac  */
    /* JADX WARNING: Removed duplicated region for block: B:258:0x051d A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:259:0x051e  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00e6  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00f0  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00fb  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x0115  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x012a  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x0137  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x0141  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x015a A[Catch:{ Exception -> 0x01a3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x015b A[Catch:{ Exception -> 0x01a3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x01c8  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ void lambda$createFCMNotificationDeepLink$3$NotificationBuilder(com.google.firebase.messaging.RemoteMessage r31) {
        /*
            r30 = this;
            r7 = r30
            java.lang.String r1 = "name"
            java.lang.String r2 = "param"
            java.lang.String r3 = "actionPayload"
            com.google.firebase.messaging.RemoteMessage$Notification r0 = r31.getNotification()
            if (r0 == 0) goto L_0x0019
            java.lang.String r5 = r0.getTitle()
            java.lang.String r0 = r0.getBody()
            r6 = r5
            r5 = r0
            goto L_0x001b
        L_0x0019:
            r5 = 0
            r6 = 0
        L_0x001b:
            int r0 = r31.getTtl()
            int r8 = r31.getPriority()
            long r9 = r31.getSentTime()
            android.os.Bundle r11 = new android.os.Bundle
            r11.<init>()
            java.util.Map r12 = r31.getData()
            java.lang.String r13 = "actionParams"
            java.lang.String r14 = "createFCMNotificationDeepLink: "
            java.lang.String r4 = "NotificationBuilder"
            if (r12 == 0) goto L_0x00da
            int r18 = r12.size()
            if (r18 <= 0) goto L_0x00da
            java.util.Set r18 = r12.entrySet()
            java.util.Iterator r18 = r18.iterator()
        L_0x0046:
            boolean r19 = r18.hasNext()
            if (r19 == 0) goto L_0x0090
            java.lang.Object r19 = r18.next()
            java.util.Map$Entry r19 = (java.util.Map.Entry) r19
            java.lang.Object r20 = r19.getKey()
            r15 = r20
            java.lang.String r15 = (java.lang.String) r15
            java.lang.Object r20 = r19.getValue()
            r22 = r8
            r8 = r20
            java.lang.String r8 = (java.lang.String) r8
            r11.putString(r15, r8)
            java.lang.String r8 = "eventProps"
            java.lang.Object r15 = r19.getKey()     // Catch:{ Exception -> 0x008d }
            java.lang.String r15 = (java.lang.String) r15     // Catch:{ Exception -> 0x008d }
            boolean r8 = r8.equalsIgnoreCase(r15)     // Catch:{ Exception -> 0x008d }
            if (r8 == 0) goto L_0x008d
            java.lang.Object r8 = r19.getValue()     // Catch:{ Exception -> 0x008d }
            java.lang.String r8 = (java.lang.String) r8     // Catch:{ Exception -> 0x008d }
            boolean r8 = com.mpl.androidapp.utils.CommonUtils.isJSONValid(r8)     // Catch:{ Exception -> 0x008d }
            if (r8 == 0) goto L_0x008d
            org.json.JSONObject r8 = new org.json.JSONObject     // Catch:{ Exception -> 0x008d }
            r8.<init>()     // Catch:{ Exception -> 0x008d }
            android.os.Bundle r8 = com.mpl.androidapp.utils.Util.jsonToBundle(r8)     // Catch:{ Exception -> 0x008d }
            r11.putAll(r8)     // Catch:{ Exception -> 0x008d }
        L_0x008d:
            r8 = r22
            goto L_0x0046
        L_0x0090:
            r22 = r8
            java.lang.String r8 = "notification_data"
            boolean r8 = r12.containsKey(r8)     // Catch:{ Exception -> 0x00ca }
            if (r8 == 0) goto L_0x00b7
            java.lang.String r8 = "action"
            boolean r8 = r11.containsKey(r8)     // Catch:{ Exception -> 0x00ca }
            if (r8 != 0) goto L_0x00b7
            java.lang.String r8 = "notification_data"
            java.lang.Object r8 = r12.get(r8)     // Catch:{ Exception -> 0x00ca }
            java.lang.String r8 = (java.lang.String) r8     // Catch:{ Exception -> 0x00ca }
            java.lang.String r15 = "action"
            r18 = r1
            java.lang.String r1 = "OPEN_DEEP_LINK"
            r11.putString(r15, r1)     // Catch:{ Exception -> 0x00c8 }
            r11.putString(r13, r8)     // Catch:{ Exception -> 0x00c8 }
            goto L_0x00b9
        L_0x00b7:
            r18 = r1
        L_0x00b9:
            java.lang.String r1 = "ttl"
            r11.putInt(r1, r0)     // Catch:{ Exception -> 0x00c8 }
            java.lang.String r0 = "sentTime"
            java.lang.String r1 = java.lang.String.valueOf(r9)     // Catch:{ Exception -> 0x00c8 }
            r11.putString(r0, r1)     // Catch:{ Exception -> 0x00c8 }
            goto L_0x00de
        L_0x00c8:
            r0 = move-exception
            goto L_0x00cd
        L_0x00ca:
            r0 = move-exception
            r18 = r1
        L_0x00cd:
            r1 = 2
            java.lang.Object[] r8 = new java.lang.Object[r1]
            r1 = 0
            r8[r1] = r14
            r1 = 1
            r8[r1] = r0
            com.mpl.androidapp.utils.MLogger.e(r4, r8)
            goto L_0x00de
        L_0x00da:
            r18 = r1
            r22 = r8
        L_0x00de:
            java.lang.String r0 = "showInBackground"
            boolean r1 = r11.containsKey(r0)
            if (r1 == 0) goto L_0x00f0
            java.lang.String r0 = r11.getString(r0)
            boolean r0 = java.lang.Boolean.parseBoolean(r0)
            r1 = r0
            goto L_0x00f1
        L_0x00f0:
            r1 = 0
        L_0x00f1:
            java.lang.String r0 = "user"
            boolean r8 = r11.containsKey(r0)
            java.lang.String r9 = ""
            if (r8 == 0) goto L_0x010b
            java.lang.String r0 = r11.getString(r0, r9)
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x010b
            android.content.Context r0 = r7.mContext
            r7.showNewUserOnBoardingNotification(r0, r11)
            return
        L_0x010b:
            java.lang.String r0 = "Type"
            boolean r0 = r11.containsKey(r0)
            java.lang.String r8 = "type"
            if (r0 != 0) goto L_0x011e
            boolean r0 = r11.containsKey(r8)
            if (r0 == 0) goto L_0x011c
            goto L_0x011e
        L_0x011c:
            r10 = r9
            goto L_0x012f
        L_0x011e:
            java.lang.String r0 = "Type"
            java.lang.String r0 = r11.getString(r0, r9)
            boolean r10 = android.text.TextUtils.isEmpty(r0)
            if (r10 == 0) goto L_0x012e
            java.lang.String r0 = r11.getString(r8, r9)
        L_0x012e:
            r10 = r0
        L_0x012f:
            java.lang.String r15 = "notifType"
            boolean r0 = r11.containsKey(r15)
            if (r0 == 0) goto L_0x0141
            java.lang.String r0 = r11.getString(r15)
            r19 = r1
            r20 = r2
            r1 = r0
            goto L_0x0146
        L_0x0141:
            r19 = r1
            r20 = r2
            r1 = r9
        L_0x0146:
            java.lang.String r0 = "GROUP_CHALLENGE_CREATED"
            boolean r0 = r0.equalsIgnoreCase(r10)     // Catch:{ Exception -> 0x01a3 }
            if (r0 != 0) goto L_0x0189
            boolean r0 = isOnLineOffLieNotification(r10)     // Catch:{ Exception -> 0x01a3 }
            if (r0 != 0) goto L_0x0189
            boolean r0 = isChallengeNotification(r10)     // Catch:{ Exception -> 0x01a3 }
            if (r0 == 0) goto L_0x015b
            goto L_0x0189
        L_0x015b:
            boolean r0 = isChallengeCancelNotification(r10)     // Catch:{ Exception -> 0x01a3 }
            if (r0 == 0) goto L_0x0186
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ Exception -> 0x01a3 }
            r0.<init>(r12)     // Catch:{ Exception -> 0x01a3 }
            android.content.Context r2 = r7.mContext     // Catch:{ Exception -> 0x01a3 }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x01a3 }
            com.mpl.androidapp.EventPublishHelper.publishChallengeCancelData(r2, r0)     // Catch:{ Exception -> 0x01a3 }
            r2 = 3
            java.lang.Object[] r0 = new java.lang.Object[r2]     // Catch:{ Exception -> 0x0182 }
            r2 = 0
            r0[r2] = r14     // Catch:{ Exception -> 0x01a3 }
            java.lang.String r2 = "Sending event data to react"
            r17 = 1
            r0[r17] = r2     // Catch:{ Exception -> 0x01a3 }
            r2 = 2
            r0[r2] = r10     // Catch:{ Exception -> 0x01a3 }
            com.mpl.androidapp.utils.MLogger.d(r4, r0)     // Catch:{ Exception -> 0x01a3 }
            return
        L_0x0182:
            r0 = move-exception
            r24 = r12
            goto L_0x01a7
        L_0x0186:
            r24 = r12
            goto L_0x01c2
        L_0x0189:
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ Exception -> 0x01a3 }
            r0.<init>(r12)     // Catch:{ Exception -> 0x01a3 }
            java.lang.String r2 = "notificationSource"
            r24 = r12
            java.lang.String r12 = "FCM"
            r0.put(r2, r12)     // Catch:{ Exception -> 0x01a1 }
            android.content.Context r2 = r7.mContext     // Catch:{ Exception -> 0x01a1 }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x01a1 }
            com.mpl.androidapp.EventPublishHelper.publishMqttMessageReceiveEvent(r2, r0)     // Catch:{ Exception -> 0x01a1 }
            goto L_0x01c2
        L_0x01a1:
            r0 = move-exception
            goto L_0x01a6
        L_0x01a3:
            r0 = move-exception
            r24 = r12
        L_0x01a6:
            r2 = 3
        L_0x01a7:
            java.lang.Object[] r12 = new java.lang.Object[r2]
            r2 = 0
            r12[r2] = r14
            java.lang.String r21 = "Exception in Sending event data to react"
            r17 = 1
            r12[r17] = r21
            r2 = 2
            r12[r2] = r10
            com.mpl.androidapp.utils.MLogger.d(r4, r12)
            java.lang.Object[] r12 = new java.lang.Object[r2]
            r2 = 0
            r12[r2] = r14
            r12[r17] = r0
            com.mpl.androidapp.utils.MLogger.e(r4, r12)
        L_0x01c2:
            boolean r0 = android.text.TextUtils.isEmpty(r10)
            if (r0 != 0) goto L_0x01f1
            java.lang.String r0 = "GROUP"
            boolean r0 = r0.equalsIgnoreCase(r10)
            if (r0 != 0) goto L_0x01dc
            java.lang.String r0 = r10.toLowerCase()
            java.lang.String r2 = "channel"
            boolean r0 = r2.equalsIgnoreCase(r0)
            if (r0 == 0) goto L_0x01f1
        L_0x01dc:
            java.lang.String r0 = "LIVE_STREAM"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x01eb
            android.content.Context r0 = r7.mContext
            r1 = 0
            r7.showLiveVideoGroupEventNotification(r0, r11, r1)
            goto L_0x01f0
        L_0x01eb:
            android.content.Context r0 = r7.mContext
            r7.showGroupEventNotification(r0, r11)
        L_0x01f0:
            return
        L_0x01f1:
            boolean r0 = android.text.TextUtils.isEmpty(r10)
            if (r0 != 0) goto L_0x0209
            boolean r0 = isGroupEventRelatedNotification(r10)
            if (r0 != 0) goto L_0x0203
            boolean r0 = isGroupChallengeEventRelatedNotification(r10)
            if (r0 == 0) goto L_0x0209
        L_0x0203:
            android.content.Context r0 = r7.mContext
            r7.showGroupChallengeNotification(r0, r11)
            return
        L_0x0209:
            boolean r0 = android.text.TextUtils.isEmpty(r6)
            if (r0 == 0) goto L_0x0215
            java.lang.String r0 = "title"
            java.lang.String r6 = r11.getString(r0, r9)
        L_0x0215:
            java.lang.String r0 = "profile"
            boolean r0 = r11.containsKey(r0)
            if (r0 == 0) goto L_0x0225
            java.lang.String r0 = "profile"
            java.lang.String r0 = r11.getString(r0)
            r1 = r0
            goto L_0x0226
        L_0x0225:
            r1 = r9
        L_0x0226:
            if (r1 == 0) goto L_0x023a
            boolean r0 = android.text.TextUtils.isEmpty(r1)
            if (r0 != 0) goto L_0x023a
            if (r6 == 0) goto L_0x023a
            boolean r0 = android.text.TextUtils.isEmpty(r6)
            if (r0 != 0) goto L_0x023a
            java.lang.String r6 = replaceServerNameWithContactName(r1, r6)
        L_0x023a:
            boolean r0 = android.text.TextUtils.isEmpty(r5)
            if (r0 == 0) goto L_0x0246
            java.lang.String r0 = "body"
            java.lang.String r5 = r11.getString(r0, r9)
        L_0x0246:
            boolean r0 = isOnLineOffLieNotification(r10)
            if (r0 == 0) goto L_0x0264
            java.lang.String r0 = "userid"
            r2 = 0
            int r0 = r11.getInt(r0, r2)
            if (r1 == 0) goto L_0x0260
            boolean r2 = android.text.TextUtils.isEmpty(r1)
            if (r2 != 0) goto L_0x0260
            java.lang.String r2 = "sender"
            r11.putString(r2, r1)
        L_0x0260:
            r12 = r1
            r2 = r9
            r1 = r0
            goto L_0x02be
        L_0x0264:
            boolean r0 = isChallengeNotification(r10)
            if (r0 == 0) goto L_0x02b2
            android.content.Context r0 = r7.mContext
            r7.showChallengeNotification(r0, r11)
            java.lang.String r0 = "challengeId"
            boolean r0 = r11.containsKey(r0)
            if (r0 == 0) goto L_0x02ae
            java.lang.String r0 = "challengeId"
            java.lang.String r2 = "challenge-0"
            java.lang.String r0 = r11.getString(r0, r2)
            boolean r2 = android.text.TextUtils.isEmpty(r0)
            if (r2 != 0) goto L_0x02a8
            java.lang.String r2 = "-"
            java.lang.String[] r12 = r0.split(r2)
            int r12 = r12.length
            if (r12 <= 0) goto L_0x02a8
            java.lang.String[] r12 = r0.split(r2)
            java.lang.String[] r2 = r0.split(r2)
            int r2 = r2.length
            r16 = 1
            int r2 = r2 + -1
            r2 = r12[r2]
            r16 = r0
            r12 = r1
            long r0 = java.lang.Long.parseLong(r2)
            int r1 = (int) r0
            r2 = r16
            goto L_0x02be
        L_0x02a8:
            r16 = r0
            r12 = r1
            r2 = r16
            goto L_0x02b0
        L_0x02ae:
            r12 = r1
            r2 = r9
        L_0x02b0:
            r1 = 0
            goto L_0x02be
        L_0x02b2:
            r12 = r1
            java.util.Random r0 = new java.util.Random
            r0.<init>()
            int r0 = r0.nextInt()
            r1 = r0
            r2 = r9
        L_0x02be:
            java.lang.String r0 = "action_notification_id"
            boolean r0 = r11.containsKey(r0)
            if (r0 != 0) goto L_0x02ce
            java.lang.String r0 = "action_notification_id"
            r11.putInt(r0, r1)
            r16 = r2
            goto L_0x02dc
        L_0x02ce:
            r16 = r2
            r2 = 1
            java.lang.Object[] r0 = new java.lang.Object[r2]
            java.lang.String r2 = "showGroupEventNotification:already having notification ID "
            r21 = 0
            r0[r21] = r2
            com.mpl.androidapp.utils.MLogger.d(r4, r0)
        L_0x02dc:
            boolean r0 = r11.containsKey(r8)
            if (r0 == 0) goto L_0x0301
            java.lang.String r0 = r11.getString(r8)
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x0301
            java.lang.String r0 = r11.getString(r8)
            if (r0 == 0) goto L_0x0301
            java.lang.String r0 = r11.getString(r8)
            java.lang.String r2 = "Collectible"
            boolean r0 = r2.equalsIgnoreCase(r0)
            if (r0 != 0) goto L_0x02ff
            goto L_0x0301
        L_0x02ff:
            r1 = 2
            goto L_0x0324
        L_0x0301:
            boolean r0 = r11.containsKey(r15)
            if (r0 == 0) goto L_0x0337
            java.lang.String r0 = r11.getString(r15)
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x0337
            java.lang.String r0 = r11.getString(r15)
            if (r0 == 0) goto L_0x0337
            java.lang.String r0 = r11.getString(r15)
            java.lang.String r2 = "Collectible"
            boolean r0 = r2.equalsIgnoreCase(r0)
            if (r0 == 0) goto L_0x0337
            goto L_0x02ff
        L_0x0324:
            java.lang.Object[] r0 = new java.lang.Object[r1]
            r1 = 0
            r0[r1] = r14
            java.lang.String r1 = "this is Collectible notification"
            r2 = 1
            r0[r2] = r1
            com.mpl.androidapp.utils.MLogger.d(r4, r0)
            android.content.Context r0 = r7.mContext
            r7.createCollectibleNotification(r0, r11)
            return
        L_0x0337:
            boolean r0 = android.text.TextUtils.isEmpty(r6)
            if (r0 == 0) goto L_0x0343
            boolean r0 = android.text.TextUtils.isEmpty(r5)
            if (r0 != 0) goto L_0x069f
        L_0x0343:
            android.content.Intent r2 = new android.content.Intent
            android.content.Context r0 = r7.mContext
            java.lang.Class<com.mpl.androidapp.react.MPLReactContainerActivity> r8 = com.mpl.androidapp.react.MPLReactContainerActivity.class
            r2.<init>(r0, r8)
            java.lang.String r0 = "feature"
            boolean r0 = r11.containsKey(r0)
            if (r0 != 0) goto L_0x0369
            java.lang.String r0 = "Feature"
            boolean r0 = r11.containsKey(r0)
            if (r0 == 0) goto L_0x035d
            goto L_0x0369
        L_0x035d:
            r27 = r1
            r26 = r2
            r25 = r5
            r23 = r10
            r28 = r12
            goto L_0x052c
        L_0x0369:
            java.lang.String r0 = "feature"
            java.lang.String r0 = r11.getString(r0, r9)
            boolean r8 = android.text.TextUtils.isEmpty(r0)
            if (r8 == 0) goto L_0x037b
            java.lang.String r0 = "Feature"
            java.lang.String r0 = r11.getString(r0, r9)
        L_0x037b:
            r8 = r0
            r15 = 2
            java.lang.Object[] r0 = new java.lang.Object[r15]
            r15 = 0
            r0[r15] = r14
            r15 = 1
            r0[r15] = r8
            com.mpl.androidapp.utils.MLogger.d(r4, r0)
            java.lang.String r0 = "referral MOT"
            boolean r0 = r0.equalsIgnoreCase(r8)
            if (r0 == 0) goto L_0x050b
            java.lang.String r0 = "referredMobileNumber"
            boolean r0 = r11.containsKey(r0)
            if (r0 == 0) goto L_0x050b
            java.lang.String r0 = "referredMobileNumber"
            java.lang.String r15 = r11.getString(r0, r9)
            r25 = r5
            java.lang.String r5 = "deepLink"
            java.lang.String r0 = r11.getString(r5, r9)
            r26 = r2
            r2 = 5
            java.lang.Object[] r2 = new java.lang.Object[r2]
            java.lang.String r27 = "createFCMNotificationDeepLink:1 "
            r21 = 0
            r2[r21] = r27
            java.lang.String r27 = "referredId: "
            r17 = 1
            r2[r17] = r27
            r27 = 2
            r2[r27] = r15
            java.lang.String r27 = "deepLink:"
            r23 = 3
            r2[r23] = r27
            r27 = 4
            r2[r27] = r0
            com.mpl.androidapp.utils.MLogger.d(r4, r2)
            boolean r2 = android.text.TextUtils.isEmpty(r15)
            if (r2 != 0) goto L_0x0508
            com.mpl.androidapp.database.entity.Contact r2 = com.mpl.androidapp.contact.ContactUtils.getNameFromLocalDb(r15)
            r27 = r1
            java.lang.String r1 = "A friend"
            if (r2 == 0) goto L_0x04a1
            java.lang.String r28 = r2.getContactDisplayName()     // Catch:{ Exception -> 0x048e }
            boolean r28 = android.text.TextUtils.isEmpty(r28)     // Catch:{ Exception -> 0x048e }
            if (r28 != 0) goto L_0x04a1
            java.lang.String r2 = r2.getContactDisplayName()     // Catch:{ Exception -> 0x048e }
            boolean r28 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x0488 }
            if (r28 == 0) goto L_0x03f0
            java.lang.String r0 = r11.getString(r13, r9)     // Catch:{ Exception -> 0x0488 }
        L_0x03f0:
            r28 = r12
            r12 = 5
            java.lang.Object[] r12 = new java.lang.Object[r12]     // Catch:{ Exception -> 0x0484 }
            java.lang.String r29 = "createFCMNotificationDeepLink:2 "
            r21 = 0
            r12[r21] = r29     // Catch:{ Exception -> 0x0484 }
            java.lang.String r29 = "referredId: "
            r17 = 1
            r12[r17] = r29     // Catch:{ Exception -> 0x0484 }
            r29 = 2
            r12[r29] = r15     // Catch:{ Exception -> 0x0484 }
            java.lang.String r29 = "deepLink:"
            r23 = 3
            r12[r23] = r29     // Catch:{ Exception -> 0x0484 }
            r23 = 4
            r12[r23] = r0     // Catch:{ Exception -> 0x0484 }
            com.mpl.androidapp.utils.MLogger.d(r4, r12)     // Catch:{ Exception -> 0x0484 }
            boolean r12 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x0484 }
            if (r12 != 0) goto L_0x0481
            boolean r12 = com.mpl.androidapp.utils.CommonUtils.isJSONValid(r0)     // Catch:{ Exception -> 0x0484 }
            if (r12 == 0) goto L_0x0481
            org.json.JSONObject r12 = new org.json.JSONObject     // Catch:{ Exception -> 0x0484 }
            r12.<init>(r0)     // Catch:{ Exception -> 0x0484 }
            org.json.JSONObject r0 = r12.optJSONObject(r3)     // Catch:{ Exception -> 0x0484 }
            if (r0 == 0) goto L_0x0481
            org.json.JSONObject r0 = r12.optJSONObject(r3)     // Catch:{ Exception -> 0x0484 }
            r23 = r10
            r10 = r20
            org.json.JSONObject r0 = r0.optJSONObject(r10)     // Catch:{ Exception -> 0x047f }
            if (r0 == 0) goto L_0x04a6
            org.json.JSONObject r0 = r12.optJSONObject(r3)     // Catch:{ Exception -> 0x047f }
            org.json.JSONObject r0 = r0.optJSONObject(r10)     // Catch:{ Exception -> 0x047f }
            r7 = r18
            java.lang.String r0 = r0.optString(r7, r9)     // Catch:{ Exception -> 0x047f }
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x047f }
            if (r0 != 0) goto L_0x04a6
            org.json.JSONObject r0 = r12.optJSONObject(r3)     // Catch:{ Exception -> 0x047f }
            org.json.JSONObject r0 = r0.optJSONObject(r10)     // Catch:{ Exception -> 0x047f }
            r0.remove(r7)     // Catch:{ Exception -> 0x047f }
            org.json.JSONObject r0 = r12.optJSONObject(r3)     // Catch:{ Exception -> 0x047f }
            org.json.JSONObject r0 = r0.optJSONObject(r10)     // Catch:{ Exception -> 0x047f }
            r0.put(r7, r2)     // Catch:{ Exception -> 0x047f }
            java.lang.String r0 = r12.toString()     // Catch:{ Exception -> 0x047f }
            boolean r3 = r11.containsKey(r5)     // Catch:{ Exception -> 0x047f }
            if (r3 == 0) goto L_0x0472
            r11.remove(r5)     // Catch:{ Exception -> 0x047f }
            r11.putString(r5, r0)     // Catch:{ Exception -> 0x047f }
            goto L_0x04a6
        L_0x0472:
            boolean r3 = r11.containsKey(r13)     // Catch:{ Exception -> 0x047f }
            if (r3 == 0) goto L_0x04a6
            r11.remove(r13)     // Catch:{ Exception -> 0x047f }
            r11.putString(r13, r0)     // Catch:{ Exception -> 0x047f }
            goto L_0x04a6
        L_0x047f:
            r0 = move-exception
            goto L_0x0494
        L_0x0481:
            r23 = r10
            goto L_0x04a6
        L_0x0484:
            r0 = move-exception
            r23 = r10
            goto L_0x0494
        L_0x0488:
            r0 = move-exception
            r23 = r10
            r28 = r12
            goto L_0x0494
        L_0x048e:
            r0 = move-exception
            r23 = r10
            r28 = r12
            r2 = r1
        L_0x0494:
            r3 = 2
            java.lang.Object[] r7 = new java.lang.Object[r3]
            r3 = 0
            r7[r3] = r14
            r3 = 1
            r7[r3] = r0
            com.mpl.androidapp.utils.MLogger.e(r4, r7)
            goto L_0x04a6
        L_0x04a1:
            r23 = r10
            r28 = r12
            r2 = r1
        L_0x04a6:
            boolean r0 = android.text.TextUtils.isEmpty(r6)
            if (r0 != 0) goto L_0x04e5
            boolean r0 = r6.contains(r1)
            if (r0 == 0) goto L_0x04b6
            java.lang.String r6 = r6.replace(r1, r2)
        L_0x04b6:
            java.lang.String r0 = "CONTACT_NAME"
            boolean r3 = r6.contains(r0)
            if (r3 == 0) goto L_0x04c2
            java.lang.String r6 = r6.replace(r0, r2)
        L_0x04c2:
            java.lang.String r3 = "<ContactName>"
            boolean r3 = r6.contains(r3)
            if (r3 == 0) goto L_0x04ce
            java.lang.String r6 = r6.replace(r0, r2)
        L_0x04ce:
            java.lang.String r3 = "{ContactName}"
            boolean r3 = r6.contains(r3)
            if (r3 == 0) goto L_0x04db
            java.lang.String r0 = r6.replace(r0, r2)
            r6 = r0
        L_0x04db:
            boolean r0 = r6.contains(r15)
            if (r0 == 0) goto L_0x04e5
            java.lang.String r6 = r6.replace(r15, r2)
        L_0x04e5:
            boolean r0 = android.text.TextUtils.isEmpty(r2)
            if (r0 != 0) goto L_0x04f5
            boolean r0 = android.text.TextUtils.isEmpty(r6)
            if (r0 != 0) goto L_0x04f5
            java.lang.String r6 = r6.replace(r1, r2)
        L_0x04f5:
            r1 = 2
            java.lang.Object[] r0 = new java.lang.Object[r1]
            r1 = 0
            r0[r1] = r14
            java.lang.String r1 = "No deep link found"
            java.lang.String r1 = r11.getString(r5, r1)
            r2 = 1
            r0[r2] = r1
            com.mpl.androidapp.utils.MLogger.d(r4, r0)
            goto L_0x0515
        L_0x0508:
            r27 = r1
            goto L_0x0511
        L_0x050b:
            r27 = r1
            r26 = r2
            r25 = r5
        L_0x0511:
            r23 = r10
            r28 = r12
        L_0x0515:
            java.lang.String r0 = "Support Bot"
            boolean r0 = r0.equalsIgnoreCase(r8)
            if (r0 == 0) goto L_0x051e
            return
        L_0x051e:
            java.lang.String r0 = "knockOut Tournament"
            boolean r0 = r0.equalsIgnoreCase(r8)
            r7 = r30
            if (r0 == 0) goto L_0x052c
            r7.createStickyNotification(r11)
            return
        L_0x052c:
            boolean r0 = isOnLineOffLieNotification(r23)
            if (r0 == 0) goto L_0x0564
            org.json.JSONObject r1 = new org.json.JSONObject
            r2 = r24
            r1.<init>(r2)
            if (r28 == 0) goto L_0x055b
            boolean r0 = android.text.TextUtils.isEmpty(r28)
            if (r0 != 0) goto L_0x055b
            java.lang.String r0 = "sender"
            org.json.JSONObject r2 = new org.json.JSONObject     // Catch:{ JSONException -> 0x054e }
            r3 = r28
            r2.<init>(r3)     // Catch:{ JSONException -> 0x054e }
            r1.put(r0, r2)     // Catch:{ JSONException -> 0x054e }
            goto L_0x055b
        L_0x054e:
            r0 = move-exception
            r2 = 2
            java.lang.Object[] r2 = new java.lang.Object[r2]
            r3 = 0
            r2[r3] = r14
            r3 = 1
            r2[r3] = r0
            com.mpl.androidapp.utils.MLogger.e(r4, r2)
        L_0x055b:
            android.content.Context r0 = r7.mContext
            r2 = r27
            android.content.Intent r0 = buildSendBirdIntent(r0, r1, r2)
            goto L_0x056c
        L_0x0564:
            r1 = r26
            r2 = r27
            r1.putExtras(r11)
            r0 = r1
        L_0x056c:
            java.lang.String r1 = "CHAT"
            r5 = r25
            androidx.core.app.NotificationCompat$Builder r1 = r7.generateChatNotificationBuilder(r6, r5, r1)
            boolean r3 = isChallengeCancelNotification(r23)
            if (r3 != 0) goto L_0x0586
            boolean r3 = isChallengeNotification(r23)
            if (r3 != 0) goto L_0x0586
            boolean r3 = isOnLineOffLieNotification(r23)
            if (r3 == 0) goto L_0x058c
        L_0x0586:
            java.lang.String r1 = "Challenge"
            androidx.core.app.NotificationCompat$Builder r1 = r7.generateChatNotificationBuilder(r6, r5, r1)
        L_0x058c:
            java.lang.String r3 = "bigPicture"
            boolean r6 = r11.containsKey(r3)
            if (r6 == 0) goto L_0x05a9
            java.lang.String r6 = r11.getString(r3)
            boolean r6 = android.text.TextUtils.isEmpty(r6)
            if (r6 != 0) goto L_0x05a9
            java.lang.String r3 = r11.getString(r3, r9)
            androidx.core.app.NotificationCompat$BigPictureStyle r3 = r7.getBigPictureInNotification(r3, r5)
            r1.setStyle(r3)
        L_0x05a9:
            java.lang.String r3 = "largeIcon"
            boolean r5 = r11.containsKey(r3)
            if (r5 == 0) goto L_0x05d1
            java.lang.String r5 = r11.getString(r3)
            boolean r5 = android.text.TextUtils.isEmpty(r5)
            if (r5 != 0) goto L_0x05d1
            java.lang.String r5 = r11.getString(r3)
            boolean r5 = android.webkit.URLUtil.isValidUrl(r5)
            if (r5 == 0) goto L_0x05d1
            java.lang.String r3 = r11.getString(r3, r9)
            android.graphics.Bitmap r3 = r7.getLargeIconInNotification(r3)
            r1.setLargeIcon(r3)
            goto L_0x05e0
        L_0x05d1:
            android.content.Context r3 = r7.mContext
            android.content.res.Resources r3 = r3.getResources()
            r5 = 2131689472(0x7f0f0000, float:1.900796E38)
            android.graphics.Bitmap r3 = android.graphics.BitmapFactory.decodeResource(r3, r5)
            r1.setLargeIcon(r3)
        L_0x05e0:
            android.content.Context r3 = r7.mContext
            java.util.Calendar r5 = java.util.Calendar.getInstance()
            long r5 = r5.getTimeInMillis()
            int r6 = (int) r5
            r5 = 134217728(0x8000000, float:3.85186E-34)
            android.app.PendingIntent r0 = android.app.PendingIntent.getActivity(r3, r6, r0, r5)
            boolean r3 = com.mpl.androidapp.utils.MSharedPreferencesUtils.isUserPlayingGame()
            r1.setContentIntent(r0)
            r0 = 2131231343(0x7f08026f, float:1.8078764E38)
            r1.setSmallIcon(r0)
            android.content.Context r0 = r7.mContext
            r5 = 2131100229(0x7f060245, float:1.7812834E38)
            int r0 = androidx.core.content.ContextCompat.getColor(r0, r5)
            r1.setColor(r0)
            java.lang.String r0 = "onGoing"
            java.lang.String r5 = "false"
            java.lang.String r0 = r11.getString(r0, r5)
            boolean r0 = java.lang.Boolean.parseBoolean(r0)
            r1.setOngoing(r0)
            java.lang.String r0 = "autoCancel"
            java.lang.String r5 = "true"
            java.lang.String r0 = r11.getString(r0, r5)
            boolean r0 = java.lang.Boolean.parseBoolean(r0)
            r1.setAutoCancel(r0)
            java.lang.String r0 = "groupNotification"
            boolean r0 = r11.containsKey(r0)
            if (r0 == 0) goto L_0x063d
            java.lang.String r0 = com.mpl.androidapp.utils.MBuildConfigUtils.getAppName()
            java.lang.String r5 = "groupNotification"
            java.lang.String r0 = r11.getString(r5, r0)
            r1.setGroup(r0)
        L_0x063d:
            r1.setExtras(r11)
            int r0 = android.os.Build.VERSION.SDK_INT
            r5 = 26
            if (r0 >= r5) goto L_0x0652
            if (r3 == 0) goto L_0x064d
            int r8 = r30.getPriority()
            goto L_0x064f
        L_0x064d:
            r8 = r22
        L_0x064f:
            r1.setPriority(r8)
        L_0x0652:
            android.content.Context r0 = r7.mContext
            boolean r0 = com.mpl.androidapp.utils.CommonUtils.isAppIsInBackground(r0)
            if (r0 != 0) goto L_0x067c
            boolean r0 = android.text.TextUtils.isEmpty(r23)
            if (r0 != 0) goto L_0x066b
            java.lang.String r0 = "Generic"
            r9 = r23
            boolean r0 = r0.equalsIgnoreCase(r9)
            if (r0 != 0) goto L_0x066f
            goto L_0x066d
        L_0x066b:
            r9 = r23
        L_0x066d:
            if (r19 == 0) goto L_0x067b
        L_0x066f:
            r3 = 1
            java.lang.Object[] r0 = new java.lang.Object[r3]
            java.lang.String r3 = "createFCMNotificationDeepLink: showing notification"
            r5 = 0
            r0[r5] = r3
            com.mpl.androidapp.utils.MLogger.d(r4, r0)
            goto L_0x067e
        L_0x067b:
            return
        L_0x067c:
            r9 = r23
        L_0x067e:
            java.lang.String r0 = java.lang.String.valueOf(r2)
            java.lang.String r2 = "notificationId"
            java.lang.String r0 = r11.getString(r2, r0)
            int r3 = java.lang.Integer.parseInt(r0)
            boolean r0 = isChallengeRelatedNotification(r9)
            if (r0 != 0) goto L_0x069f
            android.app.Notification r4 = r1.build()
            r5 = 0
            r6 = 1
            r1 = r30
            r2 = r16
            r1.notifyNotification(r2, r3, r4, r5, r6)
        L_0x069f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mpl.androidapp.notification.NotificationBuilder.lambda$createFCMNotificationDeepLink$3$NotificationBuilder(com.google.firebase.messaging.RemoteMessage):void");
    }

    public /* synthetic */ void lambda$createSendBirdChallengeNotification$6$NotificationBuilder(RemoteMessage remoteMessage) {
        String str;
        String str2;
        try {
            JSONObject jSONObject = new JSONObject(remoteMessage.getData());
            String optString = jSONObject.optString("sendbird");
            if (jSONObject.has("message")) {
                str = jSONObject.optString("message", "");
            } else {
                str = "";
            }
            if (optString != null && !TextUtils.isEmpty(optString)) {
                JSONObject jSONObject2 = new JSONObject(new JSONObject(optString).optString("data", "{}"));
                jSONObject2.put("notificationSource", "SendBird");
                String optString2 = jSONObject.optString("message", "");
                if (optString2 != null) {
                    if (!TextUtils.isEmpty(optString2)) {
                        str = optString2;
                    }
                }
                if (!jSONObject2.has("message")) {
                    jSONObject2.put("message", str);
                }
                if (!jSONObject2.has(SMTNotificationConstants.NOTIF_BODY_KEY)) {
                    jSONObject2.put(SMTNotificationConstants.NOTIF_BODY_KEY, str);
                }
                if (!jSONObject2.has("title")) {
                    str2 = jSONObject.optString("push_alert", "");
                } else {
                    str2 = "";
                }
                String optString3 = jSONObject2.optString(Constant.PROFILE, "{}");
                if (optString3 != null && !TextUtils.isEmpty(optString3) && str2 != null && !TextUtils.isEmpty(str2)) {
                    str2 = replaceServerNameWithContactName(optString3, str2);
                }
                jSONObject2.put("title", str2);
                jSONObject2.put("avatar", new JSONObject(optString3).optString("avatar", ""));
                showChallengeNotification(this.mContext, Util.jsonToBundle(jSONObject2));
                EventPublishHelper.publishMqttMessageReceiveEvent(this.mContext, jSONObject2.toString());
                try {
                    if (isChallengeCancelNotification(jSONObject2.optString("type", ""))) {
                        EventPublishHelper.publishChallengeCancelData(this.mContext, jSONObject2.toString());
                    }
                } catch (Exception e2) {
                    MLogger.e(TAG, "createSendBirdChallengeNotification:cancel ", e2);
                }
            }
        } catch (Exception e3) {
            MLogger.e(TAG, "createSendBirdChallengeNotification: ", e3.getMessage());
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:36:0x00b9 A[Catch:{ Exception -> 0x0102 }] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00f7  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00ff  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ void lambda$createSendBirdGroupNotification$7$NotificationBuilder(com.google.firebase.messaging.RemoteMessage r20) {
        /*
            r19 = this;
            r1 = r19
            java.lang.String r0 = "unread_message_count"
            java.lang.String r2 = "message"
            java.lang.String r3 = ""
            org.json.JSONObject r5 = new org.json.JSONObject     // Catch:{ Exception -> 0x0106 }
            java.util.Map r6 = r20.getData()     // Catch:{ Exception -> 0x0106 }
            r5.<init>(r6)     // Catch:{ Exception -> 0x0106 }
            java.lang.String r6 = "sendbird"
            java.lang.String r6 = r5.optString(r6)     // Catch:{ Exception -> 0x0106 }
            if (r6 == 0) goto L_0x011b
            boolean r7 = android.text.TextUtils.isEmpty(r6)     // Catch:{ Exception -> 0x0106 }
            if (r7 != 0) goto L_0x011b
            org.json.JSONObject r7 = new org.json.JSONObject     // Catch:{ Exception -> 0x0106 }
            r7.<init>(r6)     // Catch:{ Exception -> 0x0106 }
            java.lang.String r8 = "channel"
            org.json.JSONObject r8 = r7.optJSONObject(r8)     // Catch:{ Exception -> 0x0106 }
            java.lang.String r9 = "sender"
            org.json.JSONObject r9 = r7.optJSONObject(r9)     // Catch:{ Exception -> 0x0106 }
            java.lang.String r10 = "recipient"
            org.json.JSONObject r10 = r7.optJSONObject(r10)     // Catch:{ Exception -> 0x0106 }
            java.lang.String r11 = r7.optString(r2, r3)     // Catch:{ Exception -> 0x0106 }
            java.lang.String r12 = "channelUrl"
            java.lang.String r13 = "name"
            if (r8 == 0) goto L_0x005b
            java.lang.String r14 = "custom_type"
            java.lang.String r14 = r8.optString(r14, r3)     // Catch:{ Exception -> 0x0106 }
            java.lang.String r15 = r8.optString(r13, r3)     // Catch:{ Exception -> 0x0106 }
            java.lang.String r4 = "channel_url"
            java.lang.String r4 = r8.optString(r4, r3)     // Catch:{ Exception -> 0x0106 }
            boolean r16 = android.text.TextUtils.isEmpty(r4)     // Catch:{ Exception -> 0x0106 }
            if (r16 == 0) goto L_0x005e
            java.lang.String r4 = r8.optString(r12, r3)     // Catch:{ Exception -> 0x0106 }
            goto L_0x005e
        L_0x005b:
            r4 = r3
            r14 = r4
            r15 = r14
        L_0x005e:
            java.lang.String r8 = "id"
            java.lang.String r1 = "profile_url"
            if (r9 == 0) goto L_0x0077
            java.lang.String r16 = r9.optString(r1, r3)     // Catch:{ Exception -> 0x0102 }
            java.lang.String r17 = r9.optString(r13, r3)     // Catch:{ Exception -> 0x0102 }
            java.lang.String r9 = r9.optString(r8, r3)     // Catch:{ Exception -> 0x0102 }
            r18 = r16
            r16 = r0
            r0 = r18
            goto L_0x007d
        L_0x0077:
            r16 = r0
            r0 = r3
            r9 = r0
            r17 = r9
        L_0x007d:
            if (r10 == 0) goto L_0x0088
            r10.optString(r1, r3)     // Catch:{ Exception -> 0x0102 }
            r10.optString(r13, r3)     // Catch:{ Exception -> 0x0102 }
            r10.optString(r8, r3)     // Catch:{ Exception -> 0x0102 }
        L_0x0088:
            if (r9 == 0) goto L_0x009b
            boolean r1 = android.text.TextUtils.isEmpty(r9)     // Catch:{ Exception -> 0x0102 }
            if (r1 != 0) goto L_0x009b
            java.lang.String r1 = com.mpl.androidapp.contact.ContactUtils.getNameFromLocalDbFromUserId(r9)     // Catch:{ Exception -> 0x0102 }
            boolean r8 = android.text.TextUtils.isEmpty(r1)     // Catch:{ Exception -> 0x0102 }
            if (r8 != 0) goto L_0x009b
            goto L_0x009c
        L_0x009b:
            r1 = r3
        L_0x009c:
            boolean r8 = android.text.TextUtils.isEmpty(r11)     // Catch:{ Exception -> 0x0102 }
            if (r8 == 0) goto L_0x00ac
            boolean r8 = r5.has(r2)     // Catch:{ Exception -> 0x0102 }
            if (r8 == 0) goto L_0x00ac
            java.lang.String r11 = r5.optString(r2, r3)     // Catch:{ Exception -> 0x0102 }
        L_0x00ac:
            android.os.Bundle r2 = new android.os.Bundle     // Catch:{ Exception -> 0x0102 }
            r2.<init>()     // Catch:{ Exception -> 0x0102 }
            java.lang.String r5 = "title"
            boolean r8 = android.text.TextUtils.isEmpty(r1)     // Catch:{ Exception -> 0x0102 }
            if (r8 == 0) goto L_0x00bb
            r1 = r17
        L_0x00bb:
            r2.putString(r5, r1)     // Catch:{ Exception -> 0x0102 }
            java.lang.String r1 = "body"
            r2.putString(r1, r11)     // Catch:{ Exception -> 0x0102 }
            java.lang.String r1 = "avatar"
            r2.putString(r1, r0)     // Catch:{ Exception -> 0x0102 }
            java.lang.String r0 = "groupName"
            r2.putString(r0, r15)     // Catch:{ Exception -> 0x0102 }
            java.lang.String r0 = "groupIcon"
            r2.putString(r0, r3)     // Catch:{ Exception -> 0x0102 }
            r2.putString(r12, r4)     // Catch:{ Exception -> 0x0102 }
            java.lang.String r0 = "customType"
            r2.putString(r0, r14)     // Catch:{ Exception -> 0x0102 }
            java.lang.String r0 = "type"
            r2.putString(r0, r14)     // Catch:{ Exception -> 0x0102 }
            r2.putString(r13, r15)     // Catch:{ Exception -> 0x0102 }
            java.lang.String r0 = "sendbirdPayload"
            r2.putString(r0, r6)     // Catch:{ Exception -> 0x0102 }
            r0 = r16
            r1 = 0
            int r3 = r7.optInt(r0, r1)     // Catch:{ Exception -> 0x0102 }
            r2.putInt(r0, r3)     // Catch:{ Exception -> 0x0102 }
            boolean r0 = isNoNotificationEvent(r14)     // Catch:{ Exception -> 0x0102 }
            if (r0 != 0) goto L_0x00ff
            r1 = r19
            android.content.Context r0 = r1.mContext     // Catch:{ Exception -> 0x0106 }
            r1.showGroupEventNotification(r0, r2)     // Catch:{ Exception -> 0x0106 }
            goto L_0x011b
        L_0x00ff:
            r1 = r19
            goto L_0x011b
        L_0x0102:
            r0 = move-exception
            r1 = r19
            goto L_0x0107
        L_0x0106:
            r0 = move-exception
        L_0x0107:
            r2 = 2
            java.lang.Object[] r2 = new java.lang.Object[r2]
            java.lang.String r3 = "createSendBirdChallengeNotification: "
            r4 = 0
            r2[r4] = r3
            r3 = 1
            java.lang.String r0 = r0.getMessage()
            r2[r3] = r0
            java.lang.String r0 = "NotificationBuilder"
            com.mpl.androidapp.utils.MLogger.e(r0, r2)
        L_0x011b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mpl.androidapp.notification.NotificationBuilder.lambda$createSendBirdGroupNotification$7$NotificationBuilder(com.google.firebase.messaging.RemoteMessage):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:103:0x01a1, code lost:
        if (isGroupEventRelatedNotification(r2.optString("type")) == false) goto L_0x01e6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x006a, code lost:
        if (android.text.TextUtils.isEmpty(r12) == false) goto L_0x006e;
     */
    /* JADX WARNING: Removed duplicated region for block: B:143:0x0254  */
    /* JADX WARNING: Removed duplicated region for block: B:161:0x0291  */
    /* JADX WARNING: Removed duplicated region for block: B:164:0x02a3  */
    /* JADX WARNING: Removed duplicated region for block: B:165:0x02ad  */
    /* JADX WARNING: Removed duplicated region for block: B:168:0x02b7  */
    /* JADX WARNING: Removed duplicated region for block: B:171:0x02f6  */
    /* JADX WARNING: Removed duplicated region for block: B:178:0x0315  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0088  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00d4  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x00f3  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x00f9  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x0102  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x0108  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x0111  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x0118  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x014c  */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x0157  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x0162 A[SYNTHETIC, Splitter:B:86:0x0162] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ void lambda$createSendBirdGroupNotification$8$NotificationBuilder(org.json.JSONObject r30) {
        /*
            r29 = this;
            r6 = r29
            r7 = r30
            java.lang.String r0 = "notifType"
            java.lang.String r1 = "type"
            java.lang.String r8 = "sender"
            boolean r2 = r7.has(r8)
            java.lang.String r3 = "id"
            java.lang.String r4 = "profileUrl"
            java.lang.String r5 = "nickname"
            java.lang.String r9 = "name"
            java.lang.String r10 = ""
            if (r2 == 0) goto L_0x007b
            org.json.JSONObject r2 = r7.optJSONObject(r8)
            if (r2 == 0) goto L_0x007b
            java.lang.String r11 = r2.optString(r9, r10)
            boolean r12 = android.text.TextUtils.isEmpty(r11)
            if (r12 == 0) goto L_0x0034
            boolean r12 = r2.has(r5)
            if (r12 == 0) goto L_0x0034
            java.lang.String r11 = r2.optString(r5, r10)
        L_0x0034:
            java.lang.String r12 = r2.optString(r3, r10)
            boolean r13 = android.text.TextUtils.isEmpty(r12)
            if (r13 == 0) goto L_0x0044
            java.lang.String r12 = "userId"
            java.lang.String r12 = r2.optString(r12, r10)
        L_0x0044:
            android.content.Context r13 = r6.mContext     // Catch:{ Exception -> 0x0059 }
            int r13 = com.mpl.androidapp.utils.MSharedPreferencesUtils.getUserIdInNormalPref(r13)     // Catch:{ Exception -> 0x0059 }
            if (r13 == 0) goto L_0x005a
            boolean r14 = android.text.TextUtils.isEmpty(r12)     // Catch:{ Exception -> 0x0059 }
            if (r14 != 0) goto L_0x005a
            int r14 = java.lang.Integer.parseInt(r12)     // Catch:{ Exception -> 0x0059 }
            if (r14 != r13) goto L_0x005a
            return
        L_0x0059:
        L_0x005a:
            if (r12 == 0) goto L_0x006d
            boolean r13 = android.text.TextUtils.isEmpty(r12)
            if (r13 != 0) goto L_0x006d
            java.lang.String r12 = com.mpl.androidapp.contact.ContactUtils.getNameFromLocalDbFromUserId(r12)
            boolean r13 = android.text.TextUtils.isEmpty(r12)
            if (r13 != 0) goto L_0x006d
            goto L_0x006e
        L_0x006d:
            r12 = r11
        L_0x006e:
            boolean r13 = r2.has(r4)
            if (r13 == 0) goto L_0x0079
            java.lang.String r2 = r2.optString(r4, r10)
            goto L_0x007e
        L_0x0079:
            r2 = r10
            goto L_0x007e
        L_0x007b:
            r2 = r10
            r11 = r2
            r12 = r11
        L_0x007e:
            java.lang.String r13 = "requester"
            boolean r14 = r7.has(r13)
            java.lang.String r15 = "avatar"
            if (r14 == 0) goto L_0x00e8
            org.json.JSONObject r13 = r7.optJSONObject(r13)
            if (r13 == 0) goto L_0x00e8
            java.lang.String r11 = r13.optString(r9, r10)
            boolean r12 = android.text.TextUtils.isEmpty(r11)
            if (r12 == 0) goto L_0x00a2
            boolean r12 = r13.has(r5)
            if (r12 == 0) goto L_0x00a2
            java.lang.String r11 = r13.optString(r5, r10)
        L_0x00a2:
            boolean r5 = android.text.TextUtils.isEmpty(r11)
            if (r5 == 0) goto L_0x00b5
            java.lang.String r5 = "displayName"
            boolean r12 = r13.has(r5)
            if (r12 == 0) goto L_0x00b5
            java.lang.String r5 = r13.optString(r5, r10)
            r11 = r5
        L_0x00b5:
            java.lang.String r3 = r13.optString(r3, r10)
            if (r3 == 0) goto L_0x00cd
            boolean r5 = android.text.TextUtils.isEmpty(r3)
            if (r5 != 0) goto L_0x00cd
            java.lang.String r3 = com.mpl.androidapp.contact.ContactUtils.getNameFromLocalDbFromUserId(r3)
            boolean r5 = android.text.TextUtils.isEmpty(r3)
            if (r5 != 0) goto L_0x00cd
            r12 = r3
            goto L_0x00ce
        L_0x00cd:
            r12 = r11
        L_0x00ce:
            boolean r3 = r13.has(r4)
            if (r3 == 0) goto L_0x00d8
            java.lang.String r2 = r13.optString(r4, r10)
        L_0x00d8:
            boolean r3 = android.text.TextUtils.isEmpty(r2)
            if (r3 == 0) goto L_0x00e8
            boolean r3 = r13.has(r15)
            if (r3 == 0) goto L_0x00e8
            java.lang.String r2 = r13.optString(r15, r10)
        L_0x00e8:
            r13 = r12
            r12 = r11
            r11 = r2
            java.lang.String r2 = "message"
            boolean r3 = r7.has(r2)
            if (r3 == 0) goto L_0x00f9
            java.lang.String r2 = r7.optString(r2, r10)
            r14 = r2
            goto L_0x00fa
        L_0x00f9:
            r14 = r10
        L_0x00fa:
            java.lang.String r5 = "channelUrl"
            boolean r2 = r7.has(r5)
            if (r2 == 0) goto L_0x0108
            java.lang.String r2 = r7.optString(r5, r10)
            r4 = r2
            goto L_0x0109
        L_0x0108:
            r4 = r10
        L_0x0109:
            java.lang.String r3 = "customType"
            boolean r2 = r7.has(r3)
            if (r2 == 0) goto L_0x0118
            java.lang.String r2 = r7.optString(r3, r10)
            r16 = r2
            goto L_0x011a
        L_0x0118:
            r16 = r10
        L_0x011a:
            java.lang.String r2 = "group"
            boolean r17 = r7.has(r2)
            if (r17 == 0) goto L_0x013e
            org.json.JSONObject r17 = r7.optJSONObject(r2)
            if (r17 == 0) goto L_0x013e
            org.json.JSONObject r2 = r7.optJSONObject(r2)
            java.lang.String r17 = r2.optString(r9, r10)
            r18 = r3
            java.lang.String r3 = "coverUrl"
            java.lang.String r2 = r2.optString(r3, r10)
            r3 = r2
            r2 = r17
            r17 = r9
            goto L_0x0144
        L_0x013e:
            r18 = r3
            r17 = r9
            r2 = r10
            r3 = r2
        L_0x0144:
            java.lang.String r9 = "data"
            boolean r19 = r7.has(r9)
            if (r19 == 0) goto L_0x0157
            java.lang.String r19 = r7.optString(r9, r10)
            r28 = r19
            r19 = r9
            r9 = r28
            goto L_0x015a
        L_0x0157:
            r19 = r9
            r9 = r10
        L_0x015a:
            r20 = 0
            r21 = r10
            java.lang.String r10 = "NotificationBuilder"
            if (r9 == 0) goto L_0x0245
            boolean r22 = android.text.TextUtils.isEmpty(r9)     // Catch:{ Exception -> 0x022d }
            if (r22 != 0) goto L_0x0245
            r22 = r2
            org.json.JSONObject r2 = new org.json.JSONObject     // Catch:{ Exception -> 0x022f }
            r2.<init>(r9)     // Catch:{ Exception -> 0x022f }
            boolean r23 = r2.has(r1)     // Catch:{ Exception -> 0x022f }
            if (r23 == 0) goto L_0x01e2
            java.lang.String r23 = r2.optString(r1)     // Catch:{ Exception -> 0x01d4 }
            boolean r23 = android.text.TextUtils.isEmpty(r23)     // Catch:{ Exception -> 0x01d4 }
            if (r23 != 0) goto L_0x01e2
            java.lang.String r23 = r2.optString(r1)     // Catch:{ Exception -> 0x01d4 }
            boolean r23 = isGroupChallengeEventRelatedNotification(r23)     // Catch:{ Exception -> 0x01d4 }
            if (r23 != 0) goto L_0x01b3
            r23 = r3
            java.lang.String r3 = "CHANNEL_CHANGE"
            r24 = r4
            java.lang.String r4 = r2.optString(r1)     // Catch:{ Exception -> 0x01c2 }
            boolean r3 = r3.equalsIgnoreCase(r4)     // Catch:{ Exception -> 0x01c2 }
            if (r3 != 0) goto L_0x01b7
            java.lang.String r1 = r2.optString(r1)     // Catch:{ Exception -> 0x01c2 }
            boolean r1 = isGroupEventRelatedNotification(r1)     // Catch:{ Exception -> 0x01c2 }
            if (r1 == 0) goto L_0x01e6
            goto L_0x01b7
        L_0x01a4:
            r26 = r4
            r27 = r5
            r6 = r16
            r25 = r18
        L_0x01ac:
            r0 = 1
        L_0x01ad:
            r16 = r9
            r9 = r23
            goto L_0x023b
        L_0x01b3:
            r23 = r3
            r24 = r4
        L_0x01b7:
            r0 = 1
            java.lang.Object[] r1 = new java.lang.Object[r0]     // Catch:{ Exception -> 0x01cb }
            java.lang.String r0 = "createSendBirdGroupNotification:3 returning notification from send bird "
            r1[r20] = r0     // Catch:{ Exception -> 0x01c2 }
            com.mpl.androidapp.utils.MLogger.d(r10, r1)     // Catch:{ Exception -> 0x01c2 }
            return
        L_0x01c2:
            r27 = r5
            r6 = r16
            r25 = r18
            r26 = r24
            goto L_0x01ac
        L_0x01cb:
            r27 = r5
            r6 = r16
            r25 = r18
            r26 = r24
            goto L_0x01ad
        L_0x01d4:
            r26 = r4
            r27 = r5
            r6 = r16
            r25 = r18
            r0 = 1
            r16 = r9
            r9 = r3
            goto L_0x023b
        L_0x01e2:
            r23 = r3
            r24 = r4
        L_0x01e6:
            boolean r1 = r2.has(r0)     // Catch:{ Exception -> 0x0220 }
            if (r1 == 0) goto L_0x0213
            java.lang.String r1 = "LIVE_STREAM"
            java.lang.String r0 = r2.getString(r0)     // Catch:{ Exception -> 0x0220 }
            boolean r0 = r1.equals(r0)     // Catch:{ Exception -> 0x0220 }
            if (r0 == 0) goto L_0x0213
            android.content.Context r1 = r6.mContext     // Catch:{ Exception -> 0x0220 }
            r0 = r29
            r3 = r16
            r4 = r22
            r6 = r3
            r16 = r9
            r25 = r18
            r9 = r23
            r3 = r13
            r26 = r24
            r4 = r14
            r27 = r5
            r5 = r22
            r0.showLiveVideoGroupEventNotification(r1, r2, r3, r4, r5)     // Catch:{ Exception -> 0x023a }
            return
        L_0x0213:
            r27 = r5
            r6 = r16
            r25 = r18
            r26 = r24
            r16 = r9
            r9 = r23
            goto L_0x0252
        L_0x0220:
            r27 = r5
            r6 = r16
            r25 = r18
            r26 = r24
            r16 = r9
            r9 = r23
            goto L_0x023a
        L_0x022d:
            r22 = r2
        L_0x022f:
            r26 = r4
            r27 = r5
            r6 = r16
            r25 = r18
            r16 = r9
            r9 = r3
        L_0x023a:
            r0 = 1
        L_0x023b:
            java.lang.Object[] r1 = new java.lang.Object[r0]
            java.lang.String r0 = "createSendBirdGroupNotification:2 Exception is parsing data"
            r1[r20] = r0
            com.mpl.androidapp.utils.MLogger.e(r10, r1)
            goto L_0x0252
        L_0x0245:
            r22 = r2
            r26 = r4
            r27 = r5
            r6 = r16
            r25 = r18
            r16 = r9
            r9 = r3
        L_0x0252:
            if (r6 == 0) goto L_0x026d
            boolean r0 = android.text.TextUtils.isEmpty(r6)
            if (r0 != 0) goto L_0x026d
            boolean r0 = isGroupEventRelatedNotification(r6)
            if (r0 != 0) goto L_0x026c
            boolean r0 = isGroupChallengeEventRelatedNotification(r6)
            if (r0 != 0) goto L_0x026c
            boolean r0 = isNoNotificationEvent(r6)
            if (r0 == 0) goto L_0x026d
        L_0x026c:
            return
        L_0x026d:
            boolean r0 = android.text.TextUtils.isEmpty(r13)
            java.lang.String r1 = "title"
            if (r0 == 0) goto L_0x0285
            boolean r0 = android.text.TextUtils.isEmpty(r12)
            if (r0 == 0) goto L_0x0285
            boolean r0 = r7.has(r1)
            if (r0 == 0) goto L_0x0285
            java.lang.String r13 = r7.optString(r1)
        L_0x0285:
            android.os.Bundle r0 = new android.os.Bundle
            r0.<init>()
            boolean r2 = android.text.TextUtils.isEmpty(r13)
            if (r2 == 0) goto L_0x0291
            goto L_0x0292
        L_0x0291:
            r12 = r13
        L_0x0292:
            r0.putString(r1, r12)
            java.lang.String r1 = "body"
            r0.putString(r1, r14)
            r0.putString(r15, r11)
            boolean r1 = r7.has(r8)
            if (r1 == 0) goto L_0x02ad
            r1 = r21
            java.lang.String r2 = r7.optString(r8, r1)
            r0.putString(r8, r2)
            goto L_0x02af
        L_0x02ad:
            r1 = r21
        L_0x02af:
            java.lang.String r2 = "_sender"
            boolean r3 = r7.has(r2)
            if (r3 == 0) goto L_0x02be
            java.lang.String r1 = r7.optString(r2, r1)
            r0.putString(r2, r1)
        L_0x02be:
            java.lang.String r1 = "groupName"
            r2 = r22
            r0.putString(r1, r2)
            java.lang.String r1 = "groupIcon"
            r0.putString(r1, r9)
            r1 = r26
            r3 = r27
            r0.putString(r3, r1)
            r1 = r25
            r0.putString(r1, r6)
            java.lang.String r1 = "groupAction"
            r0.putString(r1, r6)
            r1 = r17
            r0.putString(r1, r2)
            r1 = r16
            r2 = r19
            r0.putString(r2, r1)
            r1 = 2
            java.lang.Object[] r1 = new java.lang.Object[r1]
            java.lang.String r2 = "createSendBirdGroupNotification: "
            r1[r20] = r2
            r2 = 1
            r1[r2] = r6
            com.mpl.androidapp.utils.MLogger.d(r10, r1)
            if (r6 == 0) goto L_0x030c
            boolean r1 = android.text.TextUtils.isEmpty(r6)
            if (r1 != 0) goto L_0x030c
            java.lang.String r1 = "CHALLENGE"
            boolean r1 = r1.equalsIgnoreCase(r6)
            if (r1 == 0) goto L_0x030c
            r1 = r29
            android.content.Context r2 = r1.mContext
            r1.showGroupChallengeNotification(r2, r0)
            goto L_0x032e
        L_0x030c:
            r1 = r29
            r2 = r6
            boolean r3 = android.text.TextUtils.isEmpty(r2)
            if (r3 != 0) goto L_0x0329
            java.lang.String r3 = "story"
            boolean r3 = r3.equals(r2)
            if (r3 != 0) goto L_0x0325
            java.lang.String r3 = "Story"
            boolean r2 = r3.equals(r2)
            if (r2 == 0) goto L_0x0329
        L_0x0325:
            r1.showGroupStoryNotification(r0)
            goto L_0x032e
        L_0x0329:
            android.content.Context r2 = r1.mContext
            r1.showGroupEventNotification(r2, r0)
        L_0x032e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mpl.androidapp.notification.NotificationBuilder.lambda$createSendBirdGroupNotification$8$NotificationBuilder(org.json.JSONObject):void");
    }

    public /* synthetic */ void lambda$createSendBirdMessageNotification$1$NotificationBuilder(JSONObject jSONObject) {
        boolean z;
        char c2;
        int i;
        JSONObject jSONObject2 = jSONObject;
        if (jSONObject2 != null) {
            String optString = jSONObject2.optString("message", "");
            String optString2 = jSONObject2.optString("channelUrl", "");
            if (jSONObject2.has("channel")) {
                JSONObject optJSONObject = jSONObject2.optJSONObject("channel");
                if (TextUtils.isEmpty(optString2) && optJSONObject.has("channel_url")) {
                    optString2 = optJSONObject.optString("channel_url", "");
                }
            }
            if (optString2.startsWith("sendbird_group_channel")) {
                createSendBirdGroupNotification(jSONObject);
                return;
            }
            JSONObject optJSONObject2 = jSONObject2.optJSONObject("sender");
            if (optJSONObject2 != null) {
                String optString3 = optJSONObject2.optString("profileUrl", "");
                String optString4 = optJSONObject2.optString("userId", "");
                if (TextUtils.isEmpty(optString4)) {
                    optString4 = optJSONObject2.optString("id", "");
                }
                String str = optString4;
                try {
                    int userIdInNormalPref = MSharedPreferencesUtils.getUserIdInNormalPref(this.mContext);
                    if (userIdInNormalPref != 0 && !TextUtils.isEmpty(str) && Integer.parseInt(str) == userIdInNormalPref) {
                        return;
                    }
                } catch (Exception unused) {
                }
                String optString5 = optJSONObject2.optString("nickname", "");
                if (str != null && !TextUtils.isEmpty(str)) {
                    String nameFromLocalDbFromUserId = ContactUtils.getNameFromLocalDbFromUserId(str);
                    if (nameFromLocalDbFromUserId != null && !TextUtils.isEmpty(nameFromLocalDbFromUserId)) {
                        optString5 = nameFromLocalDbFromUserId;
                    }
                }
                Bitmap largeIconInNotification = (TextUtils.isEmpty(optString3) || !URLUtil.isValidUrl(optString3)) ? null : getLargeIconInNotification(optString3);
                if (largeIconInNotification == null) {
                    largeIconInNotification = BitmapFactory.decodeResource(this.mContext.getResources(), R.drawable.ic_placeholder_dp_44_dp);
                }
                String str2 = "Photo";
                if (!jSONObject2.has("custom_type") || !"file".equalsIgnoreCase(jSONObject2.optString("custom_type"))) {
                    z = false;
                } else {
                    optString = str2;
                    z = true;
                }
                if (!jSONObject2.has("customType") || !"file".equalsIgnoreCase(jSONObject2.optString("customType"))) {
                    str2 = optString;
                } else {
                    z = true;
                }
                mSendBirdSenderIds.add(str);
                MLogger.d(TAG, "createSendBirdMessageNotification:3 ", optString2, optString3, str, Boolean.valueOf(z));
                Builder generateChatNotificationBuilder = generateChatNotificationBuilder(optString5, str2, CommonUtils.isAppIsInBackground(this.mContext) ? Constant.CHALLENGES_CHANNEL_ID : Constant.GAME_CHANNEL_ID);
                Context context = this.mContext;
                int timeInMillis = (int) Calendar.getInstance().getTimeInMillis();
                Intent buildSendBirdIntent = buildSendBirdIntent(jSONObject.toString(), 0);
                String str3 = TAG;
                PendingIntent activity = PendingIntent.getActivity(context, timeInMillis, buildSendBirdIntent, 134217728);
                generateChatNotificationBuilder.setDefaults(3);
                if (VERSION.SDK_INT < 26) {
                    generateChatNotificationBuilder.setPriority(getPriority());
                }
                generateChatNotificationBuilder.setContentIntent(activity);
                generateChatNotificationBuilder.setOngoing(false);
                generateChatNotificationBuilder.setAutoCancel(true);
                generateChatNotificationBuilder.setVibrate(new long[]{1000, 1000});
                generateChatNotificationBuilder.setLights(-65536, 3000, 3000);
                if (!z) {
                    generateChatNotificationBuilder.setLargeIcon(largeIconInNotification);
                    generateChatNotificationBuilder.setStyle(new BigTextStyle().bigText(str2));
                } else if (jSONObject2.optJSONArray("files") != null && jSONObject2.optJSONArray("files").length() > 0) {
                    String optString6 = jSONObject2.optJSONArray("files").optJSONObject(0).optString("url", "");
                    Bitmap largeIconInNotification2 = (TextUtils.isEmpty(optString6) || !URLUtil.isValidUrl(optString6)) ? null : getLargeIconInNotification(optString6);
                    if (largeIconInNotification2 == null) {
                        largeIconInNotification2 = BitmapFactory.decodeResource(this.mContext.getResources(), R.mipmap.ic_launcher);
                    }
                    generateChatNotificationBuilder.setLargeIcon(largeIconInNotification);
                    generateChatNotificationBuilder.setStyle(new BigPictureStyle().bigPicture(largeIconInNotification2).bigLargeIcon(largeIconInNotification));
                }
                generateChatNotificationBuilder.setGroup(optString2);
                String str4 = str3;
                notifyNotification("", Integer.parseInt((str == null || TextUtils.isEmpty(str)) ? "0" : str), generateChatNotificationBuilder.build(), 0, false);
                EventPublishHelper.emitSendBirdDataToReact(this.mContext, "onNotificationReceived", jSONObject.toString());
                try {
                    if (jSONObject2.has("customType") && !TextUtils.isEmpty(jSONObject2.optString("customType", "")) && "remind".equalsIgnoreCase(jSONObject2.optString("customType", ""))) {
                        jSONObject2.put("Sender ID", str);
                        jSONObject2.put("Is Challenge", true);
                        if (optJSONObject2.has("metaData")) {
                            try {
                                JSONObject optJSONObject3 = optJSONObject2.optJSONObject("metaData");
                                if (optJSONObject3 != null) {
                                    jSONObject2.put("Sender Mobile Number", optJSONObject3.optString("mobileNumber", ""));
                                    jSONObject2.put("Is Sender New On SendBird", optJSONObject3.optString("isNewSendBird", BaseParser.FALSE));
                                }
                            } catch (Exception e2) {
                                e = e2;
                                i = 2;
                                c2 = 0;
                                Object[] objArr = new Object[i];
                                objArr[c2] = "createSendBirdMessageNotification:4 ";
                                objArr[1] = e;
                                MLogger.e(str4, objArr);
                            }
                        }
                        c2 = 0;
                        try {
                            jSONObject2.put("Sender is New User", optJSONObject2.optBoolean(Constant.APPSFLYER_IS_NEW_USER, false));
                            jSONObject2.put("Receiver ID", MSharedPreferencesUtils.getUserIdInNormalPref(this.mContext));
                            jSONObject2.put("Receiver Mobile Number", MSharedPreferencesUtils.getMobileNumberInNormalPref(this.mContext));
                            jSONObject2.put("Receiver is Online", false);
                            jSONObject2.put(EventsConstants.PROP_NOTIFICATION_TYPE, "Challenge Reminder");
                        } catch (Exception e3) {
                            e = e3;
                            i = 2;
                            Object[] objArr2 = new Object[i];
                            objArr2[c2] = "createSendBirdMessageNotification:4 ";
                            objArr2[1] = e;
                            MLogger.e(str4, objArr2);
                        }
                    }
                    sendNotificationReceiveEvent(jSONObject);
                } catch (Exception e4) {
                    e = e4;
                    c2 = 0;
                    i = 2;
                    Object[] objArr22 = new Object[i];
                    objArr22[c2] = "createSendBirdMessageNotification:4 ";
                    objArr22[1] = e;
                    MLogger.e(str4, objArr22);
                }
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x00c5  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00da  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00dd  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x010c  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0137  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0145  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0154  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x01a7  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x01c0  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x01c4  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x01e7 A[Catch:{ Exception -> 0x026d }] */
    /* JADX WARNING: Removed duplicated region for block: B:81:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ void lambda$createSendBirdNotification$0$NotificationBuilder(org.json.JSONObject r22) {
        /*
            r21 = this;
            r7 = r21
            r0 = r22
            java.lang.String r8 = "metaData"
            java.lang.String r9 = "customType"
            java.lang.String r1 = "push_alert"
            java.lang.String r10 = ""
            java.lang.String r1 = r0.optString(r1, r10)
            java.lang.String r2 = "channel"
            org.json.JSONObject r2 = r0.optJSONObject(r2)
            java.lang.String r3 = com.mpl.androidapp.utils.MBuildConfigUtils.getAppName()
            java.lang.String r4 = "name"
            java.lang.String r2 = r2.optString(r4, r3)
            java.lang.String r11 = "sender"
            org.json.JSONObject r3 = r0.optJSONObject(r11)
            java.lang.String r5 = "0"
            if (r3 == 0) goto L_0x004a
            org.json.JSONObject r3 = r0.optJSONObject(r11)
            java.lang.String r6 = "profile_url"
            java.lang.String r3 = r3.optString(r6, r10)
            org.json.JSONObject r6 = r0.optJSONObject(r11)
            java.lang.String r4 = r6.optString(r4, r10)
            org.json.JSONObject r6 = r0.optJSONObject(r11)
            java.lang.String r12 = "id"
            java.lang.String r13 = "1"
            java.lang.String r6 = r6.optString(r12, r13)
            r12 = r6
            goto L_0x004d
        L_0x004a:
            r12 = r5
            r3 = r10
            r4 = r3
        L_0x004d:
            java.lang.String r6 = "unread_message_count"
            r13 = 0
            int r6 = r0.optInt(r6, r13)
            java.util.Set<java.lang.String> r14 = mSendBirdSenderIds
            r14.add(r12)
            if (r12 == 0) goto L_0x0062
            boolean r14 = android.text.TextUtils.isEmpty(r12)
            if (r14 != 0) goto L_0x0062
            r5 = r12
        L_0x0062:
            int r5 = java.lang.Integer.parseInt(r5)
            r14 = 4
            java.lang.Object[] r14 = new java.lang.Object[r14]
            java.lang.String r15 = "createSendBirdNotification: "
            r14[r13] = r15
            r13 = 1
            r14[r13] = r2
            r13 = 2
            r14[r13] = r3
            r13 = 3
            r14[r13] = r12
            java.lang.String r13 = "NotificationBuilder"
            com.mpl.androidapp.utils.MLogger.d(r13, r14)
            boolean r14 = android.text.TextUtils.isEmpty(r1)
            if (r14 != 0) goto L_0x009e
            java.lang.String r14 = ":"
            r17 = r4
            java.lang.String[] r4 = r1.split(r14)
            int r4 = r4.length
            r18 = r13
            r13 = 1
            if (r4 <= r13) goto L_0x00a2
            java.lang.String[] r4 = r1.split(r14)
            r16 = 0
            r4 = r4[r16]
            java.lang.String[] r1 = r1.split(r14)
            r1 = r1[r13]
            goto L_0x00be
        L_0x009e:
            r17 = r4
            r18 = r13
        L_0x00a2:
            java.lang.String r1 = "custom_type"
            boolean r4 = r0.has(r1)
            if (r4 == 0) goto L_0x00bc
            java.lang.String r1 = r0.optString(r1)
            java.lang.String r4 = "file"
            boolean r1 = r4.equalsIgnoreCase(r1)
            if (r1 == 0) goto L_0x00bc
            java.lang.String r1 = "Photo"
            r4 = r17
            r13 = 1
            goto L_0x00bf
        L_0x00bc:
            r1 = r10
            r4 = r1
        L_0x00be:
            r13 = 0
        L_0x00bf:
            boolean r14 = android.text.TextUtils.isEmpty(r12)
            if (r14 != 0) goto L_0x00d2
            java.lang.String r14 = com.mpl.androidapp.contact.ContactUtils.getNameFromLocalDbFromUserId(r12)
            if (r14 == 0) goto L_0x00d2
            boolean r17 = android.text.TextUtils.isEmpty(r14)
            if (r17 != 0) goto L_0x00d2
            r4 = r14
        L_0x00d2:
            android.content.Context r14 = r7.mContext
            boolean r14 = com.mpl.androidapp.utils.CommonUtils.isAppIsInBackground(r14)
            if (r14 == 0) goto L_0x00dd
            java.lang.String r14 = "Challenge"
            goto L_0x00df
        L_0x00dd:
            java.lang.String r14 = "GAME"
        L_0x00df:
            androidx.core.app.NotificationCompat$Builder r4 = r7.generateChatNotificationBuilder(r4, r1, r14)
            android.content.Context r14 = r7.mContext
            java.util.Calendar r17 = java.util.Calendar.getInstance()
            r19 = r11
            r20 = r12
            long r11 = r17.getTimeInMillis()
            int r12 = (int) r11
            java.lang.String r11 = r22.toString()
            android.content.Intent r11 = r7.buildSendBirdIntent(r11, r5)
            r17 = r15
            r15 = 134217728(0x8000000, float:3.85186E-34)
            android.app.PendingIntent r11 = android.app.PendingIntent.getActivity(r14, r12, r11, r15)
            r12 = 3
            r4.setDefaults(r12)
            int r12 = android.os.Build.VERSION.SDK_INT
            r14 = 26
            if (r12 >= r14) goto L_0x0113
            int r12 = r21.getPriority()
            r4.setPriority(r12)
        L_0x0113:
            r4.setContentIntent(r11)
            r11 = 0
            r4.setOngoing(r11)
            r12 = 1
            r4.setAutoCancel(r12)
            r4.setGroup(r2)
            r4.setGroupAlertBehavior(r11)
            r4.setGroupSummary(r11)
            r2 = 2
            long[] r11 = new long[r2]
            r11 = {1000, 1000} // fill-array
            r4.setVibrate(r11)
            boolean r2 = android.text.TextUtils.isEmpty(r3)
            r11 = 0
            if (r2 != 0) goto L_0x0142
            boolean r2 = android.webkit.URLUtil.isValidUrl(r3)
            if (r2 == 0) goto L_0x0142
            android.graphics.Bitmap r2 = r7.getLargeIconInNotification(r3)
            goto L_0x0143
        L_0x0142:
            r2 = r11
        L_0x0143:
            if (r2 != 0) goto L_0x0152
            android.content.Context r2 = r7.mContext
            android.content.res.Resources r2 = r2.getResources()
            r3 = 2131231326(0x7f08025e, float:1.807873E38)
            android.graphics.Bitmap r2 = android.graphics.BitmapFactory.decodeResource(r2, r3)
        L_0x0152:
            if (r13 == 0) goto L_0x01a7
            java.lang.String r1 = "files"
            org.json.JSONArray r3 = r0.optJSONArray(r1)
            if (r3 == 0) goto L_0x01b6
            org.json.JSONArray r3 = r0.optJSONArray(r1)
            int r3 = r3.length()
            if (r3 <= 0) goto L_0x01b6
            org.json.JSONArray r1 = r0.optJSONArray(r1)
            r3 = 0
            org.json.JSONObject r1 = r1.optJSONObject(r3)
            java.lang.String r3 = "url"
            java.lang.String r1 = r1.optString(r3, r10)
            boolean r3 = android.text.TextUtils.isEmpty(r1)
            if (r3 != 0) goto L_0x0185
            boolean r3 = android.webkit.URLUtil.isValidUrl(r1)
            if (r3 == 0) goto L_0x0185
            android.graphics.Bitmap r11 = r7.getLargeIconInNotification(r1)
        L_0x0185:
            if (r11 != 0) goto L_0x0193
            android.content.Context r1 = r7.mContext
            android.content.res.Resources r1 = r1.getResources()
            r3 = 2131689472(0x7f0f0000, float:1.900796E38)
            android.graphics.Bitmap r11 = android.graphics.BitmapFactory.decodeResource(r1, r3)
        L_0x0193:
            r4.setLargeIcon(r11)
            androidx.core.app.NotificationCompat$BigPictureStyle r1 = new androidx.core.app.NotificationCompat$BigPictureStyle
            r1.<init>()
            androidx.core.app.NotificationCompat$BigPictureStyle r1 = r1.bigPicture(r11)
            androidx.core.app.NotificationCompat$BigPictureStyle r1 = r1.bigLargeIcon(r2)
            r4.setStyle(r1)
            goto L_0x01b6
        L_0x01a7:
            r4.setLargeIcon(r2)
            androidx.core.app.NotificationCompat$BigTextStyle r2 = new androidx.core.app.NotificationCompat$BigTextStyle
            r2.<init>()
            androidx.core.app.NotificationCompat$BigTextStyle r1 = r2.bigText(r1)
            r4.setStyle(r1)
        L_0x01b6:
            r1 = -65536(0xffffffffffff0000, float:NaN)
            r2 = 3000(0xbb8, float:4.204E-42)
            r4.setLights(r1, r2, r2)
            r1 = 5
            if (r6 <= r1) goto L_0x01c4
            r7.createNotificationMoreThanFiveUnreadMessages(r6)
            goto L_0x01d3
        L_0x01c4:
            android.app.Notification r4 = r4.build()
            r11 = 0
            java.lang.String r2 = ""
            r1 = r21
            r3 = r5
            r5 = r6
            r6 = r11
            r1.notifyNotification(r2, r3, r4, r5, r6)
        L_0x01d3:
            sendNotificationReceiveEvent(r22)
            android.content.Context r1 = r7.mContext
            java.lang.String r2 = r22.toString()
            java.lang.String r3 = "onNotificationReceived"
            com.mpl.androidapp.EventPublishHelper.emitSendBirdDataToReact(r1, r3, r2)
            boolean r1 = r0.has(r9)     // Catch:{ Exception -> 0x026d }
            if (r1 == 0) goto L_0x027c
            java.lang.String r1 = r0.optString(r9, r10)     // Catch:{ Exception -> 0x026d }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ Exception -> 0x026d }
            if (r1 != 0) goto L_0x027c
            java.lang.String r1 = "remind"
            java.lang.String r2 = r0.optString(r9, r10)     // Catch:{ Exception -> 0x026d }
            boolean r1 = r1.equalsIgnoreCase(r2)     // Catch:{ Exception -> 0x026d }
            if (r1 == 0) goto L_0x027c
            r1 = r19
            boolean r2 = r0.has(r1)     // Catch:{ Exception -> 0x026d }
            if (r2 == 0) goto L_0x027c
            java.lang.String r2 = "Sender ID"
            r5 = r20
            r0.put(r2, r5)     // Catch:{ Exception -> 0x026d }
            java.lang.String r2 = "Is Challenge"
            r3 = 1
            r0.put(r2, r3)     // Catch:{ Exception -> 0x026d }
            org.json.JSONObject r1 = r0.optJSONObject(r1)     // Catch:{ Exception -> 0x026d }
            boolean r2 = r1.has(r8)     // Catch:{ Exception -> 0x026d }
            if (r2 == 0) goto L_0x023a
            org.json.JSONObject r2 = r1.optJSONObject(r8)     // Catch:{ Exception -> 0x026d }
            if (r2 == 0) goto L_0x023a
            java.lang.String r3 = "Sender Mobile Number"
            java.lang.String r4 = "mobileNumber"
            java.lang.String r4 = r2.optString(r4, r10)     // Catch:{ Exception -> 0x026d }
            r0.put(r3, r4)     // Catch:{ Exception -> 0x026d }
            java.lang.String r3 = "Is Sender New On SendBird"
            java.lang.String r4 = "isNewSendBird"
            java.lang.String r5 = "false"
            java.lang.String r2 = r2.optString(r4, r5)     // Catch:{ Exception -> 0x026d }
            r0.put(r3, r2)     // Catch:{ Exception -> 0x026d }
        L_0x023a:
            java.lang.String r2 = "Sender is New User"
            java.lang.String r3 = "newUser"
            r4 = 0
            boolean r1 = r1.optBoolean(r3, r4)     // Catch:{ Exception -> 0x026d }
            r0.put(r2, r1)     // Catch:{ Exception -> 0x026d }
            java.lang.String r1 = "Receiver ID"
            android.content.Context r2 = r7.mContext     // Catch:{ Exception -> 0x026d }
            int r2 = com.mpl.androidapp.utils.MSharedPreferencesUtils.getUserIdInNormalPref(r2)     // Catch:{ Exception -> 0x026d }
            r0.put(r1, r2)     // Catch:{ Exception -> 0x026d }
            java.lang.String r1 = "Receiver Mobile Number"
            android.content.Context r2 = r7.mContext     // Catch:{ Exception -> 0x026d }
            java.lang.String r2 = com.mpl.androidapp.utils.MSharedPreferencesUtils.getMobileNumberInNormalPref(r2)     // Catch:{ Exception -> 0x026d }
            r0.put(r1, r2)     // Catch:{ Exception -> 0x026d }
            java.lang.String r1 = "Receiver is Online"
            r2 = 0
            r0.put(r1, r2)     // Catch:{ Exception -> 0x026d }
            java.lang.String r1 = "Notification Type"
            java.lang.String r2 = "Challenge Reminder"
            r0.put(r1, r2)     // Catch:{ Exception -> 0x026d }
            sendNotificationReceiveEvent(r22)     // Catch:{ Exception -> 0x026d }
            goto L_0x027c
        L_0x026d:
            r0 = move-exception
            r1 = 2
            java.lang.Object[] r1 = new java.lang.Object[r1]
            r2 = 0
            r1[r2] = r17
            r2 = 1
            r1[r2] = r0
            r2 = r18
            com.mpl.androidapp.utils.MLogger.e(r2, r1)
        L_0x027c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mpl.androidapp.notification.NotificationBuilder.lambda$createSendBirdNotification$0$NotificationBuilder(org.json.JSONObject):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:318:0x078a, code lost:
        r10 = 65535;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:319:0x078b, code lost:
        if (r10 == 0) goto L_0x07ca;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:321:0x078e, code lost:
        if (r10 == 1) goto L_0x07bb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:323:0x0791, code lost:
        if (r10 == 2) goto L_0x07ad;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:325:0x0794, code lost:
        if (r10 == 3) goto L_0x07ad;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:327:0x0798, code lost:
        if (android.os.Build.VERSION.SDK_INT >= 26) goto L_0x07a1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:328:0x079a, code lost:
        r1.setPriority(getPriority());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:329:0x07a1, code lost:
        r1.addAction(r0);
        r1.addAction(r3);
        r1.setSubText(r31);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:330:0x07ad, code lost:
        r14 = r31;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:331:0x07b1, code lost:
        if (android.os.Build.VERSION.SDK_INT >= 26) goto L_0x07b7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:332:0x07b3, code lost:
        r1.setPriority(-1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:333:0x07b7, code lost:
        r1.setSubText(r14);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:335:0x07bd, code lost:
        if (android.os.Build.VERSION.SDK_INT >= 26) goto L_0x07c6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:336:0x07bf, code lost:
        r1.setPriority(getPriority());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:337:0x07c6, code lost:
        r1.addAction(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:338:0x07ca, code lost:
        r14 = r31;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:339:0x07ce, code lost:
        if (android.os.Build.VERSION.SDK_INT >= 26) goto L_0x07d7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:340:0x07d0, code lost:
        r1.setPriority(getPriority());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:341:0x07d7, code lost:
        r1.addAction(r3);
        r1.setSubText(r14);
     */
    /* JADX WARNING: Removed duplicated region for block: B:101:0x01ac A[SYNTHETIC, Splitter:B:101:0x01ac] */
    /* JADX WARNING: Removed duplicated region for block: B:127:0x020b A[Catch:{ Exception -> 0x0816 }] */
    /* JADX WARNING: Removed duplicated region for block: B:135:0x0224 A[Catch:{ Exception -> 0x0816 }] */
    /* JADX WARNING: Removed duplicated region for block: B:157:0x0289 A[Catch:{ Exception -> 0x0816 }] */
    /* JADX WARNING: Removed duplicated region for block: B:158:0x0292 A[Catch:{ Exception -> 0x0816 }] */
    /* JADX WARNING: Removed duplicated region for block: B:161:0x029c A[Catch:{ Exception -> 0x0816 }] */
    /* JADX WARNING: Removed duplicated region for block: B:164:0x02ac A[Catch:{ Exception -> 0x0816 }] */
    /* JADX WARNING: Removed duplicated region for block: B:165:0x02cb A[Catch:{ Exception -> 0x0816 }] */
    /* JADX WARNING: Removed duplicated region for block: B:168:0x02d4 A[Catch:{ Exception -> 0x0816 }] */
    /* JADX WARNING: Removed duplicated region for block: B:173:0x0314 A[Catch:{ Exception -> 0x0816 }] */
    /* JADX WARNING: Removed duplicated region for block: B:180:0x0348 A[Catch:{ Exception -> 0x0811 }] */
    /* JADX WARNING: Removed duplicated region for block: B:205:0x03ab  */
    /* JADX WARNING: Removed duplicated region for block: B:210:0x03bf A[Catch:{ Exception -> 0x080f }] */
    /* JADX WARNING: Removed duplicated region for block: B:211:0x03d9 A[Catch:{ Exception -> 0x080f }] */
    /* JADX WARNING: Removed duplicated region for block: B:214:0x03f3 A[Catch:{ Exception -> 0x080f }] */
    /* JADX WARNING: Removed duplicated region for block: B:221:0x0409 A[Catch:{ Exception -> 0x080f }] */
    /* JADX WARNING: Removed duplicated region for block: B:236:0x0444 A[Catch:{ Exception -> 0x080f }] */
    /* JADX WARNING: Removed duplicated region for block: B:280:0x060c A[Catch:{ Exception -> 0x080f }] */
    /* JADX WARNING: Removed duplicated region for block: B:282:0x0616 A[Catch:{ Exception -> 0x080f }] */
    /* JADX WARNING: Removed duplicated region for block: B:296:0x0735 A[Catch:{ Exception -> 0x080f }] */
    /* JADX WARNING: Removed duplicated region for block: B:344:0x07ec A[Catch:{ Exception -> 0x080f }] */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00f3 A[Catch:{ Exception -> 0x0820 }] */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00fa A[Catch:{ Exception -> 0x0820 }] */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x0105 A[Catch:{ Exception -> 0x0820 }] */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x010e A[Catch:{ Exception -> 0x0820 }] */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x0119 A[Catch:{ Exception -> 0x0820 }] */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x0120 A[Catch:{ Exception -> 0x0820 }] */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x0127 A[Catch:{ Exception -> 0x0820 }] */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x012c A[Catch:{ Exception -> 0x0820 }] */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x0136 A[SYNTHETIC, Splitter:B:69:0x0136] */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x0149 A[Catch:{ Exception -> 0x0820 }] */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x015a A[Catch:{ Exception -> 0x0820 }] */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x0178 A[Catch:{ Exception -> 0x0820 }] */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x017f A[Catch:{ Exception -> 0x0820 }] */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x0186 A[Catch:{ Exception -> 0x0820 }] */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x018b  */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x0195 A[Catch:{ Exception -> 0x081c }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ void lambda$showGroupChallengeNotification$10$NotificationBuilder(android.content.Context r36, android.os.Bundle r37) {
        /*
            r35 = this;
            r7 = r35
            r0 = r36
            r1 = r37
            java.lang.String r2 = "type"
            java.lang.String r3 = "avatar"
            java.lang.String r4 = "title"
            java.lang.String r5 = "extraInfo"
            java.lang.String r6 = "profile"
            java.lang.String r8 = "channelUrl"
            java.lang.String r9 = "action_notification_id"
            java.lang.String r10 = "NotificationBuilder"
            android.widget.RemoteViews r14 = new android.widget.RemoteViews     // Catch:{ Exception -> 0x0820 }
            java.lang.String r15 = r36.getPackageName()     // Catch:{ Exception -> 0x0820 }
            r11 = 2131558760(0x7f0d0168, float:1.8742845E38)
            r14.<init>(r15, r11)     // Catch:{ Exception -> 0x0820 }
            android.widget.RemoteViews r11 = new android.widget.RemoteViews     // Catch:{ Exception -> 0x0820 }
            java.lang.String r15 = r36.getPackageName()     // Catch:{ Exception -> 0x0820 }
            r12 = 2131558758(0x7f0d0166, float:1.874284E38)
            r11.<init>(r15, r12)     // Catch:{ Exception -> 0x0820 }
            android.widget.RemoteViews r12 = new android.widget.RemoteViews     // Catch:{ Exception -> 0x0820 }
            java.lang.String r15 = r36.getPackageName()     // Catch:{ Exception -> 0x0820 }
            r13 = 2131558759(0x7f0d0167, float:1.8742843E38)
            r12.<init>(r15, r13)     // Catch:{ Exception -> 0x0820 }
            java.lang.String r13 = "0"
            java.lang.String r15 = "gameType"
            boolean r15 = r1.containsKey(r15)     // Catch:{ Exception -> 0x0820 }
            r19 = r13
            java.lang.String r13 = ""
            if (r15 == 0) goto L_0x004f
            java.lang.String r15 = "gameType"
            java.lang.String r15 = r1.getString(r15, r13)     // Catch:{ Exception -> 0x0820 }
            goto L_0x0050
        L_0x004f:
            r15 = r13
        L_0x0050:
            boolean r20 = r1.containsKey(r8)     // Catch:{ Exception -> 0x0820 }
            if (r20 == 0) goto L_0x005b
            java.lang.String r20 = r1.getString(r8)     // Catch:{ Exception -> 0x0820 }
            goto L_0x005d
        L_0x005b:
            r20 = r13
        L_0x005d:
            boolean r21 = android.text.TextUtils.isEmpty(r20)     // Catch:{ Exception -> 0x0820 }
            if (r21 == 0) goto L_0x0074
            r21 = r12
            java.lang.String r12 = "groupUrl"
            boolean r12 = r1.containsKey(r12)     // Catch:{ Exception -> 0x0820 }
            if (r12 == 0) goto L_0x0076
            java.lang.String r12 = "groupUrl"
            java.lang.String r20 = r1.getString(r12)     // Catch:{ Exception -> 0x0820 }
            goto L_0x0076
        L_0x0074:
            r21 = r12
        L_0x0076:
            r12 = r20
            boolean r20 = r1.containsKey(r8)     // Catch:{ Exception -> 0x0820 }
            if (r20 != 0) goto L_0x0087
            boolean r20 = android.text.TextUtils.isEmpty(r12)     // Catch:{ Exception -> 0x0820 }
            if (r20 != 0) goto L_0x0087
            r1.putString(r8, r12)     // Catch:{ Exception -> 0x0820 }
        L_0x0087:
            java.lang.String r8 = "createdBy"
            boolean r8 = r1.containsKey(r8)     // Catch:{ Exception -> 0x0820 }
            if (r8 == 0) goto L_0x009a
            java.lang.String r8 = "createdBy"
            java.lang.String r8 = r1.getString(r8)     // Catch:{ Exception -> 0x0820 }
            int r8 = java.lang.Integer.parseInt(r8)     // Catch:{ Exception -> 0x0820 }
            goto L_0x009b
        L_0x009a:
            r8 = 0
        L_0x009b:
            if (r8 == 0) goto L_0x00a8
            r20 = r11
            android.content.Context r11 = r7.mContext     // Catch:{ Exception -> 0x0820 }
            int r11 = com.mpl.androidapp.utils.MSharedPreferencesUtils.getUserIdInNormalPref(r11)     // Catch:{ Exception -> 0x0820 }
            if (r8 != r11) goto L_0x00aa
            return
        L_0x00a8:
            r20 = r11
        L_0x00aa:
            boolean r8 = r1.containsKey(r4)     // Catch:{ Exception -> 0x0820 }
            if (r8 == 0) goto L_0x00b5
            java.lang.String r8 = r1.getString(r4)     // Catch:{ Exception -> 0x0820 }
            goto L_0x00b6
        L_0x00b5:
            r8 = r13
        L_0x00b6:
            java.lang.String r11 = "gameName"
            boolean r11 = r1.containsKey(r11)     // Catch:{ Exception -> 0x0820 }
            if (r11 == 0) goto L_0x00c3
            java.lang.String r11 = "gameName"
            r1.getString(r11)     // Catch:{ Exception -> 0x0820 }
        L_0x00c3:
            java.lang.String r11 = "groupIcon"
            boolean r11 = r1.containsKey(r11)     // Catch:{ Exception -> 0x0820 }
            if (r11 == 0) goto L_0x00d2
            java.lang.String r11 = "groupIcon"
            java.lang.String r11 = r1.getString(r11)     // Catch:{ Exception -> 0x0820 }
            goto L_0x00d3
        L_0x00d2:
            r11 = r13
        L_0x00d3:
            boolean r22 = android.text.TextUtils.isEmpty(r11)     // Catch:{ Exception -> 0x0820 }
            if (r22 == 0) goto L_0x00e9
            r22 = r11
            java.lang.String r11 = "groupImage"
            boolean r11 = r1.containsKey(r11)     // Catch:{ Exception -> 0x0820 }
            if (r11 == 0) goto L_0x00eb
            java.lang.String r11 = "groupImage"
            java.lang.String r11 = r1.getString(r11)     // Catch:{ Exception -> 0x0820 }
        L_0x00e9:
            r22 = r11
        L_0x00eb:
            java.lang.String r11 = "groupAction"
            boolean r11 = r1.containsKey(r11)     // Catch:{ Exception -> 0x0820 }
            if (r11 == 0) goto L_0x00fa
            java.lang.String r11 = "groupAction"
            java.lang.String r11 = r1.getString(r11)     // Catch:{ Exception -> 0x0820 }
            goto L_0x00fb
        L_0x00fa:
            r11 = r13
        L_0x00fb:
            r23 = r14
            java.lang.String r14 = "groupName"
            boolean r14 = r1.containsKey(r14)     // Catch:{ Exception -> 0x0820 }
            if (r14 == 0) goto L_0x010e
            java.lang.String r14 = "groupName"
            java.lang.String r14 = r1.getString(r14, r13)     // Catch:{ Exception -> 0x0820 }
            r24 = r11
            goto L_0x0111
        L_0x010e:
            r24 = r11
            r14 = r13
        L_0x0111:
            java.lang.String r11 = "body"
            boolean r11 = r1.containsKey(r11)     // Catch:{ Exception -> 0x0820 }
            if (r11 == 0) goto L_0x0120
            java.lang.String r11 = "body"
            java.lang.String r11 = r1.getString(r11)     // Catch:{ Exception -> 0x0820 }
            goto L_0x0121
        L_0x0120:
            r11 = r13
        L_0x0121:
            boolean r25 = r1.containsKey(r3)     // Catch:{ Exception -> 0x0820 }
            if (r25 == 0) goto L_0x012c
            java.lang.String r25 = r1.getString(r3)     // Catch:{ Exception -> 0x0820 }
            goto L_0x012e
        L_0x012c:
            r25 = r13
        L_0x012e:
            boolean r26 = android.text.TextUtils.isEmpty(r13)     // Catch:{ Exception -> 0x0820 }
            java.lang.String r0 = "gameIcon"
            if (r26 == 0) goto L_0x0141
            boolean r26 = r1.containsKey(r0)     // Catch:{ Exception -> 0x0820 }
            if (r26 == 0) goto L_0x0141
            java.lang.String r26 = r1.getString(r0)     // Catch:{ Exception -> 0x0820 }
            goto L_0x0143
        L_0x0141:
            r26 = r13
        L_0x0143:
            boolean r27 = android.text.TextUtils.isEmpty(r26)     // Catch:{ Exception -> 0x0820 }
            if (r27 == 0) goto L_0x015a
            r27 = r9
            java.lang.String r9 = "bigIcon"
            boolean r9 = r1.containsKey(r9)     // Catch:{ Exception -> 0x0820 }
            if (r9 == 0) goto L_0x015c
            java.lang.String r9 = "bigIcon"
            java.lang.String r26 = r1.getString(r9)     // Catch:{ Exception -> 0x0820 }
            goto L_0x015c
        L_0x015a:
            r27 = r9
        L_0x015c:
            boolean r9 = android.text.TextUtils.isEmpty(r25)     // Catch:{ Exception -> 0x0820 }
            if (r9 == 0) goto L_0x0170
            java.lang.String r9 = "largeIcon"
            boolean r9 = r1.containsKey(r9)     // Catch:{ Exception -> 0x0820 }
            if (r9 == 0) goto L_0x0170
            java.lang.String r9 = "largeIcon"
            java.lang.String r25 = r1.getString(r9)     // Catch:{ Exception -> 0x0820 }
        L_0x0170:
            java.lang.String r9 = "inviter"
            boolean r9 = r1.containsKey(r9)     // Catch:{ Exception -> 0x0820 }
            if (r9 == 0) goto L_0x017f
            java.lang.String r9 = "inviter"
            java.lang.String r9 = r1.getString(r9, r13)     // Catch:{ Exception -> 0x0820 }
            goto L_0x0180
        L_0x017f:
            r9 = r13
        L_0x0180:
            boolean r28 = r1.containsKey(r6)     // Catch:{ Exception -> 0x0820 }
            if (r28 == 0) goto L_0x018b
            java.lang.String r28 = r1.getString(r6, r13)     // Catch:{ Exception -> 0x0820 }
            goto L_0x018d
        L_0x018b:
            r28 = r13
        L_0x018d:
            java.lang.String r7 = "invitee"
            boolean r7 = r1.containsKey(r7)     // Catch:{ Exception -> 0x081c }
            if (r7 == 0) goto L_0x019a
            java.lang.String r7 = "invitee"
            r1.getString(r7, r13)     // Catch:{ Exception -> 0x081c }
        L_0x019a:
            boolean r7 = android.text.TextUtils.isEmpty(r9)     // Catch:{ Exception -> 0x081c }
            r29 = r12
            java.lang.String r12 = "userId"
            r30 = r10
            java.lang.String r10 = "avatarUrl"
            r31 = r15
            java.lang.String r15 = "displayName"
            if (r7 != 0) goto L_0x020b
            org.json.JSONObject r7 = new org.json.JSONObject     // Catch:{ Exception -> 0x0816 }
            r7.<init>(r9)     // Catch:{ Exception -> 0x0816 }
            boolean r9 = android.text.TextUtils.isEmpty(r25)     // Catch:{ Exception -> 0x0816 }
            if (r9 == 0) goto L_0x01c1
            boolean r9 = r7.has(r10)     // Catch:{ Exception -> 0x0816 }
            if (r9 == 0) goto L_0x01c1
            java.lang.String r25 = r7.optString(r10, r13)     // Catch:{ Exception -> 0x0816 }
        L_0x01c1:
            boolean r9 = r7.has(r15)     // Catch:{ Exception -> 0x0816 }
            if (r9 == 0) goto L_0x01cc
            java.lang.String r9 = r7.optString(r15, r13)     // Catch:{ Exception -> 0x0816 }
            goto L_0x01cd
        L_0x01cc:
            r9 = r13
        L_0x01cd:
            boolean r32 = r7.has(r15)     // Catch:{ Exception -> 0x0816 }
            if (r32 == 0) goto L_0x01d7
            java.lang.String r9 = r7.optString(r15, r13)     // Catch:{ Exception -> 0x0816 }
        L_0x01d7:
            boolean r32 = r7.has(r12)     // Catch:{ Exception -> 0x0816 }
            if (r32 == 0) goto L_0x01e5
            r32 = r10
            r10 = 0
            int r7 = r7.optInt(r12, r10)     // Catch:{ Exception -> 0x0816 }
            goto L_0x01e8
        L_0x01e5:
            r32 = r10
            r7 = 0
        L_0x01e8:
            if (r7 == 0) goto L_0x020f
            java.lang.String r10 = java.lang.String.valueOf(r7)     // Catch:{ Exception -> 0x0816 }
            java.lang.String r10 = com.mpl.androidapp.contact.ContactUtils.getNameFromLocalDbFromUserId(r10)     // Catch:{ Exception -> 0x0816 }
            boolean r33 = android.text.TextUtils.isEmpty(r10)     // Catch:{ Exception -> 0x0816 }
            if (r33 != 0) goto L_0x020f
            if (r8 == 0) goto L_0x020f
            boolean r33 = android.text.TextUtils.isEmpty(r8)     // Catch:{ Exception -> 0x0816 }
            if (r33 != 0) goto L_0x020f
            boolean r33 = r8.contains(r9)     // Catch:{ Exception -> 0x0816 }
            if (r33 == 0) goto L_0x020f
            java.lang.String r8 = r8.replace(r9, r10)     // Catch:{ Exception -> 0x0816 }
            goto L_0x020f
        L_0x020b:
            r32 = r10
            r9 = r13
            r7 = 0
        L_0x020f:
            boolean r10 = android.text.TextUtils.isEmpty(r11)     // Catch:{ Exception -> 0x0816 }
            if (r10 == 0) goto L_0x021c
            boolean r10 = android.text.TextUtils.isEmpty(r14)     // Catch:{ Exception -> 0x0816 }
            if (r10 != 0) goto L_0x021c
            r11 = r14
        L_0x021c:
            java.lang.String r10 = "data"
            boolean r10 = r1.containsKey(r10)     // Catch:{ Exception -> 0x0816 }
            if (r10 == 0) goto L_0x0281
            java.lang.String r10 = "data"
            java.lang.String r10 = r1.getString(r10)     // Catch:{ Exception -> 0x0816 }
            if (r10 == 0) goto L_0x0281
            boolean r33 = android.text.TextUtils.isEmpty(r10)     // Catch:{ Exception -> 0x0816 }
            if (r33 != 0) goto L_0x0281
            org.json.JSONObject r8 = new org.json.JSONObject     // Catch:{ Exception -> 0x0816 }
            r8.<init>(r10)     // Catch:{ Exception -> 0x0816 }
            java.lang.String r26 = r8.optString(r0, r13)     // Catch:{ Exception -> 0x0816 }
            java.lang.String r0 = r8.optString(r4, r13)     // Catch:{ Exception -> 0x0816 }
            boolean r4 = r8.has(r6)     // Catch:{ Exception -> 0x0816 }
            if (r4 == 0) goto L_0x0280
            java.lang.String r4 = r8.optString(r6, r13)     // Catch:{ Exception -> 0x0816 }
            boolean r6 = android.text.TextUtils.isEmpty(r4)     // Catch:{ Exception -> 0x0816 }
            if (r6 != 0) goto L_0x0280
            org.json.JSONObject r6 = new org.json.JSONObject     // Catch:{ Exception -> 0x0816 }
            r6.<init>(r4)     // Catch:{ Exception -> 0x0816 }
            java.lang.String r4 = r6.optString(r15, r13)     // Catch:{ Exception -> 0x0816 }
            java.lang.String r8 = "id"
            r10 = 0
            int r8 = r6.optInt(r8, r10)     // Catch:{ Exception -> 0x0816 }
            if (r8 == 0) goto L_0x0272
            java.lang.String r0 = java.lang.String.valueOf(r8)     // Catch:{ Exception -> 0x0816 }
            java.lang.String r0 = com.mpl.androidapp.contact.ContactUtils.getNameFromLocalDbFromUserId(r0)     // Catch:{ Exception -> 0x0816 }
            boolean r8 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x0816 }
            if (r8 != 0) goto L_0x0270
            goto L_0x0272
        L_0x0270:
            r8 = r4
            goto L_0x0273
        L_0x0272:
            r8 = r0
        L_0x0273:
            if (r25 == 0) goto L_0x027b
            boolean r0 = android.text.TextUtils.isEmpty(r25)     // Catch:{ Exception -> 0x0816 }
            if (r0 == 0) goto L_0x0281
        L_0x027b:
            java.lang.String r25 = r6.optString(r3, r13)     // Catch:{ Exception -> 0x0816 }
            goto L_0x0281
        L_0x0280:
            r8 = r0
        L_0x0281:
            r0 = r26
            boolean r3 = r1.containsKey(r2)     // Catch:{ Exception -> 0x0816 }
            if (r3 == 0) goto L_0x0292
            java.lang.String r3 = r1.getString(r2, r13)     // Catch:{ Exception -> 0x0816 }
            java.lang.String r2 = r1.getString(r2, r13)     // Catch:{ Exception -> 0x0816 }
            goto L_0x0294
        L_0x0292:
            r2 = r13
            r3 = r2
        L_0x0294:
            java.lang.String r4 = "gameId"
            boolean r4 = r1.containsKey(r4)     // Catch:{ Exception -> 0x0816 }
            if (r4 == 0) goto L_0x02a6
            java.lang.String r4 = "gameId"
            java.lang.String r6 = "0"
            java.lang.String r4 = r1.getString(r4, r6)     // Catch:{ Exception -> 0x0816 }
            r19 = r4
        L_0x02a6:
            boolean r4 = r1.containsKey(r5)     // Catch:{ Exception -> 0x0816 }
            if (r4 == 0) goto L_0x02cb
            java.lang.String r4 = "{}"
            java.lang.String r4 = r1.getString(r5, r4)     // Catch:{ Exception -> 0x0816 }
            org.json.JSONObject r6 = new org.json.JSONObject     // Catch:{ Exception -> 0x0816 }
            r6.<init>(r4)     // Catch:{ Exception -> 0x0816 }
            java.lang.String r10 = "tournamentId"
            r26 = r9
            r9 = 0
            int r6 = r6.optInt(r10, r9)     // Catch:{ Exception -> 0x0816 }
            org.json.JSONObject r9 = new org.json.JSONObject     // Catch:{ Exception -> 0x0816 }
            r9.<init>(r4)     // Catch:{ Exception -> 0x0816 }
            java.lang.String r4 = "tournamentName"
            r9.optString(r4, r13)     // Catch:{ Exception -> 0x0816 }
            goto L_0x02ce
        L_0x02cb:
            r26 = r9
            r6 = 0
        L_0x02ce:
            boolean r4 = android.text.TextUtils.isEmpty(r31)     // Catch:{ Exception -> 0x0816 }
            if (r4 != 0) goto L_0x0314
            java.lang.String r4 = "UGC"
            r9 = r31
            boolean r4 = r4.equalsIgnoreCase(r9)     // Catch:{ Exception -> 0x0816 }
            if (r4 == 0) goto L_0x0316
            boolean r4 = r1.containsKey(r5)     // Catch:{ Exception -> 0x0816 }
            if (r4 == 0) goto L_0x0316
            java.lang.String r4 = "{}"
            java.lang.String r4 = r1.getString(r5, r4)     // Catch:{ Exception -> 0x0816 }
            org.json.JSONObject r5 = new org.json.JSONObject     // Catch:{ Exception -> 0x0816 }
            r5.<init>(r4)     // Catch:{ Exception -> 0x0816 }
            java.lang.String r10 = "contestId"
            r31 = r14
            r14 = 0
            int r5 = r5.optInt(r10, r14)     // Catch:{ Exception -> 0x0816 }
            org.json.JSONObject r10 = new org.json.JSONObject     // Catch:{ Exception -> 0x0816 }
            r10.<init>(r4)     // Catch:{ Exception -> 0x0816 }
            r33 = r5
            java.lang.String r5 = "sportId"
            int r5 = r10.optInt(r5, r14)     // Catch:{ Exception -> 0x0816 }
            org.json.JSONObject r10 = new org.json.JSONObject     // Catch:{ Exception -> 0x0816 }
            r10.<init>(r4)     // Catch:{ Exception -> 0x0816 }
            java.lang.String r4 = "matchId"
            int r4 = r10.optInt(r4, r14)     // Catch:{ Exception -> 0x0816 }
            r10 = r4
            r4 = r33
            goto L_0x031b
        L_0x0314:
            r9 = r31
        L_0x0316:
            r31 = r14
            r4 = 0
            r5 = 0
            r10 = 0
        L_0x031b:
            r14 = 4
            java.lang.Object[] r14 = new java.lang.Object[r14]     // Catch:{ Exception -> 0x0816 }
            java.lang.String r33 = "showGroupChallengeNotification: "
            r18 = 0
            r14[r18] = r33     // Catch:{ Exception -> 0x0816 }
            java.lang.Integer r33 = java.lang.Integer.valueOf(r4)     // Catch:{ Exception -> 0x0816 }
            r17 = 1
            r14[r17] = r33     // Catch:{ Exception -> 0x0816 }
            java.lang.Integer r33 = java.lang.Integer.valueOf(r5)     // Catch:{ Exception -> 0x0816 }
            r16 = 2
            r14[r16] = r33     // Catch:{ Exception -> 0x0816 }
            java.lang.Integer r33 = java.lang.Integer.valueOf(r10)     // Catch:{ Exception -> 0x0816 }
            r34 = r2
            r2 = 3
            r14[r2] = r33     // Catch:{ Exception -> 0x0816 }
            r2 = r30
            com.mpl.androidapp.utils.MLogger.d(r2, r14)     // Catch:{ Exception -> 0x0811 }
            boolean r14 = android.text.TextUtils.isEmpty(r28)     // Catch:{ Exception -> 0x0811 }
            if (r14 != 0) goto L_0x03ab
            org.json.JSONObject r14 = new org.json.JSONObject     // Catch:{ Exception -> 0x0811 }
            r30 = r0
            r0 = r28
            r14.<init>(r0)     // Catch:{ Exception -> 0x0811 }
            boolean r0 = android.text.TextUtils.isEmpty(r25)     // Catch:{ Exception -> 0x0811 }
            if (r0 == 0) goto L_0x0363
            r0 = r32
            boolean r28 = r14.has(r0)     // Catch:{ Exception -> 0x0811 }
            if (r28 == 0) goto L_0x0363
            java.lang.String r25 = r14.optString(r0, r13)     // Catch:{ Exception -> 0x0811 }
        L_0x0363:
            boolean r0 = r14.has(r15)     // Catch:{ Exception -> 0x0811 }
            if (r0 == 0) goto L_0x036e
            java.lang.String r0 = r14.optString(r15, r13)     // Catch:{ Exception -> 0x0811 }
            goto L_0x0370
        L_0x036e:
            r0 = r26
        L_0x0370:
            boolean r26 = r14.has(r15)     // Catch:{ Exception -> 0x0811 }
            if (r26 == 0) goto L_0x037a
            java.lang.String r0 = r14.optString(r15, r13)     // Catch:{ Exception -> 0x0811 }
        L_0x037a:
            if (r7 != 0) goto L_0x0388
            boolean r13 = r14.has(r12)     // Catch:{ Exception -> 0x0811 }
            if (r13 == 0) goto L_0x0388
            r7 = 0
            int r12 = r14.optInt(r12, r7)     // Catch:{ Exception -> 0x0811 }
            r7 = r12
        L_0x0388:
            if (r7 == 0) goto L_0x03ad
            java.lang.String r7 = java.lang.String.valueOf(r7)     // Catch:{ Exception -> 0x0811 }
            java.lang.String r7 = com.mpl.androidapp.contact.ContactUtils.getNameFromLocalDbFromUserId(r7)     // Catch:{ Exception -> 0x0811 }
            boolean r12 = android.text.TextUtils.isEmpty(r7)     // Catch:{ Exception -> 0x0811 }
            if (r12 != 0) goto L_0x03ad
            if (r8 == 0) goto L_0x03ad
            boolean r12 = android.text.TextUtils.isEmpty(r8)     // Catch:{ Exception -> 0x0811 }
            if (r12 != 0) goto L_0x03ad
            boolean r12 = r8.contains(r0)     // Catch:{ Exception -> 0x0811 }
            if (r12 == 0) goto L_0x03ad
            java.lang.String r8 = r8.replace(r0, r7)     // Catch:{ Exception -> 0x0811 }
            goto L_0x03ad
        L_0x03ab:
            r30 = r0
        L_0x03ad:
            r7 = r35
            r0 = r25
            r12 = r29
            int r13 = r7.getGroupNotificationId(r12)     // Catch:{ Exception -> 0x080f }
            r14 = r27
            boolean r15 = r1.containsKey(r14)     // Catch:{ Exception -> 0x080f }
            if (r15 != 0) goto L_0x03d9
            r29 = r12
            r15 = 2
            java.lang.Object[] r12 = new java.lang.Object[r15]     // Catch:{ Exception -> 0x080f }
            java.lang.String r15 = "showGroupEventNotification:does not having notification ID "
            r18 = 0
            r12[r18] = r15     // Catch:{ Exception -> 0x080f }
            java.lang.Integer r15 = java.lang.Integer.valueOf(r13)     // Catch:{ Exception -> 0x080f }
            r17 = 1
            r12[r17] = r15     // Catch:{ Exception -> 0x080f }
            com.mpl.androidapp.utils.MLogger.d(r2, r12)     // Catch:{ Exception -> 0x080f }
            r1.putInt(r14, r13)     // Catch:{ Exception -> 0x080f }
            goto L_0x03e7
        L_0x03d9:
            r29 = r12
            r12 = 1
            java.lang.Object[] r15 = new java.lang.Object[r12]     // Catch:{ Exception -> 0x080f }
            java.lang.String r12 = "showGroupEventNotification:already having notification ID "
            r18 = 0
            r15[r18] = r12     // Catch:{ Exception -> 0x080f }
            com.mpl.androidapp.utils.MLogger.d(r2, r15)     // Catch:{ Exception -> 0x080f }
        L_0x03e7:
            org.json.JSONObject r12 = r7.parseResponse(r1)     // Catch:{ Exception -> 0x080f }
            r15 = r36
            android.content.Intent r12 = buildSendBirdIntent(r15, r12, r13)     // Catch:{ Exception -> 0x080f }
            if (r24 == 0) goto L_0x03f9
            boolean r25 = android.text.TextUtils.isEmpty(r24)     // Catch:{ Exception -> 0x080f }
            if (r25 == 0) goto L_0x0403
        L_0x03f9:
            boolean r25 = android.text.TextUtils.isEmpty(r3)     // Catch:{ Exception -> 0x080f }
            if (r25 != 0) goto L_0x0403
            r25 = r12
            r12 = r3
            goto L_0x0407
        L_0x0403:
            r25 = r12
            r12 = r24
        L_0x0407:
            if (r12 == 0) goto L_0x043e
            boolean r24 = android.text.TextUtils.isEmpty(r12)     // Catch:{ Exception -> 0x080f }
            if (r24 != 0) goto L_0x043e
            boolean r24 = isGroupChallengeEventRelatedNotification(r12)     // Catch:{ Exception -> 0x080f }
            if (r24 == 0) goto L_0x043e
            if (r6 == 0) goto L_0x042a
            boolean r24 = android.text.TextUtils.isEmpty(r19)     // Catch:{ Exception -> 0x080f }
            if (r24 != 0) goto L_0x042a
            r27 = r14
            int r14 = java.lang.Integer.parseInt(r19)     // Catch:{ Exception -> 0x080f }
            android.content.Intent r14 = r7.buildTournamentLaunchIntent(r14, r6, r13)     // Catch:{ Exception -> 0x080f }
            r24 = r14
            goto L_0x042e
        L_0x042a:
            r27 = r14
            r24 = r25
        L_0x042e:
            java.lang.String r14 = "UGC"
            boolean r14 = r14.equalsIgnoreCase(r9)     // Catch:{ Exception -> 0x080f }
            if (r14 == 0) goto L_0x043b
            android.content.Intent r14 = r7.buildContestDetailsIntent(r10, r4, r5, r13)     // Catch:{ Exception -> 0x080f }
            goto L_0x0442
        L_0x043b:
            r14 = r24
            goto L_0x0442
        L_0x043e:
            r27 = r14
            r14 = r25
        L_0x0442:
            if (r12 == 0) goto L_0x0459
            boolean r24 = android.text.TextUtils.isEmpty(r12)     // Catch:{ Exception -> 0x080f }
            if (r24 != 0) goto L_0x0459
            r24 = r14
            java.lang.String r14 = "USER_REMOVED"
            boolean r14 = r14.equalsIgnoreCase(r12)     // Catch:{ Exception -> 0x080f }
            if (r14 == 0) goto L_0x045b
            android.content.Intent r14 = r7.buildChatListIntent(r13)     // Catch:{ Exception -> 0x080f }
            goto L_0x045d
        L_0x0459:
            r24 = r14
        L_0x045b:
            r14 = r24
        L_0x045d:
            r24 = r4
            r4 = 6
            java.lang.Object[] r4 = new java.lang.Object[r4]     // Catch:{ Exception -> 0x080f }
            java.lang.String r25 = "showGroupChallengeNotification: eventType"
            r18 = 0
            r4[r18] = r25     // Catch:{ Exception -> 0x080f }
            r17 = 1
            r4[r17] = r12     // Catch:{ Exception -> 0x080f }
            java.lang.String r25 = "type: "
            r16 = 2
            r4[r16] = r25     // Catch:{ Exception -> 0x080f }
            r25 = 3
            r4[r25] = r3     // Catch:{ Exception -> 0x080f }
            r3 = 4
            java.lang.String r25 = "gameType: "
            r4[r3] = r25     // Catch:{ Exception -> 0x080f }
            r3 = 5
            r4[r3] = r9     // Catch:{ Exception -> 0x080f }
            com.mpl.androidapp.utils.MLogger.d(r2, r4)     // Catch:{ Exception -> 0x080f }
            r3 = 2131362915(0x7f0a0463, float:1.8345624E38)
            r4 = r23
            r4.setTextViewText(r3, r8)     // Catch:{ Exception -> 0x080f }
            r3 = 2131362910(0x7f0a045e, float:1.8345614E38)
            r4.setTextViewText(r3, r11)     // Catch:{ Exception -> 0x080f }
            r3 = 2131362915(0x7f0a0463, float:1.8345624E38)
            r23 = r12
            r12 = r20
            r12.setTextViewText(r3, r8)     // Catch:{ Exception -> 0x080f }
            r3 = 2131362910(0x7f0a045e, float:1.8345614E38)
            r12.setTextViewText(r3, r11)     // Catch:{ Exception -> 0x080f }
            r3 = 2131362915(0x7f0a0463, float:1.8345624E38)
            r20 = r5
            r5 = r21
            r5.setTextViewText(r3, r8)     // Catch:{ Exception -> 0x080f }
            r3 = 2131362910(0x7f0a045e, float:1.8345614E38)
            r5.setTextViewText(r3, r11)     // Catch:{ Exception -> 0x080f }
            r3 = 10000(0x2710, float:1.4013E-41)
            boolean r8 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x04f9 }
            if (r8 != 0) goto L_0x0504
            java.lang.String r8 = ".circlevtw"
            boolean r8 = r8.equalsIgnoreCase(r0)     // Catch:{ Exception -> 0x04f9 }
            if (r8 != 0) goto L_0x0504
            boolean r8 = android.webkit.URLUtil.isValidUrl(r0)     // Catch:{ Exception -> 0x04f9 }
            if (r8 == 0) goto L_0x0504
            java.net.URL r8 = new java.net.URL     // Catch:{ Exception -> 0x04f9 }
            r8.<init>(r0)     // Catch:{ Exception -> 0x04f9 }
            java.net.URLConnection r0 = r8.openConnection()     // Catch:{ Exception -> 0x04f9 }
            java.lang.Object r0 = com.google.firebase.perf.network.FirebasePerfUrlConnection.instrument(r0)     // Catch:{ Exception -> 0x04f9 }
            java.net.URLConnection r0 = (java.net.URLConnection) r0     // Catch:{ Exception -> 0x04f9 }
            r0.setConnectTimeout(r3)     // Catch:{ Exception -> 0x04f9 }
            r0.setReadTimeout(r3)     // Catch:{ Exception -> 0x04f9 }
            java.io.InputStream r0 = r0.getInputStream()     // Catch:{ Exception -> 0x04f9 }
            android.graphics.Bitmap r0 = android.graphics.BitmapFactory.decodeStream(r0)     // Catch:{ Exception -> 0x04f9 }
            android.graphics.Bitmap r0 = com.mpl.androidapp.utils.CommonUtils.getCircularBitmap(r0)     // Catch:{ Exception -> 0x04f9 }
            r8 = 2131362914(0x7f0a0462, float:1.8345622E38)
            r4.setImageViewBitmap(r8, r0)     // Catch:{ Exception -> 0x04f9 }
            r8 = 2131362914(0x7f0a0462, float:1.8345622E38)
            r12.setImageViewBitmap(r8, r0)     // Catch:{ Exception -> 0x04f9 }
            r8 = 2131362914(0x7f0a0462, float:1.8345622E38)
            r5.setImageViewBitmap(r8, r0)     // Catch:{ Exception -> 0x04f9 }
            goto L_0x0504
        L_0x04f9:
            r8 = 1
            java.lang.Object[] r0 = new java.lang.Object[r8]     // Catch:{ Exception -> 0x080f }
            java.lang.String r8 = "showGroupChallengeNotification: Exception in sender avatar"
            r11 = 0
            r0[r11] = r8     // Catch:{ Exception -> 0x080f }
            com.mpl.androidapp.utils.MLogger.e(r2, r0)     // Catch:{ Exception -> 0x080f }
        L_0x0504:
            r0 = 2131362905(0x7f0a0459, float:1.8345604E38)
            boolean r8 = android.text.TextUtils.isEmpty(r22)     // Catch:{ Exception -> 0x0540 }
            if (r8 != 0) goto L_0x055e
            boolean r8 = android.webkit.URLUtil.isValidUrl(r22)     // Catch:{ Exception -> 0x0540 }
            if (r8 == 0) goto L_0x055e
            java.net.URL r8 = new java.net.URL     // Catch:{ Exception -> 0x0540 }
            r11 = r22
            r8.<init>(r11)     // Catch:{ Exception -> 0x0540 }
            java.net.URLConnection r8 = r8.openConnection()     // Catch:{ Exception -> 0x0540 }
            java.lang.Object r8 = com.google.firebase.perf.network.FirebasePerfUrlConnection.instrument(r8)     // Catch:{ Exception -> 0x0540 }
            java.net.URLConnection r8 = (java.net.URLConnection) r8     // Catch:{ Exception -> 0x0540 }
            r8.setConnectTimeout(r3)     // Catch:{ Exception -> 0x0540 }
            r8.setReadTimeout(r3)     // Catch:{ Exception -> 0x0540 }
            java.io.InputStream r8 = r8.getInputStream()     // Catch:{ Exception -> 0x0540 }
            android.graphics.Bitmap r8 = android.graphics.BitmapFactory.decodeStream(r8)     // Catch:{ Exception -> 0x0540 }
            android.graphics.Bitmap r8 = com.mpl.androidapp.utils.CommonUtils.getCircularBitmap(r8)     // Catch:{ Exception -> 0x0540 }
            r4.setImageViewBitmap(r0, r8)     // Catch:{ Exception -> 0x0540 }
            r12.setImageViewBitmap(r0, r8)     // Catch:{ Exception -> 0x0540 }
            r5.setImageViewBitmap(r0, r8)     // Catch:{ Exception -> 0x0540 }
            goto L_0x055e
        L_0x0540:
            r8 = 1
            java.lang.Object[] r11 = new java.lang.Object[r8]     // Catch:{ Exception -> 0x080f }
            java.lang.String r8 = "showGroupChallengeNotification: Exception in group Icon"
            r18 = 0
            r11[r18] = r8     // Catch:{ Exception -> 0x080f }
            com.mpl.androidapp.utils.MLogger.e(r2, r11)     // Catch:{ Exception -> 0x080f }
            r8 = 2131231051(0x7f08014b, float:1.8078172E38)
            r4.setImageViewResource(r0, r8)     // Catch:{ Exception -> 0x080f }
            r8 = 2131231051(0x7f08014b, float:1.8078172E38)
            r12.setImageViewResource(r0, r8)     // Catch:{ Exception -> 0x080f }
            r8 = 2131231051(0x7f08014b, float:1.8078172E38)
            r5.setImageViewResource(r0, r8)     // Catch:{ Exception -> 0x080f }
        L_0x055e:
            boolean r0 = android.text.TextUtils.isEmpty(r30)     // Catch:{ Exception -> 0x05a0 }
            if (r0 != 0) goto L_0x05ab
            boolean r0 = android.webkit.URLUtil.isValidUrl(r30)     // Catch:{ Exception -> 0x05a0 }
            if (r0 == 0) goto L_0x05ab
            java.net.URL r0 = new java.net.URL     // Catch:{ Exception -> 0x05a0 }
            r8 = r30
            r0.<init>(r8)     // Catch:{ Exception -> 0x05a0 }
            java.net.URLConnection r0 = r0.openConnection()     // Catch:{ Exception -> 0x05a0 }
            java.lang.Object r0 = com.google.firebase.perf.network.FirebasePerfUrlConnection.instrument(r0)     // Catch:{ Exception -> 0x05a0 }
            java.net.URLConnection r0 = (java.net.URLConnection) r0     // Catch:{ Exception -> 0x05a0 }
            r0.setConnectTimeout(r3)     // Catch:{ Exception -> 0x05a0 }
            r0.setReadTimeout(r3)     // Catch:{ Exception -> 0x05a0 }
            java.io.InputStream r0 = r0.getInputStream()     // Catch:{ Exception -> 0x05a0 }
            android.graphics.Bitmap r0 = android.graphics.BitmapFactory.decodeStream(r0)     // Catch:{ Exception -> 0x05a0 }
            android.graphics.Bitmap r0 = com.mpl.androidapp.utils.CommonUtils.getCircularBitmap(r0)     // Catch:{ Exception -> 0x05a0 }
            r3 = 2131362904(0x7f0a0458, float:1.8345602E38)
            r4.setImageViewBitmap(r3, r0)     // Catch:{ Exception -> 0x05a0 }
            r3 = 2131362904(0x7f0a0458, float:1.8345602E38)
            r12.setImageViewBitmap(r3, r0)     // Catch:{ Exception -> 0x05a0 }
            r3 = 2131362904(0x7f0a0458, float:1.8345602E38)
            r5.setImageViewBitmap(r3, r0)     // Catch:{ Exception -> 0x05a0 }
            goto L_0x05ab
        L_0x05a0:
            r3 = 1
            java.lang.Object[] r0 = new java.lang.Object[r3]     // Catch:{ Exception -> 0x080f }
            java.lang.String r3 = "showGroupChallengeNotification: Exception in Game Icon"
            r8 = 0
            r0[r8] = r3     // Catch:{ Exception -> 0x080f }
            com.mpl.androidapp.utils.MLogger.e(r2, r0)     // Catch:{ Exception -> 0x080f }
        L_0x05ab:
            org.json.JSONObject r0 = r7.parseResponse(r1)     // Catch:{ Exception -> 0x080f }
            android.content.Intent r0 = buildSendBirdIntent(r15, r0, r13)     // Catch:{ Exception -> 0x080f }
            org.json.JSONObject r3 = r7.parseResponse(r1)     // Catch:{ Exception -> 0x080f }
            android.content.Intent r3 = buildSendBirdIntent(r15, r3, r13)     // Catch:{ Exception -> 0x080f }
            int r8 = java.lang.Integer.parseInt(r19)     // Catch:{ Exception -> 0x080f }
            android.content.Intent r8 = r7.buildTournamentLaunchIntent(r8, r6, r13)     // Catch:{ Exception -> 0x080f }
            r11 = r27
            r0.putExtra(r11, r13)     // Catch:{ Exception -> 0x080f }
            r3.putExtra(r11, r13)     // Catch:{ Exception -> 0x080f }
            r14.putExtra(r11, r13)     // Catch:{ Exception -> 0x080f }
            r8.putExtra(r11, r13)     // Catch:{ Exception -> 0x080f }
            r8 = 67108864(0x4000000, float:1.5046328E-36)
            r14.setFlags(r8)     // Catch:{ Exception -> 0x080f }
            java.lang.String r8 = "Time To Send"
            java.util.Calendar r11 = java.util.Calendar.getInstance()     // Catch:{ Exception -> 0x080f }
            r21 = r12
            long r11 = r11.getTimeInMillis()     // Catch:{ Exception -> 0x080f }
            r14.putExtra(r8, r11)     // Catch:{ Exception -> 0x080f }
            java.lang.String r8 = "Notification Type"
            java.lang.String r11 = "Group Notification"
            r14.putExtra(r8, r11)     // Catch:{ Exception -> 0x080f }
            r8 = 134217728(0x8000000, float:3.85186E-34)
            r11 = 0
            android.app.PendingIntent r12 = android.app.PendingIntent.getActivity(r15, r11, r14, r8)     // Catch:{ Exception -> 0x080f }
            r11 = 1
            android.app.PendingIntent r0 = android.app.PendingIntent.getActivity(r15, r11, r0, r8)     // Catch:{ Exception -> 0x080f }
            r11 = 2
            android.app.PendingIntent r3 = android.app.PendingIntent.getActivity(r15, r11, r3, r8)     // Catch:{ Exception -> 0x080f }
            org.json.JSONObject r11 = r7.parseResponse(r1)     // Catch:{ Exception -> 0x080f }
            buildSendBirdIntent(r15, r11, r13)     // Catch:{ Exception -> 0x080f }
            java.lang.String r11 = "RUMMY"
            boolean r11 = r11.equalsIgnoreCase(r9)     // Catch:{ Exception -> 0x080f }
            if (r11 == 0) goto L_0x0616
            org.json.JSONObject r6 = r7.parseResponse(r1)     // Catch:{ Exception -> 0x080f }
            android.content.Intent r6 = buildSendBirdIntent(r15, r6, r13)     // Catch:{ Exception -> 0x080f }
        L_0x0614:
            r9 = 3
            goto L_0x063b
        L_0x0616:
            java.lang.String r11 = "UGC"
            boolean r9 = r11.equalsIgnoreCase(r9)     // Catch:{ Exception -> 0x080f }
            if (r9 == 0) goto L_0x0632
            r6 = 1
            java.lang.Object[] r9 = new java.lang.Object[r6]     // Catch:{ Exception -> 0x080f }
            java.lang.String r6 = "showGroupChallengeNotification: UGC"
            r11 = 0
            r9[r11] = r6     // Catch:{ Exception -> 0x080f }
            com.mpl.androidapp.utils.MLogger.d(r2, r9)     // Catch:{ Exception -> 0x080f }
            r9 = r20
            r6 = r24
            android.content.Intent r6 = r7.buildContestDetailsIntent(r10, r6, r9, r13)     // Catch:{ Exception -> 0x080f }
            goto L_0x0614
        L_0x0632:
            int r9 = java.lang.Integer.parseInt(r19)     // Catch:{ Exception -> 0x080f }
            android.content.Intent r6 = r7.buildTournamentLaunchIntent(r9, r6, r13)     // Catch:{ Exception -> 0x080f }
            goto L_0x0614
        L_0x063b:
            android.app.PendingIntent r6 = android.app.PendingIntent.getActivity(r15, r9, r6, r8)     // Catch:{ Exception -> 0x080f }
            r8 = 2
            android.net.Uri r9 = android.media.RingtoneManager.getDefaultUri(r8)     // Catch:{ Exception -> 0x080f }
            java.lang.String r8 = "Groups"
            androidx.core.app.NotificationCompat$Builder r8 = r7.getNotificationBuilder(r15, r8)     // Catch:{ Exception -> 0x080f }
            r10 = 2131231343(0x7f08026f, float:1.8078764E38)
            androidx.core.app.NotificationCompat$Builder r8 = r8.setSmallIcon(r10)     // Catch:{ Exception -> 0x080f }
            androidx.core.app.NotificationCompat$Builder r8 = r8.setSound(r9)     // Catch:{ Exception -> 0x080f }
            r9 = 1
            androidx.core.app.NotificationCompat$Builder r8 = r8.setBadgeIconType(r9)     // Catch:{ Exception -> 0x080f }
            androidx.core.app.NotificationCompat$Builder r4 = r8.setCustomContentView(r4)     // Catch:{ Exception -> 0x080f }
            androidx.core.app.NotificationCompat$DecoratedCustomViewStyle r8 = new androidx.core.app.NotificationCompat$DecoratedCustomViewStyle     // Catch:{ Exception -> 0x080f }
            r8.<init>()     // Catch:{ Exception -> 0x080f }
            androidx.core.app.NotificationCompat$Builder r4 = r4.setStyle(r8)     // Catch:{ Exception -> 0x080f }
            r8 = 2
            long[] r9 = new long[r8]     // Catch:{ Exception -> 0x080f }
            r19 = 1000(0x3e8, double:4.94E-321)
            r8 = 0
            r9[r8] = r19     // Catch:{ Exception -> 0x080f }
            r19 = 1000(0x3e8, double:4.94E-321)
            r8 = 1
            r9[r8] = r19     // Catch:{ Exception -> 0x080f }
            androidx.core.app.NotificationCompat$Builder r4 = r4.setVibrate(r9)     // Catch:{ Exception -> 0x080f }
            r8 = -65536(0xffffffffffff0000, float:NaN)
            r9 = 3000(0xbb8, float:4.204E-42)
            r11 = 3000(0xbb8, float:4.204E-42)
            androidx.core.app.NotificationCompat$Builder r4 = r4.setLights(r8, r9, r11)     // Catch:{ Exception -> 0x080f }
            r8 = r29
            androidx.core.app.NotificationCompat$Builder r4 = r4.setGroup(r8)     // Catch:{ Exception -> 0x080f }
            r8 = 0
            androidx.core.app.NotificationCompat$Builder r4 = r4.setGroupAlertBehavior(r8)     // Catch:{ Exception -> 0x080f }
            androidx.core.app.NotificationCompat$Builder r4 = r4.setGroupSummary(r8)     // Catch:{ Exception -> 0x080f }
            androidx.core.app.NotificationCompat$Builder r1 = r4.addExtras(r1)     // Catch:{ Exception -> 0x080f }
            long r8 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x080f }
            r19 = 1000(0x3e8, double:4.94E-321)
            long r8 = r8 + r19
            androidx.core.app.NotificationCompat$Builder r1 = r1.setWhen(r8)     // Catch:{ Exception -> 0x080f }
            r4 = 1
            androidx.core.app.NotificationCompat$Builder r1 = r1.setShowWhen(r4)     // Catch:{ Exception -> 0x080f }
            androidx.core.app.NotificationCompat$Builder r1 = r1.setContentIntent(r12)     // Catch:{ Exception -> 0x080f }
            androidx.core.app.NotificationCompat$Builder r1 = r1.setAutoCancel(r4)     // Catch:{ Exception -> 0x080f }
            androidx.core.app.NotificationCompat$Action$Builder r4 = new androidx.core.app.NotificationCompat$Action$Builder     // Catch:{ Exception -> 0x080f }
            android.content.res.Resources r8 = r36.getResources()     // Catch:{ Exception -> 0x080f }
            r9 = 2131951651(0x7f130023, float:1.9539723E38)
            java.lang.String r8 = r8.getString(r9)     // Catch:{ Exception -> 0x080f }
            r4.<init>(r10, r8, r0)     // Catch:{ Exception -> 0x080f }
            r8 = 0
            androidx.core.app.NotificationCompat$Action$Builder r0 = r4.setShowsUserInterface(r8)     // Catch:{ Exception -> 0x080f }
            r4 = 1
            androidx.core.app.NotificationCompat$Action$Builder r0 = r0.setSemanticAction(r4)     // Catch:{ Exception -> 0x080f }
            androidx.core.app.NotificationCompat$Action$Builder r0 = r0.setAllowGeneratedReplies(r8)     // Catch:{ Exception -> 0x080f }
            androidx.core.app.NotificationCompat$Action r0 = r0.build()     // Catch:{ Exception -> 0x080f }
            android.content.res.Resources r4 = r36.getResources()     // Catch:{ Exception -> 0x080f }
            r8 = 2131952509(0x7f13037d, float:1.9541463E38)
            java.lang.String r4 = r4.getString(r8)     // Catch:{ Exception -> 0x080f }
            if (r23 == 0) goto L_0x06e9
            java.lang.String r8 = r23.toLowerCase()     // Catch:{ Exception -> 0x080f }
            java.lang.String r9 = "channel"
            boolean r8 = r8.equalsIgnoreCase(r9)     // Catch:{ Exception -> 0x080f }
            if (r8 != 0) goto L_0x06f7
        L_0x06e9:
            if (r34 == 0) goto L_0x0702
            java.lang.String r8 = r34.toLowerCase()     // Catch:{ Exception -> 0x080f }
            java.lang.String r9 = "channel"
            boolean r8 = r8.equalsIgnoreCase(r9)     // Catch:{ Exception -> 0x080f }
            if (r8 == 0) goto L_0x0702
        L_0x06f7:
            android.content.res.Resources r4 = r36.getResources()     // Catch:{ Exception -> 0x080f }
            r8 = 2131952508(0x7f13037c, float:1.954146E38)
            java.lang.String r4 = r4.getString(r8)     // Catch:{ Exception -> 0x080f }
        L_0x0702:
            androidx.core.app.NotificationCompat$Action$Builder r8 = new androidx.core.app.NotificationCompat$Action$Builder     // Catch:{ Exception -> 0x080f }
            r8.<init>(r10, r4, r3)     // Catch:{ Exception -> 0x080f }
            r3 = 0
            androidx.core.app.NotificationCompat$Action$Builder r4 = r8.setShowsUserInterface(r3)     // Catch:{ Exception -> 0x080f }
            androidx.core.app.NotificationCompat$Action$Builder r4 = r4.setAllowGeneratedReplies(r3)     // Catch:{ Exception -> 0x080f }
            androidx.core.app.NotificationCompat$Action r3 = r4.build()     // Catch:{ Exception -> 0x080f }
            androidx.core.app.NotificationCompat$Action$Builder r4 = new androidx.core.app.NotificationCompat$Action$Builder     // Catch:{ Exception -> 0x080f }
            android.content.res.Resources r8 = r36.getResources()     // Catch:{ Exception -> 0x080f }
            r9 = 2131951650(0x7f130022, float:1.953972E38)
            java.lang.String r8 = r8.getString(r9)     // Catch:{ Exception -> 0x080f }
            r4.<init>(r10, r8, r6)     // Catch:{ Exception -> 0x080f }
            r6 = 0
            androidx.core.app.NotificationCompat$Action$Builder r4 = r4.setShowsUserInterface(r6)     // Catch:{ Exception -> 0x080f }
            androidx.core.app.NotificationCompat$Action$Builder r4 = r4.setAllowGeneratedReplies(r6)     // Catch:{ Exception -> 0x080f }
            androidx.core.app.NotificationCompat$Action r4 = r4.build()     // Catch:{ Exception -> 0x080f }
            r6 = 26
            if (r23 == 0) goto L_0x07de
            boolean r8 = android.text.TextUtils.isEmpty(r23)     // Catch:{ Exception -> 0x080f }
            if (r8 != 0) goto L_0x07de
            java.lang.String r8 = "USER_REMOVED"
            r9 = r23
            boolean r8 = r9.equalsIgnoreCase(r8)     // Catch:{ Exception -> 0x080f }
            if (r8 != 0) goto L_0x0755
            java.lang.String r8 = "GROUP_CHALLENGE_FINISHED"
            boolean r8 = r9.equalsIgnoreCase(r8)     // Catch:{ Exception -> 0x080f }
            if (r8 != 0) goto L_0x0755
            r1.setCustomHeadsUpContentView(r5)     // Catch:{ Exception -> 0x080f }
            r8 = r21
            r1.setCustomBigContentView(r8)     // Catch:{ Exception -> 0x080f }
        L_0x0755:
            java.lang.String r5 = r9.toUpperCase()     // Catch:{ Exception -> 0x080f }
            r8 = -1
            int r9 = r5.hashCode()     // Catch:{ Exception -> 0x080f }
            switch(r9) {
                case -976032916: goto L_0x0780;
                case 45385422: goto L_0x0776;
                case 81918188: goto L_0x076c;
                case 575157196: goto L_0x0762;
                default: goto L_0x0761;
            }     // Catch:{ Exception -> 0x080f }
        L_0x0761:
            goto L_0x078a
        L_0x0762:
            java.lang.String r9 = "USER_REMOVED"
            boolean r5 = r5.equals(r9)     // Catch:{ Exception -> 0x080f }
            if (r5 == 0) goto L_0x078a
            r10 = 3
            goto L_0x078b
        L_0x076c:
            java.lang.String r9 = "GROUP_CHALLENGE_CREATED"
            boolean r5 = r5.equals(r9)     // Catch:{ Exception -> 0x080f }
            if (r5 == 0) goto L_0x078a
            r10 = 1
            goto L_0x078b
        L_0x0776:
            java.lang.String r9 = "GROUP_CHALLENGE_FINISHED"
            boolean r5 = r5.equals(r9)     // Catch:{ Exception -> 0x080f }
            if (r5 == 0) goto L_0x078a
            r10 = 2
            goto L_0x078b
        L_0x0780:
            java.lang.String r9 = "USER_ADDED"
            boolean r5 = r5.equals(r9)     // Catch:{ Exception -> 0x080f }
            if (r5 == 0) goto L_0x078a
            r10 = 0
            goto L_0x078b
        L_0x078a:
            r10 = -1
        L_0x078b:
            if (r10 == 0) goto L_0x07ca
            r5 = 1
            if (r10 == r5) goto L_0x07bb
            r5 = 2
            if (r10 == r5) goto L_0x07ad
            r4 = 3
            if (r10 == r4) goto L_0x07ad
            int r4 = android.os.Build.VERSION.SDK_INT     // Catch:{ Exception -> 0x080f }
            if (r4 >= r6) goto L_0x07a1
            int r4 = r35.getPriority()     // Catch:{ Exception -> 0x080f }
            r1.setPriority(r4)     // Catch:{ Exception -> 0x080f }
        L_0x07a1:
            r1.addAction(r0)     // Catch:{ Exception -> 0x080f }
            r1.addAction(r3)     // Catch:{ Exception -> 0x080f }
            r14 = r31
            r1.setSubText(r14)     // Catch:{ Exception -> 0x080f }
            goto L_0x07fc
        L_0x07ad:
            r14 = r31
            int r0 = android.os.Build.VERSION.SDK_INT     // Catch:{ Exception -> 0x080f }
            if (r0 >= r6) goto L_0x07b7
            r0 = -1
            r1.setPriority(r0)     // Catch:{ Exception -> 0x080f }
        L_0x07b7:
            r1.setSubText(r14)     // Catch:{ Exception -> 0x080f }
            goto L_0x07fc
        L_0x07bb:
            int r0 = android.os.Build.VERSION.SDK_INT     // Catch:{ Exception -> 0x080f }
            if (r0 >= r6) goto L_0x07c6
            int r0 = r35.getPriority()     // Catch:{ Exception -> 0x080f }
            r1.setPriority(r0)     // Catch:{ Exception -> 0x080f }
        L_0x07c6:
            r1.addAction(r4)     // Catch:{ Exception -> 0x080f }
            goto L_0x07fc
        L_0x07ca:
            r14 = r31
            int r0 = android.os.Build.VERSION.SDK_INT     // Catch:{ Exception -> 0x080f }
            if (r0 >= r6) goto L_0x07d7
            int r0 = r35.getPriority()     // Catch:{ Exception -> 0x080f }
            r1.setPriority(r0)     // Catch:{ Exception -> 0x080f }
        L_0x07d7:
            r1.addAction(r3)     // Catch:{ Exception -> 0x080f }
            r1.setSubText(r14)     // Catch:{ Exception -> 0x080f }
            goto L_0x07fc
        L_0x07de:
            r8 = r21
            r14 = r31
            r1.setCustomHeadsUpContentView(r5)     // Catch:{ Exception -> 0x080f }
            r1.setCustomBigContentView(r8)     // Catch:{ Exception -> 0x080f }
            int r4 = android.os.Build.VERSION.SDK_INT     // Catch:{ Exception -> 0x080f }
            if (r4 >= r6) goto L_0x07f3
            int r4 = r35.getPriority()     // Catch:{ Exception -> 0x080f }
            r1.setPriority(r4)     // Catch:{ Exception -> 0x080f }
        L_0x07f3:
            r1.addAction(r0)     // Catch:{ Exception -> 0x080f }
            r1.addAction(r3)     // Catch:{ Exception -> 0x080f }
            r1.setSubText(r14)     // Catch:{ Exception -> 0x080f }
        L_0x07fc:
            java.lang.String r0 = ""
            android.app.Notification r4 = r1.build()     // Catch:{ Exception -> 0x080f }
            r5 = 0
            r6 = 1
            r1 = r35
            r8 = r2
            r2 = r0
            r3 = r13
            r1.notifyNotification(r2, r3, r4, r5, r6)     // Catch:{ Exception -> 0x080d }
            goto L_0x0830
        L_0x080d:
            r0 = move-exception
            goto L_0x0822
        L_0x080f:
            r0 = move-exception
            goto L_0x0814
        L_0x0811:
            r0 = move-exception
            r7 = r35
        L_0x0814:
            r8 = r2
            goto L_0x0822
        L_0x0816:
            r0 = move-exception
            r7 = r35
            r8 = r30
            goto L_0x0822
        L_0x081c:
            r0 = move-exception
            r7 = r35
            goto L_0x0821
        L_0x0820:
            r0 = move-exception
        L_0x0821:
            r8 = r10
        L_0x0822:
            r1 = 2
            java.lang.Object[] r1 = new java.lang.Object[r1]
            java.lang.String r2 = "showGroupEventNotification: "
            r3 = 0
            r1[r3] = r2
            r2 = 1
            r1[r2] = r0
            com.mpl.androidapp.utils.MLogger.e(r8, r1)
        L_0x0830:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mpl.androidapp.notification.NotificationBuilder.lambda$showGroupChallengeNotification$10$NotificationBuilder(android.content.Context, android.os.Bundle):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:100:0x01ac A[Catch:{ Exception -> 0x05ba }] */
    /* JADX WARNING: Removed duplicated region for block: B:101:0x01b5 A[Catch:{ Exception -> 0x05ba }] */
    /* JADX WARNING: Removed duplicated region for block: B:104:0x01c0 A[Catch:{ Exception -> 0x05ba }] */
    /* JADX WARNING: Removed duplicated region for block: B:107:0x01cb A[Catch:{ Exception -> 0x05ba }] */
    /* JADX WARNING: Removed duplicated region for block: B:132:0x0232 A[Catch:{ Exception -> 0x05ba }] */
    /* JADX WARNING: Removed duplicated region for block: B:140:0x024c A[Catch:{ Exception -> 0x05ba }] */
    /* JADX WARNING: Removed duplicated region for block: B:141:0x0250 A[Catch:{ Exception -> 0x05ba }] */
    /* JADX WARNING: Removed duplicated region for block: B:157:0x02a2 A[Catch:{ Exception -> 0x05ba }] */
    /* JADX WARNING: Removed duplicated region for block: B:164:0x02d3 A[Catch:{ Exception -> 0x05ba }] */
    /* JADX WARNING: Removed duplicated region for block: B:209:0x043f A[Catch:{ Exception -> 0x05b8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:210:0x0442 A[Catch:{ Exception -> 0x05b8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:221:0x052d A[Catch:{ Exception -> 0x05b8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:253:0x0599 A[Catch:{ Exception -> 0x05b8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:256:0x05a8 A[Catch:{ Exception -> 0x05b8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x0155 A[Catch:{ Exception -> 0x05ba }] */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x015c A[Catch:{ Exception -> 0x05ba }] */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x0163 A[Catch:{ Exception -> 0x05ba }] */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x0168 A[Catch:{ Exception -> 0x05ba }] */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x0170 A[Catch:{ Exception -> 0x05ba }] */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x0175 A[Catch:{ Exception -> 0x05ba }] */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x017d A[Catch:{ Exception -> 0x05ba }] */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x018e A[Catch:{ Exception -> 0x05ba }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ void lambda$showGroupEventNotification$9$NotificationBuilder(android.os.Bundle r29, android.content.Context r30) {
        /*
            r28 = this;
            r7 = r28
            r0 = r29
            r1 = r30
            java.lang.String r2 = "requester"
            java.lang.String r3 = "action_notification_id"
            java.lang.String r4 = "body"
            java.lang.String r5 = "title"
            java.lang.String r6 = "data"
            java.lang.String r8 = "displayName"
            java.lang.String r9 = "channelUrl"
            java.lang.String r10 = "avatar"
            java.lang.String r11 = "NotificationBuilder"
            r13 = 1
            r14 = 0
            boolean r15 = r28.isDeviceAndCountrySupported(r29)     // Catch:{ Exception -> 0x05ba }
            if (r15 != 0) goto L_0x002a
            java.lang.Object[] r0 = new java.lang.Object[r13]     // Catch:{ Exception -> 0x05ba }
            java.lang.String r1 = "Device or Country is not supported"
            r0[r14] = r1     // Catch:{ Exception -> 0x05ba }
            com.mpl.androidapp.utils.MLogger.e(r11, r0)     // Catch:{ Exception -> 0x05ba }
            return
        L_0x002a:
            android.widget.RemoteViews r15 = new android.widget.RemoteViews     // Catch:{ Exception -> 0x05ba }
            java.lang.String r12 = r30.getPackageName()     // Catch:{ Exception -> 0x05ba }
            r13 = 2131558762(0x7f0d016a, float:1.8742849E38)
            r15.<init>(r12, r13)     // Catch:{ Exception -> 0x05ba }
            android.widget.RemoteViews r12 = new android.widget.RemoteViews     // Catch:{ Exception -> 0x05ba }
            java.lang.String r13 = r30.getPackageName()     // Catch:{ Exception -> 0x05ba }
            r14 = 2131558757(0x7f0d0165, float:1.8742839E38)
            r12.<init>(r13, r14)     // Catch:{ Exception -> 0x05ba }
            android.widget.RemoteViews r13 = new android.widget.RemoteViews     // Catch:{ Exception -> 0x05ba }
            java.lang.String r14 = r30.getPackageName()     // Catch:{ Exception -> 0x05ba }
            r16 = r12
            r12 = 2131558761(0x7f0d0169, float:1.8742847E38)
            r13.<init>(r14, r12)     // Catch:{ Exception -> 0x05ba }
            java.lang.String r12 = "showInBackground"
            boolean r12 = r0.containsKey(r12)     // Catch:{ Exception -> 0x05ba }
            if (r12 == 0) goto L_0x0063
            java.lang.String r12 = "showInBackground"
            java.lang.String r12 = r0.getString(r12)     // Catch:{ Exception -> 0x05ba }
            boolean r12 = java.lang.Boolean.parseBoolean(r12)     // Catch:{ Exception -> 0x05ba }
            goto L_0x0064
        L_0x0063:
            r12 = 1
        L_0x0064:
            java.lang.String r14 = "unread_message_count"
            boolean r14 = r0.containsKey(r14)     // Catch:{ Exception -> 0x05ba }
            if (r14 == 0) goto L_0x0076
            java.lang.String r14 = "unread_message_count"
            r17 = r12
            r12 = 0
            int r14 = r0.getInt(r14, r12)     // Catch:{ Exception -> 0x05ba }
            goto L_0x0079
        L_0x0076:
            r17 = r12
            r14 = 0
        L_0x0079:
            java.lang.String r12 = "gameType"
            boolean r12 = r0.containsKey(r12)     // Catch:{ Exception -> 0x05ba }
            r18 = r13
            java.lang.String r13 = ""
            if (r12 == 0) goto L_0x008c
            java.lang.String r12 = "gameType"
            java.lang.String r12 = r0.getString(r12, r13)     // Catch:{ Exception -> 0x05ba }
            goto L_0x008d
        L_0x008c:
            r12 = r13
        L_0x008d:
            boolean r19 = r0.containsKey(r5)     // Catch:{ Exception -> 0x05ba }
            if (r19 == 0) goto L_0x009e
            java.lang.String r19 = r0.getString(r5)     // Catch:{ Exception -> 0x05ba }
            r27 = r19
            r19 = r15
            r15 = r27
            goto L_0x00a1
        L_0x009e:
            r19 = r15
            r15 = r13
        L_0x00a1:
            boolean r20 = r0.containsKey(r9)     // Catch:{ Exception -> 0x05ba }
            if (r20 == 0) goto L_0x00ac
            java.lang.String r20 = r0.getString(r9)     // Catch:{ Exception -> 0x05ba }
            goto L_0x00ae
        L_0x00ac:
            r20 = r13
        L_0x00ae:
            boolean r21 = android.text.TextUtils.isEmpty(r20)     // Catch:{ Exception -> 0x05ba }
            if (r21 == 0) goto L_0x00c2
            java.lang.String r1 = "groupUrl"
            boolean r1 = r0.containsKey(r1)     // Catch:{ Exception -> 0x05ba }
            if (r1 == 0) goto L_0x00c2
            java.lang.String r1 = "groupUrl"
            java.lang.String r20 = r0.getString(r1)     // Catch:{ Exception -> 0x05ba }
        L_0x00c2:
            r1 = r20
            boolean r20 = r0.containsKey(r9)     // Catch:{ Exception -> 0x05ba }
            if (r20 != 0) goto L_0x00d3
            boolean r20 = android.text.TextUtils.isEmpty(r1)     // Catch:{ Exception -> 0x05ba }
            if (r20 != 0) goto L_0x00d3
            r0.putString(r9, r1)     // Catch:{ Exception -> 0x05ba }
        L_0x00d3:
            r9 = 4
            if (r14 <= r9) goto L_0x00da
            r7.createNotificationMoreThanFiveUnreadMessages(r14)     // Catch:{ Exception -> 0x05ba }
            return
        L_0x00da:
            java.lang.String r9 = "groupIcon"
            boolean r9 = r0.containsKey(r9)     // Catch:{ Exception -> 0x05ba }
            if (r9 == 0) goto L_0x00e9
            java.lang.String r9 = "groupIcon"
            java.lang.String r9 = r0.getString(r9)     // Catch:{ Exception -> 0x05ba }
            goto L_0x00ea
        L_0x00e9:
            r9 = r13
        L_0x00ea:
            boolean r14 = android.text.TextUtils.isEmpty(r9)     // Catch:{ Exception -> 0x05ba }
            if (r14 == 0) goto L_0x00fe
            java.lang.String r14 = "groupImage"
            boolean r14 = r0.containsKey(r14)     // Catch:{ Exception -> 0x05ba }
            if (r14 == 0) goto L_0x00fe
            java.lang.String r9 = "groupImage"
            java.lang.String r9 = r0.getString(r9)     // Catch:{ Exception -> 0x05ba }
        L_0x00fe:
            java.lang.String r14 = "groupAction"
            boolean r14 = r0.containsKey(r14)     // Catch:{ Exception -> 0x05ba }
            if (r14 == 0) goto L_0x010d
            java.lang.String r14 = "groupAction"
            java.lang.String r14 = r0.getString(r14)     // Catch:{ Exception -> 0x05ba }
            goto L_0x010e
        L_0x010d:
            r14 = r13
        L_0x010e:
            boolean r20 = android.text.TextUtils.isEmpty(r14)     // Catch:{ Exception -> 0x05ba }
            if (r20 == 0) goto L_0x0125
            r20 = r9
            java.lang.String r9 = "eventType"
            boolean r9 = r0.containsKey(r9)     // Catch:{ Exception -> 0x05ba }
            if (r9 == 0) goto L_0x0127
            java.lang.String r9 = "eventType"
            java.lang.String r14 = r0.getString(r9, r13)     // Catch:{ Exception -> 0x05ba }
            goto L_0x0127
        L_0x0125:
            r20 = r9
        L_0x0127:
            boolean r9 = android.text.TextUtils.isEmpty(r13)     // Catch:{ Exception -> 0x05ba }
            r21 = r12
            java.lang.String r12 = "type"
            if (r9 == 0) goto L_0x013c
            boolean r9 = r0.containsKey(r12)     // Catch:{ Exception -> 0x05ba }
            if (r9 == 0) goto L_0x013c
            java.lang.String r9 = r0.getString(r12, r13)     // Catch:{ Exception -> 0x05ba }
            goto L_0x013d
        L_0x013c:
            r9 = r13
        L_0x013d:
            boolean r22 = android.text.TextUtils.isEmpty(r14)     // Catch:{ Exception -> 0x05ba }
            if (r22 == 0) goto L_0x014d
            boolean r22 = r0.containsKey(r12)     // Catch:{ Exception -> 0x05ba }
            if (r22 == 0) goto L_0x014d
            java.lang.String r14 = r0.getString(r12, r13)     // Catch:{ Exception -> 0x05ba }
        L_0x014d:
            java.lang.String r12 = "groupName"
            boolean r12 = r0.containsKey(r12)     // Catch:{ Exception -> 0x05ba }
            if (r12 == 0) goto L_0x015c
            java.lang.String r12 = "groupName"
            java.lang.String r12 = r0.getString(r12, r13)     // Catch:{ Exception -> 0x05ba }
            goto L_0x015d
        L_0x015c:
            r12 = r13
        L_0x015d:
            boolean r22 = r0.containsKey(r4)     // Catch:{ Exception -> 0x05ba }
            if (r22 == 0) goto L_0x0168
            java.lang.String r22 = r0.getString(r4)     // Catch:{ Exception -> 0x05ba }
            goto L_0x016a
        L_0x0168:
            r22 = r13
        L_0x016a:
            boolean r23 = r0.containsKey(r10)     // Catch:{ Exception -> 0x05ba }
            if (r23 == 0) goto L_0x0175
            java.lang.String r23 = r0.getString(r10)     // Catch:{ Exception -> 0x05ba }
            goto L_0x0177
        L_0x0175:
            r23 = r13
        L_0x0177:
            boolean r24 = android.text.TextUtils.isEmpty(r23)     // Catch:{ Exception -> 0x05ba }
            if (r24 == 0) goto L_0x018e
            r24 = r9
            java.lang.String r9 = "bigIcon"
            boolean r9 = r0.containsKey(r9)     // Catch:{ Exception -> 0x05ba }
            if (r9 == 0) goto L_0x0190
            java.lang.String r9 = "bigIcon"
            java.lang.String r23 = r0.getString(r9)     // Catch:{ Exception -> 0x05ba }
            goto L_0x0190
        L_0x018e:
            r24 = r9
        L_0x0190:
            boolean r9 = android.text.TextUtils.isEmpty(r23)     // Catch:{ Exception -> 0x05ba }
            if (r9 == 0) goto L_0x01a4
            java.lang.String r9 = "largeIcon"
            boolean r9 = r0.containsKey(r9)     // Catch:{ Exception -> 0x05ba }
            if (r9 == 0) goto L_0x01a4
            java.lang.String r9 = "largeIcon"
            java.lang.String r23 = r0.getString(r9)     // Catch:{ Exception -> 0x05ba }
        L_0x01a4:
            java.lang.String r9 = "inviter"
            boolean r9 = r0.containsKey(r9)     // Catch:{ Exception -> 0x05ba }
            if (r9 == 0) goto L_0x01b5
            java.lang.String r9 = "inviter"
            java.lang.String r9 = r0.getString(r9, r13)     // Catch:{ Exception -> 0x05ba }
            r25 = r4
            goto L_0x01b8
        L_0x01b5:
            r25 = r4
            r9 = r13
        L_0x01b8:
            java.lang.String r4 = "invitee"
            boolean r4 = r0.containsKey(r4)     // Catch:{ Exception -> 0x05ba }
            if (r4 == 0) goto L_0x01c5
            java.lang.String r4 = "invitee"
            r0.getString(r4, r13)     // Catch:{ Exception -> 0x05ba }
        L_0x01c5:
            boolean r4 = android.text.TextUtils.isEmpty(r9)     // Catch:{ Exception -> 0x05ba }
            if (r4 != 0) goto L_0x0232
            org.json.JSONObject r4 = new org.json.JSONObject     // Catch:{ Exception -> 0x05ba }
            r4.<init>(r9)     // Catch:{ Exception -> 0x05ba }
            boolean r9 = android.text.TextUtils.isEmpty(r23)     // Catch:{ Exception -> 0x05ba }
            if (r9 == 0) goto L_0x01e4
            java.lang.String r9 = "avatarUrl"
            boolean r9 = r4.has(r9)     // Catch:{ Exception -> 0x05ba }
            if (r9 == 0) goto L_0x01e4
            java.lang.String r9 = "avatarUrl"
            java.lang.String r23 = r4.optString(r9, r13)     // Catch:{ Exception -> 0x05ba }
        L_0x01e4:
            boolean r9 = r4.has(r8)     // Catch:{ Exception -> 0x05ba }
            if (r9 == 0) goto L_0x01ef
            java.lang.String r9 = r4.optString(r8, r13)     // Catch:{ Exception -> 0x05ba }
            goto L_0x01f0
        L_0x01ef:
            r9 = r13
        L_0x01f0:
            boolean r26 = r4.has(r8)     // Catch:{ Exception -> 0x05ba }
            if (r26 == 0) goto L_0x01fa
            java.lang.String r9 = r4.optString(r8, r13)     // Catch:{ Exception -> 0x05ba }
        L_0x01fa:
            java.lang.String r8 = "userId"
            boolean r8 = r4.has(r8)     // Catch:{ Exception -> 0x05ba }
            if (r8 == 0) goto L_0x020c
            java.lang.String r8 = "userId"
            r26 = r5
            r5 = 0
            int r4 = r4.optInt(r8, r5)     // Catch:{ Exception -> 0x05ba }
            goto L_0x020f
        L_0x020c:
            r26 = r5
            r4 = 0
        L_0x020f:
            if (r4 == 0) goto L_0x0234
            java.lang.String r4 = java.lang.String.valueOf(r4)     // Catch:{ Exception -> 0x05ba }
            java.lang.String r4 = com.mpl.androidapp.contact.ContactUtils.getNameFromLocalDbFromUserId(r4)     // Catch:{ Exception -> 0x05ba }
            boolean r5 = android.text.TextUtils.isEmpty(r4)     // Catch:{ Exception -> 0x05ba }
            if (r5 != 0) goto L_0x0234
            if (r15 == 0) goto L_0x0234
            boolean r5 = android.text.TextUtils.isEmpty(r15)     // Catch:{ Exception -> 0x05ba }
            if (r5 != 0) goto L_0x0234
            boolean r5 = r15.contains(r9)     // Catch:{ Exception -> 0x05ba }
            if (r5 == 0) goto L_0x0234
            java.lang.String r15 = r15.replace(r9, r4)     // Catch:{ Exception -> 0x05ba }
            goto L_0x0234
        L_0x0232:
            r26 = r5
        L_0x0234:
            boolean r4 = android.text.TextUtils.isEmpty(r22)     // Catch:{ Exception -> 0x05ba }
            if (r4 == 0) goto L_0x0242
            boolean r4 = android.text.TextUtils.isEmpty(r12)     // Catch:{ Exception -> 0x05ba }
            if (r4 != 0) goto L_0x0242
            r22 = r12
        L_0x0242:
            int r4 = r7.getGroupNotificationId(r1)     // Catch:{ Exception -> 0x05ba }
            boolean r5 = r0.containsKey(r3)     // Catch:{ Exception -> 0x05ba }
            if (r5 != 0) goto L_0x0250
            r0.putInt(r3, r4)     // Catch:{ Exception -> 0x05ba }
            goto L_0x025b
        L_0x0250:
            r5 = 1
            java.lang.Object[] r8 = new java.lang.Object[r5]     // Catch:{ Exception -> 0x05ba }
            java.lang.String r5 = "showGroupEventNotification:already having notification ID "
            r9 = 0
            r8[r9] = r5     // Catch:{ Exception -> 0x05ba }
            com.mpl.androidapp.utils.MLogger.d(r11, r8)     // Catch:{ Exception -> 0x05ba }
        L_0x025b:
            if (r14 == 0) goto L_0x02d6
            java.lang.String r5 = "collectible"
            boolean r5 = r14.equalsIgnoreCase(r5)     // Catch:{ Exception -> 0x05ba }
            if (r5 == 0) goto L_0x02d6
            boolean r5 = r0.containsKey(r6)     // Catch:{ Exception -> 0x05ba }
            if (r5 == 0) goto L_0x02d6
            java.lang.String r5 = r0.getString(r6)     // Catch:{ Exception -> 0x05ba }
            boolean r5 = android.text.TextUtils.isEmpty(r5)     // Catch:{ Exception -> 0x05ba }
            if (r5 != 0) goto L_0x02d6
            java.lang.String r5 = r0.getString(r6)     // Catch:{ Exception -> 0x05ba }
            boolean r5 = com.mpl.androidapp.utils.CommonUtils.isJSONValid(r5)     // Catch:{ Exception -> 0x05ba }
            if (r5 == 0) goto L_0x02d6
            org.json.JSONObject r5 = new org.json.JSONObject     // Catch:{ Exception -> 0x05ba }
            java.lang.String r6 = r0.getString(r6)     // Catch:{ Exception -> 0x05ba }
            r5.<init>(r6)     // Catch:{ Exception -> 0x05ba }
            boolean r6 = r5.has(r2)     // Catch:{ Exception -> 0x05ba }
            if (r6 == 0) goto L_0x02d6
            java.lang.String r6 = r5.optString(r2)     // Catch:{ Exception -> 0x05ba }
            boolean r6 = android.text.TextUtils.isEmpty(r6)     // Catch:{ Exception -> 0x05ba }
            if (r6 != 0) goto L_0x02d6
            java.lang.String r2 = r5.optString(r2, r13)     // Catch:{ Exception -> 0x05ba }
            boolean r6 = android.text.TextUtils.isEmpty(r2)     // Catch:{ Exception -> 0x05ba }
            if (r6 != 0) goto L_0x02bb
            org.json.JSONObject r6 = new org.json.JSONObject     // Catch:{ Exception -> 0x05ba }
            r6.<init>(r2)     // Catch:{ Exception -> 0x05ba }
            boolean r2 = r6.has(r10)     // Catch:{ Exception -> 0x05ba }
            if (r2 == 0) goto L_0x02bb
            java.lang.String r2 = r6.optString(r10)     // Catch:{ Exception -> 0x05ba }
            boolean r2 = android.text.TextUtils.isEmpty(r2)     // Catch:{ Exception -> 0x05ba }
            if (r2 != 0) goto L_0x02bb
            java.lang.String r23 = r6.optString(r10)     // Catch:{ Exception -> 0x05ba }
        L_0x02bb:
            java.lang.String r2 = "imageUrl"
            java.lang.String r9 = r5.optString(r2, r13)     // Catch:{ Exception -> 0x05ba }
            r2 = r26
            java.lang.String r15 = r5.optString(r2, r13)     // Catch:{ Exception -> 0x05ba }
            r2 = r25
            java.lang.String r22 = r5.optString(r2, r13)     // Catch:{ Exception -> 0x05ba }
            boolean r2 = android.text.TextUtils.isEmpty(r22)     // Catch:{ Exception -> 0x05ba }
            if (r2 == 0) goto L_0x02d8
            java.lang.String r22 = "Tap to view"
            goto L_0x02d8
        L_0x02d6:
            r9 = r20
        L_0x02d8:
            r2 = r22
            r5 = r23
            boolean r6 = android.text.TextUtils.isEmpty(r21)     // Catch:{ Exception -> 0x05ba }
            if (r6 != 0) goto L_0x031b
            java.lang.String r6 = "UGC"
            r13 = r21
            boolean r6 = r6.equalsIgnoreCase(r13)     // Catch:{ Exception -> 0x05ba }
            if (r6 == 0) goto L_0x031b
            java.lang.String r6 = "extraInfo"
            boolean r6 = r0.containsKey(r6)     // Catch:{ Exception -> 0x05ba }
            if (r6 == 0) goto L_0x031b
            java.lang.String r6 = "extraInfo"
            java.lang.String r8 = "{}"
            java.lang.String r6 = r0.getString(r6, r8)     // Catch:{ Exception -> 0x05ba }
            org.json.JSONObject r8 = new org.json.JSONObject     // Catch:{ Exception -> 0x05ba }
            r8.<init>(r6)     // Catch:{ Exception -> 0x05ba }
            java.lang.String r10 = "contestId"
            r13 = 0
            r8.optInt(r10, r13)     // Catch:{ Exception -> 0x05ba }
            org.json.JSONObject r8 = new org.json.JSONObject     // Catch:{ Exception -> 0x05ba }
            r8.<init>(r6)     // Catch:{ Exception -> 0x05ba }
            java.lang.String r10 = "sportId"
            r8.optInt(r10, r13)     // Catch:{ Exception -> 0x05ba }
            org.json.JSONObject r8 = new org.json.JSONObject     // Catch:{ Exception -> 0x05ba }
            r8.<init>(r6)     // Catch:{ Exception -> 0x05ba }
            java.lang.String r6 = "matchId"
            r8.optInt(r6, r13)     // Catch:{ Exception -> 0x05ba }
        L_0x031b:
            org.json.JSONObject r6 = r28.parseResponse(r29)     // Catch:{ Exception -> 0x05ba }
            r8 = r30
            android.content.Intent r6 = buildSendBirdIntent(r8, r6, r4)     // Catch:{ Exception -> 0x05ba }
            if (r14 == 0) goto L_0x0339
            boolean r10 = android.text.TextUtils.isEmpty(r14)     // Catch:{ Exception -> 0x05ba }
            if (r10 != 0) goto L_0x0339
            java.lang.String r10 = "USER_REMOVED"
            boolean r10 = r10.equalsIgnoreCase(r14)     // Catch:{ Exception -> 0x05ba }
            if (r10 == 0) goto L_0x0339
            android.content.Intent r6 = r7.buildChatListIntent(r4)     // Catch:{ Exception -> 0x05ba }
        L_0x0339:
            r10 = 2131362915(0x7f0a0463, float:1.8345624E38)
            r13 = r19
            r13.setTextViewText(r10, r15)     // Catch:{ Exception -> 0x05ba }
            r10 = 2131362910(0x7f0a045e, float:1.8345614E38)
            r13.setTextViewText(r10, r2)     // Catch:{ Exception -> 0x05ba }
            r10 = r16
            r0 = 2131362915(0x7f0a0463, float:1.8345624E38)
            r10.setTextViewText(r0, r15)     // Catch:{ Exception -> 0x05ba }
            r0 = 2131362910(0x7f0a045e, float:1.8345614E38)
            r10.setTextViewText(r0, r2)     // Catch:{ Exception -> 0x05ba }
            r16 = r12
            r0 = r18
            r12 = 2131362915(0x7f0a0463, float:1.8345624E38)
            r0.setTextViewText(r12, r15)     // Catch:{ Exception -> 0x05ba }
            r12 = 2131362910(0x7f0a045e, float:1.8345614E38)
            r0.setTextViewText(r12, r2)     // Catch:{ Exception -> 0x05ba }
            r2 = 2
            java.lang.Object[] r12 = new java.lang.Object[r2]     // Catch:{ Exception -> 0x05ba }
            java.lang.String r2 = "showGroupEventNotification:eventType "
            r15 = 0
            r12[r15] = r2     // Catch:{ Exception -> 0x05ba }
            r2 = 1
            r12[r2] = r14     // Catch:{ Exception -> 0x05ba }
            com.mpl.androidapp.utils.MLogger.d(r11, r12)     // Catch:{ Exception -> 0x05ba }
            r2 = 10000(0x2710, float:1.4013E-41)
            boolean r12 = android.text.TextUtils.isEmpty(r5)     // Catch:{ Exception -> 0x03b7 }
            if (r12 != 0) goto L_0x03c2
            java.lang.String r12 = ".circlevtw"
            boolean r12 = r12.equalsIgnoreCase(r5)     // Catch:{ Exception -> 0x03b7 }
            if (r12 != 0) goto L_0x03c2
            boolean r12 = android.webkit.URLUtil.isValidUrl(r5)     // Catch:{ Exception -> 0x03b7 }
            if (r12 == 0) goto L_0x03c2
            java.net.URL r12 = new java.net.URL     // Catch:{ Exception -> 0x03b7 }
            r12.<init>(r5)     // Catch:{ Exception -> 0x03b7 }
            java.net.URLConnection r5 = r12.openConnection()     // Catch:{ Exception -> 0x03b7 }
            java.lang.Object r5 = com.google.firebase.perf.network.FirebasePerfUrlConnection.instrument(r5)     // Catch:{ Exception -> 0x03b7 }
            java.net.URLConnection r5 = (java.net.URLConnection) r5     // Catch:{ Exception -> 0x03b7 }
            r5.setConnectTimeout(r2)     // Catch:{ Exception -> 0x03b7 }
            r5.setReadTimeout(r2)     // Catch:{ Exception -> 0x03b7 }
            java.io.InputStream r5 = r5.getInputStream()     // Catch:{ Exception -> 0x03b7 }
            android.graphics.Bitmap r5 = android.graphics.BitmapFactory.decodeStream(r5)     // Catch:{ Exception -> 0x03b7 }
            android.graphics.Bitmap r5 = com.mpl.androidapp.utils.CommonUtils.getCircularBitmap(r5)     // Catch:{ Exception -> 0x03b7 }
            r12 = 2131362914(0x7f0a0462, float:1.8345622E38)
            r13.setImageViewBitmap(r12, r5)     // Catch:{ Exception -> 0x03b7 }
            r10.setImageViewBitmap(r12, r5)     // Catch:{ Exception -> 0x03b7 }
            r0.setImageViewBitmap(r12, r5)     // Catch:{ Exception -> 0x03b7 }
            goto L_0x03c2
        L_0x03b7:
            r5 = 1
            java.lang.Object[] r12 = new java.lang.Object[r5]     // Catch:{ Exception -> 0x05ba }
            java.lang.String r5 = "showGroupEventNotification: Exception in Avtar creation"
            r15 = 0
            r12[r15] = r5     // Catch:{ Exception -> 0x05ba }
            com.mpl.androidapp.utils.MLogger.e(r11, r12)     // Catch:{ Exception -> 0x05ba }
        L_0x03c2:
            boolean r5 = android.text.TextUtils.isEmpty(r9)     // Catch:{ Exception -> 0x03fc }
            if (r5 != 0) goto L_0x0407
            boolean r5 = android.webkit.URLUtil.isValidUrl(r9)     // Catch:{ Exception -> 0x03fc }
            if (r5 == 0) goto L_0x0407
            java.net.URL r5 = new java.net.URL     // Catch:{ Exception -> 0x03fc }
            r5.<init>(r9)     // Catch:{ Exception -> 0x03fc }
            java.net.URLConnection r5 = r5.openConnection()     // Catch:{ Exception -> 0x03fc }
            java.lang.Object r5 = com.google.firebase.perf.network.FirebasePerfUrlConnection.instrument(r5)     // Catch:{ Exception -> 0x03fc }
            java.net.URLConnection r5 = (java.net.URLConnection) r5     // Catch:{ Exception -> 0x03fc }
            r5.setConnectTimeout(r2)     // Catch:{ Exception -> 0x03fc }
            r5.setReadTimeout(r2)     // Catch:{ Exception -> 0x03fc }
            java.io.InputStream r2 = r5.getInputStream()     // Catch:{ Exception -> 0x03fc }
            android.graphics.Bitmap r2 = android.graphics.BitmapFactory.decodeStream(r2)     // Catch:{ Exception -> 0x03fc }
            android.graphics.Bitmap r2 = com.mpl.androidapp.utils.CommonUtils.getCircularBitmap(r2)     // Catch:{ Exception -> 0x03fc }
            r5 = 2131362905(0x7f0a0459, float:1.8345604E38)
            r13.setImageViewBitmap(r5, r2)     // Catch:{ Exception -> 0x03fc }
            r10.setImageViewBitmap(r5, r2)     // Catch:{ Exception -> 0x03fc }
            r0.setImageViewBitmap(r5, r2)     // Catch:{ Exception -> 0x03fc }
            goto L_0x0407
        L_0x03fc:
            r2 = 1
            java.lang.Object[] r5 = new java.lang.Object[r2]     // Catch:{ Exception -> 0x05ba }
            java.lang.String r2 = "showGroupEventNotification: Exception in Group Icon creation"
            r9 = 0
            r5[r9] = r2     // Catch:{ Exception -> 0x05ba }
            com.mpl.androidapp.utils.MLogger.e(r11, r5)     // Catch:{ Exception -> 0x05ba }
        L_0x0407:
            r2 = 67108864(0x4000000, float:1.5046328E-36)
            r6.setFlags(r2)     // Catch:{ Exception -> 0x05ba }
            java.lang.String r2 = "Time To Send"
            java.util.Calendar r5 = java.util.Calendar.getInstance()     // Catch:{ Exception -> 0x05ba }
            r9 = r11
            long r11 = r5.getTimeInMillis()     // Catch:{ Exception -> 0x05b8 }
            r6.putExtra(r2, r11)     // Catch:{ Exception -> 0x05b8 }
            java.lang.String r2 = "Notification Type"
            java.lang.String r5 = "Group Notification"
            r6.putExtra(r2, r5)     // Catch:{ Exception -> 0x05b8 }
            r6.putExtra(r3, r4)     // Catch:{ Exception -> 0x05b8 }
            r2 = 134217728(0x8000000, float:3.85186E-34)
            r3 = 0
            android.app.PendingIntent r5 = android.app.PendingIntent.getActivity(r8, r3, r6, r2)     // Catch:{ Exception -> 0x05b8 }
            r3 = 1
            android.app.PendingIntent r11 = android.app.PendingIntent.getActivity(r8, r3, r6, r2)     // Catch:{ Exception -> 0x05b8 }
            r3 = 2
            android.app.PendingIntent r2 = android.app.PendingIntent.getActivity(r8, r3, r6, r2)     // Catch:{ Exception -> 0x05b8 }
            android.net.Uri r6 = android.media.RingtoneManager.getDefaultUri(r3)     // Catch:{ Exception -> 0x05b8 }
            boolean r3 = com.mpl.androidapp.utils.CommonUtils.isAppIsInBackground(r30)     // Catch:{ Exception -> 0x05b8 }
            if (r3 == 0) goto L_0x0442
            java.lang.String r3 = "Challenge"
            goto L_0x0444
        L_0x0442:
            java.lang.String r3 = "GAME"
        L_0x0444:
            androidx.core.app.NotificationCompat$Builder r3 = r7.getNotificationBuilder(r8, r3)     // Catch:{ Exception -> 0x05b8 }
            r12 = 2131231343(0x7f08026f, float:1.8078764E38)
            androidx.core.app.NotificationCompat$Builder r3 = r3.setSmallIcon(r12)     // Catch:{ Exception -> 0x05b8 }
            androidx.core.app.NotificationCompat$Builder r3 = r3.setSound(r6)     // Catch:{ Exception -> 0x05b8 }
            r6 = 1
            androidx.core.app.NotificationCompat$Builder r3 = r3.setBadgeIconType(r6)     // Catch:{ Exception -> 0x05b8 }
            androidx.core.app.NotificationCompat$Builder r3 = r3.setCustomContentView(r13)     // Catch:{ Exception -> 0x05b8 }
            androidx.core.app.NotificationCompat$Builder r0 = r3.setCustomHeadsUpContentView(r0)     // Catch:{ Exception -> 0x05b8 }
            androidx.core.app.NotificationCompat$Builder r0 = r0.setCustomBigContentView(r10)     // Catch:{ Exception -> 0x05b8 }
            androidx.core.app.NotificationCompat$DecoratedCustomViewStyle r3 = new androidx.core.app.NotificationCompat$DecoratedCustomViewStyle     // Catch:{ Exception -> 0x05b8 }
            r3.<init>()     // Catch:{ Exception -> 0x05b8 }
            androidx.core.app.NotificationCompat$Builder r0 = r0.setStyle(r3)     // Catch:{ Exception -> 0x05b8 }
            r3 = 2
            long[] r6 = new long[r3]     // Catch:{ Exception -> 0x05b8 }
            r18 = 1000(0x3e8, double:4.94E-321)
            r3 = 0
            r6[r3] = r18     // Catch:{ Exception -> 0x05b8 }
            r18 = 1000(0x3e8, double:4.94E-321)
            r3 = 1
            r6[r3] = r18     // Catch:{ Exception -> 0x05b8 }
            androidx.core.app.NotificationCompat$Builder r0 = r0.setVibrate(r6)     // Catch:{ Exception -> 0x05b8 }
            r3 = -65536(0xffffffffffff0000, float:NaN)
            r6 = 3000(0xbb8, float:4.204E-42)
            r10 = 3000(0xbb8, float:4.204E-42)
            androidx.core.app.NotificationCompat$Builder r0 = r0.setLights(r3, r6, r10)     // Catch:{ Exception -> 0x05b8 }
            androidx.core.app.NotificationCompat$Builder r0 = r0.setGroup(r1)     // Catch:{ Exception -> 0x05b8 }
            r1 = 0
            androidx.core.app.NotificationCompat$Builder r0 = r0.setGroupSummary(r1)     // Catch:{ Exception -> 0x05b8 }
            r13 = r16
            androidx.core.app.NotificationCompat$Builder r0 = r0.setSubText(r13)     // Catch:{ Exception -> 0x05b8 }
            r1 = r29
            androidx.core.app.NotificationCompat$Builder r0 = r0.addExtras(r1)     // Catch:{ Exception -> 0x05b8 }
            long r18 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x05b8 }
            r20 = 1000(0x3e8, double:4.94E-321)
            long r12 = r18 + r20
            androidx.core.app.NotificationCompat$Builder r0 = r0.setWhen(r12)     // Catch:{ Exception -> 0x05b8 }
            r3 = 1
            androidx.core.app.NotificationCompat$Builder r0 = r0.setShowWhen(r3)     // Catch:{ Exception -> 0x05b8 }
            java.lang.String r3 = "msg"
            androidx.core.app.NotificationCompat$Builder r0 = r0.setCategory(r3)     // Catch:{ Exception -> 0x05b8 }
            r3 = 0
            androidx.core.app.NotificationCompat$Builder r0 = r0.setGroupAlertBehavior(r3)     // Catch:{ Exception -> 0x05b8 }
            androidx.core.app.NotificationCompat$Builder r0 = r0.setContentIntent(r5)     // Catch:{ Exception -> 0x05b8 }
            r3 = 1
            androidx.core.app.NotificationCompat$Builder r0 = r0.setAutoCancel(r3)     // Catch:{ Exception -> 0x05b8 }
            androidx.core.app.NotificationCompat$Action$Builder r3 = new androidx.core.app.NotificationCompat$Action$Builder     // Catch:{ Exception -> 0x05b8 }
            android.content.res.Resources r5 = r30.getResources()     // Catch:{ Exception -> 0x05b8 }
            r6 = 2131952736(0x7f130460, float:1.9541923E38)
            java.lang.String r5 = r5.getString(r6)     // Catch:{ Exception -> 0x05b8 }
            r1 = 2131231343(0x7f08026f, float:1.8078764E38)
            r3.<init>(r1, r5, r11)     // Catch:{ Exception -> 0x05b8 }
            r5 = 0
            androidx.core.app.NotificationCompat$Action$Builder r3 = r3.setShowsUserInterface(r5)     // Catch:{ Exception -> 0x05b8 }
            androidx.core.app.NotificationCompat$Action$Builder r3 = r3.setAllowGeneratedReplies(r5)     // Catch:{ Exception -> 0x05b8 }
            androidx.core.app.NotificationCompat$Action r3 = r3.build()     // Catch:{ Exception -> 0x05b8 }
            android.content.res.Resources r5 = r30.getResources()     // Catch:{ Exception -> 0x05b8 }
            r6 = 2131952509(0x7f13037d, float:1.9541463E38)
            java.lang.String r5 = r5.getString(r6)     // Catch:{ Exception -> 0x05b8 }
            if (r14 == 0) goto L_0x04fb
            java.lang.String r6 = r14.toLowerCase()     // Catch:{ Exception -> 0x05b8 }
            java.lang.String r10 = "channel"
            boolean r6 = r6.equalsIgnoreCase(r10)     // Catch:{ Exception -> 0x05b8 }
            if (r6 != 0) goto L_0x0509
        L_0x04fb:
            if (r24 == 0) goto L_0x0514
            java.lang.String r6 = r24.toLowerCase()     // Catch:{ Exception -> 0x05b8 }
            java.lang.String r10 = "channel"
            boolean r6 = r6.equalsIgnoreCase(r10)     // Catch:{ Exception -> 0x05b8 }
            if (r6 == 0) goto L_0x0514
        L_0x0509:
            android.content.res.Resources r5 = r30.getResources()     // Catch:{ Exception -> 0x05b8 }
            r6 = 2131952508(0x7f13037c, float:1.954146E38)
            java.lang.String r5 = r5.getString(r6)     // Catch:{ Exception -> 0x05b8 }
        L_0x0514:
            androidx.core.app.NotificationCompat$Action$Builder r6 = new androidx.core.app.NotificationCompat$Action$Builder     // Catch:{ Exception -> 0x05b8 }
            r1 = 2131231343(0x7f08026f, float:1.8078764E38)
            r6.<init>(r1, r5, r2)     // Catch:{ Exception -> 0x05b8 }
            r1 = 0
            androidx.core.app.NotificationCompat$Action$Builder r2 = r6.setShowsUserInterface(r1)     // Catch:{ Exception -> 0x05b8 }
            androidx.core.app.NotificationCompat$Action$Builder r2 = r2.setAllowGeneratedReplies(r1)     // Catch:{ Exception -> 0x05b8 }
            androidx.core.app.NotificationCompat$Action r1 = r2.build()     // Catch:{ Exception -> 0x05b8 }
            r2 = 26
            if (r14 == 0) goto L_0x0595
            boolean r5 = android.text.TextUtils.isEmpty(r14)     // Catch:{ Exception -> 0x05b8 }
            if (r5 != 0) goto L_0x0595
            java.lang.String r5 = r14.toUpperCase()     // Catch:{ Exception -> 0x05b8 }
            r6 = -1
            int r8 = r5.hashCode()     // Catch:{ Exception -> 0x05b8 }
            r10 = -976032916(0xffffffffc5d2eb6c, float:-6749.4277)
            if (r8 == r10) goto L_0x0551
            r10 = 575157196(0x224833cc, float:2.7132475E-18)
            if (r8 == r10) goto L_0x0547
            goto L_0x055a
        L_0x0547:
            java.lang.String r8 = "USER_REMOVED"
            boolean r5 = r5.equals(r8)     // Catch:{ Exception -> 0x05b8 }
            if (r5 == 0) goto L_0x055a
            r6 = 1
            goto L_0x055a
        L_0x0551:
            java.lang.String r8 = "USER_ADDED"
            boolean r5 = r5.equals(r8)     // Catch:{ Exception -> 0x05b8 }
            if (r5 == 0) goto L_0x055a
            r6 = 0
        L_0x055a:
            if (r6 == 0) goto L_0x0586
            r5 = 1
            if (r6 == r5) goto L_0x057d
            int r5 = android.os.Build.VERSION.SDK_INT     // Catch:{ Exception -> 0x05b8 }
            if (r5 >= r2) goto L_0x056a
            int r2 = r28.getPriority()     // Catch:{ Exception -> 0x05b8 }
            r0.setPriority(r2)     // Catch:{ Exception -> 0x05b8 }
        L_0x056a:
            java.lang.String r2 = r14.toLowerCase()     // Catch:{ Exception -> 0x05b8 }
            java.lang.String r5 = "channel"
            boolean r2 = r2.equalsIgnoreCase(r5)     // Catch:{ Exception -> 0x05b8 }
            if (r2 != 0) goto L_0x0579
            r0.addAction(r3)     // Catch:{ Exception -> 0x05b8 }
        L_0x0579:
            r0.addAction(r1)     // Catch:{ Exception -> 0x05b8 }
            goto L_0x05a6
        L_0x057d:
            int r1 = android.os.Build.VERSION.SDK_INT     // Catch:{ Exception -> 0x05b8 }
            if (r1 >= r2) goto L_0x05a6
            r1 = -1
            r0.setPriority(r1)     // Catch:{ Exception -> 0x05b8 }
            goto L_0x05a6
        L_0x0586:
            int r3 = android.os.Build.VERSION.SDK_INT     // Catch:{ Exception -> 0x05b8 }
            if (r3 >= r2) goto L_0x0591
            int r2 = r28.getPriority()     // Catch:{ Exception -> 0x05b8 }
            r0.setPriority(r2)     // Catch:{ Exception -> 0x05b8 }
        L_0x0591:
            r0.addAction(r1)     // Catch:{ Exception -> 0x05b8 }
            goto L_0x05a6
        L_0x0595:
            int r5 = android.os.Build.VERSION.SDK_INT     // Catch:{ Exception -> 0x05b8 }
            if (r5 >= r2) goto L_0x05a0
            int r2 = r28.getPriority()     // Catch:{ Exception -> 0x05b8 }
            r0.setPriority(r2)     // Catch:{ Exception -> 0x05b8 }
        L_0x05a0:
            r0.addAction(r3)     // Catch:{ Exception -> 0x05b8 }
            r0.addAction(r1)     // Catch:{ Exception -> 0x05b8 }
        L_0x05a6:
            if (r17 == 0) goto L_0x05ca
            java.lang.String r2 = ""
            android.app.Notification r0 = r0.build()     // Catch:{ Exception -> 0x05b8 }
            r5 = 0
            r6 = 1
            r1 = r28
            r3 = r4
            r4 = r0
            r1.notifyNotification(r2, r3, r4, r5, r6)     // Catch:{ Exception -> 0x05b8 }
            goto L_0x05ca
        L_0x05b8:
            r0 = move-exception
            goto L_0x05bc
        L_0x05ba:
            r0 = move-exception
            r9 = r11
        L_0x05bc:
            r1 = 2
            java.lang.Object[] r1 = new java.lang.Object[r1]
            java.lang.String r2 = "showGroupEventNotification: "
            r3 = 0
            r1[r3] = r2
            r2 = 1
            r1[r2] = r0
            com.mpl.androidapp.utils.MLogger.e(r9, r1)
        L_0x05ca:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mpl.androidapp.notification.NotificationBuilder.lambda$showGroupEventNotification$9$NotificationBuilder(android.os.Bundle, android.content.Context):void");
    }

    public /* synthetic */ void lambda$showNewUserOnBoardingNotification$5$NotificationBuilder(Bundle bundle, Context context) {
        String str;
        Bundle bundle2 = bundle;
        Context context2 = context;
        String str2 = "";
        try {
            if (!bundle2.containsKey(SubCategory.Action.USER) || TextUtils.isEmpty(bundle2.getString(SubCategory.Action.USER, str2))) {
                MLogger.e(TAG, "showNewUserOnBoardingNotification: user is null");
                return;
            }
            JSONObject jSONObject = new JSONObject(bundle2.getString(SubCategory.Action.USER, str2));
            if (!jSONObject.has(Constant.APPSFLYER_IS_NEW_USER) || !jSONObject.optBoolean(Constant.APPSFLYER_IS_NEW_USER, false) || !jSONObject.has(Constant.PROFILE) || jSONObject.optJSONObject(Constant.PROFILE) == null) {
                MLogger.e(TAG, "showNewUserOnBoardingNotification:profile is null or not a new user ");
                return;
            }
            String optString = jSONObject.optJSONObject(Constant.PROFILE).optString("mobileNumber", str2);
            String optString2 = jSONObject.optJSONObject(Constant.PROFILE).optString("displayName", str2);
            if (!TextUtils.isEmpty(optString)) {
                Contact nameFromLocalDb = ContactUtils.getNameFromLocalDb(optString);
                if (nameFromLocalDb != null) {
                    str = nameFromLocalDb.getContactDisplayName() + " just joined MPL!";
                    if (nameFromLocalDb.getPhotoThumbUri() != null && !TextUtils.isEmpty(nameFromLocalDb.getPhotoThumbUri())) {
                        str2 = nameFromLocalDb.getPhotoThumbUri();
                    }
                } else {
                    str = optString2 + " just joined MPL!";
                }
                Intent buildSendBirdIntent = buildSendBirdIntent(context2, parseResponse(bundle), 0);
                buildSendBirdIntent.setFlags(PDChoice.FLAG_COMMIT_ON_SEL_CHANGE);
                buildSendBirdIntent.putExtra(Constant.TIME_TO_SEND, Calendar.getInstance().getTimeInMillis());
                buildSendBirdIntent.putExtra(EventsConstants.PROP_NOTIFICATION_TYPE, "New User Join");
                Builder autoCancel = getNotificationBuilder(context2, Constant.CHALLENGES_CHANNEL_ID).setSmallIcon((int) R.drawable.ic_stat_mpl).setContentTitle(str).setContentText("Say hi or send a challenge!").setColor(ContextCompat.getColor(this.mContext, R.color.notif_action_button)).addExtras(bundle2).setWhen(System.currentTimeMillis() + 1000).setShowWhen(true).setDefaults(3).setAutoCancel(true).setGroup("online").setVibrate(new long[]{1000, 1000}).setLights(-65536, 3000, 3000).setContentIntent(PendingIntent.getActivity(context2, 0, buildSendBirdIntent, 134217728)).setAutoCancel(true);
                if (VERSION.SDK_INT < 26) {
                    autoCancel.setPriority(getPriority());
                }
                Intent buildSendBirdIntent2 = buildSendBirdIntent(context2, parseResponse(bundle), Constant.SPIN_WHEEL_NOTIFICATION_ID);
                buildSendBirdIntent2.setAction(Constant.ACTION_NOTIFICATION_SEND_CHALLENGE);
                autoCancel.addAction(R.drawable.send_24px, "Send Challenge", PendingIntent.getActivity(this.mContext, 12345, buildSendBirdIntent2, 134217728, bundle2));
                Intent buildSendBirdIntent3 = buildSendBirdIntent(context2, parseResponse(bundle), Constant.SPIN_WHEEL_NOTIFICATION_ID);
                buildSendBirdIntent3.setAction(Constant.ACTION_NOTIFICATION_SEND_MESSAGE);
                autoCancel.addAction(R.drawable.ic_msg_send, "Send Message", PendingIntent.getActivity(this.mContext, 12345, buildSendBirdIntent3, 134217728, bundle2));
                if (TextUtils.isEmpty(str2)) {
                    autoCancel.setLargeIcon(BitmapFactory.decodeResource(this.mContext.getResources(), R.drawable.ic_placeholder_dp_44_dp));
                } else if (getLargeIconInNotification(str2) != null) {
                    autoCancel.setLargeIcon(getLargeIconInNotification(str2));
                } else {
                    autoCancel.setLargeIcon(BitmapFactory.decodeResource(this.mContext.getResources(), R.drawable.ic_placeholder_dp_44_dp));
                }
                if (!CommonUtils.isAppIsInBackground(this.mContext)) {
                    publishNotificationToReact(jSONObject.toString(), str, "Say hi or send a challenge!", str2);
                    return;
                }
                notifyNotification(null, Constant.SPIN_WHEEL_NOTIFICATION_ID, autoCancel.build(), 0, true);
                return;
            }
            MLogger.e(TAG, "showNewUserOnBoardingNotification: mobile number is null");
        } catch (Exception e2) {
            MLogger.e(TAG, "showChallengeNotification: ", e2);
        }
    }

    public void postTaskToBackgroundThread(Runnable runnable) {
        try {
            if (this.backgroundTaskHandler == null) {
                BackgroundTaskHandler backgroundTaskHandler2 = new BackgroundTaskHandler();
                this.backgroundTaskHandler = backgroundTaskHandler2;
                backgroundTaskHandler2.start();
                this.backgroundTaskHandler.prepareLooper();
            }
            this.backgroundTaskHandler.postTask(runnable);
        } catch (Exception unused) {
            MLogger.e(TAG, "postTaskToBackgroundThread: ");
        }
    }

    public static void sendNotificationReceiveEvent(JSONObject jSONObject) {
        try {
            CleverTapAnalyticsUtils.sendNotificationReceivedEvent(jSONObject);
        } catch (Exception e2) {
            MLogger.e(TAG, "sendNotificationReceiveEvent: ", e2);
        }
    }

    public void createSendBirdMessageNotification(JSONObject jSONObject, String str) {
        MLogger.d(TAG, "createSendBirdMessageNotification:5 from sendbird ");
        if (str == null || TextUtils.isEmpty(str)) {
            createSendBirdMessageNotification(jSONObject);
        }
        postTaskToBackgroundThread(new Runnable(jSONObject, str) {
            public final /* synthetic */ JSONObject f$0;
            public final /* synthetic */ String f$1;

            {
                this.f$0 = r1;
                this.f$1 = r2;
            }

            public final void run() {
                NotificationBuilder.lambda$createSendBirdMessageNotification$2(this.f$0, this.f$1);
            }
        });
    }

    public void createStickyNotification(final String str) {
        postTaskToBackgroundThread(new Runnable() {
            /* JADX WARNING: Removed duplicated region for block: B:102:0x03f9 A[Catch:{ Exception -> 0x05d8 }] */
            /* JADX WARNING: Removed duplicated region for block: B:103:0x03fc A[Catch:{ Exception -> 0x05d8 }] */
            /* JADX WARNING: Removed duplicated region for block: B:106:0x0424 A[Catch:{ Exception -> 0x05d8 }] */
            /* JADX WARNING: Removed duplicated region for block: B:109:0x042d A[Catch:{ Exception -> 0x05d8 }] */
            /* JADX WARNING: Removed duplicated region for block: B:112:0x043c A[Catch:{ Exception -> 0x05d8 }] */
            /* JADX WARNING: Removed duplicated region for block: B:119:0x0456 A[Catch:{ Exception -> 0x05d8 }, LOOP:1: B:117:0x0450->B:119:0x0456, LOOP_END] */
            /* JADX WARNING: Removed duplicated region for block: B:122:0x0472 A[Catch:{ Exception -> 0x05d8 }] */
            /* JADX WARNING: Removed duplicated region for block: B:157:0x05b4 A[Catch:{ Exception -> 0x05d8 }] */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void run() {
                /*
                    r35 = this;
                    r1 = r35
                    java.lang.String r0 = "deeplink"
                    java.lang.String r2 = "{}"
                    java.lang.String r3 = "title"
                    java.lang.String r4 = "createStickyNotification: "
                    java.lang.String r5 = "actionButtons"
                    java.lang.String r6 = "NotificationBuilder"
                    java.lang.String r7 = ""
                    org.json.JSONObject r11 = new org.json.JSONObject     // Catch:{ Exception -> 0x05de }
                    java.lang.String r12 = r2     // Catch:{ Exception -> 0x05de }
                    r11.<init>(r12)     // Catch:{ Exception -> 0x05de }
                    java.lang.String r12 = "startTime"
                    r13 = 0
                    long r15 = r11.optLong(r12, r13)     // Catch:{ Exception -> 0x05de }
                    java.lang.String r12 = r11.optString(r3, r7)     // Catch:{ Exception -> 0x05de }
                    int r17 = (r15 > r13 ? 1 : (r15 == r13 ? 0 : -1))
                    if (r17 == 0) goto L_0x004f
                    boolean r17 = android.text.TextUtils.isEmpty(r12)     // Catch:{ Exception -> 0x05de }
                    if (r17 == 0) goto L_0x004f
                    java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x05de }
                    r12.<init>()     // Catch:{ Exception -> 0x05de }
                    java.lang.String r8 = "Tournament will start in "
                    r12.append(r8)     // Catch:{ Exception -> 0x05de }
                    java.util.concurrent.TimeUnit r8 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch:{ Exception -> 0x05de }
                    long r18 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x05de }
                    long r13 = r15 - r18
                    long r13 = r8.toMinutes(r13)     // Catch:{ Exception -> 0x05de }
                    r12.append(r13)     // Catch:{ Exception -> 0x05de }
                    java.lang.String r8 = " minutes"
                    r12.append(r8)     // Catch:{ Exception -> 0x05de }
                    java.lang.String r12 = r12.toString()     // Catch:{ Exception -> 0x05de }
                L_0x004f:
                    java.lang.String r8 = "message"
                    java.lang.String r8 = r11.optString(r8, r7)     // Catch:{ Exception -> 0x05de }
                    java.lang.String r13 = "deepLink"
                    java.lang.String r13 = r11.optString(r13, r7)     // Catch:{ Exception -> 0x05de }
                    java.lang.String r14 = "largeIcon"
                    java.lang.String r14 = r11.optString(r14, r7)     // Catch:{ Exception -> 0x05de }
                    java.lang.String r15 = "bigPicture"
                    java.lang.String r15 = r11.optString(r15, r7)     // Catch:{ Exception -> 0x05de }
                    java.lang.String r9 = "feature"
                    java.lang.String r9 = r11.optString(r9, r7)     // Catch:{ Exception -> 0x05de }
                    java.lang.String r10 = "subText"
                    java.lang.String r10 = r11.optString(r10, r7)     // Catch:{ Exception -> 0x05de }
                    r19 = r15
                    java.lang.String r15 = "eventProps"
                    java.lang.String r15 = r11.optString(r15, r2)     // Catch:{ Exception -> 0x05de }
                    r20 = r10
                    java.lang.String r10 = "tournamentId"
                    r21 = r14
                    r14 = 0
                    int r10 = r11.optInt(r10, r14)     // Catch:{ Exception -> 0x05de }
                    java.lang.String r14 = "notificationId"
                    if (r10 != 0) goto L_0x0091
                    r10 = 0
                    int r22 = r11.optInt(r14, r10)     // Catch:{ Exception -> 0x05de }
                    r10 = r22
                L_0x0091:
                    boolean r22 = r11.has(r5)     // Catch:{ Exception -> 0x05de }
                    r23 = r8
                    if (r22 == 0) goto L_0x018b
                    java.lang.String r22 = r11.optString(r5)     // Catch:{ Exception -> 0x05de }
                    boolean r22 = android.text.TextUtils.isEmpty(r22)     // Catch:{ Exception -> 0x05de }
                    if (r22 != 0) goto L_0x018b
                    java.lang.String r22 = r11.optString(r5)     // Catch:{ Exception -> 0x05de }
                    boolean r22 = com.mpl.androidapp.utils.CommonUtils.isJSONValid(r22)     // Catch:{ Exception -> 0x05de }
                    if (r22 == 0) goto L_0x018b
                    java.util.ArrayList r8 = new java.util.ArrayList     // Catch:{ Exception -> 0x05de }
                    r8.<init>()     // Catch:{ Exception -> 0x05de }
                    r25 = r12
                    org.json.JSONArray r12 = new org.json.JSONArray     // Catch:{ Exception -> 0x05de }
                    java.lang.String r5 = r11.optString(r5)     // Catch:{ Exception -> 0x05de }
                    r12.<init>(r5)     // Catch:{ Exception -> 0x05de }
                    java.lang.String r5 = "Open"
                    r26 = r2
                    r28 = r15
                    r2 = 0
                    r27 = 0
                L_0x00c6:
                    int r15 = r12.length()     // Catch:{ Exception -> 0x05de }
                    if (r2 >= r15) goto L_0x0192
                    org.json.JSONObject r15 = r12.optJSONObject(r2)     // Catch:{ Exception -> 0x05de }
                    java.lang.String r5 = r15.optString(r3, r5)     // Catch:{ Exception -> 0x05de }
                    org.json.JSONObject r15 = r12.optJSONObject(r2)     // Catch:{ Exception -> 0x05de }
                    org.json.JSONObject r15 = r15.optJSONObject(r0)     // Catch:{ Exception -> 0x05de }
                    if (r15 == 0) goto L_0x00f6
                    com.mpl.androidapp.notification.NotificationBuilder r15 = com.mpl.androidapp.notification.NotificationBuilder.this     // Catch:{ Exception -> 0x05de }
                    r29 = r3
                    org.json.JSONObject r3 = r12.optJSONObject(r2)     // Catch:{ Exception -> 0x05de }
                    org.json.JSONObject r3 = r3.optJSONObject(r0)     // Catch:{ Exception -> 0x05de }
                    java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x05de }
                    r30 = r0
                    r0 = 0
                    android.content.Intent r27 = r15.buildIntentWithDeepLink(r3, r10, r0)     // Catch:{ Exception -> 0x05de }
                    goto L_0x00fb
                L_0x00f6:
                    r30 = r0
                    r29 = r3
                    r0 = 0
                L_0x00fb:
                    r3 = r27
                    java.lang.String r15 = "cancel"
                    boolean r15 = r15.equalsIgnoreCase(r5)     // Catch:{ Exception -> 0x05de }
                    if (r15 != 0) goto L_0x013f
                    java.lang.String r15 = "close"
                    boolean r15 = r15.equalsIgnoreCase(r5)     // Catch:{ Exception -> 0x05de }
                    if (r15 != 0) goto L_0x013f
                    java.lang.String r15 = "dismiss"
                    boolean r15 = r15.equalsIgnoreCase(r5)     // Catch:{ Exception -> 0x05de }
                    if (r15 != 0) goto L_0x013f
                    java.lang.String r15 = "clean"
                    boolean r15 = r15.equalsIgnoreCase(r5)     // Catch:{ Exception -> 0x05de }
                    if (r15 != 0) goto L_0x013f
                    java.lang.String r15 = "clear"
                    boolean r15 = r15.equalsIgnoreCase(r5)     // Catch:{ Exception -> 0x05de }
                    if (r15 == 0) goto L_0x0126
                    goto L_0x013f
                L_0x0126:
                    com.mpl.androidapp.notification.NotificationBuilder r15 = com.mpl.androidapp.notification.NotificationBuilder.this     // Catch:{ Exception -> 0x05de }
                    android.content.Context r15 = r15.mContext     // Catch:{ Exception -> 0x05de }
                    com.mpl.androidapp.notification.NotificationBuilder r0 = com.mpl.androidapp.notification.NotificationBuilder.this     // Catch:{ Exception -> 0x05de }
                    java.util.Random r0 = r0.mRandom     // Catch:{ Exception -> 0x05de }
                    int r0 = r0.nextInt()     // Catch:{ Exception -> 0x05de }
                    r27 = r12
                    r12 = 134217728(0x8000000, float:3.85186E-34)
                    android.app.PendingIntent r0 = android.app.PendingIntent.getActivity(r15, r0, r3, r12)     // Catch:{ Exception -> 0x05de }
                    goto L_0x0174
                L_0x013f:
                    r27 = r12
                    android.content.Intent r0 = new android.content.Intent     // Catch:{ Exception -> 0x05de }
                    r0.<init>()     // Catch:{ Exception -> 0x05de }
                    android.content.ComponentName r3 = new android.content.ComponentName     // Catch:{ Exception -> 0x05de }
                    com.mpl.androidapp.notification.NotificationBuilder r12 = com.mpl.androidapp.notification.NotificationBuilder.this     // Catch:{ Exception -> 0x05de }
                    android.content.Context r12 = r12.mContext     // Catch:{ Exception -> 0x05de }
                    java.lang.Class<com.mpl.androidapp.notification.MPLNotificationCancelReceiver> r15 = com.mpl.androidapp.notification.MPLNotificationCancelReceiver.class
                    r3.<init>(r12, r15)     // Catch:{ Exception -> 0x05de }
                    r0.setComponent(r3)     // Catch:{ Exception -> 0x05de }
                    r0.putExtra(r14, r10)     // Catch:{ Exception -> 0x05de }
                    com.mpl.androidapp.notification.NotificationBuilder r3 = com.mpl.androidapp.notification.NotificationBuilder.this     // Catch:{ Exception -> 0x05de }
                    android.content.Context r3 = r3.mContext     // Catch:{ Exception -> 0x05de }
                    com.mpl.androidapp.notification.NotificationBuilder r12 = com.mpl.androidapp.notification.NotificationBuilder.this     // Catch:{ Exception -> 0x05de }
                    java.util.Random r12 = r12.mRandom     // Catch:{ Exception -> 0x05de }
                    int r12 = r12.nextInt()     // Catch:{ Exception -> 0x05de }
                    r15 = 268435456(0x10000000, float:2.524355E-29)
                    android.app.PendingIntent r3 = android.app.PendingIntent.getBroadcast(r3, r12, r0, r15)     // Catch:{ Exception -> 0x05de }
                    r34 = r3
                    r3 = r0
                    r0 = r34
                L_0x0174:
                    androidx.core.app.NotificationCompat$Action r12 = new androidx.core.app.NotificationCompat$Action     // Catch:{ Exception -> 0x05de }
                    r15 = 2131231343(0x7f08026f, float:1.8078764E38)
                    r12.<init>(r15, r5, r0)     // Catch:{ Exception -> 0x05de }
                    r8.add(r12)     // Catch:{ Exception -> 0x05de }
                    int r2 = r2 + 1
                    r12 = r27
                    r0 = r30
                    r27 = r3
                    r3 = r29
                    goto L_0x00c6
                L_0x018b:
                    r26 = r2
                    r25 = r12
                    r28 = r15
                    r8 = 0
                L_0x0192:
                    java.lang.String r0 = "when"
                    r2 = 0
                    long r14 = r11.optLong(r0, r2)     // Catch:{ Exception -> 0x05de }
                    java.lang.String r0 = "dismissTime"
                    java.util.concurrent.TimeUnit r2 = java.util.concurrent.TimeUnit.MINUTES     // Catch:{ Exception -> 0x05de }
                    r3 = r13
                    r12 = 10
                    long r12 = r2.toMillis(r12)     // Catch:{ Exception -> 0x05de }
                    long r12 = r11.optLong(r0, r12)     // Catch:{ Exception -> 0x05de }
                    java.lang.String r0 = "autoCancel"
                    r2 = 1
                    boolean r0 = r11.optBoolean(r0, r2)     // Catch:{ Exception -> 0x05de }
                    java.lang.String r2 = "setOngoing"
                    r5 = 0
                    boolean r2 = r11.optBoolean(r2, r5)     // Catch:{ Exception -> 0x05de }
                    r22 = r8
                    java.lang.String r8 = "priority"
                    r11.optInt(r8, r5)     // Catch:{ Exception -> 0x05de }
                    java.lang.String r5 = "type"
                    java.lang.String r5 = r11.optString(r5, r7)     // Catch:{ Exception -> 0x05de }
                    boolean r8 = android.text.TextUtils.isEmpty(r5)     // Catch:{ Exception -> 0x05de }
                    if (r8 == 0) goto L_0x01d0
                    java.lang.String r5 = "notificationType"
                    java.lang.String r5 = r11.optString(r5, r7)     // Catch:{ Exception -> 0x05de }
                L_0x01d0:
                    java.lang.String r7 = "sticky"
                    if (r2 != 0) goto L_0x01d8
                    boolean r2 = r7.equalsIgnoreCase(r5)     // Catch:{ Exception -> 0x05de }
                L_0x01d8:
                    java.lang.String r8 = "knockOut Tournament"
                    boolean r8 = r8.equalsIgnoreCase(r9)     // Catch:{ Exception -> 0x05de }
                    r27 = r9
                    r9 = 5
                    java.lang.Object[] r9 = new java.lang.Object[r9]     // Catch:{ Exception -> 0x05de }
                    r18 = 0
                    r9[r18] = r4     // Catch:{ Exception -> 0x05de }
                    r29 = r4
                    org.joda.time.DateTime r4 = new org.joda.time.DateTime     // Catch:{ Exception -> 0x05dc }
                    r4.<init>(r14)     // Catch:{ Exception -> 0x05dc }
                    java.lang.String r4 = r4.toString()     // Catch:{ Exception -> 0x05dc }
                    r16 = 1
                    r9[r16] = r4     // Catch:{ Exception -> 0x05dc }
                    java.util.concurrent.TimeUnit r4 = java.util.concurrent.TimeUnit.MINUTES     // Catch:{ Exception -> 0x05dc }
                    long r30 = r4.toMillis(r12)     // Catch:{ Exception -> 0x05dc }
                    java.lang.Long r4 = java.lang.Long.valueOf(r30)     // Catch:{ Exception -> 0x05dc }
                    r17 = 2
                    r9[r17] = r4     // Catch:{ Exception -> 0x05dc }
                    java.lang.Boolean r4 = java.lang.Boolean.valueOf(r0)     // Catch:{ Exception -> 0x05dc }
                    r30 = r12
                    r12 = 3
                    r9[r12] = r4     // Catch:{ Exception -> 0x05dc }
                    r4 = 4
                    java.lang.Boolean r13 = java.lang.Boolean.valueOf(r2)     // Catch:{ Exception -> 0x05dc }
                    r9[r4] = r13     // Catch:{ Exception -> 0x05dc }
                    com.mpl.androidapp.utils.MLogger.d(r6, r9)     // Catch:{ Exception -> 0x05dc }
                    android.content.Intent r4 = new android.content.Intent     // Catch:{ Exception -> 0x05dc }
                    com.mpl.androidapp.notification.NotificationBuilder r9 = com.mpl.androidapp.notification.NotificationBuilder.this     // Catch:{ Exception -> 0x05dc }
                    android.content.Context r9 = r9.mContext     // Catch:{ Exception -> 0x05dc }
                    java.lang.Class<com.mpl.androidapp.react.MPLReactContainerActivity> r13 = com.mpl.androidapp.react.MPLReactContainerActivity.class
                    r4.<init>(r9, r13)     // Catch:{ Exception -> 0x05dc }
                    boolean r4 = android.text.TextUtils.isEmpty(r3)     // Catch:{ Exception -> 0x05dc }
                    if (r4 != 0) goto L_0x023c
                    com.mpl.androidapp.notification.NotificationBuilder r4 = com.mpl.androidapp.notification.NotificationBuilder.this     // Catch:{ Exception -> 0x05dc }
                    org.json.JSONObject r9 = new org.json.JSONObject     // Catch:{ Exception -> 0x05dc }
                    r13 = r28
                    r9.<init>(r13)     // Catch:{ Exception -> 0x05dc }
                    org.json.JSONObject r9 = com.mpl.androidapp.utils.CommonUtils.mergeJSON(r11, r9)     // Catch:{ Exception -> 0x05dc }
                    android.content.Intent r3 = r4.buildIntentWithDeepLink(r3, r10, r9)     // Catch:{ Exception -> 0x05dc }
                    goto L_0x024f
                L_0x023c:
                    r13 = r28
                    com.mpl.androidapp.notification.NotificationBuilder r3 = com.mpl.androidapp.notification.NotificationBuilder.this     // Catch:{ Exception -> 0x05dc }
                    org.json.JSONObject r4 = new org.json.JSONObject     // Catch:{ Exception -> 0x05dc }
                    r4.<init>(r13)     // Catch:{ Exception -> 0x05dc }
                    org.json.JSONObject r4 = com.mpl.androidapp.utils.CommonUtils.mergeJSON(r11, r4)     // Catch:{ Exception -> 0x05dc }
                    r9 = r26
                    android.content.Intent r3 = r3.buildIntentWithDeepLink(r9, r10, r4)     // Catch:{ Exception -> 0x05dc }
                L_0x024f:
                    r4 = 603979776(0x24000000, float:2.7755576E-17)
                    r3.setFlags(r4)     // Catch:{ Exception -> 0x05dc }
                    com.mpl.androidapp.notification.NotificationBuilder r4 = com.mpl.androidapp.notification.NotificationBuilder.this     // Catch:{ Exception -> 0x05dc }
                    android.content.Context r4 = r4.mContext     // Catch:{ Exception -> 0x05dc }
                    java.util.Calendar r9 = java.util.Calendar.getInstance()     // Catch:{ Exception -> 0x05dc }
                    r13 = 11
                    int r9 = r9.get(r13)     // Catch:{ Exception -> 0x05dc }
                    r13 = 134217728(0x8000000, float:3.85186E-34)
                    android.app.PendingIntent r3 = android.app.PendingIntent.getActivity(r4, r9, r3, r13)     // Catch:{ Exception -> 0x05dc }
                    boolean r4 = android.text.TextUtils.isEmpty(r5)     // Catch:{ Exception -> 0x05dc }
                    if (r4 != 0) goto L_0x027b
                    java.lang.String r4 = "Originals"
                    boolean r4 = r4.equalsIgnoreCase(r5)     // Catch:{ Exception -> 0x05dc }
                    if (r4 == 0) goto L_0x027b
                    r32 = 0
                    goto L_0x027d
                L_0x027b:
                    r32 = r30
                L_0x027d:
                    boolean r4 = android.text.TextUtils.isEmpty(r5)     // Catch:{ Exception -> 0x05dc }
                    if (r4 != 0) goto L_0x0494
                    java.lang.String r4 = "custom"
                    boolean r4 = r4.equalsIgnoreCase(r5)     // Catch:{ Exception -> 0x05dc }
                    if (r4 != 0) goto L_0x02b0
                    boolean r4 = r7.equalsIgnoreCase(r5)     // Catch:{ Exception -> 0x05dc }
                    if (r4 != 0) goto L_0x02b0
                    if (r8 != 0) goto L_0x02b0
                    java.lang.String r4 = "nonSticky"
                    boolean r4 = r4.equalsIgnoreCase(r5)     // Catch:{ Exception -> 0x05dc }
                    if (r4 == 0) goto L_0x029c
                    goto L_0x02b0
                L_0x029c:
                    r26 = r6
                    r28 = r10
                    r4 = r19
                    r12 = r21
                    r9 = r23
                    r13 = r25
                    r6 = r32
                    r19 = r5
                    r5 = r22
                    goto L_0x04a6
                L_0x02b0:
                    android.widget.RemoteViews r4 = new android.widget.RemoteViews     // Catch:{ Exception -> 0x05dc }
                    com.mpl.androidapp.notification.NotificationBuilder r7 = com.mpl.androidapp.notification.NotificationBuilder.this     // Catch:{ Exception -> 0x05dc }
                    android.content.Context r7 = r7.mContext     // Catch:{ Exception -> 0x05dc }
                    java.lang.String r7 = r7.getPackageName()     // Catch:{ Exception -> 0x05dc }
                    r9 = 2131558767(0x7f0d016f, float:1.874286E38)
                    r4.<init>(r7, r9)     // Catch:{ Exception -> 0x05dc }
                    android.widget.RemoteViews r7 = new android.widget.RemoteViews     // Catch:{ Exception -> 0x05dc }
                    com.mpl.androidapp.notification.NotificationBuilder r9 = com.mpl.androidapp.notification.NotificationBuilder.this     // Catch:{ Exception -> 0x05dc }
                    android.content.Context r9 = r9.mContext     // Catch:{ Exception -> 0x05dc }
                    java.lang.String r9 = r9.getPackageName()     // Catch:{ Exception -> 0x05dc }
                    r13 = 2131558768(0x7f0d0170, float:1.8742861E38)
                    r7.<init>(r9, r13)     // Catch:{ Exception -> 0x05dc }
                    if (r8 == 0) goto L_0x02f4
                    android.widget.RemoteViews r4 = new android.widget.RemoteViews     // Catch:{ Exception -> 0x05dc }
                    com.mpl.androidapp.notification.NotificationBuilder r7 = com.mpl.androidapp.notification.NotificationBuilder.this     // Catch:{ Exception -> 0x05dc }
                    android.content.Context r7 = r7.mContext     // Catch:{ Exception -> 0x05dc }
                    java.lang.String r7 = r7.getPackageName()     // Catch:{ Exception -> 0x05dc }
                    r4.<init>(r7, r13)     // Catch:{ Exception -> 0x05dc }
                    android.widget.RemoteViews r7 = new android.widget.RemoteViews     // Catch:{ Exception -> 0x05dc }
                    com.mpl.androidapp.notification.NotificationBuilder r9 = com.mpl.androidapp.notification.NotificationBuilder.this     // Catch:{ Exception -> 0x05dc }
                    android.content.Context r9 = r9.mContext     // Catch:{ Exception -> 0x05dc }
                    java.lang.String r9 = r9.getPackageName()     // Catch:{ Exception -> 0x05dc }
                    r7.<init>(r9, r13)     // Catch:{ Exception -> 0x05dc }
                L_0x02f4:
                    r9 = 2131362915(0x7f0a0463, float:1.8345624E38)
                    r13 = r25
                    r4.setTextViewText(r9, r13)     // Catch:{ Exception -> 0x05dc }
                    r9 = 2131362915(0x7f0a0463, float:1.8345624E38)
                    r7.setTextViewText(r9, r13)     // Catch:{ Exception -> 0x05dc }
                    boolean r9 = android.text.TextUtils.isEmpty(r23)     // Catch:{ Exception -> 0x05dc }
                    r13 = 2131362910(0x7f0a045e, float:1.8345614E38)
                    r12 = 8
                    if (r9 != 0) goto L_0x0318
                    r9 = r23
                    r7.setTextViewText(r13, r9)     // Catch:{ Exception -> 0x05dc }
                    if (r8 == 0) goto L_0x031d
                    r4.setTextViewText(r13, r9)     // Catch:{ Exception -> 0x05dc }
                    goto L_0x031d
                L_0x0318:
                    r9 = r23
                    r7.setViewVisibility(r13, r12)     // Catch:{ Exception -> 0x05dc }
                L_0x031d:
                    boolean r28 = android.text.TextUtils.isEmpty(r21)     // Catch:{ Exception -> 0x0374 }
                    if (r28 != 0) goto L_0x035a
                    boolean r28 = android.webkit.URLUtil.isValidUrl(r21)     // Catch:{ Exception -> 0x0374 }
                    if (r28 == 0) goto L_0x035a
                    java.net.URL r13 = new java.net.URL     // Catch:{ Exception -> 0x0374 }
                    r12 = r21
                    r13.<init>(r12)     // Catch:{ Exception -> 0x0374 }
                    java.net.URLConnection r12 = r13.openConnection()     // Catch:{ Exception -> 0x0374 }
                    java.lang.Object r12 = com.google.firebase.perf.network.FirebasePerfUrlConnection.instrument(r12)     // Catch:{ Exception -> 0x0374 }
                    java.net.URLConnection r12 = (java.net.URLConnection) r12     // Catch:{ Exception -> 0x0374 }
                    r13 = 10000(0x2710, float:1.4013E-41)
                    r12.setConnectTimeout(r13)     // Catch:{ Exception -> 0x0374 }
                    r13 = 10000(0x2710, float:1.4013E-41)
                    r12.setReadTimeout(r13)     // Catch:{ Exception -> 0x0374 }
                    java.io.InputStream r12 = r12.getInputStream()     // Catch:{ Exception -> 0x0374 }
                    android.graphics.Bitmap r12 = android.graphics.BitmapFactory.decodeStream(r12)     // Catch:{ Exception -> 0x0374 }
                    android.graphics.Bitmap r12 = com.mpl.androidapp.utils.CommonUtils.getCircularBitmap(r12)     // Catch:{ Exception -> 0x0374 }
                    r13 = 2131362905(0x7f0a0459, float:1.8345604E38)
                    r4.setImageViewBitmap(r13, r12)     // Catch:{ Exception -> 0x0374 }
                    r7.setImageViewBitmap(r13, r12)     // Catch:{ Exception -> 0x0374 }
                    goto L_0x0399
                L_0x035a:
                    if (r8 == 0) goto L_0x0368
                    r12 = 2131231389(0x7f08029d, float:1.8078858E38)
                    r13 = 2131362914(0x7f0a0462, float:1.8345622E38)
                    r4.setImageViewResource(r13, r12)     // Catch:{ Exception -> 0x0374 }
                    r7.setImageViewResource(r13, r12)     // Catch:{ Exception -> 0x0374 }
                L_0x0368:
                    r12 = 8
                    r13 = 2131362905(0x7f0a0459, float:1.8345604E38)
                    r4.setViewVisibility(r13, r12)     // Catch:{ Exception -> 0x0374 }
                    r7.setViewVisibility(r13, r12)     // Catch:{ Exception -> 0x0374 }
                    goto L_0x0399
                L_0x0374:
                    r12 = 1
                    java.lang.Object[] r13 = new java.lang.Object[r12]     // Catch:{ Exception -> 0x05dc }
                    java.lang.String r12 = "showGroupChallengeNotification: Exception in group Icon"
                    r18 = 0
                    r13[r18] = r12     // Catch:{ Exception -> 0x05dc }
                    com.mpl.androidapp.utils.MLogger.e(r6, r13)     // Catch:{ Exception -> 0x05dc }
                    if (r8 == 0) goto L_0x038e
                    r12 = 2131231389(0x7f08029d, float:1.8078858E38)
                    r13 = 2131362914(0x7f0a0462, float:1.8345622E38)
                    r4.setImageViewResource(r13, r12)     // Catch:{ Exception -> 0x05dc }
                    r7.setImageViewResource(r13, r12)     // Catch:{ Exception -> 0x05dc }
                L_0x038e:
                    r12 = 8
                    r13 = 2131362905(0x7f0a0459, float:1.8345604E38)
                    r4.setViewVisibility(r13, r12)     // Catch:{ Exception -> 0x05dc }
                    r7.setViewVisibility(r13, r12)     // Catch:{ Exception -> 0x05dc }
                L_0x0399:
                    com.mpl.androidapp.notification.NotificationBuilder r12 = com.mpl.androidapp.notification.NotificationBuilder.this     // Catch:{ Exception -> 0x05dc }
                    com.mpl.androidapp.notification.NotificationBuilder r13 = com.mpl.androidapp.notification.NotificationBuilder.this     // Catch:{ Exception -> 0x05dc }
                    android.content.Context r13 = r13.mContext     // Catch:{ Exception -> 0x05dc }
                    r26 = r6
                    java.lang.String r6 = "User Specific"
                    androidx.core.app.NotificationCompat$Builder r6 = r12.getNotificationBuilder(r13, r6)     // Catch:{ Exception -> 0x05d8 }
                    long r12 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x05d8 }
                    androidx.core.app.NotificationCompat$Builder r6 = r6.setWhen(r12)     // Catch:{ Exception -> 0x05d8 }
                    androidx.core.app.NotificationCompat$Builder r3 = r6.setContentIntent(r3)     // Catch:{ Exception -> 0x05d8 }
                    androidx.core.app.NotificationCompat$Builder r3 = r3.setCustomContentView(r4)     // Catch:{ Exception -> 0x05d8 }
                    androidx.core.app.NotificationCompat$Builder r3 = r3.setCustomBigContentView(r7)     // Catch:{ Exception -> 0x05d8 }
                    r4 = 2131231343(0x7f08026f, float:1.8078764E38)
                    androidx.core.app.NotificationCompat$Builder r3 = r3.setSmallIcon(r4)     // Catch:{ Exception -> 0x05d8 }
                    androidx.core.app.NotificationCompat$DecoratedCustomViewStyle r4 = new androidx.core.app.NotificationCompat$DecoratedCustomViewStyle     // Catch:{ Exception -> 0x05d8 }
                    r4.<init>()     // Catch:{ Exception -> 0x05d8 }
                    androidx.core.app.NotificationCompat$Builder r3 = r3.setStyle(r4)     // Catch:{ Exception -> 0x05d8 }
                    com.mpl.androidapp.notification.NotificationBuilder r4 = com.mpl.androidapp.notification.NotificationBuilder.this     // Catch:{ Exception -> 0x05d8 }
                    android.content.Context r4 = r4.mContext     // Catch:{ Exception -> 0x05d8 }
                    r6 = 2131100229(0x7f060245, float:1.7812834E38)
                    int r4 = androidx.core.content.ContextCompat.getColor(r4, r6)     // Catch:{ Exception -> 0x05d8 }
                    androidx.core.app.NotificationCompat$Builder r3 = r3.setColor(r4)     // Catch:{ Exception -> 0x05d8 }
                    r4 = 2
                    android.net.Uri r6 = android.media.RingtoneManager.getDefaultUri(r4)     // Catch:{ Exception -> 0x05d8 }
                    androidx.core.app.NotificationCompat$Builder r3 = r3.setSound(r6)     // Catch:{ Exception -> 0x05d8 }
                    r4 = 1
                    long[] r6 = new long[r4]     // Catch:{ Exception -> 0x05d8 }
                    r12 = 1000(0x3e8, double:4.94E-321)
                    r4 = 0
                    r6[r4] = r12     // Catch:{ Exception -> 0x05d8 }
                    androidx.core.app.NotificationCompat$Builder r3 = r3.setVibrate(r6)     // Catch:{ Exception -> 0x05d8 }
                    boolean r4 = android.text.TextUtils.isEmpty(r20)     // Catch:{ Exception -> 0x05d8 }
                    if (r4 == 0) goto L_0x03fc
                    java.lang.String r4 = "Mpl Tournament"
                    goto L_0x03fe
                L_0x03fc:
                    r4 = r20
                L_0x03fe:
                    androidx.core.app.NotificationCompat$Builder r3 = r3.setSubText(r4)     // Catch:{ Exception -> 0x05d8 }
                    r4 = 3
                    androidx.core.app.NotificationCompat$Builder r3 = r3.setDefaults(r4)     // Catch:{ Exception -> 0x05d8 }
                    r4 = 0
                    androidx.core.app.NotificationCompat$Builder r3 = r3.setGroupAlertBehavior(r4)     // Catch:{ Exception -> 0x05d8 }
                    androidx.core.app.NotificationCompat$Builder r3 = r3.setOngoing(r2)     // Catch:{ Exception -> 0x05d8 }
                    android.os.Bundle r4 = com.mpl.androidapp.utils.Util.jsonToBundle(r11)     // Catch:{ Exception -> 0x05d8 }
                    androidx.core.app.NotificationCompat$Builder r3 = r3.setExtras(r4)     // Catch:{ Exception -> 0x05d8 }
                    androidx.core.app.NotificationCompat$Builder r0 = r3.setAutoCancel(r0)     // Catch:{ Exception -> 0x05d8 }
                    r6 = r32
                    r3 = 0
                    int r11 = (r6 > r3 ? 1 : (r6 == r3 ? 0 : -1))
                    if (r11 <= 0) goto L_0x0427
                    r0.setTimeoutAfter(r6)     // Catch:{ Exception -> 0x05d8 }
                L_0x0427:
                    int r3 = android.os.Build.VERSION.SDK_INT     // Catch:{ Exception -> 0x05d8 }
                    r4 = 26
                    if (r3 >= r4) goto L_0x0436
                    com.mpl.androidapp.notification.NotificationBuilder r3 = com.mpl.androidapp.notification.NotificationBuilder.this     // Catch:{ Exception -> 0x05d8 }
                    int r3 = r3.getPriority()     // Catch:{ Exception -> 0x05d8 }
                    r0.setPriority(r3)     // Catch:{ Exception -> 0x05d8 }
                L_0x0436:
                    boolean r3 = android.text.TextUtils.isEmpty(r19)     // Catch:{ Exception -> 0x05d8 }
                    if (r3 != 0) goto L_0x0447
                    com.mpl.androidapp.notification.NotificationBuilder r3 = com.mpl.androidapp.notification.NotificationBuilder.this     // Catch:{ Exception -> 0x05d8 }
                    r4 = r19
                    androidx.core.app.NotificationCompat$BigPictureStyle r3 = r3.getBigPictureInNotification(r4, r9)     // Catch:{ Exception -> 0x05d8 }
                    r0.setStyle(r3)     // Catch:{ Exception -> 0x05d8 }
                L_0x0447:
                    if (r22 == 0) goto L_0x0466
                    int r3 = r22.size()     // Catch:{ Exception -> 0x05d8 }
                    if (r3 <= 0) goto L_0x0466
                    r3 = 0
                L_0x0450:
                    int r4 = r22.size()     // Catch:{ Exception -> 0x05d8 }
                    if (r3 >= r4) goto L_0x0466
                    r4 = r22
                    java.lang.Object r6 = r4.get(r3)     // Catch:{ Exception -> 0x05d8 }
                    androidx.core.app.NotificationCompat$Action r6 = (androidx.core.app.NotificationCompat.Action) r6     // Catch:{ Exception -> 0x05d8 }
                    r0.addAction(r6)     // Catch:{ Exception -> 0x05d8 }
                    int r3 = r3 + 1
                    r22 = r4
                    goto L_0x0450
                L_0x0466:
                    android.app.Notification r0 = r0.build()     // Catch:{ Exception -> 0x05d8 }
                    int r3 = r0.flags     // Catch:{ Exception -> 0x05d8 }
                    r3 = r3 | 34
                    r0.flags = r3     // Catch:{ Exception -> 0x05d8 }
                    if (r2 != 0) goto L_0x047d
                    if (r8 == 0) goto L_0x0475
                    goto L_0x047d
                L_0x0475:
                    com.mpl.androidapp.notification.NotificationBuilder r0 = com.mpl.androidapp.notification.NotificationBuilder.this     // Catch:{ Exception -> 0x05d8 }
                    java.lang.String r2 = r2     // Catch:{ Exception -> 0x05d8 }
                    r0.createNotificationAlarmManagerForNonStickyNotification(r2)     // Catch:{ Exception -> 0x05d8 }
                    goto L_0x048e
                L_0x047d:
                    com.mpl.androidapp.notification.NotificationBuilder r2 = com.mpl.androidapp.notification.NotificationBuilder.this     // Catch:{ Exception -> 0x05d8 }
                    r24 = 0
                    r25 = 1
                    r20 = r2
                    r21 = r27
                    r22 = r10
                    r23 = r0
                    r20.notifyNotification(r21, r22, r23, r24, r25)     // Catch:{ Exception -> 0x05d8 }
                L_0x048e:
                    r19 = r5
                    r28 = r10
                    goto L_0x05ae
                L_0x0494:
                    r26 = r6
                    r4 = r19
                    r12 = r21
                    r9 = r23
                    r13 = r25
                    r6 = r32
                    r19 = r5
                    r5 = r22
                    r28 = r10
                L_0x04a6:
                    com.mpl.androidapp.notification.NotificationBuilder r10 = com.mpl.androidapp.notification.NotificationBuilder.this     // Catch:{ Exception -> 0x05d8 }
                    r20 = r8
                    com.mpl.androidapp.notification.NotificationBuilder r8 = com.mpl.androidapp.notification.NotificationBuilder.this     // Catch:{ Exception -> 0x05d8 }
                    android.content.Context r8 = r8.mContext     // Catch:{ Exception -> 0x05d8 }
                    r22 = r5
                    java.lang.String r5 = "User Specific"
                    androidx.core.app.NotificationCompat$Builder r5 = r10.getNotificationBuilder(r8, r5)     // Catch:{ Exception -> 0x05d8 }
                    androidx.core.app.NotificationCompat$Builder r5 = r5.setWhen(r14)     // Catch:{ Exception -> 0x05d8 }
                    androidx.core.app.NotificationCompat$Builder r3 = r5.setContentIntent(r3)     // Catch:{ Exception -> 0x05d8 }
                    androidx.core.app.NotificationCompat$Builder r3 = r3.setContentTitle(r13)     // Catch:{ Exception -> 0x05d8 }
                    androidx.core.app.NotificationCompat$Builder r3 = r3.setContentText(r9)     // Catch:{ Exception -> 0x05d8 }
                    androidx.core.app.NotificationCompat$Builder r3 = r3.setContentInfo(r9)     // Catch:{ Exception -> 0x05d8 }
                    r5 = 2131231343(0x7f08026f, float:1.8078764E38)
                    androidx.core.app.NotificationCompat$Builder r3 = r3.setSmallIcon(r5)     // Catch:{ Exception -> 0x05d8 }
                    androidx.core.app.NotificationCompat$BigTextStyle r5 = new androidx.core.app.NotificationCompat$BigTextStyle     // Catch:{ Exception -> 0x05d8 }
                    r5.<init>()     // Catch:{ Exception -> 0x05d8 }
                    androidx.core.app.NotificationCompat$BigTextStyle r5 = r5.bigText(r9)     // Catch:{ Exception -> 0x05d8 }
                    androidx.core.app.NotificationCompat$Builder r3 = r3.setStyle(r5)     // Catch:{ Exception -> 0x05d8 }
                    com.mpl.androidapp.notification.NotificationBuilder r5 = com.mpl.androidapp.notification.NotificationBuilder.this     // Catch:{ Exception -> 0x05d8 }
                    android.content.Context r5 = r5.mContext     // Catch:{ Exception -> 0x05d8 }
                    r8 = 2131100229(0x7f060245, float:1.7812834E38)
                    int r5 = androidx.core.content.ContextCompat.getColor(r5, r8)     // Catch:{ Exception -> 0x05d8 }
                    androidx.core.app.NotificationCompat$Builder r3 = r3.setColor(r5)     // Catch:{ Exception -> 0x05d8 }
                    r5 = 2
                    android.net.Uri r8 = android.media.RingtoneManager.getDefaultUri(r5)     // Catch:{ Exception -> 0x05d8 }
                    androidx.core.app.NotificationCompat$Builder r3 = r3.setSound(r8)     // Catch:{ Exception -> 0x05d8 }
                    r5 = 1
                    long[] r8 = new long[r5]     // Catch:{ Exception -> 0x05d8 }
                    r23 = 1000(0x3e8, double:4.94E-321)
                    r5 = 0
                    r8[r5] = r23     // Catch:{ Exception -> 0x05d8 }
                    androidx.core.app.NotificationCompat$Builder r3 = r3.setVibrate(r8)     // Catch:{ Exception -> 0x05d8 }
                    r8 = 3
                    androidx.core.app.NotificationCompat$Builder r3 = r3.setDefaults(r8)     // Catch:{ Exception -> 0x05d8 }
                    androidx.core.app.NotificationCompat$Builder r3 = r3.setGroupAlertBehavior(r5)     // Catch:{ Exception -> 0x05d8 }
                    androidx.core.app.NotificationCompat$Builder r3 = r3.setOngoing(r2)     // Catch:{ Exception -> 0x05d8 }
                    android.os.Bundle r5 = com.mpl.androidapp.utils.Util.jsonToBundle(r11)     // Catch:{ Exception -> 0x05d8 }
                    androidx.core.app.NotificationCompat$Builder r3 = r3.setExtras(r5)     // Catch:{ Exception -> 0x05d8 }
                    androidx.core.app.NotificationCompat$Builder r0 = r3.setAutoCancel(r0)     // Catch:{ Exception -> 0x05d8 }
                    r10 = 0
                    int r3 = (r6 > r10 ? 1 : (r6 == r10 ? 0 : -1))
                    if (r3 <= 0) goto L_0x0528
                    r0.setTimeoutAfter(r6)     // Catch:{ Exception -> 0x05d8 }
                L_0x0528:
                    int r3 = android.os.Build.VERSION.SDK_INT     // Catch:{ Exception -> 0x05d8 }
                    r5 = 26
                    if (r3 >= r5) goto L_0x0537
                    com.mpl.androidapp.notification.NotificationBuilder r3 = com.mpl.androidapp.notification.NotificationBuilder.this     // Catch:{ Exception -> 0x05d8 }
                    int r3 = r3.getPriority()     // Catch:{ Exception -> 0x05d8 }
                    r0.setPriority(r3)     // Catch:{ Exception -> 0x05d8 }
                L_0x0537:
                    boolean r3 = android.text.TextUtils.isEmpty(r4)     // Catch:{ Exception -> 0x05d8 }
                    if (r3 != 0) goto L_0x0546
                    com.mpl.androidapp.notification.NotificationBuilder r3 = com.mpl.androidapp.notification.NotificationBuilder.this     // Catch:{ Exception -> 0x05d8 }
                    androidx.core.app.NotificationCompat$BigPictureStyle r3 = r3.getBigPictureInNotification(r4, r9)     // Catch:{ Exception -> 0x05d8 }
                    r0.setStyle(r3)     // Catch:{ Exception -> 0x05d8 }
                L_0x0546:
                    boolean r3 = android.text.TextUtils.isEmpty(r12)     // Catch:{ Exception -> 0x05d8 }
                    if (r3 != 0) goto L_0x055c
                    boolean r3 = android.webkit.URLUtil.isValidUrl(r12)     // Catch:{ Exception -> 0x05d8 }
                    if (r3 == 0) goto L_0x055c
                    com.mpl.androidapp.notification.NotificationBuilder r3 = com.mpl.androidapp.notification.NotificationBuilder.this     // Catch:{ Exception -> 0x05d8 }
                    android.graphics.Bitmap r3 = r3.getLargeIconInNotification(r12)     // Catch:{ Exception -> 0x05d8 }
                    r0.setLargeIcon(r3)     // Catch:{ Exception -> 0x05d8 }
                    goto L_0x056f
                L_0x055c:
                    com.mpl.androidapp.notification.NotificationBuilder r3 = com.mpl.androidapp.notification.NotificationBuilder.this     // Catch:{ Exception -> 0x05d8 }
                    android.content.Context r3 = r3.mContext     // Catch:{ Exception -> 0x05d8 }
                    android.content.res.Resources r3 = r3.getResources()     // Catch:{ Exception -> 0x05d8 }
                    r4 = 2131689472(0x7f0f0000, float:1.900796E38)
                    android.graphics.Bitmap r3 = android.graphics.BitmapFactory.decodeResource(r3, r4)     // Catch:{ Exception -> 0x05d8 }
                    r0.setLargeIcon(r3)     // Catch:{ Exception -> 0x05d8 }
                L_0x056f:
                    if (r22 == 0) goto L_0x058e
                    int r3 = r22.size()     // Catch:{ Exception -> 0x05d8 }
                    if (r3 <= 0) goto L_0x058e
                    r3 = 0
                L_0x0578:
                    int r4 = r22.size()     // Catch:{ Exception -> 0x05d8 }
                    if (r3 >= r4) goto L_0x058e
                    r8 = r22
                    java.lang.Object r4 = r8.get(r3)     // Catch:{ Exception -> 0x05d8 }
                    androidx.core.app.NotificationCompat$Action r4 = (androidx.core.app.NotificationCompat.Action) r4     // Catch:{ Exception -> 0x05d8 }
                    r0.addAction(r4)     // Catch:{ Exception -> 0x05d8 }
                    int r3 = r3 + 1
                    r22 = r8
                    goto L_0x0578
                L_0x058e:
                    if (r2 != 0) goto L_0x059b
                    if (r20 == 0) goto L_0x0593
                    goto L_0x059b
                L_0x0593:
                    com.mpl.androidapp.notification.NotificationBuilder r0 = com.mpl.androidapp.notification.NotificationBuilder.this     // Catch:{ Exception -> 0x05d8 }
                    java.lang.String r2 = r2     // Catch:{ Exception -> 0x05d8 }
                    r0.createNotificationAlarmManagerForNonStickyNotification(r2)     // Catch:{ Exception -> 0x05d8 }
                    goto L_0x05ae
                L_0x059b:
                    com.mpl.androidapp.notification.NotificationBuilder r2 = com.mpl.androidapp.notification.NotificationBuilder.this     // Catch:{ Exception -> 0x05d8 }
                    android.app.Notification r23 = r0.build()     // Catch:{ Exception -> 0x05d8 }
                    r24 = 0
                    r25 = 1
                    r20 = r2
                    r21 = r27
                    r22 = r28
                    r20.notifyNotification(r21, r22, r23, r24, r25)     // Catch:{ Exception -> 0x05d8 }
                L_0x05ae:
                    boolean r0 = android.text.TextUtils.isEmpty(r19)     // Catch:{ Exception -> 0x05d8 }
                    if (r0 != 0) goto L_0x05cc
                    java.lang.String r0 = "Originals"
                    r5 = r19
                    boolean r0 = r0.equalsIgnoreCase(r5)     // Catch:{ Exception -> 0x05d8 }
                    if (r0 == 0) goto L_0x05cc
                    r2 = 1
                    java.lang.Object[] r0 = new java.lang.Object[r2]     // Catch:{ Exception -> 0x05d8 }
                    java.lang.String r2 = "createStickyNotification:Don't cancel this notification "
                    r3 = 0
                    r0[r3] = r2     // Catch:{ Exception -> 0x05d8 }
                    r2 = r26
                    com.mpl.androidapp.utils.MLogger.d(r2, r0)     // Catch:{ Exception -> 0x05d6 }
                    goto L_0x05ee
                L_0x05cc:
                    r2 = r26
                    com.mpl.androidapp.notification.NotificationBuilder r0 = com.mpl.androidapp.notification.NotificationBuilder.this     // Catch:{ Exception -> 0x05d6 }
                    r10 = r28
                    r0.createNotificationAlarmManagerForCancelNonStickyNotification(r10, r14)     // Catch:{ Exception -> 0x05d6 }
                    goto L_0x05ee
                L_0x05d6:
                    r0 = move-exception
                    goto L_0x05e2
                L_0x05d8:
                    r0 = move-exception
                    r2 = r26
                    goto L_0x05e2
                L_0x05dc:
                    r0 = move-exception
                    goto L_0x05e1
                L_0x05de:
                    r0 = move-exception
                    r29 = r4
                L_0x05e1:
                    r2 = r6
                L_0x05e2:
                    r3 = 2
                    java.lang.Object[] r3 = new java.lang.Object[r3]
                    r4 = 0
                    r3[r4] = r29
                    r4 = 1
                    r3[r4] = r0
                    com.mpl.androidapp.utils.MLogger.e(r2, r3)
                L_0x05ee:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.mpl.androidapp.notification.NotificationBuilder.AnonymousClass3.run():void");
            }
        });
    }

    private void createSendBirdGroupNotification(JSONObject jSONObject) {
        MLogger.d(TAG, "createSendBirdGroupNotification:1 ");
        postTaskToBackgroundThread(new Runnable(jSONObject) {
            public final /* synthetic */ JSONObject f$1;

            {
                this.f$1 = r2;
            }

            public final void run() {
                NotificationBuilder.this.lambda$createSendBirdGroupNotification$8$NotificationBuilder(this.f$1);
            }
        });
    }

    public static Intent buildSendBirdIntent(Context context, JSONObject jSONObject, int i) {
        MLogger.d(TAG, "buildSendBirdIntent:2 ");
        Intent intent = new Intent(context, MPLReactContainerActivity.class);
        Bundle outline14 = GeneratedOutlineSupport.outline14("action", "OPEN_DEEP_LINK");
        outline14.putString("actionParams", "{\"actionType\":\"chat\",\"actionPayload\":" + jSONObject + "}");
        outline14.putInt(Constant.INTENT_EXTRA_NOTIFICATION_ID, i);
        intent.putExtra(Constant.INTENT_EXTRA_NOTIFICATION_ID, i);
        intent.putExtras(outline14);
        return intent;
    }

    public void showNotification(ApkDownloadNotificationData apkDownloadNotificationData) {
        Context context = this.mContext;
        if (context != null) {
            handleNotification(apkDownloadNotificationData, context);
        }
    }

    private boolean isDeviceAndCountrySupported(Bundle bundle) {
        String str;
        MLogger.d(TAG, "isDeviceAndCountrySupported");
        if (bundle != null) {
            try {
                if (bundle.containsKey("supportedDeviceType")) {
                    String string = bundle.getString("supportedDeviceType");
                    MLogger.d(TAG, "isDeviceAndCountrySupported -> Devices : " + string);
                    if (string != null && !string.contains("android")) {
                        return false;
                    }
                }
                if (bundle.containsKey("supportedCountryCode")) {
                    String string2 = bundle.getString("supportedCountryCode");
                    MLogger.d(TAG, "isDeviceAndCountrySupported -> countryCodes : " + string2 + ", userCountryCode : " + str);
                    if (string2 != null && !string2.contains(str)) {
                        return false;
                    }
                }
                if (!bundle.containsKey("supportedDeviceType") && !bundle.containsKey("supportedCountryCode") && bundle.containsKey("data")) {
                    String string3 = bundle.getString("data");
                    return string3 == null || isDeviceAndCountrySupported(string3);
                }
            } catch (Exception e2) {
                MLogger.e(TAG, GeneratedOutlineSupport.outline39(e2, GeneratedOutlineSupport.outline73("Error in isDeviceAndCountrySupported : ")));
            }
        } else {
            MLogger.d(TAG, "Bundle null");
        }
    }
}
