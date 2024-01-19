package com.google.firebase.perf.v1;

import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.GeneratedMessageLite.DefaultInstanceBasedParser;
import com.google.protobuf.GeneratedMessageLite.MethodToInvoke;
import com.google.protobuf.Parser;
import com.google.protobuf.RawMessageInfo;

public final class CpuMetricReading extends GeneratedMessageLite<CpuMetricReading, Builder> implements Object {
    public static final int CLIENT_TIME_US_FIELD_NUMBER = 1;
    public static final CpuMetricReading DEFAULT_INSTANCE;
    public static volatile Parser<CpuMetricReading> PARSER = null;
    public static final int SYSTEM_TIME_US_FIELD_NUMBER = 3;
    public static final int USER_TIME_US_FIELD_NUMBER = 2;
    public int bitField0_;
    public long clientTimeUs_;
    public long systemTimeUs_;
    public long userTimeUs_;

    public static final class Builder extends com.google.protobuf.GeneratedMessageLite.Builder<CpuMetricReading, Builder> implements Object {
        public Builder() {
            super(CpuMetricReading.DEFAULT_INSTANCE);
        }

        public Builder(AnonymousClass1 r1) {
            super(CpuMetricReading.DEFAULT_INSTANCE);
        }
    }

    static {
        CpuMetricReading cpuMetricReading = new CpuMetricReading();
        DEFAULT_INSTANCE = cpuMetricReading;
        GeneratedMessageLite.defaultInstanceMap.put(CpuMetricReading.class, cpuMetricReading);
    }

    public final Object dynamicMethod(MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        switch (methodToInvoke.ordinal()) {
            case 0:
                return Byte.valueOf(1);
            case 1:
                return null;
            case 2:
                return new RawMessageInfo(DEFAULT_INSTANCE, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဂ\u0000\u0002ဂ\u0001\u0003ဂ\u0002", new Object[]{"bitField0_", "clientTimeUs_", "userTimeUs_", "systemTimeUs_"});
            case 3:
                return new CpuMetricReading();
            case 4:
                return new Builder(null);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                Parser<CpuMetricReading> parser = PARSER;
                if (parser == null) {
                    synchronized (CpuMetricReading.class) {
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
