package com.mpl.androidapp.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.freshchat.consumer.sdk.Freshchat;
import com.freshchat.consumer.sdk.FreshchatConfig;
import com.freshchat.consumer.sdk.FreshchatNotificationConfig;
import com.freshchat.consumer.sdk.FreshchatUser;
import com.google.firebase.messaging.RemoteMessage;
import com.mpl.androidapp.R;
import com.xiaomi.mipush.sdk.Constants;

public class FreshChatUtils {
    public static final String TAG = "FreshChatUtils";
    public static BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            String restoreId = Freshchat.getInstance(context).getUser().getRestoreId();
            MSharedPreferencesUtils.saveStringInNormalPref(context, "freshChatRestoreId", restoreId);
            MLogger.d(FreshChatUtils.TAG, "onReceive:3 FreshChat ", restoreId);
        }
    };

    public static void handleFcmMessage(Context context, RemoteMessage remoteMessage) {
        Freshchat.handleFcmMessage(context, remoteMessage);
    }

    public static void initFreshChat(Context context) {
        if (context != null) {
            FreshchatConfig freshchatConfig = new FreshchatConfig(MBuildConfigUtils.getFreshChatAppId(), MBuildConfigUtils.getFreshChatAppKey());
            freshchatConfig.setCameraCaptureEnabled(true);
            freshchatConfig.setGallerySelectionEnabled(true);
            freshchatConfig.setResponseExpectationEnabled(true);
            freshchatConfig.setTeamMemberInfoVisible(true);
            freshchatConfig.setUserEventsTrackingEnabled(true);
            freshchatConfig.setDomain(MBuildConfigUtils.getFreshChatAppDomain());
            Freshchat.getInstance(context).init(freshchatConfig);
        }
    }

    public static boolean isFreshchatNotification(RemoteMessage remoteMessage) {
        return Freshchat.isFreshchatNotification((Object) remoteMessage);
    }

    public static void sendUserInfoToFreshChat(Context context, int i, String str) {
        try {
            FreshchatUser user = Freshchat.getInstance(context).getUser();
            user.setFirstName(str);
            user.setEmail(MBuildConfigUtils.getCountryCode().toLowerCase() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + i + "@mplsupport.com");
            Freshchat.getInstance(context).setUser(user);
            FreshchatNotificationConfig freshchatNotificationConfig = new FreshchatNotificationConfig();
            freshchatNotificationConfig.setSmallIcon(R.drawable.ic_stat_mpl);
            freshchatNotificationConfig.setLargeIcon(R.mipmap.ic_launcher);
            Freshchat.getInstance(context).setNotificationConfig(freshchatNotificationConfig);
            String restoreId = user.getRestoreId();
            if (!TextUtils.isEmpty(restoreId)) {
                Freshchat.getInstance(context).identifyUser(String.valueOf(i), restoreId);
                MLogger.d(TAG, "onReceive:1 FreshChat ", restoreId);
            } else {
                String stringInNormalPref = MSharedPreferencesUtils.getStringInNormalPref(context, "freshChatRestoreId", "");
                if (!TextUtils.isEmpty(stringInNormalPref)) {
                    Freshchat.getInstance(context).identifyUser(String.valueOf(i), stringInNormalPref);
                    MLogger.d(TAG, "onReceive:2 FreshChat ", stringInNormalPref);
                } else {
                    Freshchat.getInstance(context).identifyUser(String.valueOf(i), null);
                }
            }
            LocalBroadcastManager.getInstance(context).registerReceiver(broadcastReceiver, new IntentFilter(Freshchat.FRESHCHAT_USER_RESTORE_ID_GENERATED));
        } catch (Exception e2) {
            MLogger.printStackTrace(e2);
        }
    }

    public static void setPushRegistrationToken(Context context, String str) {
        Freshchat.getInstance(context).setPushRegistrationToken(str);
    }

    public static void showConversations(Context context) {
        Freshchat.showConversations(context);
    }

    public static void unregisterReceiver(Context context) {
        LocalBroadcastManager.getInstance(context).unregisterReceiver(broadcastReceiver);
    }
}
