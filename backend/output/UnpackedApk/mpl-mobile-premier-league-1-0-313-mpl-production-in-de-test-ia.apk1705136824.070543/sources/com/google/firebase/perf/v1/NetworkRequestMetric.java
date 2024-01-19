package com.google.firebase.perf.v1;

import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.GeneratedMessageLite.DefaultInstanceBasedParser;
import com.google.protobuf.GeneratedMessageLite.MethodToInvoke;
import com.google.protobuf.Internal.EnumLite;
import com.google.protobuf.Internal.EnumLiteMap;
import com.google.protobuf.Internal.EnumVerifier;
import com.google.protobuf.Internal.ProtobufList;
import com.google.protobuf.MapEntryLite;
import com.google.protobuf.MapFieldLite;
import com.google.protobuf.Parser;
import com.google.protobuf.ProtobufArrayList;
import com.google.protobuf.RawMessageInfo;
import com.google.protobuf.WireFormat$FieldType;

public final class NetworkRequestMetric extends GeneratedMessageLite<NetworkRequestMetric, Builder> implements Object {
    public static final int CLIENT_START_TIME_US_FIELD_NUMBER = 7;
    public static final int CUSTOM_ATTRIBUTES_FIELD_NUMBER = 12;
    public static final NetworkRequestMetric DEFAULT_INSTANCE;
    public static final int HTTP_METHOD_FIELD_NUMBER = 2;
    public static final int HTTP_RESPONSE_CODE_FIELD_NUMBER = 5;
    public static final int NETWORK_CLIENT_ERROR_REASON_FIELD_NUMBER = 11;
    public static volatile Parser<NetworkRequestMetric> PARSER = null;
    public static final int PERF_SESSIONS_FIELD_NUMBER = 13;
    public static final int REQUEST_PAYLOAD_BYTES_FIELD_NUMBER = 3;
    public static final int RESPONSE_CONTENT_TYPE_FIELD_NUMBER = 6;
    public static final int RESPONSE_PAYLOAD_BYTES_FIELD_NUMBER = 4;
    public static final int TIME_TO_REQUEST_COMPLETED_US_FIELD_NUMBER = 8;
    public static final int TIME_TO_RESPONSE_COMPLETED_US_FIELD_NUMBER = 10;
    public static final int TIME_TO_RESPONSE_INITIATED_US_FIELD_NUMBER = 9;
    public static final int URL_FIELD_NUMBER = 1;
    public int bitField0_;
    public long clientStartTimeUs_;
    public MapFieldLite<String, String> customAttributes_ = MapFieldLite.EMPTY_MAP_FIELD;
    public int httpMethod_;
    public int httpResponseCode_;
    public int networkClientErrorReason_;
    public ProtobufList<PerfSession> perfSessions_ = ProtobufArrayList.EMPTY_LIST;
    public long requestPayloadBytes_;
    public String responseContentType_ = "";
    public long responsePayloadBytes_;
    public long timeToRequestCompletedUs_;
    public long timeToResponseCompletedUs_;
    public long timeToResponseInitiatedUs_;
    public String url_ = "";

    public static final class Builder extends com.google.protobuf.GeneratedMessageLite.Builder<NetworkRequestMetric, Builder> implements Object {
        public Builder() {
            super(NetworkRequestMetric.DEFAULT_INSTANCE);
        }

        public Builder(AnonymousClass1 r1) {
            super(NetworkRequestMetric.DEFAULT_INSTANCE);
        }
    }

    public static final class CustomAttributesDefaultEntryHolder {
        public static final MapEntryLite<String, String> defaultEntry;

        static {
            WireFormat$FieldType wireFormat$FieldType = WireFormat$FieldType.STRING;
            defaultEntry = new MapEntryLite<>(wireFormat$FieldType, "", wireFormat$FieldType, "");
        }
    }

    public enum HttpMethod implements EnumLite {
        HTTP_METHOD_UNKNOWN(0),
        GET(1),
        PUT(2),
        POST(3),
        DELETE(4),
        HEAD(5),
        PATCH(6),
        OPTIONS(7),
        TRACE(8),
        CONNECT(9);
        
        public static final int CONNECT_VALUE = 9;
        public static final int DELETE_VALUE = 4;
        public static final int GET_VALUE = 1;
        public static final int HEAD_VALUE = 5;
        public static final int HTTP_METHOD_UNKNOWN_VALUE = 0;
        public static final int OPTIONS_VALUE = 7;
        public static final int PATCH_VALUE = 6;
        public static final int POST_VALUE = 3;
        public static final int PUT_VALUE = 2;
        public static final int TRACE_VALUE = 8;
        public static final EnumLiteMap<HttpMethod> internalValueMap = null;
        public final int value;

        public static final class HttpMethodVerifier implements EnumVerifier {
            public static final EnumVerifier INSTANCE = null;

            static {
                INSTANCE = new HttpMethodVerifier();
            }

            public boolean isInRange(int i) {
                return HttpMethod.forNumber(i) != null;
            }
        }

        /* access modifiers changed from: public */
        static {
            internalValueMap = new EnumLiteMap<HttpMethod>() {
            };
        }

        /* access modifiers changed from: public */
        HttpMethod(int i) {
            this.value = i;
        }

        public static HttpMethod forNumber(int i) {
            switch (i) {
                case 0:
                    return HTTP_METHOD_UNKNOWN;
                case 1:
                    return GET;
                case 2:
                    return PUT;
                case 3:
                    return POST;
                case 4:
                    return DELETE;
                case 5:
                    return HEAD;
                case 6:
                    return PATCH;
                case 7:
                    return OPTIONS;
                case 8:
                    return TRACE;
                case 9:
                    return CONNECT;
                default:
                    return null;
            }
        }

        public static EnumLiteMap<HttpMethod> internalGetValueMap() {
            return internalValueMap;
        }

        public static EnumVerifier internalGetVerifier() {
            return HttpMethodVerifier.INSTANCE;
        }

        public final int getNumber() {
            return this.value;
        }

        @Deprecated
        public static HttpMethod valueOf(int i) {
            return forNumber(i);
        }
    }

    public enum NetworkClientErrorReason implements EnumLite {
        NETWORK_CLIENT_ERROR_REASON_UNKNOWN(0),
        GENERIC_CLIENT_ERROR(1);
        
        public static final int GENERIC_CLIENT_ERROR_VALUE = 1;
        public static final int NETWORK_CLIENT_ERROR_REASON_UNKNOWN_VALUE = 0;
        public static final EnumLiteMap<NetworkClientErrorReason> internalValueMap = null;
        public final int value;

        public static final class NetworkClientErrorReasonVerifier implements EnumVerifier {
            public static final EnumVerifier INSTANCE = null;

            static {
                INSTANCE = new NetworkClientErrorReasonVerifier();
            }

            public boolean isInRange(int i) {
                return NetworkClientErrorReason.forNumber(i) != null;
            }
        }

        /* access modifiers changed from: public */
        static {
            internalValueMap = new EnumLiteMap<NetworkClientErrorReason>() {
            };
        }

        /* access modifiers changed from: public */
        NetworkClientErrorReason(int i) {
            this.value = i;
        }

        public static NetworkClientErrorReason forNumber(int i) {
            if (i == 0) {
                return NETWORK_CLIENT_ERROR_REASON_UNKNOWN;
            }
            if (i != 1) {
                return null;
            }
            return GENERIC_CLIENT_ERROR;
        }

        public static EnumLiteMap<NetworkClientErrorReason> internalGetValueMap() {
            return internalValueMap;
        }

        public static EnumVerifier internalGetVerifier() {
            return NetworkClientErrorReasonVerifier.INSTANCE;
        }

        public final int getNumber() {
            return this.value;
        }

        @Deprecated
        public static NetworkClientErrorReason valueOf(int i) {
            return forNumber(i);
        }
    }

    static {
        NetworkRequestMetric networkRequestMetric = new NetworkRequestMetric();
        DEFAULT_INSTANCE = networkRequestMetric;
        GeneratedMessageLite.defaultInstanceMap.put(NetworkRequestMetric.class, networkRequestMetric);
    }

    public static void access$100(NetworkRequestMetric networkRequestMetric, String str) {
        if (networkRequestMetric != null) {
            str.getClass();
            networkRequestMetric.bitField0_ |= 1;
            networkRequestMetric.url_ = str;
            return;
        }
        throw null;
    }

    public static void access$1000(NetworkRequestMetric networkRequestMetric, NetworkClientErrorReason networkClientErrorReason) {
        if (networkRequestMetric != null) {
            networkRequestMetric.networkClientErrorReason_ = networkClientErrorReason.getNumber();
            networkRequestMetric.bitField0_ |= 16;
            return;
        }
        throw null;
    }

    public static void access$1400(NetworkRequestMetric networkRequestMetric, String str) {
        if (networkRequestMetric != null) {
            str.getClass();
            networkRequestMetric.bitField0_ |= 64;
            networkRequestMetric.responseContentType_ = str;
            return;
        }
        throw null;
    }

    public static void access$400(NetworkRequestMetric networkRequestMetric, HttpMethod httpMethod) {
        if (networkRequestMetric != null) {
            networkRequestMetric.httpMethod_ = httpMethod.getNumber();
            networkRequestMetric.bitField0_ |= 2;
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
                return new RawMessageInfo(DEFAULT_INSTANCE, "\u0001\r\u0000\u0001\u0001\r\r\u0001\u0001\u0000\u0001ဈ\u0000\u0002ဌ\u0001\u0003ဂ\u0002\u0004ဂ\u0003\u0005င\u0005\u0006ဈ\u0006\u0007ဂ\u0007\bဂ\b\tဂ\t\nဂ\n\u000bဌ\u0004\f2\r\u001b", new Object[]{"bitField0_", "url_", "httpMethod_", HttpMethod.internalGetVerifier(), "requestPayloadBytes_", "responsePayloadBytes_", "httpResponseCode_", "responseContentType_", "clientStartTimeUs_", "timeToRequestCompletedUs_", "timeToResponseInitiatedUs_", "timeToResponseCompletedUs_", "networkClientErrorReason_", NetworkClientErrorReason.internalGetVerifier(), "customAttributes_", CustomAttributesDefaultEntryHolder.defaultEntry, "perfSessions_", PerfSession.class});
            case 3:
                return new NetworkRequestMetric();
            case 4:
                return new Builder(null);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                Parser<NetworkRequestMetric> parser = PARSER;
                if (parser == null) {
                    synchronized (NetworkRequestMetric.class) {
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

    public boolean hasHttpResponseCode() {
        return (this.bitField0_ & 32) != 0;
    }

    public boolean hasTimeToResponseCompletedUs() {
        return (this.bitField0_ & 1024) != 0;
    }
}
