package com.netcore.android.network.models;

import com.android.tools.r8.GeneratedOutlineSupport;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001:\u0001\u000eB\u0007¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004R$\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\u000f"}, d2 = {"Lcom/netcore/android/network/models/SMTInAppResponse;", "Lcom/netcore/android/network/models/SMTResponse;", "", "toString", "()Ljava/lang/String;", "Lcom/netcore/android/network/models/SMTInAppResponse$InAppListSegmentData;", "inAppListSegmentData", "Lcom/netcore/android/network/models/SMTInAppResponse$InAppListSegmentData;", "getInAppListSegmentData", "()Lcom/netcore/android/network/models/SMTInAppResponse$InAppListSegmentData;", "setInAppListSegmentData", "(Lcom/netcore/android/network/models/SMTInAppResponse$InAppListSegmentData;)V", "<init>", "()V", "InAppListSegmentData", "smartech_release"}, k = 1, mv = {1, 4, 1})
/* compiled from: SMTInAppResponse.kt */
public final class SMTInAppResponse extends SMTResponse {
    public InAppListSegmentData inAppListSegmentData;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004R\"\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR$\u0010\r\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\u0013\u001a\u00020\u00028\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0004\"\u0004\b\u0016\u0010\u0017¨\u0006\u001a"}, d2 = {"Lcom/netcore/android/network/models/SMTInAppResponse$InAppListSegmentData;", "", "", "toString", "()Ljava/lang/String;", "", "status", "I", "getStatus", "()I", "setStatus", "(I)V", "Lorg/json/JSONObject;", "data", "Lorg/json/JSONObject;", "getData", "()Lorg/json/JSONObject;", "setData", "(Lorg/json/JSONObject;)V", "message", "Ljava/lang/String;", "getMessage", "setMessage", "(Ljava/lang/String;)V", "<init>", "()V", "smartech_release"}, k = 1, mv = {1, 4, 1})
    /* compiled from: SMTInAppResponse.kt */
    public static final class InAppListSegmentData {
        public JSONObject data;
        public String message = "";
        public int status;

        public final JSONObject getData() {
            return this.data;
        }

        public final String getMessage() {
            return this.message;
        }

        public final int getStatus() {
            return this.status;
        }

        public final void setData(JSONObject jSONObject) {
            this.data = jSONObject;
        }

        public final void setMessage(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.message = str;
        }

        public final void setStatus(int i) {
            this.status = i;
        }

        public String toString() {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("data", this.data);
            jSONObject.put("message", this.message);
            jSONObject.put("status", this.status);
            String jSONObject2 = jSONObject.toString();
            Intrinsics.checkNotNullExpressionValue(jSONObject2, "json.toString()");
            return jSONObject2;
        }
    }

    public final InAppListSegmentData getInAppListSegmentData() {
        return this.inAppListSegmentData;
    }

    public final void setInAppListSegmentData(InAppListSegmentData inAppListSegmentData2) {
        this.inAppListSegmentData = inAppListSegmentData2;
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("SMTInApppResponse(pushAmpData=");
        outline73.append(this.inAppListSegmentData);
        outline73.append(')');
        return outline73.toString();
    }
}
