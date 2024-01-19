package kotlin.reflect.jvm.internal.impl.metadata;

import kotlin.reflect.jvm.internal.impl.protobuf.Internal.EnumLite;
import kotlin.reflect.jvm.internal.impl.protobuf.Internal.EnumLiteMap;

public enum ProtoBuf$MemberKind implements EnumLite {
    DECLARATION(0, 0),
    FAKE_OVERRIDE(1, 1),
    DELEGATION(2, 2),
    SYNTHESIZED(3, 3);
    
    public static EnumLiteMap<ProtoBuf$MemberKind> internalValueMap;
    public final int value;

    /* access modifiers changed from: public */
    static {
        internalValueMap = new EnumLiteMap<ProtoBuf$MemberKind>() {
            public EnumLite findValueByNumber(int i) {
                return ProtoBuf$MemberKind.valueOf(i);
            }
        };
    }

    /* access modifiers changed from: public */
    ProtoBuf$MemberKind(int i, int i2) {
        this.value = i2;
    }

    public final int getNumber() {
        return this.value;
    }

    public static ProtoBuf$MemberKind valueOf(int i) {
        if (i == 0) {
            return DECLARATION;
        }
        if (i == 1) {
            return FAKE_OVERRIDE;
        }
        if (i == 2) {
            return DELEGATION;
        }
        if (i != 3) {
            return null;
        }
        return SYNTHESIZED;
    }
}
