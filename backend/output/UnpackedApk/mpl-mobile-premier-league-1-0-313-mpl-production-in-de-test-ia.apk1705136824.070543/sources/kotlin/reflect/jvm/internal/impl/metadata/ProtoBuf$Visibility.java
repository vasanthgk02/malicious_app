package kotlin.reflect.jvm.internal.impl.metadata;

import kotlin.reflect.jvm.internal.impl.protobuf.Internal.EnumLite;
import kotlin.reflect.jvm.internal.impl.protobuf.Internal.EnumLiteMap;

public enum ProtoBuf$Visibility implements EnumLite {
    INTERNAL(0, 0),
    PRIVATE(1, 1),
    PROTECTED(2, 2),
    PUBLIC(3, 3),
    PRIVATE_TO_THIS(4, 4),
    LOCAL(5, 5);
    
    public static EnumLiteMap<ProtoBuf$Visibility> internalValueMap;
    public final int value;

    /* access modifiers changed from: public */
    static {
        internalValueMap = new EnumLiteMap<ProtoBuf$Visibility>() {
            public EnumLite findValueByNumber(int i) {
                return ProtoBuf$Visibility.valueOf(i);
            }
        };
    }

    /* access modifiers changed from: public */
    ProtoBuf$Visibility(int i, int i2) {
        this.value = i2;
    }

    public final int getNumber() {
        return this.value;
    }

    public static ProtoBuf$Visibility valueOf(int i) {
        if (i == 0) {
            return INTERNAL;
        }
        if (i == 1) {
            return PRIVATE;
        }
        if (i == 2) {
            return PROTECTED;
        }
        if (i == 3) {
            return PUBLIC;
        }
        if (i == 4) {
            return PRIVATE_TO_THIS;
        }
        if (i != 5) {
            return null;
        }
        return LOCAL;
    }
}
