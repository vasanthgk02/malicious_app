package com.mpl.androidapp.notification;

import android.app.DownloadManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import androidx.core.app.NotificationManagerCompat;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.mpl.androidapp.cleverTap.AssetsAnalytics;
import com.mpl.androidapp.utils.CleverTapAnalyticsUtils;
import com.mpl.androidapp.utils.Constant;
import com.mpl.androidapp.utils.Constant.EventsConstants;
import com.mpl.androidapp.utils.FileUtils;
import com.mpl.androidapp.utils.MLogger;
import com.mpl.androidapp.utils.MSharedPreferencesUtils;
import com.mpl.androidapp.utils.Util;
import java.util.HashMap;

public class MPLNotificationCancelReceiver extends BroadcastReceiver {
    public static final String TAG = "MPLNotificationCancelRe";

    private void localBroadcastToNotifyCancelClicked(Context context, int i) {
        MSharedPreferencesUtils.putNotificationCancelReceiverId(String.valueOf(i));
        Intent intent = new Intent(Constant.NOTIFICATION_CANCELLED);
        intent.putExtra("game_id", i);
        LocalBroadcastManager.getInstance(context).sendBroadcast(intent);
    }

    public void onReceive(Context context, Intent intent) {
        try {
            int intExtra = intent.getIntExtra(Constant.NOTIFICATION_ID, 0);
            String str = "";
            if (intent.hasExtra(Constant.NOTIFICATION_TYPE)) {
                str = intent.getStringExtra(Constant.NOTIFICATION_TYPE);
            }
            if (TextUtils.isEmpty(str) || !Constant.APK_DOWNLOAD_FLOW.equalsIgnoreCase(str)) {
                CleverTapAnalyticsUtils.setOriginalNotificationEvent(true);
            } else {
                try {
                    long longExtra = intent.getLongExtra("downloadRequestId", 0);
                    String stringExtra = intent.getStringExtra("serverVersion");
                    MLogger.d(TAG, "onReceive:MPLNotificationCancelReceiver ", "downloadRequestId: ", Long.valueOf(longExtra), "serverVersionCode:", stringExtra);
                    if (longExtra == 0 || TextUtils.isEmpty(stringExtra)) {
                        MLogger.e(TAG, "MPLNotificationCancelReceiver:downloadRequestId or server Code not found ");
                    } else {
                        Util.deleteRecursive(FileUtils.getThirdPartyAppDownloadDir(context, intExtra, Long.parseLong(stringExtra)));
                        MSharedPreferencesUtils.deleteNormalPref(context, intExtra + "_" + stringExtra, Constant.THIRD_PARTY_APK_GAME_STATUS);
                        MSharedPreferencesUtils.deleteNormalPref(context, String.valueOf(longExtra), Constant.THIRD_PARTY_APK_GAME_STATUS);
                        ((DownloadManager) context.getSystemService(Constant.DOWNLOAD)).remove(new long[]{longExtra});
                        HashMap hashMap = new HashMap();
                        hashMap.put(EventsConstants.CTA, "Download Cancelled on MPL Notif");
                        hashMap.put("Game ID", Integer.valueOf(intExtra));
                        hashMap.put(AssetsAnalytics.PROP_GAME_VERSION, stringExtra);
                        CleverTapAnalyticsUtils.sendEvent((String) "Button Clicked", hashMap);
                        localBroadcastToNotifyCancelClicked(context, intExtra);
                    }
                } catch (Exception e2) {
                    MLogger.e(TAG, "MPLNotificationCancelReceiver: ", e2);
                }
            }
            NotificationManagerCompat from = NotificationManagerCompat.from(context);
            if (intExtra != 0 && from != null) {
                from.cancel(intExtra);
            }
        } catch (Exception unused) {
        }
    }
}
