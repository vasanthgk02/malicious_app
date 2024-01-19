package com.google.crypto.tink.proto;

import com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite;
import com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite.DefaultInstanceBasedParser;
import com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite.MethodToInvoke;
import com.google.crypto.tink.shaded.protobuf.Internal.ProtobufList;
import com.google.crypto.tink.shaded.protobuf.Parser;
import com.google.crypto.tink.shaded.protobuf.ProtobufArrayList;
import com.google.crypto.tink.shaded.protobuf.RawMessageInfo;

@Deprecated
public final class RegistryConfig extends GeneratedMessageLite<RegistryConfig, Builder> implements Object {
    public static final int CONFIG_NAME_FIELD_NUMBER = 1;
    public static final RegistryConfig DEFAULT_INSTANCE;
    public static final int ENTRY_FIELD_NUMBER = 2;
    public static volatile Parser<RegistryConfig> PARSER;
    public String configName_ = "";
    public ProtobufList<KeyTypeEntry> entry_ = ProtobufArrayList.EMPTY_LIST;

    public static final class Builder extends com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite.Builder<RegistryConfig, Builder> implements Object {
        public Builder(AnonymousClass1 r1) {
            super(RegistryConfig.DEFAULT_INSTANCE);
        }
    }

    static {
        RegistryConfig registryConfig = new RegistryConfig();
        DEFAULT_INSTANCE = registryConfig;
        GeneratedMessageLite.defaultInstanceMap.put(RegistryConfig.class, registryConfig);
    }

    public final Object dynamicMethod(MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        switch (methodToInvoke.ordinal()) {
            case 0:
                return Byte.valueOf(1);
            case 1:
                return null;
            case 2:
                return new RawMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001Ȉ\u0002\u001b", new Object[]{"configName_", "entry_", KeyTypeEntry.class});
            case 3:
                return new RegistryConfig();
            case 4:
                return new Builder(null);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                Parser<RegistryConfig> parser = PARSER;
                if (parser == null) {
                    synchronized (RegistryConfig.class) {
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
