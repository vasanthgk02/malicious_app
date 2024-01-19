package com.google.crypto.tink.proto;

import com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite;
import com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite.DefaultInstanceBasedParser;
import com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite.MethodToInvoke;
import com.google.crypto.tink.shaded.protobuf.Parser;
import com.google.crypto.tink.shaded.protobuf.RawMessageInfo;

public final class AesEaxParams extends GeneratedMessageLite<AesEaxParams, Builder> implements Object {
    public static final AesEaxParams DEFAULT_INSTANCE;
    public static final int IV_SIZE_FIELD_NUMBER = 1;
    public static volatile Parser<AesEaxParams> PARSER;
    public int ivSize_;

    public static final class Builder extends com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite.Builder<AesEaxParams, Builder> implements Object {
        public Builder(AnonymousClass1 r1) {
            super(AesEaxParams.DEFAULT_INSTANCE);
        }
    }

    static {
        AesEaxParams aesEaxParams = new AesEaxParams();
        DEFAULT_INSTANCE = aesEaxParams;
        GeneratedMessageLite.defaultInstanceMap.put(AesEaxParams.class, aesEaxParams);
    }

    public final Object dynamicMethod(MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        switch (methodToInvoke.ordinal()) {
            case 0:
                return Byte.valueOf(1);
            case 1:
                return null;
            case 2:
                return new RawMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u000b", new Object[]{"ivSize_"});
            case 3:
                return new AesEaxParams();
            case 4:
                return new Builder(null);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                Parser<AesEaxParams> parser = PARSER;
                if (parser == null) {
                    synchronized (AesEaxParams.class) {
                        parser = PARSER;
                        if (parser == null) {
                            parser = new DefaultInstanceBasedParser<>(DEFAULT_INSTANCE);
                            PARSER = parser;
                        }
                    }
                }
                return parser;
            default:
                throw new UnsupportedOperationException();
        }
    }
}
