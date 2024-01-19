package com.netcore.android.network.parser;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.netcore.android.logger.SMTLogger;
import com.netcore.android.network.SMTHttpRequestClient.NetworkResponse;
import com.netcore.android.network.models.SMTInAppResponse;
import com.netcore.android.network.models.SMTInAppResponse.InAppListSegmentData;
import com.userexperior.models.recording.enums.UeCustomType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\t\u001a\u00020\b8\u0002@\u0002XD¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\u000b\u001a\u00020\b8\u0002@\u0002XD¢\u0006\u0006\n\u0004\b\u000b\u0010\nR\u001e\u0010\r\u001a\n \f*\u0004\u0018\u00010\b0\b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\nR\u0016\u0010\u000e\u001a\u00020\b8\u0002@\u0002XD¢\u0006\u0006\n\u0004\b\u000e\u0010\n¨\u0006\u0011"}, d2 = {"Lcom/netcore/android/network/parser/SMTInAppParser;", "", "Lcom/netcore/android/network/SMTHttpRequestClient$NetworkResponse;", "networkResponse", "Lcom/netcore/android/network/models/SMTInAppResponse;", "parse$smartech_release", "(Lcom/netcore/android/network/SMTHttpRequestClient$NetworkResponse;)Lcom/netcore/android/network/models/SMTInAppResponse;", "parse", "", "KEY_INAPP_STATUS", "Ljava/lang/String;", "KEY_INAPP_MESSAGE", "kotlin.jvm.PlatformType", "TAG", "KEY_INAPP_DATA", "<init>", "()V", "smartech_release"}, k = 1, mv = {1, 4, 1})
/* compiled from: SMTInAppParser.kt */
public final class SMTInAppParser {
    public final String KEY_INAPP_DATA = "data";
    public final String KEY_INAPP_MESSAGE = "message";
    public final String KEY_INAPP_STATUS = "status";
    public final String TAG = SMTInAppParser.class.getSimpleName();

    public final SMTInAppResponse parse$smartech_release(NetworkResponse networkResponse) {
        Intrinsics.checkNotNullParameter(networkResponse, "networkResponse");
        SMTInAppResponse sMTInAppResponse = new SMTInAppResponse();
        if (networkResponse.getResponse() == null) {
            SMTLogger.INSTANCE.v("SMTInAppParser", "InApp list seg response is null");
            return sMTInAppResponse;
        }
        sMTInAppResponse.setSmtApiTypeID(networkResponse.getApiID());
        try {
            JSONObject jSONObject = new JSONObject(networkResponse.getResponse());
            SMTLogger.INSTANCE.v("InApp : list and segment", String.valueOf(jSONObject));
            sMTInAppResponse.setInAppListSegmentData(new InAppListSegmentData());
            InAppListSegmentData inAppListSegmentData = sMTInAppResponse.getInAppListSegmentData();
            if (inAppListSegmentData != null) {
                inAppListSegmentData.setData(jSONObject.optJSONObject(this.KEY_INAPP_DATA));
            }
            InAppListSegmentData inAppListSegmentData2 = sMTInAppResponse.getInAppListSegmentData();
            if (inAppListSegmentData2 != null) {
                String optString = jSONObject.optString(this.KEY_INAPP_MESSAGE);
                Intrinsics.checkNotNullExpressionValue(optString, "inAppData.optString(KEY_INAPP_MESSAGE)");
                inAppListSegmentData2.setMessage(optString);
            }
            InAppListSegmentData inAppListSegmentData3 = sMTInAppResponse.getInAppListSegmentData();
            if (inAppListSegmentData3 != null) {
                inAppListSegmentData3.setStatus(jSONObject.optInt(this.KEY_INAPP_STATUS, 0));
            }
        } catch (Exception e2) {
            SMTLogger sMTLogger = SMTLogger.INSTANCE;
            String str = this.TAG;
            GeneratedOutlineSupport.outline96(str, UeCustomType.TAG, e2, sMTLogger, str);
        }
        return sMTInAppResponse;
    }
}
