package kotlin.reflect.jvm.internal.impl.protobuf;

public enum WireFormat$JavaType {
    INT(Integer.valueOf(0)),
    LONG(Long.valueOf(0)),
    FLOAT(Float.valueOf(0.0f)),
    DOUBLE(Double.valueOf(0.0d)),
    BOOLEAN(Boolean.FALSE),
    STRING(""),
    BYTE_STRING(ByteString.EMPTY),
    ENUM(null),
    MESSAGE(null);
    
    public final Object defaultDefault;

    /* access modifiers changed from: public */
    WireFormat$JavaType(Object obj) {
        this.defaultDefault = obj;
    }
}
