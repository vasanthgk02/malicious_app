package com.google.firebase.perf.v1;

import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.GeneratedMessageLite.DefaultInstanceBasedParser;
import com.google.protobuf.GeneratedMessageLite.MethodToInvoke;
import com.google.protobuf.Parser;
import com.google.protobuf.RawMessageInfo;

public final class GaugeMetadata extends GeneratedMessageLite<GaugeMetadata, Builder> implements Object {
    public static final int CPU_CLOCK_RATE_KHZ_FIELD_NUMBER = 2;
    public static final int CPU_PROCESSOR_COUNT_FIELD_NUMBER = 6;
    public static final GaugeMetadata DEFAULT_INSTANCE;
    public static final int DEVICE_RAM_SIZE_KB_FIELD_NUMBER = 3;
    public static final int MAX_APP_JAVA_HEAP_MEMORY_KB_FIELD_NUMBER = 4;
    public static final int MAX_ENCOURAGED_APP_JAVA_HEAP_MEMORY_KB_FIELD_NUMBER = 5;
    public static volatile Parser<GaugeMetadata> PARSER = null;
    public static final int PROCESS_NAME_FIELD_NUMBER = 1;
    public int bitField0_;
    public int cpuClockRateKhz_;
    public int cpuProcessorCount_;
    public int deviceRamSizeKb_;
    public int maxAppJavaHeapMemoryKb_;
    public int maxEncouragedAppJavaHeapMemoryKb_;
    public String processName_ = "";

    public static final class Builder extends com.google.protobuf.GeneratedMessageLite.Builder<GaugeMetadata, Builder> implements Object {
        public Builder() {
            super(GaugeMetadata.DEFAULT_INSTANCE);
        }

        public Builder(AnonymousClass1 r1) {
            super(GaugeMetadata.DEFAULT_INSTANCE);
        }
    }

    static {
        GaugeMetadata gaugeMetadata = new GaugeMetadata();
        DEFAULT_INSTANCE = gaugeMetadata;
        GeneratedMessageLite.defaultInstanceMap.put(GaugeMetadata.class, gaugeMetadata);
    }

    public static void access$100(GaugeMetadata gaugeMetadata, String str) {
        if (gaugeMetadata != null) {
            str.getClass();
            gaugeMetadata.bitField0_ |= 1;
            gaugeMetadata.processName_ = str;
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
                return new RawMessageInfo(DEFAULT_INSTANCE, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001ဈ\u0000\u0002င\u0001\u0003င\u0003\u0004င\u0004\u0005င\u0005\u0006င\u0002", new Object[]{"bitField0_", "processName_", "cpuClockRateKhz_", "deviceRamSizeKb_", "maxAppJavaHeapMemoryKb_", "maxEncouragedAppJavaHeapMemoryKb_", "cpuProcessorCount_"});
            case 3:
                return new GaugeMetadata();
            case 4:
                return new Builder(null);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                Parser<GaugeMetadata> parser = PARSER;
                if (parser == null) {
                    synchronized (GaugeMetadata.class) {
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
