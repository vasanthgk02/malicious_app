package com.google.crypto.tink.proto;

import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite;
import com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite.DefaultInstanceBasedParser;
import com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite.MethodToInvoke;
import com.google.crypto.tink.shaded.protobuf.Parser;
import com.google.crypto.tink.shaded.protobuf.RawMessageInfo;

public final class AesEaxKey extends GeneratedMessageLite<AesEaxKey, Builder> implements Object {
    public static final AesEaxKey DEFAULT_INSTANCE;
    public static final int KEY_VALUE_FIELD_NUMBER = 3;
    public static final int PARAMS_FIELD_NUMBER = 2;
    public static volatile Parser<AesEaxKey> PARSER = null;
    public static final int VERSION_FIELD_NUMBER = 1;
    public ByteString keyValue_ = ByteString.EMPTY;
    public AesEaxParams params_;
    public int version_;

    public static final class Builder extends com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite.Builder<AesEaxKey, Builder> implements Object {
        public Builder() {
            super(AesEaxKey.DEFAULT_INSTANCE);
        }

        public Builder(AnonymousClass1 r1) {
            super(AesEaxKey.DEFAULT_INSTANCE);
        }
    }

    static {
        AesEaxKey aesEaxKey = new AesEaxKey();
        DEFAULT_INSTANCE = aesEaxKey;
        GeneratedMessageLite.defaultInstanceMap.put(AesEaxKey.class, aesEaxKey);
    }

    public static void access$300(AesEaxKey aesEaxKey, AesEaxParams aesEaxParams) {
        if (aesEaxKey != null) {
            aesEaxParams.getClass();
            aesEaxKey.params_ = aesEaxParams;
            return;
        }
        throw null;
    }

    public static void access$600(AesEaxKey aesEaxKey, ByteString byteString) {
        if (aesEaxKey != null) {
            byteString.getClass();
            aesEaxKey.keyValue_ = byteString;
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
                return new AesEaxKey();
            case 4:
                return new Builder(null);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                Parser<AesEaxKey> parser = PARSER;
                if (parser == null) {
                    synchronized (AesEaxKey.class) {
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

    public AesEaxParams getParams() {
        AesEaxParams aesEaxParams = this.params_;
        return aesEaxParams == null ? AesEaxParams.DEFAULT_INSTANCE : aesEaxParams;
    }
}
