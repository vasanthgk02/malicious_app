package com.google.crypto.tink.proto;

import com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite;
import com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite.DefaultInstanceBasedParser;
import com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite.MethodToInvoke;
import com.google.crypto.tink.shaded.protobuf.Parser;
import com.google.crypto.tink.shaded.protobuf.RawMessageInfo;

public final class KmsAeadKey extends GeneratedMessageLite<KmsAeadKey, Builder> implements Object {
    public static final KmsAeadKey DEFAULT_INSTANCE;
    public static final int PARAMS_FIELD_NUMBER = 2;
    public static volatile Parser<KmsAeadKey> PARSER = null;
    public static final int VERSION_FIELD_NUMBER = 1;
    public KmsAeadKeyFormat params_;
    public int version_;

    public static final class Builder extends com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite.Builder<KmsAeadKey, Builder> implements Object {
        public Builder() {
            super(KmsAeadKey.DEFAULT_INSTANCE);
        }

        public Builder(AnonymousClass1 r1) {
            super(KmsAeadKey.DEFAULT_INSTANCE);
        }
    }

    static {
        KmsAeadKey kmsAeadKey = new KmsAeadKey();
        DEFAULT_INSTANCE = kmsAeadKey;
        GeneratedMessageLite.defaultInstanceMap.put(KmsAeadKey.class, kmsAeadKey);
    }

    public static void access$300(KmsAeadKey kmsAeadKey, KmsAeadKeyFormat kmsAeadKeyFormat) {
        if (kmsAeadKey != null) {
            kmsAeadKeyFormat.getClass();
            kmsAeadKey.params_ = kmsAeadKeyFormat;
            return;
        }
        throw null;
    }

    public final Object dynamicMethod(MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        switch (methodToInvoke.ordinal()) {
            case 0:
                return Byte.valueOf(1);
            case 1:
                return null;
            case 2:
                return new RawMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u000b\u0002\t", new Object[]{"version_", "params_"});
            case 3:
                return new KmsAeadKey();
            case 4:
                return new Builder(null);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                Parser<KmsAeadKey> parser = PARSER;
                if (parser == null) {
                    synchronized (KmsAeadKey.class) {
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
