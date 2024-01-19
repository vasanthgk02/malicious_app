package com.google.firebase.perf.metrics;

import com.google.firebase.perf.session.PerfSession;
import com.google.firebase.perf.v1.TraceMetric;
import com.google.firebase.perf.v1.TraceMetric.Builder;
import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal.ProtobufList;
import com.google.protobuf.MapFieldLite;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class TraceMetricBuilder {
    public final Trace trace;

    public TraceMetricBuilder(Trace trace2) {
        this.trace = trace2;
    }

    public TraceMetric build() {
        List unmodifiableList;
        Builder newBuilder = TraceMetric.newBuilder();
        newBuilder.setName(this.trace.name);
        newBuilder.setClientStartTimeUs(this.trace.startTime.timeInMicros);
        Trace trace2 = this.trace;
        newBuilder.setDurationUs(trace2.startTime.getDurationMicros(trace2.endTime));
        for (Counter next : this.trace.counterNameToCounterMap.values()) {
            newBuilder.putCounters(next.name, next.getCount());
        }
        List<Trace> list = this.trace.subtraces;
        if (!list.isEmpty()) {
            for (Trace traceMetricBuilder : list) {
                TraceMetric build = new TraceMetricBuilder(traceMetricBuilder).build();
                newBuilder.copyOnWrite();
                TraceMetric.access$1200((TraceMetric) newBuilder.instance, build);
            }
        }
        Map<String, String> attributes = this.trace.getAttributes();
        newBuilder.copyOnWrite();
        TraceMetric traceMetric = (TraceMetric) newBuilder.instance;
        MapFieldLite<String, String> mapFieldLite = traceMetric.customAttributes_;
        if (!mapFieldLite.isMutable) {
            traceMetric.customAttributes_ = mapFieldLite.mutableCopy();
        }
        traceMetric.customAttributes_.putAll(attributes);
        Trace trace3 = this.trace;
        synchronized (trace3.sessions) {
            try {
                ArrayList arrayList = new ArrayList();
                for (PerfSession next2 : trace3.sessions) {
                    if (next2 != null) {
                        arrayList.add(next2);
                    }
                }
                unmodifiableList = Collections.unmodifiableList(arrayList);
            }
        }
        com.google.firebase.perf.v1.PerfSession[] buildAndSort = PerfSession.buildAndSort(unmodifiableList);
        if (buildAndSort != null) {
            List asList = Arrays.asList(buildAndSort);
            newBuilder.copyOnWrite();
            TraceMetric traceMetric2 = (TraceMetric) newBuilder.instance;
            ProtobufList<com.google.firebase.perf.v1.PerfSession> protobufList = traceMetric2.perfSessions_;
            if (!protobufList.isModifiable()) {
                traceMetric2.perfSessions_ = GeneratedMessageLite.mutableCopy(protobufList);
            }
            AbstractMessageLite.addAll(asList, traceMetric2.perfSessions_);
        }
        return (TraceMetric) newBuilder.build();
    }
}
