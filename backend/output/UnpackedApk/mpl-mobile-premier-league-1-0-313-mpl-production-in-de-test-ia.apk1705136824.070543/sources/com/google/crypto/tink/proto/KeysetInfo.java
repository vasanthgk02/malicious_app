package com.google.crypto.tink.proto;

import com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite;
import com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite.DefaultInstanceBasedParser;
import com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite.MethodToInvoke;
import com.google.crypto.tink.shaded.protobuf.Internal.ProtobufList;
import com.google.crypto.tink.shaded.protobuf.Parser;
import com.google.crypto.tink.shaded.protobuf.ProtobufArrayList;
import com.google.crypto.tink.shaded.protobuf.RawMessageInfo;

public final class KeysetInfo extends GeneratedMessageLite<KeysetInfo, Builder> implements Object {
    public static final KeysetInfo DEFAULT_INSTANCE;
    public static final int KEY_INFO_FIELD_NUMBER = 2;
    public static volatile Parser<KeysetInfo> PARSER = null;
    public static final int PRIMARY_KEY_ID_FIELD_NUMBER = 1;
    public ProtobufList<KeyInfo> keyInfo_ = ProtobufArrayList.EMPTY_LIST;
    public int primaryKeyId_;

    public static final class Builder extends com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite.Builder<KeysetInfo, Builder> implements Object {
        public Builder() {
            super(KeysetInfo.DEFAULT_INSTANCE);
        }

        public Builder(AnonymousClass1 r1) {
            super(KeysetInfo.DEFAULT_INSTANCE);
        }
    }

    public static final class KeyInfo extends GeneratedMessageLite<KeyInfo, Builder> implements Object {
        public static final KeyInfo DEFAULT_INSTANCE;
        public static final int KEY_ID_FIELD_NUMBER = 3;
        public static final int OUTPUT_PREFIX_TYPE_FIELD_NUMBER = 4;
        public static volatile Parser<KeyInfo> PARSER = null;
        public static final int STATUS_FIELD_NUMBER = 2;
        public static final int TYPE_URL_FIELD_NUMBER = 1;
        public int keyId_;
        public int outputPrefixType_;
        public int status_;
        public String typeUrl_ = "";

        public static final class Builder extends com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite.Builder<KeyInfo, Builder> implements Object {
            public Builder() {
                super(KeyInfo.DEFAULT_INSTANCE);
            }

            public Builder(AnonymousClass1 r1) {
                super(KeyInfo.DEFAULT_INSTANCE);
            }
        }

        static {
            KeyInfo keyInfo = new KeyInfo();
            DEFAULT_INSTANCE = keyInfo;
            GeneratedMessageLite.defaultInstanceMap.put(KeyInfo.class, keyInfo);
        }

        public static void access$100(KeyInfo keyInfo, String str) {
            if (keyInfo != null) {
                str.getClass();
                keyInfo.typeUrl_ = str;
                return;
            }
            throw null;
        }

        public static void access$1000(KeyInfo keyInfo, OutputPrefixType outputPrefixType) {
            if (keyInfo != null) {
                keyInfo.outputPrefixType_ = outputPrefixType.getNumber();
                return;
            }
            throw null;
        }

        public static void access$500(KeyInfo keyInfo, KeyStatusType keyStatusType) {
            if (keyInfo != null) {
                keyInfo.status_ = keyStatusType.getNumber();
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
                    return new RawMessageInfo(DEFAULT_INSTANCE, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0000\u0000\u0001Ȉ\u0002\f\u0003\u000b\u0004\f", new Object[]{"typeUrl_", "status_", "keyId_", "outputPrefixType_"});
                case 3:
                    return new KeyInfo();
                case 4:
                    return new Builder(null);
                case 5:
                    return DEFAULT_INSTANCE;
                case 6:
                    Parser<KeyInfo> parser = PARSER;
                    if (parser == null) {
                        synchronized (KeyInfo.class) {
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

    static {
        KeysetInfo keysetInfo = new KeysetInfo();
        DEFAULT_INSTANCE = keysetInfo;
        GeneratedMessageLite.defaultInstanceMap.put(KeysetInfo.class, keysetInfo);
    }

    public static void access$1700(KeysetInfo keysetInfo, KeyInfo keyInfo) {
        if (keysetInfo != null) {
            keyInfo.getClass();
            if (!keysetInfo.keyInfo_.isModifiable()) {
                ProtobufList<KeyInfo> protobufList = keysetInfo.keyInfo_;
                int size = protobufList.size();
                keysetInfo.keyInfo_ = protobufList.mutableCopyWithCapacity(size == 0 ? 10 : size * 2);
            }
            keysetInfo.keyInfo_.add(keyInfo);
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
                return new RawMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u000b\u0002\u001b", new Object[]{"primaryKeyId_", "keyInfo_", KeyInfo.class});
            case 3:
                return new KeysetInfo();
            case 4:
                return new Builder(null);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                Parser<KeysetInfo> parser = PARSER;
                if (parser == null) {
                    synchronized (KeysetInfo.class) {
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
