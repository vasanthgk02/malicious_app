package com.google.crypto.tink.proto;

import com.google.crypto.tink.shaded.protobuf.ExtensionRegistryLite;
import com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite;
import com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite.DefaultInstanceBasedParser;
import com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite.MethodToInvoke;
import com.google.crypto.tink.shaded.protobuf.Internal.ProtobufList;
import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import com.google.crypto.tink.shaded.protobuf.Parser;
import com.google.crypto.tink.shaded.protobuf.ProtobufArrayList;
import com.google.crypto.tink.shaded.protobuf.RawMessageInfo;

public final class Keyset extends GeneratedMessageLite<Keyset, Builder> implements Object {
    public static final Keyset DEFAULT_INSTANCE;
    public static final int KEY_FIELD_NUMBER = 2;
    public static volatile Parser<Keyset> PARSER = null;
    public static final int PRIMARY_KEY_ID_FIELD_NUMBER = 1;
    public ProtobufList<Key> key_ = ProtobufArrayList.EMPTY_LIST;
    public int primaryKeyId_;

    public static final class Builder extends com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite.Builder<Keyset, Builder> implements Object {
        public Builder() {
            super(Keyset.DEFAULT_INSTANCE);
        }

        public Builder(AnonymousClass1 r1) {
            super(Keyset.DEFAULT_INSTANCE);
        }
    }

    public static final class Key extends GeneratedMessageLite<Key, Builder> implements Object {
        public static final Key DEFAULT_INSTANCE;
        public static final int KEY_DATA_FIELD_NUMBER = 1;
        public static final int KEY_ID_FIELD_NUMBER = 3;
        public static final int OUTPUT_PREFIX_TYPE_FIELD_NUMBER = 4;
        public static volatile Parser<Key> PARSER = null;
        public static final int STATUS_FIELD_NUMBER = 2;
        public KeyData keyData_;
        public int keyId_;
        public int outputPrefixType_;
        public int status_;

        public static final class Builder extends com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite.Builder<Key, Builder> implements Object {
            public Builder() {
                super(Key.DEFAULT_INSTANCE);
            }

            public Builder(AnonymousClass1 r1) {
                super(Key.DEFAULT_INSTANCE);
            }
        }

        static {
            Key key = new Key();
            DEFAULT_INSTANCE = key;
            GeneratedMessageLite.defaultInstanceMap.put(Key.class, key);
        }

        public static void access$100(Key key, KeyData keyData) {
            if (key != null) {
                keyData.getClass();
                key.keyData_ = keyData;
                return;
            }
            throw null;
        }

        public static void access$1000(Key key, OutputPrefixType outputPrefixType) {
            if (key != null) {
                key.outputPrefixType_ = outputPrefixType.getNumber();
                return;
            }
            throw null;
        }

        public static void access$500(Key key, KeyStatusType keyStatusType) {
            if (key != null) {
                key.status_ = keyStatusType.getNumber();
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
                    return new RawMessageInfo(DEFAULT_INSTANCE, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0000\u0000\u0001\t\u0002\f\u0003\u000b\u0004\f", new Object[]{"keyData_", "status_", "keyId_", "outputPrefixType_"});
                case 3:
                    return new Key();
                case 4:
                    return new Builder(null);
                case 5:
                    return DEFAULT_INSTANCE;
                case 6:
                    Parser<Key> parser = PARSER;
                    if (parser == null) {
                        synchronized (Key.class) {
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

        public KeyData getKeyData() {
            KeyData keyData = this.keyData_;
            return keyData == null ? KeyData.DEFAULT_INSTANCE : keyData;
        }

        public OutputPrefixType getOutputPrefixType() {
            OutputPrefixType forNumber = OutputPrefixType.forNumber(this.outputPrefixType_);
            return forNumber == null ? OutputPrefixType.UNRECOGNIZED : forNumber;
        }

        public KeyStatusType getStatus() {
            KeyStatusType forNumber = KeyStatusType.forNumber(this.status_);
            return forNumber == null ? KeyStatusType.UNRECOGNIZED : forNumber;
        }
    }

    static {
        Keyset keyset = new Keyset();
        DEFAULT_INSTANCE = keyset;
        GeneratedMessageLite.defaultInstanceMap.put(Keyset.class, keyset);
    }

    public static void access$1700(Keyset keyset, Key key) {
        if (keyset != null) {
            key.getClass();
            if (!keyset.key_.isModifiable()) {
                ProtobufList<Key> protobufList = keyset.key_;
                int size = protobufList.size();
                keyset.key_ = protobufList.mutableCopyWithCapacity(size == 0 ? 10 : size * 2);
            }
            keyset.key_.add(key);
            return;
        }
        throw null;
    }

    public static Keyset parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (Keyset) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public final Object dynamicMethod(MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        switch (methodToInvoke.ordinal()) {
            case 0:
                return Byte.valueOf(1);
            case 1:
                return null;
            case 2:
                return new RawMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u000b\u0002\u001b", new Object[]{"primaryKeyId_", "key_", Key.class});
            case 3:
                return new Keyset();
            case 4:
                return new Builder(null);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                Parser<Keyset> parser = PARSER;
                if (parser == null) {
                    synchronized (Keyset.class) {
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
