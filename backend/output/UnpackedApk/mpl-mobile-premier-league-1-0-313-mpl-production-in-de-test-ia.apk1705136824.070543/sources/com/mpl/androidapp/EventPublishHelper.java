package com.mpl.androidapp;

import android.content.Context;
import android.os.Bundle;
import com.mpl.androidapp.updater.util.StatusType;
import com.mpl.androidapp.utils.Constant;
import com.mpl.androidapp.utils.MLogger;
import com.mpl.androidapp.utils.MessageEvent;
import com.mpl.androidapp.utils.MessageEvent.MqttObject;
import org.eclipse.paho.android.service.MqttServiceConstants;
import org.greenrobot.eventbus.EventBus;

public class EventPublishHelper {
    public static final String TAG = "EventPublishHelper";

    public static void bindServiceEvent(Context context, boolean z) {
        MLogger.d(TAG, Constant.APP_UPDATE_CHECK, "bindServiceEvent:isAppService ", Boolean.valueOf(z));
        MessageEvent messageEvent = new MessageEvent();
        messageEvent.setAppEventName(8);
        messageEvent.setAppService(z);
        EventBus.getDefault().post(messageEvent);
    }

    public static void emitSendBirdDataToReact(Context context, String str, String str2) {
        MLogger.d(TAG, "emitSendBirdDataToReact: ");
        MessageEvent messageEvent = new MessageEvent();
        messageEvent.setAppEventName(3);
        MqttObject mqttObject = new MqttObject();
        mqttObject.setTopic(str);
        mqttObject.setActionType("sendBirdNotificationReceived");
        mqttObject.setMessage(str2);
        messageEvent.setMqttObj(mqttObject);
        EventBus.getDefault().post(messageEvent);
    }

    public static void publishAssetsBundleDownloadedStatusEvent(Context context, Bundle bundle) {
        MLogger.d(TAG, "publishAssetsBundleDownloadedStatusEvent: ");
        MessageEvent messageEvent = new MessageEvent();
        messageEvent.setAppEventName(5);
        messageEvent.setBundle(bundle);
        EventBus.getDefault().post(messageEvent);
    }

    public static void publishChallengeCancelData(Context context, String str) {
    }

    public static void publishInitialStatusEvent(Context context, StatusType statusType) {
        MLogger.d(TAG, Constant.APP_UPDATE_CHECK, "publishInitialStatusEvent: ", statusType.name());
        MessageEvent messageEvent = new MessageEvent();
        messageEvent.setAppEventName(7);
        messageEvent.setStatusType(statusType);
        EventBus.getDefault().post(messageEvent);
    }

    public static void publishMqttMessageReceiveEvent(Context context, String str) {
        MLogger.d(TAG, "publishMqttMessageReceiveEvent: ");
        MessageEvent messageEvent = new MessageEvent();
        messageEvent.setAppEventName(4);
        MqttObject mqttObject = new MqttObject();
        mqttObject.setMessage(str);
        messageEvent.setMqttObj(mqttObject);
        EventBus.getDefault().post(messageEvent);
    }

    public static void publishOnCompleteHomePageLoaded(Context context) {
        MLogger.d(TAG, "publishOnCompleteHomePageLoaded: ");
        MessageEvent messageEvent = new MessageEvent();
        messageEvent.setAppEventName(9);
        EventBus.getDefault().post(messageEvent);
    }

    public static void publishProceedAfterLoginData(Context context) {
        MLogger.d(TAG, "publishProceedAfterLoginData: ");
        MessageEvent messageEvent = new MessageEvent();
        messageEvent.setAppEventName(1);
        EventBus.getDefault().post(messageEvent);
    }

    public static void publishProceedHomeData(Context context) {
        MLogger.d(TAG, "publishProceedHomeData: ");
        MessageEvent messageEvent = new MessageEvent();
        messageEvent.setAppEventName(2);
        EventBus.getDefault().post(messageEvent);
    }

    public static void publishReactBundleDownloadedStatusEvent(Context context, StatusType statusType) {
        MLogger.d(TAG, Constant.APP_UPDATE_CHECK, "publishReactBundleDownloadedStatusEvent: ", statusType.name());
        MessageEvent messageEvent = new MessageEvent();
        messageEvent.setAppEventName(6);
        messageEvent.setStatusType(statusType);
        EventBus.getDefault().post(messageEvent);
    }

    public static void publishToMqttChannel(Context context, String str, String str2) {
        MLogger.d(TAG, "publishToMqttChannel: ");
        MessageEvent messageEvent = new MessageEvent();
        messageEvent.setAppEventName(3);
        MqttObject mqttObject = new MqttObject();
        mqttObject.setTopic(str);
        mqttObject.setActionType("publish");
        mqttObject.setMessage(str2);
        messageEvent.setMqttObj(mqttObject);
        EventBus.getDefault().post(messageEvent);
    }

    public static void subscribeToMqttChannel(Context context, String[] strArr, boolean z) {
        MLogger.d(TAG, "subscribeToMqttChannel: ");
        MessageEvent messageEvent = new MessageEvent();
        messageEvent.setAppEventName(3);
        MqttObject mqttObject = new MqttObject();
        mqttObject.setTopics(strArr);
        mqttObject.setActionType(z ? MqttServiceConstants.SUBSCRIBE_ACTION : MqttServiceConstants.UNSUBSCRIBE_ACTION);
        messageEvent.setMqttObj(mqttObject);
        EventBus.getDefault().post(messageEvent);
    }
}
