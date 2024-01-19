package com.google.firebase.perf.v1;

import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.GeneratedMessageLite.DefaultInstanceBasedParser;
import com.google.protobuf.GeneratedMessageLite.MethodToInvoke;
import com.google.protobuf.Internal.ProtobufList;
import com.google.protobuf.MapEntryLite;
import com.google.protobuf.MapFieldLite;
import com.google.protobuf.Parser;
import com.google.protobuf.ProtobufArrayList;
import com.google.protobuf.RawMessageInfo;
import com.google.protobuf.WireFormat$FieldType;

public final class TraceMetric extends GeneratedMessageLite<TraceMetric, Builder> implements Object {
    public static final int CLIENT_START_TIME_US_FIELD_NUMBER = 4;
    public static final int COUNTERS_FIELD_NUMBER = 6;
    public static final int CUSTOM_ATTRIBUTES_FIELD_NUMBER = 8;
    public static final TraceMetric DEFAULT_INSTANCE;
    public static final int DURATION_US_FIELD_NUMBER = 5;
    public static final int IS_AUTO_FIELD_NUMBER = 2;
    public static final int NAME_FIELD_NUMBER = 1;
    public static volatile Parser<TraceMetric> PARSER = null;
    public static final int PERF_SESSIONS_FIELD_NUMBER = 9;
    public static final int SUBTRACES_FIELD_NUMBER = 7;
    public int bitField0_;
    public long clientStartTimeUs_;
    public MapFieldLite<String, Long> counters_;
    public MapFieldLite<String, String> customAttributes_;
    public long durationUs_;
    public boolean isAuto_;
    public String name_ = "";
    public ProtobufList<PerfSession> perfSessions_;
    public ProtobufList<TraceMetric> subtraces_;

    public static final class Builder extends com.google.protobuf.GeneratedMessageLite.Builder<TraceMetric, Builder> implements Object {
        public Builder() {
            super(TraceMetric.DEFAULT_INSTANCE);
        }

        public Builder putCounters(String str, long j) {
            str.getClass();
            copyOnWrite();
            TraceMetric traceMetric = (TraceMetric) this.instance;
            MapFieldLite<String, Long> mapFieldLite = traceMetric.counters_;
            if (!mapFieldLite.isMutable) {
                traceMetric.counters_ = mapFieldLite.mutableCopy();
            }
            traceMetric.counters_.put(str, Long.valueOf(j));
            return this;
        }

        public Builder setClientStartTimeUs(long j) {
            copyOnWrite();
            TraceMetric traceMetric = (TraceMetric) this.instance;
            traceMetric.bitField0_ |= 4;
            traceMetric.clientStartTimeUs_ = j;
            return this;
        }

        public Builder setDurationUs(long j) {
            copyOnWrite();
            TraceMetric traceMetric = (TraceMetric) this.instance;
            traceMetric.bitField0_ |= 8;
            traceMetric.durationUs_ = j;
            return this;
        }

        public Builder setName(String str) {
            copyOnWrite();
            TraceMetric.access$100((TraceMetric) this.instance, str);
            return this;
        }

        public Builder(AnonymousClass1 r1) {
            super(TraceMetric.DEFAULT_INSTANCE);
        }
    }

    public static final class CountersDefaultEntryHolder {
        public static final MapEntryLite<String, Long> defaultEntry = new MapEntryLite<>(WireFormat$FieldType.STRING, "", WireFormat$FieldType.INT64, Long.valueOf(0));
    }

    public static final class CustomAttributesDefaultEntryHolder {
        public static final MapEntryLite<String, String> defaultEntry;

        static {
            WireFormat$FieldType wireFormat$FieldType = WireFormat$FieldType.STRING;
            defaultEntry = new MapEntryLite<>(wireFormat$FieldType, "", wireFormat$FieldType, "");
        }
    }

    static {
        TraceMetric traceMetric = new TraceMetric();
        DEFAULT_INSTANCE = traceMetric;
        GeneratedMessageLite.defaultInstanceMap.put(TraceMetric.class, traceMetric);
    }

    public TraceMetric() {
        MapFieldLite<String, Long> mapFieldLite = MapFieldLite.EMPTY_MAP_FIELD;
        this.counters_ = mapFieldLite;
        this.customAttributes_ = mapFieldLite;
        ProtobufArrayList<Object> protobufArrayList = ProtobufArrayList.EMPTY_LIST;
        this.subtraces_ = protobufArrayList;
        this.perfSessions_ = protobufArrayList;
    }

    public static void access$100(TraceMetric traceMetric, String str) {
        if (traceMetric != null) {
            str.getClass();
            traceMetric.bitField0_ |= 1;
            traceMetric.name_ = str;
            return;
        }
        throw null;
    }

    public static void access$1200(TraceMetric traceMetric, TraceMetric traceMetric2) {
        if (traceMetric != null) {
            traceMetric2.getClass();
            ProtobufList<TraceMetric> protobufList = traceMetric.subtraces_;
            if (!protobufList.isModifiable()) {
                traceMetric.subtraces_ = GeneratedMessageLite.mutableCopy(protobufList);
            }
            traceMetric.subtraces_.add(traceMetric2);
            return;
        }
        throw null;
    }

    public static void access$1900(TraceMetric traceMetric, PerfSession perfSession) {
        if (traceMetric != null) {
            perfSession.getClass();
            ProtobufList<PerfSession> protobufList = traceMetric.perfSessions_;
            if (!protobufList.isModifiable()) {
                traceMetric.perfSessions_ = GeneratedMessageLite.mutableCopy(protobufList);
            }
            traceMetric.perfSessions_.add(perfSession);
            return;
        }
        throw null;
    }

    public static Builder newBuilder() {
        return (Builder) DEFAULT_INSTANCE.createBuilder();
    }

    public final Object dynamicMethod(MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Class<TraceMetric> cls = TraceMetric.class;
        RawMessageInfo rawMessageInfo = null;
        switch (methodToInvoke.ordinal()) {
            case 0:
                return Byte.valueOf(1);
            case 1:
                break;
            case 2:
                rawMessageInfo = new RawMessageInfo(DEFAULT_INSTANCE, "\u0001\b\u0000\u0001\u0001\t\b\u0002\u0002\u0000\u0001ဈ\u0000\u0002ဇ\u0001\u0004ဂ\u0002\u0005ဂ\u0003\u00062\u0007\u001b\b2\t\u001b", new Object[]{"bitField0_", "name_", "isAuto_", "clientStartTimeUs_", "durationUs_", "counters_", CountersDefaultEntryHolder.defaultEntry, "subtraces_", cls, "customAttributes_", CustomAttributesDefaultEntryHolder.defaultEntry, "perfSessions_", PerfSession.class});
                break;
            case 3:
                return new TraceMetric();
            case 4:
                return new Builder(null);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                Parser<TraceMetric> parser = PARSER;
                if (parser == null) {
                    synchronized (cls) {
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
        return rawMessageInfo;
    }

    public int getCountersCount() {
        return this.counters_.size();
    }
}
