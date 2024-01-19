package com.google.crypto.tink.proto;

import com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite;
import com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite.DefaultInstanceBasedParser;
import com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite.MethodToInvoke;
import com.google.crypto.tink.shaded.protobuf.Parser;
import com.google.crypto.tink.shaded.protobuf.RawMessageInfo;

public final class ChaCha20Poly1305KeyFormat extends GeneratedMessageLite<ChaCha20Poly1305KeyFormat, Builder> implements Object {
    public static final ChaCha20Poly1305KeyFormat DEFAULT_INSTANCE;
    public static volatile Parser<ChaCha20Poly1305KeyFormat> PARSER;

    public static final class Builder extends com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite.Builder<ChaCha20Poly1305KeyFormat, Builder> implements Object {
        public Builder(AnonymousClass1 r1) {
            super(ChaCha20Poly1305KeyFormat.DEFAULT_INSTANCE);
        }
    }

    static {
        ChaCha20Poly1305KeyFormat chaCha20Poly1305KeyFormat = new ChaCha20Poly1305KeyFormat();
        DEFAULT_INSTANCE = chaCha20Poly1305KeyFormat;
        GeneratedMessageLite.defaultInstanceMap.put(ChaCha20Poly1305KeyFormat.class, chaCha20Poly1305KeyFormat);
    }

    public final Object dynamicMethod(MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        switch (methodToInvoke.ordinal()) {
            case 0:
                return Byte.valueOf(1);
            case 1:
                return null;
            case 2:
                return new RawMessageInfo(DEFAULT_INSTANCE, "\u0000\u0000", null);
            case 3:
                return new ChaCha20Poly1305KeyFormat();
            case 4:
                return new Builder(null);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                Parser<ChaCha20Poly1305KeyFormat> parser = PARSER;
                if (parser == null) {
                    synchronized (ChaCha20Poly1305KeyFormat.class) {
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
