package com.mpl.androidapp.utils;

import android.os.Bundle;
import com.mpl.androidapp.updater.util.StatusType;

public class MessageEvent {
    public int appEventName;
    public Bundle bundle;
    public boolean isAppService;
    public MqttObject mqttObj;
    public StatusType statusType;

    public static class MqttObject {
        public String actionType;
        public String message;
        public String topic;
        public String[] topics;

        public String getActionType() {
            return this.actionType;
        }

        public String getMessage() {
            return this.message;
        }

        public String getTopic() {
            return this.topic;
        }

        public String[] getTopics() {
            return this.topics;
        }

        public void setActionType(String str) {
            this.actionType = str;
        }

        public void setMessage(String str) {
            this.message = str;
        }

        public void setTopic(String str) {
            this.topic = str;
        }

        public void setTopics(String[] strArr) {
            this.topics = strArr;
        }
    }

    public int getAppEventName() {
        return this.appEventName;
    }

    public Bundle getBundle() {
        return this.bundle;
    }

    public MqttObject getMqttObj() {
        return this.mqttObj;
    }

    public StatusType getStatusType() {
        return this.statusType;
    }

    public boolean isAppService() {
        return this.isAppService;
    }

    public void setAppEventName(int i) {
        this.appEventName = i;
    }

    public void setAppService(boolean z) {
        this.isAppService = z;
    }

    public void setBundle(Bundle bundle2) {
        this.bundle = bundle2;
    }

    public void setMqttObj(MqttObject mqttObject) {
        this.mqttObj = mqttObject;
    }

    public void setStatusType(StatusType statusType2) {
        this.statusType = statusType2;
    }
}
