package com.google.crypto.tink.proto;

import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite;
import com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite.DefaultInstanceBasedParser;
import com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite.MethodToInvoke;
import com.google.crypto.tink.shaded.protobuf.Parser;
import com.google.crypto.tink.shaded.protobuf.RawMessageInfo;

public final class HmacKey extends GeneratedMessageLite<HmacKey, Builder> implements Object {
    public static final HmacKey DEFAULT_INSTANCE;
    public static final int KEY_VALUE_FIELD_NUMBER = 3;
    public static final int PARAMS_FIELD_NUMBER = 2;
    public static volatile Parser<HmacKey> PARSER = null;
    public static final int VERSION_FIELD_NUMBER = 1;
    public ByteString keyValue_ = ByteString.EMPTY;
    public HmacParams params_;
    public int version_;

    public static final class Builder extends com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite.Builder<HmacKey, Builder> implements Object {
        public Builder() {
            super(HmacKey.DEFAULT_INSTANCE);
        }

        public Builder(AnonymousClass1 r1) {
            super(HmacKey.DEFAULT_INSTANCE);
        }
    }

    static {
        HmacKey hmacKey = new HmacKey();
        DEFAULT_INSTANCE = hmacKey;
        GeneratedMessageLite.defaultInstanceMap.put(HmacKey.class, hmacKey);
    }

    public static void access$300(HmacKey hmacKey, HmacParams hmacParams) {
        if (hmacKey != null) {
            hmacParams.getClass();
            hmacKey.params_ = hmacParams;
            return;
        }
        throw null;
    }

    public static void access$600(HmacKey hmacKey, ByteString byteString) {
        if (hmacKey != null) {
            byteString.getClass();
            hmacKey.keyValue_ = byteString;
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
                return new RawMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002\t\u0003\n", new Object[]{"version_", "params_", "keyValue_"});
            case 3:
                return new HmacKey();
            case 4:
                return new Builder(null);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                Parser<HmacKey> parser = PARSER;
                if (parser == null) {
                    synchronized (HmacKey.class) {
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

    public HmacParams getParams() {
        HmacParams hmacParams = this.params_;
        return hmacParams == null ? HmacParams.DEFAULT_INSTANCE : hmacParams;
    }
}