package com.google.firebase.messaging;

import com.google.firebase.encoders.proto.ProtobufEncoder;
import com.google.firebase.encoders.proto.ProtobufEncoder.Builder;
import com.google.firebase.messaging.reporting.MessagingClientEventExtension;
import java.util.HashMap;

public abstract class ProtoEncoderDoNotUse {
    public static final ProtobufEncoder ENCODER;

    static {
        Builder builder = new Builder();
        ((AutoProtoEncoderDoNotUseEncoder) AutoProtoEncoderDoNotUseEncoder.CONFIG).configure(builder);
        ENCODER = new ProtobufEncoder(new HashMap(builder.objectEncoders), new HashMap(builder.valueEncoders), builder.fallbackEncoder);
    }

    public abstract MessagingClientEventExtension getMessagingClientEventExtension();
}
