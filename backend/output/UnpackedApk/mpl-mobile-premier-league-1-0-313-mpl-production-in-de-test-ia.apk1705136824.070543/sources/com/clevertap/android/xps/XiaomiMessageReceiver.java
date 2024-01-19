package com.clevertap.android.xps;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import co.hyperverge.hypersnapsdk.c.k;
import com.clevertap.android.sdk.CleverTapAPI;
import com.clevertap.android.sdk.CleverTapAPI.LogLevel;
import com.clevertap.android.sdk.Logger;
import com.clevertap.android.sdk.pushnotification.PushConstants.PushType;
import com.clevertap.android.sdk.pushnotification.PushNotificationHandler.SingletonNotificationHandler;
import com.xiaomi.channel.commonutils.android.Region;
import com.xiaomi.mipush.sdk.MiPushClient;
import com.xiaomi.mipush.sdk.MiPushCommandMessage;
import com.xiaomi.mipush.sdk.MiPushMessage;
import com.xiaomi.mipush.sdk.PushMessageReceiver;
import java.util.List;
import java.util.Objects;

public class XiaomiMessageReceiver extends PushMessageReceiver {
    public IMiMessageHandler handler;
    public final XiaomiNotificationParser xpsParser;

    public XiaomiMessageReceiver() {
        XiaomiNotificationParser xiaomiNotificationParser = new XiaomiNotificationParser();
        this.xpsParser = xiaomiNotificationParser;
        this.handler = new CTXiaomiMessageHandler(xiaomiNotificationParser);
    }

    public void onNotificationMessageArrived(Context context, MiPushMessage miPushMessage) {
        super.onNotificationMessageArrived(context, miPushMessage);
        Logger.d("PushProvider", XpsConstants.XIAOMI_LOG_TAG + "onNotificationMessageArrived is called");
        XiaomiNotificationParser xiaomiNotificationParser = this.xpsParser;
        try {
            Objects.requireNonNull(miPushMessage, "MiPushMessage must not be null");
            Objects.requireNonNull(xiaomiNotificationParser, "XiaomiNotificationParser must not be null");
            Bundle bundle = xiaomiNotificationParser.toBundle(miPushMessage);
            Objects.requireNonNull(bundle, "Bundle data must not be null");
            String accountIdFromNotificationBundle = k.getAccountIdFromNotificationBundle(bundle);
            Objects.requireNonNull(context, "Context must not be null");
            Objects.requireNonNull(accountIdFromNotificationBundle, "acc must not be null");
            CleverTapAPI fromAccountId = CleverTapAPI.fromAccountId(context, accountIdFromNotificationBundle);
            Objects.requireNonNull(fromAccountId, "CleverTapAPI must not be null");
            fromAccountId.pushNotificationViewedEvent(bundle);
        } catch (Throwable unused) {
            int i = CleverTapAPI.debugLevel;
            LogLevel.INFO.intValue();
        }
    }

    public void onReceivePassThroughMessage(Context context, MiPushMessage miPushMessage) {
        Logger.d("PushProvider", XpsConstants.XIAOMI_LOG_TAG + "onReceivePassThroughMessage is called");
        Bundle bundle = ((CTXiaomiMessageHandler) this.handler).mParser.toBundle(miPushMessage);
        if (bundle != null) {
            try {
                SingletonNotificationHandler.INSTANCE.onMessageReceived(context, bundle, PushType.XPS.toString());
            } catch (Throwable th) {
                th.printStackTrace();
                Logger.d("PushProvider", XpsConstants.XIAOMI_LOG_TAG + "Error Creating Notification", th);
            }
        }
    }

    public void onReceiveRegisterResult(Context context, MiPushCommandMessage miPushCommandMessage) {
        super.onReceiveRegisterResult(context, miPushCommandMessage);
        Logger.d("PushProvider", XpsConstants.XIAOMI_LOG_TAG + "onReceiveRegisterResult is called");
        String str = null;
        if (((CTXiaomiMessageHandler) this.handler) != null) {
            try {
                Logger.d("PushProvider", "onReceiveRegisterResult() : Message: " + miPushCommandMessage);
                if (!MiPushClient.COMMAND_REGISTER.equals(miPushCommandMessage.getCommand())) {
                    Logger.d("PushProvider", "onReceiveRegisterResult() : Received command is not register command.");
                } else if (miPushCommandMessage.getResultCode() != 0) {
                    Logger.d("PushProvider", "onReceiveRegisterResult() : Registration failed.");
                } else {
                    List<String> commandArguments = miPushCommandMessage.getCommandArguments();
                    if (commandArguments != null && commandArguments.size() > 0) {
                        str = commandArguments.get(0);
                    }
                    if (TextUtils.isEmpty(str)) {
                        Logger.d("PushProvider", "onReceiveRegisterResult() : Token is null or empty");
                        return;
                    }
                    String appRegion = MiPushClient.getAppRegion(context);
                    if (TextUtils.isEmpty(appRegion)) {
                        appRegion = Region.Global.name();
                    }
                    Logger.v("default CTXiaomiMessageHandler: onReceiveRegisterResult | MiPushClient.getAppRegion(context) returns region=" + appRegion);
                    PushType.XPS.setServerRegion(appRegion);
                    String type = PushType.XPS.getType();
                    if (type.equals(PushType.FCM.getType())) {
                        CleverTapAPI.tokenRefresh(context, str, PushType.FCM);
                    } else if (type.equals(PushType.HPS.getType())) {
                        CleverTapAPI.tokenRefresh(context, str, PushType.HPS);
                    } else if (type.equals(PushType.XPS.getType())) {
                        CleverTapAPI.tokenRefresh(context, str, PushType.XPS);
                    }
                }
            } catch (Throwable th) {
                Logger.d("PushProvider", "onReceiveRegisterResult() : Exception: ", th);
            }
        } else {
            throw null;
        }
    }
}
