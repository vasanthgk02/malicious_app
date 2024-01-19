package com.google.firebase.perf.v1;

import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.GeneratedMessageLite.DefaultInstanceBasedParser;
import com.google.protobuf.GeneratedMessageLite.MethodToInvoke;
import com.google.protobuf.Parser;
import com.google.protobuf.RawMessageInfo;

public final class AndroidMemoryReading extends GeneratedMessageLite<AndroidMemoryReading, Builder> implements Object {
    public static final int CLIENT_TIME_US_FIELD_NUMBER = 1;
    public static final AndroidMemoryReading DEFAULT_INSTANCE;
    public static volatile Parser<AndroidMemoryReading> PARSER = null;
    public static final int USED_APP_JAVA_HEAP_MEMORY_KB_FIELD_NUMBER = 2;
    public int bitField0_;
    public long clientTimeUs_;
    public int usedAppJavaHeapMemoryKb_;

    public static final class Builder extends com.google.protobuf.GeneratedMessageLite.Builder<AndroidMemoryReading, Builder> implements Object {
        public Builder() {
            super(AndroidMemoryReading.DEFAULT_INSTANCE);
        }

        public Builder(AnonymousClass1 r1) {
            super(AndroidMemoryReading.DEFAULT_INSTANCE);
        }
    }

    static {
        AndroidMemoryReading androidMemoryReading = new AndroidMemoryReading();
        DEFAULT_INSTANCE = androidMemoryReading;
        GeneratedMessageLite.defaultInstanceMap.put(AndroidMemoryReading.class, androidMemoryReading);
    }

    public final Object dynamicMethod(MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        switch (methodToInvoke.ordinal()) {
            case 0:
                return Byte.valueOf(1);
            case 1:
                return null;
            case 2:
                return new RawMessageInfo(DEFAULT_INSTANCE, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဂ\u0000\u0002င\u0001", new Object[]{"bitField0_", "clientTimeUs_", "usedAppJavaHeapMemoryKb_"});
            case 3:
                return new AndroidMemoryReading();
            case 4:
                return new Builder(null);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                Parser<AndroidMemoryReading> parser = PARSER;
                if (parser == null) {
                    synchronized (AndroidMemoryReading.class) {
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
