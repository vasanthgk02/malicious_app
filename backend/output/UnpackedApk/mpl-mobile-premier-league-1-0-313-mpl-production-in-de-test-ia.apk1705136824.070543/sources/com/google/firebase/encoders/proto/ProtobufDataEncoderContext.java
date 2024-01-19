package com.google.firebase.encoders.proto;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.google.firebase.encoders.EncodingException;
import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import com.google.firebase.encoders.ValueEncoder;
import com.google.firebase.encoders.proto.Protobuf.IntEncoding;
import io.hansel.core.criteria.HSLCriteriaBuilder;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.annotation.Annotation;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public final class ProtobufDataEncoderContext implements ObjectEncoderContext {
    public static final ObjectEncoder<Entry<Object, Object>> DEFAULT_MAP_ENCODER = $$Lambda$ProtobufDataEncoderContext$GrnqT7BliQwjE8CB4RFyP3_ydXo.INSTANCE;
    public static final FieldDescriptor MAP_KEY_DESC;
    public static final FieldDescriptor MAP_VALUE_DESC;
    public static final Charset UTF_8 = Charset.forName("UTF-8");
    public final ObjectEncoder<Object> fallbackEncoder;
    public final Map<Class<?>, ObjectEncoder<?>> objectEncoders;
    public OutputStream output;
    public final ProtobufValueEncoderContext valueEncoderContext = new ProtobufValueEncoderContext(this);
    public final Map<Class<?>, ValueEncoder<?>> valueEncoders;

    static {
        Map map;
        Map map2;
        AtProtobuf$ProtobufImpl atProtobuf$ProtobufImpl = new AtProtobuf$ProtobufImpl(1, IntEncoding.DEFAULT);
        HashMap hashMap = new HashMap();
        hashMap.put(atProtobuf$ProtobufImpl.annotationType(), atProtobuf$ProtobufImpl);
        if (hashMap == null) {
            map = Collections.emptyMap();
        } else {
            map = GeneratedOutlineSupport.outline89(hashMap);
        }
        MAP_KEY_DESC = new FieldDescriptor("key", map, null);
        AtProtobuf$ProtobufImpl atProtobuf$ProtobufImpl2 = new AtProtobuf$ProtobufImpl(2, IntEncoding.DEFAULT);
        HashMap hashMap2 = new HashMap();
        hashMap2.put(atProtobuf$ProtobufImpl2.annotationType(), atProtobuf$ProtobufImpl2);
        if (hashMap2 == null) {
            map2 = Collections.emptyMap();
        } else {
            map2 = GeneratedOutlineSupport.outline89(hashMap2);
        }
        MAP_VALUE_DESC = new FieldDescriptor(HSLCriteriaBuilder.VALUE, map2, null);
    }

    public ProtobufDataEncoderContext(OutputStream outputStream, Map<Class<?>, ObjectEncoder<?>> map, Map<Class<?>, ValueEncoder<?>> map2, ObjectEncoder<Object> objectEncoder) {
        this.output = outputStream;
        this.objectEncoders = map;
        this.valueEncoders = map2;
        this.fallbackEncoder = objectEncoder;
    }

    public static ByteBuffer allocateBuffer(int i) {
        return ByteBuffer.allocate(i).order(ByteOrder.LITTLE_ENDIAN);
    }

    public static Protobuf getProtobuf(FieldDescriptor fieldDescriptor) {
        Protobuf protobuf = (Protobuf) ((Annotation) fieldDescriptor.properties.get(Protobuf.class));
        if (protobuf != null) {
            return protobuf;
        }
        throw new EncodingException("Field has no @Protobuf config");
    }

    public static int getTag(FieldDescriptor fieldDescriptor) {
        Protobuf protobuf = (Protobuf) ((Annotation) fieldDescriptor.properties.get(Protobuf.class));
        if (protobuf != null) {
            return protobuf.tag();
        }
        throw new EncodingException("Field has no @Protobuf config");
    }

    public static /* synthetic */ void lambda$static$0(Entry entry, ObjectEncoderContext objectEncoderContext) throws IOException {
        objectEncoderContext.add(MAP_KEY_DESC, entry.getKey());
        objectEncoderContext.add(MAP_VALUE_DESC, entry.getValue());
    }

    public ObjectEncoderContext add(FieldDescriptor fieldDescriptor, Object obj) throws IOException {
        return add(fieldDescriptor, obj, true);
    }

    public final <T> ProtobufDataEncoderContext doEncode(ObjectEncoder<T> objectEncoder, FieldDescriptor fieldDescriptor, T t, boolean z) throws IOException {
        OutputStream outputStream;
        LengthCountingOutputStream lengthCountingOutputStream = new LengthCountingOutputStream();
        try {
            outputStream = this.output;
            this.output = lengthCountingOutputStream;
            objectEncoder.encode(t, this);
            this.output = outputStream;
            long j = lengthCountingOutputStream.length;
            lengthCountingOutputStream.close();
            if (z && j == 0) {
                return this;
            }
            writeVarInt32((getTag(fieldDescriptor) << 3) | 2);
            writeVarInt64(j);
            objectEncoder.encode(t, this);
            return this;
        } catch (Throwable th) {
            try {
                lengthCountingOutputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public final void writeVarInt32(int i) throws IOException {
        while (((long) (i & -128)) != 0) {
            this.output.write((i & 127) | 128);
            i >>>= 7;
        }
        this.output.write(i & 127);
    }

    public final void writeVarInt64(long j) throws IOException {
        while ((-128 & j) != 0) {
            this.output.write((((int) j) & 127) | 128);
            j >>>= 7;
        }
        this.output.write(((int) j) & 127);
    }

    public ObjectEncoderContext add(FieldDescriptor fieldDescriptor, Object obj, boolean z) throws IOException {
        if (obj == null) {
            return this;
        }
        if (obj instanceof CharSequence) {
            CharSequence charSequence = (CharSequence) obj;
            if (z && charSequence.length() == 0) {
                return this;
            }
            writeVarInt32((getTag(fieldDescriptor) << 3) | 2);
            byte[] bytes = charSequence.toString().getBytes(UTF_8);
            writeVarInt32(bytes.length);
            this.output.write(bytes);
            return this;
        } else if (obj instanceof Collection) {
            for (Object add : (Collection) obj) {
                add(fieldDescriptor, add, false);
            }
            return this;
        } else if (obj instanceof Map) {
            for (Entry doEncode : ((Map) obj).entrySet()) {
                doEncode(DEFAULT_MAP_ENCODER, fieldDescriptor, doEncode, false);
            }
            return this;
        } else if (obj instanceof Double) {
            double doubleValue = ((Double) obj).doubleValue();
            if (!z || doubleValue != 0.0d) {
                writeVarInt32((getTag(fieldDescriptor) << 3) | 1);
                this.output.write(allocateBuffer(8).putDouble(doubleValue).array());
            }
            return this;
        } else if (obj instanceof Float) {
            float floatValue = ((Float) obj).floatValue();
            if (!z || floatValue != 0.0f) {
                writeVarInt32((getTag(fieldDescriptor) << 3) | 5);
                this.output.write(allocateBuffer(4).putFloat(floatValue).array());
            }
            return this;
        } else if (obj instanceof Number) {
            add(fieldDescriptor, ((Number) obj).longValue(), z);
            return this;
        } else if (obj instanceof Boolean) {
            add(fieldDescriptor, ((Boolean) obj).booleanValue() ? 1 : 0, z);
            return this;
        } else if (obj instanceof byte[]) {
            byte[] bArr = (byte[]) obj;
            if (z && bArr.length == 0) {
                return this;
            }
            writeVarInt32((getTag(fieldDescriptor) << 3) | 2);
            writeVarInt32(bArr.length);
            this.output.write(bArr);
            return this;
        } else {
            ObjectEncoder objectEncoder = this.objectEncoders.get(obj.getClass());
            if (objectEncoder != null) {
                doEncode(objectEncoder, fieldDescriptor, obj, z);
                return this;
            }
            ValueEncoder valueEncoder = this.valueEncoders.get(obj.getClass());
            if (valueEncoder != null) {
                ProtobufValueEncoderContext protobufValueEncoderContext = this.valueEncoderContext;
                protobufValueEncoderContext.encoded = false;
                protobufValueEncoderContext.field = fieldDescriptor;
                protobufValueEncoderContext.skipDefault = z;
                valueEncoder.encode(obj, protobufValueEncoderContext);
                return this;
            } else if (obj instanceof ProtoEnum) {
                add(fieldDescriptor, ((ProtoEnum) obj).getNumber(), true);
                return this;
            } else if (obj instanceof Enum) {
                add(fieldDescriptor, ((Enum) obj).ordinal(), true);
                return this;
            } else {
                doEncode(this.fallbackEncoder, fieldDescriptor, obj, z);
                return this;
            }
        }
    }

    public ObjectEncoderContext add(FieldDescriptor fieldDescriptor, int i) throws IOException {
        add(fieldDescriptor, i, true);
        return this;
    }

    public ProtobufDataEncoderContext add(FieldDescriptor fieldDescriptor, int i, boolean z) throws IOException {
        if (z && i == 0) {
            return this;
        }
        Protobuf protobuf = getProtobuf(fieldDescriptor);
        int ordinal = protobuf.intEncoding().ordinal();
        if (ordinal == 0) {
            writeVarInt32(protobuf.tag() << 3);
            writeVarInt32(i);
        } else if (ordinal == 1) {
            writeVarInt32(protobuf.tag() << 3);
            writeVarInt32((i << 1) ^ (i >> 31));
        } else if (ordinal == 2) {
            writeVarInt32((protobuf.tag() << 3) | 5);
            this.output.write(allocateBuffer(4).putInt(i).array());
        }
        return this;
    }

    public ObjectEncoderContext add(FieldDescriptor fieldDescriptor, long j) throws IOException {
        add(fieldDescriptor, j, true);
        return this;
    }

    public ProtobufDataEncoderContext add(FieldDescriptor fieldDescriptor, long j, boolean z) throws IOException {
        if (z && j == 0) {
            return this;
        }
        Protobuf protobuf = getProtobuf(fieldDescriptor);
        int ordinal = protobuf.intEncoding().ordinal();
        if (ordinal == 0) {
            writeVarInt32(protobuf.tag() << 3);
            writeVarInt64(j);
        } else if (ordinal == 1) {
            writeVarInt32(protobuf.tag() << 3);
            writeVarInt64((j >> 63) ^ (j << 1));
        } else if (ordinal == 2) {
            writeVarInt32((protobuf.tag() << 3) | 1);
            this.output.write(allocateBuffer(8).putLong(j).array());
        }
        return this;
    }

    public ObjectEncoderContext add(FieldDescriptor fieldDescriptor, boolean z) throws IOException {
        add(fieldDescriptor, z ? 1 : 0, true);
        return this;
    }
}
