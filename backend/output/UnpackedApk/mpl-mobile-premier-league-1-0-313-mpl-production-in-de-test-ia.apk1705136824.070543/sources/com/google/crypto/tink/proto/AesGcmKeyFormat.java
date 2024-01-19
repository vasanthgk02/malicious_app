package com.google.crypto.tink.proto;

import com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite;
import com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite.DefaultInstanceBasedParser;
import com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite.MethodToInvoke;
import com.google.crypto.tink.shaded.protobuf.Parser;
import com.google.crypto.tink.shaded.protobuf.RawMessageInfo;

public final class AesGcmKeyFormat extends GeneratedMessageLite<AesGcmKeyFormat, Builder> implements Object {
    public static final AesGcmKeyFormat DEFAULT_INSTANCE;
    public static final int KEY_SIZE_FIELD_NUMBER = 2;
    public static volatile Parser<AesGcmKeyFormat> PARSER = null;
    public static final int VERSION_FIELD_NUMBER = 3;
    public int keySize_;
    public int version_;

    public static final class Builder extends com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite.Builder<AesGcmKeyFormat, Builder> implements Object {
        public Builder() {
            super(AesGcmKeyFormat.DEFAULT_INSTANCE);
        }

        public Builder(AnonymousClass1 r1) {
            super(AesGcmKeyFormat.DEFAULT_INSTANCE);
        }
    }

    static {
        AesGcmKeyFormat aesGcmKeyFormat = new AesGcmKeyFormat();
        DEFAULT_INSTANCE = aesGcmKeyFormat;
        GeneratedMessageLite.defaultInstanceMap.put(AesGcmKeyFormat.class, aesGcmKeyFormat);
    }

    public final Object dynamicMethod(MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        switch (methodToInvoke.ordinal()) {
            case 0:
                return Byte.valueOf(1);
            case 1:
                return null;
            case 2:
                return new RawMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0002\u0003\u0002\u0000\u0000\u0000\u0002\u000b\u0003\u000b", new Object[]{"keySize_", "version_"});
            case 3:
                return new AesGcmKeyFormat();
            case 4:
                return new Builder(null);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                Parser<AesGcmKeyFormat> parser = PARSER;
                if (parser == null) {
                    synchronized (AesGcmKeyFormat.class) {
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
