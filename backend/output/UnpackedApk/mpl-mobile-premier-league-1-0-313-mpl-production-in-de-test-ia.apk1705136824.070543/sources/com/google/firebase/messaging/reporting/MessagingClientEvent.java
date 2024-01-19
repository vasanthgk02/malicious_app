package com.google.firebase.messaging.reporting;

import com.google.firebase.encoders.proto.ProtoEnum;

public final class MessagingClientEvent {
    public final String analytics_label_;
    public final long bulk_id_;
    public final long campaign_id_;
    public final String collapse_key_;
    public final String composer_label_;
    public final Event event_;
    public final String instance_id_;
    public final String message_id_;
    public final MessageType message_type_;
    public final String package_name_;
    public final int priority_;
    public final long project_number_;
    public final SDKPlatform sdk_platform_;
    public final String topic_;
    public final int ttl_;

    public static final class Builder {
        public String analytics_label_ = "";
        public long bulk_id_ = 0;
        public long campaign_id_ = 0;
        public String collapse_key_ = "";
        public String composer_label_ = "";
        public Event event_ = Event.UNKNOWN_EVENT;
        public String instance_id_ = "";
        public String message_id_ = "";
        public MessageType message_type_ = MessageType.UNKNOWN;
        public String package_name_ = "";
        public int priority_ = 0;
        public long project_number_ = 0;
        public SDKPlatform sdk_platform_ = SDKPlatform.UNKNOWN_OS;
        public String topic_ = "";
        public int ttl_ = 0;

        public MessagingClientEvent build() {
            MessagingClientEvent messagingClientEvent = new MessagingClientEvent(this.project_number_, this.message_id_, this.instance_id_, this.message_type_, this.sdk_platform_, this.package_name_, this.collapse_key_, this.priority_, this.ttl_, this.topic_, this.bulk_id_, this.event_, this.analytics_label_, this.campaign_id_, this.composer_label_);
            return messagingClientEvent;
        }
    }

    public enum Event implements ProtoEnum {
        UNKNOWN_EVENT(0),
        MESSAGE_DELIVERED(1),
        MESSAGE_OPEN(2);
        
        public final int number_;

        /* access modifiers changed from: public */
        Event(int i) {
            this.number_ = i;
        }

        public int getNumber() {
            return this.number_;
        }
    }

    public enum MessageType implements ProtoEnum {
        UNKNOWN(0),
        DATA_MESSAGE(1),
        TOPIC(2),
        DISPLAY_NOTIFICATION(3);
        
        public final int number_;

        /* access modifiers changed from: public */
        MessageType(int i) {
            this.number_ = i;
        }

        public int getNumber() {
            return this.number_;
        }
    }

    public enum SDKPlatform implements ProtoEnum {
        UNKNOWN_OS(0),
        ANDROID(1),
        IOS(2),
        WEB(3);
        
        public final int number_;

        /* access modifiers changed from: public */
        SDKPlatform(int i) {
            this.number_ = i;
        }

        public int getNumber() {
            return this.number_;
        }
    }

    static {
        new Builder().build();
    }

    public MessagingClientEvent(long j, String str, String str2, MessageType messageType, SDKPlatform sDKPlatform, String str3, String str4, int i, int i2, String str5, long j2, Event event, String str6, long j3, String str7) {
        this.project_number_ = j;
        this.message_id_ = str;
        this.instance_id_ = str2;
        this.message_type_ = messageType;
        this.sdk_platform_ = sDKPlatform;
        this.package_name_ = str3;
        this.collapse_key_ = str4;
        this.priority_ = i;
        this.ttl_ = i2;
        this.topic_ = str5;
        this.bulk_id_ = j2;
        this.event_ = event;
        this.analytics_label_ = str6;
        this.campaign_id_ = j3;
        this.composer_label_ = str7;
    }

    public static Builder newBuilder() {
        return new Builder();
    }
}
