package com.google.firebase.perf.v1;

import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.GeneratedMessageLite.DefaultInstanceBasedParser;
import com.google.protobuf.GeneratedMessageLite.MethodToInvoke;
import com.google.protobuf.Internal.EnumLite;
import com.google.protobuf.Internal.EnumLiteMap;
import com.google.protobuf.Internal.EnumVerifier;
import com.google.protobuf.Parser;
import com.google.protobuf.RawMessageInfo;

public final class TransportInfo extends GeneratedMessageLite<TransportInfo, Builder> implements Object {
    public static final TransportInfo DEFAULT_INSTANCE;
    public static final int DISPATCH_DESTINATION_FIELD_NUMBER = 1;
    public static volatile Parser<TransportInfo> PARSER;
    public int bitField0_;
    public int dispatchDestination_;

    public static final class Builder extends com.google.protobuf.GeneratedMessageLite.Builder<TransportInfo, Builder> implements Object {
        public Builder(AnonymousClass1 r1) {
            super(TransportInfo.DEFAULT_INSTANCE);
        }
    }

    public enum DispatchDestination implements EnumLite {
        SOURCE_UNKNOWN(0),
        FL_LEGACY_V1(1);
        
        public static final int FL_LEGACY_V1_VALUE = 1;
        public static final int SOURCE_UNKNOWN_VALUE = 0;
        public static final EnumLiteMap<DispatchDestination> internalValueMap = null;
        public final int value;

        public static final class DispatchDestinationVerifier implements EnumVerifier {
            public static final EnumVerifier INSTANCE = null;

            static {
                INSTANCE = new DispatchDestinationVerifier();
            }

            public boolean isInRange(int i) {
                return DispatchDestination.forNumber(i) != null;
            }
        }

        /* access modifiers changed from: public */
        static {
            internalValueMap = new EnumLiteMap<DispatchDestination>() {
            };
        }

        /* access modifiers changed from: public */
        DispatchDestination(int i) {
            this.value = i;
        }

        public static DispatchDestination forNumber(int i) {
            if (i == 0) {
                return SOURCE_UNKNOWN;
            }
            if (i != 1) {
                return null;
            }
            return FL_LEGACY_V1;
        }

        public static EnumLiteMap<DispatchDestination> internalGetValueMap() {
            return internalValueMap;
        }

        public static EnumVerifier internalGetVerifier() {
            return DispatchDestinationVerifier.INSTANCE;
        }

        public final int getNumber() {
            return this.value;
        }

        @Deprecated
        public static DispatchDestination valueOf(int i) {
            return forNumber(i);
        }
    }

    static {
        TransportInfo transportInfo = new TransportInfo();
        DEFAULT_INSTANCE = transportInfo;
        GeneratedMessageLite.defaultInstanceMap.put(TransportInfo.class, transportInfo);
    }

    public final Object dynamicMethod(MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        switch (methodToInvoke.ordinal()) {
            case 0:
                return Byte.valueOf(1);
            case 1:
                return null;
            case 2:
                return new RawMessageInfo(DEFAULT_INSTANCE, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဌ\u0000", new Object[]{"bitField0_", "dispatchDestination_", DispatchDestination.internalGetVerifier()});
            case 3:
                return new TransportInfo();
            case 4:
                return new Builder(null);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                Parser<TransportInfo> parser = PARSER;
                if (parser == null) {
                    synchronized (TransportInfo.class) {
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
