package com.netcore.android.network;

import androidx.annotation.Keep;
import com.netcore.android.network.SMTHttpRequestClient.NetworkResponse;
import com.netcore.android.network.models.SMTRequest;
import com.netcore.android.network.models.SMTResponse;
import com.netcore.android.network.parser.SMTResponseParser;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00058\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/netcore/android/network/SMTApiService;", "", "Lcom/netcore/android/network/models/SMTResponse;", "makeApiCall", "()Lcom/netcore/android/network/models/SMTResponse;", "Lcom/netcore/android/network/models/SMTRequest;", "apiRequest", "Lcom/netcore/android/network/models/SMTRequest;", "<init>", "(Lcom/netcore/android/network/models/SMTRequest;)V", "smartech_release"}, k = 1, mv = {1, 4, 1})
/* compiled from: SMTApiService.kt */
public final class SMTApiService {
    public SMTRequest apiRequest;

    public SMTApiService(SMTRequest sMTRequest) {
        Intrinsics.checkNotNullParameter(sMTRequest, "apiRequest");
        this.apiRequest = sMTRequest;
    }

    @Keep
    public final SMTResponse makeApiCall() {
        SMTResponse sMTResponse = new SMTResponse();
        NetworkResponse makeNetworkCall$smartech_release = new SMTHttpRequestClient().makeNetworkCall$smartech_release(this.apiRequest);
        if (makeNetworkCall$smartech_release.isSuccess()) {
            SMTResponse parse$smartech_release = new SMTResponseParser().parse$smartech_release(makeNetworkCall$smartech_release, this.apiRequest.getAPITypeID$smartech_release());
            if (parse$smartech_release == null) {
                sMTResponse.setSuccess(false);
            } else {
                sMTResponse = parse$smartech_release;
            }
        } else {
            sMTResponse.setErrorMessage(makeNetworkCall$smartech_release.getErrorMessage());
        }
        sMTResponse.setRequestId(this.apiRequest.getRequestId$smartech_release());
        sMTResponse.setHttpCode(makeNetworkCall$smartech_release.getHttpCode());
        sMTResponse.setSuccess(makeNetworkCall$smartech_release.isSuccess());
        sMTResponse.setShouldRetry(makeNetworkCall$smartech_release.getShouldRetry());
        sMTResponse.setSmtApiTypeID(this.apiRequest.getAPITypeID$smartech_release());
        return sMTResponse;
    }
}
