package com.google.firebase.perf.v1;

import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.GeneratedMessageLite.DefaultInstanceBasedParser;
import com.google.protobuf.GeneratedMessageLite.MethodToInvoke;
import com.google.protobuf.Parser;
import com.google.protobuf.RawMessageInfo;

public final class PerfMetric extends GeneratedMessageLite<PerfMetric, Builder> implements PerfMetricOrBuilder {
    public static final int APPLICATION_INFO_FIELD_NUMBER = 1;
    public static final PerfMetric DEFAULT_INSTANCE;
    public static final int GAUGE_METRIC_FIELD_NUMBER = 4;
    public static final int NETWORK_REQUEST_METRIC_FIELD_NUMBER = 3;
    public static volatile Parser<PerfMetric> PARSER = null;
    public static final int TRACE_METRIC_FIELD_NUMBER = 2;
    public static final int TRANSPORT_INFO_FIELD_NUMBER = 5;
    public ApplicationInfo applicationInfo_;
    public int bitField0_;
    public GaugeMetric gaugeMetric_;
    public NetworkRequestMetric networkRequestMetric_;
    public TraceMetric traceMetric_;
    public TransportInfo transportInfo_;

    public static final class Builder extends com.google.protobuf.GeneratedMessageLite.Builder<PerfMetric, Builder> implements PerfMetricOrBuilder {
        public Builder() {
            super(PerfMetric.DEFAULT_INSTANCE);
        }

        public GaugeMetric getGaugeMetric() {
            return ((PerfMetric) this.instance).getGaugeMetric();
        }

        public NetworkRequestMetric getNetworkRequestMetric() {
            return ((PerfMetric) this.instance).getNetworkRequestMetric();
        }

        public TraceMetric getTraceMetric() {
            return ((PerfMetric) this.instance).getTraceMetric();
        }

        public boolean hasGaugeMetric() {
            return ((PerfMetric) this.instance).hasGaugeMetric();
        }

        public boolean hasNetworkRequestMetric() {
            return ((PerfMetric) this.instance).hasNetworkRequestMetric();
        }

        public boolean hasTraceMetric() {
            return ((PerfMetric) this.instance).hasTraceMetric();
        }

        public Builder setGaugeMetric(GaugeMetric gaugeMetric) {
            copyOnWrite();
            PerfMetric.access$1000((PerfMetric) this.instance, gaugeMetric);
            return this;
        }

        public Builder setNetworkRequestMetric(NetworkRequestMetric networkRequestMetric) {
            copyOnWrite();
            PerfMetric.access$700((PerfMetric) this.instance, networkRequestMetric);
            return this;
        }

        public Builder setTraceMetric(TraceMetric traceMetric) {
            copyOnWrite();
            PerfMetric.access$400((PerfMetric) this.instance, traceMetric);
            return this;
        }

        public Builder(AnonymousClass1 r1) {
            super(PerfMetric.DEFAULT_INSTANCE);
        }
    }

    static {
        PerfMetric perfMetric = new PerfMetric();
        DEFAULT_INSTANCE = perfMetric;
        GeneratedMessageLite.defaultInstanceMap.put(PerfMetric.class, perfMetric);
    }

    public static void access$100(PerfMetric perfMetric, ApplicationInfo applicationInfo) {
        if (perfMetric != null) {
            applicationInfo.getClass();
            perfMetric.applicationInfo_ = applicationInfo;
            perfMetric.bitField0_ |= 1;
            return;
        }
        throw null;
    }

    public static void access$1000(PerfMetric perfMetric, GaugeMetric gaugeMetric) {
        if (perfMetric != null) {
            gaugeMetric.getClass();
            perfMetric.gaugeMetric_ = gaugeMetric;
            perfMetric.bitField0_ |= 8;
            return;
        }
        throw null;
    }

    public static void access$400(PerfMetric perfMetric, TraceMetric traceMetric) {
        if (perfMetric != null) {
            traceMetric.getClass();
            perfMetric.traceMetric_ = traceMetric;
            perfMetric.bitField0_ |= 2;
            return;
        }
        throw null;
    }

    public static void access$700(PerfMetric perfMetric, NetworkRequestMetric networkRequestMetric) {
        if (perfMetric != null) {
            networkRequestMetric.getClass();
            perfMetric.networkRequestMetric_ = networkRequestMetric;
            perfMetric.bitField0_ |= 4;
            return;
        }
        throw null;
    }

    public static Builder newBuilder() {
        return (Builder) DEFAULT_INSTANCE.createBuilder();
    }

    public final Object dynamicMethod(MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        switch (methodToInvoke.ordinal()) {
            case 0:
                return Byte.valueOf(1);
            case 1:
                return null;
            case 2:
                return new RawMessageInfo(DEFAULT_INSTANCE, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003ဉ\u0002\u0004ဉ\u0003\u0005ဉ\u0004", new Object[]{"bitField0_", "applicationInfo_", "traceMetric_", "networkRequestMetric_", "gaugeMetric_", "transportInfo_"});
            case 3:
                return new PerfMetric();
            case 4:
                return new Builder(null);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                Parser<PerfMetric> parser = PARSER;
                if (parser == null) {
                    synchronized (PerfMetric.class) {
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

    public GaugeMetric getGaugeMetric() {
        GaugeMetric gaugeMetric = this.gaugeMetric_;
        return gaugeMetric == null ? GaugeMetric.DEFAULT_INSTANCE : gaugeMetric;
    }

    public NetworkRequestMetric getNetworkRequestMetric() {
        NetworkRequestMetric networkRequestMetric = this.networkRequestMetric_;
        return networkRequestMetric == null ? NetworkRequestMetric.DEFAULT_INSTANCE : networkRequestMetric;
    }

    public TraceMetric getTraceMetric() {
        TraceMetric traceMetric = this.traceMetric_;
        return traceMetric == null ? TraceMetric.DEFAULT_INSTANCE : traceMetric;
    }

    public boolean hasGaugeMetric() {
        return (this.bitField0_ & 8) != 0;
    }

    public boolean hasNetworkRequestMetric() {
        return (this.bitField0_ & 4) != 0;
    }

    public boolean hasTraceMetric() {
        return (this.bitField0_ & 2) != 0;
    }
}
