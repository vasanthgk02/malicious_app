package com.google.firebase.perf.v1;

import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.GeneratedMessageLite.DefaultInstanceBasedParser;
import com.google.protobuf.GeneratedMessageLite.MethodToInvoke;
import com.google.protobuf.Internal.ProtobufList;
import com.google.protobuf.Parser;
import com.google.protobuf.ProtobufArrayList;
import com.google.protobuf.RawMessageInfo;

public final class GaugeMetric extends GeneratedMessageLite<GaugeMetric, Builder> implements Object {
    public static final int ANDROID_MEMORY_READINGS_FIELD_NUMBER = 4;
    public static final int CPU_METRIC_READINGS_FIELD_NUMBER = 2;
    public static final GaugeMetric DEFAULT_INSTANCE;
    public static final int GAUGE_METADATA_FIELD_NUMBER = 3;
    public static volatile Parser<GaugeMetric> PARSER = null;
    public static final int SESSION_ID_FIELD_NUMBER = 1;
    public ProtobufList<AndroidMemoryReading> androidMemoryReadings_;
    public int bitField0_;
    public ProtobufList<CpuMetricReading> cpuMetricReadings_;
    public GaugeMetadata gaugeMetadata_;
    public String sessionId_ = "";

    public static final class Builder extends com.google.protobuf.GeneratedMessageLite.Builder<GaugeMetric, Builder> implements Object {
        public Builder() {
            super(GaugeMetric.DEFAULT_INSTANCE);
        }

        public Builder(AnonymousClass1 r1) {
            super(GaugeMetric.DEFAULT_INSTANCE);
        }
    }

    static {
        GaugeMetric gaugeMetric = new GaugeMetric();
        DEFAULT_INSTANCE = gaugeMetric;
        GeneratedMessageLite.defaultInstanceMap.put(GaugeMetric.class, gaugeMetric);
    }

    public GaugeMetric() {
        ProtobufArrayList<Object> protobufArrayList = ProtobufArrayList.EMPTY_LIST;
        this.cpuMetricReadings_ = protobufArrayList;
        this.androidMemoryReadings_ = protobufArrayList;
    }

    public static void access$100(GaugeMetric gaugeMetric, String str) {
        if (gaugeMetric != null) {
            str.getClass();
            gaugeMetric.bitField0_ |= 1;
            gaugeMetric.sessionId_ = str;
            return;
        }
        throw null;
    }

    public static void access$1400(GaugeMetric gaugeMetric, AndroidMemoryReading androidMemoryReading) {
        if (gaugeMetric != null) {
            androidMemoryReading.getClass();
            ProtobufList<AndroidMemoryReading> protobufList = gaugeMetric.androidMemoryReadings_;
            if (!protobufList.isModifiable()) {
                gaugeMetric.androidMemoryReadings_ = GeneratedMessageLite.mutableCopy(protobufList);
            }
            gaugeMetric.androidMemoryReadings_.add(androidMemoryReading);
            return;
        }
        throw null;
    }

    public static void access$400(GaugeMetric gaugeMetric, GaugeMetadata gaugeMetadata) {
        if (gaugeMetric != null) {
            gaugeMetadata.getClass();
            gaugeMetric.gaugeMetadata_ = gaugeMetadata;
            gaugeMetric.bitField0_ |= 2;
            return;
        }
        throw null;
    }

    public static void access$800(GaugeMetric gaugeMetric, CpuMetricReading cpuMetricReading) {
        if (gaugeMetric != null) {
            cpuMetricReading.getClass();
            ProtobufList<CpuMetricReading> protobufList = gaugeMetric.cpuMetricReadings_;
            if (!protobufList.isModifiable()) {
                gaugeMetric.cpuMetricReadings_ = GeneratedMessageLite.mutableCopy(protobufList);
            }
            gaugeMetric.cpuMetricReadings_.add(cpuMetricReading);
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
                return new RawMessageInfo(DEFAULT_INSTANCE, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0002\u0000\u0001ဈ\u0000\u0002\u001b\u0003ဉ\u0001\u0004\u001b", new Object[]{"bitField0_", "sessionId_", "cpuMetricReadings_", CpuMetricReading.class, "gaugeMetadata_", "androidMemoryReadings_", AndroidMemoryReading.class});
            case 3:
                return new GaugeMetric();
            case 4:
                return new Builder(null);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                Parser<GaugeMetric> parser = PARSER;
                if (parser == null) {
                    synchronized (GaugeMetric.class) {
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
