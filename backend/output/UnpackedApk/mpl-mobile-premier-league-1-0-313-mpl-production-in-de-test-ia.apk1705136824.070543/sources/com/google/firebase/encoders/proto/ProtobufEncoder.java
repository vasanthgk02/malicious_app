package com.google.firebase.encoders.proto;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.google.firebase.encoders.EncodingException;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import com.google.firebase.encoders.ValueEncoder;
import com.google.firebase.encoders.config.EncoderConfig;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

public class ProtobufEncoder {
    public final ObjectEncoder<Object> fallbackEncoder;
    public final Map<Class<?>, ObjectEncoder<?>> objectEncoders;
    public final Map<Class<?>, ValueEncoder<?>> valueEncoders;

    public static final class Builder implements EncoderConfig<Builder> {
        public static final ObjectEncoder<Object> DEFAULT_FALLBACK_ENCODER = $$Lambda$ProtobufEncoder$Builder$RXvYJ6SiKEbAFhRqRMHtwZ1FqU.INSTANCE;
        public ObjectEncoder<Object> fallbackEncoder = DEFAULT_FALLBACK_ENCODER;
        public final Map<Class<?>, ObjectEncoder<?>> objectEncoders = new HashMap();
        public final Map<Class<?>, ValueEncoder<?>> valueEncoders = new HashMap();

        public static /* synthetic */ void lambda$static$0(Object obj, ObjectEncoderContext objectEncoderContext) throws IOException {
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("Couldn't find encoder for type ");
            outline73.append(obj.getClass().getCanonicalName());
            throw new EncodingException(outline73.toString());
        }

        public EncoderConfig registerEncoder(Class cls, ObjectEncoder objectEncoder) {
            this.objectEncoders.put(cls, objectEncoder);
            this.valueEncoders.remove(cls);
            return this;
        }
    }

    public ProtobufEncoder(Map<Class<?>, ObjectEncoder<?>> map, Map<Class<?>, ValueEncoder<?>> map2, ObjectEncoder<Object> objectEncoder) {
        this.objectEncoders = map;
        this.valueEncoders = map2;
        this.fallbackEncoder = objectEncoder;
    }

    public void encode(Object obj, OutputStream outputStream) throws IOException {
        ProtobufDataEncoderContext protobufDataEncoderContext = new ProtobufDataEncoderContext(outputStream, this.objectEncoders, this.valueEncoders, this.fallbackEncoder);
        if (obj != null) {
            ObjectEncoder objectEncoder = protobufDataEncoderContext.objectEncoders.get(obj.getClass());
            if (objectEncoder != null) {
                objectEncoder.encode(obj, protobufDataEncoderContext);
                return;
            }
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("No encoder for ");
            outline73.append(obj.getClass());
            throw new EncodingException(outline73.toString());
        }
    }
}
