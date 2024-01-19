package com.netcore.android.network.models;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.google.firebase.crashlytics.CrashlyticsAnalyticsListener;
import com.netcore.android.network.SMTEnumHttpMethodType;
import com.netcore.android.network.SMTResponseListener;
import com.netcore.android.utility.SMTCommonUtility;
import com.razorpay.AnalyticsConstants;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u0001:\u0002:;B\u000f\u0012\u0006\u00107\u001a\u000206¢\u0006\u0004\b8\u00109J\u000f\u0010\u0005\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\t\u001a\u00020\u0006H\u0000¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\u000f\u001a\u00020\f2\b\b\u0002\u0010\u000b\u001a\u00020\nH\u0000¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0012\u001a\u00020\nH\u0000¢\u0006\u0004\b\u0010\u0010\u0011J\u0011\u0010\u0016\u001a\u0004\u0018\u00010\u0013H\u0000¢\u0006\u0004\b\u0014\u0010\u0015J\u0011\u0010\u0018\u001a\u0004\u0018\u00010\u0006H\u0000¢\u0006\u0004\b\u0017\u0010\bJ\u0011\u0010\u001c\u001a\u0004\u0018\u00010\u0019H\u0000¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010 \u001a\u00020\u001dH\u0000¢\u0006\u0004\b\u001e\u0010\u001fJ\u0011\u0010$\u001a\u0004\u0018\u00010!H\u0000¢\u0006\u0004\b\"\u0010#R\u0018\u0010%\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010'\u001a\u00020\u001d8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b'\u0010(R\u0018\u0010)\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b)\u0010*R$\u0010,\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010+8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b,\u0010-R\u0016\u0010\u000b\u001a\u00020\n8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010.R\u0018\u0010/\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b/\u00100R\u0016\u00101\u001a\u00020\u00068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b1\u00100R\u0016\u00102\u001a\u00020\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b2\u00103R\u0018\u00104\u001a\u0004\u0018\u00010!8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b4\u00105¨\u0006<"}, d2 = {"Lcom/netcore/android/network/models/SMTRequest;", "", "Lcom/netcore/android/network/models/SMTRequest$SMTApiTypeID;", "getAPITypeID$smartech_release", "()Lcom/netcore/android/network/models/SMTRequest$SMTApiTypeID;", "getAPITypeID", "", "getBaseUrl$smartech_release", "()Ljava/lang/String;", "getBaseUrl", "", "retryCount", "", "setRetryCount$smartech_release", "(I)V", "setRetryCount", "getRetryCount$smartech_release", "()I", "getRetryCount", "Lcom/netcore/android/network/SMTEnumHttpMethodType;", "getHttpMethod$smartech_release", "()Lcom/netcore/android/network/SMTEnumHttpMethodType;", "getHttpMethod", "getApiEndPoint$smartech_release", "getApiEndPoint", "Lorg/json/JSONObject;", "getHParams$smartech_release", "()Lorg/json/JSONObject;", "getHParams", "", "getRequestId$smartech_release", "()J", "getRequestId", "Lcom/netcore/android/network/SMTResponseListener;", "getResponseListener$smartech_release", "()Lcom/netcore/android/network/SMTResponseListener;", "getResponseListener", "httpMethod", "Lcom/netcore/android/network/SMTEnumHttpMethodType;", "requestId", "J", "params", "Lorg/json/JSONObject;", "Ljava/util/HashMap;", "headers", "Ljava/util/HashMap;", "I", "urlEndPoint", "Ljava/lang/String;", "baseUrl", "apiID", "Lcom/netcore/android/network/models/SMTRequest$SMTApiTypeID;", "responseListener", "Lcom/netcore/android/network/SMTResponseListener;", "Lcom/netcore/android/network/models/SMTRequest$Builder;", "builder", "<init>", "(Lcom/netcore/android/network/models/SMTRequest$Builder;)V", "Builder", "SMTApiTypeID", "smartech_release"}, k = 1, mv = {1, 4, 1})
/* compiled from: SMTRequest.kt */
public class SMTRequest {
    public final SMTApiTypeID apiID;
    public final String baseUrl;
    public final HashMap<String, String> headers;
    public final SMTEnumHttpMethodType httpMethod;
    public final JSONObject params;
    public long requestId;
    public final SMTResponseListener responseListener;
    public int retryCount;
    public final String urlEndPoint;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u001c\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\bL\u0010\u0004J\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0004J\u0015\u0010\b\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\f\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\u0015\u0010\u0010\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011J\u0015\u0010\u0012\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0012\u0010\tJ\u0015\u0010\u0015\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0015\u0010\u0016J\u0015\u0010\u0019\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u0017¢\u0006\u0004\b\u0019\u0010\u001aJ\r\u0010\u001c\u001a\u00020\u001b¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010!\u001a\u00020\u001eH\u0000¢\u0006\u0004\b\u001f\u0010 R$\u0010\"\u001a\u0004\u0018\u00010\u00068\u0000@\u0000X\u000e¢\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R$\u0010(\u001a\u0004\u0018\u00010\u00178\u0000@\u0000X\u000e¢\u0006\u0012\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\"\u0010.\u001a\u00020\n8\u0000@\u0000X.¢\u0006\u0012\n\u0004\b.\u0010/\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0014\u00104R$\u00105\u001a\u0004\u0018\u00010\u000e8\u0000@\u0000X\u000e¢\u0006\u0012\n\u0004\b5\u00106\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R$\u0010<\u001a\u0004\u0018\u00010;8\u0000@\u0000X\u000e¢\u0006\u0012\n\u0004\b<\u0010=\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR0\u0010C\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010B8\u0000@\u0000X\u000e¢\u0006\u0012\n\u0004\bC\u0010D\u001a\u0004\bE\u0010F\"\u0004\bG\u0010HR$\u0010I\u001a\u0004\u0018\u00010\u00068\u0000@\u0000X\u000e¢\u0006\u0012\n\u0004\bI\u0010#\u001a\u0004\bJ\u0010%\"\u0004\bK\u0010'¨\u0006M"}, d2 = {"Lcom/netcore/android/network/models/SMTRequest$Builder;", "", "", "createJsonRequestObject", "()V", "createUrlEndPoint", "", "url", "setBaseUrl", "(Ljava/lang/String;)Lcom/netcore/android/network/models/SMTRequest$Builder;", "Lcom/netcore/android/network/models/SMTRequest$SMTApiTypeID;", "apiId", "setApiId", "(Lcom/netcore/android/network/models/SMTRequest$SMTApiTypeID;)Lcom/netcore/android/network/models/SMTRequest$Builder;", "Lcom/netcore/android/network/SMTEnumHttpMethodType;", "method", "setHttpMethod", "(Lcom/netcore/android/network/SMTEnumHttpMethodType;)Lcom/netcore/android/network/models/SMTRequest$Builder;", "setEndPoint", "Lorg/json/JSONArray;", "params", "setParams", "(Lorg/json/JSONArray;)Lcom/netcore/android/network/models/SMTRequest$Builder;", "Lcom/netcore/android/network/SMTResponseListener;", "listener", "setResponseListener", "(Lcom/netcore/android/network/SMTResponseListener;)Lcom/netcore/android/network/models/SMTRequest$Builder;", "Lcom/netcore/android/network/models/SMTRequest;", "build", "()Lcom/netcore/android/network/models/SMTRequest;", "", "createRequestId$smartech_release", "()J", "createRequestId", "urlEndPoint", "Ljava/lang/String;", "getUrlEndPoint$smartech_release", "()Ljava/lang/String;", "setUrlEndPoint$smartech_release", "(Ljava/lang/String;)V", "responseListener", "Lcom/netcore/android/network/SMTResponseListener;", "getResponseListener$smartech_release", "()Lcom/netcore/android/network/SMTResponseListener;", "setResponseListener$smartech_release", "(Lcom/netcore/android/network/SMTResponseListener;)V", "apiID", "Lcom/netcore/android/network/models/SMTRequest$SMTApiTypeID;", "getApiID$smartech_release", "()Lcom/netcore/android/network/models/SMTRequest$SMTApiTypeID;", "setApiID$smartech_release", "(Lcom/netcore/android/network/models/SMTRequest$SMTApiTypeID;)V", "Lorg/json/JSONArray;", "httpMethod", "Lcom/netcore/android/network/SMTEnumHttpMethodType;", "getHttpMethod$smartech_release", "()Lcom/netcore/android/network/SMTEnumHttpMethodType;", "setHttpMethod$smartech_release", "(Lcom/netcore/android/network/SMTEnumHttpMethodType;)V", "Lorg/json/JSONObject;", "jsonRequestObject", "Lorg/json/JSONObject;", "getJsonRequestObject$smartech_release", "()Lorg/json/JSONObject;", "setJsonRequestObject$smartech_release", "(Lorg/json/JSONObject;)V", "Ljava/util/HashMap;", "headers", "Ljava/util/HashMap;", "getHeaders$smartech_release", "()Ljava/util/HashMap;", "setHeaders$smartech_release", "(Ljava/util/HashMap;)V", "baseUrl", "getBaseUrl$smartech_release", "setBaseUrl$smartech_release", "<init>", "smartech_release"}, k = 1, mv = {1, 4, 1})
    /* compiled from: SMTRequest.kt */
    public static final class Builder {
        public SMTApiTypeID apiID;
        public String baseUrl;
        public HashMap<String, String> headers;
        public SMTEnumHttpMethodType httpMethod;
        public JSONObject jsonRequestObject;
        public JSONArray params;
        public SMTResponseListener responseListener;
        public String urlEndPoint;

        private final void createJsonRequestObject() {
            this.jsonRequestObject = new JSONObject();
            JSONArray jSONArray = this.params;
            if (jSONArray == null) {
                return;
            }
            if (jSONArray.length() == 1) {
                this.jsonRequestObject = jSONArray.getJSONObject(0);
                return;
            }
            JSONObject jSONObject = this.jsonRequestObject;
            Intrinsics.checkNotNull(jSONObject);
            jSONObject.put("data", jSONArray);
        }

        private final void createUrlEndPoint() {
            JSONArray jSONArray = this.params;
            if (jSONArray != null) {
                Intrinsics.checkNotNull(jSONArray);
                if (jSONArray.length() > 0) {
                    JSONArray jSONArray2 = this.params;
                    Intrinsics.checkNotNull(jSONArray2);
                    JSONObject jSONObject = jSONArray2.getJSONObject(0);
                    SMTCommonUtility sMTCommonUtility = SMTCommonUtility.INSTANCE;
                    String jSONObject2 = jSONObject.toString();
                    Intrinsics.checkNotNullExpressionValue(jSONObject2, "jsonObject.toString()");
                    HashMap<String, Object> jsonToMap = sMTCommonUtility.jsonToMap(jSONObject2);
                    if (jsonToMap != null) {
                        boolean z = true;
                        for (String next : jsonToMap.keySet()) {
                            Intrinsics.checkNotNullExpressionValue(next, "key");
                            Object value = ArraysKt___ArraysJvmKt.getValue(jsonToMap, next);
                            if (z) {
                                this.urlEndPoint = GeneratedOutlineSupport.outline59(new StringBuilder(), this.urlEndPoint, '?');
                                this.urlEndPoint += next + '=' + value;
                                z = false;
                            } else {
                                this.urlEndPoint = GeneratedOutlineSupport.outline59(new StringBuilder(), this.urlEndPoint, '&');
                                this.urlEndPoint += next + '=' + value;
                            }
                        }
                    }
                }
            }
        }

        public final SMTRequest build() {
            SMTEnumHttpMethodType sMTEnumHttpMethodType = this.httpMethod;
            Integer valueOf = sMTEnumHttpMethodType != null ? Integer.valueOf(sMTEnumHttpMethodType.getValue()) : null;
            int value = SMTEnumHttpMethodType.GET.getValue();
            if (valueOf != null && valueOf.intValue() == value) {
                createUrlEndPoint();
            } else {
                createJsonRequestObject();
            }
            return new SMTRequest(this);
        }

        public final long createRequestId$smartech_release() {
            return System.currentTimeMillis();
        }

        public final SMTApiTypeID getApiID$smartech_release() {
            SMTApiTypeID sMTApiTypeID = this.apiID;
            if (sMTApiTypeID != null) {
                return sMTApiTypeID;
            }
            Intrinsics.throwUninitializedPropertyAccessException("apiID");
            throw null;
        }

        public final String getBaseUrl$smartech_release() {
            return this.baseUrl;
        }

        public final HashMap<String, String> getHeaders$smartech_release() {
            return this.headers;
        }

        public final SMTEnumHttpMethodType getHttpMethod$smartech_release() {
            return this.httpMethod;
        }

        public final JSONObject getJsonRequestObject$smartech_release() {
            return this.jsonRequestObject;
        }

        public final SMTResponseListener getResponseListener$smartech_release() {
            return this.responseListener;
        }

        public final String getUrlEndPoint$smartech_release() {
            return this.urlEndPoint;
        }

        public final void setApiID$smartech_release(SMTApiTypeID sMTApiTypeID) {
            Intrinsics.checkNotNullParameter(sMTApiTypeID, "<set-?>");
            this.apiID = sMTApiTypeID;
        }

        public final Builder setApiId(SMTApiTypeID sMTApiTypeID) {
            Intrinsics.checkNotNullParameter(sMTApiTypeID, "apiId");
            this.apiID = sMTApiTypeID;
            return this;
        }

        public final Builder setBaseUrl(String str) {
            Intrinsics.checkNotNullParameter(str, "url");
            this.baseUrl = str;
            return this;
        }

        public final void setBaseUrl$smartech_release(String str) {
            this.baseUrl = str;
        }

        public final Builder setEndPoint(String str) {
            Intrinsics.checkNotNullParameter(str, "url");
            this.urlEndPoint = str;
            return this;
        }

        public final void setHeaders$smartech_release(HashMap<String, String> hashMap) {
            this.headers = hashMap;
        }

        public final Builder setHttpMethod(SMTEnumHttpMethodType sMTEnumHttpMethodType) {
            Intrinsics.checkNotNullParameter(sMTEnumHttpMethodType, AnalyticsConstants.METHOD);
            this.httpMethod = sMTEnumHttpMethodType;
            return this;
        }

        public final void setHttpMethod$smartech_release(SMTEnumHttpMethodType sMTEnumHttpMethodType) {
            this.httpMethod = sMTEnumHttpMethodType;
        }

        public final void setJsonRequestObject$smartech_release(JSONObject jSONObject) {
            this.jsonRequestObject = jSONObject;
        }

        public final Builder setParams(JSONArray jSONArray) {
            Intrinsics.checkNotNullParameter(jSONArray, CrashlyticsAnalyticsListener.EVENT_PARAMS_KEY);
            this.params = jSONArray;
            return this;
        }

        public final Builder setResponseListener(SMTResponseListener sMTResponseListener) {
            Intrinsics.checkNotNullParameter(sMTResponseListener, "listener");
            this.responseListener = sMTResponseListener;
            return this;
        }

        public final void setResponseListener$smartech_release(SMTResponseListener sMTResponseListener) {
            this.responseListener = sMTResponseListener;
        }

        public final void setUrlEndPoint$smartech_release(String str) {
            this.urlEndPoint = str;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u000e\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0010"}, d2 = {"Lcom/netcore/android/network/models/SMTRequest$SMTApiTypeID;", "", "", "value", "I", "getValue", "()I", "<init>", "(Ljava/lang/String;II)V", "SDK_INITIALIZE", "SDK_INITIALIZE_ON_SESSION_REFRESH", "BATCH_PROCESSING_API", "PUSH_AMPLIFICATION", "INBOX_API", "LIST_SEGMENT", "GEOFENCE_API", "smartech_release"}, k = 1, mv = {1, 4, 1})
    /* compiled from: SMTRequest.kt */
    public enum SMTApiTypeID {
        SDK_INITIALIZE(1),
        SDK_INITIALIZE_ON_SESSION_REFRESH(2),
        BATCH_PROCESSING_API(3),
        PUSH_AMPLIFICATION(4),
        INBOX_API(5),
        LIST_SEGMENT(6),
        GEOFENCE_API(7);
        
        public final int value;

        /* access modifiers changed from: public */
        SMTApiTypeID(int i) {
            this.value = i;
        }

        public final int getValue() {
            return this.value;
        }
    }

    public SMTRequest(Builder builder) {
        Intrinsics.checkNotNullParameter(builder, "builder");
        this.httpMethod = builder.getHttpMethod$smartech_release();
        this.headers = builder.getHeaders$smartech_release();
        this.urlEndPoint = builder.getUrlEndPoint$smartech_release();
        this.params = builder.getJsonRequestObject$smartech_release();
        this.requestId = builder.createRequestId$smartech_release();
        this.responseListener = builder.getResponseListener$smartech_release();
        this.apiID = builder.getApiID$smartech_release();
        this.baseUrl = builder.getBaseUrl$smartech_release() == null ? "" : builder.getBaseUrl$smartech_release();
    }

    public static /* synthetic */ void setRetryCount$smartech_release$default(SMTRequest sMTRequest, int i, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 1) != 0) {
                i = 0;
            }
            sMTRequest.setRetryCount$smartech_release(i);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setRetryCount");
    }

    public final SMTApiTypeID getAPITypeID$smartech_release() {
        return this.apiID;
    }

    public final String getApiEndPoint$smartech_release() {
        return this.urlEndPoint;
    }

    public final String getBaseUrl$smartech_release() {
        return this.baseUrl;
    }

    public final JSONObject getHParams$smartech_release() {
        return this.params;
    }

    public final SMTEnumHttpMethodType getHttpMethod$smartech_release() {
        return this.httpMethod;
    }

    public final long getRequestId$smartech_release() {
        return this.requestId;
    }

    public final SMTResponseListener getResponseListener$smartech_release() {
        return this.responseListener;
    }

    public final int getRetryCount$smartech_release() {
        return this.retryCount;
    }

    public final void setRetryCount$smartech_release(int i) {
        this.retryCount = i;
    }
}
