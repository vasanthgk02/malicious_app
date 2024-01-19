package com.netcore.android.network.parser;

import com.netcore.android.network.SMTHttpRequestClient.NetworkResponse;
import com.netcore.android.network.models.SMTGeoFenceResponse;
import com.netcore.android.network.models.SMTInAppResponse;
import com.netcore.android.network.models.SMTRequest.SMTApiTypeID;
import com.netcore.android.network.models.SMTResponse;
import com.netcore.android.network.models.SMTSdkInitializeResponse;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0016\u0010\u0017J\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\n\u0010\u0006J\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u000f\u0010\u0010J!\u0010\u0015\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0011H\u0000¢\u0006\u0004\b\u0013\u0010\u0014¨\u0006\u0018"}, d2 = {"Lcom/netcore/android/network/parser/SMTResponseParser;", "", "Lcom/netcore/android/network/SMTHttpRequestClient$NetworkResponse;", "networkResponse", "Lcom/netcore/android/network/models/SMTResponse;", "parseBaseResponse", "(Lcom/netcore/android/network/SMTHttpRequestClient$NetworkResponse;)Lcom/netcore/android/network/models/SMTResponse;", "Lcom/netcore/android/network/models/SMTSdkInitializeResponse;", "parseSdkInitializeResponse", "(Lcom/netcore/android/network/SMTHttpRequestClient$NetworkResponse;)Lcom/netcore/android/network/models/SMTSdkInitializeResponse;", "parsePushAmpResponse", "Lcom/netcore/android/network/models/SMTInAppResponse;", "parseInAppListSegmentResponse", "(Lcom/netcore/android/network/SMTHttpRequestClient$NetworkResponse;)Lcom/netcore/android/network/models/SMTInAppResponse;", "Lcom/netcore/android/network/models/SMTGeoFenceResponse;", "parseGeoFenceListResponse", "(Lcom/netcore/android/network/SMTHttpRequestClient$NetworkResponse;)Lcom/netcore/android/network/models/SMTGeoFenceResponse;", "Lcom/netcore/android/network/models/SMTRequest$SMTApiTypeID;", "apiTypeId", "parse$smartech_release", "(Lcom/netcore/android/network/SMTHttpRequestClient$NetworkResponse;Lcom/netcore/android/network/models/SMTRequest$SMTApiTypeID;)Lcom/netcore/android/network/models/SMTResponse;", "parse", "<init>", "()V", "smartech_release"}, k = 1, mv = {1, 4, 1})
/* compiled from: SMTResponseParser.kt */
public final class SMTResponseParser {
    private final SMTResponse parseBaseResponse(NetworkResponse networkResponse) {
        SMTResponse sMTResponse = new SMTResponse();
        sMTResponse.setSmtApiTypeID(networkResponse.getApiID());
        sMTResponse.setResponse(networkResponse.getResponse());
        return sMTResponse;
    }

    private final SMTGeoFenceResponse parseGeoFenceListResponse(NetworkResponse networkResponse) {
        return new SMTGeoFenceParser().parse$smartech_release(networkResponse);
    }

    private final SMTInAppResponse parseInAppListSegmentResponse(NetworkResponse networkResponse) {
        return new SMTInAppParser().parse$smartech_release(networkResponse);
    }

    private final SMTResponse parsePushAmpResponse(NetworkResponse networkResponse) {
        SMTResponse sMTResponse = new SMTResponse();
        sMTResponse.setResponse(networkResponse.getResponse());
        return sMTResponse;
    }

    private final SMTSdkInitializeResponse parseSdkInitializeResponse(NetworkResponse networkResponse) {
        return new SMTSdkInitParser().parse$smartech_release(networkResponse);
    }

    public final SMTResponse parse$smartech_release(NetworkResponse networkResponse, SMTApiTypeID sMTApiTypeID) {
        SMTSdkInitializeResponse sMTSdkInitializeResponse;
        Intrinsics.checkNotNullParameter(networkResponse, "networkResponse");
        Intrinsics.checkNotNullParameter(sMTApiTypeID, "apiTypeId");
        int value = sMTApiTypeID.getValue();
        if (value == SMTApiTypeID.SDK_INITIALIZE.getValue()) {
            sMTSdkInitializeResponse = parseSdkInitializeResponse(networkResponse);
        } else if (value == SMTApiTypeID.SDK_INITIALIZE_ON_SESSION_REFRESH.getValue()) {
            sMTSdkInitializeResponse = parseSdkInitializeResponse(networkResponse);
        } else if (value == SMTApiTypeID.INBOX_API.getValue()) {
            return parseBaseResponse(networkResponse);
        } else {
            if (value == SMTApiTypeID.PUSH_AMPLIFICATION.getValue()) {
                return parsePushAmpResponse(networkResponse);
            }
            if (value == SMTApiTypeID.LIST_SEGMENT.getValue()) {
                return parseInAppListSegmentResponse(networkResponse);
            }
            if (value == SMTApiTypeID.GEOFENCE_API.getValue()) {
                return parseGeoFenceListResponse(networkResponse);
            }
            sMTSdkInitializeResponse = null;
        }
        return sMTSdkInitializeResponse;
    }
}
