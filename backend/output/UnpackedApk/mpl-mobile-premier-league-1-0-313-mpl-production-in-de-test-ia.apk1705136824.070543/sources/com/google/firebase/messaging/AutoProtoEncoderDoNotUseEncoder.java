package com.google.firebase.messaging;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import com.google.firebase.encoders.config.Configurator;
import com.google.firebase.encoders.config.EncoderConfig;
import com.google.firebase.encoders.proto.AtProtobuf$ProtobufImpl;
import com.google.firebase.encoders.proto.Protobuf.IntEncoding;
import com.google.firebase.messaging.reporting.MessagingClientEvent;
import com.google.firebase.messaging.reporting.MessagingClientEventExtension;
import com.netcore.android.notification.SMTNotificationConstants;
import com.xiaomi.mipush.sdk.MiPushMessage;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class AutoProtoEncoderDoNotUseEncoder implements Configurator {
    public static final Configurator CONFIG = new AutoProtoEncoderDoNotUseEncoder();

    public static final class MessagingClientEventEncoder implements ObjectEncoder<MessagingClientEvent> {
        public static final FieldDescriptor ANALYTICSLABEL_DESCRIPTOR;
        public static final FieldDescriptor BULKID_DESCRIPTOR;
        public static final FieldDescriptor CAMPAIGNID_DESCRIPTOR;
        public static final FieldDescriptor COLLAPSEKEY_DESCRIPTOR;
        public static final FieldDescriptor COMPOSERLABEL_DESCRIPTOR;
        public static final FieldDescriptor EVENT_DESCRIPTOR;
        public static final MessagingClientEventEncoder INSTANCE = new MessagingClientEventEncoder();
        public static final FieldDescriptor INSTANCEID_DESCRIPTOR;
        public static final FieldDescriptor MESSAGEID_DESCRIPTOR;
        public static final FieldDescriptor MESSAGETYPE_DESCRIPTOR;
        public static final FieldDescriptor PACKAGENAME_DESCRIPTOR;
        public static final FieldDescriptor PRIORITY_DESCRIPTOR;
        public static final FieldDescriptor PROJECTNUMBER_DESCRIPTOR;
        public static final FieldDescriptor SDKPLATFORM_DESCRIPTOR;
        public static final FieldDescriptor TOPIC_DESCRIPTOR;
        public static final FieldDescriptor TTL_DESCRIPTOR;

        static {
            Map map;
            Map map2;
            Map map3;
            Map map4;
            Map map5;
            Map map6;
            Map map7;
            Map map8;
            Map map9;
            Map map10;
            Map map11;
            Map map12;
            Map map13;
            Map map14;
            Map map15;
            AtProtobuf$ProtobufImpl atProtobuf$ProtobufImpl = new AtProtobuf$ProtobufImpl(1, IntEncoding.DEFAULT);
            HashMap hashMap = new HashMap();
            hashMap.put(atProtobuf$ProtobufImpl.annotationType(), atProtobuf$ProtobufImpl);
            if (hashMap == null) {
                map = Collections.emptyMap();
            } else {
                map = GeneratedOutlineSupport.outline89(hashMap);
            }
            PROJECTNUMBER_DESCRIPTOR = new FieldDescriptor("projectNumber", map, null);
            AtProtobuf$ProtobufImpl atProtobuf$ProtobufImpl2 = new AtProtobuf$ProtobufImpl(2, IntEncoding.DEFAULT);
            HashMap hashMap2 = new HashMap();
            hashMap2.put(atProtobuf$ProtobufImpl2.annotationType(), atProtobuf$ProtobufImpl2);
            if (hashMap2 == null) {
                map2 = Collections.emptyMap();
            } else {
                map2 = GeneratedOutlineSupport.outline89(hashMap2);
            }
            MESSAGEID_DESCRIPTOR = new FieldDescriptor("messageId", map2, null);
            AtProtobuf$ProtobufImpl atProtobuf$ProtobufImpl3 = new AtProtobuf$ProtobufImpl(3, IntEncoding.DEFAULT);
            HashMap hashMap3 = new HashMap();
            hashMap3.put(atProtobuf$ProtobufImpl3.annotationType(), atProtobuf$ProtobufImpl3);
            if (hashMap3 == null) {
                map3 = Collections.emptyMap();
            } else {
                map3 = GeneratedOutlineSupport.outline89(hashMap3);
            }
            INSTANCEID_DESCRIPTOR = new FieldDescriptor("instanceId", map3, null);
            AtProtobuf$ProtobufImpl atProtobuf$ProtobufImpl4 = new AtProtobuf$ProtobufImpl(4, IntEncoding.DEFAULT);
            HashMap hashMap4 = new HashMap();
            hashMap4.put(atProtobuf$ProtobufImpl4.annotationType(), atProtobuf$ProtobufImpl4);
            if (hashMap4 == null) {
                map4 = Collections.emptyMap();
            } else {
                map4 = GeneratedOutlineSupport.outline89(hashMap4);
            }
            MESSAGETYPE_DESCRIPTOR = new FieldDescriptor(MiPushMessage.KEY_MESSAGE_TYPE, map4, null);
            AtProtobuf$ProtobufImpl atProtobuf$ProtobufImpl5 = new AtProtobuf$ProtobufImpl(5, IntEncoding.DEFAULT);
            HashMap hashMap5 = new HashMap();
            hashMap5.put(atProtobuf$ProtobufImpl5.annotationType(), atProtobuf$ProtobufImpl5);
            if (hashMap5 == null) {
                map5 = Collections.emptyMap();
            } else {
                map5 = GeneratedOutlineSupport.outline89(hashMap5);
            }
            SDKPLATFORM_DESCRIPTOR = new FieldDescriptor("sdkPlatform", map5, null);
            AtProtobuf$ProtobufImpl atProtobuf$ProtobufImpl6 = new AtProtobuf$ProtobufImpl(6, IntEncoding.DEFAULT);
            HashMap hashMap6 = new HashMap();
            hashMap6.put(atProtobuf$ProtobufImpl6.annotationType(), atProtobuf$ProtobufImpl6);
            if (hashMap6 == null) {
                map6 = Collections.emptyMap();
            } else {
                map6 = GeneratedOutlineSupport.outline89(hashMap6);
            }
            PACKAGENAME_DESCRIPTOR = new FieldDescriptor("packageName", map6, null);
            AtProtobuf$ProtobufImpl atProtobuf$ProtobufImpl7 = new AtProtobuf$ProtobufImpl(7, IntEncoding.DEFAULT);
            HashMap hashMap7 = new HashMap();
            hashMap7.put(atProtobuf$ProtobufImpl7.annotationType(), atProtobuf$ProtobufImpl7);
            if (hashMap7 == null) {
                map7 = Collections.emptyMap();
            } else {
                map7 = GeneratedOutlineSupport.outline89(hashMap7);
            }
            COLLAPSEKEY_DESCRIPTOR = new FieldDescriptor(SMTNotificationConstants.NOTIF_COLLAPSE_KEY, map7, null);
            AtProtobuf$ProtobufImpl atProtobuf$ProtobufImpl8 = new AtProtobuf$ProtobufImpl(8, IntEncoding.DEFAULT);
            HashMap hashMap8 = new HashMap();
            hashMap8.put(atProtobuf$ProtobufImpl8.annotationType(), atProtobuf$ProtobufImpl8);
            if (hashMap8 == null) {
                map8 = Collections.emptyMap();
            } else {
                map8 = GeneratedOutlineSupport.outline89(hashMap8);
            }
            PRIORITY_DESCRIPTOR = new FieldDescriptor("priority", map8, null);
            AtProtobuf$ProtobufImpl atProtobuf$ProtobufImpl9 = new AtProtobuf$ProtobufImpl(9, IntEncoding.DEFAULT);
            HashMap hashMap9 = new HashMap();
            hashMap9.put(atProtobuf$ProtobufImpl9.annotationType(), atProtobuf$ProtobufImpl9);
            if (hashMap9 == null) {
                map9 = Collections.emptyMap();
            } else {
                map9 = GeneratedOutlineSupport.outline89(hashMap9);
            }
            TTL_DESCRIPTOR = new FieldDescriptor("ttl", map9, null);
            AtProtobuf$ProtobufImpl atProtobuf$ProtobufImpl10 = new AtProtobuf$ProtobufImpl(10, IntEncoding.DEFAULT);
            HashMap hashMap10 = new HashMap();
            hashMap10.put(atProtobuf$ProtobufImpl10.annotationType(), atProtobuf$ProtobufImpl10);
            if (hashMap10 == null) {
                map10 = Collections.emptyMap();
            } else {
                map10 = GeneratedOutlineSupport.outline89(hashMap10);
            }
            TOPIC_DESCRIPTOR = new FieldDescriptor(MiPushMessage.KEY_TOPIC, map10, null);
            AtProtobuf$ProtobufImpl atProtobuf$ProtobufImpl11 = new AtProtobuf$ProtobufImpl(11, IntEncoding.DEFAULT);
            HashMap hashMap11 = new HashMap();
            hashMap11.put(atProtobuf$ProtobufImpl11.annotationType(), atProtobuf$ProtobufImpl11);
            if (hashMap11 == null) {
                map11 = Collections.emptyMap();
            } else {
                map11 = GeneratedOutlineSupport.outline89(hashMap11);
            }
            BULKID_DESCRIPTOR = new FieldDescriptor("bulkId", map11, null);
            AtProtobuf$ProtobufImpl atProtobuf$ProtobufImpl12 = new AtProtobuf$ProtobufImpl(12, IntEncoding.DEFAULT);
            HashMap hashMap12 = new HashMap();
            hashMap12.put(atProtobuf$ProtobufImpl12.annotationType(), atProtobuf$ProtobufImpl12);
            if (hashMap12 == null) {
                map12 = Collections.emptyMap();
            } else {
                map12 = GeneratedOutlineSupport.outline89(hashMap12);
            }
            EVENT_DESCRIPTOR = new FieldDescriptor("event", map12, null);
            AtProtobuf$ProtobufImpl atProtobuf$ProtobufImpl13 = new AtProtobuf$ProtobufImpl(13, IntEncoding.DEFAULT);
            HashMap hashMap13 = new HashMap();
            hashMap13.put(atProtobuf$ProtobufImpl13.annotationType(), atProtobuf$ProtobufImpl13);
            if (hashMap13 == null) {
                map13 = Collections.emptyMap();
            } else {
                map13 = GeneratedOutlineSupport.outline89(hashMap13);
            }
            ANALYTICSLABEL_DESCRIPTOR = new FieldDescriptor("analyticsLabel", map13, null);
            AtProtobuf$ProtobufImpl atProtobuf$ProtobufImpl14 = new AtProtobuf$ProtobufImpl(14, IntEncoding.DEFAULT);
            HashMap hashMap14 = new HashMap();
            hashMap14.put(atProtobuf$ProtobufImpl14.annotationType(), atProtobuf$ProtobufImpl14);
            if (hashMap14 == null) {
                map14 = Collections.emptyMap();
            } else {
                map14 = GeneratedOutlineSupport.outline89(hashMap14);
            }
            CAMPAIGNID_DESCRIPTOR = new FieldDescriptor("campaignId", map14, null);
            AtProtobuf$ProtobufImpl atProtobuf$ProtobufImpl15 = new AtProtobuf$ProtobufImpl(15, IntEncoding.DEFAULT);
            HashMap hashMap15 = new HashMap();
            hashMap15.put(atProtobuf$ProtobufImpl15.annotationType(), atProtobuf$ProtobufImpl15);
            if (hashMap15 == null) {
                map15 = Collections.emptyMap();
            } else {
                map15 = GeneratedOutlineSupport.outline89(hashMap15);
            }
            COMPOSERLABEL_DESCRIPTOR = new FieldDescriptor("composerLabel", map15, null);
        }

        public void encode(Object obj, Object obj2) throws IOException {
            MessagingClientEvent messagingClientEvent = (MessagingClientEvent) obj;
            ObjectEncoderContext objectEncoderContext = (ObjectEncoderContext) obj2;
            objectEncoderContext.add(PROJECTNUMBER_DESCRIPTOR, messagingClientEvent.project_number_);
            objectEncoderContext.add(MESSAGEID_DESCRIPTOR, (Object) messagingClientEvent.message_id_);
            objectEncoderContext.add(INSTANCEID_DESCRIPTOR, (Object) messagingClientEvent.instance_id_);
            objectEncoderContext.add(MESSAGETYPE_DESCRIPTOR, (Object) messagingClientEvent.message_type_);
            objectEncoderContext.add(SDKPLATFORM_DESCRIPTOR, (Object) messagingClientEvent.sdk_platform_);
            objectEncoderContext.add(PACKAGENAME_DESCRIPTOR, (Object) messagingClientEvent.package_name_);
            objectEncoderContext.add(COLLAPSEKEY_DESCRIPTOR, (Object) messagingClientEvent.collapse_key_);
            objectEncoderContext.add(PRIORITY_DESCRIPTOR, messagingClientEvent.priority_);
            objectEncoderContext.add(TTL_DESCRIPTOR, messagingClientEvent.ttl_);
            objectEncoderContext.add(TOPIC_DESCRIPTOR, (Object) messagingClientEvent.topic_);
            objectEncoderContext.add(BULKID_DESCRIPTOR, messagingClientEvent.bulk_id_);
            objectEncoderContext.add(EVENT_DESCRIPTOR, (Object) messagingClientEvent.event_);
            objectEncoderContext.add(ANALYTICSLABEL_DESCRIPTOR, (Object) messagingClientEvent.analytics_label_);
            objectEncoderContext.add(CAMPAIGNID_DESCRIPTOR, messagingClientEvent.campaign_id_);
            objectEncoderContext.add(COMPOSERLABEL_DESCRIPTOR, (Object) messagingClientEvent.composer_label_);
        }
    }

    public static final class MessagingClientEventExtensionEncoder implements ObjectEncoder<MessagingClientEventExtension> {
        public static final MessagingClientEventExtensionEncoder INSTANCE = new MessagingClientEventExtensionEncoder();
        public static final FieldDescriptor MESSAGINGCLIENTEVENT_DESCRIPTOR;

        static {
            Map map;
            AtProtobuf$ProtobufImpl atProtobuf$ProtobufImpl = new AtProtobuf$ProtobufImpl(1, IntEncoding.DEFAULT);
            HashMap hashMap = new HashMap();
            hashMap.put(atProtobuf$ProtobufImpl.annotationType(), atProtobuf$ProtobufImpl);
            if (hashMap == null) {
                map = Collections.emptyMap();
            } else {
                map = GeneratedOutlineSupport.outline89(hashMap);
            }
            MESSAGINGCLIENTEVENT_DESCRIPTOR = new FieldDescriptor("messagingClientEvent", map, null);
        }

        public void encode(Object obj, Object obj2) throws IOException {
            ((ObjectEncoderContext) obj2).add(MESSAGINGCLIENTEVENT_DESCRIPTOR, (Object) ((MessagingClientEventExtension) obj).messaging_client_event_);
        }
    }

    public static final class ProtoEncoderDoNotUseEncoder implements ObjectEncoder<ProtoEncoderDoNotUse> {
        public static final ProtoEncoderDoNotUseEncoder INSTANCE = new ProtoEncoderDoNotUseEncoder();
        public static final FieldDescriptor MESSAGINGCLIENTEVENTEXTENSION_DESCRIPTOR = FieldDescriptor.of("messagingClientEventExtension");

        public void encode(Object obj, Object obj2) throws IOException {
            ((ObjectEncoderContext) obj2).add(MESSAGINGCLIENTEVENTEXTENSION_DESCRIPTOR, (Object) ((ProtoEncoderDoNotUse) obj).getMessagingClientEventExtension());
        }
    }

    public void configure(EncoderConfig<?> encoderConfig) {
        encoderConfig.registerEncoder(ProtoEncoderDoNotUse.class, ProtoEncoderDoNotUseEncoder.INSTANCE);
        encoderConfig.registerEncoder(MessagingClientEventExtension.class, MessagingClientEventExtensionEncoder.INSTANCE);
        encoderConfig.registerEncoder(MessagingClientEvent.class, MessagingClientEventEncoder.INSTANCE);
    }
}
