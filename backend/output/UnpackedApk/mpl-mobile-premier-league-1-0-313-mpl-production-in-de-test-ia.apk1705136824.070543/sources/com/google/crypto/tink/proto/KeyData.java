package com.google.crypto.tink.proto;

import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite;
import com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite.DefaultInstanceBasedParser;
import com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite.MethodToInvoke;
import com.google.crypto.tink.shaded.protobuf.Internal.EnumLite;
import com.google.crypto.tink.shaded.protobuf.Internal.EnumLiteMap;
import com.google.crypto.tink.shaded.protobuf.Internal.EnumVerifier;
import com.google.crypto.tink.shaded.protobuf.Parser;
import com.google.crypto.tink.shaded.protobuf.RawMessageInfo;

public final class KeyData extends GeneratedMessageLite<KeyData, Builder> implements Object {
    public static final KeyData DEFAULT_INSTANCE;
    public static final int KEY_MATERIAL_TYPE_FIELD_NUMBER = 3;
    public static volatile Parser<KeyData> PARSER = null;
    public static final int TYPE_URL_FIELD_NUMBER = 1;
    public static final int VALUE_FIELD_NUMBER = 2;
    public int keyMaterialType_;
    public String typeUrl_ = "";
    public ByteString value_ = ByteString.EMPTY;

    public static final class Builder extends com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite.Builder<KeyData, Builder> implements Object {
        public Builder() {
            super(KeyData.DEFAULT_INSTANCE);
        }

        public Builder(AnonymousClass1 r1) {
            super(KeyData.DEFAULT_INSTANCE);
        }
    }

    public enum KeyMaterialType implements EnumLite {
        UNKNOWN_KEYMATERIAL(0),
        SYMMETRIC(1),
        ASYMMETRIC_PRIVATE(2),
        ASYMMETRIC_PUBLIC(3),
        REMOTE(4),
        UNRECOGNIZED(-1);
        
        public static final int ASYMMETRIC_PRIVATE_VALUE = 2;
        public static final int ASYMMETRIC_PUBLIC_VALUE = 3;
        public static final int REMOTE_VALUE = 4;
        public static final int SYMMETRIC_VALUE = 1;
        public static final int UNKNOWN_KEYMATERIAL_VALUE = 0;
        public static final EnumLiteMap<KeyMaterialType> internalValueMap = null;
        public final int value;

        public static final class KeyMaterialTypeVerifier implements EnumVerifier {
            public static final EnumVerifier INSTANCE = null;

            static {
                INSTANCE = new KeyMaterialTypeVerifier();
            }

            public boolean isInRange(int i) {
                return KeyMaterialType.forNumber(i) != null;
            }
        }

        /* access modifiers changed from: public */
        static {
            internalValueMap = new EnumLiteMap<KeyMaterialType>() {
            };
        }

        /* access modifiers changed from: public */
        KeyMaterialType(int i) {
            this.value = i;
        }

        public static KeyMaterialType forNumber(int i) {
            if (i == 0) {
                return UNKNOWN_KEYMATERIAL;
            }
            if (i == 1) {
                return SYMMETRIC;
            }
            if (i == 2) {
                return ASYMMETRIC_PRIVATE;
            }
            if (i == 3) {
                return ASYMMETRIC_PUBLIC;
            }
            if (i != 4) {
                return null;
            }
            return REMOTE;
        }

        public static EnumLiteMap<KeyMaterialType> internalGetValueMap() {
            return internalValueMap;
        }

        public static EnumVerifier internalGetVerifier() {
            return KeyMaterialTypeVerifier.INSTANCE;
        }

        public final int getNumber() {
            if (this != UNRECOGNIZED) {
                return this.value;
            }
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }

        @Deprecated
        public static KeyMaterialType valueOf(int i) {
            return forNumber(i);
        }
    }

    static {
        KeyData keyData = new KeyData();
        DEFAULT_INSTANCE = keyData;
        GeneratedMessageLite.defaultInstanceMap.put(KeyData.class, keyData);
    }

    public static void access$100(KeyData keyData, String str) {
        if (keyData != null) {
            str.getClass();
            keyData.typeUrl_ = str;
            return;
        }
        throw null;
    }

    public static void access$400(KeyData keyData, ByteString byteString) {
        if (keyData != null) {
            byteString.getClass();
            keyData.value_ = byteString;
            return;
        }
        throw null;
    }

    public static void access$700(KeyData keyData, KeyMaterialType keyMaterialType) {
        if (keyData != null) {
            keyData.keyMaterialType_ = keyMaterialType.getNumber();
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
                return new RawMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001Ȉ\u0002\n\u0003\f", new Object[]{"typeUrl_", "value_", "keyMaterialType_"});
            case 3:
                return new KeyData();
            case 4:
                return new Builder(null);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                Parser<KeyData> parser = PARSER;
                if (parser == null) {
                    synchronized (KeyData.class) {
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
