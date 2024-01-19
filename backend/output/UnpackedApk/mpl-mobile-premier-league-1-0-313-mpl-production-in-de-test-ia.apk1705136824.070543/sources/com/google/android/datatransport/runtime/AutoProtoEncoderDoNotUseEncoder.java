package com.google.android.datatransport.runtime;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.google.android.datatransport.runtime.firebase.transport.ClientMetrics;
import com.google.android.datatransport.runtime.firebase.transport.GlobalMetrics;
import com.google.android.datatransport.runtime.firebase.transport.LogEventDropped;
import com.google.android.datatransport.runtime.firebase.transport.LogSourceMetrics;
import com.google.android.datatransport.runtime.firebase.transport.StorageMetrics;
import com.google.android.datatransport.runtime.firebase.transport.TimeWindow;
import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import com.google.firebase.encoders.config.Configurator;
import com.google.firebase.encoders.config.EncoderConfig;
import com.google.firebase.encoders.proto.AtProtobuf$ProtobufImpl;
import com.google.firebase.encoders.proto.Protobuf.IntEncoding;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class AutoProtoEncoderDoNotUseEncoder implements Configurator {
    public static final Configurator CONFIG = new AutoProtoEncoderDoNotUseEncoder();

    public static final class ClientMetricsEncoder implements ObjectEncoder<ClientMetrics> {
        public static final FieldDescriptor APPNAMESPACE_DESCRIPTOR;
        public static final FieldDescriptor GLOBALMETRICS_DESCRIPTOR;
        public static final ClientMetricsEncoder INSTANCE = new ClientMetricsEncoder();
        public static final FieldDescriptor LOGSOURCEMETRICS_DESCRIPTOR;
        public static final FieldDescriptor WINDOW_DESCRIPTOR;

        static {
            Map map;
            Map map2;
            Map map3;
            Map map4;
            AtProtobuf$ProtobufImpl atProtobuf$ProtobufImpl = new AtProtobuf$ProtobufImpl(1, IntEncoding.DEFAULT);
            HashMap hashMap = new HashMap();
            hashMap.put(atProtobuf$ProtobufImpl.annotationType(), atProtobuf$ProtobufImpl);
            if (hashMap == null) {
                map = Collections.emptyMap();
            } else {
                map = GeneratedOutlineSupport.outline89(hashMap);
            }
            WINDOW_DESCRIPTOR = new FieldDescriptor("window", map, null);
            AtProtobuf$ProtobufImpl atProtobuf$ProtobufImpl2 = new AtProtobuf$ProtobufImpl(2, IntEncoding.DEFAULT);
            HashMap hashMap2 = new HashMap();
            hashMap2.put(atProtobuf$ProtobufImpl2.annotationType(), atProtobuf$ProtobufImpl2);
            if (hashMap2 == null) {
                map2 = Collections.emptyMap();
            } else {
                map2 = GeneratedOutlineSupport.outline89(hashMap2);
            }
            LOGSOURCEMETRICS_DESCRIPTOR = new FieldDescriptor("logSourceMetrics", map2, null);
            AtProtobuf$ProtobufImpl atProtobuf$ProtobufImpl3 = new AtProtobuf$ProtobufImpl(3, IntEncoding.DEFAULT);
            HashMap hashMap3 = new HashMap();
            hashMap3.put(atProtobuf$ProtobufImpl3.annotationType(), atProtobuf$ProtobufImpl3);
            if (hashMap3 == null) {
                map3 = Collections.emptyMap();
            } else {
                map3 = GeneratedOutlineSupport.outline89(hashMap3);
            }
            GLOBALMETRICS_DESCRIPTOR = new FieldDescriptor("globalMetrics", map3, null);
            AtProtobuf$ProtobufImpl atProtobuf$ProtobufImpl4 = new AtProtobuf$ProtobufImpl(4, IntEncoding.DEFAULT);
            HashMap hashMap4 = new HashMap();
            hashMap4.put(atProtobuf$ProtobufImpl4.annotationType(), atProtobuf$ProtobufImpl4);
            if (hashMap4 == null) {
                map4 = Collections.emptyMap();
            } else {
                map4 = GeneratedOutlineSupport.outline89(hashMap4);
            }
            APPNAMESPACE_DESCRIPTOR = new FieldDescriptor("appNamespace", map4, null);
        }

        public void encode(Object obj, Object obj2) throws IOException {
            ClientMetrics clientMetrics = (ClientMetrics) obj;
            ObjectEncoderContext objectEncoderContext = (ObjectEncoderContext) obj2;
            objectEncoderContext.add(WINDOW_DESCRIPTOR, (Object) clientMetrics.window_);
            objectEncoderContext.add(LOGSOURCEMETRICS_DESCRIPTOR, (Object) clientMetrics.log_source_metrics_);
            objectEncoderContext.add(GLOBALMETRICS_DESCRIPTOR, (Object) clientMetrics.global_metrics_);
            objectEncoderContext.add(APPNAMESPACE_DESCRIPTOR, (Object) clientMetrics.app_namespace_);
        }
    }

    public static final class GlobalMetricsEncoder implements ObjectEncoder<GlobalMetrics> {
        public static final GlobalMetricsEncoder INSTANCE = new GlobalMetricsEncoder();
        public static final FieldDescriptor STORAGEMETRICS_DESCRIPTOR;

        static {
            Map map;
            AtProtobuf$ProtobufImpl atProtobuf$ProtobufImpl = new AtProtobuf$ProtobufImpl(1, IntEncoding.DEFAULT);
            HashMap hashMap = new HashMap();
            hashMap.put(atProtobuf$ProtobufImpl.annotationType(), atProtobuf$ProtobufImpl);
            if (hashMap == null) {
                map = Collections.emptyMap();
            } else {
                map = GeneratedOutlineSupport.outline89(hashMap);
            }
            STORAGEMETRICS_DESCRIPTOR = new FieldDescriptor("storageMetrics", map, null);
        }

        public void encode(Object obj, Object obj2) throws IOException {
            ((ObjectEncoderContext) obj2).add(STORAGEMETRICS_DESCRIPTOR, (Object) ((GlobalMetrics) obj).storage_metrics_);
        }
    }

    public static final class LogEventDroppedEncoder implements ObjectEncoder<LogEventDropped> {
        public static final FieldDescriptor EVENTSDROPPEDCOUNT_DESCRIPTOR;
        public static final LogEventDroppedEncoder INSTANCE = new LogEventDroppedEncoder();
        public static final FieldDescriptor REASON_DESCRIPTOR;

        static {
            Map map;
            Map map2;
            AtProtobuf$ProtobufImpl atProtobuf$ProtobufImpl = new AtProtobuf$ProtobufImpl(1, IntEncoding.DEFAULT);
            HashMap hashMap = new HashMap();
            hashMap.put(atProtobuf$ProtobufImpl.annotationType(), atProtobuf$ProtobufImpl);
            if (hashMap == null) {
                map = Collections.emptyMap();
            } else {
                map = GeneratedOutlineSupport.outline89(hashMap);
            }
            EVENTSDROPPEDCOUNT_DESCRIPTOR = new FieldDescriptor("eventsDroppedCount", map, null);
            AtProtobuf$ProtobufImpl atProtobuf$ProtobufImpl2 = new AtProtobuf$ProtobufImpl(3, IntEncoding.DEFAULT);
            HashMap hashMap2 = new HashMap();
            hashMap2.put(atProtobuf$ProtobufImpl2.annotationType(), atProtobuf$ProtobufImpl2);
            if (hashMap2 == null) {
                map2 = Collections.emptyMap();
            } else {
                map2 = GeneratedOutlineSupport.outline89(hashMap2);
            }
            REASON_DESCRIPTOR = new FieldDescriptor("reason", map2, null);
        }

        public void encode(Object obj, Object obj2) throws IOException {
            LogEventDropped logEventDropped = (LogEventDropped) obj;
            ObjectEncoderContext objectEncoderContext = (ObjectEncoderContext) obj2;
            objectEncoderContext.add(EVENTSDROPPEDCOUNT_DESCRIPTOR, logEventDropped.events_dropped_count_);
            objectEncoderContext.add(REASON_DESCRIPTOR, (Object) logEventDropped.reason_);
        }
    }

    public static final class LogSourceMetricsEncoder implements ObjectEncoder<LogSourceMetrics> {
        public static final LogSourceMetricsEncoder INSTANCE = new LogSourceMetricsEncoder();
        public static final FieldDescriptor LOGEVENTDROPPED_DESCRIPTOR;
        public static final FieldDescriptor LOGSOURCE_DESCRIPTOR;

        static {
            Map map;
            Map map2;
            AtProtobuf$ProtobufImpl atProtobuf$ProtobufImpl = new AtProtobuf$ProtobufImpl(1, IntEncoding.DEFAULT);
            HashMap hashMap = new HashMap();
            hashMap.put(atProtobuf$ProtobufImpl.annotationType(), atProtobuf$ProtobufImpl);
            if (hashMap == null) {
                map = Collections.emptyMap();
            } else {
                map = GeneratedOutlineSupport.outline89(hashMap);
            }
            LOGSOURCE_DESCRIPTOR = new FieldDescriptor("logSource", map, null);
            AtProtobuf$ProtobufImpl atProtobuf$ProtobufImpl2 = new AtProtobuf$ProtobufImpl(2, IntEncoding.DEFAULT);
            HashMap hashMap2 = new HashMap();
            hashMap2.put(atProtobuf$ProtobufImpl2.annotationType(), atProtobuf$ProtobufImpl2);
            if (hashMap2 == null) {
                map2 = Collections.emptyMap();
            } else {
                map2 = GeneratedOutlineSupport.outline89(hashMap2);
            }
            LOGEVENTDROPPED_DESCRIPTOR = new FieldDescriptor("logEventDropped", map2, null);
        }

        public void encode(Object obj, Object obj2) throws IOException {
            LogSourceMetrics logSourceMetrics = (LogSourceMetrics) obj;
            ObjectEncoderContext objectEncoderContext = (ObjectEncoderContext) obj2;
            objectEncoderContext.add(LOGSOURCE_DESCRIPTOR, (Object) logSourceMetrics.log_source_);
            objectEncoderContext.add(LOGEVENTDROPPED_DESCRIPTOR, (Object) logSourceMetrics.log_event_dropped_);
        }
    }

    public static final class ProtoEncoderDoNotUseEncoder implements ObjectEncoder<ProtoEncoderDoNotUse> {
        public static final FieldDescriptor CLIENTMETRICS_DESCRIPTOR = FieldDescriptor.of("clientMetrics");
        public static final ProtoEncoderDoNotUseEncoder INSTANCE = new ProtoEncoderDoNotUseEncoder();

        public void encode(Object obj, Object obj2) throws IOException {
            ((ObjectEncoderContext) obj2).add(CLIENTMETRICS_DESCRIPTOR, (Object) ((ProtoEncoderDoNotUse) obj).getClientMetrics());
        }
    }

    public static final class StorageMetricsEncoder implements ObjectEncoder<StorageMetrics> {
        public static final FieldDescriptor CURRENTCACHESIZEBYTES_DESCRIPTOR;
        public static final StorageMetricsEncoder INSTANCE = new StorageMetricsEncoder();
        public static final FieldDescriptor MAXCACHESIZEBYTES_DESCRIPTOR;

        static {
            Map map;
            Map map2;
            AtProtobuf$ProtobufImpl atProtobuf$ProtobufImpl = new AtProtobuf$ProtobufImpl(1, IntEncoding.DEFAULT);
            HashMap hashMap = new HashMap();
            hashMap.put(atProtobuf$ProtobufImpl.annotationType(), atProtobuf$ProtobufImpl);
            if (hashMap == null) {
                map = Collections.emptyMap();
            } else {
                map = GeneratedOutlineSupport.outline89(hashMap);
            }
            CURRENTCACHESIZEBYTES_DESCRIPTOR = new FieldDescriptor("currentCacheSizeBytes", map, null);
            AtProtobuf$ProtobufImpl atProtobuf$ProtobufImpl2 = new AtProtobuf$ProtobufImpl(2, IntEncoding.DEFAULT);
            HashMap hashMap2 = new HashMap();
            hashMap2.put(atProtobuf$ProtobufImpl2.annotationType(), atProtobuf$ProtobufImpl2);
            if (hashMap2 == null) {
                map2 = Collections.emptyMap();
            } else {
                map2 = GeneratedOutlineSupport.outline89(hashMap2);
            }
            MAXCACHESIZEBYTES_DESCRIPTOR = new FieldDescriptor("maxCacheSizeBytes", map2, null);
        }

        public void encode(Object obj, Object obj2) throws IOException {
            StorageMetrics storageMetrics = (StorageMetrics) obj;
            ObjectEncoderContext objectEncoderContext = (ObjectEncoderContext) obj2;
            objectEncoderContext.add(CURRENTCACHESIZEBYTES_DESCRIPTOR, storageMetrics.current_cache_size_bytes_);
            objectEncoderContext.add(MAXCACHESIZEBYTES_DESCRIPTOR, storageMetrics.max_cache_size_bytes_);
        }
    }

    public static final class TimeWindowEncoder implements ObjectEncoder<TimeWindow> {
        public static final FieldDescriptor ENDMS_DESCRIPTOR;
        public static final TimeWindowEncoder INSTANCE = new TimeWindowEncoder();
        public static final FieldDescriptor STARTMS_DESCRIPTOR;

        static {
            Map map;
            Map map2;
            AtProtobuf$ProtobufImpl atProtobuf$ProtobufImpl = new AtProtobuf$ProtobufImpl(1, IntEncoding.DEFAULT);
            HashMap hashMap = new HashMap();
            hashMap.put(atProtobuf$ProtobufImpl.annotationType(), atProtobuf$ProtobufImpl);
            if (hashMap == null) {
                map = Collections.emptyMap();
            } else {
                map = GeneratedOutlineSupport.outline89(hashMap);
            }
            STARTMS_DESCRIPTOR = new FieldDescriptor("startMs", map, null);
            AtProtobuf$ProtobufImpl atProtobuf$ProtobufImpl2 = new AtProtobuf$ProtobufImpl(2, IntEncoding.DEFAULT);
            HashMap hashMap2 = new HashMap();
            hashMap2.put(atProtobuf$ProtobufImpl2.annotationType(), atProtobuf$ProtobufImpl2);
            if (hashMap2 == null) {
                map2 = Collections.emptyMap();
            } else {
                map2 = GeneratedOutlineSupport.outline89(hashMap2);
            }
            ENDMS_DESCRIPTOR = new FieldDescriptor("endMs", map2, null);
        }

        public void encode(Object obj, Object obj2) throws IOException {
            TimeWindow timeWindow = (TimeWindow) obj;
            ObjectEncoderContext objectEncoderContext = (ObjectEncoderContext) obj2;
            objectEncoderContext.add(STARTMS_DESCRIPTOR, timeWindow.start_ms_);
            objectEncoderContext.add(ENDMS_DESCRIPTOR, timeWindow.end_ms_);
        }
    }

    public void configure(EncoderConfig<?> encoderConfig) {
        encoderConfig.registerEncoder(ProtoEncoderDoNotUse.class, ProtoEncoderDoNotUseEncoder.INSTANCE);
        encoderConfig.registerEncoder(ClientMetrics.class, ClientMetricsEncoder.INSTANCE);
        encoderConfig.registerEncoder(TimeWindow.class, TimeWindowEncoder.INSTANCE);
        encoderConfig.registerEncoder(LogSourceMetrics.class, LogSourceMetricsEncoder.INSTANCE);
        encoderConfig.registerEncoder(LogEventDropped.class, LogEventDroppedEncoder.INSTANCE);
        encoderConfig.registerEncoder(GlobalMetrics.class, GlobalMetricsEncoder.INSTANCE);
        encoderConfig.registerEncoder(StorageMetrics.class, StorageMetricsEncoder.INSTANCE);
    }
}
