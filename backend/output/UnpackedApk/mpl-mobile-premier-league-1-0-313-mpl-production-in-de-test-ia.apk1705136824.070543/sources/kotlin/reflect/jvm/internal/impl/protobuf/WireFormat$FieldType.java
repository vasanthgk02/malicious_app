package kotlin.reflect.jvm.internal.impl.protobuf;

public enum WireFormat$FieldType {
    DOUBLE(WireFormat$JavaType.DOUBLE, 1),
    FLOAT(WireFormat$JavaType.FLOAT, 5),
    INT64(WireFormat$JavaType.LONG, 0),
    UINT64(WireFormat$JavaType.LONG, 0),
    INT32(WireFormat$JavaType.INT, 0),
    FIXED64(WireFormat$JavaType.LONG, 1),
    FIXED32(WireFormat$JavaType.INT, 5),
    BOOL(WireFormat$JavaType.BOOLEAN, 0),
    STRING(WireFormat$JavaType.STRING, 2) {
        public boolean isPackable() {
            return false;
        }
    },
    GROUP(WireFormat$JavaType.MESSAGE, 3) {
        public boolean isPackable() {
            return false;
        }
    },
    MESSAGE(WireFormat$JavaType.MESSAGE, 2) {
        public boolean isPackable() {
            return false;
        }
    },
    BYTES(WireFormat$JavaType.BYTE_STRING, 2) {
        public boolean isPackable() {
            return false;
        }
    },
    UINT32(WireFormat$JavaType.INT, 0),
    ENUM(WireFormat$JavaType.ENUM, 0),
    SFIXED32(WireFormat$JavaType.INT, 5),
    SFIXED64(WireFormat$JavaType.LONG, 1),
    SINT32(WireFormat$JavaType.INT, 0),
    SINT64(WireFormat$JavaType.LONG, 0);
    
    public final WireFormat$JavaType javaType;
    public final int wireType;

    public WireFormat$JavaType getJavaType() {
        return this.javaType;
    }

    public int getWireType() {
        return this.wireType;
    }

    public boolean isPackable() {
        return true;
    }

    /* access modifiers changed from: public */
    WireFormat$FieldType(WireFormat$JavaType wireFormat$JavaType, int i) {
        this.javaType = wireFormat$JavaType;
        this.wireType = i;
    }
}
