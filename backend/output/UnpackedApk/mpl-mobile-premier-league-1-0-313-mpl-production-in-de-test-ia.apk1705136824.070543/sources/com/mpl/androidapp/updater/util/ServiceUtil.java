package com.mpl.androidapp.updater.util;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat.Builder;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.content.ContextCompat;
import androidx.core.content.FileProvider;
import com.mpl.androidapp.R;
import com.mpl.androidapp.react.MPLReactContainerActivity;
import com.mpl.androidapp.updater.repo.AppUpdater;
import com.mpl.androidapp.updater.repo.BundleUpdater;
import com.mpl.androidapp.utils.Constant;
import com.mpl.androidapp.utils.MLogger;
import com.mpl.androidapp.utils.MSharedPreferencesUtils;
import java.io.File;
import org.eclipse.paho.client.mqttv3.internal.ClientDefaults;

public class ServiceUtil {
    public static int DOWNLOAD_FAIL_NOTIF_ID = 3002;
    public static int INSTALL_UPDATE_NOTIF_ID = 3214;
    public static ServiceUtil INSTANCE;

    public static void clearNotification(Context context, int i) {
        ((NotificationManager) context.getSystemService("notification")).cancel(i);
    }

    public static void createNotificationChannel(Context context) {
        if (VERSION.SDK_INT >= 26) {
            NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
            NotificationChannel notificationChannel = new NotificationChannel(UpdaterConstant.UPDATER_ID, context.getString(R.string.update_channel), 2);
            notificationChannel.setDescription(context.getString(R.string.update_channel_desc));
            notificationChannel.enableLights(true);
            notificationChannel.setShowBadge(true);
            if (notificationManager != null) {
                notificationManager.createNotificationChannel(notificationChannel);
            }
        }
    }

    public static Builder createUpdaterDownloadNotification(Context context, boolean z) {
        long currentTimeMillis = System.currentTimeMillis();
        createNotificationChannel(context);
        Intent intent = new Intent(context, MPLReactContainerActivity.class);
        if (z) {
            Bundle bundle = new Bundle();
            bundle.putString("action", "OPEN_DEEP_LINK");
            bundle.putString("actionParams", "{\"actionType\":\"nav\",\"actionPayload\":{\"route\":\"Settings\",\"param\":{\"isNotification\":true}}}");
            intent.putExtras(bundle);
        }
        PendingIntent activity = PendingIntent.getActivity(context, 0, intent, 134217728);
        Builder builder = new Builder(context, (String) UpdaterConstant.UPDATER_ID);
        builder.setLargeIcon(BitmapFactory.decodeResource(context.getResources(), R.drawable.ic_downloading_updater));
        builder.setSmallIcon((int) R.drawable.ic_stat_mpl);
        builder.setOngoing(true);
        builder.setChannelId(UpdaterConstant.UPDATER_ID);
        builder.setContentTitle(context.getString(R.string.update_message));
        builder.setContentText("2% " + context.getString(R.string.done));
        builder.setContentIntent(activity);
        builder.setColor(ContextCompat.getColor(context, R.color.notif_action_button));
        MLogger.d(Constant.APP_UPDATE_CHECK, "createUpdaterDownloadNotification:time taken for creating notification channel ", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        return builder;
    }

    public static void createUpdaterInstallNotification(Context context, File file) {
        createNotificationChannel(context);
        Intent intent = new Intent("android.intent.action.VIEW");
        if (VERSION.SDK_INT > 23) {
            intent.setDataAndType(FileProvider.getUriForFile(context, context.getApplicationContext().getPackageName() + ".provider", file), "application/vnd.android.package-archive");
            intent.addFlags(1);
        } else {
            intent.addFlags(ClientDefaults.MAX_MSG_SIZE);
            intent.setDataAndType(Uri.fromFile(file), "application/vnd.android.package-archive");
        }
        PendingIntent activity = PendingIntent.getActivity(context, 0, intent, 1073741824);
        Builder builder = new Builder(context, (String) UpdaterConstant.UPDATER_ID);
        builder.setLargeIcon(BitmapFactory.decodeResource(context.getResources(), R.drawable.ic_update_downloaded));
        builder.setSmallIcon((int) R.drawable.ic_stat_mpl);
        builder.setOngoing(true);
        builder.setChannelId(UpdaterConstant.UPDATER_ID);
        builder.setContentTitle(context.getString(R.string.ready_to_install_update));
        builder.setContentText(context.getString(R.string.tap_to_install_update));
        builder.setContentIntent(activity);
        builder.setColor(ContextCompat.getColor(context, R.color.notif_action_button));
        builder.setAutoCancel(true);
        ((NotificationManager) context.getSystemService("notification")).notify(INSTALL_UPDATE_NOTIF_ID, builder.build());
    }

    public static ServiceUtil getInstance() {
        ServiceUtil serviceUtil;
        ServiceUtil serviceUtil2 = INSTANCE;
        if (serviceUtil2 != null) {
            return serviceUtil2;
        }
        synchronized (ServiceUtil.class) {
            try {
                serviceUtil = new ServiceUtil();
                INSTANCE = serviceUtil;
            }
        }
        return serviceUtil;
    }

    public static Notification getNotification(Context context, String str) {
        return new Builder(context, (String) UpdaterConstant.UPDATER_ID).setSmallIcon((int) R.drawable.ic_stat_mpl).setOngoing(true).setChannelId(UpdaterConstant.UPDATER_ID).setContentTitle(context.getString(R.string.update_message)).setContentText(str).build();
    }

    public static void updateAppDownloadNotificationProgress(Context context, int i, int i2, Builder builder) {
        Intent intent = new Intent(context, MPLReactContainerActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("action", "OPEN_DEEP_LINK");
        bundle.putString("actionParams", "{\"actionType\":\"nav\",\"actionPayload\":{\"route\":\"Settings\",\"param\":{\"isNotification\":true}}}");
        intent.putExtras(bundle);
        builder.setContentIntent(PendingIntent.getActivity(context, 0, intent, 134217728));
        builder.setContentText(i2 + "% " + context.getString(R.string.done));
        NotificationManagerCompat.from(context).notify(i, builder.build());
    }

    public static void updaterDownloadIssueNotification(Context context) {
        Builder builder = new Builder(context, (String) UpdaterConstant.UPDATER_ID);
        builder.setLargeIcon(BitmapFactory.decodeResource(context.getResources(), R.drawable.ic_apk_download_fail));
        builder.setSmallIcon((int) R.drawable.ic_stat_mpl);
        builder.setOngoing(false);
        builder.setChannelId(UpdaterConstant.UPDATER_ID);
        builder.setContentTitle(context.getString(R.string.download_mpl_update_has_an_issue));
        builder.setContentText(context.getString(R.string.try_updating_the_app_after_some_time));
        builder.setColor(ContextCompat.getColor(context, R.color.notif_action_button));
        builder.setAutoCancel(true);
        ((NotificationManager) context.getSystemService("notification")).notify(DOWNLOAD_FAIL_NOTIF_ID, builder.build());
    }

    public void startService(Context context, boolean z) {
        String str;
        MLogger.d(Constant.APP_UPDATE_CHECK, "startService:isReactBundleUpdate ", Boolean.valueOf(z));
        Intent intent = z ? new Intent(context, BundleUpdater.class) : new Intent(context, AppUpdater.class);
        try {
            str = MSharedPreferencesUtils.getAccessUserToken();
        } catch (Exception unused) {
            str = "";
        }
        if (!TextUtils.isEmpty(str)) {
            intent.putExtra(Constant.EXTRA_ACCESS_TOKEN, str);
        }
        if (VERSION.SDK_INT >= 26) {
            createNotificationChannel(context);
            context.startForegroundService(intent);
            return;
        }
        context.startService(intent);
    }
}
