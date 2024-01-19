package com.google.firebase.messaging.reporting;

import com.google.firebase.encoders.proto.ProtobufEncoder;
import com.google.firebase.messaging.ProtoEncoderDoNotUse;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public final class MessagingClientEventExtension {
    public final MessagingClientEvent messaging_client_event_;

    public static final class Builder {
        public MessagingClientEvent messaging_client_event_ = null;
    }

    public MessagingClientEventExtension(MessagingClientEvent messagingClientEvent) {
        this.messaging_client_event_ = messagingClientEvent;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public byte[] toByteArray() {
        ProtobufEncoder protobufEncoder = ProtoEncoderDoNotUse.ENCODER;
        if (protobufEncoder != null) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                protobufEncoder.encode(this, byteArrayOutputStream);
            } catch (IOException unused) {
            }
            return byteArrayOutputStream.toByteArray();
        }
        throw null;
    }
}
