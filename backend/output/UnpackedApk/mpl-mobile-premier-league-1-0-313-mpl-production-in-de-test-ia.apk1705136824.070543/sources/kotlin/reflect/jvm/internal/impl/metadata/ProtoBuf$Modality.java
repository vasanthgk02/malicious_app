package kotlin.reflect.jvm.internal.impl.metadata;

import kotlin.reflect.jvm.internal.impl.protobuf.Internal.EnumLite;
import kotlin.reflect.jvm.internal.impl.protobuf.Internal.EnumLiteMap;

public enum ProtoBuf$Modality implements EnumLite {
    FINAL(0, 0),
    OPEN(1, 1),
    ABSTRACT(2, 2),
    SEALED(3, 3);
    
    public static EnumLiteMap<ProtoBuf$Modality> internalValueMap;
    public final int value;

    /* access modifiers changed from: public */
    static {
        internalValueMap = new EnumLiteMap<ProtoBuf$Modality>() {
            public EnumLite findValueByNumber(int i) {
                return ProtoBuf$Modality.valueOf(i);
            }
        };
    }

    /* access modifiers changed from: public */
    ProtoBuf$Modality(int i, int i2) {
        this.value = i2;
    }

    public final int getNumber() {
        return this.value;
    }

    public static ProtoBuf$Modality valueOf(int i) {
        if (i == 0) {
            return FINAL;
        }
        if (i == 1) {
            return OPEN;
        }
        if (i == 2) {
            return ABSTRACT;
        }
        if (i != 3) {
            return null;
        }
        return SEALED;
    }
}
