package com.paynimo.android.payment.b;

import com.paynimo.android.payment.model.request.RequestPayload;
import com.paynimo.android.payment.model.request.i;
import com.paynimo.android.payment.model.request.n;
import com.paynimo.android.payment.model.response.ResponsePayload;
import com.paynimo.android.payment.model.response.c;
import com.paynimo.android.payment.model.response.e;
import com.paynimo.android.payment.model.response.k.r;
import retrofit2.Call;
import retrofit2.http.Body;

public class a extends b {
    public Call<c> getBinCheckData(@Body com.paynimo.android.payment.model.request.c cVar) {
        return getAPIServiceInterface().getBinCheckData(cVar);
    }

    public Call<Void> getEventLoggingData(@Body n nVar) {
        return getAPIServiceInterface().getEventLoggingData(nVar);
    }

    public Call<e> getIFSCPostData(@Body i iVar) {
        return getAPIServiceInterface().getIFSCPostData(iVar);
    }

    public Call<r> getPMIPostData(@Body RequestPayload requestPayload) {
        return getAPIServiceInterface().getPMIPostData(requestPayload);
    }

    public Call<ResponsePayload> getSVAbortPostData(@Body RequestPayload requestPayload) {
        return getAPIServiceInterface().getSVAbortRequestPostData(requestPayload);
    }

    public Call<ResponsePayload> getSVPostData(@Body RequestPayload requestPayload) {
        return getAPIServiceInterface().getSVRequestPostData(requestPayload);
    }

    public Call<ResponsePayload> getTARPostData(@Body RequestPayload requestPayload) {
        return getAPIServiceInterface().getRequestPostData(requestPayload);
    }

    public Call<ResponsePayload> getTPostData(@Body RequestPayload requestPayload) {
        return getAPIServiceInterface().getRequestPostData(requestPayload);
    }

    public Call<ResponsePayload> getTUIPostData(@Body RequestPayload requestPayload) {
        return getAPIServiceInterface().getRequestPostDataUPI(requestPayload);
    }

    public Call<ResponsePayload> getTWDForcefullPostData(@Body RequestPayload requestPayload) {
        return getAPIServiceInterface().getRequestPostDataCards(requestPayload);
    }

    public Call<ResponsePayload> getTWDPostData(@Body RequestPayload requestPayload) {
        return getAPIServiceInterface().getRequestPostDataCards(requestPayload);
    }

    public Call<ResponsePayload> getTWIPostData(@Body RequestPayload requestPayload) {
        return getAPIServiceInterface().getRequestPostData(requestPayload);
    }
}
