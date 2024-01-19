package com.google.android.datatransport.cct.internal;

import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import com.google.firebase.encoders.config.Configurator;
import com.google.firebase.encoders.config.EncoderConfig;
import java.io.IOException;

public final class AutoBatchedLogRequestEncoder implements Configurator {
    public static final Configurator CONFIG = new AutoBatchedLogRequestEncoder();

    public static final class AndroidClientInfoEncoder implements ObjectEncoder<AndroidClientInfo> {
        public static final FieldDescriptor APPLICATIONBUILD_DESCRIPTOR = FieldDescriptor.of("applicationBuild");
        public static final FieldDescriptor COUNTRY_DESCRIPTOR = FieldDescriptor.of("country");
        public static final FieldDescriptor DEVICE_DESCRIPTOR = FieldDescriptor.of("device");
        public static final FieldDescriptor FINGERPRINT_DESCRIPTOR = FieldDescriptor.of("fingerprint");
        public static final FieldDescriptor HARDWARE_DESCRIPTOR = FieldDescriptor.of("hardware");
        public static final AndroidClientInfoEncoder INSTANCE = new AndroidClientInfoEncoder();
        public static final FieldDescriptor LOCALE_DESCRIPTOR = FieldDescriptor.of("locale");
        public static final FieldDescriptor MANUFACTURER_DESCRIPTOR = FieldDescriptor.of("manufacturer");
        public static final FieldDescriptor MCCMNC_DESCRIPTOR = FieldDescriptor.of("mccMnc");
        public static final FieldDescriptor MODEL_DESCRIPTOR = FieldDescriptor.of("model");
        public static final FieldDescriptor OSBUILD_DESCRIPTOR = FieldDescriptor.of("osBuild");
        public static final FieldDescriptor PRODUCT_DESCRIPTOR = FieldDescriptor.of("product");
        public static final FieldDescriptor SDKVERSION_DESCRIPTOR = FieldDescriptor.of("sdkVersion");

        public void encode(Object obj, Object obj2) throws IOException {
            ObjectEncoderContext objectEncoderContext = (ObjectEncoderContext) obj2;
            AutoValue_AndroidClientInfo autoValue_AndroidClientInfo = (AutoValue_AndroidClientInfo) ((AndroidClientInfo) obj);
            objectEncoderContext.add(SDKVERSION_DESCRIPTOR, (Object) autoValue_AndroidClientInfo.sdkVersion);
            objectEncoderContext.add(MODEL_DESCRIPTOR, (Object) autoValue_AndroidClientInfo.model);
            objectEncoderContext.add(HARDWARE_DESCRIPTOR, (Object) autoValue_AndroidClientInfo.hardware);
            objectEncoderContext.add(DEVICE_DESCRIPTOR, (Object) autoValue_AndroidClientInfo.device);
            objectEncoderContext.add(PRODUCT_DESCRIPTOR, (Object) autoValue_AndroidClientInfo.product);
            objectEncoderContext.add(OSBUILD_DESCRIPTOR, (Object) autoValue_AndroidClientInfo.osBuild);
            objectEncoderContext.add(MANUFACTURER_DESCRIPTOR, (Object) autoValue_AndroidClientInfo.manufacturer);
            objectEncoderContext.add(FINGERPRINT_DESCRIPTOR, (Object) autoValue_AndroidClientInfo.fingerprint);
            objectEncoderContext.add(LOCALE_DESCRIPTOR, (Object) autoValue_AndroidClientInfo.locale);
            objectEncoderContext.add(COUNTRY_DESCRIPTOR, (Object) autoValue_AndroidClientInfo.country);
            objectEncoderContext.add(MCCMNC_DESCRIPTOR, (Object) autoValue_AndroidClientInfo.mccMnc);
            objectEncoderContext.add(APPLICATIONBUILD_DESCRIPTOR, (Object) autoValue_AndroidClientInfo.applicationBuild);
        }
    }

    public static final class BatchedLogRequestEncoder implements ObjectEncoder<BatchedLogRequest> {
        public static final BatchedLogRequestEncoder INSTANCE = new BatchedLogRequestEncoder();
        public static final FieldDescriptor LOGREQUEST_DESCRIPTOR = FieldDescriptor.of("logRequest");

        public void encode(Object obj, Object obj2) throws IOException {
            ((ObjectEncoderContext) obj2).add(LOGREQUEST_DESCRIPTOR, (Object) ((AutoValue_BatchedLogRequest) ((BatchedLogRequest) obj)).logRequests);
        }
    }

    public static final class ClientInfoEncoder implements ObjectEncoder<ClientInfo> {
        public static final FieldDescriptor ANDROIDCLIENTINFO_DESCRIPTOR = FieldDescriptor.of("androidClientInfo");
        public static final FieldDescriptor CLIENTTYPE_DESCRIPTOR = FieldDescriptor.of("clientType");
        public static final ClientInfoEncoder INSTANCE = new ClientInfoEncoder();

        public void encode(Object obj, Object obj2) throws IOException {
            ObjectEncoderContext objectEncoderContext = (ObjectEncoderContext) obj2;
            AutoValue_ClientInfo autoValue_ClientInfo = (AutoValue_ClientInfo) ((ClientInfo) obj);
            objectEncoderContext.add(CLIENTTYPE_DESCRIPTOR, (Object) autoValue_ClientInfo.clientType);
            objectEncoderContext.add(ANDROIDCLIENTINFO_DESCRIPTOR, (Object) autoValue_ClientInfo.androidClientInfo);
        }
    }

    public static final class LogEventEncoder implements ObjectEncoder<LogEvent> {
        public static final FieldDescriptor EVENTCODE_DESCRIPTOR = FieldDescriptor.of("eventCode");
        public static final FieldDescriptor EVENTTIMEMS_DESCRIPTOR = FieldDescriptor.of("eventTimeMs");
        public static final FieldDescriptor EVENTUPTIMEMS_DESCRIPTOR = FieldDescriptor.of("eventUptimeMs");
        public static final LogEventEncoder INSTANCE = new LogEventEncoder();
        public static final FieldDescriptor NETWORKCONNECTIONINFO_DESCRIPTOR = FieldDescriptor.of("networkConnectionInfo");
        public static final FieldDescriptor SOURCEEXTENSIONJSONPROTO3_DESCRIPTOR = FieldDescriptor.of("sourceExtensionJsonProto3");
        public static final FieldDescriptor SOURCEEXTENSION_DESCRIPTOR = FieldDescriptor.of("sourceExtension");
        public static final FieldDescriptor TIMEZONEOFFSETSECONDS_DESCRIPTOR = FieldDescriptor.of("timezoneOffsetSeconds");

        public void encode(Object obj, Object obj2) throws IOException {
            ObjectEncoderContext objectEncoderContext = (ObjectEncoderContext) obj2;
            AutoValue_LogEvent autoValue_LogEvent = (AutoValue_LogEvent) ((LogEvent) obj);
            objectEncoderContext.add(EVENTTIMEMS_DESCRIPTOR, autoValue_LogEvent.eventTimeMs);
            objectEncoderContext.add(EVENTCODE_DESCRIPTOR, (Object) autoValue_LogEvent.eventCode);
            objectEncoderContext.add(EVENTUPTIMEMS_DESCRIPTOR, autoValue_LogEvent.eventUptimeMs);
            objectEncoderContext.add(SOURCEEXTENSION_DESCRIPTOR, (Object) autoValue_LogEvent.sourceExtension);
            objectEncoderContext.add(SOURCEEXTENSIONJSONPROTO3_DESCRIPTOR, (Object) autoValue_LogEvent.sourceExtensionJsonProto3);
            objectEncoderContext.add(TIMEZONEOFFSETSECONDS_DESCRIPTOR, autoValue_LogEvent.timezoneOffsetSeconds);
            objectEncoderContext.add(NETWORKCONNECTIONINFO_DESCRIPTOR, (Object) autoValue_LogEvent.networkConnectionInfo);
        }
    }

    public static final class LogRequestEncoder implements ObjectEncoder<LogRequest> {
        public static final FieldDescriptor CLIENTINFO_DESCRIPTOR = FieldDescriptor.of("clientInfo");
        public static final LogRequestEncoder INSTANCE = new LogRequestEncoder();
        public static final FieldDescriptor LOGEVENT_DESCRIPTOR = FieldDescriptor.of("logEvent");
        public static final FieldDescriptor LOGSOURCENAME_DESCRIPTOR = FieldDescriptor.of("logSourceName");
        public static final FieldDescriptor LOGSOURCE_DESCRIPTOR = FieldDescriptor.of("logSource");
        public static final FieldDescriptor QOSTIER_DESCRIPTOR = FieldDescriptor.of("qosTier");
        public static final FieldDescriptor REQUESTTIMEMS_DESCRIPTOR = FieldDescriptor.of("requestTimeMs");
        public static final FieldDescriptor REQUESTUPTIMEMS_DESCRIPTOR = FieldDescriptor.of("requestUptimeMs");

        public void encode(Object obj, Object obj2) throws IOException {
            ObjectEncoderContext objectEncoderContext = (ObjectEncoderContext) obj2;
            AutoValue_LogRequest autoValue_LogRequest = (AutoValue_LogRequest) ((LogRequest) obj);
            objectEncoderContext.add(REQUESTTIMEMS_DESCRIPTOR, autoValue_LogRequest.requestTimeMs);
            objectEncoderContext.add(REQUESTUPTIMEMS_DESCRIPTOR, autoValue_LogRequest.requestUptimeMs);
            objectEncoderContext.add(CLIENTINFO_DESCRIPTOR, (Object) autoValue_LogRequest.clientInfo);
            objectEncoderContext.add(LOGSOURCE_DESCRIPTOR, (Object) autoValue_LogRequest.logSource);
            objectEncoderContext.add(LOGSOURCENAME_DESCRIPTOR, (Object) autoValue_LogRequest.logSourceName);
            objectEncoderContext.add(LOGEVENT_DESCRIPTOR, (Object) autoValue_LogRequest.logEvents);
            objectEncoderContext.add(QOSTIER_DESCRIPTOR, (Object) autoValue_LogRequest.qosTier);
        }
    }

    public static final class NetworkConnectionInfoEncoder implements ObjectEncoder<NetworkConnectionInfo> {
        public static final NetworkConnectionInfoEncoder INSTANCE = new NetworkConnectionInfoEncoder();
        public static final FieldDescriptor MOBILESUBTYPE_DESCRIPTOR = FieldDescriptor.of("mobileSubtype");
        public static final FieldDescriptor NETWORKTYPE_DESCRIPTOR = FieldDescriptor.of("networkType");

        public void encode(Object obj, Object obj2) throws IOException {
            ObjectEncoderContext objectEncoderContext = (ObjectEncoderContext) obj2;
            AutoValue_NetworkConnectionInfo autoValue_NetworkConnectionInfo = (AutoValue_NetworkConnectionInfo) ((NetworkConnectionInfo) obj);
            objectEncoderContext.add(NETWORKTYPE_DESCRIPTOR, (Object) autoValue_NetworkConnectionInfo.networkType);
            objectEncoderContext.add(MOBILESUBTYPE_DESCRIPTOR, (Object) autoValue_NetworkConnectionInfo.mobileSubtype);
        }
    }

    public void configure(EncoderConfig<?> encoderConfig) {
        encoderConfig.registerEncoder(BatchedLogRequest.class, BatchedLogRequestEncoder.INSTANCE);
        encoderConfig.registerEncoder(AutoValue_BatchedLogRequest.class, BatchedLogRequestEncoder.INSTANCE);
        encoderConfig.registerEncoder(LogRequest.class, LogRequestEncoder.INSTANCE);
        encoderConfig.registerEncoder(AutoValue_LogRequest.class, LogRequestEncoder.INSTANCE);
        encoderConfig.registerEncoder(ClientInfo.class, ClientInfoEncoder.INSTANCE);
        encoderConfig.registerEncoder(AutoValue_ClientInfo.class, ClientInfoEncoder.INSTANCE);
        encoderConfig.registerEncoder(AndroidClientInfo.class, AndroidClientInfoEncoder.INSTANCE);
        encoderConfig.registerEncoder(AutoValue_AndroidClientInfo.class, AndroidClientInfoEncoder.INSTANCE);
        encoderConfig.registerEncoder(LogEvent.class, LogEventEncoder.INSTANCE);
        encoderConfig.registerEncoder(AutoValue_LogEvent.class, LogEventEncoder.INSTANCE);
        encoderConfig.registerEncoder(NetworkConnectionInfo.class, NetworkConnectionInfoEncoder.INSTANCE);
        encoderConfig.registerEncoder(AutoValue_NetworkConnectionInfo.class, NetworkConnectionInfoEncoder.INSTANCE);
    }
}
