package com.google.crypto.tink.proto;

import com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite;
import com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite.DefaultInstanceBasedParser;
import com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite.MethodToInvoke;
import com.google.crypto.tink.shaded.protobuf.Parser;
import com.google.crypto.tink.shaded.protobuf.RawMessageInfo;

public final class AesCtrHmacAeadKey extends GeneratedMessageLite<AesCtrHmacAeadKey, Builder> implements Object {
    public static final int AES_CTR_KEY_FIELD_NUMBER = 2;
    public static final AesCtrHmacAeadKey DEFAULT_INSTANCE;
    public static final int HMAC_KEY_FIELD_NUMBER = 3;
    public static volatile Parser<AesCtrHmacAeadKey> PARSER = null;
    public static final int VERSION_FIELD_NUMBER = 1;
    public AesCtrKey aesCtrKey_;
    public HmacKey hmacKey_;
    public int version_;

    public static final class Builder extends com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite.Builder<AesCtrHmacAeadKey, Builder> implements Object {
        public Builder() {
            super(AesCtrHmacAeadKey.DEFAULT_INSTANCE);
        }

        public Builder(AnonymousClass1 r1) {
            super(AesCtrHmacAeadKey.DEFAULT_INSTANCE);
        }
    }

    static {
        AesCtrHmacAeadKey aesCtrHmacAeadKey = new AesCtrHmacAeadKey();
        DEFAULT_INSTANCE = aesCtrHmacAeadKey;
        GeneratedMessageLite.defaultInstanceMap.put(AesCtrHmacAeadKey.class, aesCtrHmacAeadKey);
    }

    public static void access$300(AesCtrHmacAeadKey aesCtrHmacAeadKey, AesCtrKey aesCtrKey) {
        if (aesCtrHmacAeadKey != null) {
            aesCtrKey.getClass();
            aesCtrHmacAeadKey.aesCtrKey_ = aesCtrKey;
            return;
        }
        throw null;
    }

    public static void access$600(AesCtrHmacAeadKey aesCtrHmacAeadKey, HmacKey hmacKey) {
        if (aesCtrHmacAeadKey != null) {
            hmacKey.getClass();
            aesCtrHmacAeadKey.hmacKey_ = hmacKey;
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
                return new RawMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002\t\u0003\t", new Object[]{"version_", "aesCtrKey_", "hmacKey_"});
            case 3:
                return new AesCtrHmacAeadKey();
            case 4:
                return new Builder(null);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                Parser<AesCtrHmacAeadKey> parser = PARSER;
                if (parser == null) {
                    synchronized (AesCtrHmacAeadKey.class) {
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

    public HmacKey getHmacKey() {
        HmacKey hmacKey = this.hmacKey_;
        return hmacKey == null ? HmacKey.DEFAULT_INSTANCE : hmacKey;
    }
}
